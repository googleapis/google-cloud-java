/*
 * Copyright 2022 Google LLC
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

SELECT TABLE_CATALOG AS "TABLE_CAT", TABLE_SCHEMA AS "TABLE_SCHEM", TABLE_NAME AS "TABLE_NAME", COLUMN_NAME AS "COLUMN_NAME",
       CASE
           WHEN DATA_TYPE LIKE 'ARRAY' THEN 2003
           WHEN DATA_TYPE = 'boolean' THEN 16
           WHEN DATA_TYPE LIKE 'bytea' THEN -2
           WHEN DATA_TYPE = 'date' THEN 91
           WHEN DATA_TYPE = 'double precision' THEN 8
           WHEN DATA_TYPE = 'real' THEN 7
           WHEN DATA_TYPE = 'bigint' THEN -5
           WHEN DATA_TYPE = 'numeric' THEN 2
           WHEN DATA_TYPE LIKE 'character varying' THEN -9
           WHEN DATA_TYPE = 'jsonb' THEN -9
           WHEN DATA_TYPE = 'timestamp with time zone' THEN 93
           END AS "DATA_TYPE",
       CASE
           WHEN DATA_TYPE LIKE 'ARRAY' THEN
               CASE
                   WHEN spanner_type LIKE '%[]' THEN
                       CONCAT('_'::varchar, REPLACE(spanner_type, '[]'::varchar, ''::varchar))
                   ELSE spanner_type
                   END
           ELSE DATA_TYPE
           END AS "TYPE_NAME",
       CASE
           WHEN DATA_TYPE LIKE 'ARRAY' THEN 0
           WHEN DATA_TYPE = 'boolean' THEN NULL
           WHEN DATA_TYPE LIKE 'bytea' THEN 10485760
           WHEN DATA_TYPE = 'date' THEN 10
           WHEN DATA_TYPE = 'double precision' THEN 15
           WHEN DATA_TYPE = 'real' THEN 15
           WHEN DATA_TYPE = 'bigint' THEN 19
           WHEN DATA_TYPE = 'numeric' THEN 15
           WHEN DATA_TYPE LIKE 'character varying' THEN CHARACTER_MAXIMUM_LENGTH
           WHEN DATA_TYPE = 'jsonb' THEN CHARACTER_MAXIMUM_LENGTH
           WHEN DATA_TYPE = 'timestamp with time zone' THEN 35
           END AS "COLUMN_SIZE",
       0 AS "BUFFER_LENGTH",
       CASE
           WHEN DATA_TYPE LIKE 'double precision' THEN 16
           WHEN DATA_TYPE LIKE 'real' THEN 16
           WHEN DATA_TYPE LIKE 'numeric' THEN 16383
           ELSE NULL
           END AS "DECIMAL_DIGITS",
       CASE
           WHEN DATA_TYPE LIKE 'bigint' THEN 10
           WHEN DATA_TYPE LIKE 'numeric' THEN 10
           WHEN DATA_TYPE LIKE 'double precision' THEN 2
           WHEN DATA_TYPE LIKE 'real' THEN 2
           ELSE NULL
           END AS "NUM_PREC_RADIX",
       CASE
           WHEN IS_NULLABLE = 'YES' THEN 1
           WHEN IS_NULLABLE = 'NO' THEN 0
           ELSE 2
           END AS "NULLABLE",
       NULL AS "REMARKS",
       COLUMN_DEFAULT AS "COLUMN_DEF",
       0 AS "SQL_DATA_TYPE",
       0 AS "SQL_DATETIME_SUB",
       CHARACTER_MAXIMUM_LENGTH AS "CHAR_OCTET_LENGTH",
       ORDINAL_POSITION AS "ORDINAL_POSITION",
       IS_NULLABLE AS "IS_NULLABLE",
       NULL AS "SCOPE_CATALOG",
       NULL AS "SCOPE_SCHEMA",
       NULL AS "SCOPE_TABLE",
       NULL AS "SOURCE_DATA_TYPE",
       IS_IDENTITY AS "IS_AUTOINCREMENT",
       CASE
           WHEN (IS_GENERATED = 'NEVER') THEN 'NO'
           ELSE 'YES'
        END AS "IS_GENERATEDCOLUMN"
FROM INFORMATION_SCHEMA.COLUMNS C
WHERE UPPER(COALESCE(C.TABLE_CATALOG, '')) LIKE ?
  AND UPPER(C.TABLE_SCHEMA) LIKE ?
  AND UPPER(C.TABLE_NAME) LIKE ?
  AND UPPER(C.COLUMN_NAME) LIKE ?
ORDER BY TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, ORDINAL_POSITION
