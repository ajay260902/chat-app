package com.substring.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.substring.chat")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://user1:ajay1234@cluster0.rkkfnby.mongodb.net/?retryWrites=true&w=majority");
    }

    @Override
    protected String getDatabaseName() {
        return "chat_app"; // Replace with your actual database name
    }
}