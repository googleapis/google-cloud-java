package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class DateTimeValue extends Value<DateTime> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<DateTime, DateTimeValue, Builder> MARSHALLER =
      new BaseMarshaller<DateTime, DateTimeValue, Builder>() {

        private static final long serialVersionUID = -5695812592049332840L;

        @Override
        public int getProtoFieldId() {
          return TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(DateTime value) {
          return builder(value);
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

  public static final class Builder extends Value.BaseBuilder<DateTime, DateTimeValue, Builder> {

    private Builder() {
      super(Type.DATE_TIME);
    }

    @Override
    public DateTimeValue build() {
      return new DateTimeValue(this);
    }
  }

  public DateTimeValue(DateTime dateTime) {
    this(builder(dateTime));
  }

  private DateTimeValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static DateTimeValue of(DateTime dateTime) {
    return new DateTimeValue(dateTime);
  }

  public static Builder builder(DateTime dateTime) {
    return new Builder().set(dateTime);
  }
}
