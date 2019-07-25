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

package com.google.cloud.spanner.jdbc;

/** Enum used to define the transaction type of a {@link Connection} */
enum TransactionMode {
  READ_ONLY_TRANSACTION("READ ONLY"),
  READ_WRITE_TRANSACTION("READ WRITE");

  private final String statementString;

  private TransactionMode(String statement) {
    this.statementString = statement;
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

  @Override
  public String toString() {
    return statementString;
  }
}
