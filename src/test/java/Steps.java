import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Steps {

    public Steps() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    public Response getRequest() {
        return given()
                .when()
                .get();
    }

    public Response postRequest(String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post");
    }

    public Response postFormData(String name, String surname) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("name", name)
                .formParam("surname", surname)
                .when()
                .post("/post");
    }

    public Response putRequest(String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put");
    }

    public Response patchRequest(String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch");
    }

    public Response deleteRequest() {
        return given()
                .when()
                .delete("/delete");
    }
}