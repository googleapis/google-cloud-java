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

/*
 * Insert test data into test tables
 */

@EXPECT NO_RESULT
SET AUTOCOMMIT = FALSE;
@EXPECT NO_RESULT
SET READONLY = FALSE;

@EXPECT UPDATE_COUNT 3
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES(1, 'Marc', 'Richards'),
      (2, 'Catalina', 'Smith'),
      (3, 'Alice', 'Trentor');

@EXPECT UPDATE_COUNT 3
INSERT INTO Singers (SingerId, FirstName, LastName)
SELECT 4, 'Lea', 'Martin'
UNION ALL
SELECT 5, 'David', 'Lomond'
UNION ALL
SELECT 6, 'Elena', 'Campbell';

@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (10, 'Virginia', 'Watson');
@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (11, 'Timothy', 'Campbell');

@EXPECT UPDATE_COUNT 5
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle)
VALUES
    (1, 1, 'Total Junk'),
    (1, 2, 'Go, Go, Go'),
    (2, 1, 'Green'),
    (2, 2, 'Forever Hold Your Peace'),
    (2, 3, 'Terrified');

@EXPECT NO_RESULT
COMMIT;

-- Try to insert a record that already exists
@EXPECT EXCEPTION ALREADY_EXISTS
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (10, 'Virginia', 'Watson');

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE FirstName='Virginia' AND LastName='Watson';

@EXPECT NO_RESULT
ROLLBACK;

-- Verify the contents of the tables
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 5 AS EXPECTED
FROM Albums;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 8 AS EXPECTED
FROM Singers;
