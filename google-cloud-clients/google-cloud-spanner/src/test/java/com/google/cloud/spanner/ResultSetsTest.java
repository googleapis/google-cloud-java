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
    double dval = 1.2;
    String s = "s";
    String byt = "101";
    long us = 32343;
    int yr = 2018;
    int month = 5;
    int day = 26;
    boolean[] ba = { true, false, true, true, false };
    long[] la = { Long.MAX_VALUE, Long.MIN_VALUE, 0, 1, -1 };
    double[] da = { Double.MIN_VALUE, Double.MAX_VALUE, 0, 1, -1, 1.2341 };
    ByteArray[] byta = {
        ByteArray.copyFrom("123"),
        ByteArray.copyFrom("456"),
        ByteArray.copyFrom("789")
    };
    Timestamp[] tsa = {
        Timestamp.ofTimeMicroseconds(101),
        Timestamp.ofTimeMicroseconds(202),
        Timestamp.ofTimeMicroseconds(303)
    };
    Date[] dta = {
        Date.fromYearMonthDay(1, 2, 3),
        Date.fromYearMonthDay(4, 5, 6),
        Date.fromYearMonthDay(7, 8, 9)
    };
    String[] sa = { "abc", "def", "ghi" };

    Type type =
        Type.struct(
            Type.StructField.of("f1", Type.string()),
            Type.StructField.of("f2", Type.int64()),
            Type.StructField.of("f3", Type.bool()),
            Type.StructField.of("d", Type.float64()),
            Type.StructField.of("s", Type.string()),
            Type.StructField.of("byt", Type.bytes()),
            Type.StructField.of("ts", Type.timestamp()),
            Type.StructField.of("dt", Type.date()),
            Type.StructField.of("ba", Type.array(Type.bool())),
            Type.StructField.of("la", Type.array(Type.int64())),
            Type.StructField.of("da", Type.array(Type.float64())),
            Type.StructField.of("byta", Type.array(Type.bytes())),
            Type.StructField.of("tsa", Type.array(Type.timestamp())),
            Type.StructField.of("dta", Type.array(Type.date())),
            Type.StructField.of("sa", Type.array(Type.string()))
        );
    Struct struct1 =
        Struct.newBuilder()
            .set("f1")
            .to("x")
            .set("f2")
            .to(2)
            .set("f3")
            .to(Value.bool(true))
            .set("d")
            .to(Value.float64(dval))
            .set("s")
            .to(s)
            .set("byt")
            .to(Value.bytes(ByteArray.copyFrom(byt)))
            .set("ts")
            .to(Timestamp.ofTimeMicroseconds(us))
            .set("dt")
            .to(Date.fromYearMonthDay(yr, month, day))
            .set("ba")
            .to(Value.boolArray(ba))
            .set("la")
            .to(Value.int64Array(la))
            .set("da")
            .to(Value.float64Array(da))
            .set("byta")
            .to(Value.bytesArray(Arrays.asList(byta)))
            .set("tsa")
            .to(Value.timestampArray(Arrays.asList(tsa)))
            .set("dta")
            .to(Value.dateArray(Arrays.asList(dta)))
            .set("sa")
            .to(Value.stringArray(Arrays.asList(sa)))
            .build();
    Struct struct2 =
        Struct.newBuilder()
            .set("f1")
            .to("y")
            .set("f2")
            .to(3)
            .set("f3")
            .to(Value.bool(null))
            .set("d")
            .to(Value.float64(dval))
            .set("s")
            .to(s)
            .set("byt")
            .to(Value.bytes(ByteArray.copyFrom(byt)))
            .set("ts")
            .to(Timestamp.ofTimeMicroseconds(us))
            .set("dt")
            .to(Date.fromYearMonthDay(yr, month, day))
            .set("ba")
            .to(Value.boolArray(ba))
            .set("la")
            .to(Value.int64Array(la))
            .set("da")
            .to(Value.float64Array(da))
            .set("byta")
            .to(Value.bytesArray(Arrays.asList(byta)))
            .set("tsa")
            .to(Value.timestampArray(Arrays.asList(tsa)))
            .set("dta")
            .to(Value.dateArray(Arrays.asList(dta)))
            .set("sa")
            .to(Value.stringArray(Arrays.asList(sa)))
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
    assertThat(rs.getDouble("d")).isWithin(0.0).of(dval);
    assertThat(rs.getDouble(3)).isWithin(0.0).of(dval);
    assertThat(rs.getString(4)).isEqualTo(s);
    assertThat(rs.getString("s")).isEqualTo(s);
    assertThat(rs.getBytes(5)).isEqualTo(ByteArray.copyFrom(byt));
    assertThat(rs.getBytes("byt")).isEqualTo(ByteArray.copyFrom(byt));
    assertThat(rs.getTimestamp(6)).isEqualTo(Timestamp.ofTimeMicroseconds(us));
    assertThat(rs.getTimestamp("ts")).isEqualTo(Timestamp.ofTimeMicroseconds(us));
    assertThat(rs.getDate(7)).isEqualTo(Date.fromYearMonthDay(yr, month, day));
    assertThat(rs.getDate("dt")).isEqualTo(Date.fromYearMonthDay(yr, month, day));
    assertThat(rs.getBooleanArray(8)).isEqualTo(ba);
    assertThat(rs.getBooleanArray("ba")).isEqualTo(ba);
    assertThat(rs.getBooleanList(8)).isEqualTo(Booleans.asList(ba));
    assertThat(rs.getBooleanList("ba")).isEqualTo(Booleans.asList(ba));
    assertThat(rs.getLongArray(9)).isEqualTo(la);
    assertThat(rs.getLongArray("la")).isEqualTo(la);
    assertThat(rs.getLongList(9)).isEqualTo(Longs.asList(la));
    assertThat(rs.getLongList("la")).isEqualTo(Longs.asList(la));
    assertThat(rs.getDoubleArray(10)).isEqualTo(da, 0.0);
    assertThat(rs.getDoubleArray("da")).isEqualTo(da, 0.0);
    assertThat(rs.getDoubleList(10)).isEqualTo(Doubles.asList(da));
    assertThat(rs.getDoubleList("da")).isEqualTo(Doubles.asList(da));
    assertThat(rs.getBytesList(11)).isEqualTo(Arrays.asList(byta));
    assertThat(rs.getBytesList("byta")).isEqualTo(Arrays.asList(byta));
    assertThat(rs.getTimestampList(12)).isEqualTo(Arrays.asList(tsa));
    assertThat(rs.getTimestampList("tsa")).isEqualTo(Arrays.asList(tsa));
    assertThat(rs.getDateList(13)).isEqualTo(Arrays.asList(dta));
    assertThat(rs.getDateList("dta")).isEqualTo(Arrays.asList(dta));
    assertThat(rs.getStringList(14)).isEqualTo(Arrays.asList(sa));
    assertThat(rs.getStringList("sa")).isEqualTo(Arrays.asList(sa));

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
