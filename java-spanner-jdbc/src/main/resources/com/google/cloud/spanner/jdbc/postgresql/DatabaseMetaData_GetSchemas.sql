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

SELECT SCHEMA_NAME AS "TABLE_SCHEM", CATALOG_NAME AS "TABLE_CATALOG"
FROM INFORMATION_SCHEMA.SCHEMATA
WHERE UPPER(COALESCE(CATALOG_NAME, '')) LIKE ?
  AND UPPER(SCHEMA_NAME) LIKE ?
ORDER BY CATALOG_NAME, SCHEMA_NAME
