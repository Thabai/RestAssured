package studentApp;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studentAppModel.StudentPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteStudentTest extends TestBase {


    @DisplayName("Delete student")
    @Test
    void deleteStudent(){


        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/100")
                .then()
                .statusCode(204);


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
