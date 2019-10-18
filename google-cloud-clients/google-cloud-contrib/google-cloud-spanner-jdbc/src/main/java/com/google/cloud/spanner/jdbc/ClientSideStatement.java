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

import com.google.cloud.spanner.ResultSet;
import java.util.List;

/**
 * A {@link ClientSideStatement} is a statement that is not sent to Google Cloud Spanner, but that
 * is executed locally to for example set a certain state of a {@link Connection} or get a property
 * of a {@link Connection}.
 */
interface ClientSideStatement {

  /**
   * @return a list of example statements for this {@link ClientSideStatement}. If these statements
   *     are parsed, they will all result this in this {@link ClientSideStatement}.
   */
  List<String> getExampleStatements();

  /**
   * @return a list of statements that need to be executed on a new connection before the example
   *     statements may be executed on a connection. For GET READ_TIMESTAMP this would for example
   *     be a couple of statements that generate a read-only transaction.
   */
  List<String> getExamplePrerequisiteStatements();

  /**
   * @return <code>true</code> if this {@link ClientSideStatement} will return a {@link ResultSet}.
   */
  boolean isQuery();

  /** @return <code>true</code> if this {@link ClientSideStatement} will return an update count. */
  boolean isUpdate();

  /**
   * Execute this {@link ClientSideStatement} on the given {@link ConnectionStatementExecutor}. The
   * executor calls the appropriate method(s) on the {@link Connection}. The statement argument is
   * used to parse any additional properties that might be needed for the execution.
   *
   * @param executor The {@link ConnectionStatementExecutor} that will be used to call a method on
   *     the {@link Connection}.
   * @param statement The original sql statement that has been parsed to this {@link
   *     ClientSideStatement}. This statement is used to get any additional arguments that are
   *     needed for the execution of the {@link ClientSideStatement}.
   * @return the result of the execution of the statement.
   */
  StatementResult execute(ConnectionStatementExecutor executor, String statement);
}
