package com.tweetconsumer.infrastructure.h2.adapter;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;

public class TweetDomainToTweetEntityAdapter {

    public TweetEntity execute(final Tweet tweet) {

        TweetEntity entity = new TweetEntity();
        //entity.setId(tweet.getId());
        entity.setUser(tweet.getUser());
        entity.setText(tweet.getText());
        entity.setLocalization(tweet.getLocalization());
        entity.setValidate(tweet.isValidate());
        return entity;
    }
}
