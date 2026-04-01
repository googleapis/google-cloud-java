/*
 * Copyright 2024 Google LLC
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

/** Enum used for setting the behavior of DDL in read/write transactions. */
public enum DdlInTransactionMode {
  /** All DDL statements in a read/write transaction fail. */
  FAIL,
  /**
   * DDL statements in an empty transaction are allowed. That is; if the connection is in
   * AutoCommit=false mode and no other statement has been executed, then executing a DDL statement
   * or a DDL batch is allowed.
   */
  ALLOW_IN_EMPTY_TRANSACTION,
  /**
   * DDL statements automatically cause the current transaction to be committed and the DDL
   * statement is subsequently executed without a transaction. This is equal to how MySQL and Oracle
   * behave.
   */
  AUTO_COMMIT_TRANSACTION;
}
