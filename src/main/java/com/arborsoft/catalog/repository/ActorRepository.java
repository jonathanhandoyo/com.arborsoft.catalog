package com.arborsoft.catalog.repository;

import com.arborsoft.catalog.model.Actor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends GraphRepository<Actor> {
    @Query(" MATCH (actor:Actor {name:{0}})" +
           "RETURN actor;")
    Iterable<Actor> findByName(String name);
}
