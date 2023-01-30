-- 메인글 테이블
CREATE TABLE COMMUNITY
(
	IDX NUMBER(10) NOT NULL,	
	WRITER VARCHAR2(50) NOT NULL,			-- 작성자 (로그인 계정 정보 등)
	TITLE VARCHAR2(100) NOT NULL,			-- 글제목
	CONTENT VARCHAR2(3000) NOT NULL,		-- 글 내용
	READCOUNT NUMBER(10) DEFAULT '0',		-- 조회수
	CREATEDAT DATE DEFAULT SYSDATE,			-- 작성날짜와 시간 기본값
	IP VARCHAR2(15) DEFAULT '127.0.0.1',	-- 작성자 IP
	COMMENTCOUNT NUMBER(10) DEFAULT '0',	-- 댓글 갯수
	PRIMARY KEY(IDX)
);

CREATE SEQUENCE COMMUNITY_IDX_SEQ;

-- 댓글 테이블
CREATE TABLE COMMUNITYCOMMENTS
(
	IDX NUMBER(10) NOT NULL,					-- 기본키
	MREF NUMBER(10) NOT NULL,				-- COMMUNITY 테이블의 IDX
	WRITER VARCHAR2(50) NOT NULL,			-- 작성자
	CONTENT VARCHAR2(1000) NOT NULL,		-- 댓글 내용
	CREATEDAT DATE DEFAULT SYSDATE,			-- 작성날짜와 시간 기본값
	IP VARCHAR2(15) DEFAULT '127.0.0.1',	-- 작성자 IP
	HEART NUMBER(3) DEFAULT '0',			-- 종아요 갯수
	PRIMARY KEY(IDX)
);

CREATE SEQUENCE COMMENT_IDX_SEQ;

-- 데이터 샘플 추가
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '김모모','알립니다.','오늘 모임 변경안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '최사나','공지','공지공지');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '박세리','하이','하이하이!!');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '김땡땡','이벤트','이벤트 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '강감찬','재공지','재공지재공지');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공55지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공66지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공77지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공88지','정회원 안내입니다.');

SELECT * FROM community f ;

-- 댓글 테이블 데이터
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,3,'이하니','이글은 메인글 3번 댓글~');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,3,'김땡땡','이글은 메인글 3번 댓글~2');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,1,'이하니','이글은 메인글 333번 댓글~');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,9,'김땡땡','이글은 메인글 333번 댓글~2');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,9,'김땡땡','하이!!!하이~~');
