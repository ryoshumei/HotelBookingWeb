-- if exist, then delete
DROP TABLE IF EXISTS guest_table;
DROP TABLE IF EXISTS room_table;
DROP TABLE IF EXISTS admin_table;
DROP TABLE IF EXISTS order_table;

-- create new guest_table if not exist
CREATE TABLE IF NOT EXISTS guest_table
(
    id             INT AUTO_INCREMENT,
    name           VARCHAR(50) NOT NULL,
    room_num       INT         NOT NULL,
    age            INT         NOT NULL,
    gender         INT         NOT NULL,
    check_in_date  DATE        NOT NULL,
    check_out_date DATE        NOT NULL,
    PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS room_table
(
    id            INT AUTO_INCREMENT,
    room_num      INT NOT NULL,
    floor         INT NOT NULL,
    room_type     VARCHAR(50),
    room_capacity INT NOT NULL,
    is_available  BOOLEAN,
    PRIMARY KEY (id)
-- todo : Add a fk indicate guest_table.id many to many

);

CREATE TABLE IF NOT EXISTS admin_table
(
    id       INT AUTO_INCREMENT,
    admin_id VARCHAR(256) NOT NULL, -- ID for login
    password VARCHAR(128) NOT NULL, -- Hashed password
    role     VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);


