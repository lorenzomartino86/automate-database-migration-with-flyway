ALTER TABLE book
  ADD COLUMN author_id INT,
  ADD CONSTRAINT fk_book_author_id
  FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE book DROP COLUMN author;