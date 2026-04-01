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

import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import java.lang.reflect.Method;

/**
 * Executor to use for statements that do not set a value and do not have any parameters, such as
 * SHOW AUTOCOMMIT. The executor just calls a method with no parameters.
 */
class ClientSideStatementNoParamExecutor implements ClientSideStatementExecutor {
  private final Method method;

  /**
   * Creates and compiles the given {@link ClientSideStatementImpl}.
   *
   * @param statement The statement to compile.
   * @throws CompileException If the statement could not be compiled. This should never happen, as
   *     it would indicate that an invalid statement has been defined in the source file.
   */
  ClientSideStatementNoParamExecutor(ClientSideStatementImpl statement) throws CompileException {
    try {
      this.method = ConnectionStatementExecutor.class.getDeclaredMethod(statement.getMethodName());
    } catch (NoSuchMethodException | SecurityException e) {
      throw new CompileException(e, statement);
    }
  }

  @Override
  public StatementResult execute(ConnectionStatementExecutor connection, ParsedStatement statement)
      throws Exception {
    return (StatementResult) method.invoke(connection);
  }
}
