/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.IsolationLevelConverter;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

/** Executor for BEGIN TRANSACTION [ISOLATION LEVEL SERIALIZABLE|REPEATABLE READ] statements. */
class ClientSideStatementBeginExecutor implements ClientSideStatementExecutor {
  private final ClientSideStatementImpl statement;
  private final Method method;
  private final IsolationLevelConverter converter;

  ClientSideStatementBeginExecutor(ClientSideStatementImpl statement) throws CompileException {
    try {
      this.statement = statement;
      this.converter = new IsolationLevelConverter();
      this.method =
          ConnectionStatementExecutor.class.getDeclaredMethod(
              statement.getMethodName(), converter.getParameterClass());
    } catch (Exception e) {
      throw new CompileException(e, statement);
    }
  }

  @Override
  public StatementResult execute(ConnectionStatementExecutor connection, ParsedStatement statement)
      throws Exception {
    return (StatementResult) method.invoke(connection, getParameterValue(statement.getSql()));
  }

  IsolationLevel getParameterValue(String sql) {
    Matcher matcher = statement.getPattern().matcher(sql);
    // Match the 'isolation level (serializable|repeatable read)' part.
    // Group 1 is the isolation level.
    if (matcher.find() && matcher.groupCount() >= 1) {
      String value = matcher.group(1);
      if (value != null) {
        // Convert the text to an isolation level enum.
        // This returns null if the string is not a valid isolation level value.
        IsolationLevel res = converter.convert(value.trim());
        if (res != null) {
          return res;
        }
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, String.format("Unknown isolation level: %s", value));
      }
    }
    return null;
  }
}
