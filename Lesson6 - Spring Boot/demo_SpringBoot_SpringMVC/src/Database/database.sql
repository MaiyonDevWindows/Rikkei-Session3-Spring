drop schema if exists demo_springboot_springmvc;
create schema if not exists demo_springboot_springmvc;
use demo_springBoot_springMVC;

-- Database create first.


insert into category
    values (1, 'Quần', 1),
           (2, 'Áo', 1),
            (3, 'Giày', 0);

select * from category;