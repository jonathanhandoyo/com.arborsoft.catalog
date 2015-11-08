package com.arborsoft.catalog.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

@Configuration
@ComponentScan(basePackages = {"com.arborsoft.catalog"})
@EnableNeo4jRepositories(basePackages = "com.arborsoft.catalog.repository")
public class ApplicationConfiguration extends Neo4jConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://jonathantest2:yG3vVKGa5kteDoX2h5sH@jonathantest2.sb02.stations.graphenedb.com:24789");
    }

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.arborsoft.catalog.model");
    }
}
