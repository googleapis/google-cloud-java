/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse;

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
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class WorkflowTemplateServiceClientTest {
  private static MockClusterController mockClusterController;
  private static MockJobController mockJobController;
  private static MockWorkflowTemplateService mockWorkflowTemplateService;
  private static MockServiceHelper serviceHelper;
  private WorkflowTemplateServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterController = new MockClusterController();
    mockJobController = new MockJobController();
    mockWorkflowTemplateService = new MockWorkflowTemplateService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockClusterController, mockJobController, mockWorkflowTemplateService));
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
    WorkflowTemplateServiceSettings settings =
        WorkflowTemplateServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkflowTemplateServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkflowTemplateTest() {
    String id = "id3355";
    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");
    int version = 351608024;
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId(id)
            .setName(name.toString())
            .setVersion(version)
            .build();
    mockWorkflowTemplateService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    WorkflowTemplate actualResponse = client.createWorkflowTemplate(parent, template);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkflowTemplateRequest actualRequest =
        (CreateWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegionName.parse(actualRequest.getParent()));
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

      client.createWorkflowTemplate(parent, template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkflowTemplateTest() {
    String id = "id3355";
    WorkflowTemplateName name2 =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");
    int version = 351608024;
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId(id)
            .setName(name2.toString())
            .setVersion(version)
            .build();
    mockWorkflowTemplateService.addResponse(expectedResponse);

    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

    WorkflowTemplate actualResponse = client.getWorkflowTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkflowTemplateRequest actualRequest = (GetWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

      client.getWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateWorkflowTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflowTemplateService.addResponse(resultOperation);

    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

    Empty actualResponse = client.instantiateWorkflowTemplateAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstantiateWorkflowTemplateRequest actualRequest =
        (InstantiateWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

      client.instantiateWorkflowTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateWorkflowTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest2")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflowTemplateService.addResponse(resultOperation);

    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");
    Map<String, String> parameters = new HashMap<>();

    Empty actualResponse = client.instantiateWorkflowTemplateAsync(name, parameters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstantiateWorkflowTemplateRequest actualRequest =
        (InstantiateWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowTemplateName.parse(actualRequest.getName()));
    Assert.assertEquals(parameters, actualRequest.getParametersMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateWorkflowTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");
      Map<String, String> parameters = new HashMap<>();

      client.instantiateWorkflowTemplateAsync(name, parameters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateInlineWorkflowTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateInlineWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkflowTemplateService.addResponse(resultOperation);

    String formattedParent = RegionName.format("[PROJECT]", "[REGION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    Empty actualResponse =
        client.instantiateInlineWorkflowTemplateAsync(formattedParent, template).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstantiateInlineWorkflowTemplateRequest actualRequest =
        (InstantiateInlineWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void instantiateInlineWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      String formattedParent = RegionName.format("[PROJECT]", "[REGION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

      client.instantiateInlineWorkflowTemplateAsync(formattedParent, template).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkflowTemplateTest() {
    String id = "id3355";
    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");
    int version = 351608024;
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId(id)
            .setName(name.toString())
            .setVersion(version)
            .build();
    mockWorkflowTemplateService.addResponse(expectedResponse);

    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    WorkflowTemplate actualResponse = client.updateWorkflowTemplate(template);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkflowTemplateRequest actualRequest =
        (UpdateWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

      client.updateWorkflowTemplate(template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkflowTemplatesTest() {
    String nextPageToken = "";
    WorkflowTemplate templatesElement = WorkflowTemplate.newBuilder().build();
    List<WorkflowTemplate> templates = Arrays.asList(templatesElement);
    ListWorkflowTemplatesResponse expectedResponse =
        ListWorkflowTemplatesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTemplates(templates)
            .build();
    mockWorkflowTemplateService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

    ListWorkflowTemplatesPagedResponse pagedListResponse = client.listWorkflowTemplates(parent);

    List<WorkflowTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkflowTemplatesRequest actualRequest =
        (ListWorkflowTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegionName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkflowTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

      client.listWorkflowTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkflowTemplateTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWorkflowTemplateService.addResponse(expectedResponse);

    WorkflowTemplateName name =
        WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

    client.deleteWorkflowTemplate(name);

    List<GeneratedMessageV3> actualRequests = mockWorkflowTemplateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkflowTemplateRequest actualRequest =
        (DeleteWorkflowTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkflowTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkflowTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWorkflowTemplateService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.of("[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]");

      client.deleteWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
