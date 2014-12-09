package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.BOOLEAN_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class BooleanValue extends Value<Boolean, BooleanValue, BooleanValue.Builder> {

  private static final long serialVersionUID = -542649497897250340L;

  static final BaseMarshaller<Boolean, BooleanValue, Builder> MARSHALLER =
      new BaseMarshaller<Boolean, BooleanValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return BOOLEAN_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(Boolean value) {
      return builder(value);
    }

    @Override
    protected Boolean getValue(DatastoreV1.Value from) {
      return from.getBooleanValue();
    }

    @Override
    protected void setValue(BooleanValue from, DatastoreV1.Value.Builder to) {
      to.setBooleanValue(from.get());
    }
  };

  public static final class Builder extends Value.BaseBuilder<Boolean, BooleanValue, Builder> {

    private Builder() {
      super(Type.BOOLEAN);
    }

    @Override
    public BooleanValue build() {
      return new BooleanValue(this);
    }
  }

  public BooleanValue(boolean value) {
    this(builder(value));
  }

  private BooleanValue(Builder builder) {
    super(builder);
  }

  public static Builder builder(boolean value) {
    return new Builder().set(value);
  }
}
