/* be sure to put a USE here */
/* USE TABLE_NAME ; */

/* create the users table */
create table Users  (
      userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      username VARCHAR(255),
      password VARCHAR(255),
      email VARCHAR(255),
      isSuper BOOLEAN
);

/* create the posts table */
create table Posts  (
      postId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      postTitle VARCHAR(255),
      postContent MEDIUMTEXT
);
/* create root user */
INSERT INTO Users (username, password, isSuper)
VALUES ("root", "password", true);

/* Some fake posts */
INSERT INTO Posts (postTitle, postContent) 
VALUES ("WTF", "WTAFASFASFF");

INSERT INTO Posts (postTitle, postContent) 
VALUES ("WHAT DID I DOOOO", "Holy crap it works it works it works it works it works it works");