package ru.training.at.hw9.core;

import static org.hamcrest.Matchers.lessThan;
import static ru.training.at.hw9.params.TrelloElementParam.EL_NAME;
import static ru.training.at.hw9.params.TrelloElementParam.ID_BOARD;
import static ru.training.at.hw9.params.TrelloElementParam.ID_LIST;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.hc.core5.http.HttpStatus;
import ru.training.at.hw9.MainProperty;
import ru.training.at.hw9.params.Endpoints;
import ru.training.at.hw9.params.TrelloBoardPrefs;
import ru.training.at.hw9.response.TrelloResponse;

public class TrelloService extends MainProperty {

    private Method requestMethod;
    private static URI REQ_URI;

    private Map<String, String> parameters;

    private TrelloService(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public TrelloService() {
    }

    protected void setREQ_URI(URI uri) {
        REQ_URI = uri;
    }

    public static class ApiBuilder {

        private Map<String, String> parameters = new LinkedHashMap<>();

        private Method requestMethod = Method.GET;

        public ApiBuilder authorization() {
            parameters.put("key", KEY);
            parameters.put("token", TOKEN);
            return this;
        }

        public ApiBuilder setEndpoint(Endpoints endpoint) {
            new TrelloService().setREQ_URI(URI.create(BASE_URL + endpoint.toString()));
            return this;
        }

        public ApiBuilder setIdBoard(String idBoard) {
            parameters.put(ID_BOARD.toString(), idBoard);
            return this;
        }

        public ApiBuilder setIdList(String idList) {
            parameters.put(ID_LIST.toString(), idList);
            return this;
        }

        public ApiBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiBuilder setName(String name) {
            parameters.put(EL_NAME.toString(), name);
            return this;
        }

        public ApiBuilder setPrefs(TrelloBoardPrefs prefsEl, String value) {
            String path = "prefs_" + prefsEl.toString();
            parameters.put(path, value);
            return this;
        }

        public ApiBuilder changePrefs(TrelloBoardPrefs prefsEl, String value) {
            String path = "prefs/" + prefsEl.toString();
            parameters.put(path, value);
            return this;
        }

        public TrelloService buildRequest() {
            return new TrelloService(parameters, requestMethod);
        }
    }

    public static TrelloResponse getTheOnlyAnswer(Response response) {
        return new Gson()
            .fromJson(response.asString(), TrelloResponse.class);
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, REQ_URI)
            .prettyPeek();
    }

    public Response sendRequest(String id) {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, URI.create(REQ_URI + id))
            .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        long requestNumber = (long) (Math.random() * 1_000_000);
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .addQueryParam("requestNumber", requestNumber)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }
}
