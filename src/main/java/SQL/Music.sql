CREATE TABLE 'musicdatabase'(
  'MusicId' INT(5) NOT NULL AUTO_INCREMENT,
  'Title' VARCHAR(50) NOT NULL,
  'Genre' VARCHAR(50) NOT NULL,
  'Length' DOUBLE(50) NOT NULL,
  'FilePath' VARCHAR(200) NOT NULL,
  PRIMARY KEY('MusicId')
);