insert into user(name ,surname,email,password) values('Kanan','Ahmadli','kanan.akhmadli99@gmail.com','$2a$12$oI9riH8qcl/yfWCQ1.Gwauzbo2XsYeI22aDURaSzxEAA1Hh9FSjTa');
insert into user(name ,surname,email,password) values('Taleh','Qasimli','taleh.qasimli@gmail.com','$2a$12$oI9riH8qcl/yfWCQ1.Gwauzbo2XsYeI22aDURaSzxEAA1Hh9FSjTa');

-- insert into skill(name) values ('Java');
-- insert into skill(name) values ('PYTHON');
-- insert into skill(name) values ('PHP');

-- insert into user_skill(user_id,skill_id) values (1,1);
-- insert into user_skill(user_id,skill_id) values (1,2);
-- insert into user_skill(user_id,skill_id) values (2,3;

insert into role(name) values ('DELETE');
insert into role(name) values ('UPDATE');
insert into role(name) values ('SELECT');

insert into my_group(name) values ('ADMIN');
insert into my_group(name) values ('USER');
insert into my_group(name) values ('MODERATOR');

insert into group_role( my_groups_id,role_id) values (1,1);
insert into group_role( my_groups_id,role_id) values (1,2);
insert into group_role( my_groups_id,role_id) values (1,3);
insert into group_role( my_groups_id,role_id) values (2,3);
insert into group_role( my_groups_id,role_id) values (3,3);
insert into group_role( my_groups_id,role_id) values (3,2);

insert into group_user(group_id,user_id) values(1,1);
insert into group_user(group_id,user_id) values(2,1);
insert into group_user(group_id,user_id) values(2,2);