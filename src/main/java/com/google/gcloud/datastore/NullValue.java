package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1;

public final class NullValue extends Value<Void> {

  private static final long serialVersionUID = 8497300779013002270L;

  static final BaseMarshaller<Void, NullValue, Builder> MARSHALLER =
      new BaseMarshaller<Void, NullValue, Builder>() {

    @Override
    public Builder newBuilder(Void value) {
      return builder();
    }

    @Override
    public int getProtoFieldId() {
      return 0;
    }

    @Override
    protected Void getValue(DatastoreV1.Value from) {
      return null;
    }

    @Override
    protected void setValue(NullValue from, DatastoreV1.Value.Builder to) {
      // nothing to set
    }
  };

  public static final class Builder extends Value.BaseBuilder<Void, NullValue, Builder> {

    private Builder() {
      super(Type.NULL);
    }

    @Override
    public NullValue build() {
      return new NullValue(this);
    }

    @Override
    public Builder set(Void value) {
      checkArgument(value == null, "Only null values are allowed");
      return this;
    }
  }

  public NullValue() {
    this(builder());
  }

  private NullValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static Builder builder() {
    return new Builder();
  }
}
