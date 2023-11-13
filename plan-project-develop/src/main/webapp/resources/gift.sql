
create table gift(
    category1 VARCHAR2(50) NOT NULL,
    category2 VARCHAR2(50) NOT NULL,
    item_name VARCHAR2(100) NOT NULL,
    item_price int not null,
    item_image VARCHAR2(255)
);

drop table gift;

select * from gift;