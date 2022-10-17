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

package com.google.cloud.datastore;

import static com.google.cloud.datastore.BlobValue.of;
import static com.google.cloud.datastore.BooleanValue.of;
import static com.google.cloud.datastore.DoubleValue.of;
import static com.google.cloud.datastore.KeyValue.of;
import static com.google.cloud.datastore.LongValue.of;
import static com.google.cloud.datastore.StringValue.of;
import static com.google.cloud.datastore.TimestampValue.of;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.core.InternalApi;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Query.ResultType;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of a Google Cloud Datastore Query that can be constructed by providing all the
 * specific query elements.
 *
 * <h3>A usage example:</h3>
 *
 * <p>A simple query that returns all entities for a specific kind
 *
 * <pre>{@code
 * Query<Entity> query = Query.newEntityQueryBuilder().setKind(kind).build();
 * QueryResults<Entity> results = datastore.run(query);
 * while (results.hasNext()) {
 *   Entity entity = results.next();
 *   ...
 * }
 * }</pre>
 *
 * <p>A simple key-only query of all entities for a specific kind
 *
 * <pre>{@code
 * Query<Key> keyOnlyQuery =  Query.newKeyQueryBuilder().setKind(KIND1).build();
 * QueryResults<Key> results = datastore.run(keyOnlyQuery);
 * ...
 * }</pre>
 *
 * <p>A less trivial example of a projection query that returns the first 10 results of "age" and
 * "name" properties (sorted and grouped by "age") with an age greater than 18
 *
 * <pre>{@code
 * Query<ProjectionEntity> query = Query.newProjectionEntityQueryBuilder()
 *     .setKind(kind)
 *     .setProjection(Projection.property("age"), Projection.first("name"))
 *     .setFilter(PropertyFilter.gt("age", 18))
 *     .setGroupBy("age")
 *     .setOrderBy(OrderBy.asc("age"))
 *     .setLimit(10)
 *     .build();
 * QueryResults<ProjectionEntity> results = datastore.run(query);
 * ...
 * }</pre>
 *
 * @param <V> the type of the result values this query will produce
 * @see <a href="https://cloud.google.com/appengine/docs/java/datastore/queries">Datastore
 *     queries</a>
 */
public abstract class StructuredQuery<V> extends Query<V> implements RecordQuery<V> {

  private static final long serialVersionUID = 546838955624019594L;
  static final String KEY_PROPERTY_NAME = "__key__";

  private final String kind;
  private final ImmutableList<String> projection;
  private final Filter filter;
  private final ImmutableList<String> distinctOn;
  private final ImmutableList<OrderBy> orderBy;
  private final Cursor startCursor;
  private final Cursor endCursor;
  private final int offset;
  private final Integer limit;

  private final ResultType<V> resultType;

  public abstract static class Filter implements Serializable {

    private static final long serialVersionUID = -6443285436239990860L;

    Filter() {}

    abstract com.google.datastore.v1.Filter toPb();

    static Filter fromPb(com.google.datastore.v1.Filter filterPb) {
      switch (filterPb.getFilterTypeCase()) {
        case COMPOSITE_FILTER:
          return CompositeFilter.fromPb(filterPb.getCompositeFilter());
        case PROPERTY_FILTER:
          return PropertyFilter.fromPb(filterPb.getPropertyFilter());
        default:
          throw new AssertionError("Unexpected enum value " + filterPb.getFilterTypeCase());
      }
    }
  }

  /** A class representing a filter composed of a combination of other filters. */
  public static final class CompositeFilter extends Filter {

    private static final long serialVersionUID = 3610352685739360009L;
    private final Operator operator;
    private final ImmutableList<Filter> filters;

    static final class Operator extends StringEnumValue {
      private static final long serialVersionUID = -4806600805752138487L;

      private Operator(String constant) {
        super(constant);
      }

      private static final ApiFunction<String, Operator> CONSTRUCTOR =
          new ApiFunction<String, Operator>() {
            @Override
            public Operator apply(String constant) {
              return new Operator(constant);
            }
          };

