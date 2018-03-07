/* be sure to put a USE here */
/* USE TABLE_NAME ; */

/* create the users table */
create table Users  (
      UserId INT NOT NULL UNIQUE PRIMARY KEY,
      Username VARCHAR(255),
      Password VARCHAR(255),
      Email VARCHAR(255),
      IsSuper BOOLEAN
);

/* create the posts table */
create table Posts  (
      PostId INT NOT NULL UNIQUE PRIMARY KEY,
      PostTitle VARCHAR(255),
      PostContent MEDIUMTEXT
);