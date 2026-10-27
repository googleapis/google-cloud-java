/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Database options that are read from {@code information_schema.database_options}. */
@NullMarked
final class DatabaseMetadata {
  static final String DATABASE_DIALECT_OPTION = "database_dialect";
  static final String DEFAULT_TRANSACTION_ISOLATION_OPTION = "default_transaction_isolation";

  // The values of default_transaction_isolation. Spanner accepts any case when the option is set,
  // and stores and returns these lower-case values for both GoogleSQL and PostgreSQL databases.
  static final String SERIALIZABLE_VALUE = "serializable";
  static final String REPEATABLE_READ_VALUE = "repeatable read";

  /** Reads all the options in {@link DatabaseMetadata} with a single query. */
  static final Statement STATEMENT =
      Statement.of(
          String.format(
              "select option_name, option_value from information_schema.database_options "
                  + "where option_name in ('%s', '%s')",
              DATABASE_DIALECT_OPTION, DEFAULT_TRANSACTION_ISOLATION_OPTION));

  private final Dialect dialect;
  private final IsolationLevel defaultIsolationLevel;

  private DatabaseMetadata(Dialect dialect, IsolationLevel defaultIsolationLevel) {
    this.dialect = dialect;
    this.defaultIsolationLevel = defaultIsolationLevel;
  }

  /**
   * Creates a {@link DatabaseMetadata} from the result of {@link #STATEMENT}. Options that are not
   * in the result keep the value that Spanner uses when the option has not been set.
   */
  static DatabaseMetadata fromResultSet(ResultSet resultSet) {
    Dialect dialect = Dialect.GOOGLE_STANDARD_SQL;
    IsolationLevel defaultIsolationLevel = IsolationLevel.SERIALIZABLE;
    while (resultSet.next()) {
      switch (resultSet.getString(0)) {
        case DATABASE_DIALECT_OPTION:
          dialect = Dialect.fromName(resultSet.getString(1));
          break;
        case DEFAULT_TRANSACTION_ISOLATION_OPTION:
          defaultIsolationLevel =
              parseIsolationLevel(resultSet.isNull(1) ? null : resultSet.getString(1));
          break;
        default:
          break;
      }
    }
    return new DatabaseMetadata(dialect, defaultIsolationLevel);
  }

  /**
   * Parses the value of the {@code default_transaction_isolation} option. {@code null} means that
   * the option has not been set. {@code null}, {@link #SERIALIZABLE_VALUE}, and unrecognized values
   * return {@link IsolationLevel#SERIALIZABLE}, which is the isolation level that Spanner uses when
   * the option has not been set.
   */
  private static IsolationLevel parseIsolationLevel(@Nullable String optionValue) {
    return REPEATABLE_READ_VALUE.equalsIgnoreCase(optionValue)
        ? IsolationLevel.REPEATABLE_READ
        : IsolationLevel.SERIALIZABLE;
  }

  Dialect getDialect() {
    return dialect;
  }

  IsolationLevel getDefaultIsolationLevel() {
    return defaultIsolationLevel;
  }
}
