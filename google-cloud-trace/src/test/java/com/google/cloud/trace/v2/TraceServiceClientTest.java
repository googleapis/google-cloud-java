/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest;
import com.google.devtools.cloudtrace.v2.ProjectName;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
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
public class TraceServiceClientTest {
  private static MockTraceService mockTraceService;
  private static MockServiceHelper serviceHelper;
  private TraceServiceClient client;

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
        TraceServiceSettings.newBuilder()
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
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

    List<GeneratedMessageV3> actualRequests = mockTraceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchWriteSpansRequest actualRequest = (BatchWriteSpansRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsProjectName());
    Assert.assertEquals(spans, actualRequest.getSpansList());
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
}
