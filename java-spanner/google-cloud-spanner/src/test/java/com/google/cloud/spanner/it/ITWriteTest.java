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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.cloud.spanner.Type.array;
import static com.google.cloud.spanner.Type.json;
import static com.google.cloud.spanner.Type.pgJsonb;
import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.MutationGroup;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.NullValue;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.spanner.v1.BatchWriteResponse;
import io.grpc.Context;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/** Integration test for writing data to Cloud Spanner. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITWriteTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    return params;
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;

  private static final String[] GOOGLE_STANDARD_SQL_SCHEMA =
      new String[] {
        "CREATE TABLE T ("
            + "  K                   STRING(MAX) NOT NULL,"
            + "  BoolValue           BOOL,"
            + "  Int64Value          INT64,"
            + "  Float64Value        FLOAT64,"
            + "  StringValue         STRING(MAX),"
            + "  JsonValue           JSON,"
            + "  BytesValue          BYTES(MAX),"
            + "  TimestampValue      TIMESTAMP OPTIONS (allow_commit_timestamp = true),"
            + "  DateValue           DATE,"
            + "  NumericValue        NUMERIC,"
            + "  BoolArrayValue      ARRAY<BOOL>,"
            + "  Int64ArrayValue     ARRAY<INT64>,"
            + "  Float64ArrayValue   ARRAY<FLOAT64>,"
            + "  StringArrayValue    ARRAY<STRING(MAX)>,"
            + "  JsonArrayValue      ARRAY<JSON>,"
            + "  BytesArrayValue     ARRAY<BYTES(MAX)>,"
            + "  TimestampArrayValue ARRAY<TIMESTAMP>,"
            + "  DateArrayValue      ARRAY<DATE>,"
            + "  NumericArrayValue   ARRAY<NUMERIC>,"
            + ") PRIMARY KEY (K)",
        "CREATE TABLE T1 ("
            + "  K1                  STRING(MAX) NOT NULL,"
            + "  K                   STRING(MAX) NOT NULL,"
            + "  CONSTRAINT FK FOREIGN KEY (K) REFERENCES T(K)"
            + ") PRIMARY KEY (K1)"
      };

  private static final String[] POSTGRESQL_SCHEMA =
      new String[] {
        "CREATE TABLE T ("
            + "  K                   VARCHAR PRIMARY KEY,"
            + "  BoolValue           BOOL,"
            + "  Int64Value          BIGINT,"
            + "  Float64Value        DOUBLE PRECISION,"
            + "  StringValue         VARCHAR,"
            + "  JsonValue           JSONB,"
            + "  BytesValue          BYTEA,"
            + "  TimestampValue      SPANNER.COMMIT_TIMESTAMP,"
            + "  DateValue           DATE,"
            + "  NumericValue        NUMERIC,"
            + "  BoolArrayValue      BOOL[],"
            + "  Int64ArrayValue     BIGINT[],"
            + "  Float64ArrayValue   DOUBLE PRECISION[],"
            + "  StringArrayValue    VARCHAR[],"
            + "  JsonArrayValue      JSONB[],"
            + "  BytesArrayValue     BYTEA[],"
            + "  TimestampArrayValue TIMESTAMPTZ[],"
            + "  DateArrayValue      DATE[],"
            + "  NumericArrayValue   NUMERIC[]"
            + ")",
        "CREATE TABLE T1 ("
            + "  K1                  VARCHAR PRIMARY KEY,"
            + "  K                   VARCHAR,"
            + "  CONSTRAINT FK FOREIGN KEY (K) REFERENCES T(K)"
            + ")"
      };

  /** Sequence used to generate unique keys. */
  private static int seq;

  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase()
      throws ExecutionException, InterruptedException, TimeoutException {
    Database googleStandardSQLDatabase =
        env.getTestHelper().createTestDatabase(GOOGLE_STANDARD_SQL_SCHEMA);

    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);
    Database postgreSQLDatabase =
        env.getTestHelper()
            .createTestDatabase(Dialect.POSTGRESQL, Arrays.asList(POSTGRESQL_SCHEMA));
    postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
  }

  @Before
  public void before() {
    client =
        dialect.dialect == Dialect.GOOGLE_STANDARD_SQL ? googleStandardSQLClient : postgreSQLClient;
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  private static String uniqueString() {
    return String.format("k%04d", seq++);
  }

  private String lastKey;

  private Timestamp write(Mutation m) {
    return client.write(Collections.singletonList(m));
  }

  private Mutation.WriteBuilder baseInsert() {
    return Mutation.newInsertOrUpdateBuilder("T").set("K").to(lastKey = uniqueString());
  }

  private Struct readLastRow(String... columns) {
    return readRow("T", lastKey, columns);
  }

  private Struct readRow(String table, String key, String... columns) {
    return client
        .singleUse(TimestampBound.strong())
        .readRow(table, Key.of(key), Arrays.asList(columns));
  }

  @Test
  public void writeAtLeastOnce() {
    client.writeAtLeastOnce(
        Collections.singletonList(
            Mutation.newInsertOrUpdateBuilder("T")
                .set("K")
                .to(lastKey = uniqueString())
                .set("StringValue")
                .to("v1")
                .build()));
    Struct row = readLastRow("StringValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("v1");
  }

  @Test
  public void batchWriteAtLeastOnce() {
    assumeFalse("Emulator does not support BatchWriteAtLeastOnce", isUsingEmulator());
    final String k1 = uniqueString(), k2 = uniqueString(), k3 = uniqueString(), k4 = uniqueString();
    lastKey = k3;
    final List<MutationGroup> mutationGroups =
        ImmutableList.of(
            MutationGroup.of(
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(k1)
                    .set("StringValue")
                    .to("v1")
                    .set("BoolValue")
                    .to(true)
                    .build(),
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(k2)
                    .set("StringValue")
                    .to("v2")
                    .build()),
            MutationGroup.of(
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(k3)
                    .set("StringValue")
                    .to("v1")
                    .set("BoolValue")
                    .to(false)
                    .build(),
                Mutation.newInsertOrUpdateBuilder("T1").set("K1").to(k4).set("K").to(k3).build()));
    ServerStream<BatchWriteResponse> responses = client.batchWriteAtLeastOnce(mutationGroups);
    Set<Integer> responseIndexes = new HashSet<>();
    Set<Integer> appliedMutationIndexes = new HashSet<>();
    for (BatchWriteResponse response : responses) {
      responseIndexes.addAll(response.getIndexesList());
      if (response.getStatus().equals(Status.newBuilder().setCode(Code.OK_VALUE).build())) {
        appliedMutationIndexes.addAll(response.getIndexesList());
        assertNotNull(response.getCommitTimestamp());
      }
    }
    assertEquals(responseIndexes, new HashSet<>(Arrays.asList(0, 1)));

    Struct row;
    // assert row with key k1
    if (appliedMutationIndexes.contains(0)) {
      row = readRow("T", k1, "StringValue", "BoolValue");
      assertEquals(row.getString(0), "v1");
      assertTrue(row.getBoolean(1));
      row = readRow("T", k2, "StringValue", "BoolValue");
      assertEquals(row.getString(0), "v2");
      assertTrue(row.isNull(1));
    }

    // assert row with key k4, and corresponding referencing table.
    if (appliedMutationIndexes.contains(1)) {
      row = readRow("T", k3, "StringValue", "BoolValue");
      assertEquals(row.getString(0), "v1");
      assertFalse(row.getBoolean(1));
      row = readRow("T1", k4, "K");
      assertEquals(row.getString(0), k3);
    }
  }

  @Test
  public void testWriteWithMaxCommitDelay() {
    CommitResponse response =
        client.writeWithOptions(
            Collections.singletonList(
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(lastKey = uniqueString())
                    .set("StringValue")
                    .to("v1")
                    .build()),
            Options.maxCommitDelay(java.time.Duration.ofMillis(100)));
    assertNotNull(response);
    assertNotNull(response.getCommitTimestamp());
  }

  @Test
  public void testWriteReturnsCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    CommitResponse response =
        client.writeWithOptions(
            Collections.singletonList(
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(lastKey = uniqueString())
                    .set("StringValue")
                    .to("v1")
                    .build()),
            Options.commitStats());
    assertNotNull(response);
    assertNotNull(response.getCommitTimestamp());
    assertNotNull(response.getCommitStats());
    assertEquals(2L, response.getCommitStats().getMutationCount());
  }

  @Test
  public void testWriteAtLeastOnceReturnsCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    CommitResponse response =
        client.writeAtLeastOnceWithOptions(
            Collections.singletonList(
                Mutation.newInsertOrUpdateBuilder("T")
                    .set("K")
                    .to(lastKey = uniqueString())
                    .set("StringValue")
                    .to("v1")
                    .build()),
            Options.commitStats());
    assertNotNull(response);
    assertNotNull(response.getCommitTimestamp());
    assertNotNull(response.getCommitStats());
    assertEquals(2L, response.getCommitStats().getMutationCount());
  }

  @Test
  public void writeAlreadyExists() {
    client.write(
        Collections.singletonList(
            Mutation.newInsertBuilder("T")
                .set("K")
                .to(lastKey = "key1")
                .set("StringValue")
                .to("v1")
                .build()));
    Struct row = readLastRow("StringValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("v1");

    try {
      client.write(
          Collections.singletonList(
              Mutation.newInsertBuilder("T")
                  .set("K")
                  .to(lastKey)
                  .set("StringValue")
                  .to("v2")
                  .build()));
      fail("missing expected ALREADY_EXISTS exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.ALREADY_EXISTS);
    }
    row = readLastRow("StringValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("v1");
  }

  @Ignore // TODO(user): Fix this - backend currently accepts empty mutation.
  @Test
  public void emptyWrite() {
    try {
      client.write(Collections.emptyList());
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void writeBool() {
    write(baseInsert().set("BoolValue").to(true).build());
    Struct row = readLastRow("BoolValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBoolean(0)).isTrue();
  }

  @Test
  public void writeBoolNull() {
    write(baseInsert().set("BoolValue").to((Boolean) null).build());
    Struct row = readLastRow("BoolValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeInt64() {
    write(baseInsert().set("Int64Value").to(1234).build());
    Struct row = readLastRow("Int64Value");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLong(0)).isEqualTo(1234L);
  }

  @Test
  public void writeInt64Null() {
    write(baseInsert().set("Int64Value").to((Long) null).build());
    Struct row = readLastRow("Int64Value");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeFloat64() {
    write(baseInsert().set("Float64Value").to(2.0).build());
    Struct row = readLastRow("Float64Value");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isWithin(0.0).of(2.0);
  }

  @Test
  public void writeFloat64NonNumbers() {
    write(baseInsert().set("Float64Value").to(Double.NEGATIVE_INFINITY).build());
    Struct row = readLastRow("Float64Value");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isNegativeInfinity();

    write(baseInsert().set("Float64Value").to(Double.POSITIVE_INFINITY).build());
    row = readLastRow("Float64Value");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isPositiveInfinity();

    write(baseInsert().set("Float64Value").to(Double.NaN).build());
    row = readLastRow("Float64Value");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDouble(0)).isNaN();
  }

  @Test
  public void writeFloat64Null() {
    write(baseInsert().set("Float64Value").to((Double) null).build());
    Struct row = readLastRow("Float64Value");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeString() {
    write(baseInsert().set("StringValue").to("V1").build());
    Struct row = readLastRow("StringValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getString(0)).isEqualTo("V1");
  }

  @Test
  public void writeStringNull() {
    write(baseInsert().set("StringValue").to((String) null).build());
    Struct row = readLastRow("StringValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeJson() {
    write(baseInsert().set("JsonValue").to(Value.json("{\"rating\":9,\"open\":true}")).build());
    Struct row = readLastRow("JsonValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonvalue")).isEqualTo(pgJsonb());
      assertThat(row.getPgJsonb(0)).isEqualTo("{\"open\": true, \"rating\": 9}");
    } else {
      assertThat(row.getColumnType("JsonValue")).isEqualTo(json());
      assertThat(row.getJson(0)).isEqualTo("{\"open\":true,\"rating\":9}");
    }
  }

  @Test
  public void writeJsonEmpty() {
    write(baseInsert().set("JsonValue").to(Value.json("{}")).build());
    Struct row = readLastRow("JsonValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonvalue")).isEqualTo(pgJsonb());
      assertThat(row.getPgJsonb(0)).isEqualTo("{}");
    } else {
      assertThat(row.getColumnType("JsonValue")).isEqualTo(json());
      assertThat(row.getJson(0)).isEqualTo("{}");
    }
  }

  @Test
  public void writeJsonNull() {
    write(baseInsert().set("JsonValue").to(Value.json(null)).build());
    Struct row = readLastRow("JsonValue");
    assertThat(row.isNull(0)).isTrue();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonvalue")).isEqualTo(pgJsonb());
    } else {
      assertThat(row.getColumnType("JsonValue")).isEqualTo(json());
    }
  }

  @Test
  public void writeBytes() {
    ByteArray data = ByteArray.copyFrom("V1");
    write(baseInsert().set("BytesValue").to(data).build());
    Struct row = readLastRow("BytesValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(data);
  }

  @Test
  public void writeBytesAsString() {
    Random random = new Random();
    byte[] data = new byte[256];
    random.nextBytes(data);
    String base64 = Base64.getEncoder().encodeToString(data);
    write(baseInsert().set("BytesValue").to(base64).build());
    Struct row = readLastRow("BytesValue");
    assertFalse(row.isNull(0));
    assertArrayEquals(data, row.getBytes(0).toByteArray());
    assertEquals(base64, row.getValue(0).getAsString());
  }

  @Test
  public void writeBytesAsStringUsingDml() {
    Random random = new Random();
    byte[] data = new byte[256];
    random.nextBytes(data);
    String base64 = Base64.getEncoder().encodeToString(data);
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.executeUpdate(
                        Statement.newBuilder(
                                "insert into T (BytesValue, K) values ("
                                    + queryParamString(1)
                                    + ", "
                                    + queryParamString(2)
                                    + ")")
                            .bind("p1")
                            .to(Value.bytesFromBase64(base64))
                            .bind("p2")
                            .to(lastKey = uniqueString())
                            .build()));
    assertNotNull(updateCount);
    assertEquals(1L, updateCount.longValue());

    Struct row = readLastRow("BytesValue");
    assertFalse(row.isNull(0));
    assertArrayEquals(data, row.getBytes(0).toByteArray());
    assertEquals(base64, row.getValue(0).getAsString());
  }

  String queryParamString(int index) {
    return dialect.dialect == Dialect.GOOGLE_STANDARD_SQL ? "@p" + index : "$" + index;
  }

  @Test
  public void writeBytesRandom() {
    // Pseudo-random test for byte encoding.  We explicitly set a random seed so that multiple
    // test runs cover more data, but any failing test run can be reproduced easily.
    Random rnd = new Random();
    long seed = rnd.nextLong();
    rnd.setSeed(seed);

    Map<String, ByteArray> expected = new HashMap<>();
    boolean pass = false;
    try {
      for (int length : new int[] {1, 2, 5, 11}) {
        byte[] data = new byte[length];
        for (int i = 0; i < 3; ++i) {
          rnd.nextBytes(data);
          String key = uniqueString();
          ByteArray value = ByteArray.copyFrom(data);
          expected.put(key, value);
          write(
              Mutation.newInsertOrUpdateBuilder("T")
                  .set("K")
                  .to(key)
                  .set("BytesValue")
                  .to(value)
                  .build());
        }
      }
      KeySet.Builder keys = KeySet.newBuilder();
      for (String key : expected.keySet()) {
        keys.addKey(Key.of(key));
      }
      ResultSet resultSet =
          client
              .singleUse(TimestampBound.strong())
              .read("T", keys.build(), Arrays.asList("K", "BytesValue"));
      while (resultSet.next()) {
        String key = resultSet.getString(0);
        ByteArray value = resultSet.getBytes(1);
        assertThat(expected).containsKey(key);
        ByteArray expectedValue = expected.remove(key);
        assertThat(value).isEqualTo(expectedValue);
      }
      assertThat(expected).isEmpty();
      pass = true;
    } finally {
      if (!pass) {
        System.out.println("To reproduce failure, use seed " + seed);
      }
    }
  }

  @Test
  public void writeBytesNull() {
    write(baseInsert().set("BytesValue").to((ByteArray) null).build());
    Struct row = readLastRow("BytesValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeTimestamp() {
    Timestamp timestamp = Timestamp.parseTimestamp("2016-09-15T00:00:00.111111Z");
    write(baseInsert().set("TimestampValue").to(timestamp).build());
    Struct row = readLastRow("TimestampValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestamp(0)).isEqualTo(timestamp);
  }

  @Test
  public void writeTimestampNull() {
    write(baseInsert().set("TimestampValue").to((Timestamp) null).build());
    Struct row = readLastRow("TimestampValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeCommitTimestamp() {
    Timestamp commitTimestamp =
        write(baseInsert().set("TimestampValue").to(Value.COMMIT_TIMESTAMP).build());
    Struct row = readLastRow("TimestampValue");
    assertThat(row.getTimestamp(0)).isEqualTo(commitTimestamp);
  }

  @Test
  public void writeDate() {
    Date date = Date.parseDate("2016-09-15");
    write(baseInsert().set("DateValue").to(date).build());
    Struct row = readLastRow("DateValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDate(0)).isEqualTo(date);
  }

  @Test
  public void writeDateNull() {
    write(baseInsert().set("DateValue").to((Date) null).build());
    Struct row = readLastRow("DateValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeNumeric() {
    write(baseInsert().set("NumericValue").to("3.141592").build());
    Struct row = readLastRow("NumericValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.GOOGLE_STANDARD_SQL) {
      assertThat(row.getBigDecimal(0)).isEqualTo(BigDecimal.valueOf(3141592, 6));
    } else {
      assertThat(row.getString(0)).isEqualTo("3.141592");
    }
  }

  @Test
  public void writeNumericNull() {
    write(baseInsert().set("NumericValue").to((String) null).build());
    Struct row = readLastRow("NumericValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeBoolArrayNull() {
    write(baseInsert().set("BoolArrayValue").toBoolArray((boolean[]) null).build());
    Struct row = readLastRow("BoolArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeBoolArrayEmpty() {
    write(baseInsert().set("BoolArrayValue").toBoolArray(new boolean[] {}).build());
    Struct row = readLastRow("BoolArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly();
  }

  @Test
  public void writeBoolArray() {
    write(baseInsert().set("BoolArrayValue").toBoolArray(Arrays.asList(true, null, false)).build());
    Struct row = readLastRow("BoolArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanList(0)).containsExactly(true, null, false).inOrder();
    try {
      row.getBooleanArray(0);
      fail("Expected exception");
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void writeBoolArrayNoNulls() {
    write(baseInsert().set("BoolArrayValue").toBoolArray(Arrays.asList(true, false)).build());
    Struct row = readLastRow("BoolArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBooleanArray(0)).isEqualTo(new boolean[] {true, false});
  }

  @Test
  public void writeInt64ArrayNull() {
    write(baseInsert().set("Int64ArrayValue").toInt64Array((long[]) null).build());
    Struct row = readLastRow("Int64ArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeInt64ArrayEmpty() {
    write(baseInsert().set("Int64ArrayValue").toInt64Array(new long[] {}).build());
    Struct row = readLastRow("Int64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly();
  }

  @Test
  public void writeInt64Array() {
    write(baseInsert().set("Int64ArrayValue").toInt64Array(Arrays.asList(1L, 2L, null)).build());
    Struct row = readLastRow("Int64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongList(0)).containsExactly(1L, 2L, null).inOrder();
    try {
      row.getLongArray(0);
      fail("Expected exception");
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void writeInt64ArrayNoNulls() {
    write(baseInsert().set("Int64ArrayValue").toInt64Array(Arrays.asList(1L, 2L)).build());
    Struct row = readLastRow("Int64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getLongArray(0)).isEqualTo(new long[] {1, 2});
  }

  @Test
  public void writeFloat64ArrayNull() {
    write(baseInsert().set("Float64ArrayValue").toFloat64Array((double[]) null).build());
    Struct row = readLastRow("Float64ArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeFloat64ArrayEmpty() {
    write(baseInsert().set("Float64ArrayValue").toFloat64Array(new double[] {}).build());
    Struct row = readLastRow("Float64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleList(0)).containsExactly();
  }

  @Test
  public void writeFloat64Array() {
    write(
        baseInsert()
            .set("Float64ArrayValue")
            .toFloat64Array(Arrays.asList(null, 1.0, 2.0))
            .build());
    Struct row = readLastRow("Float64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleList(0)).containsExactly(null, 1.0, 2.0).inOrder();
    try {
      row.getDoubleArray(0);
      fail("Expected exception");
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void writeFloat64ArrayNoNulls() {
    write(baseInsert().set("Float64ArrayValue").toFloat64Array(Arrays.asList(1.0, 2.0)).build());
    Struct row = readLastRow("Float64ArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDoubleArray(0).length).isEqualTo(2);
    assertThat(row.getDoubleArray(0)[0]).isWithin(0.0).of(1.0);
    assertThat(row.getDoubleArray(0)[1]).isWithin(0.0).of(2.0);
  }

  @Test
  public void writeStringArrayNull() {
    write(baseInsert().set("StringArrayValue").toStringArray(null).build());
    Struct row = readLastRow("StringArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeStringArrayEmpty() {
    write(baseInsert().set("StringArrayValue").toStringArray(Collections.emptyList()).build());
    Struct row = readLastRow("StringArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly();
  }

  @Test
  public void writeStringArray() {
    write(
        baseInsert().set("StringArrayValue").toStringArray(Arrays.asList("a", null, "b")).build());
    Struct row = readLastRow("StringArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getStringList(0)).containsExactly("a", null, "b").inOrder();
  }

  @Test
  public void writeJsonArrayNull() {
    write(baseInsert().set("JsonArrayValue").toJsonArray(null).build());
    Struct row = readLastRow("JsonArrayValue");
    assertThat(row.isNull(0)).isTrue();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonarrayvalue")).isEqualTo(array(pgJsonb()));
    } else {
      assertThat(row.getColumnType("JsonArrayValue")).isEqualTo(array(json()));
    }
  }

  @Test
  public void writeJsonArrayEmpty() {
    write(baseInsert().set("JsonArrayValue").toJsonArray(Collections.emptyList()).build());
    Struct row = readLastRow("JsonArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonarrayvalue")).isEqualTo(array(pgJsonb()));
      assertThat(row.getPgJsonbList(0)).containsExactly();
    } else {
      assertThat(row.getColumnType("JsonArrayValue")).isEqualTo(array(json()));
      assertThat(row.getJsonList(0)).containsExactly();
    }
  }

  @Test
  public void writeJsonArray() {
    write(baseInsert().set("JsonArrayValue").toJsonArray(Arrays.asList("[]", null, "{}")).build());
    Struct row = readLastRow("JsonArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonarrayvalue")).isEqualTo(array(pgJsonb()));
      assertThat(row.getPgJsonbList(0)).containsExactly("[]", null, "{}").inOrder();
    } else {
      assertThat(row.getColumnType("JsonArrayValue")).isEqualTo(array(json()));
      assertThat(row.getJsonList(0)).containsExactly("[]", null, "{}").inOrder();
    }
  }

  @Test
  public void writeJsonArrayNoNulls() {
    write(
        baseInsert()
            .set("JsonArrayValue")
            .toJsonArray(Arrays.asList("[]", "{\"color\":\"red\",\"value\":\"#f00\"}", "{}"))
            .build());
    Struct row = readLastRow("JsonArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.POSTGRESQL) {
      assertThat(row.getColumnType("jsonarrayvalue")).isEqualTo(array(pgJsonb()));
      assertThat(row.getPgJsonbList(0))
          .containsExactly("[]", "{\"color\": \"red\", \"value\": \"#f00\"}", "{}")
          .inOrder();
    } else {
      assertThat(row.getColumnType("JsonArrayValue")).isEqualTo(array(json()));
      assertThat(row.getJsonList(0))
          .containsExactly("[]", "{\"color\":\"red\",\"value\":\"#f00\"}", "{}")
          .inOrder();
    }
  }

  @Test
  public void writeBytesArrayNull() {
    write(baseInsert().set("BytesArrayValue").toBytesArray(null).build());
    Struct row = readLastRow("BytesArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeBytesArrayEmpty() {
    write(baseInsert().set("BytesArrayValue").toBytesArray(Collections.emptyList()).build());
    Struct row = readLastRow("BytesArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).containsExactly();
  }

  @Test
  public void writeBytesArray() {
    List<ByteArray> data = Arrays.asList(ByteArray.copyFrom("a"), ByteArray.copyFrom("b"), null);
    write(baseInsert().set("BytesArrayValue").toBytesArray(data).build());
    Struct row = readLastRow("BytesArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytesList(0)).isEqualTo(data);
  }

  @Test
  public void writeTimestampArrayNull() {
    write(baseInsert().set("TimestampArrayValue").toTimestampArray(null).build());
    Struct row = readLastRow("TimestampArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeTimestampArrayEmpty() {
    write(
        baseInsert().set("TimestampArrayValue").toTimestampArray(Collections.emptyList()).build());
    Struct row = readLastRow("TimestampArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly();
  }

  @Test
  public void writeTimestampArray() {
    Timestamp t1 = Timestamp.parseTimestamp("2016-09-18T00:00:00Z");
    Timestamp t2 = Timestamp.parseTimestamp("2016-09-19T00:00:00Z");
    write(
        baseInsert()
            .set("TimestampArrayValue")
            .toTimestampArray(Arrays.asList(t1, null, t2))
            .build());
    Struct row = readLastRow("TimestampArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getTimestampList(0)).containsExactly(t1, null, t2).inOrder();
  }

  @Test
  public void writeDateArrayNull() {
    write(baseInsert().set("DateArrayValue").toDateArray(null).build());
    Struct row = readLastRow("DateArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeDateArrayEmpty() {
    write(baseInsert().set("DateArrayValue").toDateArray(Collections.emptyList()).build());
    Struct row = readLastRow("DateArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly();
  }

  @Test
  public void writeDateArray() {
    Date d1 = Date.parseDate("2016-09-18");
    Date d2 = Date.parseDate("2016-09-19");
    write(baseInsert().set("DateArrayValue").toDateArray(Arrays.asList(d1, null, d2)).build());
    Struct row = readLastRow("DateArrayValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getDateList(0)).containsExactly(d1, null, d2).inOrder();
  }

  @Test
  public void writeNumericArrayNull() {
    write(baseInsert().set("NumericArrayValue").toNumericArray(null).build());
    Struct row = readLastRow("NumericArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeNumericArrayEmpty() {
    write(baseInsert().set("NumericArrayValue").toNumericArray(ImmutableList.of()).build());
    Struct row = readLastRow("NumericArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.GOOGLE_STANDARD_SQL) {
      assertThat(row.getBigDecimalList(0)).containsExactly();
    } else {
      assertThat(row.getStringList(0)).containsExactly();
    }
  }

  @Test
  public void writeNumericArray() {
    write(
        baseInsert()
            .set("NumericArrayValue")
            .toNumericArray(
                Arrays.asList(new BigDecimal("3.141592"), new BigDecimal("6.626"), null))
            .build());
    Struct row = readLastRow("NumericArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.GOOGLE_STANDARD_SQL) {
      assertThat(row.getBigDecimalList(0))
          .containsExactly(BigDecimal.valueOf(3141592, 6), BigDecimal.valueOf(6626, 3), null);
    } else {
      assertThat(row.getStringList(0)).containsExactly("3.141592", "6.626", null).inOrder();
    }
  }

  @Test
  public void writeNumericArrayNoNulls() {
    write(
        baseInsert()
            .set("NumericArrayValue")
            .toNumericArray(Arrays.asList(new BigDecimal("3.141592"), new BigDecimal("6.626")))
            .build());
    Struct row = readLastRow("NumericArrayValue");
    assertThat(row.isNull(0)).isFalse();
    if (dialect.dialect == Dialect.GOOGLE_STANDARD_SQL) {
      assertThat(row.getBigDecimalList(0))
          .containsExactly(BigDecimal.valueOf(3141592, 6), BigDecimal.valueOf(6626, 3));
    } else {
      assertThat(row.getStringList(0))
          .containsExactly(
              BigDecimal.valueOf(3141592, 6).toString(), BigDecimal.valueOf(6626, 3).toString())
          .inOrder();
    }
  }

  @Test
  public void tableNotFound() {
    // TODO(user): More precise matchers! Customer code needs to discern table not found, column
    // not found, etc.
    try {
      write(
          Mutation.newInsertBuilder("TableThatDoesNotExist")
              .set("K")
              .to(uniqueString())
              .set("StringuniqueString(Value")
              .to("V1")
              .build());
      fail("Expected exception");
    } catch (SpannerException ex) {
      if (env.getTestHelper()
          .getOptions()
          .getSessionPoolOptions()
          .getUseMultiplexedSessionForRW()) {
        // Backend currently returns INVALID_ARGUMENT, however this will be changed to NOT_FOUND in
        // future.
        assertThat(ex.getErrorCode()).isAnyOf(ErrorCode.NOT_FOUND, ErrorCode.INVALID_ARGUMENT);
      } else {
        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
    }
  }

  @Test
  public void columnNotFound() {
    try {
      write(baseInsert().set("ColumnThatDoesNotExist").to("V1").build());
      fail("Expected exception");
    } catch (SpannerException ex) {
      if (env.getTestHelper()
          .getOptions()
          .getSessionPoolOptions()
          .getUseMultiplexedSessionForRW()) {
        // Backend currently returns INVALID_ARGUMENT, however this will be changed to NOT_FOUND in
        // future.
        assertThat(ex.getErrorCode()).isAnyOf(ErrorCode.NOT_FOUND, ErrorCode.INVALID_ARGUMENT);
      } else {
        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
    }
  }

  @Test
  public void incorrectType() {
    try {
      write(baseInsert().set("StringValue").to(1.234).build());
      fail("Expected exception");
    } catch (SpannerException ex) {
      if (env.getTestHelper()
          .getOptions()
          .getSessionPoolOptions()
          .getUseMultiplexedSessionForRW()) {
        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      } else {
        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
        assertThat(ex.getMessage()).contains("STRING");
      }
    }
  }

  @Test
  public void cancellation() {
    Context.CancellableContext context = Context.current().withCancellation();
    context.cancel(new RuntimeException("Cancelled by test"));
    Runnable work =
        context.wrap(
            () -> {
              write(baseInsert().set("BoolValue").to(true).build());
            });

    try {
      work.run();
    } catch (SpannerException e) {
      MatcherAssert.assertThat(e, isSpannerException(ErrorCode.CANCELLED));
    }
  }

  @Test
  public void deadline() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    // Cloud Spanner is fast, but not this fast :-)
    Context.CancellableContext context =
        Context.current().withDeadlineAfter(10, TimeUnit.NANOSECONDS, executor);
    Runnable work =
        context.wrap(
            () -> {
              write(baseInsert().set("BoolValue").to(true).build());
            });

    try {
      work.run();
    } catch (SpannerException e) {
      MatcherAssert.assertThat(e, isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    } finally {
      executor.shutdown();
    }
  }

  @Test
  public void testWriteUntypedNullValuesGoogleSQL() {
    assumeFalse(
        "PostgreSQL uses a different parameter format", dialect.dialect == Dialect.POSTGRESQL);
    Value untypedNull =
        Value.untyped(
            com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build());
    assertEquals(
        Long.valueOf(1L),
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.executeUpdate(
                        Statement.newBuilder(
                                "insert into T (K,BoolValue,Int64Value,Float64Value,StringValue,"
                                    + "JsonValue,BytesValue,TimestampValue,DateValue,NumericValue,"
                                    + "BoolArrayValue,Int64ArrayValue,Float64ArrayValue,"
                                    + "StringArrayValue,JsonArrayValue,BytesArrayValue,"
                                    + "TimestampArrayValue,DateArrayValue,NumericArrayValue) values"
                                    + " (@k, @bool, @int64, @float64, @string, @json, @bytes,"
                                    + " @timestamp, @date, @numeric, @boolArray, @int64Array,"
                                    + " @float64Array, @stringArray, @jsonArray, @bytesArray,"
                                    + " @timestampArray, @dateArray, @numericArray)")
                            .bind("k")
                            .to(uniqueString())
                            .bind("bool")
                            .to(untypedNull)
                            .bind("int64")
                            .to(untypedNull)
                            .bind("float64")
                            .to(untypedNull)
                            .bind("string")
                            .to(untypedNull)
                            .bind("json")
                            .to(untypedNull)
                            .bind("bytes")
                            .to(untypedNull)
                            .bind("timestamp")
                            .to(untypedNull)
                            .bind("date")
                            .to(untypedNull)
                            .bind("numeric")
                            .to(untypedNull)
                            .bind("boolArray")
                            .to(untypedNull)
                            .bind("int64Array")
                            .to(untypedNull)
                            .bind("float64Array")
                            .to(untypedNull)
                            .bind("stringArray")
                            .to(untypedNull)
                            .bind("jsonArray")
                            .to(untypedNull)
                            .bind("bytesArray")
                            .to(untypedNull)
                            .bind("timestampArray")
                            .to(untypedNull)
                            .bind("dateArray")
                            .to(untypedNull)
                            .bind("numericArray")
                            .to(untypedNull)
                            .build())));
  }

  @Test
  public void testTypeNamesGoogleSQL() {
    assumeTrue(
        "GoogleSQL uses different type names", dialect.dialect == Dialect.GOOGLE_STANDARD_SQL);

    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.newBuilder(
                        "select column_name, spanner_type "
                            + "from information_schema.columns "
                            + "where table_schema=@schema "
                            + "and table_name=@table "
                            + "order by ordinal_position")
                    .bind("schema")
                    .to(dialect.dialect.getDefaultSchema())
                    .bind("table")
                    .to("T")
                    .build())) {
      assertTrue(resultSet.next());
      assertEquals("K", resultSet.getString("column_name"));
      assertEquals(
          Type.string().getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type").replaceFirst("\\((?:\\d+|MAX)\\)", ""));

      assertTrue(resultSet.next());
      assertEquals("BoolValue", resultSet.getString("column_name"));
      assertEquals(
          Type.bool().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("Int64Value", resultSet.getString("column_name"));
      assertEquals(
          Type.int64().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("Float64Value", resultSet.getString("column_name"));
      assertEquals(
          Type.float64().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("StringValue", resultSet.getString("column_name"));
      assertEquals(
          Type.string().getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type").replaceFirst("\\((?:\\d+|MAX)\\)", ""));

      assertTrue(resultSet.next());
      assertEquals("JsonValue", resultSet.getString("column_name"));
      assertEquals(
          Type.json().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("BytesValue", resultSet.getString("column_name"));
      assertEquals(
          Type.bytes().getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type").replaceFirst("\\((?:\\d+|MAX)\\)", ""));

      assertTrue(resultSet.next());
      assertEquals("TimestampValue", resultSet.getString("column_name"));
      assertEquals(
          Type.timestamp().getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("DateValue", resultSet.getString("column_name"));
      assertEquals(
          Type.date().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("NumericValue", resultSet.getString("column_name"));
      assertEquals(
          Type.numeric().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("BoolArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.bool()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("Int64ArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.int64()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("Float64ArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.float64()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("StringArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.string()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type").replaceFirst("\\((?:\\d+|MAX)\\)", ""));

      assertTrue(resultSet.next());
      assertEquals("JsonArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.json()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("BytesArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.bytes()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type").replaceFirst("\\((?:\\d+|MAX)\\)", ""));

      assertTrue(resultSet.next());
      assertEquals("TimestampArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.timestamp()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("DateArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.date()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("NumericArrayValue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.numeric()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testWriteUntypedNullValuesPostgreSQL() {
    assumeTrue(
        "PostgreSQL uses a different parameter format", dialect.dialect == Dialect.POSTGRESQL);
    Value untypedNull =
        Value.untyped(
            com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build());
    assertEquals(
        Long.valueOf(1L),
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.executeUpdate(
                        Statement.newBuilder(
                                "insert into T ("
                                    + "K,"
                                    + "BoolValue,"
                                    + "Int64Value,"
                                    + "Float64Value,"
                                    + "StringValue,"
                                    + "JsonValue,"
                                    + "BytesValue,"
                                    + "TimestampValue,"
                                    + "DateValue,"
                                    + "NumericValue,"
                                    + "BoolArrayValue,"
                                    + "Int64ArrayValue,"
                                    + "Float64ArrayValue,"
                                    + "StringArrayValue,"
                                    + "JsonArrayValue,"
                                    + "BytesArrayValue,"
                                    + "TimestampArrayValue,"
                                    + "DateArrayValue,"
                                    + "NumericArrayValue"
                                    + ") values ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, "
                                    + "$11, $12, $13, $14, $15, $16, $17, $18, $19)")
                            .bind("p1")
                            .to(uniqueString())
                            .bind("p2")
                            .to(untypedNull)
                            .bind("p3")
                            .to(untypedNull)
                            .bind("p4")
                            .to(untypedNull)
                            .bind("p5")
                            .to(untypedNull)
                            .bind("p6")
                            .to(untypedNull)
                            .bind("p7")
                            .to(untypedNull)
                            .bind("p8")
                            .to(untypedNull)
                            .bind("p9")
                            .to(untypedNull)
                            .bind("p10")
                            .to(untypedNull)
                            .bind("p11")
                            .to(untypedNull)
                            .bind("p12")
                            .to(untypedNull)
                            .bind("p13")
                            .to(untypedNull)
                            .bind("p14")
                            .to(untypedNull)
                            .bind("p15")
                            .to(untypedNull)
                            .bind("p16")
                            .to(untypedNull)
                            .bind("p17")
                            .to(untypedNull)
                            .bind("p18")
                            .to(untypedNull)
                            .bind("p19")
                            .to(untypedNull)
                            .build())));
  }

  @Test
  public void testTypeNamesPostgreSQL() {
    assumeTrue("PostgreSQL uses different type names", dialect.dialect == Dialect.POSTGRESQL);

    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.newBuilder(
                        "select column_name, spanner_type "
                            + "from information_schema.columns "
                            + "where table_schema=$1 "
                            + "and table_name=$2 "
                            + "order by ordinal_position")
                    .bind("p1")
                    .to(dialect.dialect.getDefaultSchema())
                    .bind("p2")
                    .to("t")
                    .build())) {
      assertTrue(resultSet.next());
      assertEquals("k", resultSet.getString("column_name"));
      assertEquals(
          Type.string().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("boolvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.bool().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("int64value", resultSet.getString("column_name"));
      assertEquals(
          Type.int64().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("float64value", resultSet.getString("column_name"));
      assertEquals(
          Type.float64().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("stringvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.string().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("jsonvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.pgJsonb().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("bytesvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.bytes().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("timestampvalue", resultSet.getString("column_name"));
      assertEquals("spanner.commit_timestamp", resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("datevalue", resultSet.getString("column_name"));
      assertEquals(
          Type.date().getSpannerTypeName(dialect.dialect), resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("numericvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.pgNumeric().getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("boolarrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.bool()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("int64arrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.int64()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("float64arrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.float64()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("stringarrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.string()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("jsonarrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.pgJsonb()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("bytesarrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.bytes()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("timestamparrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.timestamp()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("datearrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.date()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertTrue(resultSet.next());
      assertEquals("numericarrayvalue", resultSet.getString("column_name"));
      assertEquals(
          Type.array(Type.pgNumeric()).getSpannerTypeName(dialect.dialect),
          resultSet.getString("spanner_type"));

      assertFalse(resultSet.next());
    }
  }
}
