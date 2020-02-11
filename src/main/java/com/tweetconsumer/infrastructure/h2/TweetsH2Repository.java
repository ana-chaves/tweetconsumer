package com.tweetconsumer.infrastructure.h2;

import com.tweetconsumer.domain.entity.Tweet;
import com.tweetconsumer.domain.ports.primary.TweetsRepository;
import com.tweetconsumer.infrastructure.h2.adapter.TweetDomainToTweetEntityAdapter;
import com.tweetconsumer.infrastructure.h2.adapter.TweetEntityToTweetDomainAdapter;
import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TweetsH2Repository implements TweetsRepository {

    private ITweetDao tweetDao;
    private TweetEntityToTweetDomainAdapter tweetEntityToTweetDomainAdapter;
    private TweetDomainToTweetEntityAdapter tweetDomainToTweetEntityAdapter;

    @Override
    public List<Tweet> retrieveAllTweets() {
        List<Tweet> tweets = new ArrayList<>();
        List<TweetEntity> tweetEntities = (List<TweetEntity>) tweetDao.findAll();
        tweetEntities.forEach(tweetEntity ->
                tweets.add(tweetEntityToTweetDomainAdapter.execute(tweetEntity)));
        return tweets;
    }

    @Override
    public List<Tweet> retrieveValidateTweets() {
        List<Tweet> tweets = new ArrayList<>();
        List<TweetEntity> tweetEntities = (List<TweetEntity>) tweetDao.findAll();
        List<TweetEntity> validateTweets = tweetEntities.stream().
                filter(TweetEntity::isValidate).
                collect(Collectors.toList());
        validateTweets.forEach(tweetEntity ->
                tweets.add(tweetEntityToTweetDomainAdapter.execute(tweetEntity)));
        return tweets;
    }

    @Override
    public Tweet save(final Tweet tweet) {
        TweetEntity entity = tweetDomainToTweetEntityAdapter.execute(tweet);
        return tweetEntityToTweetDomainAdapter.execute(tweetDao.save(entity));
    }

    @Override
    public Tweet updateValidateField(final Long id) {
        Optional<TweetEntity> optionalEntity = tweetDao.findById(id);
        TweetEntity entity = optionalEntity.get();
        entity.setValidate(true);
        tweetDao.save(entity);
        return tweetEntityToTweetDomainAdapter.execute(tweetDao.save(entity));
    }

}
