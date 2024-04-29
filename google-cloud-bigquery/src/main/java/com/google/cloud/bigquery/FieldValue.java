/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static java.time.temporal.ChronoUnit.MICROS;

import com.google.api.client.util.Data;
import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.extra.PeriodDuration;

/**
 * Google BigQuery Table Field Value class. Objects of this class represent values of a BigQuery
 * Table Field. A list of values forms a table row. Tables rows can be gotten as the result of a
 * query or when listing table data.
 */
public class FieldValue implements Serializable {

  private static final int MICROSECONDS = 1000000;
  private static final long serialVersionUID = 469098630191710061L;

  private final Attribute attribute;
  private final Object value;

  /** The field value's attribute, giving information on the field's content type. */
  public enum Attribute {
    /**
     * A primitive field value. A {@code FieldValue} is primitive when the corresponding field has
     * type {@link LegacySQLTypeName#BYTES}, {@link LegacySQLTypeName#BOOLEAN}, {@link
     * LegacySQLTypeName#STRING}, {@link LegacySQLTypeName#FLOAT}, {@link
     * LegacySQLTypeName#INTEGER}, {@link LegacySQLTypeName#NUMERIC}, {@link
     * LegacySQLTypeName#TIMESTAMP}, {@link LegacySQLTypeName#GEOGRAPHY} or the value is set to
     * {@code null}.
     */
    PRIMITIVE,

    /** A {@code FieldValue} for a field with {@link Field.Mode#REPEATED} mode. */
    REPEATED,

    /** A {@code FieldValue} for a field of type {@link LegacySQLTypeName#RECORD}. */
    RECORD,

    /** A {@code FieldValue} for a field of type {@link LegacySQLTypeName#RANGE}. */
    RANGE
  }

  private FieldValue(Attribute attribute, Object value) {
    this.attribute = checkNotNull(attribute);
    this.value = value;
  }

  /**
   * Returns the attribute of this Field Value.
   *
   * @return {@link Attribute#PRIMITIVE} if the field is a primitive type ({@link
   *     LegacySQLTypeName#BYTES}, {@link LegacySQLTypeName#BOOLEAN}, {@link
   *     LegacySQLTypeName#STRING}, {@link LegacySQLTypeName#FLOAT}, {@link
   *     LegacySQLTypeName#INTEGER}, {@link LegacySQLTypeName#NUMERIC}, {@link
   *     LegacySQLTypeName#TIMESTAMP}, {@link LegacySQLTypeName#GEOGRAPHY}) or is {@code null}.
   *     <p>Returns {@link Attribute#REPEATED} if the corresponding field has ({@link
   *     Field.Mode#REPEATED}) mode. Returns {@link Attribute#RECORD} if the corresponding field is
   *     a {@link LegacySQLTypeName#RECORD} type.
   */
  public Attribute getAttribute() {
    return attribute;
  }

  /** Returns {@code true} if this field's value is {@code null}, {@code false} otherwise. */
  public boolean isNull() {
    return value == null;
  }

  /**
   * Returns this field's value as an {@link Object}. If {@link #isNull()} is {@code true} this
   * method returns {@code null}.
   */
  public Object getValue() {
    return value;
  }

  /**
   * Returns this field's value as a {@link String}. This method should only be used if the
   * corresponding field has primitive type ({@link LegacySQLTypeName#BYTES}, {@link
   * LegacySQLTypeName#BOOLEAN}, {@link LegacySQLTypeName#STRING}, {@link LegacySQLTypeName#FLOAT},
   * {@link LegacySQLTypeName#INTEGER}, {@link LegacySQLTypeName#NUMERIC} {@link
   * LegacySQLTypeName#TIMESTAMP}).
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public String getStringValue() {
    checkNotNull(value);
    return (String) value;
  }

  /**
   * Returns this field's value as a {@link String}, or defaultValue if {@link #isNull()} returns
   * {@code true}. See {@link #getStringValue()} for more details.
   *
   * @throws ClassCastException if the field is not a primitive type
   */
  @SuppressWarnings("unchecked")
  public String getStringValueOrDefault(String defaultValue) {
    if (isNull()) {
      return defaultValue;
    }
    return getStringValue();
  }

  /**
   * Returns this field's value as a byte array. This method should only be used if the
   * corresponding field has primitive type ({@link LegacySQLTypeName#BYTES}.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   * @throws IllegalStateException if the field value is not encoded in base64
   */
  public byte[] getBytesValue() {
    try {
      return BaseEncoding.base64().decode(getStringValue());
    } catch (IllegalArgumentException ex) {
      throw new IllegalStateException(ex);
    }
  }

