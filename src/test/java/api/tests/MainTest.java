package api.tests;
import api.pojoClasses.*;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import api.specification.Specifications;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;


public class MainTest {

    private static final String URL = "https://reqres.in/";

    @Test
    public void SortYearTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        List<ListResources> listResources = given()
                .when()
                    .get("api/unknown")
                .then()
                    .log().all()
                    .extract().body().jsonPath().getList("data", ListResources.class);


        List<Integer> years = listResources.stream().map(ListResources::getYear).collect(Collectors.toList());
        List<Integer> sortedYear = years.stream().sorted().collect(Collectors.toList());
        System.out.println(years);

        System.out.println(sortedYear);

       Assertions.assertEquals(sortedYear,years);
    }

    @Test
    public void CheckSuccessLogin(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        String token = "QpwL5tke4Pnpja7X4";
        UserForRegisterAndLogin userForRegisterAndLogin = new UserForRegisterAndLogin("eve.holt@reqres.in","cityslicka");

        SuccessfulUser successfulUser = given()
                .body(userForRegisterAndLogin)
                .when()
                .post("api/login")
                .then()
                .log().all()
                .extract().as(SuccessfulUser.class);

        Assertions.assertEquals(token,successfulUser.getToken());
    }

    @Test
    public void CheckUnSuccessLogin(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec400());

        String error = "Missing password";
        UserForRegisterAndLogin userForRegisterAndLogin = new UserForRegisterAndLogin("peter@klaven","");

        UnSuccessfulUser unSuccessfulUser = given()
                .body(userForRegisterAndLogin)
                .when()
                .post("api/login")
                .then()
                .log().all()
                .extract().as(UnSuccessfulUser.class);

        Assertions.assertEquals(error,unSuccessfulUser.getError());
    }

    @Test
    public void DeleteUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));

        given()
                .when()
                    .delete("api/users/2")
                .then()
                    .log().all();
    }

    @Test
    public void CheckUserDateTime(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        UserTimeRequest userReq = new UserTimeRequest("morpheus","zion resident");

        UserTimeResponse userResp = given()
                .body(userReq)
                .when()
                .put("api/users/2")
                .then()
                .log().all()
                .extract().as(UserTimeResponse.class);

        LocalDate currentDate = LocalDate.now();

        Assertions.assertEquals(currentDate,ZonedDateTime.parse(userResp.getUpdatedAt()).toLocalDate());

    }

    @Test
    public void DelayUsers(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        String checkJpg = "jpg";
        Awaitility.await()
                .atMost(6, TimeUnit.SECONDS) // Запрос от сервера придет через 3 секунды, но так как проверка включена в untilAsserted, следовательно нужно больше времени чтобы прошел весь тест
                .pollInterval(500, TimeUnit.MILLISECONDS) // Проверяем каждые 500 мс
                .ignoreExceptions() // Игнорируем ошибки, если ответ еще не пришел
                .untilAsserted(() -> {
                    List<ListUsers> listUsers = given()
                            .when()
                            .get("api/users?delay=3")
                            .then()
                            .extract().body().jsonPath().getList("data", ListUsers.class);

                    Assertions.assertTrue(listUsers.stream().allMatch(x->x.getAvatar().endsWith(checkJpg)));
                });
    }


    @Test
    public void SingleResource(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

        int year = 2001;

        UnknownSingleResource unRes = given()
                .when()
                .get("api/unknown/2")
                .then()
                .log().all()
                .extract().jsonPath().getObject("data",UnknownSingleResource.class);

        Assertions.assertEquals(year, unRes.getYear());


    }
}
