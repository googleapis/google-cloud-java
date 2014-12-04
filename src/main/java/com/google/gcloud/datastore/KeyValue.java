package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.KEY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class KeyValue extends Value<Key, KeyValue, KeyValue.Builder> {

  private static final long serialVersionUID = -1318353707326704821L;

  static final BaseMarshaller<Key, KeyValue, Builder> MARSHALLER =
      new BaseMarshaller<Key, KeyValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return KEY_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(Key key) {
      return new Builder(key);
    }

    @Override
    protected Key getValue(DatastoreV1.Value from) {
      return Key.fromPb(from.getKeyValue());
    }

    @Override
    protected void setValue(KeyValue from, DatastoreV1.Value.Builder to) {
      to.setKeyValue(from.get().toPb());
    }
  };

  public static final class Builder extends Value.BaseBuilder<Key, KeyValue, Builder> {

    public Builder(Key key) {
      super(Type.KEY);
      set(key);
    }

    @Override
    public KeyValue build() {
      return new KeyValue(this);
    }
  }

  public KeyValue(Key key) {
    this(new Builder(key));
  }

  KeyValue(Builder builder) {
    super(builder);
  }
}
