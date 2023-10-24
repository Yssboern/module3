package com.epam.learn;

import java.util.List;

public interface SubscriptionService {
    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long subscriptionId);

    SubscriptionResponseDto getSubscription(Long subscriptionId);

    List<SubscriptionResponseDto> getAllSubscriptions();
}
