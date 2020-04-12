package com.example.faizal.controler

import com.example.faizal.data.Greeting
import com.example.faizal.data.HelloMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo


class WebSocketController {
    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    fun greeting(message: HelloMessage): Greeting {
        print(message.name)
        return Greeting("Hello, ${message.name}")
    }
}