package com.arborsoft.catalog.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;

@Getter @Setter
public class BaseNode {
    @GraphId
    private Long id;

    public @Override String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
