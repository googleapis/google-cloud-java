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

package com.google.cloud.datastore;

import static com.google.cloud.datastore.BlobValue.of;
import static com.google.cloud.datastore.BooleanValue.of;
import static com.google.cloud.datastore.DateTimeValue.of;
import static com.google.cloud.datastore.DoubleValue.of;
import static com.google.cloud.datastore.EntityValue.of;
import static com.google.cloud.datastore.KeyValue.of;
import static com.google.cloud.datastore.LatLngValue.of;
import static com.google.cloud.datastore.ListValue.of;
import static com.google.cloud.datastore.LongValue.of;
import static com.google.cloud.datastore.NullValue.of;
import static com.google.cloud.datastore.StringValue.of;

import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A base class for entities (key and properties).
 * An entity is a Google Cloud Datastore persistent data object.
 * An entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link com.google.cloud.datastore.Value}), and may be associated with a
 * key. For a list of possible values see {@link ValueType}.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public abstract class BaseEntity<K extends IncompleteKey>
    extends Serializable<com.google.datastore.v1beta3.Entity> {

  private static final long serialVersionUID = 8175618724683792766L;

  private final transient ImmutableSortedMap<String, Value<?>> properties;
  private final K key;

  public abstract static class Builder<K extends IncompleteKey, B extends Builder<K, B>> {

    private K key;
    private final Map<String, Value<?>> properties = new HashMap<>();

    Builder() {
    }

    Builder(K key) {
      key(key);
    }

    Builder(BaseEntity<K> entity) {
      this(entity.key, entity);
    }

    Builder(K key, BaseEntity<?> entity) {
      key(key);
      properties(entity.properties);
    }

    protected K key() {
      return key;
    }

    protected Map<String, Value<?>> properties() {
      return properties;
    }

    @SuppressWarnings("unchecked")
    private B self() {
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    B fill(com.google.datastore.v1beta3.Entity entityPb) {
      Map<String, Value<?>> copiedProperties = Maps.newHashMap();
      for (Map.Entry<String, com.google.datastore.v1beta3.Value> entry :
        entityPb.getProperties().entrySet()) {
        copiedProperties.put(entry.getKey(), Value.fromPb(entry.getValue()));
      }
      properties(copiedProperties);
      if (entityPb.hasKey()) {
        key((K) IncompleteKey.fromPb(entityPb.getKey()));
      }
      return self();
    }

    protected B properties(Map<String, Value<?>> properties) {
      this.properties.putAll(properties);
      return self();
    }

    public B key(K key) {
      this.key = key;
      return self();
    }

    /**
     * Clears all the properties.
     */
    public B clear() {
      properties.clear();
      return self();
    }

    /**
     * Removes a property with the given {@code name}.
     */
    public B remove(String name) {
      properties.remove(name);
      return self();
    }

    /**
     * Sets a property.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, Value<?> value) {
      properties.put(name, value);
      return self();
    }

    /**
     * Sets a property of type {@link StringValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, String value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link StringValue}.
     *
     * @param name name of the property
     * @param first the first string in the list
     * @param second the second string in the list
     * @param others other strings in the list
     */
    public B set(String name, String first, String second, String... others) {
      List<StringValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (String other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link LongValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, long value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link LongValue}.
     *
     * @param name name of the property
     * @param first the first long in the list
     * @param second the second long in the list
     * @param others other longs in the list
     */
    public B set(String name, long first, long second, long... others) {
      List<LongValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (long other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link DoubleValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, double value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link DoubleValue}.
     *
     * @param name name of the property
     * @param first the first double in the list
     * @param second the second double in the list
     * @param others other doubles in the list
     */
    public B set(String name, double first, double second, double... others) {
      List<DoubleValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (double other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link BooleanValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, boolean value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link BooleanValue}.
     *
     * @param name name of the property
     * @param first the first boolean in the list
     * @param second the second boolean in the list
     * @param others other booleans in the list
     */
    public B set(String name, boolean first, boolean second, boolean... others) {
      List<BooleanValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (boolean other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link DateTimeValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, DateTime value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link DateTimeValue}.
     *
     * @param name name of the property
     * @param first the first {@link DateTime} in the list
     * @param second the second {@link DateTime} in the list
     * @param others other {@link DateTime}s in the list
     */
    public B set(String name, DateTime first, DateTime second, DateTime... others) {
      List<DateTimeValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (DateTime other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link LatLng}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, LatLng value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link LatLng}.
     *
     * @param name name of the property
     * @param first the first {@link LatLng} in the list
     * @param second the second {@link LatLng} in the list
     * @param others other {@link LatLng}s in the list
     */
    public B set(String name, LatLng first, LatLng second, LatLng... others) {
      List<LatLngValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (LatLng other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link KeyValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, Key value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link KeyValue}.
     *
     * @param name name of the property
     * @param first the first {@link Key} in the list
     * @param second the second {@link Key} in the list
     * @param others other {@link Key}s in the list
     */
    public B set(String name, Key first, Key second, Key... others) {
      List<KeyValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (Key other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link EntityValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, FullEntity<?> value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link EntityValue}.
     *
     * @param name name of the property
     * @param first the first {@link FullEntity} in the list
     * @param second the second {@link FullEntity} in the list
     * @param others other entities in the list
     */
    public B set(String name, FullEntity<?> first, FullEntity<?> second, FullEntity<?>... others) {
      List<EntityValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (FullEntity<?> other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link ListValue}.
     *
     * @param name name of the property
     * @param values list of values associated with the property
     */
    public B set(String name, List<? extends Value<?>> values) {
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@link ListValue}.
     *
     * @param name name of the property
     * @param first the first value in the list
     * @param second the second value in the list
     * @param others other values in the list
     */
    public B set(String name, Value<?> first, Value<?> second, Value<?>... others) {
      properties.put(name, ListValue.builder().addValue(first).addValue(second, others).build());
      return self();
    }

    /**
     * Sets a property of type {@link BlobValue}.
     *
     * @param name name of the property
     * @param value value associated with the property
     */
    public B set(String name, Blob value) {
      properties.put(name, of(value));
      return self();
    }

    /**
     * Sets a list property containing elements of type {@link BlobValue}.
     *
     * @param name name of the property
     * @param first the first {@link Blob} in the list
     * @param second the second {@link Blob} in the list
     * @param others other {@link Blob}s in the list
     */
    public B set(String name, Blob first, Blob second, Blob... others) {
      List<BlobValue> values = new LinkedList<>();
      values.add(of(first));
      values.add(of(second));
      for (Blob other : others) {
        values.add(of(other));
      }
      properties.put(name, of(values));
      return self();
    }

    /**
     * Sets a property of type {@code NullValue}.
     *
     * @param name name of the property
     */
    public B setNull(String name) {
      properties.put(name, of());
      return self();
    }

    public abstract BaseEntity<K> build();
  }

  BaseEntity(Builder<K, ?> builder) {
    this.key = builder.key;
    this.properties = ImmutableSortedMap.copyOf(builder.properties);
  }

  BaseEntity(BaseEntity<K> from) {
    this.key = from.key();
    this.properties = from.properties;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, properties);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof BaseEntity)) {
      return false;
    }
    BaseEntity<?> other = (BaseEntity<?>) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties, other.properties);
  }

  /**
   * Returns true if entity has a non-null key.
   */
  public boolean hasKey() {
    return key != null;
  }

  /**
   * Returns the associated key or null if it does not have one.
   */
  public K key() {
    return key;
  }

  /**
   * Returns {@code true} if the entity contains a property with the given {@code name}.
   */
  public boolean contains(String name) {
    return properties.containsKey(name);
  }

  /**
   * Returns the {@link Value} for the given property {@code name}.
   *
   * @throws DatastoreException if not such property
   */
  public <V extends Value<?>> V getValue(String name) {
    @SuppressWarnings("unchecked")
    V property = (V) properties.get(name);
    if (property == null) {
      throw DatastoreException.throwInvalidRequest("No such property %s", name);
    }
    return property;
  }

  /**
   * Returns true if property is an instance of NullValue.
   *
   * @throws DatastoreException if not such property
   */
  public boolean isNull(String name) {
    return getValue(name) instanceof NullValue;
  }


  /**
   * Returns the property value as a string.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a string
   */
  @SuppressWarnings("unchecked")
  public String getString(String name) {
    return ((Value<String>) getValue(name)).get();
  }

  /**
   * Returns the property value as long.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a long
   */
  @SuppressWarnings("unchecked")
  public long getLong(String name) {
    return ((Value<Long>) getValue(name)).get();
  }

  /**
   * Returns the property value as a double.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a double
   */
  @SuppressWarnings("unchecked")
  public double getDouble(String name) {
    return ((Value<Double>) getValue(name)).get();
  }

  /**
   * Returns the property value as a boolean.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a boolean
   */
  @SuppressWarnings("unchecked")
  public boolean getBoolean(String name) {
    return ((Value<Boolean>) getValue(name)).get();
  }

  /**
   * Returns the property value as a DateTime.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a DateTime
   */
  @SuppressWarnings("unchecked")
  public DateTime getDateTime(String name) {
    return ((Value<DateTime>) getValue(name)).get();
  }

  /**
   * Returns the property value as a LatLng.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a LatLng.
   */
  @SuppressWarnings("unchecked")
  public LatLng getLatLng(String name) {
    return ((Value<LatLng>) getValue(name)).get();
  }

  /**
   * Returns the property value as a Key.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a Key
   */
  @SuppressWarnings("unchecked")
  public Key getKey(String name) {
    return ((Value<Key>) getValue(name)).get();
  }

  /**
   * Returns the property value as an entity.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not an entity
   */
  @SuppressWarnings("unchecked")
  public <K extends IncompleteKey> FullEntity<K> getEntity(String name) {
    return ((Value<FullEntity<K>>) getValue(name)).get();
  }

  /**
   * Returns the property value as a list of values.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a list of values
   */
  @SuppressWarnings("unchecked")
  public <T extends Value<?>> List<T> getList(String name) {
    return (List<T>) getValue(name).get();
  }

  /**
   * Returns the property value as a blob.
   *
   * @throws DatastoreException if not such property
   * @throws ClassCastException if value is not a blob
   */
  @SuppressWarnings("unchecked")
  public Blob getBlob(String name) {
    return ((Value<Blob>) getValue(name)).get();
  }

  /**
   * Returns the properties name.
   */
  public Set<String> names() {
    return properties.keySet();
  }

  ImmutableSortedMap<String, Value<?>> properties() {
    return properties;
  }

  @Override
  Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    Builder<?, ?> builder = emptyBuilder();
    builder.fill(com.google.datastore.v1beta3.Entity.parseFrom(bytesPb));
    return builder.build();
  }

  protected abstract Builder<?, ?> emptyBuilder();

  @Override
  final com.google.datastore.v1beta3.Entity toPb() {
    com.google.datastore.v1beta3.Entity.Builder entityPb =
        com.google.datastore.v1beta3.Entity.newBuilder();
    Map<String, com.google.datastore.v1beta3.Value> propertiesPb = entityPb.getMutableProperties();
    for (Map.Entry<String, Value<?>> entry : properties.entrySet()) {
      propertiesPb.put(entry.getKey(), entry.getValue().toPb());
    }
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
    return entityPb.build();
  }
}
