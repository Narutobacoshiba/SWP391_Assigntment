USE [master]
GO
/****** Object:  Database [Course]    Script Date: 10/20/2022 11:05:06 AM ******/
CREATE DATABASE [Course]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Course', FILENAME = N'D:\SQL Sever\MSSQL15.SQLEXPRESS\MSSQL\DATA\Course.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Course_log', FILENAME = N'D:\SQL Sever\MSSQL15.SQLEXPRESS\MSSQL\DATA\Course_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Course] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Course].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Course] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Course] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Course] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Course] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Course] SET ARITHABORT OFF 
GO
ALTER DATABASE [Course] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Course] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Course] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Course] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Course] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Course] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Course] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Course] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Course] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Course] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Course] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Course] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Course] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Course] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Course] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Course] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Course] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Course] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Course] SET  MULTI_USER 
GO
ALTER DATABASE [Course] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Course] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Course] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Course] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Course] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Course] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Course] SET QUERY_STORE = OFF
GO
USE [Course]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/20/2022 11:05:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccountID] [int] IDENTITY(1,1) NOT NULL,
	[Password] [varchar](128) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Email] [varchar](255) NOT NULL,
	[RoleID] [int] NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 10/20/2022 11:05:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[CourseID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](200) NULL,
	[Description] [text] NULL,
	[InstructorID] [int] NULL,
	[TinyPictureUrl] [varchar](3000) NULL,
	[ThumbnailUrl] [varchar](3000) NULL,
	[CreatedDate] [date] NULL,
	[ModifiedDate] [date] NULL,
	[Price] [decimal](15, 2) NOT NULL,
	[Status] [bit] NOT NULL,
	[VideoIntroduce] [varchar](500) NULL,
	[AboutCourse] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([AccountID], [Password], [Username], [Email], [RoleID], [Status]) VALUES (1, N'123', N'Kiendc', N'Kiendc@gmail.com', 1, 1)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Course] ON 

INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (1, N'Python For Everybody', N'This collection contains all the courses of the specialization: Python for everybody', 1, NULL, N'https://th.bing.com/th/id/OIP.uSvYbZEknvNd6gNDvHeK_QAAAA?pid=ImgDet&rs=1', CAST(N'2022-10-16' AS Date), CAST(N'2022-10-18' AS Date), CAST(100000.00 AS Decimal(15, 2)), 1, NULL, N'This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language. In the Capstone Project, you’ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (3, N'Foundations of User Experience (UX) Design', N'This collection contains all the courses of the specialization: Foundations of User Experience (UX) Design', 1, NULL, N'https://th.bing.com/th/id/R.f29d1541a205073a998307c8ea23700c?rik=tljwsqT8bvmLUg&riu=http%3a%2f%2fincitrio.com%2fwp-content%2fuploads%2f2014%2f03%2fUntitled.png&ehk=7b0iYyBAukTlqQa3mRrHYBdQa3IgRON8P3RuK3RjPmk%3d&risl=&pid=ImgRaw&r=0', CAST(N'2022-10-14' AS Date), CAST(N'2022-10-16' AS Date), CAST(100000.00 AS Decimal(15, 2)), 1, NULL, N'Foundations of User Experience (UX) Design is the first of a series of seven courses that will equip you with the skills needed to apply to entry-level jobs in user experience design. UX designers focus on the interactions that people have with products like websites, mobile apps, and physical objects. UX designers make those everyday interactions usable, enjoyable, and accessible. The role of an entry-level UX designer might include empathizing with users, defining their pain points, coming up with ideas for design solutions, creating wireframes, prototypes, and mockups, and testing designs to get feedback. ')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (7, N'Introduction to CSS3', N'This collection contains all the courses of the specialization: Introduction to CSS3 ', 1, NULL, N'https://image.slidesharecdn.com/lecture7-121004082434-phpapp01/95/introduction-to-css3-1-728.jpg?cb=1349339137', CAST(N'2022-10-14' AS Date), CAST(N'2022-10-16' AS Date), CAST(10000.00 AS Decimal(15, 2)), 1, NULL, N'The web today is almost unrecognizable from the early days of white pages with lists of blue links.  Now, sites are designed with complex layouts, unique fonts, and customized color schemes.   This course will show you the basics of Cascading Style Sheets (CSS3).  The emphasis will be on learning how to write CSS rules, how to test code, and how to establish good programming habits.')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (9, N'Introduction to HTML5', N'This collection contains all the courses of the specialization: Introduction to HTML5 ', 1, NULL, N'https://th.bing.com/th/id/OIP.44eTVBDz4qXtYl8LRVRy9wAAAA?pid=ImgDet&w=225&h=225&rs=1', CAST(N'2022-10-14' AS Date), CAST(N'2022-10-17' AS Date), CAST(10000.00 AS Decimal(15, 2)), 1, NULL, N'Thanks to a growing number of software programs, it seems as if anyone can make a webpage. But what if you actually want to understand how the page was created? There are great textbooks and online resources for learning web design, but most of those resources require some background knowledge. This course is designed to help the novice who wants to gain confidence and knowledge. We will explore the theory (what actually happens when you click on a link on a webpage?), the practical (what do I need to know to make my own page?), and the overlooked (I have a page, what do I do now?). Throughout the course there will be a strong emphasis on adhering to syntactic standards for validation and semantic standards to promote wide accessibility for users with disabilities.')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (13, N'Interactivity with JavaScript', N'This collection contains all the courses of the specialization: Interactivity with JavaScript ', 1, NULL, N'https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/d7/216ee0502611e5ab137970bddb1c09/javascript_thumnail_1x1.png', CAST(N'2022-10-14' AS Date), CAST(N'2022-10-16' AS Date), CAST(100000.00 AS Decimal(15, 2)), 1, NULL, N'This course will introduce you to the basics of the JavaScript language.  We will cover concepts such as variables, looping, functions, and even a little bit about debugging tools.  You will understand how the Document Object Model (DOM) is used by JavaScript to identify and modify specific parts of your page.  After the course, learners will be able to react to DOM Events and dynamically alter the contents and style of their page.   The class will culminate in a  final project - the creation of an interactive HTML5 form that accepts and verifies input.')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (14, N'Problem-Solving Skills for University Success', N'This collection contains all the courses of the specialization: Problem-Solving Skills for University Success ', 1, NULL, N'https://th.bing.com/th/id/OIP.-WEjvP3S-0dZbLXfv1kNwQHaFb?pid=ImgDet&rs=1', CAST(N'2022-10-14' AS Date), CAST(N'2022-10-16' AS Date), CAST(10000.00 AS Decimal(15, 2)), 1, NULL, N'In this course, you will learn how to develop your Problem Solving and Creativity Skills to help you achieve success in your university studies. After completing this course, you will be able to: Recognise the importance and function of problem solving and creative thought within academic study and the role of critical thought in creative ideation. Develop a toolkit to be able to identify real problems and goals within ill-defined problems. Recognize and apply analytical problem solving techniques. Recognise and apply creative problem solving techniques. Identify the use of creativity within and types of problems most common to your field. Apply learnt problem solving and creative ideation skills to a real-life context and reflect on personal learning processes')
INSERT [dbo].[Course] ([CourseID], [Name], [Description], [InstructorID], [TinyPictureUrl], [ThumbnailUrl], [CreatedDate], [ModifiedDate], [Price], [Status], [VideoIntroduce], [AboutCourse]) VALUES (15, N'Critical Thinking Skills for University Success', N'This collection contains all the courses of the specialization: Critical Thinking Skills for University Success ', 1, NULL, N'https://th.bing.com/th/id/OIP.YFcm5IK8eUeBfkKzs6Kg3gHaEo?pid=ImgDet&rs=1', CAST(N'2022-10-15' AS Date), CAST(N'2022-10-17' AS Date), CAST(10000.00 AS Decimal(15, 2)), 1, NULL, N'In this course, you will learn how to develop your Critical Thinking Skills to help you achieve success in your university studies. After completing this course, you will be able to: 1. Use critical thinking and argumentation in university contexts to improve academic results 2. Understand the importance and function of critical thinking in academic culture 3. Use a variety of thinking tools to improve critical thinking 4. Identify types of argument, and bias within arguments, in order to better evaluate the strength of arguments 5. Use evidence to support claims in arguments 6. Apply critical thinking and argumentation to real world problems and issues
')
SET IDENTITY_INSERT [dbo].[Course] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Account__A9D1053493DD9804]    Script Date: 10/20/2022 11:05:06 AM ******/
ALTER TABLE [dbo].[Account] ADD UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((1)) FOR [Status]
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD  CONSTRAINT [FK_Course_Account] FOREIGN KEY([InstructorID])
REFERENCES [dbo].[Account] ([AccountID])
GO
ALTER TABLE [dbo].[Course] CHECK CONSTRAINT [FK_Course_Account]
GO
USE [master]
GO
ALTER DATABASE [Course] SET  READ_WRITE 
GO
