package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.datastore.Validator.validateNamespace;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * A Google Cloud Datastore GQL.
 *
 * <h3>A usage example:</h3>
 *
 * <p>When the type of the results is known the preferred usage would be:
 * <pre> {@code
 *   Query<Entity> query = GqlQuery.builder(ResultClass.full(), "select * from kind").build();
 *   QueryResult<Entity> results = datastore.run(query);
 *   while (results.hasNext()) {
 *     Entity entity = results.next();
 *     ...
 *   }
 * } </pre>
 *
 * <p>When the type of the results is unknown you can use this approach:
 * <pre> {@code
 *   Query<?> query = GqlQuery.builder("select __key__ from kind").build();
 *   QueryResult<?> results = datastore.run(query);
 *   if (Key.class.isAssignableFrom(results.resultClass())) {
 *     QueryResult<Key> keys = (QueryResult<Key>) results;
 *     while (keys.hasNext()) {
 *       Key key = keys.next();
 *       ...
 *     }
 *   }
 * } </pre>
 *
 * @param <V> the type of the result values this query will produce
 * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
 */
public final class GqlQuery<V> extends Query<V> {

  private static final long serialVersionUID = 5988280590929540569L;

  private final transient String queryString;
  private final transient boolean allowLiteral;
  private final transient ImmutableList<Argument> nameArgs;
  private final transient ImmutableList<Argument> numberArgs;

  static final class Argument extends Serializable<DatastoreV1.GqlQueryArg> {

    private static final long serialVersionUID = 1976895435257636275L;

    private final transient String name;
    private final transient Cursor cursor;
    private final transient Value<?> value;

    Argument(String name, Cursor cursor) {
      this.name = name;
      this.cursor = checkNotNull(cursor);
      value = null;
    }

    Argument(String name, Value<?> value) {
      this.name = name;
      this.value = checkNotNull(value);
      cursor = null;
    }

    Object cursorOrValue() {
      return MoreObjects.firstNonNull(cursor, value);
    }

