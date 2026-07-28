/*
 * Copyright 2022 Google LLC
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

import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.StructuredQuery.FieldFilter.Operator;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Filter {
  static class UnaryFilter extends Filter {
    private final FieldPath field;
    private final Operator operator;
    private final Object value;

    public UnaryFilter(FieldPath field, Operator operator, @Nullable Object value) {
      this.field = field;
      this.operator = operator;
      this.value = value;
    }

    public FieldPath getField() {
      return field;
    }

    public Operator getOperator() {
      return operator;
    }

    @Nullable
    public Object getValue() {
      return value;
    }
  }

  static class CompositeFilter extends Filter {
    private final List<Filter> filters;
    private final StructuredQuery.CompositeFilter.Operator operator;

    public CompositeFilter(
        @Nonnull List<Filter> filters, StructuredQuery.CompositeFilter.Operator operator) {
      this.filters = filters;
      this.operator = operator;
    }

    public List<Filter> getFilters() {
      return filters;
    }

    public StructuredQuery.CompositeFilter.Operator getOperator() {
      return operator;
    }
  }

  /**
   * Creates a new filter for checking that the given field is equal to the given value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter equalTo(@Nonnull String field, @Nullable Object value) {
    return equalTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is equal to the given value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter equalTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.EQUAL, value);
  }

  /**
   * Creates a new filter for checking that the given field is not equal to the given value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter notEqualTo(@Nonnull String field, @Nullable Object value) {
    return notEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is not equal to the given value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter notEqualTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.NOT_EQUAL, value);
  }

  /**
   * Creates a new filter for checking that the given field is greater than the given value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter greaterThan(@Nonnull String field, @Nullable Object value) {
    return greaterThan(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is greater than the given value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter greaterThan(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.GREATER_THAN, value);
  }

  /**
   * Creates a new filter for checking that the given field is greater than or equal to the given
   * value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter greaterThanOrEqualTo(@Nonnull String field, @Nullable Object value) {
    return greaterThanOrEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is greater than or equal to the given
   * value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter greaterThanOrEqualTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.GREATER_THAN_OR_EQUAL, value);
  }

  /**
   * Creates a new filter for checking that the given field is less than the given value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter lessThan(@Nonnull String field, @Nullable Object value) {
    return lessThan(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is less than the given value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter lessThan(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.LESS_THAN, value);
  }

  /**
   * Creates a new filter for checking that the given field is less than or equal to the given
   * value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter lessThanOrEqualTo(@Nonnull String field, @Nullable Object value) {
    return lessThanOrEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field is less than or equal to the given
   * value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter lessThanOrEqualTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.LESS_THAN_OR_EQUAL, value);
  }

  /**
   * Creates a new filter for checking that the given array field contains the given value.
   *
   * @param field The field used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter arrayContains(@Nonnull String field, @Nullable Object value) {
    return arrayContains(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given array field contains the given value.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The value used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter arrayContains(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.ARRAY_CONTAINS, value);
  }

  /**
   * Creates a new filter for checking that the given array field contains any of the given values.
   *
   * @param field The field used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter arrayContainsAny(@Nonnull String field, @Nullable Object value) {
    return arrayContainsAny(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given array field contains any of the given values.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter arrayContainsAny(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.ARRAY_CONTAINS_ANY, value);
  }

  /**
   * Creates a new filter for checking that the given field equals any of the given values.
   *
   * @param field The field used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter inArray(@Nonnull String field, @Nullable Object value) {
    return inArray(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field equals any of the given values.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter inArray(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.IN, value);
  }

  /**
   * Creates a new filter for checking that the given field does not equal any of the given values.
   *
   * @param field The field path used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter notInArray(@Nonnull String field, @Nullable Object value) {
    return notInArray(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates a new filter for checking that the given field does not equal any of the given values.
   *
   * @param fieldPath The field path used for the filter.
   * @param value The list of values used for the filter.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter notInArray(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return new UnaryFilter(fieldPath, Operator.NOT_IN, value);
  }

  /**
   * Creates a new filter that is a disjunction of the given filters. A disjunction filter includes
   * a document if it satisfies <em>any</em> of the given filters.
   *
   * @param filters The list of filters to perform a disjunction for.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter or(Filter... filters) {
    return new CompositeFilter(Arrays.asList(filters), StructuredQuery.CompositeFilter.Operator.OR);
  }

  /**
   * Creates a new filter that is a conjunction of the given filters. A conjunction filter includes
   * a document if it satisfies <em>all</em> of the given filters.
   *
   * @param filters The list of filters to perform a conjunction for.
   * @return The newly created filter.
   */
  @Nonnull
  public static Filter and(Filter... filters) {
    return new CompositeFilter(
        Arrays.asList(filters), StructuredQuery.CompositeFilter.Operator.AND);
  }
}
