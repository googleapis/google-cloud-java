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

import static com.google.gcloud.datastore.BlobValue.of;
import static com.google.gcloud.datastore.BooleanValue.of;
import static com.google.gcloud.datastore.DateTimeValue.of;
import static com.google.gcloud.datastore.DoubleValue.of;
import static com.google.gcloud.datastore.EntityValue.of;
import static com.google.gcloud.datastore.KeyValue.of;
import static com.google.gcloud.datastore.ListValue.of;
import static com.google.gcloud.datastore.LongValue.of;
import static com.google.gcloud.datastore.NullValue.of;
import static com.google.gcloud.datastore.StringValue.of;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A base class for entities (key and properties).
 * An entity is a Google Cloud Datastore persistent data object.
 * An entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link com.google.gcloud.datastore.Value}), and may be associated with a
 * key. For a list of possible values see {@link ValueType}.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public abstract class BaseEntity<K extends IncompleteKey> extends Serializable<DatastoreV1.Entity> {

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
    protected B fill(DatastoreV1.Entity entityPb) {
      Map<String, Value<?>> copiedProperties = Maps.newHashMap();
      for (DatastoreV1.Property property : entityPb.getPropertyList()) {
        copiedProperties.put(property.getName(), Value.fromPb(property.getValue()));
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

    public B set(String name, Value<?> value) {
      properties.put(name, value);
      return self();
    }

    public B set(String name, String value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, long value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, double value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, boolean value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, DateTime value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, Key value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, FullEntity<?> value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, List<? extends Value<?>> values) {
      properties.put(name, of(values));
      return self();
    }

    public B set(String name, Value<?> value, Value<?>... other) {
      properties.put(name, of(value, other));
      return self();
    }

    public B set(String name, Blob value) {
      properties.put(name, of(value));
      return self();
    }

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
   * @throws DatastoreException if not such property.
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
   * @throws DatastoreException if not such property.
   */
  public boolean isNull(String name) {
    return getValue(name) instanceof NullValue;
  }


  /**
   * Returns the property value as a string.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a string.
   */
  @SuppressWarnings("unchecked")
  public String getString(String name) {
    return ((Value<String>) getValue(name)).get();
  }

  /**
   * Returns the property value as long.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a long.
   */
  @SuppressWarnings("unchecked")
  public long getLong(String name) {
    return ((Value<Long>) getValue(name)).get();
  }

  /**
   * Returns the property value as a double.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a double.
   */
  @SuppressWarnings("unchecked")
  public double getDouble(String name) {
    return ((Value<Double>) getValue(name)).get();
  }

  /**
   * Returns the property value as a boolean.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a boolean.
   */
  @SuppressWarnings("unchecked")
  public boolean getBoolean(String name) {
    return ((Value<Boolean>) getValue(name)).get();
  }

  /**
   * Returns the property value as a DateTime.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a DateTime.
   */
  @SuppressWarnings("unchecked")
  public DateTime getDateTime(String name) {
    return ((Value<DateTime>) getValue(name)).get();
  }

  /**
   * Returns the property value as a Key.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a Key.
   */
  @SuppressWarnings("unchecked")
  public Key getKey(String name) {
    return ((Value<Key>) getValue(name)).get();
  }

  /**
   * Returns the property value as an entity.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not an entity.
   */
  @SuppressWarnings("unchecked")
  public <K extends IncompleteKey> FullEntity<K> getEntity(String name) {
    return ((Value<FullEntity<K>>) getValue(name)).get();
  }

  /**
   * Returns the property value as a list of values.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a list of values.
   */
  @SuppressWarnings("unchecked")
  public List<? extends Value<?>> getList(String name) {
    return ((Value<List<? extends Value<?>>>) getValue(name)).get();
  }

  /**
   * Returns the property value as a blob.
   *
   * @throws DatastoreException if not such property.
   * @throws ClassCastException if value is not a blob.
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
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    Builder<?, ?> builder = emptyBuilder();
    builder.fill(DatastoreV1.Entity.parseFrom(bytesPb));
    return builder.build();
  }

  protected abstract Builder<?, ?> emptyBuilder();

  @Override
  protected final DatastoreV1.Entity toPb() {
    DatastoreV1.Entity.Builder entityPb = DatastoreV1.Entity.newBuilder();
    for (Map.Entry<String, Value<?>> entry : properties.entrySet()) {
      DatastoreV1.Property.Builder propertyPb = DatastoreV1.Property.newBuilder();
      propertyPb.setName(entry.getKey());
      propertyPb.setValue(entry.getValue().toPb());
      entityPb.addProperty(propertyPb.build());
    }
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
    return entityPb.build();
  }
}
