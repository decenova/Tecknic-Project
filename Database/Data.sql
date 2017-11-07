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

insert into [Tag](Name) values (N'Laptop');
insert into [Tag](Name) values (N'Điện thoại');
insert into [Tag](Name) values (N'Khác');
go

--delete from [User]

insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('admin','admin',N'Mai Đức Thắng', 'img/avatar01.jpg', '2017-01-01' , 'M', 'tknadmin@gmail.com', 4)
insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('trung3d','trung3d',N'Trung Ba Đê', null, '2017-01-01' , 'O', 'trung3d@gmail.com', 3)
insert into [User](Username, [Password], Name, Avatar, DateOfJoin, Gender, Email, RoleId) values ('hoanhtungxy','hoanhtungxy',N'Võ Thanh Tung', null, '2017-01-01' ,'M', 'tungxy@gmail.com', 2)

insert into [User](Username,[Password],Name,Gender,DateOfBirth,DateOfJoin,Email,PhoneNum,Address,RoleId) 
values ('user02','user02',N'Người dùng','M',null,'2017-01-01','user02@gmail.com',null,'',1)
--insert into BanLog(BannedUserId,ExRole,ModId,BanTime,Reason) values()
--delete from Article 

insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Đâylàbàiviếtđầutiêncủachúngtôi',N'Hãy nói theo cách của bạn và tính loc theo cách của chúng tôi', 'img/cover01.jpg', '2017-10-26 09:53:57.927', 1, '2017-10-26 20:53:57.927', 1, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Đây là bài viết đầu tiên của chúng tôi',N'Hãy nói theo cách của bạn và tính loc theo cách của chúng tôi', 'img/cover01.jpg', '2017-10-26 09:53:57.927', 1, '2017-10-26 20:53:57.927', 1, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Chẳng thể kể hết những nỗ lực này',N'Những ngày Over Time vẫn tiếp tục', 'img/cover02.jpg', '2017-10-26 10:53:57.927', 2, '2017-10-26 19:53:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Có những lúc trong đầu nảy ra những con số',N'Nhưng chúng không phải là 6 cặp số cuộc đời', 'img/cover01.jpg', '2017-10-26 10:59:57.927', 3, '2017-10-26 18:59:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Chúng tôi lại quay lại tháng ngày fix bug',N'Nhìn vào màu đỏ trên màn mình cũng đủ làm tim tôi ngừng đập', 'img/cover02.jpg', '2017-10-26 11:00:57.927', 1, '2017-10-26 17:00:57.927', 1, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Có những con bug có thể tìm cách diệt dễ dàng',N'Nhưng có những con mà lần đầu tiên xuất hiện trong lịch sử nhân loại', 'img/cover01.jpg', '2017-10-26 11:01:57.927', 1, '2017-10-26 16:02:57.927', 1, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và bạn tự hỏi tại sao những bài báo này vẫn tiếp diễn',N'Vì sự than thở qua ngôn từ giúp chúng tôi dễ thở hơn', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 3, '2017-10-26 15:07:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 14:08:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 13:09:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 12:10:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 11:11:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 10:15:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 09:16:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 08:20:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 07:21:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 06:22:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 05:26:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 04:27:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 03:28:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 02:29:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 01:30:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-26 00:31:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-25 23:32:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-25 22:33:57.927', 2, 3)
insert into Article(Title,Content,CoverImage,CreateTime,CreatorId,ModifyTime,ModifierId,StatusId)
values (N'Và vì nhiều bài như thế này thì mới có thể test được',N'Mục tiêu chính chỉ là test thôi', 'img/cover02.jpg', '2017-10-26 11:05:57.927', 1, '2017-10-25 21:34:57.927', 2, 3)
