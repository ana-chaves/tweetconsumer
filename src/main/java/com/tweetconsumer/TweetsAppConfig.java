package com.tweetconsumer;

import com.tweetconsumer.application.TweetConsumerApplication;
import com.tweetconsumer.domain.ports.primary.RetrieveAllTweetsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TweetsAppConfig {

  @Bean
  TweetConsumerApplication tweetConsumerApplication(){
    return new TweetConsumerApplication(new RetrieveAllTweetsUseCase());
  }

}
