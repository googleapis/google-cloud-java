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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base class for SQL Script verifiers for both the generic Connection API and JDBC connections
 *
 * <p>Simple parser/verifier for sql statements. This verifier is able to parse additional @EXPECT
 * statements that defines the expected behavior of a sql statement. Possible uses are:
 *
 * <ul>
 *   <li>@EXPECT NO_RESULT: The following statement should not return a result (no {@link ResultSet}
 *       and no update count)
 *   <li>@EXPECT UPDATE_COUNT <i>count</i>: The following statement should return the specified
 *       update count
 *   <li>@EXPECT RESULT_SET: The following statement should return a {@link ResultSet} with two
 *       columns with the names ACTUAL and EXPECTED and containing at least one row. For each row,
 *       the values of ACTUAL and EXPECTED must be equal
 *   <li>@EXPECT RESULT_SET 'columnName': The following statement should return a {@link ResultSet}
 *       with a column with the specified name and containing at least one row (additional columns
 *       in the {@link ResultSet} are allowed). For each row, the value of the column must be not
 *       null
 *   <li>@EXPECT RESULT_SET 'columnName',value: The following statement should return a {@link
 *       ResultSet} with a column with the specified name and containing at least one row
 *       (additional columns in the {@link ResultSet} are allowed). For each row, the value of the
 *       column must be equal to the specified value
 *   <li>@EXPECT EXCEPTION code ['messagePrefix']: The following statement should throw a {@link
 *       SpannerException} with the specified code and starting with the (optional) message prefix
 *   <li>@EXPECT EQUAL 'variable1','variable2': The values of the two given variables should be
 *       equal. The value of a variable can be set using a @PUT statement.
 * </ul>
 *
 * The parser can set a temporary variable value using a @PUT statement: <code>
 * @PUT 'variable_name'\nSQL statement</code> The SQL statement must be a statement that returns a
 * {@link ResultSet} containing exactly one row and one column.
 *
 * <p>In addition the verifier can create new connections if the script contains NEW_CONNECTION;
 * statements and the verifier has been created with a {@link GenericConnectionProvider}. See {@link
 * ConnectionImplGeneratedSqlScriptTest} for an example for this.
 */
public abstract class AbstractSqlScriptVerifier {
  private static final Pattern VERIFY_PATTERN =
      Pattern.compile(
          "(?is)\\s*(?:@EXPECT)\\s+"
              + "(?<type>NO_RESULT"
              + "|RESULT_SET\\s*(?<column>'.*?'(?<value>,.*?)?)?"
              + "|UPDATE_COUNT\\s*(?<count>-?\\d{1,19})"
              + "|EXCEPTION\\s*(?<exception>(?<code>CANCELLED|UNKNOWN|INVALID_ARGUMENT|DEADLINE_EXCEEDED|NOT_FOUND|ALREADY_EXISTS|PERMISSION_DENIED|UNAUTHENTICATED|RESOURCE_EXHAUSTED|FAILED_PRECONDITION|ABORTED|OUT_OF_RANGE|UNIMPLEMENTED|INTERNAL|UNAVAILABLE|DATA_LOSS)(?:\\s*)(?<messagePrefix>'.*?')?)"
              + "|EQUAL\\s+(?<variable1>'.+?')\\s*,\\s*(?<variable2>'.+?')"
              + ")"
              + "(\\n(?<statement>.*))?");

  private static final String PUT_CONDITION =
      "@PUT can only be used in combination with a statement that returns a"
          + " result set containing exactly one row and one column";
  private static final Pattern PUT_PATTERN =
      Pattern.compile("(?is)\\s*(?:@PUT)\\s+(?<variable>'.*?')" + "\\n(?<statement>.*)");

  protected enum ExpectedResultType {
    RESULT_SET,
    UPDATE_COUNT,
    NO_RESULT,
    EXCEPTION,
    EQUAL;

    StatementResult.ResultType getStatementResultType() {
      switch (this) {
        case NO_RESULT:
          return StatementResult.ResultType.NO_RESULT;
        case RESULT_SET:
          return StatementResult.ResultType.RESULT_SET;
        case UPDATE_COUNT:
          return StatementResult.ResultType.UPDATE_COUNT;
        case EXCEPTION:
        case EQUAL:
        default:
          throw new IllegalArgumentException("not supported");
      }
    }
  }

