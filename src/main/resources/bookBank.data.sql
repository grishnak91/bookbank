INSERT INTO readers (reader_name, num_books_read)
VALUES
('Jordan', 7),
('Oscar', 1200),
('Casey', 1199)
;

INSERT INTO books (book_name, num_pages, notes, reader_fk)
VALUES (
'The Lion, The Witch, and The Wardrobe',
208,
'Four children escape the turmoil of London during WWI through a migical
doorway leading to new friends and life lessons.',
1
),
(
'Rainbow Six',
740,
'A sweaty-fingered thriller full of action, betrayal, treason, and so much more. Join
Mr. Clark as he takes down the most notorious terrorists in history.',
2
),
(
'Hunt For the Red October',
387,
'Jack Ryan is a data anylist for the CIA until they force him to get his hands dirty. 
How can Jack diffuse a tense situation during the Cold War with minimum loss of life?',
3
),
(
'The Screwtape Letters',
160,
'A deamon and his mentor wreak havoc on a man to steal his soul to hell. An
abstract look at the christian faith and the different conversations about morality,
psychology, and consequence therein.',
3
),
(
'The Bourne Identity',
523,
'A man has to confront his past to achieve his goal for a normal life. But as He 
uncovers his past, it tries to kill him.',
2
),
(
'The Wind-up Bird Chronicle',
607,
'A feckless idiot falls backwards into his transition into a psychic warrior
embroiled in the conquest of minds.',
1
),
(
'A Wizard of Earthsea',
205,
'A boy realizes he has the power of words and sets off to the school
of Wizards to hone his skill but is met with tools of his own demise.',
1
),
(
'Good Omens',
288,
'Satan is born and so is the end of the world. An angel and a Deamon
work together to thwart the end because of their love for the Earth',
2
);

INSERT INTO authors (author_name)
VALUES 
('C.S. Lewis'),
('Tom Clancy'),
('Robert Ludlum'),
('Haruki Murakami'),
('Ursula Le Guinn'),
('Neil Gaiman'),
('Terry Pratchett');

INSERT INTO genres (genre_name)
VALUES
('Fiction'),
('Non-fiction'),
('Thriller'),
('Espionage'),
('Sci-fi'),
('Fantasy'),
('Adventure'),
('Psychological Thriller'),
('Mind-Bender'),
('Drama');

INSERT INTO book_author (book_fk, author_fk)
VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 1),
(5, 3),
(6, 4),
(7, 5),
(8, 6),
(8, 7)
;


INSERT INTO book_genre (book_fk, genre_fk)
VALUES
(1, 1),
(1, 5),
(1, 6),
(1, 10),
(2, 1),
(2, 3),
(2, 4),
(3, 1),
(3, 3),
(3, 4),
(4, 1),
(4, 6),
(4, 9),
(5, 1),
(5, 3),
(5, 4),
(5, 7),
(5, 8),
(5, 9),
(6, 1),
(6, 3),
(6, 5),
(6, 7),
(6, 8),
(6, 9),
(6, 10),
(7, 1),
(7, 6),
(7, 7),
(7, 8),
(7, 10),
(8, 1),
(8, 6),
(8, 7),
(8, 10);
