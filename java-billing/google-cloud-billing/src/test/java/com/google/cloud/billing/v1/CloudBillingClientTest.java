/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.billing.v1;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CloudBillingClientTest {
  private static MockCloudBilling mockCloudBilling;
  private static MockCloudCatalog mockCloudCatalog;
  private static MockServiceHelper serviceHelper;
  private CloudBillingClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudBilling = new MockCloudBilling();
    mockCloudCatalog = new MockCloudCatalog();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudBilling, mockCloudCatalog));
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
    CloudBillingSettings settings =
        CloudBillingSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudBillingClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getBillingAccountTest() {
    BillingAccountName name2 = BillingAccountName.of("[BILLING_ACCOUNT]");
    boolean open = true;
    String displayName = "displayName1615086568";
    String masterBillingAccount = "masterBillingAccount1503143052";
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(name2.toString())
            .setOpen(open)
            .setDisplayName(displayName)
            .setMasterBillingAccount(masterBillingAccount)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");

    BillingAccount actualResponse = client.getBillingAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBillingAccountRequest actualRequest = (GetBillingAccountRequest) actualRequests.get(0);

    Assert.assertEquals(name, BillingAccountName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");

      client.getBillingAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBillingAccountsTest() {
    String nextPageToken = "";
    BillingAccount billingAccountsElement = BillingAccount.newBuilder().build();
    List<BillingAccount> billingAccounts = Arrays.asList(billingAccountsElement);
    ListBillingAccountsResponse expectedResponse =
        ListBillingAccountsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllBillingAccounts(billingAccounts)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    ListBillingAccountsPagedResponse pagedListResponse = client.listBillingAccounts();

    List<BillingAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBillingAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBillingAccountsRequest actualRequest = (ListBillingAccountsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBillingAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      client.listBillingAccounts();
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBillingAccountTest() {
    BillingAccountName name2 = BillingAccountName.of("[BILLING_ACCOUNT]");
    boolean open = true;
    String displayName = "displayName1615086568";
    String masterBillingAccount = "masterBillingAccount1503143052";
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(name2.toString())
            .setOpen(open)
            .setDisplayName(displayName)
            .setMasterBillingAccount(masterBillingAccount)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
    BillingAccount account = BillingAccount.newBuilder().build();

    BillingAccount actualResponse = client.updateBillingAccount(name, account);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBillingAccountRequest actualRequest = (UpdateBillingAccountRequest) actualRequests.get(0);

    Assert.assertEquals(name, BillingAccountName.parse(actualRequest.getName()));
    Assert.assertEquals(account, actualRequest.getAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
      BillingAccount account = BillingAccount.newBuilder().build();

      client.updateBillingAccount(name, account);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createBillingAccountTest() {
    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
    boolean open = true;
    String displayName = "displayName1615086568";
    String masterBillingAccount = "masterBillingAccount1503143052";
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(name.toString())
            .setOpen(open)
            .setDisplayName(displayName)
            .setMasterBillingAccount(masterBillingAccount)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccount billingAccount = BillingAccount.newBuilder().build();

    BillingAccount actualResponse = client.createBillingAccount(billingAccount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBillingAccountRequest actualRequest = (CreateBillingAccountRequest) actualRequests.get(0);

    Assert.assertEquals(billingAccount, actualRequest.getBillingAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccount billingAccount = BillingAccount.newBuilder().build();

      client.createBillingAccount(billingAccount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listProjectBillingInfoTest() {
    String nextPageToken = "";
    ProjectBillingInfo projectBillingInfoElement = ProjectBillingInfo.newBuilder().build();
    List<ProjectBillingInfo> projectBillingInfo = Arrays.asList(projectBillingInfoElement);
    ListProjectBillingInfoResponse expectedResponse =
        ListProjectBillingInfoResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProjectBillingInfo(projectBillingInfo)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListProjectBillingInfoPagedResponse pagedListResponse = client.listProjectBillingInfo(name);

    List<ProjectBillingInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProjectBillingInfoList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProjectBillingInfoRequest actualRequest =
        (ListProjectBillingInfoRequest) actualRequests.get(0);

    Assert.assertEquals(name, BillingAccountName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");

      client.listProjectBillingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getProjectBillingInfoTest() {
    String name2 = "name2-1052831874";
    String projectId = "projectId-1969970175";
    String billingAccountName = "billingAccountName-1056086879";
    boolean billingEnabled = false;
    ProjectBillingInfo expectedResponse =
        ProjectBillingInfo.newBuilder()
            .setName(name2)
            .setProjectId(projectId)
            .setBillingAccountName(billingAccountName)
            .setBillingEnabled(billingEnabled)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";

    ProjectBillingInfo actualResponse = client.getProjectBillingInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectBillingInfoRequest actualRequest =
        (GetProjectBillingInfoRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";

      client.getProjectBillingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateProjectBillingInfoTest() {
    String name2 = "name2-1052831874";
    String projectId = "projectId-1969970175";
    String billingAccountName = "billingAccountName-1056086879";
    boolean billingEnabled = false;
    ProjectBillingInfo expectedResponse =
        ProjectBillingInfo.newBuilder()
            .setName(name2)
            .setProjectId(projectId)
            .setBillingAccountName(billingAccountName)
            .setBillingEnabled(billingEnabled)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";
    ProjectBillingInfo projectBillingInfo = ProjectBillingInfo.newBuilder().build();

    ProjectBillingInfo actualResponse = client.updateProjectBillingInfo(name, projectBillingInfo);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProjectBillingInfoRequest actualRequest =
        (UpdateProjectBillingInfoRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(projectBillingInfo, actualRequest.getProjectBillingInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      ProjectBillingInfo projectBillingInfo = ProjectBillingInfo.newBuilder().build();

      client.updateProjectBillingInfo(name, projectBillingInfo);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");

      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
