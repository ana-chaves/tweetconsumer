package com.tweetconsumer.controller;

import com.tweetconsumer.application.TweetConsumerApplication;
import com.tweetconsumer.domain.entity.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tweets")
public class TweetConsumerController {

  private TweetConsumerApplication tweetConsumerApplication;

  @GetMapping("/")
  public ResponseEntity<List<Tweet>> getAllTweets() {
    List<Tweet> number = tweetConsumerApplication.getAllTweets();
    return ResponseEntity.ok(number);
  }
}
