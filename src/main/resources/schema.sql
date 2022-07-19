USE lib;

create table book
(
    id integer not null AUTO_INCREMENT,
    isbn varchar(255) not null,
    title varchar(255) not null,
    author varchar(255) not null,
    book_desc varchar(255) not null,
    genre varchar(255) not null,
    primary key(id)
);

# insert into book values (1 , '0-000-0000-0', 'Programming 1', 'Janus Tan', 'This is my description', 'Programming');
# insert into book values (2, '0-000-0000-0', 'Programming 1', 'Janus Tan', 'This is my description', 'Programming');
# insert into book values (3, '0-000-0000-0', 'Programming 1', 'Janus Tan', 'This is my description', 'Programming');
# select * from book;