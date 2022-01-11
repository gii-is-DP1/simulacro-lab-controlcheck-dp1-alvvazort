package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductType {
    @Id
    Integer id;
    String name;
}
