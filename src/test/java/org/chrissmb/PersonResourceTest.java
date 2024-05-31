package org.chrissmb;

import io.quarkus.test.junit.QuarkusTest;
import org.chrissmb.entity.Person;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {

    @Test
    public void testGetAllPerson() {
        given()
                .when().get("/person")
                .then().statusCode(200);
    }

    @Test
    public void savePerson() {
        Person person = Person.builder()
                .name("Mock Person")
                .build();
        given().body(person).contentType("application/json")
                .when().post("/person")
                .then().statusCode(200).body("name", is("Mock Person"));
    }
}
