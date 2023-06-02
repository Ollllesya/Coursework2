CREATE TABLE [dbo].[book]
(
    id INT PRIMARY KEY IDENTITY (1, 1),
    title VARCHAR (255) NOT NULL,
    year_of_publication INT NOT NULL,
    author VARCHAR (255) NOT NULL,
    available BIT NOT NULL
)