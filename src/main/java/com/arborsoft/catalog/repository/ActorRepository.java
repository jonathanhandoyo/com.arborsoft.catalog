package com.arborsoft.catalog.repository;

import com.arborsoft.catalog.model.Actor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends GraphRepository<Actor> {
    @Query(" MATCH (actor:Actor {name:{name}}) " +
           "RETURN actor;")
    Actor findByName(@Param("name") String name);

    @Query(" START actor1 = node({0}), actor2 = node({1}) " +
           "CREATE UNIQUE (actor1) -[:FRIENDS_WITH]-> (actor2); ")
    void friend(Actor actor1, Actor actor2);

    @Query(" START actor1 = node({0}), actor2 = node({1}) " +
           " MATCH (actor1) -[rel:FRIENDS_WITH]- (actor2) " +
           "DELETE rel; ")
    void unfriend(Actor actor1, Actor actor2);
}
