package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;

import java.util.List;

public class RetrieveValidateTweetsUseCase {
    private TweetsRepository tweetsRepository;

    public List<Tweet> retrieveValidateTweets() {
        return tweetsRepository.retrieveValidateTweets();
    }

}
