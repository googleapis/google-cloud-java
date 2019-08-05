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
 * Test script that creates a couple of test tables in one transaction.
 */

-- Turn off autocommit (and verify)
@EXPECT NO_RESULT
SET AUTOCOMMIT = FALSE;
@EXPECT RESULT_SET 'AUTOCOMMIT',false
SHOW VARIABLE AUTOCOMMIT;

-- Turn off readonly (and verify)
@EXPECT NO_RESULT
SET READONLY = FALSE;
@EXPECT RESULT_SET 'READONLY',false
SHOW VARIABLE READONLY;

-- Start a DDL batch to execute a number of DDL statements as one operation.
@EXPECT NO_RESULT
START BATCH DDL;

-- Create a couple of test tables
@EXPECT NO_RESULT
CREATE TABLE Singers (
	SingerId	INT64 NOT NULL,
	FirstName	STRING(1024),
	LastName	STRING(1024),
	SingerInfo	BYTES(MAX)
) PRIMARY KEY (SingerId);

@EXPECT NO_RESULT
CREATE TABLE Albums (
	SingerId     INT64 NOT NULL,
	AlbumId      INT64 NOT NULL,
	AlbumTitle   STRING(MAX)
) PRIMARY KEY (SingerId, AlbumId),
-- interleave this table in the Singers table
INTERLEAVE IN PARENT Singers ON DELETE CASCADE;

-- Create a secondary index
@EXPECT NO_RESULT
CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle);

-- Run the DDL batch
RUN BATCH;

-- Reset the statement timeout
SET STATEMENT_TIMEOUT=null;

/*
 * Verify that the test tables have been created
 */
@EXPECT NO_RESULT
SET AUTOCOMMIT = TRUE;
@EXPECT NO_RESULT
SET READONLY = TRUE;

-- Check that the table has been created
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='Singers';

-- Check for all columns
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 4 AS EXPECTED
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='Singers'
/**
 * List all expected column names
 */
AND COLUMN_NAME IN (
	'SingerId',
	'FirstName',
	'LastName',
	'SingerInfo'
);

-- Check for index
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 1 AS EXPECTED
FROM INFORMATION_SCHEMA.INDEXES
WHERE TABLE_NAME='Albums' AND INDEX_NAME='AlbumsByAlbumTitle';
