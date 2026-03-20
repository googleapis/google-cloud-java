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

SELECT table_catalog    AS TABLE_CAT,
       table_schema     AS TABLE_SCHEM,
       table_name       AS TABLE_NAME,
       column_name      AS COLUMN_NAME,
       ordinal_position AS KEY_SEQ,
       constraint_name  AS PK_NAME
FROM
    %s.%s.INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE
    table_name = '%s'
  AND CONTAINS_SUBSTR(constraint_name
    , 'pk$')
ORDER BY
    COLUMN_NAME;
