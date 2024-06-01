package org.chrissmb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person extends PanacheEntity {
    private String name;
    private LocalDate birthday;
    private Double height;
}