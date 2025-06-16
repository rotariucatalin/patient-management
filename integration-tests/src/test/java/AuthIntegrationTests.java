import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004/";
    }

    @Test
    public void shouldReturnOkWithValidToken() {
        String loadingPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "password123"
                    }
                """;


        Response response = given()
                .contentType(ContentType.JSON)
                .body(loadingPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract().response();

        System.out.println("Generated token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin() {
        String loadingPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "loremipsum"
                    }
                """;


        given()
                .contentType(ContentType.JSON)
                .body(loadingPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(401);
    }
}
