package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class DateAndTimeValue
    extends Value<DateAndTime, DateAndTimeValue, DateAndTimeValue.Builder> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<DateAndTime, DateAndTimeValue, Builder> MARSHALLER =
      new BaseMarshaller<DateAndTime, DateAndTimeValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(DateAndTime value) {
      return new Builder(value);
    }

    @Override
    protected DateAndTime getValue(DatastoreV1.Value from) {
      return new DateAndTime(from.getTimestampMicrosecondsValue());
    }

    @Override
    protected void setValue(DateAndTimeValue from, DatastoreV1.Value.Builder to) {
      to.setTimestampMicrosecondsValue(from.get().timestampMicroseconds());
    }
  };

  public static final class Builder
      extends Value.BaseBuilder<DateAndTime, DateAndTimeValue, Builder> {

    public Builder(DateAndTime dateAndTime) {
      super(Type.DATE_AND_TIME);
      set(dateAndTime);
    }

    @Override
    public DateAndTimeValue build() {
      return new DateAndTimeValue(this);
    }
  }

  public DateAndTimeValue(DateAndTime dateAndTime) {
    this(new Builder(dateAndTime));
  }

  DateAndTimeValue(Builder builder) {
    super(builder);
  }
}
