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

import static com.google.cloud.run.v2.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.LaunchStage;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.run.v2.stub.HttpJsonExecutionsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
  public void getExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
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
            .setLaunchStage(LaunchStage.forNumber(0))
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setParallelism(635164956)
            .setTaskCount(1297805781)
            .setTemplate(TaskTemplate.newBuilder().build())
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setRunningCount(261439119)
            .setSucceededCount(633694641)
            .setFailedCount(-2013829491)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");

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
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");
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
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
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
            .setLaunchStage(LaunchStage.forNumber(0))
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setParallelism(635164956)
            .setTaskCount(1297805781)
            .setTemplate(TaskTemplate.newBuilder().build())
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setRunningCount(261439119)
            .setSucceededCount(633694641)
            .setFailedCount(-2013829491)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3087/locations/location-3087/jobs/job-3087/executions/execution-3087";

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
          "projects/project-3087/locations/location-3087/jobs/job-3087/executions/execution-3087";
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
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

    JobName parent = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

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
      JobName parent = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
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

    String parent = "projects/project-7113/locations/location-7113/jobs/job-7113";

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
      String parent = "projects/project-7113/locations/location-7113/jobs/job-7113";
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
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
            .setLaunchStage(LaunchStage.forNumber(0))
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setParallelism(635164956)
            .setTaskCount(1297805781)
            .setTemplate(TaskTemplate.newBuilder().build())
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setRunningCount(261439119)
            .setSucceededCount(633694641)
            .setFailedCount(-2013829491)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");

    Execution actualResponse = client.deleteExecutionAsync(name).get();
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
  public void deleteExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
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
            .setLaunchStage(LaunchStage.forNumber(0))
            .setJob(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setParallelism(635164956)
            .setTaskCount(1297805781)
            .setTemplate(TaskTemplate.newBuilder().build())
            .setReconciling(true)
            .addAllConditions(new ArrayList<Condition>())
            .setObservedGeneration(900833007)
            .setRunningCount(261439119)
            .setSucceededCount(633694641)
            .setFailedCount(-2013829491)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3087/locations/location-3087/jobs/job-3087/executions/execution-3087";

    Execution actualResponse = client.deleteExecutionAsync(name).get();
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
  public void deleteExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3087/locations/location-3087/jobs/job-3087/executions/execution-3087";
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
