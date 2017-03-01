/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.cloud.spanner.Type.StructField;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Date;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.spanner.v1.ResultSetStats;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for query execution. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITQueryTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    // Empty database.
    db = env.getTestHelper().createTestDatabase();
    client = env.getTestHelper().getDatabaseClient(db);
  }

  @Test
  public void simple() {
    Struct row = execute(Statement.of("SELECT 1"), Type.int64());
    assertThat(row.getLong(0)).isEqualTo(1);
  }

  @Test
  public void badQuery() {
    expectedException.expect(isSpannerException(ErrorCode.INVALID_ARGUMENT));
    expectedException.expectMessage("Unrecognized name: Apples");
    execute(Statement.of("SELECT Apples AND Oranges"), Type.int64());
  }

  @Test
  public void arrayOfStruct() {
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
            .add(
                "",
                Arrays.asList(
                    StructField.of("C1", Type.string()), StructField.of("C2", Type.int64())),
                Arrays.asList(
                    Struct.newBuilder().set("C1").to("a").set("C2").to(1).build(),
                    Struct.newBuilder().set("C1").to("b").set("C2").to(2).build()))
            .build();
    assertThat(row).isEqualTo(expectedRow);
  }

  @Test
  public void arrayOfStructEmpty() {
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
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to(true).build(), Type.bool());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBoolean(0)).isEqualTo(true);
  }

  @Test
  public void bindBoolNull() {
    Struct row =
        execute(Statement.newBuilder("SELECT @v").bind("v").to((Boolean) null), Type.bool());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindInt64() {
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to(1234), Type.int64());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLong(0)).isEqualTo(1234);
  }

  @Test
  public void bindInt64Null() {
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to((Long) null), Type.int64());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindFloat64() {
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to(2.0), Type.float64());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isWithin(0.0).of(2.0);
  }

  @Test
  public void bindFloat64Null() {
    Struct row =
        execute(Statement.newBuilder("SELECT @v").bind("v").to((Double) null), Type.float64());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindString() {
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to("abc"), Type.string());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("abc");
  }

  @Test
  public void bindStringNull() {
    Struct row =
        execute(Statement.newBuilder("SELECT @v").bind("v").to((String) null), Type.string());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindBytes() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").to(ByteArray.copyFrom("xyz")),
            Type.bytes());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("xyz"));
  }

  @Test
  public void bindBytesNull() {
    Struct row =
        execute(Statement.newBuilder("SELECT @v").bind("v").to((ByteArray) null), Type.bytes());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindTimestamp() {
    Timestamp t = Timestamp.parseTimestamp("2016-09-18T00:00:00Z");
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to(t), Type.timestamp());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestamp(0)).isEqualTo(t);
  }

  @Test
  public void bindTimestampNull() {
    Struct row =
        execute(Statement.newBuilder("SELECT @v").bind("v").to((Timestamp) null), Type.timestamp());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindDate() {
    Date d = Date.parseDate("2016-09-18");
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to(d), Type.date());
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDate(0)).isEqualTo(d);
  }

  @Test
  public void bindDateNull() {
    Struct row = execute(Statement.newBuilder("SELECT @v").bind("v").to((Date) null), Type.date());
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindBoolArray() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v")
                .bind("v")
                .toBoolArray(Arrays.asList(true, null, false)),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly(true, null, false).inOrder();
  }

  @Test
  public void bindBoolArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toBoolArray(Arrays.<Boolean>asList()),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly();
  }

  @Test
  public void bindBoolArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toBoolArray((boolean[]) null),
            Type.array(Type.bool()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindInt64Array() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toInt64Array(Arrays.asList(null, 1L, 2L)),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly(null, 1L, 2L).inOrder();
  }

  @Test
  public void bindInt64ArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toInt64Array(Arrays.<Long>asList()),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly();
  }

  @Test
  public void bindInt64ArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toInt64Array((long[]) null),
            Type.array(Type.int64()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindFloat64Array() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v")
                .bind("v")
                .toFloat64Array(
                    Arrays.asList(
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
            Statement.newBuilder("SELECT @v").bind("v").toFloat64Array(Arrays.<Double>asList()),
            Type.array(Type.float64()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleList(0)).containsExactly();
  }

  @Test
  public void bindFloat64ArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toFloat64Array((double[]) null),
            Type.array(Type.float64()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindStringArray() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v")
                .bind("v")
                .toStringArray(Arrays.asList("a", "b", null)),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly("a", "b", null).inOrder();
  }

  @Test
  public void bindStringArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toStringArray(Arrays.<String>asList()),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly();
  }

  @Test
  public void bindStringArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toStringArray(null),
            Type.array(Type.string()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindBytesArray() {
    ByteArray e1 = ByteArray.copyFrom("x");
    ByteArray e2 = ByteArray.copyFrom("y");
    ByteArray e3 = null;
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toBytesArray(Arrays.asList(e1, e2, e3)),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).containsExactly(e1, e2, e3).inOrder();
  }

  @Test
  public void bindBytesArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toBytesArray(Arrays.<ByteArray>asList()),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).isEmpty();
  }

  @Test
  public void bindBytesArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toBytesArray(null),
            Type.array(Type.bytes()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindTimestampArray() {
    Timestamp t1 = Timestamp.parseTimestamp("2016-09-18T00:00:00Z");
    Timestamp t2 = Timestamp.parseTimestamp("2016-09-19T00:00:00Z");

    Struct row =
        execute(
            Statement.newBuilder("SELECT @v")
                .bind("v")
                .toTimestampArray(Arrays.asList(t1, t2, null)),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly(t1, t2, null).inOrder();
  }

  @Test
  public void bindTimestampArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v")
                .bind("v")
                .toTimestampArray(Arrays.<Timestamp>asList()),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly();
  }

  @Test
  public void bindTimestampArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toTimestampArray(null),
            Type.array(Type.timestamp()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void bindDateArray() {
    Date d1 = Date.parseDate("2016-09-18");
    Date d2 = Date.parseDate("2016-09-19");

    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toDateArray(Arrays.asList(d1, d2, null)),
            Type.array(Type.date()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly(d1, d2, null).inOrder();
  }

  @Test
  public void bindDateArrayEmpty() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toDateArray(Arrays.<Date>asList()),
            Type.array(Type.date()));
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly();
  }

  @Test
  public void bindDateArrayNull() {
    Struct row =
        execute(
            Statement.newBuilder("SELECT @v").bind("v").toDateArray(null), Type.array(Type.date()));
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void unboundParameter() {
    ResultSet resultSet =
        Statement.of("SELECT @v").executeQuery(client.singleUse(TimestampBound.strong()));
    expectedException.expect(isSpannerException(ErrorCode.INVALID_ARGUMENT));
    expectedException.expectMessage("No parameter found for binding: v");
    resultSet.next();
  }

  @Test
  public void positiveInfinity() {
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(1, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isPositiveInfinity();
  }

  @Test
  public void negativeInfinity() {
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(-1, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isNegativeInfinity();
  }

  @Test
  public void notANumber() {
    Struct row = execute(Statement.newBuilder("SELECT IEEE_DIVIDE(0, 0)"), Type.float64());
    assertThat(row.getDouble(0)).isNaN();
  }

  @Test
  public void nonNumberArray() {
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
    String veryLongString = Joiner.on("").join(Iterables.limit(Iterables.cycle("x"), 8000));
    Statement statement =
        Statement.newBuilder("SELECT REGEXP_CONTAINS(@value, @regexp)")
            .bind("value")
            .to("")
            .bind("regexp")
            .to("(" + veryLongString)
            .build();
    ResultSet resultSet = statement.executeQuery(client.singleUse(TimestampBound.strong()));
    expectedException.expect(isSpannerException(ErrorCode.OUT_OF_RANGE));
    expectedException.expectMessage("Cannot parse regular expression");
    resultSet.next();
  }

  @Test
  public void queryRealTable() {
    Database populatedDb =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ( K STRING(MAX) NOT NULL, V STRING(MAX) ) PRIMARY KEY (K)");
    DatabaseClient client = env.getTestHelper().getDatabaseClient(populatedDb);
    client.writeAtLeastOnce(
        Arrays.asList(
            Mutation.newInsertBuilder("T").set("K").to("k1").set("V").to("v1").build(),
            Mutation.newInsertBuilder("T").set("K").to("k2").set("V").to("v2").build(),
            Mutation.newInsertBuilder("T").set("K").to("k3").set("V").to("v3").build(),
            Mutation.newInsertBuilder("T").set("K").to("k4").set("V").to("v4").build()));

    Statement statement =
        Statement.newBuilder("SELECT K, V FROM T WHERE K >= @min AND K < @max ORDER BY K ASC")
            .bind("min")
            .to("k13")
            .bind("max")
            .to("k32")
            .build();
    ResultSet resultSet = statement.executeQuery(client.singleUse(TimestampBound.strong()));
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType())
        .isEqualTo(
            Type.struct(StructField.of("K", Type.string()), StructField.of("V", Type.string())));
    assertThat(resultSet.getString(0)).isEqualTo("k2");
    assertThat(resultSet.getString(1)).isEqualTo("v2");
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getString("K")).isEqualTo("k3");
    assertThat(resultSet.getString("V")).isEqualTo("v3");
    assertThat(resultSet.next()).isFalse();
  }

  @Test
  public void analyzePlan() {
    Statement statement = Statement.of("SELECT 1 AS column UNION ALL SELECT 2");
    ResultSet resultSet =
        statement.analyzeQuery(client.singleUse(TimestampBound.strong()), QueryAnalyzeMode.PLAN);
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(Type.struct(StructField.of("column", Type.int64())));
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(receivedStats).isNotNull();
    assertThat(receivedStats.hasQueryPlan()).isTrue();
    assertThat(receivedStats.hasQueryStats()).isFalse();
  }

  @Test
  public void analyzeProfile() {
    Statement statement =
        Statement.of("SELECT 1 AS column UNION ALL SELECT 2 AS column ORDER BY column");
    ResultSet resultSet =
        statement.analyzeQuery(client.singleUse(TimestampBound.strong()), QueryAnalyzeMode.PROFILE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType()).isEqualTo(Type.struct(StructField.of("column", Type.int64())));
    assertThat(resultSet.getLong(0)).isEqualTo(1);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(2);
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(receivedStats).isNotNull();
    assertThat(receivedStats.hasQueryPlan()).isTrue();
    assertThat(receivedStats.hasQueryStats()).isTrue();
  }

  private Struct execute(Statement statement, Type expectedType) {
    ResultSet resultSet = statement.executeQuery(client.singleUse(TimestampBound.strong()));
    return checkSingleValueOfType(resultSet, expectedType);
  }

  private Struct execute(Statement.Builder builder, Type expectedType) {
    return execute(builder.build(), expectedType);
  }

  private Struct checkSingleValueOfType(ResultSet resultSet, Type expectedType) {
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getType().getStructFields()).hasSize(1);
    assertThat(resultSet.getType().getStructFields().get(0).getType()).isEqualTo(expectedType);
    Struct row = resultSet.getCurrentRowAsStruct();
    assertThat(resultSet.next()).isFalse();
    return row;
  }
}
