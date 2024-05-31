package org.chrissmb.resource;

import java.util.List;

import org.chrissmb.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/person")
public class PersonResource {

    private final Logger logger = LoggerFactory.getLogger(PersonResource.class); 

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
}
