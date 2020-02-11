package com.tweetconsumer.infrastructure.configuration;

import com.tweetconsumer.domain.ports.primary.RetrieveAllTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.RetrieveValidateTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import com.tweetconsumer.domain.ports.primary.UpdateToValidateTweetUseCase;
import com.tweetconsumer.infrastructure.h2.ITweetDao;
import com.tweetconsumer.infrastructure.h2.TweetsH2Repository;
import com.tweetconsumer.infrastructure.h2.adapter.TweetDomainToTweetEntityAdapter;
import com.tweetconsumer.infrastructure.h2.adapter.TweetEntityToTweetDomainAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TweetsAppConfig {

    @Bean
    public RetrieveAllTweetsUseCase retrieveAllTweetsUseCase(final TweetsRepository tweetsRepository) {
        return new RetrieveAllTweetsUseCase(tweetsRepository);
    }

    @Bean
    public RetrieveValidateTweetsUseCase retrieveValidateTweetsUseCase(final TweetsRepository tweetsRepository) {
        return new RetrieveValidateTweetsUseCase(tweetsRepository);
    }

    @Bean
    public UpdateToValidateTweetUseCase updateToValidateTweetUseCase(final TweetsRepository tweetsRepository) {
        return new UpdateToValidateTweetUseCase(tweetsRepository);
    }

    @Bean
    public TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter() {
        return new TweetEntityToTweetDomainAdapter();
    }

    @Bean
    public TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter() {
        return new TweetDomainToTweetEntityAdapter();
    }

    @Bean
    public TweetsH2Repository tweetsH2Repository(final ITweetDao tweetDao,
                                                 final TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter,
                                                 TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter) {
        return new TweetsH2Repository(tweetDao, tweetEntityToTweetDomainAdapter, tweetDomainToTweetEntityAdapter);

    }

}
