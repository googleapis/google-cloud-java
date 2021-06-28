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

import com.google.api.core.ApiFunction;
import com.google.api.services.bigquery.model.Table;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import java.io.Serializable;
import javax.annotation.Nullable;

/** Base class for a Google BigQuery table definition. */
public abstract class TableDefinition implements Serializable {

  private static final long serialVersionUID = -374760330662959529L;

  /** The table type. */
  public static final class Type extends StringEnumValue {
    private static final long serialVersionUID = -551560816480511474L;

    private static final ApiFunction<String, Type> CONSTRUCTOR =
        new ApiFunction<String, Type>() {
          @Override
          public Type apply(String constant) {
            return new Type(constant);
          }
        };

    private static final StringEnumType<Type> type =
        new StringEnumType<Type>(Type.class, CONSTRUCTOR);

    /**
     * A normal BigQuery table. Instances of {@code TableDefinition} for this type are implemented
     * by {@link StandardTableDefinition}.
     */
    public static final Type TABLE = type.createAndRegister("TABLE");

    /**
     * A virtual table defined by a SQL query. Instances of {@code TableDefinition} for this type
     * are implemented by {@link ViewDefinition}.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
     */
    public static final Type VIEW = type.createAndRegister("VIEW");

    /**
     * SQL query whose result is persisted. Instances of {@code MaterializedViewDefinition} for this
     * type are implemented by {@link MaterializedViewDefinition}.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
     */
    public static final Type MATERIALIZED_VIEW = type.createAndRegister("MATERIALIZED_VIEW");

    /**
     * A BigQuery table backed by external data. Instances of {@code TableDefinition} for this type
     * are implemented by {@link ExternalTableDefinition}.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    public static final Type EXTERNAL = type.createAndRegister("EXTERNAL");

    /**
     * A BigQuery table representing BigQuery ML Model.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/standard-sql/bigqueryml-syntax-create#models_in_bqml_name">
     *     BigQuery ML Model</a>
     */
    public static final Type MODEL = type.createAndRegister("MODEL");

    public static final Type SNAPSHOT = type.createAndRegister("SNAPSHOT");

    private Type(String constant) {
      super(constant);
    }

    /**
     * Get the Type for the given String constant, and throw an exception if the constant is not
     * recognized.
     */
    public static Type valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the Type for the given String constant, and allow unrecognized values. */
    public static Type valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for Type. */
    public static Type[] values() {
      return type.values();
    }
  }

  /**
   * Base builder for table definitions.
   *
   * @param <T> the table definition class
   * @param <B> the table definition builder
   */
  public abstract static class Builder<T extends TableDefinition, B extends Builder<T, B>> {
    public abstract B setType(Type type);

    /** Sets the table schema. */
    public abstract B setSchema(Schema schema);

    /** Creates an object. */
    public abstract T build();

    B table(Table tablePb) {
      if (tablePb.getSchema() != null) {
        setSchema(Schema.fromPb(tablePb.getSchema()));
      }
      return setType(Type.valueOf(tablePb.getType()));
    }
  }

  /**
   * Returns the table's type. If this table is simple table the method returns {@link Type#TABLE}.
   * If this table is an external table this method returns {@link Type#EXTERNAL}. If this table is
   * a view table this method returns {@link Type#VIEW}.
   */
  public abstract Type getType();

  /** Returns the table's schema. */
  @Nullable
  public abstract Schema getSchema();

  /** Returns a builder for the object. */
  public abstract Builder toBuilder();

  Table toPb() {
    Table tablePb = new Table();
    if (getSchema() != null) {
      tablePb.setSchema(getSchema().toPb());
    }
    tablePb.setType(getType().name());
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static <T extends TableDefinition> T fromPb(Table tablePb) {
    switch (Type.valueOf(tablePb.getType()).toString()) {
      case "TABLE":
        return (T) StandardTableDefinition.fromPb(tablePb);
      case "VIEW":
        return (T) ViewDefinition.fromPb(tablePb);
      case "MATERIALIZED_VIEW":
        return (T) MaterializedViewDefinition.fromPb(tablePb);
      case "EXTERNAL":
        return (T) ExternalTableDefinition.fromPb(tablePb);
      case "MODEL":
        return (T) ModelTableDefinition.fromPb(tablePb);
      case "SNAPSHOT":
        return (T) SnapshotTableDefinition.fromPb(tablePb);
      default:
        // never reached
        throw new IllegalArgumentException("Format " + tablePb.getType() + " is not supported");
    }
  }
}
