create table profiles
(
    id  bigint primary key,
    bio text,
    phone_number varchar(15),
    date_of_birth date,
    loyalty_points int default 0,
    foreign key (id) references user (id)
)