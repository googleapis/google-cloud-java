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
package com.google.cloud.workflows.v1beta;

import static com.google.cloud.workflows.v1beta.WorkflowsClient.ListWorkflowsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class WorkflowsClientTest {
  private static MockWorkflows mockWorkflows;
  private static MockServiceHelper serviceHelper;
  private WorkflowsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkflows = new MockWorkflows();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockWorkflows));
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
    WorkflowsSettings settings =
        WorkflowsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkflowsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkflowsTest() {
    String nextPageToken = "";
    Workflow workflowsElement = Workflow.newBuilder().build();
    List<Workflow> workflows = Arrays.asList(workflowsElement);
    ListWorkflowsResponse expectedResponse =
        ListWorkflowsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllWorkflows(workflows)
            .build();
    mockWorkflows.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkflowsPagedResponse pagedListResponse = client.listWorkflows(parent);

    List<Workflow> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkflows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkflowsRequest actualRequest = (ListWorkflowsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkflowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflows.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listWorkflows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkflowTest() {
    WorkflowName name2 = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
    String description = "description-1724546052";
    String revisionId = "revisionId513861631";
    String serviceAccount = "serviceAccount-1948028253";
    String sourceContents = "sourceContents-1799875906";
    Workflow expectedResponse =
        Workflow.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRevisionId(revisionId)
            .setServiceAccount(serviceAccount)
            .setSourceContents(sourceContents)
            .build();
    mockWorkflows.addResponse(expectedResponse);

    WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    Workflow actualResponse = client.getWorkflow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkflows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkflowRequest actualRequest = (GetWorkflowRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflows.addException(exception);

    try {
      WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

      client.getWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkflowTest() throws Exception {
    WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
    String description = "description-1724546052";
    String revisionId = "revisionId513861631";
    String serviceAccount = "serviceAccount-1948028253";
    String sourceContents = "sourceContents-1799875906";
    Workflow expectedResponse =
        Workflow.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setRevisionId(revisionId)
            .setServiceAccount(serviceAccount)
            .setSourceContents(sourceContents)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkflowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflows.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Workflow workflow = Workflow.newBuilder().build();
    String workflowId = "workflowId1712917915";

    Workflow actualResponse = client.createWorkflowAsync(parent, workflow, workflowId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkflows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkflowRequest actualRequest = (CreateWorkflowRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(workflow, actualRequest.getWorkflow());
    Assert.assertEquals(workflowId, actualRequest.getWorkflowId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflows.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Workflow workflow = Workflow.newBuilder().build();
      String workflowId = "workflowId1712917915";

      client.createWorkflowAsync(parent, workflow, workflowId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkflowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkflowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflows.addResponse(resultOperation);

    WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    Empty actualResponse = client.deleteWorkflowAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkflows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkflowRequest actualRequest = (DeleteWorkflowRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflows.addException(exception);

    try {
      WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

      client.deleteWorkflowAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkflowTest() throws Exception {
    WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
    String description = "description-1724546052";
    String revisionId = "revisionId513861631";
    String serviceAccount = "serviceAccount-1948028253";
    String sourceContents = "sourceContents-1799875906";
    Workflow expectedResponse =
        Workflow.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setRevisionId(revisionId)
            .setServiceAccount(serviceAccount)
            .setSourceContents(sourceContents)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkflowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflows.addResponse(resultOperation);

    Workflow workflow = Workflow.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workflow actualResponse = client.updateWorkflowAsync(workflow, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkflows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkflowRequest actualRequest = (UpdateWorkflowRequest) actualRequests.get(0);

    Assert.assertEquals(workflow, actualRequest.getWorkflow());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflows.addException(exception);

    try {
      Workflow workflow = Workflow.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateWorkflowAsync(workflow, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
