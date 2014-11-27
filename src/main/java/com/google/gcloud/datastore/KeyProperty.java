package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.KEY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1.Value;

public final class KeyProperty extends Property<Key, KeyProperty, KeyProperty.Builder> {

  private static final long serialVersionUID = -1318353707326704821L;

  static final BaseMarshaller<Key, KeyProperty, Builder> MARSHALLER =
      new BaseMarshaller<Key, KeyProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return KEY_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(Key key) {
      return new Builder(key);
    }

    @Override
    protected Key getValue(Value from) {
      return Key.fromPb(from.getKeyValue());
    }

    @Override
    protected void setValue(KeyProperty from, Value.Builder to) {
      to.setKeyValue(from.get().toPb());
    }
  };

  public static final class Builder extends Property.BaseBuilder<Key, KeyProperty, Builder> {

    public Builder(Key value) {
      super(Type.KEY);
      set(value);
    }

    @Override
    public KeyProperty build() {
      return new KeyProperty(this);
    }
  }

  public KeyProperty(Key key) {
    this(new Builder(key));
  }

  KeyProperty(Builder builder) {
    super(builder);
  }
}
