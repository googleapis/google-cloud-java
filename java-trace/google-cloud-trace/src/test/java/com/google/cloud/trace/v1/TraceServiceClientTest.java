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

package com.google.cloud.trace.v1;

import static com.google.cloud.trace.v1.TraceServiceClient.ListTracesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
  public void listTracesTest() throws Exception {
    Trace responsesElement = Trace.newBuilder().build();
    ListTracesResponse expectedResponse =
        ListTracesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTraces(Arrays.asList(responsesElement))
            .build();
    mockTraceService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";

    ListTracesPagedResponse pagedListResponse = client.listTraces(projectId);

    List<Trace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTracesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTracesRequest actualRequest = ((ListTracesRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTracesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      String projectId = "projectId-894832108";
      client.listTraces(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTraceTest() throws Exception {
    Trace expectedResponse =
        Trace.newBuilder()
            .setProjectId("projectId-894832108")
            .setTraceId("traceId-1067401920")
            .addAllSpans(new ArrayList<TraceSpan>())
            .build();
    mockTraceService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String traceId = "traceId-1067401920";

    Trace actualResponse = client.getTrace(projectId, traceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTraceRequest actualRequest = ((GetTraceRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(traceId, actualRequest.getTraceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTraceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String traceId = "traceId-1067401920";
      client.getTrace(projectId, traceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void patchTracesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTraceService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    Traces traces = Traces.newBuilder().build();

    client.patchTraces(projectId, traces);

    List<AbstractMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchTracesRequest actualRequest = ((PatchTracesRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(traces, actualRequest.getTraces());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void patchTracesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTraceService.addException(exception);

    try {
      String projectId = "projectId-894832108";
      Traces traces = Traces.newBuilder().build();
      client.patchTraces(projectId, traces);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
