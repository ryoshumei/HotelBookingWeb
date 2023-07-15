-- init guest data for test

INSERT INTO guest_table
(name, room_num,age,gender,check_in_date,check_out_date)
VALUES
    ( 'Test1',202,36,'0','2023-07-10','2023-07-20'),
    ( '高橋 誠',303,40,'1','2023-07-20','2023-07-25'),
    ( '松野 学',206,6,'2','2023-07-19','2023-07-27'),
    ( '大谷 竜也',401,1,'1','2023-08-01','2023-08-05')
;

INSERT INTO room_table (room_num, floor, price, room_type, room_capacity, is_available)
VALUES
( 201,2,8000,'Single',1,true),
( 202,2,8000,'Single',1,true),
( 203,2,8000,'Single',1,true),
( 204,2,8000,'Single',1,true),
( 205,2,8000,'Single',1,true),
( 206,2,8000,'Single',1,true),

-- 4 double rooms on Floor 3
( 301,3,8000,'Double',2,true),
( 302,3,8000,'Double',2,true),
( 303,3,8000,'Double',2,true),
( 304,3,8000,'Double',2,true),

-- 4 twin rooms on Floor4
( 401,4,8000,'Twin',2,true),
( 402,4,8000,'Twin',2,true),
( 403,4,8000,'Twin',2,true),
( 404,4,8000,'Twin',2,true)
;


INSERT INTO admin_table
(admin_id, password, role)
VALUES
    ('test1', '$2a$10$gvVycTto9jDbcjtLt63wLe/rdUsCs4KsLcRpgq10YaVnQ7aO/eNYi','ADMIN'), -- password is 'test1'
    ('test2','$2a$10$NIyt6w1JECx9kLHQTaNnc.IOPpE./OrHh4UEaevyyZO04/N1Ibw.y','ADMIN')  -- password is 'test2'
;



