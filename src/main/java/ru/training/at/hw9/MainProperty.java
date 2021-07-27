package ru.training.at.hw9;

import ru.training.at.hw9.core.TrelloService.ApiBuilder;

public abstract class MainProperty {

    public static final String BASE_URL = "https://trello.com";

    public static final String KEY = "762eaf336054345b702cb4e5c03eb2ab";
    public static final String TOKEN = "0d4324aa2a6fd41393b743b15e974a1d7c60d9e38224ae9f84bd34b7d0f4ee09";

    public static String BOARDS_ID = "boards id";
    public static String CUSTOM_BOARDS_ID = "custom boards id";
    public static String CARDS_ID = "cards id";
    public static String LISTS_ID = "lists id";

    public static String BOARD_NAME = "Test Board";
    public static String NEW_BOARD_NAME = "New Name Of Test Board";
    public static String LIST_NAME = "New List";
    public static String CARD_NAME = "New Card";

    ApiBuilder apiBuilder = new ApiBuilder();
}
