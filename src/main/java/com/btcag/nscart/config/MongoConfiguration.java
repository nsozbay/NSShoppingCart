package com.btcag.nscart.config;


import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
 
import java.net.UnknownHostException;
 
 
@Configuration
public class MongoConfiguration  extends AbstractMongoConfiguration {
	
	private static final String DATABASE_NAME = "deneme";
	
    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }
 
    public @Bean
    Mongo mongo() throws UnknownHostException {
        ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(4).socketKeepAlive(true).build();
        Mongo mongo = new MongoClient(serverAddress, options);
        return mongo;
    }
    @Bean(name="MongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), DATABASE_NAME);
    }
 
}
