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

import com.google.api.core.ApiFunction;
import com.google.api.services.bigquery.model.Table;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for a Google BigQuery table definition.
 */
public abstract class TableDefinition implements Serializable {

  private static final long serialVersionUID = -374760330662959529L;

  private final Type type;
  private final Schema schema;

  /**
   * The table type.
   */
  public static final class Type extends StringEnumValue {
    private static final long serialVersionUID = -551560816480511474L;

    private static final ApiFunction<String, Type> CONSTRUCTOR =
        new ApiFunction<String, Type>() {
          @Override
          public Type apply(String constant) {
            return new Type(constant);
          }
        };

    private static final StringEnumType<Type> type = new StringEnumType(
        Type.class,
        CONSTRUCTOR);

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
     * A BigQuery table backed by external data. Instances of {@code TableDefinition} for this type
     * are implemented by {@link ExternalTableDefinition}.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    public static final Type EXTERNAL = type.createAndRegister("EXTERNAL");

    private Type(String constant) {
      super(constant);
    }

    /**
     * Get the Type for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static Type valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the Type for the given String constant, and allow unrecognized values.
     */
    public static Type valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values for Type.
     */
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

    private Type type;
    private Schema schema;

    Builder(Type type) {
      this.type = type;
    }

    Builder(TableDefinition tableDefinition) {
      this.type = tableDefinition.type;
      this.schema = tableDefinition.schema;
    }

    Builder(Table tablePb) {
      this.type = Type.valueOf(tablePb.getType());
      if (tablePb.getSchema() != null) {
        this.setSchema(Schema.fromPb(tablePb.getSchema()));
      }
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B setType(Type type) {
      this.type = type;
      return self();
    }


    /**
     * Sets the table schema.
     */
    public B setSchema(Schema schema) {
      this.schema = schema;
      return self();
    }

    /**
     * Creates an object.
     */
    public abstract T build();
  }

  TableDefinition(Builder builder) {
    this.type = builder.type;
    this.schema = builder.schema;
  }


  /**
   * Returns the table's type. If this table is simple table the method returns {@link Type#TABLE}.
   * If this table is an external table this method returns {@link Type#EXTERNAL}. If this table is
   * a view table this method returns {@link Type#VIEW}.
   */
  public Type getType() {
    return type;
  }


  /**
   * Returns the table's schema.
   */
  public Schema getSchema() {
    return schema;
  }

  /**
   * Returns a builder for the object.
   */
  public abstract Builder toBuilder();

  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("type", type).add("schema", schema);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(type);
  }

  final boolean baseEquals(TableDefinition tableDefinition) {
    return Objects.equals(toPb(), tableDefinition.toPb());
  }

  Table toPb() {
    Table tablePb = new Table();
    if (schema != null) {
      tablePb.setSchema(schema.toPb());
    }
    tablePb.setType(type.name());
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static <T extends TableDefinition> T fromPb(Table tablePb) {
    switch (Type.valueOf(tablePb.getType()).toString()) {
      case "TABLE":
        return (T) StandardTableDefinition.fromPb(tablePb);
      case "VIEW":
        return (T) ViewDefinition.fromPb(tablePb);
      case "EXTERNAL":
        return (T) ExternalTableDefinition.fromPb(tablePb);
      default:
        // never reached
        throw new IllegalArgumentException("Format " + tablePb.getType() + " is not supported");
    }
  }
}
