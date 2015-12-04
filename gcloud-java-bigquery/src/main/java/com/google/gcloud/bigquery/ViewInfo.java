/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.ViewDefinition;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery View Table information. BigQuery's views are logical views, not materialized
 * views, which means that the query that defines the view is re-executed every time the view is
 * queried.
 *
 * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
 */
public class ViewInfo extends BaseTableInfo {

  private static final long serialVersionUID = 7567772157817454901L;

  private final String query;
  private final List<UserDefinedFunction> userDefinedFunctions;

  public static final class Builder extends BaseTableInfo.Builder<ViewInfo, Builder> {

    private String query;
    private List<UserDefinedFunction> userDefinedFunctions;

    private Builder() {}

    private Builder(ViewInfo viewInfo) {
      super(viewInfo);
      this.query = viewInfo.query;
      this.userDefinedFunctions = viewInfo.userDefinedFunctions;
    }

    @Override
    protected Builder self() {
      return this;
    }

    /**
     * Sets the query used to create the view.
     */
    public Builder query(String query) {
      this.query = checkNotNull(query);
      return self();
    }

    /**
     * Sets user defined functions that can be used by {@link #query()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions
     *     </a>
     */
    public Builder userDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(checkNotNull(userDefinedFunctions));
      return self();
    }

    /**
     * Sets user defined functions that can be used by {@link #query()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions
     *     </a>
     */
    public Builder userDefinedFunctions(UserDefinedFunction... userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(userDefinedFunctions);
      return self();
    }

    /**
     * Creates a {@code ViewInfo} object.
     */
    @Override
    public ViewInfo build() {
      return new ViewInfo(this);
    }
  }

  private ViewInfo(Builder builder) {
    super(builder);
    this.query = checkNotNull(builder.query);
    this.userDefinedFunctions = builder.userDefinedFunctions;
  }

  /**
   * Returns the query used to create the view.
   */
  public String query() {
    return query;
  };

  /**
   * Returns user defined functions that can be used by {@link #query()}. Returns {@code null} if
   * not set.
   *
   * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions
   *     </a>
   */
  public List<UserDefinedFunction> userDefinedFunctions() {
    return userDefinedFunctions;
  }

  /**
   * Returns a builder for the {@code ViewInfo} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  protected MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("query", query)
        .add("userDefinedFunctions", userDefinedFunctions);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ViewInfo && Objects.equals(toPb(), ((ViewInfo) obj).toPb());
  }

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    ViewDefinition viewDefinition = new ViewDefinition()
        .setQuery(query);
    if (userDefinedFunctions != null) {
      viewDefinition.setUserDefinedFunctionResources(Lists.transform(userDefinedFunctions,
          UserDefinedFunction.TO_PB_FUNCTION));
    }
    tablePb.setView(viewDefinition);
    return tablePb;
  }

  /**
   * Returns a builder for a BigQuery View Table.
   *
   * @param tableId table id
   * @param query the query used to generate the table
   */
  public static Builder builder(TableId tableId, String query) {
    return new Builder().tableId(tableId).type(Type.VIEW).query(query);
  }

  /**
   * Returns a builder for a BigQuery View Table.
   *
   * @param table table id
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder builder(TableId table, String query, List<UserDefinedFunction> functions) {
    return new Builder()
        .tableId(table)
        .type(Type.VIEW)
        .userDefinedFunctions(functions)
        .query(query);
  }

  /**
   * Returns a builder for a BigQuery View Table.
   *
   * @param table table id
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder builder(TableId table, String query, UserDefinedFunction... functions) {
    return new Builder()
        .tableId(table)
        .type(Type.VIEW)
        .userDefinedFunctions(functions)
        .query(query);
  }

  /**
   * Creates a BigQuery View given table identity and query.
   *
   * @param tableId table id
   * @param query the query used to generate the table
   */
  public static ViewInfo of(TableId tableId, String query) {
    return builder(tableId, query).build();
  }

  /**
   * Creates a BigQuery View given table identity, a query and some user-defined functions.
   *
   * @param table table id
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewInfo of(TableId table, String query, List<UserDefinedFunction> functions) {
    return builder(table, query, functions).build();
  }

  /**
   * Creates a BigQuery View given table identity, a query and some user-defined functions.
   *
   * @param table table id
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewInfo of(TableId table, String query, UserDefinedFunction... functions) {
    return builder(table, query, functions).build();
  }
}
