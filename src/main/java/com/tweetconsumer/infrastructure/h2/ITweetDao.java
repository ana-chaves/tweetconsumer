package com.tweetconsumer.infrastructure.h2;

import com.tweetconsumer.infrastructure.h2.entity.TweetEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITweetDao extends CrudRepository<TweetEntity, Long> {

}
