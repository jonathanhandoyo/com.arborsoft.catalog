package com.arborsoft.catalog.config;

import com.arborsoft.catalog.model.BaseEntity;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.event.BeforeSaveEvent;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"com.arborsoft.catalog"})
@EnableNeo4jRepositories(basePackages = "com.arborsoft.catalog.repository")
public class ApplicationConfiguration extends Neo4jConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean
    @Override
    public Neo4jServer neo4jServer() {
        String url = "http://jonathantest2:yG3vVKGa5kteDoX2h5sH@jonathantest2.sb02.stations.graphenedb.com:24789";
        LOG.info("neo4j >> server @ " + url);
        return new RemoteServer(url);
    }

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        String _package = "com.arborsoft.catalog.model";
        LOG.info("neo4j >> models @ " + _package);
        return new SessionFactory(_package);
    }

    @Bean
    @Override
    public Session getSession() throws Exception {
        return super.getSession();
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
        return new ApplicationListener<BeforeSaveEvent>() {
            @Override
            public void onApplicationEvent(BeforeSaveEvent event) {
                BaseEntity entity = (BaseEntity) event.getEntity();

                Set<ConstraintViolation<BaseEntity>> violations = ApplicationConfiguration.this.validator().validate(entity);
                if (!violations.isEmpty()) {
                    LOG.error("constraint violation while saving: " + entity.toString());
                    for (ConstraintViolation<BaseEntity> violation: violations) {
                        LOG.error("constraint violation: '" + violation.getRootBeanClass().getSimpleName() + "." + violation.getPropertyPath().toString() + "' " + violation.getMessage());
                    }
                    throw new ConstraintViolationException(violations);
                }

                entity.setCreatedOn(entity.getId() == null ? new Date() : entity.getCreatedOn());
                entity.setCreatedBy(entity.getId() == null ? "SYSTEM"   : entity.getCreatedBy());
                entity.setUpdatedOn(entity.getId() != null ? new Date() : null);
                entity.setUpdatedBy(entity.getId() != null ? "SYSTEM"   : null);
            }
        };
    }
}
