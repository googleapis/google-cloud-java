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
    property_graph_catalog AS cat, property_graph_schema AS sch,
    CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name')) AS tbl,
    JSON_VALUE(p, '$.name') AS col,
    JSON_VALUE(p, '$.dataType.typeKind') AS type_kind,
    TO_JSON_STRING(JSON_QUERY(p, '$.dataType')) AS data_type_json,
    JSON_VALUE(p, '$.expression') AS expression,
    JSON_VALUE(p, '$.expressionKind') AS expression_kind,
    JSON_VALUE(p, '$.info.description') AS description,
    (lp_off * 100000) + p_off AS first_seen
  FROM `%1$s.%2$s.INFORMATION_SCHEMA.PROPERTY_GRAPHS`,
    UNNEST([STRUCT(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.nodeTables') AS arr),
            STRUCT(JSON_QUERY_ARRAY(property_graph_metadata_json, '$.edgeTables') AS arr)]) k,
    UNNEST(k.arr) t,
    UNNEST(JSON_QUERY_ARRAY(t, '$.labelAndProperties')) lp WITH OFFSET lp_off,
    UNNEST(JSON_QUERY_ARRAY(lp, '$.properties')) p WITH OFFSET p_off
  WHERE LOWER(property_graph_schema) LIKE LOWER(?)
    AND LOWER(CONCAT(property_graph_name, '.', JSON_VALUE(t, '$.name'))) LIKE LOWER(?)
    AND LOWER(JSON_VALUE(p, '$.name')) LIKE LOWER(?)
)
SELECT cat, sch, tbl, col,
  ANY_VALUE(type_kind HAVING MIN first_seen) AS type_kind,
  ANY_VALUE(data_type_json HAVING MIN first_seen) AS data_type_json,
  ANY_VALUE(expression HAVING MIN first_seen) AS expression,
  ANY_VALUE(expression_kind HAVING MIN first_seen) AS expression_kind,
  ANY_VALUE(description HAVING MIN first_seen) AS description,
  ROW_NUMBER() OVER (PARTITION BY cat, sch, tbl ORDER BY MIN(first_seen)) AS ordinal
FROM props
GROUP BY cat, sch, tbl, col