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
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Date;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import io.grpc.Context;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration test for writing data to Cloud Spanner. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITWriteTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  /** Sequence used to generate unique keys. */
  private static int seq;

  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K                   STRING(MAX) NOT NULL,"
                    + "  BoolValue           BOOL,"
                    + "  Int64Value          INT64,"
                    + "  Float64Value        FLOAT64,"
                    + "  StringValue         STRING(MAX),"
                    + "  BytesValue          BYTES(MAX),"
                    + "  TimestampValue      TIMESTAMP,"
                    + "  DateValue           DATE,"
                    + "  BoolArrayValue      ARRAY<BOOL>,"
                    + "  Int64ArrayValue     ARRAY<INT64>,"
                    + "  Float64ArrayValue   ARRAY<FLOAT64>,"
                    + "  StringArrayValue    ARRAY<STRING(MAX)>,"
                    + "  BytesArrayValue     ARRAY<BYTES(MAX)>,"
                    + "  TimestampArrayValue ARRAY<TIMESTAMP>,"
                    + "  DateArrayValue      ARRAY<DATE>,"
                    + ") PRIMARY KEY (K)");
    client = env.getTestHelper().getDatabaseClient(db);
  }

  private static String uniqueString() {
    return String.format("k%04d", seq++);
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();
  private String lastKey;

  private void write(Mutation m) {
    client.write(Arrays.asList(m));
  }

  private Mutation.WriteBuilder baseInsert() {
    return Mutation.newInsertOrUpdateBuilder("T").set("K").to(lastKey = uniqueString());
  }

  private Struct readLastRow(String... columns) {
    return client
        .singleUse(TimestampBound.strong())
        .readRow("T", Key.of(lastKey), Arrays.asList(columns));
  }

  @Test
  public void writeAtLeastOnce() {
    client.writeAtLeastOnce(
        Arrays.asList(
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

  @Ignore // TODO(user): Fix this - backend currently accepts empty mutation.
  @Test
  public void emptyWrite() {
    expectedException.expect(isSpannerException(ErrorCode.INVALID_ARGUMENT));
    client.write(Arrays.<Mutation>asList());
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
  public void writeBytes() {
    ByteArray data = ByteArray.copyFrom("V1");
    write(baseInsert().set("BytesValue").to(data).build());
    Struct row = readLastRow("BytesValue");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(data);
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

    expectedException.expect(NullPointerException.class);
    row.getBooleanArray(0);
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

    expectedException.expect(NullPointerException.class);
    row.getLongArray(0);
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

    expectedException.expect(NullPointerException.class);
    row.getDoubleArray(0);
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
    write(baseInsert().set("StringArrayValue").toStringArray(Arrays.<String>asList()).build());
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
  public void writeBytesArrayNull() {
    write(baseInsert().set("BytesArrayValue").toBytesArray(null).build());
    Struct row = readLastRow("BytesArrayValue");
    assertThat(row.isNull(0)).isTrue();
  }

  @Test
  public void writeBytesArrayEmpty() {
    write(baseInsert().set("BytesArrayValue").toBytesArray(Arrays.<ByteArray>asList()).build());
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
        baseInsert()
            .set("TimestampArrayValue")
            .toTimestampArray(Arrays.<Timestamp>asList())
            .build());
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
    write(baseInsert().set("DateArrayValue").toDateArray(Arrays.<Date>asList()).build());
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
  public void tableNotFound() {
    // TODO(user): More precise matchers! Customer code needs to discern table not found, column
    // not found, etc.
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    write(
        Mutation.newInsertBuilder("TableThatDoesNotExist")
            .set("K")
            .to(uniqueString())
            .set("StringuniqueString(Value")
            .to("V1")
            .build());
  }

  @Test
  public void columnNotFound() {
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    write(baseInsert().set("ColumnThatDoesNotExist").to("V1").build());
  }

  @Test
  public void incorrectType() {
    expectedException.expect(isSpannerException(ErrorCode.FAILED_PRECONDITION));
    expectedException.expectMessage("Expected STRING");
    // Attempt to set 'V' to INT64, not STRING.
    // NOTE: an interest effect of not sending type metadata is that BYTES and INT64 are accepted
    // here...
    write(baseInsert().set("StringValue").to(1.234).build());
  }

  @Test
  public void cancellation() {
    Context.CancellableContext context = Context.current().withCancellation();
    context.cancel(new RuntimeException("Cancelled by test"));
    Runnable work =
        context.wrap(
            new Runnable() {
              @Override
              public void run() {
                write(baseInsert().set("BoolValue").to(true).build());
              }
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
            new Runnable() {
              @Override
              public void run() {
                write(baseInsert().set("BoolValue").to(true).build());
              }
            });

    try {
      work.run();
    } catch (SpannerException e) {
      MatcherAssert.assertThat(e, isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    } finally {
      executor.shutdown();
    }
  }
}
