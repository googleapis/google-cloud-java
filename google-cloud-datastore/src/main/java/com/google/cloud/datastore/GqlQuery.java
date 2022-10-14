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

import static com.google.cloud.datastore.Validator.validateNamespace;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import io.grpc.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * A Google Cloud Datastore GQL query.
 *
 * <h3>A usage example:</h3>
 *
 * <p>When the type of the results is known the preferred usage would be:
 *
 * <pre>{@code
 * Query<Entity> query =
 *     Query.newGqlQueryBuilder(Query.ResultType.ENTITY, "select * from kind").build();
 * QueryResults<Entity> results = datastore.run(query);
 * while (results.hasNext()) {
 *   Entity entity = results.next();
 *   ...
 * }
 * }</pre>
 *
 * <p>When the type of the results is unknown you can use this approach:
 *
 * <pre>{@code
 * Query<?> query = Query.newGqlQueryBuilder("select __key__ from kind").build();
 * QueryResults<?> results = datastore.run(query);
 * if (Key.class.isAssignableFrom(results.getResultClass())) {
 *   QueryResults<Key> keys = (QueryResults<Key>) results;
 *   while (keys.hasNext()) {
 *     Key key = keys.next();
 *     ...
 *   }
 * }
 * }</pre>
 *
 * @param <V> the type of the result values this query will produce
 * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
 */
public final class GqlQuery<V> extends Query<V> implements RecordQuery<V> {

  private static final long serialVersionUID = -5514894742849230793L;

  private final String queryString;
  private final boolean allowLiteral;
  private final ImmutableMap<String, Binding> namedBindings;
  private final ImmutableList<Binding> positionalBindings;

  private final ResultType<V> resultType;

  static final class Binding implements Serializable {

    private static final long serialVersionUID = 2344746877591371548L;

    private final Cursor cursor;
    private final Value<?> value;

    Binding(Cursor cursor) {
      this.cursor = checkNotNull(cursor);
      value = null;
    }

    Binding(Value<?> value) {
      this.value = checkNotNull(value);
      cursor = null;
    }

    Object getCursorOrValue() {
      return MoreObjects.firstNonNull(cursor, value);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("cursor", cursor).add("value", value).toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(cursor, value);
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
      return Objects.equals(cursor, other.cursor) && Objects.equals(value, other.value);
    }

    com.google.datastore.v1.GqlQueryParameter toPb() {
      com.google.datastore.v1.GqlQueryParameter.Builder argPb =
          com.google.datastore.v1.GqlQueryParameter.newBuilder();
      if (cursor != null) {
        argPb.setCursor(cursor.getByteString());
      }
      if (value != null) {
        argPb.setValue(value.toPb());
      }
      return argPb.build();
    }

    static Binding fromPb(com.google.datastore.v1.GqlQueryParameter argPb) {
      switch (argPb.getParameterTypeCase()) {
        case CURSOR:
          return new Binding(new Cursor(argPb.getCursor()));
        case VALUE:
          return new Binding(Value.fromPb(argPb.getValue()));
        default:
          throw new AssertionError("Unexpected enum value " + argPb.getParameterTypeCase());
      }
    }
  }

  /** A GQL query builder. */
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

    /** Sets the GQL query. */
    public Builder<V> setQuery(String query) {
      queryString = checkNotNull(query);
      return this;
    }

    /** Sets the namespace for the GQL query. */
    public Builder<V> setNamespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    /**
     * Sets whether the query string can contain literals. When {@code false}, the query string must
     * not contain any literals and instead must bind all values.
     */
    public Builder<V> setAllowLiteral(boolean allowLiteral) {
      this.allowLiteral = allowLiteral;
      return this;
    }

