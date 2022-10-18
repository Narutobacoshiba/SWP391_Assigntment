/****** Object:  Table [dbo].[Course]    Script Date: 10/18/2022 11:21:05 PM ******/
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