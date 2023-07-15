-- if exist, then delete
DROP TABLE IF EXISTS guest_table;
DROP TABLE IF EXISTS room_table;
DROP TABLE IF EXISTS admin_table;
DROP TABLE IF EXISTS order_table;

-- create new guest_table if not exist
CREATE TABLE guest_table
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255),
    age    INT,
    gender INT
);

CREATE TABLE room_table
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    room_num      INT,
    floor         INT,
    price         INT,
    room_type     VARCHAR(255),
    room_capacity INT,
    is_available  BOOLEAN
);

CREATE TABLE order_table
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    guest_id       INT,
    room_id        INT,
    payment        ENUM ('paid', 'unpaid'),
    price          INT,
    check_in_date  DATE,
    check_out_date DATE,
    FOREIGN KEY (guest_id) REFERENCES guest_table (id),
    FOREIGN KEY (room_id) REFERENCES room_table (id)
);

CREATE TABLE admin_table
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    admin_id VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(255)
);


