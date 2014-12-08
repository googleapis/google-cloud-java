package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class DateTimeValue
    extends Value<DateTime, DateTimeValue, DateTimeValue.Builder> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<DateTime, DateTimeValue, Builder> MARSHALLER =
      new BaseMarshaller<DateTime, DateTimeValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(DateTime value) {
      return new Builder(value);
    }

    @Override
    protected DateTime getValue(DatastoreV1.Value from) {
      return new DateTime(from.getTimestampMicrosecondsValue());
    }

    @Override
    protected void setValue(DateTimeValue from, DatastoreV1.Value.Builder to) {
      to.setTimestampMicrosecondsValue(from.get().timestampMicroseconds());
    }
  };

  public static final class Builder
      extends Value.BaseBuilder<DateTime, DateTimeValue, Builder> {

    public Builder(DateTime dateTime) {
      super(Type.DATE_TIME);
      set(dateTime);
    }

    @Override
    public DateTimeValue build() {
      return new DateTimeValue(this);
    }
  }

  public DateTimeValue(DateTime dateTime) {
    this(new Builder(dateTime));
  }

  DateTimeValue(Builder builder) {
    super(builder);
  }
}