  /** Result of an executed statement */
  protected abstract static class GenericStatementResult {
    protected abstract StatementResult.ResultType getResultType();

    protected abstract GenericResultSet getResultSet();

    protected abstract long getUpdateCount();
  }

  /**
   * Generic wrapper around a connection to a database. The underlying connection could be a Spanner
   * {@link com.google.cloud.spanner.jdbc.Connection} or a JDBC {@link java.sql.Connection}
   */
  public abstract static class GenericConnection implements AutoCloseable {
    protected abstract GenericStatementResult execute(String sql) throws Exception;

    @Override
    public abstract void close() throws Exception;
  }

  /**
   * Generic wrapper around a result set. The underlying result set could be a Spanner {@link
   * ResultSet} or a JDBC {@link java.sql.ResultSet}
   */
  protected abstract static class GenericResultSet {
    protected abstract boolean next() throws Exception;

    protected abstract Object getValue(String col) throws Exception;

    protected abstract int getColumnCount() throws Exception;

    protected abstract Object getFirstValue() throws Exception;
  }

  public static interface GenericConnectionProvider {
    public GenericConnection getConnection();
  }

  /** Reads SQL statements from a file. Any copyright header in the file will be stripped away. */
  public static List<String> readStatementsFromFile(String filename, Class<?> resourceClass) {
    File file = new File(resourceClass.getResource(filename).getFile());
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    String script = builder.toString().replaceAll(StatementParserTest.COPYRIGHT_PATTERN, "");
    String[] array = script.split(";");
    List<String> res = new ArrayList<>(array.length);
    for (String statement : array) {
      if (statement != null && statement.trim().length() > 0) {
        res.add(statement);
      }
    }
    return res;
  }

  private final GenericConnectionProvider connectionProvider;

  private final Map<String, Object> variables = new HashMap<>();

  /**
   * Constructor for a verifier that will take a {@link GenericConnection} as a parameter to the
   * {@link AbstractSqlScriptVerifier#verifyStatementsInFile(GenericConnection, String, Class,
   * boolean)}
   */
  public AbstractSqlScriptVerifier() {
    this(null);
  }

  /** Constructor for a verifier that will use a connection provider for connections */
  public AbstractSqlScriptVerifier(GenericConnectionProvider provider) {
    this.connectionProvider = provider;
  }

  /**
   * Reads sql statements from the specified file name and executes and verifies these. Statements
   * that are preceeded by an @EXPECT statement are verified against the @EXPECT specification.
   * Statements without an @EXPECT statement will be executed and its result will be ignored, unless
   * the statement throws an exception, which will fail the test case.
   *
   * <p>The {@link com.google.cloud.spanner.jdbc.Connection}s that the statements are executed on
   * must be created by a {@link GenericConnectionProvider}
   *
   * @param filename The file name containing the statements. Statements must be separated by a
   *     semicolon (;)
   * @param resourceClass The class that should be used to locate the resource specified by the file
   *     name
   * @param logStatements Should the verifier log each statement that is executed and verified to
   *     standard out
   * @throws Exception
   */
  public void verifyStatementsInFile(String filename, Class<?> resourceClass, boolean logStatements)
      throws Exception {
    verifyStatementsInFile(
        connectionProvider.getConnection(), filename, resourceClass, logStatements);
  }

  /**
   * Reads sql statements from the specified file name and executes and verifies these. Statements
   * that are preceeded by an @EXPECT statement are verified against the @EXPECT specification.
   * Statements without an @EXPECT statement will be executed and its result will be ignored, unless
   * the statement throws an exception, which will fail the test case.
   *
   * @param connection The {@link com.google.cloud.spanner.jdbc.Connection} to execute the
   *     statements against
   * @param filename The file name containing the statements. Statements must be separated by a
   *     semicolon (;)
   * @param resourceClass The class that defines the package where to find the input file
   * @param logStatements Should all statements be logged to standard out?
   */
  public void verifyStatementsInFile(
      GenericConnection connection, String filename, Class<?> resourceClass, boolean logStatements)
      throws Exception {
    try {
      List<String> statements = readStatementsFromFile(filename, resourceClass);
      for (String statement : statements) {
        String sql = statement.trim();
        if (logStatements) {
          System.out.println(
              "\n------------------------------------------------------\n"
                  + new Date()
                  + " ---- verifying statement:");
          System.out.println(sql);
        }
        if (sql.equalsIgnoreCase("NEW_CONNECTION")) {
          connection.close();
          connection = connectionProvider.getConnection();
          variables.clear();
        } else {
          verifyStatement(connection, sql);
        }
      }
    } finally {
      if (connection != null) {
        connection.close();
      }
    }
  }

