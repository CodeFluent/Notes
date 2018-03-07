/* be sure to put a USE here */
/* USE TABLE_NAME ; */

/* create the table */
create table [IF NOT EXISTS] Assignment8 (
      LanguageName varchar(255) NOT NULL,
      IsGoodLanguage boolean,
      FoundedYear int,
      ID int NOT NULL PRIMARY KEY
);

/* Add entries */
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Python", true, 1991);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("C", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
insert into Assignment8 (LanguageName, IsGoodLanguage, FoundedYear) Values("Java", false, 1995);
