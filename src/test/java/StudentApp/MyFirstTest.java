package StudentApp;

import io.restassured.RestAssured;

public class MyFirstTest {
    private void styles(){
        RestAssured.given()
                .queryParam("","")
                .when()
                .get("www.google.com")
                .then();

        RestAssured.given()
                .expect()
                .when();
    }
}
