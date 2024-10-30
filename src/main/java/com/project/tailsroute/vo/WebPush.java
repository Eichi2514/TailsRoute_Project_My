package com.project.tailsroute.vo;

import lombok.Data;
import nl.martijndwars.webpush.Subscription;

@Data
public class WebPush {
    private int memberId;
    private Subscription subscription;

    public WebPush(int memberId, Subscription subscription) {
        this.memberId = memberId;
        this.subscription = subscription;
    }
}
