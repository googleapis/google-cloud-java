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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceClient.ListPolicyBasedRoutesPagedResponse;

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
public class PolicyBasedRoutingServiceClientTest {
  private static MockPolicyBasedRoutingService mockPolicyBasedRoutingService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PolicyBasedRoutingServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPolicyBasedRoutingService = new MockPolicyBasedRoutingService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPolicyBasedRoutingService));
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
    PolicyBasedRoutingServiceSettings settings =
        PolicyBasedRoutingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyBasedRoutingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listPolicyBasedRoutesTest() throws Exception {
    PolicyBasedRoute responsesElement = PolicyBasedRoute.newBuilder().build();
    ListPolicyBasedRoutesResponse expectedResponse =
        ListPolicyBasedRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBasedRoutes(Arrays.asList(responsesElement))
            .build();
    mockPolicyBasedRoutingService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPolicyBasedRoutesPagedResponse pagedListResponse = client.listPolicyBasedRoutes(parent);

    List<PolicyBasedRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBasedRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBasedRoutesRequest actualRequest =
        ((ListPolicyBasedRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBasedRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPolicyBasedRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyBasedRoutesTest2() throws Exception {
    PolicyBasedRoute responsesElement = PolicyBasedRoute.newBuilder().build();
    ListPolicyBasedRoutesResponse expectedResponse =
        ListPolicyBasedRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBasedRoutes(Arrays.asList(responsesElement))
            .build();
    mockPolicyBasedRoutingService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPolicyBasedRoutesPagedResponse pagedListResponse = client.listPolicyBasedRoutes(parent);

    List<PolicyBasedRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBasedRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBasedRoutesRequest actualRequest =
        ((ListPolicyBasedRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBasedRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPolicyBasedRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyBasedRouteTest() throws Exception {
    PolicyBasedRoute expectedResponse =
        PolicyBasedRoute.newBuilder()
            .setName(
                PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setFilter(PolicyBasedRoute.Filter.newBuilder().build())
            .setPriority(-1165461084)
            .addAllWarnings(new ArrayList<PolicyBasedRoute.Warnings>())
            .setSelfLink("selfLink1191800166")
            .setKind("kind3292052")
            .build();
    mockPolicyBasedRoutingService.addResponse(expectedResponse);

    PolicyBasedRouteName name =
        PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");

    PolicyBasedRoute actualResponse = client.getPolicyBasedRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyBasedRouteRequest actualRequest = ((GetPolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyBasedRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      PolicyBasedRouteName name =
          PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");
      client.getPolicyBasedRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyBasedRouteTest2() throws Exception {
    PolicyBasedRoute expectedResponse =
        PolicyBasedRoute.newBuilder()
            .setName(
                PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setFilter(PolicyBasedRoute.Filter.newBuilder().build())
            .setPriority(-1165461084)
            .addAllWarnings(new ArrayList<PolicyBasedRoute.Warnings>())
            .setSelfLink("selfLink1191800166")
            .setKind("kind3292052")
            .build();
    mockPolicyBasedRoutingService.addResponse(expectedResponse);

    String name = "name3373707";

    PolicyBasedRoute actualResponse = client.getPolicyBasedRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyBasedRouteRequest actualRequest = ((GetPolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyBasedRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicyBasedRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyBasedRouteTest() throws Exception {
    PolicyBasedRoute expectedResponse =
        PolicyBasedRoute.newBuilder()
            .setName(
                PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setFilter(PolicyBasedRoute.Filter.newBuilder().build())
            .setPriority(-1165461084)
            .addAllWarnings(new ArrayList<PolicyBasedRoute.Warnings>())
            .setSelfLink("selfLink1191800166")
            .setKind("kind3292052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBasedRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBasedRoutingService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
    String policyBasedRouteId = "policyBasedRouteId-18034589";

    PolicyBasedRoute actualResponse =
        client.createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBasedRouteRequest actualRequest =
        ((CreatePolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policyBasedRoute, actualRequest.getPolicyBasedRoute());
    Assert.assertEquals(policyBasedRouteId, actualRequest.getPolicyBasedRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBasedRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
      String policyBasedRouteId = "policyBasedRouteId-18034589";
      client.createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPolicyBasedRouteTest2() throws Exception {
    PolicyBasedRoute expectedResponse =
        PolicyBasedRoute.newBuilder()
            .setName(
                PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setFilter(PolicyBasedRoute.Filter.newBuilder().build())
            .setPriority(-1165461084)
            .addAllWarnings(new ArrayList<PolicyBasedRoute.Warnings>())
            .setSelfLink("selfLink1191800166")
            .setKind("kind3292052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBasedRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBasedRoutingService.addResponse(resultOperation);

    String parent = "parent-995424086";
    PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
    String policyBasedRouteId = "policyBasedRouteId-18034589";

    PolicyBasedRoute actualResponse =
        client.createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBasedRouteRequest actualRequest =
        ((CreatePolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policyBasedRoute, actualRequest.getPolicyBasedRoute());
    Assert.assertEquals(policyBasedRouteId, actualRequest.getPolicyBasedRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBasedRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      String parent = "parent-995424086";
      PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
      String policyBasedRouteId = "policyBasedRouteId-18034589";
      client.createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePolicyBasedRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyBasedRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBasedRoutingService.addResponse(resultOperation);

    PolicyBasedRouteName name =
        PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");

    client.deletePolicyBasedRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyBasedRouteRequest actualRequest =
        ((DeletePolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyBasedRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      PolicyBasedRouteName name =
          PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");
      client.deletePolicyBasedRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePolicyBasedRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyBasedRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBasedRoutingService.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePolicyBasedRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockPolicyBasedRoutingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyBasedRouteRequest actualRequest =
        ((DeletePolicyBasedRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyBasedRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBasedRoutingService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePolicyBasedRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
