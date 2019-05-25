/*
 * Copyright 2017 Google LLC
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

import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.GREATER_THAN;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.LESS_THAN;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.auto.value.AutoValue;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Query.QueryOptions.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.StructuredQuery.CollectionSelector;
import com.google.firestore.v1.StructuredQuery.CompositeFilter;
import com.google.firestore.v1.StructuredQuery.FieldReference;
import com.google.firestore.v1.StructuredQuery.Filter;
import com.google.firestore.v1.StructuredQuery.Order;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Int32Value;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A Query which you can read or listen to. You can also construct refined Query objects by adding
 * filters and ordering.
 */
public class Query {

  final FirestoreImpl firestore;
  final QueryOptions options;

  /** The direction of a sort. */
  public enum Direction {
    ASCENDING(StructuredQuery.Direction.ASCENDING),
    DESCENDING(StructuredQuery.Direction.DESCENDING);

    private final StructuredQuery.Direction direction;

    Direction(StructuredQuery.Direction direction) {
      this.direction = direction;
    }

    StructuredQuery.Direction getDirection() {
      return direction;
    }
  }

  abstract static class FieldFilter {
    final FieldPath fieldPath;
    final Object value;

    FieldFilter(FieldPath fieldPath, Object value) {
      this.value = value;
      this.fieldPath = fieldPath;
    }

    Value encodeValue() {
      Object sanitizedObject = CustomClassMapper.serialize(value);
      Value encodedValue =
          UserDataConverter.encodeValue(fieldPath, sanitizedObject, UserDataConverter.ARGUMENT);

      if (encodedValue == null) {
        throw FirestoreException.invalidState("Cannot use Firestore Sentinels in FieldFilter");
      }
      return encodedValue;
    }

    abstract boolean isEqualsFilter();

    abstract Filter toProto();
  }

  private static class UnaryFilter extends FieldFilter {
    UnaryFilter(FieldPath fieldPath, Object value) {
      super(fieldPath, value);
      Preconditions.checkArgument(
          isUnaryComparison(value), "Cannot use '%s' in unary comparison", value);
    }

    @Override
    boolean isEqualsFilter() {
      return true;
    }

    Filter toProto() {
      Filter.Builder result = Filter.newBuilder();

      result
          .getUnaryFilterBuilder()
          .setField(FieldReference.newBuilder().setFieldPath(fieldPath.getEncodedPath()))
          .setOp(
              value == null
                  ? StructuredQuery.UnaryFilter.Operator.IS_NULL
                  : StructuredQuery.UnaryFilter.Operator.IS_NAN);

      return result.build();
    }
  }

  private static class ComparisonFilter extends FieldFilter {
    final StructuredQuery.FieldFilter.Operator operator;

    ComparisonFilter(
        FieldPath fieldPath, StructuredQuery.FieldFilter.Operator operator, Object value) {
      super(fieldPath, value);
      Preconditions.checkArgument(
          !isUnaryComparison(value), "Cannot use '%s' in field comparison", value);
      this.operator = operator;
    }

    @Override
    boolean isEqualsFilter() {
      return operator.equals(EQUAL);
    }

    Filter toProto() {
      Filter.Builder result = Filter.newBuilder();

      Value encodedValue = encodeValue();

      result
          .getFieldFilterBuilder()
          .setField(FieldReference.newBuilder().setFieldPath(fieldPath.getEncodedPath()))
          .setValue(encodedValue)
          .setOp(operator);
      return result.build();
    }
  }

  static final class FieldOrder {
    final FieldPath fieldPath;
    final Direction direction;

    FieldOrder(FieldPath fieldPath, Direction direction) {
      this.fieldPath = fieldPath;
      this.direction = direction;
    }

    Order toProto() {
      Order.Builder result = Order.newBuilder();
      result.setField(FieldReference.newBuilder().setFieldPath(fieldPath.getEncodedPath()));
      result.setDirection(direction.getDirection());
      return result.build();
    }
  }

