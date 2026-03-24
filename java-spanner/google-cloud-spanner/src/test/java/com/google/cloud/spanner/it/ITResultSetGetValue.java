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

package com.google.cloud.spanner.it;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.primitives.Doubles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITResultSetGetValue {

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    if (!EmulatorSpannerHelper.isUsingEmulator()) {
      params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    }
    return params;
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  // For floats / doubles comparison
  private static final double DELTA = 1e-15;
  private static final String TABLE_NAME = "TestTable";
  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;
  private DatabaseClient databaseClient;

  @BeforeClass
  public static void beforeClass()
      throws ExecutionException, InterruptedException, TimeoutException {
    Database googleStandardSqlDatabase =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE "
                    + TABLE_NAME
                    + "("
                    + "Id INT64 NOT NULL,"
                    + "bool BOOL,"
                    + "int64 INT64,"
                    + "float64 FLOAT64,"
                    + "numeric NUMERIC,"
                    + "string STRING(MAX),"
                    + "bytes BYTES(MAX),"
                    + "timestamp TIMESTAMP,"
                    + "date DATE,"
                    + "json JSON,"
                    + "boolArray ARRAY<BOOL>,"
                    + "int64Array ARRAY<INT64>,"
                    + "float64Array ARRAY<FLOAT64>,"
                    + "numericArray ARRAY<NUMERIC>,"
                    + "stringArray ARRAY<STRING(MAX)>,"
                    + "bytesArray ARRAY<BYTES(MAX)>,"
                    + "timestampArray ARRAY<TIMESTAMP>,"
                    + "dateArray ARRAY<DATE>,"
                    + "jsonArray ARRAY<JSON>"
                    + ") PRIMARY KEY (Id)");
    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSqlDatabase);
    if (!EmulatorSpannerHelper.isUsingEmulator()) {
      Database postgreSQLDatabase =
          env.getTestHelper()
              .createTestDatabase(
                  Dialect.POSTGRESQL,
                  Collections.singletonList(
                      "CREATE TABLE "
                          + TABLE_NAME
                          + "("
                          + "id BIGINT PRIMARY KEY,"
                          + "bool BOOL,"
                          + "int64 BIGINT,"
                          + "float64 DOUBLE PRECISION,"
                          + "numeric NUMERIC,"
                          + "string VARCHAR,"
                          + "bytes BYTEA,"
                          + "timestamp TIMESTAMPTZ,"
                          + "date DATE,"
                          + "boolArray BOOL[],"
                          + "int64Array BIGINT[],"
                          + "float64Array DOUBLE PRECISION[],"
                          + "numericArray NUMERIC[],"
                          + "stringArray VARCHAR[],"
                          + "bytesArray BYTEA[],"
                          + "dateArray DATE[],"
                          + "timestampArray TIMESTAMPTZ[]"
                          + ")"));
      postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
    }
  }

  @Before
  public void before() {
    databaseClient =
        dialect.dialect == Dialect.GOOGLE_STANDARD_SQL ? googleStandardSQLClient : postgreSQLClient;
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @Test
  public void testReadNonNullValuesGoogleStandardSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    databaseClient.write(
        Collections.singletonList(
            Mutation.newInsertBuilder(TABLE_NAME)
                .set("Id")
                .to(1L)
                .set("bool")
                .to(true)
                .set("int64")
                .to(10L)
                .set("float64")
                .to(20D)
                .set("numeric")
                .to(new BigDecimal("30"))
                .set("string")
                .to("stringValue")
                .set("bytes")
                .to(ByteArray.copyFrom("bytesValue"))
                .set("timestamp")
                .to(Timestamp.ofTimeSecondsAndNanos(1, 0))
                .set("date")
                .to(Date.fromYearMonthDay(2021, 1, 2))
                .set("json")
                .to(Value.json("{\"key\":\"value\"}"))
                .set("boolArray")
                .toBoolArray(new boolean[] {false, true})
                .set("int64Array")
                .toInt64Array(new long[] {100L, 200L})
                .set("float64Array")
                .toFloat64Array(new double[] {1000D, 2000D})
                .set("numericArray")
                .toNumericArray(Arrays.asList(new BigDecimal("10000"), new BigDecimal("20000")))
                .set("stringArray")
                .toStringArray(Arrays.asList("string1", "string2"))
                .set("bytesArray")
                .toBytesArray(
                    Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2")))
                .set("timestampArray")
                .toTimestampArray(
                    Arrays.asList(
                        Timestamp.ofTimeSecondsAndNanos(10, 0),
                        Timestamp.ofTimeSecondsAndNanos(20, 0)))
                .set("dateArray")
                .toDateArray(
                    Arrays.asList(
                        Date.fromYearMonthDay(2021, 2, 3), Date.fromYearMonthDay(2021, 3, 4)))
                .set("jsonArray")
                .toJsonArray(Arrays.asList("{\"key1\":\"value1\"}", "{\"key2\":\"value2\"}"))
                .build()));
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE Id = 1"))) {
      resultSet.next();

      assertEquals(Value.int64(1L), resultSet.getValue("Id"));
      assertEquals(Value.bool(true), resultSet.getValue("bool"));
      assertEquals(Value.int64(10L), resultSet.getValue("int64"));
      assertEquals(20D, resultSet.getValue("float64").getFloat64(), 1e-15);
      assertEquals(Value.numeric(new BigDecimal("30")), resultSet.getValue("numeric"));
      assertEquals(Value.string("stringValue"), resultSet.getValue("string"));
      assertEquals(Value.bytes(ByteArray.copyFrom("bytesValue")), resultSet.getValue("bytes"));
      assertEquals(
          Value.timestamp(Timestamp.ofTimeSecondsAndNanos(1, 0)), resultSet.getValue("timestamp"));
      assertEquals(Value.date(Date.fromYearMonthDay(2021, 1, 2)), resultSet.getValue("date"));
      assertEquals(Value.json("{\"key\":\"value\"}"), resultSet.getValue("json"));
      assertEquals(Value.boolArray(new boolean[] {false, true}), resultSet.getValue("boolArray"));
      assertEquals(Value.int64Array(new long[] {100L, 200L}), resultSet.getValue("int64Array"));
      assertArrayEquals(
          new double[] {1000D, 2000D},
          Doubles.toArray(resultSet.getValue("float64Array").getFloat64Array()),
          1e-15);
      assertEquals(
          Value.numericArray(Arrays.asList(new BigDecimal("10000"), new BigDecimal("20000"))),
          resultSet.getValue("numericArray"));
      assertEquals(
          Value.stringArray(Arrays.asList("string1", "string2")),
          resultSet.getValue("stringArray"));
      assertEquals(
          Value.bytesArray(
              Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2"))),
          resultSet.getValue("bytesArray"));
      assertEquals(
          Value.timestampArray(
              Arrays.asList(
                  Timestamp.ofTimeSecondsAndNanos(10, 0), Timestamp.ofTimeSecondsAndNanos(20, 0))),
          resultSet.getValue("timestampArray"));
      assertEquals(
          Value.dateArray(
              Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), Date.fromYearMonthDay(2021, 3, 4))),
          resultSet.getValue("dateArray"));
      assertEquals(
          Value.jsonArray(Arrays.asList("{\"key1\":\"value1\"}", "{\"key2\":\"value2\"}")),
          resultSet.getValue("jsonArray"));
    }
  }

  @Test
  public void testReadNonNullValuesPostgreSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    databaseClient.write(
        Collections.singletonList(
            Mutation.newInsertBuilder(TABLE_NAME)
                .set("id")
                .to(1L)
                .set("bool")
                .to(true)
                .set("int64")
                .to(10L)
                .set("float64")
                .to(20D)
                .set("numeric")
                .to(new BigDecimal("30"))
                .set("string")
                .to("stringValue")
                .set("bytes")
                .to(ByteArray.copyFrom("bytesValue"))
                .set("date")
                .to(Date.fromYearMonthDay(2021, 1, 2))
                .set("timestamp")
                .to(Timestamp.ofTimeSecondsAndNanos(1, 0))
                .set("boolArray")
                .toBoolArray(new boolean[] {false, true})
                .set("int64Array")
                .toInt64Array(new long[] {100L, 200L})
                .set("float64Array")
                .toFloat64Array(new double[] {1000D, 2000D})
                .set("numericArray")
                .toNumericArray(Arrays.asList(new BigDecimal("10000"), new BigDecimal("20000")))
                .set("stringArray")
                .toStringArray(Arrays.asList("string1", "string2"))
                .set("bytesArray")
                .toBytesArray(
                    Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2")))
                .set("timestampArray")
                .toTimestampArray(
                    Arrays.asList(
                        Timestamp.ofTimeSecondsAndNanos(10, 0),
                        Timestamp.ofTimeSecondsAndNanos(20, 0)))
                .set("dateArray")
                .toDateArray(
                    Arrays.asList(
                        Date.fromYearMonthDay(2021, 2, 3), Date.fromYearMonthDay(2021, 3, 4)))
                .build()));

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE id = 1"))) {
      resultSet.next();
      assertEquals(Value.int64(1L), resultSet.getValue("id"));
      assertEquals(Value.bool(true), resultSet.getValue("bool"));
      assertEquals(Value.int64(10L), resultSet.getValue("int64"));
      assertEquals(20D, resultSet.getValue("float64").getFloat64(), 1e-15);
      assertEquals(Value.pgNumeric("30"), resultSet.getValue("numeric"));
      assertEquals(Value.string("stringValue"), resultSet.getValue("string"));
      assertEquals(Value.bytes(ByteArray.copyFrom("bytesValue")), resultSet.getValue("bytes"));
      assertEquals(
          Value.timestamp(Timestamp.ofTimeSecondsAndNanos(1, 0)), resultSet.getValue("timestamp"));
      assertEquals(Value.date(Date.fromYearMonthDay(2021, 1, 2)), resultSet.getValue("date"));
      assertEquals(Value.boolArray(new boolean[] {false, true}), resultSet.getValue("boolarray"));
      assertEquals(Value.int64Array(new long[] {100L, 200L}), resultSet.getValue("int64array"));
      assertArrayEquals(
          new double[] {1000D, 2000D},
          Doubles.toArray(resultSet.getValue("float64array").getFloat64Array()),
          1e-15);
      assertEquals(
          Value.pgNumericArray(Arrays.asList("10000", "20000")),
          resultSet.getValue("numericarray"));
      assertEquals(
          Value.stringArray(Arrays.asList("string1", "string2")),
          resultSet.getValue("stringarray"));
      assertEquals(
          Value.bytesArray(
              Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2"))),
          resultSet.getValue("bytesarray"));
      assertEquals(
          Value.timestampArray(
              Arrays.asList(
                  Timestamp.ofTimeSecondsAndNanos(10, 0), Timestamp.ofTimeSecondsAndNanos(20, 0))),
          resultSet.getValue("timestamparray"));
      assertEquals(
          Value.dateArray(
              Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), Date.fromYearMonthDay(2021, 3, 4))),
          resultSet.getValue("datearray"));
    }
  }

  @Test
  public void testReadNullValuesGoogleStandardSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    databaseClient.write(
        Collections.singletonList(Mutation.newInsertBuilder(TABLE_NAME).set("Id").to(2L).build()));
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE Id = 2"))) {
      resultSet.next();

      assertEquals(Value.int64(2L), resultSet.getValue("Id"));
      assertTrue(resultSet.getValue("bool").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("bool").getBool());
      assertTrue(resultSet.getValue("int64").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("int64").getInt64());
      assertTrue(resultSet.getValue("float64").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("float64").getFloat64());
      assertTrue(resultSet.getValue("numeric").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("numeric").getNumeric());
      assertTrue(resultSet.getValue("string").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("string").getString());
      assertTrue(resultSet.getValue("bytes").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("bytes").getBytes());
      assertTrue(resultSet.getValue("timestamp").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("timestamp").getTimestamp());
      assertTrue(resultSet.getValue("date").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("date").getDate());
      assertTrue(resultSet.getValue("json").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("json").getJson());
      assertTrue(resultSet.getValue("boolArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("boolArray").getBoolArray());
      assertTrue(resultSet.getValue("int64Array").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("int64Array").getInt64Array());
      assertTrue(resultSet.getValue("float64Array").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("float64Array").getFloat64Array());
      assertTrue(resultSet.getValue("numericArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("numericArray").getNumericArray());
      assertTrue(resultSet.getValue("stringArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("stringArray").getStringArray());
      assertTrue(resultSet.getValue("bytesArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("bytesArray").getBytesArray());
      assertTrue(resultSet.getValue("timestampArray").isNull());
      assertThrows(
          IllegalStateException.class,
          () -> resultSet.getValue("timestampArray").getTimestampArray());
      assertTrue(resultSet.getValue("dateArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("dateArray").getDateArray());
      assertTrue(resultSet.getValue("jsonArray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("jsonArray").getJsonArray());
    }
  }

  @Test
  public void testReadNullValuesPostgreSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    databaseClient.write(
        Collections.singletonList(Mutation.newInsertBuilder(TABLE_NAME).set("id").to(2L).build()));
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE id = 2"))) {
      resultSet.next();

      assertEquals(Value.int64(2L), resultSet.getValue("id"));
      assertTrue(resultSet.getValue("bool").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("bool").getBool());
      assertTrue(resultSet.getValue("int64").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("int64").getInt64());
      assertTrue(resultSet.getValue("float64").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("float64").getFloat64());
      assertTrue(resultSet.getValue("numeric").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("numeric").getNumeric());
      assertTrue(resultSet.getValue("string").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("string").getString());
      assertTrue(resultSet.getValue("bytes").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("bytes").getBytes());
      assertTrue(resultSet.getValue("timestamp").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("timestamp").getTimestamp());
      assertTrue(resultSet.getValue("date").isNull());
      assertThrows(IllegalStateException.class, () -> resultSet.getValue("date").getDate());
      assertTrue(resultSet.getValue("boolarray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("boolarray").getBoolArray());
      assertTrue(resultSet.getValue("int64array").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("int64array").getInt64Array());
      assertTrue(resultSet.getValue("float64array").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("float64array").getFloat64Array());
      assertTrue(resultSet.getValue("numericarray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("numericarray").getNumericArray());
      assertTrue(resultSet.getValue("stringarray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("stringarray").getStringArray());
      assertTrue(resultSet.getValue("bytesarray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("bytesarray").getBytesArray());
      assertTrue(resultSet.getValue("timestamparray").isNull());
      assertThrows(
          IllegalStateException.class,
          () -> resultSet.getValue("timestamparray").getTimestampArray());
      assertTrue(resultSet.getValue("datearray").isNull());
      assertThrows(
          IllegalStateException.class, () -> resultSet.getValue("datearray").getDateArray());
    }
  }

  @Test
  public void testReadNullValuesInArraysGoogleStandardSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    databaseClient.write(
        Collections.singletonList(
            Mutation.newInsertBuilder(TABLE_NAME)
                .set("Id")
                .to(3L)
                .set("boolArray")
                .toBoolArray(Arrays.asList(true, null))
                .set("int64Array")
                .toInt64Array(Arrays.asList(null, 2L))
                .set("float64Array")
                .toFloat64Array(Arrays.asList(null, 10D))
                .set("numericArray")
                .toNumericArray(Arrays.asList(new BigDecimal("10000"), null))
                .set("stringArray")
                .toStringArray(Arrays.asList(null, "string2"))
                .set("bytesArray")
                .toBytesArray(Arrays.asList(ByteArray.copyFrom("bytes1"), null))
                .set("timestampArray")
                .toTimestampArray(Arrays.asList(null, Timestamp.ofTimeSecondsAndNanos(20, 0)))
                .set("dateArray")
                .toDateArray(Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), null))
                .set("jsonArray")
                .toJsonArray(Arrays.asList("{\"key1\":\"value1\"}", null))
                .build()));

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE Id = 3"))) {
      resultSet.next();

      assertEquals(Value.int64(3L), resultSet.getValue("Id"));
      assertEquals(Value.boolArray(Arrays.asList(true, null)), resultSet.getValue("boolArray"));
      assertEquals(Value.int64Array(Arrays.asList(null, 2L)), resultSet.getValue("int64Array"));
      assertNull(resultSet.getValue("float64Array").getFloat64Array().get(0));
      assertEquals(10D, resultSet.getValue("float64Array").getFloat64Array().get(1), DELTA);
      assertEquals(
          Value.numericArray(Arrays.asList(new BigDecimal("10000"), null)),
          resultSet.getValue("numericArray"));
      assertEquals(
          Value.stringArray(Arrays.asList(null, "string2")), resultSet.getValue("stringArray"));
      assertEquals(
          Value.bytesArray(Arrays.asList(ByteArray.copyFrom("bytes1"), null)),
          resultSet.getValue("bytesArray"));
      assertEquals(
          Value.timestampArray(Arrays.asList(null, Timestamp.ofTimeSecondsAndNanos(20, 0))),
          resultSet.getValue("timestampArray"));
      assertEquals(
          Value.dateArray(Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), null)),
          resultSet.getValue("dateArray"));
      assertEquals(
          Value.jsonArray(Arrays.asList("{\"key1\":\"value1\"}", null)),
          resultSet.getValue("jsonArray"));
    }
  }

  @Test
  public void testReadNullValuesInArraysPostgreSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    databaseClient.write(
        Collections.singletonList(
            Mutation.newInsertBuilder(TABLE_NAME)
                .set("Id")
                .to(3L)
                .set("boolArray")
                .toBoolArray(Arrays.asList(true, null))
                .set("int64Array")
                .toInt64Array(Arrays.asList(null, 2L))
                .set("float64Array")
                .toFloat64Array(Arrays.asList(null, 10D))
                .set("numericArray")
                .toNumericArray(Arrays.asList(new BigDecimal("10000"), null))
                .set("stringArray")
                .toStringArray(Arrays.asList(null, "string2"))
                .set("bytesArray")
                .toBytesArray(Arrays.asList(ByteArray.copyFrom("bytes1"), null))
                .set("timestampArray")
                .toTimestampArray(Arrays.asList(null, Timestamp.ofTimeSecondsAndNanos(20, 0)))
                .set("dateArray")
                .toDateArray(Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), null))
                .build()));

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME + " WHERE Id = 3"))) {
      resultSet.next();

      assertEquals(Value.int64(3L), resultSet.getValue("id"));
      assertEquals(Value.boolArray(Arrays.asList(true, null)), resultSet.getValue("boolarray"));
      assertEquals(Value.int64Array(Arrays.asList(null, 2L)), resultSet.getValue("int64array"));
      assertNull(resultSet.getValue("float64array").getFloat64Array().get(0));
      assertEquals(10D, resultSet.getValue("float64array").getFloat64Array().get(1), DELTA);
      assertEquals(
          Value.pgNumericArray(Arrays.asList("10000", null)), resultSet.getValue("numericarray"));
      assertEquals(
          Value.stringArray(Arrays.asList(null, "string2")), resultSet.getValue("stringarray"));
      assertEquals(
          Value.bytesArray(Arrays.asList(ByteArray.copyFrom("bytes1"), null)),
          resultSet.getValue("bytesarray"));
      assertEquals(
          Value.timestampArray(Arrays.asList(null, Timestamp.ofTimeSecondsAndNanos(20, 0))),
          resultSet.getValue("timestamparray"));
      assertEquals(
          Value.dateArray(Arrays.asList(Date.fromYearMonthDay(2021, 2, 3), null)),
          resultSet.getValue("datearray"));
    }
  }

  @Test
  public void testReadNonFloat64LiteralsGoogleStandardSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT TRUE AS bool,1 AS int64,CAST('100' AS NUMERIC) AS numeric,'stringValue'"
                        + " AS string,CAST('bytesValue' AS BYTES) AS"
                        + " bytes,CAST('1970-01-01T00:00:01Z' AS TIMESTAMP) AS"
                        + " timestamp,CAST('2021-02-03' AS DATE) AS date,[false, true] AS"
                        + " boolArray,[1, 2] AS int64Array,[CAST('100' AS NUMERIC), CAST('200' AS"
                        + " NUMERIC)] AS numericArray,['string1', 'string2'] AS"
                        + " stringArray,[CAST('bytes1' AS BYTES), CAST('bytes2' AS BYTES)] AS"
                        + " bytesArray,[CAST('1970-01-01T00:00:01.000000002Z' AS TIMESTAMP),"
                        + " CAST('1970-01-01T00:00:02.000000003Z' AS TIMESTAMP)] AS"
                        + " timestampArray,[CAST('2020-01-02' AS DATE), CAST('2021-02-03' AS DATE)]"
                        + " AS dateArray,ARRAY(SELECT STRUCT(  TRUE AS structBool,  1 AS"
                        + " structInt64,  CAST('100' AS NUMERIC) AS structNumeric,  'stringValue'"
                        + " AS structString,  CAST('bytesValue' AS BYTES) AS structBytes, "
                        + " CAST('1970-01-01T00:00:01Z' AS TIMESTAMP) AS structTimestamp, "
                        + " CAST('2020-01-02' AS DATE) AS structDate,  [false, true] AS"
                        + " structBoolArray,  [1, 2] AS structInt64Array,  [CAST('100' AS NUMERIC),"
                        + " CAST('200' AS NUMERIC)] AS structNumericArray,  ['string1', 'string2']"
                        + " AS structStringArray,  [CAST('bytes1' AS BYTES), CAST('bytes2' AS"
                        + " BYTES)] AS structBytesArray,  [CAST('1970-01-01T00:00:01.000000002Z' AS"
                        + " TIMESTAMP), CAST('1970-01-01T00:00:02.000000003Z' AS TIMESTAMP)] AS"
                        + " structTimestampArray,  [CAST('2020-01-02' AS DATE), CAST('2021-02-03'"
                        + " AS DATE)] AS structDateArray)) AS structArray"))) {
      resultSet.next();

      assertEquals(Value.bool(true), resultSet.getValue("bool"));
      assertEquals(Value.int64(1L), resultSet.getValue("int64"));
      assertEquals(Value.numeric(new BigDecimal("100")), resultSet.getValue("numeric"));
      assertEquals(Value.string("stringValue"), resultSet.getValue("string"));
      assertEquals(Value.bytes(ByteArray.copyFrom("bytesValue")), resultSet.getValue("bytes"));
      assertEquals(
          Value.timestamp(Timestamp.ofTimeSecondsAndNanos(1, 0)), resultSet.getValue("timestamp"));
      assertEquals(Value.date(Date.fromYearMonthDay(2021, 2, 3)), resultSet.getValue("date"));
      assertEquals(Value.boolArray(new boolean[] {false, true}), resultSet.getValue("boolArray"));
      assertEquals(Value.int64Array(new long[] {1L, 2L}), resultSet.getValue("int64Array"));
      assertEquals(
          Value.numericArray(Arrays.asList(new BigDecimal("100"), new BigDecimal("200"))),
          resultSet.getValue("numericArray"));
      assertEquals(
          Value.stringArray(Arrays.asList("string1", "string2")),
          resultSet.getValue("stringArray"));
      assertEquals(
          Value.bytesArray(
              Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2"))),
          resultSet.getValue("bytesArray"));
      assertEquals(
          Value.timestampArray(
              Arrays.asList(
                  Timestamp.ofTimeSecondsAndNanos(1, 2), Timestamp.ofTimeSecondsAndNanos(2, 3))),
          resultSet.getValue("timestampArray"));
      assertEquals(
          Value.dateArray(
              Arrays.asList(Date.fromYearMonthDay(2020, 1, 2), Date.fromYearMonthDay(2021, 2, 3))),
          resultSet.getValue("dateArray"));
      assertEquals(
          Value.structArray(
              Type.struct(
                  StructField.of("structBool", Type.bool()),
                  StructField.of("structInt64", Type.int64()),
                  StructField.of("structNumeric", Type.numeric()),
                  StructField.of("structString", Type.string()),
                  StructField.of("structBytes", Type.bytes()),
                  StructField.of("structTimestamp", Type.timestamp()),
                  StructField.of("structDate", Type.date()),
                  StructField.of("structBoolArray", Type.array(Type.bool())),
                  StructField.of("structInt64Array", Type.array(Type.int64())),
                  StructField.of("structNumericArray", Type.array(Type.numeric())),
                  StructField.of("structStringArray", Type.array(Type.string())),
                  StructField.of("structBytesArray", Type.array(Type.bytes())),
                  StructField.of("structTimestampArray", Type.array(Type.timestamp())),
                  StructField.of("structDateArray", Type.array(Type.date()))),
              Collections.singletonList(
                  Struct.newBuilder()
                      .set("structBool")
                      .to(Value.bool(true))
                      .set("structInt64")
                      .to(Value.int64(1L))
                      .set("structNumeric")
                      .to(new BigDecimal("100"))
                      .set("structString")
                      .to("stringValue")
                      .set("structBytes")
                      .to(ByteArray.copyFrom("bytesValue"))
                      .set("structTimestamp")
                      .to(Timestamp.ofTimeSecondsAndNanos(1, 0))
                      .set("structDate")
                      .to(Date.fromYearMonthDay(2020, 1, 2))
                      .set("structBoolArray")
                      .toBoolArray(new boolean[] {false, true})
                      .set("structInt64Array")
                      .toInt64Array(new long[] {1L, 2L})
                      .set("structNumericArray")
                      .toNumericArray(Arrays.asList(new BigDecimal("100"), new BigDecimal("200")))
                      .set("structStringArray")
                      .toStringArray(Arrays.asList("string1", "string2"))
                      .set("structBytesArray")
                      .toBytesArray(
                          Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2")))
                      .set("structTimestampArray")
                      .toTimestampArray(
                          Arrays.asList(
                              Timestamp.ofTimeSecondsAndNanos(1, 2),
                              Timestamp.ofTimeSecondsAndNanos(2, 3)))
                      .set("structDateArray")
                      .toDateArray(
                          Arrays.asList(
                              Date.fromYearMonthDay(2020, 1, 2), Date.fromYearMonthDay(2021, 2, 3)))
                      .build())),
          resultSet.getValue("structArray"));
    }
  }

  @Test
  public void testReadNonFloat64LiteralsPostgreSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT TRUE AS bool,1 AS int64,CAST('100' AS numeric) AS numeric,'stringValue'"
                        + " AS string,CAST('bytesValue' AS BYTEA) AS"
                        + " bytes,CAST('1970-01-01T00:00:01 UTC' AS TIMESTAMPTZ) AS"
                        + " timestamp,CAST('2021-02-03' AS DATE) AS date,ARRAY[false, true] AS"
                        + " boolArray,ARRAY[1, 2] AS int64Array,ARRAY[CAST('100' AS NUMERIC),"
                        + " CAST('200' AS NUMERIC)] AS numericArray,ARRAY['string1', 'string2'] AS"
                        + " stringArray,ARRAY[CAST('bytes1' AS BYTEA), CAST('bytes2' AS BYTEA)] AS"
                        + " bytesArray,ARRAY[CAST('1970-01-01T00:00:01 UTC' AS TIMESTAMPTZ),"
                        + " CAST('1970-01-01T00:00:02 UTC' AS TIMESTAMPTZ)] AS"
                        + " timestampArray,ARRAY[CAST('2020-01-02' AS DATE), CAST('2021-02-03' AS"
                        + " DATE)] AS dateArray"))) {
      resultSet.next();

      assertEquals(Value.bool(true), resultSet.getValue("bool"));
      assertEquals(Value.int64(1L), resultSet.getValue("int64"));
      assertEquals(Value.pgNumeric("100"), resultSet.getValue("numeric"));
      assertEquals(Value.string("stringValue"), resultSet.getValue("string"));
      assertEquals(Value.bytes(ByteArray.copyFrom("bytesValue")), resultSet.getValue("bytes"));
      assertEquals(
          Value.timestamp(Timestamp.ofTimeSecondsAndNanos(1, 0)), resultSet.getValue("timestamp"));
      assertEquals(Value.date(Date.fromYearMonthDay(2021, 2, 3)), resultSet.getValue("date"));
      assertEquals(Value.boolArray(new boolean[] {false, true}), resultSet.getValue("boolarray"));
      assertEquals(Value.int64Array(new long[] {1L, 2L}), resultSet.getValue("int64array"));
      assertEquals(
          Value.pgNumericArray(Arrays.asList("100", "200")), resultSet.getValue("numericarray"));
      assertEquals(
          Value.stringArray(Arrays.asList("string1", "string2")),
          resultSet.getValue("stringarray"));
      assertEquals(
          Value.bytesArray(
              Arrays.asList(ByteArray.copyFrom("bytes1"), ByteArray.copyFrom("bytes2"))),
          resultSet.getValue("bytesarray"));
      assertEquals(
          Value.timestampArray(
              Arrays.asList(
                  Timestamp.ofTimeSecondsAndNanos(1, 0), Timestamp.ofTimeSecondsAndNanos(2, 0))),
          resultSet.getValue("timestamparray"));
      assertEquals(
          Value.dateArray(
              Arrays.asList(Date.fromYearMonthDay(2020, 1, 2), Date.fromYearMonthDay(2021, 2, 3))),
          resultSet.getValue("datearray"));
    }
  }

  @Test
  public void testReadFloat64LiteralsGoogleStandardSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT "
                        + "10.0 AS float64,"
                        + "[20.0, 30.0] AS float64Array,"
                        + "ARRAY(SELECT STRUCT("
                        + "  40.0 AS structFloat64,"
                        + "  [50.0, 60.0] AS structFloat64Array"
                        + ")) AS structArray"))) {
      resultSet.next();

      final Struct struct = resultSet.getValue("structArray").getStructArray().get(0);

      assertEquals(10D, resultSet.getValue("float64").getFloat64(), DELTA);
      assertArrayEquals(
          new double[] {20D, 30D},
          Doubles.toArray(resultSet.getValue("float64Array").getFloat64Array()),
          DELTA);
      assertEquals(40D, struct.getDouble("structFloat64"), DELTA);
      assertArrayEquals(
          new double[] {50D, 60D}, struct.getDoubleArray("structFloat64Array"), DELTA);
    }
  }

  @Test
  public void testReadFloat64LiteralsPostgreSQL() {
    Assume.assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of("SELECT 10.0 AS float64, " + "ARRAY[20.0, 30.0] AS float64Array"))) {
      resultSet.next();
      assertEquals(10D, resultSet.getValue("float64").getFloat64(), DELTA);
      assertArrayEquals(
          new double[] {20D, 30D},
          Doubles.toArray(resultSet.getValue("float64array").getFloat64Array()),
          DELTA);
    }
  }
}
