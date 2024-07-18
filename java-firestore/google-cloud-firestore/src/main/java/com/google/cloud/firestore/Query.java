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

import static com.google.cloud.firestore.telemetry.TraceUtil.*;
import static com.google.common.collect.Lists.reverse;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.GREATER_THAN;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.IN;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.LESS_THAN;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.NOT_EQUAL;
import static com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.NOT_IN;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.auto.value.AutoValue;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Query.QueryOptions.Builder;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.bundle.BundledQuery;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.StructuredQuery.CollectionSelector;
import com.google.firestore.v1.StructuredQuery.CompositeFilter;
import com.google.firestore.v1.StructuredQuery.FieldFilter.Operator;
import com.google.firestore.v1.StructuredQuery.FieldReference;
import com.google.firestore.v1.StructuredQuery.Filter;
import com.google.firestore.v1.StructuredQuery.Order;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Int32Value;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * A Query which you can read or listen to. You can also construct refined Query objects by adding
 * filters and ordering.
 */
@InternalExtensionOnly
public class Query {

  static final Comparator<QueryDocumentSnapshot> DOCUMENT_ID_COMPARATOR = Query::compareDocumentId;
  final FirestoreRpcContext<?> rpcContext;
  final QueryOptions options;

  private static final Logger LOGGER = Logger.getLogger(Query.class.getName());

  /** The direction of a sort. */
  public enum Direction {
    ASCENDING(StructuredQuery.Direction.ASCENDING, DOCUMENT_ID_COMPARATOR),
    DESCENDING(StructuredQuery.Direction.DESCENDING, DOCUMENT_ID_COMPARATOR.reversed());

    private final StructuredQuery.Direction direction;
    private final Comparator<QueryDocumentSnapshot> documentIdComparator;

    Direction(
        StructuredQuery.Direction direction,
        Comparator<QueryDocumentSnapshot> documentIdComparator) {
      this.direction = direction;
      this.documentIdComparator = documentIdComparator;
    }

    StructuredQuery.Direction getDirection() {
      return direction;
    }
  }

  abstract static class FilterInternal {
    /** Returns a list of all field filters that are contained within this filter */
    abstract List<FieldFilterInternal> getFlattenedFilters();

    /** Returns a list of all filters that are contained within this filter */
    abstract List<FilterInternal> getFilters();

    /** Returns the field of the first filter that's an inequality, or null if none. */
    @Nullable
    abstract FieldReference getFirstInequalityField();

    /** Returns the proto representation of this filter */
    abstract Filter toProto();

    static FilterInternal fromProto(StructuredQuery.Filter filter) {
      if (filter.hasUnaryFilter()) {
        return new UnaryFilterInternal(
            filter.getUnaryFilter().getField(), filter.getUnaryFilter().getOp());
      }

      if (filter.hasFieldFilter()) {
        return new ComparisonFilterInternal(
            filter.getFieldFilter().getField(),
            filter.getFieldFilter().getOp(),
            filter.getFieldFilter().getValue());
      }

      // `filter` must be a composite filter.
      Preconditions.checkArgument(filter.hasCompositeFilter(), "Unknown filter type.");
      CompositeFilter compositeFilter = filter.getCompositeFilter();
      // A composite filter with only 1 sub-filter should be reduced to its sub-filter.
      if (compositeFilter.getFiltersCount() == 1) {
        return FilterInternal.fromProto(compositeFilter.getFiltersList().get(0));
      }
      List<FilterInternal> filters = new ArrayList<>();
      for (StructuredQuery.Filter subfilter : compositeFilter.getFiltersList()) {
        filters.add(FilterInternal.fromProto(subfilter));
      }
      return new CompositeFilterInternal(filters, compositeFilter.getOp());
    }
  }

  static class CompositeFilterInternal extends FilterInternal {
    private final List<FilterInternal> filters;
    private final StructuredQuery.CompositeFilter.Operator operator;

    // Memoized list of all field filters that can be found by traversing the tree of filters
    // contained in this composite filter.
    private List<FieldFilterInternal> memoizedFlattenedFilters;

    public CompositeFilterInternal(
        List<FilterInternal> filters, StructuredQuery.CompositeFilter.Operator operator) {
      this.filters = filters;
      this.operator = operator;
    }

    @Override
    public List<FilterInternal> getFilters() {
      return filters;
    }

    @Nullable
    @Override
    public FieldReference getFirstInequalityField() {
      for (FieldFilterInternal fieldFilter : getFlattenedFilters()) {
        if (fieldFilter.isInequalityFilter()) {
          return fieldFilter.fieldReference;
        }
      }
      return null;
    }

    public boolean isConjunction() {
      return operator == CompositeFilter.Operator.AND;
    }

    @Override
    public List<FieldFilterInternal> getFlattenedFilters() {
      if (memoizedFlattenedFilters != null) {
        return memoizedFlattenedFilters;
      }
      memoizedFlattenedFilters = new ArrayList<>();
      for (FilterInternal subfilter : filters) {
        memoizedFlattenedFilters.addAll(subfilter.getFlattenedFilters());
      }
      return memoizedFlattenedFilters;
    }

    @Override
    Filter toProto() {
      // A composite filter that contains one sub-filter is equivalent to the sub-filter.
      if (filters.size() == 1) {
        return filters.get(0).toProto();
      }

      Filter.Builder protoFilter = Filter.newBuilder();
      StructuredQuery.CompositeFilter.Builder compositeFilter =
          StructuredQuery.CompositeFilter.newBuilder();
      compositeFilter.setOp(operator);
      for (FilterInternal filter : filters) {
        compositeFilter.addFilters(filter.toProto());
      }
      protoFilter.setCompositeFilter(compositeFilter.build());
      return protoFilter.build();
    }
  }

  abstract static class FieldFilterInternal extends FilterInternal {
    protected final FieldReference fieldReference;

    FieldFilterInternal(FieldReference fieldReference) {
      this.fieldReference = fieldReference;
    }

    abstract boolean isInequalityFilter();

    public List<FilterInternal> getFilters() {
      return Collections.singletonList(this);
    }

    @Override
    public List<FieldFilterInternal> getFlattenedFilters() {
      return Collections.singletonList(this);
    }
  }

  private static class UnaryFilterInternal extends FieldFilterInternal {

    private final StructuredQuery.UnaryFilter.Operator operator;

    UnaryFilterInternal(
        FieldReference fieldReference, StructuredQuery.UnaryFilter.Operator operator) {
      super(fieldReference);
      this.operator = operator;
    }

    @Override
    boolean isInequalityFilter() {
      return false;
    }

    @Nullable
    @Override
    public FieldReference getFirstInequalityField() {
      return null;
    }

