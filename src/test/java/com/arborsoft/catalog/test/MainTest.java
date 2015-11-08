package com.arborsoft.catalog.test;

import com.arborsoft.catalog.config.ApplicationConfiguration;
import com.arborsoft.catalog.model.Actor;
import com.arborsoft.catalog.repository.ActorRepository;
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

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private Neo4jOperations template;

    @Test
    public void test1() throws Exception {
//        for (int i = 0; i < 100; i++) {
            this.actorRepository.friend(this.actorRepository.findByName("name1"), this.actorRepository.findByName("name2"));
//            this.actorRepository.unfriend(this.actorRepository.findByName("name2"), this.actorRepository.findByName("name1"));
//        }

        Actor test = this.template.load(Actor.class, 1L, 1);
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
        LOG.info(test.toString());
    }
}
