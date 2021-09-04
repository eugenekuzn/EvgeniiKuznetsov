package ru.training.at.hw9.params;

public enum TrelloBoardPrefs {
    BACKGROUND("background"),
    PERMISSION_LEVEL("permissionLevel"),
    COMMENTS("comments"),
    VOTING("voting");

    private final String value;

    TrelloBoardPrefs(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
