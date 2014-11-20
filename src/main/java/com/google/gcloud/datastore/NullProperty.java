package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1.Value;

public final class NullProperty extends Property {

  static final Provider<NullProperty> PROVIDER = new Provider<NullProperty>() {
    @Override
    NullProperty get(Value proto, boolean indexed, Integer meaning) {
      return new NullProperty(indexed, meaning);
    }
  };

  public static class Builder extends Property.Builder<NullProperty> {

    public Builder() {
      super(Type.NULL);
    }

    @Override
    public NullProperty build() {
      return new NullProperty();
    }
  }

  public NullProperty() {
    this(true);
  }

  public NullProperty(boolean indexed) {
    this(indexed, null);
  }

  public NullProperty(boolean indexed, Integer meaning) {
    super(Type.NULL, indexed, meaning);
  }

  @Override
  protected void addValueToProto(Builder builder) {
    // set nothing
  }
}
