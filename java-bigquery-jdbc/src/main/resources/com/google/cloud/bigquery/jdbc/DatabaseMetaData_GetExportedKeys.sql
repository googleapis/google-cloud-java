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

SELECT referenced_table_catalog AS PKTABLE_CAT,
       referenced_table_schema  AS PKTABLE_SCHEM,
       referenced_table_name    AS PKTABLE_NAME,
       referenced_column_name   AS PKCOLUMN_NAME,
       table_catalog            AS FKTABLE_CAT,
       table_schema             AS FKTABLE_SCHEM,
       table_name               AS FKTABLE_NAME,
       column_name              AS FKCOLUMN_NAME,
       ordinal_position         AS KEY_SEQ,
       NULL                     AS UPDATE_RULE,
       NULL                     AS DELETE_RULE,
       constraint_name          AS FK_NAME,
       NULL                     AS PK_NAME,
       NULL                     AS DEFERRABILITY
FROM `%1$s.%2$s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE`
WHERE referenced_table_name = ?
ORDER BY FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, KEY_SEQ
