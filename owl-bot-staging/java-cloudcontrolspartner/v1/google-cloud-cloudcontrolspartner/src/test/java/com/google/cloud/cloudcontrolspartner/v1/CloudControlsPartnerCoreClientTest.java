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

package com.google.cloud.cloudcontrolspartner.v1;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class CloudControlsPartnerCoreClientTest {
  private static MockCloudControlsPartnerCore mockCloudControlsPartnerCore;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudControlsPartnerCoreClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudControlsPartnerCore = new MockCloudControlsPartnerCore();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudControlsPartnerCore));
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
    CloudControlsPartnerCoreSettings settings =
        CloudControlsPartnerCoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudControlsPartnerCoreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .setFolderId(527488652)
            .setCreateTime(Timestamp.newBuilder().build())
            .setFolder("folder-1268966290")
            .setWorkloadOnboardingState(WorkloadOnboardingState.newBuilder().build())
            .setIsOnboarded(true)
            .setKeyManagementProjectId("keyManagementProjectId-288019406")
            .setLocation("location1901043637")
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      WorkloadName name =
          WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadTest2() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .setFolderId(527488652)
            .setCreateTime(Timestamp.newBuilder().build())
            .setFolder("folder-1268966290")
            .setWorkloadOnboardingState(WorkloadOnboardingState.newBuilder().build())
            .setIsOnboarded(true)
            .setKeyManagementProjectId("keyManagementProjectId-288019406")
            .setLocation("location1901043637")
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String name = "name3373707";

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    CustomerName parent = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      CustomerName parent = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest2() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
            .setDisplayName("displayName1714148973")
            .setCustomerOnboardingState(CustomerOnboardingState.newBuilder().build())
            .setIsOnboarded(true)
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    CustomerName name = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");

    Customer actualResponse = client.getCustomer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRequest actualRequest = ((GetCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      CustomerName name = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");
      client.getCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerTest2() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
            .setDisplayName("displayName1714148973")
            .setCustomerOnboardingState(CustomerOnboardingState.newBuilder().build())
            .setIsOnboarded(true)
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String name = "name3373707";

    Customer actualResponse = client.getCustomer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRequest actualRequest = ((GetCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomersTest() throws Exception {
    Customer responsesElement = Customer.newBuilder().build();
    ListCustomersResponse expectedResponse =
        ListCustomersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomers(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListCustomersPagedResponse pagedListResponse = client.listCustomers(parent);

    List<Customer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomersRequest actualRequest = ((ListCustomersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listCustomers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomersTest2() throws Exception {
    Customer responsesElement = Customer.newBuilder().build();
    ListCustomersResponse expectedResponse =
        ListCustomersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomers(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomersPagedResponse pagedListResponse = client.listCustomers(parent);

    List<Customer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomersRequest actualRequest = ((ListCustomersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEkmConnectionsTest() throws Exception {
    EkmConnections expectedResponse =
        EkmConnections.newBuilder()
            .setName(
                EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .addAllEkmConnections(new ArrayList<EkmConnection>())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    EkmConnectionsName name =
        EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");

    EkmConnections actualResponse = client.getEkmConnections(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEkmConnectionsRequest actualRequest = ((GetEkmConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEkmConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      EkmConnectionsName name =
          EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
      client.getEkmConnections(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEkmConnectionsTest2() throws Exception {
    EkmConnections expectedResponse =
        EkmConnections.newBuilder()
            .setName(
                EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .addAllEkmConnections(new ArrayList<EkmConnection>())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String name = "name3373707";

    EkmConnections actualResponse = client.getEkmConnections(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEkmConnectionsRequest actualRequest = ((GetEkmConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEkmConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String name = "name3373707";
      client.getEkmConnections(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartnerPermissionsTest() throws Exception {
    PartnerPermissions expectedResponse =
        PartnerPermissions.newBuilder()
            .setName(
                PartnerPermissionsName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .addAllPartnerPermissions(new ArrayList<PartnerPermissions.Permission>())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    PartnerPermissionsName name =
        PartnerPermissionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");

    PartnerPermissions actualResponse = client.getPartnerPermissions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartnerPermissionsRequest actualRequest =
        ((GetPartnerPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartnerPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      PartnerPermissionsName name =
          PartnerPermissionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
      client.getPartnerPermissions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartnerPermissionsTest2() throws Exception {
    PartnerPermissions expectedResponse =
        PartnerPermissions.newBuilder()
            .setName(
                PartnerPermissionsName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                    .toString())
            .addAllPartnerPermissions(new ArrayList<PartnerPermissions.Permission>())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String name = "name3373707";

    PartnerPermissions actualResponse = client.getPartnerPermissions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartnerPermissionsRequest actualRequest =
        ((GetPartnerPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartnerPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String name = "name3373707";
      client.getPartnerPermissions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessApprovalRequestsTest() throws Exception {
    AccessApprovalRequest responsesElement = AccessApprovalRequest.newBuilder().build();
    ListAccessApprovalRequestsResponse expectedResponse =
        ListAccessApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    WorkloadName parent =
        WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");

    ListAccessApprovalRequestsPagedResponse pagedListResponse =
        client.listAccessApprovalRequests(parent);

    List<AccessApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessApprovalRequestsRequest actualRequest =
        ((ListAccessApprovalRequestsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessApprovalRequestsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      WorkloadName parent =
          WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
      client.listAccessApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessApprovalRequestsTest2() throws Exception {
    AccessApprovalRequest responsesElement = AccessApprovalRequest.newBuilder().build();
    ListAccessApprovalRequestsResponse expectedResponse =
        ListAccessApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccessApprovalRequestsPagedResponse pagedListResponse =
        client.listAccessApprovalRequests(parent);

    List<AccessApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessApprovalRequestsRequest actualRequest =
        ((ListAccessApprovalRequestsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessApprovalRequestsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccessApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartnerTest() throws Exception {
    Partner expectedResponse =
        Partner.newBuilder()
            .setName(PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString())
            .addAllSkus(new ArrayList<Sku>())
            .addAllEkmSolutions(new ArrayList<EkmMetadata>())
            .addAllOperatedCloudRegions(new ArrayList<String>())
            .setPartnerProjectId("partnerProjectId2071402028")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    PartnerName name = PartnerName.of("[ORGANIZATION]", "[LOCATION]");

    Partner actualResponse = client.getPartner(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartnerRequest actualRequest = ((GetPartnerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartnerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      PartnerName name = PartnerName.of("[ORGANIZATION]", "[LOCATION]");
      client.getPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartnerTest2() throws Exception {
    Partner expectedResponse =
        Partner.newBuilder()
            .setName(PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString())
            .addAllSkus(new ArrayList<Sku>())
            .addAllEkmSolutions(new ArrayList<EkmMetadata>())
            .addAllOperatedCloudRegions(new ArrayList<String>())
            .setPartnerProjectId("partnerProjectId2071402028")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudControlsPartnerCore.addResponse(expectedResponse);

    String name = "name3373707";

    Partner actualResponse = client.getPartner(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerCore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartnerRequest actualRequest = ((GetPartnerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartnerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerCore.addException(exception);

    try {
      String name = "name3373707";
      client.getPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