    public Builder<V> clearBindings() {
      namedBindings.clear();
      positionalBindings.clear();
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param cursor a {@link Cursor} object that binds to a given name
     */
    public Builder<V> setBinding(String name, Cursor cursor) {
      namedBindings.put(name, new Binding(cursor));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a String object or a list of String objects that binds to a given name
     */
    public Builder<V> setBinding(String name, String... value) {
      namedBindings.put(name, toBinding(StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a long value or a list of long values that binds to a given name
     */
    public Builder<V> setBinding(String name, long... value) {
      namedBindings.put(name, toBinding(LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a double value or a list of double values that binds to a given name
     */
    public Builder<V> setBinding(String name, double... value) {
      namedBindings.put(name, toBinding(DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a boolean value or a list of boolean values that binds to a given name
     */
    public Builder<V> setBinding(String name, boolean... value) {
      namedBindings.put(name, toBinding(BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a {@link Timestamp} object or a list of {@link Timestamp} objects that binds to
     *     a given name
     */
    public Builder<V> setBinding(String name, Timestamp... value) {
      namedBindings.put(name, toBinding(TimestampValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a {@link Key} object or a list of {@link Key} objects that binds to a given name
     */
    public Builder<V> setBinding(String name, Key... value) {
      namedBindings.put(name, toBinding(KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a {@link FullEntity} object or a list of {@link FullEntity} objects that binds
     *     to a given name
     */
    @Deprecated
    public Builder<V> setBinding(String name, FullEntity<?>... value) {
      throw new DatastoreException(
          Status.Code.UNIMPLEMENTED.value(), "Binding entities is not supported.", "UNIMPLEMENTED");
    }

    /**
     * Sets a new named binding.
     *
     * @param name name of the binding
     * @param value a {@link Blob} object or list of {@link Blob} objects that binds to a given name
     */
    public Builder<V> setBinding(String name, Blob... value) {
      namedBindings.put(name, toBinding(BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new named binding with null value.
     *
     * @param name of the binding
     */
    public Builder<V> setNullBinding(String name) {
      namedBindings.put(name, toBinding(NullValue.MARSHALLER, new ArrayList()));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param cursor a {@link Cursor} object to be set as a new positional binding
     */
    public Builder<V> addBinding(Cursor cursor) {
      positionalBindings.add(new Binding(cursor));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a String object or a list of String objects to be set as a new positional
     *     binding
     */
    public Builder<V> addBinding(String... value) {
      positionalBindings.add(toBinding(StringValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a long value or a list of long values to be set as a new positional binding
     */
    public Builder<V> addBinding(long... value) {
      positionalBindings.add(toBinding(LongValue.MARSHALLER, Longs.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a double value or a list of double values to be set as a new positional binding
     */
    public Builder<V> addBinding(double... value) {
      positionalBindings.add(toBinding(DoubleValue.MARSHALLER, Doubles.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a boolean value or a list of boolean values to be set as a new positional
     *     binding
     */
    public Builder<V> addBinding(boolean... value) {
      positionalBindings.add(toBinding(BooleanValue.MARSHALLER, Booleans.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a {@link Timestamp} object or a list of {@link Timestamp} objects to be set as a
     *     new positional binding
     */
    public Builder<V> addBinding(Timestamp... value) {
      positionalBindings.add(toBinding(TimestampValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a {@link Key} object or a list of {@link Key} objects to be set as a new
     *     positional binding
     */
    public Builder<V> addBinding(Key... value) {
      positionalBindings.add(toBinding(KeyValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a {@link FullEntity} object or a list of {@link FullEntity} objects to be set as
     *     a new positional binding
     */
    @Deprecated
    public Builder<V> addBinding(FullEntity<?>... value) {
      throw new DatastoreException(
          Status.Code.UNIMPLEMENTED.value(), "Binding entities is not supported.", "UNIMPLEMENTED");
    }

    /**
     * Sets a new positional binding.
     *
     * @param value a {@link Blob} object or a list of {@link Blob} objects to be set as a new
     *     positional binding
     */
    public Builder<V> addBinding(Blob... value) {
      positionalBindings.add(toBinding(BlobValue.MARSHALLER, Arrays.asList(value)));
      return this;
    }

    public GqlQuery<V> build() {
      return new GqlQuery<>(this);
    }

    private static <V> Binding toBinding(
        Value.BuilderFactory<V, ?, ?> builderFactory, List<?> values) {
      List<Value<V>> list = new ArrayList<>(values.size());
      for (Object object : values) {
        @SuppressWarnings("unchecked")
        V v = (V) object;
        list.add(builderFactory.newBuilder(v).build());
      }
      Value<?> value;
      if (list.isEmpty()) {
        value = new NullValue();
      } else if (list.size() == 1) {
        value = list.get(0);
      } else {
        value = new ListValue(list);
      }
      return new Binding(value);
    }
  }

  private GqlQuery(Builder<V> builder) {
    super(builder.namespace);
    resultType = checkNotNull(builder.resultType);
    queryString = builder.queryString;
    allowLiteral = builder.allowLiteral;
    namedBindings = ImmutableMap.copyOf(builder.namedBindings);
    positionalBindings = ImmutableList.copyOf(builder.positionalBindings);
  }

  /** Returns the query string for this query. */
  public String getQueryString() {
    return queryString;
  }

  /**
   * Returns whether the query string can contain literals. When {@code false}, the query string
   * must not contain any literals and instead must bind all values.
   */
  public boolean allowLiteral() {
    return allowLiteral;
  }

  /** Returns an immutable map of named bindings. */
  public Map<String, Object> getNamedBindings() {
    ImmutableMap.Builder<String, Object> builder = ImmutableSortedMap.naturalOrder();
    for (Map.Entry<String, Binding> binding : namedBindings.entrySet()) {
      builder.put(binding.getKey(), binding.getValue().getCursorOrValue());
    }
    return builder.buildOrThrow();
  }

  @InternalApi
  public Map<String, Binding> getNamedBindingsMap() {
    return namedBindings;
  }

  @InternalApi
  public List<Binding> getPositionalBindingsMap() {
    return positionalBindings;
  }

  /** Returns an immutable list of positional bindings (using original order). */
  public List<Object> getNumberArgs() {
    ImmutableList.Builder<Object> builder = ImmutableList.builder();
    for (Binding binding : positionalBindings) {
      builder.add(binding.getCursorOrValue());
    }
    return builder.build();
  }

  @Override
  public ResultType<V> getType() {
    return resultType;
  }

  @Override
  public String toString() {
    return toStringHelper()
        .add("type", getType())
        .add("queryString", queryString)
        .add("allowLiteral", allowLiteral)
        .add("namedBindings", namedBindings)
        .add("positionalBindings", positionalBindings)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getNamespace(), queryString, allowLiteral, namedBindings, positionalBindings);
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
    return Objects.equals(getNamespace(), other.getNamespace())
        && Objects.equals(queryString, other.queryString)
        && allowLiteral == other.allowLiteral
        && Objects.equals(namedBindings, other.namedBindings)
        && Objects.equals(positionalBindings, other.positionalBindings);
  }

  com.google.datastore.v1.GqlQuery toPb() {
    GqlQueryProtoPreparer protoPreparer = new GqlQueryProtoPreparer();
    return protoPreparer.prepare(this);
  }

  @InternalApi
  @Override
  public void populatePb(com.google.datastore.v1.RunQueryRequest.Builder requestPb) {
    requestPb.setGqlQuery(toPb());
  }

  @InternalApi
  @Override
  public RecordQuery<V> nextQuery(com.google.datastore.v1.RunQueryResponse responsePb) {
    return StructuredQuery.<V>fromPb(getType(), getNamespace(), responsePb.getQuery())
        .nextQuery(responsePb);
  }
}
