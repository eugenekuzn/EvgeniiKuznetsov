package ru.training.at.hw9;

import static ru.training.at.hw9.params.Endpoints.BOARDS;

import io.restassured.http.Method;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import ru.training.at.hw9.core.TrelloService.ApiBuilder;

public class BaseTest {
    ApiBuilder apiBuilder = new ApiBuilder();

    @AfterTest
    public void cleanTestEnvironment(ITestContext context) {
        apiBuilder.authorization().setEndpoint(BOARDS)
                  .setMethod(Method.DELETE)
                  .buildRequest()
                  .sendRequest((String) context.getAttribute(MainProperty.BOARDS_ID));
    }
}

