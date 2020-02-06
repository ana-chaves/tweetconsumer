package com.tweetconsumer.infrastructure.twitter;

import com.tweetconsumer.infrastructure.configuration.TwitterConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TwitterMessageProducerTest.TestConfig.class)
public class TwitterMessageProducerTest {
    @MockBean
    private TwitterStream twitterStream;
    @Autowired
    private PollableChannel outputChannel;
    @Autowired
    private TwitterMessageProducer twitterMessageProducer;

    @Test
    public void shouldBeInitialized() {
        StatusListener statusListener = twitterMessageProducer.getStatusListener();
        verify(twitterStream).addListener(statusListener);
        FilterQuery filterQuery = twitterMessageProducer.getFilterQuery();
        verify(twitterStream).filter(filterQuery);
    }

    @Test
    public void shouldReceiveStatus() {
        StatusListener statusListener = twitterMessageProducer.getStatusListener();
        Status status = mock(Status.class);
        statusListener.onStatus(status);
        Message<?> statusMessage = outputChannel.receive();
        assertSame(status, statusMessage.getPayload());
    }

    @Import(TwitterConfiguration.class)
    static class TestConfig {
        @Bean
        MessageChannel outputChannel() {
            return MessageChannels.queue(1).get();
        }
    }
}
