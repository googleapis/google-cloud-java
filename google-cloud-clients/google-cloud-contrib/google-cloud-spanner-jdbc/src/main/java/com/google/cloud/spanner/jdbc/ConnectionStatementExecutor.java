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

import com.google.cloud.spanner.TimestampBound;
import com.google.protobuf.Duration;

/**
 * The Cloud Spanner JDBC driver supports a number of client side statements that are interpreted by
 * the driver and that can modify the current state of a connection, or report the current state of
 * a connection. Each of the methods in this interface correspond with one such client side
 * statement.
 *
 * <p>The methods in this interface are called by the different {@link ClientSideStatement}s. These
 * method calls are then forwarded into the appropriate method of a {@link Connection} instance.
 *
 * <p>The client side statements are defined in the ClientSideStatements.json file.
 */
interface ConnectionStatementExecutor {

  StatementResult statementSetAutocommit(Boolean autocommit);

  StatementResult statementShowAutocommit();

  StatementResult statementSetReadOnly(Boolean readOnly);

  StatementResult statementShowReadOnly();

  StatementResult statementSetRetryAbortsInternally(Boolean retryAbortsInternally);

  StatementResult statementShowRetryAbortsInternally();

  StatementResult statementSetAutocommitDmlMode(AutocommitDmlMode mode);

  StatementResult statementShowAutocommitDmlMode();

  StatementResult statementSetStatementTimeout(Duration duration);

  StatementResult statementShowStatementTimeout();

  StatementResult statementShowReadTimestamp();

  StatementResult statementShowCommitTimestamp();

  StatementResult statementSetReadOnlyStaleness(TimestampBound staleness);

  StatementResult statementShowReadOnlyStaleness();

  StatementResult statementBeginTransaction();

  StatementResult statementCommit();

  StatementResult statementRollback();

  StatementResult statementSetTransactionMode(TransactionMode mode);

  StatementResult statementStartBatchDdl();

  StatementResult statementStartBatchDml();

  StatementResult statementRunBatch();

  StatementResult statementAbortBatch();
}
