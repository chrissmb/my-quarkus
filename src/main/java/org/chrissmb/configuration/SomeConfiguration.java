package org.chrissmb.configuration;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

@Dependent
public class SomeConfiguration {

    @Produces
    NumberFormat getNumberFormat() {
        return new DecimalFormat("#,##0.00");
    }

    @Produces
    DateFormat getDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
}
