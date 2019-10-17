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

SELECT TABLE_CATALOG AS TABLE_CAT, TABLE_SCHEMA AS TABLE_SCHEM, TABLE_NAME,
       CASE WHEN TABLE_SCHEMA = '' THEN 'TABLE' ELSE 'VIEW' END AS TABLE_TYPE,
       NULL AS REMARKS, NULL AS TYPE_CAT, NULL AS TYPE_SCHEM, NULL AS TYPE_NAME,
       NULL AS SELF_REFERENCING_COL_NAME, NULL AS REF_GENERATION 
FROM INFORMATION_SCHEMA.TABLES AS T 
WHERE UPPER(TABLE_CATALOG) LIKE ?
  AND UPPER(TABLE_SCHEMA) LIKE ?
  AND UPPER(TABLE_NAME) LIKE ?
  AND (
    (CASE WHEN TABLE_SCHEMA = '' THEN 'TABLE' ELSE 'VIEW' END) LIKE ?
    OR
    (CASE WHEN TABLE_SCHEMA = '' THEN 'TABLE' ELSE 'VIEW' END) LIKE ?
  )
ORDER BY TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME