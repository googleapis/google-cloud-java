/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ITCallableStatementTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static final String connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3";
  private static final Random random = new Random();
  private static final String DATASET = "JDBC_PRESUBMIT_INTEGRATION_DATASET";
  private static final String CALLABLE_STMT_PROC_NAME = "IT_CALLABLE_STMT_PROC_TEST";
  private static final String CALLABLE_STMT_TABLE_NAME = "IT_CALLABLE_STMT_PROC_TABLE";
  private static final String CALLABLE_STMT_PARAM_KEY = "CALL_STMT_PARAM_KEY";
  private static final String CALLABLE_STMT_DML_INSERT_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_INSERT_TEST";
  private static final String CALLABLE_STMT_DML_UPDATE_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_UPDATE_TEST";
  private static final String CALLABLE_STMT_DML_DELETE_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_DELETE_TEST";
  private static final String CALLABLE_STMT_DML_TABLE_NAME = "IT_CALLABLE_STMT_PROC_DML_TABLE";

  static Connection bigQueryConnection;
  static BigQuery bigQuery;
  static Statement bigQueryStatement;

  @BeforeAll
  public static void beforeClass() throws SQLException {
    bigQueryConnection = DriverManager.getConnection(connection_uri, new Properties());
    bigQueryStatement = bigQueryConnection.createStatement();
    bigQuery = BigQueryOptions.newBuilder().build().getService();
  }

  @AfterAll
  public static void afterClass() throws SQLException {
    bigQueryStatement.close();
    bigQueryConnection.close();
  }

  // Block A Tests
  @Test
  public void testPrepareCallSql() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc");
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallSqlResultSetTypeConcurrency() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallSqlResultSetTypeConcurrencyHoldability() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallFailureResultSetType() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
  }

  @Test
  public void testPrepareCallFailureResultSetConcurrency() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));
  }

  @Test
  public void testPrepareCallFailureResultSetHoldability() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT));
  }

  @Test
  public void testSetterGetterBigDecimal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    BigDecimal expected = new BigDecimal(12344);
    callableStatement.setBigDecimal(CALLABLE_STMT_PARAM_KEY, expected);
    BigDecimal actual = callableStatement.getBigDecimal(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterBoolean() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Boolean expected = true;
    callableStatement.setBoolean(CALLABLE_STMT_PARAM_KEY, expected);
    Boolean actual = callableStatement.getBoolean(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterByte() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Byte expected = "hello".getBytes()[0];
    callableStatement.setByte(CALLABLE_STMT_PARAM_KEY, expected);
    Byte actual = callableStatement.getByte(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterBytes() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    byte[] expected = "hello".getBytes();
    callableStatement.setBytes(CALLABLE_STMT_PARAM_KEY, expected);
    byte[] actual = callableStatement.getBytes(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDate() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Date expected = new Date(1234567);
    callableStatement.setDate(CALLABLE_STMT_PARAM_KEY, expected);
    Date actual = callableStatement.getDate(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDateCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Date expected = new Date(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setDate(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Date actual = callableStatement.getDate(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDouble() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Double expected = 123.2345;
    callableStatement.setDouble(CALLABLE_STMT_PARAM_KEY, expected);
    Double actual = callableStatement.getDouble(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterFloat() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Float expected = 123.2345F;
    callableStatement.setFloat(CALLABLE_STMT_PARAM_KEY, expected);
    Float actual = callableStatement.getFloat(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterInt() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Integer expected = 123;
    callableStatement.setInt(CALLABLE_STMT_PARAM_KEY, expected);
    Integer actual = callableStatement.getInt(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterLong() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Long expected = 123L;
    callableStatement.setLong(CALLABLE_STMT_PARAM_KEY, expected);
    Long actual = callableStatement.getLong(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterNString() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setNString(CALLABLE_STMT_PARAM_KEY, expected);
    String actual = callableStatement.getNString(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObject() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObjectWithSQLType() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected, Types.NVARCHAR);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObjectWithSqlTypeAndScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected, Types.NVARCHAR, 0);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterString() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "123";
    callableStatement.setString(CALLABLE_STMT_PARAM_KEY, expected);
    String actual = callableStatement.getString(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTime() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Time expected = new Time(1234567);
    callableStatement.setTime(CALLABLE_STMT_PARAM_KEY, expected);
    Time actual = callableStatement.getTime(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimeCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Time expected = new Time(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setTime(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Time actual = callableStatement.getTime(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimestamp() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Timestamp expected = new Timestamp(1234567);
    callableStatement.setTimestamp(CALLABLE_STMT_PARAM_KEY, expected);
    Timestamp actual = callableStatement.getTimestamp(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimestampCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Timestamp expected = new Timestamp(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setTimestamp(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Timestamp actual = callableStatement.getTimestamp(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  // Block B Tests
  @Test
  public void testCallableStatementScriptExecuteUpdate() throws SQLException {
    int randomNum = java.util.UUID.randomUUID().hashCode();
    String insertName = "callable-statement-dml-insert-test";
    String insertResult = String.format("%s-%d", insertName, randomNum);
    String updateName = "callable-statement-dml-update-test";
    String updateResult = String.format("%s-%d", updateName, randomNum);
    String selectStmtQuery =
        String.format("SELECT * FROM %s.%s WHERE id = ?", DATASET, CALLABLE_STMT_DML_TABLE_NAME);
    String insertCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_INSERT_PROC_NAME);
    String updateCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_UPDATE_PROC_NAME);
    String deleteCallStmtQuery =
        String.format("CALL %s.%s(?);", DATASET, CALLABLE_STMT_DML_DELETE_PROC_NAME);

    // DML INSERT
    CallableStatement callableStatement = bigQueryConnection.prepareCall(insertCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, insertName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, insertResult);
    int rowsInserted = callableStatement.executeUpdate();
    assertEquals(1, rowsInserted);

    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    ResultSet rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(insertName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(insertResult, rs.getString(3));

    // DML UPDATE
    callableStatement = bigQueryConnection.prepareCall(updateCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, updateName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, updateResult);
    int rowsUpdated = callableStatement.executeUpdate();
    assertEquals(1, rowsUpdated);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(updateName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(updateResult, rs.getString(3));

    // DML DELETE
    callableStatement = bigQueryConnection.prepareCall(deleteCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setInt(1, randomNum);
    int rowsDeleted = callableStatement.executeUpdate();
    assertEquals(1, rowsDeleted);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertFalse(rs.next());

    callableStatement.close();
  }

  @Test
  public void testCallableStatementScriptExecuteLargeUpdate() throws SQLException {
    int randomNum = java.util.UUID.randomUUID().hashCode();
    String insertName = "callable-statement-dml-insert-test";
    String insertResult = String.format("%s-%d", insertName, randomNum);
    String updateName = "callable-statement-dml-update-test";
    String updateResult = String.format("%s-%d", updateName, randomNum);
    String selectStmtQuery =
        String.format("SELECT * FROM %s.%s WHERE id = ?", DATASET, CALLABLE_STMT_DML_TABLE_NAME);
    String insertCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_INSERT_PROC_NAME);
    String updateCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_UPDATE_PROC_NAME);
    String deleteCallStmtQuery =
        String.format("CALL %s.%s(?);", DATASET, CALLABLE_STMT_DML_DELETE_PROC_NAME);

    // DML INSERT
    CallableStatement callableStatement = bigQueryConnection.prepareCall(insertCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, insertName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, insertResult);
    long rowsInserted = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsInserted);

    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    ResultSet rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(insertName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(insertResult, rs.getString(3));

    // DML UPDATE
    callableStatement = bigQueryConnection.prepareCall(updateCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, updateName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, updateResult);
    long rowsUpdated = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsUpdated);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(updateName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(updateResult, rs.getString(3));

    // DML DELETE
    callableStatement = bigQueryConnection.prepareCall(deleteCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setInt(1, randomNum);
    long rowsDeleted = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsDeleted);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertFalse(rs.next());

    callableStatement.close();
  }

  @Test
  public void testScript() throws SQLException {
    String BASE_QUERY =
        "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
            + " trip_distance asc LIMIT %s;";
    String query1 = String.format(BASE_QUERY, 5000);
    String query2 = String.format(BASE_QUERY, 7000);
    String query3 = String.format(BASE_QUERY, 9000);

    bigQueryStatement.execute(query1 + query2 + query3);
    ResultSet resultSet = bigQueryStatement.getResultSet();
    assertEquals(5000, resultSetRowCount(resultSet));

    boolean hasMoreResult = bigQueryStatement.getMoreResults();
    assertTrue(hasMoreResult);
    resultSet = bigQueryStatement.getResultSet();
    assertEquals(7000, resultSetRowCount(resultSet));

    hasMoreResult = bigQueryStatement.getMoreResults();
    assertTrue(hasMoreResult);
    resultSet = bigQueryStatement.getResultSet();
    assertEquals(9000, resultSetRowCount(resultSet));
  }

  @Test
  public void testCallableStatementScriptExecute() throws SQLException {
    int randomNum = random.nextInt(99);
    String callableStmtQuery =
        String.format(
            "DECLARE call_result STRING;"
                + "CALL %s.%s(?,?,call_result);"
                + "SELECT * FROM %s.%s WHERE result = call_result;",
            DATASET, CALLABLE_STMT_PROC_NAME, DATASET, CALLABLE_STMT_TABLE_NAME);
    CallableStatement callableStatement = bigQueryConnection.prepareCall(callableStmtQuery);
    callableStatement.setString(1, "callable-stmt-test");
    callableStatement.setInt(2, randomNum);

    assertFalse(callableStatement.execute());
    assertEquals(1, callableStatement.getUpdateCount());

    // This is an actual SELECT * from the above
    assertTrue(callableStatement.getMoreResults());
    ResultSet resultSet = callableStatement.getResultSet();
    ResultSetMetaData rsMetadata = resultSet.getMetaData();
    assertEquals(3, rsMetadata.getColumnCount());

    assertTrue(resultSet.next());

    String expected = String.format("callable-stmt-test-%d", randomNum);
    String actual = resultSet.getString(3);

    assertEquals(expected, actual);

    // Validate there are no more results
    assertFalse(callableStatement.getMoreResults());
    assertEquals(-1, callableStatement.getUpdateCount());
    callableStatement.close();
  }
}
