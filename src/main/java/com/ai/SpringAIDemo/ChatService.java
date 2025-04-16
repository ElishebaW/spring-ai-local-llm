package com.ai.SpringAIDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    
    private final OllamaChatModel chatModel;

    public ChatService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {
        // Create a prompt for the chat model
        Prompt ollamaPrompt = new Prompt(prompt);


        // Return the response text
        return chatModel.call(ollamaPrompt).getResult().getOutput().getText();
    }

    public String getResponseOptions(String prompt) {
        // Create a prompt for the chat model
        Prompt ollamaPrompt = new Prompt(
            prompt,
            OllamaOptions.builder()
                .model(OllamaModel.LLAMA3_2)
                .temperature(0.4)
                .build()
        );

        // Return the response text
        return chatModel.call(ollamaPrompt).getResult().getOutput().getText();
    }
    
}
