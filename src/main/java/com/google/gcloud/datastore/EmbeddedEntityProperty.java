package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class EmbeddedEntityProperty extends
    Property<EmbeddedEntity, EmbeddedEntityProperty, EmbeddedEntityProperty.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final Marshaller<EmbeddedEntity, EmbeddedEntityProperty, Builder> MARSHALLER =
      new BaseMarshaller<EmbeddedEntity, EmbeddedEntityProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;
    }

    @Override
    protected Builder newBuilder(EmbeddedEntity value) {
      return new Builder(value);
    }

    @Override
    protected EmbeddedEntity getValue(DatastoreV1.Value from) {
      return EmbeddedEntity.fromPb(from.getEntityValue());
    }

    @Override
    protected void setValue(EmbeddedEntityProperty from, DatastoreV1.Value.Builder to) {
      to.setEntityValue(from.getValue().toPb());
    }
  };

  public static final class Builder extends
      Property.BaseBuilder<EmbeddedEntity, EmbeddedEntityProperty, Builder> {

    public Builder(EmbeddedEntity entity) {
      super(Type.EMBEDDED_ENTITY);
      setIndexed(false);
      setValue(entity);
    }

    @Override
    protected Builder self() {
      return this;
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
