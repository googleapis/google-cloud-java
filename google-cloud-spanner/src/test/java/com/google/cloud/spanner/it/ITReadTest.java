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

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import io.grpc.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration tests for read and query.
 *
 * <p>See also {@link ITWriteTest}, which provides coverage of writing and reading back all Cloud
 * Spanner types.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITReadTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";
  private static final String INDEX_NAME = "TestTableByValue";
  private static final String DESC_INDEX_NAME = "TestTableByValueDesc";
  private static final List<String> ALL_COLUMNS = Arrays.asList("Key", "StringValue");
  private static final Type TABLE_TYPE =
      Type.struct(
          StructField.of("Key", Type.string()), StructField.of("StringValue", Type.string()));

  private static Database db;
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ("
                    + "  Key                STRING(MAX) NOT NULL,"
                    + "  StringValue        STRING(MAX),"
                    + ") PRIMARY KEY (Key)",
                "CREATE INDEX TestTableByValue ON TestTable(StringValue)",
                "CREATE INDEX TestTableByValueDesc ON TestTable(StringValue DESC)");
    client = env.getTestHelper().getDatabaseClient(db);

    // Includes k0..k14.  Note that strings k{10,14} sort between k1 and k2.
    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 15; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    client.write(mutations);
  }

  @Test
  public void emptyRead() {
    ResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .read(
                TABLE_NAME,
                KeySet.range(KeyRange.closedOpen(Key.of("k99"), Key.of("z"))),
                ALL_COLUMNS);
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(TABLE_TYPE);
  }

  @Test
  public void indexEmptyRead() {
    ResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .readUsingIndex(
                TABLE_NAME,
                INDEX_NAME,
                KeySet.range(KeyRange.closedOpen(Key.of("v99"), Key.of("z"))),
                ALL_COLUMNS);
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(TABLE_TYPE);
  }

  @Test
  public void pointRead() {
    Struct row =
        client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo("k1");
    assertThat(row.getString(1)).isEqualTo("v1");
    // Ensure that the Struct implementation supports equality properly.
    assertThat(row)
        .isEqualTo(Struct.newBuilder().set("Key").to("k1").set("StringValue").to("v1").build());
  }

  @Test
  public void indexPointRead() {
    Struct row =
        client
            .singleUse(TimestampBound.strong())
            .readRowUsingIndex(TABLE_NAME, INDEX_NAME, Key.of("v1"), ALL_COLUMNS);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo("k1");
    assertThat(row.getString(1)).isEqualTo("v1");
  }

  @Test
  public void pointReadNotFound() {
    Struct row =
        client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k999"), ALL_COLUMNS);
    assertThat(row).isNull();
  }

  @Test
  public void indexPointReadNotFound() {
    Struct row =
        client
            .singleUse(TimestampBound.strong())
            .readRowUsingIndex(TABLE_NAME, INDEX_NAME, Key.of("v999"), ALL_COLUMNS);
    assertThat(row).isNull();
  }

  @Test
  public void rangeReads() {
    checkRange(Source.BASE_TABLE, KeySet.singleKey(Key.of("k1")), 1);
    checkRange(Source.BASE_TABLE, KeyRange.closedOpen(Key.of("k3"), Key.of("k5")), 3, 4);
    checkRange(Source.BASE_TABLE, KeyRange.closedClosed(Key.of("k3"), Key.of("k5")), 3, 4, 5);
    checkRange(Source.BASE_TABLE, KeyRange.openClosed(Key.of("k3"), Key.of("k5")), 4, 5);
    checkRange(Source.BASE_TABLE, KeyRange.openOpen(Key.of("k3"), Key.of("k5")), 4);

    // Partial key specification.
    checkRange(Source.BASE_TABLE, KeyRange.closedClosed(Key.of("k7"), Key.of()), 7, 8, 9);
    checkRange(Source.BASE_TABLE, KeyRange.openClosed(Key.of("k7"), Key.of()), 8, 9);
    checkRange(Source.BASE_TABLE, KeyRange.closedOpen(Key.of(), Key.of("k11")), 0, 1, 10);
    checkRange(Source.BASE_TABLE, KeyRange.closedClosed(Key.of(), Key.of("k11")), 0, 1, 10, 11);

    // The following produce empty ranges.
    // TODO(user): Consider a multi-part key to illustrate partial key behavior.
    checkRange(Source.BASE_TABLE, KeyRange.closedOpen(Key.of("k7"), Key.of()));
    checkRange(Source.BASE_TABLE, KeyRange.openOpen(Key.of("k7"), Key.of()));
    checkRange(Source.BASE_TABLE, KeyRange.openOpen(Key.of(), Key.of("k11")));
    checkRange(Source.BASE_TABLE, KeyRange.openClosed(Key.of(), Key.of("k11")));

    // Prefix is component-wise, not string prefix.
    checkRange(Source.BASE_TABLE, KeyRange.prefix(Key.of("k1")), 1);
    checkRange(
        Source.BASE_TABLE, KeyRange.closedOpen(Key.of("k1"), Key.of("k2")), 1, 10, 11, 12, 13, 14);

    checkRange(Source.BASE_TABLE, KeySet.all(), 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
  }

  @Test
  public void limitRead() {
    checkRangeWithLimit(
        Source.BASE_TABLE, 2, KeyRange.closedClosed(Key.of("k3"), Key.of("k7")), 3, 4);
    checkRangeWithLimit(
        Source.BASE_TABLE, 0, KeyRange.closedClosed(Key.of("k3"), Key.of("k7")), 3, 4, 5, 6, 7);
  }

  @Test
  public void indexRangeReads() {
    checkRange(Source.INDEX, KeySet.singleKey(Key.of("v1")), 1);
    checkRange(Source.INDEX, KeyRange.closedOpen(Key.of("v3"), Key.of("v5")), 3, 4);
    checkRange(Source.INDEX, KeyRange.closedClosed(Key.of("v3"), Key.of("v5")), 3, 4, 5);
    checkRange(Source.INDEX, KeyRange.openClosed(Key.of("v3"), Key.of("v5")), 4, 5);
    checkRange(Source.INDEX, KeyRange.openOpen(Key.of("v3"), Key.of("v5")), 4);

    // Partial key specification.
    checkRange(Source.INDEX, KeyRange.closedClosed(Key.of("v7"), Key.of()), 7, 8, 9);
    checkRange(Source.INDEX, KeyRange.openClosed(Key.of("v7"), Key.of()), 8, 9);
    checkRange(Source.INDEX, KeyRange.closedOpen(Key.of(), Key.of("v11")), 0, 1, 10);
    checkRange(Source.INDEX, KeyRange.closedClosed(Key.of(), Key.of("v11")), 0, 1, 10, 11);

    // The following produce empty ranges.
    checkRange(Source.INDEX, KeyRange.closedOpen(Key.of("v7"), Key.of()));
    checkRange(Source.INDEX, KeyRange.openOpen(Key.of("v7"), Key.of()));
    checkRange(Source.INDEX, KeyRange.openOpen(Key.of(), Key.of("v11")));
    checkRange(Source.INDEX, KeyRange.openClosed(Key.of(), Key.of("v11")));

    // Prefix is component-wise, not string prefix.
    checkRange(Source.INDEX, KeyRange.prefix(Key.of("v1")), 1);
    checkRange(
        Source.INDEX, KeyRange.closedOpen(Key.of("v1"), Key.of("v2")), 1, 10, 11, 12, 13, 14);
    checkRange(Source.INDEX, KeySet.all(), 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

    // Read from an index with DESC ordering.
    checkRange(Source.DESC_INDEX, KeySet.all(), 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
  }

  @Test
  public void limitReadUsingIndex() {
    checkRangeWithLimit(Source.INDEX, 2, KeyRange.closedClosed(Key.of("v3"), Key.of("v7")), 3, 4);
    checkRangeWithLimit(
        Source.DESC_INDEX, 2, KeyRange.closedClosed(Key.of("v7"), Key.of("v3")), 7, 6);
  }

  @Test
  public void multiPointRead() {
    KeySet keys =
        KeySet.newBuilder().addKey(Key.of("k3")).addKey(Key.of("k5")).addKey(Key.of("k7")).build();
    checkRange(Source.BASE_TABLE, keys, 3, 5, 7);
  }

  @Test
  public void indexMultiPointRead() {
    KeySet keys =
        KeySet.newBuilder().addKey(Key.of("v3")).addKey(Key.of("v5")).addKey(Key.of("v7")).build();
    checkRange(Source.INDEX, keys, 3, 5, 7);
  }

  @Test
  public void rowsAreSnapshots() {
    List<Struct> rows = new ArrayList<>();
    ResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .read(
                TABLE_NAME,
                KeySet.newBuilder()
                    .addKey(Key.of("k2"))
                    .addKey(Key.of("k3"))
                    .addKey(Key.of("k4"))
                    .build(),
                ALL_COLUMNS);
    while (resultSet.next()) {
      rows.add(resultSet.getCurrentRowAsStruct());
    }

    assertThat(rows.size()).isEqualTo(3);
    assertThat(rows.get(0).getString(0)).isEqualTo("k2");
    assertThat(rows.get(0).getString(1)).isEqualTo("v2");
    assertThat(rows.get(1).getString(0)).isEqualTo("k3");
    assertThat(rows.get(1).getString(1)).isEqualTo("v3");
    assertThat(rows.get(2).getString(0)).isEqualTo("k4");
    assertThat(rows.get(2).getString(1)).isEqualTo("v4");
  }

  @Test
  public void invalidDatabase() {
    RemoteSpannerHelper helper = env.getTestHelper();
    DatabaseClient invalidClient =
        helper
            .getClient()
            .getDatabaseClient(
                DatabaseId.of(helper.getInstanceId(), "invalid"));
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    invalidClient
        .singleUse(TimestampBound.strong())
        .readRow(TABLE_NAME, Key.of("k99"), ALL_COLUMNS);
  }

  @Test
  public void tableNotFound() {
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    expectedException.expectMessage("BadTableName");
    client.singleUse(TimestampBound.strong()).readRow("BadTableName", Key.of("k1"), ALL_COLUMNS);
  }

  @Test
  public void columnNotFound() {
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    expectedException.expectMessage("BadColumnName");
    client
        .singleUse(TimestampBound.strong())
        .readRow(TABLE_NAME, Key.of("k1"), Arrays.asList("Key", "BadColumnName"));
  }

  @Test
  public void cursorErrorDeferred() {
    // Error should be deferred until next().  This gives consistent behavior with respect to
    // non-blocking implementations (e.g., gRPC).
    ResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .read("BadTableName", KeySet.singleKey(Key.of("k1")), ALL_COLUMNS);

    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    expectedException.expectMessage("BadTableName");
    resultSet.next();
  }

  @Test
  public void cancellation() {
    Context.CancellableContext context = Context.current().withCancellation();
    Runnable work =
        context.wrap(
            new Runnable() {
              @Override
              public void run() {
                client
                    .singleUse(TimestampBound.strong())
                    .readRow(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
              }
            });
    context.cancel(new RuntimeException("Cancelled by test"));

    try {
      work.run();
    } catch (SpannerException e) {
      MatcherAssert.assertThat(e, isSpannerException(ErrorCode.CANCELLED));
    }
  }

  @Test
  public void deadline() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    Context.CancellableContext context =
        Context.current().withDeadlineAfter(10, TimeUnit.NANOSECONDS, executor);
    Runnable work =
        context.wrap(
            new Runnable() {
              @Override
              public void run() {
                client
                    .singleUse(TimestampBound.strong())
                    .readRow(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
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

  private enum Source {
    BASE_TABLE,
    INDEX,
    DESC_INDEX,
  }

  private void checkReadRange(Source source, KeySet keySet, long limit, int[] expectedRows) {
    Map<String, String> expected = new LinkedHashMap<>();
    for (int expectedRow : expectedRows) {
      expected.put("k" + expectedRow, "v" + expectedRow);
    }

    ResultSet resultSet;
    switch (source) {
      case INDEX:
        resultSet =
            limit != 0
                ? client
                    .singleUse(TimestampBound.strong())
                    .readUsingIndex(
                        TABLE_NAME, INDEX_NAME, keySet, ALL_COLUMNS, Options.limit(limit))
                : client
                    .singleUse(TimestampBound.strong())
                    .readUsingIndex(TABLE_NAME, INDEX_NAME, keySet, ALL_COLUMNS);
        break;
      case DESC_INDEX:
        resultSet =
            limit != 0
                ? client
                    .singleUse(TimestampBound.strong())
                    .readUsingIndex(
                        TABLE_NAME, DESC_INDEX_NAME, keySet, ALL_COLUMNS, Options.limit(limit))
                : client
                    .singleUse(TimestampBound.strong())
                    .readUsingIndex(TABLE_NAME, DESC_INDEX_NAME, keySet, ALL_COLUMNS);
        break;
      case BASE_TABLE:
        resultSet =
            limit != 0
                ? client
                    .singleUse(TimestampBound.strong())
                    .read(TABLE_NAME, keySet, ALL_COLUMNS, Options.limit(limit))
                : client.singleUse(TimestampBound.strong()).read(TABLE_NAME, keySet, ALL_COLUMNS);
        break;
      default:
        throw new IllegalArgumentException("Invalid source");
    }
    Map<String, String> rows = new LinkedHashMap<>();
    while (resultSet.next()) {
      rows.put(resultSet.getString(0), resultSet.getString(1));
    }

    assertThat(rows).named("read of " + keySet).isEqualTo(expected);
  }

  private void checkRange(Source source, KeyRange range, int... expectedRows) {
    checkRange(source, KeySet.range(range), expectedRows);
  }

  private void checkRange(Source source, KeySet keySet, int... expectedRows) {
    checkReadRange(source, keySet, 0, expectedRows);
  }

  private void checkRangeWithLimit(Source source, long limit, KeyRange range, int... expectedRows) {
    checkReadRange(source, KeySet.range(range), limit, expectedRows);
  }
}
