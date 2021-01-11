/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.devtools.cloudtrace.v2.StackTrace;
import com.google.devtools.cloudtrace.v2.TruncatableString;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TraceServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private TraceServiceClient client;
  private static MockTraceService mockTraceService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTraceService = new MockTraceService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTraceService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void batchWriteSpansTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTraceService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    List<Span> spans = new ArrayList<>();

    client.batchWriteSpans(name, spans);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchWriteSpansRequest actualRequest = ((BatchWriteSpansRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(spans, actualRequest.getSpansList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchWriteSpansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      List<Span> spans = new ArrayList<>();
      client.batchWriteSpans(name, spans);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchWriteSpansTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTraceService.addResponse(expectedResponse);

    String name = "name3373707";
    List<Span> spans = new ArrayList<>();

    client.batchWriteSpans(name, spans);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchWriteSpansRequest actualRequest = ((BatchWriteSpansRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(spans, actualRequest.getSpansList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchWriteSpansExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      String name = "name3373707";
      List<Span> spans = new ArrayList<>();
      client.batchWriteSpans(name, spans);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpanTest() throws Exception {
    Span expectedResponse =
        Span.newBuilder()
            .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
            .setSpanId("spanId-896182779")
            .setParentSpanId("parentSpanId1059234639")
            .setDisplayName(TruncatableString.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAttributes(Span.Attributes.newBuilder().build())
            .setStackTrace(StackTrace.newBuilder().build())
            .setTimeEvents(Span.TimeEvents.newBuilder().build())
            .setLinks(Span.Links.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
            .setChildSpanCount(Int32Value.newBuilder().build())
            .build();
    mockTraceService.addResponse(expectedResponse);

    Span request =
        Span.newBuilder()
            .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
            .setSpanId("spanId-896182779")
            .setParentSpanId("parentSpanId1059234639")
            .setDisplayName(TruncatableString.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAttributes(Span.Attributes.newBuilder().build())
            .setStackTrace(StackTrace.newBuilder().build())
            .setTimeEvents(Span.TimeEvents.newBuilder().build())
            .setLinks(Span.Links.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
            .setChildSpanCount(Int32Value.newBuilder().build())
            .build();

    Span actualResponse = client.createSpan(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Span actualRequest = ((Span) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getSpanId(), actualRequest.getSpanId());
    Assert.assertEquals(request.getParentSpanId(), actualRequest.getParentSpanId());
    Assert.assertEquals(request.getDisplayName(), actualRequest.getDisplayName());
    Assert.assertEquals(request.getStartTime(), actualRequest.getStartTime());
    Assert.assertEquals(request.getEndTime(), actualRequest.getEndTime());
    Assert.assertEquals(request.getAttributes(), actualRequest.getAttributes());
    Assert.assertEquals(request.getStackTrace(), actualRequest.getStackTrace());
    Assert.assertEquals(request.getTimeEvents(), actualRequest.getTimeEvents());
    Assert.assertEquals(request.getLinks(), actualRequest.getLinks());
    Assert.assertEquals(request.getStatus(), actualRequest.getStatus());
    Assert.assertEquals(
        request.getSameProcessAsParentSpan(), actualRequest.getSameProcessAsParentSpan());
    Assert.assertEquals(request.getChildSpanCount(), actualRequest.getChildSpanCount());
    Assert.assertEquals(request.getSpanKind(), actualRequest.getSpanKind());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      Span request =
          Span.newBuilder()
              .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
              .setSpanId("spanId-896182779")
              .setParentSpanId("parentSpanId1059234639")
              .setDisplayName(TruncatableString.newBuilder().build())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setAttributes(Span.Attributes.newBuilder().build())
              .setStackTrace(StackTrace.newBuilder().build())
              .setTimeEvents(Span.TimeEvents.newBuilder().build())
              .setLinks(Span.Links.newBuilder().build())
              .setStatus(Status.newBuilder().build())
              .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
              .setChildSpanCount(Int32Value.newBuilder().build())
              .build();
      client.createSpan(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
