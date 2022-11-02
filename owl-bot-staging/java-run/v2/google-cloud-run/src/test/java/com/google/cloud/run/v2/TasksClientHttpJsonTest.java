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

package com.google.cloud.run.v2;

import static com.google.cloud.run.v2.TasksClient.ListTasksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.run.v2.stub.HttpJsonTasksStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
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
public class TasksClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TasksClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTasksStub.getMethodDescriptors(), TasksSettings.getDefaultEndpoint());
    TasksSettings settings =
        TasksSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TasksSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TasksClient.create(settings);
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
  public void getTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(
                TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]").toString())
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setCompletionTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setExecution(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setMaxRetries(1129288043)
            .setTimeout(Duration.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setExecutionEnvironment(ExecutionEnvironment.forNumber(0))
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setIndex(100346066)
            .setRetried(1098377527)
            .setLastAttemptResult(TaskAttemptResult.newBuilder().build())
            .setEncryptionKey("encryptionKey-36224036")
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]");

    Task actualResponse = client.getTask(name);
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
  public void getTaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]");
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(
                TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]").toString())
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setCompletionTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setExecution(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setMaxRetries(1129288043)
            .setTimeout(Duration.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setExecutionEnvironment(ExecutionEnvironment.forNumber(0))
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setIndex(100346066)
            .setRetried(1098377527)
            .setLastAttemptResult(TaskAttemptResult.newBuilder().build())
            .setEncryptionKey("encryptionKey-36224036")
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-119/locations/location-119/jobs/job-119/executions/execution-119/tasks/task-119";

    Task actualResponse = client.getTask(name);
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
  public void getTaskExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-119/locations/location-119/jobs/job-119/executions/execution-119/tasks/task-119";
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

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
  public void listTasksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest2() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1154/locations/location-1154/jobs/job-1154/executions/execution-1154";

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

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
  public void listTasksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1154/locations/location-1154/jobs/job-1154/executions/execution-1154";
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
