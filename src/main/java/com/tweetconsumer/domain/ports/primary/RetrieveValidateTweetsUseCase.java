package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveValidateTweetsUseCase {
    private TweetsRepository tweetsRepository;

    public List<Tweet> retrieveValidateTweets() {
        return tweetsRepository.retrieveValidateTweets();
    }

}
