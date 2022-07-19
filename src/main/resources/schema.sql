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

# insert into book values (1 , '6-543-1798-5', 'Programming 1', 'Janus Tan', 'This is my description1', 'Programming');
# insert into book values (2, '1-123-3456-3', 'Data Structure', 'Janus Tan', 'This is my description2', 'Programming');
# insert into book values (3, '7-645-7723-4', 'Human Computer Interaction', 'Janus Tan', 'This is my description3', 'Programming');
# select * from book;