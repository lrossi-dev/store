package dev.lrossi.ecommerce.products.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "pdt_brand")
@Entity(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
