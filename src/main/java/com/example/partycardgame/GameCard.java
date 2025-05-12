package com.example.partycardgame;

public class GameCard {
    private final String text;
    private final String severity;
    private final String type;
    private final String imageFile;

    public GameCard(String text, String severity, String type, String imageFile) {
        this.text = text;
        this.severity = severity;
        this.type = type;
        this.imageFile = imageFile;
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