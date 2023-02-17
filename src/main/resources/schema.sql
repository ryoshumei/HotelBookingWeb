--if exist, then delete
DROP TABLE IF EXISTS guesttable;
DROP TABLE IF EXISTS roomtable;

--create new guesttable if not exist
CREATE TABLE IF NOT EXISTS guesttable(
id INT AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
room_num INT NOT NULL,
age INT NOT NULL,
gender INT NOT NULL,
check_in_date DATE NOT NULL,
check_out_date DATE NOT NULL,
PRIMARY KEY(id)
);

--create new roomtable if not exist

CREATE TABLE IF NOT EXISTS roomtable(
id INT AUTO_INCREMENT,
room_num INT NOT NULL,
floor INT NOT NULL,
room_type VARCHAR(50),
room_capacity INT NOT NULL,
is_available BOOLEAN,
PRIMARY KEY(id)
);


