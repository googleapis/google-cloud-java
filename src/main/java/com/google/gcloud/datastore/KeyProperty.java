package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.KEY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1.Value;

public final class KeyProperty extends Property<Key, KeyProperty, KeyProperty.Builder> {

  private static final long serialVersionUID = -1318353707326704821L;

  static final Marshaller<Key, KeyProperty, Builder> MARSHALLER =
      new BaseMarshaller<Key, KeyProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return KEY_VALUE_FIELD_NUMBER;
    }

    @Override
    protected Builder newBuilder(Value from) {
      return new Builder(Key.fromPb(from.getKeyValue()));
    }

    @Override
    protected void setValueField(KeyProperty from, Value.Builder to) {
      to.setKeyValue(from.getValue().toPb());
    }
  };

  public static final class Builder extends Property.BaseBuilder<Key, KeyProperty, Builder> {

    public Builder(Key value) {
      super(Type.KEY);
      setValue(value);
    }

    @Override
    public KeyProperty build() {
      return new KeyProperty(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  public KeyProperty(Key key) {
    this(new Builder(key));
  }

  KeyProperty(Builder builder) {
    super(builder);
  }
}
