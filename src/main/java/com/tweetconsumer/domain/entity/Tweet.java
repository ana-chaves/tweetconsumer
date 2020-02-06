package com.tweetconsumer.domain.entity;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Tweet {
    private String user;
    private String text;
    private String localization;
    private boolean validate;
}
