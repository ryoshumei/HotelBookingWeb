-- init guest data for test

INSERT INTO guest_table
(name, age, gender)
VALUES
    ('Test1', 36, 0),
    ('高橋 誠', 40, 1),
    ('松野 学', 6, 2),
    ('大谷 竜也', 1, 1)
;

INSERT INTO introduction_table(content)
VALUES
('This is a single room, perfect for solo travelers. It includes a cozy bed, workspace, and flat-screen TV. The modern en-suite bathroom is stocked with complimentary toiletries. Additional conveniences are a tea and coffee setup, and a mini fridge. This room is a compact haven, providing the essentials for a comfortable stay'),
('This is a double room, a spacious sanctuary designed for two. It boasts a large double bed or two single beds for ultimate relaxation. Features include a modern desk for any work-related tasks, a flat-screen TV for entertainment, and a mini fridge for refreshments. The stylish en-suite bathroom comes with premium toiletries. With comfort and convenience at its core, this room embodies the ideal setting for a shared journey.'),
('This is a twin room, thoughtfully designed to accommodate two guests. Each room features two separate single beds ensuring personal space and comfort. In-room facilities include a work desk, a flat-screen TV for leisure, and a mini fridge. The modern en-suite bathroom provides premium toiletries. The twin room is the epitome of comfort for friends or colleagues traveling together.')
;

INSERT INTO room_table (introduction_id, room_num, floor, price, room_type, room_capacity, is_available)
VALUES
(1, 201, 2, 6000, 'Single', 1, true),
(1, 202, 2, 6000, 'Single', 1, true),
(1, 203, 2, 6000, 'Single', 1, true),
(1, 204, 2, 6000, 'Single', 1, true),
(1, 205, 2, 6000, 'Single', 1, true),
(1, 206, 2, 6000, 'Single', 1, true),

-- 4 double rooms on Floor 3
(2, 301, 3, 8000, 'Double', 2, true),
(2, 302, 3, 8000, 'Double', 2, true),
(2, 303, 3, 8000, 'Double', 2, true),
(2, 304, 3, 8000, 'Double', 2, true),

-- 4 twin rooms on Floor4
(3, 401, 4, 8000, 'Twin', 2, true),
(3, 402, 4, 8000, 'Twin', 2, true),
(3, 403, 4, 8000, 'Twin', 2, true),
(3, 404, 4, 8000, 'Twin', 2, true)
;

INSERT INTO order_table
(guest_id, room_id, payment, price, check_in_date, check_out_date)
VALUES
    (1, 1, 'paid', 6000, '2023-07-10', '2023-07-20'),
    (2, 3, 'unpaid', 6000, '2023-07-20', '2023-07-25'),
    (3, 7, 'paid', 8000, '2023-07-19', '2023-07-27'),
    (4, 4, 'unpaid', 6000, '2023-08-01', '2023-08-05')
;

INSERT INTO admin_table
(admin_id, password, role)
VALUES
    ('test1', '$2a$10$gvVycTto9jDbcjtLt63wLe/rdUsCs4KsLcRpgq10YaVnQ7aO/eNYi','ADMIN'), -- password is 'test1'
    ('test2','$2a$10$NIyt6w1JECx9kLHQTaNnc.IOPpE./OrHh4UEaevyyZO04/N1Ibw.y','ADMIN')  -- password is 'test2'
;



