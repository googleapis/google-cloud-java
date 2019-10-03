/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.v1.SpannerClient;
import com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;
import com.google.cloud.spanner.v1.SpannerSettings;
import com.google.common.collect.ImmutableList;
import com.google.grpc.gcp.GcpManagedChannelBuilder;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.KeySet;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Benchmark for the lower level gapic-generated Spanner client
 * (com.google.cloud.spanner.v1.SpannerClient) with two different implementations of channel pool:
 * <1> Channel pool by com.google.api.gax.grpc. <2> Channel pool by grpc-gcp-java.
 */
final class SpannerClientV1TestCases {

  private static final Logger logger = Logger.getLogger(SpannerTestCases.class.getName());

  private static final String SPANNER_TARGET = "spanner.googleapis.com";
  private static final String DATABASE =
      "projects/cloudprober-test/instances/test-instance/databases/test-db";
  private static final String LARGE_TABLE = "large_table";
  private static final String TABLE = "jenny";
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
  private static final String API_FILE = "spannertest.json";
  private static final int MAX_SIZE_PER_COLUMN = 2621440;
  private static final int NUM_WARMUP = 10;

  // This should be the same as channelpool-maxsize in the ApiConfig JSON file.
  private static final int DEFAULT_CHANNEL_POOL = 2;

  private final boolean isGrpcGcp;
  private final int payload;
  private final int numOfRpcs;
  private final int numOfThreads;

  SpannerClientV1TestCases(boolean isGrpcGcp, int payload, int numOfRpcs, int numOfThreads) {
    this.isGrpcGcp = isGrpcGcp;
    this.payload = payload;
    this.numOfRpcs = numOfRpcs;
    this.numOfThreads = numOfThreads;
  }

  void prepareTestData() throws InterruptedException {
    int columnBytes = Integer.min(payload, MAX_SIZE_PER_COLUMN);
    int rows = (payload - 1) / columnBytes + 1;
    char[] charArray = new char[columnBytes];
    Arrays.fill(charArray, 'z');
    String colContent = new String(charArray);
    SpannerClient client = getClient();
    Session session =
        client.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());
    long start = System.currentTimeMillis();

