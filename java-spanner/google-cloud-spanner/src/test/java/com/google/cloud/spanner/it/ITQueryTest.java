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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.spanner.v1.ResultSetStats;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/** Integration tests for query execution. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITQueryTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;
  private String selectValueQuery;

  @BeforeClass
  public static void setUpDatabase() {
    // Empty database.
    Database googleStandardSQLDatabase = env.getTestHelper().createTestDatabase();
    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);
    if (!isUsingEmulator()) {
      Database postgreSQLDatabase =
          env.getTestHelper().createTestDatabase(Dialect.POSTGRESQL, Collections.emptyList());
      postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
    }
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @Before
  public void initSelectValueQuery() {
    selectValueQuery = "SELECT @p1";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      selectValueQuery = "SELECT $1";
    }
  }

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    // "PG dialect tests are not supported by the emulator"
    if (!isUsingEmulator()) {
      params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    }
    return params;
  }

  @Parameterized.Parameter(0)
  public DialectTestParameter dialect;

  private DatabaseClient getClient(Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL) {
      return postgreSQLClient;
    }
    return googleStandardSQLClient;
  }

  @Test
  public void simple() {
    Struct row = execute(Statement.of("SELECT 1"), Type.int64());
    assertThat(row.getLong(0)).isEqualTo(1);
  }

  @Test
  public void badQuery() {
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () -> execute(Statement.of("SELECT Apples AND Oranges"), Type.int64()));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertTrue(
          exception.getMessage(),
          exception.getMessage().contains("column \"apples\" does not exist"));
      // See https://www.postgresql.org/docs/current/errcodes-appendix.html
      // '42703' == undefined_column
      assumeFalse(
          "Skipping PGErrorCode check on experimental host due to b/473270453",
          isExperimentalHost());
      assertEquals("42703", exception.getPostgreSQLErrorCode());
    } else {
      assertTrue(
          exception.getMessage(), exception.getMessage().contains("Unrecognized name: Apples"));
    }
  }

  @Test
  public void arrayOfStruct() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Type structType =
        Type.struct(StructField.of("C1", Type.string()), StructField.of("C2", Type.int64()));
    Struct row =
        execute(
            Statement.of(
                "SELECT ARRAY(SELECT AS STRUCT C1, C2 "
                    + "FROM (SELECT 'a' AS C1, 1 AS C2 UNION ALL SELECT 'b' AS C1, 2 AS C2) "
                    + "ORDER BY C1 ASC)"),
            Type.array(structType));
    assertThat(row.isNull(0)).isFalse();
    List<Struct> value = row.getStructList(0);
    assertThat(value.size()).isEqualTo(2);
    assertThat(value.get(0).getType()).isEqualTo(structType);
    assertThat(value.get(0).getString(0)).isEqualTo("a");
    assertThat(value.get(0).getLong(1)).isEqualTo(1);
    assertThat(value.get(1).getType()).isEqualTo(structType);
    assertThat(value.get(1).getString(0)).isEqualTo("b");
    assertThat(value.get(1).getLong(1)).isEqualTo(2);

    // Also confirm that an STRUCT<ARRAY<STRUCT>> implements equality correctly with respect to
    // a manually constructed Struct.
    Struct expectedRow =
        Struct.newBuilder()
            .set("")
            .toStructArray(
                Type.struct(
                    asList(
                        StructField.of("C1", Type.string()), StructField.of("C2", Type.int64()))),
                asList(
                    Struct.newBuilder().set("C1").to("a").set("C2").to(1).build(),
                    Struct.newBuilder().set("C1").to("b").set("C2").to(2).build()))
            .build();
    assertThat(row).isEqualTo(expectedRow);
  }

  @Test
  public void arrayOfStructEmpty() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Type structType =
        Type.struct(StructField.of("", Type.string()), StructField.of("", Type.int64()));
    Struct row =
        execute(
            Statement.of("SELECT ARRAY(SELECT AS STRUCT * FROM (SELECT 'a', 1) WHERE 0 = 1)"),
            Type.array(structType));
    assertThat(row.isNull(0)).isFalse();
    List<Struct> value = row.getStructList(0);
    assertThat(value.size()).isEqualTo(0);
  }

  @Ignore // Not yet supported by the backend.
  @Test
  public void arrayOfStructNull() {
    Type structType =
        Type.struct(StructField.of("", Type.string()), StructField.of("", Type.int64()));
    Struct row =
        execute(
            Statement.of("SELECT CAST (NULL AS ARRAY<STRUCT<string,int64>>)"),
            Type.array(structType));
    assertThat(row.isNull(0)).isTrue();
  }

  @Ignore // Not yet supported by the backend.
  @Test
  public void arrayOfStructNullElement() {
    Type structType =
        Type.struct(StructField.of("", Type.string()), StructField.of("", Type.int64()));
    Struct row =
        execute(
            Statement.of(
                "SELECT ARRAY(SELECT AS STRUCT 'a', 1"
                    + " UNION ALL SELECT CAST (NULL AS STRUCT<string,int64>))"),
            Type.array(structType));
    assertThat(row.isNull(0)).isFalse();
    List<Struct> value = row.getStructList(0);
    assertThat(value.size()).isEqualTo(2);
    assertThat(value.get(0).getType()).isEqualTo(structType);
    assertThat(value.get(0).getString(0)).isEqualTo("a");
    assertThat(value.get(0).getLong(1)).isEqualTo(1);
    assertThat(value.get(1)).isNull();
  }

  @Test
  public void bindBool() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to(true).build(), Type.bool());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBoolean(0)).isEqualTo(true);
  }

  @Test
  public void bindBoolNull() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((Boolean) null), Type.bool());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindInt64() {
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(1234), Type.int64());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLong(0)).isEqualTo(1234);
  }

  @Test
  public void bindInt64Null() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((Long) null), Type.int64());
    assertThat(row.isNull(0)).isTrue();
  }

  // TODO: Remove once FLOAT32 is supported in production.
  private static boolean isUsingCloudDevel() {
    String jobType = System.getenv("JOB_TYPE");

    // Assumes that the jobType contains the string "cloud-devel" to signal that
    // the environment is cloud-devel.
    return !isNullOrEmpty(jobType) && jobType.contains("cloud-devel");
  }

  @Test
  public void bindFloat32() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to(2.0f), Type.float32());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getFloat(0)).isWithin(0.0f).of(2.0f);
  }

  @Test
  public void bindFloat32Null() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((Float) null), Type.float32());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindPgOid() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      Struct row =
          execute(
              Statement.newBuilder(selectValueQuery).bind("p1").to(Value.pgOid(1234)),
              Type.pgOid());
      assertThat(row.isNull(0)).isFalse();
      assertThat(row.getLong(0)).isEqualTo(1234);
    }
  }

  @Test
  public void bindPgOidNull() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      Struct row =
          execute(
              Statement.newBuilder(selectValueQuery).bind("p1").to(Value.pgOid(null)),
              Type.pgOid());
      assertThat(row.isNull(0)).isTrue();
    }
  }

  @Test
  public void bindFloat64() {
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(2.0), Type.float64());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isWithin(0.0).of(2.0);
  }

  @Test
  public void bindFloat64Null() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to((Double) null), Type.float64());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindString() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to("abc"), Type.string());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("abc");
  }

  @Test
  public void bindStringNull() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((String) null), Type.string());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindJson() {
    assumeFalse("JSON are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .to(Value.json("{\"rating\":9,\"open\":true}")),
            Type.json());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getJson(0)).isEqualTo("{\"open\":true,\"rating\":9}");
  }

  @Test
  public void bindJsonEmpty() {
    assumeFalse("JSON are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to(Value.json("{}")), Type.json());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getJson(0)).isEqualTo("{}");
  }

  @Test
  public void bindJsonNull() {
    assumeFalse("JSON is not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to(Value.json(null)), Type.json());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindBytes() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to(ByteArray.copyFrom("xyz")),
            Type.bytes());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("xyz"));
  }

  @Test
  public void bindBytesNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to((ByteArray) null), Type.bytes());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindTimestamp() {
    Timestamp t = Timestamp.parseTimestamp("2016-09-18T00:00:00Z");
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(t), Type.timestamp());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestamp(0)).isEqualTo(t);
  }

  @Test
  public void bindTimestampNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to((Timestamp) null),
            Type.timestamp());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindDate() {
    Date d = Date.parseDate("2016-09-18");
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(d), Type.date());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDate(0)).isEqualTo(d);
  }

  @Test
  public void bindDateNull() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((Date) null), Type.date());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindUuid() {
    UUID uuid = UUID.randomUUID();
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(uuid), Type.uuid());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getUuid(0)).isEqualTo(uuid);
  }

  @Test
  public void bindUuidNull() {
    Struct row =
        execute(Statement.newBuilder(selectValueQuery).bind("p1").to((UUID) null), Type.uuid());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindInterval() {
    Interval d = Interval.parseFromString("P1Y2M3DT4H5M6.789123S");
    Struct row = execute(Statement.newBuilder(selectValueQuery).bind("p1").to(d), Type.interval());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getInterval(0)).isEqualTo(d);
  }

  @Test
  public void bindIntervalNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").to((Interval) null), Type.interval());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindNumeric() {
    BigDecimal b = new BigDecimal("1.1");
    Statement.Builder statement = Statement.newBuilder(selectValueQuery);
    Type expectedType = Type.numeric();
    Object expectedValue = b;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      expectedType = Type.pgNumeric();
      expectedValue = Value.pgNumeric(b.toString());
      statement.bind("p1").to(Value.pgNumeric(b.toString()));
    } else {
      statement.bind("p1").to(b);
    }
    Struct row = execute(statement, expectedType);
    assertThat(row.isNull(0)).isFalse();
    Object got;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      got = row.getValue(0);
    } else {
      got = row.getBigDecimal(0);
    }
    assertThat(got).isEqualTo(expectedValue);
  }

  @Test
  public void bindNumericNull() {
    Statement.Builder statement = Statement.newBuilder(selectValueQuery);
    Type expectedType = Type.numeric();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      expectedType = Type.pgNumeric();
      statement.bind("p1").to(Value.pgNumeric(null));
    } else {
      statement.bind("p1").to((BigDecimal) null);
    }
    Struct row = execute(statement, expectedType);
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindNumeric_doesNotPreservePrecision() {
    BigDecimal b = new BigDecimal("1.10");
    Statement.Builder statement = Statement.newBuilder(selectValueQuery);
    Type expectedType = Type.numeric();
    // Cloud Spanner does not store precision, and will therefore return 1.10 as 1.1.
    Object expectedValue = b.stripTrailingZeros();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      expectedType = Type.pgNumeric();
      // Cloud Spanner with PG dialect store precision, and will therefore return 1.10.
      expectedValue = Value.pgNumeric(b.toString());
      statement.bind("p1").to(Value.pgNumeric(b.toString()));
    } else {
      statement.bind("p1").to(b);
    }
    Struct row = execute(statement, expectedType);
    assertThat(row.isNull(0)).isFalse();
    Object got;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      got = row.getValue(0);
    } else {
      got = row.getBigDecimal(0);
    }
    assertThat(got).isNotEqualTo(b);
    assertThat(got).isEqualTo(expectedValue);
  }

  @Test
  public void bindBoolArray() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toBoolArray(asList(true, null, false)),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly(true, null, false).inOrder();
  }

  @Test
  public void bindBoolArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toBoolArray(Collections.emptyList()),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly();
  }

  @Test
  public void bindBoolArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toBoolArray((boolean[]) null),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindInt64Array() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toInt64Array(asList(null, 1L, 2L)),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly(null, 1L, 2L).inOrder();
  }

  @Test
  public void bindInt64ArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toInt64Array(Collections.emptyList()),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly();
  }

  @Test
  public void bindInt64ArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toInt64Array((long[]) null),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindFloat32Array() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toFloat32Array(
                    asList(
                        null,
                        1.0f,
                        2.0f,
                        Float.NEGATIVE_INFINITY,
                        Float.POSITIVE_INFINITY,
                        Float.NaN)),
            Type.array(Type.float32()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getFloatList(0))
        .containsExactly(
            null, 1.0f, 2.0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN)
        .inOrder();
  }

  @Test
  public void bindFloat32ArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toFloat32Array(Collections.emptyList()),
            Type.array(Type.float32()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getFloatList(0)).containsExactly();
  }

  @Test
  public void bindFloat32ArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toFloat32Array((float[]) null),
            Type.array(Type.float32()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindFloat64Array() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toFloat64Array(
                    asList(
                        null,
                        1.0,
                        2.0,
                        Double.NEGATIVE_INFINITY,
                        Double.POSITIVE_INFINITY,
                        Double.NaN)),
            Type.array(Type.float64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleList(0))
        .containsExactly(
            null, 1.0, 2.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN)
        .inOrder();
  }

  @Test
  public void bindFloat64ArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toFloat64Array(Collections.emptyList()),
            Type.array(Type.float64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleList(0)).containsExactly();
  }

  @Test
  public void bindFloat64ArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toFloat64Array((double[]) null),
            Type.array(Type.float64()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindStringArray() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toStringArray(asList("a", "b", null)),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly("a", "b", null).inOrder();
  }

  @Test
  public void bindStringArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toStringArray(Collections.emptyList()),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly();
  }

  @Test
  public void bindStringArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toStringArray(null),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindJsonArray() {
    assumeFalse(
        "array JSON binding is not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toJsonArray(asList("{}", "[]", "{\"rating\":9,\"open\":true}", null)),
            Type.array(Type.json()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getJsonList(0))
        .containsExactly("{}", "[]", "{\"open\":true,\"rating\":9}", null)
        .inOrder();
  }

  @Test
  public void bindJsonArrayEmpty() {
    assumeFalse("JSON is not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toJsonArray(Collections.emptyList()),
            Type.array(Type.json()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getJsonList(0)).isEqualTo(Collections.emptyList());
  }

  @Test
  public void bindJsonArrayNull() {
    assumeFalse("JSON is not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toJsonArray(null),
            Type.array(Type.json()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindBytesArray() {
    ByteArray e1 = ByteArray.copyFrom("x");
    ByteArray e2 = ByteArray.copyFrom("y");
    ByteArray e3 = null;
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toBytesArray(asList(e1, e2, e3)),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).containsExactly(e1, e2, e3).inOrder();
  }

  @Test
  public void bindBytesArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toBytesArray(Collections.emptyList()),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).isEmpty();
  }

  @Test
  public void bindBytesArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toBytesArray(null),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindTimestampArray() {
    Timestamp t1 = Timestamp.parseTimestamp("2016-09-18T00:00:00Z");
    Timestamp t2 = Timestamp.parseTimestamp("2016-09-19T00:00:00Z");

    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toTimestampArray(asList(t1, t2, null)),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly(t1, t2, null).inOrder();
  }

  @Test
  public void bindTimestampArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toTimestampArray(Collections.emptyList()),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly();
  }

  @Test
  public void bindTimestampArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toTimestampArray(null),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindDateArray() {
    Date d1 = Date.parseDate("2016-09-18");
    Date d2 = Date.parseDate("2016-09-19");

    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toDateArray(asList(d1, d2, null)),
            Type.array(Type.date()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly(d1, d2, null).inOrder();
  }

  @Test
  public void bindDateArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toDateArray(Collections.emptyList()),
            Type.array(Type.date()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly();
  }

  @Test
  public void bindDateArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toDateArray(null),
            Type.array(Type.date()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindUuidArray() {
    UUID u1 = UUID.randomUUID();
    UUID u2 = UUID.randomUUID();

    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toUuidArray(asList(u1, u2, null)),
            Type.array(Type.uuid()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getUuidList(0)).containsExactly(u1, u2, null).inOrder();
  }

  @Test
  public void bindUuidArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toUuidArray(Collections.emptyList()),
            Type.array(Type.uuid()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getUuidList(0)).containsExactly();
  }

  @Test
  public void bindUuidArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toUuidArray(null),
            Type.array(Type.uuid()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindIntervalArray() {
    Interval d1 = Interval.parseFromString("P-1Y-2M-3DT4H5M6.789123S");
    Interval d2 = Interval.parseFromString("P1Y2M3DT-4H-5M-6.789123S");
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toIntervalArray(asList(d1, d2, null)),
            Type.array(Type.interval()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getIntervalList(0)).containsExactly(d1, d2, null).inOrder();
  }

  @Test
  public void bindIntervalArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toIntervalArray(Collections.emptyList()),
            Type.array(Type.interval()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getIntervalList(0)).containsExactly();
  }

  @Test
  public void bindIntervalArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toIntervalArray(null),
            Type.array(Type.interval()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindNumericArrayGoogleStandardSQL() {
    assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    BigDecimal b1 = new BigDecimal("3.14");
    BigDecimal b2 = new BigDecimal("6.626");

    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toNumericArray(asList(b1, b2, null)),
            Type.array(Type.numeric()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBigDecimalList(0)).containsExactly(b1, b2, null).inOrder();
  }

  @Test
  public void bindNumericArrayPostgreSQL() {
    assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toPgNumericArray(asList("3.14", "6.626", null)),
            Type.array(Type.pgNumeric()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly("3.14", "6.626", null).inOrder();
  }

  @Test
  public void bindNumericArrayEmptyGoogleStandardSQL() {
    assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toNumericArray(Collections.emptyList()),
            Type.array(Type.numeric()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBigDecimalList(0)).containsExactly();
  }

  @Test
  public void bindNumericArrayEmptyPostgreSQL() {
    assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery)
                .bind("p1")
                .toPgNumericArray(Collections.emptyList()),
            Type.array(Type.pgNumeric()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly();
  }

  @Test
  public void bindNumericArrayNullGoogleStandardSQL() {
    assumeTrue(dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toNumericArray(null),
            Type.array(Type.numeric()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindNumericArrayNullPostgreSQL() {
    assumeTrue(dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toPgNumericArray(null),
            Type.array(Type.pgNumeric()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindNumericArray_doesNotPreservePrecision() {
    assumeFalse(
        "array numeric binding is not supported on POSTGRESQL",
        dialect.dialect == Dialect.POSTGRESQL);
    assumeFalse("Emulator does not yet support NUMERIC", EmulatorSpannerHelper.isUsingEmulator());
    BigDecimal b1 = new BigDecimal("3.14");
    BigDecimal b2 = new BigDecimal("6.626070");

    Struct row =
        execute(
            Statement.newBuilder(selectValueQuery).bind("p1").toNumericArray(asList(b1, b2, null)),
            Type.array(Type.numeric()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBigDecimalList(0))
        .containsExactly(b1.stripTrailingZeros(), b2.stripTrailingZeros(), null)
        .inOrder();
  }

  @Test
  public void unsupportedSelectStructValue() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    assumeFalse("The emulator accepts this query", isUsingEmulator());
    Struct p = structValue();
    try {
      execute(Statement.newBuilder(selectValueQuery).bind("p1").to(p).build(), p.getType());
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.UNIMPLEMENTED);
      assertThat(ex.getMessage())
          .contains(
              "Unsupported query shape: A struct value cannot be returned as a column value.");
    }
  }

  @Test
  public void unsupportedSelectArrayStructValue() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    assumeFalse(
        "Emulator evaluates this expression differently than Cloud Spanner", isUsingEmulator());

    Struct p = structValue();
    try {
      execute(
          Statement.newBuilder("SELECT @p")
              .bind("p")
              .toStructArray(p.getType(), Collections.singletonList(p))
              .build(),
          p.getType());
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.UNIMPLEMENTED);
      assertThat(ex.getMessage())
          .contains(
              "Unsupported query shape: "
                  + "This query can return a null-valued array of struct, "
                  + "which is not supported by Spanner.");
    }
  }

  @Test
  public void invalidAmbiguousFieldAccess() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p = Struct.newBuilder().set("f1").to(20).set("f1").to("abc").build();
    try {
      execute(Statement.newBuilder("SELECT @p.f1").bind("p").to(p).build(), Type.int64());
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(ex.getMessage()).contains("Struct field name f1 is ambiguous");
    }
  }

  private Struct structValue() {
    // TODO: Add test for interval once interval is supported in emulator.
    return Struct.newBuilder()
        .set("f_int")
        .to(10)
        .set("f_bool")
        .to(false)
        .set("f_double")
        .to(3.4)
        .set("f_timestamp")
        .to(Timestamp.ofTimeMicroseconds(20))
        .set("f_date")
        .to(Date.fromYearMonthDay(1, 3, 1))
        .set("f_string")
        .to("hello")
        .set("f_bytes")
        .to(ByteArray.copyFrom("bytes"))
        .build();
  }

  @Test
  public void bindStruct() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    // TODO: Add test for interval once interval is supported in emulator.
    Struct p = structValue();
    String query =
        "SELECT "
            + "@p.f_int,"
            + "@p.f_bool,"
            + "@p.f_double,"
            + "@p.f_timestamp,"
            + "@p.f_date,"
            + "@p.f_string,"
            + "@p.f_bytes";

    Struct row =
        executeWithRowResultType(Statement.newBuilder(query).bind("p").to(p).build(), p.getType());
    assertThat(row).isEqualTo(p);
  }

  @Test
  public void bindArrayOfStruct() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct arrayElement = structValue();
    List<Struct> p = asList(arrayElement, null);

    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p)")
                .bind("p")
                .toStructArray(arrayElement.getType(), p)
                .build(),
            arrayElement.getType());

    assertThat(rows).hasSize(p.size());
    assertThat(rows.get(0)).isEqualTo(p.get(0));

    // Field accesses on a null struct element (because of SELECT *) return null values.
    Struct structElementFromNull = rows.get(1);
    // assertThat(structElementFromNull.isNull()).isFalse();
    for (int i = 0; i < arrayElement.getType().getStructFields().size(); ++i) {
      assertThat(structElementFromNull.isNull(i)).isTrue();
    }
  }

  @Test
  public void bindStructNull() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder("SELECT @p IS NULL")
                .bind("p")
                .to(
                    Type.struct(
                        asList(
                            Type.StructField.of("f1", Type.string()),
                            Type.StructField.of("f2", Type.float64()))),
                    null)
                .build(),
            Type.bool());
    assertThat(row.getBoolean(0)).isTrue();
  }

  @Test
  public void bindArrayOfStructNull() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Type elementType =
        Type.struct(
            asList(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.float64())));

    Struct row =
        execute(
            Statement.newBuilder("SELECT @p IS NULL")
                .bind("p")
                .toStructArray(elementType, null)
                .build(),
            Type.bool());
    assertThat(row.getBoolean(0)).isTrue();
  }

  @Test
  public void bindEmptyStruct() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p = Struct.newBuilder().build();
    Struct row =
        execute(Statement.newBuilder("SELECT @p IS NULL").bind("p").to(p).build(), Type.bool());
    assertThat(row.getBoolean(0)).isFalse();
  }

  @Test
  public void bindStructWithUnnamedFields() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p = Struct.newBuilder().add(Value.int64(1337)).add(Value.int64(7331)).build();
    Struct row =
        executeWithRowResultType(
            Statement.newBuilder("SELECT * FROM UNNEST([@p])").bind("p").to(p).build(),
            p.getType());
    assertThat(row.getLong(0)).isEqualTo(1337);
    assertThat(row.getLong(1)).isEqualTo(7331);
  }

  @Test
  public void bindStructWithDuplicateFieldNames() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p =
        Struct.newBuilder()
            .set("f1")
            .to(Value.int64(1337))
            .set("f1")
            .to(Value.string("1337"))
            .build();
    Struct row =
        executeWithRowResultType(
            Statement.newBuilder("SELECT * FROM UNNEST([@p])").bind("p").to(p).build(),
            p.getType());
    assertThat(row.getLong(0)).isEqualTo(1337);
    assertThat(row.getString(1)).isEqualTo("1337");
  }

  @Test
  public void bindEmptyArrayOfStruct() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Type elementType = Type.struct(Collections.singletonList(StructField.of("f1", Type.date())));
    List<Struct> p = Collections.emptyList();
    assertThat(p).isEmpty();

    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p)")
                .bind("p")
                .toStructArray(elementType, p)
                .build(),
            elementType);
    assertThat(rows).isEmpty();
  }

  @Test
  public void bindStructWithNullStructField() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Type emptyStructType = Type.struct(new ArrayList<>());
    Struct p = Struct.newBuilder().set("f1").to(emptyStructType, null).build();

    Struct row =
        execute(Statement.newBuilder("SELECT @p.f1 IS NULL").bind("p").to(p).build(), Type.bool());
    assertThat(row.getBoolean(0)).isTrue();
  }

  @Test
  public void bindStructWithBoolArrayFieldThatContainsNulls() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p =
        Struct.newBuilder()
            .set("boolArray")
            .to(Value.boolArray(Arrays.asList(true, false, null)))
            .build();
    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p.boolArray) ORDER BY 1")
                .bind("p")
                .to(p)
                .build(),
            Type.struct(StructField.of("", Type.bool())));
    assertTrue(rows.get(0).isNull(0));
    assertFalse(rows.get(1).getBoolean(0));
    assertTrue(rows.get(2).getBoolean(0));
  }

  @Test
  public void bindStructWithInt64ArrayFieldThatContainsNulls() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p =
        Struct.newBuilder()
            .set("int64Array")
            .to(Value.int64Array(Arrays.asList(1L, 100L, null)))
            .build();
    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p.int64Array) ORDER BY 1")
                .bind("p")
                .to(p)
                .build(),
            Type.struct(StructField.of("", Type.int64())));
    assertTrue(rows.get(0).isNull(0));
    assertEquals(1L, rows.get(1).getLong(0));
    assertEquals(100L, rows.get(2).getLong(0));
  }

  @Test
  public void bindStructWithFloat64ArrayFieldThatContainsNulls() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct p =
        Struct.newBuilder()
            .set("float64Array")
            .to(Value.float64Array(Arrays.asList(1d, 3.14d, null)))
            .build();
    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p.float64Array) ORDER BY 1")
                .bind("p")
                .to(p)
                .build(),
            Type.struct(StructField.of("", Type.float64())));
    assertTrue(rows.get(0).isNull(0));
    assertEquals(1d, rows.get(1).getDouble(0), 0d);
    assertEquals(3.14d, rows.get(2).getDouble(0), 0d);
  }

  @Test
  public void bindStructWithStructField() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct nestedStruct = Struct.newBuilder().set("ff1").to("abc").build();
    Struct p = Struct.newBuilder().set("f1").to(nestedStruct).build();

    Struct row =
        executeWithRowResultType(
            Statement.newBuilder("SELECT @p.f1.ff1").bind("p").to(p).build(),
            nestedStruct.getType());
    assertThat(row.getString(0)).isEqualTo("abc");
  }

  @Test
  public void bindStructWithArrayOfStructField() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct arrayElement1 = Struct.newBuilder().set("ff1").to("abc").build();
    Struct arrayElement2 = Struct.newBuilder().set("ff1").to("def").build();
    Struct p =
        Struct.newBuilder()
            .set("f1")
            .toStructArray(arrayElement1.getType(), asList(arrayElement1, arrayElement2))
            .build();

    List<Struct> rows =
        resultRows(
            Statement.newBuilder("SELECT * FROM UNNEST(@p.f1)").bind("p").to(p).build(),
            arrayElement1.getType());
    assertThat(rows.get(0).getString(0)).isEqualTo("abc");
    assertThat(rows.get(1).getString(0)).isEqualTo("def");
  }

  @Test
  public void unboundParameter() {
    String query = "SELECT @v";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      query = "SELECT $1";
    }
    ResultSet resultSet =
        Statement.of(query)
            .executeQuery(getClient(dialect.dialect).singleUse(TimestampBound.strong()));
    try {
      resultSet.next();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void positiveInfinity() {
    assumeFalse(
        "function ieee_divide not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(1, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isPositiveInfinity();
  }

  @Test
  public void negativeInfinity() {
    assumeFalse(
        "function ieee_divide not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(-1, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isNegativeInfinity();
  }

  @Test
  public void notANumber() {
    assumeFalse(
        "function ieee_divide not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(0, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isNaN();
  }

  @Test
  public void nonNumberArray() {
    assumeFalse(
        "function ieee_divide not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    Struct row =
        execute(
            Statement.newBuilder(
                "SELECT [IEEE_DIVIDE(1, 0), IEEE_DIVIDE(-1, 0), IEEE_DIVIDE(0, 0)]"),
            Type.array(Type.float64()));
    assertThat(row.getDoubleList(0)).hasSize(3);
    assertThat(row.getDoubleList(0).get(0)).isPositiveInfinity();
    assertThat(row.getDoubleList(0).get(1)).isNegativeInfinity();
    assertThat(row.getDoubleList(0).get(2)).isNaN();
  }

  @Test
  public void largeErrorText() {
    assumeFalse(
        "regexp_contains is not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    String veryLongString = Joiner.on("").join(Iterables.limit(Iterables.cycle("x"), 8000));
    Statement statement =
        Statement.newBuilder("SELECT REGEXP_CONTAINS(@value, @regexp)")
            .bind("value")
            .to("")
            .bind("regexp")
            .to("(" + veryLongString)
            .build();
    ResultSet resultSet =
        statement.executeQuery(getClient(dialect.dialect).singleUse(TimestampBound.strong()));
    try {
      resultSet.next();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      assertThat(ex.getMessage()).contains("Cannot parse regular expression");
    }
  }

  @Test
  public void queryRealTable() {
    Database populatedDb;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      populatedDb =
          env.getTestHelper()
              .createTestDatabase(
                  dialect.dialect,
                  Arrays.asList("CREATE TABLE T ( K VARCHAR PRIMARY KEY, V VARCHAR )"));
    } else {
      populatedDb =
          env.getTestHelper()
              .createTestDatabase(
                  "CREATE TABLE T ( K STRING(MAX) NOT NULL, V STRING(MAX) ) PRIMARY KEY (K)");
    }
    DatabaseClient client = env.getTestHelper().getDatabaseClient(populatedDb);
    client.writeAtLeastOnce(
        asList(
            Mutation.newInsertBuilder("T").set("K").to("k1").set("V").to("v1").build(),
            Mutation.newInsertBuilder("T").set("K").to("k2").set("V").to("v2").build(),
            Mutation.newInsertBuilder("T").set("K").to("k3").set("V").to("v3").build(),
            Mutation.newInsertBuilder("T").set("K").to("k4").set("V").to("v4").build()));

    String query = "SELECT k, v FROM T WHERE k >= @p1 AND k < @p2 ORDER BY K ASC";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      query = "SELECT k, v FROM T WHERE k >= $1 AND k < $2 ORDER BY K ASC";
    }
    Statement statement =
        Statement.newBuilder(query).bind("p1").to("k13").bind("p2").to("k32").build();
    ResultSet resultSet = statement.executeQuery(client.singleUse(TimestampBound.strong()));
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType())
        .isEqualTo(
            Type.struct(StructField.of("k", Type.string()), StructField.of("v", Type.string())));
    assertThat(resultSet.getString(0)).isEqualTo("k2");
    assertThat(resultSet.getString(1)).isEqualTo("v2");
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getString("k")).isEqualTo("k3");
    assertThat(resultSet.getString("v")).isEqualTo("v3");
    assertThat(resultSet.next()).isFalse();
  }

  @Test
  public void analyzePlan() {
    assumeFalse("Emulator does not support Analyze Plan", isUsingEmulator());

    Statement statement = Statement.of("SELECT 1 AS data UNION ALL SELECT 2");
    ResultSet resultSet =
        statement.analyzeQuery(
            getClient(dialect.dialect).singleUse(TimestampBound.strong()), QueryAnalyzeMode.PLAN);
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(Type.struct(StructField.of("data", Type.int64())));
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(receivedStats).isNotNull();
    assertThat(receivedStats.hasQueryPlan()).isTrue();
    assertThat(receivedStats.hasQueryStats()).isFalse();
  }

  @Test
  public void analyzeProfile() {
    assumeFalse("Emulator does not support Analyze Profile", isUsingEmulator());

    String query = "SELECT 1 AS data UNION ALL SELECT 2 AS data ORDER BY data";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      // "Statements with set operations and ORDER BY are not supported"
      query = "SELECT 1 AS data UNION ALL SELECT 2 AS data";
    }
    Statement statement = Statement.of(query);
    ResultSet resultSet =
        statement.analyzeQuery(
            getClient(dialect.dialect).singleUse(TimestampBound.strong()),
            QueryAnalyzeMode.PROFILE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType()).isEqualTo(Type.struct(StructField.of("data", Type.int64())));
    assertThat(resultSet.getLong(0)).isEqualTo(1);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(2);
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(receivedStats).isNotNull();
    assertThat(receivedStats.hasQueryPlan()).isTrue();
    assertThat(receivedStats.hasQueryStats()).isTrue();
  }

  @Test
  public void testSelectArrayOfStructs() {
    assumeFalse("structs are not supported on POSTGRESQL", dialect.dialect == Dialect.POSTGRESQL);
    try (ResultSet resultSet =
        getClient(dialect.dialect)
            .singleUse()
            .executeQuery(
                Statement.of(
                    "WITH points AS\n"
                        + "  (SELECT [1, 5] as point\n"
                        + "   UNION ALL SELECT [2, 8] as point\n"
                        + "   UNION ALL SELECT [3, 7] as point\n"
                        + "   UNION ALL SELECT [4, 1] as point\n"
                        + "   UNION ALL SELECT [5, 7] as point)\n"
                        + "SELECT ARRAY(\n"
                        + "  SELECT STRUCT(point)\n"
                        + "  FROM points)\n"
                        + "  AS coordinates"))) {
      assertTrue(resultSet.next());
      assertEquals(resultSet.getColumnCount(), 1);
      assertThat(resultSet.getStructList(0))
          .containsExactly(
              Struct.newBuilder().set("point").to(Value.int64Array(new long[] {1L, 5L})).build(),
              Struct.newBuilder().set("point").to(Value.int64Array(new long[] {2L, 8L})).build(),
              Struct.newBuilder().set("point").to(Value.int64Array(new long[] {3L, 7L})).build(),
              Struct.newBuilder().set("point").to(Value.int64Array(new long[] {4L, 1L})).build(),
              Struct.newBuilder().set("point").to(Value.int64Array(new long[] {5L, 7L})).build());
      assertFalse(resultSet.next());
    }
  }

  private List<Struct> resultRows(Statement statement, Type expectedRowType) {
    ArrayList<Struct> results = new ArrayList<>();
    ResultSet resultSet =
        statement.executeQuery(getClient(dialect.dialect).singleUse(TimestampBound.strong()));
    while (resultSet.next()) {
      Struct row = resultSet.getCurrentRowAsStruct();
      results.add(row);
    }
    assertThat(resultSet.getType()).isEqualTo(expectedRowType);
    assertThat(resultSet.next()).isFalse();
    return results;
  }

  private Struct executeWithRowResultType(Statement statement, Type expectedRowType) {
    ResultSet resultSet =
        statement.executeQuery(getClient(dialect.dialect).singleUse(TimestampBound.strong()));
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType()).isEqualTo(expectedRowType);
    Struct row = resultSet.getCurrentRowAsStruct();
    assertThat(resultSet.next()).isFalse();
    return row;
  }

  private Struct execute(Statement statement, Type expectedColumnType) {
    Type rowType = Type.struct(StructField.of("", expectedColumnType));
    if (dialect.dialect == Dialect.POSTGRESQL) {
      rowType = Type.struct(StructField.of("?column?", expectedColumnType));
    }
    return executeWithRowResultType(statement, rowType);
  }

  private Struct execute(Statement.Builder builder, Type expectedColumnType) {
    return execute(builder.build(), expectedColumnType);
  }
}
