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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.BQTableSchemaToProtoDescriptor;
import com.google.cloud.bigquery.storage.v1.CivilTimeEncoder;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Int64Value;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;
import org.apache.arrow.vector.PeriodDuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BigQueryTypeRegistryTest {

  private TimeZone originalJvmZone;

  private static Stream<String> jvmZones() {
    return Stream.of("UTC", "America/New_York", "Asia/Kolkata", "Pacific/Auckland");
  }

  @BeforeEach
  public void saveJvmZone() {
    originalJvmZone = TimeZone.getDefault();
  }

  @AfterEach
  public void restoreJvmZone() {
    TimeZone.setDefault(originalJvmZone);
  }

  @Test
  public void testIntervalFormatting() throws Exception {
    Period p = Period.of(1, 2, 3);
    Duration d =
        Duration.ofHours(4).plusMinutes(5).plusSeconds(6).plusNanos(78000); // 78 microseconds
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("1-2 3 4:5:6.000078");
  }

  @Test
  public void testIntervalFormattingZeroMicroseconds() throws Exception {
    Period p = Period.of(0, 0, 0);
    Duration d = Duration.ofHours(1).plusMinutes(0).plusSeconds(0);
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("0-0 0 1:0:0.0");
  }

  @Test
  public void testIntervalFormattingNegativeDuration() throws Exception {
    Period p = Period.of(0, 0, 0);
    Duration d = Duration.ofHours(-1).minusMinutes(5).minusSeconds(6).minusNanos(78000);
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("0-0 0 -1:5:6.000078");
  }

  @Test
  public void testDateFormatting() throws Exception {
    LocalDate localDate = LocalDate.of(2026, 8, 24);
    assertThat(BigQueryTypeRegistry.convert(localDate, StandardSQLTypeName.DATE, Date.class, null))
        .isEqualTo(Date.valueOf("2026-08-24"));
  }

  @Test
  public void testTimeFormatting() throws Exception {
    LocalTime localTime = LocalTime.of(15, 30, 45, 123456000); // 123.456 ms
    assertThat(BigQueryTypeRegistry.convert(localTime, StandardSQLTypeName.TIME, Time.class, null))
        .isEqualTo(Time.valueOf("15:30:45"));
  }

  @Test
  public void testDatetimeFormatting() throws Exception {
    LocalDateTime localDateTime = LocalDateTime.of(2026, 8, 24, 15, 30, 45, 123456000);
    assertThat(
            BigQueryTypeRegistry.convert(
                localDateTime, StandardSQLTypeName.DATETIME, Timestamp.class, null))
        .isEqualTo(Timestamp.valueOf("2026-08-24 15:30:45.123456"));
  }

  @Test
  public void testTimestampFormatting() throws Exception {
    ZonedDateTime zonedDateTime =
        ZonedDateTime.of(2026, 8, 24, 15, 30, 45, 123456000, ZoneId.of("UTC"));
    assertThat(
            BigQueryTypeRegistry.convert(
                zonedDateTime, StandardSQLTypeName.TIMESTAMP, Timestamp.class, null))
        .isEqualTo(Timestamp.from(zonedDateTime.toInstant()));
  }

  @Test
  public void testTimestampToTimePreservesLocalWallClock() throws Exception {
    Timestamp ts = Timestamp.valueOf("2023-07-28 12:30:00");
    Time time = BigQueryTypeRegistry.convert(ts, StandardSQLTypeName.TIME, Time.class, null);
    assertThat(time).isEqualTo(Time.valueOf("12:30:00"));

    LocalTime localTime =
        BigQueryTypeRegistry.convert(ts, StandardSQLTypeName.TIME, LocalTime.class, null);
    assertThat(localTime).isEqualTo(LocalTime.of(12, 30, 0));
  }

  @Test
  public void testTimestampToDatePreservesLocalWallClock() throws Exception {
    Timestamp ts = Timestamp.valueOf("2023-07-28 12:30:00");
    Date date = BigQueryTypeRegistry.convert(ts, StandardSQLTypeName.DATE, Date.class, null);
    assertThat(date).isEqualTo(Date.valueOf("2023-07-28"));

    LocalDate localDate =
        BigQueryTypeRegistry.convert(ts, StandardSQLTypeName.DATE, LocalDate.class, null);
    assertThat(localDate).isEqualTo(LocalDate.of(2023, 7, 28));
  }

  @Test
  public void testDatetimeStringPreservesLocalWallClock() throws Exception {
    String dtStr = "2023-01-01 01:00:00";
    Timestamp ts =
        (Timestamp) BigQueryTypeRegistry.convert(dtStr, StandardSQLTypeName.DATETIME, null);
    assertThat(ts.toString()).isEqualTo("2023-01-01 01:00:00.0");
  }

  @Test
  public void testCoercionException() throws Exception {
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            BigQueryTypeRegistry.convert(
                "bad_number", StandardSQLTypeName.INT64, Integer.class, null));
  }

  /**
   * Read-side guard for TIMESTAMP coercions. The result sets hand the registry zone-less UTC digits
   * for {@code TIMESTAMP(12)} (see {@code BigQueryJsonResultSet.getObject}) and epoch microseconds
   * from Arrow; both must resolve to the same instant regardless of the JVM default zone. The
   * write-side counterpart lives in {@link BigQueryParameterHandlerTest}.
   *
   * <p>Without this, a coercion that silently starts depending on {@code ZoneId.systemDefault()}
   * (for example by falling through to {@code Timestamp.valueOf}) passes every unit test that pins
   * the JVM to UTC and is only caught by the integration suite.
   */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testTimestampReadCoercionsAreJvmZoneInvariant(String zone) throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone(zone));

    // The instant the backend holds, expressed at the precision each input shape carries.
    Instant nanosInstant = Instant.parse("2026-08-10T15:30:45.123456789Z");
    Instant microsInstant = Instant.parse("2026-08-10T15:30:45.123456Z");

    // Shapes the result sets pass in for a TIMESTAMP(12) column.
    String picosUtcString = "2026-08-10 15:30:45.123456789012"; // formatTimestampValue output
    String paddedMicrosString = "2026-08-10 15:30:45.123456000000"; // micros value, picos padded
    String epochDecimalString = nanosInstant.getEpochSecond() + ".123456789012"; // raw JSON
    long epochMicros =
        microsInstant.getEpochSecond() * 1_000_000L + microsInstant.getNano() / 1_000L; // Arrow

    // getTimestamp(): class-based lookup, sub-nanosecond digits truncated.
    assertThat(BigQueryTypeRegistry.convert(picosUtcString, Timestamp.class).toInstant())
        .isEqualTo(nanosInstant);
    assertThat(BigQueryTypeRegistry.convert(paddedMicrosString, Timestamp.class).toInstant())
        .isEqualTo(microsInstant);
    assertThat(BigQueryTypeRegistry.convert(epochDecimalString, Timestamp.class).toInstant())
        .isEqualTo(nanosInstant);

    // getObject(col, <JSR-310 type>): the fast path must agree and must stay anchored to UTC.
    assertThat(BigQueryTypeRegistry.convert(picosUtcString, Instant.class)).isEqualTo(nanosInstant);
    OffsetDateTime odt = BigQueryTypeRegistry.convert(picosUtcString, OffsetDateTime.class);
    assertThat(odt.toInstant()).isEqualTo(nanosInstant);
    assertThat(odt.getOffset()).isEqualTo(ZoneOffset.UTC);
    ZonedDateTime zdt = BigQueryTypeRegistry.convert(picosUtcString, ZonedDateTime.class);
    assertThat(zdt.toInstant()).isEqualTo(nanosInstant);
    assertThat(zdt.getZone()).isEqualTo(ZoneOffset.UTC);

    // ResultSet hot path keyed by BigQuery type, for both the string and the Arrow Long shape.
    assertThat(
            BigQueryTypeRegistry.convert(
                    picosUtcString, StandardSQLTypeName.TIMESTAMP, Timestamp.class, null)
                .toInstant())
        .isEqualTo(nanosInstant);
    assertThat(
            BigQueryTypeRegistry.convert(
                    epochMicros, StandardSQLTypeName.TIMESTAMP, Timestamp.class, null)
                .toInstant())
        .isEqualTo(microsInstant);
    assertThat(
            BigQueryTypeRegistry.convert(
                epochMicros, StandardSQLTypeName.TIMESTAMP, Instant.class, null))
        .isEqualTo(microsInstant);

    // Local views before 1582 follow java.time.
    Instant yearOne = Instant.parse("0001-01-01T00:00:00Z");
    long yearOneMicros = yearOne.getEpochSecond() * 1_000_000L;
    ZonedDateTime yearOneLocal = yearOne.atZone(ZoneId.of(zone));
    assertThat(
            BigQueryTypeRegistry.convert(
                yearOneMicros, StandardSQLTypeName.TIMESTAMP, LocalDateTime.class, null))
        .isEqualTo(yearOneLocal.toLocalDateTime());
    assertThat(
            BigQueryTypeRegistry.convert(
                yearOneMicros, StandardSQLTypeName.TIMESTAMP, LocalDate.class, null))
        .isEqualTo(yearOneLocal.toLocalDate());
  }

  @Test
  public void testDatetimeAndTimestampCrossTypeConversionWithZone() throws Exception {
    ZoneId utc = ZoneId.of("UTC");
    ZoneId la = ZoneId.of("America/Los_Angeles");

    Date dtDateUtc =
        BigQueryTypeRegistry.convert(
            "2000-02-15 10:30:45", StandardSQLTypeName.DATETIME, Date.class, utc);
    Date dtDateLa =
        BigQueryTypeRegistry.convert(
            "2000-02-15 10:30:45", StandardSQLTypeName.DATETIME, Date.class, la);
    assertThat(dtDateUtc.getTime()).isEqualTo(950572800000L);
    assertThat(dtDateLa.getTime()).isEqualTo(950601600000L);

    Time dtTimeUtc =
        BigQueryTypeRegistry.convert(
            "2000-02-15 10:30:45", StandardSQLTypeName.DATETIME, Time.class, utc);
    Time dtTimeLa =
        BigQueryTypeRegistry.convert(
            "2000-02-15 10:30:45", StandardSQLTypeName.DATETIME, Time.class, la);
    assertThat(dtTimeUtc.getTime()).isEqualTo(37845000L);
    assertThat(dtTimeLa.getTime()).isEqualTo(66645000L);

    Date tsDateUtc =
        BigQueryTypeRegistry.convert(
            "2025-01-01 12:34:56Z", StandardSQLTypeName.TIMESTAMP, Date.class, utc);
    Date tsDateLa =
        BigQueryTypeRegistry.convert(
            "2025-01-01 12:34:56Z", StandardSQLTypeName.TIMESTAMP, Date.class, la);
    assertThat(tsDateUtc).isEqualTo(tsDateLa);

    Time tsTimeUtc =
        BigQueryTypeRegistry.convert(
            "2025-01-01 12:34:56Z", StandardSQLTypeName.TIMESTAMP, Time.class, utc);
    Time tsTimeLa =
        BigQueryTypeRegistry.convert(
            "2025-01-01 12:34:56Z", StandardSQLTypeName.TIMESTAMP, Time.class, la);
    assertThat(tsTimeUtc).isEqualTo(tsTimeLa);
  }

  @Test
  public void testTimeMicrosecondPrecision() throws BigQueryJdbcException {
    String timeStr = "14:30:00.123456";
    long timeMicros = (14L * 3600 + 30L * 60) * 1_000_000L + 123_456L;
    LocalTime expectedLocalTime = LocalTime.of(14, 30, 0, 123_456_000);

    // Direct conversion to LocalTime and String preserves microseconds
    assertThat(
            BigQueryTypeRegistry.convert(timeStr, StandardSQLTypeName.TIME, LocalTime.class, null))
        .isEqualTo(expectedLocalTime);
    assertThat(
            BigQueryTypeRegistry.convert(
                timeMicros, StandardSQLTypeName.TIME, LocalTime.class, null))
        .isEqualTo(expectedLocalTime);
    assertThat(BigQueryTypeRegistry.convert(timeStr, StandardSQLTypeName.TIME, String.class, null))
        .isEqualTo("14:30:00.123456");
    assertThat(
            BigQueryTypeRegistry.convert(timeMicros, StandardSQLTypeName.TIME, String.class, null))
        .isEqualTo("14:30:00.123456");
    assertThat(
            BigQueryTypeRegistry.convert("12:30:00", StandardSQLTypeName.TIME, String.class, null))
        .isEqualTo("12:30:00");

    // Standard java.sql.Time conversion retains pure JDK Time contract
    Time sqlTime = (Time) BigQueryTypeRegistry.convert(timeStr, StandardSQLTypeName.TIME, null);
    assertThat(sqlTime.getClass()).isEqualTo(Time.class);
    assertThat(sqlTime.toString()).isEqualTo("14:30:00");
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testDatetimeReadCoercionsPreserveCivilDigits(String zone) throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone(zone));
    LocalDateTime gapLdt = LocalDateTime.of(2025, 3, 9, 2, 30, 0);
    ZoneId utc = ZoneId.of("UTC");

    for (Object raw : Arrays.asList("2025-03-09 02:30:00", gapLdt)) {
      assertThat(BigQueryTypeRegistry.convert(raw, StandardSQLTypeName.DATETIME, Date.class, null))
          .isEqualTo(Date.valueOf(gapLdt.toLocalDate()));
      assertThat(BigQueryTypeRegistry.convert(raw, StandardSQLTypeName.DATETIME, Time.class, null))
          .isEqualTo(Time.valueOf(gapLdt.toLocalTime()));
      assertThat(
              BigQueryTypeRegistry.convert(raw, StandardSQLTypeName.DATETIME, Time.class, utc)
                  .getTime())
          .isEqualTo(Duration.ofHours(2).plusMinutes(30).toMillis());
    }
  }

  private static BigQueryJdbcParameter param(int idx, Object val, StandardSQLTypeName sqlType) {
    BigQueryJdbcParameter p = new BigQueryJdbcParameter();
    p.setIndex(idx);
    p.setValue(val);
    p.bindType(val != null ? val.getClass() : Object.class, sqlType);
    return p;
  }

  private static boolean cellOk(Field field, Object val, StandardSQLTypeName sqlType) {
    return BigQueryTypeRegistry.isCompatibleWithWriteApi(field, param(1, val, sqlType));
  }

  @Test
  public void testWriteApiPredicatesBoundsProtoSymmetryAndNegativePaths() throws Exception {
    assertThat(BigQueryTypeRegistry.isSupportedWriteApiField(null)).isFalse();
    for (StandardSQLTypeName type : StandardSQLTypeName.values()) {
      if (type != StandardSQLTypeName.ARRAY && type != StandardSQLTypeName.STRUCT) {
        assertThat(BigQueryTypeRegistry.isSupportedWriteApiField(Field.of("c", type)))
            .isEqualTo(type != StandardSQLTypeName.RANGE);
      }
    }
    Field rep =
        Field.newBuilder("a", StandardSQLTypeName.STRING).setMode(Field.Mode.REPEATED).build();
    Field rec = Field.of("r", StandardSQLTypeName.STRUCT, Field.of("s", StandardSQLTypeName.INT64));
    assertThat(BigQueryTypeRegistry.isSupportedWriteApiField(rep)).isFalse();
    assertThat(BigQueryTypeRegistry.isSupportedWriteApiField(rec)).isFalse();
    assertThat(BigQueryTypeRegistry.isSupportedJavaValue(StandardSQLTypeName.INT64, BigInteger.ONE))
        .isFalse();
    java.util.Date utilDate = new java.util.Date(1000L);
    assertThat(BigQueryTypeRegistry.isSupportedJavaValue(StandardSQLTypeName.TIMESTAMP, utilDate))
        .isFalse();
    Field reqStr =
        Field.newBuilder("r", StandardSQLTypeName.STRING).setMode(Field.Mode.REQUIRED).build();
    Field num52 =
        Field.newBuilder("n52", StandardSQLTypeName.NUMERIC).setPrecision(5L).setScale(2L).build();
    Field bnum = Field.of("bn", StandardSQLTypeName.BIGNUMERIC);
    BigDecimal bnMin =
        new BigDecimal(
            "-578960446186580977117854925043439539266.34992332820282019728792003956564819968");
    BigDecimal extremeNegScale = BigDecimal.valueOf(1L, Integer.MIN_VALUE);
    assertThat(cellOk(reqStr, null, StandardSQLTypeName.STRING)).isFalse();
    assertThat(cellOk(num52, new BigDecimal("999.9900"), StandardSQLTypeName.NUMERIC)).isTrue();
    assertThat(cellOk(num52, new BigDecimal("12.345"), StandardSQLTypeName.NUMERIC)).isFalse();
    assertThat(cellOk(bnum, bnMin, StandardSQLTypeName.BIGNUMERIC)).isTrue();
    assertThat(cellOk(bnum, extremeNegScale, StandardSQLTypeName.BIGNUMERIC)).isFalse();
    LocalDate dateVal = LocalDate.of(1582, 10, 10);
    LocalTime ltVal = LocalTime.of(9, 8, 7, 123_456_789);
    LocalDateTime ldtVal = LocalDateTime.of(2025, 3, 9, 2, 30, 5, 654_321_987);
    LocalDateTime expLdt = LocalDateTime.of(2025, 3, 9, 2, 30, 5, 654_321_000);
    Instant subMicro = Instant.parse("1969-12-31T23:59:59.999999900Z");
    Instant expSub = Instant.parse("1969-12-31T23:59:59.999999Z");
    Timestamp ts12Val = Timestamp.from(Instant.parse("2024-01-01T12:34:56.123456789Z"));
    Instant expTs12 = Instant.parse("2024-01-01T12:34:56.123456Z");
    Object[][] spec = {
      {"c_null", StandardSQLTypeName.STRING, null, null},
      {"col-é", StandardSQLTypeName.STRING, "héllo", "héllo"},
      {"c_bytes", StandardSQLTypeName.BYTES, new byte[] {-1, 7}, new byte[] {-1, 7}},
      {"c_bool", StandardSQLTypeName.BOOL, true, true},
      {"c_int", StandardSQLTypeName.INT64, (short) 42, 42L},
      {"c_flt", StandardSQLTypeName.FLOAT64, 0.5f, 0.5d},
      {"c_num", StandardSQLTypeName.NUMERIC, new BigDecimal("12.300"), new BigDecimal("12.3")},
      {"c_bnum", StandardSQLTypeName.BIGNUMERIC, 90L, BigDecimal.valueOf(90L)},
      {"c_date", StandardSQLTypeName.DATE, dateVal, dateVal},
      {"c_time", StandardSQLTypeName.TIME, ltVal, LocalTime.of(9, 8, 7, 123_456_000)},
      {"c_dt", StandardSQLTypeName.DATETIME, ldtVal, expLdt},
      {"c_ts6", StandardSQLTypeName.TIMESTAMP, subMicro, expSub},
      {"c_ts12", StandardSQLTypeName.TIMESTAMP, ts12Val, expTs12},
      {"c_json", StandardSQLTypeName.JSON, new JsonObject(), "{}"},
      {"c_geo", StandardSQLTypeName.GEOGRAPHY, "POINT(1 2)", "POINT(1 2)"},
      {"c_iv", StandardSQLTypeName.INTERVAL, "1-0 0 0:0:0", "1-0 0 0:0:0"}
    };
    List<Field> fields = new ArrayList<>();
    TableSchema.Builder schemaBuilder = TableSchema.newBuilder();
    List<BigQueryJdbcParameter> params = new ArrayList<>();
    for (int i = 0; i < spec.length; i++) {
      String colName = (String) spec[i][0];
      StandardSQLTypeName bqType = (StandardSQLTypeName) spec[i][1];
      TableFieldSchema.Type protoType =
          bqType == StandardSQLTypeName.FLOAT64
              ? TableFieldSchema.Type.DOUBLE
              : TableFieldSchema.Type.valueOf(bqType.name());
      fields.add(Field.of(colName, bqType));
      TableFieldSchema.Builder fb =
          TableFieldSchema.newBuilder().setName(colName).setType(protoType);
      fb.setMode(i == 3 ? TableFieldSchema.Mode.REQUIRED : TableFieldSchema.Mode.NULLABLE);
      if ("c_ts12".equals(colName)) {
        fb.setTimestampPrecision(Int64Value.of(12L));
      }
      schemaBuilder.addFields(fb.build());
      params.add(param(i + 1, spec[i][2], bqType));
    }
    Descriptor desc =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(schemaBuilder.build());
    BigQueryTypeRegistry.ResolvedWriteColumn[] cols =
        BigQueryTypeRegistry.resolveWriteApiColumns(desc, FieldList.of(fields));
    DynamicMessage msg =
        DynamicMessage.parseFrom(desc, BigQueryTypeRegistry.encodeWriteApiRow(desc, cols, params));
    assertThat(msg.hasField(cols[0].fieldDescriptor)).isFalse();
    for (int i = 1; i < spec.length; i++) {
      Object raw = msg.getField(cols[i].fieldDescriptor);
      Object actual =
          i == 9
              ? CivilTimeEncoder.decodePacked64TimeMicrosLocalTime((Long) raw)
              : BigQueryTypeRegistry.convert(
                  raw, cols[i].typeDescriptor.getBqType(), spec[i][3].getClass(), null);
      assertThat(actual).isEqualTo(spec[i][3]);
    }
    assertThrows(
        BigQueryJdbcException.class,
        () -> BigQueryTypeRegistry.resolveWriteApiColumns(desc, FieldList.of(reqStr)));
    for (int badIdx : new int[] {6, 3}) {
      params.get(badIdx).setValue(badIdx == 6 ? 1.5d : null);
      assertThrows(
          BigQueryJdbcException.class,
          () -> BigQueryTypeRegistry.encodeWriteApiRow(desc, cols, params));
    }
  }
}
