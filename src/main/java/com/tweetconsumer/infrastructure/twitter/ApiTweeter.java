package com.tweetconsumer.infrastructure.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class ApiTweeter {

    public static Twitter getTwitterinstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("//TODO")
                .setOAuthConsumerSecret("//TODO")
                .setOAuthAccessToken("//TODO")
                .setOAuthAccessTokenSecret("//TODO");
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getSingleton();
    }

    public static List<String> getTimeLine() throws TwitterException {
        Twitter twitter = getTwitterinstance();
        List<Status> statuses = twitter.getHomeTimeline();
        return statuses.stream().map(
                Status::getText).collect(
                Collectors.toList());
    }
}
