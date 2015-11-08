package com.arborsoft.catalog.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;

@Configuration
@ComponentScan(basePackages = {"com.arborsoft.catalog"})
@EnableNeo4jRepositories(basePackages = "com.arborsoft.catalog.repository")
public class ApplicationConfiguration extends Neo4jConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean
    public Neo4jServer neo4jServer() {
        String url = "http://jonathantest2:yG3vVKGa5kteDoX2h5sH@jonathantest2.sb02.stations.graphenedb.com:24789";
        LOG.info("neo4j >> " + url);
        return new RemoteServer(url);
    }

    @Bean
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
    public Neo4jOperations neo4jTemplate() throws Exception {
        return new Neo4jTemplate(this.getSession());
    }
}
