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
 * Script that tests the different possible transaction modes in read-write mode
 */

SET AUTOCOMMIT = FALSE;
SET READONLY = FALSE;

-- Insert a test record
@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (9999, 'First 9999', 'Last 9999');
COMMIT;

---------------------------------------- Test read only transactions ---------------------------------------------
SET TRANSACTION READ ONLY;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=9999;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed for read-only transactions'
-- try to update a record in a read-only transaction
UPDATE Singers SET FirstName='New First Name' WHERE SingerId=9999;

-- We are in a read-only transaction that has returned a query, so there should be a read-timestamp
@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- Finish the transaction with a rollback. This removes the read timestamp
ROLLBACK;

-- Read timestamp from the previous transaction should no longer be available as it rolled back
@EXPECT RESULT_SET 'READ_TIMESTAMP',null
SHOW VARIABLE READ_TIMESTAMP;

-- Start a new read only transaction and SHOW VARIABLE the read timestamp after a commit
SET TRANSACTION READ ONLY;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=9999;

COMMIT;

@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- Try to execute DDL in a read-only transaction
SET TRANSACTION READ ONLY;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL statements are not allowed for read-only transactions'
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID);

ROLLBACK;

---------------------------------------- Test read/write transactions ---------------------------------------------
SET TRANSACTION READ WRITE;

@EXPECT UPDATE_COUNT 1
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (9998, 'First 9998', 'Last 9998');

COMMIT;

-- Verify the existence of the record
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=9998;

COMMIT;

-- try to delete the record, then rollback the transaction
@EXPECT UPDATE_COUNT 1
DELETE FROM Singers WHERE SingerId=9998;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM Singers
WHERE SingerId=9998;

ROLLBACK;

-- Verify that the rollback succeeded
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=9998;

-- Try to execute DDL in a read/write transaction
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL-statements are not allowed inside a read/write transaction.'
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID);

ROLLBACK;

---------------------------------------- Test DDL batches ---------------------------------------------
START BATCH DDL;

-- Verify that queries and updates fail
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Executing queries is not allowed for DDL batches.'
SELECT *
FROM Singers;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Executing updates is not allowed for DDL batches.'
UPDATE Singers SET LastName='Foo';

-- Verify that DDL statements are allowed
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID);
alter table FOO add column bar timestamp;
RUN BATCH;

-- Verify the existence of the table and the column
SET AUTOCOMMIT = TRUE;
@EXPECT RESULT_SET
SELECT TABLE_NAME AS ACTUAL, 'FOO' AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='FOO';

@EXPECT RESULT_SET
SELECT COLUMN_NAME AS ACTUAL, 'bar' AS EXPECTED
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='FOO' AND COLUMN_NAME='bar';

SET AUTOCOMMIT = FALSE;

-- Remove the table
START BATCH DDL;
DROP TABLE FOO;
RUN BATCH;

-- Remove the test records
@EXPECT UPDATE_COUNT 2
DELETE FROM Singers WHERE SingerId IN (9999, 9998);
COMMIT;