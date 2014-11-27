package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class EmbeddedEntityProperty extends
    Property<EmbeddedEntity, EmbeddedEntityProperty, EmbeddedEntityProperty.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<EmbeddedEntity, EmbeddedEntityProperty, Builder> MARSHALLER =
      new BaseMarshaller<EmbeddedEntity, EmbeddedEntityProperty, Builder>() {

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
    protected void setValue(EmbeddedEntityProperty from, DatastoreV1.Value.Builder to) {
      to.setEntityValue(from.get().toPb());
    }
  };

  public static final class Builder extends
      Property.BaseBuilder<EmbeddedEntity, EmbeddedEntityProperty, Builder> {

    public Builder(EmbeddedEntity entity) {
      super(Type.EMBEDDED_ENTITY);
      indexed(false);
      set(entity);
    }

    @Override
    public EmbeddedEntityProperty build() {
      return new EmbeddedEntityProperty(this);
    }
  }

  public EmbeddedEntityProperty(EmbeddedEntity entity) {
    this(new Builder(entity));
  }

  EmbeddedEntityProperty(Builder builder) {
    super(builder);
  }
}