  /**
   * Returns this field's value as a {@code long}. This method should only be used if the
   * corresponding field has {@link LegacySQLTypeName#INTEGER} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Integer}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public long getLongValue() {
    return Long.parseLong(getStringValue());
  }

  /**
   * Returns this field's value as a {@link Double}. This method should only be used if the
   * corresponding field has {@link LegacySQLTypeName#FLOAT} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Double}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public double getDoubleValue() {
    return Double.parseDouble(getStringValue());
  }

  /**
   * Returns this field's value as a {@link Boolean}. This method should only be used if the
   * corresponding field has {@link LegacySQLTypeName#BOOLEAN} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws IllegalStateException if the field's value could not be converted to {@link Boolean}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public boolean getBooleanValue() {
    String stringValue = getStringValue();
    checkState(
        stringValue.equalsIgnoreCase("true") || stringValue.equalsIgnoreCase("false"),
        "Field value is not of boolean type");
    return Boolean.parseBoolean(stringValue);
  }

  /**
   * Returns this field's value as a {@code long}, representing a timestamp in microseconds since
   * epoch (UNIX time). This method should only be used if the corresponding field has {@link
   * LegacySQLTypeName#TIMESTAMP} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Long}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public long getTimestampValue() {
    // timestamps are encoded in the format 1408452095.22 where the integer part is seconds since
    // epoch (e.g. 1408452095.22 == 2014-08-19 07:41:35.220 -05:00)
    BigDecimal secondsWithMicro = new BigDecimal(getStringValue());
    // Rounding the BigDecimal to the nearest whole number before setting the longValue in order to
    // address TimeStamp rounding issue described in
    // https://github.com/googleapis/java-bigquery/issues/1644
    BigDecimal scaled = secondsWithMicro.scaleByPowerOfTen(6).setScale(0, RoundingMode.HALF_UP);
    return scaled.longValue();
  }

  /**
   * Returns this field's value as a {@code String}, representing a timestamp as an Instant. This
   * method should only be used if the corresponding field has {@link LegacySQLTypeName#TIMESTAMP}
   * type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link Long}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public Instant getTimestampInstant() {
    checkNotNull(value);
    return Instant.EPOCH.plus(getTimestampValue(), MICROS);
  }

  /**
   * Returns this field's value as a {@link java.math.BigDecimal}. This method should only be used
   * if the corresponding field has {@link LegacySQLTypeName#NUMERIC} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NumberFormatException if the field's value could not be converted to {@link
   *     java.math.BigDecimal}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public BigDecimal getNumericValue() {
    return new BigDecimal(getStringValue());
  }

  /**
   * Returns this field's value as a {@link Range}. This method should only be used * if the
   * corresponding field has {@link LegacySQLTypeName#RANGE} type.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws IllegalArgumentException if the field's value could not be converted to {@link Range}
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public Range getRangeValue() {
    if (attribute == Attribute.RANGE) {
      return (Range) value;
    }
    // Provide best effort to convert value to Range object.
    return Range.of(getStringValue());
  }

  /**
   * Returns this field's value as a list of {@link FieldValue}. This method should only be used if
   * the corresponding field has {@link Field.Mode#REPEATED} mode (i.e. {@link #getAttribute()} is
   * {@link Attribute#REPEATED}).
   *
   * @throws ClassCastException if the field has not {@link Field.Mode#REPEATED} mode
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  @SuppressWarnings("unchecked")
  public List<FieldValue> getRepeatedValue() {
    checkNotNull(value);
    return (List<FieldValue>) value;
  }

  /**
   * Returns this field's value as a {@link org.threeten.extra.PeriodDuration}. This method should
   * be used if the corresponding field has {@link StandardSQLTypeName#INTERVAL} type, or if it is a
   * legal canonical format "[sign]Y-M [sign]D [sign]H:M:S[.F]", e.g. "123-7 -19 0:24:12.000006" or
   * ISO 8601.
   *
   * @throws ClassCastException if the field is not a primitive type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   * @throws IllegalArgumentException if the field cannot be converted to a legal interval
   */
  @SuppressWarnings("unchecked")
  public PeriodDuration getPeriodDuration() {
    checkNotNull(value);
    try {
      // Try parsing from ISO 8601
      return PeriodDuration.parse(getStringValue());
    } catch (DateTimeParseException dateTimeParseException) {
      // Try parsing from canonical interval format
      return parseCanonicalInterval(getStringValue());
    }
  }

