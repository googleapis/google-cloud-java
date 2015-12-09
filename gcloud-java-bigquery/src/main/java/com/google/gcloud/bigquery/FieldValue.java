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

import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.util.Data;
import com.google.api.client.util.Lists;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google BigQuery Table Field Value class. Objects of this class represent values of a BigQuery
 * Table Field. A list of values forms a {@link TableRow}. Tables rows can be gotten as the result
 * of a query or when listing table data.
 */
public class FieldValue implements Serializable {

  private static final int MICROSECONDS = 1000000;
  private static final long serialVersionUID = 469098630191710061L;

  private final Kind kind;
  private final Object value;

  /**
   * The field value's kind, giving information on the field's content type.
   */
  public enum Kind {
    /**
     * A primitive field value. A {@code FieldValue} has type {@link #PRIMITIVE} when the
     * corresponding field has type {@link Field.Type#bool()}, {@link Field.Type#string()}
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

  FieldValue(Kind kind, Object value) {
    this.kind = kind;
    this.value = value;
  }

  /**
   * Returns the kind of this Field Value.
   *
   * @return {@link Kind#PRIMITIVE} if the value is of primitive type ({@link Field.Type#bool()},
   *     {@link Field.Type#string()}, {@link Field.Type#floatingPoint()},
   *     {@link Field.Type#integer()}, {@link Field.Type#timestamp()}) or is {@code null}. Returns
   *     {@link Kind#REPEATED} if the corresponding field has ({@link Field.Mode#REPEATED}) mode.
   *     Returns {@link Kind#RECORD} if the corresponding field has
   *     {@link Field.Type#record(Field...)} type.
   */
  public Kind kind() {
    return kind;
  }

  /**
   * Return this field's value as an {@link Object}.
   */
  public Object value() {
    return value;
  }

  /**
   * Return this field's value as a {@link String}. This method should only be used if the
   * corresponding field has primitive type ({@link Field.Type#bool()}, {@link Field.Type#string()},
   * {@link Field.Type#floatingPoint()}, {@link Field.Type#integer()},
   * {@link Field.Type#timestamp()}).
   *
   * @throws ClassCastException if the field has not primitive type
   */
  @SuppressWarnings("unchecked")
  public String stringValue() {
    return (String) value;
  }

  /**
   * Returns this field's value as a {@link Long}. This method should only be used if the
   * corresponding field has {@link Field.Type#integer()} type.
   *
   * @throws NumberFormatException if the field's value could not be converted to {@link Integer}
   */
  @SuppressWarnings("unchecked")
  public long longValue() {
    return Long.valueOf(stringValue());
  }

  /**
   * Returns this field's value as a {@link Double}. This method should only be used if the
   * corresponding field has {@link Field.Type#floatingPoint()} type.
   *
   * @throws NumberFormatException if the field's value could not be converted to {@link Double}
   */
  @SuppressWarnings("unchecked")
  public double doubleValue() {
    return Double.valueOf(stringValue());
  }

  /**
   * Returns this field's value as a {@link Boolean}. This method should only be used if the
   * corresponding field has {@link Field.Type#bool()} type.
   *
   * @throws IllegalStateException if the field's value could not be converted to {@link Boolean}
   */
  @SuppressWarnings("unchecked")
  public boolean booleanValue() {
    String stringValue = stringValue();
    checkState(stringValue.equalsIgnoreCase("true") || stringValue.equalsIgnoreCase("false"),
        "Field value is not of boolean type");
    return Boolean.parseBoolean(stringValue);
  }

  /**
   * Returns this field's value as a {@link Long}, representing a timestamp in microseconds. This
   * method should only be used if the corresponding field has {@link Field.Type#timestamp()} type.
   *
   * @throws NumberFormatException if the field's value could not be converted to {@link Long}
   */
  @SuppressWarnings("unchecked")
  public long timestampValue() {
    return new Double(((Double.valueOf(stringValue())) * MICROSECONDS)).longValue();
  }

  /**
   * Returns this field's value as a list of {@link FieldValue}. This method should only be used if
   * the corresponding field has {@link Field.Mode#REPEATED} mode (i.e. {@link #kind()} is
   * {@link Kind#REPEATED}).
   *
   * @throws ClassCastException if the field has not {@link Field.Mode#REPEATED} mode
   */
  @SuppressWarnings("unchecked")
  public List<FieldValue> repeatedValue() {
    return (List<FieldValue>) value;
  }

  /**
   * Returns this field's value as a list of {@link FieldValue}. This method should only be used if
   * the corresponding field has {@link Field.Type#record(Field...)} type (i.e. {@link #kind()} is
   * {@link Kind#RECORD}).
   *
   * @throws ClassCastException if the field has not {@link Field.Type#record(Field...)} type
   */
  @SuppressWarnings("unchecked")
  public List<FieldValue> recordValue() {
    return (List<FieldValue>) value;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("kind", kind)
        .add("value", value)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof FieldValue)) {
      return false;
    }
    FieldValue other = (FieldValue) obj;
    return kind == other.kind && Objects.equals(value, other.value);
  }

  @SuppressWarnings("unchecked")
  static FieldValue fromPb(Object cellPb) {
    if (Data.isNull(cellPb)) {
      return new FieldValue(Kind.PRIMITIVE, null);
    }
    if (cellPb instanceof String) {
      return new FieldValue(Kind.PRIMITIVE, cellPb);
    }
    if (cellPb instanceof List) {
      List<Object> cellsListPb = (List<Object>) cellPb;
      List<FieldValue> repeatedCells = Lists.newArrayListWithCapacity(cellsListPb.size());
      for (Object repeatedCellPb : cellsListPb) {
        repeatedCells.add(FieldValue.fromPb(repeatedCellPb));
      }
      return new FieldValue(Kind.REPEATED, repeatedCells);
    }
    if (cellPb instanceof Map) {
      Map<String, Object> cellMapPb = (Map<String, Object>) cellPb;
      if (cellMapPb.containsKey("f")) {
        List<Object> cellsListPb = (List<Object>) cellMapPb.get("f");
        List<FieldValue> recordCells = Lists.newArrayListWithCapacity(cellsListPb.size());
        for (Object repeatedCellPb : cellsListPb) {
          recordCells.add(FieldValue.fromPb(repeatedCellPb));
        }
        return new FieldValue(Kind.RECORD, recordCells);
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
