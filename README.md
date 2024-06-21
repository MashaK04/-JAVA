# sql
CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    release_year YEAR,
    author VARCHAR(100) NOT NULL
);
