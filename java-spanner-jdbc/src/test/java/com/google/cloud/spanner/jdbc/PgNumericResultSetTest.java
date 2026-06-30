/*
 * Copyright 2021 Google LLC
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

import static com.google.protobuf.NullValue.NULL_VALUE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.common.io.ByteSource;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PgNumericResultSetTest {

  private static final String PROJECT = "my-project";
  private static final String INSTANCE = "my-instance";
  private static final String DATABASE = "my-database";
  private static final String COLUMN_NAME = "PgNumeric";
  private static final ResultSetMetadata SCALAR_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName(COLUMN_NAME)
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.NUMERIC)
                                  .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC))))
          .build();
  private static final ResultSetMetadata ARRAY_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName(COLUMN_NAME)
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.ARRAY)
                                  .setArrayElementType(
                                      com.google.spanner.v1.Type.newBuilder()
                                          .setCode(TypeCode.NUMERIC)
                                          .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)))))
          .build();
  private static final String QUERY = "SELECT " + COLUMN_NAME + " FROM Table WHERE Id = 0";
  private static final int MAX_PG_NUMERIC_SCALE = 131_072;
  private static final int MAX_PG_NUMERIC_PRECISION = 16_383;

  private static MockSpannerServiceImpl mockSpanner;
  private static InetSocketAddress address;
  private static Server server;
  private Connection connection;

  @BeforeClass
  public static void beforeClass() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);

    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() throws Exception {
    final String endpoint = address.getHostString() + ":" + server.getPort();
    final String url =
        String.format(
            "jdbc:cloudspanner://%s/projects/%s/instances/%s/databases/%s?usePlainText=true",
            endpoint, PROJECT, INSTANCE, DATABASE);
    connection = DriverManager.getConnection(url);
  }

  @After
  public void tearDown() throws Exception {
    connection.close();
  }

  @Test
  public void testGetString() throws Exception {
    final String maxScale = String.join("", Collections.nCopies(MAX_PG_NUMERIC_SCALE, "1"));
    final String maxPrecision =
        "0." + String.join("", Collections.nCopies(MAX_PG_NUMERIC_PRECISION, "2"));

    mockScalarResults("0", "1", "1.23", maxScale, maxPrecision, "NaN", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<String> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getString, ResultSet::getString);

      matcher.nextAndAssertEquals("0");
      matcher.nextAndAssertEquals("1");
      matcher.nextAndAssertEquals("1.23");
      matcher.nextAndAssertEquals(maxScale);
      matcher.nextAndAssertEquals(maxPrecision);
      matcher.nextAndAssertEquals("NaN");
      matcher.nextAndAssertEquals(null);
    }
  }

  @Test
  public void testGetNString() throws Exception {
    final String maxScale = String.join("", Collections.nCopies(MAX_PG_NUMERIC_SCALE, "1"));
    final String maxPrecision =
        "0." + String.join("", Collections.nCopies(MAX_PG_NUMERIC_PRECISION, "2"));

    mockScalarResults("0", "1", "1.23", maxScale, maxPrecision, "NaN", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {
      final ResultSetMatcher<String> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getNString, ResultSet::getNString);

      matcher.nextAndAssertEquals("0");
      matcher.nextAndAssertEquals("1");
      matcher.nextAndAssertEquals("1.23");
      matcher.nextAndAssertEquals(maxScale);
      matcher.nextAndAssertEquals(maxPrecision);
      matcher.nextAndAssertEquals("NaN");
      matcher.nextAndAssertEquals(null);
    }
  }

  @Test
  public void testGetBoolean() throws Exception {
    mockScalarResults("0", null, "1", "NaN", "1.00");

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Boolean> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getBoolean, ResultSet::getBoolean);

      // 0 == false
      matcher.nextAndAssertEquals(false);
      // NULL == false
      matcher.nextAndAssertEquals(false);
      // anything else == true
      matcher.nextAndAssertEquals(true); // "1" == true
      matcher.nextAndAssertEquals(true); // "Nan" == true
      matcher.nextAndAssertEquals(true); // "1.00" == true
    }
  }

  @Test
  public void testGetByte() throws Exception {
    final String minValue = Byte.MIN_VALUE + "";
    final String underflow = String.valueOf((int) Byte.MIN_VALUE - 1);
    final String maxValue = Byte.MAX_VALUE + "";
    final String overflow = String.valueOf((int) Short.MAX_VALUE + 1);

    mockScalarResults(minValue, maxValue, "1.23", null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Byte> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getByte, ResultSet::getByte);

      matcher.nextAndAssertEquals(Byte.MIN_VALUE);
      matcher.nextAndAssertEquals(Byte.MAX_VALUE);
      matcher.nextAndAssertEquals((byte) 1);
      // NULL == 0
      matcher.nextAndAssertEquals((byte) 0);
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "NaN is not a valid number");
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for byte: " + underflow);
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for byte: " + overflow);
    }
  }

  @Test
  public void testGetShort() throws Exception {
    final String minValue = Short.MIN_VALUE + "";
    final String underflow = String.valueOf((int) Short.MIN_VALUE - 1);
    final String maxValue = Short.MAX_VALUE + "";
    final String overflow = String.valueOf((int) Short.MAX_VALUE + 1);

    mockScalarResults(minValue, maxValue, "1.23", null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Short> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getShort, ResultSet::getShort);

      matcher.nextAndAssertEquals(Short.MIN_VALUE);
      matcher.nextAndAssertEquals(Short.MAX_VALUE);
      matcher.nextAndAssertEquals((short) 1);
      // NULL == 0
      matcher.nextAndAssertEquals((short) 0);
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "NaN is not a valid number");
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for short: " + underflow);
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for short: " + overflow);
    }
  }

  @Test
  public void testGetInt() throws Exception {
    final String minValue = Integer.MIN_VALUE + "";
    final String underflow = String.valueOf((long) Integer.MIN_VALUE - 1L);
    final String maxValue = Integer.MAX_VALUE + "";
    final String overflow = String.valueOf((long) Integer.MAX_VALUE + 1L);

    mockScalarResults(minValue, maxValue, "1.23", null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Integer> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getInt, ResultSet::getInt);

      matcher.nextAndAssertEquals(Integer.MIN_VALUE);
      matcher.nextAndAssertEquals(Integer.MAX_VALUE);
      matcher.nextAndAssertEquals(1);
      // NULL == 0
      matcher.nextAndAssertEquals(0);
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "NaN is not a valid number");
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for int: " + underflow);
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for int: " + overflow);
    }
  }

  @Test
  public void testGetLong() throws Exception {
    final String minValue = Long.MIN_VALUE + "";
    final String underflow = BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE).toString();
    final String maxValue = Long.MAX_VALUE + "";
    final String overflow = BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE).toString();

    mockScalarResults(minValue, maxValue, "1.23", null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Long> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getLong, ResultSet::getLong);

      matcher.nextAndAssertEquals(Long.MIN_VALUE);
      matcher.nextAndAssertEquals(Long.MAX_VALUE);
      matcher.nextAndAssertEquals(1L);
      // NULL == 0
      matcher.nextAndAssertEquals((long) 0);
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "NaN is not a valid number");
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for long: " + underflow);
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Value out of range for long: " + overflow);
    }
  }

  // TODO(thiagotnunes): Confirm that it is ok to wrap around in under / over flows (like pg)
  @Test
  public void testGetFloat() throws Exception {
    final String minValue = Float.MIN_VALUE + "";
    final String underflow =
        BigDecimal.valueOf(Float.MIN_VALUE).subtract(BigDecimal.ONE).toString();
    final String maxValue = (Float.MAX_VALUE - 1) + "";
    final String overflow = BigDecimal.valueOf(Float.MAX_VALUE).add(BigDecimal.ONE).toString();

    mockScalarResults(
        minValue, maxValue, "1.23", null, "NaN", "-Infinity", "+Infinity", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Float> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getFloat, ResultSet::getFloat);

      matcher.nextAndAssertEquals(Float.MIN_VALUE);
      matcher.nextAndAssertEquals(Float.MAX_VALUE);
      matcher.nextAndAssertEquals(1.23F);
      // NULL == 0
      matcher.nextAndAssertEquals(0F);
      matcher.nextAndAssertEquals(Float.NaN);
      matcher.nextAndAssertEquals(Float.NEGATIVE_INFINITY);
      matcher.nextAndAssertEquals(Float.POSITIVE_INFINITY);
      // Value rolls back to 0 + (underflow value)
      matcher.nextAndAssertEquals(-1F);
      // Value is capped at Float.MAX_VALUE
      matcher.nextAndAssertEquals(Float.MAX_VALUE);
    }
  }

  @Test
  public void testGetDouble() throws Exception {
    final String minValue = Double.MIN_VALUE + "";
    final String underflow =
        BigDecimal.valueOf(Double.MIN_VALUE).subtract(BigDecimal.ONE).toString();
    final String maxValue = (Double.MAX_VALUE - 1) + "";
    final String overflow = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.ONE).toString();

    mockScalarResults(
        minValue, maxValue, "1.23", null, "NaN", "-Infinity", "+Infinity", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Double> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getDouble, ResultSet::getDouble);

      matcher.nextAndAssertEquals(Double.MIN_VALUE);
      matcher.nextAndAssertEquals(Double.MAX_VALUE);
      matcher.nextAndAssertEquals(1.23D);
      // NULL == 0
      matcher.nextAndAssertEquals(0D);
      matcher.nextAndAssertEquals(Double.NaN);
      matcher.nextAndAssertEquals(Double.NEGATIVE_INFINITY);
      matcher.nextAndAssertEquals(Double.POSITIVE_INFINITY);
      // Value rolls back to 0 + (underflow value)
      matcher.nextAndAssertEquals(-1D);
      // Value is capped at Double.MAX_VALUE
      matcher.nextAndAssertEquals(Double.MAX_VALUE);
    }
  }

  @Test
  public void testGetBigDecimal() throws Exception {
    final String maxScale = String.join("", Collections.nCopies(MAX_PG_NUMERIC_SCALE, "1"));
    final String maxPrecision =
        "0." + String.join("", Collections.nCopies(MAX_PG_NUMERIC_PRECISION, "2"));

    mockScalarResults(maxScale, maxPrecision, "0", "1.23", null, "NaN");

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<BigDecimal> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getBigDecimal, ResultSet::getBigDecimal);

      // Default representation is BigDecimal
      matcher.nextAndAssertEquals(new BigDecimal(maxScale));
      matcher.nextAndAssertEquals(new BigDecimal(maxPrecision));
      matcher.nextAndAssertEquals(BigDecimal.ZERO);
      matcher.nextAndAssertEquals(new BigDecimal("1.23"));
      matcher.nextAndAssertEquals(null);
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "NaN is not a valid number");
    }
  }

  @Test
  public void testGetObject() throws Exception {
    final String maxScale = String.join("", Collections.nCopies(MAX_PG_NUMERIC_SCALE, "1"));
    final String maxPrecision =
        "0." + String.join("", Collections.nCopies(MAX_PG_NUMERIC_PRECISION, "2"));

    mockScalarResults(maxScale, maxPrecision, null, "NaN", "-Infinity", "+Infinity");

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Object> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getObject, ResultSet::getObject);

      // Default representation is BigDecimal
      matcher.nextAndAssertEquals(new BigDecimal(maxScale));
      matcher.nextAndAssertEquals(new BigDecimal(maxPrecision));
      matcher.nextAndAssertEquals(null);
      // Nan is represented as Double
      matcher.nextAndAssertEquals(Double.NaN);
      // -Infinity is represented as Double
      matcher.nextAndAssertEquals(Double.NEGATIVE_INFINITY);
      // +Infinity is represented as Double
      matcher.nextAndAssertEquals(Double.POSITIVE_INFINITY);
    }
  }

  @Test
  public void testGetDate() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Date> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getDate, ResultSet::getDate);

      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "Invalid column type to get as date");
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "Invalid column type to get as date");
    }
  }

  @Test
  public void testGetTime() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Time> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getTime, ResultSet::getTime);

      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "Invalid column type to get as time");
      matcher.nextAndAssertError(JdbcSqlExceptionImpl.class, "Invalid column type to get as time");
    }
  }

  @Test
  public void testGetTimestamp() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Timestamp> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getTimestamp, ResultSet::getTimestamp);

      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Invalid column type to get as timestamp");
      matcher.nextAndAssertError(
          JdbcSqlExceptionImpl.class, "Invalid column type to get as timestamp");
    }
  }

  @Test
  public void testGetBytes() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<byte[]> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getBytes, ResultSet::getBytes);

      matcher.nextAndAssertError(
          IllegalStateException.class,
          "expected one of [[PROTO, BYTES]] but was NUMERIC<PG_NUMERIC>");
      matcher.nextAndAssertEquals(null);
    }
  }

  @Test
  public void testGetAsciiStream() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {
      resultSet.next();
      assertEquals("1.23", read(resultSet.getAsciiStream(COLUMN_NAME), StandardCharsets.UTF_8));
      assertEquals("1.23", read(resultSet.getAsciiStream(1), StandardCharsets.UTF_8));

      resultSet.next();
      assertNull(resultSet.getAsciiStream(COLUMN_NAME));
      assertNull(resultSet.getAsciiStream(1));
    }
  }

  @Test
  public void testGetUnicodeStream() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {
      resultSet.next();
      assertEquals(
          "1.23", read(resultSet.getUnicodeStream(COLUMN_NAME), StandardCharsets.UTF_16LE));
      assertEquals("1.23", read(resultSet.getUnicodeStream(1), StandardCharsets.UTF_16LE));

      resultSet.next();
      assertNull(resultSet.getUnicodeStream(COLUMN_NAME));
      assertNull(resultSet.getUnicodeStream(1));
    }
  }

  @Test
  public void testGetCharacterStream() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {
      resultSet.next();
      assertEquals("1.23", read(resultSet.getCharacterStream(COLUMN_NAME)));
      assertEquals("1.23", read(resultSet.getCharacterStream(1)));

      resultSet.next();
      assertNull(resultSet.getCharacterStream(COLUMN_NAME));
      assertNull(resultSet.getCharacterStream(1));
    }
  }

  // TODO(thiagotnunes): confirm that it is ok this is implemented for pg numeric (in pg driver it
  // throws unimplemented error)
  @Test
  public void testGetNCharacterStream() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {
      resultSet.next();
      assertEquals("1.23", read(resultSet.getNCharacterStream(COLUMN_NAME)));
      assertEquals("1.23", read(resultSet.getNCharacterStream(1)));

      resultSet.next();
      assertNull(resultSet.getNCharacterStream(COLUMN_NAME));
      assertNull(resultSet.getNCharacterStream(1));
    }
  }

  // TODO(thiagotnunes): Confirm that it is ok to not throw an error for clob > Long.MAX or clob <
  // Long.MIN
  @Test
  public void testGetNClob() throws Exception {
    final String minValue = Long.MIN_VALUE + "";
    final String underflow = BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE).toString();
    final String maxValue = Long.MAX_VALUE + "";
    final String overflow = BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE).toString();

    mockScalarResults(minValue, maxValue, null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<NClob> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getNClob, ResultSet::getNClob);

      matcher.nextAndAssertEquals(new JdbcClob(minValue));
      matcher.nextAndAssertEquals(new JdbcClob(maxValue));
      matcher.nextAndAssertEquals(null);
      matcher.nextAndAssertEquals(new JdbcClob("NaN"));
      matcher.nextAndAssertEquals(new JdbcClob(underflow));
      matcher.nextAndAssertEquals(new JdbcClob(overflow));
    }
  }

  @Test
  public void testGetBlob() throws Exception {
    mockScalarResults("1.23", null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Blob> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getBlob, ResultSet::getBlob);

      matcher.nextAndAssertError(
          IllegalStateException.class,
          "expected one of [[PROTO, BYTES]] but was NUMERIC<PG_NUMERIC>");
      matcher.nextAndAssertEquals(null);
    }
  }

  // TODO(thiagotnunes): Confirm that it is ok to not throw an error for clob > Long.MAX or clob <
  // Long.MIN
  @Test
  public void testGetClob() throws Exception {
    final String minValue = Long.MIN_VALUE + "";
    final String underflow = BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE).toString();
    final String maxValue = Long.MAX_VALUE + "";
    final String overflow = BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE).toString();

    mockScalarResults(minValue, maxValue, null, "NaN", underflow, overflow);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      final ResultSetMatcher<Clob> matcher =
          resultSetMatcherFrom(resultSet, ResultSet::getClob, ResultSet::getClob);

      matcher.nextAndAssertEquals(new JdbcClob(minValue));
      matcher.nextAndAssertEquals(new JdbcClob(maxValue));
      matcher.nextAndAssertEquals(null);
      matcher.nextAndAssertEquals(new JdbcClob("NaN"));
      matcher.nextAndAssertEquals(new JdbcClob(underflow));
      matcher.nextAndAssertEquals(new JdbcClob(overflow));
    }
  }

  @Test
  public void testGetArray() throws Exception {
    final String maxScale = String.join("", Collections.nCopies(MAX_PG_NUMERIC_SCALE, "1"));
    final String maxPrecision =
        "0." + String.join("", Collections.nCopies(MAX_PG_NUMERIC_PRECISION, "2"));

    mockArrayResults(
        Arrays.asList(maxScale, maxPrecision),
        Arrays.asList(null, "0"),
        Collections.singletonList("NaN"),
        null);

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY)) {

      resultSet.next();
      final BigDecimal[] expectedFirstRow = {
        new BigDecimal(maxScale), new BigDecimal(maxPrecision)
      };
      assertArrayEquals(
          expectedFirstRow, (BigDecimal[]) resultSet.getArray(COLUMN_NAME).getArray());
      assertArrayEquals(expectedFirstRow, (BigDecimal[]) resultSet.getArray(1).getArray());

      resultSet.next();
      final BigDecimal[] expectedSecondRow = {null, BigDecimal.ZERO};
      assertArrayEquals(
          expectedSecondRow, (BigDecimal[]) resultSet.getArray(COLUMN_NAME).getArray());
      assertArrayEquals(expectedSecondRow, (BigDecimal[]) resultSet.getArray(1).getArray());

      resultSet.next();
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getArray(COLUMN_NAME).getArray());
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getArray(1).getArray());

      resultSet.next();
      assertNull(resultSet.getArray(COLUMN_NAME));
      assertNull(resultSet.getArray(1));
    }
  }

  private String read(InputStream inputStream, Charset charset) throws IOException {
    try {
      return new ByteSource() {
        @Override
        public InputStream openStream() {
          return inputStream;
        }
      }.asCharSource(charset).read();
    } finally {
      inputStream.close();
    }
  }

  private String read(Reader reader) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(reader)) {
      return bufferedReader.readLine();
    }
  }

  private String read(byte[] bytes, Charset charset) {
    return new String(bytes, charset);
  }

  private void mockScalarResults(String... rows) {
    final ListValue.Builder builder = ListValue.newBuilder();
    for (String row : rows) {
      if (row == null) {
        builder.addValues(com.google.protobuf.Value.newBuilder().setNullValue(NULL_VALUE));
      } else {
        builder.addValues(com.google.protobuf.Value.newBuilder().setStringValue(row));
      }
    }

    mockSpanner.putStatementResult(
        StatementResult.query(
            com.google.cloud.spanner.Statement.of(QUERY),
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(SCALAR_METADATA)
                .addRows(builder)
                .build()));
  }

  private void mockArrayResults(List<String>... arrays) {
    final ListValue.Builder builder = ListValue.newBuilder();

    for (List<String> array : arrays) {
      if (array == null) {
        builder.addValues(com.google.protobuf.Value.newBuilder().setNullValue(NULL_VALUE));
      } else {
        final ListValue.Builder arrayBuilder = ListValue.newBuilder();
        for (String row : array) {
          if (row == null) {
            arrayBuilder.addValues(com.google.protobuf.Value.newBuilder().setNullValue(NULL_VALUE));
          } else {
            arrayBuilder.addValues(com.google.protobuf.Value.newBuilder().setStringValue(row));
          }
        }
        builder.addValues(com.google.protobuf.Value.newBuilder().setListValue(arrayBuilder));
      }
    }

    mockSpanner.putStatementResult(
        StatementResult.query(
            com.google.cloud.spanner.Statement.of(QUERY),
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(ARRAY_METADATA)
                .addRows(builder)
                .build()));
  }

  private <T> ResultSetMatcher<T> resultSetMatcherFrom(
      ResultSet resultSet,
      CheckedBiFunction<ResultSet, String, T> columnByNameGetter,
      CheckedBiFunction<ResultSet, Integer, T> columnByIndexGetter) {
    return new ResultSetMatcher<T>() {
      @Override
      public void nextAndAssertEquals(T expected) throws Exception {
        resultSet.next();
        assertEquals(expected, columnByNameGetter.apply(resultSet, COLUMN_NAME));
        assertEquals(expected, columnByIndexGetter.apply(resultSet, 1));
      }

      @Override
      public <E extends Throwable> void nextAndAssertError(
          Class<E> exceptionClass, String expectedMessage) throws Exception {
        resultSet.next();
        try {
          columnByNameGetter.apply(resultSet, COLUMN_NAME);
          fail("Expected exception " + exceptionClass + " to be thrown");
        } catch (Exception e) {
          assertEquals(exceptionClass, e.getClass());
          assertTrue(
              "Expected \""
                  + e.getMessage()
                  + "\" exception message to contain \""
                  + expectedMessage
                  + "\"",
              e.getMessage().contains(expectedMessage));
        }
        try {
          columnByIndexGetter.apply(resultSet, 1);
          fail("Expected exception " + exceptionClass + " to be thrown");
        } catch (Exception e) {
          assertEquals(exceptionClass, e.getClass());
          assertTrue(
              "Expected \""
                  + e.getMessage()
                  + "\" exception message to contain \""
                  + expectedMessage
                  + "\"",
              e.getMessage().contains(expectedMessage));
        }
      }
    };
  }

  private interface ResultSetMatcher<T> {

    void nextAndAssertEquals(T expected) throws Exception;

    <E extends Throwable> void nextAndAssertError(Class<E> exceptionClass, String expectedMessage)
        throws Exception;
  }

  private interface CheckedBiFunction<A, B, C> {

    C apply(A a, B b) throws Exception;
  }
}
