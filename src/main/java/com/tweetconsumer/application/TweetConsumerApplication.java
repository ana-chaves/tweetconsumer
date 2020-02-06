package com.tweetconsumer.application;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TweetConsumerApplication {

    private TweetsRepository repository;

    public List<Tweet> getAllTweets() {
        List<Tweet> result;
        result = repository.retrieveAllTweets();
        return result;
    }

}
