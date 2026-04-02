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
 * Script that tests the different possible autocommit dml modes
 */

SET AUTOCOMMIT = FALSE;
SET READONLY = FALSE;

-- First verify that the mode cannot be set when not in autocommit mode
@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Cannot set autocommit DML mode while not in autocommit mode or while a transaction is active'
SET AUTOCOMMIT_DML_MODE = 'Transactional';

-- Turn on autocommit and set mode to transactional
SET AUTOCOMMIT = TRUE;

@EXPECT NO_RESULT
SET AUTOCOMMIT_DML_MODE = 'Transactional';

@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','TRANSACTIONAL'
SHOW VARIABLE AUTOCOMMIT_DML_MODE;

-- Verify that executing an update statement is possible
@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='Some Other Last Name' /* It used to be 'Last 1' */
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Some Other Last Name' AS EXPECTED
FROM Singers
WHERE SingerId=1;

-- Reset to original value in partioned mode
@EXPECT NO_RESULT
SET AUTOCOMMIT_DML_MODE = 'partitioned_non_atomic';

@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','PARTITIONED_NON_ATOMIC'
SHOW VARIABLE AUTOCOMMIT_DML_MODE;

@EXPECT UPDATE_COUNT 1
UPDATE Singers SET LastName='Last 1'
WHERE SingerId=1;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;

-- Verify that trying to set the mode to an invalid value will throw an exception
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown value for AUTOCOMMIT_DML_MODE: 'None''
SET AUTOCOMMIT_DML_MODE = 'None';

-- Verify that setting the mode in read-only mode will throw an exception
SET READONLY = TRUE;

@EXPECT EXCEPTION FAILED_PRECONDITION 'FAILED_PRECONDITION: Cannot set autocommit DML mode for a read-only connection'
SET AUTOCOMMIT_DML_MODE = 'Transactional';

-- Back to read-write mode
SET READONLY = FALSE;

-- Verify that turning off autocommit and on again will not reset the AUTOCOMMIT_DML_MODE value
@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','PARTITIONED_NON_ATOMIC'
SHOW VARIABLE AUTOCOMMIT_DML_MODE;
SET AUTOCOMMIT = FALSE;
SET AUTOCOMMIT = TRUE;
@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','PARTITIONED_NON_ATOMIC'
SHOW VARIABLE AUTOCOMMIT_DML_MODE;

-- Reset to default value
SET AUTOCOMMIT_DML_MODE = 'Transactional';
@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','TRANSACTIONAL'
SHOW VARIABLE AUTOCOMMIT_DML_MODE;
