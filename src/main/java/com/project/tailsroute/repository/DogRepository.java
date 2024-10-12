package com.project.tailsroute.repository;

import com.project.tailsroute.vo.Dog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DogRepository {

    @Select("""
			SELECT id
            FROM dog
            ORDER BY id DESC
            LIMIT 1;		
            	""")
    Integer lastNumber();

    @Insert("""
            INSERT INTO dog
            SET regDate = NOW(),
            updateDate = NOW(),
            memberId = #{loginedMemberId},
            `name` = #{dogName},
            weight = COALESCE(#{dogWeight}, -1),
            `type` = #{dogType},
            photo = #{photoPath}
                    			""")
    void upload(int loginedMemberId, String dogName, Double dogWeight, String dogType, String photoPath);

    @Select("""
            SELECT *
            FROM dog
            WHERE memberId = #{loginedMemberId} 
            LIMIT 0, 1;
             """)
    Dog getDogfile(int loginedMemberId);
}