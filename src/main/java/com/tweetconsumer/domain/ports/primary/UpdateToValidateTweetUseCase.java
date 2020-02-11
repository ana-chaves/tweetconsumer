package com.tweetconsumer.domain.ports.primary;

import com.tweetconsumer.domain.entity.Tweet;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UpdateToValidateTweetUseCase {
    private TweetsRepository tweetsRepository;
    public Tweet updateToValidate(final Long id) {
        return tweetsRepository.updateValidateField(id);
    }
}
