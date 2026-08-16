/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

SELECT
  pk.table_catalog        AS PKTABLE_CAT,
  pk.table_schema         AS PKTABLE_SCHEM,
  pk.table_name           AS PKTABLE_NAME,
  pk.column_name          AS PKCOLUMN_NAME,
  fk.table_catalog        AS FKTABLE_CAT,
  fk.table_schema         AS FKTABLE_SCHEM,
  fk.table_name           AS FKTABLE_NAME,
  fk.column_name          AS FKCOLUMN_NAME,
  fk.ordinal_position     AS KEY_SEQ,
  1                       AS UPDATE_RULE,
  1                       AS DELETE_RULE,
  REGEXP_EXTRACT(fk.constraint_name, r'[^.]+$') AS FK_NAME,
  REGEXP_EXTRACT(pk.constraint_name, r'[^.]+$') AS PK_NAME,
  7                       AS DEFERRABILITY
FROM `%1$s.%2$s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE` AS pk
JOIN `%1$s.%2$s.INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE` AS ccu
  ON ccu.table_catalog = pk.table_catalog
 AND ccu.table_schema  = pk.table_schema
 AND ccu.table_name    = pk.table_name
 AND ccu.column_name   = pk.column_name
JOIN `%1$s.%2$s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE` AS fk
  ON fk.constraint_catalog = ccu.constraint_catalog
 AND fk.constraint_schema  = ccu.constraint_schema
 AND fk.constraint_name    = ccu.constraint_name
 AND fk.position_in_unique_constraint = pk.ordinal_position
JOIN `%1$s.%2$s.INFORMATION_SCHEMA.TABLE_CONSTRAINTS` AS tc
  ON tc.constraint_catalog = fk.constraint_catalog
 AND tc.constraint_schema  = fk.constraint_schema
 AND tc.constraint_name    = fk.constraint_name
 AND tc.constraint_type    = 'FOREIGN KEY'
WHERE CASE WHEN pk.table_name = '%3$s' THEN 1 ELSE 0 END = 1
  AND pk.position_in_unique_constraint IS NULL
ORDER BY fk.table_schema, fk.table_name, fk.ordinal_position