/*
 * Copyright 2022 Google LLC
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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.trace.v2.stub.HttpJsonTraceServiceStub;
import com.google.devtools.cloudtrace.v2.ProjectName;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.devtools.cloudtrace.v2.SpanName;
import com.google.devtools.cloudtrace.v2.StackTrace;
import com.google.devtools.cloudtrace.v2.TruncatableString;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TraceServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TraceServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTraceServiceStub.getMethodDescriptors(),
            TraceServiceSettings.getDefaultEndpoint());
    TraceServiceSettings settings =
        TraceServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TraceServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TraceServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void batchWriteSpansTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    List<Span> spans = new ArrayList<>();

    client.batchWriteSpans(name, spans);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchWriteSpansExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3664";
    List<Span> spans = new ArrayList<>();

    client.batchWriteSpans(name, spans);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchWriteSpansExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3664";
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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSpanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