    String name() {
      return name;
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, cursor, value);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Argument)) {
        return false;
      }
      Argument other = (Argument) obj;
      return Objects.equals(name, other.name)
        && Objects.equals(cursor, other.cursor)
        && Objects.equals(value, other.value);
    }

    @Override
    protected DatastoreV1.GqlQueryArg toPb() {
      DatastoreV1.GqlQueryArg.Builder argPb = DatastoreV1.GqlQueryArg.newBuilder();
      if (name != null) {
        argPb.setName(name);
      }
      if (cursor != null) {
        argPb.setCursor(cursor.byteString());
      }
      if (value != null) {
        argPb.setValue(value.toPb());
      }
      return argPb.build();
    }

    @Override
    protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
      return fromPb(DatastoreV1.GqlQueryArg.parseFrom(bytesPb));
    }

    static Argument fromPb(DatastoreV1.GqlQueryArg argPb) {
      String name = argPb.hasName() ? argPb.getName() : null;
      if (argPb.hasCursor()) {
        return new Argument(name, new Cursor(argPb.getCursor()));
      }
      return new Argument(name, Value.fromPb(argPb.getValue()));
    }
  }

  /**
   * A GQL query builder.
   */
  public static final class Builder<V> {

    private final ResultClass<V> resultClass;
    private String namespace;
    private String queryString;
    private boolean allowLiteral;
    private Map<String, Argument> nameArgs = new TreeMap<>();
    private List<Argument> numberArgs = new LinkedList<>();

    Builder(ResultClass<V> resultClass, String query) {
      this.resultClass = checkNotNull(resultClass);
      queryString = checkNotNull(query);
    }

    public Builder<V> query(String query) {
      queryString = checkNotNull(query);
      return this;
    }

    public Builder<V> namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    public Builder<V> allowLiteral(boolean allowLiteral) {
      this.allowLiteral = allowLiteral;
      return this;
    }

    public Builder<V> clearArguments() {
      nameArgs.clear();
      numberArgs.clear();
      return this;
    }

    public Builder<V> setArgument(String name, Cursor cursor) {
      nameArgs.put(name, new Argument(name, cursor));
      return this;
    }

    public Builder<V> setArgument(String name, String... value) {
      nameArgs.put(name, toArgument(name, StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, long... value) {
      nameArgs.put(name, toArgument(name, LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, double... value) {
      nameArgs.put(name, toArgument(name, DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, boolean... value) {
      nameArgs.put(name, toArgument(name, BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, DateTime... value) {
      nameArgs.put(name, toArgument(name, DateTimeValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, Key... value) {
      nameArgs.put(name, toArgument(name, KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, PartialEntity... value) {
      nameArgs.put(name, toArgument(name, EntityValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setArgument(String name, Blob... value) {
      nameArgs.put(name, toArgument(name, BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addArgument(Cursor cursor) {
      numberArgs.add(new Argument(null, cursor));
      return this;
    }

    public Builder<V> addArgument(String... value) {
      numberArgs.add(toArgument(StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addArgument(long... value) {
      numberArgs.add(toArgument(LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    public Builder<V> addArgument(double... value) {
      numberArgs.add(toArgument(DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    public Builder<V> addArgument(boolean... value) {
      numberArgs.add(toArgument(BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    public Builder<V> addArgument(DateTime... value) {
      numberArgs.add(toArgument(DateTimeValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addArgument(Key... value) {
      numberArgs.add(toArgument(KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addArgument(PartialEntity... value) {
      numberArgs.add(toArgument(EntityValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addArgument(Blob... value) {
      numberArgs.add(toArgument(BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public GqlQuery<V> build() {
      return new GqlQuery<>(this);
    }

    @SuppressWarnings("rawtypes")
    private static Argument toArgument(Value.BuilderFactory builderFactory, List<?> values) {
      return toArgument(null, builderFactory, values);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static Argument toArgument(String name, Value.BuilderFactory builderFactory,
        List<?> values) {
      List<Value<?>> list = new ArrayList<>(values.size());
      for (Object object : values) {
        list.add(builderFactory.newBuilder(object).build());
      }
      Value<?> value;
      if (list.isEmpty()) {
        value = new NullValue();
      } else if (list.size() == 1) {
        value = list.get(0);
      } else {
        value = new ListValue(list);
      }
      return new Argument(name, value);
    }
  }

  private GqlQuery(Builder<V> builder) {
    super(builder.resultClass, builder.namespace);
    queryString = builder.queryString;
    allowLiteral = builder.allowLiteral;
    nameArgs = ImmutableList.copyOf(builder.nameArgs.values());
    numberArgs = ImmutableList.copyOf(builder.numberArgs);
  }

  public String queryString() {
    return queryString;
  }

  public boolean allowLiteral() {
    return allowLiteral;
  }

  /**
   * Returns an immutable map of named arguments.
   */
  public Map<String, Object> nameArgs() {
    ImmutableMap.Builder<String, Object> builder = ImmutableSortedMap.naturalOrder();
    for (Argument argument : nameArgs) {
      builder.put(argument.name(), argument.cursorOrValue());
    }
    return builder.build();
  }

  /**
   * Returns an immutable list of numbered arguments (using original order).
   */
  public List<Object> numberArgs() {
    ImmutableList.Builder<Object> builder = ImmutableList.builder();
    for (Argument argument : numberArgs) {
      builder.add(argument.cursorOrValue());
    }
    return builder.build();
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), queryString, allowLiteral, nameArgs, numberArgs);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof GqlQuery)) {
      return false;
    }
    GqlQuery<?> other = (GqlQuery<?>) obj;
    return Objects.equals(namespace(), other.namespace())
        && Objects.equals(queryString, other.queryString)
        && allowLiteral == other.allowLiteral
        && Objects.equals(nameArgs,  other.nameArgs)
        && Objects.equals(numberArgs,  other.numberArgs);
  }

  @Override
  protected DatastoreV1.GqlQuery toPb() {
    DatastoreV1.GqlQuery.Builder queryPb = DatastoreV1.GqlQuery.newBuilder();
    queryPb.setQueryString(queryString);
    queryPb.setAllowLiteral(allowLiteral);
    for (Argument argument : nameArgs) {
      queryPb.addNameArg(argument.toPb());
    }
    for (Argument argument : numberArgs) {
      queryPb.addNumberArg(argument.toPb());
    }
    return queryPb.build();
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb) {
    requestPb.setGqlQuery(toPb());
  }

  @Override
  protected GqlQuery<V> nextQuery(DatastoreV1.QueryResultBatch responsePb) {
    // See b/18705483
    throw new UnsupportedOperationException("paging for this query is not implemented yet");
  }

  @Override
  protected Object fromPb(ResultClass<V> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, DatastoreV1.GqlQuery.parseFrom(bytesPb));
  }

  static <V> GqlQuery<V> fromPb(ResultClass<V> resultType, String namespace,
      DatastoreV1.GqlQuery queryPb) {
    Builder<V> builder = new Builder<>(resultType, queryPb.getQueryString());
    builder.namespace(namespace);
    if (queryPb.hasAllowLiteral()) {
      builder.allowLiteral = queryPb.getAllowLiteral();
    }
    for (DatastoreV1.GqlQueryArg nameArg : queryPb.getNameArgList()) {
      Argument argument = Argument.fromPb(nameArg);
      builder.nameArgs.put(argument.name(), argument);
    }
    for (DatastoreV1.GqlQueryArg numberArg : queryPb.getNumberArgList()) {
      Argument argument = Argument.fromPb(numberArg);
      builder.numberArgs.add(argument);
    }
    return builder.build();
  }

  /**
   * Returns a new GQL query builder.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
   */
  public static GqlQuery.Builder<?> builder(String gql) {
    return builder(ResultClass.unknown(), gql);
  }

  /**
   * Returns a new GQL query builder.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
   */
  public static <V> GqlQuery.Builder<V> builder(ResultClass<V> resultClass, String gql) {
    return new GqlQuery.Builder<>(resultClass, gql);
  }
}
