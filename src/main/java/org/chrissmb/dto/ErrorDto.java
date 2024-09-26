package org.chrissmb.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
public class ErrorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6133088779981862040L;

    private String code;
    private String message;
    private LocalDate date;
}
