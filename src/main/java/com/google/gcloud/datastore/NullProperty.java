package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1.Value;

public final class NullProperty extends Property<NullProperty> {

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

    public Builder(NullProperty property) {
      super(property);
    }

    @Override
    public NullProperty build() {
      return new NullProperty(this);
    }
  }

  public NullProperty() {
    this(new Builder());
  }

  NullProperty(Builder builder) {
    super(builder);
  }

  @Override
  protected void addValueToProto(Value.Builder builder) {
    // set nothing
  }

  @Override
  public Property.Builder<NullProperty> toBuilder() {
    return new Builder(this);
  }
}
