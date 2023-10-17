package studentApp;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studentAppModel.StudentPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateStudentTests extends TestBase{


    @DisplayName("Update student sending payload")
    @Test
    void updateStudent(){

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
                .put("/100")
                .then()
                .log()
                .all()
                .statusCode(200);

    }


        @DisplayName("Update email sending payload")
        @Test
        void updateEmailStudent(){

            StudentPojo student = new StudentPojo();
            Faker fake = new Faker();

            student.setEmail(fake.internet().emailAddress());


            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .log()
                    .all()
                    .body(student)
                    .patch("/99")
                    .then()
                    .log()
                    .all()
                    .statusCode(200);

        }


}
