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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class StreamWriterV2Test {
  private static final Logger log = Logger.getLogger(StreamWriterV2Test.class.getName());
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private FakeScheduledExecutorService fakeExecutor;
  private FakeBigQueryWrite testBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(testBigQueryWrite));
    serviceHelper.start();
    fakeExecutor = new FakeScheduledExecutorService();
    testBigQueryWrite.setExecutor(fakeExecutor);
    client =
        BigQueryWriteClient.create(
            BigQueryWriteSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .setTransportChannelProvider(serviceHelper.createChannelProvider())
                .build());
  }

  @After
  public void tearDown() throws Exception {
    log.info("tearDown called");
    client.close();
    serviceHelper.stop();
  }

  private StreamWriterV2 getTestStreamWriterV2() {
    return StreamWriterV2.newBuilder(TEST_STREAM, client).build();
  }

  private AppendRowsRequest createAppendRequest(String[] messages, long offset) {
    AppendRowsRequest.Builder requestBuilder = AppendRowsRequest.newBuilder();
    AppendRowsRequest.ProtoData.Builder dataBuilder = AppendRowsRequest.ProtoData.newBuilder();
    dataBuilder.setWriterSchema(
        ProtoSchema.newBuilder()
            .setProtoDescriptor(
                DescriptorProtos.DescriptorProto.newBuilder()
                    .setName("Message")
                    .addField(
                        DescriptorProtos.FieldDescriptorProto.newBuilder()
                            .setName("foo")
                            .setType(DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING)
                            .setNumber(1)
                            .build())
                    .build()));
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rows.addSerializedRows(foo.toByteString());
    }
    if (offset > 0) {
      requestBuilder.setOffset(Int64Value.of(offset));
    }
    return requestBuilder
        .setProtoRows(dataBuilder.setRows(rows.build()).build())
        .setWriteStream(TEST_STREAM)
        .build();
  }

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }

  private ApiFuture<AppendRowsResponse> sendTestMessage(StreamWriterV2 writer, String[] messages) {
    return writer.append(createAppendRequest(messages, -1));
  }

  private static <T extends Throwable> T assertFutureException(
      Class<T> expectedThrowable, final Future<?> future) {
    return assertThrows(
        expectedThrowable,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            try {
              future.get();
            } catch (ExecutionException ex) {
              // Future wraps exception with ExecutionException. So unwrapper it here.
              throw ex.getCause();
            }
          }
        });
  }

  @Test
  public void testAppendSuccess() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();

    long appendCount = 1000;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}));
    }

    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }
    assertEquals(appendCount, testBigQueryWrite.getAppendRequests().size());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndError() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ApiException actualError = assertFutureException(ApiException.class, appendFuture2);
    assertEquals(Code.INTERNAL, actualError.getStatusCode().getCode());

    writer.close();
  }

  @Test
  public void longIdleBetweenAppends() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());

    // Sleep to create a long idle between appends.
    TimeUnit.SECONDS.sleep(3);

    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendAfterUserClose() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    writer.close();
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertTrue(appendFuture2.isDone());
    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, appendFuture2);
    assertEquals(Status.Code.FAILED_PRECONDITION, actualError.getStatus().getCode());
  }

  @Test
  public void testAppendAfterServerClose() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiException error1 = assertFutureException(ApiException.class, appendFuture1);
    assertEquals(Code.INTERNAL, error1.getStatusCode().getCode());

    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    assertTrue(appendFuture2.isDone());
    StatusRuntimeException error2 =
        assertFutureException(StatusRuntimeException.class, appendFuture2);
    assertEquals(Status.Code.FAILED_PRECONDITION, error2.getStatus().getCode());

    writer.close();
  }

  @Test
  public void userCloseWhileRequestInflight() throws Exception {
    final StreamWriterV2 writer = getTestStreamWriterV2();
    // Server will sleep 2 seconds before sending back the response.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(2));
    testBigQueryWrite.addResponse(createAppendResponse(0));

    // Send a request and close the stream in separate thread while the request is inflight.
    final ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    Thread closeThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                writer.close();
              }
            });
    closeThread.start();

    // Due to the sleep on server, the append won't finish within 1 second even though stream
    // is being closed.
    assertThrows(
        TimeoutException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            appendFuture1.get(1, TimeUnit.SECONDS);
          }
        });

    // Within 2 seconds, the request should be done and stream should be closed.
    closeThread.join(2000);
    assertTrue(appendFuture1.isDone());
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
  }

  @Test
  public void serverCloseWhileRequestsInflight() throws Exception {
    StreamWriterV2 writer = getTestStreamWriterV2();
    // Server will sleep 2 seconds before closing the connection.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(2));
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    // Send 10 requests, so that there are 10 inflight requests.
    int appendCount = 10;
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}));
    }

    // Server close should properly handle all inflight requests.
    for (int i = 0; i < appendCount; i++) {
      ApiException actualError = assertFutureException(ApiException.class, futures.get(i));
      assertEquals(Code.INTERNAL, actualError.getStatusCode().getCode());
    }

    writer.close();
    ;
  }
}
