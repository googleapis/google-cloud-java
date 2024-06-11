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

package com.google.cloud.networkservices.v1;

import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewaysPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGrpcRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListHttpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListLocationsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceBindingsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTcpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTlsRoutesPagedResponse;

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
public class NetworkServicesClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockNetworkServices mockNetworkServices;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NetworkServicesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNetworkServices = new MockNetworkServices();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNetworkServices, mockLocations, mockIAMPolicy));
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
    NetworkServicesSettings settings =
        NetworkServicesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NetworkServicesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEndpointPoliciesTest() throws Exception {
    EndpointPolicy responsesElement = EndpointPolicy.newBuilder().build();
    ListEndpointPoliciesResponse expectedResponse =
        ListEndpointPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpointPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointPoliciesPagedResponse pagedListResponse = client.listEndpointPolicies(parent);

    List<EndpointPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointPoliciesRequest actualRequest =
        ((ListEndpointPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEndpointPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointPoliciesTest2() throws Exception {
    EndpointPolicy responsesElement = EndpointPolicy.newBuilder().build();
    ListEndpointPoliciesResponse expectedResponse =
        ListEndpointPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpointPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEndpointPoliciesPagedResponse pagedListResponse = client.listEndpointPolicies(parent);

    List<EndpointPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointPoliciesRequest actualRequest =
        ((ListEndpointPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEndpointPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    EndpointPolicyName name = EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");

    EndpointPolicy actualResponse = client.getEndpointPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointPolicyRequest actualRequest = ((GetEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      EndpointPolicyName name =
          EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
      client.getEndpointPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointPolicyTest2() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    EndpointPolicy actualResponse = client.getEndpointPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointPolicyRequest actualRequest = ((GetEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getEndpointPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
    String endpointPolicyId = "endpointPolicyId-509458782";

    EndpointPolicy actualResponse =
        client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointPolicyRequest actualRequest =
        ((CreateEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(endpointPolicy, actualRequest.getEndpointPolicy());
    Assert.assertEquals(endpointPolicyId, actualRequest.getEndpointPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
      String endpointPolicyId = "endpointPolicyId-509458782";
      client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEndpointPolicyTest2() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
    String endpointPolicyId = "endpointPolicyId-509458782";

    EndpointPolicy actualResponse =
        client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointPolicyRequest actualRequest =
        ((CreateEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(endpointPolicy, actualRequest.getEndpointPolicy());
    Assert.assertEquals(endpointPolicyId, actualRequest.getEndpointPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
      String endpointPolicyId = "endpointPolicyId-509458782";
      client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EndpointPolicy actualResponse =
        client.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEndpointPolicyRequest actualRequest =
        ((UpdateEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(endpointPolicy, actualRequest.getEndpointPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEndpointPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEndpointPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    EndpointPolicyName name = EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");

    client.deleteEndpointPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointPolicyRequest actualRequest =
        ((DeleteEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      EndpointPolicyName name =
          EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
      client.deleteEndpointPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEndpointPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEndpointPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointPolicyRequest actualRequest =
        ((DeleteEndpointPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEndpointPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGatewaysTest() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaysRequest actualRequest = ((ListGatewaysRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGatewaysTest2() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaysRequest actualRequest = ((ListGatewaysRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    Gateway actualResponse = client.getGateway(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewayRequest actualRequest = ((GetGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    Gateway actualResponse = client.getGateway(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewayRequest actualRequest = ((GetGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewayRequest actualRequest = ((CreateGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gateway, actualRequest.getGateway());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewayRequest actualRequest = ((CreateGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gateway, actualRequest.getGateway());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    Gateway gateway = Gateway.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Gateway actualResponse = client.updateGatewayAsync(gateway, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGatewayRequest actualRequest = ((UpdateGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(gateway, actualRequest.getGateway());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      Gateway gateway = Gateway.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGatewayAsync(gateway, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewayTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    client.deleteGatewayAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewayRequest actualRequest = ((DeleteGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewayTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGatewayAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewayRequest actualRequest = ((DeleteGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGrpcRoutesTest() throws Exception {
    GrpcRoute responsesElement = GrpcRoute.newBuilder().build();
    ListGrpcRoutesResponse expectedResponse =
        ListGrpcRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrpcRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGrpcRoutesPagedResponse pagedListResponse = client.listGrpcRoutes(parent);

    List<GrpcRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrpcRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGrpcRoutesRequest actualRequest = ((ListGrpcRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGrpcRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGrpcRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGrpcRoutesTest2() throws Exception {
    GrpcRoute responsesElement = GrpcRoute.newBuilder().build();
    ListGrpcRoutesResponse expectedResponse =
        ListGrpcRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrpcRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGrpcRoutesPagedResponse pagedListResponse = client.listGrpcRoutes(parent);

    List<GrpcRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrpcRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGrpcRoutesRequest actualRequest = ((ListGrpcRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGrpcRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGrpcRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");

    GrpcRoute actualResponse = client.getGrpcRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGrpcRouteRequest actualRequest = ((GetGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGrpcRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
      client.getGrpcRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrpcRouteTest2() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    GrpcRoute actualResponse = client.getGrpcRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGrpcRouteRequest actualRequest = ((GetGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGrpcRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getGrpcRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
    String grpcRouteId = "grpcRouteId1888295750";

    GrpcRoute actualResponse = client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGrpcRouteRequest actualRequest = ((CreateGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(grpcRoute, actualRequest.getGrpcRoute());
    Assert.assertEquals(grpcRouteId, actualRequest.getGrpcRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGrpcRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      String grpcRouteId = "grpcRouteId1888295750";
      client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGrpcRouteTest2() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
    String grpcRouteId = "grpcRouteId1888295750";

    GrpcRoute actualResponse = client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGrpcRouteRequest actualRequest = ((CreateGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(grpcRoute, actualRequest.getGrpcRoute());
    Assert.assertEquals(grpcRouteId, actualRequest.getGrpcRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGrpcRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      String grpcRouteId = "grpcRouteId1888295750";
      client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GrpcRoute actualResponse = client.updateGrpcRouteAsync(grpcRoute, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGrpcRouteRequest actualRequest = ((UpdateGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(grpcRoute, actualRequest.getGrpcRoute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGrpcRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGrpcRouteAsync(grpcRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGrpcRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");

    client.deleteGrpcRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGrpcRouteRequest actualRequest = ((DeleteGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGrpcRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
      client.deleteGrpcRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGrpcRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGrpcRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGrpcRouteRequest actualRequest = ((DeleteGrpcRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGrpcRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGrpcRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHttpRoutesTest() throws Exception {
    HttpRoute responsesElement = HttpRoute.newBuilder().build();
    ListHttpRoutesResponse expectedResponse =
        ListHttpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllHttpRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHttpRoutesPagedResponse pagedListResponse = client.listHttpRoutes(parent);

    List<HttpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHttpRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHttpRoutesRequest actualRequest = ((ListHttpRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHttpRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHttpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHttpRoutesTest2() throws Exception {
    HttpRoute responsesElement = HttpRoute.newBuilder().build();
    ListHttpRoutesResponse expectedResponse =
        ListHttpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllHttpRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHttpRoutesPagedResponse pagedListResponse = client.listHttpRoutes(parent);

    List<HttpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHttpRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHttpRoutesRequest actualRequest = ((ListHttpRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHttpRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHttpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");

    HttpRoute actualResponse = client.getHttpRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHttpRouteRequest actualRequest = ((GetHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHttpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
      client.getHttpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHttpRouteTest2() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    HttpRoute actualResponse = client.getHttpRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHttpRouteRequest actualRequest = ((GetHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHttpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getHttpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    HttpRoute httpRoute = HttpRoute.newBuilder().build();
    String httpRouteId = "httpRouteId-2054835300";

    HttpRoute actualResponse = client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHttpRouteRequest actualRequest = ((CreateHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(httpRoute, actualRequest.getHttpRoute());
    Assert.assertEquals(httpRouteId, actualRequest.getHttpRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHttpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      HttpRoute httpRoute = HttpRoute.newBuilder().build();
      String httpRouteId = "httpRouteId-2054835300";
      client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHttpRouteTest2() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    HttpRoute httpRoute = HttpRoute.newBuilder().build();
    String httpRouteId = "httpRouteId-2054835300";

    HttpRoute actualResponse = client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHttpRouteRequest actualRequest = ((CreateHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(httpRoute, actualRequest.getHttpRoute());
    Assert.assertEquals(httpRouteId, actualRequest.getHttpRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHttpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      HttpRoute httpRoute = HttpRoute.newBuilder().build();
      String httpRouteId = "httpRouteId-2054835300";
      client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    HttpRoute httpRoute = HttpRoute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HttpRoute actualResponse = client.updateHttpRouteAsync(httpRoute, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHttpRouteRequest actualRequest = ((UpdateHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(httpRoute, actualRequest.getHttpRoute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHttpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      HttpRoute httpRoute = HttpRoute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHttpRouteAsync(httpRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHttpRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");

    client.deleteHttpRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHttpRouteRequest actualRequest = ((DeleteHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHttpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
      client.deleteHttpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHttpRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHttpRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHttpRouteRequest actualRequest = ((DeleteHttpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHttpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHttpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTcpRoutesTest() throws Exception {
    TcpRoute responsesElement = TcpRoute.newBuilder().build();
    ListTcpRoutesResponse expectedResponse =
        ListTcpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTcpRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTcpRoutesPagedResponse pagedListResponse = client.listTcpRoutes(parent);

    List<TcpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTcpRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTcpRoutesRequest actualRequest = ((ListTcpRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTcpRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTcpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTcpRoutesTest2() throws Exception {
    TcpRoute responsesElement = TcpRoute.newBuilder().build();
    ListTcpRoutesResponse expectedResponse =
        ListTcpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTcpRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTcpRoutesPagedResponse pagedListResponse = client.listTcpRoutes(parent);

    List<TcpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTcpRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTcpRoutesRequest actualRequest = ((ListTcpRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTcpRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTcpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");

    TcpRoute actualResponse = client.getTcpRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTcpRouteRequest actualRequest = ((GetTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTcpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
      client.getTcpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTcpRouteTest2() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    TcpRoute actualResponse = client.getTcpRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTcpRouteRequest actualRequest = ((GetTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTcpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getTcpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TcpRoute tcpRoute = TcpRoute.newBuilder().build();
    String tcpRouteId = "tcpRouteId806467107";

    TcpRoute actualResponse = client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTcpRouteRequest actualRequest = ((CreateTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tcpRoute, actualRequest.getTcpRoute());
    Assert.assertEquals(tcpRouteId, actualRequest.getTcpRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTcpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TcpRoute tcpRoute = TcpRoute.newBuilder().build();
      String tcpRouteId = "tcpRouteId806467107";
      client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTcpRouteTest2() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    TcpRoute tcpRoute = TcpRoute.newBuilder().build();
    String tcpRouteId = "tcpRouteId806467107";

    TcpRoute actualResponse = client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTcpRouteRequest actualRequest = ((CreateTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tcpRoute, actualRequest.getTcpRoute());
    Assert.assertEquals(tcpRouteId, actualRequest.getTcpRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTcpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      TcpRoute tcpRoute = TcpRoute.newBuilder().build();
      String tcpRouteId = "tcpRouteId806467107";
      client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    TcpRoute tcpRoute = TcpRoute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TcpRoute actualResponse = client.updateTcpRouteAsync(tcpRoute, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTcpRouteRequest actualRequest = ((UpdateTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(tcpRoute, actualRequest.getTcpRoute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTcpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TcpRoute tcpRoute = TcpRoute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTcpRouteAsync(tcpRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTcpRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");

    client.deleteTcpRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTcpRouteRequest actualRequest = ((DeleteTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTcpRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
      client.deleteTcpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTcpRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTcpRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTcpRouteRequest actualRequest = ((DeleteTcpRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTcpRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTcpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTlsRoutesTest() throws Exception {
    TlsRoute responsesElement = TlsRoute.newBuilder().build();
    ListTlsRoutesResponse expectedResponse =
        ListTlsRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTlsRoutesPagedResponse pagedListResponse = client.listTlsRoutes(parent);

    List<TlsRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTlsRoutesRequest actualRequest = ((ListTlsRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTlsRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTlsRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTlsRoutesTest2() throws Exception {
    TlsRoute responsesElement = TlsRoute.newBuilder().build();
    ListTlsRoutesResponse expectedResponse =
        ListTlsRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsRoutes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTlsRoutesPagedResponse pagedListResponse = client.listTlsRoutes(parent);

    List<TlsRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTlsRoutesRequest actualRequest = ((ListTlsRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTlsRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTlsRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");

    TlsRoute actualResponse = client.getTlsRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTlsRouteRequest actualRequest = ((GetTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTlsRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
      client.getTlsRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsRouteTest2() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    TlsRoute actualResponse = client.getTlsRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTlsRouteRequest actualRequest = ((GetTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTlsRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getTlsRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TlsRoute tlsRoute = TlsRoute.newBuilder().build();
    String tlsRouteId = "tlsRouteId-1642257463";

    TlsRoute actualResponse = client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTlsRouteRequest actualRequest = ((CreateTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tlsRoute, actualRequest.getTlsRoute());
    Assert.assertEquals(tlsRouteId, actualRequest.getTlsRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTlsRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TlsRoute tlsRoute = TlsRoute.newBuilder().build();
      String tlsRouteId = "tlsRouteId-1642257463";
      client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTlsRouteTest2() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    TlsRoute tlsRoute = TlsRoute.newBuilder().build();
    String tlsRouteId = "tlsRouteId-1642257463";

    TlsRoute actualResponse = client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTlsRouteRequest actualRequest = ((CreateTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tlsRoute, actualRequest.getTlsRoute());
    Assert.assertEquals(tlsRouteId, actualRequest.getTlsRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTlsRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      TlsRoute tlsRoute = TlsRoute.newBuilder().build();
      String tlsRouteId = "tlsRouteId-1642257463";
      client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    TlsRoute tlsRoute = TlsRoute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TlsRoute actualResponse = client.updateTlsRouteAsync(tlsRoute, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTlsRouteRequest actualRequest = ((UpdateTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(tlsRoute, actualRequest.getTlsRoute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTlsRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TlsRoute tlsRoute = TlsRoute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTlsRouteAsync(tlsRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTlsRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");

    client.deleteTlsRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTlsRouteRequest actualRequest = ((DeleteTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTlsRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
      client.deleteTlsRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTlsRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTlsRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTlsRouteRequest actualRequest = ((DeleteTlsRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTlsRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTlsRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServiceBindingsTest() throws Exception {
    ServiceBinding responsesElement = ServiceBinding.newBuilder().build();
    ListServiceBindingsResponse expectedResponse =
        ListServiceBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceBindings(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceBindingsPagedResponse pagedListResponse = client.listServiceBindings(parent);

    List<ServiceBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceBindingsRequest actualRequest = ((ListServiceBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceBindingsTest2() throws Exception {
    ServiceBinding responsesElement = ServiceBinding.newBuilder().build();
    ListServiceBindingsResponse expectedResponse =
        ListServiceBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceBindings(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceBindingsPagedResponse pagedListResponse = client.listServiceBindings(parent);

    List<ServiceBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceBindingsRequest actualRequest = ((ListServiceBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceBindingTest() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    ServiceBindingName name = ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");

    ServiceBinding actualResponse = client.getServiceBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceBindingRequest actualRequest = ((GetServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      ServiceBindingName name =
          ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
      client.getServiceBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceBindingTest2() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceBinding actualResponse = client.getServiceBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceBindingRequest actualRequest = ((GetServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceBindingTest() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
    String serviceBindingId = "serviceBindingId-1424670901";

    ServiceBinding actualResponse =
        client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceBindingRequest actualRequest =
        ((CreateServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceBinding, actualRequest.getServiceBinding());
    Assert.assertEquals(serviceBindingId, actualRequest.getServiceBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
      String serviceBindingId = "serviceBindingId-1424670901";
      client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceBindingTest2() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
    String serviceBindingId = "serviceBindingId-1424670901";

    ServiceBinding actualResponse =
        client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceBindingRequest actualRequest =
        ((CreateServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceBinding, actualRequest.getServiceBinding());
    Assert.assertEquals(serviceBindingId, actualRequest.getServiceBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
      String serviceBindingId = "serviceBindingId-1424670901";
      client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    ServiceBindingName name = ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");

    client.deleteServiceBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceBindingRequest actualRequest =
        ((DeleteServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      ServiceBindingName name =
          ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
      client.deleteServiceBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceBindingRequest actualRequest =
        ((DeleteServiceBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMeshesTest() throws Exception {
    Mesh responsesElement = Mesh.newBuilder().build();
    ListMeshesResponse expectedResponse =
        ListMeshesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeshes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMeshesPagedResponse pagedListResponse = client.listMeshes(parent);

    List<Mesh> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMeshesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMeshesRequest actualRequest = ((ListMeshesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMeshesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMeshes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMeshesTest2() throws Exception {
    Mesh responsesElement = Mesh.newBuilder().build();
    ListMeshesResponse expectedResponse =
        ListMeshesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeshes(Arrays.asList(responsesElement))
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMeshesPagedResponse pagedListResponse = client.listMeshes(parent);

    List<Mesh> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMeshesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMeshesRequest actualRequest = ((ListMeshesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMeshesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMeshes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");

    Mesh actualResponse = client.getMesh(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMeshRequest actualRequest = ((GetMeshRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMeshExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
      client.getMesh(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeshTest2() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    mockNetworkServices.addResponse(expectedResponse);

    String name = "name3373707";

    Mesh actualResponse = client.getMesh(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMeshRequest actualRequest = ((GetMeshRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMeshExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.getMesh(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Mesh mesh = Mesh.newBuilder().build();
    String meshId = "meshId-1077585944";

    Mesh actualResponse = client.createMeshAsync(parent, mesh, meshId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMeshRequest actualRequest = ((CreateMeshRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mesh, actualRequest.getMesh());
    Assert.assertEquals(meshId, actualRequest.getMeshId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMeshExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Mesh mesh = Mesh.newBuilder().build();
      String meshId = "meshId-1077585944";
      client.createMeshAsync(parent, mesh, meshId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMeshTest2() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String parent = "parent-995424086";
    Mesh mesh = Mesh.newBuilder().build();
    String meshId = "meshId-1077585944";

    Mesh actualResponse = client.createMeshAsync(parent, mesh, meshId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMeshRequest actualRequest = ((CreateMeshRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mesh, actualRequest.getMesh());
    Assert.assertEquals(meshId, actualRequest.getMeshId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMeshExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String parent = "parent-995424086";
      Mesh mesh = Mesh.newBuilder().build();
      String meshId = "meshId-1077585944";
      client.createMeshAsync(parent, mesh, meshId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    Mesh mesh = Mesh.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Mesh actualResponse = client.updateMeshAsync(mesh, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMeshRequest actualRequest = ((UpdateMeshRequest) actualRequests.get(0));

    Assert.assertEquals(mesh, actualRequest.getMesh());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMeshExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      Mesh mesh = Mesh.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMeshAsync(mesh, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMeshTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");

    client.deleteMeshAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMeshRequest actualRequest = ((DeleteMeshRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMeshExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
      client.deleteMeshAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMeshTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkServices.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMeshAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkServices.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMeshRequest actualRequest = ((DeleteMeshRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMeshExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkServices.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMeshAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
              .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
            .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
              .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
            .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
              .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
