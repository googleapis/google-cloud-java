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
import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.util.Data;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google BigQuery Table Field Value class. Objects of this class represent values of a BigQuery
 * Table Field. A list of values forms a table row. Tables rows can be gotten as the result of a
 * query or when listing table data.
 */
public class FieldValue implements Serializable {

  static final Function<Object, FieldValue> FROM_PB_FUNCTION = new Function<Object, FieldValue>() {
    @Override
    public FieldValue apply(Object pb) {
      return FieldValue.fromPb(pb);
    }
  };
  private static final int MICROSECONDS = 1000000;
  private static final long serialVersionUID = 469098630191710061L;

  private final Attribute attribute;
  private final Object value;

  /**
   * The field value's attribute, giving information on the field's content type.
   */
  public enum Attribute {
    /**
     * A primitive field value. A {@code FieldValue} is primitive when the corresponding field has
     * type {@link Field.Type#bytes()}, {@link Field.Type#bool()}, {@link Field.Type#string()},
     * {@link Field.Type#floatingPoint()}, {@link Field.Type#integer()},
     * {@link Field.Type#timestamp()} or the value is set to {@code null}.
     */
    PRIMITIVE,

    /**
     * A {@code FieldValue} for a field with {@link Field.Mode#REPEATED} mode.
     */
    REPEATED,

    /**
     * A {@code FieldValue} for a field of type {@link Field.Type#record(Field...)}.
     */
    RECORD
  }

  FieldValue(Attribute attribute, Object value) {
    this.attribute = attribute;
    this.value = value;
  }


  /**
   * Returns the attribute of this Field Value.
   *
   * @return {@link Attribute#PRIMITIVE} if the field is a primitive type
   *     ({@link Field.Type#bytes()}, {@link Field.Type#bool()}, {@link Field.Type#string()},
   *     {@link Field.Type#floatingPoint()}, {@link Field.Type#integer()},
   *     {@link Field.Type#timestamp()}) or is {@code null}. Returns {@link Attribute#REPEATED} if
   *     the corresponding field has ({@link Field.Mode#REPEATED}) mode. Returns
   *     {@link Attribute#RECORD} if the corresponding field is a
   *     {@link Field.Type#record(Field...)} type.
   */
  public Attribute getAttribute() {
    return attribute;
  }

  /**
   * Returns {@code true} if this field's value is {@code null}, {@code false} otherwise.
   */
  public boolean isNull() {
    return value == null;
  }


  /**
   * Returns this field's value as an {@link Object}. If {@link #isNull()} is {@code true} this
   * method returns {@code null}.
   */
  public Object getValue() {
    return value;
  }


  /**
   * Returns this field's value as a {@link String}. This method should only be used if the
   * corresponding field has primitive type ({@link Field.Type#bytes()}, {@link Field.Type#bool()},
   * {@link Field.Type#string()}, {@link Field.Type#floatingPoint()}, {@link Field.Type#integer()},
   * {@link Field.Type#timestamp()}).
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public String getStringValue() {
    checkNotNull(value);
    return (String) value;
  }


  /**
   * Returns this field's value as a byte array. This method should only be used if the
   * corresponding field has primitive type ({@link Field.Type#bytes()}.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   * @throws IllegalStateException if the field value is not encoded in base64
   */
  public byte[] getBytesValue() {
    try {
      return BaseEncoding.base64().decode(getStringValue());
    } catch (IllegalArgumentException ex) {
      throw new IllegalStateException(ex);
    }
  }


  /**
   * Returns this field's value as a {@code long}. This method should only be used if the
   * corresponding field has {@link Field.Type#integer()} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Integer}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public long getLongValue() {
    return Long.parseLong(getStringValue());
  }


  /**
   * Returns this field's value as a {@link Double}. This method should only be used if the
   * corresponding field has {@link Field.Type#floatingPoint()} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Double}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public double getDoubleValue() {
    return Double.parseDouble(getStringValue());
  }


  /**
   * Returns this field's value as a {@link Boolean}. This method should only be used if the
   * corresponding field has {@link Field.Type#bool()} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws IllegalStateException if the field's value could not be converted to {@link Boolean}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public boolean getBooleanValue() {
    String stringValue = getStringValue();
    checkState(stringValue.equalsIgnoreCase("true") || stringValue.equalsIgnoreCase("false"),
        "Field value is not of boolean type");
    return Boolean.parseBoolean(stringValue);
  }


  /**
   * Returns this field's value as a {@code long}, representing a timestamp in microseconds since
   * epoch (UNIX time). This method should only be used if the corresponding field has
   * {@link Field.Type#timestamp()} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Long}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public long getTimestampValue() {
    // timestamps are encoded in the format 1408452095.22 where the integer part is seconds since
    // epoch (e.g. 1408452095.22 == 2014-08-19 07:41:35.220 -05:00)
    return new Double(Double.valueOf(getStringValue()) * MICROSECONDS).longValue();
  }


  /**
   * Returns this field's value as a list of {@link FieldValue}. This method should only be used if
   * the corresponding field has {@link Field.Mode#REPEATED} mode (i.e. {@link #getAttribute()} is
   * {@link Attribute#REPEATED}).
   *
   * @throws ClassCastException if the field has not {@link Field.Mode#REPEATED} mode
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public List<FieldValue> getRepeatedValue() {
    checkNotNull(value);
    return (List<FieldValue>) value;
  }


  /**
   * Returns this field's value as a list of {@link FieldValue}. This method should only be used if
   * the corresponding field has {@link Field.Type#record(Field...)} type (i.e.
   * {@link #getAttribute()} is {@link Attribute#RECORD}).
   *
   * @throws ClassCastException if the field is not a {@link Field.Type#record(Field...)} type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public List<FieldValue> getRecordValue() {
    checkNotNull(value);
    return (List<FieldValue>) value;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attribute", attribute)
        .add("value", value)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(attribute, value);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(FieldValue.class)) {
      return false;
    }
    FieldValue other = (FieldValue) obj;
    return attribute == other.attribute && Objects.equals(value, other.value);
  }

  @SuppressWarnings("unchecked")
  static FieldValue fromPb(Object cellPb) {
    if (Data.isNull(cellPb)) {
      return new FieldValue(Attribute.PRIMITIVE, null);
    }
    if (cellPb instanceof String) {
      return new FieldValue(Attribute.PRIMITIVE, cellPb);
    }
    if (cellPb instanceof List) {
      List<Object> cellsListPb = (List<Object>) cellPb;
      List<FieldValue> repeatedCells = Lists.newArrayListWithCapacity(cellsListPb.size());
      for (Object repeatedCellPb : cellsListPb) {
        repeatedCells.add(FieldValue.fromPb(repeatedCellPb));
      }
      return new FieldValue(Attribute.REPEATED, repeatedCells);
    }
    if (cellPb instanceof Map) {
      Map<String, Object> cellMapPb = (Map<String, Object>) cellPb;
      if (cellMapPb.containsKey("f")) {
        List<Object> cellsListPb = (List<Object>) cellMapPb.get("f");
        List<FieldValue> recordCells = Lists.newArrayListWithCapacity(cellsListPb.size());
        for (Object repeatedCellPb : cellsListPb) {
          recordCells.add(FieldValue.fromPb(repeatedCellPb));
        }
        return new FieldValue(Attribute.RECORD, recordCells);
      }
      // This should never be the case when we are processing a first level table field (i.e. a
      // row's field, not a record sub-field)
      if (cellMapPb.containsKey("v")) {
        return FieldValue.fromPb(cellMapPb.get("v"));
      }
    }
    throw new AssertionError("Unexpected table cell format");
  }
}
