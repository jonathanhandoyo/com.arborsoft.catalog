package com.arborsoft.catalog.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter @Setter
@NodeEntity
public class Actor extends BaseNode {
    private String name;
}
