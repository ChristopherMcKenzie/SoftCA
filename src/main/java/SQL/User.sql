CREATE TABLE 'user'(
  'UserId' INT(5) NOT NULL AUTO_INCREMENT,
  'Name' VARCHAR(50) NOT NULL,
  'Email' VARCHAR(50) NOT NULL,
  'Password' VARCHAR(50) NOT NULL,
  'FavGenre' VARCHAR(50) NOT NULL,
  'Admin' int(1) NOT NULL, 
  PRIMARY KEY('UserId')
);

