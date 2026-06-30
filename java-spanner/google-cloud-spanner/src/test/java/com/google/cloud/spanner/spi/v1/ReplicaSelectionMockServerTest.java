/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.TextFormat;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RecipeList;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.Tablet;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReplicaSelectionMockServerTest {

  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      StructType.Field.newBuilder()
                          .setName("COL1")
                          .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                          .build())
                  .build())
          .build();
  private static final ResultSet SELECT1_RESULTSET =
      ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT1_METADATA)
          .build();
  private static final String QUERY_SQL = "SELECT * FROM Table WHERE Column = @p1";
  private static final String QUERY_PARAM = "p1";

  private List<ServerInstance> servers;
  private final int numServers = 2;

  private static class ServerInstance {
    Server server;
    MockSpannerServiceImpl mockSpanner;
    int port;
  }

  @Before
  public void setUp() throws IOException {
    servers = new ArrayList<>();
    List<MockSpannerServiceImpl> nonDefaultMocks = new ArrayList<>();
    for (int i = 1; i < numServers; i++) {
      nonDefaultMocks.add(new MockSpannerServiceImpl());
    }

    MockSpannerServiceImpl defaultMock =
        new MockSpannerServiceImpl() {
          @Override
          public void createSession(
              CreateSessionRequest request, StreamObserver<Session> responseObserver) {
            super.createSession(
                request,
                new StreamObserver<Session>() {
                  @Override
                  public void onNext(Session value) {
                    responseObserver.onNext(value);
                    for (MockSpannerServiceImpl target : nonDefaultMocks) {
                      target.getSessions().put(value.getName(), value);
                    }
                  }

                  @Override
                  public void onError(Throwable t) {
                    responseObserver.onError(t);
                  }

                  @Override
                  public void onCompleted() {
                    responseObserver.onCompleted();
                  }
                });
          }
        };

    for (int i = 0; i < numServers; i++) {
      MockSpannerServiceImpl mockSpanner = (i == 0) ? defaultMock : nonDefaultMocks.get(i - 1);
      mockSpanner.setAbortProbability(0.0D);
      InetSocketAddress address = new InetSocketAddress("localhost", 0);
      Server server =
          NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();

      ServerInstance instance = new ServerInstance();
      instance.server = server;
      instance.mockSpanner = mockSpanner;
      instance.port = server.getPort();
      servers.add(instance);
    }
  }

  @After
  public void tearDown() throws InterruptedException {
    EndpointLatencyRegistry.clear();
    RequestIdTargetTracker.clear();
    for (ServerInstance si : servers) {
      si.server.shutdown();
    }
    for (ServerInstance si : servers) {
      si.server.awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  @Test
  public void testEndToEndWithSpannerOptions() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .usePlainText()
            .setExperimentalHost("localhost:" + servers.get(0).port)
            .setProjectId("fake-project")
            .setChannelEndpointCacheFactory(null)
            .build();

    RecipeList.Builder recipeListBuilder = RecipeList.newBuilder();
    try {
      TextFormat.merge(
          "recipe {\n"
              + "  table_name: \"Table\"\n"
              + "  part { tag: 1 }\n"
              + "  part {\n"
              + "    order: ASCENDING\n"
              + "    null_order: NULLS_FIRST\n"
              + "    type { code: STRING }\n"
              + "  }\n"
              + "}\n",
          recipeListBuilder);
    } catch (TextFormat.ParseException e) {
      throw new RuntimeException(e);
    }

    // 2. Construct a CacheUpdate that points to Server 1 for location "us-east1"
    CacheUpdate cacheUpdate =
        CacheUpdate.newBuilder()
            .setDatabaseId(12345L)
            .setKeyRecipes(recipeListBuilder.build())
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(1L)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(101L)
                            .setServerAddress("localhost:" + servers.get(1).port)
                            .setLocation("us-east1")
                            .setRole(Tablet.Role.READ_ONLY)
                            .setDistance(0)
                            .build())
                    .build())
            .addRange(
                Range.newBuilder()
                    .setStartKey(ByteString.EMPTY)
                    .setLimitKey(ByteString.copyFromUtf8("\u00FF"))
                    .setGroupUid(1L)
                    .setSplitId(1L)
                    .setGeneration(ByteString.copyFromUtf8("gen1"))
                    .build())
            .build();

    ResultSet resultSetWithUpdate =
        SELECT1_RESULTSET.toBuilder().setCacheUpdate(cacheUpdate).build();

    // Setup Server 0 to return the update
    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(Statement.of("SELECT 1"), resultSetWithUpdate));

    com.google.cloud.spanner.Statement readStatement =
        StatementResult.createReadStatement(
            "Table",
            com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of()),
            Arrays.asList("Column"));

    // Setup Server 0 to ALSO return result for the read to avoid INTERNAL error if routing fails
    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));

    // Setup Server 1 to return result for the directed read
    servers
        .get(1)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));

      // 3. Execute first query to receive the update
      try (com.google.cloud.spanner.ResultSet rs =
          client.singleUse().executeQuery(Statement.of("SELECT 1"))) {
        while (rs.next()) {
          /* consume */
        }
      }

      // Poll until the read is routed to the replica (Server 1)
      String successfulKey = null;
      Stopwatch watch = Stopwatch.createStarted();
      int attempt = 0;

      DirectedReadOptions directedReadOptions =
          DirectedReadOptions.newBuilder()
              .setIncludeReplicas(
                  IncludeReplicas.newBuilder()
                      .addReplicaSelections(
                          ReplicaSelection.newBuilder().setLocation("us-east1").build())
                      .build())
              .build();

      while (watch.elapsed(TimeUnit.SECONDS) < 10) {
        attempt++;
        String key = "key-" + attempt;

        try (com.google.cloud.spanner.ResultSet rs =
            client
                .singleUse()
                .read(
                    "Table",
                    com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of(key)),
                    Arrays.asList("Column"),
                    Options.directedRead(directedReadOptions))) {
          while (rs.next()) {
            /* consume */
          }
        }

        final String currentKey = key;
        boolean server1ReceivedRead =
            servers.get(1).mockSpanner.getRequestsOfType(ReadRequest.class).stream()
                .anyMatch(
                    req ->
                        req.getKeySet()
                            .getKeys(0)
                            .getValues(0)
                            .getStringValue()
                            .equals(currentKey));

        if (server1ReceivedRead) {
          successfulKey = key;
          break;
        }
      }
      assertNotNull("Should have routed to replica within timeout", successfulKey);

      // 5. Verify that Server 0 did NOT receive the read with the successful key
      final String finalSuccessfulKey = successfulKey;
      boolean server0ReceivedSuccessfulRead =
          servers.get(0).mockSpanner.getRequestsOfType(ReadRequest.class).stream()
              .anyMatch(
                  req ->
                      req.getKeySet()
                          .getKeys(0)
                          .getValues(0)
                          .getStringValue()
                          .equals(finalSuccessfulKey));
      assertFalse(
          "Server 0 should not have received Read with the successful key",
          server0ReceivedSuccessfulRead);

      // 6. Verify that Server 1 received the read with the successful key
      boolean server1ReceivedSuccessfulRead =
          servers.get(1).mockSpanner.getRequestsOfType(ReadRequest.class).stream()
              .anyMatch(
                  req ->
                      req.getKeySet()
                          .getKeys(0)
                          .getValues(0)
                          .getStringValue()
                          .equals(finalSuccessfulKey));
      assertTrue(
          "Server 1 should have received Read with the successful key",
          server1ReceivedSuccessfulRead);
    }
  }

  @Test
  public void testStaleSingleUseReadBootstrapsScoresAndConvergesToLowerLatencyReplica()
      throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .usePlainText()
            .setExperimentalHost("localhost:" + servers.get(0).port)
            .setProjectId("fake-project")
            .setChannelEndpointCacheFactory(null)
            .build();

    RecipeList.Builder recipeListBuilder = RecipeList.newBuilder();
    try {
      TextFormat.merge(
          "recipe {\n"
              + "  table_name: \"Table\"\n"
              + "  part { tag: 1 }\n"
              + "  part {\n"
              + "    order: ASCENDING\n"
              + "    null_order: NULLS_FIRST\n"
              + "    type { code: STRING }\n"
              + "  }\n"
              + "}\n",
          recipeListBuilder);
    } catch (TextFormat.ParseException e) {
      throw new RuntimeException(e);
    }

    CacheUpdate cacheUpdate =
        CacheUpdate.newBuilder()
            .setDatabaseId(12345L)
            .setKeyRecipes(recipeListBuilder.build())
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(1L)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(101L)
                            .setServerAddress("localhost:" + servers.get(0).port)
                            .setRole(Tablet.Role.READ_ONLY)
                            .setDistance(0)
                            .build())
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(102L)
                            .setServerAddress("localhost:" + servers.get(1).port)
                            .setRole(Tablet.Role.READ_ONLY)
                            .setDistance(0)
                            .build())
                    .build())
            .addRange(
                Range.newBuilder()
                    .setStartKey(ByteString.EMPTY)
                    .setLimitKey(ByteString.copyFromUtf8("\u00FF"))
                    .setGroupUid(1L)
                    .setSplitId(1L)
                    .setGeneration(ByteString.copyFromUtf8("gen1"))
                    .build())
            .build();

    ResultSet resultSetWithUpdate =
        SELECT1_RESULTSET.toBuilder().setCacheUpdate(cacheUpdate).build();

    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(Statement.of("SELECT 1"), resultSetWithUpdate));

    com.google.cloud.spanner.Statement readStatement =
        StatementResult.createReadStatement(
            "Table",
            com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of()),
            Arrays.asList("Column"));

    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));
    servers
        .get(1)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));
    servers
        .get(0)
        .mockSpanner
        .setStreamingReadExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(40, 0));
    servers
        .get(1)
        .mockSpanner
        .setStreamingReadExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(0, 0));

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));

      try (com.google.cloud.spanner.ResultSet rs =
          client.singleUse().executeQuery(Statement.of("SELECT 1"))) {
        while (rs.next()) {
          /* consume */
        }
      }

      clearServerRequests();
      long operationUid = 0L;

      for (int attempt = 1; attempt <= 3; attempt++) {
        String key = "bootstrap-key-" + attempt;
        try (com.google.cloud.spanner.ResultSet rs =
            client
                .singleUse(TimestampBound.ofExactStaleness(15L, TimeUnit.SECONDS))
                .read(
                    "Table",
                    com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of(key)),
                    Arrays.asList("Column"))) {
          while (rs.next()) {
            /* consume */
          }
        }

        long currentOperationUid = findReadOperationUid(key);
        assertTrue("Expected stale read to carry operation_uid", currentOperationUid > 0L);
        if (operationUid == 0L) {
          operationUid = currentOperationUid;
        } else {
          assertEquals(
              "Expected stale reads to reuse the same operation_uid",
              operationUid,
              currentOperationUid);
        }
      }

      assertTrue("Expected stale reads to reuse the same operation_uid", operationUid > 0L);

      clearServerRequests();
      Stopwatch watch = Stopwatch.createStarted();
      boolean routedToLowerLatencyReplica = false;
      int convergenceAttempt = 0;
      while (watch.elapsed(TimeUnit.SECONDS) < 10 && !routedToLowerLatencyReplica) {
        convergenceAttempt++;
        String key = "convergence-key-" + convergenceAttempt;
        try (com.google.cloud.spanner.ResultSet rs =
            client
                .singleUse(TimestampBound.ofExactStaleness(15L, TimeUnit.SECONDS))
                .read(
                    "Table",
                    com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of(key)),
                    Arrays.asList("Column"))) {
          while (rs.next()) {
            /* consume */
          }
        }

        routedToLowerLatencyReplica =
            hasReadRequestForKey(servers.get(1).mockSpanner, key)
                && !hasReadRequestForKey(servers.get(0).mockSpanner, key);
      }

      assertTrue(
          "Expected latency-aware routing to converge to the faster replica",
          routedToLowerLatencyReplica);
    }
  }

  @Test
  public void testStrongSingleUseReadConvergesToLowerLatencyReplica() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .usePlainText()
            .setExperimentalHost("localhost:" + servers.get(0).port)
            .setProjectId("fake-project")
            .setChannelEndpointCacheFactory(null)
            .build();

    ResultSet resultSetWithUpdate =
        SELECT1_RESULTSET.toBuilder()
            .setCacheUpdate(createReplicaCacheUpdate(readRecipeList()))
            .build();

    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(Statement.of("SELECT 1"), resultSetWithUpdate));

    com.google.cloud.spanner.Statement readStatement =
        StatementResult.createReadStatement(
            "Table",
            com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of()),
            Arrays.asList("Column"));

    servers
        .get(0)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));
    servers
        .get(1)
        .mockSpanner
        .putStatementResult(StatementResult.query(readStatement, SELECT1_RESULTSET));
    servers
        .get(0)
        .mockSpanner
        .setStreamingReadExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(40, 0));
    servers
        .get(1)
        .mockSpanner
        .setStreamingReadExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(0, 0));

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));

      try (com.google.cloud.spanner.ResultSet rs =
          client.singleUse().executeQuery(Statement.of("SELECT 1"))) {
        while (rs.next()) {
          /* consume */
        }
      }

      clearServerRequests();
      long operationUid = 0L;

      for (int attempt = 1; attempt <= 3; attempt++) {
        String key = "strong-read-bootstrap-" + attempt;
        try (com.google.cloud.spanner.ResultSet rs =
            client
                .singleUse()
                .read(
                    "Table",
                    com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of(key)),
                    Arrays.asList("Column"))) {
          while (rs.next()) {
            /* consume */
          }
        }

        long currentOperationUid = findReadOperationUid(key);
        assertTrue("Expected strong read to carry operation_uid", currentOperationUid > 0L);
        if (operationUid == 0L) {
          operationUid = currentOperationUid;
        } else {
          assertEquals(
              "Expected strong reads to reuse the same operation_uid",
              operationUid,
              currentOperationUid);
        }
      }

      assertTrue("Expected strong reads to reuse the same operation_uid", operationUid > 0L);

      clearServerRequests();
      Stopwatch watch = Stopwatch.createStarted();
      boolean routedToLowerLatencyReplica = false;
      int convergenceAttempt = 0;
      while (watch.elapsed(TimeUnit.SECONDS) < 10 && !routedToLowerLatencyReplica) {
        convergenceAttempt++;
        String key = "strong-read-convergence-" + convergenceAttempt;
        try (com.google.cloud.spanner.ResultSet rs =
            client
                .singleUse()
                .read(
                    "Table",
                    com.google.cloud.spanner.KeySet.singleKey(com.google.cloud.spanner.Key.of(key)),
                    Arrays.asList("Column"))) {
          while (rs.next()) {
            /* consume */
          }
        }

        routedToLowerLatencyReplica =
            hasReadRequestForKey(servers.get(1).mockSpanner, key)
                && !hasReadRequestForKey(servers.get(0).mockSpanner, key);
      }

      assertTrue(
          "Expected strong read routing to converge to the faster replica",
          routedToLowerLatencyReplica);
    }
  }

  @Test
  public void testStrongSingleUseQueryConvergesToLowerLatencyReplica() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .usePlainText()
            .setExperimentalHost("localhost:" + servers.get(0).port)
            .setProjectId("fake-project")
            .setChannelEndpointCacheFactory(null)
            .build();

    servers
        .get(0)
        .mockSpanner
        .setExecuteStreamingSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(40, 0));
    servers
        .get(1)
        .mockSpanner
        .setExecuteStreamingSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(0, 0));

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));
      assertStrongQueryConvergesToLowerLatencyReplica(
          statement -> {
            try (com.google.cloud.spanner.ResultSet rs =
                client.singleUse().executeQuery(statement)) {
              while (rs.next()) {
                /* consume */
              }
            }
          });
    }
  }

  @FunctionalInterface
  private interface QueryExecutor {
    void execute(Statement statement) throws Exception;
  }

  private void assertStrongQueryConvergesToLowerLatencyReplica(QueryExecutor queryExecutor)
      throws Exception {
    String seedKey = "query-seed";
    installQueryResultOnAllServers(seedKey, SELECT1_RESULTSET);

    queryExecutor.execute(queryStatement(seedKey));
    long operationUid = findQueryOperationUid(seedKey);
    assertTrue("Expected strong query to carry operation_uid", operationUid > 0L);

    installQueryResultOnAllServers(
        seedKey,
        SELECT1_RESULTSET.toBuilder()
            .setCacheUpdate(createReplicaCacheUpdate(queryRecipeList(operationUid)))
            .build());
    queryExecutor.execute(queryStatement(seedKey));
    clearServerRequests();

    for (int attempt = 1; attempt <= 3; attempt++) {
      String key = "strong-query-bootstrap-" + attempt;
      installQueryResultOnAllServers(key, SELECT1_RESULTSET);
      queryExecutor.execute(queryStatement(key));

      long currentOperationUid = findQueryOperationUid(key);
      assertEquals(
          "Expected strong queries to reuse the same operation_uid",
          operationUid,
          currentOperationUid);
    }

    clearServerRequests();
    Stopwatch watch = Stopwatch.createStarted();
    boolean routedToLowerLatencyReplica = false;
    int convergenceAttempt = 0;
    while (watch.elapsed(TimeUnit.SECONDS) < 10 && !routedToLowerLatencyReplica) {
      convergenceAttempt++;
      String key = "strong-query-convergence-" + convergenceAttempt;
      installQueryResultOnAllServers(key, SELECT1_RESULTSET);
      queryExecutor.execute(queryStatement(key));

      routedToLowerLatencyReplica =
          hasQueryRequestForKey(servers.get(1).mockSpanner, key)
              && !hasQueryRequestForKey(servers.get(0).mockSpanner, key);
    }

    assertTrue(
        "Expected strong query routing to converge to the faster replica",
        routedToLowerLatencyReplica);
  }

  private void clearServerRequests() {
    for (ServerInstance server : servers) {
      server.mockSpanner.clearRequests();
    }
  }

  private CacheUpdate createReplicaCacheUpdate(RecipeList keyRecipes) {
    return CacheUpdate.newBuilder()
        .setDatabaseId(12345L)
        .setKeyRecipes(keyRecipes)
        .addGroup(
            Group.newBuilder()
                .setGroupUid(1L)
                .setLeaderIndex(0)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(101L)
                        .setServerAddress("localhost:" + servers.get(0).port)
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0)
                        .build())
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(102L)
                        .setServerAddress("localhost:" + servers.get(1).port)
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0)
                        .build())
                .build())
        .addRange(
            Range.newBuilder()
                .setStartKey(ByteString.EMPTY)
                .setLimitKey(ByteString.copyFromUtf8("\u00FF"))
                .setGroupUid(1L)
                .setSplitId(1L)
                .setGeneration(ByteString.copyFromUtf8("gen1"))
                .build())
        .build();
  }

  private RecipeList readRecipeList() throws TextFormat.ParseException {
    RecipeList.Builder recipeListBuilder = RecipeList.newBuilder();
    TextFormat.merge(
        "recipe {\n"
            + "  table_name: \"Table\"\n"
            + "  part { tag: 1 }\n"
            + "  part {\n"
            + "    order: ASCENDING\n"
            + "    null_order: NULLS_FIRST\n"
            + "    type { code: STRING }\n"
            + "    identifier: \"k\"\n"
            + "  }\n"
            + "}\n",
        recipeListBuilder);
    return recipeListBuilder.build();
  }

  private RecipeList queryRecipeList(long operationUid) throws TextFormat.ParseException {
    RecipeList.Builder recipeListBuilder = RecipeList.newBuilder();
    TextFormat.merge(
        "recipe {\n"
            + "  operation_uid: "
            + operationUid
            + "\n"
            + "  part { tag: 1 }\n"
            + "  part {\n"
            + "    order: ASCENDING\n"
            + "    null_order: NULLS_FIRST\n"
            + "    type { code: STRING }\n"
            + "    identifier: \""
            + QUERY_PARAM
            + "\"\n"
            + "  }\n"
            + "}\n",
        recipeListBuilder);
    return recipeListBuilder.build();
  }

  private Statement queryStatement(String key) {
    return Statement.newBuilder(QUERY_SQL).bind(QUERY_PARAM).to(key).build();
  }

  private void installQueryResultOnAllServers(String key, ResultSet resultSet) {
    Statement statement = queryStatement(key);
    for (ServerInstance server : servers) {
      server.mockSpanner.putStatementResult(StatementResult.query(statement, resultSet));
    }
  }

  private long findReadOperationUid(String key) {
    for (ServerInstance server : servers) {
      for (ReadRequest request : server.mockSpanner.getRequestsOfType(ReadRequest.class)) {
        if (request.getKeySet().getKeysCount() == 0
            || request.getKeySet().getKeys(0).getValuesCount() == 0) {
          continue;
        }
        if (key.equals(request.getKeySet().getKeys(0).getValues(0).getStringValue())) {
          return request.getRoutingHint().getOperationUid();
        }
      }
    }
    return 0L;
  }

  private long findQueryOperationUid(String key) {
    for (ServerInstance server : servers) {
      for (ExecuteSqlRequest request :
          server.mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
        if (request.getParams().getFieldsMap().containsKey(QUERY_PARAM)
            && key.equals(request.getParams().getFieldsOrThrow(QUERY_PARAM).getStringValue())) {
          return request.getRoutingHint().getOperationUid();
        }
      }
    }
    return 0L;
  }

  private boolean hasReadRequestForKey(MockSpannerServiceImpl mockSpanner, String key) {
    return mockSpanner.getRequestsOfType(ReadRequest.class).stream()
        .anyMatch(
            request ->
                request.getKeySet().getKeysCount() > 0
                    && request.getKeySet().getKeys(0).getValuesCount() > 0
                    && key.equals(request.getKeySet().getKeys(0).getValues(0).getStringValue()));
  }

  private boolean hasQueryRequestForKey(MockSpannerServiceImpl mockSpanner, String key) {
    return mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
        .anyMatch(
            request ->
                request.getParams().getFieldsMap().containsKey(QUERY_PARAM)
                    && key.equals(
                        request.getParams().getFieldsOrThrow(QUERY_PARAM).getStringValue()));
  }
}
