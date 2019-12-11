package com.example.re_cipe;

public class RecipeDTO {

    public RecipeDTO(String name, String ingredients, String description, String imageUrl) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    private String name;
    private String ingredients;
    private String description;
    private String imageUrl;

}