package com.example.re_cipe;

public class Card {
    private String text = "Text";
    private String image;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }
}
