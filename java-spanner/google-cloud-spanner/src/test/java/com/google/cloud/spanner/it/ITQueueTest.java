/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.*;
import com.google.cloud.spanner.connection.ConnectionOptions;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/** Integration test for Cloud Spanner Queue. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITQueueTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    return params;
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  private static DatabaseClient googleStandardSQLClient;

  private static final String[] GOOGLE_STANDARD_SQL_SCHEMA =
      new String[] {
        "CREATE Queue Q1 ("
            + "  Id INT64 NOT NULL,"
            + "  Payload BYTES(MAX) NOT NULL,"
            + ") PRIMARY KEY (Id), "
            + "OPTIONS (receive_mode = 'PULL')",
        "CREATE TABLE T1 ("
            + "  K1                  INT64 NOT NULL,"
            + "  K                   INT64 NOT NULL,"
            + ") PRIMARY KEY (K1)"
      };

  private static DatabaseClient client;

  private Struct readRow(String queue, Key key, String... columns) {
    return client.singleUse(TimestampBound.strong()).readRow(queue, key, Arrays.asList(columns));
  }

  @BeforeClass
  public static void setUpTestSuite() {
    // TODO: remove once the feature is fully enabled in prod
    assumeTrue("Queue tests are temporarily disabled", false);
    Database googleStandardSQLDatabase =
        env.getTestHelper().createTestDatabase(GOOGLE_STANDARD_SQL_SCHEMA);
    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);
    System.out.println("Database created");
  }

  @Before
  public void setUp() {
    // TODO: add postgres schema & client after feature is enabled
    client = googleStandardSQLClient;
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @Test
  public void testSendAndAckMutation() {
    client.write(
        Arrays.asList(
            Mutation.newSendBuilder("Q1")
                .setKey(Key.of(1))
                .setPayload(Value.bytes(ByteArray.copyFrom("payload1")))
                .build(),
            Mutation.newSendBuilder("Q1")
                .setKey(Key.of(2))
                .setPayload(Value.bytes(ByteArray.copyFrom("payload2")))
                .build(),
            Mutation.newSendBuilder("Q1")
                .setKey(Key.of(3))
                .setPayload(Value.bytes(ByteArray.copyFrom("payload3")))
                .setDeliveryTime(Instant.now())
                .build()));

    // Verifying messages are in the queue.
    Struct row = readRow("Q1", Key.of(1), "Payload");
    assertThat(row == null).isFalse();
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("payload1"));

    row = readRow("Q1", Key.of(2), "Payload");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("payload2"));

    row = readRow("Q1", Key.of(3), "Payload");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("payload3"));

    // Ack-ing the first two messages.
    client.write(
        Arrays.asList(
            Mutation.newAckBuilder("Q1").setKey(Key.of(1)).build(),
            Mutation.newAckBuilder("Q1").setKey(Key.of(2)).build()));

    // Verifying the first 2 messages are acked and remvoed from the queue
    row = readRow("Q1", Key.of(1), "Payload");
    assertThat(row == null).isTrue();
    row = readRow("Q1", Key.of(2), "Payload");
    assertThat(row == null).isTrue();
    row = readRow("Q1", Key.of(3), "Payload");
    assertThat(row.isNull(0)).isFalse();
    assertThat(row.getBytes(0)).isEqualTo(ByteArray.copyFrom("payload3"));
  }

  @Test
  public void testAckNotFound() {
    // Enable IgnoreNotFound.
    client.write(
        Collections.singletonList(
            Mutation.newAckBuilder("Q1").setKey(Key.of(1)).setIgnoreNotFound(true).build()));
    Struct row = readRow("Q1", Key.of(1), "Payload");
    assertThat(row == null).isTrue();

    // Disable IgnoreNotFound.
    SpannerException thrown =
        assertThrows(
            SpannerException.class,
            () ->
                client.write(
                    Collections.singletonList(
                        Mutation.newAckBuilder("Q1")
                            .setKey(Key.of(1))
                            .setIgnoreNotFound(false)
                            .build())));
    assertThat(thrown).hasMessageThat().contains("NOT_FOUND: Message not found");
  }
}
