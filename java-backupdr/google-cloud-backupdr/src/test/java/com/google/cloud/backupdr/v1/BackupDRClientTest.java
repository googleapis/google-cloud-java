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

package com.google.cloud.backupdr.v1;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchBackupPlanAssociationsForResourceTypePagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.FetchDataSourceReferencesForResourceTypePagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanRevisionsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
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
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
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
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(true)
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
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(true)
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
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(true)
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
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(true)
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
  public void createBackupVaultTest() throws Exception {
    BackupVault expectedResponse =
        BackupVault.newBuilder()
            .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupMinimumEnforcedRetentionDuration(Duration.newBuilder().build())
            .setDeletable(true)
            .setEtag("etag3123477")
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setServiceAccount("serviceAccount1079137720")
            .setTotalStoredBytes(1181597162)
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupVault backupVault = BackupVault.newBuilder().build();
    String backupVaultId = "backupVaultId-1897432373";

    BackupVault actualResponse =
        client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupVaultRequest actualRequest = ((CreateBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupVault, actualRequest.getBackupVault());
    Assert.assertEquals(backupVaultId, actualRequest.getBackupVaultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupVault backupVault = BackupVault.newBuilder().build();
      String backupVaultId = "backupVaultId-1897432373";
      client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupVaultTest2() throws Exception {
    BackupVault expectedResponse =
        BackupVault.newBuilder()
            .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupMinimumEnforcedRetentionDuration(Duration.newBuilder().build())
            .setDeletable(true)
            .setEtag("etag3123477")
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setServiceAccount("serviceAccount1079137720")
            .setTotalStoredBytes(1181597162)
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String parent = "parent-995424086";
    BackupVault backupVault = BackupVault.newBuilder().build();
    String backupVaultId = "backupVaultId-1897432373";

    BackupVault actualResponse =
        client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupVaultRequest actualRequest = ((CreateBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupVault, actualRequest.getBackupVault());
    Assert.assertEquals(backupVaultId, actualRequest.getBackupVaultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      BackupVault backupVault = BackupVault.newBuilder().build();
      String backupVaultId = "backupVaultId-1897432373";
      client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBackupVaultsTest() throws Exception {
    BackupVault responsesElement = BackupVault.newBuilder().build();
    ListBackupVaultsResponse expectedResponse =
        ListBackupVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupVaults(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupVaultsPagedResponse pagedListResponse = client.listBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupVaultsRequest actualRequest = ((ListBackupVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupVaultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackupVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupVaultsTest2() throws Exception {
    BackupVault responsesElement = BackupVault.newBuilder().build();
    ListBackupVaultsResponse expectedResponse =
        ListBackupVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupVaults(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupVaultsPagedResponse pagedListResponse = client.listBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupVaultsRequest actualRequest = ((ListBackupVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupVaultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchUsableBackupVaultsTest() throws Exception {
    BackupVault responsesElement = BackupVault.newBuilder().build();
    FetchUsableBackupVaultsResponse expectedResponse =
        FetchUsableBackupVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupVaults(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchUsableBackupVaultsPagedResponse pagedListResponse = client.fetchUsableBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchUsableBackupVaultsRequest actualRequest =
        ((FetchUsableBackupVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchUsableBackupVaultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.fetchUsableBackupVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchUsableBackupVaultsTest2() throws Exception {
    BackupVault responsesElement = BackupVault.newBuilder().build();
    FetchUsableBackupVaultsResponse expectedResponse =
        FetchUsableBackupVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupVaults(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    FetchUsableBackupVaultsPagedResponse pagedListResponse = client.fetchUsableBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchUsableBackupVaultsRequest actualRequest =
        ((FetchUsableBackupVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchUsableBackupVaultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.fetchUsableBackupVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupVaultTest() throws Exception {
    BackupVault expectedResponse =
        BackupVault.newBuilder()
            .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupMinimumEnforcedRetentionDuration(Duration.newBuilder().build())
            .setDeletable(true)
            .setEtag("etag3123477")
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setServiceAccount("serviceAccount1079137720")
            .setTotalStoredBytes(1181597162)
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    BackupVault actualResponse = client.getBackupVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupVaultRequest actualRequest = ((GetBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
      client.getBackupVault(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupVaultTest2() throws Exception {
    BackupVault expectedResponse =
        BackupVault.newBuilder()
            .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupMinimumEnforcedRetentionDuration(Duration.newBuilder().build())
            .setDeletable(true)
            .setEtag("etag3123477")
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setServiceAccount("serviceAccount1079137720")
            .setTotalStoredBytes(1181597162)
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    BackupVault actualResponse = client.getBackupVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupVaultRequest actualRequest = ((GetBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupVault(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupVaultTest() throws Exception {
    BackupVault expectedResponse =
        BackupVault.newBuilder()
            .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupMinimumEnforcedRetentionDuration(Duration.newBuilder().build())
            .setDeletable(true)
            .setEtag("etag3123477")
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setServiceAccount("serviceAccount1079137720")
            .setTotalStoredBytes(1181597162)
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupVault backupVault = BackupVault.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupVault actualResponse = client.updateBackupVaultAsync(backupVault, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupVaultRequest actualRequest = ((UpdateBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(backupVault, actualRequest.getBackupVault());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupVault backupVault = BackupVault.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupVaultAsync(backupVault, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupVaultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    client.deleteBackupVaultAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupVaultRequest actualRequest = ((DeleteBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
      client.deleteBackupVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupVaultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupVaultAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupVaultRequest actualRequest = ((DeleteBackupVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDataSourcesTest() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupVaultName parent = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupVaultName parent = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest2() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(
                DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                    .toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setEtag("etag3123477")
            .setTotalStoredBytes(1181597162)
            .setConfigState(BackupConfigState.forNumber(0))
            .setBackupConfigInfo(BackupConfigInfo.newBuilder().build())
            .setBackupBlockedByVaultAccessRestriction(true)
            .build();
    mockBackupDR.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      DataSourceName name =
          DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(
                DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                    .toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setEtag("etag3123477")
            .setTotalStoredBytes(1181597162)
            .setConfigState(BackupConfigState.forNumber(0))
            .setBackupConfigInfo(BackupConfigInfo.newBuilder().build())
            .setBackupBlockedByVaultAccessRestriction(true)
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(
                DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                    .toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBackupCount(336678994)
            .setEtag("etag3123477")
            .setTotalStoredBytes(1181597162)
            .setConfigState(BackupConfigState.forNumber(0))
            .setBackupConfigInfo(BackupConfigInfo.newBuilder().build())
            .setBackupBlockedByVaultAccessRestriction(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    DataSource dataSource = DataSource.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSource actualResponse = client.updateDataSourceAsync(dataSource, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataSourceRequest actualRequest = ((UpdateDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(dataSource, actualRequest.getDataSource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      DataSource dataSource = DataSource.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataSourceAsync(dataSource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBackupsTest() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    DataSourceName parent =
        DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      DataSourceName parent =
          DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest2() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnforcedRetentionEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setConsistencyTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllServiceLocks(new ArrayList<BackupLock>())
            .addAllBackupApplianceLocks(new ArrayList<BackupLock>())
            .setResourceSizeBytes(-275424386)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupName name =
          BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnforcedRetentionEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setConsistencyTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllServiceLocks(new ArrayList<BackupLock>())
            .addAllBackupApplianceLocks(new ArrayList<BackupLock>())
            .setResourceSizeBytes(-275424386)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnforcedRetentionEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setConsistencyTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllServiceLocks(new ArrayList<BackupLock>())
            .addAllBackupApplianceLocks(new ArrayList<BackupLock>())
            .setResourceSizeBytes(-275424386)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    Backup backup = Backup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Backup actualResponse = client.updateBackupAsync(backup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupRequest actualRequest = ((UpdateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      Backup backup = Backup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupAsync(backup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnforcedRetentionEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setConsistencyTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllServiceLocks(new ArrayList<BackupLock>())
            .addAllBackupApplianceLocks(new ArrayList<BackupLock>())
            .setResourceSizeBytes(-275424386)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    Backup actualResponse = client.deleteBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupName name =
          BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnforcedRetentionEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setConsistencyTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllServiceLocks(new ArrayList<BackupLock>())
            .addAllBackupApplianceLocks(new ArrayList<BackupLock>())
            .setResourceSizeBytes(-275424386)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    Backup actualResponse = client.deleteBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreBackupTest() throws Exception {
    RestoreBackupResponse expectedResponse =
        RestoreBackupResponse.newBuilder()
            .setTargetResource(TargetResource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    RestoreBackupResponse actualResponse = client.restoreBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreBackupRequest actualRequest = ((RestoreBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupName name =
          BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
      client.restoreBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreBackupTest2() throws Exception {
    RestoreBackupResponse expectedResponse =
        RestoreBackupResponse.newBuilder()
            .setTargetResource(TargetResource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    RestoreBackupResponse actualResponse = client.restoreBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreBackupRequest actualRequest = ((RestoreBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.restoreBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllBackupRules(new ArrayList<BackupRule>())
            .setResourceType("resourceType-384364440")
            .setEtag("etag3123477")
            .setBackupVault(
                BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setBackupVaultServiceAccount("backupVaultServiceAccount1888664424")
            .setLogRetentionDays(1566369587)
            .addAllSupportedResourceTypes(new ArrayList<String>())
            .setRevisionId("revisionId-1507445162")
            .setRevisionName("revisionName-1250672378")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanRequest actualRequest = ((CreateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(backupPlanId, actualRequest.getBackupPlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupPlanTest2() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllBackupRules(new ArrayList<BackupRule>())
            .setResourceType("resourceType-384364440")
            .setEtag("etag3123477")
            .setBackupVault(
                BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setBackupVaultServiceAccount("backupVaultServiceAccount1888664424")
            .setLogRetentionDays(1566369587)
            .addAllSupportedResourceTypes(new ArrayList<String>())
            .setRevisionId("revisionId-1507445162")
            .setRevisionName("revisionName-1250672378")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String parent = "parent-995424086";
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanRequest actualRequest = ((CreateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(backupPlanId, actualRequest.getBackupPlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllBackupRules(new ArrayList<BackupRule>())
            .setResourceType("resourceType-384364440")
            .setEtag("etag3123477")
            .setBackupVault(
                BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setBackupVaultServiceAccount("backupVaultServiceAccount1888664424")
            .setLogRetentionDays(1566369587)
            .addAllSupportedResourceTypes(new ArrayList<String>())
            .setRevisionId("revisionId-1507445162")
            .setRevisionName("revisionName-1250672378")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlan actualResponse = client.updateBackupPlanAsync(backupPlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupPlanRequest actualRequest = ((UpdateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAsync(backupPlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllBackupRules(new ArrayList<BackupRule>())
            .setResourceType("resourceType-384364440")
            .setEtag("etag3123477")
            .setBackupVault(
                BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setBackupVaultServiceAccount("backupVaultServiceAccount1888664424")
            .setLogRetentionDays(1566369587)
            .addAllSupportedResourceTypes(new ArrayList<String>())
            .setRevisionId("revisionId-1507445162")
            .setRevisionName("revisionName-1250672378")
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRequest actualRequest = ((GetBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.getBackupPlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupPlanTest2() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllBackupRules(new ArrayList<BackupRule>())
            .setResourceType("resourceType-384364440")
            .setEtag("etag3123477")
            .setBackupVault(
                BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
            .setBackupVaultServiceAccount("backupVaultServiceAccount1888664424")
            .setLogRetentionDays(1566369587)
            .addAllSupportedResourceTypes(new ArrayList<String>())
            .setRevisionId("revisionId-1507445162")
            .setRevisionName("revisionName-1250672378")
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRequest actualRequest = ((GetBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupPlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlansTest() throws Exception {
    BackupPlan responsesElement = BackupPlan.newBuilder().build();
    ListBackupPlansResponse expectedResponse =
        ListBackupPlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlans(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlansRequest actualRequest = ((ListBackupPlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackupPlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlansTest2() throws Exception {
    BackupPlan responsesElement = BackupPlan.newBuilder().build();
    ListBackupPlansResponse expectedResponse =
        ListBackupPlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlans(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlansRequest actualRequest = ((ListBackupPlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlansExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupPlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupPlanTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    client.deleteBackupPlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanRequest actualRequest = ((DeleteBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupPlanTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupPlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanRequest actualRequest = ((DeleteBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getBackupPlanRevisionTest() throws Exception {
    BackupPlanRevision expectedResponse =
        BackupPlanRevision.newBuilder()
            .setName(
                BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setBackupPlanSnapshot(BackupPlan.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupPlanRevisionName name =
        BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]");

    BackupPlanRevision actualResponse = client.getBackupPlanRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRevisionRequest actualRequest =
        ((GetBackupPlanRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanRevisionName name =
          BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]");
      client.getBackupPlanRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupPlanRevisionTest2() throws Exception {
    BackupPlanRevision expectedResponse =
        BackupPlanRevision.newBuilder()
            .setName(
                BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setBackupPlanSnapshot(BackupPlan.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    BackupPlanRevision actualResponse = client.getBackupPlanRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRevisionRequest actualRequest =
        ((GetBackupPlanRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupPlanRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlanRevisionsTest() throws Exception {
    BackupPlanRevision responsesElement = BackupPlanRevision.newBuilder().build();
    ListBackupPlanRevisionsResponse expectedResponse =
        ListBackupPlanRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanRevisions(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    ListBackupPlanRevisionsPagedResponse pagedListResponse = client.listBackupPlanRevisions(parent);

    List<BackupPlanRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlanRevisionsRequest actualRequest =
        ((ListBackupPlanRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlanRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.listBackupPlanRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlanRevisionsTest2() throws Exception {
    BackupPlanRevision responsesElement = BackupPlanRevision.newBuilder().build();
    ListBackupPlanRevisionsResponse expectedResponse =
        ListBackupPlanRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanRevisions(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupPlanRevisionsPagedResponse pagedListResponse = client.listBackupPlanRevisions(parent);

    List<BackupPlanRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlanRevisionsRequest actualRequest =
        ((ListBackupPlanRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlanRevisionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupPlanRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupPlanAssociationTest() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
    String backupPlanAssociationId = "backupPlanAssociationId567762737";

    BackupPlanAssociation actualResponse =
        client
            .createBackupPlanAssociationAsync(
                parent, backupPlanAssociation, backupPlanAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanAssociationRequest actualRequest =
        ((CreateBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupPlanAssociation, actualRequest.getBackupPlanAssociation());
    Assert.assertEquals(backupPlanAssociationId, actualRequest.getBackupPlanAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
      String backupPlanAssociationId = "backupPlanAssociationId567762737";
      client
          .createBackupPlanAssociationAsync(parent, backupPlanAssociation, backupPlanAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupPlanAssociationTest2() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String parent = "parent-995424086";
    BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
    String backupPlanAssociationId = "backupPlanAssociationId567762737";

    BackupPlanAssociation actualResponse =
        client
            .createBackupPlanAssociationAsync(
                parent, backupPlanAssociation, backupPlanAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanAssociationRequest actualRequest =
        ((CreateBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupPlanAssociation, actualRequest.getBackupPlanAssociation());
    Assert.assertEquals(backupPlanAssociationId, actualRequest.getBackupPlanAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
      String backupPlanAssociationId = "backupPlanAssociationId567762737";
      client
          .createBackupPlanAssociationAsync(parent, backupPlanAssociation, backupPlanAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBackupPlanAssociationTest() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupPlanAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlanAssociation actualResponse =
        client.updateBackupPlanAssociationAsync(backupPlanAssociation, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupPlanAssociationRequest actualRequest =
        ((UpdateBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(backupPlanAssociation, actualRequest.getBackupPlanAssociation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupPlanAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAssociationAsync(backupPlanAssociation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getBackupPlanAssociationTest() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    mockBackupDR.addResponse(expectedResponse);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");

    BackupPlanAssociation actualResponse = client.getBackupPlanAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanAssociationRequest actualRequest =
        ((GetBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanAssociationName name =
          BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
      client.getBackupPlanAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupPlanAssociationTest2() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    BackupPlanAssociation actualResponse = client.getBackupPlanAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanAssociationRequest actualRequest =
        ((GetBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupPlanAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlanAssociationsTest() throws Exception {
    BackupPlanAssociation responsesElement = BackupPlanAssociation.newBuilder().build();
    ListBackupPlanAssociationsResponse expectedResponse =
        ListBackupPlanAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanAssociations(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlanAssociationsPagedResponse pagedListResponse =
        client.listBackupPlanAssociations(parent);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlanAssociationsRequest actualRequest =
        ((ListBackupPlanAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlanAssociationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackupPlanAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlanAssociationsTest2() throws Exception {
    BackupPlanAssociation responsesElement = BackupPlanAssociation.newBuilder().build();
    ListBackupPlanAssociationsResponse expectedResponse =
        ListBackupPlanAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanAssociations(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupPlanAssociationsPagedResponse pagedListResponse =
        client.listBackupPlanAssociations(parent);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlanAssociationsRequest actualRequest =
        ((ListBackupPlanAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlanAssociationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupPlanAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeTest() throws Exception {
    BackupPlanAssociation responsesElement = BackupPlanAssociation.newBuilder().build();
    FetchBackupPlanAssociationsForResourceTypeResponse expectedResponse =
        FetchBackupPlanAssociationsForResourceTypeResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanAssociations(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String resourceType = "resourceType-384364440";

    FetchBackupPlanAssociationsForResourceTypePagedResponse pagedListResponse =
        client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchBackupPlanAssociationsForResourceTypeRequest actualRequest =
        ((FetchBackupPlanAssociationsForResourceTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(resourceType, actualRequest.getResourceType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String resourceType = "resourceType-384364440";
      client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeTest2() throws Exception {
    BackupPlanAssociation responsesElement = BackupPlanAssociation.newBuilder().build();
    FetchBackupPlanAssociationsForResourceTypeResponse expectedResponse =
        FetchBackupPlanAssociationsForResourceTypeResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlanAssociations(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String resourceType = "resourceType-384364440";

    FetchBackupPlanAssociationsForResourceTypePagedResponse pagedListResponse =
        client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchBackupPlanAssociationsForResourceTypeRequest actualRequest =
        ((FetchBackupPlanAssociationsForResourceTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(resourceType, actualRequest.getResourceType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      String resourceType = "resourceType-384364440";
      client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupPlanAssociationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");

    client.deleteBackupPlanAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanAssociationRequest actualRequest =
        ((DeleteBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanAssociationName name =
          BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
      client.deleteBackupPlanAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupPlanAssociationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupPlanAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanAssociationRequest actualRequest =
        ((DeleteBackupPlanAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupPlanAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void triggerBackupTest() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("triggerBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
    String ruleId = "ruleId-919875273";

    BackupPlanAssociation actualResponse = client.triggerBackupAsync(name, ruleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TriggerBackupRequest actualRequest = ((TriggerBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(ruleId, actualRequest.getRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void triggerBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      BackupPlanAssociationName name =
          BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
      String ruleId = "ruleId-919875273";
      client.triggerBackupAsync(name, ruleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void triggerBackupTest2() throws Exception {
    BackupPlanAssociation expectedResponse =
        BackupPlanAssociation.newBuilder()
            .setName(
                BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                    .toString())
            .setResourceType("resourceType-384364440")
            .setResource("resource-341064690")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
            .setDataSource("dataSource1272470629")
            .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
            .setBackupPlanRevisionName("backupPlanRevisionName648847537")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("triggerBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    String name = "name3373707";
    String ruleId = "ruleId-919875273";

    BackupPlanAssociation actualResponse = client.triggerBackupAsync(name, ruleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TriggerBackupRequest actualRequest = ((TriggerBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(ruleId, actualRequest.getRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void triggerBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      String ruleId = "ruleId-919875273";
      client.triggerBackupAsync(name, ruleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataSourceReferenceTest() throws Exception {
    DataSourceReference expectedResponse =
        DataSourceReference.newBuilder()
            .setName(
                DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]")
                    .toString())
            .setDataSource(
                DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataSourceBackupConfigState(BackupConfigState.forNumber(0))
            .setDataSourceBackupCount(-1620010527)
            .setDataSourceBackupConfigInfo(DataSourceBackupConfigInfo.newBuilder().build())
            .setDataSourceGcpResourceInfo(DataSourceGcpResourceInfo.newBuilder().build())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    DataSourceReferenceName name =
        DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]");

    DataSourceReference actualResponse = client.getDataSourceReference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceReferenceRequest actualRequest =
        ((GetDataSourceReferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceReferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      DataSourceReferenceName name =
          DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]");
      client.getDataSourceReference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceReferenceTest2() throws Exception {
    DataSourceReference expectedResponse =
        DataSourceReference.newBuilder()
            .setName(
                DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]")
                    .toString())
            .setDataSource(
                DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataSourceBackupConfigState(BackupConfigState.forNumber(0))
            .setDataSourceBackupCount(-1620010527)
            .setDataSourceBackupConfigInfo(DataSourceBackupConfigInfo.newBuilder().build())
            .setDataSourceGcpResourceInfo(DataSourceGcpResourceInfo.newBuilder().build())
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String name = "name3373707";

    DataSourceReference actualResponse = client.getDataSourceReference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceReferenceRequest actualRequest =
        ((GetDataSourceReferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceReferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String name = "name3373707";
      client.getDataSourceReference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeTest() throws Exception {
    DataSourceReference responsesElement = DataSourceReference.newBuilder().build();
    FetchDataSourceReferencesForResourceTypeResponse expectedResponse =
        FetchDataSourceReferencesForResourceTypeResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSourceReferences(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String resourceType = "resourceType-384364440";

    FetchDataSourceReferencesForResourceTypePagedResponse pagedListResponse =
        client.fetchDataSourceReferencesForResourceType(parent, resourceType);

    List<DataSourceReference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourceReferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDataSourceReferencesForResourceTypeRequest actualRequest =
        ((FetchDataSourceReferencesForResourceTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(resourceType, actualRequest.getResourceType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String resourceType = "resourceType-384364440";
      client.fetchDataSourceReferencesForResourceType(parent, resourceType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeTest2() throws Exception {
    DataSourceReference responsesElement = DataSourceReference.newBuilder().build();
    FetchDataSourceReferencesForResourceTypeResponse expectedResponse =
        FetchDataSourceReferencesForResourceTypeResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSourceReferences(Arrays.asList(responsesElement))
            .build();
    mockBackupDR.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String resourceType = "resourceType-384364440";

    FetchDataSourceReferencesForResourceTypePagedResponse pagedListResponse =
        client.fetchDataSourceReferencesForResourceType(parent, resourceType);

    List<DataSourceReference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourceReferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDataSourceReferencesForResourceTypeRequest actualRequest =
        ((FetchDataSourceReferencesForResourceTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(resourceType, actualRequest.getResourceType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      String parent = "parent-995424086";
      String resourceType = "resourceType-384364440";
      client.fetchDataSourceReferencesForResourceType(parent, resourceType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void initializeServiceTest() throws Exception {
    InitializeServiceResponse expectedResponse =
        InitializeServiceResponse.newBuilder()
            .setBackupVaultName("backupVaultName1928739899")
            .setBackupPlanName("backupPlanName42972470")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("initializeServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupDR.addResponse(resultOperation);

    InitializeServiceRequest request =
        InitializeServiceRequest.newBuilder()
            .setName("name3373707")
            .setResourceType("resourceType-384364440")
            .setRequestId("requestId693933066")
            .build();

    InitializeServiceResponse actualResponse = client.initializeServiceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupDR.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InitializeServiceRequest actualRequest = ((InitializeServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getResourceType(), actualRequest.getResourceType());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(
        request.getCloudSqlInstanceInitializationConfig(),
        actualRequest.getCloudSqlInstanceInitializationConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void initializeServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupDR.addException(exception);

    try {
      InitializeServiceRequest request =
          InitializeServiceRequest.newBuilder()
              .setName("name3373707")
              .setResourceType("resourceType-384364440")
              .setRequestId("requestId693933066")
              .build();
      client.initializeServiceAsync(request).get();
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
