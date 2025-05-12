package com.example.partycardgame;

public class GameCard {
    private final String text;
    private final String severity;
    private final String type;

    public GameCard(String text, String severity, String type) {
        this.text = text;
        this.severity = severity;
        this.type = type;
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
}
