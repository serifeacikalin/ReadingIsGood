package com.readingisgood.model;

public enum TokenType {
    ACTIVATION("activation"),
    RESET_PASSWORD("reset-password"),
    AUTHENTICATION("authentication");

    private String type;

    TokenType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
