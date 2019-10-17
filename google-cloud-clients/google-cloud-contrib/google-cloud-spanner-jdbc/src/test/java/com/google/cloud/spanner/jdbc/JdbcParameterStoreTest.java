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

import static com.google.cloud.spanner.jdbc.JdbcParameterStore.convertPositionalParametersToNamedParameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.common.io.CharStreams;
import com.google.rpc.Code;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcParameterStoreTest {

  /** Tests setting a parameter value together with a sql type */
  @SuppressWarnings("deprecation")
  @Test
  public void testSetParameterWithType() throws SQLException, IOException {
    JdbcParameterStore params = new JdbcParameterStore();
    // test the valid default combinations
    params.setParameter(1, true, Types.BOOLEAN);
    assertThat((Boolean) params.getParameter(1), is(equalTo(true)));
    verifyParameter(params, Value.bool(true));
    params.setParameter(1, (byte) 1, Types.TINYINT);
    assertThat((Byte) params.getParameter(1), is(equalTo((byte) 1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, (short) 1, Types.SMALLINT);
    assertThat((Short) params.getParameter(1), is(equalTo((short) 1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, 1, Types.INTEGER);
    assertThat((Integer) params.getParameter(1), is(equalTo(1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, 1L, Types.BIGINT);
    assertThat((Long) params.getParameter(1), is(equalTo(1L)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, (float) 1, Types.FLOAT);
    assertThat((Float) params.getParameter(1), is(equalTo((float) 1)));
    verifyParameter(params, Value.float64(1));
    params.setParameter(1, (double) 1, Types.DOUBLE);
    assertThat((Double) params.getParameter(1), is(equalTo((double) 1)));
    verifyParameter(params, Value.float64(1));
    params.setParameter(1, new Date(1970 - 1900, 0, 1), Types.DATE);
    assertThat((Date) params.getParameter(1), is(equalTo(new Date(1970 - 1900, 0, 1))));
    verifyParameter(params, Value.date(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1)));
    params.setParameter(1, new Time(0L), Types.TIME);
    assertThat((Time) params.getParameter(1), is(equalTo(new Time(0L))));
    verifyParameter(
        params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
    params.setParameter(1, new Timestamp(0L), Types.TIMESTAMP);
    assertThat((Timestamp) params.getParameter(1), is(equalTo(new Timestamp(0L))));
    verifyParameter(
        params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
    params.setParameter(1, new byte[] {1, 2, 3}, Types.BINARY);
    assertThat((byte[]) params.getParameter(1), is(equalTo(new byte[] {1, 2, 3})));
    verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));
    params.setParameter(1, "test", Types.NVARCHAR);
    assertThat((String) params.getParameter(1), is(equalTo("test")));
    verifyParameter(params, Value.string("test"));

    params.setParameter(1, new JdbcBlob(new byte[] {1, 2, 3}), Types.BLOB);
    assertThat((JdbcBlob) params.getParameter(1), is(equalTo(new JdbcBlob(new byte[] {1, 2, 3}))));
    verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));
    params.setParameter(1, new ByteArrayInputStream(new byte[] {1, 2, 3}), Types.BLOB);
    verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));

    params.setParameter(1, new JdbcClob("test"), Types.CLOB);
    assertThat((JdbcClob) params.getParameter(1), is(equalTo(new JdbcClob("test"))));
    verifyParameter(params, Value.string("test"));
    params.setParameter(1, new StringReader("test"), Types.CLOB);
    assertThat(
        stringReadersEqual((StringReader) params.getParameter(1), new StringReader("test")),
        is(true));
    verifyParameter(params, Value.string("test"));

    params.setParameter(1, new JdbcClob("test"), Types.NCLOB);
    assertThat((JdbcClob) params.getParameter(1), is(equalTo(new JdbcClob("test"))));
    verifyParameter(params, Value.string("test"));
    params.setParameter(1, new StringReader("test"), Types.NCLOB);
    assertThat(
        stringReadersEqual((StringReader) params.getParameter(1), new StringReader("test")),
        is(true));
    verifyParameter(params, Value.string("test"));

    // test unsupported types
    boolean expectedException = false;
    try {
      params.setParameter(1, BigDecimal.ONE, Types.DECIMAL);
    } catch (SQLException e) {
      if (e instanceof JdbcSqlException) {
        expectedException = ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT;
      }
    }
    assertThat(expectedException, is(true));

    // types that should lead to int64
    for (int type : new int[] {Types.TINYINT, Types.SMALLINT, Types.INTEGER, Types.BIGINT}) {
      params.setParameter(1, (byte) 1, type);
      assertThat((Byte) params.getParameter(1), is(equalTo((byte) 1)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, (short) 1, type);
      assertThat((Short) params.getParameter(1), is(equalTo((short) 1)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, 1, type);
      assertThat((Integer) params.getParameter(1), is(equalTo(1)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, 1L, type);
      assertThat((Long) params.getParameter(1), is(equalTo(1L)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, (float) 1, type);
      assertThat((Float) params.getParameter(1), is(equalTo((float) 1)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, (double) 1, type);
      assertThat((Double) params.getParameter(1), is(equalTo((double) 1)));
      verifyParameter(params, Value.int64(1));
      params.setParameter(1, BigDecimal.ONE, type);
      assertThat((BigDecimal) params.getParameter(1), is(equalTo(BigDecimal.ONE)));
      verifyParameter(params, Value.int64(1));
    }

    // types that should lead to float64
    for (int type : new int[] {Types.FLOAT, Types.REAL, Types.DOUBLE}) {
      params.setParameter(1, (byte) 1, type);
      assertThat((Byte) params.getParameter(1), is(equalTo((byte) 1)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, (short) 1, type);
      assertThat((Short) params.getParameter(1), is(equalTo((short) 1)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, 1, type);
      assertThat((Integer) params.getParameter(1), is(equalTo(1)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, 1L, type);
      assertThat((Long) params.getParameter(1), is(equalTo(1L)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, (float) 1, type);
      assertThat((Float) params.getParameter(1), is(equalTo((float) 1)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, (double) 1, type);
      assertThat((Double) params.getParameter(1), is(equalTo((double) 1)));
      verifyParameter(params, Value.float64(1));
      params.setParameter(1, BigDecimal.ONE, type);
      assertThat((BigDecimal) params.getParameter(1), is(equalTo(BigDecimal.ONE)));
      verifyParameter(params, Value.float64(1));
    }

    // types that should lead to date
    for (int type : new int[] {Types.DATE}) {
      params.setParameter(1, new Date(1970 - 1900, 0, 1), type);
      assertThat((Date) params.getParameter(1), is(equalTo(new Date(1970 - 1900, 0, 1))));
      verifyParameter(params, Value.date(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1)));
      params.setParameter(1, new Time(0L), type);
      assertThat((Time) params.getParameter(1), is(equalTo(new Time(0L))));
      verifyParameter(params, Value.date(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1)));
      params.setParameter(1, new Timestamp(1970 - 1900, 0, 1, 0, 0, 0, 0), type);
      assertThat(
          (Timestamp) params.getParameter(1),
          is(equalTo(new Timestamp(1970 - 1900, 0, 1, 0, 0, 0, 0))));
      verifyParameter(params, Value.date(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1)));
    }

    // types that should lead to timestamp
    for (int type : new int[] {Types.TIME, Types.TIMESTAMP}) {
      params.setParameter(1, new Date(0L), type);
      assertThat((Date) params.getParameter(1), is(equalTo(new Date(0L))));
      verifyParameter(
          params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
      params.setParameter(1, new Time(0L), type);
      assertThat((Time) params.getParameter(1), is(equalTo(new Time(0L))));
      verifyParameter(
          params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
      params.setParameter(1, new Timestamp(0L), type);
      assertThat((Timestamp) params.getParameter(1), is(equalTo(new Timestamp(0L))));
      verifyParameter(
          params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
    }

    // types that should lead to bytes (except BLOB which is handled separately)
    for (int type : new int[] {Types.BINARY, Types.VARBINARY, Types.LONGVARBINARY}) {
      params.setParameter(1, new byte[] {1, 2, 3}, type);
      assertThat((byte[]) params.getParameter(1), is(equalTo(new byte[] {1, 2, 3})));
      verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));
    }

    // types that should lead to string
    for (int type :
        new int[] {
          Types.CHAR,
          Types.VARCHAR,
          Types.LONGVARCHAR,
          Types.NCHAR,
          Types.NVARCHAR,
          Types.LONGNVARCHAR
        }) {
      params.setParameter(1, "test", type);
      assertThat((String) params.getParameter(1), is(equalTo("test")));
      verifyParameter(params, Value.string("test"));

      params.setParameter(1, new StringReader("test"), type);
      assertThat(
          stringReadersEqual((StringReader) params.getParameter(1), new StringReader("test")),
          is(true));
      verifyParameter(params, Value.string("test"));

      params.setParameter(
          1, new ByteArrayInputStream(StandardCharsets.US_ASCII.encode("test").array()), type);
      assertThat(
          asciiStreamsEqual(
              (ByteArrayInputStream) params.getParameter(1),
              new ByteArrayInputStream(StandardCharsets.US_ASCII.encode("test").array())),
          is(true));
      verifyParameter(params, Value.string("test"));

      params.setParameter(1, new URL("https://cloud.google.com/spanner"), type);
      assertThat(
          (URL) params.getParameter(1), is(equalTo(new URL("https://cloud.google.com/spanner"))));
      verifyParameter(params, Value.string("https://cloud.google.com/spanner"));
    }

    // types that should lead to bool
    for (int type : new int[] {Types.BOOLEAN, Types.BIT}) {
      params.setParameter(1, true, type);
      assertThat((Boolean) params.getParameter(1), is(equalTo(true)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, (byte) 1, type);
      assertThat((Byte) params.getParameter(1), is(equalTo((byte) 1)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, (short) 0, type);
      assertThat((Short) params.getParameter(1), is(equalTo((short) 0)));
      verifyParameter(params, Value.bool(false));
      params.setParameter(1, 1, type);
      assertThat((Integer) params.getParameter(1), is(equalTo(1)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, 1L, type);
      assertThat((Long) params.getParameter(1), is(equalTo(1L)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, (float) 1, type);
      assertThat((Float) params.getParameter(1), is(equalTo((float) 1)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, (double) 1, type);
      assertThat((Double) params.getParameter(1), is(equalTo((double) 1)));
      verifyParameter(params, Value.bool(true));
      params.setParameter(1, BigDecimal.ZERO, type);
      assertThat((BigDecimal) params.getParameter(1), is(equalTo(BigDecimal.ZERO)));
      verifyParameter(params, Value.bool(false));
    }
  }

  @Test
  public void testSetInvalidParameterWithType() throws SQLException, IOException {
    JdbcParameterStore params = new JdbcParameterStore();

    // types that should lead to int64, but with invalid values.
    for (int type : new int[] {Types.TINYINT, Types.SMALLINT, Types.INTEGER, Types.BIGINT}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
    }

    // types that should lead to float64
    for (int type : new int[] {Types.FLOAT, Types.REAL, Types.DOUBLE}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
    }

    // types that should lead to date
    for (int type : new int[] {Types.DATE}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
      assertInvalidParameter(params, 1, type);
      assertInvalidParameter(params, 1L, type);
    }

    // types that should lead to timestamp
    for (int type : new int[] {Types.TIME, Types.TIMESTAMP}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
      assertInvalidParameter(params, 1, type);
      assertInvalidParameter(params, 1L, type);
    }

    // types that should lead to bytes (except BLOB which is handled separately)
    for (int type : new int[] {Types.BINARY, Types.VARBINARY, Types.LONGVARBINARY}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
      assertInvalidParameter(params, 1, type);
      assertInvalidParameter(params, 1L, type);
      assertInvalidParameter(params, new JdbcBlob(), type);
    }

    for (int type :
        new int[] {
          Types.CHAR,
          Types.VARCHAR,
          Types.LONGVARCHAR,
          Types.NCHAR,
          Types.NVARCHAR,
          Types.LONGNVARCHAR
        }) {
      assertInvalidParameter(params, new Object(), type);
      assertInvalidParameter(params, Boolean.TRUE, type);
      assertInvalidParameter(params, 1, type);
      assertInvalidParameter(params, 1L, type);
      assertInvalidParameter(params, new JdbcBlob(), type);
      assertInvalidParameter(params, new JdbcClob(), type);
    }

    // types that should lead to bool
    for (int type : new int[] {Types.BOOLEAN, Types.BIT}) {
      assertInvalidParameter(params, "1", type);
      assertInvalidParameter(params, "true", type);
      assertInvalidParameter(params, new Object(), type);
    }

    assertInvalidParameter(params, BigDecimal.ONE, Types.DECIMAL);
    assertInvalidParameter(params, BigDecimal.ZERO, Types.NUMERIC);

    // test setting closed readers and streams.
    for (int type :
        new int[] {
          Types.CHAR,
          Types.VARCHAR,
          Types.LONGVARCHAR,
          Types.NCHAR,
          Types.NVARCHAR,
          Types.LONGNVARCHAR
        }) {
      Reader reader = new StringReader("test");
      reader.close();
      params.setParameter(1, reader, type);
      verifyParameterBindFails(params);

      InputStream stream =
          new InputStream() {
            @Override
            public int read() throws IOException {
              throw new IOException();
            }
          };
      params.setParameter(1, stream, type);
      verifyParameterBindFails(params);
    }
  }

  private void assertInvalidParameter(JdbcParameterStore params, Object value, int type)
      throws SQLException {
    try {
      params.setParameter(1, value, type);
      fail("missing expected exception");
    } catch (JdbcSqlExceptionImpl e) {
      assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
    }
  }

  /**
   * Tests setting a parameter value without knowing the sql type. The type must be deferred from
   * the type of the parameter value
   */
  @SuppressWarnings("deprecation")
  @Test
  public void testSetParameterWithoutType() throws SQLException {
    JdbcParameterStore params = new JdbcParameterStore();
    params.setParameter(1, (byte) 1, null);
    assertThat((Byte) params.getParameter(1), is(equalTo((byte) 1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, (short) 1, null);
    assertThat((Short) params.getParameter(1), is(equalTo((short) 1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, 1, null);
    assertThat((Integer) params.getParameter(1), is(equalTo(1)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, 1L, null);
    assertThat((Long) params.getParameter(1), is(equalTo(1L)));
    verifyParameter(params, Value.int64(1));
    params.setParameter(1, (float) 1, null);
    assertThat((Float) params.getParameter(1), is(equalTo((float) 1)));
    verifyParameter(params, Value.float64(1));
    params.setParameter(1, (double) 1, null);
    assertThat((Double) params.getParameter(1), is(equalTo((double) 1)));
    verifyParameter(params, Value.float64(1));
    params.setParameter(1, new Date(1970 - 1900, 0, 1), null);
    assertThat((Date) params.getParameter(1), is(equalTo(new Date(1970 - 1900, 0, 1))));
    verifyParameter(params, Value.date(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1)));
    params.setParameter(1, new Time(0L), null);
    assertThat((Time) params.getParameter(1), is(equalTo(new Time(0L))));
    verifyParameter(
        params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
    params.setParameter(1, new Timestamp(0L), null);
    assertThat((Timestamp) params.getParameter(1), is(equalTo(new Timestamp(0L))));
    verifyParameter(
        params, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(0L, 0)));
    params.setParameter(1, new byte[] {1, 2, 3}, null);
    assertThat((byte[]) params.getParameter(1), is(equalTo(new byte[] {1, 2, 3})));
    verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));

    params.setParameter(1, new JdbcBlob(new byte[] {1, 2, 3}), null);
    assertThat((JdbcBlob) params.getParameter(1), is(equalTo(new JdbcBlob(new byte[] {1, 2, 3}))));
    verifyParameter(params, Value.bytes(ByteArray.copyFrom(new byte[] {1, 2, 3})));
    params.setParameter(1, new JdbcClob("test"), null);
    assertThat((JdbcClob) params.getParameter(1), is(equalTo(new JdbcClob("test"))));
    verifyParameter(params, Value.string("test"));
    params.setParameter(1, true, null);
    assertThat((Boolean) params.getParameter(1), is(equalTo(true)));
    verifyParameter(params, Value.bool(true));
    params.setParameter(1, "test", null);
    assertThat((String) params.getParameter(1), is(equalTo("test")));
    verifyParameter(params, Value.string("test"));
    params.setParameter(1, new JdbcClob("test"), null);
    assertThat((JdbcClob) params.getParameter(1), is(equalTo(new JdbcClob("test"))));
    verifyParameter(params, Value.string("test"));
  }

  private boolean stringReadersEqual(StringReader r1, StringReader r2) throws IOException {
    boolean res = CharStreams.toString(r1).equals(CharStreams.toString(r2));
    r1.reset();
    r2.reset();
    return res;
  }

  private boolean asciiStreamsEqual(InputStream is1, InputStream is2) throws IOException {
    InputStreamReader r1 = new InputStreamReader(is1, StandardCharsets.US_ASCII);
    String s1 = CharStreams.toString(r1);
    InputStreamReader r2 = new InputStreamReader(is2, StandardCharsets.US_ASCII);
    String s2 = CharStreams.toString(r2);
    is1.reset();
    is2.reset();
    return s1.equals(s2);
  }

  /** Tests setting array types of parameters */
  @Test
  public void testSetArrayParameter() throws SQLException {
    JdbcParameterStore params = new JdbcParameterStore();
    params.setParameter(
        1, JdbcArray.createArray("BOOL", new Boolean[] {true, false, true}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("BOOL", new Boolean[] {true, false, true}))));
    verifyParameter(params, Value.boolArray(new boolean[] {true, false, true}));

    params.setParameter(
        1, JdbcArray.createArray("BOOL", new Boolean[] {true, false, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("BOOL", new Boolean[] {true, false, null}))));
    verifyParameter(params, Value.boolArray(Arrays.asList(true, false, null)));

    params.setParameter(1, JdbcArray.createArray("BOOL", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("BOOL", null))));
    verifyParameter(params, Value.boolArray((boolean[]) null));

    params.setParameter(1, JdbcArray.createArray("INT64", new Long[] {1L, 2L, 3L}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("INT64", new Long[] {1L, 2L, 3L}))));
    verifyParameter(params, Value.int64Array(new long[] {1, 2, 3}));

    params.setParameter(1, JdbcArray.createArray("INT64", new Long[] {1L, 2L, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("INT64", new Long[] {1L, 2L, null}))));
    verifyParameter(params, Value.int64Array(Arrays.asList(1L, 2L, null)));

    params.setParameter(1, JdbcArray.createArray("INT64", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("INT64", null))));
    verifyParameter(params, Value.int64Array((long[]) null));

    params.setParameter(
        1, JdbcArray.createArray("FLOAT64", new Double[] {1D, 2D, 3D}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("FLOAT64", new Double[] {1D, 2D, 3D}))));
    verifyParameter(params, Value.float64Array(new double[] {1, 2, 3}));

    params.setParameter(
        1, JdbcArray.createArray("FLOAT64", new Double[] {1D, 2D, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("FLOAT64", new Double[] {1D, 2D, null}))));
    verifyParameter(params, Value.float64Array(Arrays.asList(1D, 2D, null)));

    params.setParameter(1, JdbcArray.createArray("FLOAT64", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("FLOAT64", null))));
    verifyParameter(params, Value.float64Array((double[]) null));

    @SuppressWarnings("deprecation")
    Date sqlDate = new Date(2018 - 1900, 12 - 1, 14);
    params.setParameter(1, JdbcArray.createArray("DATE", new Date[] {sqlDate}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("DATE", new Date[] {sqlDate}))));
    verifyParameter(
        params,
        Value.dateArray(Arrays.asList(com.google.cloud.Date.fromYearMonthDay(2018, 12, 14))));

    params.setParameter(1, JdbcArray.createArray("DATE", new Date[] {sqlDate, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("DATE", new Date[] {sqlDate, null}))));
    verifyParameter(
        params,
        Value.dateArray(Arrays.asList(com.google.cloud.Date.fromYearMonthDay(2018, 12, 14), null)));

    params.setParameter(1, JdbcArray.createArray("DATE", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("DATE", null))));
    verifyParameter(params, Value.dateArray(null));

    Timestamp sqlTimestamp = new Timestamp(System.currentTimeMillis());
    params.setParameter(
        1, JdbcArray.createArray("TIMESTAMP", new Timestamp[] {sqlTimestamp}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("TIMESTAMP", new Timestamp[] {sqlTimestamp}))));
    verifyParameter(
        params, Value.timestampArray(Arrays.asList(com.google.cloud.Timestamp.of(sqlTimestamp))));

    params.setParameter(
        1, JdbcArray.createArray("TIMESTAMP", new Timestamp[] {sqlTimestamp, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("TIMESTAMP", new Timestamp[] {sqlTimestamp, null}))));
    verifyParameter(
        params,
        Value.timestampArray(Arrays.asList(com.google.cloud.Timestamp.of(sqlTimestamp), null)));

    params.setParameter(1, JdbcArray.createArray("TIMESTAMP", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("TIMESTAMP", null))));
    verifyParameter(params, Value.timestampArray(null));

    params.setParameter(
        1, JdbcArray.createArray("BYTES", new byte[][] {{1, 2, 3}, {4, 5, 6}}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("BYTES", new byte[][] {{1, 2, 3}, {4, 5, 6}}))));
    verifyParameter(
        params,
        Value.bytesArray(
            Arrays.asList(
                ByteArray.copyFrom(new byte[] {1, 2, 3}),
                ByteArray.copyFrom(new byte[] {4, 5, 6}))));

    params.setParameter(
        1, JdbcArray.createArray("BYTES", new byte[][] {{1, 2, 3}, {4, 5, 6}, null}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("BYTES", new byte[][] {{1, 2, 3}, {4, 5, 6}, null}))));
    verifyParameter(
        params,
        Value.bytesArray(
            Arrays.asList(
                ByteArray.copyFrom(new byte[] {1, 2, 3}),
                ByteArray.copyFrom(new byte[] {4, 5, 6}),
                null)));

    params.setParameter(1, JdbcArray.createArray("BYTES", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("BYTES", null))));
    verifyParameter(params, Value.bytesArray(null));

    params.setParameter(
        1, JdbcArray.createArray("STRING", new String[] {"test1", "test2", "test3"}), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(equalTo(JdbcArray.createArray("STRING", new String[] {"test1", "test2", "test3"}))));
    verifyParameter(params, Value.stringArray(Arrays.asList("test1", "test2", "test3")));

    params.setParameter(
        1,
        JdbcArray.createArray("STRING", new String[] {"test1", null, "test2", "test3"}),
        Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1),
        is(
            equalTo(
                JdbcArray.createArray("STRING", new String[] {"test1", null, "test2", "test3"}))));
    verifyParameter(params, Value.stringArray(Arrays.asList("test1", null, "test2", "test3")));

    params.setParameter(1, JdbcArray.createArray("STRING", null), Types.ARRAY);
    assertThat(
        (JdbcArray) params.getParameter(1), is(equalTo(JdbcArray.createArray("STRING", null))));
    verifyParameter(params, Value.stringArray(null));
  }

  private void verifyParameter(JdbcParameterStore params, Value value) throws SQLException {
    Statement.Builder builder = Statement.newBuilder("SELECT * FROM FOO WHERE BAR=:p1");
    params.bindParameterValue(builder.bind("p1"), 1);
    assertThat(builder.build().getParameters().get("p1"), is(equalTo(value)));
  }

  private void verifyParameterBindFails(JdbcParameterStore params) throws SQLException {
    Statement.Builder builder = Statement.newBuilder("SELECT * FROM FOO WHERE BAR=:p1");
    try {
      params.bindParameterValue(builder.bind("p1"), 1);
      fail("missing expected exception");
    } catch (JdbcSqlExceptionImpl e) {
      assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
    }
  }

  @Test
  public void testConvertPositionalParametersToNamedParameters() throws SQLException {
    assertThat(
        convertPositionalParametersToNamedParameters("select * from foo where name=?")
            .sqlWithNamedParameters,
        is(equalTo("select * from foo where name=@p1")));
    assertThat(
        convertPositionalParametersToNamedParameters("?'?test?\"?test?\"?'?")
            .sqlWithNamedParameters,
        is(equalTo("@p1'?test?\"?test?\"?'@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?'?it\\'?s'?").sqlWithNamedParameters,
        is(equalTo("@p1'?it\\'?s'@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?'?it\\\"?s'?").sqlWithNamedParameters,
        is(equalTo("@p1'?it\\\"?s'@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?\"?it\\\"?s\"?").sqlWithNamedParameters,
        is(equalTo("@p1\"?it\\\"?s\"@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?`?it\\`?s`?").sqlWithNamedParameters,
        is(equalTo("@p1`?it\\`?s`@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?'''?it\\'?s'''?").sqlWithNamedParameters,
        is(equalTo("@p1'''?it\\'?s'''@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?\"\"\"?it\\\"?s\"\"\"?")
            .sqlWithNamedParameters,
        is(equalTo("@p1\"\"\"?it\\\"?s\"\"\"@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?```?it\\`?s```?").sqlWithNamedParameters,
        is(equalTo("@p1```?it\\`?s```@p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("?'''?it\\'?s \n ?it\\'?s'''?")
            .sqlWithNamedParameters,
        is(equalTo("@p1'''?it\\'?s \n ?it\\'?s'''@p2")));

    assertUnclosedLiteral("?'?it\\'?s \n ?it\\'?s'?");
    assertUnclosedLiteral("?'?it\\'?s \n ?it\\'?s?");
    assertUnclosedLiteral("?'''?it\\'?s \n ?it\\'?s'?");

    assertThat(
        convertPositionalParametersToNamedParameters(
                "select 1, ?, 'test?test', \"test?test\", foo.* from `foo` where col1=? and col2='test' and col3=? and col4='?' and col5=\"?\" and col6='?''?''?'")
            .sqlWithNamedParameters,
        is(
            equalTo(
                "select 1, @p1, 'test?test', \"test?test\", foo.* from `foo` where col1=@p2 and col2='test' and col3=@p3 and col4='?' and col5=\"?\" and col6='?''?''?'")));

    assertThat(
        convertPositionalParametersToNamedParameters(
                "select * " + "from foo " + "where name=? " + "and col2 like ? " + "and col3 > ?")
            .sqlWithNamedParameters,
        is(
            equalTo(
                "select * "
                    + "from foo "
                    + "where name=@p1 "
                    + "and col2 like @p2 "
                    + "and col3 > @p3")));
    assertThat(
        convertPositionalParametersToNamedParameters(
                "select * " + "from foo " + "where id between ? and ?")
            .sqlWithNamedParameters,
        is(equalTo("select * " + "from foo " + "where id between @p1 and @p2")));
    assertThat(
        convertPositionalParametersToNamedParameters("select * " + "from foo " + "limit ? offset ?")
            .sqlWithNamedParameters,
        is(equalTo("select * " + "from foo " + "limit @p1 offset @p2")));
    assertThat(
        convertPositionalParametersToNamedParameters(
                "select * "
                    + "from foo "
                    + "where col1=? "
                    + "and col2 like ? "
                    + "and col3 > ? "
                    + "and col4 < ? "
                    + "and col5 != ? "
                    + "and col6 not in (?, ?, ?) "
                    + "and col7 in (?, ?, ?) "
                    + "and col8 between ? and ?")
            .sqlWithNamedParameters,
        is(
            equalTo(
                "select * "
                    + "from foo "
                    + "where col1=@p1 "
                    + "and col2 like @p2 "
                    + "and col3 > @p3 "
                    + "and col4 < @p4 "
                    + "and col5 != @p5 "
                    + "and col6 not in (@p6, @p7, @p8) "
                    + "and col7 in (@p9, @p10, @p11) "
                    + "and col8 between @p12 and @p13")));
  }

  private void assertUnclosedLiteral(String sql) {
    boolean exception = false;
    try {
      convertPositionalParametersToNamedParameters(sql);
    } catch (SQLException t) {
      assertThat(t instanceof JdbcSqlException, is(true));
      JdbcSqlException e = (JdbcSqlException) t;
      assertThat(e.getCode(), is(Code.INVALID_ARGUMENT));
      assertThat(
          e.getMessage(),
          startsWith(
              Code.INVALID_ARGUMENT.name()
                  + ": SQL statement contains an unclosed literal: "
                  + sql));
      exception = true;
    }
    assertThat(exception, is(true));
  }
}
