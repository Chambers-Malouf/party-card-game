package com.example.partycardgame;

public class CardResponse {
    private String text;
    private String severity;
    private String type;
    private String imageFile;

    public CardResponse(GameCard card) {
        this.text = card.getText();
        this.severity = card.getSeverity();
        this.type = card.getType();
        this.imageFile = card.getImageFile();
    }

    public String getText() {
        return text;
    }

    public String getSeverity() {
        return severity;
    }

    public String getType() {
        return type;
    }

    public String getImageFile() {
        return imageFile;
    }
}