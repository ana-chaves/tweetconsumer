package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveAllTweetsUseCase  {
  private TweetsRepository tweetsRepository;

  public List<Tweet> retrieveAllTweets() {
    return tweetsRepository.retrieveAllTweets();
  }
}
