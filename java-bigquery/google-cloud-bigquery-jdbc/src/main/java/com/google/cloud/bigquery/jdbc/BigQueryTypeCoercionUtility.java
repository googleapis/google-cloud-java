/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.Range;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import org.apache.arrow.vector.PeriodDuration;
import org.apache.arrow.vector.util.Text;

@InternalApi
class BigQueryTypeCoercionUtility {

  static BigQueryTypeCoercer INSTANCE;

  static {
    INSTANCE =
        BigQueryTypeCoercer.builder()
            .registerTypeCoercion(new FieldValueToString())
            .registerTypeCoercion(new FieldValueToInteger())
            .registerTypeCoercion(new FieldValueToFloat())
            .registerTypeCoercion(new FieldValueToShort())
            .registerTypeCoercion(new FieldValueToLong())
            .registerTypeCoercion(new FieldValueToDouble())
            .registerTypeCoercion(new FieldValueToBigDecimal())
            .registerTypeCoercion(new FieldValueToBoolean())
            .registerTypeCoercion(new FieldValueToBytesArray())
            .registerTypeCoercion(new FieldValueToTimestamp())
            .registerTypeCoercion(new FieldValueToTime())
            .registerTypeCoercion(new FieldValueToDate())
            .registerTypeCoercion(new FieldValueToObject())
            .registerTypeCoercion(new StringToBytesArray())
            .registerTypeCoercion(new RangeToString())
            .registerTypeCoercion(new IntegerToLong())
            .registerTypeCoercion(new BytesArrayToString())

            // Read API Type coercions
            .registerTypeCoercion(Timestamp::valueOf, LocalDateTime.class, Timestamp.class)
            .registerTypeCoercion(Text::toString, Text.class, String.class)
            .registerTypeCoercion(new TextToInteger())
            .registerTypeCoercion(new LongToTimestamp())
            .registerTypeCoercion(new LongToTime())
            .registerTypeCoercion(new IntegerToDate())
            .registerTypeCoercion(
                (Timestamp ts) -> Date.valueOf(ts.toLocalDateTime().toLocalDate()),
                Timestamp.class,
                Date.class)
            .registerTypeCoercion(
                (Timestamp ts) -> Time.valueOf(ts.toLocalDateTime().toLocalTime()),
                Timestamp.class,
                Time.class)
            .registerTypeCoercion(
                (Time time) -> // Per JDBC spec, the date component should be 1970-01-01
                Timestamp.valueOf(LocalDateTime.of(LocalDate.ofEpochDay(0), time.toLocalTime())),
                Time.class,
                Timestamp.class)
            .registerTypeCoercion(
                (Date date) -> new Timestamp(date.getTime()), Date.class, Timestamp.class)
            .registerTypeCoercion(new TimestampToString())
            .registerTypeCoercion(new TimeToString())
            .registerTypeCoercion((Long l) -> l != 0L, Long.class, Boolean.class)
            .registerTypeCoercion((Double d) -> d != 0.0d, Double.class, Boolean.class)
            .registerTypeCoercion(
                (BigDecimal bd) -> bd.compareTo(BigDecimal.ZERO) != 0,
                BigDecimal.class,
                Boolean.class)
            .registerTypeCoercion((Integer i) -> i != 0, Integer.class, Boolean.class)
            .registerTypeCoercion((Float f) -> f != 0.0f, Float.class, Boolean.class)
            .registerTypeCoercion((Short s) -> s.shortValue() != 0, Short.class, Boolean.class)
            .registerTypeCoercion((Boolean b) -> b ? 1L : 0L, Boolean.class, Long.class)
            .registerTypeCoercion((Boolean b) -> b ? 1.0d : 0.0d, Boolean.class, Double.class)
            .registerTypeCoercion((Boolean b) -> b ? 1.0f : 0.0f, Boolean.class, Float.class)
            .registerTypeCoercion((Boolean b) -> (short) (b ? 1 : 0), Boolean.class, Short.class)
            .registerTypeCoercion((Boolean b) -> (byte) (b ? 1 : 0), Boolean.class, Byte.class)
            .registerTypeCoercion(
                (Boolean b) -> b ? BigDecimal.ONE : BigDecimal.ZERO,
                Boolean.class,
                BigDecimal.class)
            .registerTypeCoercion(new PeriodDurationToString())
            .registerTypeCoercion(unused -> (byte) 0, Void.class, Byte.class)
            .registerTypeCoercion(unused -> 0, Void.class, Integer.class)
            .registerTypeCoercion(unused -> 0L, Void.class, Long.class)
            .registerTypeCoercion(unused -> 0D, Void.class, Double.class)
            .registerTypeCoercion(unused -> 0f, Void.class, Float.class)
            .registerTypeCoercion(unused -> (short) 0, Void.class, Short.class)
            .build();
  }

