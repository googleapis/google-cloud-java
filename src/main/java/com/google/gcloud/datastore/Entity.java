package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * An entity is the Google Cloud Datastore persistent data object.
 * An entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}), and is associated with a {@link Key}.
 * For a list of possible values see {@link Value.Type}.
 * This class is immutable. To edit (a copy) use {@link #builder()}.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class Entity extends PartialEntity {

  private static final long serialVersionUID = 432961565733066915L;

  public static final class Builder extends PartialEntity.Builder {

    public Builder(Key key) {
      super(key);
    }

    public Builder(Entity entity) {
      super(entity);
    }

    @Override
    public Builder clearProperties() {
      super.clearProperties();
      return this;
    }

    @Override
    public Builder removeProperty(String name) {
      super.removeProperty(name);
      return this;
    }

    @Override
    public Builder setProperty(String name, Value<?, ?, ?> value) {
      super.setProperty(name, value);
      return this;
    }

    @Override
    public Entity build() {
      PartialEntity entity = super.build();
      return new Entity((Key) entity.key(), entity.properties());
    }
  }

  private Entity(Key key, ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    super(key, properties);
  }

  /**
   * Returns the entity's key (never null).
   */
  @Override
  public Key key() {
    return (Key) super.key();
  }

  @Override
  public Builder builder() {
    return new Builder(this);
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static Entity fromPb(DatastoreV1.Entity entityPb) {
    Preconditions.checkArgument(entityPb.hasKey());
    Builder builder = new Builder(Key.fromPb(entityPb.getKey()));
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }
}
