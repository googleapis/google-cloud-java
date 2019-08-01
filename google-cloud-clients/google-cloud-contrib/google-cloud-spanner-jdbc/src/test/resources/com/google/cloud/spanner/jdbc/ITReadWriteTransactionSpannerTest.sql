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

NEW_CONNECTION;

@EXPECT RESULT_SET 'TEST',1
SELECT 1 AS TEST;

COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;


NEW_CONNECTION;

@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (1, 'test');

COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;


NEW_CONNECTION;

@EXPECT RESULT_SET 'ID',1
SELECT ID
FROM TEST;

COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;


NEW_CONNECTION;

@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (2, 'FOO');

COMMIT;


NEW_CONNECTION;

@EXPECT RESULT_SET 'C',2
SELECT COUNT(*) AS C
FROM TEST;

COMMIT;


NEW_CONNECTION;

-- Set a statement timeout that should never be exceeded
SET STATEMENT_TIMEOUT = '10000s';

@EXPECT RESULT_SET 'NAME','FOO'
SELECT NAME FROM TEST WHERE ID=2;

COMMIT;


NEW_CONNECTION;

-- Set a statement timeout that should always be exceeded
SET STATEMENT_TIMEOUT = '1ns';

@EXPECT EXCEPTION DEADLINE_EXCEEDED
SELECT NAME FROM TEST WHERE ID=2;

SET STATEMENT_TIMEOUT = null;
ROLLBACK;


NEW_CONNECTION;

-- Set a statement timeout that should always be exceeded
SET STATEMENT_TIMEOUT = '1ns';

@EXPECT EXCEPTION DEADLINE_EXCEEDED
SELECT NAME FROM TEST WHERE ID=2;

-- Commit the transaction, even though the statement timed out.
-- This is not allowed as the transaction is no longer valid.
SET STATEMENT_TIMEOUT = null;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: The last statement of this transaction timed out or was cancelled'
COMMIT;


NEW_CONNECTION;

-- Set a statement timeout that should never be exceeded
SET STATEMENT_TIMEOUT = '10000s';

@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (3, 'test');

COMMIT;

-- Verify that there is a commit timestamp
@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;


NEW_CONNECTION;

-- Set a statement timeout that should always be exceeded
SET STATEMENT_TIMEOUT = '1ns';

@EXPECT EXCEPTION DEADLINE_EXCEEDED
INSERT INTO TEST (ID, NAME) VALUES (4, 'test');


NEW_CONNECTION;
-- Do not commit or rollback, just open a new connection

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED FROM TEST WHERE ID=4;


NEW_CONNECTION;
-- Test multiple statements in one transaction
@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (5, 'test');
@EXPECT RESULT_SET 'NAME','test'
SELECT * FROM TEST WHERE ID=5;
@EXPECT UPDATE_COUNT 1
UPDATE TEST SET NAME='test19' WHERE ID=5;
@EXPECT RESULT_SET 'NAME','test19'
SELECT * FROM TEST WHERE ID=5;
@EXPECT UPDATE_COUNT 1
DELETE FROM TEST WHERE ID=5;
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED FROM TEST WHERE ID=5;

COMMIT;


NEW_CONNECTION;
-- Execute multiple statements with timeouts in one transaction
@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (5, 'test');
@EXPECT RESULT_SET 'NAME','test'
SELECT * FROM TEST WHERE ID=5;
-- Everything ok, do a commit
COMMIT;

-- Do an update that should time out
SET STATEMENT_TIMEOUT = '1ns';
@EXPECT EXCEPTION DEADLINE_EXCEEDED
UPDATE TEST SET NAME='test20' WHERE ID=5;
-- Timed out, do a rollback
SET STATEMENT_TIMEOUT = null;
ROLLBACK;

-- Check that the previous update did not succeed
@EXPECT RESULT_SET 'NAME','test'
SELECT * FROM TEST WHERE ID=5;
-- Do a delete that should succeed
DELETE FROM TEST WHERE ID=5;
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED FROM TEST WHERE ID=5;

COMMIT;


NEW_CONNECTION;
-- Test primary key violation in transaction
@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (5, 'test');
COMMIT;

-- Do an insert that should fail because of a primary key constraint violation
@EXPECT EXCEPTION ALREADY_EXISTS
INSERT INTO TEST (ID, NAME) VALUES (5, 'should not be there');
-- Check that the insert failed
@EXPECT RESULT_SET
SELECT NAME AS ACTUAL, 'test' AS EXPECTED FROM TEST WHERE ID=5;
-- We need to rollback this transaction, as otherwise Spanner throw the constraint violation exception again
ROLLBACK;


NEW_CONNECTION;
-- Execute multiple statements in one transaction that all time out.
-- The transaction is no longer valid after the first timeout.
SET STATEMENT_TIMEOUT = '1ns';
@EXPECT EXCEPTION DEADLINE_EXCEEDED
SELECT NAME FROM TEST WHERE ID=2;
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: The last statement of this transaction timed out or was cancelled'
SELECT NAME FROM TEST WHERE ID=2;
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: The last statement of this transaction timed out or was cancelled'
SELECT NAME FROM TEST WHERE ID=2;

SET STATEMENT_TIMEOUT = null;
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: The last statement of this transaction timed out or was cancelled'
COMMIT;

NEW_CONNECTION;
-- Execute a DML batch.
START BATCH DML;
@EXPECT UPDATE_COUNT -1
INSERT INTO TEST (ID, NAME) VALUES (10, 'Batched insert 1');
@EXPECT UPDATE_COUNT -1
INSERT INTO TEST (ID, NAME) VALUES (11, 'Batched insert 2');
@EXPECT UPDATE_COUNT -1
INSERT INTO TEST (ID, NAME) VALUES (12, 'Batched insert 3');
@EXPECT RESULT_SET 'UPDATE_COUNTS',[1,1,1]
RUN BATCH;
COMMIT;

-- Verify that the records were inserted.
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 3 AS EXPECTED
FROM TEST
WHERE ID IN (10,11,12);


-- Execute a DML batch with an error.
START BATCH DML;
@EXPECT UPDATE_COUNT -1
DELETE FROM TEST WHERE ID IN (10,11,12);
@EXPECT UPDATE_COUNT -1
DELETE FROM TEST_NOT_FOUND WHERE ID IN (10,11,12);
-- Returns an error because of the second statement.
@EXPECT EXCEPTION INVALID_ARGUMENT
RUN BATCH;
-- Committing the transaction will still persist the first statement of the batch.
COMMIT;

-- Verify that the records were deleted.
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM TEST
WHERE ID IN (10,11,12);
