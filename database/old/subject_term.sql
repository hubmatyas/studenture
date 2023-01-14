create table subject_term
(
    id           bigint unsigned auto_increment
        primary key,
    subjectId    bigint                          not null,
    academicYear varchar(20) default '2022/2023' null,
    semester     ENUM ('ZS', 'LS')               null,
    constraint "subject_term_`subject`_`id`_fk"
        foreign key (id) references subject (id)
)
    engine = InnoDB
    collate = utf8mb4_0900_ai_ci;

