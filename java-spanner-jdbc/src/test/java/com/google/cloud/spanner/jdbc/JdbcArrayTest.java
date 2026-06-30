/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static com.google.cloud.spanner.jdbc.JdbcTypeConverter.toSqlDate;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.cloud.spanner.jdbc.it.SingerProto.Genre;
import com.google.cloud.spanner.jdbc.it.SingerProto.SingerInfo;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcArrayTest {

  @Test
  public void testCreateArrayTypeName() throws SQLException {
    // Note that JDBC array indices start at 1.
    JdbcArray array;
    array = JdbcArray.createArray("BOOL", new Boolean[] {true, false, true});
    assertThat(array.getBaseType()).isEqualTo(Types.BOOLEAN);
    assertThat(((Boolean[]) array.getArray(1, 1))[0]).isEqualTo(Boolean.TRUE);
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBoolean(2)).isEqualTo(true);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBoolean(2)).isEqualTo(false);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBoolean(2)).isEqualTo(true);
      assertThat(rs.next()).isFalse();
    }

    array = JdbcArray.createArray("BYTES", new byte[][] {new byte[] {1, 2}, new byte[] {3, 4}});
    assertThat(array.getBaseType()).isEqualTo(Types.BINARY);
    assertThat(((byte[][]) array.getArray(1, 1))[0][1]).isEqualTo((byte) 2);
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes(2)).isEqualTo(new byte[] {1, 2});
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes(2)).isEqualTo(new byte[] {3, 4});
      assertThat(rs.next()).isFalse();
    }

    array =
        JdbcArray.createArray(
            "DATE",
            new Date[] {
              toSqlDate(com.google.cloud.Date.fromYearMonthDay(2021, 1, 18)),
              toSqlDate(com.google.cloud.Date.fromYearMonthDay(2000, 2, 29)),
              toSqlDate(com.google.cloud.Date.fromYearMonthDay(2019, 8, 31))
            });
    assertThat(array.getBaseType()).isEqualTo(Types.DATE);
    assertThat(((Date[]) array.getArray(1, 1))[0])
        .isEqualTo(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2021, 1, 18)));
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDate(2))
          .isEqualTo(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2021, 1, 18)));
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDate(2))
          .isEqualTo(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2000, 2, 29)));
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDate(2))
          .isEqualTo(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2019, 8, 31)));
      assertThat(rs.next()).isFalse();
    }

    array =
        JdbcArray.createArray(
            "FLOAT32", new Float[] {1.1f, 2.2f, Double.valueOf(Math.PI).floatValue()});
    assertEquals(Types.REAL, array.getBaseType());
    assertThat(((Float[]) array.getArray(1, 3))[2]).isEqualTo(Double.valueOf(Math.PI).floatValue());
    assertEquals(Double.valueOf(Math.PI).floatValue(), ((Float[]) array.getArray(1, 3))[2], 0.0f);
    try (ResultSet resultSet = array.getResultSet()) {
      assertTrue(resultSet.next());
      // Column index 2 of a JDBC array is the value.
      // Column index 1 of a JDBC array is the index.
      assertEquals(1.1f, resultSet.getFloat(2), 0.0f);
      assertTrue(resultSet.next());
      assertEquals(2.2f, resultSet.getFloat(2), 0.0f);
      assertTrue(resultSet.next());
      assertEquals(Double.valueOf(Math.PI).floatValue(), resultSet.getFloat(2), 0.0f);
      assertFalse(resultSet.next());
    }

    array = JdbcArray.createArray("FLOAT64", new Double[] {1.1D, 2.2D, Math.PI});
    assertThat(array.getBaseType()).isEqualTo(Types.DOUBLE);
    assertThat(((Double[]) array.getArray(1, 3))[2]).isEqualTo(Math.PI);
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDouble(2)).isEqualTo(1.1D);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDouble(2)).isEqualTo(2.2D);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getDouble(2)).isEqualTo(Math.PI);
      assertThat(rs.next()).isFalse();
    }

    array = JdbcArray.createArray("INT64", new Long[] {1L, 2L, 3L});
    assertThat(array.getBaseType()).isEqualTo(Types.BIGINT);
    assertThat(((Long[]) array.getArray(1, 1))[0]).isEqualTo(1L);
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getLong(2)).isEqualTo(1L);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getLong(2)).isEqualTo(2L);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getLong(2)).isEqualTo(3L);
      assertThat(rs.next()).isFalse();
    }

    // Test that Byte[] arrays are automatically widened to Long[] for INT64 type
    Long[] data;
    array = JdbcArray.createArray("INT64", new Byte[] {1, 2, 3, null, Byte.MAX_VALUE});
    assertThat(array.getBaseType()).isEqualTo(Types.BIGINT);
    // Data should be stored as Long[]
    assertThat(array.getArray()).isInstanceOf(Long[].class);
    data = (Long[]) array.getArray();
    assertThat(data[0]).isEqualTo(1L);
    assertThat(data[1]).isEqualTo(2L);
    assertThat(data[2]).isEqualTo(3L);
    assertThat(data[3]).isNull();
    assertThat(data[4]).isEqualTo((long) Byte.MAX_VALUE);

    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getByte(2)).isEqualTo((byte) 1);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getByte(2)).isEqualTo((byte) 2);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getByte(2)).isEqualTo((byte) 3);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getByte(2)).isEqualTo((byte) 0);
      assertTrue(rs.wasNull());
      assertThat(rs.next()).isTrue();
      assertThat(rs.getByte(2)).isEqualTo(Byte.MAX_VALUE);
      assertThat(rs.next()).isFalse();
    }

    // Test that Short[] arrays are automatically widened to Long[] for INT64 type
    array = JdbcArray.createArray("INT64", new Short[] {100, 200, null, Short.MAX_VALUE});
    assertThat(array.getBaseType()).isEqualTo(Types.BIGINT);
    // Data should be stored as Long[]
    assertThat(array.getArray()).isInstanceOf(Long[].class);
    data = (Long[]) array.getArray();
    assertThat(data[0]).isEqualTo(100L);
    assertThat(data[1]).isEqualTo(200L);
    assertThat(data[2]).isNull();
    assertThat(data[3]).isEqualTo((long) Short.MAX_VALUE);

    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getShort(2)).isEqualTo((short) 100);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getShort(2)).isEqualTo((short) 200);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getShort(2)).isEqualTo((short) 0);
      assertTrue(rs.wasNull());
      assertThat(rs.next()).isTrue();
      assertThat(rs.getShort(2)).isEqualTo(Short.MAX_VALUE);
      assertThat(rs.next()).isFalse();
    }

    // Test that Integer[] arrays are automatically widened to Long[] for INT64 type
    array = JdbcArray.createArray("INT64", new Integer[] {1000, 2000, null, Integer.MAX_VALUE});
    assertThat(array.getBaseType()).isEqualTo(Types.BIGINT);
    // Data should be stored as Long[]
    assertThat(array.getArray()).isInstanceOf(Long[].class);
    data = (Long[]) array.getArray();
    assertThat(data[0]).isEqualTo(1000L);
    assertThat(data[1]).isEqualTo(2000L);
    assertThat(data[2]).isNull();
    assertThat(data[3]).isEqualTo((long) Integer.MAX_VALUE);

    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getInt(2)).isEqualTo(1000);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getInt(2)).isEqualTo(2000);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getInt(2)).isEqualTo(0);
      assertTrue(rs.wasNull());
      assertThat(rs.next()).isTrue();
      assertThat(rs.getInt(2)).isEqualTo(Integer.MAX_VALUE);
      assertThat(rs.next()).isFalse();
    }

    array =
        JdbcArray.createArray("NUMERIC", new BigDecimal[] {BigDecimal.ONE, null, BigDecimal.TEN});
    assertThat(array.getBaseType()).isEqualTo(Types.NUMERIC);
    assertThat(((BigDecimal[]) array.getArray(1, 1))[0]).isEqualTo(BigDecimal.ONE);
    assertThat(((BigDecimal[]) array.getArray(2, 1))[0]).isNull();
    assertThat(((BigDecimal[]) array.getArray(3, 1))[0]).isEqualTo(BigDecimal.TEN);
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBigDecimal(2)).isEqualTo(BigDecimal.ONE);
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBigDecimal(2)).isNull();
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBigDecimal(2)).isEqualTo(BigDecimal.TEN);
      assertThat(rs.next()).isFalse();
    }

    array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    assertThat(array.getBaseType()).isEqualTo(Types.NVARCHAR);
    assertThat(((String[]) array.getArray(1, 1))[0]).isEqualTo("foo");
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("foo");
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("bar");
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("baz");
      assertThat(rs.next()).isFalse();
    }

    array =
        JdbcArray.createArray(
            "JSON",
            new String[] {"{}", "[]", null, "{\"name\":\"John\", \"age\":30, \"car\":null}"});
    assertThat(array.getBaseType()).isEqualTo(JsonType.VENDOR_TYPE_NUMBER);
    assertThat(((String[]) array.getArray(1, 1))[0]).isEqualTo("{}");
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertEquals("{}", rs.getString(2));
      assertTrue(rs.next());
      assertEquals("[]", rs.getString(2));
      assertTrue(rs.next());
      assertNull(rs.getString(2));
      assertTrue(rs.wasNull());
      assertTrue(rs.next());
      assertEquals("{\"name\":\"John\", \"age\":30, \"car\":null}", rs.getString(2));
      assertFalse(rs.next());
    }

    array =
        JdbcArray.createArray(
            "JSONB",
            new String[] {"{}", "[]", null, "{\"name\":\"John\", \"age\":30, \"car\":null}"});
    assertThat(array.getBaseType()).isEqualTo(PgJsonbType.VENDOR_TYPE_NUMBER);
    assertThat(((String[]) array.getArray(1, 1))[0]).isEqualTo("{}");
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertEquals("{}", rs.getString(2));
      assertTrue(rs.next());
      assertEquals("[]", rs.getString(2));
      assertTrue(rs.next());
      assertNull(rs.getString(2));
      assertTrue(rs.wasNull());
      assertTrue(rs.next());
      assertEquals("{\"name\":\"John\", \"age\":30, \"car\":null}", rs.getString(2));
      assertFalse(rs.next());
    }

    array =
        JdbcArray.createArray(
            "TIMESTAMP",
            new Timestamp[] {new Timestamp(1L), new Timestamp(100L), new Timestamp(1000L)});
    assertThat(array.getBaseType()).isEqualTo(Types.TIMESTAMP);
    assertThat(((Timestamp[]) array.getArray(1, 1))[0]).isEqualTo(new Timestamp(1L));
    try (ResultSet rs = array.getResultSet()) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getTimestamp(2)).isEqualTo(new Timestamp(1L));
      assertThat(rs.next()).isTrue();
      assertThat(rs.getTimestamp(2)).isEqualTo(new Timestamp(100L));
      assertThat(rs.next()).isTrue();
      assertThat(rs.getTimestamp(2)).isEqualTo(new Timestamp(1000L));
      assertThat(rs.next()).isFalse();
    }

    SingerInfo singerInfo =
        SingerInfo.newBuilder().setSingerId(1).setNationality("Country1").build();
    array =
        JdbcArray.createArray(
            "PROTO", new SingerInfo[] {singerInfo, SingerInfo.getDefaultInstance(), null});
    assertEquals(ProtoMessageType.VENDOR_TYPE_NUMBER, array.getBaseType());
    assertEquals(singerInfo, ((SingerInfo[]) array.getArray(1, 1))[0]);
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertEquals(singerInfo, rs.getObject(2, SingerInfo.class));
      assertArrayEquals(singerInfo.toByteArray(), rs.getBytes(2));
      assertTrue(rs.next());
      assertEquals(SingerInfo.getDefaultInstance(), rs.getObject(2, SingerInfo.class));
      assertArrayEquals(SingerInfo.getDefaultInstance().toByteArray(), rs.getBytes(2));
      assertTrue(rs.next());
      assertNull(rs.getObject(2, SingerInfo.class));
      assertNull(rs.getBytes(2));
      assertFalse(rs.next());
    }

    array = JdbcArray.createArray("ENUM", new Genre[] {Genre.ROCK, Genre.FOLK, null});
    assertEquals(ProtoEnumType.VENDOR_TYPE_NUMBER, array.getBaseType());
    assertEquals(Genre.ROCK, ((Genre[]) array.getArray(1, 1))[0]);
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertEquals(Genre.ROCK, rs.getObject(2, Genre.class));
      assertEquals(Genre.ROCK.getNumber(), rs.getInt(2));
      assertTrue(rs.next());
      assertEquals(Genre.FOLK, rs.getObject(2, Genre.class));
      assertEquals(Genre.FOLK.getNumber(), rs.getInt(2));
      assertTrue(rs.next());
      assertNull(rs.getObject(2, Genre.class));
      assertEquals(0, rs.getInt(2));
      assertFalse(rs.next());
    }

    array =
        JdbcArray.createArray(
            JdbcDataType.getType(Code.PROTO),
            Arrays.asList(
                singerInfo.toByteArray(), SingerInfo.getDefaultInstance().toByteArray(), null));
    assertEquals(ProtoMessageType.VENDOR_TYPE_NUMBER, array.getBaseType());
    assertArrayEquals(singerInfo.toByteArray(), ((byte[][]) array.getArray(1, 1))[0]);
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertArrayEquals(singerInfo.toByteArray(), rs.getBytes(2));
      assertTrue(rs.next());
      assertArrayEquals(SingerInfo.getDefaultInstance().toByteArray(), rs.getBytes(2));
      assertTrue(rs.next());
      assertNull(rs.getBytes(2));
      assertFalse(rs.next());
    }

    array =
        JdbcArray.createArray(
            JdbcDataType.getType(Code.ENUM),
            Arrays.asList((long) Genre.ROCK.getNumber(), (long) Genre.FOLK.getNumber(), null));
    assertEquals(ProtoEnumType.VENDOR_TYPE_NUMBER, array.getBaseType());
    assertEquals(Genre.ROCK.getNumber(), (long) ((Long[]) array.getArray(1, 1))[0]);
    try (ResultSet rs = array.getResultSet()) {
      assertTrue(rs.next());
      assertEquals(Genre.ROCK.getNumber(), rs.getInt(2));
      assertTrue(rs.next());
      assertEquals(Genre.FOLK.getNumber(), rs.getInt(2));
      assertTrue(rs.next());
      assertEquals(0, rs.getInt(2));
      assertFalse(rs.next());
    }
  }

  @Test
  public void testCreateArrayOfArray() {
    try {
      JdbcArray.createArray("ARRAY<STRING>", new String[][] {{}});
      fail("missing expected exception");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      JdbcSqlException jse = (JdbcSqlException) e;
      assertThat(jse.getErrorCode())
          .isEqualTo(ErrorCode.INVALID_ARGUMENT.getGrpcStatusCode().value());
    }
  }

  @Test
  public void testCreateArrayOfStruct() throws SQLException {
    JdbcArray array =
        JdbcArray.createArray(
            "STRUCT",
            new Struct[] {Struct.newBuilder().set("f1").to("v1").set("f2").to(1L).build(), null});
    assertEquals(Types.STRUCT, array.getBaseType());
    assertThat((Struct[]) array.getArray())
        .asList()
        .containsExactly(Struct.newBuilder().set("f1").to("v1").set("f2").to(1L).build(), null)
        .inOrder();
    assertThrows(SQLFeatureNotSupportedException.class, array::getResultSet);
  }

  @Test
  public void testGetResultSetMetadata() throws SQLException {
    JdbcArray array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    try (ResultSet rs = array.getResultSet()) {
      ResultSetMetaData metadata = rs.getMetaData();
      assertThat(metadata.getColumnCount()).isEqualTo(2);
      assertThat(metadata.getColumnType(1)).isEqualTo(Types.BIGINT);
      assertThat(metadata.getColumnType(2)).isEqualTo(Types.NVARCHAR);
      assertThat(metadata.getColumnName(1)).isEqualTo("INDEX");
      assertThat(metadata.getColumnName(2)).isEqualTo("VALUE");
    }
  }

  @Test
  public void testGetResultSetWithIndex() throws SQLException {
    JdbcArray array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    try (ResultSet rs = array.getResultSet(2L, 1)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getLong("INDEX")).isEqualTo(2L);
      assertThat(rs.getString("VALUE")).isEqualTo("bar");
      assertThat(rs.next()).isFalse();
    }

    try (ResultSet rs = array.getResultSet(1L, 5)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("foo");
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("bar");
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(2)).isEqualTo("baz");
      assertThat(rs.next()).isFalse();
    }

    try (ResultSet rs = array.getResultSet(1L, 0)) {
      assertThat(rs.next()).isFalse();
    }
  }

  @Test
  public void testGetResultSetWithInvalidIndex() throws SQLException {
    JdbcArray array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    try (ResultSet rs = array.getResultSet(0L, 1)) {
      fail("missing expected exception");
    } catch (JdbcSqlExceptionImpl e) {
      assertThat(e.getErrorCode())
          .isEqualTo(ErrorCode.INVALID_ARGUMENT.getGrpcStatusCode().value());
    }
  }

  @Test
  public void testGetResultSetWithInvalidCount() throws SQLException {
    JdbcArray array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    try (ResultSet rs = array.getResultSet(1L, -1)) {
      fail("missing expected exception");
    } catch (JdbcSqlExceptionImpl e) {
      assertThat(e.getErrorCode())
          .isEqualTo(ErrorCode.INVALID_ARGUMENT.getGrpcStatusCode().value());
    }
  }
}
