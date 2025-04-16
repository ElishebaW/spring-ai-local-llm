package com.ai.SpringAIDemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GenAIController {
    private ChatService chatService;

    public GenAIController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * This method is used to get the response from the chat model.
     * @param prompt The prompt to be sent to the chat model.
     * @return The response from the chat model.
     */
    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt) {
      return chatService.getResponse(prompt);
    }
    
    /**
     * This method is used to get the response from the chat model with options.
     * @param prompt The prompt to be sent to the chat model.
     * @return The response from the chat model.
     */
    
    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt) {
      return chatService.getResponse(prompt);
    }

}