  private static class TimestampToString implements BigQueryCoercion<Timestamp, String> {
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

    @Override
    public String coerce(Timestamp value) {
      return FORMATTER.format(value.toLocalDateTime());
    }
  }

  private static class TimeToString implements BigQueryCoercion<Time, String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    @Override
    public String coerce(Time value) {
      return FORMATTER.format(value.toLocalTime());
    }
  }

  private static class PeriodDurationToString implements BigQueryCoercion<PeriodDuration, String> {

    @Override
    public String coerce(PeriodDuration value) {
      StringBuilder builder = new StringBuilder();

      // Conversion of Period
      Period period = value.getPeriod().normalized();

      builder
          .append(period.getYears())
          .append("-")
          .append(period.getMonths())
          .append(" ")
          .append(period.getDays())
          .append(" ");

      // Conversion of Duration
      Duration duration = value.getDuration();
      if (duration.isNegative()) {
        builder.append("-");
        duration = duration.negated();
      }
      long hours = duration.toHours();
      duration = duration.minusHours(hours);
      long minutes = duration.toMinutes();
      duration = duration.minusMinutes(minutes);
      long seconds = duration.getSeconds();
      duration = duration.minusSeconds(seconds);
      long microseconds = duration.toNanos() / 1000;

      builder
          .append(hours)
          .append(":")
          .append(minutes)
          .append(":")
          .append(seconds)
          .append(".")
          .append(microseconds);

      String result = builder.toString();
      result = result.replaceFirst("--", "-");

      return result;
    }
  }

  private static class IntegerToDate implements BigQueryCoercion<Integer, Date> {

    @Override
    public Date coerce(Integer value) {
      // For example int 18993 represents 2022-01-01
      // Using LocalDate here to avoid this date getting affected by local time zones.
      LocalDate date = LocalDate.ofEpochDay(Long.valueOf(value));
      return Date.valueOf(date);
    }
  }

  private static class LongToTime implements BigQueryCoercion<Long, Time> {

    @Override
    public Time coerce(Long value) {

      int HH = (int) TimeUnit.MICROSECONDS.toHours(value);
      int MM = (int) (TimeUnit.MICROSECONDS.toMinutes(value) % 60);
      int SS = (int) (TimeUnit.MICROSECONDS.toSeconds(value) % 60);

      // Note: BQ Time has a precision of up to six fractional digits (microsecond precision)
      // but java.sql.Time do not. So data after seconds is not returned.
      return new Time(HH, MM, SS);
    }
  }

  private static class LongToTimestamp implements BigQueryCoercion<Long, Timestamp> {

    @Override
    public Timestamp coerce(Long value) {
      // Long value is in microseconds. All further calculations should account for the unit.
      Instant instant = Instant.ofEpochMilli(value / 1000).plusNanos((value % 1000) * 1000);
      // JDBC is defaulting to UTC because BQ UI defaults to UTC.
      LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
      return Timestamp.valueOf(localDateTime);
    }
  }

  private static class TextToInteger implements BigQueryCoercion<Text, Integer> {

    @Override
    public Integer coerce(Text value) {
      return Integer.parseInt(value.toString());
    }
  }

  private static class FieldValueToObject implements BigQueryCoercion<FieldValue, Object> {

    @Override
    public Object coerce(FieldValue fieldValue) {
      return fieldValue.getValue();
    }
  }

  private static class FieldValueToDate implements BigQueryCoercion<FieldValue, Date> {

    @Override
    public Date coerce(FieldValue fieldValue) {
      return Date.valueOf(fieldValue.getStringValue());
    }
  }

  private static class FieldValueToTime implements BigQueryCoercion<FieldValue, Time> {

    @Override
    public Time coerce(FieldValue fieldValue) {
      // Time ranges from 00:00:00 to 23:59:59.999999 in BigQuery
      String strTime = fieldValue.getStringValue();
      try {
        LocalTime localTime = LocalTime.parse(strTime);
        // Convert LocalTime to milliseconds of the day. This correctly preserves millisecond
        // precision and truncates anything smaller
        long millis = TimeUnit.NANOSECONDS.toMillis(localTime.toNanoOfDay());
        return new Time(millis);
      } catch (java.time.format.DateTimeParseException e) {
        throw new IllegalArgumentException(
            "Cannot parse the value " + strTime + " to java.sql.Time", e);
      }
    }
  }

  private static class FieldValueToTimestamp implements BigQueryCoercion<FieldValue, Timestamp> {

    @Override
    public Timestamp coerce(FieldValue fieldValue) {
      String rawValue = fieldValue.getStringValue();
      // BigQuery DATETIME strings are formatted like "YYYY-MM-DD'T'HH:MM:SS.fffffffff"
      // BigQuery TIMESTAMP strings are numeric epoch seconds.
      if (rawValue.contains("T")) {
        // It's a DATETIME string.
        // Timestamp.valueOf() expects "yyyy-mm-dd hh:mm:ss.fffffffff" format.
        return Timestamp.valueOf(rawValue.replace('T', ' '));
      } else {
        // It's a TIMESTAMP numeric string.
        long microseconds = fieldValue.getTimestampValue();
        Instant instant = Instant.EPOCH.plus(microseconds, ChronoUnit.MICROS);
        // JDBC is defaulting to UTC because BQ UI defaults to UTC.
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        return Timestamp.valueOf(localDateTime);
      }
    }
  }

  private static class FieldValueToBytesArray implements BigQueryCoercion<FieldValue, byte[]> {

    @Override
    public byte[] coerce(FieldValue fieldValue) {
      return fieldValue.getBytesValue();
    }
  }

  private static class StringToBytesArray implements BigQueryCoercion<String, byte[]> {

    @Override
    public byte[] coerce(String value) {
      return value.getBytes();
    }
  }

  private static class BytesArrayToString implements BigQueryCoercion<byte[], String> {

    @Override
    public String coerce(byte[] value) {
      return java.util.Base64.getEncoder().encodeToString(value);
    }
  }

  private static class FieldValueToBoolean implements BigQueryCoercion<FieldValue, Boolean> {

    @Override
    public Boolean coerce(FieldValue fieldValue) {
      return !fieldValue.isNull() && fieldValue.getBooleanValue();
    }
  }

  private static class FieldValueToBigDecimal implements BigQueryCoercion<FieldValue, BigDecimal> {

    @Override
    public BigDecimal coerce(FieldValue fieldValue) {
      return fieldValue.getNumericValue();
    }
  }

  private static class FieldValueToDouble implements BigQueryCoercion<FieldValue, Double> {

    @Override
    public Double coerce(FieldValue fieldValue) {
      return fieldValue.getDoubleValue();
    }
  }

  private static class FieldValueToLong implements BigQueryCoercion<FieldValue, Long> {

    @Override
    public Long coerce(FieldValue fieldValue) {
      return fieldValue.getLongValue();
    }
  }

  private static class FieldValueToInteger implements BigQueryCoercion<FieldValue, Integer> {

    @Override
    public Integer coerce(FieldValue fieldValue) {
      return (int) fieldValue.getLongValue();
    }
  }

  private static class FieldValueToFloat implements BigQueryCoercion<FieldValue, Float> {

    @Override
    public Float coerce(FieldValue fieldValue) {
      return (float) fieldValue.getDoubleValue();
    }
  }

  private static class FieldValueToShort implements BigQueryCoercion<FieldValue, Short> {

    @Override
    public Short coerce(FieldValue fieldValue) {
      return (short) fieldValue.getLongValue();
    }
  }

  private static class FieldValueToString implements BigQueryCoercion<FieldValue, String> {

    @Override
    public String coerce(FieldValue fieldValue) {
      if (Attribute.REPEATED.equals(fieldValue.getAttribute())) { // Case for Arrays
        return fieldValue.getValue().toString();
      }
      if (Attribute.RANGE.equals(fieldValue.getAttribute())) { // Range values
        Range rangeValue = fieldValue.getRangeValue();
        return INSTANCE.coerceTo(String.class, rangeValue);
      }
      if (Attribute.RECORD.equals(fieldValue.getAttribute())) { // Case for Structs
        return fieldValue.getRecordValue().toString();
      }
      return fieldValue.getStringValue();
    }
  }

  private static class IntegerToLong implements BigQueryCoercion<Integer, Long> {

    @Override
    public Long coerce(Integer intValue) {
      if (intValue == null) {
        return 0L;
      }
      return Long.valueOf(intValue);
    }
  }

  private static class RangeToString implements BigQueryCoercion<Range, String> {

    @Override
    public String coerce(Range value) {
      FieldValue startValue = value.getStart();
      FieldValue endValue = value.getEnd();

      String start = startValue.isNull() ? "UNBOUNDED" : startValue.getStringValue();
      String end = endValue.isNull() ? "UNBOUNDED" : endValue.getStringValue();
      // The start of a range is inclusive, and the end is exclusive.
      return String.format("[%s, %s)", start, end);
    }
  }
}