  /** Options that define a Firestore Query. */
  @AutoValue
  abstract static class QueryOptions {

    abstract ResourcePath getParentPath();

    abstract String getCollectionId();

    abstract boolean getAllDescendants();

    abstract @Nullable Integer getLimit();

    abstract @Nullable Integer getOffset();

    abstract @Nullable Cursor getStartCursor();

    abstract @Nullable Cursor getEndCursor();

    abstract ImmutableList<FieldFilter> getFieldFilters();

    abstract ImmutableList<FieldOrder> getFieldOrders();

    abstract ImmutableList<FieldReference> getFieldProjections();

    static Builder builder() {
      return new AutoValue_Query_QueryOptions.Builder()
          .setAllDescendants(false)
          .setFieldOrders(ImmutableList.<FieldOrder>of())
          .setFieldFilters(ImmutableList.<FieldFilter>of())
          .setFieldProjections(ImmutableList.<FieldReference>of());
    }

    abstract Builder toBuilder();

    @AutoValue.Builder
    abstract static class Builder {
      abstract Builder setParentPath(ResourcePath value);

      abstract Builder setCollectionId(String value);

      abstract Builder setAllDescendants(boolean value);

      abstract Builder setLimit(Integer value);

      abstract Builder setOffset(Integer value);

      abstract Builder setStartCursor(@Nullable Cursor value);

      abstract Builder setEndCursor(@Nullable Cursor value);

      abstract Builder setFieldFilters(ImmutableList<FieldFilter> value);

      abstract Builder setFieldOrders(ImmutableList<FieldOrder> value);

      abstract Builder setFieldProjections(ImmutableList<FieldReference> value);

      abstract QueryOptions build();
    }
  }

  /** Creates a query for documents in a single collection */
  Query(FirestoreImpl firestore, ResourcePath path) {
    this(
        firestore,
        QueryOptions.builder()
            .setParentPath(path.getParent())
            .setCollectionId(path.getId())
            .build());
  }

  /**
   * Creates a Collection Group query that matches all documents directly nested under a
   * specifically named collection
   */
  Query(FirestoreImpl firestore, String collectionId) {
    this(
        firestore,
        QueryOptions.builder()
            .setParentPath(firestore.getResourcePath())
            .setCollectionId(collectionId)
            .setAllDescendants(true)
            .build());
  }

  private Query(FirestoreImpl firestore, QueryOptions queryOptions) {
    this.firestore = firestore;
    this.options = queryOptions;
  }

  /**
   * Gets the Firestore instance associated with this query.
   *
   * @return The Firestore instance associated with this query.
   */
  @Nonnull
  public Firestore getFirestore() {
    return firestore;
  }

  /** Checks whether the provided object is NULL or NaN. */
  private static boolean isUnaryComparison(@Nullable Object value) {
    return value == null || value.equals(Double.NaN) || value.equals(Float.NaN);
  }

  /** Computes the backend ordering semantics for DocumentSnapshot cursors. */
  private ImmutableList<FieldOrder> createImplicitOrderBy() {
    List<FieldOrder> implicitOrders = new ArrayList<>(options.getFieldOrders());
    boolean hasDocumentId = false;

    if (implicitOrders.isEmpty()) {
      // If no explicit ordering is specified, use the first inequality to define an implicit order.
      for (FieldFilter fieldFilter : options.getFieldFilters()) {
        if (!fieldFilter.isEqualsFilter()) {
          implicitOrders.add(new FieldOrder(fieldFilter.fieldPath, Direction.ASCENDING));
          break;
        }
      }
    } else {
      for (FieldOrder fieldOrder : options.getFieldOrders()) {
        if (fieldOrder.fieldPath.equals(FieldPath.DOCUMENT_ID)) {
          hasDocumentId = true;
        }
      }
    }

    if (!hasDocumentId) {
      // Add implicit sorting by name, using the last specified direction.
      Direction lastDirection =
          implicitOrders.isEmpty()
              ? Direction.ASCENDING
              : implicitOrders.get(implicitOrders.size() - 1).direction;

      implicitOrders.add(new FieldOrder(FieldPath.documentId(), lastDirection));
    }

    return ImmutableList.<FieldOrder>builder().addAll(implicitOrders).build();
  }

