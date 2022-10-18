CREATE TABLE QuizList (
	QuizID INT PRIMARY KEY,
	[Name] [varchar](50) NULL,
	[Description] TEXT,
	[QuizTimeInMinute] INT DEFAULT(5),
	[SubjectID] [int] NULL,
	[TotalQuestion] [int] NULL,
);



INSERT [dbo].QuizList ([QuizID], [Name], [Description], [QuizTimeInMinute], [SubjectID], [TotalQuestion])
VALUES (1, N'HTML Basics Quiz 1',N'The quiz below tests your knowledge of the material learnt in HTML', 30, 1, 30)
INSERT [dbo].QuizList ([QuizID], [Name], [Description], [QuizTimeInMinute], [SubjectID], [TotalQuestion])
VALUES (2, N'HTML Intermediate Quiz 1',N'The quiz below tests your knowledge of the material learnt in HTML', 30, 2, 30)
INSERT [dbo].QuizList ([QuizID], [Name], [Description], [QuizTimeInMinute], [SubjectID], [TotalQuestion])
VALUES (3, N'CSS Basics Quiz 1',N'The quiz below tests your knowledge of the material learnt in CSS', 30, 3, 30)
INSERT [dbo].QuizList ([QuizID], [Name], [Description], [QuizTimeInMinute], [SubjectID], [TotalQuestion])
VALUES (4, N'CSS Basics Quiz 2',N'The quiz below tests your knowledge of the material learnt in CSS', 30, 4, 30)
