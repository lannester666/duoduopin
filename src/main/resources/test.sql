INSERT INTO share_bill (`user_id`, `title`, `type`, `description`, `address`, `time`, `cur_people`, `max_people`,
                        `price`, `longitude`,
                        `latitude`, `geohash`)
VALUES (1, '首都机场T2拼车', 'CAR', '1月1日早上首都机场T2航站楼拼车，11点的飞机，8点半以前出发都可以', '北京邮电大学西门', '2021-01-01 16:00:00', 2, 3,
        23.00, 32, 20, 'sewcb0vsqn1');

INSERT INTO team_member (`bill_id`, `user_id`)
VALUES (1, 1);
