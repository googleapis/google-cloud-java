/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

class IsolationLevelConverter {
  static IsolationLevel convertToSpanner(int jdbcIsolationLevel) throws SQLException {
    switch (jdbcIsolationLevel) {
      case Connection.TRANSACTION_SERIALIZABLE:
        return IsolationLevel.SERIALIZABLE;
      case Connection.TRANSACTION_REPEATABLE_READ:
        return IsolationLevel.REPEATABLE_READ;
      case Connection.TRANSACTION_READ_COMMITTED:
      case Connection.TRANSACTION_READ_UNCOMMITTED:
      case Connection.TRANSACTION_NONE:
        throw new SQLFeatureNotSupportedException(
            "Unsupported JDBC isolation level: " + jdbcIsolationLevel);
      default:
        throw new IllegalArgumentException("Invalid JDBC isolation level: " + jdbcIsolationLevel);
    }
  }

  static int convertToJdbc(IsolationLevel isolationLevel) {
    switch (isolationLevel) {
      // Translate UNSPECIFIED to SERIALIZABLE as that is the default isolation level.
      case ISOLATION_LEVEL_UNSPECIFIED:
      case SERIALIZABLE:
        return Connection.TRANSACTION_SERIALIZABLE;
      case REPEATABLE_READ:
        return Connection.TRANSACTION_REPEATABLE_READ;
      default:
        throw new IllegalArgumentException(
            "Unknown or unsupported isolation level: " + isolationLevel);
    }
  }
}
