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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.common.base.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Executor for {@link ClientSideStatement}s that sets a value for a property, such as SET
 * AUTOCOMMIT=TRUE.
 */
class ClientSideStatementSetExecutor<T> implements ClientSideStatementExecutor {
  private ClientSideStatementImpl statement;
  private Method method;
  private ClientSideStatementValueConverter<T> converter;
  private Pattern allowedValuesPattern;

  @SuppressWarnings("unchecked")
  @Override
  public void compile(ClientSideStatementImpl statement) throws CompileException {
    Preconditions.checkNotNull(statement.getSetStatement());
    try {
      this.statement = statement;
      this.allowedValuesPattern =
          Pattern.compile(
              String.format(
                  "(?is)\\A\\s*set\\s+%s\\s*%s\\s*%s\\s*\\z",
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
      this.method =
          ConnectionStatementExecutor.class.getDeclaredMethod(
              statement.getMethodName(), converter.getParameterClass());
    } catch (Exception e) {
      throw new CompileException(e, statement);
    }
  }

  @Override
  public StatementResult execute(ConnectionStatementExecutor connection, String sql)
      throws Exception {
    return (StatementResult) method.invoke(connection, getParameterValue(sql));
  }

  T getParameterValue(String sql) {
    Matcher matcher = allowedValuesPattern.matcher(sql);
    if (matcher.find() && matcher.groupCount() >= 1) {
      String value = matcher.group(1);
      T res = converter.convert(value);
      if (res != null) {
        return res;
      }
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          String.format(
              "Unknown value for %s: %s",
              this.statement.getSetStatement().getPropertyName(), value));
    } else {
      Matcher invalidMatcher = this.statement.getPattern().matcher(sql);
      if (invalidMatcher.find() && invalidMatcher.groupCount() == 1) {
        String invalidValue = invalidMatcher.group(1);
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
