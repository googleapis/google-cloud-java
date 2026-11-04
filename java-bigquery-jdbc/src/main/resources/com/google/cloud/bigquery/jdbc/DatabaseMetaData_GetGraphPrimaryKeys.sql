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
  property_graph_catalog AS TABLE_CAT,
  property_graph_schema AS TABLE_SCHEM,
  CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name')) AS TABLE_NAME,
  JSON_VALUE(kc) AS COLUMN_NAME,
  kc_off + 1 AS KEY_SEQ,
  CAST(NULL AS STRING) AS PK_NAME
FROM `%1$s.%2$s.INFORMATION_SCHEMA.PROPERTY_GRAPHS`,
UNNEST(ARRAY_CONCAT(
  IFNULL(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.nodeTables'), []),
  IFNULL(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.edgeTables'), []))) AS t,
UNNEST(JSON_QUERY_ARRAY(t, '$.keyColumns')) AS kc WITH OFFSET kc_off
WHERE CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name')) = ?
ORDER BY COLUMN_NAME