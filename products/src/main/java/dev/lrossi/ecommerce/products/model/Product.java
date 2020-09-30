package dev.lrossi.ecommerce.products.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "product")
public class Product {

    public static final String TABLE_NAME = "pd_product";

}
