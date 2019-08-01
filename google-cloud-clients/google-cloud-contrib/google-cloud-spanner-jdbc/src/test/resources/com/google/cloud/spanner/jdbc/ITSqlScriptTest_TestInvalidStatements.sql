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
 * Script for testing invalid/unrecognized statements
 */

-- PostgreSQL MERGE statement
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement: MERGE'
MERGE INTO wines w
USING (VALUES('Chateau Lafite 2003', '24')) v
ON v.column1 = w.winename
WHEN NOT MATCHED 
  INSERT VALUES(v.column1, v.column2)
WHEN MATCHED
  UPDATE SET stock = stock + v.column2;

-- EXPAIN statement
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement: EXPLAIN'
EXPLAIN SELECT *
FROM Singers;

-- EXPAIN ANALYZE statement
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement: EXPLAIN ANALYZE'
EXPLAIN ANALYZE SELECT *
FROM Singers;

-- SET unknown property
@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement: SET some_property'
SET some_property='value';