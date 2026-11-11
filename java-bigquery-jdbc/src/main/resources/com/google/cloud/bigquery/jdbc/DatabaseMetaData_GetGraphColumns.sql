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

WITH props AS (
  SELECT
    property_graph_catalog AS TABLE_CAT,
    property_graph_schema AS TABLE_SCHEM,
    CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name')) AS TABLE_NAME,
    JSON_VALUE(p, '$.name') AS COLUMN_NAME,
    JSON_VALUE(p, '$.dataType.typeKind') AS TYPE_KIND,
    TO_JSON_STRING(JSON_QUERY(p, '$.dataType')) AS DATA_TYPE_JSON,
    JSON_VALUE(p, '$.expression') AS EXPRESSION,
    JSON_VALUE(p, '$.expressionKind') AS EXPRESSION_KIND,
    JSON_VALUE(p, '$.info.description') AS DESCRIPTION,
    (lp_off * 100000) + p_off AS first_seen
  FROM `%1$s.%2$s.INFORMATION_SCHEMA.PROPERTY_GRAPHS`,
    UNNEST([STRUCT(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.nodeTables') AS arr),
            STRUCT(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.edgeTables') AS arr)]) k,
    UNNEST(k.arr) t,
    UNNEST(JSON_QUERY_ARRAY(t, '$.labelAndProperties')) lp WITH OFFSET lp_off,
    UNNEST(JSON_QUERY_ARRAY(lp, '$.properties')) p WITH OFFSET p_off
  WHERE LOWER(property_graph_schema) LIKE LOWER(?)
    AND LOWER(CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name'))) LIKE LOWER(?)
),
numbered AS (
  SELECT
    TABLE_CAT,
    TABLE_SCHEM,
    TABLE_NAME,
    COLUMN_NAME,
    ANY_VALUE(TYPE_KIND HAVING MIN first_seen) AS TYPE_KIND,
    ANY_VALUE(DATA_TYPE_JSON HAVING MIN first_seen) AS DATA_TYPE_JSON,
    ANY_VALUE(EXPRESSION HAVING MIN first_seen) AS EXPRESSION,
    ANY_VALUE(EXPRESSION_KIND HAVING MIN first_seen) AS EXPRESSION_KIND,
    ANY_VALUE(DESCRIPTION HAVING MIN first_seen) AS DESCRIPTION,
    ROW_NUMBER() OVER (PARTITION BY TABLE_CAT, TABLE_SCHEM, TABLE_NAME ORDER BY MIN(first_seen)) AS ORDINAL_POSITION
  FROM props
  GROUP BY TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME
)
SELECT
  TABLE_CAT,
  TABLE_SCHEM,
  TABLE_NAME,
  COLUMN_NAME,
  TYPE_KIND,
  DATA_TYPE_JSON,
  EXPRESSION,
  EXPRESSION_KIND,
  DESCRIPTION,
  ORDINAL_POSITION
FROM numbered
WHERE LOWER(COLUMN_NAME) LIKE LOWER(?)