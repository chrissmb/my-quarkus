package org.chrissmb.resource;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.chrissmb.entity.Person;
import org.chrissmb.exception.PersonNameNotInformedException;
import org.chrissmb.service.SomeService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;

@Path("/person")
public class PersonResource {

    private final Logger logger = LoggerFactory.getLogger(PersonResource.class);

    @ConfigProperty(name = "application.my-property")
    String myProperty;

    @Inject
    SomeService someService;

    @Inject
    NumberFormat numberFormat;

    @Inject
    DateFormat dateFormat;

    @GET
    public List<Person> getAll() {
        logger.info("getAll");
        return Person.listAll();
    }

    @GET
    @Path("{id}")
    public Person getById(@PathParam("id") Long id) {
        logger.info("getById {}", id);
        return Person.findById(id);
    }

    @POST
    @Transactional
    public Person save(Person person) {
        logger.info("save {}", person);
        if (person.getName() == null || person.getName().isBlank()) {
            throw new PersonNameNotInformedException();
        }
        person.persist();
        return person;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Person save(Person person, @PathParam("id") Long id) {
        logger.info("update {}", person);
        if (person.getName() == null || person.getName().isBlank()) {
            throw new PersonNameNotInformedException();
        }
        Person.<Person>findByIdOptional(id).ifPresent(person1 -> {
            person1.setName(person.getName());
            person1.setBirthday(person.getBirthday());
            person1.setHeight(person.getHeight());
            person1.persist();
        });
        return person;
    }

    @GET
    @Path("my-property")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMyProperty() {
        String myContent = someService.getContent();
        String myNumber = numberFormat.format(123_123_123.123123);
        String myDate = dateFormat.format(new Date());

        logger.info(numberFormat.format(1234.1));
        logger.info(numberFormat.format(1.1));
        logger.info(numberFormat.format(0.1));
        logger.info(numberFormat.format(1));

        return "myProperty: %s, myContent: %s, myNumber: %s, myDate: %s".formatted(myProperty, myContent, myNumber, myDate);
    }
}
