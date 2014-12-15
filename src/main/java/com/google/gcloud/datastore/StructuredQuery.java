package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.gcloud.datastore.BlobValue.of;
import static com.google.gcloud.datastore.BooleanValue.of;
import static com.google.gcloud.datastore.DateTimeValue.of;
import static com.google.gcloud.datastore.DoubleValue.of;
import static com.google.gcloud.datastore.KeyValue.of;
import static com.google.gcloud.datastore.LongValue.of;
import static com.google.gcloud.datastore.StringValue.of;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;
  private static final String KEY_PROPERTY_NAME = "__key__";

  private final transient String kind;
  private final ImmutableList<Projection> projection;
  private final transient Filter filter;
  private final ImmutableList<String> groupBy;
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

    static Filter fromPb(DatastoreV1.Filter filterPb) {
      if (filterPb.hasCompositeFilter()) {
        return CompositeFilter.fromPb(filterPb.getCompositeFilter());
      }
      return PropertyFilter.fromPb(filterPb.getPropertyFilter());
    }
  }

  public static final class CompositeFilter extends Filter {

    private static final long serialVersionUID = 3610352685739360009L;
    private final Operator operator;
    private final ImmutableList<Filter> filters;

    enum Operator {
      AND;

      DatastoreV1.CompositeFilter.Operator toPb() {
        return DatastoreV1.CompositeFilter.Operator.valueOf(name());
      }

      static Operator fromPb(DatastoreV1.CompositeFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
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

    static CompositeFilter fromPb(DatastoreV1.CompositeFilter compositeFilterPb) {
      Operator operator = Operator.fromPb(compositeFilterPb.getOperator());
      ImmutableList.Builder<Filter> filters = ImmutableList.builder();
      for (DatastoreV1.Filter filterPb : compositeFilterPb.getFilterList()) {
        filters.add(Filter.fromPb(filterPb));
      }
      return new CompositeFilter(operator, filters.build());
    }

    public static CompositeFilter and(Filter first, Filter... other) {
      return new CompositeFilter(Operator.AND, first, other);
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

  public static final class PropertyFilter extends Filter {

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
      HAS_ANCESTOR;

      DatastoreV1.PropertyFilter.Operator toPb() {
        return DatastoreV1.PropertyFilter.Operator.valueOf(name());
      }

      static Operator fromPb(DatastoreV1.PropertyFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
      }
    }

    private PropertyFilter(String property, Operator operator, Value<?> value) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = checkNotNull(value);
    }

    public static PropertyFilter fromPb(DatastoreV1.PropertyFilter propertyFilterPb) {
      String property = propertyFilterPb.getProperty().getName();
      Operator operator = Operator.fromPb(propertyFilterPb.getOperator());
      Value<?> value = Value.fromPb(propertyFilterPb.getValue());
      return new PropertyFilter(property, operator, value);
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

    public static PropertyFilter le(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN, value);
    }

    public static PropertyFilter le(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, DateTime value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, Blob value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lte(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter lte(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, DateTime value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter lte(String property, Blob value) {
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

    public static PropertyFilter gt(String property, DateTime value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Blob value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gte(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter gte(String property, String value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, long value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, double value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, boolean value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, DateTime value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gte(String property, Blob value) {
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

    public static PropertyFilter eq(String property, DateTime value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Key value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Blob value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter hasAncestor(String property, Key key) {
      return new PropertyFilter(property, Operator.HAS_ANCESTOR, of(key));
    }

    public static PropertyFilter isNull(String property) {
      return new PropertyFilter(property, Operator.EQUAL, NullValue.of());
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

      ASCENDING, DESCENDING;

      DatastoreV1.PropertyOrder.Direction toPb() {
        return DatastoreV1.PropertyOrder.Direction.valueOf(name());
      }

      static Direction fromPb(DatastoreV1.PropertyOrder.Direction directionPb) {
        return valueOf(directionPb.name());
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
      return property.equals(other.property)
          && direction.equals(other.direction);
    }

    public String property() {
      return property;
    }

    public Direction direction() {
      return direction;
    }

    DatastoreV1.PropertyOrder toPb() {
      return DatastoreV1.PropertyOrder.newBuilder()
          .setDirection(direction.toPb())
          .setProperty(DatastoreV1.PropertyReference.newBuilder().setName(property).build())
          .build();
    }

    public static OrderBy asc(String property) {
      return new OrderBy(property, OrderBy.Direction.ASCENDING);
    }

    public static OrderBy desc(String property) {
      return new OrderBy(property, OrderBy.Direction.DESCENDING);
    }

    static OrderBy fromPb(DatastoreV1.PropertyOrder propertyOrderPb) {
      String property = propertyOrderPb.getProperty().getName();
      Direction direction = Direction.fromPb(propertyOrderPb.getDirection());
      return new OrderBy(property, direction);
    }
  }

  public static final class Projection implements Serializable {

    private static final long serialVersionUID = 3083707957256279470L;

    private final Aggregate aggregate;
    private final String property;

    public enum Aggregate {

      FIRST;

      DatastoreV1.PropertyExpression.AggregationFunction toPb() {
        return DatastoreV1.PropertyExpression.AggregationFunction.valueOf(name());
      }

      static Aggregate fromPb(DatastoreV1.PropertyExpression.AggregationFunction aggregatePb) {
        return valueOf(aggregatePb.name());
      }
    }

    private Projection(Aggregate aggregate, String property) {
      this.aggregate = aggregate;
      this.property = property;
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, aggregate);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Projection)) {
        return false;
      }
      Projection other = (Projection) obj;
      return Objects.equals(property, other.property)
          && Objects.equals(aggregate, other.aggregate);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("property", property);
      if (aggregate != null) {
        toStringHelper.add("aggregate", aggregate);
      }
      return toStringHelper.toString();
    }

    DatastoreV1.PropertyExpression toPb() {
      DatastoreV1.PropertyExpression.Builder expressionPb =
          DatastoreV1.PropertyExpression.newBuilder();
      if (aggregate != null) {
        expressionPb.setAggregationFunction(aggregate.toPb());
      }
      expressionPb.setProperty(
          DatastoreV1.PropertyReference.newBuilder().setName(property).build());
      return expressionPb.build();
    }

    public static Projection fromPb(DatastoreV1.PropertyExpression propertyExpressionPb) {
      String property = propertyExpressionPb.getProperty().getName();
      Aggregate aggregate = null;
      if (propertyExpressionPb.hasAggregationFunction()) {
        aggregate = Aggregate.fromPb(propertyExpressionPb.getAggregationFunction());
      }
      return new Projection(aggregate, property);
    }

    public static Projection property(String property) {
      return new Projection(null, property);
    }

    public static Projection aggregate(Aggregate aggregate, String property) {
      return new Projection(aggregate, property);
    }

    public static Projection first(String property) {
      return new Projection(Aggregate.FIRST, property);
    }
  }

  static abstract class BaseBuilder<T, B extends BaseBuilder<T, B>> {

    private ResultClass<T> resultClass;
    private String namespace;
    private String kind;
    private List<Projection> projection = new LinkedList<>();
    private Filter filter;
    private List<String> groupBy = new LinkedList<>();
    private List<OrderBy> orderBy = new LinkedList<>();
    private Cursor startCursor;
    private Cursor endCursor;
    private Integer offset;
    private Integer limit;

    BaseBuilder(ResultClass<T> resultClass) {
      this.resultClass = resultClass;
    }

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

    public B endCursor(Cursor endCursor) {
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

    public B orderBy(OrderBy orderBy, OrderBy... others) {
      clearOrderBy();
      addOrderBy(orderBy, others);
      return self();
    }

    public B addOrderBy(OrderBy orderBy, OrderBy... others) {
      this.orderBy.add(orderBy);
      for (OrderBy other : others) {
        this.orderBy.add(other);
      }
      return self();
    }

    protected B clearProjection() {
      projection.clear();
      return self();
    }

    protected B projection(Projection projection, Projection... others) {
      clearProjection();
      addProjection(projection, others);
      return self();
    }

    protected B addProjection(Projection projection, Projection... others) {
      this.projection.add(projection);
      for (Projection other : others) {
        this.projection.add(other);
      }
      return self();
    }

    protected B clearGroupBy() {
      groupBy.clear();
      return self();
    }

    protected B groupBy(String property, String... others) {
      clearGroupBy();
      addGroupBy(property, others);
      return self();
    }

    protected B addGroupBy(String property, String... others) {
      this.groupBy.add(property);
      for (String other : others) {
        this.groupBy.add(other);
      }
      return self();
    }

    protected B mergeFrom(DatastoreV1.Query queryPb) {
      if (queryPb.getKindCount() > 0) {
        kind(queryPb.getKind(0).getName());
      }
      if (queryPb.hasStartCursor()) {
        startCursor(new Cursor(queryPb.getStartCursor()));
      }
      if (queryPb.hasEndCursor()) {
        endCursor(new Cursor(queryPb.getEndCursor()));
      }
      if (queryPb.hasOffset()) {
        offset(queryPb.getOffset());
      }
      if (queryPb.hasLimit()) {
        limit(queryPb.getLimit());
      }
      if (queryPb.hasFilter()) {
        filter(Filter.fromPb(queryPb.getFilter()));
      }
      for (DatastoreV1.PropertyOrder orderByPb : queryPb.getOrderList()) {
        addOrderBy(OrderBy.fromPb(orderByPb));
      }
      for (DatastoreV1.PropertyExpression projectionPb : queryPb.getProjectionList()) {
        addProjection(Projection.fromPb(projectionPb));
      }
      for (DatastoreV1.PropertyReference groupByPb : queryPb.getGroupByList()) {
        addGroupBy(groupByPb.getName());
      }
      return self();
    }

    public abstract StructuredQuery<T> build();
  }

  public static final class FullQueryBuilder extends BaseBuilder<Entity, FullQueryBuilder> {

    FullQueryBuilder() {
      super(ResultClass.full());
    }

    @Override
    public FullQuery build() {
      clearProjection();
      clearGroupBy();
      return new FullQuery(this);
    }
  }

  public static final class KeyOnlyQueryBuilder extends BaseBuilder<Key, KeyOnlyQueryBuilder> {

    public KeyOnlyQueryBuilder() {
      super(ResultClass.keyOnly());
    }

    @Override
    public KeyOnlyQuery build() {
      projection(Projection.property(KEY_PROPERTY_NAME));
      clearGroupBy();
      return new KeyOnlyQuery(this);
    }
  }

  public static final class ProjectionQueryBuilder
      extends BaseBuilder<PartialEntity, ProjectionQueryBuilder> {

    public ProjectionQueryBuilder() {
      super(ResultClass.projection());
    }

    @Override
    public ProjectionQuery build() {
      return new ProjectionQuery(this);
    }

    @Override
    public ProjectionQueryBuilder clearProjection() {
      return super.clearProjection();
    }

    @Override
    public ProjectionQueryBuilder projection(Projection projection, Projection... others) {
      return super.projection(projection, others);
    }

    @Override
    public ProjectionQueryBuilder addProjection(Projection projection, Projection... others) {
      return super.addProjection(projection, others);
    }

    @Override
    public ProjectionQueryBuilder clearGroupBy() {
      return super.clearGroupBy();
    }

    @Override
    public ProjectionQueryBuilder groupBy(String property, String... others) {
      return super.groupBy(property, others);
    }

    @Override
    public ProjectionQueryBuilder addGroupBy(String property, String... others) {
      return super.addGroupBy(property, others);
    }
  }

  public static final class FullQuery extends StructuredQuery<Entity> {

    private static final long serialVersionUID = -84461800292593840L;

    FullQuery(FullQueryBuilder builder) {
      super(builder);
    }
  }

  public static final class KeyOnlyQuery extends StructuredQuery<Key> {

    private static final long serialVersionUID = -7502917784216095473L;

    KeyOnlyQuery(KeyOnlyQueryBuilder builder) {
      super(builder);
    }
  }

  public static final class ProjectionQuery extends StructuredQuery<PartialEntity> {

    private static final long serialVersionUID = -3333183044486150649L;

    ProjectionQuery(ProjectionQueryBuilder builder) {
      super(builder);
      Preconditions.checkState(!keyOnly(),
          "Projection query can't project only '__key__', use KeyOnlyQuery instead.");
    }

    @Override
    public List<Projection> projection() {
      return super.projection();
    }

    @Override
    public List<String> groupBy() {
      return super.groupBy();
    }
  }

  StructuredQuery(BaseBuilder<T, ?> builder) {
    super(builder.resultClass, builder.namespace);
    kind = builder.kind;
    projection = ImmutableList.copyOf(builder.projection);
    filter = builder.filter;
    groupBy = ImmutableList.copyOf(builder.groupBy);
    orderBy = ImmutableList.copyOf(builder.orderBy);
    startCursor = builder.startCursor;
    endCursor = builder.endCursor;
    offset = builder.offset;
    limit = builder.limit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), kind, startCursor, endCursor, offset, limit, filter, orderBy,
        projection(), groupBy());
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
        && Objects.equals(orderBy, other.orderBy)
        && Objects.equals(projection, other.projection)
        && Objects.equals(groupBy, other.groupBy);

  }

  public String kind() {
    return kind;
  }

  protected boolean keyOnly() {
    return projection.size() == 1 && projection.get(0).property.equals(KEY_PROPERTY_NAME);
  }

  protected List<Projection> projection() {
    return projection;
  }

  public Filter filter() {
    return filter;
  }

  protected List<String> groupBy() {
    return groupBy;
  }

  public ImmutableList<OrderBy> orderBy() {
    return orderBy;
  }

  public Cursor startCursor() {
    return startCursor;
  }

  public Cursor endCursor() {
    return endCursor;
  }

  public Integer offset() {
    return offset;
  }

  public Integer limit() {
    return limit;
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb) {
    requestPb.setQuery(toPb());
  }

  @Override
  protected StructuredQuery<T> nextQuery(DatastoreV1.QueryResultBatch responsePb) {
    // TODO: implment
    throw new UnsupportedOperationException("paging not implemented yet");
  }

  @Override
  protected Object fromPb(ResultClass<T> resultClass, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultClass, namespace, DatastoreV1.Query.parseFrom(bytesPb));
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
    for (OrderBy value : orderBy) {
      queryPb.addOrder(value.toPb());
    }
    for (String value : groupBy) {
      queryPb.addGroupBy(DatastoreV1.PropertyReference.newBuilder().setName(value).build());
    }
    for (Projection value : projection) {
      queryPb.addProjection(value.toPb());
    }
    return queryPb.build();
  }

  static StructuredQuery<?> fromPb(ResultClass<?> resultClass, String namespace,
      DatastoreV1.Query queryPb) {
    BaseBuilder<?, ?> builder;
    if (resultClass.equals(ResultClass.full())) {
      builder = new FullQueryBuilder();
    } else if (resultClass.equals(ResultClass.keyOnly())) {
      builder = new KeyOnlyQueryBuilder();
    } else {
      builder = new ProjectionQueryBuilder();
    }
    return builder.namespace(namespace).mergeFrom(queryPb).build();
  }

  public static FullQueryBuilder builder() {
    return new FullQueryBuilder();
  }

  public static KeyOnlyQueryBuilder keyOnlyBuilder() {
    return new KeyOnlyQueryBuilder();
  }

  public static ProjectionQueryBuilder projectionBuilder() {
    return new ProjectionQueryBuilder();
  }
}
