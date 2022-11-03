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

package com.google.cloud.bigquery.migration.v2alpha;

import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.bigquery.migration.v2alpha.stub.HttpJsonMigrationServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.rpc.ErrorInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MigrationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MigrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMigrationServiceStub.getMethodDescriptors(),
            MigrationServiceSettings.getDefaultEndpoint());
    MigrationServiceSettings settings =
        MigrationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MigrationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MigrationServiceClient.create(settings);
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
  public void createMigrationWorkflowTest() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();

    MigrationWorkflow actualResponse = client.createMigrationWorkflow(parent, migrationWorkflow);
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
  public void createMigrationWorkflowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
      client.createMigrationWorkflow(parent, migrationWorkflow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMigrationWorkflowTest2() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();

    MigrationWorkflow actualResponse = client.createMigrationWorkflow(parent, migrationWorkflow);
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
  public void createMigrationWorkflowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
      client.createMigrationWorkflow(parent, migrationWorkflow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationWorkflowTest() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    MigrationWorkflow actualResponse = client.getMigrationWorkflow(name);
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
  public void getMigrationWorkflowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.getMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationWorkflowTest2() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";

    MigrationWorkflow actualResponse = client.getMigrationWorkflow(name);
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
  public void getMigrationWorkflowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";
      client.getMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationWorkflowsTest() throws Exception {
    MigrationWorkflow responsesElement = MigrationWorkflow.newBuilder().build();
    ListMigrationWorkflowsResponse expectedResponse =
        ListMigrationWorkflowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationWorkflows(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMigrationWorkflowsPagedResponse pagedListResponse = client.listMigrationWorkflows(parent);

    List<MigrationWorkflow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationWorkflowsList().get(0), resources.get(0));

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
  public void listMigrationWorkflowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMigrationWorkflows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationWorkflowsTest2() throws Exception {
    MigrationWorkflow responsesElement = MigrationWorkflow.newBuilder().build();
    ListMigrationWorkflowsResponse expectedResponse =
        ListMigrationWorkflowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationWorkflows(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListMigrationWorkflowsPagedResponse pagedListResponse = client.listMigrationWorkflows(parent);

    List<MigrationWorkflow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationWorkflowsList().get(0), resources.get(0));

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
  public void listMigrationWorkflowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listMigrationWorkflows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMigrationWorkflowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    client.deleteMigrationWorkflow(name);

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
  public void deleteMigrationWorkflowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.deleteMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMigrationWorkflowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";

    client.deleteMigrationWorkflow(name);

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
  public void deleteMigrationWorkflowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";
      client.deleteMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startMigrationWorkflowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    client.startMigrationWorkflow(name);

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
  public void startMigrationWorkflowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.startMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startMigrationWorkflowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";

    client.startMigrationWorkflow(name);

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
  public void startMigrationWorkflowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4710/locations/location-4710/workflows/workflow-4710";
      client.startMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationSubtaskTest() throws Exception {
    MigrationSubtask expectedResponse =
        MigrationSubtask.newBuilder()
            .setName(
                MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
                    .toString())
            .setTaskId("taskId-880873088")
            .setType("type3575610")
            .setProcessingError(ErrorInfo.newBuilder().build())
            .addAllResourceErrorDetails(new ArrayList<ResourceErrorDetail>())
            .setResourceErrorCount(-929997465)
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<TimeSeries>())
            .build();
    mockService.addResponse(expectedResponse);

    MigrationSubtaskName name =
        MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]");

    MigrationSubtask actualResponse = client.getMigrationSubtask(name);
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
  public void getMigrationSubtaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigrationSubtaskName name =
          MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]");
      client.getMigrationSubtask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationSubtaskTest2() throws Exception {
    MigrationSubtask expectedResponse =
        MigrationSubtask.newBuilder()
            .setName(
                MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
                    .toString())
            .setTaskId("taskId-880873088")
            .setType("type3575610")
            .setProcessingError(ErrorInfo.newBuilder().build())
            .addAllResourceErrorDetails(new ArrayList<ResourceErrorDetail>())
            .setResourceErrorCount(-929997465)
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<TimeSeries>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3070/locations/location-3070/workflows/workflow-3070/subtasks/subtask-3070";

    MigrationSubtask actualResponse = client.getMigrationSubtask(name);
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
  public void getMigrationSubtaskExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3070/locations/location-3070/workflows/workflow-3070/subtasks/subtask-3070";
      client.getMigrationSubtask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationSubtasksTest() throws Exception {
    MigrationSubtask responsesElement = MigrationSubtask.newBuilder().build();
    ListMigrationSubtasksResponse expectedResponse =
        ListMigrationSubtasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationSubtasks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MigrationWorkflowName parent =
        MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    ListMigrationSubtasksPagedResponse pagedListResponse = client.listMigrationSubtasks(parent);

    List<MigrationSubtask> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationSubtasksList().get(0), resources.get(0));

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
  public void listMigrationSubtasksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigrationWorkflowName parent =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.listMigrationSubtasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationSubtasksTest2() throws Exception {
    MigrationSubtask responsesElement = MigrationSubtask.newBuilder().build();
    ListMigrationSubtasksResponse expectedResponse =
        ListMigrationSubtasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationSubtasks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";

    ListMigrationSubtasksPagedResponse pagedListResponse = client.listMigrationSubtasks(parent);

    List<MigrationSubtask> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationSubtasksList().get(0), resources.get(0));

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
  public void listMigrationSubtasksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9319/locations/location-9319/workflows/workflow-9319";
      client.listMigrationSubtasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
