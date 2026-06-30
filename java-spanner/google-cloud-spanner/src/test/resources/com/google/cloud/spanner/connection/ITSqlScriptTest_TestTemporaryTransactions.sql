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
 * Test script for temporary transactions (i.e. autocommit mode with explicit BEGIN [TRANSACTION] statements)
 */

SET AUTOCOMMIT = TRUE;
SET READONLY = FALSE;

-- Insert a new singer in a temporary transaction and commit
BEGIN;
@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (9999, 'First 9999', 'Last 9999');
COMMIT;

-- Verify that the record is there
@EXPECT RESULT_SET
SELECT FirstName AS ACTUAL, 'First 9999' AS EXPECTED
FROM Singers
WHERE SingerId=9999
UNION ALL
SELECT LastName AS ACTUAL, 'Last 9999' AS EXPECTED
FROM Singers
WHERE SingerId=9999;

-- Insert another singer in a temporary transaction and rollback
BEGIN;
@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (9998, 'First 9998', 'Last 9998');
ROLLBACK;

-- Verify that the record is not there
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=9998;

-- Delete the initial test record in autocommit mode
@EXPECT UPDATE_COUNT 1
DELETE FROM Singers
WHERE SingerId=9999;

-- Verify that a rollback is not possible, as we are in autocommit mode
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: This connection has no transaction'
ROLLBACK;

-- Verify that the record has been removed
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=9999;
