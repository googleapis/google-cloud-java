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
 * Script that tests the different possible transaction modes in read-only mode
 */

SET AUTOCOMMIT = FALSE;
SET READONLY = TRUE;

-- Verify that trying to insert a test record will fail
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed for read-only transactions'
INSERT INTO Singers (SingerId, FirstName, LastName)
VALUES (9999, 'First 9999', 'Last 9999');
COMMIT;

---------------------------------------- Test read only transactions ---------------------------------------------
SET TRANSACTION READ ONLY;

@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM Singers
WHERE SingerId=1;

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
WHERE SingerId=1;

COMMIT;

@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- Try to execute DDL in a read-only transaction
SET TRANSACTION READ ONLY;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL statements are not allowed for read-only transactions'
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID);

ROLLBACK;

---------------------------------------- Test read/write transactions ---------------------------------------------
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: The transaction mode can only be READ_ONLY when the connection is in read_only mode'
SET TRANSACTION READ WRITE;

---------------------------------------- Test DDL batches ---------------------------------------------
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Cannot start a DDL batch when the connection is in read-only mode'
START BATCH DDL;
