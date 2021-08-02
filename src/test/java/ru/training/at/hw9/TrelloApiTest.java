package ru.training.at.hw9;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.training.at.hw9.core.TrelloService.getTheOnlyAnswer;
import static ru.training.at.hw9.params.Endpoints.BOARDS;
import static ru.training.at.hw9.params.Endpoints.CARDS;
import static ru.training.at.hw9.params.Endpoints.LISTS;
import static ru.training.at.hw9.params.TrelloBoardPrefs.BACKGROUND;
import static ru.training.at.hw9.params.TrelloBoardPrefs.COMMENTS;
import static ru.training.at.hw9.params.TrelloBoardPrefs.PERMISSION_LEVEL;
import static ru.training.at.hw9.params.TrelloBoardPrefs.VOTING;

import io.restassured.http.Method;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.training.at.hw9.dataprovider.TrelloDataProvider;
import ru.training.at.hw9.response.TrelloResponse;

public class TrelloApiTest extends BaseTest {

    @Test()
    public void createTheBoard(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.POST)
                      .setName(MainProperty.BOARD_NAME)
                      .buildRequest()
                      .sendRequest()
        );
        context.setAttribute(MainProperty.BOARDS_ID, answer.getId());

        assertThat("The board was created: ", answer.getName().equals(MainProperty.BOARD_NAME));
    }

    @Test(dependsOnMethods = {"createTheBoard"})
    public void checkTheBoardExist(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.GET)
                      .buildRequest()
                      .sendRequest((String) context.getAttribute(MainProperty.BOARDS_ID))
        );

        assertThat("The board exist: ", answer.getId().equals(context.getAttribute(MainProperty.BOARDS_ID)));
    }

    @Test(dependsOnMethods = {"createTheBoard"})
    public void changeTheBoardName(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.PUT)
                      .setName(MainProperty.NEW_BOARD_NAME)
                      .buildRequest()
                      .sendRequest((String) context.getAttribute(MainProperty.BOARDS_ID))
        );
        assertThat("Name of board equal expected new name: ", answer.getName().equals(MainProperty.NEW_BOARD_NAME));
    }

    @Test(dependsOnMethods = {"createTheBoard"})
    public void changeTheBoardColor(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.PUT)
                      .changePrefs(BACKGROUND, "orange")
                      .buildRequest()
                      .sendRequest((String) context.getAttribute(MainProperty.BOARDS_ID))
        );
        assertThat("Board color is changed: ", answer.getPrefs().getBackground().equals("orange"));
    }

    @Test(dependsOnMethods = {"createTheBoard"},
          dataProvider = "changeTheBoardPermissionLevelAndDisableCommentsProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void changeTheBoardPermissionLevelAndDisableComments(ITestContext context, String permissionLevel,
                                                                String comments) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.PUT)
                      .changePrefs(PERMISSION_LEVEL, permissionLevel)
                      .changePrefs(COMMENTS, comments)
                      .buildRequest()
                      .sendRequest((String) context.getAttribute(MainProperty.BOARDS_ID))
        );
        assertThat("Permission level is changed: ", answer.getPrefs().getPermissionLevel().equals(permissionLevel));
        assertThat("Comments is disabled: ", answer.getPrefs().getComments().equals(comments));
    }

    @Test(dependsOnMethods = {"createTheBoard"})
    public void createTheList(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(LISTS)
                      .setMethod(Method.POST)
                      .setIdBoard((String) context.getAttribute(MainProperty.BOARDS_ID))
                      .setName(MainProperty.LIST_NAME)
                      .buildRequest()
                      .sendRequest()
        );
        context.setAttribute(MainProperty.LISTS_ID, answer.getId());

        assertThat("The list was created: ", answer.getName().equals(MainProperty.LIST_NAME));
    }

    @Test(dependsOnMethods = {"createTheList"})
    public void createTheCard(ITestContext context) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(CARDS)
                      .setMethod(Method.POST)
                      .setIdList((String) context.getAttribute(MainProperty.LISTS_ID))
                      .setName(MainProperty.CARD_NAME)
                      .buildRequest()
                      .sendRequest()
        );
        context.setAttribute(MainProperty.CARDS_ID, answer.getId());

        assertThat("The card was created: ", answer.getName().equals(MainProperty.CARD_NAME));
    }

    @Test(dataProvider = "createTheBoardWithCustomPrefsProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void createTheBoardWithCustomPrefs(ITestContext context, String boardName, String votingPermission,
                                              String commentsPermission, String background) {
        TrelloResponse answer = getTheOnlyAnswer(
            apiBuilder.authorization().setEndpoint(BOARDS)
                      .setMethod(Method.POST)
                      .setName(boardName)
                      .setPrefs(COMMENTS, commentsPermission).setPrefs(VOTING, votingPermission)
                      .setPrefs(BACKGROUND, background)
                      .buildRequest()
                      .sendRequest()
        );
        context.setAttribute(MainProperty.CUSTOM_BOARDS_ID, answer.getId());

        assertThat("The custom board was created: ", answer.getName().equals(boardName));
        assertThat("Voting permission is \"observers\": ",
            answer.getPrefs().getVoting().equals(votingPermission));
        assertThat("Comments permission is \"observers\": ",
            answer.getPrefs().getComments().equals(commentsPermission));
        assertThat("Background color is \"sky\": ",
            answer.getPrefs().getBackground().equals(background));
    }

    @Test(dependsOnMethods = {"createTheBoardWithCustomPrefs"})
    public void deleteTheBoardWithCustomPrefs(ITestContext context) {
        apiBuilder.authorization().setEndpoint(BOARDS)
                  .setMethod(Method.DELETE)
                  .buildRequest()
                  .sendRequest((String) context.getAttribute(MainProperty.CUSTOM_BOARDS_ID));
    }
}
