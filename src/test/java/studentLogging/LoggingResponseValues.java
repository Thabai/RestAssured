package studentLogging;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studentApp.TestBase;

import static io.restassured.RestAssured.*;
public class LoggingResponseValues extends TestBase{



    @DisplayName("This test will print out all the Response Headers")
    @Test
    public void test001(){

        given()
                .param("programme", "Computer Science")
                .param("limit",1)
                .when()
                .get("/list")
                .then()
                .log()
                .headers()
                .statusCode(200);
    }


    @DisplayName("This test will print out all the Response Status line")
    @Test
    public void test002(){

        given()
                .param("programme", "Computer Science")
                .param("limit",1)
                .when()
                .get("/list")
                .then()
                .log()
                .status()
                .statusCode(200);
    }


    @DisplayName("This test will print out all the Response body")
    @Test
    public void test003(){

        given()
                .param("programme", "Computer Science")
                .param("limit",1)
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @DisplayName("This test will print out all the Response incase of error")
    @Test
    public void test004(){

        given()
                .param("programme", "Computer Science")
                .param("limit",1)
                .when()
                .get("/list")
                .then()
                .log()
                .ifError();
    }

}
