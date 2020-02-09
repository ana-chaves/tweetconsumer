package com.tweetconsumer.infrastructure.h2.adapter;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TweetEntityToTweetDomainAdapter {

    public Tweet execute(final TweetEntity tweetEntity) {

        return Tweet.builder()
                .user(tweetEntity.getUser())
                .text(tweetEntity.getText())
                .localization(tweetEntity.getLocalization())
                .validate(tweetEntity.isValidate())
                .build();
    }
}
