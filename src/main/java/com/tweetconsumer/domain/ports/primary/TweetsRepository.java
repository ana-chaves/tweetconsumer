package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;

import java.util.List;

public interface TweetsRepository {
    List<Tweet> retrieveAllTweets();
     List<Tweet> retrieveValidateTweets();
     int save(Tweet tweet);
}
