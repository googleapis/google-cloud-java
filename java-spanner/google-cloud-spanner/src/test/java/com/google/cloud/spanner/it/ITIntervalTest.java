/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.*;
import com.google.cloud.spanner.connection.ConnectionOptions;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITIntervalTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    return Arrays.asList(
        new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL),
        new DialectTestParameter(Dialect.POSTGRESQL));
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;

  private static final String[] GOOGLE_STANDARD_SQL_SCHEMA =
      new String[] {
        "CREATE TABLE IntervalTable (\n"
            + "  key STRING(MAX),\n"
            + "  create_time TIMESTAMP,\n"
            + "  expiry_time TIMESTAMP,\n"
            + "  expiry_within_month bool AS (expiry_time - create_time < INTERVAL 30 DAY),\n"
            + "  interval_array_len INT64 AS (ARRAY_LENGTH(ARRAY<INTERVAL>[INTERVAL '1-2 3 4:5:6'"
            + " YEAR TO SECOND]))\n"
            + ") PRIMARY KEY (key)"
      };

  private static final String[] POSTGRESQL_SCHEMA =
      new String[] {
        "CREATE TABLE IntervalTable (\n"
            + "  key text primary key,\n"
            + "  create_time timestamptz,\n"
            + "  expiry_time timestamptz,\n"
            + "  expiry_within_month bool GENERATED ALWAYS AS (expiry_time - create_time < INTERVAL"
            + " '30' DAY) STORED,\n"
            + "  interval_array_len bigint GENERATED ALWAYS AS (ARRAY_LENGTH(ARRAY[INTERVAL '1-2 3"
            + " 4:5:6'], 1)) STORED\n"
            + ")"
      };

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
  public static void tearDown() throws Exception {
    ConnectionOptions.closeSpanner();
  }

  /** Sequence used to generate unique keys. */
  private static int seq;

  private static String uniqueString() {
    return String.format("k%04d", seq++);
  }

  private String lastKey;

  private Timestamp write(Mutation m) {
    return client.write(Collections.singletonList(m));
  }

  private Mutation.WriteBuilder baseInsert() {
    return Mutation.newInsertOrUpdateBuilder("IntervalTable")
        .set("Key")
        .to(lastKey = uniqueString());
  }

  @Test
  public void writeToTableWithIntervalExpressions() {
    write(
        baseInsert()
            .set("create_time")
            .to(Timestamp.parseTimestamp("2004-11-30T04:53:54Z"))
            .set("expiry_time")
            .to(Timestamp.parseTimestamp("2004-12-15T04:53:54Z"))
            .build());
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT expiry_within_month, interval_array_len FROM IntervalTable WHERE key='"
                        + lastKey
                        + "'"))) {
      assertTrue(resultSet.next());
      assertTrue(resultSet.getBoolean(0));
      assertEquals(1, resultSet.getLong(1));
    }
  }

  @Test
  public void queryInterval() {
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(Statement.of("SELECT INTERVAL '1' DAY + INTERVAL '1' MONTH AS Col1"))) {
      assertTrue(resultSet.next());
      assertEquals(resultSet.getInterval(0), Interval.fromMonthsDaysNanos(1, 1, BigInteger.ZERO));
    }
  }

  @Test
  public void queryWithIntervalParam() {
    write(
        baseInsert()
            .set("create_time")
            .to(Timestamp.parseTimestamp("2004-08-30T04:53:54Z"))
            .set("expiry_time")
            .to(Timestamp.parseTimestamp("2004-12-15T04:53:54Z"))
            .build());

    String query;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      query =
          "SELECT COUNT(*) FROM IntervalTable WHERE create_time < TIMESTAMPTZ"
              + " '2004-11-30T10:23:54+0530' - $1";
    } else {
      query =
          "SELECT COUNT(*) FROM IntervalTable WHERE create_time <"
              + " TIMESTAMP('2004-11-30T10:23:54+0530') - @p1";
    }

    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.newBuilder(query)
                    .bind("p1")
                    .to(Value.interval(Interval.ofDays(30)))
                    .build())) {
      assertTrue(resultSet.next());
      assertEquals(resultSet.getLong(0), 1L);
    }
  }

  @Test
  public void queryWithIntervalArrayParam() {
    String query;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      query = "SELECT $1";
    } else {
      query = "SELECT @p1";
    }

    List<Interval> intervalList =
        Arrays.asList(
            Interval.parseFromString("P1Y2M3DT4H5M6.789123S"),
            null,
            Interval.parseFromString("P-1Y-2M-3DT-4H-5M-6.789123S"),
            null);

    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.newBuilder(query)
                    .bind("p1")
                    .to(Value.intervalArray(intervalList))
                    .build())) {
      assertTrue(resultSet.next());
      assertEquals(resultSet.getIntervalList(0), intervalList);
    }
  }

  @Test
  public void queryWithUntypedIntervalParam() {
    String query;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      query = "SELECT (INTERVAL '1' DAY > $1) AS Col1";
    } else {
      query = "SELECT (INTERVAL '1' DAY > @p1) AS Col1";
    }

    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.newBuilder(query)
                    .bind("p1")
                    .to(
                        Value.untyped(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue("PT1.5S")
                                .build()))
                    .build())) {
      assertTrue(resultSet.next());
      assertTrue(resultSet.getBoolean(0));
    }
  }

  @Test
  public void queryIntervalArray() {
    String query =
        "SELECT ARRAY[CAST('P1Y2M3DT4H5M6.789123S' AS INTERVAL), null,"
            + " CAST('P-1Y-2M-3DT-4H-5M-6.789123S' AS INTERVAL)] AS Col1";
    try (ResultSet resultSet = client.singleUse().executeQuery(Statement.of(query))) {
      assertTrue(resultSet.next());
      assertEquals(
          Arrays.asList(
              Interval.parseFromString("P1Y2M3DT4H5M6.789123S"),
              null,
              Interval.parseFromString("P-1Y-2M-3DT-4H-5M-6.789123S")),
          resultSet.getIntervalList(0));
    }
  }
}
