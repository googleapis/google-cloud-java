/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Table;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery view table definition. BigQuery's views are logical views, not materialized
 * views, which means that the query that defines the view is re-executed every time the view is
 * queried.
 *
 * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
 */
public class ViewDefinition extends TableDefinition {

  private static final long serialVersionUID = -8789311196910794545L;

  private final String query;
  private final List<UserDefinedFunction> userDefinedFunctions;
  private final Boolean useLegacySql;

  public static final class Builder extends TableDefinition.Builder<ViewDefinition, Builder> {

    private String query;
    private List<UserDefinedFunction> userDefinedFunctions;
    private Boolean useLegacySql;

    private Builder() {
      super(Type.VIEW);
    }

    private Builder(ViewDefinition viewDefinition) {
      super(viewDefinition);
      this.query = viewDefinition.query;
      this.userDefinedFunctions = viewDefinition.userDefinedFunctions;
      this.useLegacySql = viewDefinition.useLegacySql;
    }

    private Builder(Table tablePb) {
      super(tablePb);
      com.google.api.services.bigquery.model.ViewDefinition viewPb = tablePb.getView();
      if (viewPb != null) {
        this.query = viewPb.getQuery();
        this.useLegacySql = viewPb.getUseLegacySql();
        if (viewPb.getUserDefinedFunctionResources() != null) {
          this.userDefinedFunctions = Lists.transform(viewPb.getUserDefinedFunctionResources(),
              UserDefinedFunction.FROM_PB_FUNCTION);
        }
      }
    }


    /**
     * Sets the query used to create the view.
     */
    public Builder setQuery(String query) {
      this.query = checkNotNull(query);
      return self();
    }


    /**
     * Sets user defined functions that can be used by {@link #getQuery()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder setUserDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(checkNotNull(userDefinedFunctions));
      return self();
    }


    /**
     * Sets user defined functions that can be used by {@link #getQuery()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder setUserDefinedFunctions(UserDefinedFunction... userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(userDefinedFunctions);
      return self();
    }

    /**
     * Sets whether to use BigQuery's legacy SQL dialect for this query. By default this property is
     * set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
     * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>.
     *
     * <p>If set to {@code null} or {@code true}, legacy SQL dialect is used. This property is
     * experimental and might be subject to change.
     */
    public Builder setUseLegacySql(Boolean useLegacySql) {
      this.useLegacySql = useLegacySql;
      return this;
    }

    /**
     * Creates a {@code ViewDefinition} object.
     */
    @Override
    public ViewDefinition build() {
      return new ViewDefinition(this);
    }
  }

  private ViewDefinition(Builder builder) {
    super(builder);
    this.query = builder.query;
    this.useLegacySql = builder.useLegacySql;
    this.userDefinedFunctions = builder.userDefinedFunctions;
  }


  /**
   * Returns the query used to create the view.
   */
  public String getQuery() {
    return query;
  }


  /**
   * Returns user defined functions that can be used by {@link #getQuery()}. Returns {@code null} if
   * not set.
   *
   * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions
   *     </a>
   */
  public List<UserDefinedFunction> getUserDefinedFunctions() {
    return userDefinedFunctions;
  }

  /**
   * Returns whether to use BigQuery's legacy SQL dialect for this query. By default this property
   * is set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
   * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>. If set to {@code
   * null} or {@code true}, legacy SQL dialect is used. This property is experimental and might be
   * subject to change.
   */
  public Boolean useLegacySql() {
    return useLegacySql;
  }

  /**
   * Returns a builder for the {@code ViewInfo} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("query", query)
        .add("useLegacySql", useLegacySql)
        .add("userDefinedFunctions", userDefinedFunctions);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(ViewDefinition.class)
        && baseEquals((ViewDefinition) obj);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), query, userDefinedFunctions);
  }

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    com.google.api.services.bigquery.model.ViewDefinition viewDefinition =
        new com.google.api.services.bigquery.model.ViewDefinition().setQuery(query);
    if (userDefinedFunctions != null) {
      viewDefinition.setUserDefinedFunctionResources(Lists.transform(userDefinedFunctions,
          UserDefinedFunction.TO_PB_FUNCTION));
    }
    viewDefinition.setUseLegacySql(useLegacySql);
    tablePb.setView(viewDefinition);
    return tablePb;
  }


  /**
   * Returns a builder for a BigQuery view definition.
   *
   * @param query the query used to generate the view
   */
  public static Builder newBuilder(String query) {
    return new Builder().setQuery(query);
  }


  /**
   * Returns a builder for a BigQuery view definition.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder newBuilder(String query, List<UserDefinedFunction> functions) {
    return newBuilder(query).setUserDefinedFunctions(functions);
  }


  /**
   * Returns a builder for a BigQuery view definition.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder newBuilder(String query, UserDefinedFunction... functions) {
    return newBuilder(query).setUserDefinedFunctions(functions);
  }

  /**
   * Creates a BigQuery view definition given the query used to generate the table.
   *
   * @param query the query used to generate the table
   */
  public static ViewDefinition of(String query) {
    return newBuilder(query).build();
  }

  /**
   * Creates a BigQuery view definition given a query and some user-defined functions.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewDefinition of(String query, List<UserDefinedFunction> functions) {
    return newBuilder(query, functions).build();
  }

  /**
   * Creates a BigQuery view definition given a query and some user-defined functions.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewDefinition of(String query, UserDefinedFunction... functions) {
    return newBuilder(query, functions).build();
  }

  @SuppressWarnings("unchecked")
  static ViewDefinition fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }
}
