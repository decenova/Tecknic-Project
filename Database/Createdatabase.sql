create database Tecknic
go
use Tecknic
go

create table [Role] (
	Id int primary key identity,
	Name nvarchar(20) not null unique
)
create table [Status] (
	Id int primary key identity,
	Name nvarchar(20) not null unique
)
create table Tag (
	Id int primary key identity,
	Name nvarchar(40) not null unique
)
go
create table [User] (
	Id int primary key identity,
	Username varchar(40) not null unique,
	[Password] varchar(20) not null,
	Name nvarchar(100) not null,
	Avatar varchar(100),
	Gender char(1) not null check (Gender in ('M','F','O')),
	DateOfBirth datetime,
	DateOfJoin datetime,
	Email varchar(100) not null,
	PhoneNum varchar(20),
	[Address] nvarchar(200),
	RoleId int not null,
	constraint FK_USER_ROLE foreign key (RoleId) references [Role](Id)
)
go
create table BanLog(
	Id int primary key identity,
	BannedUserId int not null,
	ExRole int not null,
	ModId int not null,
	BanTime datetime not null,
	Reason nvarchar(200),
	constraint FK_BANLOG_USER_BAN foreign key (BannedUserId) references [User](Id),
	constraint FK_BANLOG_USER_MOD foreign key (ModId) references [User](Id),
	constraint FK_BANLOG_ROLE foreign key (ExRole) references [Role](Id)
)
create table Article(
	Id int primary key identity,
	Title nvarchar(500) not null,
	Content nvarchar(2500) not null,
	CoverImage varchar(200) not null,
	CreateTime datetime not null,
	CreatorId int not null,
	ModifyTime datetime not null,
	ModifierId int,
	StatusId int not null,
	Reason nvarchar(200),
	NumOfView int default 0,
	Constraint FK_ARTICLE_USER_CREATOR foreign key (CreatorId) references [User](Id),
	Constraint FK_ARTICLE_USER_MODIFIER foreign key (ModifierId) references [User](Id),
	Constraint FK_ARTICLE_STATUS foreign key (StatusId) references [Status](Id)
)
go
create table Comment(
	Id int primary key identity,
	UserId int not null,
	ArticleId int not null,
	Content nvarchar(500) not null,
	CreateTime datetime not null,
	[Status] bit default 0,
	Constraint FK_COMMENT_USER foreign key (UserId) references [User](Id),
	Constraint FK_COMMENT_ARTICLE foreign key (ArticleId) references [Article](Id)
)

create table ArticleTag(
	Id int primary key identity,
	ArticleId int not null,
	TagId int not null,
	Constraint FK_ARTICLETAG_ARTICLE foreign key (ArticleId) references [Article](Id),
	Constraint FK_ARTICLETAG_TAG foreign key (TagId) references [Tag](Id)
)