  private void verifyStatement(GenericConnection connection, String statement) throws Exception {
    statement = replaceVariables(statement);
    String statementWithoutComments = StatementParser.removeCommentsAndTrim(statement);
    Matcher verifyMatcher = VERIFY_PATTERN.matcher(statementWithoutComments);
    Matcher putMatcher = PUT_PATTERN.matcher(statementWithoutComments);
    if (verifyMatcher.matches()) {
      String sql = verifyMatcher.group("statement");
      String typeName = verifyMatcher.group("type");
      int endIndex = getFirstSpaceChar(typeName);
      ExpectedResultType type = ExpectedResultType.valueOf(typeName.substring(0, endIndex));
      if (type == ExpectedResultType.EXCEPTION) {
        String code = verifyMatcher.group("code");
        String messagePrefix = verifyMatcher.group("messagePrefix");
        try {
          connection.execute(sql);
          fail("expected exception: " + sql);
        } catch (Exception e) {
          verifyExpectedException(statementWithoutComments, e, code, messagePrefix);
        }
      } else if (type == ExpectedResultType.EQUAL) {
        String variable1 = verifyMatcher.group("variable1");
        String variable2 = verifyMatcher.group("variable2");
        // get rid of the single quotes
        variable1 = variable1.substring(1, variable1.length() - 1);
        variable2 = variable2.substring(1, variable2.length() - 1);
        assertThat(
            "No variable with name " + variable1, variables.containsKey(variable1), is(true));
        assertThat(
            "No variable with name " + variable2, variables.containsKey(variable2), is(true));
        Object value1 = variables.get(variable1);
        Object value2 = variables.get(variable2);
        if ((value1 instanceof Timestamp) && (value2 instanceof Timestamp)) {
          // read timestamps are rounded
          Timestamp ts1 = (Timestamp) value1;
          Timestamp ts2 = (Timestamp) value2;
          value1 =
              Timestamp.ofTimeSecondsAndNanos(ts1.getSeconds(), (ts1.getNanos() / 1000) * 1000);
          value2 =
              Timestamp.ofTimeSecondsAndNanos(ts2.getSeconds(), (ts2.getNanos() / 1000) * 1000);
        }
        assertThat(value1, is(equalTo(value2)));
      } else {
        GenericStatementResult result = connection.execute(sql);
        assertThat(statement, result.getResultType(), is(equalTo(type.getStatementResultType())));
        switch (type.getStatementResultType()) {
          case NO_RESULT:
            break;
          case RESULT_SET:
            String column = verifyMatcher.group("column");
            if (column == null) {
              verifyActualVsExpectedResultSet(statement, result.getResultSet());
            } else {
              String value = verifyMatcher.group("value");
              if (value != null) {
                String parts[] = column.split(",", 2);
                column = parts[0].trim();
                value = parts[1].trim();
                column = column.substring(1, column.length() - 1);
                verifyResultSetValue(statement, result.getResultSet(), column, parseValue(value));
              } else {
                // get rid of the quotation marks
                column = column.substring(1, column.length() - 1);
                verifyResultSetColumnNotNull(statement, result.getResultSet(), column);
              }
            }
            break;
          case UPDATE_COUNT:
            long expectedUpdateCount = Long.valueOf(verifyMatcher.group("count").trim());
            assertThat(statement, result.getUpdateCount(), is(equalTo(expectedUpdateCount)));
            break;
        }
      }
    } else if (putMatcher.matches()) {
      String sql = putMatcher.group("statement");
      String variable = putMatcher.group("variable");
      // get rid of the single quotes
      variable = variable.substring(1, variable.length() - 1);
      GenericStatementResult result = connection.execute(sql);
      assertThat(
          PUT_CONDITION,
          result.getResultType(),
          is(equalTo(com.google.cloud.spanner.jdbc.StatementResult.ResultType.RESULT_SET)));
      GenericResultSet rs = result.getResultSet();
      assertThat(PUT_CONDITION, rs.next(), is(true));
      assertThat(PUT_CONDITION, rs.getColumnCount(), is(equalTo(1)));
      variables.put(variable, rs.getFirstValue());
      assertThat(PUT_CONDITION, rs.next(), is(false));
    } else {
      // just execute the statement
      connection.execute(statement);
    }
  }

