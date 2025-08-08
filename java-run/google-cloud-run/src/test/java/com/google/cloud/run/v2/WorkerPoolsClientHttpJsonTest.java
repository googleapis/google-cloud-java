/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

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
import com.google.cloud.run.v2.stub.HttpJsonWorkerPoolsStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
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
public class WorkerPoolsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WorkerPoolsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWorkerPoolsStub.getMethodDescriptors(),
            WorkerPoolsSettings.getDefaultEndpoint());
    WorkerPoolsSettings settings =
        WorkerPoolsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WorkerPoolsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkerPoolsClient.create(settings);
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
  public void createWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
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
  public void createWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
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
  public void createWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.getWorkerPool(name);
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
  public void getWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.getWorkerPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";

    WorkerPool actualResponse = client.getWorkerPool(name);
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
  public void getWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";
      client.getWorkerPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkerPoolsTest() throws Exception {
    WorkerPool responsesElement = WorkerPool.newBuilder().build();
    ListWorkerPoolsResponse expectedResponse =
        ListWorkerPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkerPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

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
  public void listWorkerPoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listWorkerPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkerPoolsTest2() throws Exception {
    WorkerPool responsesElement = WorkerPool.newBuilder().build();
    ListWorkerPoolsResponse expectedResponse =
        ListWorkerPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkerPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

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
  public void listWorkerPoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listWorkerPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkerPool workerPool =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool).get();
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
  public void updateWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPool workerPool =
          WorkerPool.newBuilder()
              .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .setDescription("description-1724546052")
              .setUid("uid115792")
              .setGeneration(305703192)
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .setCreator("creator1028554796")
              .setLastModifier("lastModifier1959003021")
              .setClient("client-1357712437")
              .setClientVersion("clientVersion771880589")
              .setLaunchStage(LaunchStage.forNumber(0))
              .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
              .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
              .addAllInstanceSplits(new ArrayList<InstanceSplit>())
              .setScaling(WorkerPoolScaling.newBuilder().build())
              .setObservedGeneration(900833007)
              .setTerminalCondition(Condition.newBuilder().build())
              .addAllConditions(new ArrayList<Condition>())
              .setLatestReadyRevision(
                  RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
              .setLatestCreatedRevision(
                  RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
              .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
              .addAllCustomAudiences(new ArrayList<String>())
              .setSatisfiesPzs(true)
              .setReconciling(true)
              .setEtag("etag3123477")
              .build();
      client.updateWorkerPoolAsync(workerPool).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkerPool workerPool =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool, updateMask).get();
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
  public void updateWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPool workerPool =
          WorkerPool.newBuilder()
              .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .setDescription("description-1724546052")
              .setUid("uid115792")
              .setGeneration(305703192)
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .setCreator("creator1028554796")
              .setLastModifier("lastModifier1959003021")
              .setClient("client-1357712437")
              .setClientVersion("clientVersion771880589")
              .setLaunchStage(LaunchStage.forNumber(0))
              .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
              .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
              .addAllInstanceSplits(new ArrayList<InstanceSplit>())
              .setScaling(WorkerPoolScaling.newBuilder().build())
              .setObservedGeneration(900833007)
              .setTerminalCondition(Condition.newBuilder().build())
              .addAllConditions(new ArrayList<Condition>())
              .setLatestReadyRevision(
                  RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
              .setLatestCreatedRevision(
                  RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
              .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
              .addAllCustomAudiences(new ArrayList<String>())
              .setSatisfiesPzs(true)
              .setReconciling(true)
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkerPoolAsync(workerPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.deleteWorkerPoolAsync(name).get();
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
  public void deleteWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setTemplate(WorkerPoolRevisionTemplate.newBuilder().build())
            .addAllInstanceSplits(new ArrayList<InstanceSplit>())
            .setScaling(WorkerPoolScaling.newBuilder().build())
            .setObservedGeneration(900833007)
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .setLatestReadyRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .setLatestCreatedRevision(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
            .addAllInstanceSplitStatuses(new ArrayList<InstanceSplitStatus>())
            .addAllCustomAudiences(new ArrayList<String>())
            .setSatisfiesPzs(true)
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";

    WorkerPool actualResponse = client.deleteWorkerPoolAsync(name).get();
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
  public void deleteWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
