use Tecknic;
go
insert into [Role](Name) values ('Member');
insert into [Role](Name) values ('Colaborator');
insert into [Role](Name) values ('Moderator');
insert into [Role](Name) values ('Administrator');
insert into [Role](Name) values ('Banned Member');

insert into [Status](Name) values ('submited');
insert into [Status](Name) values ('reviewing');
insert into [Status](Name) values ('posted');
insert into [Status](Name) values ('reject');
insert into [Status](Name) values ('remove');

insert into [Tag](Name) values ('Laptop');
insert into [Tag](Name) values ('Điện thoại');
insert into [Tag](Name) values ('Khác');
go

--delete from [User]

insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('admin','admin',N'Mai Đức Thắng', 'img/avatar01.jpg', '2017-01-01' , 'M', 'tknadmin@gmail.com', 4)
insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('trung3d','trung3d',N'Trung Ba Đê', null, '2017-01-01' , 'O', 'trung3d@gmail.com', 3)
insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('hoanhtungxy','hoanhtungxy',N'Võ Thanh Tung', null, '2017-01-01' ,'M', 'tungxy@gmail.com', 2)


--insert into BanLog(BannedUserId,ExRole,ModId,BanTime,Reason) values()