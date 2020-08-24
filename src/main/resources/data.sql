insert into role (role)
values ('trainer'), ('member');

insert into category (category)
values ('performance'), ('physique'), ('fitness');

insert into user (first_name, last_name, username, password, email, role_id, category_id)
values  ('member1', 'lastName1', 'username1', 'password1', 'email1', 2, 1),
		('member2', 'lastName2', 'username2', 'password2', 'email2', 2, 2),
		('trainer1', 'TlastName1', 'Tusername1', 'Tpassword1', 'Temail1', 1, 1),
		('trainer2', 'TlastName2', 'Tusername2', 'Tpassword2', 'Temail2', 1, 2);
		
insert into post (content, media, posted_date, author_id, saved_by_id)
values  ('this is post 1', 'this is pic1', '2020-08-20', 3, 1),
		('this is post 2', 'this is pic2', '2020-08-21', 3, 1),
		('this is post 3', 'this is pic3', '2020-08-23', 3, 1),
		('this is post 4', 'this is pic4', '2020-08-28', 4, 2),
		('this is post 5', 'this is pic5', '2020-08-30', 4, 2);
		
insert into comment (author_id, content, date, post_id)
values	(1, 'this is comment 1 on post 1', '2020-08-20', 1),
		(2, 'this is comment 2 on post 1', '2020-08-20', 1),
		(1, 'this is comment 1 on post 2', '2020-08-20', 2),
		(2, 'this is comment 2 on post 2', '2020-08-20', 2),
		(1, 'this is comment 3 on post 2', '2020-08-20', 2),
		(2, 'this is comment 4 on post 2', '2020-08-20', 2),
		(3, 'this is comment 5 on post 2', '2020-08-20', 2);