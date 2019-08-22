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
 * Test SHOW VARIABLE COMMIT_TIMESTAMP in different modes
 */

-- Select query in autocommit and read-only mode should not yield a commit timestamp
@EXPECT NO_RESULT
SET AUTOCOMMIT = TRUE;
@EXPECT NO_RESULT
SET READONLY = TRUE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Select query in autocommit and read-write mode should not yield a commit timestamp
@EXPECT NO_RESULT
SET READONLY = FALSE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Select query in transactional and read-only mode should not yield a commit timestamp
@EXPECT NO_RESULT
SET AUTOCOMMIT = FALSE;
@EXPECT NO_RESULT
SET READONLY = TRUE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT NO_RESULT
COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Select query in transactional and read-write mode should yield a commit timestamp
@EXPECT NO_RESULT
SET READONLY = FALSE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT NO_RESULT
COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Update statement in transactional and read-write mode should yield a commit timestamp
@EXPECT NO_RESULT
SET AUTOCOMMIT = FALSE;

@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='New Last 1'
WHERE SingerId=1;

@EXPECT NO_RESULT
COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Reset the value to its original value
@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='Last 1'
WHERE SingerId=1;

@EXPECT NO_RESULT
COMMIT;

-- Select query in transactional and read-write mode that rollbacks should not yield a commit timestamp
@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT NO_RESULT
ROLLBACK;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Update statement in transactional and read-write mode that rollbacks should not yield a commit timestamp
@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='New Last 1'
WHERE SingerId=1;

@EXPECT NO_RESULT
ROLLBACK;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null
SHOW VARIABLE COMMIT_TIMESTAMP;

-- Invalid select query in transactional and read-write mode should yield a commit timestamp
-- The (invalid) query is sent to the server, initiating a transaction, that is committed afterwards
SET AUTOCOMMIT = FALSE;
SET READONLY = FALSE;

@EXPECT EXCEPTION INVALID_ARGUMENT
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM NonExistentTable
WHERE SingerId=1;

@EXPECT NO_RESULT
COMMIT;

@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'
SHOW VARIABLE COMMIT_TIMESTAMP;
