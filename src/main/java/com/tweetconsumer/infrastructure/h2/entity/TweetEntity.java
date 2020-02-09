package com.tweetconsumer.infrastructure.h2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TweetEntity {
    private Integer id;
    private String user;
    private String text;
    private String localization;
    private boolean validate;
}
