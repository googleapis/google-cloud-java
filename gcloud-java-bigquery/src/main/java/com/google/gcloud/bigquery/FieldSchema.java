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

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google Bigquery schema for a Table field. Several data types and modes are supported.
 */
public class FieldSchema implements Serializable {

  static final Function<TableFieldSchema, FieldSchema> FROM_PB_FUNCTION =
      new Function<TableFieldSchema, FieldSchema>() {
        @Override
        public FieldSchema apply(TableFieldSchema pb) {
          return FieldSchema.fromPb(pb);
        }
      };
  static final Function<FieldSchema, TableFieldSchema> TO_PB_FUNCTION =
      new Function<FieldSchema, TableFieldSchema>() {
        @Override
        public TableFieldSchema apply(FieldSchema fieldSchema) {
          return fieldSchema.toPb();
        }
      };

  private static final long serialVersionUID = -8154262932305199256L;

  /**
   * Data Types for a BigQuery Table field.
   *
   * @see <a href="https://cloud.google.com/bigquery/preparing-data-for-bigquery#datatypes">
   *     Data Types</a>
   */
  public enum Type {
    STRING, INTEGER, FLOAT, BOOLEAN, TIMESTAMP, RECORD
  }

  /**
   * Mode for a BigQuery Table field. {@link Mode#NULLABLE} fields can be set to {@code null},
   * {@link Mode#REQUIRED} fields must be provided. {@link Mode#REPEATED} fields can contain more
   * than one value.
   */
  public enum Mode {
    NULLABLE, REQUIRED, REPEATED
  }

  private final String name;
  private final Type type;
  private final Mode mode;
  private final String description;
  private final List<FieldSchema> fields;

  public static final class Builder {

    private String name;
    private Type type;
    private Mode mode;
    private String description;
    private List<FieldSchema> fields;

    private Builder() {}

    /**
     * Sets the field name. The name must contain only letters (a-z, A-Z), numbers (0-9), or
     * underscores (_), and must start with a letter or underscore. The maximum length is 128
     * characters.
     */
    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /**
     * Sets the type of the field.
     *
     * @see <a href="https://cloud.google.com/bigquery/preparing-data-for-bigquery#datatypes">
     *     Data Types</a>
     */
    public Builder type(Type type) {
      this.type = checkNotNull(type);
      return this;
    }

    /**
     * Sets the mode of the field. By default {@link Mode#NULLABLE} is used.
     */
    public Builder mode(Mode mode) {
      this.mode = mode;
      return this;
    }

    /**
     * Sets the field description. The maximum length is 16K characters.
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Sets the nested schema fields if {@link #type(Type)} is set to {@link Type#RECORD}.
     */
    Builder fields(Iterable<FieldSchema> fields) {
      this.fields = fields != null ? ImmutableList.copyOf(fields) : null;
      return this;
    }

    /**
     * Creates an {@code FieldSchema} object.
     */
    public FieldSchema build() {
      FieldSchema fieldSchema = new FieldSchema(this);
      checkNotNull(fieldSchema.name);
      checkNotNull(fieldSchema.type);
      return fieldSchema;
    }
  }

  private FieldSchema(Builder builder) {
    this.name = builder.name;
    this.type = builder.type;
    this.mode = builder.mode;
    this.description = builder.description;
    this.fields = builder.fields;
  }

  /**
   * Returns the field name.
   */
  public String name() {
    return name;
  }

  /**
   * Returns the field type.
   *
   * @see <a href="https://cloud.google.com/bigquery/preparing-data-for-bigquery#datatypes">
   *     Data Types</a>
   */
  public Type type() {
    return type;
  }

  /**
   * Returns the field mode. By default {@link Mode#NULLABLE} is used.
   */
  public Mode mode() {
    return mode;
  }

  /**
   * Returns the field description.
   */
  public String description() {
    return description;
  }

  /**
   * Returns the nested schema fields if {@link #type()} is set to {@link Type#RECORD}. Returns
   * {@code null} otherwise.
   */
  public List<FieldSchema> fields() {
    return fields;
  }

  /**
   * Returns a builder for the {@code FieldSchema} object.
   */
  public Builder toBuilder() {
    return new Builder()
        .name(this.name)
        .type(this.type)
        .mode(this.mode)
        .description(this.description)
        .fields(this.fields);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("type", type)
        .add("mode", mode)
        .add("description", description)
        .add("fields", fields)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, mode, description, fields);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof FieldSchema && Objects.equals(toPb(), ((FieldSchema) obj).toPb());
  }

  TableFieldSchema toPb() {
    TableFieldSchema fieldSchemaPb = new TableFieldSchema();
    fieldSchemaPb.setName(name);
    fieldSchemaPb.setType(type.name());
    if (mode != null) {
      fieldSchemaPb.setMode(mode.name());
    }
    if (description != null) {
      fieldSchemaPb.setDescription(description);
    }
    if (fields != null) {
      List<TableFieldSchema> fieldsPb = Lists.transform(fields, TO_PB_FUNCTION);
      fieldSchemaPb.setFields(fieldsPb);
    }
    return fieldSchemaPb;
  }

  /**
   * Returns a FieldSchema object with given name and type.  This method should only be used to
   * create fields with primitive types (i.e. {@link Type#FLOAT}, {@link Type#BOOLEAN},
   * {@link Type#INTEGER}, {@link Type#STRING} and {@link Type#TIMESTAMP}).
   */
  public static FieldSchema of(String name, Type type) {
    return builder(name, type).build();
  }

  /**
   * Returns a FieldSchema object of type {@link Type#RECORD} for the provided name and subfields.
   */
  public static FieldSchema of(String name, List<FieldSchema> fields) {
    return builder(name, fields).type(Type.RECORD).build();
  }

  /**
   * Returns a builder for a FieldSchema object with given name and type.
   */
  public static Builder builder(String name, Type type) {
    return new Builder().name(name).type(type);
  }

  /**
   * Returns a builder for a FieldSchema object with given name and list of subfields. Type is set
   * to {@link Type#RECORD}.
   */
  public static Builder builder(String name, List<FieldSchema> fields) {
    return new Builder().name(name).type(Type.RECORD).fields(fields);
  }

  static FieldSchema fromPb(TableFieldSchema fieldSchemaPb) {
    Builder fieldBuilder = new Builder();
    fieldBuilder.name(fieldSchemaPb.getName());
    fieldBuilder.type(Type.valueOf(fieldSchemaPb.getType()));
    if (fieldSchemaPb.getMode() != null) {
      fieldBuilder.mode(Mode.valueOf(fieldSchemaPb.getMode()));
    }
    if (fieldSchemaPb.getDescription() != null) {
      fieldBuilder.description(fieldSchemaPb.getDescription());
    }
    if (fieldSchemaPb.getFields() != null) {
      fieldBuilder.fields(Lists.transform(fieldSchemaPb.getFields(), FROM_PB_FUNCTION));
    }
    return fieldBuilder.build();
  }
}
