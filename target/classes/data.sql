DROP TABLE IF EXISTS TWEET;

CREATE TABLE TWEET (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user VARCHAR(250) NOT NULL,
  text VARCHAR(250) NOT NULL,
  localization VARCHAR(250) DEFAULT NULL,
  validate VARCHAR(2) DEFAUlT NULL
);

INSERT INTO TWEET (id, user, text, localization, validate) VALUES
  (1, 'anita', 'Texto del twwet', 'Madrid', true);