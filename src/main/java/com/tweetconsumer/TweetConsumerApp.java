package com.tweetconsumer;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class TweetConsumerApp implements CommandLineRunner {

    @Autowired
    private TweetsRepository tweetsRepository;
    @Autowired
    private ConfigurationBuilder configurationBuilder;

    private List<String> languages = Arrays.asList("es", "fr", "it");

    public static void main(String[] args) {
        SpringApplication.run(TweetConsumerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();

        StatusListener listener = new StatusListener() {

            public void onStatus(Status status) {
                log.info(status.getUser().getName() + " : " + status.getText());
                String lang = status.getLang();
                if (languages.contains(lang)) {
                    saveTweet(status);
                }
            }

            private void saveTweet(Status status) {
                log.info(TwitterObjectFactory.getRawJSON(status));
                tweetsRepository.save(new Tweet(0L, status.getUser().getName(), status.getText(),
                        status.getGeoLocation() != null ? status.getGeoLocation().toString() : "", false));

            }

            @Override
            public void onException(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg) {
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
            }

            @Override
            public void onStallWarning(StallWarning warning) {
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            }
        };

        twitterStream.addListener(listener);
        twitterStream.sample();
    }
}

