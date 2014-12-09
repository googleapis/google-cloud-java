package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.gcloud.datastore.Value.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A base class for entities.
 */
abstract class BaseEntity extends Serializable<DatastoreV1.Entity> {

  private static final long serialVersionUID = 8175618724683792766L;

  private final transient ImmutableSortedMap<String, Value<?, ?, ?>> properties;

  protected abstract static class Builder<E extends BaseEntity, B extends Builder<E, B>> {

    private final Map<String, Value<?, ?, ?>> properties;

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

    public B clearProperties() {
      properties.clear();
      return self();
    }

    public B removeProperty(String name) {
      properties.remove(name);
      return self();
    }

    public B setProperty(String name, Value<?, ?, ?> value) {
      properties.put(name, value);
      return self();
    }

    public B setNullProperty(String name) {
      properties.put(name, new NullValue());
      return self();
    }

    public B setStringProperty(String name, String value) {
      properties.put(name, new StringValue(value));
      return self();
    }

    public B setLongProperty(String name, long value) {
      properties.put(name, new LongValue(value));
      return self();
    }

    public B setDoubleProperty(String name, double value) {
      properties.put(name, new DoubleValue(value));
      return self();
    }

    public B setBooleanProperty(String name, boolean value) {
      properties.put(name, new BooleanValue(value));
      return self();
    }

    public B setDateTimeProperty(String name, DateTime value) {
      properties.put(name, new DateTimeValue(value));
      return self();
    }

    public B setKeyProperty(String name, Key value) {
      properties.put(name, new KeyValue(value));
      return self();
    }

    public B setEntityProperty(String name, PartialEntity value) {
      properties.put(name, new EntityValue(value));
      return self();
    }

    public B setListProperty(String name, List<? extends Value<?, ?, ?>> values) {
      properties.put(name, new ListValue(values));
      return self();
    }

    public B setListProperty(String name, Value<?, ?, ?>... value) {
      properties.put(name, new ListValue(Arrays.asList(value)));
      return self();
    }

    public B setBlobProperty(String name, Blob value) {
      properties.put(name, new BlobValue(value));
      return self();
    }

    public E build() {
      return build(ImmutableSortedMap.copyOf(properties));
    }

    protected abstract E build(ImmutableSortedMap<String, Value<?, ?, ?>> properties);
  }

  protected BaseEntity(ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    this.properties = properties;
  }

  /**
   * Returns {@code true} if there is such property with the given {@code name}.
   */
  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  /**
   * Returns the {@link Value} of property with the given {@code name}.
   *
   * @throws DatastoreServiceException if not such property.
   */
  public <V extends Value<?, ?, ?>> V property(String name) {
    @SuppressWarnings("unchecked")
    V property = (V) properties.get(name);
    if (property == null) {
      throw DatastoreServiceException.throwInvalidRequest("No such property %s", name);
    }
    return property;
  }

  public Type propertyType(String name) {
    return property(name).type();
  }

  public boolean isNullProperty(String name) {
    return property(name) instanceof NullValue;
  }

  public String stringProperty(String name) {
    return ((StringValue) property(name)).get();
  }

  public long longProperty(String name) {
    return ((LongValue) property(name)).get();
  }

  public double doubleProperty(String name) {
    return ((DoubleValue) property(name)).get();
  }

  public boolean booleanProperty(String name) {
    return ((BooleanValue) property(name)).get();
  }

  public DateTime dateTimeProperty(String name) {
    return ((DateTimeValue) property(name)).get();
  }

  public Key keyProperty(String name) {
    return ((KeyValue) property(name)).get();
  }

  @SuppressWarnings("unchecked")
  public <T extends PartialEntity> T entityProperty(String name) {
    return (T) ((EntityValue) property(name)).get();
  }

  public List<? extends Value<?, ?, ?>> listProperty(String name) {
    return ((ListValue) property(name)).get();
  }

  public Blob blobProperty(String name) {
    return ((BlobValue) property(name)).get();
  }

  /**
   * Returns the property's value as a {@link RawValue}.
   */
  public RawValue asRawValueProperty(String name) {
    Value<?, ?, ?> value = property(name);
    if (value instanceof RawValue) {
      return (RawValue) value;
    }
    return new RawValue(value.toPb());
  }

  public Set<String> propertyNames() {
    return properties.keySet();
  }

  ImmutableSortedMap<String, Value<?, ?, ?>> properties() {
    return properties;
  }

  @Override
  protected final DatastoreV1.Entity toPb() {
    DatastoreV1.Entity.Builder entityPb = DatastoreV1.Entity.newBuilder();
    for (Map.Entry<String, Value<?, ?, ?>> entry : properties.entrySet()) {
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
