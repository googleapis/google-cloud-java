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

-- Test that DDL statements are allowed in DDL batches
START BATCH DDL;

-- Try to execute a DDL statement
@EXPECT NO_RESULT
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100) PRIMARY KEY (ID);
-- Abort batch as creating a table takes quite some time
ABORT BATCH;


NEW_CONNECTION;

-- Test that DDL statements are not allowed in read/write transactions
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;
@EXPECT RESULT_SET 'READONLY',false
SHOW VARIABLE READONLY;

@EXPECT EXCEPTION FAILED_PRECONDITION
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100) PRIMARY KEY (ID);


NEW_CONNECTION;

-- Test that DDL statements are not allowed in read-only transactions
SET TRANSACTION READ ONLY;
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;

@EXPECT EXCEPTION FAILED_PRECONDITION
CREATE TABLE FOO (ID INT64 NOT NULL, NAME STRING(100) PRIMARY KEY (ID);


NEW_CONNECTION;

-- Test that DML statements are allowed in read/write transactions
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;
@EXPECT RESULT_SET 'READONLY',false
SHOW VARIABLE READONLY;

@EXPECT UPDATE_COUNT 1
INSERT INTO TEST (ID, NAME) VALUES (1, 'TEST');
@EXPECT UPDATE_COUNT 1
UPDATE TEST SET NAME='TEST2' WHERE ID=1;
@EXPECT UPDATE_COUNT 1
DELETE FROM TEST WHERE ID=1;
COMMIT;


NEW_CONNECTION;

-- Test that DML statements are not allowed in read-only transactions
SET TRANSACTION READ ONLY;
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;

@EXPECT EXCEPTION FAILED_PRECONDITION
UPDATE FOO SET BAR=1 WHERE ID=2;


NEW_CONNECTION;

-- Test that DML statements are not allowed in DDL batches
START BATCH DDL;

@EXPECT EXCEPTION FAILED_PRECONDITION
UPDATE FOO SET BAR=1 WHERE ID=2;


NEW_CONNECTION;

-- Test that queries are allowed in read/write transactions
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;

SELECT * FROM TEST;


NEW_CONNECTION;

-- Test that queries are allowed in read-only transactions
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;
SET TRANSACTION READ ONLY;

SELECT * FROM TEST;


NEW_CONNECTION;

-- Test that queries are not allowed in DDL batches
START BATCH DDL;

@EXPECT EXCEPTION FAILED_PRECONDITION
SELECT * FROM TEST;
