/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListLocationsPagedResponse;

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
public class FirewallActivationClientTest {
  private static MockFirewallActivation mockFirewallActivation;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FirewallActivationClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFirewallActivation = new MockFirewallActivation();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFirewallActivation, mockLocations, mockIAMPolicy));
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
    FirewallActivationSettings settings =
        FirewallActivationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirewallActivationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listFirewallEndpointsTest() throws Exception {
    FirewallEndpoint responsesElement = FirewallEndpoint.newBuilder().build();
    ListFirewallEndpointsResponse expectedResponse =
        ListFirewallEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallEndpoints(Arrays.asList(responsesElement))
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFirewallEndpointsPagedResponse pagedListResponse = client.listFirewallEndpoints(parent);

    List<FirewallEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirewallEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallEndpointsRequest actualRequest =
        ((ListFirewallEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFirewallEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirewallEndpointsTest2() throws Exception {
    FirewallEndpoint responsesElement = FirewallEndpoint.newBuilder().build();
    ListFirewallEndpointsResponse expectedResponse =
        ListFirewallEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallEndpoints(Arrays.asList(responsesElement))
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFirewallEndpointsPagedResponse pagedListResponse = client.listFirewallEndpoints(parent);

    List<FirewallEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirewallEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallEndpointsRequest actualRequest =
        ((ListFirewallEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallEndpointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFirewallEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirewallEndpointsTest3() throws Exception {
    FirewallEndpoint responsesElement = FirewallEndpoint.newBuilder().build();
    ListFirewallEndpointsResponse expectedResponse =
        ListFirewallEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallEndpoints(Arrays.asList(responsesElement))
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFirewallEndpointsPagedResponse pagedListResponse = client.listFirewallEndpoints(parent);

    List<FirewallEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirewallEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallEndpointsRequest actualRequest =
        ((ListFirewallEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallEndpointsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFirewallEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallEndpointTest() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    FirewallEndpointName name =
        FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
            "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");

    FirewallEndpoint actualResponse = client.getFirewallEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallEndpointRequest actualRequest = ((GetFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpointName name =
          FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
              "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
      client.getFirewallEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallEndpointTest2() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    String name = "name3373707";

    FirewallEndpoint actualResponse = client.getFirewallEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallEndpointRequest actualRequest = ((GetFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String name = "name3373707";
      client.getFirewallEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirewallEndpointTest() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
    String firewallEndpointId = "firewallEndpointId-993710416";

    FirewallEndpoint actualResponse =
        client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallEndpointRequest actualRequest =
        ((CreateFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(firewallEndpoint, actualRequest.getFirewallEndpoint());
    Assert.assertEquals(firewallEndpointId, actualRequest.getFirewallEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
      String firewallEndpointId = "firewallEndpointId-993710416";
      client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFirewallEndpointTest2() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
    String firewallEndpointId = "firewallEndpointId-993710416";

    FirewallEndpoint actualResponse =
        client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallEndpointRequest actualRequest =
        ((CreateFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(firewallEndpoint, actualRequest.getFirewallEndpoint());
    Assert.assertEquals(firewallEndpointId, actualRequest.getFirewallEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
      String firewallEndpointId = "firewallEndpointId-993710416";
      client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFirewallEndpointTest3() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    String parent = "parent-995424086";
    FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
    String firewallEndpointId = "firewallEndpointId-993710416";

    FirewallEndpoint actualResponse =
        client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallEndpointRequest actualRequest =
        ((CreateFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(firewallEndpoint, actualRequest.getFirewallEndpoint());
    Assert.assertEquals(firewallEndpointId, actualRequest.getFirewallEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallEndpointExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String parent = "parent-995424086";
      FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
      String firewallEndpointId = "firewallEndpointId-993710416";
      client.createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFirewallEndpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    FirewallEndpointName name =
        FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
            "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");

    client.deleteFirewallEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallEndpointRequest actualRequest =
        ((DeleteFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpointName name =
          FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
              "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
      client.deleteFirewallEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFirewallEndpointTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFirewallEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallEndpointRequest actualRequest =
        ((DeleteFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFirewallEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFirewallEndpointTest() throws Exception {
    FirewallEndpoint expectedResponse =
        FirewallEndpoint.newBuilder()
            .setName(
                FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
                        "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllAssociatedNetworks(new ArrayList<String>())
            .addAllAssociations(new ArrayList<FirewallEndpoint.AssociationReference>())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setBillingProjectId("billingProjectId-881358375")
            .setEndpointSettings(FirewallEndpoint.EndpointSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFirewallEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FirewallEndpoint actualResponse =
        client.updateFirewallEndpointAsync(firewallEndpoint, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFirewallEndpointRequest actualRequest =
        ((UpdateFirewallEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(firewallEndpoint, actualRequest.getFirewallEndpoint());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFirewallEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFirewallEndpointAsync(firewallEndpoint, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listFirewallEndpointAssociationsTest() throws Exception {
    FirewallEndpointAssociation responsesElement = FirewallEndpointAssociation.newBuilder().build();
    ListFirewallEndpointAssociationsResponse expectedResponse =
        ListFirewallEndpointAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallEndpointAssociations(Arrays.asList(responsesElement))
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFirewallEndpointAssociationsPagedResponse pagedListResponse =
        client.listFirewallEndpointAssociations(parent);

    List<FirewallEndpointAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFirewallEndpointAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallEndpointAssociationsRequest actualRequest =
        ((ListFirewallEndpointAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallEndpointAssociationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFirewallEndpointAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirewallEndpointAssociationsTest2() throws Exception {
    FirewallEndpointAssociation responsesElement = FirewallEndpointAssociation.newBuilder().build();
    ListFirewallEndpointAssociationsResponse expectedResponse =
        ListFirewallEndpointAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallEndpointAssociations(Arrays.asList(responsesElement))
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFirewallEndpointAssociationsPagedResponse pagedListResponse =
        client.listFirewallEndpointAssociations(parent);

    List<FirewallEndpointAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFirewallEndpointAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallEndpointAssociationsRequest actualRequest =
        ((ListFirewallEndpointAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallEndpointAssociationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFirewallEndpointAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallEndpointAssociationTest() throws Exception {
    FirewallEndpointAssociation expectedResponse =
        FirewallEndpointAssociation.newBuilder()
            .setName(
                FirewallEndpointAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setFirewallEndpoint("firewallEndpoint1867120309")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setReconciling(true)
            .setDisabled(true)
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    FirewallEndpointAssociationName name =
        FirewallEndpointAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");

    FirewallEndpointAssociation actualResponse = client.getFirewallEndpointAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallEndpointAssociationRequest actualRequest =
        ((GetFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallEndpointAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpointAssociationName name =
          FirewallEndpointAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");
      client.getFirewallEndpointAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallEndpointAssociationTest2() throws Exception {
    FirewallEndpointAssociation expectedResponse =
        FirewallEndpointAssociation.newBuilder()
            .setName(
                FirewallEndpointAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setFirewallEndpoint("firewallEndpoint1867120309")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setReconciling(true)
            .setDisabled(true)
            .build();
    mockFirewallActivation.addResponse(expectedResponse);

    String name = "name3373707";

    FirewallEndpointAssociation actualResponse = client.getFirewallEndpointAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallEndpointAssociationRequest actualRequest =
        ((GetFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallEndpointAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String name = "name3373707";
      client.getFirewallEndpointAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirewallEndpointAssociationTest() throws Exception {
    FirewallEndpointAssociation expectedResponse =
        FirewallEndpointAssociation.newBuilder()
            .setName(
                FirewallEndpointAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setFirewallEndpoint("firewallEndpoint1867120309")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setReconciling(true)
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFirewallEndpointAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FirewallEndpointAssociation firewallEndpointAssociation =
        FirewallEndpointAssociation.newBuilder().build();
    String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";

    FirewallEndpointAssociation actualResponse =
        client
            .createFirewallEndpointAssociationAsync(
                parent, firewallEndpointAssociation, firewallEndpointAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallEndpointAssociationRequest actualRequest =
        ((CreateFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        firewallEndpointAssociation, actualRequest.getFirewallEndpointAssociation());
    Assert.assertEquals(
        firewallEndpointAssociationId, actualRequest.getFirewallEndpointAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallEndpointAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FirewallEndpointAssociation firewallEndpointAssociation =
          FirewallEndpointAssociation.newBuilder().build();
      String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";
      client
          .createFirewallEndpointAssociationAsync(
              parent, firewallEndpointAssociation, firewallEndpointAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFirewallEndpointAssociationTest2() throws Exception {
    FirewallEndpointAssociation expectedResponse =
        FirewallEndpointAssociation.newBuilder()
            .setName(
                FirewallEndpointAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setFirewallEndpoint("firewallEndpoint1867120309")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setReconciling(true)
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFirewallEndpointAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    String parent = "parent-995424086";
    FirewallEndpointAssociation firewallEndpointAssociation =
        FirewallEndpointAssociation.newBuilder().build();
    String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";

    FirewallEndpointAssociation actualResponse =
        client
            .createFirewallEndpointAssociationAsync(
                parent, firewallEndpointAssociation, firewallEndpointAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallEndpointAssociationRequest actualRequest =
        ((CreateFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        firewallEndpointAssociation, actualRequest.getFirewallEndpointAssociation());
    Assert.assertEquals(
        firewallEndpointAssociationId, actualRequest.getFirewallEndpointAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallEndpointAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String parent = "parent-995424086";
      FirewallEndpointAssociation firewallEndpointAssociation =
          FirewallEndpointAssociation.newBuilder().build();
      String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";
      client
          .createFirewallEndpointAssociationAsync(
              parent, firewallEndpointAssociation, firewallEndpointAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFirewallEndpointAssociationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFirewallEndpointAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    FirewallEndpointAssociationName name =
        FirewallEndpointAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");

    client.deleteFirewallEndpointAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallEndpointAssociationRequest actualRequest =
        ((DeleteFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallEndpointAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpointAssociationName name =
          FirewallEndpointAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");
      client.deleteFirewallEndpointAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFirewallEndpointAssociationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFirewallEndpointAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFirewallEndpointAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallEndpointAssociationRequest actualRequest =
        ((DeleteFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallEndpointAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFirewallEndpointAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFirewallEndpointAssociationTest() throws Exception {
    FirewallEndpointAssociation expectedResponse =
        FirewallEndpointAssociation.newBuilder()
            .setName(
                FirewallEndpointAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setFirewallEndpoint("firewallEndpoint1867120309")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setReconciling(true)
            .setDisabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFirewallEndpointAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirewallActivation.addResponse(resultOperation);

    FirewallEndpointAssociation firewallEndpointAssociation =
        FirewallEndpointAssociation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FirewallEndpointAssociation actualResponse =
        client
            .updateFirewallEndpointAssociationAsync(firewallEndpointAssociation, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewallActivation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFirewallEndpointAssociationRequest actualRequest =
        ((UpdateFirewallEndpointAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(
        firewallEndpointAssociation, actualRequest.getFirewallEndpointAssociation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFirewallEndpointAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewallActivation.addException(exception);

    try {
      FirewallEndpointAssociation firewallEndpointAssociation =
          FirewallEndpointAssociation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFirewallEndpointAssociationAsync(firewallEndpointAssociation, updateMask).get();
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
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
