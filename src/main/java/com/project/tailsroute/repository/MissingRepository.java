package com.project.tailsroute.repository;

import com.project.tailsroute.vo.Missing;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("""			
			SELECT COUNT(*)
			FROM missing
			""")
    int totalCnt();

    @Select("""
			SELECT S.*, M.name extra__ownerName, M.cellphoneNum extra__ownerCellphoneNum
			FROM missing S
			LEFT JOIN `member` M
			ON m.id = S.memberId
			LIMIT #{limitFrom}, #{itemsInAPage}
			""")
    List<Missing> list(int limitFrom, int itemsInAPage);
}