      private static final StringEnumType<Operator> type =
          new StringEnumType(Operator.class, CONSTRUCTOR);

      static final Operator AND = type.createAndRegister("AND");

      com.google.datastore.v1.CompositeFilter.Operator toPb() {
        return com.google.datastore.v1.CompositeFilter.Operator.valueOf(name());
      }

      static Operator fromPb(com.google.datastore.v1.CompositeFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
      }

      /**
       * Get the Operator for the given String constant, and throw an exception if the constant is
       * not recognized.
       */
      static Operator valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      /** Get the Operator for the given String constant, and allow unrecognized values. */
      static Operator valueOf(String constant) {
        return type.valueOf(constant);
      }

      /** Return the known values for Operator. */
      static Operator[] values() {
        return type.values();
      }
    }

    private CompositeFilter(Operator operator, Filter first, Filter... other) {
      this.operator = operator;
      this.filters =
          ImmutableList.<Filter>builder().add(first).addAll(Arrays.asList(other)).build();
    }

    private CompositeFilter(Operator operator, ImmutableList<Filter> filters) {
      this.operator = operator;
      this.filters = filters;
      Preconditions.checkArgument(!filters.isEmpty(), "filters list must not be empty");
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("operator", operator);
      toStringHelper.add("filters", filters);
      return toStringHelper.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(operator, filters);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof CompositeFilter)) {
        return false;
      }
      CompositeFilter other = (CompositeFilter) obj;
      return operator.equals(other.operator) && filters.equals(other.filters);
    }

    static CompositeFilter fromPb(com.google.datastore.v1.CompositeFilter compositeFilterPb) {
      Operator operator = Operator.fromPb(compositeFilterPb.getOp());
      ImmutableList.Builder<Filter> filters = ImmutableList.builder();
      for (com.google.datastore.v1.Filter filterPb : compositeFilterPb.getFiltersList()) {
        Filter currFilter = Filter.fromPb(filterPb);
        if (currFilter != null) {
          filters.add(currFilter);
        }
      }
      return new CompositeFilter(operator, filters.build());
    }

    public static CompositeFilter and(Filter first, Filter... other) {
      return new CompositeFilter(Operator.AND, first, other);
    }

    @Override
    com.google.datastore.v1.Filter toPb() {
      com.google.datastore.v1.Filter.Builder filterPb = com.google.datastore.v1.Filter.newBuilder();
      com.google.datastore.v1.CompositeFilter.Builder compositeFilterPb =
          filterPb.getCompositeFilterBuilder();
      compositeFilterPb.setOp(operator.toPb());
      for (Filter filter : filters) {
        compositeFilterPb.addFilters(filter.toPb());
      }
      return filterPb.build();
    }
  }

  /** A class representing a filter based on a single property or ancestor. */
  public static final class PropertyFilter extends Filter {

    private static final long serialVersionUID = -4514695915258598597L;

    private final String property;
    private final Operator operator;
    private final Value<?> value;

    static final class Operator extends StringEnumValue {
      private static final long serialVersionUID = 4105765859141068029L;

      private Operator(String constant) {
        super(constant);
      }

      private static final ApiFunction<String, Operator> CONSTRUCTOR =
          new ApiFunction<String, Operator>() {
            @Override
            public Operator apply(String constant) {
              return new Operator(constant);
            }
          };

      private static final StringEnumType<Operator> type =
          new StringEnumType(Operator.class, CONSTRUCTOR);

      static final Operator LESS_THAN = type.createAndRegister("LESS_THAN");
      static final Operator LESS_THAN_OR_EQUAL = type.createAndRegister("LESS_THAN_OR_EQUAL");
      static final Operator GREATER_THAN = type.createAndRegister("GREATER_THAN");
      static final Operator GREATER_THAN_OR_EQUAL = type.createAndRegister("GREATER_THAN_OR_EQUAL");
      static final Operator EQUAL = type.createAndRegister("EQUAL");
      static final Operator IN = type.createAndRegister("IN");
      static final Operator NOT_EQUAL = type.createAndRegister("NOT_EQUAL");
      static final Operator HAS_ANCESTOR = type.createAndRegister("HAS_ANCESTOR");
      static final Operator NOT_IN = type.createAndRegister("NOT_IN");

      com.google.datastore.v1.PropertyFilter.Operator toPb() {
        return com.google.datastore.v1.PropertyFilter.Operator.valueOf(name());
      }

      static Operator fromPb(com.google.datastore.v1.PropertyFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
      }

      /**
       * Get the Operator for the given String constant, and throw an exception if the constant is
       * not recognized.
       */
      static Operator valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      /** Get the Operator for the given String constant, and allow unrecognized values. */
      static Operator valueOf(String constant) {
        return type.valueOf(constant);
      }

      /** Return the known values for Operator. */
      static Operator[] values() {
        return type.values();
      }
    }

    private PropertyFilter(String property, Operator operator, Value<?> value) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = checkNotNull(value);
    }

    static PropertyFilter fromPb(com.google.datastore.v1.PropertyFilter propertyFilterPb) {
      String property = propertyFilterPb.getProperty().getName();
      Operator operator = Operator.fromPb(propertyFilterPb.getOp());
      Value<?> value = Value.fromPb(propertyFilterPb.getValue());
      return new PropertyFilter(property, operator, value);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("property", property);
      toStringHelper.add("operator", operator);
      toStringHelper.add("value", value);
      return toStringHelper.toString();
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
      if (!(obj instanceof PropertyFilter)) {
        return false;
      }
      PropertyFilter other = (PropertyFilter) obj;
      return property.equals(other.property)
          && operator.equals(other.operator)
          && Objects.equals(value, other.value);
    }

    public static PropertyFilter lt(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN, value);
    }

    public static PropertyFilter lt(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, Blob value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter le(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, Blob value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gt(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, value);
    }

    public static PropertyFilter gt(String property, String value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, long value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, double value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, boolean value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Blob value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter ge(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter ge(String property, String value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, long value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, double value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, boolean value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, Blob value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.EQUAL, value);
    }

    public static PropertyFilter eq(String property, String value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, long value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, double value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, boolean value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Key value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Blob value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, value);
    }

    public static PropertyFilter neq(String property, String value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, long value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, double value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, boolean value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, Timestamp value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, Key value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter neq(String property, Blob value) {
      return new PropertyFilter(property, Operator.NOT_EQUAL, of(value));
    }

    public static PropertyFilter in(String property, ListValue value) {
      return new PropertyFilter(property, Operator.IN, value);
    }

    public static PropertyFilter not_in(String property, ListValue value) {
      return new PropertyFilter(property, Operator.NOT_IN, value);
    }

    public static PropertyFilter hasAncestor(Key key) {
      return new PropertyFilter(KEY_PROPERTY_NAME, Operator.HAS_ANCESTOR, of(key));
    }

    public static PropertyFilter isNull(String property) {
      return new PropertyFilter(property, Operator.EQUAL, NullValue.of());
    }

    @Override
    com.google.datastore.v1.Filter toPb() {
      com.google.datastore.v1.Filter.Builder filterPb = com.google.datastore.v1.Filter.newBuilder();
      com.google.datastore.v1.PropertyFilter.Builder propertyFilterPb =
          filterPb.getPropertyFilterBuilder();
      propertyFilterPb.getPropertyBuilder().setName(property);
      propertyFilterPb.setOp(operator.toPb());
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

    public static final class Direction extends StringEnumValue {
      private static final long serialVersionUID = -6938125060419556331L;

      private Direction(String constant) {
        super(constant);
      }

      private static final ApiFunction<String, Direction> CONSTRUCTOR =
          new ApiFunction<String, Direction>() {
            @Override
            public Direction apply(String constant) {
              return new Direction(constant);
            }
          };

      private static final StringEnumType<Direction> type =
          new StringEnumType(Direction.class, CONSTRUCTOR);

      public static final Direction ASCENDING = type.createAndRegister("ASCENDING");
      public static final Direction DESCENDING = type.createAndRegister("DESCENDING");

      com.google.datastore.v1.PropertyOrder.Direction toPb() {
        return com.google.datastore.v1.PropertyOrder.Direction.valueOf(name());
      }

      static Direction fromPb(com.google.datastore.v1.PropertyOrder.Direction directionPb) {
        return valueOf(directionPb.name());
      }

      /**
       * Get the Direction for the given String constant, and throw an exception if the constant is
       * not recognized.
       */
      static Direction valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      /** Get the Direction for the given String constant, and allow unrecognized values. */
      static Direction valueOf(String constant) {
        return type.valueOf(constant);
      }

      /** Return the known values for Direction. */
      static Direction[] values() {
        return type.values();
      }
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
      return property.equals(other.property) && direction.equals(other.direction);
    }

    /** Returns the property according to which the query result should be ordered. */
    public String getProperty() {
      return property;
    }

    /** Returns the order's direction. */
    public Direction getDirection() {
      return direction;
    }

    com.google.datastore.v1.PropertyOrder toPb() {
      return com.google.datastore.v1.PropertyOrder.newBuilder()
          .setDirection(direction.toPb())
          .setProperty(
              com.google.datastore.v1.PropertyReference.newBuilder().setName(property).build())
          .build();
    }

    public static OrderBy asc(String property) {
      return new OrderBy(property, OrderBy.Direction.ASCENDING);
    }

    public static OrderBy desc(String property) {
      return new OrderBy(property, OrderBy.Direction.DESCENDING);
    }

    static OrderBy fromPb(com.google.datastore.v1.PropertyOrder propertyOrderPb) {
      String property = propertyOrderPb.getProperty().getName();
      Direction direction = Direction.fromPb(propertyOrderPb.getDirection());
      return new OrderBy(property, direction);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("property", getProperty());
      toStringHelper.add("direction", getDirection());
      return toStringHelper.toString();
    }
  }

  /**
   * Interface for StructuredQuery builders.
   *
   * @param <V> the type of result the query returns.
   */
  public interface Builder<V> {

    /** Sets the namespace for the query. */
    Builder<V> setNamespace(String namespace);

    /** Sets the kind for the query. */
    Builder<V> setKind(String kind);

    /** Sets the start cursor for the query. */
    Builder<V> setStartCursor(Cursor startCursor);

    /** Sets the end cursor for the query. */
    Builder<V> setEndCursor(Cursor endCursor);

    /** Sets the offset for the query. */
    Builder<V> setOffset(int offset);

    /** Sets the limit for the query. */
    Builder<V> setLimit(Integer limit);

    Builder<V> setFilter(Filter filter);

    /** Clears any previously specified order by settings. */
    Builder<V> clearOrderBy();

    /** Sets the query's order by clause (clearing any previously specified order by settings). */
    Builder<V> setOrderBy(OrderBy orderBy, OrderBy... others);

    /** Adds settings to the existing order by clause. */
    Builder<V> addOrderBy(OrderBy orderBy, OrderBy... others);

    StructuredQuery<V> build();
  }

  /**
   * Base class for StructuredQuery builders.
   *
   * @param <V> the type of result the query returns.
   * @param <B> the query builder.
   */
  abstract static class BuilderImpl<V, B extends BuilderImpl<V, B>> implements Builder<V> {

    private final ResultType<V> resultType;
    private String namespace;
    private String kind;
    private final List<String> projection = new LinkedList<>();
    private Filter filter;
    private final List<String> distinctOn = new LinkedList<>();
    private final List<OrderBy> orderBy = new LinkedList<>();
    private Cursor startCursor;
    private Cursor endCursor;
    private int offset;
    private Integer limit;

    BuilderImpl(ResultType<V> resultType) {
      this.resultType = resultType;
    }

    BuilderImpl(StructuredQuery<V> query) {
      this(query.getType());
      namespace = query.getNamespace();
      kind = query.kind;
      projection.addAll(query.projection);
      filter = query.filter;
      distinctOn.addAll(query.distinctOn);
      orderBy.addAll(query.orderBy);
      startCursor = query.startCursor;
      endCursor = query.endCursor;
      offset = query.offset;
      limit = query.limit;
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    @Override
    public B setNamespace(String namespace) {
      this.namespace = namespace;
      return self();
    }

    @Override
    public B setKind(String kind) {
      this.kind = kind;
      return self();
    }

    @Override
    public B setStartCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return self();
    }

    @Override
    public B setEndCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return self();
    }

    @Override
    public B setOffset(int offset) {
      Preconditions.checkArgument(offset >= 0, "offset must not be negative");
      this.offset = offset;
      return self();
    }

    @Override
    public B setLimit(Integer limit) {
      Preconditions.checkArgument(limit == null || limit >= 0, "limit must not be negative");
      this.limit = limit;
      return self();
    }

    @Override
    public B setFilter(Filter filter) {
      this.filter = filter;
      return self();
    }

    @Override
    public B clearOrderBy() {
      orderBy.clear();
      return self();
    }

    @Override
    public B setOrderBy(OrderBy orderBy, OrderBy... others) {
      clearOrderBy();
      addOrderBy(orderBy, others);
      return self();
    }

    @Override
    public B addOrderBy(OrderBy orderBy, OrderBy... others) {
      this.orderBy.add(orderBy);
      Collections.addAll(this.orderBy, others);
      return self();
    }

    B clearProjection() {
      projection.clear();
      return self();
    }

    B setProjection(String projection, String... others) {
      clearProjection();
      addProjection(projection, others);
      return self();
    }

    B addProjection(String projection, String... others) {
      this.projection.add(projection);
      Collections.addAll(this.projection, others);
      return self();
    }

    B clearDistinctOn() {
      distinctOn.clear();
      return self();
    }

    B setDistinctOn(String property, String... others) {
      clearDistinctOn();
      addDistinctOn(property, others);
      return self();
    }

    B addDistinctOn(String property, String... others) {
      this.distinctOn.add(property);
      Collections.addAll(this.distinctOn, others);
      return self();
    }

    B mergeFrom(com.google.datastore.v1.Query queryPb) {
      if (queryPb.getKindCount() > 0) {
        setKind(queryPb.getKind(0).getName());
      }
      if (!queryPb.getStartCursor().isEmpty()) {
        setStartCursor(new Cursor(queryPb.getStartCursor()));
      }
      if (!queryPb.getEndCursor().isEmpty()) {
        setEndCursor(new Cursor(queryPb.getEndCursor()));
      }
      setOffset(queryPb.getOffset());
      if (queryPb.hasLimit()) {
        setLimit(queryPb.getLimit().getValue());
      }
      if (queryPb.hasFilter()) {
        Filter currFilter = Filter.fromPb(queryPb.getFilter());
        if (currFilter != null) {
          setFilter(currFilter);
        }
      }
      for (com.google.datastore.v1.PropertyOrder orderByPb : queryPb.getOrderList()) {
        addOrderBy(OrderBy.fromPb(orderByPb));
      }
      for (com.google.datastore.v1.Projection projectionPb : queryPb.getProjectionList()) {
        addProjection(projectionPb.getProperty().getName());
      }
      for (com.google.datastore.v1.PropertyReference distinctOnPb : queryPb.getDistinctOnList()) {
        addDistinctOn(distinctOnPb.getName());
      }
      return self();
    }
  }

  StructuredQuery(BuilderImpl<V, ?> builder) {
    super(builder.namespace);
    resultType = checkNotNull(builder.resultType);
    kind = builder.kind;
    projection = ImmutableList.copyOf(builder.projection);
    filter = builder.filter;
    distinctOn = ImmutableList.copyOf(builder.distinctOn);
    orderBy = ImmutableList.copyOf(builder.orderBy);
    startCursor = builder.startCursor;
    endCursor = builder.endCursor;
    offset = builder.offset;
    limit = builder.limit;
  }

  @Override
  public String toString() {
    return toStringHelper()
        .add("type", getType())
        .add("kind", kind)
        .add("startCursor", startCursor)
        .add("endCursor", endCursor)
        .add("offset", offset)
        .add("limit", limit)
        .add("filter", filter)
        .add("orderBy", orderBy)
        .add("projection", projection)
        .add("distinctOn", distinctOn)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getNamespace(),
        kind,
        startCursor,
        endCursor,
        offset,
        limit,
        filter,
        orderBy,
        projection,
        distinctOn);
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
    return Objects.equals(getNamespace(), other.getNamespace())
        && Objects.equals(kind, other.kind)
        && Objects.equals(startCursor, other.startCursor)
        && Objects.equals(endCursor, other.endCursor)
        && Objects.equals(offset, other.offset)
        && Objects.equals(limit, other.limit)
        && Objects.equals(filter, other.filter)
        && Objects.equals(orderBy, other.orderBy)
        && Objects.equals(projection, other.projection)
        && Objects.equals(distinctOn, other.distinctOn);
  }

  /** Returns the kind for this query. */
  public String getKind() {
    return kind;
  }

  boolean isKeyOnly() {
    return projection.size() == 1 && KEY_PROPERTY_NAME.equals(projection.get(0));
  }

  /** Returns the projection for this query. */
  public List<String> getProjection() {
    return projection;
  }

  /** Returns the filter for this query. */
  public Filter getFilter() {
    return filter;
  }

  /** Returns the distinct on clause for this query. */
  public List<String> getDistinctOn() {
    return distinctOn;
  }

  /** Returns the order by clause for this query. */
  public List<OrderBy> getOrderBy() {
    return orderBy;
  }

  /** Returns the start cursor for this query. */
  public Cursor getStartCursor() {
    return startCursor;
  }

  /** Returns the end cursor for this query. */
  public Cursor getEndCursor() {
    return endCursor;
  }

  /** Returns the offset for this query. */
  public int getOffset() {
    return offset;
  }

  /** Returns the limit for this query. */
  public Integer getLimit() {
    return limit;
  }

  public abstract Builder<V> toBuilder();

  @InternalApi
  @Override
  public ResultType<V> getType() {
    return resultType;
  }

  @InternalApi
  @Override
  public void populatePb(com.google.datastore.v1.RunQueryRequest.Builder requestPb) {
    requestPb.setQuery(toPb());
  }

  @InternalApi
  @Override
  public StructuredQuery<V> nextQuery(com.google.datastore.v1.RunQueryResponse responsePb) {
    Builder<V> builder = toBuilder();
    builder.setStartCursor(new Cursor(responsePb.getBatch().getEndCursor()));
    if (offset > 0 && responsePb.getBatch().getSkippedResults() < offset) {
      builder.setOffset(offset - responsePb.getBatch().getSkippedResults());
    } else {
      builder.setOffset(0);
      if (limit != null) {
        builder.setLimit(limit - responsePb.getBatch().getEntityResultsCount());
      }
    }
    return builder.build();
  }

  com.google.datastore.v1.Query toPb() {
    StructuredQueryProtoPreparer protoPreparer = new StructuredQueryProtoPreparer();
    return protoPreparer.prepare(this);
  }

  @SuppressWarnings("unchecked")
  static <V> StructuredQuery<V> fromPb(
      ResultType<?> resultType, String namespace, com.google.datastore.v1.Query queryPb) {
    BuilderImpl<?, ?> builder;
    if (resultType.equals(ResultType.ENTITY)) {
      builder = new EntityQuery.Builder();
    } else if (resultType.equals(ResultType.KEY)) {
      builder = new KeyQuery.Builder();
    } else {
      builder = new ProjectionEntityQuery.Builder();
    }
    return (StructuredQuery<V>) builder.setNamespace(namespace).mergeFrom(queryPb).build();
  }
}
