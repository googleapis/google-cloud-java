/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ReadRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExcludeFromChangeStreamTest extends AbstractMockServerTest {

  @BeforeClass
  public static void setupReadResult() {
    RandomResultSetGenerator generator = new RandomResultSetGenerator(10);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT my-column FROM my-table WHERE 1=1"), generator.generate()));
  }

  private Spanner createSpanner() {
    return SpannerOptions.newBuilder()
        .setProjectId("fake-project")
        .setHost("http://localhost:" + getPort())
        .setCredentials(NoCredentials.getInstance())
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .build()
        .getService();
  }

  @Test
  public void testStandardTransaction() {
    try (Spanner spanner = createSpanner()) {
      for (int i = 0; i < 10; i++) {
        DatabaseClient client =
            spanner.getDatabaseClient(
                DatabaseId.of("fake-project", "fake-instance", "fake-database"));
        client
            .readWriteTransaction(Options.tag("some-tag"), Options.excludeTxnFromChangeStreams())
            .run(
                transaction -> {
                  try (ResultSet resultSet =
                      transaction.read("my-table", KeySet.all(), ImmutableList.of("my-column"))) {
                    while (resultSet.next()) {}
                  }
                  transaction.buffer(
                      Mutation.newInsertOrUpdateBuilder("my-table")
                          .set("my-column")
                          .to(1L)
                          .build());
                  return null;
                });
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(ReadRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        ReadRequest readRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(0);
        assertTrue(readRequest.hasTransaction());
        assertTrue(readRequest.getTransaction().hasBegin());
        assertTrue(readRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(readRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
        assertNotNull(commitRequest.getTransactionId());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testTransactionAbortedDuringRead() {
    try (Spanner spanner = createSpanner()) {
      for (int i = 0; i < 10; i++) {
        DatabaseClient client =
            spanner.getDatabaseClient(
                DatabaseId.of("fake-project", "fake-instance", "fake-database"));
        AtomicBoolean hasAborted = new AtomicBoolean(false);
        client
            .readWriteTransaction(Options.tag("some-tag"), Options.excludeTxnFromChangeStreams())
            .run(
                transaction -> {
                  if (hasAborted.compareAndSet(false, true)) {
                    mockSpanner.abortNextStatement();
                  }
                  try (ResultSet resultSet =
                      transaction.read("my-table", KeySet.all(), ImmutableList.of("my-column"))) {
                    while (resultSet.next()) {}
                  }
                  transaction.buffer(
                      Mutation.newInsertOrUpdateBuilder("my-table")
                          .set("my-column")
                          .to(1L)
                          .build());
                  return null;
                });
        assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(ReadRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        BeginTransactionRequest beginRequest =
            mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
        assertTrue(beginRequest.getOptions().hasReadWrite());
        assertTrue(beginRequest.getOptions().getExcludeTxnFromChangeStreams());

        ReadRequest firstReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(0);
        assertTrue(firstReadRequest.hasTransaction());
        assertTrue(firstReadRequest.getTransaction().hasBegin());
        assertTrue(firstReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(firstReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        ReadRequest secondReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(1);
        assertTrue(secondReadRequest.hasTransaction());
        assertTrue(secondReadRequest.getTransaction().hasId());

        CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
        assertNotNull(commitRequest.getTransactionId());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testTransactionAbortedDuringCommit() {
    try (Spanner spanner = createSpanner()) {
      for (int i = 0; i < 10; i++) {
        DatabaseClient client =
            spanner.getDatabaseClient(
                DatabaseId.of("fake-project", "fake-instance", "fake-database"));
        AtomicBoolean hasAborted = new AtomicBoolean(false);
        client
            .readWriteTransaction(Options.tag("some-tag"), Options.excludeTxnFromChangeStreams())
            .run(
                transaction -> {
                  try (ResultSet resultSet =
                      transaction.read("my-table", KeySet.all(), ImmutableList.of("my-column"))) {
                    while (resultSet.next()) {}
                  }
                  if (hasAborted.compareAndSet(false, true)) {
                    mockSpanner.abortNextStatement();
                  }
                  transaction.buffer(
                      Mutation.newInsertOrUpdateBuilder("my-table")
                          .set("my-column")
                          .to(1L)
                          .build());
                  return null;
                });
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(ReadRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));

        ReadRequest firstReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(0);
        assertTrue(firstReadRequest.hasTransaction());
        assertTrue(firstReadRequest.getTransaction().hasBegin());
        assertTrue(firstReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(firstReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        ReadRequest secondReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(1);
        assertTrue(secondReadRequest.hasTransaction());
        assertTrue(secondReadRequest.getTransaction().hasBegin());
        assertTrue(secondReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(secondReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        for (CommitRequest commitRequest : mockSpanner.getRequestsOfType(CommitRequest.class)) {
          assertNotNull(commitRequest.getTransactionId());
        }
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testReadReturnsUnavailable() {

    try (Spanner spanner = createSpanner()) {
      for (int i = 0; i < 10; i++) {
        mockSpanner.setStreamingReadExecutionTime(
            SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));
        DatabaseClient client =
            spanner.getDatabaseClient(
                DatabaseId.of("fake-project", "fake-instance", "fake-database"));
        client
            .readWriteTransaction(Options.tag("some-tag"), Options.excludeTxnFromChangeStreams())
            .run(
                transaction -> {
                  try (ResultSet resultSet =
                      transaction.read("my-table", KeySet.all(), ImmutableList.of("my-column"))) {
                    while (resultSet.next()) {}
                  }
                  transaction.buffer(
                      Mutation.newInsertOrUpdateBuilder("my-table")
                          .set("my-column")
                          .to(1L)
                          .build());
                  return null;
                });
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(ReadRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        ReadRequest firstReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(0);
        assertTrue(firstReadRequest.hasTransaction());
        assertTrue(firstReadRequest.getTransaction().hasBegin());
        assertTrue(firstReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(firstReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        ReadRequest secondReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(1);
        assertTrue(secondReadRequest.hasTransaction());
        assertTrue(secondReadRequest.getTransaction().hasBegin());
        assertTrue(secondReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(secondReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
        assertNotNull(commitRequest.getTransactionId());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testReadReturnsUnavailableHalfway() {
    try (Spanner spanner = createSpanner()) {
      for (int i = 0; i < 10; i++) {
        mockSpanner.setStreamingReadExecutionTime(
            SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 2));

        DatabaseClient client =
            spanner.getDatabaseClient(
                DatabaseId.of("fake-project", "fake-instance", "fake-database"));
        client
            .readWriteTransaction(Options.tag("some-tag"), Options.excludeTxnFromChangeStreams())
            .run(
                transaction -> {
                  try (ResultSet resultSet =
                      transaction.read("my-table", KeySet.all(), ImmutableList.of("my-column"))) {
                    while (resultSet.next()) {}
                  }
                  transaction.buffer(
                      Mutation.newInsertOrUpdateBuilder("my-table")
                          .set("my-column")
                          .to(1L)
                          .build());
                  return null;
                });
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(ReadRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        ReadRequest firstReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(0);
        assertTrue(firstReadRequest.hasTransaction());
        assertTrue(firstReadRequest.getTransaction().hasBegin());
        assertTrue(firstReadRequest.getTransaction().getBegin().hasReadWrite());
        assertTrue(firstReadRequest.getTransaction().getBegin().getExcludeTxnFromChangeStreams());

        ReadRequest secondReadRequest = mockSpanner.getRequestsOfType(ReadRequest.class).get(1);
        assertTrue(secondReadRequest.hasTransaction());
        assertTrue(secondReadRequest.getTransaction().hasId());

        CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
        assertNotNull(commitRequest.getTransactionId());

        mockSpanner.clearRequests();
      }
    }
  }
}
