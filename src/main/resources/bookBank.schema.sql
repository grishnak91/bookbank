DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS book_genre;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS readers;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
author_pk INT unsigned NOT NULL AUTO_INCREMENT,
author_name VARCHAR (128) NOT NULL,
PRIMARY KEY (author_pk)
);

CREATE TABLE genres (
genre_pk INT unsigned NOT NULL AUTO_INCREMENT,
genre_name VARCHAR (128) NOT NULL,
PRIMARY KEY (genre_pk)
);

CREATE TABLE readers (
reader_pk INT unsigned NOT NULL AUTO_INCREMENT,
reader_name VARCHAR (128) NOT NULL,
num_books_read INT NOT NULL,
PRIMARY KEY (reader_pk)
);

CREATE TABLE books (
book_pk INT unsigned NOT NULL AUTO_INCREMENT,
book_name VARCHAR (128) NOT NULL,
num_pages INT NOT NULL,
notes TEXT,
reader_fk INT unsigned NOT NULL,
FOREIGN KEY (reader_fk) REFERENCES readers (reader_pk) ON DELETE CASCADE,
PRIMARY KEY (book_pk)
);

CREATE TABLE book_genre (
book_fk INT unsigned NOT NULL,
genre_fk INT unsigned NOT NULL,
FOREIGN KEY (book_fk) REFERENCES books (book_pk) ON DELETE CASCADE,
FOREIGN KEY (genre_fk) REFERENCES genres (genre_pk) ON DELETE CASCADE
);

CREATE TABLE book_author (
book_fk INT unsigned,
author_fk INT unsigned,
FOREIGN KEY (book_fk) REFERENCES books (book_pk) ON DELETE CASCADE,
FOREIGN KEY (author_fk) REFERENCES authors (author_pk) ON DELETE CASCADE
);