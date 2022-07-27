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

package com.google.cloud.lifesciences.v2beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class WorkflowsServiceV2BetaClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockWorkflowsServiceV2Beta mockWorkflowsServiceV2Beta;
  private LocalChannelProvider channelProvider;
  private WorkflowsServiceV2BetaClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkflowsServiceV2Beta = new MockWorkflowsServiceV2Beta();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWorkflowsServiceV2Beta));
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
    WorkflowsServiceV2BetaSettings settings =
        WorkflowsServiceV2BetaSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkflowsServiceV2BetaClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void runPipelineTest() throws Exception {
    RunPipelineResponse expectedResponse = RunPipelineResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflowsServiceV2Beta.addResponse(resultOperation);

    RunPipelineRequest request =
        RunPipelineRequest.newBuilder()
            .setParent("parent-995424086")
            .setPipeline(Pipeline.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPubSubTopic("pubSubTopic320524524")
            .build();

    RunPipelineResponse actualResponse = client.runPipelineAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkflowsServiceV2Beta.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunPipelineRequest actualRequest = ((RunPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPipeline(), actualRequest.getPipeline());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertEquals(request.getPubSubTopic(), actualRequest.getPubSubTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkflowsServiceV2Beta.addException(exception);

    try {
      RunPipelineRequest request =
          RunPipelineRequest.newBuilder()
              .setParent("parent-995424086")
              .setPipeline(Pipeline.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setPubSubTopic("pubSubTopic320524524")
              .build();
      client.runPipelineAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
