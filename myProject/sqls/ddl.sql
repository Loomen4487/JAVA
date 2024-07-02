DROP TABLE landuse
;

CREATE TABLE landuse(
	seq				NUMBER				PRIMARY KEY,	-- 순번
	street 			varchar2(100)		NOT NULL,		-- 지번
	address			varchar2(100)		NOT NULL,    	-- 주소, 지목, 면적
	category		varchar2(100)		NOT NULL,
	area 			NUMBER						,		
	price			NUMBER								-- 가격 현시간 나오면서 가격대 나옴
);

COMMENT ON COLUMN landuse.seq IS '번호';
COMMENT ON COLUMN landuse.street IS '지번';
COMMENT ON COLUMN landuse.address IS '주소';
COMMENT ON COLUMN landuse.category IS '지목';
COMMENT ON COLUMN landuse.area IS '면적';
COMMENT ON COLUMN landuse.price IS '가격';

CREATE SEQUENCE seq_landuse_No
		INCREMENT BY 1 
	    START WITH 1
;

CREATE TABLE landmemeber(
	member_seq		NUMBER			NOT NULL,	-- 순번
	member_id		varchar2(100)	NOT NULL,	-- 아이디
	member_pw		varchar2(100)	NOT NULL,	-- 패스워드
	memeber_name	varchar2(100)	NOT NULL,	-- 이름
	member_phone	NUMBER,						-- 전화번호
	landuse_seq		NUMBER						-- landuse랑 이어지게 하는 테이블
);

CREATE SEQUENCE seq_memberuse_No
		INCREMENT BY 1 
	    START WITH 1
;