/*
 * Copyright 2021 Google LLC
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
SET SPANNER.READONLY = FALSE;
@EXPECT RESULT_SET 'SPANNER.READONLY',false
SHOW VARIABLE SPANNER.READONLY;

-- Start a DDL batch to execute a number of DDL statements as one operation.
@EXPECT NO_RESULT
START BATCH DDL;

-- Create a couple of test tables
@EXPECT NO_RESULT
CREATE TABLE Singers (
                         SingerId	BIGINT PRIMARY KEY,
                         FirstName	VARCHAR(1024),
                         LastName	VARCHAR(1024),
                         SingerInfo	BYTEA
);

@EXPECT NO_RESULT
CREATE TABLE Albums (
                        SingerId     BIGINT NOT NULL,
                        AlbumId      BIGINT NOT NULL,
                        AlbumTitle   VARCHAR,
                        PRIMARY KEY (SingerId, AlbumId)
)
-- interleave this table in the Singers table
    INTERLEAVE IN PARENT Singers;

-- Create a secondary index
@EXPECT NO_RESULT
CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle);

-- Run the DDL batch
RUN BATCH;

-- Reset the statement timeout
SET STATEMENT_TIMEOUT=default;

/*
 * Verify that the test tables have been created
 */
@EXPECT NO_RESULT
SET AUTOCOMMIT = TRUE;
@EXPECT NO_RESULT
SET SPANNER.READONLY = TRUE;

-- Check that the table has been created
@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME='singers';

-- Check for all columns
@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='singers'
  AND COLUMN_NAME='singerid';

@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='singers'
  AND COLUMN_NAME='firstname';

@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='singers'
  AND COLUMN_NAME='lastname';

@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME='singers'
  AND COLUMN_NAME='singerinfo';

-- Check for index
@EXPECT RESULT_SET
SELECT COUNT(*) AS "ACTUAL", 1 AS "EXPECTED"
FROM INFORMATION_SCHEMA.INDEXES
WHERE TABLE_NAME='albums' AND INDEX_NAME='albumsbyalbumtitle';
