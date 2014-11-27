package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class EmbeddedEntityValue extends
    Value<EmbeddedEntity, EmbeddedEntityValue, EmbeddedEntityValue.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<EmbeddedEntity, EmbeddedEntityValue, Builder> MARSHALLER =
      new BaseMarshaller<EmbeddedEntity, EmbeddedEntityValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(EmbeddedEntity value) {
      return new Builder(value);
    }

    @Override
    protected EmbeddedEntity getValue(DatastoreV1.Value from) {
      return EmbeddedEntity.fromPb(from.getEntityValue());
    }

    @Override
    protected void setValue(EmbeddedEntityValue from, DatastoreV1.Value.Builder to) {
      to.setEntityValue(from.get().toPb());
    }
  };

  public static final class Builder extends
      Value.BaseBuilder<EmbeddedEntity, EmbeddedEntityValue, Builder> {

    public Builder(EmbeddedEntity entity) {
      super(Type.EMBEDDED_ENTITY);
      indexed(false);
      set(entity);
    }

    @Override
    public EmbeddedEntityValue build() {
      return new EmbeddedEntityValue(this);
    }
  }

  public EmbeddedEntityValue(EmbeddedEntity entity) {
    this(new Builder(entity));
  }

  EmbeddedEntityValue(Builder builder) {
    super(builder);
  }
}
