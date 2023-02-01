-- 추가 기능 : dao method, mapper xml(community.xml)의 id 이름 동일
-- count(*) function의 SQL문 resultType = int


-- 전체 글의 수 : count
SELECT COUNT(*) FROM COMMUNITY c; 

-- idx 최대값 : maxOf -> method는 각각 mapper.xml에 사용
SELECT MAX(idx) FROM COMMUNITY c ;
SELECT MAX(idx) FROM COMMUNITYCOMMENTS c ; 

-- 메인글 : selectByIdx
SELECT * FROM COMMUNITY c 
WHERE idx=3;

-- 메인글의 댓글 목록 : comments
SELECT * FROM COMMUNITYCOMMENTS c 
WHERE MREF=3;


-- 조회수 : setReadCount
UPDATE COMMUNITY 
SET READCOUNT = READCOUNT + 1
WHERE idx = 3;

-- 메인글 댓글 수 : commentsCount
SELECT COUNT(*) FROM COMMUNITYCOMMENTS c 
WHERE MREF=3; 

-- 댓글 개수 UPDATE (댓글 추가, 삭제 시 필요) : setCommentCount
UPDATE COMMUNITY 
SET COMMENTCOUNT =
	(SELECT COUNT(*) FROM COMMUNITYCOMMENTS c WHERE MREF=3)
WHERE IDX=3;

-- 댓글 삭제 - idx
DELETE FROM COMMUNITYCOMMENTS c 
WHERE IDX=2;