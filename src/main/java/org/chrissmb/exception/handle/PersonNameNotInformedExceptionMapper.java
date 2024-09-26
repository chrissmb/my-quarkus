package org.chrissmb.exception.handle;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.chrissmb.dto.ErrorDto;
import org.chrissmb.exception.PersonNameNotInformedException;

import java.time.LocalDate;

@Provider
public class PersonNameNotInformedExceptionMapper implements ExceptionMapper<PersonNameNotInformedException> {
    @Override
    public Response toResponse(PersonNameNotInformedException exception) {
        var error = ErrorDto.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .date(LocalDate.now())
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
