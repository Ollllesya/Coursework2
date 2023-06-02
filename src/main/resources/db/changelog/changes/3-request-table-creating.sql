CREATE TABLE [dbo].[request]
(
    id INT PRIMARY KEY IDENTITY (1, 1),
    creating_date DATETIME NOT NULL,
    returned_date DATETIME,
    book_id INT NOT NULL,
    student_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE ,
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE
)