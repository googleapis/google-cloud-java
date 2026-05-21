/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.firestore;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Represents an aggregation that can be performed by Firestore. */
public abstract class AggregateField {
  /**
   * Create a {@link CountAggregateField} object that can be used to compute the count of documents
   * in the result set of a query.
   *
   * <p>The result of a count operation will always be a 64-bit integer value.
   *
   * @return The `CountAggregateField` object that can be used to compute the count of documents in
   *     the result set of a query.
   */
  @Nonnull
  public static CountAggregateField count() {
    return new CountAggregateField();
  }

  /**
   * Create a {@link SumAggregateField} object that can be used to compute the sum of a specified
   * field over a range of documents in the result set of a query.
   *
   * <p>The result of a sum operation will always be a 64-bit integer value, a double, or NaN.
   *
   * <ul>
   *   <li>Summing over zero documents or fields will result in 0L.
   *   <li>Summing over NaN will result in a double value representing NaN.
   *   <li>A sum that overflows the maximum representable 64-bit integer value will result in a
   *       double return value. This may result in lost precision of the result.
   *   <li>A sum that overflows the maximum representable double value will result in a double
   *       return value representing infinity.
   * </ul>
   *
   * @param field Specifies the field to sum across the result set.
   * @return The `SumAggregateField` object that can be used to compute the sum of a specified field
   *     over a range of documents in the result set of a query.
   */
  @Nonnull
  public static SumAggregateField sum(@Nonnull String field) {
    return new SumAggregateField(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Create a {@link SumAggregateField} object that can be used to compute the sum of a specified
   * field over a range of documents in the result set of a query.
   *
   * <p>The result of a sum operation will always be a 64-bit integer value, a double, or NaN.
   *
   * <ul>
   *   <li>Summing over zero documents or fields will result in 0L.
   *   <li>Summing over NaN will result in a double value representing NaN.
   *   <li>A sum that overflows the maximum representable 64-bit integer value will result in a
   *       double return value. This may result in lost precision of the result.
   *   <li>A sum that overflows the maximum representable double value will result in a double
   *       return value representing infinity.
   * </ul>
   *
   * @param fieldPath Specifies the field to sum across the result set.
   * @return The `SumAggregateField` object that can be used to compute the sum of a specified field
   *     over a range of documents in the result set of a query.
   */
  @Nonnull
  public static SumAggregateField sum(@Nonnull FieldPath fieldPath) {
    return new SumAggregateField(fieldPath);
  }

  /**
   * Create an {@link AverageAggregateField} object that can be used to compute the average of a
   * specified field over a range of documents in the result set of a query.
   *
   * <p>The result of an average operation will always be a double or NaN.
   *
   * <ul>
   *   <li>Averaging over zero documents or fields will result in a double value representing NaN.
   *   <li>Averaging over NaN will result in a double value representing NaN.
   * </ul>
   *
   * @param field Specifies the field to average across the result set.
   * @return The `AverageAggregateField` object that can be used to compute the average of a
   *     specified field over a range of documents in the result set of a query.
   */
  @Nonnull
  public static AverageAggregateField average(@Nonnull String field) {
    return new AverageAggregateField(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Create an {@link AverageAggregateField} object that can be used to compute the average of a
   * specified field over a range of documents in the result set of a query.
   *
   * <p>The result of an average operation will always be a double or NaN.
   *
   * <ul>
   *   <li>Averaging over zero documents or fields will result in a double value representing NaN.
   *   <li>Averaging over NaN will result in a double value representing NaN.
   * </ul>
   *
   * @param fieldPath Specifies the field to average across the result set.
   * @return The `AverageAggregateField` object that can be used to compute the average of a
   *     specified field over a range of documents in the result set of a query.
   */
  @Nonnull
  public static AverageAggregateField average(@Nonnull FieldPath fieldPath) {
    return new AverageAggregateField(fieldPath);
  }

  /** The field over which the aggregation is performed. */
  @Nullable FieldPath fieldPath;

  /** Returns the alias used internally for this aggregate field. */
  @Nonnull
  String getAlias() {
    // Use $operator_$field format if it's an aggregation of a specific field. For example: sum_foo.
    // Use $operator format if there's no field. For example: count.
    return getOperator() + (fieldPath == null ? "" : "_" + fieldPath.getEncodedPath());
  }

  /**
   * Returns the field on which the aggregation takes place. Returns an empty string if there's no
   * field (this applies to count).
   */
  @Nonnull
  String getFieldPath() {
    return fieldPath == null ? "" : fieldPath.getEncodedPath();
  }

  /** Returns a string representation of this aggregation's operator. For example: "sum" */
  abstract @Nonnull String getOperator();

  /**
   * Returns true if the given object is equal to this object. Two `AggregateField` objects are
   * considered equal if they have the same operator and operate on the same field.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof AggregateField)) {
      return false;
    }
    AggregateField otherAggregateField = (AggregateField) other;
    return getOperator().equals(otherAggregateField.getOperator())
        && getFieldPath().equals(otherAggregateField.getFieldPath());
  }

  /** Calculates and returns the hash code for this object. */
  @Override
  public int hashCode() {
    return Objects.hash(getOperator(), getFieldPath());
  }

  /** Represents a "sum" aggregation that can be performed by Firestore. */
  public static class SumAggregateField extends AggregateField {
    private SumAggregateField(@Nonnull FieldPath field) {
      fieldPath = field;
    }

    @Override
    @Nonnull
    public String getOperator() {
      return "sum";
    }
  }

  /** Represents an "average" aggregation that can be performed by Firestore. */
  public static class AverageAggregateField extends AggregateField {
    private AverageAggregateField(@Nonnull FieldPath field) {
      fieldPath = field;
    }

    @Override
    @Nonnull
    public String getOperator() {
      return "average";
    }
  }

  /** Represents a "count" aggregation that can be performed by Firestore. */
  public static class CountAggregateField extends AggregateField {
    private CountAggregateField() {}

    @Override
    @Nonnull
    public String getOperator() {
      return "count";
    }
  }
}
