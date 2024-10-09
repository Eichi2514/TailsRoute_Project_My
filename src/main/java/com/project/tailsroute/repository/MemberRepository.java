package com.project.tailsroute.repository;

import com.project.tailsroute.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

    @Select("SELECT * FROM `member` WHERE id = #{id}")
    Member getMemberById(int id);

}
