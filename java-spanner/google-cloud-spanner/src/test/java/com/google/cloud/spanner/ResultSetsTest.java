/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link ResultSets} */
@RunWith(JUnit4.class)
public class ResultSetsTest {

  @Test
  public void resultSetIteration() {
    double doubleVal = 1.2;
    float floatVal = 6.626f;
    BigDecimal bigDecimalVal = BigDecimal.valueOf(123, 2);
    String stringVal = "stringVal";
    String jsonVal = "{\"color\":\"red\",\"value\":\"#f00\"}";
    SingerInfo protoMessageVal =
        SingerInfo.newBuilder()
            .setSingerId(111)
            .setNationality("COUNTRY1")
            .setGenre(Genre.FOLK)
            .build();
    ProtocolMessageEnum protoEnumVal = Genre.ROCK;
    String byteVal = "101";
    long usecs = 32343;
    int year = 2018;
    int month = 5;
    int day = 26;
    UUID uuid = UUID.randomUUID();
    Interval interval = Interval.parseFromString("P1Y2M3DT5H7M8.967589762S");

    boolean[] boolArray = {true, false, true, true, false};
    long[] longArray = {Long.MAX_VALUE, Long.MIN_VALUE, 0, 1, -1};
    double[] doubleArray = {Double.MIN_VALUE, Double.MAX_VALUE, 0, 1, -1, 1.2341};
    float[] floatArray = {Float.MIN_VALUE, Float.MAX_VALUE, 0, 1, -1, 1.2341f};
    BigDecimal[] bigDecimalArray = {
      BigDecimal.valueOf(1, Integer.MAX_VALUE),
      BigDecimal.valueOf(1, Integer.MIN_VALUE),
      BigDecimal.ZERO,
      BigDecimal.TEN,
      BigDecimal.valueOf(3141592, 6)
    };
    ByteArray[] byteArray = {
      ByteArray.copyFrom("123"), ByteArray.copyFrom("456"), ByteArray.copyFrom("789")
    };
    Timestamp[] timestampArray = {
      Timestamp.ofTimeMicroseconds(101),
      Timestamp.ofTimeMicroseconds(202),
      Timestamp.ofTimeMicroseconds(303)
    };
    Date[] dateArray = {
      Date.fromYearMonthDay(1, 2, 3), Date.fromYearMonthDay(4, 5, 6), Date.fromYearMonthDay(7, 8, 9)
    };

    UUID[] uuidArray = {UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()};

    Interval[] intervalArray = {
      Interval.parseFromString("P0Y"), Interval.parseFromString("P1Y2M3DT-5H-7M8.9675S")
    };

    String[] stringArray = {"abc", "def", "ghi"};
    String[] jsonArray = {"{}", "{\"color\":\"red\",\"value\":\"#f00\"}", "[]"};
    AbstractMessage[] protoMessageArray = {
      protoMessageVal, SingerInfo.newBuilder().setSingerId(1).build()
    };
    ProtocolMessageEnum[] protoEnumArray = {protoEnumVal, Genre.JAZZ};

    Type type =
        Type.struct(
            Type.StructField.of("f1", Type.string()),
            Type.StructField.of("f2", Type.int64()),
            Type.StructField.of("f3", Type.bool()),
            Type.StructField.of("doubleVal", Type.float64()),
            Type.StructField.of("floatVal", Type.float32()),
            Type.StructField.of("bigDecimalVal", Type.numeric()),
            Type.StructField.of("stringVal", Type.string()),
            Type.StructField.of("jsonVal", Type.json()),
            Type.StructField.of("pgJsonbVal", Type.pgJsonb()),
            Type.StructField.of("pgOidVal", Type.pgOid()),
            Type.StructField.of("byteVal", Type.bytes()),
            Type.StructField.of("timestamp", Type.timestamp()),
            Type.StructField.of("date", Type.date()),
            Type.StructField.of("uuid", Type.uuid()),
            Type.StructField.of("interval", Type.interval()),
            Type.StructField.of(
                "protoMessage", Type.proto(protoMessageVal.getDescriptorForType().getFullName())),
            Type.StructField.of(
                "protoEnum", Type.protoEnum(protoEnumVal.getDescriptorForType().getFullName())),
            Type.StructField.of("boolArray", Type.array(Type.bool())),
            Type.StructField.of("longArray", Type.array(Type.int64())),
            Type.StructField.of("doubleArray", Type.array(Type.float64())),
            Type.StructField.of("floatArray", Type.array(Type.float32())),
            Type.StructField.of("bigDecimalArray", Type.array(Type.numeric())),
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
    Struct struct1 =
        Struct.newBuilder()
            .set("f1")
            .to("x")
            .set("f2")
            .to(2)
            .set("f3")
            .to(Value.bool(true))
            .set("doubleVal")
            .to(Value.float64(doubleVal))
            .set("floatVal")
            .to(Value.float32(floatVal))
            .set("bigDecimalVal")
            .to(Value.numeric(bigDecimalVal))
            .set("stringVal")
            .to(stringVal)
            .set("jsonVal")
            .to(Value.json(jsonVal))
            .set("pgJsonbVal")
            .to(Value.pgJsonb(jsonVal))
            .set("pgOidVal")
            .to(Value.pgOid(2))
            .set("byteVal")
            .to(Value.bytes(ByteArray.copyFrom(byteVal)))
            .set("timestamp")
            .to(Timestamp.ofTimeMicroseconds(usecs))
            .set("date")
            .to(Date.fromYearMonthDay(year, month, day))
            .set("uuid")
            .to(uuid)
            .set("interval")
            .to(interval)
            .set("protoMessage")
            .to(protoMessageVal)
            .set("protoEnum")
            .to(protoEnumVal)
            .set("boolArray")
            .to(Value.boolArray(boolArray))
            .set("longArray")
            .to(Value.int64Array(longArray))
            .set("doubleArray")
            .to(Value.float64Array(doubleArray))
            .set("floatArray")
            .to(Value.float32Array(floatArray))
            .set("bigDecimalArray")
            .to(Value.numericArray(Arrays.asList(bigDecimalArray)))
            .set("byteArray")
            .to(Value.bytesArray(Arrays.asList(byteArray)))
            .set("timestampArray")
            .to(Value.timestampArray(Arrays.asList(timestampArray)))
            .set("dateArray")
            .to(Value.dateArray(Arrays.asList(dateArray)))
            .set("uuidArray")
            .to(Value.uuidArray(Arrays.asList(uuidArray)))
            .set("intervalArray")
            .to(Value.intervalArray(Arrays.asList(intervalArray)))
            .set("stringArray")
            .to(Value.stringArray(Arrays.asList(stringArray)))
            .set("jsonArray")
            .to(Value.jsonArray(Arrays.asList(jsonArray)))
            .set("pgJsonbArray")
            .to(Value.pgJsonbArray(Arrays.asList(jsonArray)))
            .set("pgOidArray")
            .to(Value.pgOidArray(longArray))
            .set("protoMessageArray")
            .to(
                Value.protoMessageArray(
                    Arrays.asList(protoMessageArray), protoMessageVal.getDescriptorForType()))
            .set("protoEnumArray")
            .to(
                Value.protoEnumArray(
                    Arrays.asList(protoEnumArray), protoEnumVal.getDescriptorForType()))
            .build();
    Struct struct2 =
        Struct.newBuilder()
            .set("f1")
            .to("y")
            .set("f2")
            .to(3)
            .set("f3")
            .to(Value.bool(null))
            .set("doubleVal")
            .to(Value.float64(doubleVal))
            .set("floatVal")
            .to(Value.float32(floatVal))
            .set("bigDecimalVal")
            .to(Value.numeric(bigDecimalVal))
            .set("stringVal")
            .to(stringVal)
            .set("jsonVal")
            .to(Value.json(jsonVal))
            .set("pgJsonbVal")
            .to(Value.pgJsonb(jsonVal))
            .set("pgOidVal")
            .to(Value.pgOid(3))
            .set("byteVal")
            .to(Value.bytes(ByteArray.copyFrom(byteVal)))
            .set("timestamp")
            .to(Timestamp.ofTimeMicroseconds(usecs))
            .set("date")
            .to(Date.fromYearMonthDay(year, month, day))
            .set("uuid")
            .to(uuid)
            .set("interval")
            .to(Value.interval(interval))
            .set("protoMessage")
            .to(protoMessageVal)
            .set("protoEnum")
            .to(protoEnumVal)
            .set("boolArray")
            .to(Value.boolArray(boolArray))
            .set("longArray")
            .to(Value.int64Array(longArray))
            .set("doubleArray")
            .to(Value.float64Array(doubleArray))
            .set("floatArray")
            .to(Value.float32Array(floatArray))
            .set("bigDecimalArray")
            .to(Value.numericArray(Arrays.asList(bigDecimalArray)))
            .set("byteArray")
            .to(Value.bytesArray(Arrays.asList(byteArray)))
            .set("timestampArray")
            .to(Value.timestampArray(Arrays.asList(timestampArray)))
            .set("dateArray")
            .to(Value.dateArray(Arrays.asList(dateArray)))
            .set("uuidArray")
            .to(Value.uuidArray(Arrays.asList(uuidArray)))
            .set("intervalArray")
            .to(Value.intervalArray(Arrays.asList(intervalArray)))
            .set("stringArray")
            .to(Value.stringArray(Arrays.asList(stringArray)))
            .set("jsonArray")
            .to(Value.jsonArray(Arrays.asList(jsonArray)))
            .set("pgJsonbArray")
            .to(Value.pgJsonbArray(Arrays.asList(jsonArray)))
            .set("pgOidArray")
            .to(Value.pgOidArray(longArray))
            .set("protoMessageArray")
            .to(
                Value.protoMessageArray(
                    Arrays.asList(protoMessageArray), protoMessageVal.getDescriptorForType()))
            .set("protoEnumArray")
            .to(
                Value.protoEnumArray(
                    Arrays.asList(protoEnumArray), protoEnumVal.getDescriptorForType()))
            .build();
    ResultSet rs = ResultSets.forRows(type, Arrays.asList(struct1, struct2));

    IllegalStateException e = assertThrows(IllegalStateException.class, rs::getType);
    assertThat(e.getMessage()).contains("Must be preceded by a next() call");

    int columnIndex = 0;
    assertThat(rs.next()).isTrue();
    assertThat(rs.getType()).isEqualTo(type);
    assertThat(rs.getColumnCount()).isEqualTo(type.getStructFields().size());
    assertThat(rs.getColumnIndex("f1")).isEqualTo(0);
    assertThat(rs.getColumnType("nonexistent")).isNull();
    assertThat(rs.getColumnType("f1")).isEqualTo(Type.string());
    assertThat(rs.getColumnType(0)).isEqualTo(Type.string());
    assertThat(rs.getColumnIndex("f2")).isEqualTo(1);
    assertThat(rs.getColumnType("f2")).isEqualTo(Type.int64());
    assertThat(rs.getColumnType(1)).isEqualTo(Type.int64());
    assertThat(rs.getColumnIndex("f3")).isEqualTo(2);
    assertThat(rs.getColumnType("f3")).isEqualTo(Type.bool());
    assertThat(rs.getColumnType(2)).isEqualTo(Type.bool());
    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct1);
    assertThat(rs.getString(columnIndex)).isEqualTo("x");
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.string("x"));
    assertThat(rs.getLong(columnIndex)).isEqualTo(2L);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.int64(2L));
    assertThat(rs.getBoolean(columnIndex)).isTrue();
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.bool(true));
    assertThat(rs.getBoolean("f3")).isTrue();
    assertThat(rs.getValue("f3")).isEqualTo(Value.bool(true));
    assertThat(rs.getDouble("doubleVal")).isWithin(0.0).of(doubleVal);
    assertThat(rs.getValue("doubleVal").getFloat64()).isWithin(0.0).of(doubleVal);
    assertThat(rs.getDouble(columnIndex)).isWithin(0.0).of(doubleVal);
    assertThat(rs.getValue(columnIndex++).getFloat64()).isWithin(0.0).of(doubleVal);
    assertThat(rs.getFloat(columnIndex)).isWithin(0.0f).of(floatVal);
    assertThat(rs.getValue(columnIndex++).getFloat32()).isWithin(0.0f).of(floatVal);
    assertThat(rs.getFloat("floatVal")).isWithin(0.0f).of(floatVal);
    assertThat(rs.getValue("floatVal").getFloat32()).isWithin(0.0f).of(floatVal);
    assertThat(rs.getBigDecimal("bigDecimalVal")).isEqualTo(new BigDecimal("1.23"));
    assertThat(rs.getValue("bigDecimalVal")).isEqualTo(Value.numeric(new BigDecimal("1.23")));
    assertThat(rs.getBigDecimal(columnIndex)).isEqualTo(new BigDecimal("1.23"));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.numeric(new BigDecimal("1.23")));
    assertThat(rs.getString(columnIndex)).isEqualTo(stringVal);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.string(stringVal));
    assertThat(rs.getString("stringVal")).isEqualTo(stringVal);
    assertThat(rs.getValue("stringVal")).isEqualTo(Value.string(stringVal));
    assertThat(rs.getJson(columnIndex)).isEqualTo(jsonVal);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.json(jsonVal));
    assertThat(rs.getJson("jsonVal")).isEqualTo(jsonVal);
    assertThat(rs.getValue("jsonVal")).isEqualTo(Value.json(jsonVal));

    assertEquals(jsonVal, rs.getPgJsonb(columnIndex));
    assertEquals(Value.pgJsonb(jsonVal), rs.getValue(columnIndex++));
    assertEquals(jsonVal, rs.getPgJsonb("pgJsonbVal"));
    assertEquals(Value.pgJsonb(jsonVal), rs.getValue("pgJsonbVal"));

    assertThat(rs.getLong(columnIndex)).isEqualTo(2L);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.pgOid(2L));
    assertThat(rs.getColumnType("pgOidVal")).isEqualTo(Type.pgOid());

    assertThat(rs.getBytes(columnIndex)).isEqualTo(ByteArray.copyFrom(byteVal));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.bytes(ByteArray.copyFrom(byteVal)));
    assertThat(rs.getBytes("byteVal")).isEqualTo(ByteArray.copyFrom(byteVal));
    assertThat(rs.getValue("byteVal")).isEqualTo(Value.bytes(ByteArray.copyFrom(byteVal)));
    assertThat(rs.getTimestamp(columnIndex)).isEqualTo(Timestamp.ofTimeMicroseconds(usecs));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(Value.timestamp(Timestamp.ofTimeMicroseconds(usecs)));
    assertThat(rs.getTimestamp("timestamp")).isEqualTo(Timestamp.ofTimeMicroseconds(usecs));
    assertThat(rs.getValue("timestamp"))
        .isEqualTo(Value.timestamp(Timestamp.ofTimeMicroseconds(usecs)));
    assertThat(rs.getDate(columnIndex)).isEqualTo(Date.fromYearMonthDay(year, month, day));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(Value.date(Date.fromYearMonthDay(year, month, day)));
    assertThat(rs.getDate("date")).isEqualTo(Date.fromYearMonthDay(year, month, day));
    assertThat(rs.getValue("date")).isEqualTo(Value.date(Date.fromYearMonthDay(year, month, day)));

    // UUID
    assertThat(rs.getUuid(columnIndex)).isEqualTo(uuid);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.uuid(uuid));
    assertThat(rs.getUuid("uuid")).isEqualTo(uuid);
    assertThat(rs.getValue("uuid")).isEqualTo(Value.uuid(uuid));

    // INTERVAL
    assertThat(rs.getInterval(columnIndex)).isEqualTo(interval);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.interval(interval));
    assertThat(rs.getInterval("interval")).isEqualTo(interval);
    assertThat(rs.getValue("interval")).isEqualTo(Value.interval(interval));

    assertEquals(protoMessageVal, rs.getProtoMessage(columnIndex, SingerInfo.getDefaultInstance()));
    assertEquals(Value.protoMessage(protoMessageVal), rs.getValue(columnIndex++));
    assertEquals(
        protoMessageVal, rs.getProtoMessage("protoMessage", SingerInfo.getDefaultInstance()));
    assertEquals(Value.protoMessage(protoMessageVal), rs.getValue("protoMessage"));

    assertEquals(protoEnumVal, rs.getProtoEnum(columnIndex, Genre::forNumber));
    assertEquals(Value.protoEnum(protoEnumVal), rs.getValue(columnIndex++));
    assertEquals(protoEnumVal, rs.getProtoEnum("protoEnum", Genre::forNumber));
    assertEquals(Value.protoEnum(protoEnumVal), rs.getValue("protoEnum"));

    assertThat(rs.getBooleanArray(columnIndex)).isEqualTo(boolArray);
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.boolArray(boolArray));
    assertThat(rs.getBooleanArray("boolArray")).isEqualTo(boolArray);
    assertThat(rs.getValue("boolArray")).isEqualTo(Value.boolArray(boolArray));
    assertThat(rs.getLongArray(columnIndex)).isEqualTo(longArray);
    assertThat(rs.getValue(columnIndex)).isEqualTo(Value.int64Array(longArray));
    assertThat(rs.getLongArray("longArray")).isEqualTo(longArray);
    assertThat(rs.getValue("longArray")).isEqualTo(Value.int64Array(longArray));
    assertThat(rs.getLongList(columnIndex++)).isEqualTo(Longs.asList(longArray));
    assertThat(rs.getLongList("longArray")).isEqualTo(Longs.asList(longArray));
    assertThat(rs.getDoubleArray(columnIndex)).usingTolerance(0.0).containsAtLeast(doubleArray);
    assertThat(rs.getValue(columnIndex)).isEqualTo(Value.float64Array(doubleArray));
    assertThat(rs.getDoubleArray("doubleArray"))
        .usingTolerance(0.0)
        .containsExactly(doubleArray)
        .inOrder();
    assertThat(rs.getValue("doubleArray")).isEqualTo(Value.float64Array(doubleArray));
    assertThat(rs.getDoubleList(columnIndex++)).isEqualTo(Doubles.asList(doubleArray));
    assertThat(rs.getDoubleList("doubleArray")).isEqualTo(Doubles.asList(doubleArray));

    assertThat(rs.getFloatArray(columnIndex)).usingTolerance(0.0f).containsAtLeast(floatArray);
    assertThat(rs.getValue(columnIndex)).isEqualTo(Value.float32Array(floatArray));
    assertThat(rs.getFloatArray("floatArray"))
        .usingTolerance(0.0f)
        .containsExactly(floatArray)
        .inOrder();
    assertThat(rs.getValue("floatArray")).isEqualTo(Value.float32Array(floatArray));
    assertThat(rs.getFloatList(columnIndex++)).isEqualTo(Floats.asList(floatArray));
    assertThat(rs.getFloatList("floatArray")).isEqualTo(Floats.asList(floatArray));

    assertThat(rs.getBigDecimalList(columnIndex)).isEqualTo(Arrays.asList(bigDecimalArray));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(Value.numericArray(Arrays.asList(bigDecimalArray)));
    assertThat(rs.getBigDecimalList("bigDecimalArray")).isEqualTo(Arrays.asList(bigDecimalArray));
    assertThat(rs.getValue("bigDecimalArray"))
        .isEqualTo(Value.numericArray(Arrays.asList(bigDecimalArray)));
    assertThat(rs.getBytesList(columnIndex)).isEqualTo(Arrays.asList(byteArray));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.bytesArray(Arrays.asList(byteArray)));
    assertThat(rs.getBytesList("byteArray")).isEqualTo(Arrays.asList(byteArray));
    assertThat(rs.getValue("byteArray")).isEqualTo(Value.bytesArray(Arrays.asList(byteArray)));
    assertThat(rs.getTimestampList(columnIndex)).isEqualTo(Arrays.asList(timestampArray));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(Value.timestampArray(Arrays.asList(timestampArray)));
    assertThat(rs.getTimestampList("timestampArray")).isEqualTo(Arrays.asList(timestampArray));
    assertThat(rs.getValue("timestampArray"))
        .isEqualTo(Value.timestampArray(Arrays.asList(timestampArray)));
    assertThat(rs.getDateList(columnIndex)).isEqualTo(Arrays.asList(dateArray));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.dateArray(Arrays.asList(dateArray)));
    assertThat(rs.getDateList("dateArray")).isEqualTo(Arrays.asList(dateArray));
    assertThat(rs.getValue("dateArray")).isEqualTo(Value.dateArray(Arrays.asList(dateArray)));

    // UUID Array
    assertThat(rs.getUuidList(columnIndex)).isEqualTo(Arrays.asList(uuidArray));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.uuidArray(Arrays.asList(uuidArray)));
    assertThat(rs.getUuidList("uuidArray")).isEqualTo(Arrays.asList(uuidArray));
    assertThat(rs.getValue("uuidArray")).isEqualTo(Value.uuidArray(Arrays.asList(uuidArray)));

    // INTERVAL Array
    assertThat(rs.getIntervalList(columnIndex)).isEqualTo(Arrays.asList(intervalArray));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(Value.intervalArray(Arrays.asList(intervalArray)));
    assertThat(rs.getIntervalList("intervalArray")).isEqualTo(Arrays.asList(intervalArray));
    assertThat(rs.getValue("intervalArray"))
        .isEqualTo(Value.intervalArray(Arrays.asList(intervalArray)));

    assertThat(rs.getStringList(columnIndex)).isEqualTo(Arrays.asList(stringArray));
    assertThat(rs.getValue(columnIndex++)).isEqualTo(Value.stringArray(Arrays.asList(stringArray)));
    assertThat(rs.getStringList("stringArray")).isEqualTo(Arrays.asList(stringArray));
    assertThat(rs.getValue("stringArray")).isEqualTo(Value.stringArray(Arrays.asList(stringArray)));
    assertThat(rs.getJsonList(columnIndex++)).isEqualTo(Arrays.asList(jsonArray));
    assertThat(rs.getJsonList("jsonArray")).isEqualTo(Arrays.asList(jsonArray));

    assertEquals(Arrays.asList(jsonArray), rs.getPgJsonbList(columnIndex++));
    assertEquals(Arrays.asList(jsonArray), rs.getPgJsonbList("pgJsonbArray"));

    assertThat(rs.getLongArray(columnIndex)).isEqualTo(longArray);
    assertThat(rs.getValue(columnIndex)).isEqualTo(Value.pgOidArray(longArray));
    assertThat(rs.getLongArray("pgOidArray")).isEqualTo(longArray);
    assertThat(rs.getValue("pgOidArray")).isEqualTo(Value.pgOidArray(longArray));
    assertThat(rs.getLongList(columnIndex++)).isEqualTo(Longs.asList(longArray));
    assertThat(rs.getLongList("pgOidArray")).isEqualTo(Longs.asList(longArray));

    assertThat(rs.getProtoMessageList(columnIndex, SingerInfo.getDefaultInstance()))
        .isEqualTo(Arrays.asList(protoMessageArray));
    assertThat(rs.getValue(columnIndex++))
        .isEqualTo(
            Value.protoMessageArray(Arrays.asList(protoMessageArray), SingerInfo.getDescriptor()));
    assertThat(rs.getProtoMessageList("protoMessageArray", SingerInfo.getDefaultInstance()))
        .isEqualTo(Arrays.asList(protoMessageArray));
    assertThat(rs.getValue("protoMessageArray"))
        .isEqualTo(
            Value.protoMessageArray(Arrays.asList(protoMessageArray), SingerInfo.getDescriptor()));

    assertThat(rs.getProtoEnumList(columnIndex, Genre::forNumber))
        .isEqualTo(Arrays.asList(protoEnumArray));
    assertThat(rs.getValue(columnIndex))
        .isEqualTo(Value.protoEnumArray(Arrays.asList(protoEnumArray), Genre.getDescriptor()));
    assertThat(rs.getProtoEnumList("protoEnumArray", Genre::forNumber))
        .isEqualTo(Arrays.asList(protoEnumArray));
    assertThat(rs.getValue("protoEnumArray"))
        .isEqualTo(Value.protoEnumArray(Arrays.asList(protoEnumArray), Genre.getDescriptor()));

    assertThat(rs.next()).isTrue();
    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct2);
    assertThat(rs.getString(0)).isEqualTo("y");
    assertThat(rs.getLong(1)).isEqualTo(3L);
    assertThat(rs.isNull(2)).isTrue();
    assertThat(rs.next()).isFalse();

    UnsupportedOperationException unsupported =
        assertThrows(UnsupportedOperationException.class, rs::getStats);
    assertThat(unsupported.getMessage())
        .contains("ResultSetStats are available only for results returned from analyzeQuery");
  }

  @Test
  public void resultSetIterationWithStructColumns() {
    Type nestedStructType = Type.struct(Type.StructField.of("g1", Type.string()));
    Type type =
        Type.struct(
            Type.StructField.of("f1", nestedStructType), Type.StructField.of("f2", Type.int64()));

    Struct value1 = Struct.newBuilder().set("g1").to("abc").build();

    Struct struct1 = Struct.newBuilder().set("f1").to(value1).set("f2").to((Long) null).build();
    UnsupportedOperationException e =
        assertThrows(
            UnsupportedOperationException.class,
            () -> ResultSets.forRows(type, Collections.singletonList(struct1)));
    assertThat(e.getMessage())
        .contains("STRUCT-typed columns are not supported inside ResultSets.");
  }

  @Test
  public void resultSetIterationWithArrayStructColumns() {
    Type nestedStructType = Type.struct(Type.StructField.of("g1", Type.string()));
    Type type =
        Type.struct(
            Type.StructField.of("f1", Type.array(nestedStructType)),
            Type.StructField.of("f2", Type.int64()));

    Struct value1 = Struct.newBuilder().set("g1").to("abc").build();

    List<Struct> arrayValue = Arrays.asList(value1, null);

    Struct struct1 =
        Struct.newBuilder()
            .set("f1")
            .toStructArray(nestedStructType, arrayValue)
            .set("f2")
            .to((Long) null)
            .build();

    Struct struct2 =
        Struct.newBuilder()
            .set("f1")
            .toStructArray(nestedStructType, null)
            .set("f2")
            .to(20)
            .build();

    ResultSet rs = ResultSets.forRows(type, Arrays.asList(struct1, struct2));

    assertThat(rs.next()).isTrue();
    assertThat(rs.getType()).isEqualTo(type);
    assertThat(rs.getColumnCount()).isEqualTo(2);

    assertThat(rs.getColumnIndex("f1")).isEqualTo(0);
    assertThat(rs.getColumnType("f1")).isEqualTo(Type.array(nestedStructType));
    assertThat(rs.getColumnType(0)).isEqualTo(Type.array(nestedStructType));

    assertThat(rs.getColumnIndex("f2")).isEqualTo(1);
    assertThat(rs.getColumnType("f2")).isEqualTo(Type.int64());
    assertThat(rs.getColumnType(1)).isEqualTo(Type.int64());

    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct1);

    assertThat(rs.getStructList(0)).isEqualTo(arrayValue);
    assertThat(rs.getValue(0)).isEqualTo(Value.structArray(nestedStructType, arrayValue));
    assertThat(rs.getStructList("f1")).isEqualTo(arrayValue);
    assertThat(rs.getValue("f1")).isEqualTo(Value.structArray(nestedStructType, arrayValue));
    assertThat(rs.isNull(1)).isTrue();

    assertThat(rs.next()).isTrue();
    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct2);

    assertThat(rs.isNull(0)).isTrue();
    assertThat(rs.isNull("f1")).isTrue();
    assertThat(rs.getLong(1)).isEqualTo(20);
    assertThat(rs.getValue(1)).isEqualTo(Value.int64(20));
    assertThat(rs.getLong("f2")).isEqualTo(20);
    assertThat(rs.getValue("f2")).isEqualTo(Value.int64(20));

    assertThat(rs.next()).isFalse();
  }

  @Test
  public void closeResultSet() {
    ResultSet rs =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Collections.singletonList(Struct.newBuilder().set("f1").to("x").build()));
    rs.close();
    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> rs.getCurrentRowAsStruct());
    assertNotNull(e.getMessage());
  }

  @Test
  public void exceptionIfNextIsNotCalled() {
    ResultSet rs =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Collections.singletonList(Struct.newBuilder().set("f1").to("x").build()));
    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> rs.getCurrentRowAsStruct());
    assertNotNull(e.getMessage());
  }

  @Test
  public void testToAsyncResultSet() {
    ResultSet delegate =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Collections.singletonList(Struct.newBuilder().set("f1").to("x").build()));

    final AtomicInteger count = new AtomicInteger();
    AsyncResultSet rs = ResultSets.toAsyncResultSet(delegate);
    ApiFuture<Void> fut =
        rs.setCallback(
            MoreExecutors.directExecutor(),
            resultSet -> {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    count.incrementAndGet();
                    assertThat(resultSet.getString("f1")).isEqualTo("x");
                }
              }
            });
    SpannerApiFutures.get(fut);
    assertThat(count.get()).isEqualTo(1);
  }

  @Test
  public void testToAsyncResultSetWithExecProvider() {
    ResultSet delegate =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Collections.singletonList(Struct.newBuilder().set("f1").to("x").build()));

    ExecutorProvider provider =
        new ExecutorProvider() {
          final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

          @Override
          public boolean shouldAutoClose() {
            return true;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return executor;
          }
        };
    final AtomicInteger count = new AtomicInteger();
    AsyncResultSet rs = ResultSets.toAsyncResultSet(delegate, provider);
    ApiFuture<Void> fut =
        rs.setCallback(
            MoreExecutors.directExecutor(),
            resultSet -> {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    count.incrementAndGet();
                    assertThat(resultSet.getString("f1")).isEqualTo("x");
                }
              }
            });
    SpannerApiFutures.get(fut);
    assertThat(count.get()).isEqualTo(1);
    assertThat(provider.getExecutor().isShutdown()).isTrue();
  }

  @Test
  public void testToAsyncResultSetWithFuture() {
    ApiFuture<ResultSet> delegateFuture =
        ApiFutures.immediateFuture(
            ResultSets.forRows(
                Type.struct(Type.StructField.of("f1", Type.string())),
                Collections.singletonList(Struct.newBuilder().set("f1").to("x").build())));

    ExecutorProvider provider =
        new ExecutorProvider() {
          final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

          @Override
          public boolean shouldAutoClose() {
            return false;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return executor;
          }
        };
    final AtomicInteger count = new AtomicInteger();
    AsyncResultSet rs = ResultSets.toAsyncResultSet(delegateFuture, provider);
    ApiFuture<Void> fut =
        rs.setCallback(
            MoreExecutors.directExecutor(),
            resultSet -> {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    count.incrementAndGet();
                    assertThat(resultSet.getString("f1")).isEqualTo("x");
                }
              }
            });
    SpannerApiFutures.get(fut);
    assertThat(count.get()).isEqualTo(1);
    assertThat(provider.getExecutor().isShutdown()).isFalse();
    provider.getExecutor().shutdown();
  }
}
