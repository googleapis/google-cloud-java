package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.gcloud.datastore.BlobValue.of;
import static com.google.gcloud.datastore.BooleanValue.of;
import static com.google.gcloud.datastore.DateTimeValue.of;
import static com.google.gcloud.datastore.DoubleValue.of;
import static com.google.gcloud.datastore.KeyValue.of;
import static com.google.gcloud.datastore.LongValue.of;
import static com.google.gcloud.datastore.StringValue.of;

import com.google.api.client.util.Preconditions;
import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;

  private final transient boolean keysOnly;
  private final transient String kind;
  private final transient Filter filter;
  private final transient ImmutableList<OrderBy> orderBy;
  private final transient Cursor startCursor;
  private final transient Cursor endCursor;
  private final transient Integer offset;
  private final transient Integer limit;


  public abstract static class Filter implements Serializable {

    private static final long serialVersionUID = -6443285436239990860L;

    Filter() {
    }

    protected abstract DatastoreV1.Filter toPb();
  }


  public static final class Expression extends Filter {

    private static final long serialVersionUID = 3610352685739360009L;
    private final Operator operator;
    private final ImmutableList<Filter> filters;

    enum Operator {
      AND;

      DatastoreV1.CompositeFilter.Operator toPb() {
        return DatastoreV1.CompositeFilter.Operator.valueOf(name());
      }
    }

    private Expression(Operator operator, Filter first, Filter... other) {
      this.operator = operator;
      this.filters =
          ImmutableList.<Filter>builder().add(first).addAll(Arrays.asList(other)).build();
    }

    public static Expression and(Filter first, Filter... other) {
      return new Expression(Operator.AND, first, other);
    }

    @Override
    protected DatastoreV1.Filter toPb() {
      DatastoreV1.Filter.Builder filterPb = DatastoreV1.Filter.newBuilder();
      DatastoreV1.CompositeFilter.Builder compositeFilterPb = filterPb.getCompositeFilterBuilder();
      compositeFilterPb.setOperator(operator.toPb());
      for (Filter filter : filters) {
        compositeFilterPb.addFilter(filter.toPb());
      }
      return filterPb.build();
    }
  }

  public static final class Condition extends Filter {

    private static final long serialVersionUID = -4514695915258598597L;

    private final String property;
    private final Operator operator;
    private final Value<?> value;

    enum Operator {
      LESS_THAN,
      LESS_THAN_OR_EQUAL,
      GREATER_THAN,
      GREATER_THAN_OR_EQUAL,
      EQUAL,
      HAS_ANCESTOR,
      IS_NULL {
        @Override
        public DatastoreV1.PropertyFilter.Operator toPb() {
          return DatastoreV1.PropertyFilter.Operator.valueOf(EQUAL.name());
        }
      };

      public DatastoreV1.PropertyFilter.Operator toPb() {
        return DatastoreV1.PropertyFilter.Operator.valueOf(name());
      }
    }

    private Condition(String property, Operator operator, Value<?> value) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = checkNotNull(value);
    }

    private Condition(String property, Operator operator) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = null;
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, operator, value);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Condition)) {
        return false;
      }
      Condition other = (Condition) obj;
      return property.equals(other.property)
          && operator.equals(other.operator)
          && Objects.equals(value, other.value);
    }

    public static Condition le(String property, Value<?> value) {
      return new Condition(property, Operator.LESS_THAN, value);
    }

    public static Condition le(String property, String value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, long value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, double value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, boolean value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, DateTime value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, Key value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition le(String property, Blob value) {
      return new Condition(property, Operator.LESS_THAN, of(value));
    }

    public static Condition lte(String property, Value<?> value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, value);
    }

    public static Condition lte(String property, String value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, long value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, double value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, boolean value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, DateTime value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, Key value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition lte(String property, Blob value) {
      return new Condition(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static Condition gt(String property, Value<?> value) {
      return new Condition(property, Operator.GREATER_THAN, value);
    }

    public static Condition gt(String property, String value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, long value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, double value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, boolean value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, DateTime value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, Key value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gt(String property, Blob value) {
      return new Condition(property, Operator.GREATER_THAN, of(value));
    }

    public static Condition gte(String property, Value<?> value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, value);
    }

    public static Condition gte(String property, String value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, long value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, double value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, boolean value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, DateTime value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, Key value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition gte(String property, Blob value) {
      return new Condition(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static Condition eq(String property, Value<?> value) {
      return new Condition(property, Operator.EQUAL, value);
    }

    public static Condition eq(String property, String value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, long value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, double value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, boolean value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, DateTime value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, Key value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition eq(String property, Blob value) {
      return new Condition(property, Operator.EQUAL, of(value));
    }

    public static Condition hasAncestor(String property) {
      return new Condition(property, Operator.HAS_ANCESTOR);
    }

    public static Condition isNull(String property) {
      return new Condition(property, Operator.IS_NULL, NullValue.of());
    }

    @Override
    protected DatastoreV1.Filter toPb() {
      DatastoreV1.Filter.Builder filterPb = DatastoreV1.Filter.newBuilder();
      DatastoreV1.PropertyFilter.Builder propertyFilterPb = filterPb.getPropertyFilterBuilder();
      propertyFilterPb.getPropertyBuilder().setName(property);
      propertyFilterPb.setOperator(operator.toPb());
      if (value != null) {
        propertyFilterPb.setValue(value.toPb());
      }
      return filterPb.build();
    }
  }

  public static final class OrderBy implements Serializable {

    private static final long serialVersionUID = 4091186784814400031L;

    private final String property;
    private final Direction direction;

    public enum Direction {
      ASC, DESC
    }

    public OrderBy(String property, Direction direction) {
      this.property = checkNotNull(property);
      this.direction = checkNotNull(direction);
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, direction);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof OrderBy)) {
        return false;
      }
      OrderBy other = (OrderBy) obj;
      return property.equals(other.property)
          && direction.equals(other.direction);
    }

    public String property() {
      return property;
    }

    public Direction direction() {
      return direction;
    }

    public static OrderBy asc(String property) {
      return new OrderBy(property, OrderBy.Direction.ASC);
    }

    public static OrderBy desc(String property) {
      return new OrderBy(property, OrderBy.Direction.DESC);
    }
  }

  static class Builder<B extends Builder<B>> {

    private String namespace;
    private String kind;
    private Cursor startCursor;
    private Cursor endCursor;
    private Integer offset;
    private Integer limit;
    private Filter filter;
    private List<OrderBy> orderBy = new LinkedList<>();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public B namespace(String namespace) {
      this.namespace = namespace;
      return self();
    }

    public B kind(String kind) {
      this.kind = kind;
      return self();
    }

    public B startCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return self();
    }

    public B encCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return self();
    }

    public B offset(Integer offset) {
      Preconditions.checkArgument(offset == null || offset >= 0, "offset must not be negative");
      this.offset = offset;
      return self();
    }

    public B limit(Integer limit) {
      Preconditions.checkArgument(limit == null || offset > 0, "limit must be positive");
      this.limit = limit;
      return self();
    }

    public B filter(Filter filter) {
      this.filter = filter;
      return self();
    }

    public B clearOrderBy() {
      orderBy.clear();
      return self();
    }

    public B addOrderBy(OrderBy orderBy, OrderBy... others) {
      this.orderBy.add(orderBy);
      for (OrderBy other : others) {
        this.orderBy.add(other);
      }
      return self();
    }
  }

  private StructuredQuery(ResultType<T> resultType, boolean keysOnly, String namespace, String kind,
      Cursor startCursor, Cursor endCursor, Integer offset, Integer limit,
      Filter filter, ImmutableList<OrderBy> orderBy) {
    super(resultType, namespace);
    this.keysOnly = keysOnly;
    this.kind = kind;
    this.startCursor = startCursor;
    this.endCursor = endCursor;
    this.offset = offset;
    this.limit = limit;
    this.filter = filter;
    this.orderBy = orderBy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        namespace(), keysOnly, kind, startCursor, endCursor, offset, limit, filter, orderBy);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof StructuredQuery)) {
      return false;
    }
    StructuredQuery<?> other = (StructuredQuery<?>) obj;
    return Objects.equals(namespace(), other.namespace())
        && Objects.equals(kind, other.kind)
        && Objects.equals(startCursor, other.startCursor)
        && Objects.equals(endCursor, other.endCursor)
        && Objects.equals(offset, other.offset)
        && Objects.equals(limit, other.limit)
        && Objects.equals(filter, other.filter)
        && Objects.equals(orderBy, other.orderBy);
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb) {
    requestPb.setQuery(toPb());
  }

  @Override
  protected GqlQuery<T> nextQuery(DatastoreV1.QueryResultBatch responsePb) {
    // TODO: implment
    throw new UnsupportedOperationException("paging not implemented yet");
  }

  @Override
  protected Object fromPb(ResultType<T> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, DatastoreV1.Query.parseFrom(bytesPb));
  }

  @Override
  protected DatastoreV1.Query toPb() {
    DatastoreV1.Query.Builder queryPb = DatastoreV1.Query.newBuilder();
    if (kind != null) {
      queryPb.addKindBuilder().setName(kind);
    }
    if (startCursor != null) {
      queryPb.setStartCursor(startCursor.byteString());
    }
    if (endCursor != null) {
      queryPb.setEndCursor(endCursor.byteString());
    }
    if (offset != null) {
      queryPb.setOffset(offset);
    }
    if (limit != null) {
      queryPb.setLimit(limit);
    }
    if (filter != null) {
      queryPb.setFilter(filter.toPb());
    }
    // TODO: projection, groupBy, orderBy (or keys-only)
    return queryPb.build();
  }

  static <T> StructuredQuery<T> fromPb(ResultType<T> resultType, String namespace,
      DatastoreV1.Query queryPb) {
    // TODO: implement
    return null;
  }
}
