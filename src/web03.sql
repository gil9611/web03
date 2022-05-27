--board
create table board(
seq number primary key,
title varchar(100) not null,
nickname varchar(30) not null,
note varchar(800) not null,
indate date,
visited number
);

insert into board values(1, '더미1', '관리자', '더미1입니다.', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '더미2', '관리자', '내용 없음.', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '더미3', '관리자', '샘플 내용', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '더미4', '관리자', '아무거나 쓰기', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '더미5', '관리자', '관리자가 되는법', sysdate, 0);

--update
update board set title=?, note=?, indate=sysdate where seq=?
--delete
delete from board where seq=?

--member
create table member(
mid varchar(12) primary key,
mpw varchar(20) not null,
mname varchar(30) not null,
maddress varchar(100),
mlank number,
mpoint number
);

insert into member values('admin', '5555', '관리자', '관리시 관리동', 1, 10000);
insert into member values('dodo', '1234', '도도', '도도시 도도도', 9, 100);


commit;