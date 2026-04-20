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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.spi.v1.KeyRecipeCache;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.TextFormat;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RecipeList;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.Tablet;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LocationAwareSharedBackendReplicaHarnessTest {

  private static final String PROJECT = "fake-project";
  private static final String INSTANCE = "fake-instance";
  private static final String DATABASE = "fake-database";
  private static final String TABLE = "T";
  private static final String REPLICA_LOCATION = "us-east1";
  private static final Statement SEED_QUERY = Statement.of("SELECT 1");
  private static final ByteString RESUME_TOKEN_AFTER_FIRST_ROW =
      ByteString.copyFromUtf8("000000001");
  private static final DirectedReadOptions DIRECTED_READ_OPTIONS =
      DirectedReadOptions.newBuilder()
          .setIncludeReplicas(
              IncludeReplicas.newBuilder()
                  .addReplicaSelections(
                      ReplicaSelection.newBuilder()
                          .setLocation(REPLICA_LOCATION)
                          .setType(ReplicaSelection.Type.READ_ONLY)
                          .build())
                  .build())
          .build();
  private static SharedBackendReplicaHarness harness;

  @BeforeClass
  public static void enableLocationAwareRouting() throws Exception {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableLocationApi() {
            return true;
          }
        });
    harness = SharedBackendReplicaHarness.create(2);
  }

  @Before
  public void resetHarness() {
    harness.reset();
  }

  @AfterClass
  public static void restoreEnvironment() throws Exception {
    try {
      if (harness != null) {
        harness.close();
      }
    } finally {
      harness = null;
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void singleUseReadReroutesOnResourceExhaustedForBypassTraffic() throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, singleRowReadResultSet("b"));
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      int firstReplicaIndex = waitForReplicaRoutedRead(client, harness);
      int secondReplicaIndex = 1 - firstReplicaIndex;
      harness.clearRequests();

      harness
          .replicas
          .get(firstReplicaIndex)
          .putMethodErrors(
              SharedBackendReplicaHarness.METHOD_STREAMING_READ,
              resourceExhausted("busy-routed-replica"));

      try (ResultSet resultSet =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(resultSet.next());
      }

      assertEquals(
          1,
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          1,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .defaultReplica
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      ReadRequest replicaARequest =
          (ReadRequest)
              harness
                  .replicas
                  .get(firstReplicaIndex)
                  .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                  .get(0);
      assertTrue(replicaARequest.getResumeToken().isEmpty());
      assertRetriedOnSameLogicalRequest(
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0),
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0));
    }
  }

  @Test
  public void singleUseReadCooldownSkipsReplicaOnNextRequestForBypassTraffic() throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, singleRowReadResultSet("b"));
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      int firstReplicaIndex = waitForReplicaRoutedRead(client, harness);
      int secondReplicaIndex = 1 - firstReplicaIndex;
      harness.clearRequests();

      harness
          .replicas
          .get(firstReplicaIndex)
          .putMethodErrors(
              SharedBackendReplicaHarness.METHOD_STREAMING_READ,
              resourceExhaustedWithRetryInfo("busy-routed-replica"));

      try (ResultSet firstRead =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(firstRead.next());
      }

      try (ResultSet secondRead =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(secondRead.next());
      }

      assertEquals(
          1,
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          2,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .defaultReplica
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      List<AbstractMessage> replicaBRequests =
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
      for (AbstractMessage request : replicaBRequests) {
        assertTrue(((ReadRequest) request).getResumeToken().isEmpty());
      }
      List<String> replicaBRequestIds =
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
      assertRetriedOnSameLogicalRequest(
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0),
          replicaBRequestIds.get(0));
      assertNotEquals(
          XGoogSpannerRequestId.of(replicaBRequestIds.get(0)).getLogicalRequestKey(),
          XGoogSpannerRequestId.of(replicaBRequestIds.get(1)).getLogicalRequestKey());
    }
  }

  @Test
  public void singleUseReadReroutesOnUnavailableForBypassTraffic() throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, singleRowReadResultSet("b"));
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      int firstReplicaIndex = waitForReplicaRoutedRead(client, harness);
      int secondReplicaIndex = 1 - firstReplicaIndex;
      harness.clearRequests();

      harness
          .replicas
          .get(firstReplicaIndex)
          .putMethodErrors(
              SharedBackendReplicaHarness.METHOD_STREAMING_READ, unavailable("isolated-replica"));

      try (ResultSet resultSet =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(resultSet.next());
      }

      assertEquals(
          1,
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          1,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .defaultReplica
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      ReadRequest replicaARequest =
          (ReadRequest)
              harness
                  .replicas
                  .get(firstReplicaIndex)
                  .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                  .get(0);
      assertTrue(replicaARequest.getResumeToken().isEmpty());
      assertRetriedOnSameLogicalRequest(
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0),
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0));
    }
  }

  @Test
  public void singleUseReadCooldownSkipsUnavailableReplicaOnNextRequestForBypassTraffic()
      throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, singleRowReadResultSet("b"));
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      int firstReplicaIndex = waitForReplicaRoutedRead(client, harness);
      int secondReplicaIndex = 1 - firstReplicaIndex;
      harness.clearRequests();

      harness
          .replicas
          .get(firstReplicaIndex)
          .putMethodErrors(
              SharedBackendReplicaHarness.METHOD_STREAMING_READ, unavailable("isolated-replica"));

      try (ResultSet firstRead =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(firstRead.next());
      }

      try (ResultSet secondRead =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        assertTrue(secondRead.next());
      }

      assertEquals(
          1,
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          2,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .defaultReplica
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      List<AbstractMessage> replicaBRequests =
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
      for (AbstractMessage request : replicaBRequests) {
        assertTrue(((ReadRequest) request).getResumeToken().isEmpty());
      }
      List<String> replicaBRequestIds =
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
      assertRetriedOnSameLogicalRequest(
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0),
          replicaBRequestIds.get(0));
      assertNotEquals(
          XGoogSpannerRequestId.of(replicaBRequestIds.get(0)).getLogicalRequestKey(),
          XGoogSpannerRequestId.of(replicaBRequestIds.get(1)).getLogicalRequestKey());
    }
  }

  @Test
  public void singleUseReadMidStreamRecvFailureWithoutRetryInfoRetriesForBypassTraffic()
      throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, multiRowReadResultSet("b", "c", "d"));
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      int firstReplicaIndex = waitForReplicaRoutedRead(client, harness);
      int secondReplicaIndex = 1 - firstReplicaIndex;
      harness.clearRequests();

      harness.backend.setStreamingReadExecutionTime(
          SimulatedExecutionTime.ofStreamException(resourceExhausted("busy-routed-replica"), 1L));

      List<String> rows = new ArrayList<>();
      try (ResultSet resultSet =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        while (resultSet.next()) {
          rows.add(resultSet.getString(0));
        }
      }

      assertEquals(Arrays.asList("b", "c", "d"), rows);
      assertEquals(
          1,
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          1,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .defaultReplica
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());

      ReadRequest replicaARequest =
          (ReadRequest)
              harness
                  .replicas
                  .get(firstReplicaIndex)
                  .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                  .get(0);
      ReadRequest replicaBRequest =
          (ReadRequest)
              harness
                  .replicas
                  .get(secondReplicaIndex)
                  .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                  .get(0);
      assertTrue(replicaARequest.getResumeToken().isEmpty());
      assertEquals(RESUME_TOKEN_AFTER_FIRST_ROW, replicaBRequest.getResumeToken());
      assertRetriedOnSameLogicalRequest(
          harness
              .replicas
              .get(firstReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0),
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequestIds(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .get(0));
    }
  }

  @Test
  public void readWriteTransactionAbortedCommitUsesReadAffinityReplicaForBypassTraffic()
      throws Exception {
    try (Spanner spanner = createSpanner(harness)) {
      configureBackend(harness, singleRowReadResultSet("b"), /* leaderReplicaIndex= */ 1);
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      waitForReplicaRoutedStrongRead(client, harness, /* expectedReplicaIndex= */ 1);
      harness.clearRequests();
      AtomicInteger attempts = new AtomicInteger();
      AtomicInteger firstReplicaIndex = new AtomicInteger(-1);

      client
          .readWriteTransaction()
          .run(
              transaction -> {
                int attempt = attempts.incrementAndGet();
                try (ResultSet resultSet =
                    transaction.read(TABLE, KeySet.singleKey(Key.of("b")), Arrays.asList("k"))) {
                  assertTrue(resultSet.next());
                }

                if (attempt == 1) {
                  int routedReplicaIndex =
                      findReplicaWithRequest(
                          harness, SharedBackendReplicaHarness.METHOD_STREAMING_READ);
                  if (routedReplicaIndex < 0) {
                    fail("Expected read-write transaction read to route to a bypass replica");
                  }
                  firstReplicaIndex.set(routedReplicaIndex);
                  harness
                      .replicas
                      .get(routedReplicaIndex)
                      .putMethodErrors(
                          SharedBackendReplicaHarness.METHOD_COMMIT,
                          Status.ABORTED
                              .withDescription("commit aborted on routed replica")
                              .asRuntimeException());
                }
                return null;
              });

      assertEquals(2, attempts.get());
      assertEquals(1, firstReplicaIndex.get());
      int secondReplicaIndex = 1 - firstReplicaIndex.get();
      assertEquals(
          2,
          harness
              .replicas
              .get(firstReplicaIndex.get())
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          0,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .size());
      assertEquals(
          2,
          harness
              .replicas
              .get(firstReplicaIndex.get())
              .getRequests(SharedBackendReplicaHarness.METHOD_COMMIT)
              .size());
      assertEquals(
          0,
          harness
              .replicas
              .get(secondReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_COMMIT)
              .size());
      assertEquals(
          0, harness.defaultReplica.getRequests(SharedBackendReplicaHarness.METHOD_COMMIT).size());
    }
  }

  private static Spanner createSpanner(SharedBackendReplicaHarness harness) {
    return SpannerOptions.newBuilder()
        .usePlainText()
        .setExperimentalHost(harness.defaultAddress)
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder()
                .setExperimentalHost()
                .setUseMultiplexedSession(true)
                .setUseMultiplexedSessionForRW(true)
                .build())
        .setProjectId(PROJECT)
        .setCredentials(NoCredentials.getInstance())
        .setChannelEndpointCacheFactory(null)
        .build()
        .getService();
  }

  private static void configureBackend(
      SharedBackendReplicaHarness harness, com.google.spanner.v1.ResultSet readResultSet)
      throws TextFormat.ParseException {
    configureBackend(harness, readResultSet, /* leaderReplicaIndex= */ 0);
  }

  private static void configureBackend(
      SharedBackendReplicaHarness harness,
      com.google.spanner.v1.ResultSet readResultSet,
      int leaderReplicaIndex)
      throws TextFormat.ParseException {
    Statement readStatement =
        StatementResult.createReadStatement(
            TABLE, KeySet.singleKey(Key.of("b")), Arrays.asList("k"));
    harness.backend.putStatementResult(StatementResult.query(readStatement, readResultSet));
    harness.backend.putStatementResult(
        StatementResult.query(
            SEED_QUERY,
            singleRowReadResultSet("seed").toBuilder()
                .setCacheUpdate(cacheUpdate(harness, leaderReplicaIndex))
                .build()));
  }

  private static void seedLocationMetadata(DatabaseClient client) {
    try (com.google.cloud.spanner.ResultSet resultSet =
        client.singleUse().executeQuery(SEED_QUERY)) {
      while (resultSet.next()) {
        // Consume the cache update on the first query result.
      }
    }
  }

  private static int waitForReplicaRoutedRead(
      DatabaseClient client, SharedBackendReplicaHarness harness) throws InterruptedException {
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    while (System.nanoTime() < deadlineNanos) {
      try (ResultSet resultSet =
          client
              .singleUse()
              .read(
                  TABLE,
                  KeySet.singleKey(Key.of("b")),
                  Arrays.asList("k"),
                  Options.directedRead(DIRECTED_READ_OPTIONS))) {
        if (resultSet.next()) {
          for (int replicaIndex = 0; replicaIndex < harness.replicas.size(); replicaIndex++) {
            if (!harness
                .replicas
                .get(replicaIndex)
                .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                .isEmpty()) {
              return replicaIndex;
            }
          }
        }
      }
      Thread.sleep(50L);
    }
    throw new AssertionError("Timed out waiting for location-aware read to route to replica");
  }

  private static void waitForReplicaRoutedStrongRead(
      DatabaseClient client, SharedBackendReplicaHarness harness, int expectedReplicaIndex)
      throws InterruptedException {
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    while (System.nanoTime() < deadlineNanos) {
      harness.clearRequests();
      try (ResultSet resultSet =
          client.singleUse().read(TABLE, KeySet.singleKey(Key.of("b")), Arrays.asList("k"))) {
        if (resultSet.next()) {
          if (!harness
              .replicas
              .get(expectedReplicaIndex)
              .getRequests(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
              .isEmpty()) {
            return;
          }
        }
      }
      Thread.sleep(50L);
    }
    throw new AssertionError(
        "Timed out waiting for strong read to route to replica " + expectedReplicaIndex);
  }

  private static int findReplicaWithRequest(SharedBackendReplicaHarness harness, String method) {
    for (int replicaIndex = 0; replicaIndex < harness.replicas.size(); replicaIndex++) {
      if (!harness.replicas.get(replicaIndex).getRequests(method).isEmpty()) {
        return replicaIndex;
      }
    }
    return -1;
  }

  private static CacheUpdate cacheUpdate(SharedBackendReplicaHarness harness)
      throws TextFormat.ParseException {
    return cacheUpdate(harness, /* leaderReplicaIndex= */ 0);
  }

  private static CacheUpdate cacheUpdate(
      SharedBackendReplicaHarness harness, int leaderReplicaIndex)
      throws TextFormat.ParseException {
    RecipeList recipes = readRecipeList();
    RoutingHint routingHint = exactReadRoutingHint(recipes);
    ByteString limitKey = routingHint.getLimitKey();
    if (limitKey.isEmpty()) {
      limitKey = routingHint.getKey().concat(ByteString.copyFrom(new byte[] {0}));
    }

    return CacheUpdate.newBuilder()
        .setDatabaseId(12345L)
        .setKeyRecipes(recipes)
        .addRange(
            Range.newBuilder()
                .setStartKey(routingHint.getKey())
                .setLimitKey(limitKey)
                .setGroupUid(1L)
                .setSplitId(1L)
                .setGeneration(com.google.protobuf.ByteString.copyFromUtf8("gen1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(1L)
                .setGeneration(com.google.protobuf.ByteString.copyFromUtf8("gen1"))
                .setLeaderIndex(leaderReplicaIndex)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(11L)
                        .setServerAddress(harness.replicaAddresses.get(0))
                        .setLocation(REPLICA_LOCATION)
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(12L)
                        .setServerAddress(harness.replicaAddresses.get(1))
                        .setLocation(REPLICA_LOCATION)
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0)))
        .build();
  }

  private static RecipeList readRecipeList() throws TextFormat.ParseException {
    RecipeList.Builder recipes = RecipeList.newBuilder();
    TextFormat.merge(
        "schema_generation: \"1\"\n"
            + "recipe {\n"
            + "  table_name: \""
            + TABLE
            + "\"\n"
            + "  part { tag: 1 }\n"
            + "  part {\n"
            + "    order: ASCENDING\n"
            + "    null_order: NULLS_FIRST\n"
            + "    type { code: STRING }\n"
            + "    identifier: \"k\"\n"
            + "  }\n"
            + "}\n",
        recipes);
    return recipes.build();
  }

  private static RoutingHint exactReadRoutingHint(RecipeList recipes) {
    KeyRecipeCache recipeCache = new KeyRecipeCache();
    recipeCache.addRecipes(recipes);
    ReadRequest.Builder request =
        ReadRequest.newBuilder()
            .setSession(
                String.format(
                    "projects/%s/instances/%s/databases/%s/sessions/test-session",
                    PROJECT, INSTANCE, DATABASE))
            .setTable(TABLE)
            .addAllColumns(Arrays.asList("k"))
            .setDirectedReadOptions(DIRECTED_READ_OPTIONS);
    KeySet.singleKey(Key.of("b")).appendToProto(request.getKeySetBuilder());
    recipeCache.computeKeys(request);
    return request.getRoutingHint();
  }

  private static io.grpc.StatusRuntimeException resourceExhaustedWithRetryInfo(String description) {
    Metadata trailers = new Metadata();
    trailers.put(
        ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()),
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder()
                    .setNanos((int) TimeUnit.MILLISECONDS.toNanos(1L))
                    .build())
            .build());
    return Status.RESOURCE_EXHAUSTED.withDescription(description).asRuntimeException(trailers);
  }

  private static StatusRuntimeException resourceExhausted(String description) {
    return Status.RESOURCE_EXHAUSTED.withDescription(description).asRuntimeException();
  }

  private static StatusRuntimeException unavailable(String description) {
    return Status.UNAVAILABLE.withDescription(description).asRuntimeException();
  }

  private static void assertRetriedOnSameLogicalRequest(
      String firstRequestId, String secondRequestId) {
    XGoogSpannerRequestId first = XGoogSpannerRequestId.of(firstRequestId);
    XGoogSpannerRequestId second = XGoogSpannerRequestId.of(secondRequestId);
    assertEquals(first.getLogicalRequestKey(), second.getLogicalRequestKey());
    assertEquals(first.getAttempt() + 1, second.getAttempt());
  }

  private static com.google.spanner.v1.ResultSet singleRowReadResultSet(String value) {
    return readResultSet(Arrays.asList(value));
  }

  private static com.google.spanner.v1.ResultSet multiRowReadResultSet(String... values) {
    return readResultSet(Arrays.asList(values));
  }

  private static com.google.spanner.v1.ResultSet readResultSet(List<String> values) {
    com.google.spanner.v1.ResultSet.Builder builder =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                StructType.Field.newBuilder()
                                    .setName("k")
                                    .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                    .build())
                            .build()));
    for (String value : values) {
      builder.addRows(
          ListValue.newBuilder()
              .addValues(Value.newBuilder().setStringValue(value).build())
              .build());
    }
    return builder.build();
  }
}
