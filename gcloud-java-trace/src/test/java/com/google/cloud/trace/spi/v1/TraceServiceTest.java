/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.trace.spi.v1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TraceServiceTest {
  private static MockTraceService mockTraceService;
  private static MockServiceHelper serviceHelper;
  private TraceServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    mockTraceService = new MockTraceService();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockTraceService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    TraceServiceSettings settings =
        TraceServiceSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = TraceServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void patchTracesTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockTraceService.setResponses(expectedResponses);

    String projectId = "projectId-1969970175";
    Traces traces = Traces.newBuilder().build();

    api.patchTraces(projectId, traces);

    List<GeneratedMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchTracesRequest actualRequest = (PatchTracesRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(traces, actualRequest.getTraces());
  }

  @Test
  @SuppressWarnings("all")
  public void getTraceTest() {
    String projectId2 = "projectId2939242356";
    String traceId2 = "traceId2987826376";
    Trace expectedResponse =
        Trace.newBuilder().setProjectId(projectId2).setTraceId(traceId2).build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockTraceService.setResponses(expectedResponses);

    String projectId = "projectId-1969970175";
    String traceId = "traceId1270300245";

    Trace actualResponse = api.getTrace(projectId, traceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTraceRequest actualRequest = (GetTraceRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(traceId, actualRequest.getTraceId());
  }

  @Test
  @SuppressWarnings("all")
  public void listTracesTest() {
    Trace tracesElement = Trace.newBuilder().build();
    List<Trace> traces = Arrays.asList(tracesElement);
    String nextPageToken = "nextPageToken-1530815211";
    ListTracesResponse expectedResponse =
        ListTracesResponse.newBuilder()
            .addAllTraces(traces)
            .setNextPageToken(nextPageToken)
            .build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockTraceService.setResponses(expectedResponses);

    String projectId = "projectId-1969970175";

    PageAccessor<Trace> pageAccessor = api.listTraces(projectId);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<Trace> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTracesList().get(0), resources.get(0));

    List<GeneratedMessage> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTracesRequest actualRequest = (ListTracesRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
  }
}
