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
import static org.junit.Assert.fail;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link ResultSets} */
@RunWith(JUnit4.class)
public class ResultSetsTest {

  @Rule public ExpectedException expected = ExpectedException.none();

  @Test
  public void resultSetIteration() {
    double doubleVal = 1.2;
    String stringVal = "stringVal";
    String byteVal = "101";
    long usecs = 32343;
    int year = 2018;
    int month = 5;
    int day = 26;
    boolean[] boolArray = { true, false, true, true, false };
    long[] longArray = { Long.MAX_VALUE, Long.MIN_VALUE, 0, 1, -1 };
    double[] doubleArray = { Double.MIN_VALUE, Double.MAX_VALUE, 0, 1, -1, 1.2341 };
    ByteArray[] byteArray = {
        ByteArray.copyFrom("123"),
        ByteArray.copyFrom("456"),
        ByteArray.copyFrom("789")
    };
    Timestamp[] timestampArray = {
        Timestamp.ofTimeMicroseconds(101),
        Timestamp.ofTimeMicroseconds(202),
        Timestamp.ofTimeMicroseconds(303)
    };
    Date[] dateArray = {
        Date.fromYearMonthDay(1, 2, 3),
        Date.fromYearMonthDay(4, 5, 6),
        Date.fromYearMonthDay(7, 8, 9)
    };
    String[] stringArray = { "abc", "def", "ghi" };

    Type type =
        Type.struct(
            Type.StructField.of("f1", Type.string()),
            Type.StructField.of("f2", Type.int64()),
            Type.StructField.of("f3", Type.bool()),
            Type.StructField.of("doubleVal", Type.float64()),
            Type.StructField.of("stringVal", Type.string()),
            Type.StructField.of("byteVal", Type.bytes()),
            Type.StructField.of("timestamp", Type.timestamp()),
            Type.StructField.of("date", Type.date()),
            Type.StructField.of("boolArray", Type.array(Type.bool())),
            Type.StructField.of("longArray", Type.array(Type.int64())),
            Type.StructField.of("doubleArray", Type.array(Type.float64())),
            Type.StructField.of("byteArray", Type.array(Type.bytes())),
            Type.StructField.of("timestampArray", Type.array(Type.timestamp())),
            Type.StructField.of("dateArray", Type.array(Type.date())),
            Type.StructField.of("stringArray", Type.array(Type.string()))
        );
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
            .set("stringVal")
            .to(stringVal)
            .set("byteVal")
            .to(Value.bytes(ByteArray.copyFrom(byteVal)))
            .set("timestamp")
            .to(Timestamp.ofTimeMicroseconds(usecs))
            .set("date")
            .to(Date.fromYearMonthDay(year, month, day))
            .set("boolArray")
            .to(Value.boolArray(boolArray))
            .set("longArray")
            .to(Value.int64Array(longArray))
            .set("doubleArray")
            .to(Value.float64Array(doubleArray))
            .set("byteArray")
            .to(Value.bytesArray(Arrays.asList(byteArray)))
            .set("timestampArray")
            .to(Value.timestampArray(Arrays.asList(timestampArray)))
            .set("dateArray")
            .to(Value.dateArray(Arrays.asList(dateArray)))
            .set("stringArray")
            .to(Value.stringArray(Arrays.asList(stringArray)))
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
            .set("stringVal")
            .to(stringVal)
            .set("byteVal")
            .to(Value.bytes(ByteArray.copyFrom(byteVal)))
            .set("timestamp")
            .to(Timestamp.ofTimeMicroseconds(usecs))
            .set("date")
            .to(Date.fromYearMonthDay(year, month, day))
            .set("boolArray")
            .to(Value.boolArray(boolArray))
            .set("longArray")
            .to(Value.int64Array(longArray))
            .set("doubleArray")
            .to(Value.float64Array(doubleArray))
            .set("byteArray")
            .to(Value.bytesArray(Arrays.asList(byteArray)))
            .set("timestampArray")
            .to(Value.timestampArray(Arrays.asList(timestampArray)))
            .set("dateArray")
            .to(Value.dateArray(Arrays.asList(dateArray)))
            .set("stringArray")
            .to(Value.stringArray(Arrays.asList(stringArray)))
            .build();
    ResultSet rs = ResultSets.forRows(type, Arrays.asList(struct1, struct2));

    try {
      rs.getType();
      fail("Exception expected");
    } catch(IllegalStateException e) {
      assertThat(e.getMessage())
          .contains("Must be preceded by a next() call");
    }

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
    assertThat(rs.getString(0)).isEqualTo("x");
    assertThat(rs.getLong(1)).isEqualTo(2L);
    assertThat(rs.getBoolean(2)).isTrue();
    assertThat(rs.getBoolean("f3")).isTrue();
    assertThat(rs.getDouble("doubleVal")).isWithin(0.0).of(doubleVal);
    assertThat(rs.getDouble(3)).isWithin(0.0).of(doubleVal);
    assertThat(rs.getString(4)).isEqualTo(stringVal);
    assertThat(rs.getString("stringVal")).isEqualTo(stringVal);
    assertThat(rs.getBytes(5)).isEqualTo(ByteArray.copyFrom(byteVal));
    assertThat(rs.getBytes("byteVal")).isEqualTo(ByteArray.copyFrom(byteVal));
    assertThat(rs.getTimestamp(6)).isEqualTo(Timestamp.ofTimeMicroseconds(usecs));
    assertThat(rs.getTimestamp("timestamp")).isEqualTo(Timestamp.ofTimeMicroseconds(usecs));
    assertThat(rs.getDate(7)).isEqualTo(Date.fromYearMonthDay(year, month, day));
    assertThat(rs.getDate("date")).isEqualTo(Date.fromYearMonthDay(year, month, day));
    assertThat(rs.getBooleanArray(8)).isEqualTo(boolArray);
    assertThat(rs.getBooleanArray("boolArray")).isEqualTo(boolArray);
    assertThat(rs.getBooleanList(8)).isEqualTo(Booleans.asList(boolArray));
    assertThat(rs.getBooleanList("boolArray")).isEqualTo(Booleans.asList(boolArray));
    assertThat(rs.getLongArray(9)).isEqualTo(longArray);
    assertThat(rs.getLongArray("longArray")).isEqualTo(longArray);
    assertThat(rs.getLongList(9)).isEqualTo(Longs.asList(longArray));
    assertThat(rs.getLongList("longArray")).isEqualTo(Longs.asList(longArray));
    assertThat(rs.getDoubleArray(10)).isEqualTo(doubleArray, 0.0);
    assertThat(rs.getDoubleArray("doubleArray")).isEqualTo(doubleArray, 0.0);
    assertThat(rs.getDoubleList(10)).isEqualTo(Doubles.asList(doubleArray));
    assertThat(rs.getDoubleList("doubleArray")).isEqualTo(Doubles.asList(doubleArray));
    assertThat(rs.getBytesList(11)).isEqualTo(Arrays.asList(byteArray));
    assertThat(rs.getBytesList("byteArray")).isEqualTo(Arrays.asList(byteArray));
    assertThat(rs.getTimestampList(12)).isEqualTo(Arrays.asList(timestampArray));
    assertThat(rs.getTimestampList("timestampArray")).isEqualTo(Arrays.asList(timestampArray));
    assertThat(rs.getDateList(13)).isEqualTo(Arrays.asList(dateArray));
    assertThat(rs.getDateList("dateArray")).isEqualTo(Arrays.asList(dateArray));
    assertThat(rs.getStringList(14)).isEqualTo(Arrays.asList(stringArray));
    assertThat(rs.getStringList("stringArray")).isEqualTo(Arrays.asList(stringArray));

    assertThat(rs.next()).isTrue();
    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct2);
    assertThat(rs.getString(0)).isEqualTo("y");
    assertThat(rs.getLong(1)).isEqualTo(3L);
    assertThat(rs.isNull(2)).isTrue();
    assertThat(rs.next()).isFalse();

