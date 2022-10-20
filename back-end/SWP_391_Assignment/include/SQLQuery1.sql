CREATE TABLE [Role] (
	RoleID INT IDENTITY(1, 1) PRIMARY KEY,
	[Name] varchar(50) UNIQUE,
);

CREATE TABLE Account (
	AccountID INT IDENTITY(1, 1) PRIMARY KEY,
	[Password] VARCHAR(128) NOT NULL,
	Username VARCHAR(255) NOT NULL,
	Email VARCHAR(255) NOT NULL UNIQUE,
	RoleID INT NOT NULL,
	[Status] INT NOT NULL DEFAULT 1,
	CONSTRAINT FK_Account_Role_RoleID FOREIGN KEY (RoleID) REFERENCES [Role](RoleID)
);

create table Blog (
	BlogID int identity(1, 1) primary key,
	Title varchar(200),
	[Description] text,
	Content text,
	CreatedDate date,
	AuthorID int,
	Display BIT NOT NULL,
	ThumbnailUrl varchar(3000),
	NumberOfView INT NOT NULL DEFAULT 0 CHECK(NumberOfView >= 0),
	CONSTRAINT FK_Blog_Account_AccountID FOREIGN KEY (AuthorID) REFERENCES Account(AccountID) ON DELETE SET NULL
);

DROP TABLE [Role]
DROP TABLE [Account]
DROP TABLE Blog

INSERT INTO [Role] ([Name])
VALUES ('admin'),('user'),('staff');

UPDATE Blog SET CreatedDate = GETDATE() WHERE BlogID = 4;

INSERT INTO Account ([Password], Username, Email, RoleID)
VALUES ('12345678', 'hadt', 'hadthe163630@fpt.edu.vn', 1),
	   ('12345678', 'quangnh', 'quangnh167678@fpt.edu.vn', 2),
	   ('12345678', 'thanht', 'thanht168184@fpt.edu.vn', 2),
	   ('12345678', 'tunglm', 'tunglm156787@fpt.edu.vn', 3),
	   ('12345678', 'hieuht', 'hieuht167778@fpt.edu.vn', 3)

INSERT INTO Blog (Title, [Description], Content, CreatedDate, AuthorID, Display, ThumbnailUrl, NumberOfView)
VALUES 
('Trending online courses and degrees in business and tech','With more world-class content launching every week, there are always new topics to explores, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to...','With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?','2022-10-19',1,1,'https://image.shutterstock.com/image-illustration/collection-abstract-watercolor-green-tree-600w-1937191438.jpg',1000),
('Trending online courses and degrees in business and tech','With more world-class content launching every week, there are always new topics to explores, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to...','With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?','2022-10-19',1,1,'https://image.shutterstock.com/image-illustration/collection-abstract-watercolor-green-tree-600w-1937191438.jpg',2000),
('Trending online courses and degrees in business and tech','With more world-class content launching every week, there are always new topics to explores, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to...','With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?','2022-10-19',1,1,'https://image.shutterstock.com/image-illustration/collection-abstract-watercolor-green-tree-600w-1937191438.jpg',3000),
('Trending online courses and degrees in business and tech','With more world-class content launching every week, there are always new topics to explores, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to...','With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?

With more world-class content launching every week, there are always new topics to explore, new skills to learn, and new ways to achieve your goals. These latest courses, Specializations, and Professional Certificate programs cover everything from developing your own paid advertising campaign and building a high-performing team to creating machine learning-powered projects to add to your portfolio. What will you learn next?','2022-10-19',1,1,'https://image.shutterstock.com/image-illustration/collection-abstract-watercolor-green-tree-600w-1937191438.jpg',4000);

SELECT a.AccountID as id, a.Email as email, r.[Name] as role  FROM
Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID
WHERE a.Email = 'hadthe163630@fpt.edu.vn' and a.[Password] = '12345678';

SELECT b.BlogID, b.Title, b.[Description], b.CreatedDate, b.NumberOfView  FROM Blog b;

SELECT b.BlogID, b.Title, b.[Description], b.CreatedDate, b.NumberOfView, b.Content, b.ThumbnailUrl  FROM Blog b
WHERE b.BlogID = 3;

SELECT a.AccountID as id, a.Email as email, r.[Name] as role, a.Username as username, a.[Status] as [status]  FROM
Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID