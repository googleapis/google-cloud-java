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

package com.google.cloud.spanner.connection;

import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.util.Objects;

/**
 * Enum for the possible PostgreSQL transaction modes. We need a separate class for PG transaction
 * modes to handle setting the isolation level.
 */
class PgTransactionMode {
  enum AccessMode {
    READ_ONLY_TRANSACTION("READ ONLY"),
    READ_WRITE_TRANSACTION("READ WRITE");

    private final String statementString;

    AccessMode(String statement) {
      this.statementString = statement;
    }

    @Override
    public String toString() {
      return statementString;
    }
  }

  enum IsolationLevel {
    ISOLATION_LEVEL_DEFAULT(
        "ISOLATION LEVEL DEFAULT",
        "DEFAULT",
        TransactionOptions.IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED),
    ISOLATION_LEVEL_SERIALIZABLE(
        "ISOLATION LEVEL SERIALIZABLE",
        "SERIALIZABLE",
        TransactionOptions.IsolationLevel.SERIALIZABLE),
    ISOLATION_LEVEL_REPEATABLE_READ(
        "ISOLATION LEVEL REPEATABLE READ",
        "REPEATABLE READ",
        TransactionOptions.IsolationLevel.REPEATABLE_READ);

    private final String statementString;
    private final String shortStatementString;
    private final TransactionOptions.IsolationLevel spannerIsolationLevel;

    IsolationLevel(
        String statement,
        String shortStatementString,
        TransactionOptions.IsolationLevel spannerIsolationLevel) {
      this.statementString = statement;
      this.shortStatementString = shortStatementString;
      this.spannerIsolationLevel = spannerIsolationLevel;
    }

    /**
     * Use this method to get the correct format for use in a SQL statement. The SQL statement for
     * setting the mode to read-only should for example be without the underscore: <code>
     * SET TRANSACTION READ ONLY</code>
     *
     * @return a string representation of this {@link TransactionMode} that can be used in a SQL
     *     statement to set the transaction mode.
     */
    public String getStatementString() {
      return statementString;
    }

    public String getShortStatementString() {
      return shortStatementString;
    }

    public TransactionOptions.IsolationLevel getSpannerIsolationLevel() {
      return spannerIsolationLevel;
    }

    @Override
    public String toString() {
      return statementString;
    }
  }

  private AccessMode accessMode;
  private IsolationLevel isolationLevel;

  PgTransactionMode() {}

  AccessMode getAccessMode() {
    return this.accessMode;
  }

  void setAccessMode(AccessMode accessMode) {
    this.accessMode = accessMode;
  }

  IsolationLevel getIsolationLevel() {
    return this.isolationLevel;
  }

  void setIsolationLevel(IsolationLevel isolationLevel) {
    this.isolationLevel = isolationLevel;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.accessMode, this.isolationLevel);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PgTransactionMode)) {
      return false;
    }
    PgTransactionMode other = (PgTransactionMode) o;
    return Objects.equals(this.accessMode, other.accessMode)
        && Objects.equals(this.isolationLevel, other.isolationLevel);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (accessMode != null) {
      result.append(accessMode.statementString);
    }
    if (isolationLevel != null) {
      if (accessMode != null) {
        result.append(' ');
      }
      result.append(isolationLevel.statementString);
    }
    return result.toString();
  }
}
