package com.epam.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.createSubscription(subscriptionRequestDto);
    }

    @PutMapping("/{subscriptionId}")
    public SubscriptionResponseDto updateSubscription(@PathVariable Long subscriptionId, @RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.updateSubscription(subscriptionId, subscriptionRequestDto);
    }

    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }

    @GetMapping("/{subscriptionId}")
    public SubscriptionResponseDto getSubscription(@PathVariable Long subscriptionId) {
        return subscriptionService.getSubscription(subscriptionId);
    }

    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
}
