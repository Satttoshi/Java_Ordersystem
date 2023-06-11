package org.module;

public enum Status {
    PENDING("Order is pending"),
    COMPLETED("Order is completed");

    private String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
