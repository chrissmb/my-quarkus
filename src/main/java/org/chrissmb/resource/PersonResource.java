package org.chrissmb.resource;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.chrissmb.entity.Person;
import org.chrissmb.service.SomeService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

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

    @POST
    @Transactional
    public Person save(Person person) {
        logger.info("save {}", person);
        person.persist();
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
