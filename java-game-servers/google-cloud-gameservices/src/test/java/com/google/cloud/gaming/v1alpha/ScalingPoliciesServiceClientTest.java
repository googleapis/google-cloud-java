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

import static com.google.cloud.gaming.v1alpha.ScalingPoliciesServiceClient.ListScalingPoliciesPagedResponse;

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
public class ScalingPoliciesServiceClientTest {
  private static MockAllocationPoliciesService mockAllocationPoliciesService;
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockScalingPoliciesService mockScalingPoliciesService;
  private static MockServiceHelper serviceHelper;
  private ScalingPoliciesServiceClient client;
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
    ScalingPoliciesServiceSettings settings =
        ScalingPoliciesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ScalingPoliciesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listScalingPoliciesTest() {
    String nextPageToken = "";
    ScalingPolicy scalingPoliciesElement = ScalingPolicy.newBuilder().build();
    List<ScalingPolicy> scalingPolicies = Arrays.asList(scalingPoliciesElement);
    ListScalingPoliciesResponse expectedResponse =
        ListScalingPoliciesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllScalingPolicies(scalingPolicies)
            .build();
    mockScalingPoliciesService.addResponse(expectedResponse);

    String formattedParent =
        ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListScalingPoliciesPagedResponse pagedListResponse =
        client.listScalingPolicies(formattedParent);

    List<ScalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScalingPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockScalingPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScalingPoliciesRequest actualRequest = (ListScalingPoliciesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listScalingPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockScalingPoliciesService.addException(exception);

    try {
      String formattedParent =
          ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listScalingPolicies(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getScalingPolicyTest() {
    String name2 = "name2-1052831874";
    String gameServerDeployment = "gameServerDeployment840476212";
    ScalingPolicy expectedResponse =
        ScalingPolicy.newBuilder()
            .setName(name2)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    mockScalingPoliciesService.addResponse(expectedResponse);

    String formattedName =
        ScalingPoliciesServiceClient.formatScalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");

    ScalingPolicy actualResponse = client.getScalingPolicy(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockScalingPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScalingPolicyRequest actualRequest = (GetScalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getScalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockScalingPoliciesService.addException(exception);

    try {
      String formattedName =
          ScalingPoliciesServiceClient.formatScalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");

      client.getScalingPolicy(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createScalingPolicyTest() throws Exception {
    String name = "name3373707";
    String gameServerDeployment = "gameServerDeployment840476212";
    ScalingPolicy expectedResponse =
        ScalingPolicy.newBuilder()
            .setName(name)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScalingPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockScalingPoliciesService.addResponse(resultOperation);

    String formattedParent =
        ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
    String scalingPolicyId = "scalingPolicyId1901060240";
    ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();

    ScalingPolicy actualResponse =
        client.createScalingPolicyAsync(formattedParent, scalingPolicyId, scalingPolicy).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockScalingPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScalingPolicyRequest actualRequest = (CreateScalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(scalingPolicyId, actualRequest.getScalingPolicyId());
    Assert.assertEquals(scalingPolicy, actualRequest.getScalingPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createScalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockScalingPoliciesService.addException(exception);

    try {
      String formattedParent =
          ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
      String scalingPolicyId = "scalingPolicyId1901060240";
      ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();

      client.createScalingPolicyAsync(formattedParent, scalingPolicyId, scalingPolicy).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteScalingPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScalingPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockScalingPoliciesService.addResponse(resultOperation);

    String formattedName =
        ScalingPoliciesServiceClient.formatScalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");

    Empty actualResponse = client.deleteScalingPolicyAsync(formattedName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockScalingPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScalingPolicyRequest actualRequest = (DeleteScalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteScalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockScalingPoliciesService.addException(exception);

    try {
      String formattedName =
          ScalingPoliciesServiceClient.formatScalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");

      client.deleteScalingPolicyAsync(formattedName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateScalingPolicyTest() throws Exception {
    String name = "name3373707";
    String gameServerDeployment = "gameServerDeployment840476212";
    ScalingPolicy expectedResponse =
        ScalingPolicy.newBuilder()
            .setName(name)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateScalingPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockScalingPoliciesService.addResponse(resultOperation);

    ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ScalingPolicy actualResponse = client.updateScalingPolicyAsync(scalingPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockScalingPoliciesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScalingPolicyRequest actualRequest = (UpdateScalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(scalingPolicy, actualRequest.getScalingPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateScalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockScalingPoliciesService.addException(exception);

    try {
      ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateScalingPolicyAsync(scalingPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
