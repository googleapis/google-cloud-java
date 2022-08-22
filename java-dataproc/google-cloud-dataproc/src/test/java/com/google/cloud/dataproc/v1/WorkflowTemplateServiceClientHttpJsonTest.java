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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonWorkflowTemplateServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class WorkflowTemplateServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WorkflowTemplateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWorkflowTemplateServiceStub.getMethodDescriptors(),
            WorkflowTemplateServiceSettings.getDefaultEndpoint());
    WorkflowTemplateServiceSettings settings =
        WorkflowTemplateServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WorkflowTemplateServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkflowTemplateServiceClient.create(settings);
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
  public void createWorkflowTemplateTest() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                        "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    WorkflowTemplate actualResponse = client.createWorkflowTemplate(parent, template);
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
  public void createWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.createWorkflowTemplate(parent, template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowTemplateTest2() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                        "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    WorkflowTemplate actualResponse = client.createWorkflowTemplate(parent, template);
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
  public void createWorkflowTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.createWorkflowTemplate(parent, template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowTemplateTest3() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                        "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    WorkflowTemplate actualResponse = client.createWorkflowTemplate(parent, template);
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
  public void createWorkflowTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.createWorkflowTemplate(parent, template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowTemplateTest() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
                        "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowTemplateName name =
        WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
            "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");

    WorkflowTemplate actualResponse = client.getWorkflowTemplate(name);
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
  public void getWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
              "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");
      client.getWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowTemplateTest2() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
                        "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";

    WorkflowTemplate actualResponse = client.getWorkflowTemplate(name);
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
  public void getWorkflowTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";
      client.getWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void instantiateWorkflowTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkflowTemplateName name =
        WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
            "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");

    client.instantiateWorkflowTemplateAsync(name).get();

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
  public void instantiateWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
              "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");
      client.instantiateWorkflowTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateWorkflowTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";

    client.instantiateWorkflowTemplateAsync(name).get();

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
  public void instantiateWorkflowTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";
      client.instantiateWorkflowTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateWorkflowTemplateTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkflowTemplateName name =
        WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
            "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");
    Map<String, String> parameters = new HashMap<>();

    client.instantiateWorkflowTemplateAsync(name, parameters).get();

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
  public void instantiateWorkflowTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
              "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");
      Map<String, String> parameters = new HashMap<>();
      client.instantiateWorkflowTemplateAsync(name, parameters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateWorkflowTemplateTest4() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";
    Map<String, String> parameters = new HashMap<>();

    client.instantiateWorkflowTemplateAsync(name, parameters).get();

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
  public void instantiateWorkflowTemplateExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";
      Map<String, String> parameters = new HashMap<>();
      client.instantiateWorkflowTemplateAsync(name, parameters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateInlineWorkflowTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateInlineWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    client.instantiateInlineWorkflowTemplateAsync(parent, template).get();

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
  public void instantiateInlineWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.instantiateInlineWorkflowTemplateAsync(parent, template).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateInlineWorkflowTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateInlineWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    client.instantiateInlineWorkflowTemplateAsync(parent, template).get();

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
  public void instantiateInlineWorkflowTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.instantiateInlineWorkflowTemplateAsync(parent, template).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void instantiateInlineWorkflowTemplateTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("instantiateInlineWorkflowTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    WorkflowTemplate template = WorkflowTemplate.newBuilder().build();

    client.instantiateInlineWorkflowTemplateAsync(parent, template).get();

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
  public void instantiateInlineWorkflowTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
      client.instantiateInlineWorkflowTemplateAsync(parent, template).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkflowTemplateTest() throws Exception {
    WorkflowTemplate expectedResponse =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
                        "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowTemplate template =
        WorkflowTemplate.newBuilder()
            .setId("id3355")
            .setName(
                WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                        "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
                    .toString())
            .setVersion(351608024)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
            .addAllJobs(new ArrayList<OrderedJob>())
            .addAllParameters(new ArrayList<TemplateParameter>())
            .setDagTimeout(Duration.newBuilder().build())
            .build();

    WorkflowTemplate actualResponse = client.updateWorkflowTemplate(template);
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
  public void updateWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowTemplate template =
          WorkflowTemplate.newBuilder()
              .setId("id3355")
              .setName(
                  WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                          "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
                      .toString())
              .setVersion(351608024)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setPlacement(WorkflowTemplatePlacement.newBuilder().build())
              .addAllJobs(new ArrayList<OrderedJob>())
              .addAllParameters(new ArrayList<TemplateParameter>())
              .setDagTimeout(Duration.newBuilder().build())
              .build();
      client.updateWorkflowTemplate(template);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowTemplatesTest() throws Exception {
    WorkflowTemplate responsesElement = WorkflowTemplate.newBuilder().build();
    ListWorkflowTemplatesResponse expectedResponse =
        ListWorkflowTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkflowTemplatesPagedResponse pagedListResponse = client.listWorkflowTemplates(parent);

    List<WorkflowTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

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
  public void listWorkflowTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listWorkflowTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowTemplatesTest2() throws Exception {
    WorkflowTemplate responsesElement = WorkflowTemplate.newBuilder().build();
    ListWorkflowTemplatesResponse expectedResponse =
        ListWorkflowTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

    ListWorkflowTemplatesPagedResponse pagedListResponse = client.listWorkflowTemplates(parent);

    List<WorkflowTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

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
  public void listWorkflowTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      client.listWorkflowTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowTemplatesTest3() throws Exception {
    WorkflowTemplate responsesElement = WorkflowTemplate.newBuilder().build();
    ListWorkflowTemplatesResponse expectedResponse =
        ListWorkflowTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListWorkflowTemplatesPagedResponse pagedListResponse = client.listWorkflowTemplates(parent);

    List<WorkflowTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

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
  public void listWorkflowTemplatesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listWorkflowTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    WorkflowTemplateName name =
        WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
            "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");

    client.deleteWorkflowTemplate(name);

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
  public void deleteWorkflowTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowTemplateName name =
          WorkflowTemplateName.ofProjectLocationWorkflowTemplateName(
              "[PROJECT]", "[LOCATION]", "[WORKFLOW_TEMPLATE]");
      client.deleteWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";

    client.deleteWorkflowTemplate(name);

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
  public void deleteWorkflowTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5104/locations/location-5104/workflowTemplates/workflowTemplate-5104";
      client.deleteWorkflowTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
