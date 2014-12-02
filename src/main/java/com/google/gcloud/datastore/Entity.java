package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedMap;

import java.io.ObjectStreamException;

public final class Entity extends PartialEntity {

  private static final long serialVersionUID = 432961565733066915L;

  public static final class Builder {

    private PartialEntity.Builder delegate;

    public Builder(Key key) {
      delegate = new PartialEntity.Builder();
      delegate.setKey(checkNotNull(key));
    }

    public Builder(Entity entity) {
      delegate = new PartialEntity.Builder(entity);
    }

    public Builder clearProperties() {
      delegate.clearProperties();
      return this;
    }

    public Builder removeProperty(String name) {
      delegate.removeProperty(name);
      return this;
    }

    public Builder setProperty(String name, Value<?, ?, ?> value) {
      delegate.setProperty(name, value);
      return this;
    }

    public Entity build() {
      PartialEntity entity = delegate.build();
      return new Entity((Key) entity.getKey(), entity.getProperties());
    }
  }

  private Entity(Key key, ImmutableSortedMap<String, Value<?, ?, ?>> properties) {
    super(key, properties);
  }

  /**
   * Returns the entity's key (never null).
   */
  @Override
  public Key getKey() {
    return (Key) super.getKey();
  }

  static Entity fromPb(DatastoreV1.Entity entityPb) {
    Preconditions.checkArgument(entityPb.hasKey());
    Builder builder = new Builder(Key.fromPb(entityPb.getKey()));
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      builder.setProperty(property.getName(), Value.fromPb(property.getValue()));
    }
    return builder.build();
  }

  @Override
  protected Object readResolve() throws ObjectStreamException {
    return fromPb(tempEntityPb);
  }
}
