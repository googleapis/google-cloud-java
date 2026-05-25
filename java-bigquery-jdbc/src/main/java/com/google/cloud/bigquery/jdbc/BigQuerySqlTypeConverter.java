/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.jdbc.BigQueryStatement.SqlType;

class BigQuerySqlTypeConverter {

  static SqlType getSqlTypeFromStatementType(StatementType statementType) {
    switch (statementType.toString()) {
      case "SELECT":
        return SqlType.SELECT;

      case "INSERT":
      case "UPDATE":
      case "DELETE":
      case "MERGE":
        return SqlType.DML;
      case "CALL":
        return SqlType.DML_EXTRA;

      case "CREATE_TABLE":
      case "CREATE_TABLE_AS_SELECT":
      case "CREATE_VIEW":
      case "CREATE_MODEL":
      case "CREATE_MATERIALIZED_VIEW":
      case "CREATE_FUNCTION":
      case "CREATE_TABLE_FUNCTION":
      case "CREATE_PROCEDURE":
      case "CREATE_ROW_ACCESS_POLICY":
      case "CREATE_SCHEMA":
      case "CREATE_SNAPSHOT_TABLE":
      case "CREATE_SEARCH_INDEX":
      case "DROP_TABLE":
      case "DROP_EXTERNAL_TABLE":
      case "DROP_VIEW":
      case "DROP_MODEL":
      case "DROP_MATERIALIZED_VIEW":
      case "DROP_FUNCTION":
      case "DROP_TABLE_FUNCTION":
      case "DROP_PROCEDURE":
      case "DROP_SEARCH_INDEX":
      case "DROP_SCHEMA":
      case "DROP_SNAPSHOT_TABLE":
      case "DROP_ROW_ACCESS_POLICY":
      case "ALTER_TABLE":
      case "ALTER_VIEW":
      case "ALTER_MATERIALIZED_VIEW":
      case "ALTER_SCHEMA":
      case "TRUNCATE_TABLE":
      case "CREATE_EXTERNAL_TABLE":
        return SqlType.DDL;
      case "SCRIPT":
        return SqlType.SCRIPT;
      case "BEGIN_TRANSACTION":
      case "COMMIT_TRANSACTION":
      case "ROLLBACK_TRANSACTION":
        return SqlType.TCL;
      case "EXPORT_DATA":
      case "EXPORT_MODEL":
      case "LOAD_DATA":
      default:
        return SqlType.OTHER;
    }
  }
}
