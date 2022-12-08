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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListDeploymentResourcePoolsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.QueryDeployedModelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import com.google.protobuf.Empty;
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
public class DeploymentResourcePoolServiceClientTest {
  private static MockDeploymentResourcePoolService mockDeploymentResourcePoolService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeploymentResourcePoolServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeploymentResourcePoolService = new MockDeploymentResourcePoolService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockDeploymentResourcePoolService, mockLocations, mockIAMPolicy));
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
    DeploymentResourcePoolServiceSettings settings =
        DeploymentResourcePoolServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeploymentResourcePoolServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDeploymentResourcePoolTest() throws Exception {
    DeploymentResourcePool expectedResponse =
        DeploymentResourcePool.newBuilder()
            .setName(
                DeploymentResourcePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
                    .toString())
            .setDedicatedResources(DedicatedResources.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeploymentResourcePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeploymentResourcePoolService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
    String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";

    DeploymentResourcePool actualResponse =
        client
            .createDeploymentResourcePoolAsync(
                parent, deploymentResourcePool, deploymentResourcePoolId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentResourcePoolRequest actualRequest =
        ((CreateDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deploymentResourcePool, actualRequest.getDeploymentResourcePool());
    Assert.assertEquals(deploymentResourcePoolId, actualRequest.getDeploymentResourcePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentResourcePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
      String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";
      client
          .createDeploymentResourcePoolAsync(
              parent, deploymentResourcePool, deploymentResourcePoolId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDeploymentResourcePoolTest2() throws Exception {
    DeploymentResourcePool expectedResponse =
        DeploymentResourcePool.newBuilder()
            .setName(
                DeploymentResourcePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
                    .toString())
            .setDedicatedResources(DedicatedResources.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeploymentResourcePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeploymentResourcePoolService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
    String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";

    DeploymentResourcePool actualResponse =
        client
            .createDeploymentResourcePoolAsync(
                parent, deploymentResourcePool, deploymentResourcePoolId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentResourcePoolRequest actualRequest =
        ((CreateDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deploymentResourcePool, actualRequest.getDeploymentResourcePool());
    Assert.assertEquals(deploymentResourcePoolId, actualRequest.getDeploymentResourcePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentResourcePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      String parent = "parent-995424086";
      DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
      String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";
      client
          .createDeploymentResourcePoolAsync(
              parent, deploymentResourcePool, deploymentResourcePoolId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDeploymentResourcePoolTest() throws Exception {
    DeploymentResourcePool expectedResponse =
        DeploymentResourcePool.newBuilder()
            .setName(
                DeploymentResourcePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
                    .toString())
            .setDedicatedResources(DedicatedResources.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDeploymentResourcePoolService.addResponse(expectedResponse);

    DeploymentResourcePoolName name =
        DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");

    DeploymentResourcePool actualResponse = client.getDeploymentResourcePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentResourcePoolRequest actualRequest =
        ((GetDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentResourcePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      DeploymentResourcePoolName name =
          DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");
      client.getDeploymentResourcePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentResourcePoolTest2() throws Exception {
    DeploymentResourcePool expectedResponse =
        DeploymentResourcePool.newBuilder()
            .setName(
                DeploymentResourcePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
                    .toString())
            .setDedicatedResources(DedicatedResources.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDeploymentResourcePoolService.addResponse(expectedResponse);

    String name = "name3373707";

    DeploymentResourcePool actualResponse = client.getDeploymentResourcePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentResourcePoolRequest actualRequest =
        ((GetDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentResourcePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      String name = "name3373707";
      client.getDeploymentResourcePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentResourcePoolsTest() throws Exception {
    DeploymentResourcePool responsesElement = DeploymentResourcePool.newBuilder().build();
    ListDeploymentResourcePoolsResponse expectedResponse =
        ListDeploymentResourcePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeploymentResourcePools(Arrays.asList(responsesElement))
            .build();
    mockDeploymentResourcePoolService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDeploymentResourcePoolsPagedResponse pagedListResponse =
        client.listDeploymentResourcePools(parent);

    List<DeploymentResourcePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentResourcePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentResourcePoolsRequest actualRequest =
        ((ListDeploymentResourcePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentResourcePoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDeploymentResourcePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentResourcePoolsTest2() throws Exception {
    DeploymentResourcePool responsesElement = DeploymentResourcePool.newBuilder().build();
    ListDeploymentResourcePoolsResponse expectedResponse =
        ListDeploymentResourcePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeploymentResourcePools(Arrays.asList(responsesElement))
            .build();
    mockDeploymentResourcePoolService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeploymentResourcePoolsPagedResponse pagedListResponse =
        client.listDeploymentResourcePools(parent);

    List<DeploymentResourcePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentResourcePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentResourcePoolsRequest actualRequest =
        ((ListDeploymentResourcePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentResourcePoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeploymentResourcePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentResourcePoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeploymentResourcePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeploymentResourcePoolService.addResponse(resultOperation);

    DeploymentResourcePoolName name =
        DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");

    client.deleteDeploymentResourcePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentResourcePoolRequest actualRequest =
        ((DeleteDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentResourcePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      DeploymentResourcePoolName name =
          DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");
      client.deleteDeploymentResourcePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDeploymentResourcePoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeploymentResourcePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeploymentResourcePoolService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDeploymentResourcePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentResourcePoolRequest actualRequest =
        ((DeleteDeploymentResourcePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentResourcePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDeploymentResourcePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void queryDeployedModelsTest() throws Exception {
    DeployedModel responsesElement = DeployedModel.newBuilder().build();
    QueryDeployedModelsResponse expectedResponse =
        QueryDeployedModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployedModels(Arrays.asList(responsesElement))
            .build();
    mockDeploymentResourcePoolService.addResponse(expectedResponse);

    String deploymentResourcePool = "deploymentResourcePool-1928845137";

    QueryDeployedModelsPagedResponse pagedListResponse =
        client.queryDeployedModels(deploymentResourcePool);

    List<DeployedModel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeployedModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeploymentResourcePoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryDeployedModelsRequest actualRequest = ((QueryDeployedModelsRequest) actualRequests.get(0));

    Assert.assertEquals(deploymentResourcePool, actualRequest.getDeploymentResourcePool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryDeployedModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeploymentResourcePoolService.addException(exception);

    try {
      String deploymentResourcePool = "deploymentResourcePool-1928845137";
      client.queryDeployedModels(deploymentResourcePool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
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
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
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
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
