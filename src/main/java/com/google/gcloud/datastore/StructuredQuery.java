package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;

import com.google.api.client.util.Preconditions;
import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public final class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;

  private final transient boolean keysOnly;
  private final transient String kind;
  private final transient ImmutableList<String> projection;
  private final transient Filter filter;
  private final transient ImmutableList<String> groupBy;
  private final transient ImmutableList<OrderBy> orderBy;
  private final transient Cursor startCursor;
  private final transient Cursor endCursor;
  private final transient Integer offset;
  private final transient Integer limit;


  public static final class Filter implements Serializable {

    private static final long serialVersionUID = -4514695915258598597L;

    private final String property;
    private final Operator operator;
    private final Value<?> value;
    private final Filter next;

    public enum Operator {
      LESS_THAN,
      LESS_THAN_OR_EQUAL,
      GREATER_THAN,
      GREATER_THAN_OR_EQUAL,
      EQUAL,
      HAS_ANCESTOR,
      AND
    }

    private Filter(String property, Operator operator, Value<?> value, Filter next) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = value;
      this.next = next;
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, operator, value, next);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Filter)) {
        return false;
      }
      Filter other = (Filter) obj;
      return property.equals(other.property)
          && operator.equals(other.operator)
          && Objects.equals(value, other.value)
          && Objects.equals(next, other.next);
    }

    public static Filter le(String property, Value<?> value) {
      return new Filter(property, Operator.LESS_THAN, value, null);
    }

    public static Filter lte(String property, Value<?> value) {
      return new Filter(property, Operator.LESS_THAN_OR_EQUAL, value, null);
    }

    public static Filter gt(String property, Value<?> value) {
      return new Filter(property, Operator.GREATER_THAN, value, null);
    }

    public static Filter gte(String property, Value<?> value) {
      return new Filter(property, Operator.GREATER_THAN_OR_EQUAL, value, null);
    }

    public static Filter eq(String property, Value<?> value) {
      return new Filter(property, Operator.EQUAL, value, null);
    }

    public static Filter hasAncestor(String property) {
      return new Filter(property, Operator.HAS_ANCESTOR, null, null);
    }

    public static Filter and(Filter first, Filter... other) {
      Set<Filter> combined = new LinkedHashSet<>();
      for (Filter f : Iterables.concat(Collections.singleton(first), Arrays.asList(other))) {
        while (f != null) {
          combined.add(new Filter(f.property, f.operator, f.value, null));
          f = f.next;
        }
      }
      ArrayDeque<Filter> stack = new ArrayDeque<>(combined.size());
      for (Filter f : combined) {
        stack.push(f);
      }
      while (true) {
        Filter f1 = stack.pop();
        if (stack.isEmpty()) {
          return f1;
        }
        Filter f2 = stack.pop();
        stack.push(new Filter(f2.property, f2.operator, f2.value, f1));
      }
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

  static class Builder {

    private String namespace;
    private String kind;
    private Cursor startCursor;
    private Cursor endCursor;
    private Integer offset;
    private Integer limit;

    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    public Builder startCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return this;
    }

    public Builder encCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return this;
    }

    public Builder offset(Integer offset) {
      Preconditions.checkArgument(offset == null || offset >= 0, "offset must not be negative");
      this.offset = offset;
      return this;
    }

    public Builder limit(Integer limit) {
      Preconditions.checkArgument(limit == null || offset > 0, "limit must be positive");
      this.limit = limit;
      return this;
    }

    /*
    public StructuredQuery<Entity> full() {
      return new StructuredQuery<>(ResultType.full(), this, false);
    }

    public StructuredQuery<PartialEntity> projection(String projection, String... other) {
      ImmutableSet<String> projections =
          ImmutableSet.<String>builder().add(projection).add(other).build();
      return new StructuredQuery<>(ResultType.projection(), this, projections);
    }

    public StructuredQuery<Key> keyOnly() {
      return new StructuredQuery<>(ResultType.keyOnly(), this, true);
    }
    */
  }



  private StructuredQuery(ResultType<T> resultType, boolean keysOnly, String namespace, String kind,
      Cursor startCursor, Cursor endCursor, Integer offset, Integer limit,
      ImmutableList<String> projection, Filter filter, ImmutableList<String> groupBy,
      ImmutableList<OrderBy> orderBy) {
    super(resultType, namespace);
    this.keysOnly = keysOnly;
    this.kind = kind;
    this.startCursor = startCursor;
    this.endCursor = endCursor;
    this.offset = offset;
    this.limit = limit;
    this.projection = projection;
    this.filter = filter;
    this.groupBy = groupBy;
    this.orderBy = orderBy;
    Preconditions.checkState(keysOnly == false || projection.isEmpty() && groupBy.isEmpty(),
        "projection or group by are not applicable for keys-only queries");
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), keysOnly, kind, startCursor, endCursor, offset, limit, projection, filter, groupBy, orderBy);
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
        && Objects.equals(projection, other.projection)
        && Objects.equals(filter, other.filter)
        && Objects.equals(groupBy, other.groupBy)
        && Objects.equals(orderBy, other.orderBy);
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb, int totalRead,
      ByteString batchCursor) {
    if (batchCursor == null) {
      requestPb.setQuery(toPb());
      return;
    }
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
    // TODO: projection, filter, groupBy, orderBy (or keys-only)
    return queryPb.build();
  }

  static <T> StructuredQuery<T> fromPb(ResultType<T> resultType, String namespace,
      DatastoreV1.Query queryPb) {
    // TODO: implement
    return null;
  }
}
