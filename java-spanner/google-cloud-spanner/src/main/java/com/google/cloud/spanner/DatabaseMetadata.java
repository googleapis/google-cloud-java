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
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.util.Objects;

/**
 * Internal container for dynamic database-level defaults queried from
 * INFORMATION_SCHEMA.DATABASE_OPTIONS. Holds the database dialect, default transaction isolation
 * level, and default read lock mode.
 */
final class DatabaseMetadata {
  private final Dialect dialect;
  private final IsolationLevel isolationLevel;
  private final ReadLockMode readLockMode;

  DatabaseMetadata(Dialect dialect, IsolationLevel isolationLevel, ReadLockMode readLockMode) {
    this.dialect = Objects.requireNonNull(dialect);
    this.isolationLevel = Objects.requireNonNull(isolationLevel);
    this.readLockMode = Objects.requireNonNull(readLockMode);
  }

  Dialect getDialect() {
    return dialect;
  }

  IsolationLevel getIsolationLevel() {
    return isolationLevel;
  }

  ReadLockMode getReadLockMode() {
    return readLockMode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabaseMetadata that = (DatabaseMetadata) o;
    return dialect == that.dialect
        && isolationLevel == that.isolationLevel
        && readLockMode == that.readLockMode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dialect, isolationLevel, readLockMode);
  }

  @Override
  public String toString() {
    return String.format(
        "DatabaseMetadata{dialect=%s, isolation=%s, lockMode=%s}",
        dialect, isolationLevel, readLockMode);
  }
}
