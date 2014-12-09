package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * An entity is the Google Cloud Datastore persistent data object.
 * An entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}), and is associated with a {@link Key}.
 * For a list of possible values see {@link Value.Type}.
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class Entity extends PartialEntity {

  private static final long serialVersionUID = 432961565733066915L;

  public static final class Builder extends BaseEntity.Builder<Entity, Builder> {

    private Key key;

    private Builder(Key key) {
      this.key = checkNotNull(key);
    }

    private Builder(Entity entity) {
      super(entity);
      key = entity.key();
    }

    public Builder key(Key key) {
      this.key = checkNotNull(key);
      return this;
    }

    @Override
    protected Entity build(ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
      return new Entity(key, properties);
    }
  }

  Entity(Key key, ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
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
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static Entity fromPb(DatastoreV1.Entity entityPb) {
    PartialEntity entity = PartialEntity.fromPb(entityPb);
    Preconditions.checkState(entity instanceof Entity, "Entity is not complete");
    return (Entity) entity;
  }

  public static Builder builder(Key key) {
    return new Builder(key);
  }

  public static Builder builder(Entity copyFrom) {
    return new Builder(copyFrom);
  }
}
