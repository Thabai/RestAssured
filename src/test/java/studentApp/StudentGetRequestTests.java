package studentApp;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentGetRequestTests extends TestBase{
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

    @DisplayName("Getting all student names from database")
    @Test
    void getAllStudents(){

//        RequestSpecification requestSpec = RestAssured.given();
//
//        Response response = requestSpec.get("http://localhost:8080/student/list");
//        response.prettyPrint();
//
//        ValidatableResponse validatableReponse = response.then();
//        validatableReponse.statusCode(200);

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

        RestAssured.given()
                .expect()
                .statusCode(200)
                .when()
                .get("/list");

    }

    @DisplayName("Get a CS student from list")
    @Test
    void getSingleCSStudent() {

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("programme","Computer Science");
        params.put("limit", 1);

        Response response =
        given()
//                .queryParam("programme" ,"Computer Science")
//                .queryParam("limit", 1)
                .queryParams(params)
//                .queryParams("programme","Computer Science", "limit", 2)
                .when()
                .get("/list");

        response.prettyPrint();
    }

    @DisplayName("Get first student from list")
    @Test
    void getFirstStudent() {


        Response response =
                given()
                        .pathParam("id", 2)
                        .when()
                        .get("/{id}");

        response.prettyPrint();
    }
}
