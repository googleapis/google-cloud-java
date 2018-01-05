/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator.EQUAL;
import static com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator.GREATER_THAN;
import static com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
import static com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator.LESS_THAN;
import static com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.DocumentChange.Type;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.Cursor;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.firestore.v1beta1.StructuredQuery;
import com.google.firestore.v1beta1.StructuredQuery.CompositeFilter;
import com.google.firestore.v1beta1.StructuredQuery.FieldReference;
import com.google.firestore.v1beta1.StructuredQuery.Filter;
import com.google.firestore.v1beta1.StructuredQuery.Order;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Int32Value;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * A Query which you can read or listen to. You can also construct refined Query objects by adding
 * filters and ordering.
 */
public class Query {

  final ResourcePath path;
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

  private static class FieldOrder {
    final FieldPath fieldPath;
    final Direction direction;

    FieldOrder(FieldPath fieldPath, Direction direction) {
      this.fieldPath = fieldPath;
      this.direction = direction;
    }

    private Order toProto() {
      Order.Builder result = Order.newBuilder();
      result.setField(FieldReference.newBuilder().setFieldPath(fieldPath.getEncodedPath()));
      result.setDirection(direction.getDirection());
      return result.build();
    }
  }

  /** Options that define a Firestore Query. */
  private static class QueryOptions {

    private int limit;
    private int offset;
    private Cursor startCursor;
    private Cursor endCursor;
    private List<Filter> fieldFilters;
    private List<FieldOrder> fieldOrders;
    private List<FieldReference> fieldProjections;

    QueryOptions() {
      limit = -1;
      offset = -1;
      fieldFilters = new ArrayList<>();
      fieldOrders = new ArrayList<>();
      fieldProjections = new ArrayList<>();
    }

    QueryOptions(QueryOptions options) {
      limit = options.limit;
      offset = options.offset;
      startCursor = options.startCursor;
      endCursor = options.endCursor;
      fieldFilters = new ArrayList<>(options.fieldFilters);
      fieldOrders = new ArrayList<>(options.fieldOrders);
      fieldProjections = options.fieldProjections;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      QueryOptions that = (QueryOptions) o;

      if (limit != that.limit) {
        return false;
      }
      if (offset != that.offset) {
        return false;
      }
      if (startCursor != null ? !startCursor.equals(that.startCursor) : that.startCursor != null) {
        return false;
      }
      if (endCursor != null ? !endCursor.equals(that.endCursor) : that.endCursor != null) {
        return false;
      }
      if (!fieldFilters.equals(that.fieldFilters)) {
        return false;
      }
      if (!fieldOrders.equals(that.fieldOrders)) {
        return false;
      }
      return fieldProjections.equals(that.fieldProjections);
    }

    @Override
    public int hashCode() {
      int result = limit;
      result = 31 * result + offset;
      result = 31 * result + (startCursor != null ? startCursor.hashCode() : 0);
      result = 31 * result + (endCursor != null ? endCursor.hashCode() : 0);
      result = 31 * result + fieldFilters.hashCode();
      result = 31 * result + fieldOrders.hashCode();
      result = 31 * result + fieldProjections.hashCode();
      return result;
    }
  }

  Query(FirestoreImpl firestore, ResourcePath path) {
    this(firestore, path, new QueryOptions());
  }

