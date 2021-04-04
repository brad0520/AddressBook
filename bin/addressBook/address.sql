# 기존에 t1 데이터베이스가 존재 한다면 삭제
DROP DATABASE  addr;

# 새 데이터베이스(`addr`) 생성
CREATE DATABASE addr;
USE addr;

# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE addr (
id INT(5)  UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`name` CHAR(30) NOT NULL,
address CHAR(50) NOT NULL,
phoneNumber CHAR(13) NOT NULL,
regDate DATETIME NOT NULL
);

# 테스트 데이터 추가

INSERT INTO addr
SET `name` = '홍길동',
address = '대전',
phoneNumber = '01012345678'
regDate = NOW();

INSERT INTO addr
SET `name` = '홍길순',
address = '서울',
phoneNumber = '01012341234'
regDate = NOW();

INSERT INTO addr
SET `name` = '임꺽정',
address = '부산',
phoneNumber = '01065455678'
regDate = NOW();

INSERT INTO Addr
SET `name` = '김철수',
address = '대구',
phoneNumber = '01013468954'
regDate = NOW();

INSERT INTO Addr
SET `name` = '이아름',
address = '광주',
phoneNumber = '01034527855'
regDate = NOW();

DESC addr;

SELECT * 
FROM addr;

