# Spring Boot WebSocket Real Time Chat Application

This is a simple Demonstration of Spring Boot Websockets as a Real Time Chat example.
To get it running just download the directory and run the Spring Boot Applications. Afterwards the Application is available in any browser with the URL: `localhost:8080`.

All it does is it listens to WebSockets, routes the messages to the other clients, registers or disconnects clients depending on their browser actions.
The websocket actions will be handled via JavaScript on the frontend and asynchronously sent to the Spring WebSockets.