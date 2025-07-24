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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.backupdr.v1.stub.HttpJsonBackupDRStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BackupDRClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BackupDRClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBackupDRStub.getMethodDescriptors(), BackupDRSettings.getDefaultEndpoint());
    BackupDRSettings settings =
        BackupDRSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BackupDRSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BackupDRClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listManagementServersTest() throws Exception {
    ManagementServer responsesElement = ManagementServer.newBuilder().build();
    ListManagementServersResponse expectedResponse =
        ListManagementServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllManagementServers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListManagementServersPagedResponse pagedListResponse = client.listManagementServers(parent);

    List<ManagementServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getManagementServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listManagementServersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListManagementServersPagedResponse pagedListResponse = client.listManagementServers(parent);

    List<ManagementServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getManagementServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listManagementServersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    ManagementServerName name =
        ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");

    ManagementServer actualResponse = client.getManagementServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getManagementServerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2637/locations/location-2637/managementServers/managementServer-2637";

    ManagementServer actualResponse = client.getManagementServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getManagementServerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2637/locations/location-2637/managementServers/managementServer-2637";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ManagementServer managementServer = ManagementServer.newBuilder().build();
    String managementServerId = "managementServerId-1229628127";

    ManagementServer actualResponse =
        client.createManagementServerAsync(parent, managementServer, managementServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createManagementServerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ManagementServer managementServer = ManagementServer.newBuilder().build();
      String managementServerId = "managementServerId-1229628127";
      client.createManagementServerAsync(parent, managementServer, managementServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ManagementServer managementServer = ManagementServer.newBuilder().build();
    String managementServerId = "managementServerId-1229628127";

    ManagementServer actualResponse =
        client.createManagementServerAsync(parent, managementServer, managementServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createManagementServerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ManagementServer managementServer = ManagementServer.newBuilder().build();
      String managementServerId = "managementServerId-1229628127";
      client.createManagementServerAsync(parent, managementServer, managementServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ManagementServerName name =
        ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");

    client.deleteManagementServerAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteManagementServerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ManagementServerName name =
          ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
      client.deleteManagementServerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2637/locations/location-2637/managementServers/managementServer-2637";

    client.deleteManagementServerAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteManagementServerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2637/locations/location-2637/managementServers/managementServer-2637";
      client.deleteManagementServerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupVault backupVault = BackupVault.newBuilder().build();
    String backupVaultId = "backupVaultId-1897432373";

    BackupVault actualResponse =
        client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupVaultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupVault backupVault = BackupVault.newBuilder().build();
      String backupVaultId = "backupVaultId-1897432373";
      client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    BackupVault backupVault = BackupVault.newBuilder().build();
    String backupVaultId = "backupVaultId-1897432373";

    BackupVault actualResponse =
        client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupVaultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      BackupVault backupVault = BackupVault.newBuilder().build();
      String backupVaultId = "backupVaultId-1897432373";
      client.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupVaultsPagedResponse pagedListResponse = client.listBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupVaultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupVaultsPagedResponse pagedListResponse = client.listBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupVaultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchUsableBackupVaultsPagedResponse pagedListResponse = client.fetchUsableBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchUsableBackupVaultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    FetchUsableBackupVaultsPagedResponse pagedListResponse = client.fetchUsableBackupVaults(parent);

    List<BackupVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupVaultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchUsableBackupVaultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    BackupVault actualResponse = client.getBackupVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupVaultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-237/locations/location-237/backupVaults/backupVault-237";

    BackupVault actualResponse = client.getBackupVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupVaultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-237/locations/location-237/backupVaults/backupVault-237";
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
    mockService.addResponse(resultOperation);

    BackupVault backupVault =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupVault actualResponse = client.updateBackupVaultAsync(backupVault, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupVaultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupVault backupVault =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupVaultAsync(backupVault, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    client.deleteBackupVaultAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupVaultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
      client.deleteBackupVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-237/locations/location-237/backupVaults/backupVault-237";

    client.deleteBackupVaultAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupVaultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-237/locations/location-237/backupVaults/backupVault-237";
      client.deleteBackupVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupVaultName parent = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5588/locations/location-5588/backupVaults/backupVault-5588";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5588/locations/location-5588/backupVaults/backupVault-5588";
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
    mockService.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1411/locations/location-1411/backupVaults/backupVault-1411/dataSources/dataSource-1411";

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1411/locations/location-1411/backupVaults/backupVault-1411/dataSources/dataSource-1411";
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
    mockService.addResponse(resultOperation);

    DataSource dataSource =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSource actualResponse = client.updateDataSourceAsync(dataSource, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSource dataSource =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataSourceAsync(dataSource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    DataSourceName parent =
        DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9790/locations/location-9790/backupVaults/backupVault-9790/dataSources/dataSource-9790";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9790/locations/location-9790/backupVaults/backupVault-9790/dataSources/dataSource-9790";
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
    mockService.addResponse(expectedResponse);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";
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
    mockService.addResponse(resultOperation);

    Backup backup =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Backup actualResponse = client.updateBackupAsync(backup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Backup backup =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupAsync(backup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    Backup actualResponse = client.deleteBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name =
          BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";

    Backup actualResponse = client.deleteBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupName name =
        BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");

    RestoreBackupResponse actualResponse = client.restoreBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restoreBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name =
          BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
      client.restoreBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";

    RestoreBackupResponse actualResponse = client.restoreBackupAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restoreBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4042/locations/location-4042/backupVaults/backupVault-4042/dataSources/dataSource-4042/backups/backup-4042";
      client.restoreBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupPlan backupPlan =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlan actualResponse = client.updateBackupPlanAsync(backupPlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlan backupPlan =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAsync(backupPlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlansExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlansExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(resultOperation);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    client.deleteBackupPlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";

    client.deleteBackupPlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupPlanRevisionName name =
        BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]");

    BackupPlanRevision actualResponse = client.getBackupPlanRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9582/locations/location-9582/backupPlans/backupPlan-9582/revisions/revision-9582";

    BackupPlanRevision actualResponse = client.getBackupPlanRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9582/locations/location-9582/backupPlans/backupPlan-9582/revisions/revision-9582";
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
    mockService.addResponse(expectedResponse);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    ListBackupPlanRevisionsPagedResponse pagedListResponse = client.listBackupPlanRevisions(parent);

    List<BackupPlanRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlanRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";

    ListBackupPlanRevisionsPagedResponse pagedListResponse = client.listBackupPlanRevisions(parent);

    List<BackupPlanRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlanRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
    String backupPlanAssociationId = "backupPlanAssociationId567762737";

    BackupPlanAssociation actualResponse =
        client
            .createBackupPlanAssociationAsync(
                parent, backupPlanAssociation, backupPlanAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanAssociationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
      String backupPlanAssociationId = "backupPlanAssociationId567762737";
      client
          .createBackupPlanAssociationAsync(parent, backupPlanAssociation, backupPlanAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
    String backupPlanAssociationId = "backupPlanAssociationId567762737";

    BackupPlanAssociation actualResponse =
        client
            .createBackupPlanAssociationAsync(
                parent, backupPlanAssociation, backupPlanAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanAssociationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
      String backupPlanAssociationId = "backupPlanAssociationId567762737";
      client
          .createBackupPlanAssociationAsync(parent, backupPlanAssociation, backupPlanAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupPlanAssociation backupPlanAssociation =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlanAssociation actualResponse =
        client.updateBackupPlanAssociationAsync(backupPlanAssociation, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupPlanAssociationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanAssociation backupPlanAssociation =
          BackupPlanAssociation.newBuilder()
              .setName(
                  BackupPlanAssociationName.of(
                          "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
                      .toString())
              .setResourceType("resourceType-384364440")
              .setResource("resource-341064690")
              .setBackupPlan(
                  BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllRulesConfigInfo(new ArrayList<RuleConfigInfo>())
              .setDataSource("dataSource1272470629")
              .setBackupPlanRevisionId("backupPlanRevisionId-222788415")
              .setBackupPlanRevisionName("backupPlanRevisionName648847537")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAssociationAsync(backupPlanAssociation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");

    BackupPlanAssociation actualResponse = client.getBackupPlanAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanAssociationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";

    BackupPlanAssociation actualResponse = client.getBackupPlanAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanAssociationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlanAssociationsPagedResponse pagedListResponse =
        client.listBackupPlanAssociations(parent);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlanAssociationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupPlanAssociationsPagedResponse pagedListResponse =
        client.listBackupPlanAssociations(parent);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlanAssociationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String resourceType = "resourceType-384364440";

    FetchBackupPlanAssociationsForResourceTypePagedResponse pagedListResponse =
        client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String resourceType = "resourceType-384364440";

    FetchBackupPlanAssociationsForResourceTypePagedResponse pagedListResponse =
        client.fetchBackupPlanAssociationsForResourceType(parent, resourceType);

    List<BackupPlanAssociation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlanAssociationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchBackupPlanAssociationsForResourceTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(resultOperation);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");

    client.deleteBackupPlanAssociationAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanAssociationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanAssociationName name =
          BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
      client.deleteBackupPlanAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";

    client.deleteBackupPlanAssociationAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanAssociationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";
      client.deleteBackupPlanAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupPlanAssociationName name =
        BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
    String ruleId = "ruleId-919875273";

    BackupPlanAssociation actualResponse = client.triggerBackupAsync(name, ruleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void triggerBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanAssociationName name =
          BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
      String ruleId = "ruleId-919875273";
      client.triggerBackupAsync(name, ruleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";
    String ruleId = "ruleId-919875273";

    BackupPlanAssociation actualResponse = client.triggerBackupAsync(name, ruleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void triggerBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2205/locations/location-2205/backupPlanAssociations/backupPlanAssociation-2205";
      String ruleId = "ruleId-919875273";
      client.triggerBackupAsync(name, ruleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    DataSourceReferenceName name =
        DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]");

    DataSourceReference actualResponse = client.getDataSourceReference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataSourceReferenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4429/locations/location-4429/dataSourceReferences/dataSourceReference-4429";

    DataSourceReference actualResponse = client.getDataSourceReference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataSourceReferenceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4429/locations/location-4429/dataSourceReferences/dataSourceReference-4429";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String resourceType = "resourceType-384364440";

    FetchDataSourceReferencesForResourceTypePagedResponse pagedListResponse =
        client.fetchDataSourceReferencesForResourceType(parent, resourceType);

    List<DataSourceReference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourceReferencesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String resourceType = "resourceType-384364440";

    FetchDataSourceReferencesForResourceTypePagedResponse pagedListResponse =
        client.fetchDataSourceReferencesForResourceType(parent, resourceType);

    List<DataSourceReference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourceReferencesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchDataSourceReferencesForResourceTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(resultOperation);

    InitializeServiceRequest request =
        InitializeServiceRequest.newBuilder()
            .setName("projects/project-6002/locations/location-6002/serviceConfig")
            .setResourceType("resourceType-384364440")
            .setRequestId("requestId693933066")
            .build();

    InitializeServiceResponse actualResponse = client.initializeServiceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void initializeServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InitializeServiceRequest request =
          InitializeServiceRequest.newBuilder()
              .setName("projects/project-6002/locations/location-6002/serviceConfig")
              .setResourceType("resourceType-384364440")
              .setRequestId("requestId693933066")
              .build();
      client.initializeServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
