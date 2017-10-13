use Tecknic

select * from [Role]
select * from [User]
select * from [Status]

select Name from [Role] where Id = (select RoleId from [User] where Username = '' and [Password] = '');

select [User].Name, [User].[Password], [User].Avatar, [Role].Name
from [User] inner join [Role] on [User].RoleId = [Role].Id
where Username = 'admin' and [Password] = 'admin'