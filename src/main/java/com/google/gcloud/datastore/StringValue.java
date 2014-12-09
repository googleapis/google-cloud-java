package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.STRING_VALUE_FIELD_NUMBER;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1;

public final class StringValue extends Value<String> {

  private static final long serialVersionUID = -3105699707394545523L;

  static final BaseMarshaller<String, StringValue, Builder> MARSHALLER =
      new BaseMarshaller<String, StringValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return STRING_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(String value) {
      return builder(value);
    }

    @Override
    protected String getValue(DatastoreV1.Value from) {
      return from.getStringValue();
    }

    @Override
    protected void setValue(StringValue from, DatastoreV1.Value.Builder to) {
      to.setStringValue(from.get());
    }
  };

  public static final class Builder extends Value.BaseBuilder<String, StringValue, Builder> {

    private Builder() {
      super(Type.STRING);
    }

    @Override
    public StringValue build() {
      if (Boolean.TRUE.equals(getIndexed())) {
        checkArgument(get().length() <= 500, "Indexed string is limited to 500 characters");
      }
      return new StringValue(this);
    }
  }

  public StringValue(String value) {
    this(builder(value));
  }

  private StringValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static Builder builder(String value) {
    return new Builder().set(value);
  }
}
