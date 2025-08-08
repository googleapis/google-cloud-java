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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class WorkerPoolsClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockWorkerPools mockWorkerPools;
  private LocalChannelProvider channelProvider;
  private WorkerPoolsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkerPools = new MockWorkerPools();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWorkerPools, mockLocations));
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
    WorkerPoolsSettings settings =
        WorkerPoolsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkerPoolsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockWorkerPools.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = ((CreateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(workerPoolId, actualRequest.getWorkerPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = ((CreateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(workerPoolId, actualRequest.getWorkerPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(expectedResponse);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.getWorkerPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = ((GetWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

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
    mockWorkerPools.addResponse(expectedResponse);

    String name = "name3373707";

    WorkerPool actualResponse = client.getWorkerPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = ((GetWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkerPools.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = ((ListWorkerPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkerPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

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
    mockWorkerPools.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = ((ListWorkerPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkerPoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkerPools.addResponse(resultOperation);

    WorkerPool workerPool = WorkerPool.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkerPoolRequest actualRequest = ((UpdateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      client.updateWorkerPoolAsync(workerPool).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(resultOperation);

    WorkerPool workerPool = WorkerPool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkerPoolRequest actualRequest = ((UpdateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkerPoolAsync(workerPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(resultOperation);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.deleteWorkerPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = ((DeleteWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(resultOperation);

    String name = "name3373707";

    WorkerPool actualResponse = client.deleteWorkerPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = ((DeleteWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkerPools.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

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
    mockWorkerPools.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

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
    mockWorkerPools.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkerPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkerPools.addException(exception);

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
