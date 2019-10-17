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
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;

/** Interface for interceptors that are invoked before a statement is executed. */
interface StatementExecutionInterceptor {
  void intercept(ParsedStatement statement, StatementExecutionStep step, UnitOfWork transaction);
}

/**
 * Enum passed in to a {@link StatementExecutionInterceptor} to determine what/why a statement is
 * being executed.
 */
enum StatementExecutionStep {
  /** The initial execution of a statement (DML/Query). */
  EXECUTE_STATEMENT,
  /** A call to {@link ResultSet#next()}. */
  CALL_NEXT_ON_RESULT_SET,
  /** Execution of the statement during an internal transaction retry. */
  RETRY_STATEMENT,
  /** A call to {@link ResultSet#next()} during internal transaction retry. */
  RETRY_NEXT_ON_RESULT_SET;
}
