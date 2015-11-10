package com.arborsoft.catalog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Getter
@Setter
@NodeEntity
public class Product extends BaseEntity {
    @NotEmpty
    private String sku;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @Relationship(type = "REQUIRE")
    private Set<Product> requiredProducts;

    @Relationship(type = "EXCLUDE")
    private Set<Product> excludedProducts;
}
