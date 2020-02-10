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
package com.google.cloud.trace.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest;
import com.google.devtools.cloudtrace.v2.ProjectName;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.devtools.cloudtrace.v2.SpanName;
import com.google.devtools.cloudtrace.v2.TruncatableString;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TraceServiceClientTest {
  private static MockTraceService mockTraceService;
  private static MockServiceHelper serviceHelper;
  private TraceServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTraceService = new MockTraceService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTraceService));
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
    TraceServiceSettings settings =
        TraceServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TraceServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void batchWriteSpansTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTraceService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    List<Span> spans = new ArrayList<>();

    client.batchWriteSpans(name, spans);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchWriteSpansRequest actualRequest = (BatchWriteSpansRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectName.parse(actualRequest.getName()));
    Assert.assertEquals(spans, actualRequest.getSpansList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchWriteSpansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      List<Span> spans = new ArrayList<>();

      client.batchWriteSpans(name, spans);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSpanTest() {
    SpanName name2 = SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]");
    String spanId2 = "spanId2-643891741";
    String parentSpanId = "parentSpanId-1757797477";
    Span expectedResponse =
        Span.newBuilder()
            .setName(name2.toString())
            .setSpanId(spanId2)
            .setParentSpanId(parentSpanId)
            .build();
    mockTraceService.addResponse(expectedResponse);

    SpanName name = SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]");
    String spanId = "spanId-2011840976";
    TruncatableString displayName = TruncatableString.newBuilder().build();
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();
    Span request =
        Span.newBuilder()
            .setName(name.toString())
            .setSpanId(spanId)
            .setDisplayName(displayName)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();

    Span actualResponse = client.createSpan(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Span actualRequest = (Span) actualRequests.get(0);

    Assert.assertEquals(name, SpanName.parse(actualRequest.getName()));
    Assert.assertEquals(spanId, actualRequest.getSpanId());
    Assert.assertEquals(displayName, actualRequest.getDisplayName());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSpanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      SpanName name = SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]");
      String spanId = "spanId-2011840976";
      TruncatableString displayName = TruncatableString.newBuilder().build();
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      Span request =
          Span.newBuilder()
              .setName(name.toString())
              .setSpanId(spanId)
              .setDisplayName(displayName)
              .setStartTime(startTime)
              .setEndTime(endTime)
              .build();

      client.createSpan(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
