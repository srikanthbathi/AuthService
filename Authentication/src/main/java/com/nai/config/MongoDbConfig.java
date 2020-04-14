package com.nai.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

@Component
public class MongoDbConfig {

    @Value("${spring.data.mongodb.uri}")
    private String conn;

    @Bean
    public MongoClient getMongoClient(){
        System.out.println(conn);
        ConnectionString con = new ConnectionString(conn);
        MongoClientSettings sett = MongoClientSettings.builder().applyConnectionString(con)
                .retryReads(true).build();
        MongoClient client = MongoClients.create(sett);
        return client;
    }

    @Autowired
    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient){
        return new MongoTemplate(mongoClient,"nai");
    }


    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(){
        return  new ValidatingMongoEventListener(localValidatorFactoryBean());
    }
}
