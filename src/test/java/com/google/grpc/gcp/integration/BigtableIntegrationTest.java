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

package com.google.grpc.gcp;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.BigtableGrpc.BigtableBlockingStub;
import com.google.bigtable.v2.BigtableGrpc.BigtableFutureStub;
import com.google.bigtable.v2.BigtableGrpc.BigtableStub;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowSet;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for GcpManagedChannel with Bigtable. */
@RunWith(JUnit4.class)
public class BigtableIntegrationTest {

  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int DEFAULT_MAX_STREAM = 100;
  private static final int NEW_MAX_CHANNEL = 5;
  private static final int NEW_MAX_STREAM = 5;
  private static final int MAX_MSG_SIZE = 8 * 1024 * 1024;

  private static final String TEST_APICONFIG_FILE =
      "src/test/resources/apiconfigtests/empty_method.json";
  private static final String BIGTABLE_TARGET = "bigtable.googleapis.com";
  private static final String FAMILY_NAME = "test-family";
  private static final String TABLE_NAME =
      "projects/cloudprober-test/instances/test-instance/tables/test-table";
  private static final String LARGE_TABLE_NAME =
      "projects/cloudprober-test/instances/test-instance/tables/test-large-table";
  private static final String COLUMN_NAME = "col-";
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder builder;

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

  private BigtableBlockingStub getBigtableBlockingStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    BigtableBlockingStub stub =
        BigtableGrpc.newBlockingStub(gcpChannel)
            .withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private BigtableStub getBigtableStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    BigtableStub stub =
        BigtableGrpc.newStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private BigtableFutureStub getBigtableFutureStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    BigtableFutureStub stub =
        BigtableGrpc.newFutureStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private boolean runManyManyStreamsNormalChannel() {
    ManagedChannel channel = builder.build();
    GoogleCredentials creds = getCreds();
    BigtableBlockingStub stubNormal =
        BigtableGrpc.newBlockingStub(channel).withCallCredentials(MoreCallCredentials.from(creds));

    ReadRowsRequest request = ReadRowsRequest.newBuilder().setTableName(LARGE_TABLE_NAME).build();
    for (int i = 0; i < DEFAULT_MAX_STREAM + 5; i++) {
      Iterator<ReadRowsResponse> iterNormal = stubNormal.readRows(request);
      iterNormal.next();
    }
    return true;
  }

  private boolean runManyManyStreamsGcpChannel() throws InterruptedException {
    BigtableBlockingStub stub = getBigtableBlockingStub();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setTableName(LARGE_TABLE_NAME).build();

    for (int i = 0; i < DEFAULT_MAX_STREAM + 5; i++) {
      Iterator<ReadRowsResponse> iterNormal = stub.readRows(request);
      iterNormal.next();
    }
    return true;
  }

  @Before
  public void setupChannel() throws InterruptedException {
    builder =
        ManagedChannelBuilder.forAddress(BIGTABLE_TARGET, 443).maxInboundMessageSize(MAX_MSG_SIZE);
    gcpChannel = new GcpManagedChannel(builder);
  }

  @After
  public void shutdownChannel() {
    gcpChannel.shutdownNow();
  }

  @Rule public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testMutateRowReuse() throws Exception {
    BigtableBlockingStub stub = getBigtableBlockingStub();
    MutateRowRequest request = getMutateRequest("test-mutation", 100, "test-row");

    for (int i = 0; i < DEFAULT_MAX_CHANNEL * 2; i++) {
      MutateRowResponse response = stub.mutateRow(request);
      assertThat(response).isNotEqualTo(null);
      assertEquals(1, gcpChannel.channelRefs.size());
    }
  }

