package com.ai.SpringAIDemo;

import java.util.Map;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final OllamaChatModel chatModel;

    public RecipeService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
        // Create a prompt for the chat model
        PromptTemplate promptTemplate = new PromptTemplate( "I want to create a recipe using the following ingredients: {ingredients}. " +
        "The cuisine type I prefer is {cuisine}. Please consider the following dietary restrictions {dietaryRestrictions}." +
        "Please provide me a detailed recipe including the title, list of ingredients, and cooking instructions.");

        Map<String, Object> params = Map.of(
            "ingredients", ingredients,
            "cuisine", cuisine,
            "dietaryRestrictions", dietaryRestrictions
        );

        // Call the chat model with the prompt
        return chatModel.call(promptTemplate.create(params)).getResult().getOutput().getText();
    }
}
