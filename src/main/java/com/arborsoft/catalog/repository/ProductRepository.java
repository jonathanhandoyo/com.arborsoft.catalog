package com.arborsoft.catalog.repository;

import com.arborsoft.catalog.model.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GraphRepository<Product> {

    @Query(" MATCH (origin:Product), (target:Product) " +
           " WHERE id(origin) = {0} " +
           "   AND id(target) = {1} " +
           "CREATE UNIQUE (origin) -[:EXCLUDE]-> (target); ")
    void addExclude(Product origin, Product target);

    @Query(" MATCH (origin:Product), (target:Product) " +
            " WHERE id(origin) = {0} " +
            "   AND id(target) = {1} " +
            "CREATE UNIQUE (origin) -[:REQUIRE]-> (target); ")
    void addRequire(Product origin, Product target);

    @Query(" MATCH (product:Product) " +
           " WHERE product.sku = {0} " +
           "RETURN product; ")
    Product findBySku(String sku);
}
