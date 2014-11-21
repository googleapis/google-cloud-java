package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.STRING_VALUE_FIELD_NUMBER;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1.Value;

// TODO: add javadoc, find the right place to describe that null should only
// be represented by NullValue (so nulls are not allowed here).
public final class StringProperty extends Property<String, StringProperty, StringProperty.Builder> {

  static final Marshaller<String, StringProperty, Builder> MARSHALLER =
      new BaseMarshaller<String, StringProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return STRING_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder() {
      return new Builder();
    }

    @Override
    protected void set(Value from, Builder to) {
      to.setValue(from.getStringValue());
    }

    @Override
    protected void set(StringProperty from, Value.Builder to) {
      to.setStringValue(from.getValue());
    }
  };

  public static final class Builder extends Property.Builder<String, StringProperty, Builder> {

    Builder() {
      this("");
    }

    public Builder(String value) {
      super(Type.STRING);
      setValue(value);
    }

    @Override
    public StringProperty build() {
      if (isIndexed()) {
        checkArgument(getValue().length() <= 500, "Indexed string is limited to 500 characters");
      }
      return new StringProperty(this);
    }

    @Override
    public String validate(String value) {
      return checkNotNull(value);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  public StringProperty(String content) {
    this(new Builder(content));
  }

  StringProperty(Builder builder) {
    super(builder);
  }
}