  private Cursor createCursor(
      ImmutableList<FieldOrder> order, DocumentSnapshot documentSnapshot, boolean before) {
    List<Object> fieldValues = new ArrayList<>();

    for (FieldOrder fieldOrder : order) {
      if (fieldOrder.fieldPath.equals(FieldPath.DOCUMENT_ID)) {
        fieldValues.add(documentSnapshot.getReference());
      } else {
        Preconditions.checkArgument(
            documentSnapshot.contains(fieldOrder.fieldPath),
            "Field '%s' is missing in the provided DocumentSnapshot. Please provide a document that contains values for all specified orderBy() and where() constraints.");
        fieldValues.add(documentSnapshot.get(fieldOrder.fieldPath));
      }
    }

    return createCursor(order, fieldValues.toArray(), before);
  }

  private Cursor createCursor(List<FieldOrder> order, Object[] fieldValues, boolean before) {
    Cursor.Builder result = Cursor.newBuilder();

    Preconditions.checkState(
        fieldValues.length != 0, "At least one cursor value must be specified.");

    Preconditions.checkState(
        fieldValues.length <= order.size(),
        "Too many cursor values specified. The specified values must match the "
            + "orderBy() constraints of the query.");

    Iterator<FieldOrder> fieldOrderIterator = order.iterator();

    for (Object fieldValue : fieldValues) {
      Object sanitizedValue;

      FieldPath fieldPath = fieldOrderIterator.next().fieldPath;

      if (fieldPath.equals(FieldPath.DOCUMENT_ID)) {
        sanitizedValue = convertReference(fieldValue);
      } else {
        sanitizedValue = CustomClassMapper.serialize(fieldValue);
      }

      Value encodedValue =
          UserDataConverter.encodeValue(fieldPath, sanitizedValue, UserDataConverter.ARGUMENT);

      if (encodedValue == null) {
        throw FirestoreException.invalidState(
            "Cannot use FieldValue.delete() or FieldValue.serverTimestamp() in a query boundary");
      }
      result.addValues(encodedValue);
    }

    result.setBefore(before);

    return result.build();
  }

