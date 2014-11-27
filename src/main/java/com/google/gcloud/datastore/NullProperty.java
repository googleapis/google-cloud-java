package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1;

public final class NullProperty extends Property<Void, NullProperty, NullProperty.Builder> {

  private static final long serialVersionUID = 8497300779013002270L;

  static final BaseMarshaller<Void, NullProperty, Builder> MARSHALLER =
      new BaseMarshaller<Void, NullProperty, Builder>() {

    @Override
    public Builder newBuilder(Void value) {
      return new Builder();
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
    protected void setValue(NullProperty from, DatastoreV1.Value.Builder to) {
      // nothing to set
    }
  };

  public static final class Builder extends Property.BaseBuilder<Void, NullProperty, Builder> {

    public Builder() {
      super(Type.NULL);
    }

    @Override
    public NullProperty build() {
      return new NullProperty(this);
    }

    @Override
    public Builder set(Void value) {
      checkArgument(value == null, "Only null values are allowed");
      return this;
    }
  }

  public NullProperty() {
    this(new Builder().indexed(true));
  }

  NullProperty(Builder builder) {
    super(builder);
  }
}
