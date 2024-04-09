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

package com.google.cloud.backupdr.v1;

import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

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
public class BackupDRClientTest {
  private static MockBackupDR mockBackupDR;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BackupDRClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBackupDR = new MockBackupDR();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBackupDR, mockLocations, mockIAMPolicy));
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
    BackupDRSettings settings =
        BackupDRSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BackupDRClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listManagementServersTest() throws Exception {
    ManagementServer responsesElement = ManagementServer.newBuilder().build();
    ListManagementServersResponse expectedResponse =
        ListManagementServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllManagementServers(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListManagementServersPagedResponse pagedListResponse = client.listManagementServers(parent);

    List<ManagementServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getManagementServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListManagementServersRequest actualRequest =
        ((ListManagementServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listManagementServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listManagementServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listManagementServersTest2() throws Exception {
    ManagementServer responsesElement = ManagementServer.newBuilder().build();
    ListManagementServersResponse expectedResponse =
        ListManagementServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllManagementServers(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListManagementServersPagedResponse pagedListResponse = client.listManagementServers(parent);

    List<ManagementServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getManagementServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListManagementServersRequest actualRequest =
        ((ListManagementServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listManagementServersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listManagementServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getManagementServerTest() throws Exception {
    ManagementServer expectedResponse =
        ManagementServer.newBuilder()
            .setName(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagementUri(ManagementURI.newBuilder().build())
            .setWorkforceIdentityBasedManagementUri(
                WorkforceIdentityBasedManagementURI.newBuilder().build())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .setEtag("etag3123477")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setWorkforceIdentityBasedOauth2ClientId(
                WorkforceIdentityBasedOAuth2ClientID.newBuilder().build())
            .addAllBaProxyUri(new ArrayList<String>())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    ManagementServerName name =
        ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");

    ManagementServer actualResponse = client.getManagementServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetManagementServerRequest actualRequest = ((GetManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getManagementServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      ManagementServerName name =
          ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
      client.getManagementServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getManagementServerTest2() throws Exception {
    ManagementServer expectedResponse =
        ManagementServer.newBuilder()
            .setName(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagementUri(ManagementURI.newBuilder().build())
            .setWorkforceIdentityBasedManagementUri(
                WorkforceIdentityBasedManagementURI.newBuilder().build())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .setEtag("etag3123477")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setWorkforceIdentityBasedOauth2ClientId(
                WorkforceIdentityBasedOAuth2ClientID.newBuilder().build())
            .addAllBaProxyUri(new ArrayList<String>())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    ManagementServer actualResponse = client.getManagementServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetManagementServerRequest actualRequest = ((GetManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getManagementServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getManagementServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createManagementServerTest() throws Exception {
    ManagementServer expectedResponse =
        ManagementServer.newBuilder()
            .setName(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagementUri(ManagementURI.newBuilder().build())
            .setWorkforceIdentityBasedManagementUri(
                WorkforceIdentityBasedManagementURI.newBuilder().build())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .setEtag("etag3123477")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setWorkforceIdentityBasedOauth2ClientId(
                WorkforceIdentityBasedOAuth2ClientID.newBuilder().build())
            .addAllBaProxyUri(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createManagementServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ManagementServer managementServer = ManagementServer.newBuilder().build();
    String managementServerId = "managementServerId-1229628127";

    ManagementServer actualResponse =
        client.createManagementServerAsync(parent, managementServer, managementServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateManagementServerRequest actualRequest =
        ((CreateManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(managementServer, actualRequest.getManagementServer());
    Assert.assertEquals(managementServerId, actualRequest.getManagementServerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createManagementServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ManagementServer managementServer = ManagementServer.newBuilder().build();
      String managementServerId = "managementServerId-1229628127";
      client.createManagementServerAsync(parent, managementServer, managementServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createManagementServerTest2() throws Exception {
    ManagementServer expectedResponse =
        ManagementServer.newBuilder()
            .setName(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagementUri(ManagementURI.newBuilder().build())
            .setWorkforceIdentityBasedManagementUri(
                WorkforceIdentityBasedManagementURI.newBuilder().build())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .setEtag("etag3123477")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setWorkforceIdentityBasedOauth2ClientId(
                WorkforceIdentityBasedOAuth2ClientID.newBuilder().build())
            .addAllBaProxyUri(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createManagementServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String parent = "parent-995424086";
    ManagementServer managementServer = ManagementServer.newBuilder().build();
    String managementServerId = "managementServerId-1229628127";

    ManagementServer actualResponse =
        client.createManagementServerAsync(parent, managementServer, managementServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateManagementServerRequest actualRequest =
        ((CreateManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(managementServer, actualRequest.getManagementServer());
    Assert.assertEquals(managementServerId, actualRequest.getManagementServerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createManagementServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      ManagementServer managementServer = ManagementServer.newBuilder().build();
      String managementServerId = "managementServerId-1229628127";
      client.createManagementServerAsync(parent, managementServer, managementServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteManagementServerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteManagementServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    ManagementServerName name =
        ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");

    client.deleteManagementServerAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteManagementServerRequest actualRequest =
        ((DeleteManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteManagementServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      ManagementServerName name =
          ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
      client.deleteManagementServerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteManagementServerTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteManagementServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteManagementServerAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteManagementServerRequest actualRequest =
        ((DeleteManagementServerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteManagementServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.deleteManagementServerAsync(name).get();
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
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
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
                  ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
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
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
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
                  ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
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
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
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
                  ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
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
