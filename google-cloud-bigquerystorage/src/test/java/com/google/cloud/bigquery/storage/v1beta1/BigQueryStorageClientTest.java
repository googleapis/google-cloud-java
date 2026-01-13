/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ResourceExhaustedException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.Parser;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
class BigQueryStorageClientTest {
  private static MockBigQueryStorage mockBigQueryStorage;
  private static MockServiceHelper serviceHelper;
  private BigQueryStorageClient client;
  private LocalChannelProvider channelProvider;
  private int retryCount;
  private Code lastRetryStatusCode;

  @BeforeAll
  static void startStaticServer() {
    mockBigQueryStorage = new MockBigQueryStorage();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockBigQueryStorage));
    serviceHelper.start();
  }

  @AfterAll
  static void stopServer() {
    serviceHelper.stop();
  }

  @BeforeEach
  void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    retryCount = 0;
    lastRetryStatusCode = Code.OK;
    BigQueryStorageSettings settings =
        BigQueryStorageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setReadRowsRetryAttemptListener(
                new BigQueryStorageSettings.RetryAttemptListener() {
                  @Override
                  public void onRetryAttempt(Status prevStatus, Metadata prevMetadata) {
                    synchronized (this) {
                      retryCount += 1;
                      lastRetryStatusCode = prevStatus.getCode();
                    }
                  }
                })
            .build();
    client = BigQueryStorageClient.create(settings);
  }

  @AfterEach
  void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  void createReadSessionTest() {
    String name = "name3373707";
    ReadSession expectedResponse = ReadSession.newBuilder().setName(name).build();
    mockBigQueryStorage.addResponse(expectedResponse);

    TableReference tableReference = TableReference.newBuilder().build();
    String parent = "parent-995424086";
    int requestedStreams = 1017221410;

    ReadSession actualResponse = client.createReadSession(tableReference, parent, requestedStreams);
    assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = (CreateReadSessionRequest) actualRequests.get(0);

    assertEquals(tableReference, actualRequest.getTableReference());
    assertEquals(parent, actualRequest.getParent());
    assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    TableReference tableReference = TableReference.newBuilder().build();
    String parent = "parent-995424086";
    int requestedStreams = 1017221410;

    assertThrows(
        InvalidArgumentException.class,
        () -> client.createReadSession(tableReference, parent, requestedStreams));
  }

  @Test
  @SuppressWarnings("all")
  void readRowsTest() throws Exception {
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);
    StreamPosition readPosition = StreamPosition.newBuilder().build();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    assertEquals(1, actualResponses.size());
    assertEquals(expectedResponse, actualResponses.get(0));

    assertEquals(retryCount, 0);
    assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);
    StreamPosition readPosition = StreamPosition.newBuilder().build();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    ExecutionException e =
        assertThrows(ExecutionException.class, () -> responseObserver.future().get());
    assertTrue(e.getCause() instanceof InvalidArgumentException);
    InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
    assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());

    assertEquals(retryCount, 0);
    assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  void batchCreateReadSessionStreamsTest() {
    BatchCreateReadSessionStreamsResponse expectedResponse =
        BatchCreateReadSessionStreamsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    ReadSession session = ReadSession.newBuilder().build();
    int requestedStreams = 1017221410;

    BatchCreateReadSessionStreamsResponse actualResponse =
        client.batchCreateReadSessionStreams(session, requestedStreams);
    assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    assertEquals(1, actualRequests.size());
    BatchCreateReadSessionStreamsRequest actualRequest =
        (BatchCreateReadSessionStreamsRequest) actualRequests.get(0);

    assertEquals(session, actualRequest.getSession());
    assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  void batchCreateReadSessionStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    ReadSession session = ReadSession.newBuilder().build();
    int requestedStreams = 1017221410;

    assertThrows(
        InvalidArgumentException.class,
        () -> client.batchCreateReadSessionStreams(session, requestedStreams));
  }

  @Test
  @SuppressWarnings("all")
  void finalizeStreamTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Stream stream = Stream.newBuilder().build();

    client.finalizeStream(stream);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    assertEquals(1, actualRequests.size());
    FinalizeStreamRequest actualRequest = (FinalizeStreamRequest) actualRequests.get(0);

    assertEquals(stream, actualRequest.getStream());
    assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  void finalizeStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    Stream stream = Stream.newBuilder().build();

    assertThrows(InvalidArgumentException.class, () -> client.finalizeStream(stream));
  }

  @Test
  @SuppressWarnings("all")
  void splitReadStreamTest() {
    SplitReadStreamResponse expectedResponse = SplitReadStreamResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Stream originalStream = Stream.newBuilder().build();

    SplitReadStreamResponse actualResponse = client.splitReadStream(originalStream);
    assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    assertEquals(1, actualRequests.size());
    SplitReadStreamRequest actualRequest = (SplitReadStreamRequest) actualRequests.get(0);

    assertEquals(originalStream, actualRequest.getOriginalStream());
    assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  void splitReadStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    Stream originalStream = Stream.newBuilder().build();

    assertThrows(InvalidArgumentException.class, () -> client.splitReadStream(originalStream));
  }

  @Test
  @SuppressWarnings("all")
  void readRowsRetryingEOSExceptionTest() throws ExecutionException, InterruptedException {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "Received unexpected EOS on DATA frame from server")),
            GrpcStatusCode.of(Code.INTERNAL),
            /* retryable= */ false);
    mockBigQueryStorage.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryStorage.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    assertEquals(1, actualResponses.size());

    assertEquals(retryCount, 1);
    assertEquals(lastRetryStatusCode, Code.INTERNAL);
  }

  @Test
  @SuppressWarnings("all")
  void readRowsRetryingHttp2StreamRstTest() throws ExecutionException, InterruptedException {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Code.INTERNAL),
            /* retryable= */ false);
    mockBigQueryStorage.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryStorage.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    assertEquals(1, actualResponses.size());

    assertEquals(retryCount, 1);
    assertEquals(lastRetryStatusCode, Code.INTERNAL);
  }

  @Test
  @SuppressWarnings("all")
  void readRowsNoRetryForResourceExhaustedWithoutRetryInfo()
      throws ExecutionException, InterruptedException {
    ApiException exception =
        new ResourceExhaustedException(
            new StatusRuntimeException(
                Status.RESOURCE_EXHAUSTED.withDescription("You are out of quota X")),
            GrpcStatusCode.of(Code.RESOURCE_EXHAUSTED),
            /* retryable= */ false);
    mockBigQueryStorage.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryStorage.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    ExecutionException e =
        assertThrows(ExecutionException.class, () -> responseObserver.future().get());
    assertTrue(e.getCause() instanceof ResourceExhaustedException);
    ResourceExhaustedException apiException = (ResourceExhaustedException) e.getCause();
    assertEquals(StatusCode.Code.RESOURCE_EXHAUSTED, apiException.getStatusCode().getCode());

    assertEquals(retryCount, 0);
    assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  void readRowsNoRetryForResourceExhaustedWithRetryInfo()
      throws ExecutionException, InterruptedException {
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setSeconds(123).setNanos(456).build())
            .build();

    Metadata metadata = new Metadata();
    metadata.put(
        Metadata.Key.of(
            "google.rpc.retryinfo-bin",
            new Metadata.BinaryMarshaller<RetryInfo>() {
              @Override
              public byte[] toBytes(RetryInfo value) {
                return value.toByteArray();
              }

              @Override
              public RetryInfo parseBytes(byte[] serialized) {
                try {
                  Parser<RetryInfo> parser = (RetryInfo.newBuilder().build()).getParserForType();
                  return parser.parseFrom(serialized);
                } catch (Exception e) {
                  return null;
                }
              }
            }),
        retryInfo);

    ApiException exception =
        new ResourceExhaustedException(
            new StatusRuntimeException(
                Status.RESOURCE_EXHAUSTED.withDescription("Try again in a bit"), metadata),
            GrpcStatusCode.of(Code.RESOURCE_EXHAUSTED),
            /* retryable= */ false);
    mockBigQueryStorage.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryStorage.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    assertEquals(1, actualResponses.size());

    assertEquals(retryCount, 1);
    assertEquals(lastRetryStatusCode, Code.RESOURCE_EXHAUSTED);
  }
}
