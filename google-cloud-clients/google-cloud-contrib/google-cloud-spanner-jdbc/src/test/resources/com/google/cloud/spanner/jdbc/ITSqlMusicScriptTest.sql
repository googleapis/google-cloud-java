/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * SQL script that uses the standard Singers/Albums/Songs/Concerts data model for testing the Connection API.
 */

SET AUTOCOMMIT = FALSE;
START BATCH DDL;

CREATE TABLE Singers (
  SingerId   INT64 NOT NULL,
  FirstName  STRING(1024),
  LastName   STRING(1024),
  SingerInfo BYTES(MAX),
  BirthDate  DATE
) PRIMARY KEY(SingerId);

CREATE INDEX SingersByFirstLastName ON Singers(FirstName, LastName);

CREATE TABLE Albums (
  SingerId        INT64 NOT NULL,
  AlbumId         INT64 NOT NULL,
  AlbumTitle      STRING(MAX),
  MarketingBudget INT64
) PRIMARY KEY(SingerId, AlbumId),
  INTERLEAVE IN PARENT Singers ON DELETE CASCADE;

CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle);

CREATE INDEX AlbumsByAlbumTitle2 ON Albums(AlbumTitle) STORING (MarketingBudget);

CREATE TABLE Songs (
  SingerId  INT64 NOT NULL,
  AlbumId   INT64 NOT NULL,
  TrackId   INT64 NOT NULL,
  SongName  STRING(MAX),
  Duration  INT64,
  SongGenre STRING(25)
) PRIMARY KEY(SingerId, AlbumId, TrackId),
  INTERLEAVE IN PARENT Albums ON DELETE CASCADE;

CREATE INDEX SongsBySingerAlbumSongNameDesc ON Songs(SingerId, AlbumId, SongName DESC), INTERLEAVE IN Albums;

CREATE INDEX SongsBySongName ON Songs(SongName);

CREATE TABLE Concerts (
  VenueId      INT64 NOT NULL,
  SingerId     INT64 NOT NULL,
  ConcertDate  DATE NOT NULL,
  BeginTime    TIMESTAMP,
  EndTime      TIMESTAMP,
  TicketPrices ARRAY<INT64>
) PRIMARY KEY(VenueId, SingerId, ConcertDate);

RUN BATCH;

-- Check that all tables and indices were created
SET AUTOCOMMIT = TRUE;

@EXPECT RESULT_SET
SELECT TABLE_NAME AS ACTUAL, 'Singers' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Singers';

@EXPECT RESULT_SET
SELECT TABLE_NAME AS ACTUAL, 'Albums' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Albums';

@EXPECT RESULT_SET
SELECT TABLE_NAME AS ACTUAL, 'Songs' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Songs';

@EXPECT RESULT_SET
SELECT TABLE_NAME AS ACTUAL, 'Concerts' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Concerts';

@EXPECT RESULT_SET
SELECT INDEX_NAME AS ACTUAL, 'SingersByFirstLastName' AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE INDEX_NAME='SingersByFirstLastName' AND TABLE_NAME='Singers';

@EXPECT RESULT_SET
SELECT INDEX_NAME AS ACTUAL, 'AlbumsByAlbumTitle' AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE INDEX_NAME='AlbumsByAlbumTitle' AND TABLE_NAME='Albums';

@EXPECT RESULT_SET
SELECT INDEX_NAME AS ACTUAL, 'AlbumsByAlbumTitle2' AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE INDEX_NAME='AlbumsByAlbumTitle2' AND TABLE_NAME='Albums';

@EXPECT RESULT_SET
SELECT INDEX_NAME AS ACTUAL, 'SongsBySingerAlbumSongNameDesc' AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE INDEX_NAME='SongsBySingerAlbumSongNameDesc' AND TABLE_NAME='Songs';

@EXPECT RESULT_SET
SELECT INDEX_NAME AS ACTUAL, 'SongsBySongName' AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE INDEX_NAME='SongsBySongName' AND TABLE_NAME='Songs';

@EXPECT RESULT_SET
SELECT PARENT_TABLE_NAME AS ACTUAL, 'Singers' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Albums';

@EXPECT RESULT_SET
SELECT PARENT_TABLE_NAME AS ACTUAL, 'Albums' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Songs';

-- Insert test data
SET AUTOCOMMIT = FALSE;
SET TRANSACTION READ WRITE;

INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (1,'First 1','Last 1',FROM_BASE64('TIX0lfKhZyUjI+F5VXYQ9O/SXgQh4kT4Ktnp7BYPnTmAps2DA2YuulryUp9UD21JxGY1oq+UYQ/HYeN5eZ6aY31ualSCN417oWJH2yeZweByeGpxJ3XQ3tVnjbz2AYfaZ8IAap0v5EbUN/ATQT3H6NBb3qM+RzVK/VszGOxs0i8+aT6rXH3hsfXbgL36zXChrSxDNT4TjxhAjPA1YiDPqw=='),DATE '1906-04-28');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (2,'First 2','Last 2',FROM_BASE64('RtIHMSnQrvv1/aZEhBtP/JBfDe1dLjgRqGOQ/5qr3uYhdId6wthztQel0bD4Ucypl6L6/Lc56rz9PfvwKmvlBuMGr87zBvi1q3O/O74/4MTOl6Nic/3ltzxA7GEIgyKAcbKYdApPdMGMOG2Vx4p8nbPaPwMBr6hcp68A5xG/FLTreNVv2IVZx7NMSw3lqe3AV2uYdKWJp4zFB+qshsCmkA=='),DATE '1922-11-17');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (3,'First 3','Last 3',FROM_BASE64('VF6u7dM6mIY0RebnEh6E0jYajqZcfGH9b9HeotdCvUzpbOo7wJfqPMLZP3QVYnG416BFPct7Bl90EsbNE8FA/4EwUk8SU65N86PZGRoUUXEeTvaojCjVeqTByM0GQ+nROb73Kd0cW/TURRGv3ihLCMQdWIH8iGgCtjN3G+7vBavsinnnToCdSPlJxweyYKTdo+JwdqL3kVFk2O1QymuaHA=='),DATE '1935-11-08');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (4,'First 4','Last 4',FROM_BASE64('8YrvnC8FyWLGLTcv7D/fUKLxX+UqYiz6U0WOJHWyneRCDIFKsLSue3lhtbW+MnsrveL0WFmHHXRTdQ91EWzhvqdIJf4JIyk/Ndmq6mouM0n36EUeTAPQU7Wg4bxsrzggyD5FNvvuimLLpKuQBDZY1os7Xw/bksWUJ7XzZwy90pfDrgtGb4DdWZ1EJ6x71C2IMuzCnzhoV7/E15tXjiOfkg=='),DATE '1945-03-23');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (5,'First 5','Last 5',FROM_BASE64('BOItWwCAuhUAwZxfmh3F3KK6+Ne+KqShIZA/uCHi72wJOY0V3/Y/f5M8XhE+MLwz0VvLANU3Y6sHonGw8d09YkAZEo034Z2Q+YEEfFCwIhUIM+VTfwOkuRYgeU1SXBXjcZc5zsicakqYA82O3cd1RsFW+mmAO/bBcbSqraxuBR/5DYnbKrL9b5q9xqL+kQRMm2ZwoWpQP24Xke3lRlQlYg=='),DATE '1953-06-03');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (6,'First 6','Last 6',FROM_BASE64('Tz+o/44KGH34c7DzY4R/H7v0Uk4HyLV4yzjZ9VApDkhwiNKi33JspiLxfG43UvDpk0nLfRSbwu9h7p69H5NPNs9FyGaLxmqmKlP4/vohRJffbyLPEcGl3uSFRg7tnWcrlyegS03MotT9wXQNfjiAFwDh70jsxd7LnowepMMjk+qt+R8MaZkyZyL/AuE300N5P2D5i7shkS4F3IudQihtIA=='),DATE '1956-02-07');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (7,'First 7','Last 7',FROM_BASE64('r1QqmO+/0+e/J616waBJQVciDvuaLuRahdtZaCC5Tq95VxwIXfZE0Hisj0SER3+3A53DZw0qClcMOdPVTufwrKhAwggyqbtQ54UR2Q/dwAA1rHzikSS9JCyY3ksTQgUYmvcvtlfnNo/RA222yDyJMQ9sBcpJAs5cAbac0X4v8DgWicueJtQe2ohZMh4r7L9LydHW+B8DpqAa2yZWEzHoPw=='),DATE '1969-05-26');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (8,'First 8','Last 8',FROM_BASE64('IEcPp2dPGDIGotq157CMyokgh2eh5buNTqUu6JQfmbpb4vOuNFzFNrljhnFIxqj+PWAhkjjNhcYTHCmwAM5USSjrpyObo6P8KHe1ctENtgzVZ6Ym3OiKydVLsQGltVOFSpT4l/sM2aGc3AiAPkjAncCZudrMy57MtDcIUCwz1I8giEzB2ZOhlSaR2v8Vs+62+KiZOWGFnoVnen4lWywHEw=='),DATE '1978-11-08');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (9,'First 9','Last 9',FROM_BASE64('uNTiTW4e9PZuRNhywFSLAkMtLpkS/+g3J3FWuiI7kAjyWHzIJMX/KswTyyiUKasn1lcdrIieGN1wiyyXU0+o9kbCuCeT4RfrC+tSqh4rm5pbY+JaR65DtbzfGw3TrWkwoHhfxU/ftnZ14v6H3xAMVM22P3rphR833b1jc1lz3R/mdcTN0dEYhzrgCCtpoOygZZpmN8yOUR3AG0oErN1pyw=='),DATE '1987-07-04');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (10,'First 10','Last 10',FROM_BASE64('ZLpjMKSfhG9zjm/ACvA5TwB/djEWviypBYklKeuTwodVKUYciGavmgm2QkwlslDP0D0PutUorM3trZHt2vqSkKdpzoQxPa5fBtuUa+FQ3xtCZ8RoDJoZ1TEy3rGX6oUQh4vsrflFxhzuUKevKPMmf/ZQFvslytPN0vtHbHtPA9i4iaw0R6RuWyoc8QBLcHHyopul63KzweLlTBacSeC7oQ=='),DATE '1993-07-06');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (11,'First 11','Last 11',FROM_BASE64('OwMBMDWFt7Rni8cbwjWDeZ4BWluiA91JHDyh41zm2Vm36DuwwaLblF1kX2oGwJkICx2191DyfnFsJ7xejiPylZg170+iSwOeNkjj7s45JyihJVnCgEN2u5/D/7DFi0lmdqIGQzIJZ7VrhC/qEU8+4kx8uPfoQx8XndgOQJYibzw2YZM6LIMHhmJmd1nDvvda7Etdo5s9rYlGN6lvvBGifA=='),DATE '1895-09-15');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (12,'First 12','Last 12',FROM_BASE64('DNE+9WHnlmdsOLBBtVwEBotQmrHLw3JbKU6CzAGmV6yEtut+dmZU0OyDMK1jMY+vFH1fK0CSUJ4oM9jBkrI2lIhbL4UyxZghP3z6aWyywpOor/llA4xYoNdaT75xcQJUFYkrR1omHA5BqFG72qx+bjv2qV2izdttQYqq72+TYDLYCPLzhB6iP21zodySDD3HS0qc2/FeJHtm4Xe/HdOzlw=='),DATE '1922-01-03');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (13,'First 13','Last 13',FROM_BASE64('ltUFKoMUjmWlo0Vxwq4pd2kONfIX7mnNnmC2UmfF+M6w9X0U41iMVSVkVZBh4jpUNHx3AhZEJH4x7DnGgcuc8JaFbqRCT8GawwmFvrrJV8lBT3fPCV/QRDrP8Mx4DePxnBEcABfwPJlHMOF59WJX67eUyx1o5EnJx+KS8DTEPEh0yKWDreErIvMPft5T5JlHgGqOMrSNX3eKiEPI3sWjpw=='),DATE '1930-08-03');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (14,'First 14','Last 14',FROM_BASE64('SuJFYQf146OJUJCoOUOcN41X8M84E1lHVn/S0mHjrq7J8HPsUmfjAUNrwZ5RVJJ81vsm8I3xQkLtlQRC7lWkS5eCFSSo56B/NwtgtMugg+r7PSjoIC2HbIM0p89PA8QPW7jRMSx7fmSIm+PJBxavr5xJvv38IQboX/G4lK8wtMy0eNySrya0OE5fCKGKvke2fP9V5QpzhC0WnG9lhs/aRg=='),DATE '1940-05-12');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (15,'First 15','Last 15',FROM_BASE64('bUSUVJWZAEqNlHvePw03zNjtv6Bt45YXSnkduopD1wfJK8enFd9/9FwcWpEom6F8k7skYlTFMgsJCoxVXYXEbb9ZXYi0NoevQ3xG9uWT5NvFCKw++IeUwVztUjYIIHkH4zsYI3csH9Su3yHEqddKyg216ccUTgB0NZcosgKs1eTg1NC5BIzqCXa5Z+X38t/QismLAflh1gTbD2F7ihSDIA=='),DATE '1946-09-23');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (16,'First 16','Last 16',FROM_BASE64('lan0QanIaA/igo2HGkKzB82cKPgAZod4JMN/sV7kQSsMLqzMijItMQFKR1H6eYJosWKm2ajiYByBG8nxP5og5B3aut/Y2n58U86jgoHxoQR4LHOmhCnzjsBLfwZ4wE8BN8iznkWuMihQbZvsAQituLo3zygYKzSZ0V0O+nJBf4OesrS9UW1fwC312k1iB39ELDnZFTuWfca+8nqiv5kolg=='),DATE '1947-09-30');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (17,'First 17','Last 17',FROM_BASE64('NCks7+4E3+XdpeWrBg/0zz2t3KzNGh1hE3uZaXcQewMjBmiujYEP4teH6Sb2awoR55zII2eJHC6hyTcrCVLrTktBm8wqSkve+yxTvY1IIJt5eULLCerZeyl8dRDXpkpIJ3itPvXlsQUToBNhxW2gQqmz+segWsJwbtQSnnGZ+Frn8JiFSz51FCRcYP/eBlogljT9vxxuWkKrL8koRz3+ew=='),DATE '1948-02-04');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (18,'First 18','Last 18',FROM_BASE64('KZyY3e9J6d5G4uuBYa4mLVWaZv8SowusNx4KHrYx5VWF3xLsy/ZuOqRczNDeAitOyXC4lh2t1M8hclCsyxHIW2cUOR9xQnnqWtYA3WrYcFycqJn4hM+ghEAX5OXRVWEQ5lr9op7cSJio2JMawTcR5z3MrNucj0VTBtLTQKxHcW7VeuPARHCBkDCOicr0gQr/pODAUs5ipqv807ZhCV0n7Q=='),DATE '1962-11-10');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (19,'First 19','Last 19',FROM_BASE64('RymWYvEhWXx4AhUQaGoruxL/XgVUnz2vjMqa8yQtFEd8awR7Vzknzl1hpl/kKdCaKSzI9TV6RoD0HZu0U3UTazIh5WjMZYKwDT0ewsh4i5S1EIRzGohMg7l0vUVRtCzWVO5uALxm1mKYp3SczU0ETmQ0t+o1ke13Bz8I1/hyIsj6PnCIvxdOBZVycfKZ64dVxwwB9vYjVoRv5jnEw4K9Kg=='),DATE '1988-10-07');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (20,'First 20','Last 20',FROM_BASE64('+OgGCnKsVaMSILWEr/0wqkPajWcdSx79nDEOqmtCtQiIP7zqZETVKOjgfVYZg3pBzQQHQ9IExYlCvqX+//GxLhegBzKFfpJ6hp6NpKiJ2p6odLfeYVkvP7GdggU5sII5da3ApMebuQDkbYS1fWk8pXdqDIpkWbFG/PTGq+p1IdHRV0tkAEe9NFW2h5y8aO6Oy+zJprq0IX5CYln6zek/gQ=='),DATE '2000-02-29');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (21,'First 21','Last 21',FROM_BASE64('0BPlFBGYZ1w3Snpf3o6PswLXQeFgEE2ehluMDXYeqPjOO+dXN6s3CrS3JUVhejj5kARAoT510bRM4eAY7x5zRBtGQisDkeaeh0d1h/o+NESSX8MPZikMmeltT864xjxwnTd/5/m1oZTSVjVLVewzi6b1MuHcghcHrdgYMy/0f3ivz1DJMH6T4tIIFxg/y8Ueb0qKcFGvnvJlTWuNnMEpdA=='),DATE '1886-08-09');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (22,'First 22','Last 22',FROM_BASE64('K6GpZCoGGMJdF/55vnvqKCfpNyVrSJGMIpvDA8nxlwQFLBqemxUgCFrtAAZx7ERd0ndYXFJOpsRS8+You2lPcaXh/jfGWoZSy/AHLS7vpML7vRzrxKlyuocjaaDEm/wb351dEU3tT8VSOEhFkYk1VvhiFS47Hm5au5E2XXUpuQwHE/6f+FlkoD64wgmdyaOQWaJgJ0Nhg6UHWA0+MJ6AEA=='),DATE '1889-04-03');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (23,'First 23','Last 23',FROM_BASE64('etCS2Mi+5SgbO7VHnr1V+3PHp2ExR+NW0mF5mUhUxitXK4CtS1tbcUzvoSYoVEMhRlT0d1O2qlIyOPayxIB2GfEfhkJpajyPSjyBSEmh8frdKLx9qICQ+Ztwv8jK9JBOJC3VQxooS49ovUff/0W6akc0s9bNevQx8v8d3daklRCKFWYQCSIFcoYZv5+78zwZ8KZHErTXQl2ZW9/zH06Uew=='),DATE '1892-01-21');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (24,'First 24','Last 24',FROM_BASE64('RUq40F7M3XWGARLYX8ZW04hf4L+zW2wkKXf5zH4rqBxG2sacUMpZcK65mmQgj51C8XFcny+4E+ZuGfGVXIi3rsF700SnZVeFdKx1s2WMZJRKvJjbXKyHoaWytT9oUHIGqJw4qXpGh/CKUb9frNWCK5FiUk6iNsE3yMsEMVe+WnG5x+AeGXtWYwW5FtF0TnqUTnXw1lf3QzSdXg+DAvIZQA=='),DATE '1898-02-21');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (25,'First 25','Last 25',FROM_BASE64('HzmgCTWib9uD7oO0qPps+AvNx1o5b38RVsvRGXAMG9uxijG62pDK6gMVwCMt0PvUJNxEpcs0uKmPqx8eF66+V++VKjpKI8CerlxrEi7oOq344tAwRYK941HqXgBN9nQB1X33cwIufEwqq5nU85HGlGFm6O8EEGQb6+n5hXItCuMJAZWXkYiK1UW7H3zLDW4xJp+ijA35TfcHusirUaH8WQ=='),DATE '1911-12-15');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (26,'First 26','Last 26',FROM_BASE64('/j6wAEIFHAARYGDM5RDQYihb8QSfQGvZA7O2wDL2Tag1iY+twDM6DcFtvKt3PFmaFKYlB1mNkc129CWAW7PSHIIKDIVTDeI4PSHWy6DwCrYBDfn/ARmP7tRFqtM/RzFQKVQS3BvKPTAv3dNTjIWto9C0FFv7TyguTv0aPVkboxzQpJnR2FfjNG05/Uy2J67w+ngspZiUvj3aRQI/s/k8qQ=='),DATE '1912-07-01');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (27,'First 27','Last 27',FROM_BASE64('OTmvVaLjJI/8/xL6/W2dYhmAnhnB8SlzdnU1VxV/Z/FAmYp+4rALgjjq6KrQNpZ7oF2Iw+MF6bWbdQO2I3uqiH9nwCGflrq1Tjf8YkqwfZvYJ/RAorsd9WHHK74+5XpGYB3hgcPjeZ5vZg6cBeHnJbAlxEKTiBpnGvOoQqBm5bQQ1sLKsLanvBcMEsGyT98BlEZIHYeubPOELbLmhR/SWQ=='),DATE '1939-05-17');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (28,'First 28','Last 28',FROM_BASE64('OVlneKkb0DxkcCvpsKAVCE6hTutOrOBk+lF/iNCh/YMFQbIiVdZyBWNhpo8yfDKicgL50n3jjPNvEPX+I/RdKG82uM/bF8v/SWkrpzxXX9HMN4Ng9kErouVTK7s0Gf1eBHQcF4WrIbnCuN+SxWQxJhD6LCX02xw0JxXyqqRBUEmGYEbTmr/vfKZgGfj0UWYdvxbFX8bO+6vDq9NK9wTAKA=='),DATE '1946-10-18');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (29,'First 29','Last 29',FROM_BASE64('BUClPKVhaV2/DkWtL/JwWVIlqUjF1bOhCNQGM0xz/pbgxsE1jcLYNoMNVFbVPhwmEIyGiqAGOyUzfyyVVNHfPY0Hrbw2LlHXbm7VymFvxqlRNufrDnQrA6ZzsZECwkYHNtrOVcSp0rdSToNDzKdViSDPwIEzELtCKFWcycDYHF5AZzJDU1AV7gQQZHi8h8oJfncvCP9wLnXy/YpCjnDClQ=='),DATE '1956-12-23');
INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (30,'First 30','Last 30',FROM_BASE64('1JJ36b41BmeXie2RZ8TykjUUzyJfWV0ZoRShMybsVYebCanPaTb6uUiTFT4MDP1ise6jjN2STpZ49aHL8fOj02vzq1TsAVOznAScd2cbLDdnfSjVeABZRFKKIslpBNUSEP+4sgkoRi7D+ojXsNYVl+D+hSEB1mPn0brbV6mMQUWeryiUFf9ock9hYqa3BbhDEGFjkH0WcnRrvDHZgGAIVw=='),DATE '1988-05-29');
COMMIT;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 30 AS EXPECTED
FROM Singers;

INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (1,1,"Album 1 1",980045);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (2,2,"Album 2 2",667788);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (3,3,"Album 3 3",908791);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (4,4,"Album 4 4",690335);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (5,5,"Album 5 5",133041);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (6,6,"Album 6 6",505292);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (7,7,"Album 7 7",91969);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (8,8,"Album 8 8",289965);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (9,9,"Album 9 9",78176);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (10,10,"Album 10 10",485664);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (11,11,"Album 11 11",972680);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (12,12,"Album 12 12",893680);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (13,13,"Album 13 13",892138);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (14,14,"Album 14 14",449562);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (15,15,"Album 15 15",150968);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (16,16,"Album 16 16",580377);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (17,17,"Album 17 17",763081);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (18,18,"Album 18 18",203427);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (19,19,"Album 19 19",995368);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (20,20,"Album 20 20",29900);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (21,21,"Album 21 21",723728);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (22,22,"Album 22 22",540582);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (23,23,"Album 23 23",784245);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (24,24,"Album 24 24",614788);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (25,25,"Album 25 25",275649);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (26,26,"Album 26 26",970898);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (27,27,"Album 27 27",409289);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (28,28,"Album 28 28",766560);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (29,29,"Album 29 29",32414);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (30,30,"Album 30 30",457957);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (1,31,"Album 1 31",52546);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (2,32,"Album 2 32",412424);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (3,33,"Album 3 33",568496);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (4,34,"Album 4 34",353491);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (5,35,"Album 5 35",489951);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (6,36,"Album 6 36",75938);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (7,37,"Album 7 37",460461);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (8,38,"Album 8 38",642042);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (9,39,"Album 9 39",282872);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (10,40,"Album 10 40",521496);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (11,41,"Album 11 41",98126);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (12,42,"Album 12 42",535113);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (13,43,"Album 13 43",957625);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (14,44,"Album 14 44",667630);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (15,45,"Album 15 45",236968);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (16,46,"Album 16 46",445647);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (17,47,"Album 17 47",446396);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (18,48,"Album 18 48",852859);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (19,49,"Album 19 49",404105);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (20,50,"Album 20 50",384439);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (21,51,"Album 21 51",440468);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (22,52,"Album 22 52",455384);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (23,53,"Album 23 53",210756);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (24,54,"Album 24 54",849113);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (25,55,"Album 25 55",63969);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (26,56,"Album 26 56",277122);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (27,57,"Album 27 57",350063);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (28,58,"Album 28 58",359473);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (29,59,"Album 29 59",209825);
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (30,60,"Album 30 60",84543);

