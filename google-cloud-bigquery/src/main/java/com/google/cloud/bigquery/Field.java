/*
 * Copyright 2015 Google LLC
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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Table schema field. A table field has a name, a type, a mode and possibly a
 * description.
 */
public final class Field implements Serializable {

  static final Function<TableFieldSchema, Field> FROM_PB_FUNCTION =
      new Function<TableFieldSchema, Field>() {
        @Override
        public Field apply(TableFieldSchema pb) {
          return Field.fromPb(pb);
        }
      };
  static final Function<Field, TableFieldSchema> TO_PB_FUNCTION =
      new Function<Field, TableFieldSchema>() {
        @Override
        public TableFieldSchema apply(Field field) {
          return field.toPb();
        }
      };

  private static final long serialVersionUID = 8827990270251118556L;

  private final String name;
  private final LegacySQLTypeName type;
  private final FieldList subFields;
  private final String mode;
  private final String description;

  /**
   * Mode for a BigQuery Table field. {@link Mode#NULLABLE} fields can be set to {@code null},
   * {@link Mode#REQUIRED} fields must be provided. {@link Mode#REPEATED} fields can contain more
   * than one value.
   */
  public enum Mode {
    NULLABLE,
    REQUIRED,
    REPEATED
  }

  public static final class Builder {

    private String name;
    private LegacySQLTypeName type;
    private FieldList subFields;
    private String mode;
    private String description;

    private Builder() {}

    private Builder(Field field) {
      this.name = field.name;
      this.type = field.type;
      this.subFields = field.subFields;
      this.mode = field.mode;
      this.description = field.description;
    }

    /**
     * Sets the field name. The name must contain only letters (a-z, A-Z), numbers (0-9), or
     * underscores (_), and must start with a letter or underscore. The maximum length is 128
     * characters.
     */
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /**
     * Sets the type of the field.
     *
     * @param type BigQuery data type
     * @param subFields nested schema fields in case if {@code type} is {@link
     *     LegacySQLTypeName#RECORD}, empty otherwise
     * @throws IllegalArgumentException if {@code type == LegacySQLTypeName.RECORD &&
     *     subFields.length == 0} or if {@code type != LegacySQLTypeName.RECORD && subFields.length
     *     != 0}
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types">Data
     *     Types</a>
     */
    public Builder setType(LegacySQLTypeName type, Field... subFields) {
      return setType(type, subFields.length > 0 ? FieldList.of(subFields) : null);
    }

    /**
     * Sets the type of the field.
     *
     * @param type BigQuery data type
     * @param subFields nested schema fields, in case if {@code type} is {@link
     *     LegacySQLTypeName#RECORD}, {@code null} otherwise.
     * @throws IllegalArgumentException if {@code type == LegacySQLTypeName.RECORD && (subFields ==
     *     null || subFields.isEmpty())} or if {@code type != LegacySQLTypeName.RECORD && subFields
     *     != null}
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types">Data
     *     Types</a>
     */
    public Builder setType(LegacySQLTypeName type, FieldList subFields) {
      if (type == LegacySQLTypeName.RECORD) {
        if (subFields == null || subFields.isEmpty()) {
          throw new IllegalArgumentException(
              "The " + type + " field must have at least one sub-field");
        }
      } else {
        if (subFields != null) {
          throw new IllegalArgumentException(
              "Only " + LegacySQLTypeName.RECORD + " fields can have sub-fields");
        }
      }
      this.type = type;
      this.subFields = subFields;
      return this;
    }

    /** Sets the mode of the field. When not specified {@link Mode#NULLABLE} is used. */
    public Builder setMode(Mode mode) {
      this.mode = mode != null ? mode.name() : Data.<String>nullOf(String.class);
      return this;
    }

    /** Sets the field description. The maximum length is 16K characters. */
    public Builder setDescription(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    /** Creates a {@code Field} object. */
    public Field build() {
      return new Field(this);
    }
  }

  private Field(Builder builder) {
    this.name = checkNotNull(builder.name);
    this.type = checkNotNull(builder.type);
    this.subFields = builder.subFields;
    this.mode = builder.mode;
    this.description = builder.description;
  }

  /** Returns the field name. */
  public String getName() {
    return name;
  }

  /**
   * Returns the field type.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types">Data
   *     Types</a>
   */
  public LegacySQLTypeName getType() {
    return type;
  }

  /** Returns the field mode. By default {@link Mode#NULLABLE} is used. */
  public Mode getMode() {
    return mode != null ? Mode.valueOf(mode) : null;
  }

  /** Returns the field description. */
  public String getDescription() {
    return Data.isNull(description) ? null : description;
  }

  /**
   * Returns the list of sub-fields if {@link #getType()} is a {@link LegacySQLTypeName#RECORD}.
   * Returns {@code null} otherwise.
   */
  public FieldList getSubFields() {
    return subFields;
  }

  /** Returns a builder for the {@code Field} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("type", type)
        .add("mode", mode)
        .add("description", description)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, mode, description);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Field && Objects.equals(toPb(), ((Field) obj).toPb());
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, LegacySQLTypeName type, Field... subFields) {
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, LegacySQLTypeName type, FieldList subFields) {
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, LegacySQLTypeName type, Field... subFields) {
    return new Builder().setName(name).setType(type, subFields);
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, LegacySQLTypeName type, FieldList subFields) {
    return new Builder().setName(name).setType(type, subFields);
  }

  TableFieldSchema toPb() {
    TableFieldSchema fieldSchemaPb = new TableFieldSchema();
    fieldSchemaPb.setName(name);
    fieldSchemaPb.setType(type.name());
    if (mode != null) {
      fieldSchemaPb.setMode(mode);
    }
    if (description != null) {
      fieldSchemaPb.setDescription(description);
    }
    if (getSubFields() != null) {
      List<TableFieldSchema> fieldsPb = Lists.transform(getSubFields(), TO_PB_FUNCTION);
      fieldSchemaPb.setFields(fieldsPb);
    }
    return fieldSchemaPb;
  }

  static Field fromPb(TableFieldSchema fieldSchemaPb) {
    Builder fieldBuilder = new Builder();
    fieldBuilder.setName(fieldSchemaPb.getName());
    if (fieldSchemaPb.getMode() != null) {
      fieldBuilder.setMode(Mode.valueOf(fieldSchemaPb.getMode()));
    }
    if (fieldSchemaPb.getDescription() != null) {
      fieldBuilder.setDescription(fieldSchemaPb.getDescription());
    }
    FieldList subFields =
        fieldSchemaPb.getFields() != null
            ? FieldList.of(Lists.transform(fieldSchemaPb.getFields(), FROM_PB_FUNCTION))
            : null;
    fieldBuilder.setType(LegacySQLTypeName.valueOf(fieldSchemaPb.getType()), subFields);
    return fieldBuilder.build();
  }
}
