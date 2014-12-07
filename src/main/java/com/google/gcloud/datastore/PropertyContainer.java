package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A container of properties (name and Value pairs).
 */
abstract class PropertyContainer
    <E extends PropertyContainer<E, B>, B extends PropertyContainer.Builder<E, B>>
    extends Serializable<DatastoreV1.Entity> {

  private static final long serialVersionUID = 8175618724683792766L;

  private final transient ImmutableSortedMap<String, Value<?, ?, ?>> properties;

  protected abstract static class Builder
      <E extends PropertyContainer<E, B>, B extends Builder<E, B>> {

    private final Map<String, Value<?, ?, ?>> properties;

    public Builder() {
      properties = new HashMap<>();
    }

    public Builder(PropertyContainer<E, B> entity) {
      properties = new HashMap<>(entity.properties());
    }

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

    setNullProperty(String name);
  longValue
  booleanValue
  doubleValue
  dateTimeValue
  PartialEntityValue
  KeyValue
  ListValue
  blobValue
  rawValue // should work for all....



    public E build() {
      return build(ImmutableSortedMap.copyOf(properties));
    }

    protected abstract E build(ImmutableSortedMap<String, Value<?, ?, ?>> properties);
  }

  protected PropertyContainer(ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    this.properties = properties;
  }

  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  @SuppressWarnings("unchecked")
  public <V extends Value<?, ?, ?>> V property(String name) {
    return (V) properties.get(name);
  }

  public boolean isNull(String name) {
    return  properties.get(name) instanceof NullValue;
  }

  public String stringProperty(String name) {
    return ((StringValue) property(name)).get();
  }

  longProperty
  booleanValue
  doubleValue
  dateTimeValue
  PartialEntityValue
  KeyValue
  ListValue
  blobValue
  rawValue // should work for all....

  public Set<String> propertyNames() {
    return properties.keySet();
  }

  /**
   * Returns a new builder for this entity (values are copied).
   */
  public abstract B builder();

  ImmutableSortedMap<String, Value<?, ?, ?>> properties() {
    return properties;
  }

  @Override
  public int hashCode() {
    return properties.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PropertyContainer)) {
      return false;
    }
    return properties.equals(((PropertyContainer<?, ?>) obj).properties);
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

  protected abstract void populateEntityBuilder(DatastoreV1.Entity.Builder entity);
}
