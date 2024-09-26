package org.chrissmb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Person extends PanacheEntity {

    private String name;

    private LocalDate birthday;

    private Double height;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime inserted;

    @UpdateTimestamp
    private LocalDateTime updated;
}