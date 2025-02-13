package api.tests;

import api.pojoClasses.JwtToken;
import api.pojoClasses.LoginReqst;
import api.specification.Specifications;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestJWT {

    String URL = "http://85.192.34.140:8080/";

    @Test
    public void checkJwtToken(){

        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        LoginReqst loginReqst = new LoginReqst("admin","admin");

        JwtToken token = given()
                .body(loginReqst)
                .when()
                .post("api/login")
                .then().log().all()
                .extract().as(JwtToken.class);


        Response resp = given()
                .auth().oauth2(token.getToken())
                .when()
                .get("api/user")
                .then().log().all()
                .extract().response();

        String gamesTitle = resp.jsonPath().getString("games[0].title");

        Assertions.assertEquals(gamesTitle,"Aerodynamic Bronze Shoes");



    }
}
