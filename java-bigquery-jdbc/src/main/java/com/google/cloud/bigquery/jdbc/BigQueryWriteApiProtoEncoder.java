/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.BigDecimalByteStringEncoder;
import com.google.cloud.bigquery.storage.v1.BigQuerySchemaUtil;
import com.google.cloud.bigquery.storage.v1.CivilTimeEncoder;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

/**
 * Encodes bound JDBC batch parameters directly into Storage Write API {@link DynamicMessage}
 * Protobuf row bytes without intermediate JSON trees or string re-parsing, preserving exact value
 * parity with the REST SQL parameter path ({@link BigQueryParameterHandler}).
 */
final class BigQueryWriteApiProtoEncoder {

  private static final DateTimeFormatter DATE_STRICT =
      DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.ROOT)
          .withResolverStyle(ResolverStyle.STRICT);
  private static final DateTimeFormatter DATETIME_STRICT =
      DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSS", Locale.ROOT)
          .withResolverStyle(ResolverStyle.STRICT);

  private BigQueryWriteApiProtoEncoder() {}

  static final class ResolvedColumn {
    final FieldDescriptor fieldDescriptor;
    final StandardSQLTypeName sqlType;

    private ResolvedColumn(FieldDescriptor fieldDescriptor, StandardSQLTypeName sqlType) {
      this.fieldDescriptor = fieldDescriptor;
      this.sqlType = sqlType;
    }
  }

  static ResolvedColumn[] resolveColumns(Descriptor descriptor, FieldList insertFields)
      throws BigQueryJdbcException {
    if (descriptor == null) {
      throw new BigQueryJdbcException("Missing ProtoSchema descriptor for Storage Write API.");
    }
    ResolvedColumn[] resolved = new ResolvedColumn[insertFields.size()];
    for (int i = 0; i < insertFields.size(); i++) {
      Field field = insertFields.get(i);
      String lower = field.getName().toLowerCase(Locale.ROOT);
      String protoName =
          BigQuerySchemaUtil.isProtoCompatible(lower)
              ? lower
              : BigQuerySchemaUtil.generatePlaceholderFieldName(lower);
      FieldDescriptor fd = descriptor.findFieldByName(protoName);
      if (fd == null || field.getType() == null || field.getType().getStandardType() == null) {
        throw new BigQueryJdbcException(
            "Missing ProtoSchema field descriptor for column: " + field.getName());
      }
      resolved[i] = new ResolvedColumn(fd, field.getType().getStandardType());
    }
    return resolved;
  }

  static ByteString encodeRow(
      Descriptor descriptor, ResolvedColumn[] columns, List<BigQueryJdbcParameter> parameterList)
      throws BigQueryJdbcException {
    DynamicMessage.Builder row = DynamicMessage.newBuilder(descriptor);
    for (int j = 0; j < parameterList.size(); j++) {
      Object val = parameterList.get(j).getValue();
      if (val == null) {
        continue;
      }
      ResolvedColumn col = columns[j];
      row.setField(col.fieldDescriptor, toProtoFieldValue(col, val));
    }
    return row.build().toByteString();
  }

  private static Object toProtoFieldValue(ResolvedColumn col, Object val)
      throws BigQueryJdbcException {
    try {
      switch (col.sqlType) {
        case STRING:
        case JSON:
        case GEOGRAPHY:
        case INTERVAL:
          return val.toString();
        case BYTES:
          return ByteString.copyFrom((byte[]) val);
        case BOOL:
          return (Boolean) val;
        case INT64:
          return ((Number) val).longValue();
        case FLOAT64:
          return ((Number) val).doubleValue();
        case NUMERIC:
        case BIGNUMERIC:
          BigDecimal bd =
              val instanceof BigDecimal
                  ? (BigDecimal) val
                  : BigDecimal.valueOf(((Number) val).longValue());
          BigDecimal norm = bd.signum() == 0 ? BigDecimal.ZERO : bd.stripTrailingZeros();
          return col.sqlType == StandardSQLTypeName.NUMERIC
              ? BigDecimalByteStringEncoder.encodeToNumericByteString(norm)
              : BigDecimalByteStringEncoder.encodeToBigNumericByteString(norm);
        case DATE:
          LocalDate ld =
              val instanceof LocalDate
                  ? (LocalDate) val
                  : LocalDate.parse(val.toString(), DATE_STRICT);
          return (int) ld.toEpochDay();
        case TIME:
          LocalTime lt =
              val instanceof LocalTime
                  ? ((LocalTime) val).truncatedTo(ChronoUnit.MICROS)
                  : LocalTime.parse(val.toString());
          return CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(lt);
        case DATETIME:
          LocalDateTime ldt =
              val instanceof LocalDateTime
                  ? ((LocalDateTime) val).truncatedTo(ChronoUnit.MICROS)
                  : LocalDateTime.parse((String) val, DATETIME_STRICT);
          return CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(ldt);
        case TIMESTAMP:
          Instant inst = extractInstant(val);
          if (inst == null) {
            throw new IllegalArgumentException("Unsupported TIMESTAMP value: " + val.getClass());
          }
          if (col.fieldDescriptor.getType() == FieldDescriptor.Type.STRING) {
            // BigQuery's SQL backend currently truncates TIMESTAMP-typed query parameters to
            // microseconds even on TIMESTAMP(12) columns (b/419328655; see
            // ITJdbcTimestampPicosTest).
            // Passing enableTimestampPicos=false preserves exact parity with standard
            // executeBatch().
            return BigQueryParameterHandler.formatInstantUtc(inst, false);
          }
          return Math.addExact(
              Math.multiplyExact(inst.getEpochSecond(), 1_000_000L), inst.getNano() / 1_000L);
        default:
          throw new BigQueryJdbcException(
              "Unsupported Storage Write API column type: " + col.sqlType);
      }
    } catch (RuntimeException ex) {
      throw new BigQueryJdbcException(
          "Failed to encode parameter for column " + col.fieldDescriptor.getName(), ex);
    }
  }

  static Instant extractInstant(Object value) {
    if (value instanceof Timestamp) {
      return ((Timestamp) value).toInstant();
    }
    if (value instanceof Instant) {
      return (Instant) value;
    }
    if (value instanceof OffsetDateTime) {
      return ((OffsetDateTime) value).toInstant();
    }
    if (value instanceof ZonedDateTime) {
      return ((ZonedDateTime) value).toInstant();
    }
    if (value instanceof java.util.Date && !(value instanceof Date) && !(value instanceof Time)) {
      return Instant.ofEpochMilli(((java.util.Date) value).getTime());
    }
    return null;
  }
}
