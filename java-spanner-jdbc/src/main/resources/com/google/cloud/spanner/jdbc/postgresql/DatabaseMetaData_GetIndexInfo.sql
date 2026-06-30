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

SELECT IDX.TABLE_CATALOG AS "TABLE_CAT", IDX.TABLE_SCHEMA AS "TABLE_SCHEM", IDX.TABLE_NAME AS "TABLE_NAME",
       CASE WHEN IS_UNIQUE='YES' THEN FALSE ELSE TRUE END AS "NON_UNIQUE",
       IDX.TABLE_CATALOG AS "INDEX_QUALIFIER", IDX.INDEX_NAME AS "INDEX_NAME",
       2 AS "TYPE",
       ORDINAL_POSITION AS "ORDINAL_POSITION", COLUMN_NAME AS "COLUMN_NAME", SUBSTR(COLUMN_ORDERING, 1, 1) AS "ASC_OR_DESC",
       -1 AS "CARDINALITY", -- Not supported
       -1 AS "PAGES", -- Not supported
       NULL AS "FILTER_CONDITION"
FROM INFORMATION_SCHEMA.INDEXES IDX
INNER JOIN INFORMATION_SCHEMA.INDEX_COLUMNS COL
            ON  COALESCE(IDX.TABLE_CATALOG, '')=COALESCE(COL.TABLE_CATALOG, '')
                AND IDX.TABLE_SCHEMA=COL.TABLE_SCHEMA
                AND IDX.TABLE_NAME=COL.TABLE_NAME
                AND IDX.INDEX_NAME=COL.INDEX_NAME
WHERE UPPER(COALESCE(IDX.TABLE_CATALOG, '')) LIKE ?
  AND UPPER(IDX.TABLE_SCHEMA) LIKE ?
  AND UPPER(IDX.TABLE_NAME) LIKE ?
  AND UPPER(IDX.INDEX_NAME) LIKE ?
  AND UPPER(IS_UNIQUE) LIKE ?
ORDER BY IDX.TABLE_NAME, IS_UNIQUE DESC, IDX.INDEX_NAME, CASE WHEN ORDINAL_POSITION IS NULL THEN 0 ELSE ORDINAL_POSITION END
