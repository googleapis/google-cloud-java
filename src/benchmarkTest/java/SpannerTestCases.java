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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableList;
import com.google.grpc.gcp.GcpManagedChannel;
import com.google.grpc.gcp.GcpManagedChannelBuilder;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.KeySet;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.SpannerGrpc.SpannerBlockingStub;
import com.google.spanner.v1.SpannerGrpc.SpannerStub;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Benchmark for SpannerGrpc operations with two different channels: GrpcGcpManagedChannel(use
 * grpc-gcp channel pool) and gio.grpc.ManagedChannel.
 */
final class SpannerTestCases {

  private static final Logger logger = Logger.getLogger(SpannerTestCases.class.getName());

  private static final String SPANNER_TARGET = "spanner.googleapis.com";
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";

  private static final String DEFAULT_PROJECT = "cloudprober-test";
  private static final String DEFAULT_INSTANCE = "test-instance";
  private static final String DEFAULT_DATABASE = "test-db";
  private static final String LARGE_TABLE = "large_table";
  private static final String TABLE = "jenny";

  private static final String API_FILE = "spannertest.json";
  private static final int MAX_SIZE_PER_COLUMN = 2621440;
  private static final int NUM_WARMUP = 10;

  private final String database;
  private final boolean isGrpcGcp;
  private final int payload;
  private final int numOfRpcs;
  private final int numOfThreads;

  SpannerTestCases(boolean isGrpcGcp, int payload, int numOfRpcs, int numOfThreads) {
    String projectId =
        System.getenv("GCP_PROJECT_ID") != null ? System.getenv("GCP_PROJECT_ID") : DEFAULT_PROJECT;
    this.database =
        String.format(
            "projects/%s/instances/%s/databases/%s", projectId, DEFAULT_INSTANCE, DEFAULT_DATABASE);
    this.isGrpcGcp = isGrpcGcp;
    this.payload = payload;
    this.numOfRpcs = numOfRpcs;
    this.numOfThreads = numOfThreads;
  }

