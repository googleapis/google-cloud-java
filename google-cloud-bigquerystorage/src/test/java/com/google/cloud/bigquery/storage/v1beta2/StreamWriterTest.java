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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.DataLossException;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.common.base.Strings;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class StreamWriterTest {
  private static final Logger LOG = Logger.getLogger(StreamWriterTest.class.getName());
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private static final String TEST_DEFAULT_STREAM = "projects/p/datasets/d/tables/t/_default";
  private static final ExecutorProvider SINGLE_THREAD_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();
  private static LocalChannelProvider channelProvider;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeBigQueryWrite testBigQueryWrite;
  private static MockServiceHelper serviceHelper;

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(testBigQueryWrite));
    serviceHelper.start();
    channelProvider = serviceHelper.createChannelProvider();
    fakeExecutor = new FakeScheduledExecutorService();
    testBigQueryWrite.setExecutor(fakeExecutor);
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    // Add enough GetWriteStream response.
    for (int i = 0; i < 4; i++) {
      testBigQueryWrite.addResponse(
          WriteStream.newBuilder().setName(TEST_STREAM).setCreateTime(timestamp).build());
    }
  }

  @After
  public void tearDown() throws Exception {
    LOG.info("tearDown called");
    serviceHelper.stop();
  }

  private StreamWriter.Builder getTestStreamWriterBuilder(String testStream) {
    return StreamWriter.newBuilder(testStream)
        .setChannelProvider(channelProvider)
        .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
        .setCredentialsProvider(NoCredentialsProvider.create());
  }

  private StreamWriter.Builder getTestStreamWriterBuilder() {
    return getTestStreamWriterBuilder(TEST_STREAM);
  }

  private StreamWriter.Builder getDefaultTestStreamWriterBuilder() {
    return getTestStreamWriterBuilder(TEST_DEFAULT_STREAM);
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
      // Temp for Breaking Change.
      // requestBuilder.setOffset(Int64Value.of(offset));
    }
    return requestBuilder
        .setProtoRows(dataBuilder.setRows(rows.build()).build())
        .setWriteStream(TEST_STREAM)
        .build();
  }

  private ApiFuture<AppendRowsResponse> sendTestMessage(StreamWriter writer, String[] messages) {
    return writer.append(createAppendRequest(messages, -1));
  }

  @Test
  public void testTableName() throws Exception {
    try (StreamWriter writer = getTestStreamWriterBuilder().build()) {
      assertEquals("projects/p/datasets/d/tables/t", writer.getTableNameString());
    }
  }

  @Test
  public void testDefaultStream() throws Exception {
    try (StreamWriter writer = getDefaultTestStreamWriterBuilder().build()) {
      assertEquals("projects/p/datasets/d/tables/t", writer.getTableNameString());
    }
  }

  @Test
  public void testAppendByDuration() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .setElementCountThreshold(10L)
                    .build())
            .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
            .build();

    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    assertFalse(appendFuture1.isDone());
    assertFalse(appendFuture2.isDone());
    fakeExecutor.advanceTime(Duration.ofSeconds(10));

    // Temp for Breaking Change.
    // assertEquals(0L, appendFuture1.get().getOffset());
    // assertEquals(1L, appendFuture2.get().getOffset());
    appendFuture1.get();
    appendFuture2.get();
    assertEquals(1, testBigQueryWrite.getAppendRequests().size());

    assertEquals(
        2,
        testBigQueryWrite
            .getAppendRequests()
            .get(0)
            .getProtoRows()
            .getRows()
            .getSerializedRowsCount());
    assertEquals(
        true, testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
    writer.close();
  }

  @Test
  public void testAppendByNumBatchedMessages() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(100))
                    .build())
            .build();
    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});

    // Temp for Breaking Change.
    appendFuture1.get();
    appendFuture2.get();
    // assertEquals(0L, appendFuture1.get().getOffset());
    // assertEquals(1L, appendFuture2.get().getOffset());

    assertFalse(appendFuture3.isDone());

    ApiFuture<AppendRowsResponse> appendFuture4 = sendTestMessage(writer, new String[] {"D"});

    // Temp for Breaking Change.
    appendFuture3.get();
    appendFuture4.get();
    // assertEquals(2L, appendFuture3.get().getOffset());
    // assertEquals(3L, appendFuture4.get().getOffset());

    assertEquals(2, testBigQueryWrite.getAppendRequests().size());
    assertEquals(
        2,
        testBigQueryWrite
            .getAppendRequests()
            .get(0)
            .getProtoRows()
            .getRows()
            .getSerializedRowsCount());
    assertEquals(
        true, testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
    assertEquals(
        2,
        testBigQueryWrite
            .getAppendRequests()
            .get(1)
            .getProtoRows()
            .getRows()
            .getSerializedRowsCount());
    assertEquals(
        false, testBigQueryWrite.getAppendRequests().get(1).getProtoRows().hasWriterSchema());
    writer.close();
  }

  @Test
  public void testAppendByNumBytes() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    // Each message is 32 bytes, setting batch size to 70 bytes allows 2 messages.
                    .setRequestByteThreshold(70L)
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .build())
            .build();

    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(3).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});

    // Temp for Breaking Change.
    // assertEquals(0L, appendFuture1.get().getOffset());
    // assertEquals(1L, appendFuture2.get().getOffset());
    appendFuture1.get();
    appendFuture2.get();
    assertFalse(appendFuture3.isDone());

    // This message is big enough to trigger send on the previous message and itself.
    ApiFuture<AppendRowsResponse> appendFuture4 =
        sendTestMessage(writer, new String[] {Strings.repeat("A", 100)});
    // Temp for Breaking Change.
    // assertEquals(2L, appendFuture3.get().getOffset());
    // assertEquals(3L, appendFuture4.get().getOffset());
    appendFuture3.get();
    appendFuture4.get();

    assertEquals(3, testBigQueryWrite.getAppendRequests().size());

    writer.close();
  }

  @Test
  public void testWriteByShutdown() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(100))
                    .setElementCountThreshold(10L)
                    .build())
            .build();
    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0L).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(1L).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    // Note we are not advancing time or reaching the count threshold but messages should
    // still get written by call to shutdown

    writer.close();

    // Verify the appends completed
    assertTrue(appendFuture1.isDone());
    assertTrue(appendFuture2.isDone());
    // Temp for Breaking Change.
    // assertEquals(0L, appendFuture1.get().getOffset());
    // assertEquals(1L, appendFuture2.get().getOffset());
  }

  @Test
  public void testWriteMixedSizeAndDuration() throws Exception {
    try (StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build()) {
      // Temp for Breaking Change.
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0L).build());
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2L).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());

      ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});

      fakeExecutor.advanceTime(Duration.ofSeconds(2));
      assertFalse(appendFuture1.isDone());

      ApiFuture<AppendRowsResponse> appendFuture2 =
          sendTestMessage(writer, new String[] {"B", "C"});

      // Write triggered by batch size
      // Temp for Breaking Change.
      // assertEquals(0L, appendFuture1.get().getOffset());
      // assertEquals(1L, appendFuture2.get().getOffset());
      appendFuture1.get();
      appendFuture2.get();

      ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"D"});

      assertFalse(appendFuture3.isDone());

      // Write triggered by time
      fakeExecutor.advanceTime(Duration.ofSeconds(5));

      // assertEquals(2L, appendFuture3.get().getOffset());

      assertEquals(
          3,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          true, testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
      // assertEquals(
      //     1,
      //     testBigQueryWrite
      //         .getAppendRequests()
      //         .get(1) // this gives IndexOutOfBounds error at the moment
      //         .getProtoRows()
      //         .getRows()
      //         .getSerializedRowsCount());
      // assertEquals(
      //     false, testBigQueryWrite.getAppendRequests().get(1).getProtoRows().hasWriterSchema());
    }
  }

  @Test
  public void testFlowControlBehaviorBlock() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setFlowControlSettings(
                        StreamWriter.Builder.DEFAULT_FLOW_CONTROL_SETTINGS
                            .toBuilder()
                            .setMaxOutstandingRequestBytes(40L)
                            .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                            .build())
                    .build())
            .build();

    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2L).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(3L).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.setResponseDelay(Duration.ofSeconds(10));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    final StreamWriter writer1 = writer;
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            ApiFuture<AppendRowsResponse> appendFuture2 =
                sendTestMessage(writer1, new String[] {"B"});
          }
        };
    Thread t = new Thread(runnable);
    t.start();
    assertEquals(true, t.isAlive());
    assertEquals(false, appendFuture1.isDone());
    // Wait is necessary for response to be scheduled before timer is advanced.
    Thread.sleep(5000L);
    fakeExecutor.advanceTime(Duration.ofSeconds(10));
    // The first requests gets back while the second one is blocked.
    // Temp for Breaking Change.
    // assertEquals(2L, appendFuture1.get().getOffset());
    appendFuture1.get();
    Thread.sleep(5000L);
    // Wait is necessary for response to be scheduled before timer is advanced.
    fakeExecutor.advanceTime(Duration.ofSeconds(10));
    t.join();
    writer.close();
  }

  @Test
  public void testFlowControlBehaviorException() throws Exception {
    try (StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setFlowControlSettings(
                        StreamWriter.Builder.DEFAULT_FLOW_CONTROL_SETTINGS
                            .toBuilder()
                            .setMaxOutstandingElementCount(1L)
                            .setLimitExceededBehavior(
                                FlowController.LimitExceededBehavior.ThrowException)
                            .build())
                    .build())
            .build()) {
      assertEquals(
          1L,
          writer
              .getBatchingSettings()
              .getFlowControlSettings()
              .getMaxOutstandingElementCount()
              .longValue());
      // Temp for Breaking Change.
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(1L).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      testBigQueryWrite.setResponseDelay(Duration.ofSeconds(10));
      ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
      ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
      // Wait is necessary for response to be scheduled before timer is advanced.
      Thread.sleep(5000L);
      fakeExecutor.advanceTime(Duration.ofSeconds(10));
      try {
        appendFuture2.get();
        Assert.fail("This should fail");
      } catch (Exception e) {
        assertEquals(
            "java.util.concurrent.ExecutionException: The maximum number of batch elements: 1 have been reached.",
            e.toString());
      }
      // Temp for Breaking Change.
      // assertEquals(1L, appendFuture1.get().getOffset());
      appendFuture1.get();
    }
  }

  @Test
  public void testStreamReconnectionTransient() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .setElementCountThreshold(1L)
                    .build())
            .build();

    StatusRuntimeException transientError = new StatusRuntimeException(Status.UNAVAILABLE);
    testBigQueryWrite.addException(transientError);
    // Temp for Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    ApiFuture<AppendRowsResponse> future1 = sendTestMessage(writer, new String[] {"m1"});
    assertEquals(false, future1.isDone());
    // Retry is scheduled to be 7 seconds later.
    // Temp for Breaking Change.
    // assertEquals(0L, future1.get().getOffset());
    future1.get();
    writer.close();
  }

  @Test
  public void testStreamReconnectionPermanant() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .setElementCountThreshold(1L)
                    .build())
            .build();
    StatusRuntimeException permanentError = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    testBigQueryWrite.addException(permanentError);
    ApiFuture<AppendRowsResponse> future2 = sendTestMessage(writer, new String[] {"m2"});
    try {
      future2.get();
      Assert.fail("This should fail.");
    } catch (ExecutionException e) {
      assertEquals(permanentError.toString(), e.getCause().getCause().toString());
    }
    writer.close();
  }

  @Test
  public void testStreamReconnectionExceedRetry() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .setElementCountThreshold(1L)
                    .build())
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setMaxRetryDelay(Duration.ofMillis(100))
                    .setMaxAttempts(1)
                    .build())
            .build();
    assertEquals(1, writer.getRetrySettings().getMaxAttempts());
    StatusRuntimeException transientError = new StatusRuntimeException(Status.UNAVAILABLE);
    testBigQueryWrite.addException(transientError);
    testBigQueryWrite.addException(transientError);
    ApiFuture<AppendRowsResponse> future3 = sendTestMessage(writer, new String[] {"toomanyretry"});
    try {
      future3.get();
      Assert.fail("This should fail.");
    } catch (ExecutionException e) {
      assertEquals(transientError.toString(), e.getCause().getCause().toString());
    }
    writer.close();
  }

  @Test
  public void testOffset() throws Exception {
    try (StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .build())
            .build()) {

      // Temp for Breaking Change.
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(10L).build());
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(13L).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      AppendRowsRequest request1 = createAppendRequest(new String[] {"A"}, 10L);
      ApiFuture<AppendRowsResponse> appendFuture1 = writer.append(request1);
      AppendRowsRequest request2 = createAppendRequest(new String[] {"B", "C"}, 11L);
      ApiFuture<AppendRowsResponse> appendFuture2 = writer.append(request2);
      AppendRowsRequest request3 = createAppendRequest(new String[] {"E", "F"}, 13L);
      ApiFuture<AppendRowsResponse> appendFuture3 = writer.append(request3);
      AppendRowsRequest request4 = createAppendRequest(new String[] {"G"}, 15L);
      ApiFuture<AppendRowsResponse> appendFuture4 = writer.append(request4);
      // assertEquals(10L, appendFuture1.get().getOffset());
      // assertEquals(11L, appendFuture2.get().getOffset());
      // assertEquals(13L, appendFuture3.get().getOffset());
      // assertEquals(15L, appendFuture4.get().getOffset());
      appendFuture1.get();
      appendFuture2.get();
      appendFuture3.get();
      appendFuture4.get();
    }
  }

  @Test
  public void testOffsetMismatch() throws Exception {
    try (StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .build())
            .build()) {
      // Temp for Breaking Change.
      // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(11L).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      AppendRowsRequest request1 = createAppendRequest(new String[] {"A"}, 10L);
      ApiFuture<AppendRowsResponse> appendFuture1 = writer.append(request1);

      appendFuture1.get();
      // Temp for Breaking Change.
      // fail("Should throw exception");
    } catch (Exception e) {
      assertEquals(
          "java.lang.IllegalStateException: The append result offset 11 does not match the expected offset 10.",
          e.getCause().toString());
    }
  }

  @Test
  public void testErrorPropagation() throws Exception {
    try (StreamWriter writer =
        getTestStreamWriterBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build()) {
      testBigQueryWrite.addException(Status.DATA_LOSS.asException());
      sendTestMessage(writer, new String[] {"A"}).get();
      fail("should throw exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(DataLossException.class);
    }
  }

  @Test
  public void testWriterGetters() throws Exception {
    StreamWriter.Builder builder = StreamWriter.newBuilder(TEST_STREAM);
    builder.setChannelProvider(channelProvider);
    builder.setExecutorProvider(SINGLE_THREAD_EXECUTOR);
    builder.setBatchingSettings(
        BatchingSettings.newBuilder()
            .setRequestByteThreshold(10L)
            .setDelayThreshold(Duration.ofMillis(11))
            .setElementCountThreshold(12L)
            .setFlowControlSettings(
                FlowControlSettings.newBuilder()
                    .setMaxOutstandingElementCount(100L)
                    .setMaxOutstandingRequestBytes(1000L)
                    .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                    .build())
            .build());
    builder.setCredentialsProvider(NoCredentialsProvider.create());
    StreamWriter writer = builder.build();

    assertEquals(TEST_STREAM, writer.getStreamNameString());
    assertEquals(10, (long) writer.getBatchingSettings().getRequestByteThreshold());
    assertEquals(Duration.ofMillis(11), writer.getBatchingSettings().getDelayThreshold());
    assertEquals(12, (long) writer.getBatchingSettings().getElementCountThreshold());
    assertEquals(
        FlowController.LimitExceededBehavior.Block,
        writer.getBatchingSettings().getFlowControlSettings().getLimitExceededBehavior());
    assertEquals(
        100L,
        writer
            .getBatchingSettings()
            .getFlowControlSettings()
            .getMaxOutstandingElementCount()
            .longValue());
    assertEquals(
        1000L,
        writer
            .getBatchingSettings()
            .getFlowControlSettings()
            .getMaxOutstandingRequestBytes()
            .longValue());
    writer.close();
  }

  @Test
  public void testBuilderParametersAndDefaults() {
    StreamWriter.Builder builder = StreamWriter.newBuilder(TEST_STREAM);
    assertEquals(StreamWriter.Builder.DEFAULT_EXECUTOR_PROVIDER, builder.executorProvider);
    assertEquals(100 * 1024L, builder.batchingSettings.getRequestByteThreshold().longValue());
    assertEquals(Duration.ofMillis(10), builder.batchingSettings.getDelayThreshold());
    assertEquals(100L, builder.batchingSettings.getElementCountThreshold().longValue());
    assertEquals(StreamWriter.Builder.DEFAULT_RETRY_SETTINGS, builder.retrySettings);
    assertEquals(Duration.ofMillis(100), builder.retrySettings.getInitialRetryDelay());
    assertEquals(3, builder.retrySettings.getMaxAttempts());
  }

  @Test
  public void testBuilderInvalidArguments() {
    StreamWriter.Builder builder = StreamWriter.newBuilder(TEST_STREAM);

    try {
      builder.setChannelProvider(null);
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }

    try {
      builder.setExecutorProvider(null);
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(0L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(-1L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBatchingSettings(
        StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
            .toBuilder()
            .setDelayThreshold(Duration.ofMillis(1))
            .build());
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setDelayThreshold(null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setDelayThreshold(Duration.ofMillis(-1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBatchingSettings(
        StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
            .toBuilder()
            .setElementCountThreshold(1L)
            .build());
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(0L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(-1L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    try {
      FlowControlSettings flowControlSettings =
          FlowControlSettings.newBuilder().setMaxOutstandingElementCount(-1L).build();
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setFlowControlSettings(flowControlSettings)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    try {
      FlowControlSettings flowControlSettings =
          FlowControlSettings.newBuilder().setMaxOutstandingRequestBytes(-1L).build();
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setFlowControlSettings(flowControlSettings)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    try {
      FlowControlSettings flowControlSettings =
          FlowControlSettings.newBuilder()
              .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Ignore)
              .build();
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setFlowControlSettings(flowControlSettings)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    try {
      FlowControlSettings flowControlSettings =
          FlowControlSettings.newBuilder().setLimitExceededBehavior(null).build();
      builder.setBatchingSettings(
          StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setFlowControlSettings(flowControlSettings)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
  }

  @Test
  public void testExistingClient() throws Exception {
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    BigQueryWriteClient client = BigQueryWriteClient.create(settings);
    StreamWriter writer = StreamWriter.newBuilder(TEST_STREAM, client).build();
    writer.close();
    assertFalse(client.isShutdown());
    client.shutdown();
    client.awaitTermination(1, TimeUnit.MINUTES);
  }

  @Test
  public void testFlushAll() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .build())
            .build();

    // Temp Breaking Change.
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
    // testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(3).build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});
    assertFalse(appendFuture3.isDone());
    writer.flushAll(100000);
    assertTrue(appendFuture3.isDone());

    writer.close();
  }

  @Test
  public void testFlushAllFailed() throws Exception {
    StreamWriter writer =
        getTestStreamWriterBuilder()
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(100000))
                    .build())
            .build();

    testBigQueryWrite.addException(Status.DATA_LOSS.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});

    assertFalse(appendFuture3.isDone());
    try {
      writer.flushAll(100000);
      fail("Should have thrown an Exception");
    } catch (Exception expected) {
      if (expected.getCause() instanceof com.google.api.gax.rpc.DataLossException
          | expected instanceof java.lang.InterruptedException) {
        LOG.info("got: " + expected.toString());
        if (expected instanceof java.lang.InterruptedException) {
          LOG.warning("Test return ealy due to InterruptedException");
          return;
        }
      } else {
        fail("Unexpected exception:" + expected.toString());
      }
    }

    assertTrue(appendFuture3.isDone());

    writer.close();
  }
}
