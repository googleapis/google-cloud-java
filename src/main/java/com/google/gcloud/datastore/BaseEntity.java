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
import com.google.gcloud.datastore.Value.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A base class for entities to hold the properties.
 */
abstract class BaseEntity extends Serializable<DatastoreV1.Entity> {

  private static final long serialVersionUID = 8175618724683792766L;

  private final transient ImmutableSortedMap<String, Value<?>> properties;

  protected abstract static class Builder<E extends BaseEntity, B extends Builder<E, B>> {

    private final Map<String, Value<?>> properties;

    protected Builder() {
      properties = new HashMap<>();
    }

    protected Builder(BaseEntity entity) {
      properties = new HashMap<>(entity.properties());
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
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

    public B set(String name, PartialEntity value) {
      properties.put(name, of(value));
      return self();
    }

    public B set(String name, List<? extends Value<?>> values) {
      properties.put(name, of(values));
      return self();
    }

    public B set(String name, Value<?>... value) {
      properties.put(name, of(Arrays.asList(value)));
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

    public E build() {
      return build(ImmutableSortedMap.copyOf(properties));
    }

    protected abstract E build(ImmutableSortedMap<String, Value<?>> properties);
  }

  protected BaseEntity(ImmutableSortedMap<String, Value<?>> properties) {
    this.properties = properties;
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
   * @throws DatastoreServiceException if not such property.
   */
  public <V extends Value<?>> V getValue(String name) {
    @SuppressWarnings("unchecked")
    V property = (V) properties.get(name);
    if (property == null) {
      throw DatastoreServiceException.throwInvalidRequest("No such property %s", name);
    }
    return property;
  }

  public Type type(String name) {
    return getValue(name).type();
  }

  public boolean isNull(String name) {
    return getValue(name) instanceof NullValue;
  }

  public String getString(String name) {
    return ((StringValue) getValue(name)).get();
  }

  public long getLong(String name) {
    return ((LongValue) getValue(name)).get();
  }

  public double getDouble(String name) {
    return ((DoubleValue) getValue(name)).get();
  }

  public boolean getBoolean(String name) {
    return ((BooleanValue) getValue(name)).get();
  }

  public DateTime getDateTime(String name) {
    return ((DateTimeValue) getValue(name)).get();
  }

  public Key getKey(String name) {
    return ((KeyValue) getValue(name)).get();
  }

  @SuppressWarnings("unchecked")
  public <T extends PartialEntity> T getEntity(String name) {
    return (T) ((EntityValue) getValue(name)).get();
  }

  public List<? extends Value<?>> getList(String name) {
    return ((ListValue) getValue(name)).get();
  }

  public Blob getBlob(String name) {
    return ((BlobValue) getValue(name)).get();
  }

  /**
   * Returns the property's value as a {@link RawValue}.
   */
  public RawValue asRawValue(String name) {
    Value<?> value = getValue(name);
    if (value instanceof RawValue) {
      return (RawValue) value;
    }
    return new RawValue(value.toPb());
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
  protected final DatastoreV1.Entity toPb() {
    DatastoreV1.Entity.Builder entityPb = DatastoreV1.Entity.newBuilder();
    for (Map.Entry<String, Value<?>> entry : properties.entrySet()) {
      DatastoreV1.Property.Builder propertyPb = DatastoreV1.Property.newBuilder();
      propertyPb.setName(entry.getKey());
      propertyPb.setValue(entry.getValue().toPb());
      entityPb.addProperty(propertyPb.build());
    }
    populateEntityBuilder(entityPb);
    return entityPb.build();
  }

  protected abstract void populateEntityBuilder(DatastoreV1.Entity.Builder entityPb);
}