  private static GoogleCredentials getCreds() {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);
    return creds;
  }

  private ManagedChannel getChannel() {
    ManagedChannelBuilder builder = ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);
    if (isGrpcGcp) {
      File configFile =
          new File(SpannerTestCases.class.getClassLoader().getResource(API_FILE).getFile());
      builder =
          GcpManagedChannelBuilder.forDelegateBuilder(builder).withApiConfigJsonFile(configFile);
    }
    return builder.build();
  }

  private static SpannerBlockingStub getBlockingStub(ManagedChannel channel) {
    GoogleCredentials creds = getCreds();
    return SpannerGrpc.newBlockingStub(channel)
        .withCallCredentials(MoreCallCredentials.from(creds));
  }

  private static SpannerStub getStub(ManagedChannel channel) {
    GoogleCredentials creds = getCreds();
    return SpannerGrpc.newStub(channel).withCallCredentials(MoreCallCredentials.from(creds));
  }

  void prepareTestData() throws InterruptedException {
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);

    // Because of max data size, we need to separate into different rows.
    int columnBytes = Integer.min(payload, MAX_SIZE_PER_COLUMN);
    int rows = (payload - 1) / columnBytes + 1;
    char[] charArray = new char[columnBytes];
    Arrays.fill(charArray, 'z');
    String colContent = new String(charArray);

    Session session =
        stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build());
    long start = System.currentTimeMillis();
    // Clean the data in the table.
    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder()
            .setSession(session.getName())
            .setOptions(
                TransactionOptions.newBuilder()
                    .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
                    .build())
            .build();
    Transaction txn = stub.beginTransaction(request);
    stub.commit(
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
      txn = stub.beginTransaction(request);
      stub.commit(
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
    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testListSessions() throws InterruptedException {
    System.out.println("\nTestListSessions");
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setDatabase(database).build();

    for (int i = 0; i < NUM_WARMUP; i++) {
      stub.listSessions(request);
    }

    BlockingCall<ListSessionsRequest, ListSessionsResponse> blockingCall =
        (ListSessionsRequest req) -> stub.listSessions(req);
    Func func = (List<Long> result) -> doBlockingCalls(result, numOfRpcs, request, blockingCall);
    runTest(channel, func);

    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testListSessionsAsync() throws InterruptedException {
    System.out.println("\nTestListSessionsAsync");
    ManagedChannel channel = getChannel();
    SpannerStub stub = getStub(channel);
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setDatabase(database).build();

    for (int i = 0; i < NUM_WARMUP; i++) {
      AsyncResponseObserver<ListSessionsResponse> respList = new AsyncResponseObserver<>();
      stub.listSessions(request, respList);
      respList.get();
    }
    AsyncCall<ListSessionsRequest, ListSessionsResponse> asyncCall =
        (ListSessionsRequest req, AsyncResponseObserver<ListSessionsResponse> resp) ->
            stub.listSessions(req, resp);
    Func func = (List<Long> result) -> doAsyncCalls(result, numOfRpcs, request, asyncCall);
    runTest(channel, func);

    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testExecuteSql() throws InterruptedException {
    System.out.println("\nTestExecuteSql");
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);
    Session session =
        stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build());

    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(session.getName())
            .setSql("select * FROM " + TABLE)
            .build();

    BlockingCall<ExecuteSqlRequest, ResultSet> blockingCall =
        (ExecuteSqlRequest req) -> stub.executeSql(req);
    doTestBlocking(channel, request, blockingCall);

    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testExecuteSqlAsync() throws InterruptedException {
    System.out.println("\nTestExecuteSqlAsync");
    ManagedChannel channel = getChannel();
    SpannerStub stub = getStub(channel);
    AsyncResponseObserver<Session> sessionObs = new AsyncResponseObserver<>();
    stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build(), sessionObs);

    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionObs.get().getName())
            .setSql("select * FROM " + TABLE)
            .build();

    AsyncCall<ExecuteSqlRequest, ResultSet> asyncCall =
        (ExecuteSqlRequest req, AsyncResponseObserver<ResultSet> resp) ->
            stub.executeSql(req, resp);
    doTestAsync(channel, request, asyncCall);

    deleteAndCloseAsync(stub, channel, sessionObs.get().getName());
  }

  void testPartitionQuery() throws InterruptedException {
    System.out.println("\nTestPartitionQuery");
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);
    Session session =
        stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build());

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

    BlockingCall<PartitionQueryRequest, PartitionResponse> blockingCall =
        (PartitionQueryRequest req) -> stub.partitionQuery(req);
    doTestBlocking(channel, request, blockingCall);

    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testPartitionQueryAsync() throws InterruptedException {
    System.out.println("\nTestPartitionQueryAsync");
    ManagedChannel channel = getChannel();
    SpannerStub stub = getStub(channel);
    AsyncResponseObserver<Session> sessionObs = new AsyncResponseObserver<>();
    stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build(), sessionObs);

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadOnly(TransactionOptions.ReadOnly.getDefaultInstance())
            .build();
    TransactionSelector selector = TransactionSelector.newBuilder().setBegin(options).build();
    PartitionQueryRequest request =
        PartitionQueryRequest.newBuilder()
            .setSession(sessionObs.get().getName())
            .setSql("select * FROM " + LARGE_TABLE)
            .setTransaction(selector)
            .build();

    AsyncCall<PartitionQueryRequest, PartitionResponse> asyncCall =
        (PartitionQueryRequest req, AsyncResponseObserver<PartitionResponse> resp) ->
            stub.partitionQuery(req, resp);
    doTestAsync(channel, request, asyncCall);

    deleteAndCloseAsync(stub, channel, sessionObs.get().getName());
  }

  void testRead() throws InterruptedException {
    System.out.println("\nTestRead");
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);
    Session session =
        stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build());

    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(session.getName())
            .setTable("jenny")
            .setKeySet(KeySet.newBuilder().setAll(true).build())
            .addColumns("users")
            .addColumns("firstname")
            .addColumns("lastname")
            .build();

    BlockingCall<ReadRequest, ResultSet> blockingCall = (ReadRequest req) -> stub.read(req);
    doTestBlocking(channel, request, blockingCall);

    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  void testReadAsync() throws InterruptedException {
    System.out.println("\nTestReadAsync");
    ManagedChannel channel = getChannel();
    SpannerStub stub = getStub(channel);
    AsyncResponseObserver<Session> sessionObs = new AsyncResponseObserver<>();
    stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build(), sessionObs);

    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(sessionObs.get().getName())
            .setTable("jenny")
            .setKeySet(KeySet.newBuilder().setAll(true).build())
            .addColumns("users")
            .addColumns("firstname")
            .addColumns("lastname")
            .build();

    AsyncCall<ReadRequest, ResultSet> asyncCall =
        (ReadRequest req, AsyncResponseObserver<ResultSet> resp) -> stub.read(req, resp);
    doTestAsync(channel, request, asyncCall);

    deleteAndCloseAsync(stub, channel, sessionObs.get().getName());
  }

  void testMaxConcurrentStream() throws InterruptedException {
    System.out.println("\nTestMaxConcurrentStream");
    ManagedChannel channel = getChannel();
    SpannerBlockingStub stub = getBlockingStub(channel);
    Session session =
        stub.createSession(CreateSessionRequest.newBuilder().setDatabase(database).build());

    // Warm up.
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(session.getName())
            .setSql("select * FROM " + LARGE_TABLE)
            .build();
    for (int i = 0; i < NUM_WARMUP; i++) {
      Iterator<PartialResultSet> iter = stub.executeStreamingSql(request);
      while (iter.hasNext()) {
        iter.next();
      }
    }

    // Start concurrent rpc calls.
    List<Iterator<PartialResultSet>> responses = new ArrayList<>();
    long start = System.currentTimeMillis();
    for (int i = 0; i < numOfRpcs; i++) {
      responses.add(stub.executeStreamingSql(request));
    }
    System.out.println(
        String.format(
            "Started %d ExecuteStreamingSql calls in %dms",
            numOfRpcs, System.currentTimeMillis() - start));

    // Start another rpc call using a new thread.
    Thread t = new Thread(() -> listSessionsSingleCall(stub));
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
    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  private void runTest(ManagedChannel channel, Func func) throws InterruptedException {
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
    while (result.size() < numOfRpcs) {}

    // Summerize the result.
    long dur = System.currentTimeMillis() - start;
    int numOfChannels = 1;
    if (channel instanceof GcpManagedChannel) {
      numOfChannels = ((GcpManagedChannel) channel).getNumberOfChannels();
    }
    Collections.sort(result);
    System.out.println(
        String.format(
            "Number of threads: %d\t "
                + "Number of Channels: %d\n"
                + "\t\tAvg"
                + "\tMin"
                + "\tMed"
                + "\tp90"
                + "\tp99"
                + "\tp100"
                + "\tQPS\n"
                + "  Time(ms)\t%d\t%d\t%d\t%d\t%d\t%d\t%f",
            numOfThreads,
            numOfChannels,
            result.stream().mapToLong(Long::longValue).sum() / result.size(),
            result.get(0),
            result.get((int) (result.size() * 0.5)),
            result.get((int) (result.size() * 0.9)),
            result.get((int) (result.size() * 0.99)),
            result.get(result.size() - 1),
            numOfRpcs * numOfThreads / (double) dur));
  }

  private <ReqT, RespT> void doTestBlocking(
      ManagedChannel channel, ReqT request, BlockingCall<ReqT, RespT> blockingCall)
      throws InterruptedException {
    // Do the warm up.
    doBlockingCalls(null, NUM_WARMUP, request, blockingCall);

    // Run the actual benchmark.
    Func func = (List<Long> result) -> doBlockingCalls(result, numOfRpcs, request, blockingCall);

    // Will need to run in different threads.
    runTest(channel, func);
  }

  private <ReqT, RespT> void doTestAsync(
      ManagedChannel channel, ReqT request, AsyncCall<ReqT, RespT> asyncCall)
      throws InterruptedException {
    // Do the warm up.
    doAsyncCalls(null, NUM_WARMUP, request, asyncCall);

    // Run the actual benchmark.
    Func func = (List<Long> result) -> doAsyncCalls(result, numOfRpcs, request, asyncCall);

    // Will need to run in different threads.
    runTest(channel, func);
  }

  private <ReqT, RespT> void doBlockingCalls(
      List<Long> result, int iters, ReqT request, BlockingCall blockingCall) {
    for (int i = 0; i < iters; i++) {
      long start = System.currentTimeMillis();
      blockingCall.call(request);
      long dur = System.currentTimeMillis() - start;
      if (result != null) {
        result.add(dur);
      }
    }
  }

  private <ReqT, RespT> void doAsyncCalls(
      List<Long> result, int iters, ReqT request, AsyncCall asyncCall) {
    List<AsyncResponseObserver<RespT>> responses = new ArrayList<>();
    for (int i = 0; i < iters; i++) {
      AsyncResponseObserver<RespT> resp = new AsyncResponseObserver<>(result);
      asyncCall.call(request, resp);
      responses.add(resp);
    }
    for (AsyncResponseObserver<RespT> resp : responses) {
      resp.get();
    }
  }

  private void listSessionsSingleCall(SpannerBlockingStub stub) {
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setDatabase(database).build();
    long start = System.currentTimeMillis();
    stub.listSessions(request);
    System.out.println(
        String.format(
            "-- Finished executing listSessions in %d ms in another thread. -- ",
            System.currentTimeMillis() - start));
  }

  private static void deleteAndCloseAsync(SpannerStub stub, ManagedChannel channel, String name)
      throws InterruptedException {
    AsyncResponseObserver<Empty> deleteObs = new AsyncResponseObserver<>();
    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(name).build(), deleteObs);
    deleteObs.get();
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  private interface Func {
    void operate(List<Long> result);
  }

  private interface AsyncCall<ReqT, RespT> {
    void call(ReqT request, AsyncResponseObserver<RespT> obs);
  }

  private interface BlockingCall<ReqT, RespT> {
    RespT call(ReqT request);
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {
    private final CountDownLatch finishLatch = new CountDownLatch(1);
    private RespT response = null;
    private List<Long> res = null;
    private long start;

    private AsyncResponseObserver() {}

    private AsyncResponseObserver(List<Long> res) {
      this.res = res;
      start = System.currentTimeMillis();
    }

    public RespT get() {
      try {
        finishLatch.await(1, TimeUnit.MINUTES);
      } catch (InterruptedException e) {
        logger.warning(e.getMessage());
      }
      return response;
    }

    @Override
    public void onNext(RespT response) {
      this.response = response;
    }

    @Override
    public void onError(Throwable t) {
      finishLatch.countDown();
    }

    @Override
    public void onCompleted() {
      if (res != null) {
        res.add(System.currentTimeMillis() - start);
      }
      finishLatch.countDown();
    }
  }
}
