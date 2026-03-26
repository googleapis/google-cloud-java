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
 * Test SHOW VARIABLE READ_TIMESTAMP in different modes
 */

-- Select query in autocommit and read-only mode should yield a read timestamp
SET AUTOCOMMIT = TRUE;
SET READONLY = TRUE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- Select query in autocommit and read-write mode should yield a read timestamp
SET READONLY = FALSE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

-- Select query in transactional and read-only mode should yield a read timestamp
SET AUTOCOMMIT = FALSE;
SET READONLY = TRUE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP'
SHOW VARIABLE READ_TIMESTAMP;

COMMIT;

-- Select query in transactional and read-write mode should NOT yield a read timestamp
SET READONLY = FALSE;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP',null
SHOW VARIABLE READ_TIMESTAMP;

COMMIT;

-- Update statement in transactional and read-write mode should NOT yield a read timestamp
SET AUTOCOMMIT = FALSE;

@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='New Last 1'
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP',null
SHOW VARIABLE READ_TIMESTAMP;

ROLLBACK;

-- Verify that the rollback actually worked
@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

COMMIT;

-- Invalid select query in autocommit and read-only mode should not yield a read timestamp
SET AUTOCOMMIT = TRUE;
SET READONLY = TRUE;

@EXPECT EXCEPTION INVALID_ARGUMENT
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM NonExistentTable
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP',null
SHOW VARIABLE READ_TIMESTAMP;

-- Invalid select query in autocommit and read-write mode should not yield a read timestamp
SET READONLY = FALSE;

@EXPECT EXCEPTION INVALID_ARGUMENT
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM NonExistentTable
WHERE SingerId=1;

@EXPECT RESULT_SET 'READ_TIMESTAMP',null
SHOW VARIABLE READ_TIMESTAMP;
