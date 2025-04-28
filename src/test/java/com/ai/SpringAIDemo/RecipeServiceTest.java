package com.ai.SpringAIDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {
    private OllamaChatModel chatModel;
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        chatModel = mock(OllamaChatModel.class);
        recipeService = new RecipeService(chatModel);
    }

    @Test
    void testCreateRecipe() {
        String ingredients = "chicken, rice";
        String cuisine = "Asian";
        String dietaryRestrictions = "gluten-free";
        AssistantMessage output = new AssistantMessage("Delicious Chicken Fried Rice Recipe");
        Generation result = new Generation(output);
        ChatResponse response = new ChatResponse(List.of(result));
        when(chatModel.call(any(Prompt.class))).thenReturn(response);

        String recipe = recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
        assertTrue(recipe.contains("Delicious Chicken Fried Rice Recipe"));
    }
}
