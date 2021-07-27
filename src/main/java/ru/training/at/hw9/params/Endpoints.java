package ru.training.at.hw9.params;

public enum Endpoints {
    BOARDS("/1/boards/"),
    CARDS("/1/cards/"),
    LISTS("/1/lists/");

    private final String value;

    Endpoints(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
