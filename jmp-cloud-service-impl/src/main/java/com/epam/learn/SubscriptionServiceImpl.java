package com.epam.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = new Subscription();
        Optional<User> user = userRepository.findById(subscriptionRequestDto.getUserId());

        if (user.isPresent()) {
            subscription.setUser(user.get());
            subscription.setStartDate(LocalDate.now());

            Subscription savedSubscription = subscriptionRepository.save(subscription);
            return mapSubscriptionToResponseDto(savedSubscription);
        } else {
            throw new UserNotFoundException("User not found with id: " + subscriptionRequestDto.getUserId());
        }
    }

    @Override
    public SubscriptionResponseDto updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(subscriptionId);

        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();

            if (subscriptionRequestDto.getUserId() != null) {
                Optional<User> user = userRepository.findById(subscriptionRequestDto.getUserId());
                if (user.isPresent()) {
                    subscription.setUser(user.get());
                } else {
                    throw new UserNotFoundException("User not found with id: " + subscriptionRequestDto.getUserId());
                }
            }
            subscription.setStartDate(LocalDate.now());
            Subscription updatedSubscription = subscriptionRepository.save(subscription);
            return mapSubscriptionToResponseDto(updatedSubscription);
        } else {
            throw new SubscriptionNotFoundException("Subscription not found with id: " + subscriptionId);
        }
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(subscriptionId);

        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();
            return mapSubscriptionToResponseDto(subscription);
        } else {
            throw new SubscriptionNotFoundException("Subscription not found with id: " + subscriptionId);
        }
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptions.stream()
                .map(this::mapSubscriptionToResponseDto)
                .collect(Collectors.toList());
    }

    private SubscriptionResponseDto mapSubscriptionToResponseDto(Subscription subscription) {
        SubscriptionResponseDto responseDto = new SubscriptionResponseDto();
        responseDto.setId(subscription.getId());
        responseDto.setUserId(subscription.getUser().getId());
        responseDto.setStartDate(String.valueOf(subscription.getStartDate()));
        return responseDto;
    }
}
