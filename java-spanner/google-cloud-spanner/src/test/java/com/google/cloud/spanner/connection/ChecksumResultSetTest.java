/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Struct.Builder;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChecksumResultSetTest {
  private static final Struct DIFFERENT_NON_NULL_VALUES =
      Struct.newBuilder()
          .set("boolVal")
          .to(false)
          .set("longVal")
          .to(2 * 2)
          .set("doubleVal")
          .to(Value.float64(3.14d * 2d))
          .set("floatVal")
          .to(Value.float32(3.14f * 3f))
          .set("bigDecimalVal")
          .to(Value.numeric(BigDecimal.valueOf(123 * 2, 2)))
          .set("pgNumericVal")
          .to(Value.pgNumeric("2.46"))
          .set("stringVal")
          .to("testtest")
          .set("jsonVal")
          .to(Value.json("{\"color\":\"red\",\"value\":\"#ff0\"}"))
          .set("pgJsonbVal")
          .to(Value.pgJsonb("{\"color\":\"red\",\"value\":\"#00f\"}"))
          .set("pgOidVal")
          .to(Value.pgOid(2 * 2))
          .set("protoMessageVal")
          .to(SingerInfo.newBuilder().setSingerId(23).build())
          .set("protoEnumVal")
          .to(Genre.JAZZ)
          .set("byteVal")
          .to(Value.bytes(ByteArray.copyFrom("bytes".getBytes(StandardCharsets.UTF_8))))
          .set("timestamp")
          .to(Timestamp.parseTimestamp("2022-08-04T11:20:00.123456789Z"))
          .set("date")
          .to(Date.fromYearMonthDay(2022, 8, 3))
          .set("uuid")
          .to(UUID.randomUUID())
          .set("interval")
          .to(Interval.parseFromString("P8Y2M3DT4H5M6.789123456S"))
          .set("boolArray")
          .to(Value.boolArray(Arrays.asList(Boolean.FALSE, null, Boolean.TRUE)))
          .set("longArray")
          .to(Value.int64Array(Arrays.asList(2L, null, 1L, 0L)))
          .set("doubleArray")
          .to(Value.float64Array(Arrays.asList(3.14d, null, 6.6626d, 10.1d)))
          .set("floatArray")
          .to(Value.float32Array(Arrays.asList(2.71f, null, 6.6626f, 10.1f)))
          .set("bigDecimalArray")
          .to(Value.numericArray(Arrays.asList(BigDecimal.TEN, null, BigDecimal.ONE)))
          .set("pgNumericArray")
          .to(Value.pgNumericArray(Arrays.asList("10", null, "1", "NaN")))
          .set("byteArray")
          .to(
              Value.bytesArray(
                  Arrays.asList(ByteArray.copyFrom("test2"), null, ByteArray.copyFrom("test1"))))
          .set("timestampArray")
          .to(
              Value.timestampArray(
                  Arrays.asList(
                      Timestamp.parseTimestamp("2000-01-01T00:00:00Z"),
                      null,
                      Timestamp.parseTimestamp("2022-07-04T10:24:00.123456789Z"))))
          .set("dateArray")
          .to(
              Value.dateArray(
                  Arrays.asList(Date.parseDate("2000-01-01"), null, Date.parseDate("2022-08-03"))))
          .set("uuidArray")
          .to(Value.uuidArray(Arrays.asList(UUID.randomUUID(), UUID.randomUUID())))
          .set("intervalArray")
          .to(
              Value.intervalArray(
                  Arrays.asList(
                      Interval.parseFromString("P1Y2M-3DT4H5M6.789123456S"),
                      null,
                      Interval.parseFromString("P-1Y-2M-3DT-4H-5M-6.789123456S"))))
          .set("stringArray")
          .to(Value.stringArray(Arrays.asList("test2", null, "test1")))
          .set("jsonArray")
          .to(Value.jsonArray(Arrays.asList("{\"color\":\"red\",\"value\":\"#f00\"}", null, "[]")))
          .set("pgJsonbArray")
          .to(
              Value.pgJsonbArray(
                  Arrays.asList("{\"color\":\"red\",\"value\":\"#f00\"}", null, "[]")))
          .set("pgOidArray")
          .to(Value.pgOidArray(Arrays.asList(2L, null, 1L, 0L)))
          .set("protoMessageArray")
          .to(
              Value.protoMessageArray(
                  Arrays.asList(
                      SingerInfo.newBuilder().setSingerId(23).build(),
                      SingerInfo.getDefaultInstance()),
                  SingerInfo.getDescriptor()))
          .set("protoEnumArray")
          .to(Value.protoEnumArray(Arrays.asList(Genre.JAZZ, Genre.ROCK), Genre.getDescriptor()))
          .build();

  @Test
  public void testRetry() {
    Type type =
        Type.struct(
            Type.StructField.of("boolVal", Type.bool()),
            Type.StructField.of("longVal", Type.int64()),
            Type.StructField.of("doubleVal", Type.float64()),
            Type.StructField.of("floatVal", Type.float32()),
            Type.StructField.of("bigDecimalVal", Type.numeric()),
            Type.StructField.of("pgNumericVal", Type.pgNumeric()),
            Type.StructField.of("stringVal", Type.string()),
            Type.StructField.of("jsonVal", Type.json()),
            Type.StructField.of("pgJsonbVal", Type.pgJsonb()),
            Type.StructField.of("pgOidVal", Type.pgOid()),
            Type.StructField.of(
                "protoMessageVal", Type.proto(SingerInfo.getDescriptor().getFullName())),
            Type.StructField.of(
                "protoEnumVal", Type.protoEnum(Genre.getDescriptor().getFullName())),
            Type.StructField.of("byteVal", Type.bytes()),
            Type.StructField.of("timestamp", Type.timestamp()),
            Type.StructField.of("date", Type.date()),
            Type.StructField.of("uuid", Type.uuid()),
            Type.StructField.of("interval", Type.interval()),
            Type.StructField.of("boolArray", Type.array(Type.bool())),
            Type.StructField.of("longArray", Type.array(Type.int64())),
            Type.StructField.of("doubleArray", Type.array(Type.float64())),
            Type.StructField.of("floatArray", Type.array(Type.float32())),
            Type.StructField.of("bigDecimalArray", Type.array(Type.numeric())),
            Type.StructField.of("pgNumericArray", Type.array(Type.pgNumeric())),
            Type.StructField.of("byteArray", Type.array(Type.bytes())),
            Type.StructField.of("timestampArray", Type.array(Type.timestamp())),
            Type.StructField.of("dateArray", Type.array(Type.date())),
            Type.StructField.of("uuidArray", Type.array(Type.uuid())),
            Type.StructField.of("intervalArray", Type.array(Type.interval())),
            Type.StructField.of("stringArray", Type.array(Type.string())),
            Type.StructField.of("jsonArray", Type.array(Type.json())),
            Type.StructField.of("pgJsonbArray", Type.array(Type.pgJsonb())),
            Type.StructField.of("pgOidArray", Type.array(Type.pgOid())),
            Type.StructField.of(
                "protoMessageArray",
                Type.array(Type.proto(SingerInfo.getDescriptor().getFullName()))),
            Type.StructField.of(
                "protoEnumArray", Type.array(Type.protoEnum(Genre.getDescriptor().getFullName()))));
    Struct rowNonNullValues =
        Struct.newBuilder()
            .set("boolVal")
            .to(true)
            .set("longVal")
            .to(2)
            .set("doubleVal")
            .to(Value.float64(3.14d))
            .set("floatVal")
            .to(Value.float32(2.71f))
            .set("bigDecimalVal")
            .to(Value.numeric(BigDecimal.valueOf(123, 2)))
            .set("pgNumericVal")
            .to(Value.pgNumeric("1.23"))
            .set("stringVal")
            .to("test")
            .set("jsonVal")
            .to(Value.json("{\"color\":\"red\",\"value\":\"#f00\"}"))
            .set("pgJsonbVal")
            .to(Value.pgJsonb("{\"color\":\"red\",\"value\":\"#f00\"}"))
            .set("pgOidVal")
            .to(Value.pgOid(2))
            .set("protoMessageVal")
            .to(SingerInfo.newBuilder().setSingerId(98).setNationality("C1").build())
            .set("protoEnumVal")
            .to(Genre.POP)
            .set("byteVal")
            .to(Value.bytes(ByteArray.copyFrom("test".getBytes(StandardCharsets.UTF_8))))
            .set("timestamp")
            .to(Timestamp.parseTimestamp("2022-08-04T10:19:00.123456789Z"))
            .set("date")
            .to(Date.fromYearMonthDay(2022, 8, 4))
            .set("uuid")
            .to(UUID.randomUUID())
            .set("interval")
            .to(Interval.parseFromString("P1Y2M3DT4H5M6.789123456S"))
            .set("boolArray")
            .to(Value.boolArray(Arrays.asList(Boolean.TRUE, null, Boolean.FALSE)))
            .set("longArray")
            .to(Value.int64Array(Arrays.asList(1L, null, 2L)))
            .set("doubleArray")
            .to(Value.float64Array(Arrays.asList(3.14d, null, 6.6626d)))
            .set("floatArray")
            .to(Value.float32Array(Arrays.asList(2.71f, null, 6.6626f)))
            .set("bigDecimalArray")
            .to(Value.numericArray(Arrays.asList(BigDecimal.ONE, null, BigDecimal.TEN)))
            .set("pgNumericArray")
            .to(Value.pgNumericArray(Arrays.asList("1", null, "10")))
            .set("byteArray")
            .to(
                Value.bytesArray(
                    Arrays.asList(ByteArray.copyFrom("test1"), null, ByteArray.copyFrom("test2"))))
            .set("timestampArray")
            .to(
                Value.timestampArray(
                    Arrays.asList(
                        Timestamp.parseTimestamp("2000-01-01T00:00:00Z"),
                        null,
                        Timestamp.parseTimestamp("2022-08-04T10:24:00.123456789Z"))))
            .set("dateArray")
            .to(
                Value.dateArray(
                    Arrays.asList(
                        Date.parseDate("2000-01-01"), null, Date.parseDate("2022-08-04"))))
            .set("uuidArray")
            .to(Value.uuidArray(Arrays.asList(UUID.randomUUID(), UUID.randomUUID())))
            .set("intervalArray")
            .to(
                Value.intervalArray(
                    Arrays.asList(
                        Interval.parseFromString("P1Y2M3DT4H5M6.789123456S"),
                        null,
                        Interval.parseFromString("P-1Y-2M-3DT-4H-5M-6.789123456S"))))
            .set("stringArray")
            .to(Value.stringArray(Arrays.asList("test1", null, "test2")))
            .set("jsonArray")
            .to(
                Value.jsonArray(
                    Arrays.asList("{\"color\":\"red\",\"value\":\"#f00\"}", null, "{}")))
            .set("pgJsonbArray")
            .to(
                Value.pgJsonbArray(
                    Arrays.asList("{\"color\":\"red\",\"value\":\"#f00\"}", null, "{}")))
            .set("pgOidArray")
            .to(Value.pgOidArray(Arrays.asList(1L, null, 2L)))
            .set("protoMessageArray")
            .to(
                Value.protoMessageArray(
                    Arrays.asList(
                        SingerInfo.newBuilder().setSingerId(11).setNationality("C1").build(),
                        SingerInfo.getDefaultInstance()),
                    SingerInfo.getDescriptor()))
            .set("protoEnumArray")
            .to(Value.protoEnumArray(Arrays.asList(Genre.POP, Genre.ROCK), Genre.getDescriptor()))
            .build();
    Struct rowNullValues =
        Struct.newBuilder()
            .set("boolVal")
            .to((Boolean) null)
            .set("longVal")
            .to((Long) null)
            .set("doubleVal")
            .to((Double) null)
            .set("floatVal")
            .to((Float) null)
            .set("bigDecimalVal")
            .to((BigDecimal) null)
            .set("pgNumericVal")
            .to(Value.pgNumeric(null))
            .set("stringVal")
            .to((String) null)
            .set("jsonVal")
            .to(Value.json(null))
            .set("pgJsonbVal")
            .to(Value.pgJsonb(null))
            .set("pgOidVal")
            .to(Value.pgOid(null))
            .set("protoMessageVal")
            .to(Value.protoMessage(null, SingerInfo.getDescriptor().getFullName()))
            .set("protoEnumVal")
            .to(Value.protoEnum(null, Genre.getDescriptor().getFullName()))
            .set("byteVal")
            .to((ByteArray) null)
            .set("timestamp")
            .to((Timestamp) null)
            .set("date")
            .to((Date) null)
            .set("uuid")
            .to((UUID) null)
            .set("interval")
            .to((Interval) null)
            .set("boolArray")
            .toBoolArray((Iterable<Boolean>) null)
            .set("longArray")
            .toInt64Array((Iterable<Long>) null)
            .set("doubleArray")
            .toFloat64Array((Iterable<Double>) null)
            .set("floatArray")
            .toFloat32Array((Iterable<Float>) null)
            .set("bigDecimalArray")
            .toNumericArray(null)
            .set("pgNumericArray")
            .toPgNumericArray(null)
            .set("byteArray")
            .toBytesArray(null)
            .set("timestampArray")
            .toTimestampArray(null)
            .set("dateArray")
            .toDateArray(null)
            .set("uuidArray")
            .toUuidArray(null)
            .set("intervalArray")
            .toIntervalArray(null)
            .set("stringArray")
            .toStringArray(null)
            .set("jsonArray")
            .toJsonArray(null)
            .set("pgJsonbArray")
            .toPgJsonbArray(null)
            .set("pgOidArray")
            .toPgOidArray((Iterable<Long>) null)
            .set("protoMessageArray")
            .to(Value.protoMessageArray(null, SingerInfo.getDescriptor()))
            .set("protoEnumArray")
            .to(Value.protoEnumArray(null, Genre.getDescriptor()))
            .build();

    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    Statement statement = Statement.of("select * from foo");
    when(parsedStatement.getStatement()).thenReturn(statement);
    AbortedException abortedException = mock(AbortedException.class);
    ReadWriteTransaction transaction = mock(ReadWriteTransaction.class);
    when(transaction.runWithRetry(any(Callable.class)))
        .thenAnswer(invocationOnMock -> ((Callable<?>) invocationOnMock.getArgument(0)).call());
    when(transaction.getStatementExecutor()).thenReturn(mock(StatementExecutor.class));

    ResultSet queryResult =
        ResultSets.forRows(type, ImmutableList.of(rowNonNullValues, rowNullValues));
    ChecksumResultSet resultSet =
        new ChecksumResultSet(
            transaction,
            DirectExecuteResultSet.ofResultSet(queryResult),
            parsedStatement,
            AnalyzeMode.NONE);
    assertTrue(resultSet.next());
    assertTrue(resultSet.next());

    // Ensure that retrying will return the same result.
    ResultSet retryResult =
        ResultSets.forRows(type, ImmutableList.of(rowNonNullValues, rowNullValues));
    when(transaction.internalExecuteQuery(parsedStatement, AnalyzeMode.NONE))
        .thenReturn(retryResult);

    // There have been no changes, so the retry should succeed.
    resultSet.retry(abortedException);

    // Change field value from one non-null value to another non-null value.
    for (StructField fieldToChange : rowNonNullValues.getType().getStructFields()) {
      Builder builder = Struct.newBuilder();
      for (StructField field : rowNonNullValues.getType().getStructFields()) {
        if (field.equals(fieldToChange)) {
          builder.set(field.getName()).to(DIFFERENT_NON_NULL_VALUES.getValue(field.getName()));
        } else {
          builder.set(field.getName()).to(rowNonNullValues.getValue(field.getName()));
        }
      }
      ResultSet newRetryResult =
          ResultSets.forRows(type, ImmutableList.of(builder.build(), rowNullValues));
      when(transaction.internalExecuteQuery(parsedStatement, AnalyzeMode.NONE))
          .thenReturn(newRetryResult);
      // The query result has changed, so this should now fail.
      assertThrows(
          "Missing exception for " + fieldToChange.getName(),
          AbortedDueToConcurrentModificationException.class,
          () -> resultSet.retry(abortedException));
    }

    // Change field value from non-null value to null value.
    for (StructField fieldToChange : rowNonNullValues.getType().getStructFields()) {
      Builder builder = Struct.newBuilder();
      for (StructField field : rowNonNullValues.getType().getStructFields()) {
        if (field.equals(fieldToChange)) {
          builder.set(field.getName()).to(rowNullValues.getValue(field.getName()));
        } else {
          builder.set(field.getName()).to(rowNonNullValues.getValue(field.getName()));
        }
      }
      ResultSet newRetryResult =
          ResultSets.forRows(type, ImmutableList.of(builder.build(), rowNullValues));
      when(transaction.internalExecuteQuery(parsedStatement, AnalyzeMode.NONE))
          .thenReturn(newRetryResult);
      // The query result has changed, so this should now fail.
      assertThrows(
          "Missing exception for " + fieldToChange.getName(),
          AbortedDueToConcurrentModificationException.class,
          () -> resultSet.retry(abortedException));
    }

    // Change field value from null value to non-null value.
    for (StructField fieldToChange : rowNonNullValues.getType().getStructFields()) {
      Builder builder = Struct.newBuilder();
      for (StructField field : rowNullValues.getType().getStructFields()) {
        if (field.equals(fieldToChange)) {
          builder.set(field.getName()).to(rowNonNullValues.getValue(field.getName()));
        } else {
          builder.set(field.getName()).to(rowNullValues.getValue(field.getName()));
        }
      }
      // In this case the modified values are in the second row that first only contained null
      // values.
      ResultSet newRetryResult =
          ResultSets.forRows(type, ImmutableList.of(rowNonNullValues, builder.build()));
      when(transaction.internalExecuteQuery(parsedStatement, AnalyzeMode.NONE))
          .thenReturn(newRetryResult);
      // The query result has changed, so this should now fail.
      assertThrows(
          "Missing exception for " + fieldToChange.getName(),
          AbortedDueToConcurrentModificationException.class,
          () -> resultSet.retry(abortedException));
    }
  }
}
