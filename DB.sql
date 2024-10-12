DROP DATABASE IF EXISTS `tails_route`;
CREATE DATABASE `tails_route`;
USE `tails_route`;

## 회원정보 테이블
CREATE TABLE `member`(
                         id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                         regDate DATETIME NOT NULL COMMENT '가입 날짜',
                         updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                         loginId CHAR(30) NOT NULL COMMENT '아이디',
                         loginPw CHAR(100) NOT NULL COMMENT '비밀번호',
                         authLevel SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반, 7=관리자)',
                         `name` CHAR(20) NOT NULL COMMENT '오프라인 이름',
                         nickname CHAR(20) NOT NULL COMMENT '온라인 이름',
                         gender TINYINT(1) UNSIGNED NOT NULL COMMENT '성별 (0=여자, 1=남자)',
                         cellphoneNum CHAR(20) NOT NULL COMMENT '전화번호',
                         delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
                         delDate DATETIME COMMENT '탈퇴 날짜'
);

## 회원정보 테이블 테스트 데이터

INSERT INTO `member` SET
                         regDate = '2024-02-05 14:15:00',
                         updateDate = '2024-03-10 16:30:00',
                         loginId = 'admin',
                         loginPw = 'pw_hash2',
                         authLevel = 7,
                         `name` = '관리자',
                         nickname = '강아지왕',
                         gender = 1,
                         cellphoneNum = '010-8765-4321',
                         delStatus = 0;

INSERT INTO `member` SET
    regDate = '2024-01-10 10:30:00',
                         updateDate = '2024-02-10 12:00:00',
                         loginId = 'user01',
                         loginPw = 'pw_hash1',
                         authLevel = 3,
                         `name` = '김서준',
                         nickname = '콩이의대장',
                         gender = 1,
                         cellphoneNum = '010-1234-5678',
                         delStatus = 0;


INSERT INTO `member` SET
    regDate = '2024-03-20 09:45:00',
                         updateDate = '2024-04-25 14:15:00',
                         loginId = 'user02',
                         loginPw = 'pw_hash3',
                         authLevel = 3,
                         `name` = '이지아',
                         nickname = '바둑이의수호자',
                         gender = 0,
                         cellphoneNum = '010-1111-2222',
                         delStatus = 1,
                         delDate = '2024-05-01 10:30:00';

INSERT INTO `member` SET
    regDate = '2024-04-18 16:00:00',
                         updateDate = '2024-05-20 09:00:00',
                         loginId = 'user03',
                         loginPw = 'pw_hash4',
                         authLevel = 3,
                         `name` = '박도윤',
                         nickname = '두부의행복전도사',
                         gender = 1,
                         cellphoneNum = '010-3333-4444',
                         delStatus = 0;

INSERT INTO `member` SET
    regDate = '2024-05-22 11:30:00',
                         updateDate = '2024-06-10 15:45:00',
                         loginId = 'user04',
                         loginPw = 'pw_hash5',
                         authLevel = 3,
                         `name` = '최하은',
                         nickname = '뭉치의천사',
                         gender = 0,
                         cellphoneNum = '010-5555-6666',
                         delStatus = 0;

INSERT INTO `member` SET
    regDate = '2024-07-22 12:20:00',
                         updateDate = '2024-08-01 12:40:00',
                         loginId = 'asd',
                         loginPw = 'asd',
                         authLevel = 3,
                         `name` = '유은희',
                         nickname = '꾸미엄마',
                         gender = 0,
                         cellphoneNum = '010-7698-1532',
                         delStatus = 0;


## 반려견 테이블
CREATE TABLE `dog`(
                      id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                      regDate DATETIME NOT NULL COMMENT '생성 날짜',
                      updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                      memberId INT(10) UNSIGNED NOT NULL COMMENT '주인 식별번호',
                      `name` CHAR(20) DEFAULT '이름 없음' COMMENT '이름',
                      weight INT(10) DEFAULT -1 COMMENT '체중 (-1=모름)',
                      photo CHAR(50) NOT NULL COMMENT '사진',
                      `type` CHAR(20) NOT NULL COMMENT '소형, 중형, 대형'

);

INSERT INTO dog SET
    regDate = '2024-01-01 10:00:00',
    updateDate = '2024-01-01 10:00:00',
    memberId = 1,
    weight = 5,
    photo = '/resource/photo/dog1.png',
    `type` = '소형';

INSERT INTO dog SET
    regDate = '2024-02-15 14:30:00',
    updateDate = '2024-02-15 14:30:00',
    memberId = 3,
    `name` = '바둑이',
    photo = '/resource/photo/dog2.png',
    `type` = '중형';

INSERT INTO dog SET
    regDate = '2024-03-20 09:15:00',
    updateDate = '2024-03-20 09:15:00',
    memberId = 5,
    `name` = '뭉치',
    weight = 15,
    photo = '/resource/photo/dog3.png',
    `type` = '대형';

INSERT INTO dog SET
    regDate = '2024-04-25 16:45:00',
    updateDate = '2024-04-25 16:45:00',
    memberId = 6,
    `name` = '꾸미',
    weight = 4,
    photo = '/resource/photo/dog4.png',
    `type` = '소형';

