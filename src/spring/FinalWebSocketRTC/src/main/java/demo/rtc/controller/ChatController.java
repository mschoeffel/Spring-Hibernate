package demo.rtc.controller;

import demo.rtc.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * All messages form clients with destination starting with "/app" will be routed to these message handling methods with @MessageMapping.
 */
@Controller
public class ChatController {

    /**
     * Messages with destination "/app/chat.sendMessage" will be routed here.
     * @param chatMessage Chat message
     * @return Chat message
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;
    }

    /**
     * Messages with destination "/app/chat.addUser" will be routed here.
     * @param chatMessage Chat message
     * @param headerAccessor Header
     * @return Chat message
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor){
        //Add username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
