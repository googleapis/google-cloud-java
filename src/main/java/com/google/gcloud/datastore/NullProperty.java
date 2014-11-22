package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1.Value;

public final class NullProperty extends Property<Void, NullProperty, NullProperty.Builder> {

  static final Marshaller<Void, NullProperty, Builder> MARSHALLER =
      new BaseMarshaller<Void, NullProperty, Builder>() {

    @Override
    public Builder newBuilder(Value from) {
      return new Builder();
    }

    @Override
    public int getProtoFieldId() {
      return 0;
    }

    @Override
    protected void setValueField(NullProperty from, Value.Builder to) {
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
    public Builder setValue(Void value) {
      checkArgument(value == null, "Only null values are allowed");
      return this;
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  public NullProperty() {
    this(new Builder());
  }

  NullProperty(Builder builder) {
    super(builder);
  }
}