    Filter toProto() {
      Filter.Builder result = Filter.newBuilder();
      result.getUnaryFilterBuilder().setField(fieldReference).setOp(operator);
      return result.build();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof UnaryFilterInternal)) {
        return false;
      }
      UnaryFilterInternal other = (UnaryFilterInternal) o;
      return Objects.equals(fieldReference, other.fieldReference)
          && Objects.equals(operator, other.operator);
    }
  }

  static class ComparisonFilterInternal extends FieldFilterInternal {
    final StructuredQuery.FieldFilter.Operator operator;
    final Value value;

    ComparisonFilterInternal(
        FieldReference fieldReference, StructuredQuery.FieldFilter.Operator operator, Value value) {
      super(fieldReference);
      this.value = value;
      this.operator = operator;
    }

    @Override
    boolean isInequalityFilter() {
      return operator.equals(GREATER_THAN)
          || operator.equals(GREATER_THAN_OR_EQUAL)
          || operator.equals(LESS_THAN)
          || operator.equals(LESS_THAN_OR_EQUAL)
          || operator.equals(NOT_EQUAL)
          || operator.equals(NOT_IN);
    }

    @Nullable
    @Override
    public FieldReference getFirstInequalityField() {
      if (isInequalityFilter()) {
        return fieldReference;
      }
      return null;
    }

    Filter toProto() {
      Filter.Builder result = Filter.newBuilder();
      result.getFieldFilterBuilder().setField(fieldReference).setValue(value).setOp(operator);
      return result.build();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ComparisonFilterInternal)) {
        return false;
      }
      ComparisonFilterInternal other = (ComparisonFilterInternal) o;
      return Objects.equals(fieldReference, other.fieldReference)
          && Objects.equals(operator, other.operator)
          && Objects.equals(value, other.value);
    }
  }

  static final class FieldOrder implements Comparator<QueryDocumentSnapshot> {
    private final FieldReference fieldReference;
    private final Direction direction;

    FieldOrder(FieldReference fieldReference, Direction direction) {
      this.fieldReference = fieldReference;
      this.direction = direction;
    }

    FieldOrder(String field, Direction direction) {
      this.fieldReference = FieldPath.fromServerFormat(field).toProto();
      this.direction = direction;
    }

    Order toProto() {
      Order.Builder result = Order.newBuilder();
      result.setField(fieldReference);
      result.setDirection(direction.getDirection());
      return result.build();
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof FieldOrder)) {
        return false;
      }
      FieldOrder filter = (FieldOrder) o;
      if (direction != filter.direction) {
        return false;
      }
      return Objects.equals(fieldReference, filter.fieldReference);
    }

    public int compare(QueryDocumentSnapshot doc1, QueryDocumentSnapshot doc2) {
      String path = fieldReference.getFieldPath();
      if (FieldPath.isDocumentId(path)) {
        return direction.documentIdComparator.compare(doc1, doc2);
      }
      FieldPath fieldPath = FieldPath.fromDotSeparatedString(path);
      Preconditions.checkState(
          doc1.contains(fieldPath) && doc2.contains(fieldPath),
          "Can only compare fields that exist in the DocumentSnapshot."
              + " Please include the fields you are ordering on in your select() call.");
      Value v1 = doc1.extractField(fieldPath);
      Value v2 = doc2.extractField(fieldPath);

      int cmp = com.google.cloud.firestore.Order.INSTANCE.compare(v1, v2);
      return (direction == Direction.ASCENDING) ? cmp : -cmp;
    }
  }

  /** Denotes whether a provided limit is applied to the beginning or the end of the result set. */
  enum LimitType {
    First,
    Last
  }

  /** Options that define a Firestore Query. */
  @AutoValue
  abstract static class QueryOptions {

    abstract ResourcePath getParentPath();

    abstract String getCollectionId();

    abstract boolean getAllDescendants();

    abstract @Nullable Integer getLimit();

    abstract LimitType getLimitType();

    abstract @Nullable Integer getOffset();

    abstract @Nullable Cursor getStartCursor();

    abstract @Nullable Cursor getEndCursor();

    abstract ImmutableList<FilterInternal> getFilters();

    abstract ImmutableList<FieldOrder> getFieldOrders();

    abstract ImmutableList<FieldReference> getFieldProjections();

    // Whether to select all documents under `parentPath`. By default, only
    // collections that match `collectionId` are selected.
    abstract boolean isKindless();

    // Whether to require consistent documents when restarting the query. By
    // default, restarting the query uses the readTime offset of the original
    // query to provide consistent results.
    abstract boolean getRequireConsistency();

    static Builder builder() {
      return new AutoValue_Query_QueryOptions.Builder()
          .setAllDescendants(false)
          .setLimitType(LimitType.First)
          .setFieldOrders(ImmutableList.of())
          .setFilters(ImmutableList.of())
          .setFieldProjections(ImmutableList.of())
          .setKindless(false)
          .setRequireConsistency(true);
    }

    abstract Builder toBuilder();

    @AutoValue.Builder
    abstract static class Builder {
      abstract Builder setParentPath(ResourcePath value);

      abstract Builder setCollectionId(String value);

      abstract Builder setAllDescendants(boolean value);

      abstract Builder setLimit(Integer value);

      abstract Builder setLimitType(LimitType value);

      abstract Builder setOffset(Integer value);

      abstract Builder setStartCursor(@Nullable Cursor value);

      abstract Builder setEndCursor(@Nullable Cursor value);

      abstract Builder setFilters(ImmutableList<FilterInternal> value);

      abstract Builder setFieldOrders(ImmutableList<FieldOrder> value);

      abstract Builder setFieldProjections(ImmutableList<FieldReference> value);

      abstract Builder setKindless(boolean value);

      abstract Builder setRequireConsistency(boolean value);

      abstract QueryOptions build();
    }
  }

  /** Creates a query for documents in a single collection */
  Query(FirestoreRpcContext<?> rpcContext, ResourcePath path) {
    this(
        rpcContext,
        QueryOptions.builder()
            .setParentPath(path.getParent())
            .setCollectionId(path.getId())
            .build());
  }

  protected Query(FirestoreRpcContext<?> rpcContext, QueryOptions queryOptions) {
    this.rpcContext = rpcContext;
    this.options = queryOptions;
  }

  /**
   * Gets the Firestore instance associated with this query.
   *
   * @return The Firestore instance associated with this query.
   */
  @Nonnull
  public Firestore getFirestore() {
    return rpcContext.getFirestore();
  }

  /** Checks whether the provided object is NULL or NaN. */
  private static boolean isUnaryComparison(@Nullable Object value) {
    return value == null || value.equals(Double.NaN) || value.equals(Float.NaN);
  }

  /** Returns the sorted set of inequality filter fields used in this query. */
  private SortedSet<FieldPath> getInequalityFilterFields() {
    SortedSet<FieldPath> result = new TreeSet<>();

    for (FilterInternal filter : options.getFilters()) {
      for (FieldFilterInternal subFilter : filter.getFlattenedFilters()) {
        if (subFilter.isInequalityFilter()) {
          result.add(FieldPath.fromServerFormat(subFilter.fieldReference.getFieldPath()));
        }
      }
    }

    return result;
  }

  /** Computes the backend ordering semantics for DocumentSnapshot cursors. */
  ImmutableList<FieldOrder> createImplicitOrderBy() {
    // Any explicit order by fields should be added as is.
    List<FieldOrder> result = new ArrayList<>(options.getFieldOrders());

    HashSet<String> fieldsNormalized = new HashSet<>();
    for (FieldOrder order : result) {
      fieldsNormalized.add(order.fieldReference.getFieldPath());
    }

    /** The order of the implicit ordering always matches the last explicit order by. */
    Direction lastDirection =
        result.isEmpty() ? Direction.ASCENDING : result.get(result.size() - 1).direction;

    /**
     * Any inequality fields not explicitly ordered should be implicitly ordered in a
     * lexicographical order. When there are multiple inequality filters on the same field, the
     * field should be added only once.
     *
     * <p>Note: `SortedSet<FieldPath>` sorts the key field before other fields. However, we want the
     * key field to be sorted last.
     */
    SortedSet<FieldPath> inequalityFields = getInequalityFilterFields();
    for (FieldPath field : inequalityFields) {
      if (!fieldsNormalized.contains(field.toString())
          && !FieldPath.isDocumentId(field.toString())) {
        result.add(new FieldOrder(field.toProto(), lastDirection));
      }
    }

    // Add the document key field to the last if it is not explicitly ordered.
    if (!fieldsNormalized.contains(FieldPath.documentId().toString())) {
      result.add(new FieldOrder(FieldPath.documentId().toProto(), lastDirection));
    }

    return ImmutableList.<FieldOrder>builder().addAll(result).build();
  }

  private Cursor createCursor(
      ImmutableList<FieldOrder> order, DocumentSnapshot documentSnapshot, boolean before) {
    List<Object> fieldValues = new ArrayList<>();

    for (FieldOrder fieldOrder : order) {
      String path = fieldOrder.fieldReference.getFieldPath();
      if (FieldPath.isDocumentId(path)) {
        fieldValues.add(documentSnapshot.getReference());
      } else {
        FieldPath fieldPath = FieldPath.fromServerFormat(path);
        Preconditions.checkArgument(
            documentSnapshot.contains(fieldPath),
            "Field '%s' is missing in the provided DocumentSnapshot. Please provide a document "
                + "that contains values for all specified orderBy() and where() constraints.",
            fieldPath);
        fieldValues.add(documentSnapshot.get(fieldPath));
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

      FieldReference fieldReference = fieldOrderIterator.next().fieldReference;

      if (FieldPath.isDocumentId(fieldReference.getFieldPath())) {
        sanitizedValue = convertReference(fieldValue);
      } else {
        sanitizedValue = CustomClassMapper.serialize(fieldValue);
      }

      Value encodedValue = encodeValue(fieldReference, sanitizedValue);

      if (encodedValue == null) {
        throw FirestoreException.forInvalidArgument(
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
      reference = new DocumentReference(rpcContext, basePath.append((String) fieldValue));
    } else if (fieldValue instanceof DocumentReference) {
      reference = (DocumentReference) fieldValue;
    } else {
      throw new IllegalArgumentException(
          String.format(
              "The corresponding value for FieldPath.documentId() must be a String or a "
                  + "DocumentReference, but was: %s.",
              fieldValue.toString()));
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
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, EQUAL, value));
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and its value does not equal the specified value.
   *
   * @param field The name of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereNotEqualTo(@Nonnull String field, @Nullable Object value) {
    return whereNotEqualTo(FieldPath.fromDotSeparatedString(field), value);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value does not equal the specified value.
   *
   * @param fieldPath The path of the field to compare.
   * @param value The value for comparison.
   * @return The created Query.
   */
  @Nonnull
  public Query whereNotEqualTo(@Nonnull FieldPath fieldPath, @Nullable Object value) {
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, NOT_EQUAL, value));
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
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, LESS_THAN, value));
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
    return where(
        new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, LESS_THAN_OR_EQUAL, value));
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
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, GREATER_THAN, value));
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
    return where(
        new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, GREATER_THAN_OR_EQUAL, value));
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field, the value must be an array, and that the array must contain the provided
   * value.
   *
   * <p>A Query can have only one whereArrayContains() filter and it cannot be combined with
   * whereArrayContainsAny().
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
   * <p>A Query can have only one whereArrayContains() filter and it cannot be combined with
   * whereArrayContainsAny().
   *
   * @param fieldPath The path of the field containing an array to search
   * @param value The value that must be contained in the array
   * @return The created Query.
   */
  @Nonnull
  public Query whereArrayContains(@Nonnull FieldPath fieldPath, @Nonnull Object value) {
    return where(
        new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, ARRAY_CONTAINS, value));
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field, the value must be an array, and that the array must contain at least one value
   * from the provided list.
   *
   * <p>A Query can have only one whereArrayContainsAny() filter and it cannot be combined with
   * whereArrayContains() or whereIn().
   *
   * @param field The name of the field containing an array to search.
   * @param values A list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereArrayContainsAny(
      @Nonnull String field, @Nonnull List<? extends Object> values) {
    return whereArrayContainsAny(FieldPath.fromDotSeparatedString(field), values);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field, the value must be an array, and that the array must contain at least one value
   * from the provided list.
   *
   * <p>A Query can have only one whereArrayContainsAny() filter and it cannot be combined with
   * whereArrayContains() or whereIn().
   *
   * @param fieldPath The path of the field containing an array to search.
   * @param values A list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereArrayContainsAny(
      @Nonnull FieldPath fieldPath, @Nonnull List<? extends Object> values) {
    return where(
        new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, ARRAY_CONTAINS_ANY, values));
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value must equal one of the values from the provided list.
   *
   * <p>A Query can have only one whereIn() filter, and it cannot be combined with
   * whereArrayContainsAny().
   *
   * @param field The name of the field to search.
   * @param values A list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereIn(@Nonnull String field, @Nonnull List<? extends Object> values) {
    return whereIn(FieldPath.fromDotSeparatedString(field), values);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value must equal one of the values from the provided list.
   *
   * <p>A Query can have only one whereIn() filter, and it cannot be combined with
   * whereArrayContainsAny().
   *
   * @param fieldPath The path of the field to search.
   * @param values A list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereIn(@Nonnull FieldPath fieldPath, @Nonnull List<? extends Object> values) {
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, IN, values));
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value does not equal any of the values from the provided list.
   *
   * <p>A Query can have only one whereNotIn() filter and it cannot be combined with
   * whereArrayContains(), whereArrayContainsAny(), whereIn(), or whereNotEqualTo().
   *
   * @param field The name of the field to search.
   * @param values The list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereNotIn(@Nonnull String field, @Nonnull List<? extends Object> values) {
    return whereNotIn(FieldPath.fromDotSeparatedString(field), values);
  }

  /**
   * Creates and returns a new Query with the additional filter that documents must contain the
   * specified field and the value does not equal any of the values from the provided list.
   *
   * <p>A Query can have only one whereNotIn() filter, and it cannot be combined with
   * whereArrayContains(), whereArrayContainsAny(), whereIn(), or whereNotEqualTo().
   *
   * @param fieldPath The path of the field to search.
   * @param values The list that contains the values to match.
   * @return The created Query.
   */
  @Nonnull
  public Query whereNotIn(@Nonnull FieldPath fieldPath, @Nonnull List<? extends Object> values) {
    return where(new com.google.cloud.firestore.Filter.UnaryFilter(fieldPath, NOT_IN, values));
  }

  /**
   * Creates and returns a new Query with the additional filter.
   *
   * @param filter The new filter to apply to the existing query.
   * @return The newly created Query.
   */
  public Query where(com.google.cloud.firestore.Filter filter) {
    Preconditions.checkState(
        options.getStartCursor() == null && options.getEndCursor() == null,
        "Cannot call a where() clause after defining a boundary with startAt(), "
            + "startAfter(), endBefore() or endAt().");
    FilterInternal parsedFilter = parseFilter(filter);
    if (parsedFilter.getFilters().isEmpty()) {
      // Return the existing query if not adding any more filters (for example an empty composite
      // filter).
      return this;
    }
    Builder newOptions = options.toBuilder();
    newOptions.setFilters(append(options.getFilters(), parsedFilter));
    return new Query(rpcContext, newOptions.build());
  }

  FilterInternal parseFilter(com.google.cloud.firestore.Filter filter) {
    if (filter instanceof com.google.cloud.firestore.Filter.UnaryFilter) {
      return parseFieldFilter((com.google.cloud.firestore.Filter.UnaryFilter) filter);
    }
    return parseCompositeFilter((com.google.cloud.firestore.Filter.CompositeFilter) filter);
  }

  private FieldFilterInternal parseFieldFilter(
      com.google.cloud.firestore.Filter.UnaryFilter fieldFilterData) {
    Object value = fieldFilterData.getValue();
    Operator operator = fieldFilterData.getOperator();
    FieldPath fieldPath = fieldFilterData.getField();

    if (isUnaryComparison(value)) {
      if (operator.equals(EQUAL) || operator.equals(NOT_EQUAL)) {
        StructuredQuery.UnaryFilter.Operator unaryOp =
            operator.equals(EQUAL)
                ? (value == null
                    ? StructuredQuery.UnaryFilter.Operator.IS_NULL
                    : StructuredQuery.UnaryFilter.Operator.IS_NAN)
                : (value == null
                    ? StructuredQuery.UnaryFilter.Operator.IS_NOT_NULL
                    : StructuredQuery.UnaryFilter.Operator.IS_NOT_NAN);
        return new UnaryFilterInternal(fieldPath.toProto(), unaryOp);
      } else {
        throw new IllegalArgumentException(
            String.format(
                "Cannot use '%s' in field comparison. Use an equality filter instead.", value));
      }
    } else {
      if (fieldPath.equals(FieldPath.DOCUMENT_ID)) {
        if (operator.equals(ARRAY_CONTAINS) || operator.equals(ARRAY_CONTAINS_ANY)) {
          throw new IllegalArgumentException(
              String.format(
                  "Invalid query. You cannot perform '%s' queries on FieldPath.documentId().",
                  operator.toString()));
        } else if (operator.equals(IN) || operator.equals(NOT_IN)) {
          if (!(value instanceof List) || ((List<?>) value).isEmpty()) {
            throw new IllegalArgumentException(
                String.format(
                    "Invalid Query. A non-empty array is required for '%s' filters.",
                    operator.toString()));
          }
          List<Object> referenceList = new ArrayList<>();
          for (Object arrayValue : (List<Object>) value) {
            Object convertedValue = this.convertReference(arrayValue);
            referenceList.add(convertedValue);
          }
          value = referenceList;
        } else {
          value = this.convertReference(value);
        }
      }
      return new ComparisonFilterInternal(
          fieldPath.toProto(), operator, encodeValue(fieldPath, value));
    }
  }

  private FilterInternal parseCompositeFilter(
      com.google.cloud.firestore.Filter.CompositeFilter compositeFilterData) {
    List<FilterInternal> parsedFilters = new ArrayList<>();
    for (com.google.cloud.firestore.Filter filter : compositeFilterData.getFilters()) {
      FilterInternal parsedFilter = parseFilter(filter);
      if (!parsedFilter.getFilters().isEmpty()) {
        parsedFilters.add(parsedFilter);
      }
    }

    // For composite filters containing 1 filter, return the only filter.
    // For example: AND(FieldFilter1) == FieldFilter1
    if (parsedFilters.size() == 1) {
      return parsedFilters.get(0);
    }
    return new CompositeFilterInternal(parsedFilters, compositeFilterData.getOperator());
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
    FieldOrder newFieldOrder = new FieldOrder(fieldPath.toProto(), direction);
    newOptions.setFieldOrders(append(options.getFieldOrders(), newFieldOrder));

    return new Query(rpcContext, newOptions.build());
  }

  /**
   * Creates and returns a new Query that only returns the first matching documents.
   *
   * @param limit The maximum number of items to return.
   * @return The created Query.
   */
  @Nonnull
  public Query limit(int limit) {
    return new Query(
        rpcContext, options.toBuilder().setLimit(limit).setLimitType(LimitType.First).build());
  }

  /**
   * Creates and returns a new Query that only returns the last matching documents.
   *
   * <p>You must specify at least one orderBy clause for limitToLast queries. Otherwise, an {@link
   * java.lang.IllegalStateException} is thrown during execution.
   *
   * <p>Results for limitToLast() queries are only available once all documents are received. Hence,
   * limitToLast() queries cannot be streamed via the {@link #stream(ApiStreamObserver)} API.
   *
   * @param limit the maximum number of items to return
   * @return the created Query
   */
  @Nonnull
  public Query limitToLast(int limit) {
    return new Query(
        rpcContext, options.toBuilder().setLimit(limit).setLimitType(LimitType.Last).build());
  }

  /**
   * Creates and returns a new Query that skips the first n results.
   *
   * @param offset The number of items to skip.
   * @return The created Query.
   */
  @Nonnull
  public Query offset(int offset) {
    return new Query(rpcContext, options.toBuilder().setOffset(offset).build());
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
    return new Query(rpcContext, newOptions.build());
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
    // TODO(b/296435819): Remove this warning message.
    warningOnSingleDocumentReference(fieldValues);

    ImmutableList<FieldOrder> fieldOrders =
        fieldValues.length == 1 && fieldValues[0] instanceof DocumentReference
            ? createImplicitOrderBy()
            : options.getFieldOrders();
    Cursor cursor = createCursor(fieldOrders, fieldValues, true);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setStartCursor(cursor);
    return new Query(rpcContext, newOptions.build());
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
    if (fieldPaths.length == 0) {
      fieldPaths = new FieldPath[] {FieldPath.DOCUMENT_ID};
    }

    ImmutableList.Builder<FieldReference> fieldProjections =
        ImmutableList.builderWithExpectedSize(fieldPaths.length);
    for (FieldPath path : fieldPaths) {
      FieldReference fieldReference =
          FieldReference.newBuilder().setFieldPath(path.getEncodedPath()).build();
      fieldProjections.add(fieldReference);
    }

    Builder newOptions = options.toBuilder().setFieldProjections(fieldProjections.build());
    return new Query(rpcContext, newOptions.build());
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
    return new Query(rpcContext, newOptions.build());
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
    // TODO(b/296435819): Remove this warning message.
    warningOnSingleDocumentReference(fieldValues);

    ImmutableList<FieldOrder> fieldOrders =
        fieldValues.length == 1 && fieldValues[0] instanceof DocumentReference
            ? createImplicitOrderBy()
            : options.getFieldOrders();
    Cursor cursor = createCursor(fieldOrders, fieldValues, false);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setStartCursor(cursor);
    return new Query(rpcContext, newOptions.build());
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
    return new Query(rpcContext, newOptions.build());
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
    // TODO(b/296435819): Remove this warning message.
    warningOnSingleDocumentReference(fieldValues);

    ImmutableList<FieldOrder> fieldOrders =
        fieldValues.length == 1 && fieldValues[0] instanceof DocumentReference
            ? createImplicitOrderBy()
            : options.getFieldOrders();
    Cursor cursor = createCursor(fieldOrders, fieldValues, true);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setEndCursor(cursor);
    return new Query(rpcContext, newOptions.build());
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
    // TODO(b/296435819): Remove this warning message.
    warningOnSingleDocumentReference(fieldValues);

    ImmutableList<FieldOrder> fieldOrders =
        fieldValues.length == 1 && fieldValues[0] instanceof DocumentReference
            ? createImplicitOrderBy()
            : options.getFieldOrders();
    Cursor cursor = createCursor(fieldOrders, fieldValues, false);

    Builder newOptions = options.toBuilder();
    newOptions.setFieldOrders(fieldOrders);
    newOptions.setEndCursor(cursor);
    return new Query(rpcContext, newOptions.build());
  }

  private void warningOnSingleDocumentReference(Object... fieldValues) {
    if (options.getFieldOrders().isEmpty()
        && fieldValues.length == 1
        && fieldValues[0] instanceof DocumentReference) {
      LOGGER.warning(
          "Warning: Passing DocumentReference into a cursor without orderBy clause is not an intended "
              + "behavior. Please use DocumentSnapshot or add an explicit orderBy on document key field.");
    }
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
    return new Query(rpcContext, newOptions.build());
  }

  /** Build the final Firestore query. */
  StructuredQuery.Builder buildQuery() {
    StructuredQuery.Builder structuredQuery = buildWithoutClientTranslation();
    if (options.getLimitType().equals(LimitType.Last)) {
      structuredQuery.clearOrderBy();
      structuredQuery.clearStartAt();
      structuredQuery.clearEndAt();

      // Apply client translation for limitToLast.
      if (!options.getFieldOrders().isEmpty()) {
        for (FieldOrder order : options.getFieldOrders()) {
          // Flip the orderBy directions since we want the last results
          order =
              new FieldOrder(
                  order.fieldReference,
                  order.direction.equals(Direction.ASCENDING)
                      ? Direction.DESCENDING
                      : Direction.ASCENDING);
          structuredQuery.addOrderBy(order.toProto());
        }
      }

      if (options.getStartCursor() != null) {
        // Swap the cursors to match the flipped query ordering.
        Cursor cursor =
            options
                .getStartCursor()
                .toBuilder()
                .setBefore(!options.getStartCursor().getBefore())
                .build();
        structuredQuery.setEndAt(cursor);
      }

      if (options.getEndCursor() != null) {
        // Swap the cursors to match the flipped query ordering.
        Cursor cursor =
            options
                .getEndCursor()
                .toBuilder()
                .setBefore(!options.getEndCursor().getBefore())
                .build();
        structuredQuery.setStartAt(cursor);
      }
    }

    return structuredQuery;
  }

  /**
   * Builds a {@link BundledQuery} that is able to be saved in a bundle file.
   *
   * <p>This will not perform any limitToLast order flip, as {@link BundledQuery} has first class
   * representation via {@link BundledQuery.LimitType}.
   */
  BundledQuery toBundledQuery() {
    StructuredQuery.Builder structuredQuery = buildWithoutClientTranslation();

    return BundledQuery.newBuilder()
        .setStructuredQuery(structuredQuery)
        .setParent(options.getParentPath().toString())
        .setLimitType(
            options.getLimitType().equals(LimitType.Last)
                ? BundledQuery.LimitType.LAST
                : BundledQuery.LimitType.FIRST)
        .build();
  }

  private StructuredQuery.Builder buildWithoutClientTranslation() {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    CollectionSelector.Builder collectionSelector = CollectionSelector.newBuilder();

    // Kindless queries select all descendant documents, so we don't add the collectionId field.
    if (!options.isKindless()) {
      collectionSelector.setCollectionId(options.getCollectionId());
    }

    collectionSelector.setAllDescendants(options.getAllDescendants());
    structuredQuery.addFrom(collectionSelector);

    // There's an implicit AND operation between the top-level query filters.
    if (!options.getFilters().isEmpty()) {
      FilterInternal filter =
          new CompositeFilterInternal(options.getFilters(), CompositeFilter.Operator.AND);
      structuredQuery.setWhere(filter.toProto());
    }

    if (!options.getFieldOrders().isEmpty()) {
      for (FieldOrder order : options.getFieldOrders()) {
        structuredQuery.addOrderBy(order.toProto());
      }
    } else if (LimitType.Last.equals(options.getLimitType())) {
      throw new IllegalStateException(
          "limitToLast() queries require specifying at least one orderBy() clause.");
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
    Preconditions.checkState(
        !LimitType.Last.equals(Query.this.options.getLimitType()),
        "Query results for queries that include limitToLast() constraints cannot be streamed. "
            + "Use Query.get() instead.");

    internalStream(
        new ApiStreamObserver<RunQueryResponse>() {
          @Override
          public void onNext(RunQueryResponse runQueryResponse) {
            if (runQueryResponse.hasDocument()) {
              Document document = runQueryResponse.getDocument();
              QueryDocumentSnapshot documentSnapshot =
                  QueryDocumentSnapshot.fromDocument(
                      rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
              responseObserver.onNext(documentSnapshot);
            }
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
        /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
        /* transactionId= */ null,
        /* readTime= */ null,
        /* explainOptions= */ null,
        /* isRetryRequestWithCursor= */ false);
  }

  /**
   * Executes the query, streams the results as a StreamObserver of DocumentSnapshots, and returns
   * an ApiFuture that will be resolved with the associated {@link ExplainMetrics}.
   *
   * @param options The options that configure the explain request.
   * @param documentObserver The observer to be notified every time a new document arrives.
   */
  @Nonnull
  public ApiFuture<ExplainMetrics> explainStream(
      @Nonnull ExplainOptions options,
      @Nonnull ApiStreamObserver<DocumentSnapshot> documentObserver) {
    Preconditions.checkState(
        !LimitType.Last.equals(Query.this.options.getLimitType()),
        "Query results for queries that include limitToLast() constraints cannot be streamed. "
            + "Use Query.explain() instead.");

    final SettableApiFuture<ExplainMetrics> metricsFuture = SettableApiFuture.create();
    internalStream(
        new ApiStreamObserver<RunQueryResponse>() {
          @Override
          public void onNext(RunQueryResponse runQueryResponse) {
            if (runQueryResponse.hasDocument()) {
              Document document = runQueryResponse.getDocument();
              QueryDocumentSnapshot documentSnapshot =
                  QueryDocumentSnapshot.fromDocument(
                      rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
              documentObserver.onNext(documentSnapshot);
            }

            if (runQueryResponse.hasExplainMetrics()) {
              metricsFuture.set(new ExplainMetrics(runQueryResponse.getExplainMetrics()));
            }
          }

          @Override
          public void onError(Throwable throwable) {
            metricsFuture.setException(throwable);
            documentObserver.onError(throwable);
          }

          @Override
          public void onCompleted() {
            documentObserver.onCompleted();
            if (!metricsFuture.isDone()) {
              // This means the gRPC stream completed without any metrics.
              metricsFuture.setException(
                  new RuntimeException("Did not receive any explain results."));
            }
          }
        },
        /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
        /* transactionId= */ null,
        /* readTime= */ null,
        /* explainOptions= */ options,
        /* isRetryRequestWithCursor= */ false);

    return metricsFuture;
  }

  /**
   * Returns the {@link RunQueryRequest} that this Query instance represents. The request contains
   * the serialized form of all Query constraints.
   *
   * <p>Runtime metadata (as required for `limitToLast()` queries) is not serialized and as such,
   * the serialized request will return the results in the original backend order.
   *
   * @return the serialized RunQueryRequest
   */
  public RunQueryRequest toProto() {
    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.setStructuredQuery(buildQuery()).setParent(options.getParentPath().toString());
    return request.build();
  }

  /**
   * Returns a Query instance that can be used to execute the provided {@link RunQueryRequest}.
   *
   * <p>Only RunQueryRequests that pertain to the same project as the Firestore instance can be
   * deserialized.
   *
   * <p>Runtime metadata (as required for `limitToLast()` queries) is not restored and as such, the
   * results for limitToLast() queries will be returned in the original backend order.
   *
   * @param firestore a Firestore instance to apply the query to
   * @param proto the serialized RunQueryRequest
   * @return a Query instance that can be used to execute the RunQueryRequest
   */
  public static Query fromProto(Firestore firestore, RunQueryRequest proto) {
    Preconditions.checkState(
        FirestoreRpcContext.class.isAssignableFrom(firestore.getClass()),
        "The firestore instance passed to this method must also implement FirestoreRpcContext.");
    return fromProto((FirestoreRpcContext<?>) firestore, proto);
  }

  private static Query fromProto(FirestoreRpcContext<?> rpcContext, RunQueryRequest proto) {
    QueryOptions.Builder queryOptions = QueryOptions.builder();
    StructuredQuery structuredQuery = proto.getStructuredQuery();

    ResourcePath parentPath = ResourcePath.create(proto.getParent());
    if (!rpcContext.getDatabaseName().equals(parentPath.getDatabaseName().toString())) {
      throw new IllegalArgumentException(
          String.format(
              "Cannot deserialize query from different Firestore project (\"%s\" vs \"%s\")",
              rpcContext.getDatabaseName(), parentPath.getDatabaseName()));
    }
    queryOptions.setParentPath(parentPath);

    Preconditions.checkArgument(
        structuredQuery.getFromCount() == 1,
        "Can only deserialize query with exactly one collection selector.");
    queryOptions.setCollectionId(structuredQuery.getFrom(0).getCollectionId());
    queryOptions.setAllDescendants(structuredQuery.getFrom(0).getAllDescendants());

    if (structuredQuery.hasWhere()) {
      FilterInternal filter = FilterInternal.fromProto(structuredQuery.getWhere());

      // There's an implicit AND operation between the top-level query filters.
      if (filter instanceof CompositeFilterInternal
          && ((CompositeFilterInternal) filter).isConjunction()) {
        queryOptions.setFilters(
            new ImmutableList.Builder<FilterInternal>().addAll(filter.getFilters()).build());
      } else {
        queryOptions.setFilters(ImmutableList.of(filter));
      }
    }

    ImmutableList.Builder<FieldOrder> fieldOrders =
        ImmutableList.builderWithExpectedSize(structuredQuery.getOrderByCount());
    for (Order order : structuredQuery.getOrderByList()) {
      fieldOrders.add(
          new FieldOrder(order.getField(), Direction.valueOf(order.getDirection().name())));
    }
    queryOptions.setFieldOrders(fieldOrders.build());

    if (structuredQuery.hasLimit()) {
      queryOptions.setLimit(structuredQuery.getLimit().getValue());
    }

    if (structuredQuery.getOffset() != 0) {
      queryOptions.setOffset(structuredQuery.getOffset());
    }

    if (structuredQuery.hasSelect()) {
      queryOptions.setFieldProjections(
          ImmutableList.copyOf(structuredQuery.getSelect().getFieldsList()));
    }

    if (structuredQuery.hasStartAt()) {
      queryOptions.setStartCursor(structuredQuery.getStartAt());
    }

    if (structuredQuery.hasEndAt()) {
      queryOptions.setEndCursor(structuredQuery.getEndAt());
    }

    return new Query(rpcContext, queryOptions.build());
  }

  private Value encodeValue(FieldReference fieldReference, Object value) {
    return encodeValue(FieldPath.fromDotSeparatedString(fieldReference.getFieldPath()), value);
  }

  private Value encodeValue(FieldPath fieldPath, Object value) {
    Object sanitizedObject = CustomClassMapper.serialize(value);
    Value encodedValue =
        UserDataConverter.encodeValue(fieldPath, sanitizedObject, UserDataConverter.ARGUMENT);
    if (encodedValue == null) {
      throw FirestoreException.forInvalidArgument(
          "Cannot use Firestore sentinels in FieldFilter or cursors");
    }
    return encodedValue;
  }

  private void internalStream(
      final ApiStreamObserver<RunQueryResponse> runQueryResponseObserver,
      final long startTimeNanos,
      @Nullable final ByteString transactionId,
      @Nullable final Timestamp readTime,
      @Nullable final ExplainOptions explainOptions,
      final boolean isRetryRequestWithCursor) {
    TraceUtil traceUtil = getFirestore().getOptions().getTraceUtil();
    // To reduce the size of traces, we only register one event for every 100 responses
    // that we receive from the server.
    final int NUM_RESPONSES_PER_TRACE_EVENT = 100;

    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.setStructuredQuery(buildQuery()).setParent(options.getParentPath().toString());

    if (explainOptions != null) {
      request.setExplainOptions(explainOptions.toProto());
    }

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }
    if (readTime != null) {
      request.setReadTime(readTime.toProto());
    }

    TraceUtil.Span currentSpan = traceUtil.currentSpan();
    currentSpan.addEvent(
        TraceUtil.SPAN_NAME_RUN_QUERY,
        new ImmutableMap.Builder<String, Object>()
            .put(ATTRIBUTE_KEY_IS_TRANSACTIONAL, transactionId != null)
            .put(ATTRIBUTE_KEY_IS_RETRY_WITH_CURSOR, isRetryRequestWithCursor)
            .build());

    final AtomicReference<QueryDocumentSnapshot> lastReceivedDocument = new AtomicReference<>();

    ResponseObserver<RunQueryResponse> observer =
        new ResponseObserver<RunQueryResponse>() {
          Timestamp readTime;
          boolean firstResponse = false;
          int numDocuments = 0;

          // The stream's `onComplete()` could be called more than once,
          // this flag makes sure only the first one is actually processed.
          boolean hasCompleted = false;

          @Override
          public void onStart(StreamController streamController) {}

          @Override
          public void onResponse(RunQueryResponse response) {
            if (!firstResponse) {
              firstResponse = true;
              currentSpan.addEvent(TraceUtil.SPAN_NAME_RUN_QUERY + ": First Response");
            }

            runQueryResponseObserver.onNext(response);

            if (response.hasDocument()) {
              numDocuments++;
              if (numDocuments % NUM_RESPONSES_PER_TRACE_EVENT == 0) {
                currentSpan.addEvent(
                    TraceUtil.SPAN_NAME_RUN_QUERY + ": Received " + numDocuments + " documents");
              }
              Document document = response.getDocument();
              QueryDocumentSnapshot documentSnapshot =
                  QueryDocumentSnapshot.fromDocument(
                      rpcContext, Timestamp.fromProto(response.getReadTime()), document);
              lastReceivedDocument.set(documentSnapshot);
            }

            if (response.getDone()) {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Received RunQueryResponse.Done");
              onComplete();
            }
          }

          @Override
          public void onError(Throwable throwable) {
            QueryDocumentSnapshot cursor = lastReceivedDocument.get();
            if (shouldRetry(cursor, throwable)) {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Retryable Error",
                  Collections.singletonMap("error.message", throwable.getMessage()));

              Query.this
                  .startAfter(cursor)
                  .internalStream(
                      runQueryResponseObserver,
                      startTimeNanos,
                      /* transactionId= */ null,
                      options.getRequireConsistency() ? cursor.getReadTime() : null,
                      explainOptions,
                      /* isRetryRequestWithCursor= */ true);
            } else {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Error",
                  Collections.singletonMap("error.message", throwable.getMessage()));
              runQueryResponseObserver.onError(throwable);
            }
          }

          @Override
          public void onComplete() {
            if (hasCompleted) return;
            hasCompleted = true;
            currentSpan.addEvent(
                TraceUtil.SPAN_NAME_RUN_QUERY + ": Completed",
                Collections.singletonMap(ATTRIBUTE_KEY_DOC_COUNT, numDocuments));
            runQueryResponseObserver.onCompleted();
          }

          boolean shouldRetry(DocumentSnapshot lastDocument, Throwable t) {
            if (lastDocument == null) {
              // Only retry if we have received a single result. Retries for RPCs with initial
              // failure are handled by Google Gax, which also implements backoff.
              return false;
            }

            // Do not retry EXPLAIN requests because it'd be executing
            // multiple queries. This means stats would have to be aggregated,
            // and that may not even make sense for many statistics.
            if (explainOptions != null) {
              return false;
            }

            Set<StatusCode.Code> retryableCodes =
                FirestoreSettings.newBuilder().runQuerySettings().getRetryableCodes();
            return shouldRetryQuery(t, transactionId, startTimeNanos, retryableCodes);
          }
        };

    rpcContext.streamRequest(request.build(), observer, rpcContext.getClient().runQueryCallable());
  }

  /**
   * Executes the query and returns the results as QuerySnapshot.
   *
   * @return An ApiFuture that will be resolved with the results of the Query.
   */
  @Nonnull
  public ApiFuture<QuerySnapshot> get() {
    return get(null, null);
  }

  /**
   * Plans and optionally executes this query. Returns an ApiFuture that will be resolved with the
   * planner information, statistics from the query execution (if any), and the query results (if
   * any).
   *
   * @return An ApiFuture that will be resolved with the planner information, statistics from the
   *     query execution (if any), and the query results (if any).
   */
  @Nonnull
  public ApiFuture<ExplainResults<QuerySnapshot>> explain(ExplainOptions options) {
    TraceUtil.Span span =
        getFirestore().getOptions().getTraceUtil().startSpan(TraceUtil.SPAN_NAME_QUERY_GET);

    try (Scope ignored = span.makeCurrent()) {
      final SettableApiFuture<ExplainResults<QuerySnapshot>> result = SettableApiFuture.create();
      internalStream(
          new ApiStreamObserver<RunQueryResponse>() {
            @Nullable List<QueryDocumentSnapshot> documentSnapshots = null;
            Timestamp readTime;
            ExplainMetrics metrics;

            @Override
            public void onNext(RunQueryResponse runQueryResponse) {
              if (runQueryResponse.hasDocument()) {
                if (documentSnapshots == null) {
                  documentSnapshots = new ArrayList<>();
                }

                Document document = runQueryResponse.getDocument();
                QueryDocumentSnapshot documentSnapshot =
                    QueryDocumentSnapshot.fromDocument(
                        rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
                documentSnapshots.add(documentSnapshot);
              }

              if (readTime == null) {
                readTime = Timestamp.fromProto(runQueryResponse.getReadTime());
              }

              if (runQueryResponse.hasExplainMetrics()) {
                metrics = new ExplainMetrics(runQueryResponse.getExplainMetrics());
                if (documentSnapshots == null && metrics.getExecutionStats() != null) {
                  // This indicates that the query was executed, but no documents
                  // had matched the query. Create an empty list.
                  documentSnapshots = Collections.emptyList();
                }
              }
            }

            @Override
            public void onError(Throwable throwable) {
              result.setException(throwable);
            }

            @Override
            public void onCompleted() {
              @Nullable QuerySnapshot snapshot = null;
              if (documentSnapshots != null) {
                // The results for limitToLast queries need to be flipped since we reversed the
                // ordering constraints before sending the query to the backend.
                List<QueryDocumentSnapshot> resultView =
                    LimitType.Last.equals(Query.this.options.getLimitType())
                        ? reverse(documentSnapshots)
                        : documentSnapshots;
                snapshot = QuerySnapshot.withDocuments(Query.this, readTime, resultView);
              }
              result.set(new ExplainResults<>(metrics, snapshot));
            }
          },
          /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
          /* transactionId= */ null,
          /* readTime= */ null,
          /* explainOptions= */ options,
          /* isRetryRequestWithCursor= */ false);

      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  /**
   * Starts listening to this query.
   *
   * @param listener The event listener that will be called with the snapshots.
   * @return A registration object that can be used to remove the listener.
   */
  @Nonnull
  public ListenerRegistration addSnapshotListener(@Nonnull EventListener<QuerySnapshot> listener) {
    return addSnapshotListener(rpcContext.getClient().getExecutor(), listener);
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

  ApiFuture<QuerySnapshot> get(
      @Nullable ByteString transactionId, @Nullable Timestamp requestReadTime) {
    TraceUtil.Span span =
        getFirestore()
            .getOptions()
            .getTraceUtil()
            .startSpan(
                transactionId == null
                    ? TraceUtil.SPAN_NAME_QUERY_GET
                    : TraceUtil.SPAN_NAME_TRANSACTION_GET_QUERY);
    try (Scope ignored = span.makeCurrent()) {
      final SettableApiFuture<QuerySnapshot> result = SettableApiFuture.create();
      internalStream(
          new ApiStreamObserver<RunQueryResponse>() {
            final List<QueryDocumentSnapshot> documentSnapshots = new ArrayList<>();
            Timestamp responseReadTime;

            @Override
            public void onNext(RunQueryResponse runQueryResponse) {
              if (runQueryResponse.hasDocument()) {
                Document document = runQueryResponse.getDocument();
                QueryDocumentSnapshot documentSnapshot =
                    QueryDocumentSnapshot.fromDocument(
                        rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
                documentSnapshots.add(documentSnapshot);
              }
              if (responseReadTime == null) {
                responseReadTime = Timestamp.fromProto(runQueryResponse.getReadTime());
              }
            }

            @Override
            public void onError(Throwable throwable) {
              result.setException(throwable);
            }

            @Override
            public void onCompleted() {
              // The results for limitToLast queries need to be flipped since we reversed the
              // ordering constraints before sending the query to the backend.
              List<QueryDocumentSnapshot> resultView =
                  LimitType.Last.equals(Query.this.options.getLimitType())
                      ? reverse(documentSnapshots)
                      : documentSnapshots;
              QuerySnapshot querySnapshot =
                  QuerySnapshot.withDocuments(Query.this, responseReadTime, resultView);
              result.set(querySnapshot);
            }
          },
          /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
          transactionId,
          /* readTime= */ requestReadTime,
          /* explainOptions= */ null,
          /* isRetryRequestWithCursor= */ false);

      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  Comparator<QueryDocumentSnapshot> comparator() {
    Iterator<FieldOrder> iterator = options.getFieldOrders().iterator();
    if (!iterator.hasNext()) {
      return DOCUMENT_ID_COMPARATOR;
    }
    FieldOrder fieldOrder = iterator.next();
    Comparator<QueryDocumentSnapshot> comparator = fieldOrder;
    while (iterator.hasNext()) {
      fieldOrder = iterator.next();
      comparator = comparator.thenComparing(fieldOrder);
    }
    // Add implicit sorting by name, using the last specified direction.
    Direction lastDirection = fieldOrder.direction;
    return comparator.thenComparing(lastDirection.documentIdComparator);
  }

  private static int compareDocumentId(QueryDocumentSnapshot doc1, QueryDocumentSnapshot doc2) {
    return doc1.getReference().getResourcePath().compareTo(doc2.getReference().getResourcePath());
  }

  /**
   * Helper method to append an element to an existing ImmutableList. Returns the newly created
   * list.
   */
  private <T> ImmutableList<T> append(ImmutableList<T> existingList, T newElement) {
    ImmutableList.Builder<T> builder =
        ImmutableList.builderWithExpectedSize(existingList.size() + 1);
    builder.addAll(existingList);
    builder.add(newElement);
    return builder.build();
  }

  /** Verifies whether the given exception is retryable based on the RunQuery configuration. */
  private boolean isRetryableError(Throwable throwable, Set<StatusCode.Code> retryableCodes) {
    if (!(throwable instanceof FirestoreException)) {
      return false;
    }
    Status status = ((FirestoreException) throwable).getStatus();
    for (StatusCode.Code code : retryableCodes) {
      if (code.equals(StatusCode.Code.valueOf(status.getCode().name()))) {
        return true;
      }
    }
    return false;
  }

  /** Returns whether a query that failed in the given scenario should be retried. */
  boolean shouldRetryQuery(
      Throwable throwable,
      @Nullable ByteString transactionId,
      long startTimeNanos,
      Set<StatusCode.Code> retryableCodes) {
    if (transactionId != null) {
      // Transactional queries are retried via the transaction runner.
      return false;
    }

    if (!isRetryableError(throwable, retryableCodes)) {
      return false;
    }

    if (rpcContext.getTotalRequestTimeout().isZero()) {
      return true;
    }

    Duration duration = Duration.ofNanos(rpcContext.getClock().nanoTime() - startTimeNanos);
    return duration.compareTo(rpcContext.getTotalRequestTimeout()) < 0;
  }

  /**
   * Returns a query that counts the documents in the result set of this query.
   *
   * <p>The returned query, when executed, counts the documents in the result set of this query
   * <em>without actually downloading the documents</em>.
   *
   * <p>Using the returned query to count the documents is efficient because only the final count,
   * not the documents' data, is downloaded. The returned query can count the documents in cases
   * where the result set is prohibitively large to download entirely (thousands of documents).
   *
   * @return a query that counts the documents in the result set of this query.
   */
  @Nonnull
  public AggregateQuery count() {
    return new AggregateQuery(this, Collections.singletonList(AggregateField.count()));
  }

  /**
   * Calculates the specified aggregations over the documents in the result set of the given query
   * <em>without actually downloading the documents</em>.
   *
   * <p>Using the returned query to perform aggregations is efficient because only the final
   * aggregation values, not the documents' data, is downloaded. The returned query can perform
   * aggregations of the documents in cases where the result set is prohibitively large to download
   * entirely (thousands of documents).
   *
   * @return an {@link AggregateQuery} that performs aggregations on the documents in the result set
   *     of this query.
   */
  @Nonnull
  public AggregateQuery aggregate(
      @Nonnull AggregateField aggregateField1, @Nonnull AggregateField... aggregateFields) {
    List<AggregateField> aggregateFieldList = new ArrayList<>();
    aggregateFieldList.add(aggregateField1);
    aggregateFieldList.addAll(Arrays.asList(aggregateFields));
    return new AggregateQuery(this, aggregateFieldList);
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
    return Objects.equals(rpcContext, query.rpcContext) && Objects.equals(options, query.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rpcContext, options);
  }
}
