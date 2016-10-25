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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class represents the schema for a Google BigQuery Table or data source.
 */
public final class Schema implements Serializable {

  static final Function<com.google.api.services.bigquery.model.TableSchema, Schema>
      FROM_PB_FUNCTION = new Function<com.google.api.services.bigquery.model.TableSchema,
          Schema>() {
            @Override
            public Schema apply(com.google.api.services.bigquery.model.TableSchema pb) {
              return Schema.fromPb(pb);
            }
          };
  static final Function<Schema, com.google.api.services.bigquery.model.TableSchema>
      TO_PB_FUNCTION = new Function<Schema,
          com.google.api.services.bigquery.model.TableSchema>() {
            @Override
            public com.google.api.services.bigquery.model.TableSchema apply(Schema schema) {
              return schema.toPb();
            }
          };

  private static final long serialVersionUID = 2007400596384553696L;

  private final List<Field> fields;

  public static final class Builder {

    private List<Field> fields;

    private Builder() {}

    /**
     * Adds a field's schema to the table's schema.
     */
    public Builder addField(Field field) {
      if (fields == null) {
        fields = Lists.newArrayList();
      }
      fields.add(checkNotNull(field));
      return this;
    }

    /**
     * Sets table's schema fields.
     */
    @Deprecated
    public Builder fields(Iterable<Field> fields) {
      return setFields(fields);
    }

    /**
     * Sets table's schema fields.
     */
    public Builder setFields(Iterable<Field> fields) {
      this.fields = Lists.newArrayList(checkNotNull(fields));
      return this;
    }

    /**
     * Sets table's schema fields.
     */
    @Deprecated
    public Builder fields(Field... fields) {
      return setFields(fields);
    }

    /**
     * Sets table's schema fields.
     */
    public Builder setFields(Field... fields) {
      this.fields = Lists.newArrayList(fields);
      return this;
    }

    /**
     * Creates an {@code Schema} object.
     */
    public Schema build() {
      return new Schema(this);
    }
  }

  private Schema(Builder builder) {
    this.fields = builder.fields != null ? ImmutableList.copyOf(builder.fields)
        : ImmutableList.<Field>of();
  }

  /**
   * Returns the fields in the current table schema.
   */
  @Deprecated
  public List<Field> fields() {
    return getFields();
  }

  /**
   * Returns the fields in the current table schema.
   */
  public List<Field> getFields() {
    return fields;
  }

  /**
   * Returns a builder for the {@code Schema} object.
   */
  public Builder toBuilder() {
    return newBuilder().setFields(fields);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("fields", fields)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof Schema
        && Objects.equals(toPb(), ((Schema) obj).toPb());
  }

  com.google.api.services.bigquery.model.TableSchema toPb() {
    com.google.api.services.bigquery.model.TableSchema tableSchemaPb =
        new com.google.api.services.bigquery.model.TableSchema();
    if (fields != null) {
      List<TableFieldSchema> fieldsPb = Lists.transform(fields, Field.TO_PB_FUNCTION);
      tableSchemaPb.setFields(fieldsPb);
    }
    return tableSchemaPb;
  }

  /**
   * Creates a builder for a {@code Schema} object.
   */
  @Deprecated
  public static Builder builder() {
    return newBuilder();
  }

  /**
   * Creates a builder for a {@code Schema} object.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a {@code Schema} object given a list of fields.
   */
  public static Schema of(Iterable<Field> fields) {
    return newBuilder().setFields(fields).build();
  }

  /**
   * Creates a {@code Schema} object given some fields.
   */
  public static Schema of(Field... fields) {
    return newBuilder().setFields(fields).build();
  }

  static Schema fromPb(com.google.api.services.bigquery.model.TableSchema tableSchemaPb) {
    return Schema.of(Lists.transform(tableSchemaPb.getFields(), Field.FROM_PB_FUNCTION));
  }
}
