package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;

public class EntityValue extends Value<PartialEntity> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<PartialEntity, EntityValue, Builder> MARSHALLER =
      new BaseMarshaller<PartialEntity, EntityValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(PartialEntity value) {
      return builder(value);
    }

    @Override
    protected PartialEntity getValue(DatastoreV1.Value from) {
      return PartialEntity.fromPb(from.getEntityValue());
    }

    @Override
    protected void setValue(EntityValue from, DatastoreV1.Value.Builder to) {
      to.setEntityValue(from.get().toPb());
    }
  };

  public static final class Builder extends
      Value.BaseBuilder<PartialEntity, EntityValue, Builder> {

    private Builder() {
      super(Type.ENTITY);
    }

    @Override
    public Builder indexed(boolean indexed) {
      // see b/8730533
      Preconditions.checkArgument(!indexed, "EntityValue can't be indexed");
      return super.indexed(indexed);
    }

    @Override
    public EntityValue build() {
      return new EntityValue(this);
    }
  }

  public EntityValue(PartialEntity entity) {
    this(builder(entity));
  }

  private EntityValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static Builder builder(PartialEntity entity) {
    return new Builder().set(entity).indexed(false);
  }
}
