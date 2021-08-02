package ru.training.at.hw9;

public abstract class MainProperty {
    public static final String BASE_URL = "https://trello.com";

    public static final String KEY = ApiPropertyHandler.secureProperties().getProperty("key");
    public static final String TOKEN = ApiPropertyHandler.secureProperties().getProperty("token");

    public static String BOARDS_ID = "boards id";
    public static String CUSTOM_BOARDS_ID = "custom boards id";
    public static String CARDS_ID = "cards id";
    public static String LISTS_ID = "lists id";

    public static String BOARD_NAME = "Test Board";
    public static String NEW_BOARD_NAME = "New Name Of Test Board";
    public static String LIST_NAME = "New List";
    public static String CARD_NAME = "New Card";


}

