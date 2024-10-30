package com.project.tailsroute.repository;

import org.apache.ibatis.annotations.*;
import nl.martijndwars.webpush.Subscription;

@Mapper
public interface WebPushRepository {

	@Insert("""
            INSERT INTO WebPush
            SET 
            memberId = #{memberId},
            endpoint = #{subscription.endpoint},
            p256dh = #{subscription.keys.p256dh},
            auth = #{subscription.keys.auth}
            """)
	void save(int memberId, Subscription subscription);
}
