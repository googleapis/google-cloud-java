/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamContinuationTokens;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamMutation;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.CloseStream;
import com.google.cloud.bigtable.data.v2.models.Heartbeat;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.truth.Truth;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadChangeStreamRetryTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String START_KEY_CLOSED = "a";
  private static final String END_KEY_OPEN = "b";
  private static final String HEARTBEAT_TOKEN = "heartbeat-token";
  private static final String CLOSE_STREAM_TOKEN = "close-stream-token";
  private static final String DATA_CHANGE_TOKEN = "data-change-token";
  private static final long REQUEST_START_TIME = 1000L;

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableService service;
  private BigtableDataClient client;

  @Before
  public void setUp() throws IOException {
    service = new TestBigtableService();
    serverRule.getServiceRegistry().addService(service);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilderForEmulator(serverRule.getServer().getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create());

    settings
        .stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(serverRule.getChannel())))
        .build();

    client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.close();
    }
  }

  private StreamContinuationToken createStreamContinuationToken(@Nonnull String token) {
    return StreamContinuationToken.newBuilder()
        .setPartition(
            StreamPartition.newBuilder()
                .setRowRange(
                    RowRange.newBuilder()
                        .setStartKeyClosed(ByteString.copyFromUtf8(START_KEY_CLOSED))
                        .setEndKeyOpen(ByteString.copyFromUtf8(END_KEY_OPEN))
                        .build())
                .build())
        .setToken(token)
        .build();
  }

  private ReadChangeStreamResponse.Heartbeat createHeartbeat(
      StreamContinuationToken streamContinuationToken) {
    return ReadChangeStreamResponse.Heartbeat.newBuilder()
        .setContinuationToken(streamContinuationToken)
        .setEstimatedLowWatermark(Timestamp.newBuilder().setSeconds(1000).build())
        .build();
  }

  private ReadChangeStreamResponse.CloseStream createCloseStream() {
    return ReadChangeStreamResponse.CloseStream.newBuilder()
        .addContinuationTokens(createStreamContinuationToken(CLOSE_STREAM_TOKEN))
        .setStatus(com.google.rpc.Status.newBuilder().setCode(0).build())
        .build();
  }

  private ReadChangeStreamResponse.DataChange createDataChange(boolean done) {
    Mutation deleteFromFamily =
        Mutation.newBuilder()
            .setDeleteFromFamily(
                Mutation.DeleteFromFamily.newBuilder().setFamilyName("fake-family").build())
            .build();
    ReadChangeStreamResponse.DataChange.Builder dataChangeBuilder =
        ReadChangeStreamResponse.DataChange.newBuilder()
            .setType(ReadChangeStreamResponse.DataChange.Type.USER)
            .setSourceClusterId("fake-source-cluster-id")
            .setRowKey(ByteString.copyFromUtf8("key"))
            .setCommitTimestamp(Timestamp.newBuilder().setSeconds(100).build())
            .setTiebreaker(100)
            .addChunks(
                ReadChangeStreamResponse.MutationChunk.newBuilder().setMutation(deleteFromFamily));
    if (done) {
      dataChangeBuilder.setDone(true);
      dataChangeBuilder.setEstimatedLowWatermark(Timestamp.newBuilder().setSeconds(1).build());
      dataChangeBuilder.setToken(DATA_CHANGE_TOKEN);
    }
    return dataChangeBuilder.build();
  }

  // [{ReadChangeStreamResponse.Heartbeat}] -> [{Heartbeat}]
  @Test
  public void happyPathHeartbeatTest() {
    ReadChangeStreamResponse heartbeatResponse =
        ReadChangeStreamResponse.newBuilder()
            .setHeartbeat(createHeartbeat(createStreamContinuationToken(HEARTBEAT_TOKEN)))
            .build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(heartbeatResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof Heartbeat);
  }

  // [{ReadChangeStreamResponse.CloseStream}] -> [{CloseStream}]
  @Test
  public void happyPathCloseStreamTest() {
    ReadChangeStreamResponse closeStreamResponse =
        ReadChangeStreamResponse.newBuilder().setCloseStream(createCloseStream()).build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(closeStreamResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof CloseStream);
  }

  // [{DataChange(done==true)}] -> [{ReadChangeStreamMutation}]
  @Test
  public void happyPathCompleteDataChangeTest() {
    // Setting `done==true` to complete the ChangeStreamMutation.
    ReadChangeStreamResponse dataChangeResponse =
        ReadChangeStreamResponse.newBuilder().setDataChange(createDataChange(true)).build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(dataChangeResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof ChangeStreamMutation);
  }

  // [{UNAVAILABLE}, {ReadChangeStreamResponse.Heartbeat}] -> [{Heartbeat}]
  @Test
  public void singleHeartbeatImmediateRetryTest() {
    ReadChangeStreamResponse heartbeatResponse =
        ReadChangeStreamResponse.newBuilder()
            .setHeartbeat(createHeartbeat(createStreamContinuationToken(HEARTBEAT_TOKEN)))
            .build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWithStatus(Code.UNAVAILABLE));
    // Resume with the exact same request.
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(heartbeatResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof Heartbeat);
  }

  // [{UNAVAILABLE}, {ReadChangeStreamResponse.CloseStream}] -> [{CloseStream}]
  @Test
  public void singleCloseStreamImmediateRetryTest() {
    // CloseStream.
    ReadChangeStreamResponse closeStreamResponse =
        ReadChangeStreamResponse.newBuilder().setCloseStream(createCloseStream()).build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWithStatus(Code.UNAVAILABLE));
    // Resume with the exact same request.
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(closeStreamResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof CloseStream);
  }

  // [{UNAVAILABLE}, {DataChange with done==true}] -> [{(ChangeStreamRecord) ChangeStreamMutation}]
  @Test
  public void singleCompleteDataChangeImmediateRetryTest() {
    // DataChange
    ReadChangeStreamResponse dataChangeResponse =
        ReadChangeStreamResponse.newBuilder().setDataChange(createDataChange(true)).build();
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWithStatus(Code.UNAVAILABLE));
    // Resume with the exact same request.
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(dataChangeResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof ChangeStreamMutation);
  }

  // [{ReadChangeStreamResponse.Heartbeat}, {UNAVAILABLE}] -> Resume with token from heartbeat.
  @Test
  public void errorAfterHeartbeatShouldResumeWithTokenTest() {
    StreamContinuationToken streamContinuationToken =
        createStreamContinuationToken(HEARTBEAT_TOKEN);
    ReadChangeStreamResponse heartbeatResponse =
        ReadChangeStreamResponse.newBuilder()
            .setHeartbeat(createHeartbeat(streamContinuationToken))
            .build();
    service.expectations.add(
        RpcExpectation.create()
            .expectInitialRequest()
            .respondWith(heartbeatResponse)
            .respondWithStatus(Code.UNAVAILABLE));
    // Resume the request with the token from the Heartbeat. `startTime` is cleared.
    // We don't care about the response here so just do expectRequest.
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(
                StreamContinuationTokens.newBuilder().addTokens(streamContinuationToken).build()));
    List<ChangeStreamRecord> actualResults = getResults();
    // This is the Heartbeat we get before UNAVAILABLE.
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof Heartbeat);
  }

  // [{DataChange with done==true}, {UNAVAILABLE}] -> Resume with token from DataChange.
  @Test
  public void errorAfterDataChangeWithDoneShouldResumeWithTokenTest() {
    // DataChange
    ReadChangeStreamResponse dataChangeResponse =
        ReadChangeStreamResponse.newBuilder().setDataChange(createDataChange(true)).build();
    service.expectations.add(
        RpcExpectation.create()
            .expectInitialRequest()
            .respondWith(dataChangeResponse)
            .respondWithStatus(Code.UNAVAILABLE));
    // Resume the request with the token from the ChangeStreamMutation. `startTime` is cleared.
    // We don't care about the response here so just do expectRequest.
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(
                StreamContinuationTokens.newBuilder()
                    .addTokens(createStreamContinuationToken(DATA_CHANGE_TOKEN))
                    .build()));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof ChangeStreamMutation);
  }

  // [{DataChange with done==false}, {UNAVAILABLE}] -> Resume with original request.
  @Test
  public void errorAfterDataChangeWithoutDoneShouldResumeWithTokenTest() {
    // DataChange
    ReadChangeStreamResponse dataChangeResponse =
        ReadChangeStreamResponse.newBuilder().setDataChange(createDataChange(false)).build();
    service.expectations.add(
        RpcExpectation.create()
            .expectInitialRequest()
            .respondWith(dataChangeResponse)
            .respondWithStatus(Code.UNAVAILABLE));
    // Resume the request with the original request, because the previous DataChange didn't
    // complete the ChangeStreamMutation(i.e. without `done==true`).
    // We don't care about the response here so just do expectRequest.
    service.expectations.add(RpcExpectation.create().expectInitialRequest());
    List<ChangeStreamRecord> actualResults = getResults();
    Truth.assertThat(actualResults).isEmpty();
  }

  // [{DataChange with done==true}, {Heartbeat}, {UNAVAILABLE}] -> Resume with token from Heartbeat.
  @Test
  public void shouldResumeWithLastTokenTest() {
    // DataChange
    ReadChangeStreamResponse dataChangeResponse =
        ReadChangeStreamResponse.newBuilder().setDataChange(createDataChange(true)).build();
    // Heartbeat.
    ReadChangeStreamResponse heartbeatResponse =
        ReadChangeStreamResponse.newBuilder()
            .setHeartbeat(createHeartbeat(createStreamContinuationToken(HEARTBEAT_TOKEN)))
            .build();
    service.expectations.add(
        RpcExpectation.create()
            .expectInitialRequest()
            .respondWith(dataChangeResponse)
            .respondWith(heartbeatResponse)
            .respondWithStatus(Code.UNAVAILABLE));
    // If we receive a DataChange with done==true and a Heartbeat then a retryable error, it should
    // resume with the last token, which is the one from the heartbeat.
    // If the original request reads with start_time, it'll be resumed with the continuation token.
    // We don't care about the response here so just do expectRequest.
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(
                StreamContinuationTokens.newBuilder()
                    .addTokens(createStreamContinuationToken(HEARTBEAT_TOKEN))
                    .build()));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(2);
    Assert.assertTrue(actualResults.get(0) instanceof ChangeStreamMutation);
    Assert.assertTrue(actualResults.get(1) instanceof Heartbeat);
  }

  @Test
  public void retryRstStreamExceptionTest() {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "INTERNAL: HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Code.INTERNAL),
            false);
    ReadChangeStreamResponse heartbeatResponse =
        ReadChangeStreamResponse.newBuilder()
            .setHeartbeat(createHeartbeat(createStreamContinuationToken(HEARTBEAT_TOKEN)))
            .build();
    service.expectations.add(
        RpcExpectation.create()
            .expectInitialRequest()
            .respondWithException(Code.INTERNAL, exception));
    service.expectations.add(
        RpcExpectation.create().expectInitialRequest().respondWith(heartbeatResponse));
    List<ChangeStreamRecord> actualResults = getResults();
    assertThat(actualResults.size()).isEqualTo(1);
    Assert.assertTrue(actualResults.get(0) instanceof Heartbeat);
  }

  private List<ChangeStreamRecord> getResults() {
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create(TABLE_ID).startTime(REQUEST_START_TIME);
    // Always give it this partition. We don't care.
    ServerStream<ChangeStreamRecord> actualRecords =
        client.readChangeStream(query.streamPartition(START_KEY_CLOSED, END_KEY_OPEN));
    List<ChangeStreamRecord> actualValues = Lists.newArrayList();
    for (ChangeStreamRecord record : actualRecords) {
      actualValues.add(record);
    }
    return actualValues;
  }

  private static class TestBigtableService extends BigtableGrpc.BigtableImplBase {
    Queue<RpcExpectation> expectations = Queues.newArrayDeque();
    int i = -1;

    @Override
    public void readChangeStream(
        ReadChangeStreamRequest request,
        StreamObserver<ReadChangeStreamResponse> responseObserver) {

      RpcExpectation expectedRpc = expectations.poll();
      i++;

      Truth.assertWithMessage("Unexpected request#" + i + ":" + request.toString())
          .that(expectedRpc)
          .isNotNull();
      Truth.assertWithMessage("Unexpected request#" + i)
          .that(request)
          .isEqualTo(expectedRpc.getExpectedRequest());

      for (ReadChangeStreamResponse response : expectedRpc.responses) {
        responseObserver.onNext(response);
      }
      if (expectedRpc.statusCode.toStatus().isOk()) {
        responseObserver.onCompleted();
      } else if (expectedRpc.exception != null) {
        responseObserver.onError(expectedRpc.exception);
      } else {
        responseObserver.onError(expectedRpc.statusCode.toStatus().asRuntimeException());
      }
    }
  }

  private static class RpcExpectation {
    ReadChangeStreamRequest.Builder requestBuilder;
    Status.Code statusCode;
    ApiException exception;
    List<ReadChangeStreamResponse> responses;

    private RpcExpectation() {
      this.requestBuilder =
          ReadChangeStreamRequest.newBuilder()
              .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
              .setPartition(
                  StreamPartition.newBuilder()
                      .setRowRange(
                          RowRange.newBuilder()
                              .setStartKeyClosed(ByteString.copyFromUtf8(START_KEY_CLOSED))
                              .setEndKeyOpen(ByteString.copyFromUtf8(END_KEY_OPEN))
                              .build())
                      .build());
      this.statusCode = Status.Code.OK;
      this.responses = Lists.newArrayList();
    }

    static RpcExpectation create() {
      return new RpcExpectation();
    }

    RpcExpectation expectInitialRequest() {
      requestBuilder.setStartTime(Timestamps.fromNanos(REQUEST_START_TIME));
      return this;
    }

    RpcExpectation expectRequest(StreamContinuationTokens continuationTokens) {
      requestBuilder.setContinuationTokens(continuationTokens);
      return this;
    }

    RpcExpectation respondWithStatus(Status.Code code) {
      this.statusCode = code;
      return this;
    }

    RpcExpectation respondWithException(Status.Code code, ApiException exception) {
      this.statusCode = code;
      this.exception = exception;
      return this;
    }

    RpcExpectation respondWith(ReadChangeStreamResponse... responses) {
      Collections.addAll(this.responses, responses);
      return this;
    }

    ReadChangeStreamRequest getExpectedRequest() {
      return requestBuilder.build();
    }
  }
}
