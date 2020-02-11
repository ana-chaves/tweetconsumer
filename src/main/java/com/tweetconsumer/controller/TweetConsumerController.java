package com.tweetconsumer.controller;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.RetrieveAllTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.RetrieveValidateTweetsUseCase;
import com.tweetconsumer.domain.ports.primary.UpdateToValidateTweetUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tweets")
public class TweetConsumerController {

    private RetrieveAllTweetsUseCase retrieveAllTweetsUseCase;
    private RetrieveValidateTweetsUseCase retrieveValidateTweetsUseCase;
    private UpdateToValidateTweetUseCase updateToValidateTweetUseCase;

    @GetMapping("/")
    public ResponseEntity<List<Tweet>> getAllTweets() {
        List<Tweet> tweets = retrieveAllTweetsUseCase.retrieveAllTweets();
        return ResponseEntity.ok(tweets);
    }

    @GetMapping("/validate")
    public ResponseEntity<List<Tweet>> getValidateTweets() {
        List<Tweet> tweets = retrieveValidateTweetsUseCase.retrieveValidateTweets();
        return ResponseEntity.ok(tweets);
    }

    @PatchMapping("/validate/{id}")
    public ResponseEntity<Tweet> updateToValidateTweet(@PathVariable Long id) {
        Tweet tweet = updateToValidateTweetUseCase.updateToValidate(id);
        return ResponseEntity.ok(tweet);
    }
}