    // Clean the existing data.
    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder()
            .setSession(session.getName())
            .setOptions(
                TransactionOptions.newBuilder()
                    .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
                    .build())
            .build();
    Transaction txn = client.beginTransaction(request);
    client.commit(
        CommitRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder()
                    .setDelete(
                        Mutation.Delete.newBuilder()
                            .setTable(LARGE_TABLE)
                            .setKeySet(KeySet.newBuilder().setAll(true).build())
                            .build())
                    .build())
            .setSession(session.getName())
            .setTransactionId(txn.getId())
            .build());
    System.out.println(
        String.format(
            "\nDeleted the previous large_table in %d ms.", System.currentTimeMillis() - start));

    // Add the payload data.
    start = System.currentTimeMillis();
    for (int i = 0; i < rows; i++) {
      txn = client.beginTransaction(request);
      client.commit(
          CommitRequest.newBuilder()
              .addMutations(
                  Mutation.newBuilder()
                      .setInsertOrUpdate(
                          Mutation.Write.newBuilder()
                              .addColumns("id")
                              .addColumns("data")
                              .addValues(
                                  ListValue.newBuilder()
                                      .addValues(Value.newBuilder().setStringValue("payload" + i))
                                      .addValues(Value.newBuilder().setStringValue(colContent))
                                      .build())
                              .setTable(LARGE_TABLE)
                              .build())
                      .build())
              .setSession(session.getName())
              .setTransactionId(txn.getId())
              .build());
    }
    System.out.println(
        String.format(
            "Successfully added ColumnBytes: %d, Rows: %d to large_table in %d ms.",
            columnBytes, rows, System.currentTimeMillis() - start));
    cleanUpClient(client, session.getName());
  }

  void testListSessions() throws InterruptedException {
    System.out.println("\nTestListSessions");
    SpannerClient client = getClient();
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < NUM_WARMUP; i++) {
      client.listSessions(request);
    }

    // for (Session element : spannerClient.listSessions(request).iterateAll())
    RpcCall<ListSessionsRequest, ListSessionsPagedResponse> rpcCall =
        (ListSessionsRequest req) -> client.listSessions(req);
    doTestBlocking(request, rpcCall);
    client.shutdown();
    client.awaitTermination(5, TimeUnit.SECONDS);
  }

  void testExecuteSql() throws InterruptedException {
    System.out.println("\nTestExecuteSql");
    SpannerClient client = getClient();
    Session session =
        client.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());

    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(session.getName())
            .setSql("select * FROM " + TABLE)
            .build();

    RpcCall<ExecuteSqlRequest, ResultSet> rpcCall =
        (ExecuteSqlRequest req) -> client.executeSql(req);
    doTestBlocking(request, rpcCall);
    cleanUpClient(client, session.getName());
  }

  void testPartitionQuery() throws InterruptedException {
    System.out.println("\nTestPartitionQuery");
    SpannerClient client = getClient();
    Session session =
        client.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadOnly(TransactionOptions.ReadOnly.getDefaultInstance())
            .build();
    TransactionSelector selector = TransactionSelector.newBuilder().setBegin(options).build();
    PartitionQueryRequest request =
        PartitionQueryRequest.newBuilder()
            .setSession(session.getName())
            .setSql("select * FROM " + LARGE_TABLE)
            .setTransaction(selector)
            .build();

    RpcCall<PartitionQueryRequest, PartitionResponse> rpcCall =
        (PartitionQueryRequest req) -> client.partitionQuery(req);
    doTestBlocking(request, rpcCall);
    cleanUpClient(client, session.getName());
  }

  void testRead() throws InterruptedException {
    System.out.println("\nTestRead");
    SpannerClient client = getClient();
    Session session =
        client.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());

    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(session.getName())
            .setTable(TABLE)
            .setKeySet(KeySet.newBuilder().setAll(true).build())
            .addColumns("users")
            .addColumns("firstname")
            .addColumns("lastname")
            .build();

    RpcCall<ReadRequest, ResultSet> rpcCall = (ReadRequest req) -> client.read(req);
    doTestBlocking(request, rpcCall);
    cleanUpClient(client, session.getName());
  }

  void testMaxConcurrentStream() throws InterruptedException {
    System.out.println("\nTestMaxConcurrentStream");
    SpannerClient client = getClient();
    Session session =
        client.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());

    // Warm up.
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(session.getName())
            .setSql("select * FROM " + LARGE_TABLE)
            .build();
    for (int i = 0; i < NUM_WARMUP; i++) {
      Iterator<PartialResultSet> iter =
          client.executeStreamingSqlCallable().call(request).iterator();
      while (iter.hasNext()) {
        iter.next();
      }
    }

    // Start concurrent rpc calls.
    List<Iterator<PartialResultSet>> responses = new ArrayList<>();
    long start = System.currentTimeMillis();
    for (int i = 0; i < numOfRpcs; i++) {
      responses.add(client.executeStreamingSqlCallable().call(request).iterator());
    }
    System.out.println(
        String.format(
            "Started %d ExecuteStreamingSql calls in %d ms",
            numOfRpcs, System.currentTimeMillis() - start));

    // Start another rpc call using a new thread.
    Thread t = new Thread(() -> listSessionsSingleCall(client));
    t.start();

    System.out.println("I'm sleeping and will wake up after 2000ms zzzZZZZ.");
    Thread.sleep(2000);
    System.out.println("Good morning!");

    // Free one call.
    while (responses.get(0).hasNext()) {
      responses.get(0).next();
    }
    System.out.println(
        String.format("Freed one call in %dms.", System.currentTimeMillis() - start));

    // Free all the calls.
    for (int i = 1; i < responses.size(); i++) {
      Iterator<PartialResultSet> iter = responses.get(i);
      while (iter.hasNext()) {
        iter.next();
      }
    }
    System.out.println(
        String.format("Freed %d call(s) in %dms.", numOfRpcs, System.currentTimeMillis() - start));

    t.join();
    cleanUpClient(client, session.getName());
  }

  private void runTest(Func func) throws InterruptedException {
    List<Long> result = new CopyOnWriteArrayList<>();
    List<Thread> threads = new ArrayList<>();
    if (numOfThreads > 1) {
      for (int t = 0; t < numOfThreads; t++) {
        threads.add(new Thread(() -> func.operate(result)));
      }
    }
    long start = System.currentTimeMillis();
    if (numOfThreads > 1) {
      for (Thread t : threads) {
        t.start();
      }
    } else {
      func.operate(result);
    }

    for (Thread t : threads) {
      t.join();
    }
    // Waiting for all responses.
    while (result.size() < numOfRpcs * numOfThreads) {}

    // Summerize the result.
    long dur = System.currentTimeMillis() - start;
    Collections.sort(result);
    System.out.println(
        String.format(
            "Number of threads: %d\t "
                + "Total number of RPC's: %d\n"
                + "\t\tAvg"
                + "\tMin"
                + "\tMed"
                + "\tp90"
                + "\tp99"
                + "\tp100"
                + "\tQPS\n"
                + "  Time(ms)\t%d\t%d\t%d\t%d\t%d\t%d\t%f",
            numOfThreads,
            numOfThreads * numOfRpcs,
            result.stream().mapToLong(Long::longValue).sum() / result.size(),
            result.get(0),
            result.get((int) (result.size() * 0.5)),
            result.get((int) (result.size() * 0.9)),
            result.get((int) (result.size() * 0.99)),
            result.get(result.size() - 1),
            numOfRpcs * numOfThreads / (double) dur));
  }

  /**
   * Start a test. It has three steps: <1> Do warm-up calls. <2> Construct the target function. <3>
   * Run the target function with multiple threads,
   */
  private <ReqT, RespT> void doTestBlocking(ReqT request, RpcCall<ReqT, RespT> rpcCall)
      throws InterruptedException {
    // Do the warm up.
    doRpcCalls(null, NUM_WARMUP, request, rpcCall);

    // Run the actual benchmark.
    Func func = (List<Long> result) -> doRpcCalls(result, numOfRpcs, request, rpcCall);

    // Will need to run in different threads.
    runTest(func);
  }

  /** Do the actual RPC calls. */
  private static <ReqT, RespT> void doRpcCalls(
      List<Long> result, int iters, ReqT request, RpcCall rpcCall) {
    for (int i = 0; i < iters; i++) {
      long start = System.currentTimeMillis();
      rpcCall.call(request);
      long dur = System.currentTimeMillis() - start;
      if (result != null) {
        result.add(dur);
      }
    }
  }

  private static void listSessionsSingleCall(SpannerClient client) {
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setDatabase(DATABASE).build();
    long start = System.currentTimeMillis();
    client.listSessionsCallable().call(request);
    System.out.println(
        String.format(
            "Finished executing listSessions in %d ms", System.currentTimeMillis() - start));
  }

  private SpannerClient getClient() {
    // Set up credentials.
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);
    FixedCredentialsProvider provider = FixedCredentialsProvider.create(creds);

    // Set up the Spanner client.
    InstantiatingGrpcChannelProvider.Builder channelBuilder =
        InstantiatingGrpcChannelProvider.newBuilder().setPoolSize(DEFAULT_CHANNEL_POOL);

    if (isGrpcGcp) {
      File configFile =
          new File(SpannerTestCases.class.getClassLoader().getResource(API_FILE).getFile());
      ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> apiFunction =
          (ManagedChannelBuilder builder) ->
              (GcpManagedChannelBuilder.forDelegateBuilder(builder)
                  .withApiConfigJsonFile(configFile));
      channelBuilder = channelBuilder.setPoolSize(1).setChannelConfigurator(apiFunction);
    }

    SpannerClient client = null;
    try {
      SpannerSettings.Builder spannerSettingsBuilder = SpannerSettings.newBuilder();
      spannerSettingsBuilder
          .getStubSettingsBuilder()
          .setTransportChannelProvider(channelBuilder.build())
          .setCredentialsProvider(provider);

      client = SpannerClient.create(spannerSettingsBuilder.build());
    } catch (IOException e) {
      System.out.println("Failed to create the client.");
    }
    return client;
  }

  private static void cleanUpClient(SpannerClient client, String name) throws InterruptedException {
    client.deleteSession(DeleteSessionRequest.newBuilder().setName(name).build());
    client.shutdown();
    client.awaitTermination(5, TimeUnit.SECONDS);
  }

  private interface Func {
    void operate(List<Long> result);
  }

  private interface RpcCall<ReqT, RespT> {
    RespT call(ReqT request);
  }
}
