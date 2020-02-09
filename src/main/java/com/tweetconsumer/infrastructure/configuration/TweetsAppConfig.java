package com.tweetconsumer.infrastructure.configuration;

import com.tweetconsumer.controller.TweetConsumerController;
import com.tweetconsumer.domain.ports.primary.RetrieveAllTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.RetrieveValidateTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import com.tweetconsumer.infrastructure.h2.TweetsJdbcRepository;
import com.tweetconsumer.infrastructure.h2.adapter.TweetDomainToTweetEntityAdapter;
import com.tweetconsumer.infrastructure.h2.adapter.TweetEntityToTweetDomainAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class TweetsAppConfig {

   /* @Bean
    public TweetConsumerController tweetConsumerApplication(final RetrieveAllTweetsUseCase retrieveAllTweetsUseCase,
                                                            final RetrieveValidateTweetsUseCase retrieveValidateTweetsUseCase) {
        return new TweetConsumerController(retrieveAllTweetsUseCase, retrieveValidateTweetsUseCase);
    }*/

    @Bean
    public RetrieveAllTweetsUseCase retrieveAllTweetsUseCase(final TweetsRepository tweetsRepository) {
        return new RetrieveAllTweetsUseCase(tweetsRepository);
    }

    @Bean
    public RetrieveValidateTweetsUseCase retrieveValidateTweetsUseCase(final TweetsRepository tweetsRepository) {
        return new RetrieveValidateTweetsUseCase(tweetsRepository);
    }

   /* @Bean
    public TweetsJdbcRepository tweetsJdbcRepository(final JdbcTemplate jdbcTemplate,
                                                     final TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter,
                                                     final TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter) {
        return new TweetsJdbcRepository(jdbcTemplate, tweetEntityToTweetDomainAdapter, tweetDomainToTweetEntityAdapter);
    }*/

    @Bean
    public TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter() {
        return new TweetEntityToTweetDomainAdapter();
    }

    @Bean
    public TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter() {
        return new TweetDomainToTweetEntityAdapter();
    }


}
