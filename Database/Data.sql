use Tecknic;
go
insert into [Role](Name) values ('Member');
insert into [Role](Name) values ('Colaborator');
insert into [Role](Name) values ('Moderator');
insert into [Role](Name) values ('Administrator');
insert into [Role](Name) values ('Banned Member');

insert into [Status](Name) values ('draft');
insert into [Status](Name) values ('reviewing');
insert into [Status](Name) values ('posted');
insert into [Status](Name) values ('reject');
insert into [Status](Name) values ('remove');

insert into [Tag](Name) values ('Laptop');
insert into [Tag](Name) values ('Điện thoại');
insert into [Tag](Name) values ('Khác');
go

insert into [User](Username, [Password], Name, Gender, Email, RoleId) values ('admin','admin','Mai Đức Thắng', 'M', 'tknadmin@gmail.com', 4)
insert into [User](Username, [Password], Name, Gender, Email, RoleId) values ('trung3d','trung3d','Trung Ba Đê', 'O', 'trung3d@gmail.com', 3)
insert into [User](Username, [Password], Name, Gender, Email, RoleId) values ('hoanhtungxy','hoanhtungxy','Võ Thanh Tung', 'M', 'tungxy@gmail.com', 2)