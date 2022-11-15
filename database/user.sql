create table user
(
    user_id  bigint unsigned auto_increment
        primary key,
    name     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null,
    email    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null,
    password varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null,
    constraint email
        unique (email)
)
    engine = InnoDB
    collate = utf8mb4_0900_ai_ci;

