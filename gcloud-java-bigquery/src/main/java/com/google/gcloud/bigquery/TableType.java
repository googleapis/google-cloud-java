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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Table type. A BigQuery table can be of three types. {@link Type#TABLE} is a
 * normal BigQuery table. {@link Type#VIEW} is a view table, created from a query.
 * {@link Type#EXTERNAL} is an external table, backed by Google Cloud Storage data.
 */
public class TableType implements Serializable {

  /**
   * The table type.
   */
  public enum Type {
    /**
     * A normal BigQuery table.
     */
    TABLE,
    /**
     * A virtual table defined by a SQL query.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
     */
    VIEW,
    /**
     * A BigQuery table backed by external data.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    EXTERNAL
  }

  private final Type type;
  private final Schema schema;

  TableType(Type type, Schema schema) {
    this.type = type;
    this.schema = schema;
  }

  /**
   * Returns the type of the table.
   */
  public Type type() {
    return type;
  }

  /**
   * Returns the table's schema.
   */
  public Schema schema() {
    return schema;
  }

  /**
   * Google BigQuery View type.
   */
  public static class View extends TableType {

    private static final long serialVersionUID = 8275064752050652381L;

    private final String query;
    private final List<UserDefinedFunction> userDefinedFunctions;

    View(String query) {
      this(null, query, null);
    }

    View(String query, List<UserDefinedFunction> userDefinedFunctions) {
      this(null, query, userDefinedFunctions);
    }

    View(Schema schema, String query, List<UserDefinedFunction> userDefinedFunctions) {
      super(Type.VIEW, schema);
      this.query = query;
      this.userDefinedFunctions = userDefinedFunctions;
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

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("type", type())
          .add("query", query)
          .add("userDefinedFunctions", userDefinedFunctions)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(schema(), query, userDefinedFunctions);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof View)) {
        return false;
      }
      View other = (View) obj;
      return Objects.equals(type(), other.type())
          && Objects.equals(query, other.query)
          && Objects.equals(userDefinedFunctions, other.userDefinedFunctions);
    }
  }

  /**
   * Google BigQuery External Table type.
   */
  public static class ExternalTable extends TableType {

    private static final long serialVersionUID = -6912214693318638552L;

    private final ExternalDataConfiguration configuration;

    ExternalTable(ExternalDataConfiguration configuration) {
      this(null, configuration);
    }

    ExternalTable(Schema schema, ExternalDataConfiguration configuration) {
      super(Type.EXTERNAL, schema);
      this.configuration = configuration;
    }

    /**
     * Returns the data format, location and other properties of a table stored outside of BigQuery.
     * This property is experimental and might be subject to change or removed.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    public ExternalDataConfiguration configuration() {
      return configuration;
    };

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("type", type())
          .add("configuration", configuration)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(schema(), configuration);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ExternalTable)) {
        return false;
      }
      ExternalTable other = (ExternalTable) obj;
      return Objects.equals(type(), other.type())
          && Objects.equals(configuration, other.configuration);
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("schema", schema)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, schema);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof TableType)) {
      return false;
    }
    TableType other = (TableType) obj;
    return Objects.equals(type, other.type)
        && Objects.equals(schema, other.schema);
  }

  /**
   * Returns a simple BigQuery Table type.
   */
  public static TableType table(Schema schema) {
    return new TableType(Type.TABLE, checkNotNull(schema));
  }

  /**
   * Returns a BigQuery View type given the query needed to create the view.
   */
  public static View view(String query) {
    return new View(checkNotNull(query));
  }

  /**
   * Returns a BigQuery View type given the query needed to create the view and a list of user
   * defined functions that can be used by the query.
   */
  public static View view(String query, List<UserDefinedFunction> userDefinedFunctions) {
    return new View(checkNotNull(query), checkNotNull(userDefinedFunctions));
  }

  /**
   * Returns a BigQuery View type given the query needed to create the view and a list of user
   * defined functions that can be used by the query.
   */
  public static View view(String query, UserDefinedFunction... userDefinedFunctions) {
    return new View(checkNotNull(query), ImmutableList.copyOf(userDefinedFunctions));
  }

  /**
   * Returns a BigQuery External Table type given the external data configuration.
   */
  public static ExternalTable externalTable(ExternalDataConfiguration configuration) {
    return new ExternalTable(checkNotNull(configuration));
  }
}
