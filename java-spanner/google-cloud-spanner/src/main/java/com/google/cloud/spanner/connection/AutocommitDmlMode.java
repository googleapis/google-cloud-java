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

package com.google.cloud.spanner.connection;

/** Enum used to define the behavior of DML statements in autocommit mode */
public enum AutocommitDmlMode {
  /** TRANSACTIONAL: DML statements use a standard atomic transaction. */
  TRANSACTIONAL,
  /** PARTITIONED_NON_ATOMIC: DML statements use a Partitioned DML transaction. */
  PARTITIONED_NON_ATOMIC,
  /**
   * TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC: DML statements are first executed with a
   * standard atomic transaction. If that fails due to the mutation limit being exceeded, the
   * statement will automatically be retried using a Partitioned DML transaction. These statements
   * are not guaranteed to be atomic. The corresponding {@link TransactionRetryListener} methods
   * will be invoked when a DML statement falls back to Partitioned DML.
   */
  TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC;

  private final String statementString;

  AutocommitDmlMode() {
    this.statementString = name();
  }

  /**
   * Use this method to get the correct format for use in a SQL statement. Autocommit dml mode must
   * be wrapped between single quotes in SQL statements: <code>
   * SET AUTOCOMMIT_DML_MODE='TRANSACTIONAL'</code> This method returns the value
   * <strong>without</strong> the single quotes.
   *
   * @return a string representation of this {@link AutocommitDmlMode} that can be used in a SQL
   *     statement.
   */
  public String getStatementString() {
    return statementString;
  }
}
