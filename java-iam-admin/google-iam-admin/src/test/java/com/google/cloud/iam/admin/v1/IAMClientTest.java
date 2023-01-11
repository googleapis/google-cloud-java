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

package com.google.cloud.iam.admin.v1;

import static com.google.cloud.iam.admin.v1.IAMClient.ListRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.ListServiceAccountsPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryGrantableRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryTestablePermissionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.admin.v1.CreateRoleRequest;
import com.google.iam.admin.v1.CreateServiceAccountKeyRequest;
import com.google.iam.admin.v1.CreateServiceAccountRequest;
import com.google.iam.admin.v1.DeleteRoleRequest;
import com.google.iam.admin.v1.DeleteServiceAccountKeyRequest;
import com.google.iam.admin.v1.DeleteServiceAccountRequest;
import com.google.iam.admin.v1.DisableServiceAccountKeyRequest;
import com.google.iam.admin.v1.DisableServiceAccountRequest;
import com.google.iam.admin.v1.EnableServiceAccountKeyRequest;
import com.google.iam.admin.v1.EnableServiceAccountRequest;
import com.google.iam.admin.v1.GetRoleRequest;
import com.google.iam.admin.v1.GetServiceAccountKeyRequest;
import com.google.iam.admin.v1.GetServiceAccountRequest;
import com.google.iam.admin.v1.KeyName;
import com.google.iam.admin.v1.LintPolicyRequest;
import com.google.iam.admin.v1.LintPolicyResponse;
import com.google.iam.admin.v1.LintResult;
import com.google.iam.admin.v1.ListRolesRequest;
import com.google.iam.admin.v1.ListRolesResponse;
import com.google.iam.admin.v1.ListServiceAccountKeysRequest;
import com.google.iam.admin.v1.ListServiceAccountKeysResponse;
import com.google.iam.admin.v1.ListServiceAccountsRequest;
import com.google.iam.admin.v1.ListServiceAccountsResponse;
import com.google.iam.admin.v1.PatchServiceAccountRequest;
import com.google.iam.admin.v1.Permission;
import com.google.iam.admin.v1.ProjectName;
import com.google.iam.admin.v1.QueryAuditableServicesRequest;
import com.google.iam.admin.v1.QueryAuditableServicesResponse;
import com.google.iam.admin.v1.QueryGrantableRolesRequest;
import com.google.iam.admin.v1.QueryGrantableRolesResponse;
import com.google.iam.admin.v1.QueryTestablePermissionsRequest;
import com.google.iam.admin.v1.QueryTestablePermissionsResponse;
import com.google.iam.admin.v1.Role;
import com.google.iam.admin.v1.RoleView;
import com.google.iam.admin.v1.ServiceAccount;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.ServiceAccountKeyAlgorithm;
import com.google.iam.admin.v1.ServiceAccountKeyOrigin;
import com.google.iam.admin.v1.ServiceAccountName;
import com.google.iam.admin.v1.ServiceAccountPrivateKeyType;
import com.google.iam.admin.v1.ServiceAccountPublicKeyType;
import com.google.iam.admin.v1.SignBlobRequest;
import com.google.iam.admin.v1.SignBlobResponse;
import com.google.iam.admin.v1.SignJwtRequest;
import com.google.iam.admin.v1.SignJwtResponse;
import com.google.iam.admin.v1.UndeleteRoleRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountResponse;
import com.google.iam.admin.v1.UpdateRoleRequest;
import com.google.iam.admin.v1.UploadServiceAccountKeyRequest;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class IAMClientTest {
  private static MockIAM mockIAM;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IAMClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIAM = new MockIAM();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIAM));
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
    IAMSettings settings =
        IAMSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IAMClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listServiceAccountsTest() throws Exception {
    ServiceAccount responsesElement = ServiceAccount.newBuilder().build();
    ListServiceAccountsResponse expectedResponse =
        ListServiceAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockIAM.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListServiceAccountsPagedResponse pagedListResponse = client.listServiceAccounts(name);

    List<ServiceAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceAccountsRequest actualRequest = ((ListServiceAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listServiceAccounts(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceAccountsTest2() throws Exception {
    ServiceAccount responsesElement = ServiceAccount.newBuilder().build();
    ListServiceAccountsResponse expectedResponse =
        ListServiceAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    ListServiceAccountsPagedResponse pagedListResponse = client.listServiceAccounts(name);

    List<ServiceAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceAccountsRequest actualRequest = ((ListServiceAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceAccountsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.listServiceAccounts(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");

    ServiceAccount actualResponse = client.getServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      client.getServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountTest2() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceAccount actualResponse = client.getServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    String accountId = "accountId-1827029976";
    ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();

    ServiceAccount actualResponse = client.createServiceAccount(name, accountId, serviceAccount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceAccountRequest actualRequest =
        ((CreateServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(accountId, actualRequest.getAccountId());
    Assert.assertEquals(serviceAccount, actualRequest.getServiceAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      String accountId = "accountId-1827029976";
      ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();
      client.createServiceAccount(name, accountId, serviceAccount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceAccountTest2() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    String accountId = "accountId-1827029976";
    ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();

    ServiceAccount actualResponse = client.createServiceAccount(name, accountId, serviceAccount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceAccountRequest actualRequest =
        ((CreateServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(accountId, actualRequest.getAccountId());
    Assert.assertEquals(serviceAccount, actualRequest.getServiceAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      String accountId = "accountId-1827029976";
      ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();
      client.createServiceAccount(name, accountId, serviceAccount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccount request =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();

    ServiceAccount actualResponse = client.updateServiceAccount(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ServiceAccount actualRequest = ((ServiceAccount) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getUniqueId(), actualRequest.getUniqueId());
    Assert.assertEquals(request.getEmail(), actualRequest.getEmail());
    Assert.assertEquals(request.getDisplayName(), actualRequest.getDisplayName());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertEquals(request.getDescription(), actualRequest.getDescription());
    Assert.assertEquals(request.getOauth2ClientId(), actualRequest.getOauth2ClientId());
    Assert.assertEquals(request.getDisabled(), actualRequest.getDisabled());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccount request =
          ServiceAccount.newBuilder()
              .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
              .setProjectId("projectId-894832108")
              .setUniqueId("uniqueId-294460212")
              .setEmail("email96619420")
              .setDisplayName("displayName1714148973")
              .setEtag(ByteString.EMPTY)
              .setDescription("description-1724546052")
              .setOauth2ClientId("oauth2ClientId-1210797087")
              .setDisabled(true)
              .build();
      client.updateServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void patchServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .setProjectId("projectId-894832108")
            .setUniqueId("uniqueId-294460212")
            .setEmail("email96619420")
            .setDisplayName("displayName1714148973")
            .setEtag(ByteString.EMPTY)
            .setDescription("description-1724546052")
            .setOauth2ClientId("oauth2ClientId-1210797087")
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    PatchServiceAccountRequest request =
        PatchServiceAccountRequest.newBuilder()
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    ServiceAccount actualResponse = client.patchServiceAccount(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchServiceAccountRequest actualRequest = ((PatchServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServiceAccount(), actualRequest.getServiceAccount());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void patchServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      PatchServiceAccountRequest request =
          PatchServiceAccountRequest.newBuilder()
              .setServiceAccount(ServiceAccount.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.patchServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");

    client.deleteServiceAccount(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceAccountRequest actualRequest =
        ((DeleteServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      client.deleteServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceAccountTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteServiceAccount(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceAccountRequest actualRequest =
        ((DeleteServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteServiceAccountTest() throws Exception {
    UndeleteServiceAccountResponse expectedResponse =
        UndeleteServiceAccountResponse.newBuilder()
            .setRestoredAccount(ServiceAccount.newBuilder().build())
            .build();
    mockIAM.addResponse(expectedResponse);

    UndeleteServiceAccountRequest request =
        UndeleteServiceAccountRequest.newBuilder().setName("name3373707").build();

    UndeleteServiceAccountResponse actualResponse = client.undeleteServiceAccount(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteServiceAccountRequest actualRequest =
        ((UndeleteServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      UndeleteServiceAccountRequest request =
          UndeleteServiceAccountRequest.newBuilder().setName("name3373707").build();
      client.undeleteServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableServiceAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    EnableServiceAccountRequest request =
        EnableServiceAccountRequest.newBuilder().setName("name3373707").build();

    client.enableServiceAccount(request);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableServiceAccountRequest actualRequest =
        ((EnableServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      EnableServiceAccountRequest request =
          EnableServiceAccountRequest.newBuilder().setName("name3373707").build();
      client.enableServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableServiceAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    DisableServiceAccountRequest request =
        DisableServiceAccountRequest.newBuilder().setName("name3373707").build();

    client.disableServiceAccount(request);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableServiceAccountRequest actualRequest =
        ((DisableServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      DisableServiceAccountRequest request =
          DisableServiceAccountRequest.newBuilder().setName("name3373707").build();
      client.disableServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceAccountKeysTest() throws Exception {
    ListServiceAccountKeysResponse expectedResponse =
        ListServiceAccountKeysResponse.newBuilder()
            .addAllKeys(new ArrayList<ServiceAccountKey>())
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();

    ListServiceAccountKeysResponse actualResponse = client.listServiceAccountKeys(name, keyTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceAccountKeysRequest actualRequest =
        ((ListServiceAccountKeysRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(keyTypes, actualRequest.getKeyTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceAccountKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();
      client.listServiceAccountKeys(name, keyTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceAccountKeysTest2() throws Exception {
    ListServiceAccountKeysResponse expectedResponse =
        ListServiceAccountKeysResponse.newBuilder()
            .addAllKeys(new ArrayList<ServiceAccountKey>())
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();

    ListServiceAccountKeysResponse actualResponse = client.listServiceAccountKeys(name, keyTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceAccountKeysRequest actualRequest =
        ((ListServiceAccountKeysRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(keyTypes, actualRequest.getKeyTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceAccountKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();
      client.listServiceAccountKeys(name, keyTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountKeyTest() throws Exception {
    ServiceAccountKey expectedResponse =
        ServiceAccountKey.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
            .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
            .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
            .setPrivateKeyData(ByteString.EMPTY)
            .setPublicKeyData(ByteString.EMPTY)
            .setValidAfterTime(Timestamp.newBuilder().build())
            .setValidBeforeTime(Timestamp.newBuilder().build())
            .setKeyOrigin(ServiceAccountKeyOrigin.forNumber(0))
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
    ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);

    ServiceAccountKey actualResponse = client.getServiceAccountKey(name, publicKeyType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountKeyRequest actualRequest =
        ((GetServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(publicKeyType, actualRequest.getPublicKeyType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
      ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);
      client.getServiceAccountKey(name, publicKeyType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountKeyTest2() throws Exception {
    ServiceAccountKey expectedResponse =
        ServiceAccountKey.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
            .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
            .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
            .setPrivateKeyData(ByteString.EMPTY)
            .setPublicKeyData(ByteString.EMPTY)
            .setValidAfterTime(Timestamp.newBuilder().build())
            .setValidBeforeTime(Timestamp.newBuilder().build())
            .setKeyOrigin(ServiceAccountKeyOrigin.forNumber(0))
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);

    ServiceAccountKey actualResponse = client.getServiceAccountKey(name, publicKeyType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountKeyRequest actualRequest =
        ((GetServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(publicKeyType, actualRequest.getPublicKeyType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);
      client.getServiceAccountKey(name, publicKeyType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceAccountKeyTest() throws Exception {
    ServiceAccountKey expectedResponse =
        ServiceAccountKey.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
            .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
            .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
            .setPrivateKeyData(ByteString.EMPTY)
            .setPublicKeyData(ByteString.EMPTY)
            .setValidAfterTime(Timestamp.newBuilder().build())
            .setValidBeforeTime(Timestamp.newBuilder().build())
            .setKeyOrigin(ServiceAccountKeyOrigin.forNumber(0))
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
    ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);

    ServiceAccountKey actualResponse =
        client.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceAccountKeyRequest actualRequest =
        ((CreateServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(privateKeyType, actualRequest.getPrivateKeyType());
    Assert.assertEquals(keyAlgorithm, actualRequest.getKeyAlgorithm());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
      ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);
      client.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceAccountKeyTest2() throws Exception {
    ServiceAccountKey expectedResponse =
        ServiceAccountKey.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
            .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
            .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
            .setPrivateKeyData(ByteString.EMPTY)
            .setPublicKeyData(ByteString.EMPTY)
            .setValidAfterTime(Timestamp.newBuilder().build())
            .setValidBeforeTime(Timestamp.newBuilder().build())
            .setKeyOrigin(ServiceAccountKeyOrigin.forNumber(0))
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
    ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);

    ServiceAccountKey actualResponse =
        client.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceAccountKeyRequest actualRequest =
        ((CreateServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(privateKeyType, actualRequest.getPrivateKeyType());
    Assert.assertEquals(keyAlgorithm, actualRequest.getKeyAlgorithm());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
      ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);
      client.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uploadServiceAccountKeyTest() throws Exception {
    ServiceAccountKey expectedResponse =
        ServiceAccountKey.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
            .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
            .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
            .setPrivateKeyData(ByteString.EMPTY)
            .setPublicKeyData(ByteString.EMPTY)
            .setValidAfterTime(Timestamp.newBuilder().build())
            .setValidBeforeTime(Timestamp.newBuilder().build())
            .setKeyOrigin(ServiceAccountKeyOrigin.forNumber(0))
            .setDisabled(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    UploadServiceAccountKeyRequest request =
        UploadServiceAccountKeyRequest.newBuilder()
            .setName("name3373707")
            .setPublicKeyData(ByteString.EMPTY)
            .build();

    ServiceAccountKey actualResponse = client.uploadServiceAccountKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadServiceAccountKeyRequest actualRequest =
        ((UploadServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPublicKeyData(), actualRequest.getPublicKeyData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      UploadServiceAccountKeyRequest request =
          UploadServiceAccountKeyRequest.newBuilder()
              .setName("name3373707")
              .setPublicKeyData(ByteString.EMPTY)
              .build();
      client.uploadServiceAccountKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceAccountKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");

    client.deleteServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceAccountKeyRequest actualRequest =
        ((DeleteServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
      client.deleteServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceAccountKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceAccountKeyRequest actualRequest =
        ((DeleteServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableServiceAccountKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");

    client.disableServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableServiceAccountKeyRequest actualRequest =
        ((DisableServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
      client.disableServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableServiceAccountKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    client.disableServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableServiceAccountKeyRequest actualRequest =
        ((DisableServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableServiceAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.disableServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableServiceAccountKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");

    client.enableServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableServiceAccountKeyRequest actualRequest =
        ((EnableServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableServiceAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
      client.enableServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableServiceAccountKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";

    client.enableServiceAccountKey(name);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableServiceAccountKeyRequest actualRequest =
        ((EnableServiceAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableServiceAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      client.enableServiceAccountKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signBlobTest() throws Exception {
    SignBlobResponse expectedResponse =
        SignBlobResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignature(ByteString.EMPTY)
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    ByteString bytesToSign = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, bytesToSign);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignBlobRequest actualRequest = ((SignBlobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(bytesToSign, actualRequest.getBytesToSign());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signBlobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      ByteString bytesToSign = ByteString.EMPTY;
      client.signBlob(name, bytesToSign);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signBlobTest2() throws Exception {
    SignBlobResponse expectedResponse =
        SignBlobResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignature(ByteString.EMPTY)
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    ByteString bytesToSign = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, bytesToSign);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignBlobRequest actualRequest = ((SignBlobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(bytesToSign, actualRequest.getBytesToSign());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signBlobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      ByteString bytesToSign = ByteString.EMPTY;
      client.signBlob(name, bytesToSign);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signJwtTest() throws Exception {
    SignJwtResponse expectedResponse =
        SignJwtResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedJwt("signedJwt1076760587")
            .build();
    mockIAM.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignJwtRequest actualRequest = ((SignJwtRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signJwtExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      String payload = "payload-786701938";
      client.signJwt(name, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signJwtTest2() throws Exception {
    SignJwtResponse expectedResponse =
        SignJwtResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedJwt("signedJwt1076760587")
            .build();
    mockIAM.addResponse(expectedResponse);

    String name = "name3373707";
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignJwtRequest actualRequest = ((SignJwtRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signJwtExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String name = "name3373707";
      String payload = "payload-786701938";
      client.signJwt(name, payload);
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
    mockIAM.addResponse(expectedResponse);

    ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAM.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
    mockIAM.addResponse(expectedResponse);

    ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAM.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAM.addResponse(expectedResponse);

    ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAM.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryGrantableRolesTest() throws Exception {
    Role responsesElement = Role.newBuilder().build();
    QueryGrantableRolesResponse expectedResponse =
        QueryGrantableRolesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoles(Arrays.asList(responsesElement))
            .build();
    mockIAM.addResponse(expectedResponse);

    String fullResourceName = "fullResourceName-853732376";

    QueryGrantableRolesPagedResponse pagedListResponse =
        client.queryGrantableRoles(fullResourceName);

    List<Role> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryGrantableRolesRequest actualRequest = ((QueryGrantableRolesRequest) actualRequests.get(0));

    Assert.assertEquals(fullResourceName, actualRequest.getFullResourceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryGrantableRolesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      String fullResourceName = "fullResourceName-853732376";
      client.queryGrantableRoles(fullResourceName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolesTest() throws Exception {
    Role responsesElement = Role.newBuilder().build();
    ListRolesResponse expectedResponse =
        ListRolesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoles(Arrays.asList(responsesElement))
            .build();
    mockIAM.addResponse(expectedResponse);

    ListRolesRequest request =
        ListRolesRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setView(RoleView.forNumber(0))
            .setShowDeleted(true)
            .build();

    ListRolesPagedResponse pagedListResponse = client.listRoles(request);

    List<Role> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolesRequest actualRequest = ((ListRolesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getShowDeleted(), actualRequest.getShowDeleted());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      ListRolesRequest request =
          ListRolesRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(RoleView.forNumber(0))
              .setShowDeleted(true)
              .build();
      client.listRoles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRoleTest() throws Exception {
    Role expectedResponse =
        Role.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllIncludedPermissions(new ArrayList<String>())
            .setEtag(ByteString.EMPTY)
            .setDeleted(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    GetRoleRequest request =
        GetRoleRequest.newBuilder().setName("GetRoleRequest84528163".toString()).build();

    Role actualResponse = client.getRole(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRoleRequest actualRequest = ((GetRoleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRoleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      GetRoleRequest request =
          GetRoleRequest.newBuilder().setName("GetRoleRequest84528163".toString()).build();
      client.getRole(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRoleTest() throws Exception {
    Role expectedResponse =
        Role.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllIncludedPermissions(new ArrayList<String>())
            .setEtag(ByteString.EMPTY)
            .setDeleted(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    CreateRoleRequest request =
        CreateRoleRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setRoleId("roleId-925416399")
            .setRole(Role.newBuilder().build())
            .build();

    Role actualResponse = client.createRole(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRoleRequest actualRequest = ((CreateRoleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRoleId(), actualRequest.getRoleId());
    Assert.assertEquals(request.getRole(), actualRequest.getRole());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRoleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      CreateRoleRequest request =
          CreateRoleRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setRoleId("roleId-925416399")
              .setRole(Role.newBuilder().build())
              .build();
      client.createRole(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRoleTest() throws Exception {
    Role expectedResponse =
        Role.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllIncludedPermissions(new ArrayList<String>())
            .setEtag(ByteString.EMPTY)
            .setDeleted(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    UpdateRoleRequest request =
        UpdateRoleRequest.newBuilder()
            .setName("UpdateRoleRequest230834320".toString())
            .setRole(Role.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Role actualResponse = client.updateRole(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRoleRequest actualRequest = ((UpdateRoleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRole(), actualRequest.getRole());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRoleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      UpdateRoleRequest request =
          UpdateRoleRequest.newBuilder()
              .setName("UpdateRoleRequest230834320".toString())
              .setRole(Role.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateRole(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRoleTest() throws Exception {
    Role expectedResponse =
        Role.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllIncludedPermissions(new ArrayList<String>())
            .setEtag(ByteString.EMPTY)
            .setDeleted(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    DeleteRoleRequest request =
        DeleteRoleRequest.newBuilder()
            .setName("DeleteRoleRequest1468559982".toString())
            .setEtag(ByteString.EMPTY)
            .build();

    Role actualResponse = client.deleteRole(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRoleRequest actualRequest = ((DeleteRoleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRoleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      DeleteRoleRequest request =
          DeleteRoleRequest.newBuilder()
              .setName("DeleteRoleRequest1468559982".toString())
              .setEtag(ByteString.EMPTY)
              .build();
      client.deleteRole(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteRoleTest() throws Exception {
    Role expectedResponse =
        Role.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllIncludedPermissions(new ArrayList<String>())
            .setEtag(ByteString.EMPTY)
            .setDeleted(true)
            .build();
    mockIAM.addResponse(expectedResponse);

    UndeleteRoleRequest request =
        UndeleteRoleRequest.newBuilder()
            .setName("UndeleteRoleRequest755355893".toString())
            .setEtag(ByteString.EMPTY)
            .build();

    Role actualResponse = client.undeleteRole(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteRoleRequest actualRequest = ((UndeleteRoleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteRoleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      UndeleteRoleRequest request =
          UndeleteRoleRequest.newBuilder()
              .setName("UndeleteRoleRequest755355893".toString())
              .setEtag(ByteString.EMPTY)
              .build();
      client.undeleteRole(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryTestablePermissionsTest() throws Exception {
    Permission responsesElement = Permission.newBuilder().build();
    QueryTestablePermissionsResponse expectedResponse =
        QueryTestablePermissionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPermissions(Arrays.asList(responsesElement))
            .build();
    mockIAM.addResponse(expectedResponse);

    QueryTestablePermissionsRequest request =
        QueryTestablePermissionsRequest.newBuilder()
            .setFullResourceName("fullResourceName-853732376")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryTestablePermissionsPagedResponse pagedListResponse =
        client.queryTestablePermissions(request);

    List<Permission> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPermissionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryTestablePermissionsRequest actualRequest =
        ((QueryTestablePermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFullResourceName(), actualRequest.getFullResourceName());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryTestablePermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      QueryTestablePermissionsRequest request =
          QueryTestablePermissionsRequest.newBuilder()
              .setFullResourceName("fullResourceName-853732376")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryTestablePermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryAuditableServicesTest() throws Exception {
    QueryAuditableServicesResponse expectedResponse =
        QueryAuditableServicesResponse.newBuilder()
            .addAllServices(new ArrayList<QueryAuditableServicesResponse.AuditableService>())
            .build();
    mockIAM.addResponse(expectedResponse);

    QueryAuditableServicesRequest request =
        QueryAuditableServicesRequest.newBuilder()
            .setFullResourceName("fullResourceName-853732376")
            .build();

    QueryAuditableServicesResponse actualResponse = client.queryAuditableServices(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryAuditableServicesRequest actualRequest =
        ((QueryAuditableServicesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFullResourceName(), actualRequest.getFullResourceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryAuditableServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      QueryAuditableServicesRequest request =
          QueryAuditableServicesRequest.newBuilder()
              .setFullResourceName("fullResourceName-853732376")
              .build();
      client.queryAuditableServices(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lintPolicyTest() throws Exception {
    LintPolicyResponse expectedResponse =
        LintPolicyResponse.newBuilder().addAllLintResults(new ArrayList<LintResult>()).build();
    mockIAM.addResponse(expectedResponse);

    LintPolicyRequest request =
        LintPolicyRequest.newBuilder().setFullResourceName("fullResourceName-853732376").build();

    LintPolicyResponse actualResponse = client.lintPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAM.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LintPolicyRequest actualRequest = ((LintPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFullResourceName(), actualRequest.getFullResourceName());
    Assert.assertEquals(request.getCondition(), actualRequest.getCondition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lintPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAM.addException(exception);

    try {
      LintPolicyRequest request =
          LintPolicyRequest.newBuilder().setFullResourceName("fullResourceName-853732376").build();
      client.lintPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
