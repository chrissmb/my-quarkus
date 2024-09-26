package org.chrissmb.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonNameNotInformedException extends RuntimeException {

    public PersonNameNotInformedException() {
        super("Person name not informed.");
    }

    public String getCode() {
        return "P0001";
    }
}
