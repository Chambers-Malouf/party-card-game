package com.example.partycardgame;

public class GameCard {
    private final String text;
    private final String severity;
    private final String category;
    private final String type;

    public GameCard(String text, String severity, String category) {
        this(text, severity, category, "standard"); // default type
    }

    public GameCard(String text, String severity, String category, String type) {
        this.text = text;
        this.severity = severity;
        this.category = category;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getSeverity() {
        return severity;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }
}