  /**
   * Returns this field's value as a {@link FieldValueList} instance. This method should only be
   * used if the corresponding field has {@link LegacySQLTypeName#RECORD} type (i.e. {@link
   * #getAttribute()} is {@link Attribute#RECORD}).
   *
   * @throws ClassCastException if the field is not a {@link LegacySQLTypeName#RECORD} type
   * @throws NullPointerException if {@link #isNull()} returns {@code true}
   */
  public FieldValueList getRecordValue() {
    checkNotNull(value);
    return (FieldValueList) value;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attribute", attribute)
        .add("value", value)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(attribute, value);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(FieldValue.class)) {
      return false;
    }
    FieldValue other = (FieldValue) obj;
    return attribute == other.attribute && Objects.equals(value, other.value);
  }

  /**
   * Creates an instance of {@code FieldValue}, useful for testing.
   *
   * <p>If the {@code attribute} is {@link Attribute#PRIMITIVE}, the {@code value} should be the
   * string representation of the underlying value, eg {@code "123"} for number {@code 123}.
   *
   * <p>If the {@code attribute} is {@link Attribute#REPEATED} or {@link Attribute#RECORD}, the
   * {@code value} should be {@code List} of {@link FieldValue}s or {@link FieldValueList},
   * respectively.
   *
   * <p>This method is unstable. See <a
   * href="https://github.com/googleapis/google-cloud-java/pull/2891">this discussion</a> for more
   * context.
   */
  @BetaApi
  public static FieldValue of(Attribute attribute, Object value) {
    return new FieldValue(attribute, value);
  }

  static FieldValue fromPb(Object cellPb) {
    return fromPb(cellPb, null);
  }

  @SuppressWarnings("unchecked")
  static FieldValue fromPb(Object cellPb, Field recordSchema) {
    if (Data.isNull(cellPb)) {
      return FieldValue.of(Attribute.PRIMITIVE, null);
    }
    if (cellPb instanceof String) {
      if ((recordSchema != null)
          && (recordSchema.getType() == LegacySQLTypeName.RANGE)
          && (recordSchema.getRangeElementType() != null)) {
        return FieldValue.of(
            Attribute.RANGE, Range.of((String) cellPb, recordSchema.getRangeElementType()));
      }
      return FieldValue.of(Attribute.PRIMITIVE, cellPb);
    }
    if (cellPb instanceof List) {
      return FieldValue.of(Attribute.REPEATED, FieldValueList.fromPb((List<Object>) cellPb, null));
    }
    if (cellPb instanceof Map) {
      Map<String, Object> cellMapPb = (Map<String, Object>) cellPb;
      if (cellMapPb.containsKey("f")) {
        FieldList subFieldsSchema = recordSchema != null ? recordSchema.getSubFields() : null;
        return FieldValue.of(
            Attribute.RECORD,
            FieldValueList.fromPb((List<Object>) cellMapPb.get("f"), subFieldsSchema));
      }
      // This should never be the case when we are processing a first level table field (i.e. a
      // row's field, not a record sub-field)
      if (cellMapPb.containsKey("v")) {
        return FieldValue.fromPb(cellMapPb.get("v"), recordSchema);
      }
    }
    throw new IllegalArgumentException("Unexpected table cell format");
  }

  /**
   * Parse interval in canonical format and create instance of {@code PeriodDuration}.
   *
   * <p>The parameter {@code interval} should be an interval in the canonical format: "[sign]Y-M
   * [sign]D [sign]H:M:S[.F]". More details <a href=
   * "https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types#canonical_format_3">
   * here</a>
   *
   * @throws IllegalArgumentException if the {@code interval} is not a valid interval
   */
  static PeriodDuration parseCanonicalInterval(String interval) throws IllegalArgumentException {
    // Pattern is [sign]Y-M [sign]D [sign]H:M:S[.F]
    Pattern pattern =
        Pattern.compile(
            "(?<sign1>[+-])?(?<year>\\d+)-(?<month>\\d+) (?<sign2>[-|+])?(?<day>\\d+) (?<sign3>[-|+])?(?<hours>\\d+):(?<minutes>\\d+):(?<seconds>\\d+)(\\.(?<fraction>\\d+))?");
    Matcher matcher = pattern.matcher(interval);
    if (!matcher.find()) {
      throw new IllegalArgumentException();
    }
    String sign1 = matcher.group("sign1");
    String year = matcher.group("year");
    String month = matcher.group("month");
    String sign2 = matcher.group("sign2");
    String day = matcher.group("day");
    String sign3 = matcher.group("sign3");
    String hours = matcher.group("hours");
    String minutes = matcher.group("minutes");
    String seconds = matcher.group("seconds");
    String fraction = matcher.group("fraction");

    int yearInt = Integer.parseInt(year);
    int monthInt = Integer.parseInt(month);
    if (Objects.equals(sign1, "-")) {
      yearInt *= -1;
      monthInt *= -1;
    }

    int dayInt = Integer.parseInt(day);
    if (Objects.equals(sign2, "-")) {
      dayInt *= -1;
    }
    if (sign3 == null) {
      sign3 = "";
    }

    String durationString =
        sign3
            + "PT"
            + hours
            + "H"
            + minutes
            + "M"
            + seconds
            + (fraction == null ? "" : "." + fraction)
            + "S";

    return PeriodDuration.of(Period.of(yearInt, monthInt, dayInt), Duration.parse(durationString));
  }
}
