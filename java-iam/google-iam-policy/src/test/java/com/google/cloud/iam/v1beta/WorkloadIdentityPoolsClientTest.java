/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta;

import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolProvidersPagedResponse;
import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.ProjectName;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolName;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderName;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class WorkloadIdentityPoolsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockWorkloadIdentityPools mockWorkloadIdentityPools;
  private LocalChannelProvider channelProvider;
  private WorkloadIdentityPoolsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkloadIdentityPools = new MockWorkloadIdentityPools();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWorkloadIdentityPools));
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
    WorkloadIdentityPoolsSettings settings =
        WorkloadIdentityPoolsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkloadIdentityPoolsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listWorkloadIdentityPoolsTest() throws Exception {
    WorkloadIdentityPool responsesElement = WorkloadIdentityPool.newBuilder().build();
    ListWorkloadIdentityPoolsResponse expectedResponse =
        ListWorkloadIdentityPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIdentityPools(Arrays.asList(responsesElement))
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListWorkloadIdentityPoolsPagedResponse pagedListResponse =
        client.listWorkloadIdentityPools(parent);

    List<WorkloadIdentityPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdentityPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadIdentityPoolsRequest actualRequest =
        ((ListWorkloadIdentityPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadIdentityPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listWorkloadIdentityPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadIdentityPoolsTest2() throws Exception {
    WorkloadIdentityPool responsesElement = WorkloadIdentityPool.newBuilder().build();
    ListWorkloadIdentityPoolsResponse expectedResponse =
        ListWorkloadIdentityPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIdentityPools(Arrays.asList(responsesElement))
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadIdentityPoolsPagedResponse pagedListResponse =
        client.listWorkloadIdentityPools(parent);

    List<WorkloadIdentityPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdentityPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadIdentityPoolsRequest actualRequest =
        ((ListWorkloadIdentityPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadIdentityPoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloadIdentityPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadIdentityPoolTest() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    WorkloadIdentityPoolName name =
        WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");

    WorkloadIdentityPool actualResponse = client.getWorkloadIdentityPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadIdentityPoolRequest actualRequest =
        ((GetWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadIdentityPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolName name =
          WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
      client.getWorkloadIdentityPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadIdentityPoolTest2() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    String name = "name3373707";

    WorkloadIdentityPool actualResponse = client.getWorkloadIdentityPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadIdentityPoolRequest actualRequest =
        ((GetWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadIdentityPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkloadIdentityPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkloadIdentityPoolTest() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
    String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";

    WorkloadIdentityPool actualResponse =
        client
            .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadIdentityPoolRequest actualRequest =
        ((CreateWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workloadIdentityPool, actualRequest.getWorkloadIdentityPool());
    Assert.assertEquals(workloadIdentityPoolId, actualRequest.getWorkloadIdentityPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadIdentityPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
      String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";
      client
          .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createWorkloadIdentityPoolTest2() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
    String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";

    WorkloadIdentityPool actualResponse =
        client
            .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadIdentityPoolRequest actualRequest =
        ((CreateWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workloadIdentityPool, actualRequest.getWorkloadIdentityPool());
    Assert.assertEquals(workloadIdentityPoolId, actualRequest.getWorkloadIdentityPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadIdentityPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
      String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";
      client
          .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateWorkloadIdentityPoolTest() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkloadIdentityPool actualResponse =
        client.updateWorkloadIdentityPoolAsync(workloadIdentityPool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkloadIdentityPoolRequest actualRequest =
        ((UpdateWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(workloadIdentityPool, actualRequest.getWorkloadIdentityPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkloadIdentityPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkloadIdentityPoolAsync(workloadIdentityPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadIdentityPoolTest() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolName name =
        WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");

    WorkloadIdentityPool actualResponse = client.deleteWorkloadIdentityPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadIdentityPoolRequest actualRequest =
        ((DeleteWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadIdentityPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolName name =
          WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
      client.deleteWorkloadIdentityPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadIdentityPoolTest2() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String name = "name3373707";

    WorkloadIdentityPool actualResponse = client.deleteWorkloadIdentityPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadIdentityPoolRequest actualRequest =
        ((DeleteWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadIdentityPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkloadIdentityPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteWorkloadIdentityPoolTest() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolName name =
        WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");

    WorkloadIdentityPool actualResponse = client.undeleteWorkloadIdentityPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteWorkloadIdentityPoolRequest actualRequest =
        ((UndeleteWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteWorkloadIdentityPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolName name =
          WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
      client.undeleteWorkloadIdentityPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteWorkloadIdentityPoolTest2() throws Exception {
    WorkloadIdentityPool expectedResponse =
        WorkloadIdentityPool.newBuilder()
            .setName(
                WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteWorkloadIdentityPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String name = "name3373707";

    WorkloadIdentityPool actualResponse = client.undeleteWorkloadIdentityPoolAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteWorkloadIdentityPoolRequest actualRequest =
        ((UndeleteWorkloadIdentityPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteWorkloadIdentityPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.undeleteWorkloadIdentityPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listWorkloadIdentityPoolProvidersTest() throws Exception {
    WorkloadIdentityPoolProvider responsesElement =
        WorkloadIdentityPoolProvider.newBuilder().build();
    ListWorkloadIdentityPoolProvidersResponse expectedResponse =
        ListWorkloadIdentityPoolProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIdentityPoolProviders(Arrays.asList(responsesElement))
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    WorkloadIdentityPoolName parent =
        WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");

    ListWorkloadIdentityPoolProvidersPagedResponse pagedListResponse =
        client.listWorkloadIdentityPoolProviders(parent);

    List<WorkloadIdentityPoolProvider> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getWorkloadIdentityPoolProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadIdentityPoolProvidersRequest actualRequest =
        ((ListWorkloadIdentityPoolProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadIdentityPoolProvidersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolName parent =
          WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
      client.listWorkloadIdentityPoolProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadIdentityPoolProvidersTest2() throws Exception {
    WorkloadIdentityPoolProvider responsesElement =
        WorkloadIdentityPoolProvider.newBuilder().build();
    ListWorkloadIdentityPoolProvidersResponse expectedResponse =
        ListWorkloadIdentityPoolProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIdentityPoolProviders(Arrays.asList(responsesElement))
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadIdentityPoolProvidersPagedResponse pagedListResponse =
        client.listWorkloadIdentityPoolProviders(parent);

    List<WorkloadIdentityPoolProvider> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getWorkloadIdentityPoolProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadIdentityPoolProvidersRequest actualRequest =
        ((ListWorkloadIdentityPoolProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadIdentityPoolProvidersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloadIdentityPoolProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadIdentityPoolProviderTest() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    WorkloadIdentityPoolProviderName name =
        WorkloadIdentityPoolProviderName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKLOAD_IDENTITY_POOL]",
            "[WORKLOAD_IDENTITY_POOL_PROVIDER]");

    WorkloadIdentityPoolProvider actualResponse = client.getWorkloadIdentityPoolProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadIdentityPoolProviderRequest actualRequest =
        ((GetWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadIdentityPoolProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolProviderName name =
          WorkloadIdentityPoolProviderName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKLOAD_IDENTITY_POOL]",
              "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
      client.getWorkloadIdentityPoolProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadIdentityPoolProviderTest2() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    mockWorkloadIdentityPools.addResponse(expectedResponse);

    String name = "name3373707";

    WorkloadIdentityPoolProvider actualResponse = client.getWorkloadIdentityPoolProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadIdentityPoolProviderRequest actualRequest =
        ((GetWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadIdentityPoolProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkloadIdentityPoolProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkloadIdentityPoolProviderTest() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolName parent =
        WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
    WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
        WorkloadIdentityPoolProvider.newBuilder().build();
    String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";

    WorkloadIdentityPoolProvider actualResponse =
        client
            .createWorkloadIdentityPoolProviderAsync(
                parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadIdentityPoolProviderRequest actualRequest =
        ((CreateWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        workloadIdentityPoolProvider, actualRequest.getWorkloadIdentityPoolProvider());
    Assert.assertEquals(
        workloadIdentityPoolProviderId, actualRequest.getWorkloadIdentityPoolProviderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadIdentityPoolProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolName parent =
          WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
      WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
          WorkloadIdentityPoolProvider.newBuilder().build();
      String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";
      client
          .createWorkloadIdentityPoolProviderAsync(
              parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createWorkloadIdentityPoolProviderTest2() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
        WorkloadIdentityPoolProvider.newBuilder().build();
    String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";

    WorkloadIdentityPoolProvider actualResponse =
        client
            .createWorkloadIdentityPoolProviderAsync(
                parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadIdentityPoolProviderRequest actualRequest =
        ((CreateWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        workloadIdentityPoolProvider, actualRequest.getWorkloadIdentityPoolProvider());
    Assert.assertEquals(
        workloadIdentityPoolProviderId, actualRequest.getWorkloadIdentityPoolProviderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadIdentityPoolProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
          WorkloadIdentityPoolProvider.newBuilder().build();
      String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";
      client
          .createWorkloadIdentityPoolProviderAsync(
              parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateWorkloadIdentityPoolProviderTest() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
        WorkloadIdentityPoolProvider.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkloadIdentityPoolProvider actualResponse =
        client
            .updateWorkloadIdentityPoolProviderAsync(workloadIdentityPoolProvider, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkloadIdentityPoolProviderRequest actualRequest =
        ((UpdateWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(
        workloadIdentityPoolProvider, actualRequest.getWorkloadIdentityPoolProvider());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkloadIdentityPoolProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
          WorkloadIdentityPoolProvider.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updateWorkloadIdentityPoolProviderAsync(workloadIdentityPoolProvider, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadIdentityPoolProviderTest() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolProviderName name =
        WorkloadIdentityPoolProviderName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKLOAD_IDENTITY_POOL]",
            "[WORKLOAD_IDENTITY_POOL_PROVIDER]");

    WorkloadIdentityPoolProvider actualResponse =
        client.deleteWorkloadIdentityPoolProviderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadIdentityPoolProviderRequest actualRequest =
        ((DeleteWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadIdentityPoolProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolProviderName name =
          WorkloadIdentityPoolProviderName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKLOAD_IDENTITY_POOL]",
              "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
      client.deleteWorkloadIdentityPoolProviderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadIdentityPoolProviderTest2() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String name = "name3373707";

    WorkloadIdentityPoolProvider actualResponse =
        client.deleteWorkloadIdentityPoolProviderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadIdentityPoolProviderRequest actualRequest =
        ((DeleteWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadIdentityPoolProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkloadIdentityPoolProviderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteWorkloadIdentityPoolProviderTest() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    WorkloadIdentityPoolProviderName name =
        WorkloadIdentityPoolProviderName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKLOAD_IDENTITY_POOL]",
            "[WORKLOAD_IDENTITY_POOL_PROVIDER]");

    WorkloadIdentityPoolProvider actualResponse =
        client.undeleteWorkloadIdentityPoolProviderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteWorkloadIdentityPoolProviderRequest actualRequest =
        ((UndeleteWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteWorkloadIdentityPoolProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      WorkloadIdentityPoolProviderName name =
          WorkloadIdentityPoolProviderName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKLOAD_IDENTITY_POOL]",
              "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
      client.undeleteWorkloadIdentityPoolProviderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteWorkloadIdentityPoolProviderTest2() throws Exception {
    WorkloadIdentityPoolProvider expectedResponse =
        WorkloadIdentityPoolProvider.newBuilder()
            .setName(
                WorkloadIdentityPoolProviderName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKLOAD_IDENTITY_POOL]",
                        "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .putAllAttributeMapping(new HashMap<String, String>())
            .setAttributeCondition("attributeCondition-720104993")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteWorkloadIdentityPoolProviderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkloadIdentityPools.addResponse(resultOperation);

    String name = "name3373707";

    WorkloadIdentityPoolProvider actualResponse =
        client.undeleteWorkloadIdentityPoolProviderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadIdentityPools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteWorkloadIdentityPoolProviderRequest actualRequest =
        ((UndeleteWorkloadIdentityPoolProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteWorkloadIdentityPoolProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadIdentityPools.addException(exception);

    try {
      String name = "name3373707";
      client.undeleteWorkloadIdentityPoolProviderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
