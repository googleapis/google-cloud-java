package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public class PartialEntityValue extends
    Value<PartialEntity, PartialEntityValue, PartialEntityValue.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<PartialEntity, PartialEntityValue, Builder> MARSHALLER =
      new BaseMarshaller<PartialEntity, PartialEntityValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(PartialEntity value) {
      return new Builder(value);
    }

    @Override
    protected PartialEntity getValue(DatastoreV1.Value from) {
      return PartialEntity.fromPb(from.getEntityValue());
    }

    @Override
    protected void setValue(PartialEntityValue from, DatastoreV1.Value.Builder to) {
      to.setEntityValue(from.get().toPb());
    }
  };

  public static final class Builder extends
      Value.BaseBuilder<PartialEntity, PartialEntityValue, Builder> {

    public Builder(PartialEntity entity) {
      super(Type.PARTIAL_ENTITY);
      indexed(false);
      set(entity);
    }

    @Override
    public PartialEntityValue build() {
      return new PartialEntityValue(this);
    }
  }

  public PartialEntityValue(PartialEntity entity) {
    this(new Builder(entity));
  }

  PartialEntityValue(Builder builder) {
    super(builder);
  }
}
