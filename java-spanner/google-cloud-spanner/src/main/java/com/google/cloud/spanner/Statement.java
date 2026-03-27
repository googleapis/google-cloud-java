/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.connection.AbstractStatementParser;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParametersInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A SQL statement and optional bound parameters that can be executed in a {@link ReadContext}.
 *
 * <p>The SQL query string can contain parameter placeholders. A parameter placeholder consists of
 * {@literal @} followed by the parameter name. Parameter names consist of any combination of
 * letters, numbers, and underscores.
 *
 * <p>Parameters can appear anywhere that a literal value is expected. The same parameter name can
 * be used more than once, for example: {@code WHERE id > @msg_id AND id < @msg_id + 100}
 *
 * <p>It is an error to execute an SQL query with placeholders for unbound parameters.
 *
 * <p>Statements are constructed using a builder. Parameter values are specified by calling {@link
 * Builder#bind(String)}. For example, code to build a query using the clause above and bind a value
 * to {@code id} might look like the following:
 *
 * <pre>{@code
 * Statement statement = Statement
 *     .newBuilder("SELECT name WHERE id > @msg_id AND id < @msg_id + 100")
 *     .bind("msg_id").to(500)
 *     .build();
 * }</pre>
 *
 * <p>{@code Statement} instances are immutable.
 */
public final class Statement implements Serializable {
  private static final long serialVersionUID = -1967958247625065259L;

  private final Map<String, Value> parameters;
  private final String sql;
  private final QueryOptions queryOptions;

  private Statement(String sql, Map<String, Value> parameters, QueryOptions queryOptions) {
    this.sql = sql;
    this.parameters = parameters;
    this.queryOptions = queryOptions;
  }

  /** Builder for {@code Statement}. */
  public static final class Builder {
    final Map<String, Value> parameters;
    private final StringBuilder sqlBuffer;
    private String currentBinding;
    private final ValueBinder<Builder> binder = new Binder();
    private QueryOptions queryOptions;

    private Builder(String sql) {
      parameters = new HashMap<>();
      sqlBuffer = new StringBuilder(sql);
    }

    private Builder(Statement statement) {
      sqlBuffer = new StringBuilder(statement.sql);
      parameters = new HashMap<>(statement.parameters);
      queryOptions =
          statement.queryOptions == null ? null : statement.queryOptions.toBuilder().build();
    }

    /** Replaces the current SQL of this builder with the given string. */
    public Builder replace(String sql) {
      sqlBuffer.replace(0, sqlBuffer.length(), sql);
      return this;
    }

    /** Appends {@code sqlFragment} to the statement. */
    public Builder append(String sqlFragment) {
      sqlBuffer.append(checkNotNull(sqlFragment));
      return this;
    }

    /** Sets the {@link QueryOptions} to use when executing this {@link Statement}. */
    public Builder withQueryOptions(QueryOptions queryOptions) {
      this.queryOptions = queryOptions;
      return this;
    }

    /** Returns a binder to bind the value of the query parameter {@code parameter}. */
    public ValueBinder<Builder> bind(String parameter) {
      checkState(
          currentBinding == null,
          "Cannot bind new parameter. Previous binding of parameter '%s' is incomplete.",
          currentBinding);
      currentBinding = parameter;
      return binder;
    }

    /** Builds the {@code Statement}. */
    public Statement build() {
      checkState(
          currentBinding == null, "Binding for parameter '%s' is incomplete.", currentBinding);
      return new Statement(
          sqlBuffer.toString(),
          Collections.unmodifiableMap(new HashMap<>(parameters)),
          queryOptions);
    }

    private class Binder extends ValueBinder<Builder> {
      @Override
      Builder handle(Value value) {
        Preconditions.checkArgument(
            value == null || !value.isCommitTimestamp(),
            "Mutation.COMMIT_TIMESTAMP cannot be bound as a query parameter");
        checkState(currentBinding != null, "No binding in progress");
        parameters.put(currentBinding, value);
        currentBinding = null;
        return Builder.this;
      }
    }
  }

  /** Creates a {@code Statement} with the given SQL text {@code sql}. */
  public static Statement of(String sql) {
    return new Statement(sql, ImmutableMap.of(), /* queryOptions= */ null);
  }

  /** Creates a {@link Statement} with the given SQL text and parameters. */
  public static Statement of(String sql, ImmutableMap<String, Value> parameters) {
    return new Statement(sql, parameters, /* queryOptions= */ null);
  }

  /** Creates a new statement builder with the SQL text {@code sql}. */
  public static Builder newBuilder(String sql) {
    return new Builder(sql);
  }

  /** Returns {@code true} if a binding exists for {@code parameter}. */
  public boolean hasBinding(String parameter) {
    return parameters.containsKey(parameter);
  }

  /**
   * Executes the query in {@code context}. {@code statement.executeQuery(context)} is exactly
   * equivalent to {@code context.executeQuery(statement)}.
   *
   * @see ReadContext#executeQuery(Statement, Options.QueryOption...)
   */
  public ResultSet executeQuery(ReadContext context, Options.QueryOption... options) {
    return context.executeQuery(this, options);
  }

  /**
   * Analyzes the query in {@code context}. {@code statement.analyzeQuery(context, queryMode)} is
   * exactly equivalent to {@code context.analyzeQuery(statement, queryMode)}.
   *
   * @see ReadContext#analyzeQuery(Statement, com.google.cloud.spanner.ReadContext.QueryAnalyzeMode)
   */
  public ResultSet analyzeQuery(ReadContext context, QueryAnalyzeMode queryMode) {
    return context.analyzeQuery(this, queryMode);
  }

  /** Returns the current SQL statement text. */
  public String getSql() {
    return sql;
  }

  /** Returns a copy of this statement with the SQL string replaced by the given SQL string. */
  public Statement withReplacedSql(String sql) {
    return new Statement(sql, this.parameters, this.queryOptions);
  }

  /** Returns the {@link QueryOptions} that will be used with this {@link Statement}. */
  public QueryOptions getQueryOptions() {
    return queryOptions;
  }

  /** Returns the parameters bound to this {@code Statement}. */
  public Map<String, Value> getParameters() {
    return parameters;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return toString(new StringBuilder()).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Statement that = (Statement) o;
    return Objects.equals(sql, that.sql)
        && Objects.equals(parameters, that.parameters)
        && Objects.equals(queryOptions, that.queryOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sql, parameters, queryOptions);
  }

  StringBuilder toString(StringBuilder b) {
    b.append(sql);
    if (!parameters.isEmpty()) {
      b.append(" {");
      int n = 0;
      for (Map.Entry<String, Value> parameter : parameters.entrySet()) {
        if (n++ > 0) {
          b.append(", ");
        }
        b.append(parameter.getKey()).append(": ");
        if (parameter.getValue() == null) {
          b.append("NULL");
        } else {
          parameter.getValue().toString(b);
        }
      }
      b.append("}");
    }
    if (queryOptions != null) {
      b.append(",queryOptions=").append(queryOptions.toString());
    }
    return b;
  }

  /**
   * Factory for creating {@link Statement}s with unnamed parameters.
   *
   * <p>This class is primarily intended for framework developers who want to integrate the Spanner
   * client with a framework that uses unnamed parameters. Developers who want to use the Spanner
   * client in their application, should use named parameters.
   *
   * <p>
   *
   * <h2>Usage Example</h2>
   *
   * Simple SQL query
   *
   * <pre>{@code
   * Statement statement = databaseClient.getStatementFactory()
   *     .withUnnamedParameters("SELECT * FROM TABLE WHERE ID = ?", 10L)
   * }</pre>
   *
   * SQL query with multiple parameters
   *
   * <pre>{@code
   * long id = 10L;
   * String name = "google";
   * List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321");
   * Statement statement = databaseClient.getStatementFactory()
   *      .withUnnamedParameters("INSERT INTO TABLE (ID, name, phonenumbers) VALUES(?, ?, ?)", id, name, phoneNumbers)
   * }</pre>
   *
   * How to use arrays with the IN operator
   *
   * <pre>{@code
   * long[] ids = {10L, 12L, 1483L};
   * Statement statement = databaseClient.getStatementFactory()
   *     .withUnnamedParameters("SELECT * FROM TABLE WHERE ID = UNNEST(?)", ids)
   * }</pre>
   *
   * @see DatabaseClient#getStatementFactory()
   * @see StatementFactory#withUnnamedParameters(String, Object...)
   */
  public static final class StatementFactory {
    private final Dialect dialect;

    StatementFactory(Dialect dialect) {
      this.dialect = dialect;
    }

    public Statement of(String sql) {
      return Statement.of(sql);
    }

    /**
     * This function accepts a SQL statement with unnamed parameters (?) and accepts a list of
     * objects that should be used as the values for those parameters. Primitive types are
     * supported.
     *
     * <p>For parameters of type DATE, the following types are supported
     *
     * <ul>
     *   <li>{@link java.time.LocalDate}
     *   <li>{@link com.google.cloud.Date}
     * </ul>
     *
     * <p>For parameters of type TIMESTAMP, the following types are supported. Note that Spanner
     * stores all timestamps in UTC. Instances of ZonedDateTime and OffsetDateTime that use other
     * timezones than UTC, will be converted to the corresponding UTC values before being sent to
     * Spanner. Instances of LocalDateTime will be converted to a ZonedDateTime using the system
     * default timezone, and then converted to UTC before being sent to Spanner.
     *
     * <ul>
     *   <li>{@link java.time.LocalDateTime}
     *   <li>{@link java.time.OffsetDateTime}
     *   <li>{@link java.time.ZonedDateTime}
     * </ul>
     *
     * <p>
     *
     * @param sql SQL statement with unnamed parameters denoted as ?
     * @param values positional list of values for the unnamed parameters in the SQL string
     * @return Statement a statement that can be executed on Spanner
     * @see DatabaseClient#getStatementFactory
     */
    public Statement withUnnamedParameters(String sql, Object... values) {
      Map<String, Value> parameters = getUnnamedParametersMap(values);
      AbstractStatementParser statementParser = AbstractStatementParser.getInstance(this.dialect);
      ParametersInfo parametersInfo =
          statementParser.convertPositionalParametersToNamedParameters('?', sql);
      return new Statement(parametersInfo.sqlWithNamedParameters, parameters, null);
    }

    private Map<String, Value> getUnnamedParametersMap(Object[] values) {
      Map<String, Value> parameters = new HashMap<>();
      int index = 1;
      for (Object value : values) {
        parameters.put("p" + (index++), Value.toValue(value));
      }
      return parameters;
    }
  }
}
