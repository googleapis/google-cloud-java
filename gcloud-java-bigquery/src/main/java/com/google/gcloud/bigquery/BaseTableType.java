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
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for a Google BigQuery table type.
 */
public abstract class BaseTableType implements Serializable{

  private static final long serialVersionUID = -374760330662959529L;

  /**
   * The table type.
   */
  public enum Type {
    /**
     * A normal BigQuery table. Instances of {@code BaseTableType} for this type are implemented by
     * {@link DefaultTableType}.
     */
    TABLE,

    /**
     * A virtual table defined by a SQL query. Instances of {@code BaseTableType} for this type are
     * implemented by {@link ViewType}.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
     */
    VIEW,

    /**
     * A BigQuery table backed by external data. Instances of {@code BaseTableType} for this type
     * are implemented by {@link ExternalTableType}.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    EXTERNAL
  }

  private final Type type;
  private final Schema schema;

  /**
   * Base builder for table types.
   *
   * @param <T> the table type class
   * @param <B> the table type builder
   */
  public abstract static class Builder<T extends BaseTableType, B extends Builder<T, B>> {

    private Type type;
    private Schema schema;

    Builder(Type type) {
      this.type = type;
    }

    Builder(BaseTableType tableType) {
      this.type = tableType.type;
      this.schema = tableType.schema;
    }

    Builder(Table tablePb) {
      this.type = Type.valueOf(tablePb.getType());
      if (tablePb.getSchema() != null) {
        this.schema(Schema.fromPb(tablePb.getSchema()));
      }
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B type(Type type) {
      this.type = type;
      return self();
    }

    /**
     * Sets the table schema.
     */
    public B schema(Schema schema) {
      this.schema = checkNotNull(schema);
      return self();
    }

    /**
     * Creates an object.
     */
    public abstract T build();
  }

  BaseTableType(Builder builder) {
    this.type = builder.type;
    this.schema = builder.schema;
  }

  /**
   * Returns the table's type. If this table is simple table the method returns {@link Type#TABLE}.
   * If this table is an external table this method returns {@link Type#EXTERNAL}. If this table is
   * a view table this method returns {@link Type#VIEW}.
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

  final boolean baseEquals(BaseTableType jobConfiguration) {
    return Objects.equals(toPb(), jobConfiguration.toPb());
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
  static <T extends BaseTableType> T fromPb(Table tablePb) {
    switch (Type.valueOf(tablePb.getType())) {
      case TABLE:
        return (T) DefaultTableType.fromPb(tablePb);
      case VIEW:
        return (T) ViewType.fromPb(tablePb);
      case EXTERNAL:
        return (T) ExternalTableType.fromPb(tablePb);
      default:
        // never reached
        throw new IllegalArgumentException("Format " + tablePb.getType() + " is not supported");
    }
  }
}
