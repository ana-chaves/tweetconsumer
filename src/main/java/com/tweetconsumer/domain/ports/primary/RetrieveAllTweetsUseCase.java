package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;

import java.util.List;

public class RetrieveAllTweetsUseCase  {
  private TweetsRepository tweetsRepository;

  public List<Tweet> retrieveAllTweets() {
    return tweetsRepository.retrieveAllTweets();
  }
}
