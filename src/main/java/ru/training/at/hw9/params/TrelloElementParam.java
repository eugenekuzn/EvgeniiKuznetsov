package ru.training.at.hw9.params;

public enum TrelloElementParam {
    EL_NAME("name"),
    ID_LIST("idList"),
    ID_BOARD("idBoard");
    private final String value;

    TrelloElementParam(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
