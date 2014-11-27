package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.STRING_VALUE_FIELD_NUMBER;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1;

public final class StringProperty extends Property<String, StringProperty, StringProperty.Builder> {

  private static final long serialVersionUID = -3105699707394545523L;

  static final BaseMarshaller<String, StringProperty, Builder> MARSHALLER =
      new BaseMarshaller<String, StringProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return STRING_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(String value) {
      return new Builder(value);
    }

    @Override
    protected String getValue(DatastoreV1.Value from) {
      return from.getStringValue();
    }

    @Override
    protected void setValue(StringProperty from, DatastoreV1.Value.Builder to) {
      to.setStringValue(from.get());
    }
  };

  public static final class Builder extends Property.BaseBuilder<String, StringProperty, Builder> {

    public Builder(String value) {
      super(Type.STRING);
      set(value);
    }

    @Override
    public StringProperty build() {
      if (getIndexed()) {
        checkArgument(get().length() <= 500, "Indexed string is limited to 500 characters");
      }
      return new StringProperty(this);
    }
  }

  public StringProperty(String content) {
    this(new Builder(content));
  }

  StringProperty(Builder builder) {
    super(builder);
  }
}
