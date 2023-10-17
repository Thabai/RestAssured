package studentLogging;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studentApp.TestBase;
import studentAppModel.StudentPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class LoggingRequestValues extends TestBase {

    @DisplayName("Print out all request headers")
    @Test
    public void test001() {

        System.out.println("Printing headers");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);

    }

    @DisplayName("Print out all request parameters")
    @Test
    public void test002() {

        System.out.println("Printing request parameters");
        given()
                .param("programme", "Computer Science")
                .param("limit" , 1)
                .log()
                .params()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }

    @DisplayName("Print out request body")
    @Test
    public void test003() {
        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        List<String> courseList = new ArrayList<String>();
        courseList.add("Java");
        courseList.add("C++");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Computer Science");
        student.setCourses(courseList);

        given()
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

    @DisplayName("Print out if validation fails")
    @Test
    public void test004() {
        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        List<String> courseList = new ArrayList<String>();
        courseList.add("Java");
        courseList.add("C++");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Computer Science");
        student.setCourses(courseList);

        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

}

