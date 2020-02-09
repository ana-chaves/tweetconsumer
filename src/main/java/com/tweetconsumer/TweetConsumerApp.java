package com.tweetconsumer;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TweetConsumerApp implements CommandLineRunner {

    @Autowired
    private TweetsRepository tweetsRepository;

    public static void main(String[] args) {
        SpringApplication.run(TweetConsumerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        tweetsRepository.save(new Tweet(1,"ana", "textAna", "lozaliza", true));
    }
}
