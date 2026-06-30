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
 * Script that tests a connection in read-only and autocommit mode
 */

SET AUTOCOMMIT = TRUE;
SET READONLY = TRUE;

-- First verify that the autocommit dml mode cannot be set when in read-only mode
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Cannot set autocommit DML mode for a read-only connection'
SET AUTOCOMMIT_DML_MODE = 'PARTITIONED_NON_ATOMIC';

-- Verify that executing an update statement fails
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed in read-only mode'
UPDATE Singers SET LastName='Some Other Last Name' /* It used to be 'Last 1' */
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

-- Verify the same for INSERT and DELETE statements
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed in read-only mode'
INSERT INTO Singers (SingerId, FirstName, LastName) VALUES (9999, 'First 9999', 'Last 9999');

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed in read-only mode'
DELETE FROM Singers;

-- Verify that the same error message is given even if the update statements references a non-existent table
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Update statements are not allowed in read-only mode'
/* The referenced table does not exist */
update Artists set LastName='Some Last Name'
where ArtistId=1;

-- Verify that DDL statements will also cause an exception
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL statements are not allowed in read-only mode'
CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID);

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL statements are not allowed in read-only mode'
/* The statement is recognized even if it is preceeded
 * by a multi-line comment */
-- And a single line comment, and some spaces

   		DROP TABLE Singers;

-- And verify that alter table statements also fail
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: DDL statements are not allowed in read-only mode'
alter table Singers add column test string(100);
