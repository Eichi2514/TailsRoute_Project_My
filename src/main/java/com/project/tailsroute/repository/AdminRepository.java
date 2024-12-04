package com.project.tailsroute.repository;

import com.project.tailsroute.vo.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminRepository {

	@Insert("""
			INSERT INTO reply
			SET regDate = NOW(),
			updateDate = NOW(),
			memberId = #{loginedMemberId},
			relTypeCode = #{relTypeCode},
			relId = #{relId},
			`body` = #{body}
			""")
	void initData();
}
