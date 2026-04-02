/*
 * Copyright 2016 Google LLC
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

import com.google.api.services.bigquery.model.Table;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Google BigQuery view table definition. BigQuery's views are logical views, not materialized
 * views, which means that the query that defines the view is re-executed every time the view is
 * queried.
 *
 * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
 */
@AutoValue
public abstract class ViewDefinition extends TableDefinition {

  private static final long serialVersionUID = -8789311196910794545L;

  @AutoValue.Builder
  public abstract static class Builder extends TableDefinition.Builder<ViewDefinition, Builder> {
    /** Sets the query used to create the view. */
    public abstract Builder setQuery(String query);

    /**
     * Sets user defined functions that can be used by {@link #getQuery()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder setUserDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      return setUserDefinedFunctionsImmut(ImmutableList.copyOf(userDefinedFunctions));
    }

    /**
     * Sets user defined functions that can be used by {@link #getQuery()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder setUserDefinedFunctions(UserDefinedFunction... userDefinedFunctions) {
      return setUserDefinedFunctionsImmut(ImmutableList.copyOf(userDefinedFunctions));
    }

    abstract Builder setUserDefinedFunctionsImmut(
        ImmutableList<UserDefinedFunction> userDefinedFunctions);

    /**
     * Sets whether to use BigQuery's legacy SQL dialect for this query. By default this property is
     * set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
     * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>.
     *
     * <p>If set to {@code null} or {@code true}, legacy SQL dialect is used. This property is
     * experimental and might be subject to change.
     */
    public abstract Builder setUseLegacySql(Boolean useLegacySql);

    public abstract Builder setType(Type type);

    /** Sets the table schema. */
    public abstract Builder setSchema(Schema schema);

    /** Creates a {@code ViewDefinition} object. */
    @Override
    public abstract ViewDefinition build();
  }

  /** Returns the query used to create the view. */
  @Nullable
  public abstract String getQuery();

  /**
   * Returns user defined functions that can be used by {@link #getQuery()}. Returns {@code null} if
   * not set.
   *
   * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions
   *     </a>
   */
  public List<UserDefinedFunction> getUserDefinedFunctions() {
    return getUserDefinedFunctionsImmut();
  }

  @Nullable
  abstract ImmutableList<UserDefinedFunction> getUserDefinedFunctionsImmut();

  /**
   * Returns whether to use BigQuery's legacy SQL dialect for this query. By default this property
   * is set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
   * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>. If set to {@code
   * null} or {@code true}, legacy SQL dialect is used. This property is experimental and might be
   * subject to change.
   */
  @Nullable
  public Boolean useLegacySql() {
    return getUseLegacySql();
  }

  @Nullable
  abstract Boolean getUseLegacySql();

  /** Returns a builder for the {@code ViewInfo} object. */
  public abstract Builder toBuilder();

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    com.google.api.services.bigquery.model.ViewDefinition viewDefinition =
        new com.google.api.services.bigquery.model.ViewDefinition().setQuery(getQuery());
    if (getUserDefinedFunctions() != null) {
      viewDefinition.setUserDefinedFunctionResources(
          Lists.transform(getUserDefinedFunctions(), UserDefinedFunction.TO_PB_FUNCTION));
    }
    viewDefinition.setUseLegacySql(useLegacySql());
    tablePb.setView(viewDefinition);
    return tablePb;
  }

  static Builder newBuilder() {
    return new AutoValue_ViewDefinition.Builder().setType(Type.VIEW).setUseLegacySql(false);
  }

  /**
   * Returns a builder for a BigQuery view definition.
   *
   * @param query the query used to generate the view
   */
  public static Builder newBuilder(String query) {
    return newBuilder().setQuery(query);
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
    Builder builder = newBuilder().table(tablePb);
    com.google.api.services.bigquery.model.ViewDefinition viewPb = tablePb.getView();
    if (viewPb != null) {
      builder.setQuery(viewPb.getQuery()).setUseLegacySql(viewPb.getUseLegacySql());
      if (viewPb.getUserDefinedFunctionResources() != null) {
        builder.setUserDefinedFunctions(
            Lists.transform(
                viewPb.getUserDefinedFunctionResources(), UserDefinedFunction.FROM_PB_FUNCTION));
      }
    }
    return builder.build();
  }
}
