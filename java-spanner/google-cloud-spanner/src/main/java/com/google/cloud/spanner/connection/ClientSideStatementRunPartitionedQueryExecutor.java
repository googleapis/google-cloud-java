/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

/** Executor for <code>RUN PARTITIONED QUERY &lt;sql&gt;</code> statements. */
class ClientSideStatementRunPartitionedQueryExecutor implements ClientSideStatementExecutor {
  private final ClientSideStatementImpl statement;
  private final Method method;

  ClientSideStatementRunPartitionedQueryExecutor(ClientSideStatementImpl statement)
      throws CompileException {
    try {
      this.statement = statement;
      this.method =
          ConnectionStatementExecutor.class.getDeclaredMethod(
              statement.getMethodName(), Statement.class);
    } catch (Exception e) {
      throw new CompileException(e, statement);
    }
  }

  @Override
  public StatementResult execute(
      ConnectionStatementExecutor connection, ParsedStatement parsedStatement) throws Exception {
    String sql = getParameterValue(parsedStatement);
    return (StatementResult)
        method.invoke(connection, parsedStatement.getStatement().toBuilder().replace(sql).build());
  }

  String getParameterValue(ParsedStatement parsedStatement) {
    Matcher matcher = statement.getPattern().matcher(parsedStatement.getSql());
    if (matcher.find() && matcher.groupCount() >= 2) {
      // Include the spacing group in case the query is enclosed in parentheses like this:
      // `run partitioned query(select * from foo)`
      String space = matcher.group(1);
      String value = matcher.group(2);
      return (space + value).trim();
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        String.format(
            "Invalid argument for RUN PARTITIONED QUERY: %s",
            parsedStatement.getStatement().getSql()));
  }
}
