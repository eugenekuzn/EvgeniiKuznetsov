package ru.training.at.hw9.dataprovider;

import org.testng.annotations.DataProvider;

public class TrelloDataProvider {

    @DataProvider(name = "createTheBoardWithCustomPrefsProvider")
    public Object[][] createTheBoardWithCustomPrefsProvider() {
        return new Object[][] {{"Custom Pref Board", "observers", "observers", "sky"}};
    }

    @DataProvider(name = "changeTheBoardPermissionLevelAndDisableCommentsProvider")
    public Object[][] changeTheBoardPermissionLevelAndDisableCommentsProvider() {
        return new Object[][] {{"private", "disabled"}};
    }
}
