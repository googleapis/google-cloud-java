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

package com.google.cloud.workflows.executions.v1beta;

import static com.google.cloud.workflows.executions.v1beta.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.workflows.executions.v1beta.stub.HttpJsonExecutionsStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ExecutionsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ExecutionsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonExecutionsStub.getMethodDescriptors(), ExecutionsSettings.getDefaultEndpoint());
    ExecutionsSettings settings =
        ExecutionsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ExecutionsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ExecutionsClient.create(settings);
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
  public void listExecutionsTest() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

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
  public void listExecutionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExecutionsTest2() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

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
  public void listExecutionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
    Execution execution = Execution.newBuilder().build();

    Execution actualResponse = client.createExecution(parent, execution);
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
  public void createExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      Execution execution = Execution.newBuilder().build();
      client.createExecution(parent, execution);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";
    Execution execution = Execution.newBuilder().build();

    Execution actualResponse = client.createExecution(parent, execution);
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
  public void createExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";
      Execution execution = Execution.newBuilder().build();
      client.createExecution(parent, execution);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
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
  public void getExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7317/locations/location-7317/workflows/workflow-7317/executions/execution-7317";

    Execution actualResponse = client.getExecution(name);
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
  public void getExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7317/locations/location-7317/workflows/workflow-7317/executions/execution-7317";
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");

    Execution actualResponse = client.cancelExecution(name);
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
  public void cancelExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
      client.cancelExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArgument("argument-1589682499")
            .setResult("result-934426595")
            .setError(Execution.Error.newBuilder().build())
            .setWorkflowRevisionId("workflowRevisionId-1575712907")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7317/locations/location-7317/workflows/workflow-7317/executions/execution-7317";

    Execution actualResponse = client.cancelExecution(name);
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
  public void cancelExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7317/locations/location-7317/workflows/workflow-7317/executions/execution-7317";
      client.cancelExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
