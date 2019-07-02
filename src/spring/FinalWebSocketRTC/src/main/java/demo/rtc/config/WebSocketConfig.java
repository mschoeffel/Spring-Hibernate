package demo.rtc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registers a websocket the clients will use to connect.
     * STOMP: Simple Text Oriented Messaging Protocol to define our functionalities.
     * @param registry StompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //withSockJS as fallback for browsers that don't support websockets.
        registry.addEndpoint("/ws").withSockJS();
    }

    /**
     * Configures message broker that routes messages from one client to another.
     * @param registry MessageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //Defines that messages whose destination starts with "/app" should be routed to message handling methods.
        registry.setApplicationDestinationPrefixes("/app");
        //Defines that the messages whose destination starts with "/topic" should be routed to the message broker.
        //Message broker boradcasts messages to all the connected clients who are subscribed to a particular topic.
        registry.enableSimpleBroker("/topic");
    }
}
