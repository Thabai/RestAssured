package studentApp;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studentAppModel.StudentPojo;


import java.util.ArrayList;
import java.util.List;

public class CreateStudentTests extends TestBase{

    @DisplayName("Create new student sending payload")
    @Test
    void createNewStudent(){

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
                .when()
                .log()
                .all()
                .body(student)
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);


//        String payload = "{\"firstName\":\"test2\",\"lastName\":\"Harper\",\"email\":\"testCreate@gmail.com\",\"programme\":\"Financial Analysis\",\"courses\":[\"Accounting\",\"Statistics\"]}";
//
//        given()
//                .when()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(payload)
//                .post()
//                .then()
//                .statusCode(201);
    }

}
