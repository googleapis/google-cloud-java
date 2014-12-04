package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.INTEGER_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class LongValue extends Value<Long, LongValue, LongValue.Builder> {

  private static final long serialVersionUID = -8552854340400546861L;

  static final BaseMarshaller<Long, LongValue, Builder> MARSHALLER =
      new BaseMarshaller<Long, LongValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return INTEGER_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(Long value) {
      return new Builder(value);
    }

    @Override
    protected Long getValue(DatastoreV1.Value from) {
      return from.getIntegerValue();
    }

    @Override
    protected void setValue(LongValue from, DatastoreV1.Value.Builder to) {
      to.setIntegerValue(from.get());
    }
  };

  public static final class Builder extends Value.BaseBuilder<Long, LongValue, Builder> {

    public Builder(long value) {
      super(Type.LONG);
      set(value);
    }

    @Override
    public LongValue build() {
      return new LongValue(this);
    }
  }

  public LongValue(long value) {
    this(new Builder(value));
  }

  LongValue(Builder builder) {
    super(builder);
  }
}
