package com.project.tailsroute.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MissingRepository {

    @Select("""
            SELECT id
                     FROM missing
                     ORDER BY id DESC
                     LIMIT 0, 1;		
                     	""")
    Integer lastNumber();


    @Insert("""
            INSERT INTO missing
            SET memberId = #{loginedMemberId},
            `name` = #{name},
            reportDate = #{reportDate},
            missingLocation = #{missingLocation},
            breed = #{breed},
            color = #{color},
            gender = #{gender},
            age = #{age},
            RFID = COALESCE(#{rfid},"없음"),    
            photo = #{photoPath},
            trait = #{trait}
              			""")
    void write(int loginedMemberId, String name, String reportDate, String missingLocation, String breed, String color, String gender, String age, String rfid, String photoPath, String trait);
}
