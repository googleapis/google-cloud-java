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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration tests for read-only transactions. For various reasons, it's not possible to test all
 * concurrency modes with high confidence using a black-box test. For example, it's legal for
 * min-read-timestamp to return the same data that exact-timestamp would, so these cases cannot be
 * distinguished. Hence, these integration tests only minimally verify that read-only transactions
 * work at all, and unit tests are relied on for validating that modes are encoded correctly.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITReadOnlyTxnTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";
  private static DatabaseClient sharedClient;
  private static List<History> sharedHistory;
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private List<History> history;
  private DatabaseClient client;

  private static class History {
    private final Timestamp timestamp;
    private final String value;
    private final long minCommitNanoTime;

    private History(Timestamp timestamp, String value, long minCommitNanoTime) {
      this.timestamp = timestamp;
      this.value = value;
      this.minCommitNanoTime = minCommitNanoTime;
    }
  }

  @BeforeClass
  public static void setUpSharedDatabase() {
    ImmutableList.Builder<History> historyBuilder = ImmutableList.builder();
    sharedClient = newTestDatabase(historyBuilder);
    sharedHistory = historyBuilder.build();
  }

  private static DatabaseClient newTestDatabase(ImmutableList.Builder<History> historyBuilder) {
    Database newDb =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ( StringValue STRING(MAX) ) PRIMARY KEY ()");
    DatabaseClient newClient = env.getTestHelper().getDatabaseClient(newDb);
    for (int i = 0; i < 5; ++i) {
      writeNewValue(newClient, i, historyBuilder);
    }
    return newClient;
  }

  private static void writeNewValue(
      DatabaseClient client, int i, @Nullable ImmutableList.Builder<History> historyBuilder) {
    String value = "v" + i;
    Mutation m = Mutation.newInsertOrUpdateBuilder(TABLE_NAME).set("StringValue").to(value).build();
    long minCommitNanoTime = System.nanoTime();
    Timestamp timestamp = client.writeAtLeastOnce(Arrays.asList(m));
    if (historyBuilder != null) {
      historyBuilder.add(new History(timestamp, value, minCommitNanoTime));
    }
  }

  @Before
  public void setUp() {
    history = sharedHistory;
    client = sharedClient;
  }

  private static Struct readRow(ReadContext ctx) {
    return ctx.readRow(TABLE_NAME, Key.of(), Arrays.asList("StringValue"));
  }

  private static Struct queryRow(ReadContext ctx) {
    ResultSet resultSet = Statement.of("SELECT StringValue FROM TestTable").executeQuery(ctx);
    // TODO(user): Consider a library routine to consume a single row from a query.
    assertThat(resultSet.next()).isTrue();
    Struct row = resultSet.getCurrentRowAsStruct();
    assertThat(resultSet.next()).isFalse();
    return row;
  }

  @Test
  public void singleStrong() {
    History expected = history.get(history.size() - 1);

    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction();
    Struct row = readRow(readContext);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
    assertThat(readContext.getReadTimestamp()).isAtLeast(expected.timestamp);

    row = readRow(client.singleUse());
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
  }

  @Test
  public void singleReadTimestamp() {
    History expected = history.get(2);

    TimestampBound bound = TimestampBound.ofReadTimestamp(expected.timestamp);
    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction(bound);
    Struct row = readRow(readContext);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
    assertThat(readContext.getReadTimestamp()).isEqualTo(expected.timestamp);

    row = readRow(client.singleUse(bound));
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
  }

  @Test
  public void query() {
    // We don't exhaustively test query with all modes - the read tests give us enough confidence
    // that transaction options are generated appropriately.  Just do one test for each type of
    // context to ensure that transaction options are set at all.
    History expected = history.get(2);

    TimestampBound bound = TimestampBound.ofReadTimestamp(expected.timestamp);
    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction(bound);
    Struct row = queryRow(readContext);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
    assertThat(readContext.getReadTimestamp()).isEqualTo(expected.timestamp);

    readContext = client.readOnlyTransaction(bound);
    row = queryRow(readContext);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
    assertThat(readContext.getReadTimestamp()).isEqualTo(expected.timestamp);
    readContext.close();

    row = queryRow(client.singleUse(bound));
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo(expected.value);
  }

  @Test
  public void singleMinReadTimestamp() {
    int minimumIndex = 2;
    History minimum = history.get(minimumIndex);
    NavigableMap<Timestamp, String> possibleValues = new TreeMap<>();
    for (History item : history.subList(minimumIndex, history.size())) {
      possibleValues.put(item.timestamp, item.value);
    }

    TimestampBound bound = TimestampBound.ofMinReadTimestamp(minimum.timestamp);
    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction(bound);
    Struct row = readRow(readContext);
    assertThat(row).isNotNull();
    assertThat(readContext.getReadTimestamp()).isAtLeast(minimum.timestamp);
    assertThat(row.getString(0))
        .isEqualTo(possibleValues.floorEntry(readContext.getReadTimestamp()).getValue());

    row = readRow(client.singleUse(bound));
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isIn(possibleValues.values());
  }

  @Test
  public void singleExactStaleness() {
    // TODO(user): Use a shorter deadline (when supported) and pass on the call to Cloud Spanner.
    long deadlineNanoTime = System.nanoTime() + TimeUnit.MINUTES.toNanos(1);

    // The only exact staleness values that can be tested reliably are before the first item or
    // later than the last item: we choose the former.
    //
    // Pick a staleness that is "guaranteed" not to observe the first write.  Note that this
    // guarantee doesn't strictly hold in the absence of enforced read deadlines, but we use a
    // deadline large enough to make it practically true.
    long stalenessNanos = 1 + deadlineNanoTime - history.get(0).minCommitNanoTime;
    TimestampBound bound = TimestampBound.ofExactStaleness(stalenessNanos, TimeUnit.NANOSECONDS);
    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction(bound);
    Struct row = readRow(readContext);
    assertThat(row).isNull();
    assertThat(readContext.getReadTimestamp().toSqlTimestamp())
        .isLessThan(history.get(0).timestamp.toSqlTimestamp());

    row = readRow(client.singleUse(bound));
    assertThat(row).isNull();
  }

  @Test
  public void singleMaxStaleness() {
    History minimum = history.get(2);
    NavigableMap<Timestamp, String> possibleValues = new TreeMap<>();
    for (History item : history.subList(2, history.size())) {
      possibleValues.put(item.timestamp, item.value);
    }

    // Pick a staleness that cannot precede the second write (which, in practice, is the staleness
    // that exceeds the minimum commit time for the subsequent write).
    long stalenessNanos = System.nanoTime() - history.get(3).minCommitNanoTime;
    TimestampBound bound = TimestampBound.ofMaxStaleness(stalenessNanos, TimeUnit.NANOSECONDS);
    ReadOnlyTransaction readContext = client.singleUseReadOnlyTransaction(bound);

    Struct row = readRow(readContext);
    assertThat(row).isNotNull();
    assertThat(readContext.getReadTimestamp()).isAtLeast(minimum.timestamp);
    assertThat(row.getString(0))
        .isEqualTo(possibleValues.floorEntry(readContext.getReadTimestamp()).getValue());

    row = readRow(client.singleUse(bound));
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isIn(possibleValues.values());
  }

  private void setUpPrivateDatabase() {
    ImmutableList.Builder<History> historyBuilder = ImmutableList.builder();
    client = newTestDatabase(historyBuilder);
    history = historyBuilder.build();
  }

  private void insertAndReadAgain(
      ReadOnlyTransaction readContext,
      Timestamp expectedTimestamp,
      @Nullable String expectedValue) {
    writeNewValue(client, history.size(), null);

    Struct row = readRow(readContext);
    if (expectedValue == null) {
      assertThat(row).isNull();
    } else {
      assertThat(row).isNotNull();
      assertThat(row.getString(0)).isEqualTo(expectedValue);
    }
    assertThat(readContext.getReadTimestamp()).isEqualTo(expectedTimestamp);
  }

  @Test
  public void multiStrong() {
    setUpPrivateDatabase();

    History expected = history.get(history.size() - 1);

    try (ReadOnlyTransaction readContext = client.readOnlyTransaction()) {
      Struct row = readRow(readContext);
      assertThat(row).isNotNull();
      assertThat(row.getString(0)).isEqualTo(expected.value);
      assertThat(readContext.getReadTimestamp()).isAtLeast(expected.timestamp);
      insertAndReadAgain(readContext, readContext.getReadTimestamp(), expected.value);
    }
  }

  @Test
  public void multiReadTimestamp() {
    setUpPrivateDatabase();

    History expected = history.get(2);

    try (ReadOnlyTransaction readContext =
        client.readOnlyTransaction(TimestampBound.ofReadTimestamp(expected.timestamp))) {
      Struct row = readRow(readContext);
      assertThat(row).isNotNull();
      assertThat(row.getString(0)).isEqualTo(expected.value);
      assertThat(readContext.getReadTimestamp()).isEqualTo(expected.timestamp);

      insertAndReadAgain(readContext, readContext.getReadTimestamp(), expected.value);
    }
  }

  @Test
  public void multiMinReadTimestamp() {
    // Cannot use bounded modes with multi-read transactions.
    expectedException.expect(IllegalArgumentException.class);
    client.readOnlyTransaction(TimestampBound.ofMinReadTimestamp(history.get(2).timestamp));
  }

  @Test
  public void multiExactStaleness() {
    setUpPrivateDatabase();

    // See singleExactStaleness() for why we pick this timestamp.  We expect to see no value.
    long deadlineNanoTime = System.nanoTime() + TimeUnit.MINUTES.toNanos(1);
    long stalenessNanos = 1 + deadlineNanoTime - history.get(0).minCommitNanoTime;

    try (ReadOnlyTransaction readContext =
        client.readOnlyTransaction(
            TimestampBound.ofExactStaleness(stalenessNanos, TimeUnit.NANOSECONDS))) {
      Struct row = readRow(readContext);
      assertThat(row).isNull();
      assertThat(readContext.getReadTimestamp().toSqlTimestamp())
          .isLessThan(history.get(0).timestamp.toSqlTimestamp());

      insertAndReadAgain(readContext, readContext.getReadTimestamp(), null);
    }
  }

  @Test
  public void multiMaxStaleness() {
    // Cannot use bounded modes with multi-read transactions.
    expectedException.expect(IllegalArgumentException.class);
    client.readOnlyTransaction(TimestampBound.ofMaxStaleness(1, TimeUnit.SECONDS));
  }
}
