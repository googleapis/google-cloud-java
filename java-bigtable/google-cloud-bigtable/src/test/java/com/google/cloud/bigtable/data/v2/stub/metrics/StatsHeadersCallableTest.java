/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.BigtableGrpc.BigtableImplBase;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.collect.Queues;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatsHeadersCallableTest {
  private Server server;

  private FakeService fakeService = new FakeService();

  private EnhancedBigtableStub stub;

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String APP_PROFILE_ID = "default";
  private static final String TABLE_ID = "fake-table";

  private final int attemptCounts = 3;
  private MetadataInterceptor metadataInterceptor;

  @Before
  public void setUp() throws Exception {
    metadataInterceptor = new MetadataInterceptor();
    server = FakeServiceBuilder.create(fakeService).intercept(metadataInterceptor).start();

    EnhancedBigtableStubSettings settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .build()
            .getStubSettings();
    stub = EnhancedBigtableStub.create(settings);
  }

  @After
  public void tearDown() {
    stub.close();
    server.shutdown();
  }

  @Test
  public void testReadRowsHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.readRowsCallable().call(Query.create(TABLE_ID).rowKey("key")).iterator().next();
    verifyHeaders(attemptCounts, startTimestamp);
  }

  @Test
  public void testReadRowHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.readRowCallable().futureCall(Query.create(TABLE_ID).rowKey("key")).get();
    verifyHeaders(attemptCounts, startTimestamp);
  }

  @Test
  public void testMutateRowsHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.bulkMutateRowsCallable()
        .futureCall(BulkMutation.create(TABLE_ID).add(RowMutationEntry.create("key")))
        .get();
    verifyHeaders(attemptCounts, startTimestamp);
  }

  @Test
  public void testMutateRowHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.mutateRowCallable()
        .futureCall(RowMutation.create(TABLE_ID, "key").setCell("f", "q", "value"))
        .get();
    verifyHeaders(attemptCounts, startTimestamp);
  }

  @Test
  public void testSampleRowKeysHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.sampleRowKeysCallable().call(TABLE_ID).get(0);
    verifyHeaders(attemptCounts, startTimestamp);
  }

  @Test
  public void testCheckAndMutateHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.checkAndMutateRowCallable()
        .call(
            ConditionalRowMutation.create(TABLE_ID, "key")
                .then(Mutation.create().setCell("f", "q", "value")));
    verifyHeaders(1, startTimestamp);
  }

  @Test
  public void testReadModifyWriteHeaders() throws Exception {
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.readModifyWriteRowCallable()
        .call(ReadModifyWriteRow.create(TABLE_ID, "key").append("f", "q", "value"));
    verifyHeaders(1, startTimestamp);
  }

  @Test
  public void testMultipleRequests() throws Exception {
    // Send multiple requests and make sure headers are set correctly
    long startTimestamp = System.currentTimeMillis() * 1000;
    stub.readRowsCallable().call(Query.create(TABLE_ID).rowKey("key")).iterator().next();
    verifyHeaders(attemptCounts, startTimestamp);

    startTimestamp = System.currentTimeMillis() * 1000;
    stub.readRowsCallable().call(Query.create(TABLE_ID).rowKey("key")).iterator().next();
    verifyHeaders(1, startTimestamp);
  }

  private static class MetadataInterceptor implements ServerInterceptor {
    final BlockingQueue<Metadata> headers = Queues.newLinkedBlockingDeque();

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      headers.add(metadata);
      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  private class FakeService extends BigtableImplBase {
    AtomicInteger callCount = new AtomicInteger(0);

    @Override
    public void readRows(ReadRowsRequest request, StreamObserver<ReadRowsResponse> observer) {
      if (callCount.get() < attemptCounts - 1) {
        callCount.incrementAndGet();
        observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      observer.onNext(
          ReadRowsResponse.newBuilder()
              .addChunks(
                  ReadRowsResponse.CellChunk.newBuilder()
                      .setCommitRow(true)
                      .setRowKey(ByteString.copyFromUtf8("a"))
                      .setFamilyName(StringValue.getDefaultInstance())
                      .setQualifier(BytesValue.getDefaultInstance())
                      .setValueSize(0))
              .build());
      observer.onCompleted();
    }

    @Override
    public void mutateRow(MutateRowRequest request, StreamObserver<MutateRowResponse> observer) {
      if (callCount.get() < attemptCounts - 1) {
        callCount.incrementAndGet();
        observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      observer.onNext(MutateRowResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void mutateRows(MutateRowsRequest request, StreamObserver<MutateRowsResponse> observer) {
      if (callCount.get() < attemptCounts - 1) {
        callCount.incrementAndGet();
        observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      observer.onNext(MutateRowsResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void sampleRowKeys(
        SampleRowKeysRequest request, StreamObserver<SampleRowKeysResponse> observer) {
      if (callCount.get() < attemptCounts - 1) {
        callCount.incrementAndGet();
        observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      observer.onNext(SampleRowKeysResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request, StreamObserver<CheckAndMutateRowResponse> observer) {
      observer.onNext(CheckAndMutateRowResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request, StreamObserver<ReadModifyWriteRowResponse> observer) {
      observer.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
      observer.onCompleted();
    }
  }

  private void verifyHeaders(int expectedAttemptCounts, long startTimestamp) throws Exception {
    assertThat(metadataInterceptor.headers).hasSize(expectedAttemptCounts);
    long timestamp = startTimestamp;

    for (int i = 0; i < expectedAttemptCounts; i++) {
      Metadata headers = metadataInterceptor.headers.take();
      String attemptCount = headers.get(Util.ATTEMPT_HEADER_KEY);
      assertThat(attemptCount).isNotNull();
      assertThat(Integer.valueOf(attemptCount)).isEqualTo(i);

      String clientTimeStr = headers.get(Util.ATTEMPT_EPOCH_KEY);
      assertThat(clientTimeStr).isNotNull();
      long clientTime = Long.valueOf(clientTimeStr);
      assertThat(clientTime).isAtLeast(timestamp);

      timestamp = clientTime;
    }
  }
}
