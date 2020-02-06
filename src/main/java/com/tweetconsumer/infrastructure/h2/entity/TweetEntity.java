package com.tweetconsumer.infrastructure.h2.entity;

import java.io.Serializable;

public class TweetEntity implements Serializable {

}
/*@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "Tweet", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"), @UniqueConstraint(columnNames = "EMAIL")})
public class TweetEntity implements Serializable {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer tweetId;
    @Column(name = "USER", unique = true, nullable = false, length = 100)
    private String user;
    @Column(name = "TEXT", unique = true, nullable = false, length = 1000)
    private String text;
    @Column(name = "LOCALIZATION", unique = true, nullable = false, length = 100)
    private String localization;
    @Column(name = "VALIDATE", unique = true, nullable = false)
    private boolean validate;
}*/
