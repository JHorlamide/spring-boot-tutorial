alter table user
drop column state;

alter table addresses
    add state varchar(255) not null;
