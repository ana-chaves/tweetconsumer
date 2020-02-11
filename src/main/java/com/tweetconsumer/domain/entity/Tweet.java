package com.tweetconsumer.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class Tweet {
    private Long id;
    private String user;
    private String text;
    private String localization;
    private boolean validate;
}