    try {
      rs.getStats();
      fail("Exception expected");
    } catch(UnsupportedOperationException e) {
      assertThat(e.getMessage())
          .contains("ResultSetStats are available only for results returned from analyzeQuery");
    }
  }

  @Test
  public void resultSetIterationWithStructColumns() {
    Type nestedStructType = Type.struct(Type.StructField.of("g1", Type.string()));
    Type type =
        Type.struct(
            Type.StructField.of("f1", nestedStructType), Type.StructField.of("f2", Type.int64()));

    Struct value1 = Struct.newBuilder().set("g1").to("abc").build();

    Struct struct1 = Struct.newBuilder().set("f1").to(value1).set("f2").to((Long) null).build();

    expected.expect(UnsupportedOperationException.class);
    expected.expectMessage("STRUCT-typed columns are not supported inside ResultSets.");
    ResultSets.forRows(type, Arrays.asList(struct1));
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
    assertThat(rs.getStructList("f1")).isEqualTo(arrayValue);
    assertThat(rs.isNull(1)).isTrue();

    assertThat(rs.next()).isTrue();
    assertThat(rs.getCurrentRowAsStruct()).isEqualTo(struct2);

    assertThat(rs.isNull(0)).isTrue();
    assertThat(rs.isNull("f1")).isTrue();
    assertThat(rs.getLong(1)).isEqualTo(20);
    assertThat(rs.getLong("f2")).isEqualTo(20);

    assertThat(rs.next()).isFalse();
  }

  @Test
  public void closeResultSet() {
    ResultSet rs =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Arrays.asList(Struct.newBuilder().set("f1").to("x").build()));
    rs.close();
    expected.expect(IllegalStateException.class);
    rs.getCurrentRowAsStruct();
  }

  @Test
  public void exceptionIfNextIsNotCalled() {
    ResultSet rs =
        ResultSets.forRows(
            Type.struct(Type.StructField.of("f1", Type.string())),
            Arrays.asList(Struct.newBuilder().set("f1").to("x").build()));
    expected.expect(IllegalStateException.class);
    rs.getCurrentRowAsStruct();
  }
}
