package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class PartialEntity implements Serializable {

  private static final long serialVersionUID = 6492561268709192891L;

  private final transient PartialKey key;
  private final transient ImmutableSortedMap<String, Value<?, ?, ?>> properties;
  protected transient DatastoreV1.Entity tempEntityPb; // only for deserialization

  public static final class Builder {

    private PartialKey key;
    private Map<String, Value<?, ?, ?>> properties;

    public Builder() {
      properties = new HashMap<>();
    }

    public Builder(PartialEntity entity) {
      this.key = entity.getKey();
      this.properties = new HashMap<>(entity.getProperties());
    }

    public Builder setKey(PartialKey key) {
      this.key = key;
      return this;
    }

    public Builder clearProperties() {
      properties.clear();
      return this;
    }

    public Builder removeProperty(String name) {
      properties.remove(name);
      return this;
    }

    public Builder setProperty(String name, Value<?, ?, ?> value) {
      properties.put(name, value);
      return this;
    }

    public PartialEntity build() {
      return new PartialEntity(key, ImmutableSortedMap.copyOf(properties));
    }
  }

  protected PartialEntity(PartialKey key, ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    this.key = key;
    this.properties = properties;
  }

  /**
   * Returns the key or null if not provided.
   */
  public PartialKey getKey() {
    return key;
  }

  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  public Value<?, ?, ?> getProperty(String name) {
    return properties.get(name);
  }

  public Set<String> getPropertyNames() {
    return properties.keySet();
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, properties);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PartialEntity)) {
      return false;
    }
    PartialEntity other = (PartialEntity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties, other.properties);
  }

  ImmutableSortedMap<String, Value<?, ?, ?>> getProperties() {
    return properties;
  }

  static PartialEntity fromPb(DatastoreV1.Entity entityPb) {
    Builder builder = new Builder();
    if (entityPb.hasKey()) {
      builder.setKey(PartialKey.fromPb(entityPb.getKey()));
    }
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }

  protected DatastoreV1.Entity toPb() {
    DatastoreV1.Entity.Builder entityPb = DatastoreV1.Entity.newBuilder();
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
    for (Map.Entry<String, Value<?, ?, ?>> entry : properties.entrySet()) {
      DatastoreV1.Property.Builder propertyPb = DatastoreV1.Property.newBuilder();
      propertyPb.setName(entry.getKey());
      propertyPb.setValue(entry.getValue().toPb());
      entityPb.addProperty(propertyPb.build());
    }
    return entityPb.build();
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeObject(toPb().toByteArray());
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    byte[] bytes = (byte[]) in.readObject();
    tempEntityPb = DatastoreV1.Entity.parseFrom(bytes);
  }

  @SuppressWarnings("unused")
  protected Object readResolve() throws ObjectStreamException {
    return fromPb(tempEntityPb);
  }
}
