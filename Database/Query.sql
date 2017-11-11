use Tecknic

select * from [Role]
select * from [User]
select * from [Status]
select * from Article
select Name from [Role] where Id = (select RoleId from [User] where Username = '' and [Password] = '');

select [User].Name, [User].[Password], [User].Avatar, [Role].Name
from [User] inner join [Role] on [User].RoleId = [Role].Id
where Username = 'admin' and [Password] = 'admin'

select A.Id, A.Title, A.CreateTime, S.Name
from Article A inner join [Status] S on A.StatusId = S.Id
where S.Name = 'draft' or S.Name = 'reviewing'

select a.Id, a.Title, SUBSTRING(a.Content,0,1000), a.CoverImage, a.ModifyTime, a.NumOfView, u.Id, u.Name, u.Avatar 
from  Article a inner join [User] u on a.CreatorId = u.Id 
where a.StatusId = (Select Id from [Status] where name = 'posted') and
		a.Id in (select ArticleId from ArticleTag where TagId = 3)
order by ModifyTime desc
OFFSET 0 ROWS
FETCH NEXT 10 ROWS ONLY;

select count(Id) as Amount from Comment where ArticleId = 27


select top 5 Id, Title, CoverImage 
from article where ModifyTime between '2017-11-1 00:00:00' and  '2017-11-15 00:00:00'
order by NumOfView desc, ModifyTime asc