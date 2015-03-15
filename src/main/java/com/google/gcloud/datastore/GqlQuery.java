/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
 * <pre>{@code
 *   Query&lt;Entity&gt; query =
 *       Query.gqlQueryBuilder(Query.ResultType.ENTITY, "select * from kind").build();
 *   QueryResults&lt;Entity&gt; results = datastore.run(query);
 *   while (results.hasNext()) {
 *     Entity entity = results.next();
 *     ...
 *   }
 * } </pre>
 *
 * <p>When the type of the results is unknown you can use this approach:
 * <pre>{@code
 *   Query&lt;?&gt; query = Query.gqlQueryBuilder("select __key__ from kind").build();
 *   QueryResults&lt;?&gt; results = datastore.run(query);
 *   if (Key.class.isAssignableFrom(results.resultClass())) {
 *     QueryResults&lt;Key&gt; keys = (QueryResults&lt;Key&gt;) results;
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
  private final transient ImmutableList<Binding> namedBindings;
  private final transient ImmutableList<Binding> positionalBindings;

  static final class Binding extends Serializable<DatastoreV1.GqlQueryArg> {

    private static final long serialVersionUID = 1976895435257636275L;

    private final transient String name;
    private final transient Cursor cursor;
    private final transient Value<?> value;

    Binding(String name, Cursor cursor) {
      this.name = name;
      this.cursor = checkNotNull(cursor);
      value = null;
    }

    Binding(String name, Value<?> value) {
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
      if (!(obj instanceof Binding)) {
        return false;
      }
      Binding other = (Binding) obj;
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

    static Binding fromPb(DatastoreV1.GqlQueryArg argPb) {
      String name = argPb.hasName() ? argPb.getName() : null;
      if (argPb.hasCursor()) {
        return new Binding(name, new Cursor(argPb.getCursor()));
      }
      return new Binding(name, Value.fromPb(argPb.getValue()));
    }
  }

  /**
   * A GQL query builder.
   */
  public static final class Builder<V> {

    private final ResultType<V> resultType;
    private String namespace;
    private String queryString;
    private boolean allowLiteral;
    private final Map<String, Binding> namedBindings = new TreeMap<>();
    private final List<Binding> positionalBindings = new LinkedList<>();

    Builder(ResultType<V> resultType, String query) {
      this.resultType = checkNotNull(resultType);
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

    public Builder<V> clearBindings() {
      namedBindings.clear();
      positionalBindings.clear();
      return this;
    }

    public Builder<V> setBinding(String name, Cursor cursor) {
      namedBindings.put(name, new Binding(name, cursor));
      return this;
    }

    public Builder<V> setBinding(String name, String... value) {
      namedBindings.put(name, toBinding(name, StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, long... value) {
      namedBindings.put(name, toBinding(name, LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, double... value) {
      namedBindings.put(name, toBinding(name, DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, boolean... value) {
      namedBindings.put(name, toBinding(name, BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, DateTime... value) {
      namedBindings.put(name, toBinding(name, DateTimeValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, Key... value) {
      namedBindings.put(name, toBinding(name, KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, FullEntity<?>... value) {
      namedBindings.put(name, toBinding(name, EntityValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> setBinding(String name, Blob... value) {
      namedBindings.put(name, toBinding(name, BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addBinding(Cursor cursor) {
      positionalBindings.add(new Binding(null, cursor));
      return this;
    }

    public Builder<V> addBinding(String... value) {
      positionalBindings.add(toBinding(StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addBinding(long... value) {
      positionalBindings.add(toBinding(LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    public Builder<V> addBinding(double... value) {
      positionalBindings.add(toBinding(DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    public Builder<V> addBinding(boolean... value) {
      positionalBindings.add(toBinding(BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    public Builder<V> addBinding(DateTime... value) {
      positionalBindings.add(toBinding(DateTimeValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addBinding(Key... value) {
      positionalBindings.add(toBinding(KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addBinding(FullEntity<?>... value) {
      positionalBindings.add(toBinding(EntityValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public Builder<V> addBinding(Blob... value) {
      positionalBindings.add(toBinding(BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public GqlQuery<V> build() {
      return new GqlQuery<>(this);
    }

    @SuppressWarnings("rawtypes")
    private static Binding toBinding(Value.BuilderFactory builderFactory, List<?> values) {
      return toBinding(null, builderFactory, values);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static Binding toBinding(String name, Value.BuilderFactory builderFactory,
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
      return new Binding(name, value);
    }
  }

  private GqlQuery(Builder<V> builder) {
    super(builder.resultType, builder.namespace);
    queryString = builder.queryString;
    allowLiteral = builder.allowLiteral;
    namedBindings = ImmutableList.copyOf(builder.namedBindings.values());
    positionalBindings = ImmutableList.copyOf(builder.positionalBindings);
  }

  public String queryString() {
    return queryString;
  }

  public boolean allowLiteral() {
    return allowLiteral;
  }

  /**
   * Returns an immutable map of named bindings.
   */
  public Map<String, Object> namedBindings() {
    ImmutableMap.Builder<String, Object> builder = ImmutableSortedMap.naturalOrder();
    for (Binding binding : namedBindings) {
      builder.put(binding.name(), binding.cursorOrValue());
    }
    return builder.build();
  }

  /**
   * Returns an immutable list of positional bindings (using original order).
   */
  public List<Object> numberArgs() {
    ImmutableList.Builder<Object> builder = ImmutableList.builder();
    for (Binding binding : positionalBindings) {
      builder.add(binding.cursorOrValue());
    }
    return builder.build();
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), queryString, allowLiteral, namedBindings, positionalBindings);
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
        && Objects.equals(namedBindings,  other.namedBindings)
        && Objects.equals(positionalBindings,  other.positionalBindings);
  }

  @Override
  protected DatastoreV1.GqlQuery toPb() {
    DatastoreV1.GqlQuery.Builder queryPb = DatastoreV1.GqlQuery.newBuilder();
    queryPb.setQueryString(queryString);
    queryPb.setAllowLiteral(allowLiteral);
    for (Binding argument : namedBindings) {
      queryPb.addNameArg(argument.toPb());
    }
    for (Binding argument : positionalBindings) {
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
    // See issue #17
    throw new UnsupportedOperationException("paging for this query is not implemented yet");
  }

  @Override
  protected Object fromPb(ResultType<V> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, DatastoreV1.GqlQuery.parseFrom(bytesPb));
  }

  private static <V> GqlQuery<V> fromPb(ResultType<V> resultType, String ns, DatastoreV1.GqlQuery queryPb) {
    Builder<V> builder = new Builder<>(resultType, queryPb.getQueryString());
    builder.namespace(ns);
    if (queryPb.hasAllowLiteral()) {
      builder.allowLiteral = queryPb.getAllowLiteral();
    }
    for (DatastoreV1.GqlQueryArg nameArg : queryPb.getNameArgList()) {
      Binding argument = Binding.fromPb(nameArg);
      builder.namedBindings.put(argument.name(), argument);
    }
    for (DatastoreV1.GqlQueryArg numberArg : queryPb.getNumberArgList()) {
      Binding argument = Binding.fromPb(numberArg);
      builder.positionalBindings.add(argument);
    }
    return builder.build();
  }

}
