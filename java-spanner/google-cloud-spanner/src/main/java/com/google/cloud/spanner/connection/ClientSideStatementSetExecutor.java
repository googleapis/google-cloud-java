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

import com.google.cloud.Tuple;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.CharBuffer;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Executor for {@link ClientSideStatement}s that sets a value for a property, such as SET
 * AUTOCOMMIT=TRUE.
 */
class ClientSideStatementSetExecutor<T> implements ClientSideStatementExecutor {
  private final Cache<String, Tuple<T, Boolean>> cache;
  private final ClientSideStatementImpl statement;
  private final Method method;
  private final boolean supportsLocal;
  private final ClientSideStatementValueConverter<T> converter;
  private final Pattern allowedValuesPattern;

  /**
   * Creates and compiles the given {@link ClientSideStatementImpl}.
   *
   * @param statement The statement to compile.
   * @throws CompileException If the statement could not be compiled. This should never happen, as
   *     it would indicate that an invalid statement has been defined in the source file.
   */
  @SuppressWarnings("unchecked")
  ClientSideStatementSetExecutor(ClientSideStatementImpl statement) throws CompileException {
    Preconditions.checkNotNull(statement.getSetStatement());
    this.cache =
        CacheBuilder.newBuilder()
            .maximumSize(25)
            // Set the concurrency level to 1, as we don't expect many concurrent updates.
            .concurrencyLevel(1)
            .build();
    try {
      this.statement = statement;
      this.allowedValuesPattern =
          Pattern.compile(
              String.format(
                  "(?is)\\A\\s*set\\s+((?:local|session)\\s+)?%s\\s*%s\\s*%s\\s*\\z",
                  statement.getSetStatement().getPropertyName(),
                  statement.getSetStatement().getSeparator(),
                  statement.getSetStatement().getAllowedValues()));
      Class<ClientSideStatementValueConverter<T>> converterClass =
          (Class<ClientSideStatementValueConverter<T>>)
              Class.forName(
                  getClass().getPackage().getName()
                      + "."
                      + statement.getSetStatement().getConverterName());
      Constructor<ClientSideStatementValueConverter<T>> constructor =
          converterClass.getConstructor(String.class);
      this.converter = constructor.newInstance(statement.getSetStatement().getAllowedValues());
      Method method;
      boolean supportsLocal;
      try {
        method =
            ConnectionStatementExecutor.class.getDeclaredMethod(
                statement.getMethodName(), converter.getParameterClass());
        supportsLocal = false;
      } catch (NoSuchMethodException ignore) {
        method =
            ConnectionStatementExecutor.class.getDeclaredMethod(
                statement.getMethodName(), converter.getParameterClass(), Boolean.class);
        supportsLocal = true;
      }
      this.method = method;
      this.supportsLocal = supportsLocal;
    } catch (Exception e) {
      throw new CompileException(e, statement);
    }
  }

  @Override
  public StatementResult execute(ConnectionStatementExecutor connection, ParsedStatement statement)
      throws Exception {
    Tuple<T, Boolean> value;
    try {
      value =
          this.cache.get(
              statement.getSql(),
              () -> getParameterValue(connection.getDialect(), statement.getSql()));
    } catch (ExecutionException | UncheckedExecutionException executionException) {
      throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
    }
    if (this.supportsLocal) {
      return (StatementResult) method.invoke(connection, value.x(), value.y());
    }
    return (StatementResult) method.invoke(connection, value.x());
  }

  Tuple<T, Boolean> getParameterValue(Dialect dialect, String sql) {
    // Get rid of any spaces/comments at the start of the string.
    SimpleParser simpleParser = new SimpleParser(dialect, sql);
    simpleParser.skipWhitespaces();
    // Create a wrapper around the SQL string from the point after the first whitespace.
    CharBuffer sqlAfterWhitespaces = CharBuffer.wrap(sql, simpleParser.getPos(), sql.length());
    Matcher matcher = allowedValuesPattern.matcher(sqlAfterWhitespaces);
    if (matcher.find() && matcher.groupCount() >= 2) {
      boolean local = matcher.group(1) != null && "local".equalsIgnoreCase(matcher.group(1).trim());
      String value = matcher.group(2);
      T res = converter.convert(value);
      if (res != null) {
        return Tuple.of(res, local);
      }
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          String.format(
              "Unknown value for %s: %s",
              this.statement.getSetStatement().getPropertyName(), value));
    } else {
      Matcher invalidMatcher = this.statement.getPattern().matcher(sqlAfterWhitespaces);
      int valueGroup = this.supportsLocal ? 2 : 1;
      if (invalidMatcher.find() && invalidMatcher.groupCount() == valueGroup) {
        String invalidValue = invalidMatcher.group(valueGroup);
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT,
            String.format(
                "Unknown value for %s: %s",
                this.statement.getSetStatement().getPropertyName(), invalidValue));
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, String.format("Unknown statement: %s", sql));
  }
}
