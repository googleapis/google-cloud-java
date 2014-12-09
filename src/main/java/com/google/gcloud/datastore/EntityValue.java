package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public class EntityValue extends Value<PartialEntity, EntityValue, EntityValue.Builder> {

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
      DatastoreServiceException.throwInvalidRequest("EntityValue can't specify index");
      return this;
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

  public static Builder builder(PartialEntity entity) {
    return new Builder().set(entity);
  }
}
