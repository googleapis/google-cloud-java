/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import com.google.common.collect.ImmutableMap;
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
public final class Statement {
  private final ImmutableMap<String, Value> parameters;
  private final String sql;

  private Statement(String sql, ImmutableMap<String, Value> parameters) {
    this.sql = sql;
    this.parameters = parameters;
  }

  /** Builder for {@code Statement}. */
  public static final class Builder {
    final Map<String, Value> parameters = new HashMap<>();
    private final StringBuilder sqlBuffer;
    private String currentBinding;
    private final ValueBinder<Builder> binder = new Binder();

    private Builder(String sql) {
      sqlBuffer = new StringBuilder(sql);
    }

    /** Appends {@code sqlFragment} to the statement. */
    public Builder append(String sqlFragment) {
      sqlBuffer.append(checkNotNull(sqlFragment));
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
      return new Statement(sqlBuffer.toString(), ImmutableMap.copyOf(parameters));
    }

    private class Binder extends ValueBinder<Builder> {
      @Override
      Builder handle(Value value) {
        checkState(currentBinding != null, "No binding in progress");
        parameters.put(currentBinding, value);
        currentBinding = null;
        return Builder.this;
      }
    }
  }

  /** Creates a {@code Statement} with the given SQL text {@code sql}. */
  public static Statement of(String sql) {
    return newBuilder(sql).build();
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

  /** Returns the parameters bound to this {@code Statement}. */
  public Map<String, Value> getParameters() {
    return parameters;
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
    return Objects.equals(sql, that.sql) && Objects.equals(parameters, that.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sql, parameters);
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
        parameter.getValue().toString(b);
      }
      b.append("}");
    }
    return b;
  }
}
