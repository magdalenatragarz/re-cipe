package com.example.re_cipe;

public class Card {
    private String text = "Text";
    private String image;
    private String description;
    private String ingredients;

    public Card(RecipeDTO recipe) {
        this.text = recipe.getName();
        this.image = recipe.getImageUrl();
        this.description = recipe.getDescription();
        this.ingredients = recipe.getIngredients();
    }

    public Card(String text, String image){
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
