package com.arborsoft.catalog.test;

import com.arborsoft.catalog.config.ApplicationConfiguration;
import com.arborsoft.catalog.model.Actor;
import com.arborsoft.catalog.repository.ActorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class MainTest {
    private static final Logger LOG = LoggerFactory.getLogger(MainTest.class);

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void test1() throws Exception {
        Actor actor = this.actorRepository.findByName("name").iterator().next();
        Assert.assertNotNull(actor);
//        System.out.println(actor.toString());
//        System.out.println(actor.toString());
//        System.out.println(actor.toString());
//        System.out.println(actor.toString());
//        System.out.println(actor.toString());
//        System.out.println(actor.toString());
    }
}
