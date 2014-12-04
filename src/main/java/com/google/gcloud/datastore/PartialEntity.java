package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A partial entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}).
 * For a list of possible values see {@link Value.Type}.
 * A partial entity also can be associated with a key (partial or full).
 * This class is immutable. To edit (a copy) use {@link #builder()}.
 */
public class PartialEntity extends Serializable<DatastoreV1.Entity> {

  private static final long serialVersionUID = 6492561268709192891L;

  private final transient PartialKey key;
  private final transient ImmutableSortedMap<String, Value<?, ?, ?>> properties;

  public static class Builder {

    private final PartialKey key;
    private final Map<String, Value<?, ?, ?>> properties;

    /**
     * Construct a builder with a partial key (could be null).
     */
    public Builder(PartialKey key) {
      this.key = key;
      properties = new HashMap<>();
    }

    public Builder(PartialEntity entity) {
      key = entity.key();
      properties = new HashMap<>(entity.properties());
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
   * Returns the key for this entity or {@code null} if it does not have one.
   */
  public PartialKey key() {
    return key;
  }

  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  @SuppressWarnings("unchecked")
  public <V, P extends Value<V, P, B>, B extends Value.Builder<V, P, B>> Value<V, P, B> property(
      String name) {
    return (Value<V, P, B>) properties.get(name);
  }

  public Set<String> propertyNames() {
    return properties.keySet();
  }

  /**
   * Returns a new builder for this entity (values are copied).
   */
  public Builder builder() {
    return new Builder(this);
  }

  ImmutableSortedMap<String, Value<?, ?, ?>> properties() {
    return properties;
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

  @Override
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

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static PartialEntity fromPb(DatastoreV1.Entity entityPb) {
    PartialKey key = entityPb.hasKey() ? PartialKey.fromPb(entityPb.getKey()) : null;
    Builder builder = new Builder(key);
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }
}
