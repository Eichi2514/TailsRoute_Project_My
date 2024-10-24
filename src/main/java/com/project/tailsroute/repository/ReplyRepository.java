package com.project.tailsroute.repository;

import com.project.tailsroute.vo.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyRepository {

	@Select("""
			SELECT R.*, M.nickname AS extra__writer
			FROM reply AS R
			INNER JOIN `member` AS M
			ON R.memberId = M.id
			WHERE relTypeCode = #{relTypeCode}
			AND relId = #{relId}
			ORDER BY R.id ASC;
				""")
	public List<Reply> getForPrintReplies(String relTypeCode, int relId);

	@Insert("""
			INSERT INTO reply
			SET regDate = NOW(),
			updateDate = NOW(),
			memberId = #{loginedMemberId},
			relTypeCode = #{relTypeCode},
			relId = #{relId},
			`body` = #{body}
			""")
	public void writeReply(int loginedMemberId, String body, String relTypeCode, int relId);

	@Select("SELECT LAST_INSERT_ID();")
	public int getLastInsertId();

	@Select("""
				SELECT R.*
				FROM reply AS R
				WHERE R.id = #{id}
			""")
	Reply getReply(int id);

	@Update("""
			UPDATE reply
			SET `body` = #{body},
			updateDate = NOW()
			WHERE id = #{id}
				""")
	public void modifyReply(int id, String body);

	@Delete("""
            DELETE FROM reply 
            WHERE id = #{id}
                """)
	void deleteReply(int id);

	@Select("""
            SELECT goodReactionPoint
            FROM reply
            WHERE id = #{relId}
            """)
	public int getGoodRP(int relId);

	@Select("""
            SELECT badReactionPoint
            FROM reply
            WHERE id = #{relId}
            """)
	public int getBadRP(int relId);

	@Update("""
            UPDATE reply
            SET goodReactionPoint = goodReactionPoint + 1
            WHERE id = #{relId}
            """)
	public int increaseGoodReactionPoint(int relId);

	@Update("""
            UPDATE reply
            SET goodReactionPoint = goodReactionPoint - 1
            WHERE id = #{relId}
            """)
	public int decreaseGoodReactionPoint(int relId);

	@Update("""
            UPDATE reply
            SET badReactionPoint = badReactionPoint + 1
            WHERE id = #{relId}
            """)
	public int increaseBadReactionPoint(int relId);

	@Update("""
            UPDATE reply
            SET badReactionPoint = badReactionPoint - 1
            WHERE id = #{relId}
            """)
	public int decreaseBadReactionPoint(int relId);
}
