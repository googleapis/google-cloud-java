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
VALUES(1, 'First 1', 'Last 1'),
      (2, 'First 2', 'Last 2'),
      (3, 'First 3', 'Last 3');

@EXPECT UPDATE_COUNT 3
INSERT INTO Singers (SingerId, FirstName, LastName)
SELECT 4, 'First 4', 'Last 4'
UNION ALL
SELECT 5, 'First 5', 'Last 5'
UNION ALL
SELECT 6, 'First 6', 'Last 6';

@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (10, 'First 10', 'Last 10');
@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (11, 'First 11', 'Last 11');

@EXPECT UPDATE_COUNT 5
INSERT INTO Albums (SingerId, AlbumId, AlbumTitle)
VALUES
    (1, 1, 'Album 1 1'),
    (1, 2, 'Album 1 2'),
    (2, 1, 'Album 2 1'),
    (2, 2, 'Album 2 2'),
    (2, 3, 'Album 2 3');

@EXPECT NO_RESULT
COMMIT;

-- Try to insert a record that already exists
@EXPECT EXCEPTION ALREADY_EXISTS
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (10, 'First 10', 'Last 10');

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE FirstName='First 10' AND LastName='Last 10';

@EXPECT NO_RESULT
ROLLBACK;

-- Verify the contents of the tables
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 5 AS EXPECTED
FROM Albums;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 8 AS EXPECTED
FROM Singers;
