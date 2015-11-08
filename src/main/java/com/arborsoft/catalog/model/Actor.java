package com.arborsoft.catalog.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Getter @Setter
@NodeEntity
public class Actor extends BaseNode {
    private String name;

    @Relationship(type = "FRIENDS_WITH")
    private Set<Actor> friends;
}
