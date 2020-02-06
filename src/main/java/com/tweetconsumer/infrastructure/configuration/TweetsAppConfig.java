package com.tweetconsumer.infrastructure.configuration;

import com.tweetconsumer.controller.TweetConsumerController;
import com.tweetconsumer.domain.ports.primary.RetrieveAllTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.RetrieveValidateTweetsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TweetsAppConfig {

    @Bean
    TweetConsumerController tweetConsumerApplication() {
        return new TweetConsumerController(new RetrieveAllTweetsUseCase(), new RetrieveValidateTweetsUseCase());
    }

}
