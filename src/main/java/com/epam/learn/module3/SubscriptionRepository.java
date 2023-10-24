package com.epam.learn.module3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
