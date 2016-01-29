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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.ViewDefinition;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery view table type. BigQuery's views are logical views, not materialized views,
 * which means that the query that defines the view is re-executed every time the view is queried.
 *
 * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
 */
public final class ViewType extends BaseTableType {

  private static final long serialVersionUID = -8789311196910794545L;

  private final String query;
  private final List<UserDefinedFunction> userDefinedFunctions;

  public static final class Builder extends BaseTableType.Builder<ViewType, Builder> {

    private String query;
    private List<UserDefinedFunction> userDefinedFunctions;

    private Builder() {
      super(Type.VIEW);
    }

    private Builder(ViewType viewType) {
      super(viewType);
      this.query = viewType.query;
      this.userDefinedFunctions = viewType.userDefinedFunctions;
    }

    private Builder(Table tablePb) {
      super(tablePb);
      ViewDefinition viewPb = tablePb.getView();
      if (viewPb != null) {
        this.query = viewPb.getQuery();
        if (viewPb.getUserDefinedFunctionResources() != null) {
          this.userDefinedFunctions = Lists.transform(viewPb.getUserDefinedFunctionResources(),
              UserDefinedFunction.FROM_PB_FUNCTION);
        }
      }
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
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder userDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(checkNotNull(userDefinedFunctions));
      return self();
    }

    /**
     * Sets user defined functions that can be used by {@link #query()}.
     *
     * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined
     *     Functions</a>
     */
    public Builder userDefinedFunctions(UserDefinedFunction... userDefinedFunctions) {
      this.userDefinedFunctions = ImmutableList.copyOf(userDefinedFunctions);
      return self();
    }

    /**
     * Creates a {@code ViewType} object.
     */
    @Override
    public ViewType build() {
      return new ViewType(this);
    }
  }

  private ViewType(Builder builder) {
    super(builder);
    this.query = builder.query;
    this.userDefinedFunctions = builder.userDefinedFunctions;
  }

  /**
   * Returns the query used to create the view.
   */
  public String query() {
    return query;
  }

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
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("query", query)
        .add("userDefinedFunctions", userDefinedFunctions);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ViewType && baseEquals((ViewType) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), query, userDefinedFunctions);
  }

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    ViewDefinition viewDefinition = new ViewDefinition().setQuery(query);
    if (userDefinedFunctions != null) {
      viewDefinition.setUserDefinedFunctionResources(Lists.transform(userDefinedFunctions,
          UserDefinedFunction.TO_PB_FUNCTION));
    }
    tablePb.setView(viewDefinition);
    return tablePb;
  }

  /**
   * Returns a builder for a BigQuery view type.
   *
   * @param query the query used to generate the view
   */
  public static Builder builder(String query) {
    return new Builder().query(query);
  }

  /**
   * Returns a builder for a BigQuery view type.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder builder(String query, List<UserDefinedFunction> functions) {
    return new Builder().type(Type.VIEW).userDefinedFunctions(functions).query(query);
  }

  /**
   * Returns a builder for a BigQuery view type.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static Builder builder(String query, UserDefinedFunction... functions) {
    return new Builder().type(Type.VIEW).userDefinedFunctions(functions).query(query);
  }

  /**
   * Creates a BigQuery view type given the query used to generate the table.
   *
   * @param query the query used to generate the table
   */
  public static ViewType of(String query) {
    return builder(query).build();
  }

  /**
   * Creates a BigQuery view type given a query and some user-defined functions.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewType of(String query, List<UserDefinedFunction> functions) {
    return builder(query, functions).build();
  }

  /**
   * Creates a BigQuery view type given a query and some user-defined functions.
   *
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   */
  public static ViewType of(String query, UserDefinedFunction... functions) {
    return builder(query, functions).build();
  }

  @SuppressWarnings("unchecked")
  static ViewType fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }
}
