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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.jdbc.StatementResult.ResultType;

/**
 * SQL script verifier implementation for Spanner {@link com.google.cloud.spanner.jdbc.Connection}
 *
 * @see AbstractSqlScriptVerifier for more information
 */
public class SqlScriptVerifier extends AbstractSqlScriptVerifier {

  static class ConnectionGenericStatementResult extends GenericStatementResult {
    private final StatementResult result;

    private ConnectionGenericStatementResult(StatementResult result) {
      this.result = result;
    }

    @Override
    protected ResultType getResultType() {
      return result.getResultType();
    }

    @Override
    protected GenericResultSet getResultSet() {
      return new ConnectionGenericResultSet(result.getResultSet());
    }

    @Override
    protected long getUpdateCount() {
      return result.getUpdateCount();
    }
  }

  static class ConnectionGenericResultSet extends GenericResultSet {
    private final ResultSet resultSet;

    private ConnectionGenericResultSet(ResultSet resultSet) {
      this.resultSet = resultSet;
    }

    @Override
    protected boolean next() {
      return resultSet.next();
    }

    @Override
    protected Object getValue(String col) {
      if (resultSet.isNull(col)) {
        return null;
      }
      Type type = resultSet.getColumnType(col);
      switch (type.getCode()) {
        case ARRAY:
          return getArrayValue(resultSet, col, type.getArrayElementType());
        case BOOL:
          return resultSet.getBoolean(col);
        case BYTES:
          return resultSet.getBytes(col);
        case DATE:
          return resultSet.getDate(col);
        case FLOAT64:
          return resultSet.getDouble(col);
        case INT64:
          return resultSet.getLong(col);
        case STRING:
          return resultSet.getString(col);
        case TIMESTAMP:
          return resultSet.getTimestamp(col);
        case STRUCT:
          throw new IllegalArgumentException("type struct not supported");
      }
      throw new IllegalArgumentException("unknown type: " + type);
    }

    private Object getArrayValue(ResultSet rs, String col, Type type) {
      switch (type.getCode()) {
        case BOOL:
          return rs.getBooleanList(col);
        case BYTES:
          return rs.getBytesList(col);
        case DATE:
          return rs.getDateList(col);
        case FLOAT64:
          return rs.getDoubleList(col);
        case INT64:
          return rs.getLongList(col);
        case STRING:
          return rs.getStringList(col);
        case STRUCT:
          return rs.getStructList(col);
        case TIMESTAMP:
          return rs.getTimestampList(col);
        case ARRAY:
          throw new IllegalArgumentException("array of array not supported");
      }
      throw new IllegalArgumentException("unknown type: " + type);
    }

    @Override
    protected int getColumnCount() throws Exception {
      return resultSet.getColumnCount();
    }

    @Override
    protected Object getFirstValue() throws Exception {
      return getValue(resultSet.getType().getStructFields().get(0).getName());
    }
  }

  public static class SpannerGenericConnection extends GenericConnection {
    private final Connection connection;

    public static SpannerGenericConnection of(Connection connection) {
      return new SpannerGenericConnection(connection);
    }

    private SpannerGenericConnection(Connection connection) {
      this.connection = connection;
    }

    @Override
    protected GenericStatementResult execute(String sql) {
      return new ConnectionGenericStatementResult(connection.execute(Statement.of(sql)));
    }

    @Override
    public void close() throws Exception {
      if (this.connection != null) {
        this.connection.close();
      }
    }
  }

  public SqlScriptVerifier() {
    this(null);
  }

  public SqlScriptVerifier(GenericConnectionProvider provider) {
    super(provider);
  }

  @Override
  protected void verifyExpectedException(
      String statement, Exception e, String code, String messagePrefix) {
    assertThat(e instanceof SpannerException, is(true));
    SpannerException spannerException = (SpannerException) e;
    assertThat(
        statement + " resulted in " + spannerException.toString(),
        spannerException.getErrorCode(),
        is(equalTo(ErrorCode.valueOf(code))));
    if (messagePrefix != null) {
      assertThat(
          statement,
          e.getMessage(),
          startsWith(messagePrefix.substring(1, messagePrefix.length() - 1)));
    }
  }
}
