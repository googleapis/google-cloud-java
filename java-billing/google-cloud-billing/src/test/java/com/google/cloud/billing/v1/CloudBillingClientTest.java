/*
 * Copyright 2020 Google LLC
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
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class CloudBillingClientTest {
  private static MockCloudBilling mockCloudBilling;
  private static MockServiceHelper mockServiceHelper;
  private CloudBillingClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudBilling = new MockCloudBilling();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudBilling));
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
  public void getBillingAccountTest() throws Exception {
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setOpen(true)
            .setDisplayName("displayName1714148973")
            .setMasterBillingAccount("masterBillingAccount1488941620")
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");

    BillingAccount actualResponse = client.getBillingAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBillingAccountRequest actualRequest = ((GetBillingAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.getBillingAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBillingAccountTest2() throws Exception {
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setOpen(true)
            .setDisplayName("displayName1714148973")
            .setMasterBillingAccount("masterBillingAccount1488941620")
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";

    BillingAccount actualResponse = client.getBillingAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBillingAccountRequest actualRequest = ((GetBillingAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBillingAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      client.getBillingAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBillingAccountsTest() throws Exception {
    BillingAccount responsesElement = BillingAccount.newBuilder().build();
    ListBillingAccountsResponse expectedResponse =
        ListBillingAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBillingAccounts(Arrays.asList(responsesElement))
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    ListBillingAccountsPagedResponse pagedListResponse = client.listBillingAccounts();

    List<BillingAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBillingAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBillingAccountsRequest actualRequest = ((ListBillingAccountsRequest) actualRequests.get(0));

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBillingAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      ListBillingAccountsRequest request =
          ListBillingAccountsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listBillingAccounts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBillingAccountTest() throws Exception {
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setOpen(true)
            .setDisplayName("displayName1714148973")
            .setMasterBillingAccount("masterBillingAccount1488941620")
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
    BillingAccount account = BillingAccount.newBuilder().build();

    BillingAccount actualResponse = client.updateBillingAccount(name, account);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBillingAccountRequest actualRequest =
        ((UpdateBillingAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(account, actualRequest.getAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
      BillingAccount account = BillingAccount.newBuilder().build();
      client.updateBillingAccount(name, account);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBillingAccountTest2() throws Exception {
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setOpen(true)
            .setDisplayName("displayName1714148973")
            .setMasterBillingAccount("masterBillingAccount1488941620")
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";
    BillingAccount account = BillingAccount.newBuilder().build();

    BillingAccount actualResponse = client.updateBillingAccount(name, account);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBillingAccountRequest actualRequest =
        ((UpdateBillingAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(account, actualRequest.getAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBillingAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      BillingAccount account = BillingAccount.newBuilder().build();
      client.updateBillingAccount(name, account);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBillingAccountTest() throws Exception {
    BillingAccount expectedResponse =
        BillingAccount.newBuilder()
            .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setOpen(true)
            .setDisplayName("displayName1714148973")
            .setMasterBillingAccount("masterBillingAccount1488941620")
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    BillingAccount billingAccount = BillingAccount.newBuilder().build();

    BillingAccount actualResponse = client.createBillingAccount(billingAccount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBillingAccountRequest actualRequest =
        ((CreateBillingAccountRequest) actualRequests.get(0));

    Assert.assertEquals(billingAccount, actualRequest.getBillingAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBillingAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccount billingAccount = BillingAccount.newBuilder().build();
      client.createBillingAccount(billingAccount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProjectBillingInfoTest() throws Exception {
    ProjectBillingInfo responsesElement = ProjectBillingInfo.newBuilder().build();
    ListProjectBillingInfoResponse expectedResponse =
        ListProjectBillingInfoResponse.newBuilder()
            .setNextPageToken("")
            .addAllProjectBillingInfo(Arrays.asList(responsesElement))
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
        ((ListProjectBillingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listProjectBillingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProjectBillingInfoTest2() throws Exception {
    ProjectBillingInfo responsesElement = ProjectBillingInfo.newBuilder().build();
    ListProjectBillingInfoResponse expectedResponse =
        ListProjectBillingInfoResponse.newBuilder()
            .setNextPageToken("")
            .addAllProjectBillingInfo(Arrays.asList(responsesElement))
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";

    ListProjectBillingInfoPagedResponse pagedListResponse = client.listProjectBillingInfo(name);

    List<ProjectBillingInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProjectBillingInfoList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProjectBillingInfoRequest actualRequest =
        ((ListProjectBillingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProjectBillingInfoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      client.listProjectBillingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectBillingInfoTest() throws Exception {
    ProjectBillingInfo expectedResponse =
        ProjectBillingInfo.newBuilder()
            .setName("name3373707")
            .setProjectId("projectId-894832108")
            .setBillingAccountName("billingAccountName929322205")
            .setBillingEnabled(true)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";

    ProjectBillingInfo actualResponse = client.getProjectBillingInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectBillingInfoRequest actualRequest =
        ((GetProjectBillingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      client.getProjectBillingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProjectBillingInfoTest() throws Exception {
    ProjectBillingInfo expectedResponse =
        ProjectBillingInfo.newBuilder()
            .setName("name3373707")
            .setProjectId("projectId-894832108")
            .setBillingAccountName("billingAccountName929322205")
            .setBillingEnabled(true)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String name = "name3373707";
    ProjectBillingInfo projectBillingInfo = ProjectBillingInfo.newBuilder().build();

    ProjectBillingInfo actualResponse = client.updateProjectBillingInfo(name, projectBillingInfo);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProjectBillingInfoRequest actualRequest =
        ((UpdateProjectBillingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(projectBillingInfo, actualRequest.getProjectBillingInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProjectBillingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBilling.addException(exception);

    try {
      String name = "name3373707";
      ProjectBillingInfo projectBillingInfo = ProjectBillingInfo.newBuilder().build();
      client.updateProjectBillingInfo(name, projectBillingInfo);
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudBilling.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

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
    mockCloudBilling.addResponse(expectedResponse);

    ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

    try {
      ResourceName resource = BillingAccountName.of("[BILLING_ACCOUNT]");
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
    mockCloudBilling.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBilling.getRequests();
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
    mockCloudBilling.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
