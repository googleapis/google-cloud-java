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

-- check that the default is null
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','0'
SHOW STATEMENT_TIMEOUT;
-- set a new value
SET STATEMENT_TIMEOUT='1000ms';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1s'
SHOW STATEMENT_TIMEOUT;
-- do a simple select and verify that the timeout does not change
SELECT 1 AS TEST;
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1s'
SHOW STATEMENT_TIMEOUT;
-- set a value that contains a fraction of a second
SET STATEMENT_TIMEOUT='1800ms';
-- check that the jdbc driver reports the value that is set, although under water the JDBC connection will round it to a whole second
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1800ms'
SHOW STATEMENT_TIMEOUT;
-- set a value that is just above a whole second
SET STATEMENT_TIMEOUT='1ms';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1ms'
SHOW STATEMENT_TIMEOUT;
-- set a value that contains a whole second
SET STATEMENT_TIMEOUT='3s';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','3s'
SHOW STATEMENT_TIMEOUT;
-- set a value to a higher value
SET STATEMENT_TIMEOUT='2999ms';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','2999ms'
SHOW STATEMENT_TIMEOUT;
-- Check that setting the value to 0 is allowed
SET STATEMENT_TIMEOUT='0s';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','0'
SHOW STATEMENT_TIMEOUT;
-- Set a timeout value and then reset it to null
SET STATEMENT_TIMEOUT='1s';
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1s'
SHOW STATEMENT_TIMEOUT;
SET STATEMENT_TIMEOUT=default;
@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','0'
SHOW STATEMENT_TIMEOUT;
