package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
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

public final class Entity implements Serializable {

  private static final long serialVersionUID = 432961565733066915L;

  private final transient Key key;
  private final transient ImmutableSortedMap<String, Value<?, ?, ?>> properties;
  private transient DatastoreV1.Entity tempEntityPb; // only for deserialization

  public static final class Builder {

    private Key key;
    private Map<String, Value<?, ?, ?>> properties;

    public Builder(Key key) {
      this.key = checkNotNull(key);
      this.properties = new HashMap<>();
    }

    public Builder(Entity entity) {
      this.key = entity.key;
      this.properties = new HashMap<>(entity.properties);
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

    public Entity build() {
      return new Entity(this);
    }
  }

  private Entity(Builder builder) {
    key = builder.key;
    properties = ImmutableSortedMap.copyOf(builder.properties);
  }

  public Key getKey() {
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

  ImmutableSortedMap<String, Value<?, ?, ?>> getProperties() {
    return properties;
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
    if (!(obj instanceof Entity)) {
      return false;
    }
    Entity other = (Entity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties, other.properties);
  }

  static Entity fromPb(DatastoreV1.Entity entityPb) {
    Preconditions.checkArgument(entityPb.hasKey());
    Builder builder = new Builder(Key.fromPb(entityPb.getKey()));
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }

  DatastoreV1.Entity toPb() {
    DatastoreV1.Entity.Builder entityPb = DatastoreV1.Entity.newBuilder();
    entityPb.setKey(key.toPb());
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
  private Object readResolve() throws ObjectStreamException {
    return fromPb(tempEntityPb);
  }
}