COMMIT;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 60 AS EXPECTED
FROM Albums;

INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,42,1,"Song 12 42 1",387,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,12,2,"Song 12 12 2",202,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,59,3,"Song 29 59 3",160,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,4,"Song 23 23 4",255,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,54,5,"Song 24 54 5",436,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (28,58,6,"Song 28 58 6",121,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,7,"Song 27 27 7",319,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,24,8,"Song 24 24 8",213,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,49,9,"Song 19 49 9",280,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (17,47,10,"Song 17 47 10",253,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (6,6,11,"Song 6 6 11",321,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,42,12,"Song 12 42 12",124,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (25,25,13,"Song 25 25 13",449,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,24,14,"Song 24 24 14",438,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,5,15,"Song 5 5 15",378,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,39,16,"Song 9 39 16",202,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (20,50,17,"Song 20 50 17",452,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (7,37,18,"Song 7 37 18",420,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,8,19,"Song 8 8 19",318,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,35,20,"Song 5 35 20",347,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,3,21,"Song 3 3 21",377,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,15,22,"Song 15 15 22",314,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,49,23,"Song 19 49 23",199,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (20,20,24,"Song 20 20 24",266,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,45,25,"Song 15 45 25",433,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (14,44,26,"Song 14 44 26",482,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,19,27,"Song 19 19 27",345,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,43,28,"Song 13 43 28",159,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (18,48,29,"Song 18 48 29",350,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,13,30,"Song 13 13 30",131,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,9,31,"Song 9 9 31",183,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,13,32,"Song 13 13 32",193,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,24,33,"Song 24 24 33",378,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,60,34,"Song 30 60 34",270,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,43,35,"Song 13 43 35",375,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,36,"Song 27 27 36",219,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (20,50,37,"Song 20 50 37",314,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (18,48,38,"Song 18 48 38",416,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,51,39,"Song 21 51 39",330,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (1,31,40,"Song 1 31 40",376,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,5,41,"Song 5 5 41",398,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,45,42,"Song 15 45 42",466,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,24,43,"Song 24 24 43",384,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,19,44,"Song 19 19 44",472,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,45,45,"Song 15 45 45",246,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,33,46,"Song 3 33 46",412,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,47,"Song 23 23 47",159,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,60,48,"Song 30 60 48",290,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,19,49,"Song 19 19 49",446,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (16,16,50,"Song 16 16 50",485,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (4,4,51,"Song 4 4 51",185,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,38,52,"Song 8 38 52",349,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,54,53,"Song 24 54 53",301,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,35,54,"Song 5 35 54",206,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,30,55,"Song 30 30 55",250,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,42,56,"Song 12 42 56",146,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,30,57,"Song 30 30 57",416,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (26,56,58,"Song 26 56 58",244,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (20,50,59,"Song 20 50 59",356,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (7,7,60,"Song 7 7 60",234,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,19,61,"Song 19 19 61",412,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,43,62,"Song 13 43 62",161,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,5,63,"Song 5 5 63",300,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (1,31,64,"Song 1 31 64",307,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (4,4,65,"Song 4 4 65",197,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,54,66,"Song 24 54 66",180,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,3,67,"Song 3 3 67",156,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (14,44,68,"Song 14 44 68",184,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,51,69,"Song 21 51 69",486,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,49,70,"Song 19 49 70",212,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,39,71,"Song 9 39 71",452,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,53,72,"Song 23 53 72",425,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (11,41,73,"Song 11 41 73",316,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,8,74,"Song 8 8 74",395,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,9,75,"Song 9 9 75",189,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (2,2,76,"Song 2 2 76",354,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,53,77,"Song 23 53 77",137,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,15,78,"Song 15 15 78",176,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,60,79,"Song 30 60 79",224,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (14,44,80,"Song 14 44 80",305,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,81,"Song 27 27 81",432,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (18,18,82,"Song 18 18 82",357,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (10,10,83,"Song 10 10 83",187,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,42,84,"Song 12 42 84",461,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,8,85,"Song 8 8 85",434,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (1,31,86,"Song 1 31 86",436,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (11,41,87,"Song 11 41 87",469,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,13,88,"Song 13 13 88",452,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (4,34,89,"Song 4 34 89",309,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,21,90,"Song 21 21 90",226,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (6,36,91,"Song 6 36 91",257,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,92,"Song 27 27 92",251,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,39,93,"Song 9 39 93",325,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,30,94,"Song 30 30 94",122,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,59,95,"Song 29 59 95",207,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (1,1,96,"Song 1 1 96",318,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (4,4,97,"Song 4 4 97",353,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,98,"Song 23 23 98",450,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,12,99,"Song 12 12 99",323,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,24,100,"Song 24 24 100",397,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,101,"Song 27 27 101",296,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,59,102,"Song 29 59 102",349,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (17,47,103,"Song 17 47 103",438,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,5,104,"Song 5 5 104",388,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (26,56,105,"Song 26 56 105",425,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (22,52,106,"Song 22 52 106",154,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,107,"Song 23 23 107",213,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,38,108,"Song 8 38 108",276,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,39,109,"Song 9 39 109",417,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (9,9,110,"Song 9 9 110",299,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (22,52,111,"Song 22 52 111",476,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,21,112,"Song 21 21 112",225,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,113,"Song 23 23 113",303,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (7,7,114,"Song 7 7 114",291,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,38,115,"Song 8 38 115",276,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (14,44,116,"Song 14 44 116",238,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,57,117,"Song 27 57 117",188,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (28,28,118,"Song 28 28 118",372,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (15,15,119,"Song 15 15 119",258,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,21,120,"Song 21 21 120",308,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,59,121,"Song 29 59 121",319,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (28,58,122,"Song 28 58 122",453,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (7,7,123,"Song 7 7 123",198,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (4,4,124,"Song 4 4 124",435,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,27,125,"Song 27 27 125",475,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (30,30,126,"Song 30 30 126",395,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,51,127,"Song 21 51 127",454,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,29,128,"Song 29 29 128",376,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (27,57,129,"Song 27 57 129",396,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,53,130,"Song 23 53 130",458,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (6,36,131,"Song 6 36 131",289,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (29,29,132,"Song 29 29 132",207,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (25,55,133,"Song 25 55 133",280,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,3,134,"Song 3 3 134",432,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (5,35,135,"",304,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,3,136,"",392,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,12,137,"",393,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (13,13,138,"",382,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (18,48,139,"",447,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (17,17,140,"",182,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (23,23,141,"",266,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (21,51,142,"",383,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (3,3,143,"",439,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (25,25,144,"",454,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (12,12,145,"",179,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (19,19,146,"",422,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (24,54,147,"",478,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (8,38,148,"",233,'Unknown');
INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (6,6,149,"",245,'Unknown');

COMMIT;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 149 AS EXPECTED
FROM Songs;

INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (1,1,DATE '2003-06-19',TIMESTAMP '2003-06-19T12:30:05Z',TIMESTAMP '2003-06-19T18:57:15Z',[11,93,140,923]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (2,18,DATE '2004-01-25',TIMESTAMP '2004-01-25T14:58:28Z',TIMESTAMP '2004-01-26T01:10:52Z',[18,51,101,812]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (3,21,DATE '2005-03-15',TIMESTAMP '2005-03-15T18:14:50Z',TIMESTAMP '2005-03-16T02:21:28Z',[23,26,107,721]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (4,16,DATE '2009-05-09',TIMESTAMP '2009-05-09T05:22:34Z',TIMESTAMP '2009-05-09T15:28:28Z',[18,70,150,297]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (5,11,DATE '2001-01-07',TIMESTAMP '2001-01-07T18:37:33Z',TIMESTAMP '2001-01-07T21:22:17Z',[20,55,185,672]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (6,25,DATE '2015-11-19',TIMESTAMP '2015-11-19T22:47:42Z',TIMESTAMP '2015-11-20T02:54:01Z',[12,73,150,833]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (7,26,DATE '2012-10-06',TIMESTAMP '2012-10-06T10:58:43Z',TIMESTAMP '2012-10-06T15:35:40Z',[8,83,199,625]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (8,8,DATE '2001-09-26',TIMESTAMP '2001-09-26T06:41:20Z',TIMESTAMP '2001-09-26T16:38:35Z',[19,87,192,912]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (9,27,DATE '2016-11-24',TIMESTAMP '2016-11-24T20:00:48Z',TIMESTAMP '2016-11-24T23:03:07Z',[20,84,134,885]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (10,30,DATE '2017-05-05',TIMESTAMP '2017-05-05T12:44:05Z',TIMESTAMP '2017-05-05T23:06:55Z',[17,44,177,997]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (11,7,DATE '2018-06-07',TIMESTAMP '2018-06-07T07:03:11Z',TIMESTAMP '2018-06-07T08:21:41Z',[10,73,182,287]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (12,22,DATE '2009-01-07',TIMESTAMP '2009-01-07T23:22:11Z',TIMESTAMP '2009-01-08T08:34:18Z',[22,59,150,983]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (13,16,DATE '2013-06-28',TIMESTAMP '2013-06-28T14:59:25Z',TIMESTAMP '2013-06-28T22:32:11Z',[17,41,129,433]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (14,11,DATE '2005-08-19',TIMESTAMP '2005-08-19T01:11:28Z',TIMESTAMP '2005-08-19T01:30:30Z',[18,49,110,590]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (15,18,DATE '2001-11-26',TIMESTAMP '2001-11-26T15:55:31Z',TIMESTAMP '2001-11-26T20:52:13Z',[18,51,132,854]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (16,26,DATE '2009-01-04',TIMESTAMP '2009-01-04T03:09:11Z',TIMESTAMP '2009-01-04T12:02:14Z',[5,37,146,344]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (17,20,DATE '2012-09-28',TIMESTAMP '2012-09-28T00:45:00Z',TIMESTAMP '2012-09-28T02:10:39Z',[15,89,185,480]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (18,24,DATE '2004-09-06',TIMESTAMP '2004-09-06T09:55:40Z',TIMESTAMP '2004-09-06T18:10:32Z',[23,51,113,244]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (19,21,DATE '2010-11-18',TIMESTAMP '2010-11-18T09:59:17Z',TIMESTAMP '2010-11-18T17:13:12Z',[14,69,164,218]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (20,29,DATE '2010-12-24',TIMESTAMP '2010-12-24T04:21:25Z',TIMESTAMP '2010-12-24T06:10:08Z',[20,34,166,573]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (21,3,DATE '2000-05-14',TIMESTAMP '2000-05-14T13:49:08Z',TIMESTAMP '2000-05-14T14:39:25Z',[21,67,136,779]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (22,18,DATE '2000-05-14',TIMESTAMP '2000-05-14T00:23:23Z',TIMESTAMP '2000-05-14T01:20:04Z',[21,91,111,749]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (23,26,DATE '2015-05-04',TIMESTAMP '2015-05-04T10:39:46Z',TIMESTAMP '2015-05-04T19:21:45Z',[24,91,128,559]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (24,16,DATE '2012-08-18',TIMESTAMP '2012-08-18T08:47:12Z',TIMESTAMP '2012-08-18T09:35:03Z',[19,44,136,281]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (25,4,DATE '2000-03-16',TIMESTAMP '2000-03-16T10:15:15Z',TIMESTAMP '2000-03-16T12:29:53Z',[22,28,111,948]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (26,4,DATE '2002-11-20',TIMESTAMP '2002-11-20T16:28:19Z',TIMESTAMP '2002-11-20T17:56:10Z',[7,70,141,517]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (27,23,DATE '2000-08-09',TIMESTAMP '2000-08-09T04:30:51Z',TIMESTAMP '2000-08-09T15:27:15Z',[13,98,156,230]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (28,16,DATE '2000-10-15',TIMESTAMP '2000-10-15T04:12:39Z',TIMESTAMP '2000-10-15T14:07:05Z',[8,39,160,455]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (29,22,DATE '2003-03-25',TIMESTAMP '2003-03-25T17:21:56Z',TIMESTAMP '2003-03-25T19:18:25Z',[17,70,148,681]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (30,15,DATE '2008-11-11',TIMESTAMP '2008-11-11T22:56:07Z',TIMESTAMP '2008-11-12T09:33:48Z',[24,47,175,901]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (31,7,DATE '2018-05-22',TIMESTAMP '2018-05-22T20:54:59Z',TIMESTAMP '2018-05-23T02:52:28Z',[13,34,177,804]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (32,30,DATE '2000-04-03',TIMESTAMP '2000-04-03T13:54:10Z',TIMESTAMP '2000-04-03T15:57:02Z',[16,48,137,249]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (33,23,DATE '2003-12-24',TIMESTAMP '2003-12-24T22:22:00Z',TIMESTAMP '2003-12-25T06:09:40Z',[15,36,131,922]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (34,12,DATE '2012-06-23',TIMESTAMP '2012-06-23T18:15:30Z',TIMESTAMP '2012-06-24T03:46:17Z',[25,31,160,564]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (35,5,DATE '2017-12-15',TIMESTAMP '2017-12-15T09:43:38Z',TIMESTAMP '2017-12-15T17:18:28Z',[22,31,177,868]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (36,20,DATE '2012-12-21',TIMESTAMP '2012-12-21T08:28:14Z',TIMESTAMP '2012-12-21T11:34:59Z',[25,62,143,437]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (37,19,DATE '2014-07-07',TIMESTAMP '2014-07-07T22:01:35Z',TIMESTAMP '2014-07-08T04:39:37Z',[8,31,184,784]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (38,15,DATE '2012-07-26',TIMESTAMP '2012-07-26T09:45:35Z',TIMESTAMP '2012-07-26T13:03:53Z',[19,79,140,908]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (39,24,DATE '2014-03-19',TIMESTAMP '2014-03-19T07:52:25Z',TIMESTAMP '2014-03-19T11:47:01Z',[11,90,141,978]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (40,4,DATE '2015-08-26',TIMESTAMP '2015-08-26T20:51:25Z',TIMESTAMP '2015-08-27T07:06:46Z',[15,94,195,510]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (41,24,DATE '2016-04-11',TIMESTAMP '2016-04-11T08:59:07Z',TIMESTAMP '2016-04-11T13:23:30Z',[15,51,173,233]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (42,18,DATE '2005-03-19',TIMESTAMP '2005-03-19T15:45:04Z',TIMESTAMP '2005-03-19T16:28:42Z',[19,31,188,546]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (43,7,DATE '2001-01-04',TIMESTAMP '2001-01-04T11:02:16Z',TIMESTAMP '2001-01-04T11:32:21Z',[20,37,133,958]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (44,5,DATE '2015-12-24',TIMESTAMP '2015-12-24T06:49:48Z',TIMESTAMP '2015-12-24T14:46:46Z',[12,61,175,233]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (45,12,DATE '2011-08-24',TIMESTAMP '2011-08-24T03:45:46Z',TIMESTAMP '2011-08-24T06:13:10Z',[18,38,169,913]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (46,16,DATE '2017-03-04',TIMESTAMP '2017-03-04T04:01:04Z',TIMESTAMP '2017-03-04T13:44:38Z',[21,79,119,839]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (47,18,DATE '2009-05-19',TIMESTAMP '2009-05-19T23:10:52Z',TIMESTAMP '2009-05-20T04:02:01Z',[25,79,151,357]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (48,22,DATE '2003-10-03',TIMESTAMP '2003-10-03T14:10:24Z',TIMESTAMP '2003-10-03T17:35:09Z',[18,60,140,450]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (49,9,DATE '2003-03-07',TIMESTAMP '2003-03-07T22:09:59Z',TIMESTAMP '2003-03-08T08:28:29Z',[22,41,122,726]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (50,9,DATE '2015-07-12',TIMESTAMP '2015-07-12T07:43:51Z',TIMESTAMP '2015-07-12T12:45:20Z',[18,67,126,474]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (51,12,DATE '2014-11-05',TIMESTAMP '2014-11-05T19:03:00Z',TIMESTAMP '2014-11-06T05:27:07Z',[19,43,125,865]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (52,6,DATE '2016-07-25',TIMESTAMP '2016-07-25T14:39:28Z',TIMESTAMP '2016-07-26T00:36:03Z',[6,74,192,344]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (53,13,DATE '2005-08-02',TIMESTAMP '2005-08-02T16:06:47Z',TIMESTAMP '2005-08-02T17:13:41Z',[5,52,192,977]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (54,18,DATE '2010-01-25',TIMESTAMP '2010-01-25T07:34:54Z',TIMESTAMP '2010-01-25T16:29:11Z',[24,85,181,304]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (55,14,DATE '2012-05-20',TIMESTAMP '2012-05-20T13:15:12Z',TIMESTAMP '2012-05-20T17:40:09Z',[15,43,104,665]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (56,3,DATE '2013-09-08',TIMESTAMP '2013-09-08T19:53:42Z',TIMESTAMP '2013-09-08T22:32:52Z',[14,81,129,354]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (57,27,DATE '2003-07-18',TIMESTAMP '2003-07-18T23:11:24Z',TIMESTAMP '2003-07-19T03:29:46Z',[21,85,188,854]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (58,27,DATE '2001-04-10',TIMESTAMP '2001-04-10T08:36:49Z',TIMESTAMP '2001-04-10T16:17:57Z',[17,86,161,438]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (59,2,DATE '2002-07-02',TIMESTAMP '2002-07-02T17:32:20Z',TIMESTAMP '2002-07-03T01:59:33Z',[23,59,164,357]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (60,28,DATE '2000-11-24',TIMESTAMP '2000-11-24T12:53:25Z',TIMESTAMP '2000-11-24T22:37:53Z',[22,47,161,739]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (61,12,DATE '2017-07-04',TIMESTAMP '2017-07-04T21:02:01Z',TIMESTAMP '2017-07-05T03:57:29Z',[16,88,179,478]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (62,3,DATE '2015-10-07',TIMESTAMP '2015-10-07T17:58:42Z',TIMESTAMP '2015-10-07T21:04:38Z',[21,44,155,381]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (63,23,DATE '2005-05-03',TIMESTAMP '2005-05-03T15:08:10Z',TIMESTAMP '2005-05-03T20:58:30Z',[20,43,111,824]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (64,24,DATE '2012-12-09',TIMESTAMP '2012-12-09T02:52:09Z',TIMESTAMP '2012-12-09T08:01:11Z',[18,87,106,997]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (65,30,DATE '2004-03-01',TIMESTAMP '2004-03-01T07:09:06Z',TIMESTAMP '2004-03-01T07:49:32Z',[14,26,195,895]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (66,24,DATE '2007-05-19',TIMESTAMP '2007-05-19T10:20:57Z',TIMESTAMP '2007-05-19T15:21:09Z',[18,54,179,238]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (67,16,DATE '2016-01-06',TIMESTAMP '2016-01-06T21:32:20Z',TIMESTAMP '2016-01-07T02:31:32Z',[20,61,120,652]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (68,2,DATE '2007-10-26',TIMESTAMP '2007-10-26T03:37:22Z',TIMESTAMP '2007-10-26T10:02:36Z',[11,65,151,537]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (69,2,DATE '2018-08-11',TIMESTAMP '2018-08-11T01:33:38Z',TIMESTAMP '2018-08-11T07:39:21Z',[10,98,105,621]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (70,23,DATE '2012-07-06',TIMESTAMP '2012-07-06T01:02:23Z',TIMESTAMP '2012-07-06T05:04:16Z',[14,44,172,953]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (71,7,DATE '2006-01-24',TIMESTAMP '2006-01-24T15:32:10Z',TIMESTAMP '2006-01-24T17:40:43Z',[9,58,150,713]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (72,8,DATE '2002-11-06',TIMESTAMP '2002-11-06T05:58:03Z',TIMESTAMP '2002-11-06T07:43:24Z',[25,36,193,213]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (73,10,DATE '2003-11-24',TIMESTAMP '2003-11-24T17:39:10Z',TIMESTAMP '2003-11-25T03:17:36Z',[8,55,200,352]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (74,16,DATE '2007-11-03',TIMESTAMP '2007-11-03T05:49:12Z',TIMESTAMP '2007-11-03T16:34:16Z',[21,50,114,820]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (75,4,DATE '2009-05-06',TIMESTAMP '2009-05-06T18:52:07Z',TIMESTAMP '2009-05-06T21:10:02Z',[16,42,101,281]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (76,1,DATE '2012-12-03',TIMESTAMP '2012-12-03T06:01:05Z',TIMESTAMP '2012-12-03T06:45:00Z',[24,60,140,292]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (77,1,DATE '2016-11-26',TIMESTAMP '2016-11-26T01:19:27Z',TIMESTAMP '2016-11-26T07:20:17Z',[19,31,123,214]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (78,9,DATE '2018-05-21',TIMESTAMP '2018-05-21T00:14:43Z',TIMESTAMP '2018-05-21T08:43:35Z',[7,28,115,634]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (79,14,DATE '2013-11-20',TIMESTAMP '2013-11-20T08:54:47Z',TIMESTAMP '2013-11-20T10:44:54Z',[18,39,155,328]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (80,17,DATE '2015-10-11',TIMESTAMP '2015-10-11T23:41:17Z',TIMESTAMP '2015-10-12T02:42:48Z',[16,94,102,894]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (81,23,DATE '2011-08-07',TIMESTAMP '2011-08-07T19:33:01Z',TIMESTAMP '2011-08-07T21:51:53Z',[23,90,134,370]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (82,7,DATE '2010-04-10',TIMESTAMP '2010-04-10T13:22:08Z',TIMESTAMP '2010-04-10T17:59:08Z',[18,68,121,303]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (83,27,DATE '2001-07-08',TIMESTAMP '2001-07-08T20:19:54Z',TIMESTAMP '2001-07-08T22:46:15Z',[18,86,148,746]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (84,6,DATE '2017-09-02',TIMESTAMP '2017-09-02T10:29:03Z',TIMESTAMP '2017-09-02T13:06:41Z',[12,85,138,471]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (85,1,DATE '2013-11-02',TIMESTAMP '2013-11-02T04:01:03Z',TIMESTAMP '2013-11-02T14:08:47Z',[9,65,111,583]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (86,22,DATE '2004-04-03',TIMESTAMP '2004-04-03T19:13:48Z',TIMESTAMP '2004-04-04T05:59:31Z',[19,72,105,908]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (87,2,DATE '2012-02-26',TIMESTAMP '2012-02-26T22:52:21Z',TIMESTAMP '2012-02-27T02:55:24Z',[16,75,129,740]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (88,9,DATE '2017-09-17',TIMESTAMP '2017-09-17T11:28:49Z',TIMESTAMP '2017-09-17T12:13:03Z',[24,77,182,755]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (89,11,DATE '2011-03-28',TIMESTAMP '2011-03-28T13:05:23Z',TIMESTAMP '2011-03-28T16:32:29Z',[22,96,174,731]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (90,21,DATE '2006-12-12',TIMESTAMP '2006-12-12T20:44:10Z',TIMESTAMP '2006-12-12T22:10:34Z',[15,68,166,616]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (91,27,DATE '2010-08-18',TIMESTAMP '2010-08-18T05:49:35Z',TIMESTAMP '2010-08-18T12:58:36Z',[12,84,157,369]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (92,2,DATE '2003-02-03',TIMESTAMP '2003-02-03T11:19:43Z',TIMESTAMP '2003-02-03T22:10:42Z',[25,59,140,939]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (93,5,DATE '2016-01-04',TIMESTAMP '2016-01-04T08:10:26Z',TIMESTAMP '2016-01-04T13:08:30Z',[5,90,163,272]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (94,3,DATE '2018-04-20',TIMESTAMP '2018-04-20T07:19:52Z',TIMESTAMP '2018-04-20T17:41:01Z',[5,59,109,854]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (95,19,DATE '2016-10-09',TIMESTAMP '2016-10-09T17:02:59Z',TIMESTAMP '2016-10-09T17:37:27Z',[6,35,176,442]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (96,9,DATE '2007-06-12',TIMESTAMP '2007-06-12T16:50:12Z',TIMESTAMP '2007-06-12T19:27:30Z',[7,49,169,729]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (97,29,DATE '2012-11-25',TIMESTAMP '2012-11-25T20:40:30Z',TIMESTAMP '2012-11-25T21:29:50Z',[12,35,128,269]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (98,11,DATE '2013-10-22',TIMESTAMP '2013-10-22T03:26:36Z',TIMESTAMP '2013-10-22T06:42:42Z',[14,49,148,726]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (99,10,DATE '2006-05-10',TIMESTAMP '2006-05-10T05:49:43Z',TIMESTAMP '2006-05-10T07:12:18Z',[5,67,131,360]);
INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (100,18,DATE '2015-02-15',TIMESTAMP '2015-02-15T01:18:05Z',TIMESTAMP '2015-02-15T04:19:27Z',[11,38,127,909]);

COMMIT;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 100 AS EXPECTED
FROM Concerts;

COMMIT;

# Switch to read-only mode
SET READONLY = TRUE;

# Do a query that should also generate a read timestamp
@EXPECT RESULT_SET 'NUMBER_OF_SINGERS',30
SELECT COUNT(*) AS NUMBER_OF_SINGERS
FROM Singers;

# Check that the read-timestamp is there
@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- End the read-only transaction and try to get a commit timestamp.
COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Try to do an update in read-only mode
@EXPECT EXCEPTION FAILED_PRECONDITION
UPDATE Singers SET FirstName='FirstName' WHERE SingerId=1;

-- Verify that it was not changed
@EXPECT RESULT_SET 'FirstName','First 1'
SELECT FirstName
FROM Singers
WHERE SingerId=1;

COMMIT;

-- Switch to autocommit and read/write mode
SET READONLY = FALSE;
SET AUTOCOMMIT = TRUE;

-- Try to insert a record that already exists
@EXPECT EXCEPTION ALREADY_EXISTS
INSERT INTO Singers (SingerId, FirstName, LastName)
SELECT SingerId, FirstName, LastName
FROM Singers
WHERE SingerId=1;

-- Ensure there was no commit timestamp
@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Delete a record that will also cascade to other records
-- First verify the actual number of records
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 2 AS EXPECTED
FROM Albums
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 4 AS EXPECTED
FROM Songs
WHERE SingerId=1;

-- Even though the delete cascades to several other records, the update count is returned as 1
@EXPECT UPDATE_COUNT 1
DELETE FROM Singers WHERE SingerId=1;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Albums
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Songs
WHERE SingerId=1;

-- Switch to transactional mode
SET AUTOCOMMIT = FALSE;

-- Delete a record that will also cascade to other records and then rollback
-- First verify the actual number of records
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 2 AS EXPECTED
FROM Albums
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Songs
WHERE SingerId=2;

-- Even though the delete cascades to several other records, the update count is returned as 1
@EXPECT UPDATE_COUNT 1
DELETE FROM Singers WHERE SingerId=2;

-- Verify that the change is visible inside the transaction
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Albums
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Songs
WHERE SingerId=2;

-- Rollback and verify that no changes were persisted
ROLLBACK;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 2 AS EXPECTED
FROM Albums
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Songs
WHERE SingerId=2;

-- End transaction
COMMIT;

-- Switch to autocommit and partitioned_non_atomic mode and redo the delete
SET AUTOCOMMIT = TRUE;
SET AUTOCOMMIT_DML_MODE='PARTITIONED_NON_ATOMIC';

@EXPECT UPDATE_COUNT 1
DELETE FROM Singers WHERE SingerId=2;

-- There should be no commit timestamp for PARTITIONED_NON_ATOMIC
@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Albums
WHERE SingerId=2;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Songs
WHERE SingerId=2;
