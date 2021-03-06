package com.arborsoft.catalog.model;

import com.arborsoft.catalog.serializer.DateDeserializer;
import com.arborsoft.catalog.serializer.DateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;

import java.util.Date;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL) @JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {
    @GraphId
    private Long id;

    private String createdBy;
    private String updatedBy;

    @JsonSerialize(using = DateSerializer.class) @JsonDeserialize(using = DateDeserializer.class)
    private Date createdOn;

    @JsonSerialize(using = DateSerializer.class) @JsonDeserialize(using = DateDeserializer.class)
    private Date updatedOn;

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
