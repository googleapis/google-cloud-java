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

  public static final class Builder extends PropertyContainer.Builder<Entity, Builder> {

    private Key key;

    public Builder(Key key) {
      this.key = checkNotNull(key);
    }

    public Builder(Entity entity) {
      super(entity);
      key = entity.key();
    }

    /**
     * Create a Builder for the given key and with the properties from the given entity.
     */
    public Builder(Key key, PartialEntity entity) {
      super(entity);
      this.key = key;
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
