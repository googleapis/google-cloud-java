/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta2;

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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Parser;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BigQueryReadClientTest {
  private static MockBigQueryRead mockBigQueryRead;
  private static MockServiceHelper serviceHelper;
  private BigQueryReadClient client;
  private LocalChannelProvider channelProvider;
  private int retryCount;
  private Code lastRetryStatusCode;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryRead = new MockBigQueryRead();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryRead));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    retryCount = 0;
    lastRetryStatusCode = Code.OK;
    BigQueryReadSettings settings =
        BigQueryReadSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setReadRowsRetryAttemptListener(
                new BigQueryReadSettings.RetryAttemptListener() {
                  @Override
                  public void onRetryAttempt(Status prevStatus, Metadata prevMetadata) {
                    synchronized (this) {
                      retryCount += 1;
                      lastRetryStatusCode = prevStatus.getCode();
                    }
                  }
                })
            .build();
    client = BigQueryReadClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionTest() {
    String name = "name3373707";
    String table = "table110115790";
    ReadSession expectedResponse = ReadSession.newBuilder().setName(name).setTable(table).build();
    mockBigQueryRead.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReadSession readSession = ReadSession.newBuilder().build();
    int maxStreamCount = 940837515;

    ReadSession actualResponse = client.createReadSession(parent, readSession, maxStreamCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = (CreateReadSessionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(readSession, actualRequest.getReadSession());
    Assert.assertEquals(maxStreamCount, actualRequest.getMaxStreamCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      String parent = "parent-995424086";
      ReadSession readSession = ReadSession.newBuilder().build();
      int maxStreamCount = 940837515;

      client.createReadSession(parent, readSession, maxStreamCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsTest() throws Exception {
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));

    Assert.assertEquals(retryCount, 0);
    Assert.assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }

    Assert.assertEquals(retryCount, 0);
    Assert.assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsRetryingEOSExceptionTest() throws ExecutionException, InterruptedException {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "Received unexpected EOS on DATA frame from server")),
            GrpcStatusCode.of(Code.INTERNAL),
            /* retryable= */ false);
    mockBigQueryRead.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());

    Assert.assertEquals(retryCount, 1);
    Assert.assertEquals(lastRetryStatusCode, Code.INTERNAL);
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsRetryingHttp2StreamRstTest() throws ExecutionException, InterruptedException {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Code.INTERNAL),
            /* retryable= */ false);
    mockBigQueryRead.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());

    Assert.assertEquals(retryCount, 1);
    Assert.assertEquals(lastRetryStatusCode, Code.INTERNAL);
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsNoRetryForResourceExhaustedWithoutRetryInfo()
      throws ExecutionException, InterruptedException {
    ApiException exception =
        new ResourceExhaustedException(
            new StatusRuntimeException(
                Status.RESOURCE_EXHAUSTED.withDescription("You are out of quota X")),
            GrpcStatusCode.of(Code.RESOURCE_EXHAUSTED),
            /* retryable= */ false);
    mockBigQueryRead.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof ResourceExhaustedException);
      ResourceExhaustedException apiException = (ResourceExhaustedException) e.getCause();
      Assert.assertEquals(
          StatusCode.Code.RESOURCE_EXHAUSTED, apiException.getStatusCode().getCode());
    }

    Assert.assertEquals(retryCount, 0);
    Assert.assertEquals(lastRetryStatusCode, Code.OK);
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsNoRetryForResourceExhaustedWithRetryInfo()
      throws ExecutionException, InterruptedException {
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setSeconds(2).setNanos(456).build())
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
    mockBigQueryRead.addException(exception);
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);
    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());

    Assert.assertEquals(retryCount, 1);
    Assert.assertEquals(lastRetryStatusCode, Code.RESOURCE_EXHAUSTED);
  }
}
