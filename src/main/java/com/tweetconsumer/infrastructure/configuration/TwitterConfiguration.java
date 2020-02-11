package com.tweetconsumer.infrastructure.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Slf4j
@Configuration
public class TwitterConfiguration {

    @Bean()
    public ConfigurationBuilder configurationBuilder() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("KEY")
                .setOAuthConsumerSecret("SECRET")
                .setOAuthAccessToken("TOKEN")
                .setOAuthAccessTokenSecret("TOKENSECRET");
        configurationBuilder.setIncludeEntitiesEnabled(true);
        configurationBuilder.setJSONStoreEnabled(true);
        return configurationBuilder;
    }
}