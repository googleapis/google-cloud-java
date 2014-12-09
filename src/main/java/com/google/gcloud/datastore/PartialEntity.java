package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * A partial entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}).
 * For a list of possible values see {@link Value.Type}.
 * A partial entity also can be associated with a key (partial or full).
 * This class is immutable.
 */
public class PartialEntity extends BaseEntity {

  private static final long serialVersionUID = 6492561268709192891L;

  private final transient PartialKey key;

  public static class Builder extends BaseEntity.Builder<PartialEntity, Builder> {

    private PartialKey key;

    private Builder() {
    }

    private Builder(PartialEntity entity) {
      super(entity);
      key = entity.key();
    }

    public Builder key(PartialKey key) {
      this.key = key;
      return this;
    }

    @Override
    protected PartialEntity build(ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
      return new PartialEntity(key, properties);
    }
  }

  protected PartialEntity(PartialKey key, ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    super(properties);
    this.key = key;
  }

  public Entity newEntity(Key key) {
    return new Entity(key, ImmutableSortedMap.<String, Value<?, ?, ?>>copyOf(properties()));
  }

  /**
   * Returns the key for this entity or {@code null} if it does not have one.
   */
  public PartialKey key() {
    return key;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, properties());
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PartialEntity)) {
      return false;
    }
    PartialEntity other = (PartialEntity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties(), other.properties());
  }

  @Override
  protected void populateEntityBuilder(DatastoreV1.Entity.Builder entityPb) {
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static PartialEntity fromPb(DatastoreV1.Entity entityPb) {
    ImmutableSortedMap.Builder<String, Value<?, ?, ?>> properties =
        ImmutableSortedMap.naturalOrder();
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      properties.put(property.getName(), Value.fromPb(property.getValue()));
    }
    PartialKey partialKey = null;
    if (entityPb.hasKey()) {
      partialKey = PartialKey.fromPb(entityPb.getKey());
      if (partialKey instanceof Key) {
        return new Entity((Key) partialKey, properties.build());
      }
    }
    return new PartialEntity(partialKey, properties.build());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(PartialKey key) {
    return new Builder().key(key);
  }

  public static Builder builder(PartialEntity copyFrom) {
    return new Builder(copyFrom);
  }
}
