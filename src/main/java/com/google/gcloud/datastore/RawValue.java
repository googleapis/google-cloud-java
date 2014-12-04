package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;

public final class RawValue extends Value<DatastoreV1.Value, RawValue, RawValue.Builder> {

  private static final long serialVersionUID = -3359604598651897941L;

  static final BaseMarshaller<DatastoreV1.Value, RawValue, Builder> MARSHALLER =
      new BaseMarshaller<DatastoreV1.Value, RawValue, Builder>() {

    @Override
    public Builder newBuilder(DatastoreV1.Value value) {
      return new Builder(value);
    }

    @Override
    public int getProtoFieldId() {
      return 0;
    }

    @Override
    protected DatastoreV1.Value getValue(DatastoreV1.Value from) {
      return from;
    }

    @Override
    protected void setValue(RawValue from, DatastoreV1.Value.Builder to) {
      to.mergeFrom(from.get());
    }
  };

  static final class Builder extends Value.BaseBuilder<DatastoreV1.Value, RawValue, Builder> {

    Builder(DatastoreV1.Value valuePb) {
      super(Type.RAW_VALUE);
      if (valuePb.hasIndexed()) {
        indexed(valuePb.getIndexed());
      }
      if (valuePb.hasMeaning()) {
        meaning(valuePb.getMeaning());
      }
      set(valuePb);
    }

    @Override
    public RawValue build() {
      return new RawValue(this);
    }
  }

  RawValue(Builder builder) {
    super(builder);
  }

  RawValue(DatastoreV1.Value valuePb) {
    this(new Builder(valuePb));
  }
}
