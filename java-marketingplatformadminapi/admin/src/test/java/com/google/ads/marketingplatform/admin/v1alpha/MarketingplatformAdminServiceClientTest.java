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

package com.google.ads.marketingplatform.admin.v1alpha;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAdminAccessBindingsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListOrganizationsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupMembersPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class MarketingplatformAdminServiceClientTest {
  private static MockMarketingplatformAdminService mockMarketingplatformAdminService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MarketingplatformAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMarketingplatformAdminService = new MockMarketingplatformAdminService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMarketingplatformAdminService));
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
    MarketingplatformAdminServiceSettings settings =
        MarketingplatformAdminServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MarketingplatformAdminServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOrganizationTest() throws Exception {
    Organization expectedResponse =
        Organization.newBuilder()
            .setName(OrganizationName.of("[ORGANIZATION]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    Organization actualResponse = client.getOrganization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationRequest actualRequest = ((GetOrganizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.getOrganization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationTest2() throws Exception {
    Organization expectedResponse =
        Organization.newBuilder()
            .setName(OrganizationName.of("[ORGANIZATION]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    Organization actualResponse = client.getOrganization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationRequest actualRequest = ((GetOrganizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getOrganization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrganizationsTest() throws Exception {
    Organization responsesElement = Organization.newBuilder().build();
    ListOrganizationsResponse expectedResponse =
        ListOrganizationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrganizations(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    ListOrganizationsRequest request =
        ListOrganizationsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListOrganizationsPagedResponse pagedListResponse = client.listOrganizations(request);

    List<Organization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrganizationsRequest actualRequest = ((ListOrganizationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrganizationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      ListOrganizationsRequest request =
          ListOrganizationsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listOrganizations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findSalesPartnerManagedClientsTest() throws Exception {
    FindSalesPartnerManagedClientsResponse expectedResponse =
        FindSalesPartnerManagedClientsResponse.newBuilder()
            .addAllClientData(new ArrayList<FindSalesPartnerManagedClientsResponse.ClientData>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    FindSalesPartnerManagedClientsRequest request =
        FindSalesPartnerManagedClientsRequest.newBuilder()
            .setOrganization(OrganizationName.of("[ORGANIZATION]").toString())
            .setIsActive(true)
            .build();

    FindSalesPartnerManagedClientsResponse actualResponse =
        client.findSalesPartnerManagedClients(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindSalesPartnerManagedClientsRequest actualRequest =
        ((FindSalesPartnerManagedClientsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getOrganization(), actualRequest.getOrganization());
    Assert.assertEquals(request.getIsActive(), actualRequest.getIsActive());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findSalesPartnerManagedClientsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      FindSalesPartnerManagedClientsRequest request =
          FindSalesPartnerManagedClientsRequest.newBuilder()
              .setOrganization(OrganizationName.of("[ORGANIZATION]").toString())
              .setIsActive(true)
              .build();
      client.findSalesPartnerManagedClients(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyticsAccountLinksTest() throws Exception {
    AnalyticsAccountLink responsesElement = AnalyticsAccountLink.newBuilder().build();
    ListAnalyticsAccountLinksResponse expectedResponse =
        ListAnalyticsAccountLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyticsAccountLinks(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyticsAccountLinksRequest actualRequest =
        ((ListAnalyticsAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyticsAccountLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listAnalyticsAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyticsAccountLinksTest2() throws Exception {
    AnalyticsAccountLink responsesElement = AnalyticsAccountLink.newBuilder().build();
    ListAnalyticsAccountLinksResponse expectedResponse =
        ListAnalyticsAccountLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyticsAccountLinks(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyticsAccountLinksRequest actualRequest =
        ((ListAnalyticsAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyticsAccountLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAnalyticsAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalyticsAccountLinkTest() throws Exception {
    AnalyticsAccountLink expectedResponse =
        AnalyticsAccountLink.newBuilder()
            .setName(
                AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
                    .toString())
            .setAnalyticsAccount("analyticsAccount-1287740473")
            .setDisplayName("displayName1714148973")
            .setLinkVerificationState(LinkVerificationState.forNumber(0))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalyticsAccountLinkRequest actualRequest =
        ((CreateAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalyticsAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
      client.createAnalyticsAccountLink(parent, analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalyticsAccountLinkTest2() throws Exception {
    AnalyticsAccountLink expectedResponse =
        AnalyticsAccountLink.newBuilder()
            .setName(
                AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
                    .toString())
            .setAnalyticsAccount("analyticsAccount-1287740473")
            .setDisplayName("displayName1714148973")
            .setLinkVerificationState(LinkVerificationState.forNumber(0))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalyticsAccountLinkRequest actualRequest =
        ((CreateAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalyticsAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
      client.createAnalyticsAccountLink(parent, analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalyticsAccountLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    AnalyticsAccountLinkName name =
        AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");

    client.deleteAnalyticsAccountLink(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalyticsAccountLinkRequest actualRequest =
        ((DeleteAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalyticsAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      AnalyticsAccountLinkName name =
          AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");
      client.deleteAnalyticsAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalyticsAccountLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnalyticsAccountLink(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalyticsAccountLinkRequest actualRequest =
        ((DeleteAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalyticsAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAnalyticsAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setPropertyServiceLevelTest() throws Exception {
    SetPropertyServiceLevelResponse expectedResponse =
        SetPropertyServiceLevelResponse.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String analyticsAccountLink = "analyticsAccountLink-397570975";

    SetPropertyServiceLevelResponse actualResponse =
        client.setPropertyServiceLevel(analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetPropertyServiceLevelRequest actualRequest =
        ((SetPropertyServiceLevelRequest) actualRequests.get(0));

    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setPropertyServiceLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String analyticsAccountLink = "analyticsAccountLink-397570975";
      client.setPropertyServiceLevel(analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportPropertyUsageTest() throws Exception {
    ReportPropertyUsageResponse expectedResponse =
        ReportPropertyUsageResponse.newBuilder()
            .addAllPropertyUsages(new ArrayList<ReportPropertyUsageResponse.PropertyUsage>())
            .setBillInfo(ReportPropertyUsageResponse.BillInfo.newBuilder().build())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String organization = "organization1178922291";

    ReportPropertyUsageResponse actualResponse = client.reportPropertyUsage(organization);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportPropertyUsageRequest actualRequest = ((ReportPropertyUsageRequest) actualRequests.get(0));

    Assert.assertEquals(organization, actualRequest.getOrganization());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportPropertyUsageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String organization = "organization1178922291";
      client.reportPropertyUsage(organization);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserGroupTest() throws Exception {
    UserGroup expectedResponse =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    UserGroup actualResponse = client.getUserGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserGroupRequest actualRequest = ((GetUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
      client.getUserGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserGroupTest2() throws Exception {
    UserGroup expectedResponse =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    UserGroup actualResponse = client.getUserGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserGroupRequest actualRequest = ((GetUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserGroupsTest() throws Exception {
    UserGroup responsesElement = UserGroup.newBuilder().build();
    ListUserGroupsResponse expectedResponse =
        ListUserGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserGroups(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListUserGroupsPagedResponse pagedListResponse = client.listUserGroups(parent);

    List<UserGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserGroupsRequest actualRequest = ((ListUserGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listUserGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserGroupsTest2() throws Exception {
    UserGroup responsesElement = UserGroup.newBuilder().build();
    ListUserGroupsResponse expectedResponse =
        ListUserGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserGroups(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserGroupsPagedResponse pagedListResponse = client.listUserGroups(parent);

    List<UserGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserGroupsRequest actualRequest = ((ListUserGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserGroupTest() throws Exception {
    UserGroup expectedResponse =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    UserGroup userGroup = UserGroup.newBuilder().build();

    UserGroup actualResponse = client.createUserGroup(parent, userGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserGroupRequest actualRequest = ((CreateUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userGroup, actualRequest.getUserGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      UserGroup userGroup = UserGroup.newBuilder().build();
      client.createUserGroup(parent, userGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserGroupTest2() throws Exception {
    UserGroup expectedResponse =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserGroup userGroup = UserGroup.newBuilder().build();

    UserGroup actualResponse = client.createUserGroup(parent, userGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserGroupRequest actualRequest = ((CreateUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userGroup, actualRequest.getUserGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      UserGroup userGroup = UserGroup.newBuilder().build();
      client.createUserGroup(parent, userGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserGroupTest() throws Exception {
    UserGroup expectedResponse =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroup userGroup = UserGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserGroup actualResponse = client.updateUserGroup(userGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserGroupRequest actualRequest = ((UpdateUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(userGroup, actualRequest.getUserGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroup userGroup = UserGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserGroup(userGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    client.deleteUserGroup(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserGroupRequest actualRequest = ((DeleteUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
      client.deleteUserGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserGroup(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserGroupRequest actualRequest = ((DeleteUserGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserGroupMemberTest() throws Exception {
    UserGroupMember expectedResponse =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupMemberName name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");

    UserGroupMember actualResponse = client.getUserGroupMember(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserGroupMemberRequest actualRequest = ((GetUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserGroupMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupMemberName name =
          UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");
      client.getUserGroupMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserGroupMemberTest2() throws Exception {
    UserGroupMember expectedResponse =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    UserGroupMember actualResponse = client.getUserGroupMember(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserGroupMemberRequest actualRequest = ((GetUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserGroupMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserGroupMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserGroupMembersTest() throws Exception {
    UserGroupMember responsesElement = UserGroupMember.newBuilder().build();
    ListUserGroupMembersResponse expectedResponse =
        ListUserGroupMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserGroupMembers(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    ListUserGroupMembersPagedResponse pagedListResponse = client.listUserGroupMembers(parent);

    List<UserGroupMember> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserGroupMembersRequest actualRequest =
        ((ListUserGroupMembersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserGroupMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
      client.listUserGroupMembers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserGroupMembersTest2() throws Exception {
    UserGroupMember responsesElement = UserGroupMember.newBuilder().build();
    ListUserGroupMembersResponse expectedResponse =
        ListUserGroupMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserGroupMembers(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserGroupMembersPagedResponse pagedListResponse = client.listUserGroupMembers(parent);

    List<UserGroupMember> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserGroupMembersRequest actualRequest =
        ((ListUserGroupMembersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserGroupMembersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserGroupMembers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserGroupMemberTest() throws Exception {
    UserGroupMember expectedResponse =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
    UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();

    UserGroupMember actualResponse = client.createUserGroupMember(parent, userGroupMember);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserGroupMemberRequest actualRequest =
        ((CreateUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userGroupMember, actualRequest.getUserGroupMember());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserGroupMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
      UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
      client.createUserGroupMember(parent, userGroupMember);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserGroupMemberTest2() throws Exception {
    UserGroupMember expectedResponse =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();

    UserGroupMember actualResponse = client.createUserGroupMember(parent, userGroupMember);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserGroupMemberRequest actualRequest =
        ((CreateUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userGroupMember, actualRequest.getUserGroupMember());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserGroupMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
      client.createUserGroupMember(parent, userGroupMember);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserGroupMemberTest() throws Exception {
    UserGroupMember expectedResponse =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserGroupMember actualResponse = client.updateUserGroupMember(userGroupMember, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserGroupMemberRequest actualRequest =
        ((UpdateUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(userGroupMember, actualRequest.getUserGroupMember());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserGroupMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserGroupMember(userGroupMember, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserGroupMemberTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    UserGroupMemberName name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");

    client.deleteUserGroupMember(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserGroupMemberRequest actualRequest =
        ((DeleteUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserGroupMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      UserGroupMemberName name =
          UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");
      client.deleteUserGroupMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserGroupMemberTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserGroupMember(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserGroupMemberRequest actualRequest =
        ((DeleteUserGroupMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserGroupMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserGroupMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdminAccessBindingTest() throws Exception {
    AdminAccessBinding expectedResponse =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    AdminAccessBindingName name =
        AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]");

    AdminAccessBinding actualResponse = client.getAdminAccessBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAdminAccessBindingRequest actualRequest =
        ((GetAdminAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAdminAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      AdminAccessBindingName name =
          AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]");
      client.getAdminAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdminAccessBindingTest2() throws Exception {
    AdminAccessBinding expectedResponse =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    AdminAccessBinding actualResponse = client.getAdminAccessBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAdminAccessBindingRequest actualRequest =
        ((GetAdminAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAdminAccessBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getAdminAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdminAccessBindingsTest() throws Exception {
    AdminAccessBinding responsesElement = AdminAccessBinding.newBuilder().build();
    ListAdminAccessBindingsResponse expectedResponse =
        ListAdminAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdminAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListAdminAccessBindingsPagedResponse pagedListResponse = client.listAdminAccessBindings(parent);

    List<AdminAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdminAccessBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAdminAccessBindingsRequest actualRequest =
        ((ListAdminAccessBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAdminAccessBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listAdminAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdminAccessBindingsTest2() throws Exception {
    AdminAccessBinding responsesElement = AdminAccessBinding.newBuilder().build();
    ListAdminAccessBindingsResponse expectedResponse =
        ListAdminAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdminAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAdminAccessBindingsPagedResponse pagedListResponse = client.listAdminAccessBindings(parent);

    List<AdminAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdminAccessBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAdminAccessBindingsRequest actualRequest =
        ((ListAdminAccessBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAdminAccessBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAdminAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdminAccessBindingTest() throws Exception {
    AdminAccessBinding expectedResponse =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();

    AdminAccessBinding actualResponse = client.createAdminAccessBinding(parent, adminAccessBinding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAdminAccessBindingRequest actualRequest =
        ((CreateAdminAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(adminAccessBinding, actualRequest.getAdminAccessBinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAdminAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
      client.createAdminAccessBinding(parent, adminAccessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdminAccessBindingTest2() throws Exception {
    AdminAccessBinding expectedResponse =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();

    AdminAccessBinding actualResponse = client.createAdminAccessBinding(parent, adminAccessBinding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAdminAccessBindingRequest actualRequest =
        ((CreateAdminAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(adminAccessBinding, actualRequest.getAdminAccessBinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAdminAccessBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
      client.createAdminAccessBinding(parent, adminAccessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAdminAccessBindingTest() throws Exception {
    AdminAccessBinding expectedResponse =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AdminAccessBinding actualResponse =
        client.updateAdminAccessBinding(adminAccessBinding, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAdminAccessBindingRequest actualRequest =
        ((UpdateAdminAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(adminAccessBinding, actualRequest.getAdminAccessBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAdminAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAdminAccessBinding(adminAccessBinding, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
