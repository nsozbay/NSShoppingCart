package com.btcag.nscart.test.mongo;

import static org.junit.Assert.*;

import javax.inject.Inject;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.btcag.nscart.config.MongoConfiguration;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={MongoConfiguration.class})
public class MongoTemplateTest {
 
    @Inject MongoTemplate mongoTemplate;
     
    @Test
    public void testMongoTemplate() {
        assertEquals(mongoTemplate.getCollection("lc-activity-service").getName(), "lc-activity-service");
    }
}
