package dev.lrossi.ecommerce.products.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "pdt_department")
@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
