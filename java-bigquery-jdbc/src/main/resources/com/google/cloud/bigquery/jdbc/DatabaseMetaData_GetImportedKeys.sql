/*
 * Copyright 2024 Google LLC
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

SELECT PKTABLE_CAT,
       PKTABLE_SCHEM,
       PKTABLE_NAME,
       PRIMARY.column_name        AS PKCOLUMN_NAME,
       FOREIGN.constraint_catalog AS FKTABLE_CAT,
       FOREIGN.constraint_schema  AS FKTABLE_SCHEM,
       FOREIGN.table_name         AS FKTABLE_NAME,
       FOREIGN.column_name        AS FKCOLUMN_NAME,
       FOREIGN.ordinal_position   AS KEY_SEQ,
       NULL                       AS UPDATE_RULE,
       NULL                       AS DELETE_RULE,
       FOREIGN.constraint_name    AS FK_NAME,
       PRIMARY.constraint_name    AS PK_NAME,
       NULL                       AS DEFERRABILITY
FROM (SELECT DISTINCT CCU.table_catalog AS PKTABLE_CAT,
                      CCU.table_schema  AS PKTABLE_SCHEM,
                      CCU.table_name    AS PKTABLE_NAME,
                      TC.constraint_catalog,
                      TC.constraint_schema,
                      TC.constraint_name,
                      TC.table_catalog,
                      TC.table_schema,
                      TC.table_name,
                      TC.constraint_type,
                      KCU.column_name,
                      KCU.ordinal_position,
                      KCU.position_in_unique_constraint
      FROM `%1$s.%2$s.INFORMATION_SCHEMA.TABLE_CONSTRAINTS` TC
               INNER JOIN
           `%1$s.%2$s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE` KCU
           USING
               (constraint_catalog,
                constraint_schema,
                constraint_name,
                table_catalog,
                table_schema,
                table_name)
               INNER JOIN
           `%1$s.%2$s.INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE` CCU
           USING
               (constraint_catalog,
                constraint_schema,
                constraint_name)
      WHERE constraint_type = 'FOREIGN KEY'
        AND TC.table_name = '%3$s') FOREIGN
         INNER JOIN (SELECT *
                     FROM `%1$s.%2$s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE`
                     WHERE position_in_unique_constraint IS NULL) PRIMARY
ON
    FOREIGN.PKTABLE_CAT = PRIMARY.table_catalog
    AND FOREIGN.PKTABLE_SCHEM = PRIMARY.table_schema
    AND FOREIGN.PKTABLE_NAME = PRIMARY.table_name
    AND FOREIGN.position_in_unique_constraint =
    PRIMARY.ordinal_position
ORDER BY PKTABLE_CAT, PKTABLE_SCHEM, PKTABLE_NAME, KEY_SEQ