  private Query(FirestoreImpl firestore, ResourcePath path, QueryOptions queryOptions) {
    Preconditions.checkArgument(
        path.isCollection(), "Invalid path specified. Path should point to a collection");

    this.firestore = firestore;
    this.path = path;
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

  private Filter createFieldFilter(
      FieldPath fieldPath, StructuredQuery.FieldFilter.Operator operator, Object value) {
    Preconditions.checkState(
        !isUnaryComparison(value), "Firestore only support equals comparisons with Null and NaN");

    Filter.Builder result = Filter.newBuilder();

    Object sanitizedObject = CustomClassMapper.serialize(value);
    Value encodedValue =
        UserDataConverter.encodeValue(fieldPath, sanitizedObject, UserDataConverter.NO_DELETES);

    if (encodedValue == null) {
      throw FirestoreException.invalidState("Cannot use Firestore Sentinels in FieldFilter");
    }

    result
        .getFieldFilterBuilder()
        .setField(FieldReference.newBuilder().setFieldPath(fieldPath.getEncodedPath()))
        .setValue(encodedValue)
        .setOp(operator);

    return result.build();
  }

  private Filter createUnaryFilter(FieldPath fieldPath, Object value) {
    Preconditions.checkState(isUnaryComparison(value));

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

  private Cursor createCursor(Object[] fieldValues, boolean before) {
    Cursor.Builder result = Cursor.newBuilder();

    Preconditions.checkState(
        fieldValues.length <= options.fieldOrders.size(),
        "Too many cursor values specified. The specified values must match the "
            + "orderBy() constraints of the query.");

    Iterator<FieldOrder> fieldOrderIterator = options.fieldOrders.iterator();

    for (Object fieldValue : fieldValues) {
      Object sanitizedValue;

      FieldPath fieldPath = fieldOrderIterator.next().fieldPath;

      if (fieldPath.equals(FieldPath.DOCUMENT_ID)) {
        DocumentReference cursorDocument;
        if (fieldValue instanceof String) {
          cursorDocument = new DocumentReference(firestore, path.append((String) fieldValue));
        } else if (fieldValue instanceof DocumentReference) {
          cursorDocument = (DocumentReference) fieldValue;
        } else {
          throw new IllegalArgumentException(
              "The corresponding value for FieldPath.documentId() must be a String or a "
                  + "DocumentReference.");
        }

        if (!this.path.isPrefixOf(cursorDocument.getResourcePath())) {
          throw new IllegalArgumentException(
              String.format(
                  "'%s' is not part of the query result set and cannot be used as a query boundary.",
                  cursorDocument.getPath()));
        }
        if (!cursorDocument.getParent().getResourcePath().equals(this.path)) {
          throw new IllegalArgumentException(
              String.format(
                  "Only a direct child can be used as a query boundary. Found: '%s'",
                  cursorDocument.getPath()));
        }

        sanitizedValue = cursorDocument;
      } else {
        sanitizedValue = CustomClassMapper.serialize(fieldValue);
      }

      Value encodedValue =
          UserDataConverter.encodeValue(fieldPath, sanitizedValue, UserDataConverter.NO_DELETES);
      if (encodedValue == null) {
        throw FirestoreException.invalidState("Cannot use Firestore Sentinels in Cursor");
      }
      result.addValues(encodedValue);
    }

    result.setBefore(before);

    return result.build();
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
    QueryOptions newOptions = new QueryOptions(options);

    if (isUnaryComparison(value)) {
      newOptions.fieldFilters.add(createUnaryFilter(fieldPath, value));
    } else {
      newOptions.fieldFilters.add(createFieldFilter(fieldPath, EQUAL, value));
    }

    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldFilters.add(createFieldFilter(fieldPath, LESS_THAN, value));
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldFilters.add(createFieldFilter(fieldPath, LESS_THAN_OR_EQUAL, value));
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldFilters.add(createFieldFilter(fieldPath, GREATER_THAN, value));
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldFilters.add(createFieldFilter(fieldPath, GREATER_THAN_OR_EQUAL, value));
    return new Query(firestore, path, newOptions);
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
        options.startCursor == null && options.endCursor == null,
        "Cannot specify an orderBy() constraint after calling startAt(), "
            + "startAfter(), endBefore() or endAt().");

    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldOrders.add(new FieldOrder(fieldPath, direction));

    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.limit = limit;
    return new Query(firestore, path, newOptions);
  }

  /**
   * Creates and returns a new Query that skips the first n results.
   *
   * @param offset The number of items to skip.
   * @return The created Query.
   */
  @Nonnull
  public Query offset(int offset) {
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.offset = offset;
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.startCursor = createCursor(fieldValues, true);
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.fieldProjections = new ArrayList<>();

    if (fieldPaths.length == 0) {
      fieldPaths = new FieldPath[] {FieldPath.DOCUMENT_ID};
    }

    for (FieldPath path : fieldPaths) {
      FieldReference fieldReference =
          FieldReference.newBuilder().setFieldPath(path.getEncodedPath()).build();
      newOptions.fieldProjections.add(fieldReference);
    }

    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.startCursor = createCursor(fieldValues, false);
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.endCursor = createCursor(fieldValues, true);
    return new Query(firestore, path, newOptions);
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
    QueryOptions newOptions = new QueryOptions(options);
    newOptions.endCursor = createCursor(fieldValues, false);
    return new Query(firestore, path, newOptions);
  }

  /** Build the final Firestore query. */
  StructuredQuery.Builder buildQuery() {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.addFrom(
        StructuredQuery.CollectionSelector.newBuilder().setCollectionId(path.getId()));

    if (!options.fieldFilters.isEmpty()) {
      Filter.Builder filter = Filter.newBuilder();
      StructuredQuery.CompositeFilter.Builder compositeFilter =
          StructuredQuery.CompositeFilter.newBuilder();
      compositeFilter.setOp(CompositeFilter.Operator.AND);
      compositeFilter.addAllFilters(options.fieldFilters);
      filter.setCompositeFilter(compositeFilter.build());
      structuredQuery.setWhere(filter.build());
    }

    if (!options.fieldOrders.isEmpty()) {
      for (FieldOrder order : options.fieldOrders) {
        structuredQuery.addOrderBy(order.toProto());
      }
    }

    if (!options.fieldProjections.isEmpty()) {
      structuredQuery.getSelectBuilder().addAllFields(options.fieldProjections);
    }

    if (options.limit != -1) {
      structuredQuery.setLimit(Int32Value.newBuilder().setValue(options.limit));
    }

    if (options.offset != -1) {
      structuredQuery.setOffset(options.offset);
    }

    if (options.startCursor != null) {
      structuredQuery.setStartAt(options.startCursor);
    }

    if (options.endCursor != null) {
      structuredQuery.setEndAt(options.endCursor);
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
          public void onNext(DocumentSnapshot documentSnapshot) {
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
      implements ApiStreamObserver<DocumentSnapshot> {

    private Instant readTime;

    void onCompleted(Instant readTime) {
      this.readTime = readTime;
      this.onCompleted();
    }

    Instant getReadTime() {
      return readTime;
    }
  }

  private void stream(
      final QuerySnapshotObserver documentObserver, @Nullable ByteString transactionId) {
    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.setStructuredQuery(buildQuery()).setParent(path.getParent().toString());

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    ApiStreamObserver<RunQueryResponse> observer =
        new ApiStreamObserver<RunQueryResponse>() {
          Instant readTime;

          @Override
          public void onNext(RunQueryResponse response) {
            if (response.hasDocument()) {
              Document document = response.getDocument();
              DocumentSnapshot documentSnapshot =
                  DocumentSnapshot.fromDocument(firestore, response.getReadTime(), document);
              documentObserver.onNext(documentSnapshot);
            }

            if (readTime == null) {
              readTime =
                  Instant.ofEpochSecond(
                      response.getReadTime().getSeconds(), response.getReadTime().getNanos());
            }
          }

          @Override
          public void onError(Throwable throwable) {
            documentObserver.onError(throwable);
          }

          @Override
          public void onCompleted() {
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
          List<DocumentSnapshot> documentSnapshots = new ArrayList<>();
          List<DocumentChange> documentChanges = new ArrayList<>();

          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            documentSnapshots.add(documentSnapshot);
            documentChanges.add(
                new DocumentChange(documentSnapshot, Type.ADDED, -1, documentSnapshots.size() - 1));
          }

          @Override
          public void onError(Throwable throwable) {
            result.setException(throwable);
          }

          @Override
          public void onCompleted() {
            QuerySnapshot querySnapshot =
                new QuerySnapshot(
                    Query.this, this.getReadTime(), documentSnapshots, documentChanges);
            result.set(querySnapshot);
          }
        },
        transactionId);

    return result;
  }

  Comparator<DocumentSnapshot> comparator() {
    return new Comparator<DocumentSnapshot>() {
      @Override
      public int compare(DocumentSnapshot doc1, DocumentSnapshot doc2) {
        // Add implicit sorting by name, using the last specified direction.
        Direction lastDirection =
            options.fieldOrders.isEmpty()
                ? Direction.ASCENDING
                : options.fieldOrders.get(options.fieldOrders.size() - 1).direction;

        List<FieldOrder> orderBys = new ArrayList<>();
        orderBys.addAll(options.fieldOrders);
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

  ResourcePath getResourcePath() {
    return path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Query query = (Query) o;
    return Objects.equals(path, query.path)
        && Objects.equals(firestore, query.firestore)
        && Objects.equals(options, query.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, firestore, options);
  }
}
