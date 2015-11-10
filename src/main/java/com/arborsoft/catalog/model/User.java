package com.arborsoft.catalog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Setter
@NodeEntity
public class User extends BaseEntity {
    @NotEmpty
    private String code;

    @NotEmpty
    private String name;
}
