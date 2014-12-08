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
public class PartialEntity extends PropertyContainer {

  private static final long serialVersionUID = 6492561268709192891L;

  private final transient PartialKey key;

  public static class Builder extends PropertyContainer.Builder<PartialEntity, Builder> {

    private PartialKey key;

    public Builder() {
    }

    /**
     * Construct a builder with a partial key (could be null).
     */
    public Builder(PartialKey key) {
      this.key = key;
    }

    public Builder(PartialEntity entity) {
      super(entity);
      key = entity.key();
    }

    public Builder(PartialKey key, PartialEntity entity) {
      super(entity);
      this.key = key;
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
        && super.equals(obj);
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
    PartialKey key = entityPb.hasKey() ? PartialKey.fromPb(entityPb.getKey()) : null;
    Builder builder = new Builder(key);
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }
}
