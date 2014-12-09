package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;

public final class RawValue extends Value<DatastoreV1.Value> {

  private static final long serialVersionUID = -3359604598651897941L;

  static final BaseMarshaller<DatastoreV1.Value, RawValue, Builder> MARSHALLER =
      new BaseMarshaller<DatastoreV1.Value, RawValue, Builder>() {

    @Override
    public Builder newBuilder(DatastoreV1.Value value) {
      return builder(value);
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

    private Builder() {
      super(Type.RAW_VALUE);
    }

    @Override
    public RawValue build() {
      return new RawValue(this);
    }
  }

  private RawValue(Builder builder) {
    super(builder);
  }

  RawValue(DatastoreV1.Value valuePb) {
    this(builder(valuePb));
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  static Builder builder(DatastoreV1.Value valuePb) {
    Builder builder = new Builder();
    if (valuePb.hasIndexed()) {
      builder.indexed(valuePb.getIndexed());
    }
    if (valuePb.hasMeaning()) {
      builder.meaning(valuePb.getMeaning());
    }
    builder.set(valuePb);
    return builder;
  }
}
