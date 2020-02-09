package com.tweetconsumer.infrastructure.h2;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import com.tweetconsumer.infrastructure.h2.adapter.TweetDomainToTweetEntityAdapter;
import com.tweetconsumer.infrastructure.h2.adapter.TweetEntityToTweetDomainAdapter;
import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TweetsJdbcRepository implements TweetsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter;
    @Autowired
    private TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter;

    @Override
    public List<Tweet> retrieveAllTweets() {
        List<Tweet> tweets = new ArrayList<>();

        List<TweetEntity> tweetEntities = jdbcTemplate.query("select * from tweet",
                (rs, rowNum) ->
                        new TweetEntity(
                                rs.getInt("id"),
                                rs.getString("user"),
                                rs.getString("text"),
                                rs.getString("localization"),
                                rs.getBoolean("validate")
                        )
        );

        tweetEntities.forEach(tweetEntity ->
                tweets.add(tweetEntityToTweetDomainAdapter.execute(tweetEntity)));
        return tweets;
    }

    @Override
    public List<Tweet> retrieveValidateTweets() {
        List<Tweet> tweets = new ArrayList<>();

        List<TweetEntity> tweetEntities = jdbcTemplate.query("select * from tweet where validate = true",
                (rs, rowNum) ->
                        new TweetEntity(
                                rs.getInt("id"),
                                rs.getString("user"),
                                rs.getString("text"),
                                rs.getString("localization"),
                                rs.getBoolean("validate")
                        )
        );

        tweetEntities.forEach(tweetEntity ->
                tweets.add(tweetEntityToTweetDomainAdapter.execute(tweetEntity)));
        return tweets;
    }

    @Override
    public int save(Tweet tweet) {
        TweetEntity entity = tweetDomainToTweetEntityAdapter.execute(tweet);
        return jdbcTemplate.update("insert into tweet (id, user, text, localization, validate) "
                        + "values(?, ?, ?, ?, ?)",
                entity.getId(), entity.getUser(), entity.getText(),
                entity.getLocalization(), entity.isValidate());
    }

 /*   public TweetEntity findById(long id) {
        return jdbcTemplate.queryForObject("select * from tweet where id=?",
                new Object[]{id}, TweetEntity.class);
    }

    public int insert(TweetEntity tweet) {
        return jdbcTemplate.update("insert into tweet (id, user, text, localization, validate) "
                        + "values(?, ?, ?, ?, ?)",
                tweet.getId(), tweet.getUser(), tweet.getText(), tweet.getLocalization(), true);
    }

    public int update(TweetEntity tweet) {
        return jdbcTemplate.update("update tweet " + " set validate = ? " + " where id = ?",
                tweet.isValidate());
    }

    */
}
