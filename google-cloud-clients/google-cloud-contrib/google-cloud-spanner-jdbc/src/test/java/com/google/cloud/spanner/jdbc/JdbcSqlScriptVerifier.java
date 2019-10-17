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

import com.google.cloud.spanner.jdbc.StatementResult.ResultType;
import com.google.rpc.Code;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/** SQL Script verifier for JDBC connections */
public class JdbcSqlScriptVerifier extends AbstractSqlScriptVerifier {

  static class JdbcGenericStatementResult extends GenericStatementResult {
    private final boolean result;
    private final long updateCount;
    private final ResultSet resultSet;

    private JdbcGenericStatementResult(Statement statement, boolean result) throws SQLException {
      this.result = result;
      if (result) {
        this.resultSet = statement.getResultSet();
        this.updateCount = -1L;
      } else {
        this.resultSet = null;
        this.updateCount = statement.getUpdateCount();
      }
    }

    @Override
    protected ResultType getResultType() {
      if (result) {
        return ResultType.RESULT_SET;
      }
      if (updateCount == -2L) {
        return ResultType.NO_RESULT;
      }
      return ResultType.UPDATE_COUNT;
    }

    @Override
    protected GenericResultSet getResultSet() {
      return new JdbcGenericResultSet(resultSet);
    }

    @Override
    protected long getUpdateCount() {
      return updateCount;
    }
  }

  static class JdbcGenericResultSet extends GenericResultSet {
    private final ResultSet resultSet;

    private JdbcGenericResultSet(ResultSet resultSet) {
      this.resultSet = resultSet;
    }

    @Override
    protected boolean next() throws SQLException {
      return resultSet.next();
    }

    @Override
    protected Object getValue(String col) throws SQLException {
      Object value = resultSet.getObject(col);
      if (value instanceof Timestamp) {
        return com.google.cloud.Timestamp.of((Timestamp) value);
      } else if (value instanceof Array) {
        Array array = (Array) value;
        switch (array.getBaseType()) {
          case Types.BIGINT:
            Long[] longs = (Long[]) array.getArray();
            List<Long> res = new ArrayList<>();
            for (Long l : longs) {
              res.add(l);
            }
            return res;
          default:
            throw new IllegalArgumentException(
                "Unsupported array base type: " + array.getBaseType());
        }
      }
      return value;
    }

    @Override
    protected int getColumnCount() throws Exception {
      return resultSet.getMetaData().getColumnCount();
    }

    @Override
    protected Object getFirstValue() throws Exception {
      String col = resultSet.getMetaData().getColumnName(1);
      return getValue(col);
    }
  }

  public static class JdbcGenericConnection extends GenericConnection {
    private final Connection connection;
    /**
     * Use this to strip comments from a statement before the statement is executed. This should
     * only be used when the connection is used in a unit test with a mocked underlying connection.
     */
    private boolean stripCommentsBeforeExecute;

    public static JdbcGenericConnection of(Connection connection) {
      return new JdbcGenericConnection(connection);
    }

    private JdbcGenericConnection(Connection connection) {
      this.connection = connection;
    }

    @Override
    protected GenericStatementResult execute(String sql) throws SQLException {
      Statement statement = connection.createStatement();
      if (isStripCommentsBeforeExecute()) {
        sql = StatementParser.removeCommentsAndTrim(sql);
      }
      boolean result = statement.execute(sql);
      return new JdbcGenericStatementResult(statement, result);
    }

    @Override
    public void close() throws Exception {
      if (this.connection != null) {
        this.connection.close();
      }
    }

    boolean isStripCommentsBeforeExecute() {
      return stripCommentsBeforeExecute;
    }

    void setStripCommentsBeforeExecute(boolean stripCommentsBeforeExecute) {
      this.stripCommentsBeforeExecute = stripCommentsBeforeExecute;
    }
  }

  public JdbcSqlScriptVerifier() {}

  public JdbcSqlScriptVerifier(GenericConnectionProvider connectionProvider) {
    super(connectionProvider);
  }

  @Override
  protected void verifyExpectedException(
      String statement, Exception e, String code, String messagePrefix) {
    assertThat(e instanceof JdbcSqlException, is(true));
    JdbcSqlException jdbcException = (JdbcSqlException) e;
    assertThat(statement, jdbcException.getCode(), is(equalTo(Code.valueOf(code))));
    if (messagePrefix != null) {
      assertThat(
          statement,
          e.getMessage(),
          startsWith(messagePrefix.substring(1, messagePrefix.length() - 1)));
    }
  }
}
