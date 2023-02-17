--init guest data for test
INSERT INTO guesttable
(name, room_num,age,gender,check_in_date,check_out_date)
VALUES
( 'Test1',202,36,'0','2023-02-16','2023-02-21'),
( '高橋 誠',303,40,'1','2023-02-23','2023-02-25'),
( '松野 学',206,6,'2','2023-02-19','2023-02-27'),
( '大谷 竜也',401,1,'1','2023-02-01','2023-02-28')
;


INSERT INTO roomtable
(room_num, floor,room_type,room_capacity,is_available)
VALUES
--6 single rooms on Floor 2
( 201,2,'Single',1,true),
( 202,2,'Single',1,true),
( 203,2,'Single',1,true),
( 204,2,'Single',1,true),
( 205,2,'Single',1,true),
( 206,2,'Single',1,true),

--4 double rooms on Floor 3
( 301,3,'Double',2,true),
( 302,3,'Double',2,true),
( 303,3,'Double',2,true),
( 304,3,'Double',2,true),

--4 twin rooms on Floor4
( 401,4,'Twin',2,true),
( 402,4,'Twin',2,true),
( 403,4,'Twin',2,true),
( 404,4,'Twin',2,true)
;