  @Test
  public void testMutateRowAsyncReuse() throws Exception {
    BigtableStub stub = getBigtableStub();

    for (int i = 0; i < DEFAULT_MAX_CHANNEL * 2; i++) {
      MutateRowRequest request = getMutateRequest("test-mutation-async", i, "test-row");
      AsyncResponseObserver<MutateRowResponse> responseObserver =
          new AsyncResponseObserver<MutateRowResponse>();
      stub.mutateRow(request, responseObserver);
      assertEquals(1, gcpChannel.channelRefs.size());
      assertEquals(1, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
      responseObserver.awaitCompletion();
      assertEquals(0, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
    }
  }

  @Test
  public void testMutateRowFutureReuse() throws Exception {
    BigtableFutureStub stub = getBigtableFutureStub();
    for (int i = 0; i < DEFAULT_MAX_CHANNEL; i++) {
      MutateRowRequest request = getMutateRequest("test-mutation-future", i, "test-row-future");
      ListenableFuture<MutateRowResponse> future = stub.mutateRow(request);
      assertEquals(1, gcpChannel.channelRefs.size());
      assertEquals(1, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
      future.get();
      assertEquals(0, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
    }
  }

  @Test
  public void testConcurrentStreamsAndChannels() throws Exception {
    // For our current channel pool, the max_stream is 5 and the max_size is 5.
    gcpChannel.shutdownNow();
    gcpChannel = new GcpManagedChannel(builder, TEST_APICONFIG_FILE);
    BigtableStub stub = getBigtableStub();
    List<AsyncResponseObserver<MutateRowResponse>> clearObservers = new ArrayList<>();

    // The number of streams is <= 5 * 5.
    for (int i = 0; i < NEW_MAX_STREAM * NEW_MAX_CHANNEL; i++) {
      MutateRowRequest request = getMutateRequest("test-mutation-async", i, "test-row-async");
      AsyncResponseObserver<MutateRowResponse> responseObserver =
          new AsyncResponseObserver<MutateRowResponse>();
      stub.mutateRow(request, responseObserver);
      // Test the number of channels.
      assertEquals((i / NEW_MAX_CHANNEL) + 1, gcpChannel.channelRefs.size());
      // Test the number of streams.
      if ((i % NEW_MAX_STREAM) == 0) {
        assertEquals(
            (i % NEW_MAX_STREAM) + 1,
            gcpChannel.channelRefs.get(i / NEW_MAX_CHANNEL).getActiveStreamsCount());
      } else {
        assertEquals(
            (i % NEW_MAX_STREAM) + 1, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
      }
      clearObservers.add(responseObserver);
    }

    // The number of streams is 26, new channel won't be created.
    MutateRowRequest request = getMutateRequest("test-mutation-async", 100, "test-row-async");
    AsyncResponseObserver<MutateRowResponse> responseObserver =
        new AsyncResponseObserver<MutateRowResponse>();
    stub.mutateRow(request, responseObserver);
    assertEquals(5, gcpChannel.channelRefs.size());
    clearObservers.add(responseObserver);

    // Clear the streams and check the channels.
    for (AsyncResponseObserver<MutateRowResponse> observer : clearObservers) {
      observer.awaitCompletion();
    }
    for (GcpManagedChannel.ChannelRef channelRef : gcpChannel.channelRefs) {
      assertEquals(0, channelRef.getActiveStreamsCount());
    }
  }

  @Test
  public void testReadRows() throws Exception {
    gcpChannel = new GcpManagedChannel(builder);
    BigtableBlockingStub stub = getBigtableBlockingStub();
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setRows(RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("test-row")))
            .build();
    Iterator<ReadRowsResponse> response = stub.readRows(request);
    assertEquals(21, response.next().getChunksCount());
    assertEquals(1, gcpChannel.channelRefs.size());
  }

  private static MutateRowRequest getMutateRequest(String val, int col, String rowKey) {
    ByteString value = ByteString.copyFromUtf8(val);
    Mutation mutation =
        Mutation.newBuilder()
            .setSetCell(
                Mutation.SetCell.newBuilder()
                    .setFamilyName(FAMILY_NAME)
                    .setColumnQualifier(ByteString.copyFromUtf8(COLUMN_NAME + col))
                    .setValue(value))
            .build();
    MutateRowRequest request =
        MutateRowRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setRowKey(ByteString.copyFromUtf8(rowKey))
            .addMutations(mutation)
            .build();
    return request;
  }

  /** There are 105 streams and our GcpManagedChannel is able to handle them. */
  @Test
  public void readGiganticDataGcpChannel() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    Callable<Object> task =
        new Callable<Object>() {
          public Object call() {
            try {
              return runManyManyStreamsGcpChannel();
            } catch (InterruptedException e) {
              return null;
            }
          }
        };
    Future<Object> future = executor.submit(task);
    try {
      Object result = future.get(120, TimeUnit.SECONDS);
    } finally {
      future.cancel(true);
    }
  }

  /**
   * The original ManagedChannel is not able to hold 105 streams concurrently. The 101st stream will
   * be blocked and throws a TimeoutException.
   */
  @Test
  public void readGiganticDataNormalChannel() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    Callable<Object> task =
        new Callable<Object>() {
          public Object call() {
            return runManyManyStreamsNormalChannel();
          }
        };
    expectedEx.expect(TimeoutException.class);
    Future<Object> future = executor.submit(task);
    try {
      Object result = future.get(120, TimeUnit.SECONDS);
    } finally {
      future.cancel(true);
    }
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {

    private final CountDownLatch finishLatch = new CountDownLatch(1);
    private RespT response;

    private void awaitCompletion()
        throws InterruptedException, ExecutionException, TimeoutException {
      finishLatch.await(1, TimeUnit.MINUTES);
    }

    private AsyncResponseObserver() {
      response = null;
    }

    public RespT get() throws InterruptedException, ExecutionException, TimeoutException {
      finishLatch.await(1, TimeUnit.MINUTES);
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
      finishLatch.countDown();
    }
  }
}
