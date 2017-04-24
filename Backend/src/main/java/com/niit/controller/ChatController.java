package com.niit.controller;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.Message;
import com.niit.model.OutputMessage;



@RestController
public class ChatController {
	
	
		
		@RequestMapping("/chat/info")
		@MessageMapping("/chat")
		@SendTo("/topic/message")
		public OutputMessage sendMessage(Message message) {
		    return new OutputMessage(message, new Date());
		}
	}


