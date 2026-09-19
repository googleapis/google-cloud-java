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

import com.google.ads.marketingplatform.admin.v1alpha.stub.HttpJsonMarketingplatformAdminServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MarketingplatformAdminServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MarketingplatformAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMarketingplatformAdminServiceStub.getMethodDescriptors(),
            MarketingplatformAdminServiceSettings.getDefaultEndpoint());
    MarketingplatformAdminServiceSettings settings =
        MarketingplatformAdminServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MarketingplatformAdminServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MarketingplatformAdminServiceClient.create(settings);
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
  public void getOrganizationTest() throws Exception {
    Organization expectedResponse =
        Organization.newBuilder()
            .setName(OrganizationName.of("[ORGANIZATION]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    Organization actualResponse = client.getOrganization(name);
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
  public void getOrganizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-1936";

    Organization actualResponse = client.getOrganization(name);
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
  public void getOrganizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-1936";
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
    mockService.addResponse(expectedResponse);

    ListOrganizationsRequest request =
        ListOrganizationsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListOrganizationsPagedResponse pagedListResponse = client.listOrganizations(request);

    List<Organization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationsList().get(0), resources.get(0));

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
  public void listOrganizationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    FindSalesPartnerManagedClientsRequest request =
        FindSalesPartnerManagedClientsRequest.newBuilder()
            .setOrganization(OrganizationName.of("[ORGANIZATION]").toString())
            .setIsActive(true)
            .build();

    FindSalesPartnerManagedClientsResponse actualResponse =
        client.findSalesPartnerManagedClients(request);
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
  public void findSalesPartnerManagedClientsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

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
  public void listAnalyticsAccountLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

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
  public void listAnalyticsAccountLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
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
  public void createAnalyticsAccountLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
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
  public void createAnalyticsAccountLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    AnalyticsAccountLinkName name =
        AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");

    client.deleteAnalyticsAccountLink(name);

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
  public void deleteAnalyticsAccountLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-3502/analyticsAccountLinks/analyticsAccountLink-3502";

    client.deleteAnalyticsAccountLink(name);

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
  public void deleteAnalyticsAccountLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-3502/analyticsAccountLinks/analyticsAccountLink-3502";
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
    mockService.addResponse(expectedResponse);

    String analyticsAccountLink =
        "organizations/organization-2696/analyticsAccountLinks/analyticsAccountLink-2696";

    SetPropertyServiceLevelResponse actualResponse =
        client.setPropertyServiceLevel(analyticsAccountLink);
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
  public void setPropertyServiceLevelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String analyticsAccountLink =
          "organizations/organization-2696/analyticsAccountLinks/analyticsAccountLink-2696";
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
    mockService.addResponse(expectedResponse);

    String organization = "organizations/organization-2552";

    ReportPropertyUsageResponse actualResponse = client.reportPropertyUsage(organization);
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
  public void reportPropertyUsageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String organization = "organizations/organization-2552";
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
    mockService.addResponse(expectedResponse);

    UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    UserGroup actualResponse = client.getUserGroup(name);
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
  public void getUserGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-5401/userGroups/userGroup-5401";

    UserGroup actualResponse = client.getUserGroup(name);
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
  public void getUserGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-5401/userGroups/userGroup-5401";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListUserGroupsPagedResponse pagedListResponse = client.listUserGroups(parent);

    List<UserGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupsList().get(0), resources.get(0));

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
  public void listUserGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListUserGroupsPagedResponse pagedListResponse = client.listUserGroups(parent);

    List<UserGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupsList().get(0), resources.get(0));

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
  public void listUserGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    UserGroup userGroup = UserGroup.newBuilder().build();

    UserGroup actualResponse = client.createUserGroup(parent, userGroup);
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
  public void createUserGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    UserGroup userGroup = UserGroup.newBuilder().build();

    UserGroup actualResponse = client.createUserGroup(parent, userGroup);
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
  public void createUserGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    UserGroup userGroup =
        UserGroup.newBuilder()
            .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserGroup actualResponse = client.updateUserGroup(userGroup, updateMask);
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
  public void updateUserGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserGroup userGroup =
          UserGroup.newBuilder()
              .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .build();
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
    mockService.addResponse(expectedResponse);

    UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    client.deleteUserGroup(name);

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
  public void deleteUserGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-5401/userGroups/userGroup-5401";

    client.deleteUserGroup(name);

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
  public void deleteUserGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-5401/userGroups/userGroup-5401";
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
    mockService.addResponse(expectedResponse);

    UserGroupMemberName name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");

    UserGroupMember actualResponse = client.getUserGroupMember(name);
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
  public void getUserGroupMemberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-5778/userGroups/userGroup-5778/members/member-5778";

    UserGroupMember actualResponse = client.getUserGroupMember(name);
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
  public void getUserGroupMemberExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-5778/userGroups/userGroup-5778/members/member-5778";
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
    mockService.addResponse(expectedResponse);

    UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");

    ListUserGroupMembersPagedResponse pagedListResponse = client.listUserGroupMembers(parent);

    List<UserGroupMember> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupMembersList().get(0), resources.get(0));

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
  public void listUserGroupMembersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-3448/userGroups/userGroup-3448";

    ListUserGroupMembersPagedResponse pagedListResponse = client.listUserGroupMembers(parent);

    List<UserGroupMember> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserGroupMembersList().get(0), resources.get(0));

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
  public void listUserGroupMembersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-3448/userGroups/userGroup-3448";
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
    mockService.addResponse(expectedResponse);

    UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
    UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();

    UserGroupMember actualResponse = client.createUserGroupMember(parent, userGroupMember);
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
  public void createUserGroupMemberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-3448/userGroups/userGroup-3448";
    UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();

    UserGroupMember actualResponse = client.createUserGroupMember(parent, userGroupMember);
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
  public void createUserGroupMemberExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-3448/userGroups/userGroup-3448";
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
    mockService.addResponse(expectedResponse);

    UserGroupMember userGroupMember =
        UserGroupMember.newBuilder()
            .setName(
                UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserGroupMember actualResponse = client.updateUserGroupMember(userGroupMember, updateMask);
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
  public void updateUserGroupMemberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserGroupMember userGroupMember =
          UserGroupMember.newBuilder()
              .setName(
                  UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
              .build();
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
    mockService.addResponse(expectedResponse);

    UserGroupMemberName name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");

    client.deleteUserGroupMember(name);

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
  public void deleteUserGroupMemberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-5778/userGroups/userGroup-5778/members/member-5778";

    client.deleteUserGroupMember(name);

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
  public void deleteUserGroupMemberExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-5778/userGroups/userGroup-5778/members/member-5778";
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
    mockService.addResponse(expectedResponse);

    AdminAccessBindingName name =
        AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]");

    AdminAccessBinding actualResponse = client.getAdminAccessBinding(name);
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
  public void getAdminAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-4499/adminAccessBindings/adminAccessBinding-4499";

    AdminAccessBinding actualResponse = client.getAdminAccessBinding(name);
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
  public void getAdminAccessBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-4499/adminAccessBindings/adminAccessBinding-4499";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListAdminAccessBindingsPagedResponse pagedListResponse = client.listAdminAccessBindings(parent);

    List<AdminAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdminAccessBindingsList().get(0), resources.get(0));

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
  public void listAdminAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListAdminAccessBindingsPagedResponse pagedListResponse = client.listAdminAccessBindings(parent);

    List<AdminAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdminAccessBindingsList().get(0), resources.get(0));

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
  public void listAdminAccessBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();

    AdminAccessBinding actualResponse = client.createAdminAccessBinding(parent, adminAccessBinding);
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
  public void createAdminAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();

    AdminAccessBinding actualResponse = client.createAdminAccessBinding(parent, adminAccessBinding);
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
  public void createAdminAccessBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
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
    mockService.addResponse(expectedResponse);

    AdminAccessBinding adminAccessBinding =
        AdminAccessBinding.newBuilder()
            .setName(
                AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
            .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AdminAccessBinding actualResponse =
        client.updateAdminAccessBinding(adminAccessBinding, updateMask);
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
  public void updateAdminAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdminAccessBinding adminAccessBinding =
          AdminAccessBinding.newBuilder()
              .setName(
                  AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
              .addAllOrganizationRoles(new ArrayList<OrganizationRole>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAdminAccessBinding(adminAccessBinding, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
