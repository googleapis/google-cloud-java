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
package com.google.cloud.workflows.executions.v1beta;

import static com.google.cloud.workflows.executions.v1beta.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class ExecutionsClientTest {
  private static MockExecutions mockExecutions;
  private static MockServiceHelper serviceHelper;
  private ExecutionsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockExecutions = new MockExecutions();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockExecutions));
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
    ExecutionsSettings settings =
        ExecutionsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ExecutionsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listExecutionsTest() {
    String nextPageToken = "";
    Execution executionsElement = Execution.newBuilder().build();
    List<Execution> executions = Arrays.asList(executionsElement);
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllExecutions(executions)
            .build();
    mockExecutions.addResponse(expectedResponse);

    WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExecutions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = (ListExecutionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, WorkflowName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockExecutions.addException(exception);

    try {
      WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createExecutionTest() {
    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
    String argument = "argument-1589682499";
    String result = "result-934426595";
    String workflowRevisionId = "workflowRevisionId-1453295745";
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(name.toString())
            .setArgument(argument)
            .setResult(result)
            .setWorkflowRevisionId(workflowRevisionId)
            .build();
    mockExecutions.addResponse(expectedResponse);

    WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
    Execution execution = Execution.newBuilder().build();

    Execution actualResponse = client.createExecution(parent, execution);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExecutions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExecutionRequest actualRequest = (CreateExecutionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, WorkflowName.parse(actualRequest.getParent()));
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockExecutions.addException(exception);

    try {
      WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      Execution execution = Execution.newBuilder().build();

      client.createExecution(parent, execution);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getExecutionTest() {
    ExecutionName name2 = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
    String argument = "argument-1589682499";
    String result = "result-934426595";
    String workflowRevisionId = "workflowRevisionId-1453295745";
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(name2.toString())
            .setArgument(argument)
            .setResult(result)
            .setWorkflowRevisionId(workflowRevisionId)
            .build();
    mockExecutions.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExecutions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = (GetExecutionRequest) actualRequests.get(0);

    Assert.assertEquals(name, ExecutionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockExecutions.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelExecutionTest() {
    ExecutionName name2 = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
    String argument = "argument-1589682499";
    String result = "result-934426595";
    String workflowRevisionId = "workflowRevisionId-1453295745";
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(name2.toString())
            .setArgument(argument)
            .setResult(result)
            .setWorkflowRevisionId(workflowRevisionId)
            .build();
    mockExecutions.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

    Execution actualResponse = client.cancelExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExecutions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelExecutionRequest actualRequest = (CancelExecutionRequest) actualRequests.get(0);

    Assert.assertEquals(name, ExecutionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockExecutions.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

      client.cancelExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
