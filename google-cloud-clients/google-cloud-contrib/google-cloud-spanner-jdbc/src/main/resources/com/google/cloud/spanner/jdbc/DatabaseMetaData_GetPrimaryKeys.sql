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

SELECT IDX.TABLE_CATALOG AS TABLE_CAT, IDX.TABLE_SCHEMA AS TABLE_SCHEM, IDX.TABLE_NAME AS TABLE_NAME,
       COLS.COLUMN_NAME AS COLUMN_NAME, ORDINAL_POSITION AS KEY_SEQ, IDX.INDEX_NAME AS PK_NAME
FROM INFORMATION_SCHEMA.INDEXES IDX
INNER JOIN INFORMATION_SCHEMA.INDEX_COLUMNS COLS 
        ON  IDX.TABLE_CATALOG=COLS.TABLE_CATALOG
        AND IDX.TABLE_SCHEMA=COLS.TABLE_SCHEMA
        AND IDX.TABLE_NAME=COLS.TABLE_NAME
        AND IDX.INDEX_NAME=COLS.INDEX_NAME
WHERE IDX.INDEX_TYPE='PRIMARY_KEY'
  AND UPPER(IDX.TABLE_CATALOG) LIKE ?
  AND UPPER(IDX.TABLE_SCHEMA) LIKE ?
  AND UPPER(IDX.TABLE_NAME) LIKE ?
ORDER BY COLS.ORDINAL_POSITION