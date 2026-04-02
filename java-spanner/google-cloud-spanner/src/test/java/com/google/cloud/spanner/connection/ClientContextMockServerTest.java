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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.protobuf.Value;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RequestOptions;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClientContextMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  private static final RequestOptions.ClientContext CLIENT_CONTEXT =
      RequestOptions.ClientContext.newBuilder()
          .putSecureContext("test-key", Value.newBuilder().setStringValue("test-value").build())
          .build();

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
      SpannerPool.closeSpannerPool();
      currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testQuery_PropagatesClientContext() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());
    }
  }

  @Test
  public void testUpdate_PropagatesClientContext() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      connection.executeUpdate(INSERT_STATEMENT);

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());
    }
  }

  @Test
  public void testBatchUpdate_PropagatesClientContext() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());
    }
  }

  @Test
  public void testCommit_PropagatesClientContext() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());
    }
  }

  @Test
  public void testBeginTransaction_PropagatesClientContextWithLazyStart() {
    // The BeginTransaction option is inlined with the first statement.
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      connection.beginTransaction();
      connection.executeUpdate(INSERT_STATEMENT);

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals(CLIENT_CONTEXT, request.getRequestOptions().getClientContext());
      assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    }
  }

  @Test
  public void testBeginTransaction_PropagatesClientContextWithEagerStartAborted() {
    // We can force an explicit BeginTransaction RPC by failing the first statement with an ABORTED
    // error. If the statement fails before returning a transaction ID, the retry will use an
    // explicit BeginTransaction RPC.
    // Note: This relies on triggering a retry logic which is the only way to force explicit
    // BeginTransaction in the standard Connection API flow without additional configuration (like
    // setting delayTransactionStartUntilFirstWrite=false which is not exposed publicly here).
    try (Connection connection = createConnection()) {
      // Abort the next statement. This will cause the ExecuteSql request (which carries the
      // BeginTransaction option) to fail with an ABORTED error.
      // Since the request fails, the client does not receive the transaction ID.
      // The retry logic in TransactionRunnerImpl/ReadWriteTransaction will then force an
      // explicit BeginTransaction RPC to ensure a transaction is started before retrying the
      // statement.
      mockSpanner.abortNextStatement();

      connection.setClientContext(CLIENT_CONTEXT);
      connection.beginTransaction();
      connection.executeUpdate(INSERT_STATEMENT);

      // We expect two ExecuteSqlRequests.
      // 1. The first one fails with ABORTED. This request includes the BeginTransaction option.
      // 2. The retry.
      int executeSqlCount = mockSpanner.countRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(2, executeSqlCount);

      for (ExecuteSqlRequest req : mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
        assertEquals(CLIENT_CONTEXT, req.getRequestOptions().getClientContext());
      }

      // We also expect 1 BeginTransactionRequest because the retry used explicit BeginTransaction.
      assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      BeginTransactionRequest beginRequest =
          mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
      assertEquals(CLIENT_CONTEXT, beginRequest.getRequestOptions().getClientContext());
    }
  }

  @Test
  public void testBeginTransaction_PropagatesClientContextWithEagerStartMutations() {
    // We can also force an explicit BeginTransaction RPC by constructing a transaction
    // that only issues mutations.  Mutation RPCs cannot start a transaction, so
    // if they are the only RPCs in the transaction, then an explicit BeginTransaction
    // must be issued.
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      connection.beginTransaction();
      connection.bufferedWrite(Mutation.newInsertBuilder("my-table").set("my-col").to(1L).build());
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      BeginTransactionRequest request =
          mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
      assertEquals(CLIENT_CONTEXT, request.getRequestOptions().getClientContext());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
      assertEquals(CLIENT_CONTEXT, commitRequest.getRequestOptions().getClientContext());
    }
  }

  @Test
  public void testDatabaseClient_ClientContextMerging() {
    String projectId = "test-project";
    String instanceId = "test-instance";
    String databaseId = "test-database";

    // 1. Define the default ClientContext in SpannerOptions.
    RequestOptions.ClientContext defaultContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext("key1", Value.newBuilder().setStringValue("default_value1").build())
            .putSecureContext("key2", Value.newBuilder().setStringValue("default_value2").build())
            .build();

    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .setHost("http://localhost:" + getPort())
            .usePlainText()
            .setDefaultClientContext(defaultContext)
            .build();

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

      // 2. Define the request-specific ClientContext that overrides one key and adds a new one.
      RequestOptions.ClientContext requestContext =
          RequestOptions.ClientContext.newBuilder()
              .putSecureContext("key2", Value.newBuilder().setStringValue("request_value2").build())
              .putSecureContext("key3", Value.newBuilder().setStringValue("request_value3").build())
              .build();

      // 3. Define the expected merged ClientContext (Union + Overwrite).
      RequestOptions.ClientContext expectedContext =
          RequestOptions.ClientContext.newBuilder()
              .putSecureContext("key1", Value.newBuilder().setStringValue("default_value1").build())
              .putSecureContext("key2", Value.newBuilder().setStringValue("request_value2").build())
              .putSecureContext("key3", Value.newBuilder().setStringValue("request_value3").build())
              .build();

      // Execute a query with the request context.
      try (ResultSet rs =
          client
              .singleUse()
              .executeQuery(
                  SELECT_COUNT_STATEMENT,
                  com.google.cloud.spanner.Options.clientContext(requestContext))) {
        rs.next();
      }

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      RequestOptions.ClientContext actualContext =
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext();

      assertEquals(expectedContext, actualContext);

      // Verify specifically that key2 was overwritten and key1 was preserved.
      assertEquals(
          "request_value2", actualContext.getSecureContextOrThrow("key2").getStringValue());
      assertEquals(
          "default_value1", actualContext.getSecureContextOrThrow("key1").getStringValue());
    }
  }

  @Test
  public void testPersistence() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());

      connection.executeUpdate(INSERT_STATEMENT);
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(1)
              .getRequestOptions()
              .getClientContext());

      connection.commit();
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());
    }
  }

  @Test
  public void testClearClientContext() {
    try (Connection connection = createConnection()) {
      connection.setClientContext(CLIENT_CONTEXT);
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}

      assertEquals(
          CLIENT_CONTEXT,
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getClientContext());

      connection.setClientContext(null);
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}

      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertFalse(
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(1)
              .getRequestOptions()
              .hasClientContext());
    }
  }
}
