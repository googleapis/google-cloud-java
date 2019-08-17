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
 * Test setting statement timeout and verify that statements actually do timeout
 */

-- Ensure we know what mode we are in
SET AUTOCOMMIT = TRUE;
SET AUTOCOMMIT_DML_MODE='Transactional';
SET READONLY = FALSE;

-- Verify that setting a negative timeout value is not allowed
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown value for STATEMENT_TIMEOUT: '-1ms''
SET STATEMENT_TIMEOUT='-1ms';

@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown value for STATEMENT_TIMEOUT: '1''
SET STATEMENT_TIMEOUT='1';

-- First set the statement timeout to null, which means no timeout
SET STATEMENT_TIMEOUT=null;

@EXPECT RESULT_SET 'STATEMENT_TIMEOUT',null
SHOW VARIABLE STATEMENT_TIMEOUT;

-- Do a somewhat complex query that should not timeout
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM (
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
) RES
;

-- Set the statement timeout to 1 nanosecond that should cause basically any statement to timeout
SET STATEMENT_TIMEOUT='1ns';

@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1ns'
SHOW VARIABLE STATEMENT_TIMEOUT;

-- Do a somewhat complex query that should now timeout
@EXPECT EXCEPTION DEADLINE_EXCEEDED 'DEADLINE_EXCEEDED: Statement execution timeout occurred'
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM (
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
) RES
;

-- Try to execute an update that should also timeout
@EXPECT EXCEPTION DEADLINE_EXCEEDED 'DEADLINE_EXCEEDED: Statement execution timeout occurred'
UPDATE Singers SET LastName='Some Other Last Name' /* It used to be 'Last 1' */
WHERE SingerId=1
OR LastName IN (
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
)
;

-- Verify that the record was not updated
SET STATEMENT_TIMEOUT=null;
@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;


-----------------------------------------------------------------------------------------------------

-- Repeat test in transactional mode
SET AUTOCOMMIT = FALSE;
-- First set the statement timeout to null, which means no timeout
SET STATEMENT_TIMEOUT=null;

@EXPECT RESULT_SET 'STATEMENT_TIMEOUT',null
SHOW VARIABLE STATEMENT_TIMEOUT;

-- Do a somewhat complex query that should not timeout
@EXPECT RESULT_SET
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM (
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
) RES
;

-- Set the statement timeout to 1 nanosecond that should cause basically any statement to timeout
SET STATEMENT_TIMEOUT='1ns';

@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1ns'
SHOW VARIABLE STATEMENT_TIMEOUT;

-- Do a somewhat complex query that should now timeout
@EXPECT EXCEPTION DEADLINE_EXCEEDED 'DEADLINE_EXCEEDED: Statement execution timeout occurred'
SELECT COUNT(*) AS ACTUAL, 0 AS EXPECTED
FROM (
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT *
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
) RES
;
-- We need to rollback the transaction as it is no longer usable.
@EXPECT EXCEPTION DEADLINE_EXCEEDED 'DEADLINE_EXCEEDED: Statement execution timeout occurred'
ROLLBACK;

-- Try to execute an update that should also timeout
@EXPECT EXCEPTION DEADLINE_EXCEEDED 'DEADLINE_EXCEEDED: Statement execution timeout occurred'
UPDATE Singers SET LastName='Some Other Last Name' /* It used to be 'Last 1' */
WHERE SingerId=1
OR LastName IN (
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	UNION ALL
	SELECT LastName
	FROM Singers
	WHERE LastName IN (SELECT AlbumTitle FROM Albums)
	OR LastName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
	OR FirstName IN (SELECT AlbumTitle FROM Albums)
	OR FirstName IN (SELECT CAST(SingerId AS STRING) FROM Singers)
)
;

/* As we are in a transaction, the statement *could* continue in the background and will not
 * automatically be rollbacked by the connection. Whether the statement will continue to
 * execute in the background depends on what the reason for the timeout was. If the timeout
 * was caused because the statement took too long to execute on the server, the statement
 * will continue to run server side. If the timeout was caused by a network problem that
 * prevented the statement to be delivered to the server in a timely fashion, the statement
 * has never reached the server and hence will not be executed in the background.
 * 
 * It is the responsibility of the user to rollback the transaction. If the user does nothing,
 * the transaction will automatically abort server side and the change will not be committed.
 */

-- Now rollback the transaction and verify that there was no permanent change
SET STATEMENT_TIMEOUT=null;
ROLLBACK;

@EXPECT RESULT_SET
SELECT LastName AS ACTUAL, 'Last 1' AS EXPECTED
FROM Singers
WHERE SingerId=1;
