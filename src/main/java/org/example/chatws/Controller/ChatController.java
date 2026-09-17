package org.example.chatws.Controller;

import org.example.chatws.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage") //mapeo de la ruta para recibir mensajes de websocket
    @SendTo("/topic/public") //ruta a la que se enviarán los mensajes recibidos
    //Metodo de controlador que recibe un mensaje de tipo ChatMessage y lo devuelve al cliente
    public ChatMessage enviarMensaje(ChatMessage mensaje) {
       
        // Aquí puedes agregar lógica adicional si es necesario
        System.out.println("Mensaje recibido en servidor " + mensaje);
        return mensaje;
    }
    @MessageMapping("/chat.addUser") //mapeo de la ruta para agregar un usuario
    @SendTo("/topic/public") //ruta a la que se enviarán los mensajes recibidos
    public ChatMessage agregarUsuario(ChatMessage mensaje) {
        // Aquí puedes agregar lógica adicional si es necesario
        System.out.println("Usuario agregado en servidor " + mensaje);
        return mensaje;
    }
    
}
