package org.chrissmb;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.chrissmb.entity.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class PersonResourceTest {

    @Test
    public void testGetAllPerson() {
        List<Person> personList = instancePersonList();
        PanacheMock.mock(Person.class);
        Mockito.when(Person.<Person>listAll()).thenReturn(personList);
        given()
                .when().get("/person")
                .then().statusCode(200).body("size()", is(2));
    }

    @Test
    public void testSavePerson() {
        Person person = Person.builder()
            .name("Mock Person")
            .birthday(LocalDate.of(2000, 1, 1))
            .height(1.8)
            .build();
        given().body(person).contentType(ContentType.JSON)
            .when().post("/person")
            .then().statusCode(200)
                .body("name", is("Mock Person"))
                .body("birthday", is("2000-01-01"))
                .body("height", is(1.8f))
                .body("id", is(notNullValue()));
    }

    private List<Person> instancePersonList() {
        Person person1 = Person.builder()
                .name("John")
                .height(1.8)
                .birthday(LocalDate.of(1990, 01, 02))
                .build();
        Person person2 = Person.builder()
                .name("Maria")
                .height(1.63)
                .birthday(LocalDate.of(1990, 01, 02))
                .build();
        return List.of(person1, person2);
    }
}
