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

package com.google.cloud.devtools.cloudtrace.spi.v1;

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
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TraceServiceTest {
  private static MockServiceHelper serviceHelper;
  private TraceServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    MockTraceService mockService = new MockTraceService();
    serviceHelper = new MockServiceHelper("in-process-1", mockService);
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
  public void listTracesTest() {
    ListTracesResponse expectedResponse = ListTracesResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String projectId = "";
    PageAccessor<Trace> pageAccessor = api.listTraces(projectId);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<Trace> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(0, resources.size());

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTracesRequest actualRequest = (ListTracesRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getProjectId(), projectId);
  }

  @Test
  @SuppressWarnings("all")
  public void getTraceTest() {
    Trace expectedResponse = Trace.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String projectId = "";
    String traceId = "";
    Trace actualResponse = api.getTrace(projectId, traceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTraceRequest actualRequest = (GetTraceRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getProjectId(), projectId);
    Assert.assertEquals(actualRequest.getTraceId(), traceId);
  }

  @Test
  @SuppressWarnings("all")
  public void patchTracesTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String projectId = "";
    Traces traces = Traces.newBuilder().build();
    api.patchTraces(projectId, traces);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchTracesRequest actualRequest = (PatchTracesRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getProjectId(), projectId);
    Assert.assertEquals(actualRequest.getTraces(), traces);
  }
}
