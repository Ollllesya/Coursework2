CREATE TABLE [dbo].[student]
(
    id INT PRIMARY KEY IDENTITY (1, 1),
    first_name VARCHAR (255) NOT NULL,
    last_name VARCHAR (255) NOT NULL,
    student_card VARCHAR (255) NOT NULL
)