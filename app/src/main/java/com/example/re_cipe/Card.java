package com.example.re_cipe;

public class Card {
    private String text = "Text";
    private String image;
    private String ingredients;
    private String description;

    public Card(RecipeDTO recipe){
        this.text = recipe.getName();
        this.image = recipe.getImageUrl();
        this.ingredients = recipe.getIngredients();
        this.description = recipe.getDescription();
    }

    public Card(String text, String image, String ingredients, String description){
        this.text = text;
        this.image = image;
        this.ingredients = ingredients;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
