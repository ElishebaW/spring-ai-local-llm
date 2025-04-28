package com.ai.SpringAIDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class ChatServiceTest {
    private OllamaChatModel chatModel;
    private ChatService chatService;

    @BeforeEach
    void setUp() {
        chatModel = mock(OllamaChatModel.class);
        chatService = new ChatService(chatModel);
    }

    @Test
    void testGetResponse() {
        String prompt = "Hello AI!";
        AssistantMessage output = new AssistantMessage("Hello, human!");
        Generation result = new Generation(output);
        ChatResponse response = new ChatResponse(List.of(result));
        when(chatModel.call(any(Prompt.class))).thenReturn(response);

        String reply = chatService.getResponse(prompt);
        assertEquals("Hello, human!", reply);
    }
}
