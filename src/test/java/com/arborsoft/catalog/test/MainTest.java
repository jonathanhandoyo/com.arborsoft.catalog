package com.arborsoft.catalog.test;

import com.arborsoft.catalog.config.ApplicationConfiguration;
import com.arborsoft.catalog.model.User;
import com.arborsoft.catalog.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class MainTest {
    private static final Logger LOG = LoggerFactory.getLogger(MainTest.class);

    @Autowired private Neo4jOperations neo4jTemplate;
    @Autowired private UserRepository users;

    @Before
    public void before() throws Exception {
        LOG.info("");
    }

    @Test
    public void test1() throws Exception {
        try {
            this.users.deleteAll();

            User input = new User();
            input.setCode("user-code");
            input.setName("name");
            this.neo4jTemplate.save(input);

            User output = this.users.findByCode("user-code");
            LOG.info(output.toString());
        } catch (Exception exception) {
            LOG.error(exception.getMessage(), exception);
            throw exception;
        }
    }
}
