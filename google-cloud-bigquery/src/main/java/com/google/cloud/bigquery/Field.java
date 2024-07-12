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
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

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
  private final PolicyTags policyTags;
  private final Long maxLength;
  private final Long scale;
  private final Long precision;
  private final String defaultValueExpression;
  private final String collation;
  private final FieldElementType rangeElementType;

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
    private PolicyTags policyTags;
    private Long maxLength;
    private Long scale;
    private Long precision;
    private String defaultValueExpression;
    private String collation;
    private FieldElementType rangeElementType;

    private Builder() {}

    private Builder(Field field) {
      this.name = field.name;
      this.type = field.type;
      this.subFields = field.subFields;
      this.mode = field.mode;
      this.description = field.description;
      this.policyTags = field.policyTags;
      this.maxLength = field.maxLength;
      this.scale = field.scale;
      this.precision = field.precision;
      this.defaultValueExpression = field.defaultValueExpression;
      this.collation = field.collation;
      this.rangeElementType = field.rangeElementType;
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
     * @param subFields nested schema fields in case if {@code type} is {@link
     *     StandardSQLTypeName#STRUCT}, empty otherwise
     * @throws IllegalArgumentException if {@code type == StandardSQLTypeName.STRUCT &&
     *     subFields.length == 0} or if {@code type != StandardSQLTypeName.STRUCT &&
     *     subFields.length != 0}
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types">Data
     *     Types</a>
     */
    public Builder setType(StandardSQLTypeName type, Field... subFields) {
      return setType(
          LegacySQLTypeName.legacySQLTypeName(type),
          subFields.length > 0 ? FieldList.of(subFields) : null);
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
      // LegacySQLTypeName is not an enum, cannot use reference equal.
      if (LegacySQLTypeName.RECORD.equals(type)) {
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

    /**
     * Sets the type of the field.
     *
     * @param type BigQuery data type
     * @param subFields nested schema fields in case if {@code type} is {@link
     *     StandardSQLTypeName#STRUCT}, empty otherwise
     * @throws IllegalArgumentException if {@code type == StandardSQLTypeName.STRUCT &&
     *     subFields.length == 0} or if {@code type != StandardSQLTypeName.STRUCT &&
     *     subFields.length != 0}
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types">Data
     *     Types</a>
     */
    public Builder setType(StandardSQLTypeName type, FieldList subFields) {
      return setType(LegacySQLTypeName.legacySQLTypeName(type), subFields);
    }

    /** Sets the mode of the field. When not specified {@link Mode#NULLABLE} is used. */
    public Builder setMode(Mode mode) {
      this.mode = mode != null ? mode.name() : null;
      return this;
    }

    /** Sets the field description. The maximum length is 16K characters. */
    public Builder setDescription(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    /** Sets the policy tags for the field. */
    public Builder setPolicyTags(PolicyTags policyTags) {
      this.policyTags = policyTags;
      return this;
    }

    /**
     * Sets the maximum length of the field for STRING or BYTES type.
     *
     * <p>It is invalid to set value for types other than STRING or BYTES.
     *
     * <p>For STRING type, this represents the maximum UTF-8 length of strings allowed in the field.
     * For BYTES type, this represents the maximum number of bytes in the field.
     */
    public Builder setMaxLength(Long maxLength) {
      this.maxLength = maxLength;
      return this;
    }

    /**
     * Scale can be used to constrain the maximum number of digits in the fractional part of a
     * NUMERIC or BIGNUMERIC type. If the Scale value is set, the Precision value must be set as
     * well. It is invalid to set values for Scale for types other than NUMERIC or BIGNUMERIC. See
     * the Precision field for additional guidance about valid values.
     */
    public Builder setScale(Long scale) {
      this.scale = scale;
      return this;
    }

    /**
     * Precision can be used to constrain the maximum number of total digits allowed for NUMERIC or
     * BIGNUMERIC types. It is invalid to set values for Precision for types other than // NUMERIC
     * or BIGNUMERIC. For NUMERIC type, acceptable values for Precision must be: 1 ≤ (Precision -
     * Scale) ≤ 29. Values for Scale must be: 0 ≤ Scale ≤ 9. For BIGNUMERIC type, acceptable values
     * for Precision must be: 1 ≤ (Precision - Scale) ≤ 38. Values for Scale must be: 0 ≤ Scale ≤
     * 38.
     */
    public Builder setPrecision(Long precision) {
      this.precision = precision;
      return this;
    }

    /**
     * DefaultValueExpression is used to specify the default value of a field using a SQL
     * expression. It can only be set for top level fields (columns).
     *
     * <p>You can use struct or array expression to specify default value for the entire struct or
     * array. The valid SQL expressions are:
     *
     * <pre>
     *   Literals for all data types, including STRUCT and ARRAY.
     *   The following functions:
     *      - CURRENT_TIMESTAMP
     *      - CURRENT_TIME
     *      - CURRENT_DATE
     *      - CURRENT_DATETIME
     *      - GENERATE_UUID
     *      - RAND
     *      - SESSION_USER
     *      - ST_GEOGPOINT
     *
     *   Struct or array composed with the above allowed functions, for example:
     *      "[CURRENT_DATE(), DATE '2020-01-01']"
     * </pre>
     */
    public Builder setDefaultValueExpression(String defaultValueExpression) {
      this.defaultValueExpression = defaultValueExpression;
      return this;
    }

    /**
     * Optional. Field collation can be set only when the type of field is STRING. The following
     * values are supported:
     *
     * <p>* 'und:ci': undetermined locale, case insensitive. * '': empty string. Default to
     * case-sensitive behavior. (-- A wrapper is used here because it is possible to set the value
     * to the empty string. --)
     */
    public Builder setCollation(String collation) {
      this.collation = collation;
      return this;
    }

    /** Optional. Field range element type can be set only when the type of field is RANGE. */
    public Builder setRangeElementType(FieldElementType rangeElementType) {
      this.rangeElementType = rangeElementType;
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
    this.policyTags = builder.policyTags;
    this.maxLength = builder.maxLength;
    this.scale = builder.scale;
    this.precision = builder.precision;
    this.defaultValueExpression = builder.defaultValueExpression;
    this.collation = builder.collation;
    this.rangeElementType = builder.rangeElementType;
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

  /** Returns the policy tags for the field. */
  public PolicyTags getPolicyTags() {
    return policyTags;
  }

  /** Returns the maximum length of the field for STRING or BYTES type. */
  public Long getMaxLength() {
    return maxLength;
  }

  /**
   * Returns the maximum number of digits set in the fractional part of a NUMERIC or BIGNUMERIC
   * type.
   */
  public Long getScale() {
    return scale;
  }

  /** Returns the maximum number of total digits allowed for NUMERIC or BIGNUMERIC types. */
  public Long getPrecision() {
    return precision;
  }

  /** Return the default value of the field. */
  public String getDefaultValueExpression() {
    return defaultValueExpression;
  }

  public String getCollation() {
    return collation;
  }

  /** Return the range element type the field. */
  public FieldElementType getRangeElementType() {
    return rangeElementType;
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
        .add("policyTags", policyTags)
        .add("maxLength", maxLength)
        .add("scale", scale)
        .add("precision", precision)
        .add("defaultValueExpression", defaultValueExpression)
        .add("collation", collation)
        .add("rangeElementType", rangeElementType)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, mode, description, policyTags, rangeElementType);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Field && Objects.equals(toPb(), ((Field) obj).toPb());
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, LegacySQLTypeName type, Field... subFields) {
    checkArgument(!isNullOrEmpty(name), "Provided name is null or empty");
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, StandardSQLTypeName type, Field... subFields) {
    checkArgument(!isNullOrEmpty(name), "Provided name is null or empty");
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, LegacySQLTypeName type, FieldList subFields) {
    checkArgument(!isNullOrEmpty(name), "Provided name is null or empty");
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a Field object with given name and type. */
  public static Field of(String name, StandardSQLTypeName type, FieldList subFields) {
    checkArgument(!isNullOrEmpty(name), "Provided name is null or empty");
    return newBuilder(name, type, subFields).build();
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, LegacySQLTypeName type, Field... subFields) {
    return new Builder().setName(name).setType(type, subFields);
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, StandardSQLTypeName type, Field... subFields) {
    return new Builder().setName(name).setType(type, subFields);
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, LegacySQLTypeName type, FieldList subFields) {
    return new Builder().setName(name).setType(type, subFields);
  }

  /** Returns a builder for a Field object with given name and type. */
  public static Builder newBuilder(String name, StandardSQLTypeName type, FieldList subFields) {
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
    if (policyTags != null) {
      fieldSchemaPb.setPolicyTags(policyTags.toPb());
    }
    if (maxLength != null) {
      fieldSchemaPb.setMaxLength(maxLength);
    }
    if (scale != null) {
      fieldSchemaPb.setScale(scale);
    }
    if (precision != null) {
      fieldSchemaPb.setPrecision(precision);
    }
    if (defaultValueExpression != null) {
      fieldSchemaPb.setDefaultValueExpression(defaultValueExpression);
    }
    if (getSubFields() != null) {
      List<TableFieldSchema> fieldsPb = Lists.transform(getSubFields(), TO_PB_FUNCTION);
      fieldSchemaPb.setFields(fieldsPb);
    }
    if (collation != null) {
      fieldSchemaPb.setCollation(collation);
    }
    if (rangeElementType != null) {
      fieldSchemaPb.setRangeElementType(rangeElementType.toPb());
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
    if (fieldSchemaPb.getPolicyTags() != null) {
      fieldBuilder.setPolicyTags(PolicyTags.fromPb(fieldSchemaPb.getPolicyTags()));
    }
    if (fieldSchemaPb.getMaxLength() != null) {
      fieldBuilder.setMaxLength(fieldSchemaPb.getMaxLength());
    }
    if (fieldSchemaPb.getScale() != null) {
      fieldBuilder.setScale(fieldSchemaPb.getScale());
    }
    if (fieldSchemaPb.getPrecision() != null) {
      fieldBuilder.setPrecision(fieldSchemaPb.getPrecision());
    }
    if (fieldSchemaPb.getDefaultValueExpression() != null) {
      fieldBuilder.setDefaultValueExpression(fieldSchemaPb.getDefaultValueExpression());
    }
    FieldList subFields =
        fieldSchemaPb.getFields() != null
            ? FieldList.of(Lists.transform(fieldSchemaPb.getFields(), FROM_PB_FUNCTION))
            : null;
    fieldBuilder.setType(LegacySQLTypeName.valueOf(fieldSchemaPb.getType()), subFields);
    if (fieldSchemaPb.getCollation() != null) {
      fieldBuilder.setCollation(fieldSchemaPb.getCollation());
    }
    if (fieldSchemaPb.getRangeElementType() != null) {
      fieldBuilder.setRangeElementType(
          FieldElementType.fromPb(fieldSchemaPb.getRangeElementType()));
    }
    return fieldBuilder.build();
  }
}