  /**
   * Validates that a value used with FieldValue.documentId() is either a string or a
   * DocumentReference that is part of the query`s result set. Throws a validation error or returns
   * a DocumentReference that can directly be used in the Query.
   */
  private Object convertReference(Object fieldValue) {
    ResourcePath basePath =
        options.getAllDescendants()
            ? options.getParentPath()
            : options.getParentPath().append(options.getCollectionId());

    DocumentReference reference;
    if (fieldValue instanceof String) {
      reference = new DocumentReference(firestore, basePath.append((String) fieldValue));
    } else if (fieldValue instanceof DocumentReference) {
      reference = (DocumentReference) fieldValue;
    } else {
      throw new IllegalArgumentException(
          "The corresponding value for FieldPath.documentId() must be a String or a "
              + "DocumentReference.");
    }

    if (!basePath.isPrefixOf(reference.getResourcePath())) {
      throw new IllegalArgumentException(
          String.format(
              "'%s' is not part of the query result set and cannot be used as a query boundary.",
              reference.getPath()));
    }

    if (!options.getAllDescendants() && !reference.getParent().getResourcePath().equals(basePath)) {
      throw new IllegalArgumentException(
          String.format(
              "Only a direct child can be used as a query boundary. Found: '%s'",
              reference.getPath()));
    }

    return reference;
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be equal to the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereEqualTo(@Nonnull String field, @Nullable Object value) {
    return whereEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be equal to the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereEqualTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereEqualTo() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");

    if (isUnaryComparison(value)) {
      Builder newOptions = options.toBuilder();
      UnaryFilter newFieldFilter = new UnaryFilter(fieldPath, value);
      newOptions.setFieldFilters(append(options.getFieldFilters(), newFieldFilter));
      return new Query(firestore, newOptions.build());
    } else {
      return whereHelper(fieldPath, EQUAL, value);
    }
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be less than the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereLessThan(@Nonnull String field, @Nonnull Object value) {
    return whereLessThan(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be less than the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereLessThan(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereLessThan() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    return whereHelper(fieldPath, LESS_THAN, value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be less or equal to the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereLessThanOrEqualTo(@Nonnull String field, @Nonnull Object value) {
    return whereLessThanOrEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be less or equal to the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereLessThanOrEqualTo(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereLessThanOrEqualTo() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    return whereHelper(fieldPath, LESS_THAN_OR_EQUAL, value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be greater than the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereGreaterThan(@Nonnull String field, @Nonnull Object value) {
    return whereGreaterThan(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be greater than the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereGreaterThan(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereGreaterThan() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    return whereHelper(fieldPath, GREATER_THAN, value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be greater than or equal to the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereGreaterThanOrEqualTo(@Nonnull String field, @Nonnull Object value) {
    return whereGreaterThanOrEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value should be greater than or equal to the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereGreaterThanOrEqualTo(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereGreaterThanOrEqualTo() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    return whereHelper(fieldPath, GREATER_THAN_OR_EQUAL, value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field, the value must be an array, and that the array must contain the provided
   * value.
   *
   * <p>A Query can have only one whereArrayContains() filter.
   *
   * @param field The name of the field containing an array to search
   * @param value The value that must be contained in the array
   * @return The created Query.
   */
  @Nonnull
  public Query whereArrayContains(@Nonnull String field, @Nonnull Object value) {
    return whereArrayContains(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field, the value must be an array, and that the array must contain the provided
   * value.
   *
   * <p>A Query can have only one whereArrayContains() filter.
   *
   * @param fieldPath The path of the field containing an array to search
   * @param value The value that must be contained in the array
   * @return The created Query.
   */
  @Nonnull
  public Query whereArrayContains(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call whereArrayContains() after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    return whereHelper(fieldPath, ARRAY_CONTAINS, value);
  }

  private Query whereHelper(
      FieldPath fieldPath, StructuredQuery.FieldFilter.Operator operator, Object value) {
    if (fieldPath.equals(FieldPath.DOCUMENT_ID)) {
      value = this.convertReference(value);
    }

    Builder newOptions = options.toBuilder();
    ComparisonFilter newFieldFilter = new ComparisonFilter(fieldPath, operator, value);
    newOptions.setFieldFilters(append(options.getFieldFilters(), newFieldFilter));
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that's additionally sorted by the specified field.
   *
   * @param field The field to sort by.
   * @return The created Query.
   */
  @Nonnull
  public Query orderBy(@Nonnull String field) {
    return orderBy(FieldPath.fromDotSeparatedString(field), Direction.ASCENDING);
  }

  /**
   * Creates and returns a new Query that's additionally sorted by the specified field.
   *
   * @param fieldPath The field to sort by.
   * @return The created Query.
   */
  @Nonnull
  public Query orderBy(@Nonnull FieldPath fieldPath) {
    return orderBy(fieldPath, Direction.ASCENDING);
  }

  /**
   * Creates and returns a new Query that's additionally sorted by the specified field, optionally
   * in descending order instead of ascending.
   *
   * @param field The field to sort by.
   * @param direction The direction to sort.
   * @return The created Query.
   */
  @Nonnull
  public Query orderBy(@Nonnull String field, @Nonnull Direction direction) {
    return orderBy(FieldPath.fromDotSeparatedString(field), direction);
  }

  /**
   * Creates and returns a new Query that's additionally sorted by the specified field, optionally
   * in descending order instead of ascending.
   *
   * @param fieldPath The field to sort by.
   * @param direction The direction to sort.
   * @return The created Query.
   */
  @Nonnull
  public Query orderBy(@Nonnull FieldPath fieldPath, @Nonnull Direction direction) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot specify an orderBy() constraint after calling startAt(), "
            + "startAfter(), endBefore() or endAt().");

    Builder newOptions = options.toBuilder();
    FieldOrder newFieldOrder = new FieldOrder(fieldPath, direction);
    newOptions.setFieldOrders(append(options.getFieldOrders(), newFieldOrder));

    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that's additionally limited to only return up to the specified
   * number of documents.
   *
   * @param limit The maximum number of items to return.
   * @return The created Query.
   */
  @Nonnull
  public Query limit(int limit) {
    return new Query(firestore, options.toBuilder().setLimit(limit).build());
  }

  /**
   * Creates and returns a new Query that skips the first n results.
   *
   * @param offset The number of items to skip.
   * @return The created Query.
   */
  @Nonnull
  public Query offset(int offset) {
    return new Query(firestore, options.toBuilder().setOffset(offset).build());
  }

  /**
   * Creates and returns a new Query that starts at the provided document (inclusive). The starting
   * position is relative to the order of the query. The document must contain all of the fields
   * provided in the orderBy of this query.
   *
   * @param snapshot The snapshot of the document to start at.
   * @return The created Query.
   */
  @Nonnull
  public Query startAt(@Nonnull DocumentSnapshot snapshot) {
    ImmutableList<FieldOrder> fieldOrders = createImplicitOrderBy();
    Cursor cursor = createCursor(fieldOrders, snapshot, true);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setStartCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that starts at the provided fields relative to the order of the
   * query. The order of the field values must match the order of the order by clauses of the query.
   *
   * @param fieldValues The field values to start this query at, in order of the query's order by.
   * @return The created Query.
   */
  @Nonnull
  public Query startAt(Object... fieldValues) {
    Cursor cursor = createCursor(options.getFieldOrders(), fieldValues, true);

    Builder newOptions = options.toBuilder();
    newOptions.setStartCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query instance that applies a field mask to the result and returns
   * the specified subset of fields. You can specify a list of field paths to return, or use an
   * empty list to only return the references of matching documents.
   *
   * @param fields The fields to include.
   * @return The created Query.
   */
  @Nonnull
  public Query select(String... fields) {
    FieldPath[] fieldPaths = new FieldPath[fields.length];

    for (int i = 0; i < fields.length; ++i) {
      fieldPaths[i] = FieldPath.fromDotSeparatedString(fields[i]);
    }

    return select(fieldPaths);
  }

  /**
   * Creates and returns a new Query instance that applies a field mask to the result and returns
   * the specified subset of fields. You can specify a list of field paths to return, or use an
   * empty list to only return the references of matching documents.
   *
   * @param fieldPaths The field paths to include.
   * @return The created Query.
   */
  @Nonnull
  public Query select(FieldPath... fieldPaths) {
    ImmutableList.Builder<FieldReference> fieldProjections = ImmutableList.builder();

    if (fieldPaths.length == 0) {
      fieldPaths = new FieldPath[] {FieldPath.DOCUMENT_ID};
    }

    for (FieldPath path : fieldPaths) {
      FieldReference fieldReference =
          FieldReference.newBuilder().setFieldPath(path.getEncodedPath()).build();
      fieldProjections.add(fieldReference);
    }

    Builder newOptions = options.toBuilder().setFieldProjections(fieldProjections.build());
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that starts after the provided document (exclusive). The
   * starting position is relative to the order of the query. The document must contain all of the
   * fields provided in the orderBy of this query.
   *
   * @param snapshot The snapshot of the document to start after.
   * @return The created Query.
   */
  @Nonnull
  public Query startAfter(@Nonnull DocumentSnapshot snapshot) {
    ImmutableList<FieldOrder> fieldOrders = createImplicitOrderBy();
    Cursor cursor = createCursor(fieldOrders, snapshot, false);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setStartCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that starts after the provided fields relative to the order of
   * the query. The order of the field values must match the order of the order by clauses of the
   * query.
   *
   * @param fieldValues The field values to start this query after, in order of the query's order
   *     by.
   * @return The created Query.
   */
  public Query startAfter(Object... fieldValues) {
    Cursor cursor = createCursor(options.getFieldOrders(), fieldValues, false);

    Builder newOptions = options.toBuilder();
    newOptions.setStartCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that ends before the provided document (exclusive). The end
   * position is relative to the order of the query. The document must contain all of the fields
   * provided in the orderBy of this query.
   *
   * @param snapshot The snapshot of the document to end before.
   * @return The created Query.
   */
  @Nonnull
  public Query endBefore(@Nonnull DocumentSnapshot snapshot) {
    ImmutableList<FieldOrder> fieldOrders = createImplicitOrderBy();
    Cursor cursor = createCursor(fieldOrders, snapshot, true);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setEndCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that ends before the provided fields relative to the order of
   * the query. The order of the field values must match the order of the order by clauses of the
   * query.
   *
   * @param fieldValues The field values to end this query before, in order of the query's order by.
   * @return The created Query.
   */
  @Nonnull
  public Query endBefore(Object... fieldValues) {
    Cursor cursor = createCursor(options.getFieldOrders(), fieldValues, true);

    Builder newOptions = options.toBuilder();
    newOptions.setEndCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that ends at the provided fields relative to the order of the
   * query. The order of the field values must match the order of the order by clauses of the query.
   *
   * @param fieldValues The field values to end this query at, in order of the query's order by.
   * @return The created Query.
   */
  @Nonnull
  public Query endAt(Object... fieldValues) {
    Cursor cursor = createCursor(options.getFieldOrders(), fieldValues, false);

    Builder newOptions = options.toBuilder();
    newOptions.setEndCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /**
   * Creates and returns a new Query that ends at the provided document (inclusive). The end
   * position is relative to the order of the query. The document must contain all of the fields
   * provided in the orderBy of this query.
   *
   * @param snapshot The snapshot of the document to end at.
   * @return The created Query.
   */
  @Nonnull
  public Query endAt(@Nonnull DocumentSnapshot snapshot) {
    ImmutableList<FieldOrder> fieldOrders = createImplicitOrderBy();
    Cursor cursor = createCursor(fieldOrders, snapshot, false);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setEndCursor(cursor);
    return new Query(firestore, newOptions.build());
  }

  /** Build the final Firestore query. */
  StructuredQuery.Builder buildQuery() {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    CollectionSelector.Builder collectionSelector = CollectionSelector.newBuilder();
    collectionSelector.setCollectionId(options.getCollectionId());
    collectionSelector.setAllDescendants(options.getAllDescendants());
    structuredQuery.addFrom(collectionSelector);

    if (options.getFieldFilters().size() == 1) {
      Filter filter = options.getFieldFilters().get(0).toProto();
      if (filter.hasFieldFilter()) {
        structuredQuery.getWhereBuilder().setFieldFilter(filter.getFieldFilter());
      } else {
        Preconditions.checkState(
            filter.hasUnaryFilter(), "Expected a UnaryFilter or a FieldFilter.");
        structuredQuery.getWhereBuilder().setUnaryFilter(filter.getUnaryFilter());
      }
    } else if (options.getFieldFilters().size() > 1) {
      Filter.Builder filter = Filter.newBuilder();
      StructuredQuery.CompositeFilter.Builder compositeFilter =
          StructuredQuery.CompositeFilter.newBuilder();
      compositeFilter.setOp(CompositeFilter.Operator.AND);
      for (FieldFilter fieldFilter : options.getFieldFilters()) {
        compositeFilter.addFilters(fieldFilter.toProto());
      }
      filter.setCompositeFilter(compositeFilter.build());
      structuredQuery.setWhere(filter.build());
    }

    if (!options.getFieldOrders().isEmpty()) {
      for (FieldOrder order : options.getFieldOrders()) {
        structuredQuery.addOrderBy(order.toProto());
      }
    }

    if (!options.getFieldProjections().isEmpty()) {
      structuredQuery.getSelectBuilder().addAllFields(options.getFieldProjections());
    }

    if (options.getLimit() != null) {
      structuredQuery.setLimit(Int32Value.newBuilder().setValue(options.getLimit()));
    }

    if (options.getOffset() != null) {
      structuredQuery.setOffset(options.getOffset());
    }

    if (options.getStartCursor() != null) {
      structuredQuery.setStartAt(options.getStartCursor());
    }

    if (options.getEndCursor() != null) {
      structuredQuery.setEndAt(options.getEndCursor());
    }

    return structuredQuery;
  }

  /**
   * Executes the query and streams the results as a StreamObserver of DocumentSnapshots.
   *
   * @param responseObserver The observer to be notified when results arrive.
   */
  public void stream(@Nonnull final ApiStreamObserver<DocumentSnapshot> responseObserver) {
    stream(
        new QuerySnapshotObserver() {
          @Override
          public void onNext(QueryDocumentSnapshot documentSnapshot) {
            responseObserver.onNext(documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            responseObserver.onError(throwable);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        },
        null);
  }

  /** Stream observer that captures DocumentSnapshots as well as the Query read time. */
  private abstract static class QuerySnapshotObserver
      implements ApiStreamObserver<QueryDocumentSnapshot> {

    private Timestamp readTime;

    void onCompleted(Timestamp readTime) {
      this.readTime = readTime;
      this.onCompleted();
    }

    Timestamp getReadTime() {
      return readTime;
    }
  }

  private void stream(
      final QuerySnapshotObserver documentObserver, @Nullable ByteString transactionId) {
    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.setStructuredQuery(buildQuery()).setParent(options.getParentPath().toString());

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    Tracing.getTracer()
        .getCurrentSpan()
        .addAnnotation(
            "Firestore.Query: Start",
            ImmutableMap.of(
                "transactional", AttributeValue.booleanAttributeValue(transactionId != null)));

    ApiStreamObserver<RunQueryResponse> observer =
        new ApiStreamObserver<RunQueryResponse>() {
          Timestamp readTime;
          boolean firstResponse;
          int numDocuments;

          @Override
          public void onNext(RunQueryResponse response) {
            if (!firstResponse) {
              firstResponse = true;
              Tracing.getTracer().getCurrentSpan().addAnnotation("Firestore.Query: First response");
            }
            if (response.hasDocument()) {
              numDocuments++;
              if (numDocuments % 100 == 0) {
                Tracing.getTracer()
                    .getCurrentSpan()
                    .addAnnotation("Firestore.Query: Received 100 documents");
              }
              Document document = response.getDocument();
              QueryDocumentSnapshot documentSnapshot =
                  QueryDocumentSnapshot.fromDocument(
                      firestore, Timestamp.fromProto(response.getReadTime()), document);
              documentObserver.onNext(documentSnapshot);
            }

            if (readTime == null) {
              readTime = Timestamp.fromProto(response.getReadTime());
            }
          }

          @Override
          public void onError(Throwable throwable) {
            Tracing.getTracer().getCurrentSpan().addAnnotation("Firestore.Query: Error");
            documentObserver.onError(throwable);
          }

          @Override
          public void onCompleted() {
            Tracing.getTracer()
                .getCurrentSpan()
                .addAnnotation(
                    "Firestore.Query: Completed",
                    ImmutableMap.of(
                        "numDocuments", AttributeValue.longAttributeValue(numDocuments)));
            documentObserver.onCompleted(readTime);
          }
        };

    firestore.streamRequest(request.build(), observer, firestore.getClient().runQueryCallable());
  }

  /**
   * Executes the query and returns the results as QuerySnapshot.
   *
   * @return An ApiFuture that will be resolved with the results of the Query.
   */
  @Nonnull
  public ApiFuture<QuerySnapshot> get() {
    return get(null);
  }

  /**
   * Starts listening to this query.
   *
   * @param listener The event listener that will be called with the snapshots.
   * @return A registration object that can be used to remove the listener.
   */
  @Nonnull
  public ListenerRegistration addSnapshotListener(@Nonnull EventListener<QuerySnapshot> listener) {
    return addSnapshotListener(firestore.getClient().getExecutor(), listener);
  }

  /**
   * Starts listening to this query.
   *
   * @param executor The executor to use to call the listener.
   * @param listener The event listener that will be called with the snapshots.
   * @return A registration object that can be used to remove the listener.
   */
  @Nonnull
  public ListenerRegistration addSnapshotListener(
      @Nonnull Executor executor, @Nonnull EventListener<QuerySnapshot> listener) {
    return Watch.forQuery(this).runWatch(executor, listener);
  }

  ApiFuture<QuerySnapshot> get(@Nullable ByteString transactionId) {
    final SettableApiFuture<QuerySnapshot> result = SettableApiFuture.create();

    stream(
        new QuerySnapshotObserver() {
          List<QueryDocumentSnapshot> documentSnapshots = new ArrayList<>();

          @Override
          public void onNext(QueryDocumentSnapshot documentSnapshot) {
            documentSnapshots.add(documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            result.setException(throwable);
          }

          @Override
          public void onCompleted() {
            QuerySnapshot querySnapshot =
                QuerySnapshot.withDocuments(Query.this, this.getReadTime(), documentSnapshots);
            result.set(querySnapshot);
          }
        },
        transactionId);

    return result;
  }

  Comparator<QueryDocumentSnapshot> comparator() {
    return new Comparator<QueryDocumentSnapshot>() {
      @Override
      public int compare(QueryDocumentSnapshot doc1, QueryDocumentSnapshot doc2) {
        // Add implicit sorting by name, using the last specified direction.
        ImmutableList<FieldOrder> fieldOrders = options.getFieldOrders();
        Direction lastDirection =
            fieldOrders.isEmpty()
                ? Direction.ASCENDING
                : fieldOrders.get(fieldOrders.size() - 1).direction;

        List<FieldOrder> orderBys = new ArrayList<>(fieldOrders);
        orderBys.add(new FieldOrder(FieldPath.DOCUMENT_ID, lastDirection));

        for (FieldOrder orderBy : orderBys) {
          int comp;

          if (orderBy.fieldPath.equals(FieldPath.documentId())) {
            comp =
                doc1.getReference()
                    .getResourcePath()
                    .compareTo(doc2.getReference().getResourcePath());
          } else {
            Preconditions.checkState(
                doc1.contains(orderBy.fieldPath) && doc2.contains(orderBy.fieldPath),
                "Can only compare fields that exist in the DocumentSnapshot."
                    + " Please include the fields you are ordering on in your select() call.");
            Value v1 = doc1.extractField(orderBy.fieldPath);
            Value v2 = doc2.extractField(orderBy.fieldPath);

            comp = com.google.cloud.firestore.Order.INSTANCE.compare(v1, v2);
          }

          if (comp != 0) {
            int direction = orderBy.direction.equals(Direction.ASCENDING) ? 1 : -1;
            return direction * comp;
          }
        }

        return 0;
      }
    };
  }

  /**
   * Helper method to append an element to an existing ImmutableList. Returns the newly created
   * list.
   */
  private <T> ImmutableList<T> append(ImmutableList<T> existingList, T newElement) {
    ImmutableList.Builder<T> builder = ImmutableList.builder();
    builder.addAll(existingList);
    builder.add(newElement);
    return builder.build();
  }

  /**
   * Returns true if this Query is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this Query is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof Query)) {
      return false;
    }
    Query query = (Query) obj;
    return Objects.equals(firestore, query.firestore) && Objects.equals(options, query.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firestore, options);
  }
}
