package com.tweetconsumer.infrastructure.h2.adapter;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TweetDomainToTweetEntityAdapter {

    public TweetEntity execute(final Tweet tweet) {

        return TweetEntity.builder()
                .id(tweet.getId())
                .user(tweet.getUser())
                .text(tweet.getText())
                .localization(tweet.getLocalization())
                .validate(tweet.isValidate())
                .build();
    }
}
