package com.ai.SpringAIDemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GenAIController {
    private ChatService chatService;
    private RecipeService recipeService;

    public GenAIController(ChatService chatService, RecipeService recipeService) {
        this.chatService = chatService;
        this.recipeService = recipeService;
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

    /**
     * This method is used to get the response from the chat model for recipe creation.
     * @param prompt The prompt to be sent to the chat model.
     * @return The response from the chat model.
     */
    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients, @RequestParam(defaultValue = "any") String cuisine, @RequestParam(defaultValue = " ") String dietaryRestrictions) {
      return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }

}