  private String replaceVariables(String sql) {
    for (String key : variables.keySet()) {
      sql = sql.replaceAll("%%" + key + "%%", variables.get(key).toString());
    }
    return sql;
  }

  protected abstract void verifyExpectedException(
      String statement, Exception e, String code, String messagePrefix);

  private static final Pattern INT64_PATTERN = Pattern.compile("\\d{1,19}");
  private static final Pattern ARRAY_INT64_PATTERN =
      Pattern.compile("\\[\\s*\\d{1,19}(\\s*,\\s*\\d{1,19})*\\s*\\]");
  private static final Pattern FLOAT64_PATTERN = Pattern.compile("\\d{1,19}.\\d{1,19}");
  private static final String TS_PREFIX = "ts'";
  private static final String TS_SUFFIX = "'";
  private static final Pattern BOOLEAN_PATTERN = Pattern.compile("(?is)true|false");

  private Object parseValue(String valueString) {
    if (valueString == null || "".equals(valueString) || "null".equalsIgnoreCase(valueString)) {
      return null;
    }
    if (valueString.startsWith("'") && valueString.endsWith("'")) {
      return valueString.substring(1, valueString.length() - 1);
    }
    if (INT64_PATTERN.matcher(valueString).matches()) {
      return Long.valueOf(valueString);
    }
    if (ARRAY_INT64_PATTERN.matcher(valueString).matches()) {
      String[] stringArray = valueString.substring(1, valueString.length() - 1).split(",");
      List<Long> res = new ArrayList<>();
      for (int i = 0; i < stringArray.length; i++) {
        res.add(Long.valueOf(stringArray[i]));
      }
      return res;
    }
    if (FLOAT64_PATTERN.matcher(valueString).matches()) {
      return Double.valueOf(valueString);
    }
    if (valueString.startsWith(TS_PREFIX) && valueString.endsWith(TS_SUFFIX)) {
      try {
        return ReadOnlyStalenessUtil.parseRfc3339(
            valueString.substring(TS_PREFIX.length(), valueString.length() - TS_SUFFIX.length()));
      } catch (IllegalArgumentException e) {
        // ignore, apparently not a valid a timestamp after all.
      }
    }
    if (BOOLEAN_PATTERN.matcher(valueString).matches()) {
      return Boolean.valueOf(valueString);
    }
    return valueString;
  }

  private int getFirstSpaceChar(String input) {
    for (int index = 0; index < input.length(); index++) {
      if (Character.isWhitespace(input.charAt(index))) {
        return index;
      }
    }
    return input.length();
  }

  private void verifyResultSetColumnNotNull(String statement, GenericResultSet rs, String column)
      throws Exception {
    int count = 0;
    while (rs.next()) {
      assertThat(statement, getValue(rs, column), is(notNullValue()));
      count++;
    }
    assertThat(count, is(not(equalTo(0))));
  }

  private void verifyResultSetValue(
      String statement, GenericResultSet rs, String column, Object value) throws Exception {
    int count = 0;
    while (rs.next()) {
      if (value == null) {
        assertThat(statement, getValue(rs, column), is(nullValue()));
      } else {
        assertEquals(statement, getValue(rs, column), value);
      }
      count++;
    }
    assertThat(count, is(not(equalTo(0))));
  }

  private void verifyActualVsExpectedResultSet(String statement, GenericResultSet rs)
      throws Exception {
    int count = 0;
    while (rs.next()) {
      assertThat(statement, getValue(rs, "ACTUAL"), is(equalTo(getValue(rs, "EXPECTED"))));
      count++;
    }
    assertThat(count, is(not(equalTo(0))));
  }

  private Object getValue(GenericResultSet rs, String col) throws Exception {
    return rs.getValue(col);
  }
}
