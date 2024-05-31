package org.chrissmb.entity;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person extends PanacheEntity {

    // @Id @GeneratedValue
    // private Long id;
    private String name;
    private Date birthday;
    private Double height;
}