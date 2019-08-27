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
package com.google.cloud.gaming.v1alpha;

import static com.google.cloud.gaming.v1alpha.AllocationPoliciesServiceClient.ListAllocationPoliciesPagedResponse;

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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AllocationPoliciesServiceClientTest {
  private static MockAllocationPoliciesService mockAllocationPoliciesService;
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockScalingPoliciesService mockScalingPoliciesService;
  private static MockServiceHelper serviceHelper;
  private AllocationPoliciesServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAllocationPoliciesService = new MockAllocationPoliciesService();
    mockGameServerClustersService = new MockGameServerClustersService();
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockRealmsService = new MockRealmsService();
    mockScalingPoliciesService = new MockScalingPoliciesService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAllocationPoliciesService,
                mockGameServerClustersService,
                mockGameServerDeploymentsService,
                mockRealmsService,
                mockScalingPoliciesService));
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
    AllocationPoliciesServiceSettings settings =
        AllocationPoliciesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AllocationPoliciesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listAllocationPoliciesTest() {
    String nextPageToken = "";
    AllocationPolicy allocationPoliciesElement = AllocationPolicy.newBuilder().build();
    List<AllocationPolicy> allocationPolicies = Arrays.asList(allocationPoliciesElement);
    ListAllocationPoliciesResponse expectedResponse =
        ListAllocationPoliciesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAllocationPolicies(allocationPolicies)
            .build();
    mockAllocationPoliciesService.addResponse(expectedResponse);

    String formattedParent =
        AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListAllocationPoliciesPagedResponse pagedListResponse =
        client.listAllocationPolicies(formattedParent);

    List<AllocationPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAllocationPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAllocationPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAllocationPoliciesRequest actualRequest =
        (ListAllocationPoliciesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAllocationPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAllocationPoliciesService.addException(exception);

    try {
      String formattedParent =
          AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listAllocationPolicies(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAllocationPolicyTest() {
    String name2 = "name2-1052831874";
    int weight = 791592328;
    AllocationPolicy expectedResponse =
        AllocationPolicy.newBuilder().setName(name2).setWeight(weight).build();
    mockAllocationPoliciesService.addResponse(expectedResponse);

    String formattedName =
        AllocationPoliciesServiceClient.formatAllocationPolicyName(
            "[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");

    AllocationPolicy actualResponse = client.getAllocationPolicy(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAllocationPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAllocationPolicyRequest actualRequest = (GetAllocationPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAllocationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAllocationPoliciesService.addException(exception);

    try {
      String formattedName =
          AllocationPoliciesServiceClient.formatAllocationPolicyName(
              "[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");

      client.getAllocationPolicy(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAllocationPolicyTest() throws Exception {
    String name = "name3373707";
    int weight = 791592328;
    AllocationPolicy expectedResponse =
        AllocationPolicy.newBuilder().setName(name).setWeight(weight).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAllocationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAllocationPoliciesService.addResponse(resultOperation);

    String formattedParent =
        AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
    String allocationPolicyId = "allocationPolicyId-850912599";
    AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();

    AllocationPolicy actualResponse =
        client
            .createAllocationPolicyAsync(formattedParent, allocationPolicyId, allocationPolicy)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAllocationPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAllocationPolicyRequest actualRequest =
        (CreateAllocationPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(allocationPolicyId, actualRequest.getAllocationPolicyId());
    Assert.assertEquals(allocationPolicy, actualRequest.getAllocationPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAllocationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAllocationPoliciesService.addException(exception);

    try {
      String formattedParent =
          AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
      String allocationPolicyId = "allocationPolicyId-850912599";
      AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();

      client
          .createAllocationPolicyAsync(formattedParent, allocationPolicyId, allocationPolicy)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAllocationPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAllocationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAllocationPoliciesService.addResponse(resultOperation);

    String formattedName =
        AllocationPoliciesServiceClient.formatAllocationPolicyName(
            "[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");

    Empty actualResponse = client.deleteAllocationPolicyAsync(formattedName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAllocationPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAllocationPolicyRequest actualRequest =
        (DeleteAllocationPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAllocationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAllocationPoliciesService.addException(exception);

    try {
      String formattedName =
          AllocationPoliciesServiceClient.formatAllocationPolicyName(
              "[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");

      client.deleteAllocationPolicyAsync(formattedName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAllocationPolicyTest() throws Exception {
    String name = "name3373707";
    int weight = 791592328;
    AllocationPolicy expectedResponse =
        AllocationPolicy.newBuilder().setName(name).setWeight(weight).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAllocationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAllocationPoliciesService.addResponse(resultOperation);

    AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AllocationPolicy actualResponse =
        client.updateAllocationPolicyAsync(allocationPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAllocationPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAllocationPolicyRequest actualRequest =
        (UpdateAllocationPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(allocationPolicy, actualRequest.getAllocationPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAllocationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAllocationPoliciesService.addException(exception);

    try {
      AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateAllocationPolicyAsync(allocationPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
