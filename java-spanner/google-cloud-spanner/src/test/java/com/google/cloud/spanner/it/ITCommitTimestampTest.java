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

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration test for commit timestamp of Cloud Spanner. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITCommitTimestampTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  private static DatabaseClient client;
  private static DatabaseAdminClient dbAdminClient;
  private static RemoteSpannerHelper testHelper;
  private static String instanceId;
  private static String databaseId;

  @BeforeClass
  public static void setUp() {
    testHelper = env.getTestHelper();
    db =
        testHelper.createTestDatabase(
            "CREATE TABLE T ("
                + "K  STRING(MAX) NOT NULL,"
                + "T1   TIMESTAMP OPTIONS (allow_commit_timestamp = true),"
                + "T2   TIMESTAMP OPTIONS (allow_commit_timestamp = true),"
                + "T3   TIMESTAMP,"
                + ") PRIMARY KEY (K)");
    client = testHelper.getDatabaseClient(db);
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
    instanceId = testHelper.getInstanceId().getInstance();
    databaseId = db.getId().getDatabase();
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @After
  public void deleteAllTestRecords() {
    client.write(ImmutableList.of(Mutation.delete("T", KeySet.all())));
  }

  private Timestamp write(Mutation m) {
    return client.write(Collections.singletonList(m));
  }

  private Struct readRow(DatabaseClient client, String table, Key key, String... columns) {
    return client.singleUse(TimestampBound.strong()).readRow(table, key, Arrays.asList(columns));
  }

  @Test
  public void writeCommitTimestamp() {
    // 1. timestamps auto populated and returned should be the same
    Timestamp commitTimestamp =
        write(
            Mutation.newInsertOrUpdateBuilder("T")
                .set("K")
                .to("a")
                .set("T1")
                .to(Value.COMMIT_TIMESTAMP)
                .set("T2")
                .to(Value.COMMIT_TIMESTAMP)
                .build());
    Struct row = readRow(client, "T", Key.of("a"), "T1", "T2");
    assertThat(row.getTimestamp(0)).isEqualTo(commitTimestamp);
    assertThat(row.getTimestamp(1)).isEqualTo(commitTimestamp);

    // 2. attempt to write CommitTimestamp to not enabled column should fail
    // error_catalog error CommitTimestampOptionNotEnabled
    try {
      write(
          Mutation.newInsertOrUpdateBuilder("T")
              .set("K")
              .to("a")
              .set("T3")
              .to(Value.COMMIT_TIMESTAMP)
              .build());
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void consistency() {
    // 1. timestamps populated are consistent in order
    write(
        Mutation.newInsertOrUpdateBuilder("T")
            .set("K")
            .to("a")
            .set("T1")
            .to(Value.COMMIT_TIMESTAMP)
            .build());
    write(
        Mutation.newInsertOrUpdateBuilder("T")
            .set("K")
            .to("b")
            .set("T1")
            .to(Value.COMMIT_TIMESTAMP)
            .build());
    Struct row1 = readRow(client, "T", Key.of("a"), "T1");
    Struct row2 = readRow(client, "T", Key.of("b"), "T1");
    assertThat(row2.getTimestamp(0)).isGreaterThan(row1.getTimestamp(0));
  }

  @Test
  public void schemaChangeTimestampInFuture() throws Exception {
    write(
        Mutation.newInsertOrUpdateBuilder("T")
            .set("K")
            .to("a")
            .set("T3")
            .to(Timestamp.MAX_VALUE)
            .build());

    // error_catalog error CommitTimestampNotInFuture
    String statement = "ALTER TABLE T ALTER COLUMN T3 SET OPTIONS (allow_commit_timestamp=true)";
    try {
      dbAdminClient
          .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(statement), null)
          .get();
      fail("missing expected exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void insertTimestampInFuture() {
    // error_catalog error TimestampInFuture
    try {
      write(
          Mutation.newInsertOrUpdateBuilder("T")
              .set("K")
              .to("a")
              .set("T1")
              .to(Timestamp.MAX_VALUE)
              .build());
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void invalidColumnOption() throws Exception {
    // error_catalog error DDLStatementWithError
    String statement = "ALTER TABLE T ALTER COLUMN T3 SET OPTIONS (bogus=null)";
    try {
      dbAdminClient
          .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(statement), null)
          .get();
      fail("missing expected exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void invalidColumnOptionValue() throws Exception {
    // error_catalog error DDLStatementWithErrors
    String statement = "ALTER TABLE T ALTER COLUMN T3 SET OPTIONS (allow_commit_timestamp=bogus)";
    try {
      dbAdminClient
          .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(statement), null)
          .get();
      fail("missing expected exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void invalidColumnType() throws Exception {
    assumeFalse(
        "Validation currently not available in experimental host mode - tracked via b/442339325",
        isExperimentalHost());
    // error_catalog error OptionErrorList
    String statement = "ALTER TABLE T ADD COLUMN T4 INT64 OPTIONS (allow_commit_timestamp=true)";
    try {
      dbAdminClient
          .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(statement), null)
          .get();
      fail("missing expected exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  private void alterColumnOption(String databaseId, String table, String opt) throws Exception {
    String statement =
        "ALTER TABLE "
            + table
            + " ALTER COLUMN ts"
            + " SET OPTIONS (allow_commit_timestamp="
            + opt
            + ")";
    dbAdminClient
        .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(statement), null)
        .get();
  }

  private void writeAndVerify(DatabaseClient client, Timestamp ts) {
    Timestamp commitTimestamp =
        client.write(
            Arrays.asList(
                Mutation.newInsertOrUpdateBuilder("T1").set("ts").to(ts).build(),
                Mutation.newInsertOrUpdateBuilder("T2").set("ts").to(ts).build(),
                Mutation.newInsertOrUpdateBuilder("T3").set("ts").to(ts).build()));
    if (ts == Value.COMMIT_TIMESTAMP) {
      ts = commitTimestamp;
    }
    assertThat(readRow(client, "T1", Key.of(ts), "ts").getTimestamp(0)).isEqualTo(ts);
    assertThat(readRow(client, "T2", Key.of(ts), "ts").getTimestamp(0)).isEqualTo(ts);
    assertThat(readRow(client, "T3", Key.of(ts), "ts").getTimestamp(0)).isEqualTo(ts);
  }

  // 1) Write timestamps in the past
  // 2) Set all interleaved tables allow_commit_timestamp=true
  // 3) Use commit timestamp in all tables
  // 4) Set all interleaved tables allow_commit_timestamp=null
  // 5) Write timestamps in the future
  @Test
  public void interleavedTable() throws Exception {
    Database db =
        testHelper.createTestDatabase(
            "CREATE TABLE T1 (ts TIMESTAMP) PRIMARY KEY (ts)",
            "CREATE TABLE T2 (ts TIMESTAMP) PRIMARY KEY (ts), INTERLEAVE IN PARENT T1",
            "CREATE TABLE T3 (ts TIMESTAMP) PRIMARY KEY (ts), INTERLEAVE IN PARENT T2");
    DatabaseClient client = testHelper.getDatabaseClient(db);
    String databaseId = db.getId().getDatabase();

    Timestamp timeNow = Timestamp.ofTimeMicroseconds(Instant.now().toEpochMilli() * 1000);
    Timestamp timeFuture =
        Timestamp.ofTimeMicroseconds(
            Instant.now().plus(Duration.ofDays(300)).toEpochMilli() * 1000);

    writeAndVerify(client, timeNow);

    alterColumnOption(databaseId, "T1", "true");
    alterColumnOption(databaseId, "T2", "true");
    alterColumnOption(databaseId, "T3", "true");
    writeAndVerify(client, Value.COMMIT_TIMESTAMP);

    alterColumnOption(databaseId, "T1", "null");
    alterColumnOption(databaseId, "T2", "null");
    alterColumnOption(databaseId, "T3", "null");
    writeAndVerify(client, timeFuture);
  }

  // In interleaved table, use of commit timestamp in child table is not allowed
  // if parent tables are not allow_commit_timestamp=true
  @Test
  public void interleavedTableHierarchy1() {
    Database db =
        testHelper.createTestDatabase(
            "CREATE TABLE T1 (ts TIMESTAMP) PRIMARY KEY (ts)",
            "CREATE TABLE T2 (ts TIMESTAMP) PRIMARY KEY (ts), INTERLEAVE IN PARENT T1",
            "CREATE TABLE T3 (ts TIMESTAMP OPTIONS (allow_commit_timestamp = true)) "
                + "PRIMARY KEY (ts), INTERLEAVE IN PARENT T2");
    DatabaseClient client = testHelper.getDatabaseClient(db);

    // error_catalog error CommitTimestampOptionNotEnabled
    try {
      client.write(
          Collections.singletonList(
              Mutation.newInsertOrUpdateBuilder("T3")
                  .set("ts")
                  .to(Value.COMMIT_TIMESTAMP)
                  .build()));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  // In interleaved table, use of commit timestamp in parent table is not
  // allowed if child tables are not allow_commit_timestamp=true
  @Test
  public void interleavedTableHierarchy2() {
    Database db =
        testHelper.createTestDatabase(
            "CREATE TABLE T1 (ts TIMESTAMP OPTIONS (allow_commit_timestamp = true)) "
                + "PRIMARY KEY (ts)",
            "CREATE TABLE T2 (ts TIMESTAMP) PRIMARY KEY (ts), INTERLEAVE IN PARENT T1",
            "CREATE TABLE T3 (ts TIMESTAMP OPTIONS (allow_commit_timestamp = true)) "
                + "PRIMARY KEY (ts), INTERLEAVE IN PARENT T2");
    DatabaseClient client = testHelper.getDatabaseClient(db);

    // error_catalog error CommitTimestampOptionNotEnabled
    try {
      client.write(
          Collections.singletonList(
              Mutation.newInsertOrUpdateBuilder("T1")
                  .set("ts")
                  .to(Value.COMMIT_TIMESTAMP)
                  .build()));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }
}
