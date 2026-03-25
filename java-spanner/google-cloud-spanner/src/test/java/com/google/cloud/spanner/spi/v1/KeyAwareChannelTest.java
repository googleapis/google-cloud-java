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

package com.google.cloud.spanner.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.Tablet;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyAwareChannelTest {
  private static final String DEFAULT_ADDRESS = "default:1234";
  private static final String SESSION =
      "projects/p/instances/i/databases/d/sessions/test-session-id";

  @Test
  public void cancelBeforeStartPreservesTrailersAndSkipsDelegateCreation() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);

    Metadata causeTrailers = new Metadata();
    Metadata.Key<String> key = Metadata.Key.of("debug", Metadata.ASCII_STRING_MARSHALLER);
    causeTrailers.put(key, "timeout");
    RuntimeException cause =
        Status.DEADLINE_EXCEEDED
            .withDescription("server timeout")
            .asRuntimeException(causeTrailers);

    call.cancel("cancelled by client", cause);
    CapturingListener<ResultSet> listener = new CapturingListener<>();
    call.start(listener, new Metadata());

    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(0);
    assertThat(listener.closeCount).isEqualTo(1);
    assertThat(listener.closedStatus.getCode()).isEqualTo(Status.Code.CANCELLED);
    assertThat(listener.closedStatus.getDescription()).isEqualTo("cancelled by client");
    assertThat(listener.closedTrailers.get(key)).isEqualTo("timeout");
  }

  @Test
  public void cancelAfterStartBeforeSendSkipsDelegateCreation() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);

    CapturingListener<ResultSet> listener = new CapturingListener<>();
    call.start(listener, new Metadata());
    call.cancel("cancel", null);
    call.sendMessage(ExecuteSqlRequest.newBuilder().setSession(SESSION).build());

    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(0);
    assertThat(listener.closeCount).isEqualTo(1);
    assertThat(listener.closedStatus.getCode()).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  public void cancelAfterDelegateCreationDelegatesToUnderlyingCall() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);

    CapturingListener<ResultSet> listener = new CapturingListener<>();
    call.start(listener, new Metadata());
    call.sendMessage(ExecuteSqlRequest.newBuilder().setSession(SESSION).build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> delegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();

    RuntimeException cause = new RuntimeException("boom");
    call.cancel("cancel now", cause);

    assertThat(delegate.cancelCalled).isTrue();
    assertThat(delegate.cancelMessage).isEqualTo("cancel now");
    assertThat(delegate.cancelCause).isSameInstanceAs(cause);
    assertThat(listener.closeCount).isEqualTo(0);
  }

  @Test
  public void sendMessageBeforeStartThrows() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);

    assertThrows(
        IllegalStateException.class,
        () -> call.sendMessage(ExecuteSqlRequest.newBuilder().setSession(SESSION).build()));
  }

  @Test
  public void deadlineExceededFromDelegateIsForwardedToListener() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    CapturingListener<ResultSet> listener = new CapturingListener<>();

    call.start(listener, new Metadata());
    call.sendMessage(ExecuteSqlRequest.newBuilder().setSession(SESSION).build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> delegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();

    Metadata trailers = new Metadata();
    Metadata.Key<String> key = Metadata.Key.of("timeout", Metadata.ASCII_STRING_MARSHALLER);
    trailers.put(key, "true");
    Status status = Status.DEADLINE_EXCEEDED.withDescription("rpc timeout");
    delegate.emitOnClose(status, trailers);

    assertThat(listener.closeCount).isEqualTo(1);
    assertThat(listener.closedStatus).isEqualTo(status);
    assertThat(listener.closedTrailers.get(key)).isEqualTo("true");
  }

  @Test
  public void timeoutOnCommitClearsTransactionAffinity() throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("tx-1");

    ClientCall<BeginTransactionRequest, Transaction> beginCall =
        harness.channel.newCall(SpannerGrpc.getBeginTransactionMethod(), CallOptions.DEFAULT);
    beginCall.start(new CapturingListener<Transaction>(), new Metadata());
    beginCall.sendMessage(BeginTransactionRequest.newBuilder().setSession(SESSION).build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<BeginTransactionRequest, Transaction> beginDelegate =
        (RecordingClientCall<BeginTransactionRequest, Transaction>)
            harness.defaultManagedChannel.latestCall();
    beginDelegate.emitOnMessage(Transaction.newBuilder().setId(transactionId).build());
    beginDelegate.emitOnClose(Status.OK, new Metadata());

    ClientCall<CommitRequest, CommitResponse> commitCall =
        harness.channel.newCall(SpannerGrpc.getCommitMethod(), CallOptions.DEFAULT);
    commitCall.start(new CapturingListener<CommitResponse>(), new Metadata());
    commitCall.sendMessage(
        CommitRequest.newBuilder().setSession(SESSION).setTransactionId(transactionId).build());

    assertThat(harness.endpointCache.getCount(DEFAULT_ADDRESS)).isEqualTo(1);

    @SuppressWarnings("unchecked")
    RecordingClientCall<CommitRequest, CommitResponse> commitDelegate =
        (RecordingClientCall<CommitRequest, CommitResponse>)
            harness.defaultManagedChannel.latestCall();
    commitDelegate.emitOnClose(Status.DEADLINE_EXCEEDED, new Metadata());

    ClientCall<RollbackRequest, Empty> rollbackCall =
        harness.channel.newCall(SpannerGrpc.getRollbackMethod(), CallOptions.DEFAULT);
    rollbackCall.start(new CapturingListener<Empty>(), new Metadata());
    rollbackCall.sendMessage(
        RollbackRequest.newBuilder().setSession(SESSION).setTransactionId(transactionId).build());

    assertThat(harness.endpointCache.getCount(DEFAULT_ADDRESS)).isEqualTo(1);
  }

  @Test
  public void requestAfterCancelBeforeSendIsIgnored() throws Exception {
    TestHarness harness = createHarness();
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);

    CapturingListener<ResultSet> listener = new CapturingListener<>();
    call.start(listener, new Metadata());
    call.cancel("cancel", null);
    call.request(10);
    call.sendMessage(ExecuteSqlRequest.newBuilder().setSession(SESSION).build());

    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(0);
    assertThat(listener.closeCount).isEqualTo(1);
    assertThat(listener.closedStatus.getCode()).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  public void resultSetCacheUpdateRoutesSubsequentRequest() throws Exception {
    TestHarness harness = createHarness();
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("a")).build())
            .build();

    ClientCall<ExecuteSqlRequest, ResultSet> firstCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    firstCall.start(new CapturingListener<ResultSet>(), new Metadata());
    firstCall.sendMessage(request);

    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> firstDelegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();

    CacheUpdate cacheUpdate =
        CacheUpdate.newBuilder()
            .setDatabaseId(7L)
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(9L)
                    .setSplitId(1L)
                    .setGeneration(bytes("1")))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(9L)
                    .setGeneration(bytes("1"))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(3L)
                            .setServerAddress("routed:1234")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .build();

    firstDelegate.emitOnMessage(ResultSet.newBuilder().setCacheUpdate(cacheUpdate).build());

    ClientCall<ExecuteSqlRequest, ResultSet> secondCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    secondCall.start(new CapturingListener<ResultSet>(), new Metadata());
    secondCall.sendMessage(request);

    assertThat(harness.endpointCache.callCountForAddress(DEFAULT_ADDRESS)).isEqualTo(1);
    assertThat(harness.endpointCache.callCountForAddress("routed:1234")).isEqualTo(1);
  }

  @Test
  public void readOnlyTransactionRoutesEachReadIndependently() throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("ro-tx-1");

    // 1. Begin a read-only transaction (stale read).
    ClientCall<BeginTransactionRequest, Transaction> beginCall =
        harness.channel.newCall(SpannerGrpc.getBeginTransactionMethod(), CallOptions.DEFAULT);
    CapturingListener<Transaction> beginListener = new CapturingListener<>();
    beginCall.start(beginListener, new Metadata());
    beginCall.sendMessage(
        BeginTransactionRequest.newBuilder()
            .setSession(SESSION)
            .setOptions(
                TransactionOptions.newBuilder()
                    .setReadOnly(
                        TransactionOptions.ReadOnly.newBuilder()
                            .setReturnReadTimestamp(true)
                            .build()))
            .build());

    // BeginTransaction goes to default channel.
    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(1);

    @SuppressWarnings("unchecked")
    RecordingClientCall<BeginTransactionRequest, Transaction> beginDelegate =
        (RecordingClientCall<BeginTransactionRequest, Transaction>)
            harness.defaultManagedChannel.latestCall();
    beginDelegate.emitOnMessage(Transaction.newBuilder().setId(transactionId).build());
    beginDelegate.emitOnClose(Status.OK, new Metadata());

    // 2. Populate cache with routing data for two different key ranges.
    CacheUpdate cacheUpdate =
        CacheUpdate.newBuilder()
            .setDatabaseId(7L)
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("m"))
                    .setGroupUid(1L)
                    .setSplitId(1L)
                    .setGeneration(bytes("1")))
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("m"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(2L)
                    .setSplitId(2L)
                    .setGeneration(bytes("1")))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(1L)
                    .setGeneration(bytes("1"))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(1L)
                            .setServerAddress("server-a:1234")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(2L)
                    .setGeneration(bytes("1"))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2L)
                            .setServerAddress("server-b:1234")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .build();

    // Seed the cache via a dummy query response with cache update.
    ClientCall<ExecuteSqlRequest, ResultSet> seedCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    seedCall.start(new CapturingListener<ResultSet>(), new Metadata());
    seedCall.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("a")).build())
            .build());
    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> seedDelegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();
    seedDelegate.emitOnMessage(ResultSet.newBuilder().setCacheUpdate(cacheUpdate).build());

    // 3. Send a streaming read with key in range [a, m) → should go to server-a.
    ClientCall<ReadRequest, PartialResultSet> readCallA =
        harness.channel.newCall(SpannerGrpc.getStreamingReadMethod(), CallOptions.DEFAULT);
    readCallA.start(new CapturingListener<PartialResultSet>(), new Metadata());
    readCallA.sendMessage(
        ReadRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(TransactionSelector.newBuilder().setId(transactionId))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("b")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-a:1234")).isEqualTo(1);

    // 4. Send an ExecuteStreamingSql with key in range [m, z) → should go to server-b.
    ClientCall<ExecuteSqlRequest, PartialResultSet> queryCallB =
        harness.channel.newCall(SpannerGrpc.getExecuteStreamingSqlMethod(), CallOptions.DEFAULT);
    queryCallB.start(new CapturingListener<PartialResultSet>(), new Metadata());
    queryCallB.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(TransactionSelector.newBuilder().setId(transactionId))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("n")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-b:1234")).isEqualTo(1);

    // Neither read was pinned to the default host (besides the initial begin + seed).
    // default had: 1 begin + 1 seed = 2 calls
    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(2);
  }

  @Test
  public void readOnlyInlinedBeginExecuteSqlRoutesSubsequentRequestsIndependently()
      throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("ro-inline-sql");

    seedCache(harness, createTwoRangeCacheUpdate());

    // First query begins a read-only transaction inline and routes to server-a.
    ClientCall<ExecuteSqlRequest, ResultSet> firstCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    firstCall.start(new CapturingListener<ResultSet>(), new Metadata());
    firstCall.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(
                TransactionSelector.newBuilder()
                    .setBegin(
                        TransactionOptions.newBuilder()
                            .setReadOnly(
                                TransactionOptions.ReadOnly.newBuilder()
                                    .setReturnReadTimestamp(true)
                                    .build())
                            .build()))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("b")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-a:1234")).isEqualTo(1);

    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> firstDelegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.endpointCache.latestCallForAddress("server-a:1234");
    firstDelegate.emitOnMessage(
        ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setTransaction(Transaction.newBuilder().setId(transactionId)))
            .build());

    // Second query in same txn should route by key to server-b, not affinity-pin to server-a.
    ClientCall<ExecuteSqlRequest, ResultSet> secondCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    secondCall.start(new CapturingListener<ResultSet>(), new Metadata());
    secondCall.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(TransactionSelector.newBuilder().setId(transactionId))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("n")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-a:1234")).isEqualTo(1);
    assertThat(harness.endpointCache.callCountForAddress("server-b:1234")).isEqualTo(1);
    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(1);
  }

  @Test
  public void readOnlyInlinedBeginReadRoutesSubsequentRequestsIndependently() throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("ro-inline-read");

    seedCache(harness, createTwoRangeCacheUpdate());

    // First read begins a read-only transaction inline and routes to server-a.
    ClientCall<ReadRequest, PartialResultSet> firstCall =
        harness.channel.newCall(SpannerGrpc.getStreamingReadMethod(), CallOptions.DEFAULT);
    firstCall.start(new CapturingListener<PartialResultSet>(), new Metadata());
    firstCall.sendMessage(
        ReadRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(
                TransactionSelector.newBuilder()
                    .setBegin(
                        TransactionOptions.newBuilder()
                            .setReadOnly(
                                TransactionOptions.ReadOnly.newBuilder()
                                    .setReturnReadTimestamp(true)
                                    .build())
                            .build()))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("b")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-a:1234")).isEqualTo(1);

    @SuppressWarnings("unchecked")
    RecordingClientCall<ReadRequest, PartialResultSet> firstDelegate =
        (RecordingClientCall<ReadRequest, PartialResultSet>)
            harness.endpointCache.latestCallForAddress("server-a:1234");
    firstDelegate.emitOnMessage(
        PartialResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setTransaction(Transaction.newBuilder().setId(transactionId)))
            .build());

    // Second read in same txn should route by key to server-b, not affinity-pin to server-a.
    ClientCall<ReadRequest, PartialResultSet> secondCall =
        harness.channel.newCall(SpannerGrpc.getStreamingReadMethod(), CallOptions.DEFAULT);
    secondCall.start(new CapturingListener<PartialResultSet>(), new Metadata());
    secondCall.sendMessage(
        ReadRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(TransactionSelector.newBuilder().setId(transactionId))
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("n")).build())
            .build());

    assertThat(harness.endpointCache.callCountForAddress("server-a:1234")).isEqualTo(1);
    assertThat(harness.endpointCache.callCountForAddress("server-b:1234")).isEqualTo(1);
    assertThat(harness.defaultManagedChannel.callCount()).isEqualTo(1);
  }

  @Test
  public void readOnlyTransactionDoesNotRecordAffinity() throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("ro-tx-2");

    // Begin a read-only transaction.
    ClientCall<BeginTransactionRequest, Transaction> beginCall =
        harness.channel.newCall(SpannerGrpc.getBeginTransactionMethod(), CallOptions.DEFAULT);
    beginCall.start(new CapturingListener<Transaction>(), new Metadata());
    beginCall.sendMessage(
        BeginTransactionRequest.newBuilder()
            .setSession(SESSION)
            .setOptions(
                TransactionOptions.newBuilder()
                    .setReadOnly(
                        TransactionOptions.ReadOnly.newBuilder()
                            .setReturnReadTimestamp(true)
                            .build()))
            .build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<BeginTransactionRequest, Transaction> beginDelegate =
        (RecordingClientCall<BeginTransactionRequest, Transaction>)
            harness.defaultManagedChannel.latestCall();
    beginDelegate.emitOnMessage(Transaction.newBuilder().setId(transactionId).build());
    beginDelegate.emitOnClose(Status.OK, new Metadata());

    // No affinity should be recorded for the default endpoint.
    // Verify by checking that the endpoint cache was never queried for affinity lookup.
    // The default endpoint getCount tracks affinity lookups.
    assertThat(harness.endpointCache.getCount(DEFAULT_ADDRESS)).isEqualTo(0);

    // Send a read using the transaction ID (no cache populated, so falls back to default).
    ClientCall<ExecuteSqlRequest, ResultSet> readCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    readCall.start(new CapturingListener<ResultSet>(), new Metadata());
    readCall.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setTransaction(TransactionSelector.newBuilder().setId(transactionId))
            .build());

    // The read goes to default (no cache data), but NOT because of affinity.
    // No affinity lookup should have been performed for the read-only txn.
    assertThat(harness.endpointCache.getCount(DEFAULT_ADDRESS)).isEqualTo(0);

    // Now receive a response with the transaction ID — should NOT record affinity.
    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> readDelegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();
    readDelegate.emitOnMessage(
        ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setTransaction(Transaction.newBuilder().setId(transactionId)))
            .build());

    // Still no affinity recorded.
    assertThat(harness.endpointCache.getCount(DEFAULT_ADDRESS)).isEqualTo(0);
  }

  @Test
  public void readOnlyTransactionCleanupOnClose() throws Exception {
    TestHarness harness = createHarness();
    ByteString transactionId = ByteString.copyFromUtf8("ro-tx-3");

    // Begin a read-only transaction.
    ClientCall<BeginTransactionRequest, Transaction> beginCall =
        harness.channel.newCall(SpannerGrpc.getBeginTransactionMethod(), CallOptions.DEFAULT);
    beginCall.start(new CapturingListener<Transaction>(), new Metadata());
    beginCall.sendMessage(
        BeginTransactionRequest.newBuilder()
            .setSession(SESSION)
            .setOptions(
                TransactionOptions.newBuilder()
                    .setReadOnly(
                        TransactionOptions.ReadOnly.newBuilder()
                            .setReturnReadTimestamp(true)
                            .build()))
            .build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<BeginTransactionRequest, Transaction> beginDelegate =
        (RecordingClientCall<BeginTransactionRequest, Transaction>)
            harness.defaultManagedChannel.latestCall();
    beginDelegate.emitOnMessage(Transaction.newBuilder().setId(transactionId).build());
    beginDelegate.emitOnClose(Status.OK, new Metadata());

    // Clear transaction affinity (simulates MultiUseReadOnlyTransaction.close()).
    harness.channel.clearTransactionAffinity(transactionId);
  }

  private static CacheUpdate createTwoRangeCacheUpdate() {
    return CacheUpdate.newBuilder()
        .setDatabaseId(7L)
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes("a"))
                .setLimitKey(bytes("m"))
                .setGroupUid(1L)
                .setSplitId(1L)
                .setGeneration(bytes("1")))
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes("m"))
                .setLimitKey(bytes("z"))
                .setGroupUid(2L)
                .setSplitId(2L)
                .setGeneration(bytes("1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(1L)
                .setGeneration(bytes("1"))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(1L)
                        .setServerAddress("server-a:1234")
                        .setIncarnation(bytes("1"))
                        .setDistance(0)))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(2L)
                .setGeneration(bytes("1"))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(2L)
                        .setServerAddress("server-b:1234")
                        .setIncarnation(bytes("1"))
                        .setDistance(0)))
        .build();
  }

  private static void seedCache(TestHarness harness, CacheUpdate cacheUpdate) {
    ClientCall<ExecuteSqlRequest, ResultSet> seedCall =
        harness.channel.newCall(SpannerGrpc.getExecuteSqlMethod(), CallOptions.DEFAULT);
    seedCall.start(new CapturingListener<ResultSet>(), new Metadata());
    seedCall.sendMessage(
        ExecuteSqlRequest.newBuilder()
            .setSession(SESSION)
            .setRoutingHint(RoutingHint.newBuilder().setKey(bytes("a")).build())
            .build());

    @SuppressWarnings("unchecked")
    RecordingClientCall<ExecuteSqlRequest, ResultSet> seedDelegate =
        (RecordingClientCall<ExecuteSqlRequest, ResultSet>)
            harness.defaultManagedChannel.latestCall();
    seedDelegate.emitOnMessage(ResultSet.newBuilder().setCacheUpdate(cacheUpdate).build());
  }

  private static TestHarness createHarness() throws IOException {
    FakeEndpointCache endpointCache = new FakeEndpointCache(DEFAULT_ADDRESS);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().setEndpoint("localhost:9999").build();
    KeyAwareChannel channel = KeyAwareChannel.create(provider, baseProvider -> endpointCache);
    return new TestHarness(channel, endpointCache, endpointCache.defaultManagedChannel());
  }

  private static final class TestHarness {
    private final KeyAwareChannel channel;
    private final FakeEndpointCache endpointCache;
    private final FakeManagedChannel defaultManagedChannel;

    private TestHarness(
        KeyAwareChannel channel,
        FakeEndpointCache endpointCache,
        FakeManagedChannel defaultManagedChannel) {
      this.channel = channel;
      this.endpointCache = endpointCache;
      this.defaultManagedChannel = defaultManagedChannel;
    }
  }

  private static final class CapturingListener<T> extends ClientCall.Listener<T> {
    private int closeCount;
    @Nullable private Status closedStatus;
    @Nullable private Metadata closedTrailers;

    @Override
    public void onClose(Status status, Metadata trailers) {
      this.closeCount++;
      this.closedStatus = status;
      this.closedTrailers = trailers;
    }
  }

  private static final class FakeEndpointCache implements ChannelEndpointCache {
    private final String defaultAddress;
    private final FakeEndpoint defaultEndpoint;
    private final Map<String, FakeEndpoint> endpoints = new HashMap<>();
    private final Map<String, Integer> getCount = new HashMap<>();

    private FakeEndpointCache(String defaultAddress) {
      this.defaultAddress = defaultAddress;
      this.defaultEndpoint = new FakeEndpoint(defaultAddress);
    }

    @Override
    public ChannelEndpoint defaultChannel() {
      return defaultEndpoint;
    }

    @Override
    public ChannelEndpoint get(String address) {
      getCount.put(address, getCount.getOrDefault(address, 0) + 1);
      if (defaultAddress.equals(address)) {
        return defaultEndpoint;
      }
      return endpoints.computeIfAbsent(address, FakeEndpoint::new);
    }

    @Override
    public void evict(String address) {
      endpoints.remove(address);
    }

    @Override
    public void shutdown() {
      defaultEndpoint.channel.shutdown();
      for (FakeEndpoint endpoint : endpoints.values()) {
        endpoint.channel.shutdown();
      }
      endpoints.clear();
    }

    int getCount(String address) {
      return getCount.getOrDefault(address, 0);
    }

    FakeManagedChannel defaultManagedChannel() {
      return defaultEndpoint.channel;
    }

    int callCountForAddress(String address) {
      if (defaultAddress.equals(address)) {
        return defaultEndpoint.channel.callCount();
      }
      FakeEndpoint endpoint = endpoints.get(address);
      return endpoint == null ? 0 : endpoint.channel.callCount();
    }

    RecordingClientCall<?, ?> latestCallForAddress(String address) {
      if (defaultAddress.equals(address)) {
        return defaultEndpoint.channel.latestCall();
      }
      FakeEndpoint endpoint = endpoints.get(address);
      if (endpoint == null) {
        throw new IllegalStateException("No endpoint for address: " + address);
      }
      return endpoint.channel.latestCall();
    }
  }

  private static final class FakeEndpoint implements ChannelEndpoint {
    private final String address;
    private final FakeManagedChannel channel;

    private FakeEndpoint(String address) {
      this.address = address;
      this.channel = new FakeManagedChannel(address);
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      return true;
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    private final String authority;
    private final List<RecordingClientCall<?, ?>> calls = new ArrayList<>();
    private boolean shutdown;

    private FakeManagedChannel(String authority) {
      this.authority = authority;
    }

    @Override
    public ManagedChannel shutdown() {
      shutdown = true;
      return this;
    }

    @Override
    public ManagedChannel shutdownNow() {
      shutdown = true;
      return this;
    }

    @Override
    public boolean isShutdown() {
      return shutdown;
    }

    @Override
    public boolean isTerminated() {
      return shutdown;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return shutdown;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      RecordingClientCall<RequestT, ResponseT> call = new RecordingClientCall<>();
      calls.add(call);
      return call;
    }

    @Override
    public String authority() {
      return authority;
    }

    int callCount() {
      return calls.size();
    }

    RecordingClientCall<?, ?> latestCall() {
      return calls.get(calls.size() - 1);
    }
  }

  private static final class RecordingClientCall<RequestT, ResponseT>
      extends ClientCall<RequestT, ResponseT> {
    @Nullable private ClientCall.Listener<ResponseT> listener;
    private boolean cancelCalled;
    @Nullable private String cancelMessage;
    @Nullable private Throwable cancelCause;

    @Override
    public void start(ClientCall.Listener<ResponseT> responseListener, Metadata headers) {
      this.listener = responseListener;
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      this.cancelCalled = true;
      this.cancelMessage = message;
      this.cancelCause = cause;
    }

    @Override
    public void halfClose() {}

    @Override
    public void sendMessage(RequestT message) {}

    void emitOnMessage(ResponseT response) {
      if (listener != null) {
        listener.onMessage(response);
      }
    }

    void emitOnClose(Status status, Metadata trailers) {
      if (listener != null) {
        listener.onClose(status, trailers);
      }
    }
  }

  private static ByteString bytes(String value) {
    return ByteString.copyFromUtf8(value);
  }
}
