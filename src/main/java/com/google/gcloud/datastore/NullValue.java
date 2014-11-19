package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1.Value.Builder;

public final class NullValue extends Value {

  static final Provider<NullValue> PROVIDER = new Provider<NullValue>() {
    @Override
    NullValue get(com.google.api.services.datastore.DatastoreV1.Value proto, boolean indexed,
        Integer meaning) {
      return new NullValue(indexed, meaning);
    }
  };

  public NullValue() {
    this(true);
  }

  public NullValue(boolean indexed) {
    this(indexed, null);
  }

  public NullValue(boolean indexed, Integer meaning) {
    super(Type.NULL, indexed, meaning);
  }

  @Override
  protected void addValueToProto(Builder builder) {
    // set nothing
  }
}
