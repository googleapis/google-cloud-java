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

package com.google.cloud.networkconnectivity.v1beta;

import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListRemoteTransportProfilesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListTransportsPagedResponse;

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
public class TransportManagerClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockTransportManager mockTransportManager;
  private LocalChannelProvider channelProvider;
  private TransportManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTransportManager = new MockTransportManager();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTransportManager, mockLocations, mockIAMPolicy));
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
    TransportManagerSettings settings =
        TransportManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TransportManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRemoteTransportProfilesTest() throws Exception {
    RemoteTransportProfile responsesElement = RemoteTransportProfile.newBuilder().build();
    ListRemoteTransportProfilesResponse expectedResponse =
        ListRemoteTransportProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRemoteTransportProfiles(Arrays.asList(responsesElement))
            .build();
    mockTransportManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRemoteTransportProfilesPagedResponse pagedListResponse =
        client.listRemoteTransportProfiles(parent);

    List<RemoteTransportProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRemoteTransportProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRemoteTransportProfilesRequest actualRequest =
        ((ListRemoteTransportProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRemoteTransportProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRemoteTransportProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRemoteTransportProfilesTest2() throws Exception {
    RemoteTransportProfile responsesElement = RemoteTransportProfile.newBuilder().build();
    ListRemoteTransportProfilesResponse expectedResponse =
        ListRemoteTransportProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRemoteTransportProfiles(Arrays.asList(responsesElement))
            .build();
    mockTransportManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRemoteTransportProfilesPagedResponse pagedListResponse =
        client.listRemoteTransportProfiles(parent);

    List<RemoteTransportProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRemoteTransportProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRemoteTransportProfilesRequest actualRequest =
        ((ListRemoteTransportProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRemoteTransportProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRemoteTransportProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRemoteTransportProfileTest() throws Exception {
    RemoteTransportProfile expectedResponse =
        RemoteTransportProfile.newBuilder()
            .setName(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setProvider("provider-987494927")
            .setProviderSite("providerSite-419104552")
            .addAllSupportedBandwidths(new ArrayList<RemoteTransportProfile.Bandwidth>())
            .setDisplayName("displayName1714148973")
            .build();
    mockTransportManager.addResponse(expectedResponse);

    RemoteTransportProfileName name =
        RemoteTransportProfileName.of("[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]");

    RemoteTransportProfile actualResponse = client.getRemoteTransportProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRemoteTransportProfileRequest actualRequest =
        ((GetRemoteTransportProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRemoteTransportProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      RemoteTransportProfileName name =
          RemoteTransportProfileName.of("[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]");
      client.getRemoteTransportProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRemoteTransportProfileTest2() throws Exception {
    RemoteTransportProfile expectedResponse =
        RemoteTransportProfile.newBuilder()
            .setName(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setProvider("provider-987494927")
            .setProviderSite("providerSite-419104552")
            .addAllSupportedBandwidths(new ArrayList<RemoteTransportProfile.Bandwidth>())
            .setDisplayName("displayName1714148973")
            .build();
    mockTransportManager.addResponse(expectedResponse);

    String name = "name3373707";

    RemoteTransportProfile actualResponse = client.getRemoteTransportProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRemoteTransportProfileRequest actualRequest =
        ((GetRemoteTransportProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRemoteTransportProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String name = "name3373707";
      client.getRemoteTransportProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransportsTest() throws Exception {
    Transport responsesElement = Transport.newBuilder().build();
    ListTransportsResponse expectedResponse =
        ListTransportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransports(Arrays.asList(responsesElement))
            .build();
    mockTransportManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTransportsPagedResponse pagedListResponse = client.listTransports(parent);

    List<Transport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransportsRequest actualRequest = ((ListTransportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTransports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransportsTest2() throws Exception {
    Transport responsesElement = Transport.newBuilder().build();
    ListTransportsResponse expectedResponse =
        ListTransportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransports(Arrays.asList(responsesElement))
            .build();
    mockTransportManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTransportsPagedResponse pagedListResponse = client.listTransports(parent);

    List<Transport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransportsRequest actualRequest = ((ListTransportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTransports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransportTest() throws Exception {
    Transport expectedResponse =
        Transport.newBuilder()
            .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setRemoteProfile(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .setProvidedActivationKey("providedActivationKey-363194298")
            .setGeneratedActivationKey("generatedActivationKey1508760602")
            .setMtuLimit(144989162)
            .setAdminEnabled(true)
            .setNetwork("network1843485230")
            .addAllAdvertisedRoutes(new ArrayList<String>())
            .setRemoteAccountId("remoteAccountId-416492926")
            .setPeeringNetwork("peeringNetwork-975063346")
            .build();
    mockTransportManager.addResponse(expectedResponse);

    TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");

    Transport actualResponse = client.getTransport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransportRequest actualRequest = ((GetTransportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
      client.getTransport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransportTest2() throws Exception {
    Transport expectedResponse =
        Transport.newBuilder()
            .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setRemoteProfile(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .setProvidedActivationKey("providedActivationKey-363194298")
            .setGeneratedActivationKey("generatedActivationKey1508760602")
            .setMtuLimit(144989162)
            .setAdminEnabled(true)
            .setNetwork("network1843485230")
            .addAllAdvertisedRoutes(new ArrayList<String>())
            .setRemoteAccountId("remoteAccountId-416492926")
            .setPeeringNetwork("peeringNetwork-975063346")
            .build();
    mockTransportManager.addResponse(expectedResponse);

    String name = "name3373707";

    Transport actualResponse = client.getTransport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransportRequest actualRequest = ((GetTransportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String name = "name3373707";
      client.getTransport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStatusTest() throws Exception {
    GetStatusResponse expectedResponse = GetStatusResponse.newBuilder().build();
    mockTransportManager.addResponse(expectedResponse);

    TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");

    GetStatusResponse actualResponse = client.getStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStatusRequest actualRequest = ((GetStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
      client.getStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStatusTest2() throws Exception {
    GetStatusResponse expectedResponse = GetStatusResponse.newBuilder().build();
    mockTransportManager.addResponse(expectedResponse);

    String name = "name3373707";

    GetStatusResponse actualResponse = client.getStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStatusRequest actualRequest = ((GetStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStatusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String name = "name3373707";
      client.getStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransportTest() throws Exception {
    Transport expectedResponse =
        Transport.newBuilder()
            .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setRemoteProfile(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .setProvidedActivationKey("providedActivationKey-363194298")
            .setGeneratedActivationKey("generatedActivationKey1508760602")
            .setMtuLimit(144989162)
            .setAdminEnabled(true)
            .setNetwork("network1843485230")
            .addAllAdvertisedRoutes(new ArrayList<String>())
            .setRemoteAccountId("remoteAccountId-416492926")
            .setPeeringNetwork("peeringNetwork-975063346")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTransportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTransportManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Transport transport = Transport.newBuilder().build();
    String transportId = "transportId-1713251804";

    Transport actualResponse = client.createTransportAsync(parent, transport, transportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransportRequest actualRequest = ((CreateTransportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(transport, actualRequest.getTransport());
    Assert.assertEquals(transportId, actualRequest.getTransportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Transport transport = Transport.newBuilder().build();
      String transportId = "transportId-1713251804";
      client.createTransportAsync(parent, transport, transportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTransportTest2() throws Exception {
    Transport expectedResponse =
        Transport.newBuilder()
            .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setRemoteProfile(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .setProvidedActivationKey("providedActivationKey-363194298")
            .setGeneratedActivationKey("generatedActivationKey1508760602")
            .setMtuLimit(144989162)
            .setAdminEnabled(true)
            .setNetwork("network1843485230")
            .addAllAdvertisedRoutes(new ArrayList<String>())
            .setRemoteAccountId("remoteAccountId-416492926")
            .setPeeringNetwork("peeringNetwork-975063346")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTransportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTransportManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Transport transport = Transport.newBuilder().build();
    String transportId = "transportId-1713251804";

    Transport actualResponse = client.createTransportAsync(parent, transport, transportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransportRequest actualRequest = ((CreateTransportRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(transport, actualRequest.getTransport());
    Assert.assertEquals(transportId, actualRequest.getTransportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Transport transport = Transport.newBuilder().build();
      String transportId = "transportId-1713251804";
      client.createTransportAsync(parent, transport, transportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTransportTest() throws Exception {
    Transport expectedResponse =
        Transport.newBuilder()
            .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setRemoteProfile(
                RemoteTransportProfileName.of(
                        "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                    .toString())
            .setProvidedActivationKey("providedActivationKey-363194298")
            .setGeneratedActivationKey("generatedActivationKey1508760602")
            .setMtuLimit(144989162)
            .setAdminEnabled(true)
            .setNetwork("network1843485230")
            .addAllAdvertisedRoutes(new ArrayList<String>())
            .setRemoteAccountId("remoteAccountId-416492926")
            .setPeeringNetwork("peeringNetwork-975063346")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTransportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTransportManager.addResponse(resultOperation);

    Transport transport = Transport.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Transport actualResponse = client.updateTransportAsync(transport, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTransportRequest actualRequest = ((UpdateTransportRequest) actualRequests.get(0));

    Assert.assertEquals(transport, actualRequest.getTransport());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTransportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      Transport transport = Transport.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTransportAsync(transport, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTransportTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTransportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTransportManager.addResponse(resultOperation);

    TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");

    client.deleteTransportAsync(name).get();

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransportRequest actualRequest = ((DeleteTransportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
      client.deleteTransportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTransportTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTransportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTransportManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTransportAsync(name).get();

    List<AbstractMessage> actualRequests = mockTransportManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransportRequest actualRequest = ((DeleteTransportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTransportManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTransportAsync(name).get();
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