## 게시글 테이블
CREATE TABLE article(
                        id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                        regDate DATETIME NOT NULL COMMENT '작성 날짜',
                        updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                        memberId INT(10) UNSIGNED NOT NULL COMMENT '작성자 식별번호',
                        boardId INT(10) UNSIGNED NOT NULL COMMENT '게시판 식별번호',
                        title CHAR(100) NOT NULL COMMENT '제목',
                        `body` TEXT NOT NULL COMMENT '내용',
                        hitCount INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '조회수'
);

## 게시판 테이블
CREATE TABLE board(
                      id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                      `code` CHAR(100) NOT NULL UNIQUE COMMENT 'notice(공지사항) free(자유) Q&A(질의응답)',
                      `name` CHAR(20) NOT NULL UNIQUE COMMENT '이름'
);

## 리액션(좋아요, 싫어요) 테이블
CREATE TABLE reactionPoint(
                              id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                              regDate DATETIME NOT NULL COMMENT '추천 날짜',
                              updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                              memberId INT(10) UNSIGNED NOT NULL COMMENT '추천자 식별번호',
                              relTypeCode CHAR(20) NOT NULL COMMENT '추천대상 식별코드',
                              relId INT(10) UNSIGNED NOT NULL COMMENT '추천대상 식별번호',
                              `point` INT(10) COMMENT '좋아요, 싫어요 여부'
);

## 댓글 테이블
CREATE TABLE reply (
                       id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                       regDate DATETIME NOT NULL COMMENT '작성 날짜',
                       updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                       memberId INT(10) UNSIGNED NOT NULL COMMENT '작성자 식별번호',
                       relTypeCode CHAR(50) NOT NULL COMMENT '작성대상 식별코드',
                       relId INT(10) UNSIGNED NOT NULL COMMENT '작성대상 식별번호',
                       `body` TEXT NOT NULL COMMENT '내용'
);

## 알람 테이블
CREATE TABLE alarm (
                       id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                       regDate DATETIME NOT NULL COMMENT '생성 날짜',
                       updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                       memberId INT(10) UNSIGNED NOT NULL COMMENT '생성자 식별번호',
                       alarmDate DATE COMMENT '알람이 울릴 날짜',
                       alarmDay ENUM('월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일') COMMENT '알람이 울릴 요일',
                       alarmTime TIME NOT NULL COMMENT '알람이 울릴 시간',
                       CHECK ((alarmDate IS NOT NULL) OR (alarmDay IS NOT NULL))  -- 최소 하나는 NOT NULL
);

## 생필품 테이블
CREATE TABLE essentials (
                            id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                            regDate DATETIME NOT NULL COMMENT '생성 날짜',
                            updateDate DATETIME NOT NULL COMMENT '수정 날짜',
                            memberId INT(10) UNSIGNED NOT NULL COMMENT '생성자 식별번호',
                            itemType CHAR(100) NOT NULL COMMENT '생필품 종류',
                            purchaseDate DATE NOT NULL COMMENT '구매 날짜',
                            usageCycle INT(10) NOT NULL COMMENT '사용주기',
                            timing INT(10) NOT NULL COMMENT '알림 시기'
);

## 약 체크 테이블
CREATE TABLE medicationLog (
                               id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                               regDate DATETIME NOT NULL COMMENT '생성 날짜',
                               memberId INT(10) UNSIGNED NOT NULL COMMENT '사용자 식별번호',
                               medicationDate DATE NOT NULL COMMENT '복용 날짜'
);

##실종 테이블
CREATE TABLE missing(
                        id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '식별번호',
                        memberId INT(10) UNSIGNED NOT NULL COMMENT '신고자 식별번호',
                        `name` CHAR(30) NOT NULL COMMENT '강아지 이름',
                        reportDate DATETIME NOT NULL COMMENT '실종 날짜',
                        missingLocation VARCHAR(100) NOT NULL COMMENT '실종 장소',
                        breed CHAR(30) NOT NULL COMMENT '품종',
                        color CHAR(30) NOT NULL COMMENT '색상',
                        gender CHAR(30) NOT NULL COMMENT '성별',
                        age CHAR(30) NOT NULL COMMENT '나이',
                        photo TEXT NOT NULL COMMENT '사진',
                        RFID CHAR(30) NOT NULL COMMENT '마이크로칩 번호',
                        trait TEXT NOT NULL COMMENT '특징'
);

##건강기록 테이블
CREATE TABLE doghealth(
                          memberId INT(10) UNSIGNED NOT NULL COMMENT 'member번호',
                          dogWeight FLOAT NOT NULL COMMENT '강아지 체중',
                          vaccinationDate DATETIME NOT NULL COMMENT '예방 접종 날짜',
                          checkupDate DATETIME NOT NULL COMMENT '건강 검진 날짜',
                          activityLevel FLOAT NOT NULL COMMENT '활동량(평균걸음수)'
);

## init 끝
##############################################

SELECT * FROM `member`;

SELECT M.*, D.photo extra__dogPoto FROM `member` M LEFT JOIN dog D ON D.memberId = M.id WHERE M.id = 6 LIMIT 1;

SELECT M.nickname, D.name
FROM `member` M
         LEFT JOIN dog D
                   ON D.memberId = M.id;

SELECT * FROM dog;

SELECT * FROM missing;