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

package com.google.analytics.admin.v1alpha;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccessBindingsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAdSenseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAudiencesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListBigQueryLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCalculatedMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListChannelGroupsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinkProposalsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListEventCreateRulesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListExpandedDataSetsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListRollupPropertySourceLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSKAdNetworkConversionValueSchemasPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSearchAds360LinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSubpropertyEventFiltersPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.SearchChangeHistoryEventsPagedResponse;

import com.google.analytics.admin.v1alpha.stub.HttpJsonAnalyticsAdminServiceStub;
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
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class AnalyticsAdminServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AnalyticsAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAnalyticsAdminServiceStub.getMethodDescriptors(),
            AnalyticsAdminServiceSettings.getDefaultEndpoint());
    AnalyticsAdminServiceSettings settings =
        AnalyticsAdminServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AnalyticsAdminServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AnalyticsAdminServiceClient.create(settings);
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
  public void getAccountTest() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRegionCode("regionCode-1991004415")
            .setDeleted(true)
            .build();
    mockService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.getAccount(name);
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
  public void getAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");
      client.getAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountTest2() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRegionCode("regionCode-1991004415")
            .setDeleted(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3500";

    Account actualResponse = client.getAccount(name);
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
  public void getAccountExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3500";
      client.getAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountsTest() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListAccountsResponse expectedResponse =
        ListAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListAccountsRequest request =
        ListAccountsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setShowDeleted(true)
            .build();

    ListAccountsPagedResponse pagedListResponse = client.listAccounts(request);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

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
  public void listAccountsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListAccountsRequest request =
          ListAccountsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setShowDeleted(true)
              .build();
      client.listAccounts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    client.deleteAccount(name);

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
  public void deleteAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");
      client.deleteAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccountTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3500";

    client.deleteAccount(name);

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
  public void deleteAccountExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3500";
      client.deleteAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountTest() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRegionCode("regionCode-1991004415")
            .setDeleted(true)
            .build();
    mockService.addResponse(expectedResponse);

    Account account =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRegionCode("regionCode-1991004415")
            .setDeleted(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Account actualResponse = client.updateAccount(account, updateMask);
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
  public void updateAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Account account =
          Account.newBuilder()
              .setName(AccountName.of("[ACCOUNT]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setRegionCode("regionCode-1991004415")
              .setDeleted(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccount(account, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionAccountTicketTest() throws Exception {
    ProvisionAccountTicketResponse expectedResponse =
        ProvisionAccountTicketResponse.newBuilder()
            .setAccountTicketId("accountTicketId-1576709484")
            .build();
    mockService.addResponse(expectedResponse);

    ProvisionAccountTicketRequest request =
        ProvisionAccountTicketRequest.newBuilder()
            .setAccount(Account.newBuilder().build())
            .setRedirectUri("redirectUri1970337776")
            .build();

    ProvisionAccountTicketResponse actualResponse = client.provisionAccountTicket(request);
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
  public void provisionAccountTicketExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProvisionAccountTicketRequest request =
          ProvisionAccountTicketRequest.newBuilder()
              .setAccount(Account.newBuilder().build())
              .setRedirectUri("redirectUri1970337776")
              .build();
      client.provisionAccountTicket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountSummariesTest() throws Exception {
    AccountSummary responsesElement = AccountSummary.newBuilder().build();
    ListAccountSummariesResponse expectedResponse =
        ListAccountSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountSummaries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListAccountSummariesRequest request =
        ListAccountSummariesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAccountSummariesPagedResponse pagedListResponse = client.listAccountSummaries(request);

    List<AccountSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountSummariesList().get(0), resources.get(0));

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
  public void listAccountSummariesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListAccountSummariesRequest request =
          ListAccountSummariesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAccountSummaries(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPropertyTest() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    Property actualResponse = client.getProperty(name);
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
  public void getPropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName name = PropertyName.of("[PROPERTY]");
      client.getProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPropertyTest2() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-7337";

    Property actualResponse = client.getProperty(name);
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
  public void getPropertyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-7337";
      client.getProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPropertiesTest() throws Exception {
    Property responsesElement = Property.newBuilder().build();
    ListPropertiesResponse expectedResponse =
        ListPropertiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProperties(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListPropertiesRequest request =
        ListPropertiesRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setShowDeleted(true)
            .build();

    ListPropertiesPagedResponse pagedListResponse = client.listProperties(request);

    List<Property> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPropertiesList().get(0), resources.get(0));

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
  public void listPropertiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListPropertiesRequest request =
          ListPropertiesRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setShowDeleted(true)
              .build();
      client.listProperties(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPropertyTest() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    Property property = Property.newBuilder().build();

    Property actualResponse = client.createProperty(property);
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
  public void createPropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Property property = Property.newBuilder().build();
      client.createProperty(property);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePropertyTest() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    Property actualResponse = client.deleteProperty(name);
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
  public void deletePropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName name = PropertyName.of("[PROPERTY]");
      client.deleteProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePropertyTest2() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-7337";

    Property actualResponse = client.deleteProperty(name);
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
  public void deletePropertyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-7337";
      client.deleteProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePropertyTest() throws Exception {
    Property expectedResponse =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    Property property =
        Property.newBuilder()
            .setName(PropertyName.of("[PROPERTY]").toString())
            .setPropertyType(PropertyType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setServiceLevel(ServiceLevel.forNumber(0))
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Property actualResponse = client.updateProperty(property, updateMask);
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
  public void updatePropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Property property =
          Property.newBuilder()
              .setName(PropertyName.of("[PROPERTY]").toString())
              .setPropertyType(PropertyType.forNumber(0))
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setParent("parent-995424086")
              .setDisplayName("displayName1714148973")
              .setIndustryCategory(IndustryCategory.forNumber(0))
              .setTimeZone("timeZone-2077180903")
              .setCurrencyCode("currencyCode1004773790")
              .setServiceLevel(ServiceLevel.forNumber(0))
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .setAccount(AccountName.of("[ACCOUNT]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProperty(property, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirebaseLinkTest() throws Exception {
    FirebaseLink expectedResponse =
        FirebaseLink.newBuilder()
            .setName(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
            .setProject("project-309310695")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

    FirebaseLink actualResponse = client.createFirebaseLink(parent, firebaseLink);
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
  public void createFirebaseLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
      client.createFirebaseLink(parent, firebaseLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirebaseLinkTest2() throws Exception {
    FirebaseLink expectedResponse =
        FirebaseLink.newBuilder()
            .setName(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
            .setProject("project-309310695")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

    FirebaseLink actualResponse = client.createFirebaseLink(parent, firebaseLink);
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
  public void createFirebaseLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
      client.createFirebaseLink(parent, firebaseLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFirebaseLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");

    client.deleteFirebaseLink(name);

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
  public void deleteFirebaseLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");
      client.deleteFirebaseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFirebaseLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-2649/firebaseLinks/firebaseLink-2649";

    client.deleteFirebaseLink(name);

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
  public void deleteFirebaseLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-2649/firebaseLinks/firebaseLink-2649";
      client.deleteFirebaseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirebaseLinksTest() throws Exception {
    FirebaseLink responsesElement = FirebaseLink.newBuilder().build();
    ListFirebaseLinksResponse expectedResponse =
        ListFirebaseLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirebaseLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListFirebaseLinksPagedResponse pagedListResponse = client.listFirebaseLinks(parent);

    List<FirebaseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirebaseLinksList().get(0), resources.get(0));

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
  public void listFirebaseLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listFirebaseLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirebaseLinksTest2() throws Exception {
    FirebaseLink responsesElement = FirebaseLink.newBuilder().build();
    ListFirebaseLinksResponse expectedResponse =
        ListFirebaseLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirebaseLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListFirebaseLinksPagedResponse pagedListResponse = client.listFirebaseLinks(parent);

    List<FirebaseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirebaseLinksList().get(0), resources.get(0));

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
  public void listFirebaseLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listFirebaseLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlobalSiteTagTest() throws Exception {
    GlobalSiteTag expectedResponse =
        GlobalSiteTag.newBuilder()
            .setName(GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setSnippet("snippet-2061635299")
            .build();
    mockService.addResponse(expectedResponse);

    GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]");

    GlobalSiteTag actualResponse = client.getGlobalSiteTag(name);
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
  public void getGlobalSiteTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]");
      client.getGlobalSiteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlobalSiteTagTest2() throws Exception {
    GlobalSiteTag expectedResponse =
        GlobalSiteTag.newBuilder()
            .setName(GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setSnippet("snippet-2061635299")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-1615/dataStreams/dataStream-1615/globalSiteTag";

    GlobalSiteTag actualResponse = client.getGlobalSiteTag(name);
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
  public void getGlobalSiteTagExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-1615/dataStreams/dataStream-1615/globalSiteTag";
      client.getGlobalSiteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGoogleAdsLinkTest() throws Exception {
    GoogleAdsLink expectedResponse =
        GoogleAdsLink.newBuilder()
            .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
            .setCustomerId("customerId-1581184615")
            .setCanManageClients(true)
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreatorEmailAddress("creatorEmailAddress67752708")
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

    GoogleAdsLink actualResponse = client.createGoogleAdsLink(parent, googleAdsLink);
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
  public void createGoogleAdsLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
      client.createGoogleAdsLink(parent, googleAdsLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGoogleAdsLinkTest2() throws Exception {
    GoogleAdsLink expectedResponse =
        GoogleAdsLink.newBuilder()
            .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
            .setCustomerId("customerId-1581184615")
            .setCanManageClients(true)
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreatorEmailAddress("creatorEmailAddress67752708")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

    GoogleAdsLink actualResponse = client.createGoogleAdsLink(parent, googleAdsLink);
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
  public void createGoogleAdsLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
      client.createGoogleAdsLink(parent, googleAdsLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGoogleAdsLinkTest() throws Exception {
    GoogleAdsLink expectedResponse =
        GoogleAdsLink.newBuilder()
            .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
            .setCustomerId("customerId-1581184615")
            .setCanManageClients(true)
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreatorEmailAddress("creatorEmailAddress67752708")
            .build();
    mockService.addResponse(expectedResponse);

    GoogleAdsLink googleAdsLink =
        GoogleAdsLink.newBuilder()
            .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
            .setCustomerId("customerId-1581184615")
            .setCanManageClients(true)
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreatorEmailAddress("creatorEmailAddress67752708")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleAdsLink actualResponse = client.updateGoogleAdsLink(googleAdsLink, updateMask);
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
  public void updateGoogleAdsLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GoogleAdsLink googleAdsLink =
          GoogleAdsLink.newBuilder()
              .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
              .setCustomerId("customerId-1581184615")
              .setCanManageClients(true)
              .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCreatorEmailAddress("creatorEmailAddress67752708")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGoogleAdsLink(googleAdsLink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGoogleAdsLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");

    client.deleteGoogleAdsLink(name);

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
  public void deleteGoogleAdsLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");
      client.deleteGoogleAdsLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGoogleAdsLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-1267/googleAdsLinks/googleAdsLink-1267";

    client.deleteGoogleAdsLink(name);

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
  public void deleteGoogleAdsLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-1267/googleAdsLinks/googleAdsLink-1267";
      client.deleteGoogleAdsLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGoogleAdsLinksTest() throws Exception {
    GoogleAdsLink responsesElement = GoogleAdsLink.newBuilder().build();
    ListGoogleAdsLinksResponse expectedResponse =
        ListGoogleAdsLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllGoogleAdsLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListGoogleAdsLinksPagedResponse pagedListResponse = client.listGoogleAdsLinks(parent);

    List<GoogleAdsLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleAdsLinksList().get(0), resources.get(0));

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
  public void listGoogleAdsLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listGoogleAdsLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGoogleAdsLinksTest2() throws Exception {
    GoogleAdsLink responsesElement = GoogleAdsLink.newBuilder().build();
    ListGoogleAdsLinksResponse expectedResponse =
        ListGoogleAdsLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllGoogleAdsLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListGoogleAdsLinksPagedResponse pagedListResponse = client.listGoogleAdsLinks(parent);

    List<GoogleAdsLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleAdsLinksList().get(0), resources.get(0));

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
  public void listGoogleAdsLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listGoogleAdsLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSharingSettingsTest() throws Exception {
    DataSharingSettings expectedResponse =
        DataSharingSettings.newBuilder()
            .setName(DataSharingSettingsName.of("[ACCOUNT]").toString())
            .setSharingWithGoogleSupportEnabled(true)
            .setSharingWithGoogleAssignedSalesEnabled(true)
            .setSharingWithGoogleAnySalesEnabled(true)
            .setSharingWithGoogleProductsEnabled(true)
            .setSharingWithOthersEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");

    DataSharingSettings actualResponse = client.getDataSharingSettings(name);
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
  public void getDataSharingSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");
      client.getDataSharingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSharingSettingsTest2() throws Exception {
    DataSharingSettings expectedResponse =
        DataSharingSettings.newBuilder()
            .setName(DataSharingSettingsName.of("[ACCOUNT]").toString())
            .setSharingWithGoogleSupportEnabled(true)
            .setSharingWithGoogleAssignedSalesEnabled(true)
            .setSharingWithGoogleAnySalesEnabled(true)
            .setSharingWithGoogleProductsEnabled(true)
            .setSharingWithOthersEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-7122/dataSharingSettings";

    DataSharingSettings actualResponse = client.getDataSharingSettings(name);
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
  public void getDataSharingSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-7122/dataSharingSettings";
      client.getDataSharingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeasurementProtocolSecretTest() throws Exception {
    MeasurementProtocolSecret expectedResponse =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    mockService.addResponse(expectedResponse);

    MeasurementProtocolSecretName name =
        MeasurementProtocolSecretName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");

    MeasurementProtocolSecret actualResponse = client.getMeasurementProtocolSecret(name);
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
  public void getMeasurementProtocolSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MeasurementProtocolSecretName name =
          MeasurementProtocolSecretName.of(
              "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");
      client.getMeasurementProtocolSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeasurementProtocolSecretTest2() throws Exception {
    MeasurementProtocolSecret expectedResponse =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-6357/dataStreams/dataStream-6357/measurementProtocolSecrets/measurementProtocolSecret-6357";

    MeasurementProtocolSecret actualResponse = client.getMeasurementProtocolSecret(name);
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
  public void getMeasurementProtocolSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-6357/dataStreams/dataStream-6357/measurementProtocolSecrets/measurementProtocolSecret-6357";
      client.getMeasurementProtocolSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMeasurementProtocolSecretsTest() throws Exception {
    MeasurementProtocolSecret responsesElement = MeasurementProtocolSecret.newBuilder().build();
    ListMeasurementProtocolSecretsResponse expectedResponse =
        ListMeasurementProtocolSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeasurementProtocolSecrets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    ListMeasurementProtocolSecretsPagedResponse pagedListResponse =
        client.listMeasurementProtocolSecrets(parent);

    List<MeasurementProtocolSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMeasurementProtocolSecretsList().get(0), resources.get(0));

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
  public void listMeasurementProtocolSecretsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      client.listMeasurementProtocolSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMeasurementProtocolSecretsTest2() throws Exception {
    MeasurementProtocolSecret responsesElement = MeasurementProtocolSecret.newBuilder().build();
    ListMeasurementProtocolSecretsResponse expectedResponse =
        ListMeasurementProtocolSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeasurementProtocolSecrets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";

    ListMeasurementProtocolSecretsPagedResponse pagedListResponse =
        client.listMeasurementProtocolSecrets(parent);

    List<MeasurementProtocolSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMeasurementProtocolSecretsList().get(0), resources.get(0));

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
  public void listMeasurementProtocolSecretsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      client.listMeasurementProtocolSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMeasurementProtocolSecretTest() throws Exception {
    MeasurementProtocolSecret expectedResponse =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
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
  public void createMeasurementProtocolSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      MeasurementProtocolSecret measurementProtocolSecret =
          MeasurementProtocolSecret.newBuilder().build();
      client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMeasurementProtocolSecretTest2() throws Exception {
    MeasurementProtocolSecret expectedResponse =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
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
  public void createMeasurementProtocolSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      MeasurementProtocolSecret measurementProtocolSecret =
          MeasurementProtocolSecret.newBuilder().build();
      client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMeasurementProtocolSecretTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    MeasurementProtocolSecretName name =
        MeasurementProtocolSecretName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");

    client.deleteMeasurementProtocolSecret(name);

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
  public void deleteMeasurementProtocolSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MeasurementProtocolSecretName name =
          MeasurementProtocolSecretName.of(
              "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");
      client.deleteMeasurementProtocolSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMeasurementProtocolSecretTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-6357/dataStreams/dataStream-6357/measurementProtocolSecrets/measurementProtocolSecret-6357";

    client.deleteMeasurementProtocolSecret(name);

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
  public void deleteMeasurementProtocolSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-6357/dataStreams/dataStream-6357/measurementProtocolSecrets/measurementProtocolSecret-6357";
      client.deleteMeasurementProtocolSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMeasurementProtocolSecretTest() throws Exception {
    MeasurementProtocolSecret expectedResponse =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    mockService.addResponse(expectedResponse);

    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder()
            .setName(
                MeasurementProtocolSecretName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSecretValue("secretValue-2044460895")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.updateMeasurementProtocolSecret(measurementProtocolSecret, updateMask);
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
  public void updateMeasurementProtocolSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MeasurementProtocolSecret measurementProtocolSecret =
          MeasurementProtocolSecret.newBuilder()
              .setName(
                  MeasurementProtocolSecretName.of(
                          "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setSecretValue("secretValue-2044460895")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMeasurementProtocolSecret(measurementProtocolSecret, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acknowledgeUserDataCollectionTest() throws Exception {
    AcknowledgeUserDataCollectionResponse expectedResponse =
        AcknowledgeUserDataCollectionResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AcknowledgeUserDataCollectionRequest request =
        AcknowledgeUserDataCollectionRequest.newBuilder()
            .setProperty(PropertyName.of("[PROPERTY]").toString())
            .setAcknowledgement("acknowledgement1769490938")
            .build();

    AcknowledgeUserDataCollectionResponse actualResponse =
        client.acknowledgeUserDataCollection(request);
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
  public void acknowledgeUserDataCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AcknowledgeUserDataCollectionRequest request =
          AcknowledgeUserDataCollectionRequest.newBuilder()
              .setProperty(PropertyName.of("[PROPERTY]").toString())
              .setAcknowledgement("acknowledgement1769490938")
              .build();
      client.acknowledgeUserDataCollection(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSKAdNetworkConversionValueSchemaTest() throws Exception {
    SKAdNetworkConversionValueSchema expectedResponse =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    mockService.addResponse(expectedResponse);

    SKAdNetworkConversionValueSchemaName name =
        SKAdNetworkConversionValueSchemaName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");

    SKAdNetworkConversionValueSchema actualResponse =
        client.getSKAdNetworkConversionValueSchema(name);
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
  public void getSKAdNetworkConversionValueSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SKAdNetworkConversionValueSchemaName name =
          SKAdNetworkConversionValueSchemaName.of(
              "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");
      client.getSKAdNetworkConversionValueSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSKAdNetworkConversionValueSchemaTest2() throws Exception {
    SKAdNetworkConversionValueSchema expectedResponse =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-7099/dataStreams/dataStream-7099/sKAdNetworkConversionValueSchema/sKAdNetworkConversionValueSchem-7099";

    SKAdNetworkConversionValueSchema actualResponse =
        client.getSKAdNetworkConversionValueSchema(name);
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
  public void getSKAdNetworkConversionValueSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-7099/dataStreams/dataStream-7099/sKAdNetworkConversionValueSchema/sKAdNetworkConversionValueSchem-7099";
      client.getSKAdNetworkConversionValueSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSKAdNetworkConversionValueSchemaTest() throws Exception {
    SKAdNetworkConversionValueSchema expectedResponse =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
    SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
        SKAdNetworkConversionValueSchema.newBuilder().build();

    SKAdNetworkConversionValueSchema actualResponse =
        client.createSKAdNetworkConversionValueSchema(parent, skadnetworkConversionValueSchema);
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
  public void createSKAdNetworkConversionValueSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
          SKAdNetworkConversionValueSchema.newBuilder().build();
      client.createSKAdNetworkConversionValueSchema(parent, skadnetworkConversionValueSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSKAdNetworkConversionValueSchemaTest2() throws Exception {
    SKAdNetworkConversionValueSchema expectedResponse =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
    SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
        SKAdNetworkConversionValueSchema.newBuilder().build();

    SKAdNetworkConversionValueSchema actualResponse =
        client.createSKAdNetworkConversionValueSchema(parent, skadnetworkConversionValueSchema);
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
  public void createSKAdNetworkConversionValueSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
          SKAdNetworkConversionValueSchema.newBuilder().build();
      client.createSKAdNetworkConversionValueSchema(parent, skadnetworkConversionValueSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSKAdNetworkConversionValueSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SKAdNetworkConversionValueSchemaName name =
        SKAdNetworkConversionValueSchemaName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");

    client.deleteSKAdNetworkConversionValueSchema(name);

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
  public void deleteSKAdNetworkConversionValueSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SKAdNetworkConversionValueSchemaName name =
          SKAdNetworkConversionValueSchemaName.of(
              "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");
      client.deleteSKAdNetworkConversionValueSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSKAdNetworkConversionValueSchemaTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-7099/dataStreams/dataStream-7099/sKAdNetworkConversionValueSchema/sKAdNetworkConversionValueSchem-7099";

    client.deleteSKAdNetworkConversionValueSchema(name);

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
  public void deleteSKAdNetworkConversionValueSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-7099/dataStreams/dataStream-7099/sKAdNetworkConversionValueSchema/sKAdNetworkConversionValueSchem-7099";
      client.deleteSKAdNetworkConversionValueSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSKAdNetworkConversionValueSchemaTest() throws Exception {
    SKAdNetworkConversionValueSchema expectedResponse =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    mockService.addResponse(expectedResponse);

    SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
        SKAdNetworkConversionValueSchema.newBuilder()
            .setName(
                SKAdNetworkConversionValueSchemaName.of(
                        "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                    .toString())
            .setPostbackWindowOne(PostbackWindow.newBuilder().build())
            .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
            .setPostbackWindowThree(PostbackWindow.newBuilder().build())
            .setApplyConversionValues(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SKAdNetworkConversionValueSchema actualResponse =
        client.updateSKAdNetworkConversionValueSchema(skadnetworkConversionValueSchema, updateMask);
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
  public void updateSKAdNetworkConversionValueSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
          SKAdNetworkConversionValueSchema.newBuilder()
              .setName(
                  SKAdNetworkConversionValueSchemaName.of(
                          "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
                      .toString())
              .setPostbackWindowOne(PostbackWindow.newBuilder().build())
              .setPostbackWindowTwo(PostbackWindow.newBuilder().build())
              .setPostbackWindowThree(PostbackWindow.newBuilder().build())
              .setApplyConversionValues(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSKAdNetworkConversionValueSchema(skadnetworkConversionValueSchema, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSKAdNetworkConversionValueSchemasTest() throws Exception {
    SKAdNetworkConversionValueSchema responsesElement =
        SKAdNetworkConversionValueSchema.newBuilder().build();
    ListSKAdNetworkConversionValueSchemasResponse expectedResponse =
        ListSKAdNetworkConversionValueSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkadnetworkConversionValueSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    ListSKAdNetworkConversionValueSchemasPagedResponse pagedListResponse =
        client.listSKAdNetworkConversionValueSchemas(parent);

    List<SKAdNetworkConversionValueSchema> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSkadnetworkConversionValueSchemasList().get(0), resources.get(0));

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
  public void listSKAdNetworkConversionValueSchemasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      client.listSKAdNetworkConversionValueSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSKAdNetworkConversionValueSchemasTest2() throws Exception {
    SKAdNetworkConversionValueSchema responsesElement =
        SKAdNetworkConversionValueSchema.newBuilder().build();
    ListSKAdNetworkConversionValueSchemasResponse expectedResponse =
        ListSKAdNetworkConversionValueSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkadnetworkConversionValueSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";

    ListSKAdNetworkConversionValueSchemasPagedResponse pagedListResponse =
        client.listSKAdNetworkConversionValueSchemas(parent);

    List<SKAdNetworkConversionValueSchema> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSkadnetworkConversionValueSchemasList().get(0), resources.get(0));

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
  public void listSKAdNetworkConversionValueSchemasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      client.listSKAdNetworkConversionValueSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchChangeHistoryEventsTest() throws Exception {
    ChangeHistoryEvent responsesElement = ChangeHistoryEvent.newBuilder().build();
    SearchChangeHistoryEventsResponse expectedResponse =
        SearchChangeHistoryEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangeHistoryEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchChangeHistoryEventsRequest request =
        SearchChangeHistoryEventsRequest.newBuilder()
            .setAccount(AccountName.of("[ACCOUNT]").toString())
            .setProperty(PropertyName.of("[PROPERTY]").toString())
            .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
            .addAllAction(new ArrayList<ActionType>())
            .addAllActorEmail(new ArrayList<String>())
            .setEarliestChangeTime(Timestamp.newBuilder().build())
            .setLatestChangeTime(Timestamp.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchChangeHistoryEventsPagedResponse pagedListResponse =
        client.searchChangeHistoryEvents(request);

    List<ChangeHistoryEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangeHistoryEventsList().get(0), resources.get(0));

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
  public void searchChangeHistoryEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchChangeHistoryEventsRequest request =
          SearchChangeHistoryEventsRequest.newBuilder()
              .setAccount(AccountName.of("[ACCOUNT]").toString())
              .setProperty(PropertyName.of("[PROPERTY]").toString())
              .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
              .addAllAction(new ArrayList<ActionType>())
              .addAllActorEmail(new ArrayList<String>())
              .setEarliestChangeTime(Timestamp.newBuilder().build())
              .setLatestChangeTime(Timestamp.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchChangeHistoryEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGoogleSignalsSettingsTest() throws Exception {
    GoogleSignalsSettings expectedResponse =
        GoogleSignalsSettings.newBuilder()
            .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
            .setState(GoogleSignalsState.forNumber(0))
            .setConsent(GoogleSignalsConsent.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    GoogleSignalsSettingsName name = GoogleSignalsSettingsName.of("[PROPERTY]");

    GoogleSignalsSettings actualResponse = client.getGoogleSignalsSettings(name);
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
  public void getGoogleSignalsSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GoogleSignalsSettingsName name = GoogleSignalsSettingsName.of("[PROPERTY]");
      client.getGoogleSignalsSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGoogleSignalsSettingsTest2() throws Exception {
    GoogleSignalsSettings expectedResponse =
        GoogleSignalsSettings.newBuilder()
            .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
            .setState(GoogleSignalsState.forNumber(0))
            .setConsent(GoogleSignalsConsent.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-7279/googleSignalsSettings";

    GoogleSignalsSettings actualResponse = client.getGoogleSignalsSettings(name);
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
  public void getGoogleSignalsSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-7279/googleSignalsSettings";
      client.getGoogleSignalsSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGoogleSignalsSettingsTest() throws Exception {
    GoogleSignalsSettings expectedResponse =
        GoogleSignalsSettings.newBuilder()
            .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
            .setState(GoogleSignalsState.forNumber(0))
            .setConsent(GoogleSignalsConsent.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    GoogleSignalsSettings googleSignalsSettings =
        GoogleSignalsSettings.newBuilder()
            .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
            .setState(GoogleSignalsState.forNumber(0))
            .setConsent(GoogleSignalsConsent.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleSignalsSettings actualResponse =
        client.updateGoogleSignalsSettings(googleSignalsSettings, updateMask);
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
  public void updateGoogleSignalsSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GoogleSignalsSettings googleSignalsSettings =
          GoogleSignalsSettings.newBuilder()
              .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
              .setState(GoogleSignalsState.forNumber(0))
              .setConsent(GoogleSignalsConsent.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGoogleSignalsSettings(googleSignalsSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversionEventTest() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();

    ConversionEvent actualResponse = client.createConversionEvent(parent, conversionEvent);
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
  public void createConversionEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();
      client.createConversionEvent(parent, conversionEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversionEventTest2() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();

    ConversionEvent actualResponse = client.createConversionEvent(parent, conversionEvent);
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
  public void createConversionEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();
      client.createConversionEvent(parent, conversionEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConversionEventTest() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversionEvent conversionEvent =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversionEvent actualResponse = client.updateConversionEvent(conversionEvent, updateMask);
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
  public void updateConversionEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionEvent conversionEvent =
          ConversionEvent.newBuilder()
              .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
              .setEventName("eventName31228997")
              .setCreateTime(Timestamp.newBuilder().build())
              .setDeletable(true)
              .setCustom(true)
              .setDefaultConversionValue(
                  ConversionEvent.DefaultConversionValue.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversionEvent(conversionEvent, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionEventTest() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");

    ConversionEvent actualResponse = client.getConversionEvent(name);
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
  public void getConversionEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");
      client.getConversionEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionEventTest2() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .setDefaultConversionValue(ConversionEvent.DefaultConversionValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-4144/conversionEvents/conversionEvent-4144";

    ConversionEvent actualResponse = client.getConversionEvent(name);
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
  public void getConversionEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-4144/conversionEvents/conversionEvent-4144";
      client.getConversionEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");

    client.deleteConversionEvent(name);

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
  public void deleteConversionEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");
      client.deleteConversionEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionEventTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-4144/conversionEvents/conversionEvent-4144";

    client.deleteConversionEvent(name);

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
  public void deleteConversionEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-4144/conversionEvents/conversionEvent-4144";
      client.deleteConversionEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionEventsTest() throws Exception {
    ConversionEvent responsesElement = ConversionEvent.newBuilder().build();
    ListConversionEventsResponse expectedResponse =
        ListConversionEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListConversionEventsPagedResponse pagedListResponse = client.listConversionEvents(parent);

    List<ConversionEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionEventsList().get(0), resources.get(0));

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
  public void listConversionEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listConversionEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionEventsTest2() throws Exception {
    ConversionEvent responsesElement = ConversionEvent.newBuilder().build();
    ListConversionEventsResponse expectedResponse =
        ListConversionEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListConversionEventsPagedResponse pagedListResponse = client.listConversionEvents(parent);

    List<ConversionEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionEventsList().get(0), resources.get(0));

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
  public void listConversionEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listConversionEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDisplayVideo360AdvertiserLinkTest() throws Exception {
    DisplayVideo360AdvertiserLink expectedResponse =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DisplayVideo360AdvertiserLinkName name =
        DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");

    DisplayVideo360AdvertiserLink actualResponse = client.getDisplayVideo360AdvertiserLink(name);
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
  public void getDisplayVideo360AdvertiserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisplayVideo360AdvertiserLinkName name =
          DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");
      client.getDisplayVideo360AdvertiserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDisplayVideo360AdvertiserLinkTest2() throws Exception {
    DisplayVideo360AdvertiserLink expectedResponse =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-7275/displayVideo360AdvertiserLinks/displayVideo360AdvertiserLink-7275";

    DisplayVideo360AdvertiserLink actualResponse = client.getDisplayVideo360AdvertiserLink(name);
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
  public void getDisplayVideo360AdvertiserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-7275/displayVideo360AdvertiserLinks/displayVideo360AdvertiserLink-7275";
      client.getDisplayVideo360AdvertiserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDisplayVideo360AdvertiserLinksTest() throws Exception {
    DisplayVideo360AdvertiserLink responsesElement =
        DisplayVideo360AdvertiserLink.newBuilder().build();
    ListDisplayVideo360AdvertiserLinksResponse expectedResponse =
        ListDisplayVideo360AdvertiserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllDisplayVideo360AdvertiserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListDisplayVideo360AdvertiserLinksPagedResponse pagedListResponse =
        client.listDisplayVideo360AdvertiserLinks(parent);

    List<DisplayVideo360AdvertiserLink> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDisplayVideo360AdvertiserLinksList().get(0), resources.get(0));

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
  public void listDisplayVideo360AdvertiserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listDisplayVideo360AdvertiserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDisplayVideo360AdvertiserLinksTest2() throws Exception {
    DisplayVideo360AdvertiserLink responsesElement =
        DisplayVideo360AdvertiserLink.newBuilder().build();
    ListDisplayVideo360AdvertiserLinksResponse expectedResponse =
        ListDisplayVideo360AdvertiserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllDisplayVideo360AdvertiserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListDisplayVideo360AdvertiserLinksPagedResponse pagedListResponse =
        client.listDisplayVideo360AdvertiserLinks(parent);

    List<DisplayVideo360AdvertiserLink> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDisplayVideo360AdvertiserLinksList().get(0), resources.get(0));

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
  public void listDisplayVideo360AdvertiserLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listDisplayVideo360AdvertiserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDisplayVideo360AdvertiserLinkTest() throws Exception {
    DisplayVideo360AdvertiserLink expectedResponse =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
        DisplayVideo360AdvertiserLink.newBuilder().build();

    DisplayVideo360AdvertiserLink actualResponse =
        client.createDisplayVideo360AdvertiserLink(parent, displayVideo360AdvertiserLink);
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
  public void createDisplayVideo360AdvertiserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
          DisplayVideo360AdvertiserLink.newBuilder().build();
      client.createDisplayVideo360AdvertiserLink(parent, displayVideo360AdvertiserLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDisplayVideo360AdvertiserLinkTest2() throws Exception {
    DisplayVideo360AdvertiserLink expectedResponse =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
        DisplayVideo360AdvertiserLink.newBuilder().build();

    DisplayVideo360AdvertiserLink actualResponse =
        client.createDisplayVideo360AdvertiserLink(parent, displayVideo360AdvertiserLink);
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
  public void createDisplayVideo360AdvertiserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
          DisplayVideo360AdvertiserLink.newBuilder().build();
      client.createDisplayVideo360AdvertiserLink(parent, displayVideo360AdvertiserLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDisplayVideo360AdvertiserLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DisplayVideo360AdvertiserLinkName name =
        DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");

    client.deleteDisplayVideo360AdvertiserLink(name);

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
  public void deleteDisplayVideo360AdvertiserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisplayVideo360AdvertiserLinkName name =
          DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");
      client.deleteDisplayVideo360AdvertiserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDisplayVideo360AdvertiserLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-7275/displayVideo360AdvertiserLinks/displayVideo360AdvertiserLink-7275";

    client.deleteDisplayVideo360AdvertiserLink(name);

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
  public void deleteDisplayVideo360AdvertiserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-7275/displayVideo360AdvertiserLinks/displayVideo360AdvertiserLink-7275";
      client.deleteDisplayVideo360AdvertiserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDisplayVideo360AdvertiserLinkTest() throws Exception {
    DisplayVideo360AdvertiserLink expectedResponse =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
        DisplayVideo360AdvertiserLink.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DisplayVideo360AdvertiserLink actualResponse =
        client.updateDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink, updateMask);
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
  public void updateDisplayVideo360AdvertiserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
          DisplayVideo360AdvertiserLink.newBuilder()
              .setName(
                  DisplayVideo360AdvertiserLinkName.of(
                          "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                      .toString())
              .setAdvertiserId("advertiserId550061990")
              .setAdvertiserDisplayName("advertiserDisplayName1594116162")
              .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
              .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
              .setCostDataSharingEnabled(BoolValue.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDisplayVideo360AdvertiserLinkProposalTest() throws Exception {
    DisplayVideo360AdvertiserLinkProposal expectedResponse =
        DisplayVideo360AdvertiserLinkProposal.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setLinkProposalStatusDetails(LinkProposalStatusDetails.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setValidationEmail("validationEmail-94407005")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DisplayVideo360AdvertiserLinkProposalName name =
        DisplayVideo360AdvertiserLinkProposalName.of(
            "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");

    DisplayVideo360AdvertiserLinkProposal actualResponse =
        client.getDisplayVideo360AdvertiserLinkProposal(name);
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
  public void getDisplayVideo360AdvertiserLinkProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisplayVideo360AdvertiserLinkProposalName name =
          DisplayVideo360AdvertiserLinkProposalName.of(
              "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");
      client.getDisplayVideo360AdvertiserLinkProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDisplayVideo360AdvertiserLinkProposalTest2() throws Exception {
    DisplayVideo360AdvertiserLinkProposal expectedResponse =
        DisplayVideo360AdvertiserLinkProposal.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setLinkProposalStatusDetails(LinkProposalStatusDetails.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setValidationEmail("validationEmail-94407005")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-8473/displayVideo360AdvertiserLinkProposals/displayVideo360AdvertiserLinkProposal-8473";

    DisplayVideo360AdvertiserLinkProposal actualResponse =
        client.getDisplayVideo360AdvertiserLinkProposal(name);
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
  public void getDisplayVideo360AdvertiserLinkProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-8473/displayVideo360AdvertiserLinkProposals/displayVideo360AdvertiserLinkProposal-8473";
      client.getDisplayVideo360AdvertiserLinkProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDisplayVideo360AdvertiserLinkProposalsTest() throws Exception {
    DisplayVideo360AdvertiserLinkProposal responsesElement =
        DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
    ListDisplayVideo360AdvertiserLinkProposalsResponse expectedResponse =
        ListDisplayVideo360AdvertiserLinkProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDisplayVideo360AdvertiserLinkProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListDisplayVideo360AdvertiserLinkProposalsPagedResponse pagedListResponse =
        client.listDisplayVideo360AdvertiserLinkProposals(parent);

    List<DisplayVideo360AdvertiserLinkProposal> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDisplayVideo360AdvertiserLinkProposalsList().get(0), resources.get(0));

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
  public void listDisplayVideo360AdvertiserLinkProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listDisplayVideo360AdvertiserLinkProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDisplayVideo360AdvertiserLinkProposalsTest2() throws Exception {
    DisplayVideo360AdvertiserLinkProposal responsesElement =
        DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
    ListDisplayVideo360AdvertiserLinkProposalsResponse expectedResponse =
        ListDisplayVideo360AdvertiserLinkProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDisplayVideo360AdvertiserLinkProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListDisplayVideo360AdvertiserLinkProposalsPagedResponse pagedListResponse =
        client.listDisplayVideo360AdvertiserLinkProposals(parent);

    List<DisplayVideo360AdvertiserLinkProposal> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDisplayVideo360AdvertiserLinkProposalsList().get(0), resources.get(0));

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
  public void listDisplayVideo360AdvertiserLinkProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listDisplayVideo360AdvertiserLinkProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDisplayVideo360AdvertiserLinkProposalTest() throws Exception {
    DisplayVideo360AdvertiserLinkProposal expectedResponse =
        DisplayVideo360AdvertiserLinkProposal.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setLinkProposalStatusDetails(LinkProposalStatusDetails.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setValidationEmail("validationEmail-94407005")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
        DisplayVideo360AdvertiserLinkProposal.newBuilder().build();

    DisplayVideo360AdvertiserLinkProposal actualResponse =
        client.createDisplayVideo360AdvertiserLinkProposal(
            parent, displayVideo360AdvertiserLinkProposal);
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
  public void createDisplayVideo360AdvertiserLinkProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
          DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
      client.createDisplayVideo360AdvertiserLinkProposal(
          parent, displayVideo360AdvertiserLinkProposal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDisplayVideo360AdvertiserLinkProposalTest2() throws Exception {
    DisplayVideo360AdvertiserLinkProposal expectedResponse =
        DisplayVideo360AdvertiserLinkProposal.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setLinkProposalStatusDetails(LinkProposalStatusDetails.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setValidationEmail("validationEmail-94407005")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
        DisplayVideo360AdvertiserLinkProposal.newBuilder().build();

    DisplayVideo360AdvertiserLinkProposal actualResponse =
        client.createDisplayVideo360AdvertiserLinkProposal(
            parent, displayVideo360AdvertiserLinkProposal);
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
  public void createDisplayVideo360AdvertiserLinkProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
          DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
      client.createDisplayVideo360AdvertiserLinkProposal(
          parent, displayVideo360AdvertiserLinkProposal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDisplayVideo360AdvertiserLinkProposalTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DisplayVideo360AdvertiserLinkProposalName name =
        DisplayVideo360AdvertiserLinkProposalName.of(
            "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");

    client.deleteDisplayVideo360AdvertiserLinkProposal(name);

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
  public void deleteDisplayVideo360AdvertiserLinkProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisplayVideo360AdvertiserLinkProposalName name =
          DisplayVideo360AdvertiserLinkProposalName.of(
              "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");
      client.deleteDisplayVideo360AdvertiserLinkProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDisplayVideo360AdvertiserLinkProposalTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-8473/displayVideo360AdvertiserLinkProposals/displayVideo360AdvertiserLinkProposal-8473";

    client.deleteDisplayVideo360AdvertiserLinkProposal(name);

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
  public void deleteDisplayVideo360AdvertiserLinkProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-8473/displayVideo360AdvertiserLinkProposals/displayVideo360AdvertiserLinkProposal-8473";
      client.deleteDisplayVideo360AdvertiserLinkProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveDisplayVideo360AdvertiserLinkProposalTest() throws Exception {
    ApproveDisplayVideo360AdvertiserLinkProposalResponse expectedResponse =
        ApproveDisplayVideo360AdvertiserLinkProposalResponse.newBuilder()
            .setDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLink.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApproveDisplayVideo360AdvertiserLinkProposalRequest request =
        ApproveDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .build();

    ApproveDisplayVideo360AdvertiserLinkProposalResponse actualResponse =
        client.approveDisplayVideo360AdvertiserLinkProposal(request);
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
  public void approveDisplayVideo360AdvertiserLinkProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApproveDisplayVideo360AdvertiserLinkProposalRequest request =
          ApproveDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
              .setName(
                  DisplayVideo360AdvertiserLinkProposalName.of(
                          "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                      .toString())
              .build();
      client.approveDisplayVideo360AdvertiserLinkProposal(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelDisplayVideo360AdvertiserLinkProposalTest() throws Exception {
    DisplayVideo360AdvertiserLinkProposal expectedResponse =
        DisplayVideo360AdvertiserLinkProposal.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .setAdvertiserId("advertiserId550061990")
            .setLinkProposalStatusDetails(LinkProposalStatusDetails.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setValidationEmail("validationEmail-94407005")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CancelDisplayVideo360AdvertiserLinkProposalRequest request =
        CancelDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setName(
                DisplayVideo360AdvertiserLinkProposalName.of(
                        "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                    .toString())
            .build();

    DisplayVideo360AdvertiserLinkProposal actualResponse =
        client.cancelDisplayVideo360AdvertiserLinkProposal(request);
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
  public void cancelDisplayVideo360AdvertiserLinkProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CancelDisplayVideo360AdvertiserLinkProposalRequest request =
          CancelDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
              .setName(
                  DisplayVideo360AdvertiserLinkProposalName.of(
                          "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
                      .toString())
              .build();
      client.cancelDisplayVideo360AdvertiserLinkProposal(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomDimensionTest() throws Exception {
    CustomDimension expectedResponse =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    CustomDimension customDimension = CustomDimension.newBuilder().build();

    CustomDimension actualResponse = client.createCustomDimension(parent, customDimension);
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
  public void createCustomDimensionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      CustomDimension customDimension = CustomDimension.newBuilder().build();
      client.createCustomDimension(parent, customDimension);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomDimensionTest2() throws Exception {
    CustomDimension expectedResponse =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    CustomDimension customDimension = CustomDimension.newBuilder().build();

    CustomDimension actualResponse = client.createCustomDimension(parent, customDimension);
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
  public void createCustomDimensionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      CustomDimension customDimension = CustomDimension.newBuilder().build();
      client.createCustomDimension(parent, customDimension);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomDimensionTest() throws Exception {
    CustomDimension expectedResponse =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    mockService.addResponse(expectedResponse);

    CustomDimension customDimension =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomDimension actualResponse = client.updateCustomDimension(customDimension, updateMask);
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
  public void updateCustomDimensionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomDimension customDimension =
          CustomDimension.newBuilder()
              .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
              .setParameterName("parameterName-379607596")
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setDisallowAdsPersonalization(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomDimension(customDimension, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomDimensionsTest() throws Exception {
    CustomDimension responsesElement = CustomDimension.newBuilder().build();
    ListCustomDimensionsResponse expectedResponse =
        ListCustomDimensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomDimensions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListCustomDimensionsPagedResponse pagedListResponse = client.listCustomDimensions(parent);

    List<CustomDimension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomDimensionsList().get(0), resources.get(0));

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
  public void listCustomDimensionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listCustomDimensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomDimensionsTest2() throws Exception {
    CustomDimension responsesElement = CustomDimension.newBuilder().build();
    ListCustomDimensionsResponse expectedResponse =
        ListCustomDimensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomDimensions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListCustomDimensionsPagedResponse pagedListResponse = client.listCustomDimensions(parent);

    List<CustomDimension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomDimensionsList().get(0), resources.get(0));

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
  public void listCustomDimensionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listCustomDimensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomDimensionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");

    client.archiveCustomDimension(name);

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
  public void archiveCustomDimensionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");
      client.archiveCustomDimension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomDimensionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-447/customDimensions/customDimension-447";

    client.archiveCustomDimension(name);

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
  public void archiveCustomDimensionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-447/customDimensions/customDimension-447";
      client.archiveCustomDimension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomDimensionTest() throws Exception {
    CustomDimension expectedResponse =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    mockService.addResponse(expectedResponse);

    CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");

    CustomDimension actualResponse = client.getCustomDimension(name);
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
  public void getCustomDimensionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");
      client.getCustomDimension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomDimensionTest2() throws Exception {
    CustomDimension expectedResponse =
        CustomDimension.newBuilder()
            .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDisallowAdsPersonalization(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-447/customDimensions/customDimension-447";

    CustomDimension actualResponse = client.getCustomDimension(name);
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
  public void getCustomDimensionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-447/customDimensions/customDimension-447";
      client.getCustomDimension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomMetricTest() throws Exception {
    CustomMetric expectedResponse =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    CustomMetric customMetric = CustomMetric.newBuilder().build();

    CustomMetric actualResponse = client.createCustomMetric(parent, customMetric);
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
  public void createCustomMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      CustomMetric customMetric = CustomMetric.newBuilder().build();
      client.createCustomMetric(parent, customMetric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomMetricTest2() throws Exception {
    CustomMetric expectedResponse =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    CustomMetric customMetric = CustomMetric.newBuilder().build();

    CustomMetric actualResponse = client.createCustomMetric(parent, customMetric);
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
  public void createCustomMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      CustomMetric customMetric = CustomMetric.newBuilder().build();
      client.createCustomMetric(parent, customMetric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomMetricTest() throws Exception {
    CustomMetric expectedResponse =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    mockService.addResponse(expectedResponse);

    CustomMetric customMetric =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomMetric actualResponse = client.updateCustomMetric(customMetric, updateMask);
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
  public void updateCustomMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomMetric customMetric =
          CustomMetric.newBuilder()
              .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
              .setParameterName("parameterName-379607596")
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomMetric(customMetric, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomMetricsTest() throws Exception {
    CustomMetric responsesElement = CustomMetric.newBuilder().build();
    ListCustomMetricsResponse expectedResponse =
        ListCustomMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomMetrics(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListCustomMetricsPagedResponse pagedListResponse = client.listCustomMetrics(parent);

    List<CustomMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomMetricsList().get(0), resources.get(0));

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
  public void listCustomMetricsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listCustomMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomMetricsTest2() throws Exception {
    CustomMetric responsesElement = CustomMetric.newBuilder().build();
    ListCustomMetricsResponse expectedResponse =
        ListCustomMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomMetrics(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListCustomMetricsPagedResponse pagedListResponse = client.listCustomMetrics(parent);

    List<CustomMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomMetricsList().get(0), resources.get(0));

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
  public void listCustomMetricsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listCustomMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomMetricTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");

    client.archiveCustomMetric(name);

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
  public void archiveCustomMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");
      client.archiveCustomMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomMetricTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-2999/customMetrics/customMetric-2999";

    client.archiveCustomMetric(name);

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
  public void archiveCustomMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-2999/customMetrics/customMetric-2999";
      client.archiveCustomMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomMetricTest() throws Exception {
    CustomMetric expectedResponse =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    mockService.addResponse(expectedResponse);

    CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");

    CustomMetric actualResponse = client.getCustomMetric(name);
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
  public void getCustomMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");
      client.getCustomMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomMetricTest2() throws Exception {
    CustomMetric expectedResponse =
        CustomMetric.newBuilder()
            .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
            .setParameterName("parameterName-379607596")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllRestrictedMetricType(new ArrayList<CustomMetric.RestrictedMetricType>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-2999/customMetrics/customMetric-2999";

    CustomMetric actualResponse = client.getCustomMetric(name);
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
  public void getCustomMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-2999/customMetrics/customMetric-2999";
      client.getCustomMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataRetentionSettingsTest() throws Exception {
    DataRetentionSettings expectedResponse =
        DataRetentionSettings.newBuilder()
            .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
            .setResetUserDataOnNewActivity(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataRetentionSettingsName name = DataRetentionSettingsName.of("[PROPERTY]");

    DataRetentionSettings actualResponse = client.getDataRetentionSettings(name);
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
  public void getDataRetentionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataRetentionSettingsName name = DataRetentionSettingsName.of("[PROPERTY]");
      client.getDataRetentionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataRetentionSettingsTest2() throws Exception {
    DataRetentionSettings expectedResponse =
        DataRetentionSettings.newBuilder()
            .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
            .setResetUserDataOnNewActivity(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-2463/dataRetentionSettings";

    DataRetentionSettings actualResponse = client.getDataRetentionSettings(name);
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
  public void getDataRetentionSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-2463/dataRetentionSettings";
      client.getDataRetentionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataRetentionSettingsTest() throws Exception {
    DataRetentionSettings expectedResponse =
        DataRetentionSettings.newBuilder()
            .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
            .setResetUserDataOnNewActivity(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataRetentionSettings dataRetentionSettings =
        DataRetentionSettings.newBuilder()
            .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
            .setResetUserDataOnNewActivity(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataRetentionSettings actualResponse =
        client.updateDataRetentionSettings(dataRetentionSettings, updateMask);
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
  public void updateDataRetentionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataRetentionSettings dataRetentionSettings =
          DataRetentionSettings.newBuilder()
              .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
              .setResetUserDataOnNewActivity(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataRetentionSettings(dataRetentionSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataStreamTest() throws Exception {
    DataStream expectedResponse =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    DataStream dataStream = DataStream.newBuilder().build();

    DataStream actualResponse = client.createDataStream(parent, dataStream);
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
  public void createDataStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      DataStream dataStream = DataStream.newBuilder().build();
      client.createDataStream(parent, dataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataStreamTest2() throws Exception {
    DataStream expectedResponse =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    DataStream dataStream = DataStream.newBuilder().build();

    DataStream actualResponse = client.createDataStream(parent, dataStream);
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
  public void createDataStreamExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      DataStream dataStream = DataStream.newBuilder().build();
      client.createDataStream(parent, dataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    client.deleteDataStream(name);

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
  public void deleteDataStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      client.deleteDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-9806/dataStreams/dataStream-9806";

    client.deleteDataStream(name);

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
  public void deleteDataStreamExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-9806/dataStreams/dataStream-9806";
      client.deleteDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataStreamTest() throws Exception {
    DataStream expectedResponse =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStream dataStream =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataStream actualResponse = client.updateDataStream(dataStream, updateMask);
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
  public void updateDataStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStream dataStream =
          DataStream.newBuilder()
              .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataStream(dataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStreamsTest() throws Exception {
    DataStream responsesElement = DataStream.newBuilder().build();
    ListDataStreamsResponse expectedResponse =
        ListDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStreams(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListDataStreamsPagedResponse pagedListResponse = client.listDataStreams(parent);

    List<DataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStreamsList().get(0), resources.get(0));

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
  public void listDataStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStreamsTest2() throws Exception {
    DataStream responsesElement = DataStream.newBuilder().build();
    ListDataStreamsResponse expectedResponse =
        ListDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStreams(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListDataStreamsPagedResponse pagedListResponse = client.listDataStreams(parent);

    List<DataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStreamsList().get(0), resources.get(0));

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
  public void listDataStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataStreamTest() throws Exception {
    DataStream expectedResponse =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    DataStream actualResponse = client.getDataStream(name);
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
  public void getDataStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      client.getDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataStreamTest2() throws Exception {
    DataStream expectedResponse =
        DataStream.newBuilder()
            .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-9806/dataStreams/dataStream-9806";

    DataStream actualResponse = client.getDataStream(name);
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
  public void getDataStreamExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-9806/dataStreams/dataStream-9806";
      client.getDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAudienceTest() throws Exception {
    Audience expectedResponse =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    AudienceName name = AudienceName.of("[PROPERTY]", "[AUDIENCE]");

    Audience actualResponse = client.getAudience(name);
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
  public void getAudienceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AudienceName name = AudienceName.of("[PROPERTY]", "[AUDIENCE]");
      client.getAudience(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAudienceTest2() throws Exception {
    Audience expectedResponse =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-2172/audiences/audience-2172";

    Audience actualResponse = client.getAudience(name);
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
  public void getAudienceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-2172/audiences/audience-2172";
      client.getAudience(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudiencesTest() throws Exception {
    Audience responsesElement = Audience.newBuilder().build();
    ListAudiencesResponse expectedResponse =
        ListAudiencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudiences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListAudiencesPagedResponse pagedListResponse = client.listAudiences(parent);

    List<Audience> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudiencesList().get(0), resources.get(0));

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
  public void listAudiencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listAudiences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudiencesTest2() throws Exception {
    Audience responsesElement = Audience.newBuilder().build();
    ListAudiencesResponse expectedResponse =
        ListAudiencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudiences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListAudiencesPagedResponse pagedListResponse = client.listAudiences(parent);

    List<Audience> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudiencesList().get(0), resources.get(0));

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
  public void listAudiencesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listAudiences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAudienceTest() throws Exception {
    Audience expectedResponse =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    Audience audience = Audience.newBuilder().build();

    Audience actualResponse = client.createAudience(parent, audience);
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
  public void createAudienceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      Audience audience = Audience.newBuilder().build();
      client.createAudience(parent, audience);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAudienceTest2() throws Exception {
    Audience expectedResponse =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    Audience audience = Audience.newBuilder().build();

    Audience actualResponse = client.createAudience(parent, audience);
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
  public void createAudienceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      Audience audience = Audience.newBuilder().build();
      client.createAudience(parent, audience);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAudienceTest() throws Exception {
    Audience expectedResponse =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    Audience audience =
        Audience.newBuilder()
            .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMembershipDurationDays(1702404985)
            .setAdsPersonalizationEnabled(true)
            .setEventTrigger(AudienceEventTrigger.newBuilder().build())
            .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Audience actualResponse = client.updateAudience(audience, updateMask);
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
  public void updateAudienceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Audience audience =
          Audience.newBuilder()
              .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setMembershipDurationDays(1702404985)
              .setAdsPersonalizationEnabled(true)
              .setEventTrigger(AudienceEventTrigger.newBuilder().build())
              .addAllFilterClauses(new ArrayList<AudienceFilterClause>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAudience(audience, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveAudienceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ArchiveAudienceRequest request =
        ArchiveAudienceRequest.newBuilder()
            .setName("properties/propertie-2172/audiences/audience-2172")
            .build();

    client.archiveAudience(request);

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
  public void archiveAudienceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ArchiveAudienceRequest request =
          ArchiveAudienceRequest.newBuilder()
              .setName("properties/propertie-2172/audiences/audience-2172")
              .build();
      client.archiveAudience(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchAds360LinkTest() throws Exception {
    SearchAds360Link expectedResponse =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");

    SearchAds360Link actualResponse = client.getSearchAds360Link(name);
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
  public void getSearchAds360LinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");
      client.getSearchAds360Link(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchAds360LinkTest2() throws Exception {
    SearchAds360Link expectedResponse =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-3689/searchAds360Links/searchAds360Link-3689";

    SearchAds360Link actualResponse = client.getSearchAds360Link(name);
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
  public void getSearchAds360LinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-3689/searchAds360Links/searchAds360Link-3689";
      client.getSearchAds360Link(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchAds360LinksTest() throws Exception {
    SearchAds360Link responsesElement = SearchAds360Link.newBuilder().build();
    ListSearchAds360LinksResponse expectedResponse =
        ListSearchAds360LinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchAds360Links(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListSearchAds360LinksPagedResponse pagedListResponse = client.listSearchAds360Links(parent);

    List<SearchAds360Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchAds360LinksList().get(0), resources.get(0));

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
  public void listSearchAds360LinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listSearchAds360Links(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchAds360LinksTest2() throws Exception {
    SearchAds360Link responsesElement = SearchAds360Link.newBuilder().build();
    ListSearchAds360LinksResponse expectedResponse =
        ListSearchAds360LinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchAds360Links(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListSearchAds360LinksPagedResponse pagedListResponse = client.listSearchAds360Links(parent);

    List<SearchAds360Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchAds360LinksList().get(0), resources.get(0));

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
  public void listSearchAds360LinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listSearchAds360Links(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSearchAds360LinkTest() throws Exception {
    SearchAds360Link expectedResponse =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();

    SearchAds360Link actualResponse = client.createSearchAds360Link(parent, searchAds360Link);
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
  public void createSearchAds360LinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();
      client.createSearchAds360Link(parent, searchAds360Link);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSearchAds360LinkTest2() throws Exception {
    SearchAds360Link expectedResponse =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();

    SearchAds360Link actualResponse = client.createSearchAds360Link(parent, searchAds360Link);
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
  public void createSearchAds360LinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();
      client.createSearchAds360Link(parent, searchAds360Link);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchAds360LinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");

    client.deleteSearchAds360Link(name);

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
  public void deleteSearchAds360LinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");
      client.deleteSearchAds360Link(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchAds360LinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-3689/searchAds360Links/searchAds360Link-3689";

    client.deleteSearchAds360Link(name);

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
  public void deleteSearchAds360LinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-3689/searchAds360Links/searchAds360Link-3689";
      client.deleteSearchAds360Link(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSearchAds360LinkTest() throws Exception {
    SearchAds360Link expectedResponse =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SearchAds360Link searchAds360Link =
        SearchAds360Link.newBuilder()
            .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
            .setAdvertiserId("advertiserId550061990")
            .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
            .setCostDataSharingEnabled(BoolValue.newBuilder().build())
            .setAdvertiserDisplayName("advertiserDisplayName1594116162")
            .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
            .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SearchAds360Link actualResponse = client.updateSearchAds360Link(searchAds360Link, updateMask);
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
  public void updateSearchAds360LinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchAds360Link searchAds360Link =
          SearchAds360Link.newBuilder()
              .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
              .setAdvertiserId("advertiserId550061990")
              .setCampaignDataSharingEnabled(BoolValue.newBuilder().build())
              .setCostDataSharingEnabled(BoolValue.newBuilder().build())
              .setAdvertiserDisplayName("advertiserDisplayName1594116162")
              .setAdsPersonalizationEnabled(BoolValue.newBuilder().build())
              .setSiteStatsSharingEnabled(BoolValue.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSearchAds360Link(searchAds360Link, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributionSettingsTest() throws Exception {
    AttributionSettings expectedResponse =
        AttributionSettings.newBuilder()
            .setName(AttributionSettingsName.of("[PROPERTY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    AttributionSettingsName name = AttributionSettingsName.of("[PROPERTY]");

    AttributionSettings actualResponse = client.getAttributionSettings(name);
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
  public void getAttributionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttributionSettingsName name = AttributionSettingsName.of("[PROPERTY]");
      client.getAttributionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributionSettingsTest2() throws Exception {
    AttributionSettings expectedResponse =
        AttributionSettings.newBuilder()
            .setName(AttributionSettingsName.of("[PROPERTY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-492/attributionSettings";

    AttributionSettings actualResponse = client.getAttributionSettings(name);
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
  public void getAttributionSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-492/attributionSettings";
      client.getAttributionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAttributionSettingsTest() throws Exception {
    AttributionSettings expectedResponse =
        AttributionSettings.newBuilder()
            .setName(AttributionSettingsName.of("[PROPERTY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    AttributionSettings attributionSettings =
        AttributionSettings.newBuilder()
            .setName(AttributionSettingsName.of("[PROPERTY]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AttributionSettings actualResponse =
        client.updateAttributionSettings(attributionSettings, updateMask);
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
  public void updateAttributionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttributionSettings attributionSettings =
          AttributionSettings.newBuilder()
              .setName(AttributionSettingsName.of("[PROPERTY]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAttributionSettings(attributionSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runAccessReportTest() throws Exception {
    RunAccessReportResponse expectedResponse =
        RunAccessReportResponse.newBuilder()
            .addAllDimensionHeaders(new ArrayList<AccessDimensionHeader>())
            .addAllMetricHeaders(new ArrayList<AccessMetricHeader>())
            .addAllRows(new ArrayList<AccessRow>())
            .setRowCount(1340416618)
            .setQuota(AccessQuota.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RunAccessReportRequest request =
        RunAccessReportRequest.newBuilder()
            .setEntity("properties/propertie-4993")
            .addAllDimensions(new ArrayList<AccessDimension>())
            .addAllMetrics(new ArrayList<AccessMetric>())
            .addAllDateRanges(new ArrayList<AccessDateRange>())
            .setDimensionFilter(AccessFilterExpression.newBuilder().build())
            .setMetricFilter(AccessFilterExpression.newBuilder().build())
            .setOffset(-1019779949)
            .setLimit(102976443)
            .setTimeZone("timeZone-2077180903")
            .addAllOrderBys(new ArrayList<AccessOrderBy>())
            .setReturnEntityQuota(true)
            .setIncludeAllUsers(true)
            .setExpandGroups(true)
            .build();

    RunAccessReportResponse actualResponse = client.runAccessReport(request);
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
  public void runAccessReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunAccessReportRequest request =
          RunAccessReportRequest.newBuilder()
              .setEntity("properties/propertie-4993")
              .addAllDimensions(new ArrayList<AccessDimension>())
              .addAllMetrics(new ArrayList<AccessMetric>())
              .addAllDateRanges(new ArrayList<AccessDateRange>())
              .setDimensionFilter(AccessFilterExpression.newBuilder().build())
              .setMetricFilter(AccessFilterExpression.newBuilder().build())
              .setOffset(-1019779949)
              .setLimit(102976443)
              .setTimeZone("timeZone-2077180903")
              .addAllOrderBys(new ArrayList<AccessOrderBy>())
              .setReturnEntityQuota(true)
              .setIncludeAllUsers(true)
              .setExpandGroups(true)
              .build();
      client.runAccessReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccessBindingTest() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    AccessBinding accessBinding = AccessBinding.newBuilder().build();

    AccessBinding actualResponse = client.createAccessBinding(parent, accessBinding);
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
  public void createAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      AccessBinding accessBinding = AccessBinding.newBuilder().build();
      client.createAccessBinding(parent, accessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccessBindingTest2() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    AccessBinding accessBinding = AccessBinding.newBuilder().build();

    AccessBinding actualResponse = client.createAccessBinding(parent, accessBinding);
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
  public void createAccessBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      AccessBinding accessBinding = AccessBinding.newBuilder().build();
      client.createAccessBinding(parent, accessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccessBindingTest3() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    AccessBinding accessBinding = AccessBinding.newBuilder().build();

    AccessBinding actualResponse = client.createAccessBinding(parent, accessBinding);
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
  public void createAccessBindingExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      AccessBinding accessBinding = AccessBinding.newBuilder().build();
      client.createAccessBinding(parent, accessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessBindingTest() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AccessBindingName name =
        AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");

    AccessBinding actualResponse = client.getAccessBinding(name);
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
  public void getAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessBindingName name =
          AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");
      client.getAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessBindingTest2() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3488/accessBindings/accessBinding-3488";

    AccessBinding actualResponse = client.getAccessBinding(name);
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
  public void getAccessBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3488/accessBindings/accessBinding-3488";
      client.getAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccessBindingTest() throws Exception {
    AccessBinding expectedResponse =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AccessBinding accessBinding =
        AccessBinding.newBuilder()
            .setName(
                AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                    .toString())
            .addAllRoles(new ArrayList<String>())
            .build();

    AccessBinding actualResponse = client.updateAccessBinding(accessBinding);
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
  public void updateAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessBinding accessBinding =
          AccessBinding.newBuilder()
              .setName(
                  AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
                      .toString())
              .addAllRoles(new ArrayList<String>())
              .build();
      client.updateAccessBinding(accessBinding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AccessBindingName name =
        AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");

    client.deleteAccessBinding(name);

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
  public void deleteAccessBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessBindingName name =
          AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");
      client.deleteAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3488/accessBindings/accessBinding-3488";

    client.deleteAccessBinding(name);

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
  public void deleteAccessBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3488/accessBindings/accessBinding-3488";
      client.deleteAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessBindingsTest() throws Exception {
    AccessBinding responsesElement = AccessBinding.newBuilder().build();
    ListAccessBindingsResponse expectedResponse =
        ListAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccessBindingsPagedResponse pagedListResponse = client.listAccessBindings(parent);

    List<AccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessBindingsList().get(0), resources.get(0));

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
  public void listAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessBindingsTest2() throws Exception {
    AccessBinding responsesElement = AccessBinding.newBuilder().build();
    ListAccessBindingsResponse expectedResponse =
        ListAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListAccessBindingsPagedResponse pagedListResponse = client.listAccessBindings(parent);

    List<AccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessBindingsList().get(0), resources.get(0));

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
  public void listAccessBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessBindingsTest3() throws Exception {
    AccessBinding responsesElement = AccessBinding.newBuilder().build();
    ListAccessBindingsResponse expectedResponse =
        ListAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListAccessBindingsPagedResponse pagedListResponse = client.listAccessBindings(parent);

    List<AccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessBindingsList().get(0), resources.get(0));

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
  public void listAccessBindingsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateAccessBindingsTest() throws Exception {
    BatchCreateAccessBindingsResponse expectedResponse =
        BatchCreateAccessBindingsResponse.newBuilder()
            .addAllAccessBindings(new ArrayList<AccessBinding>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchCreateAccessBindingsRequest request =
        BatchCreateAccessBindingsRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllRequests(new ArrayList<CreateAccessBindingRequest>())
            .build();

    BatchCreateAccessBindingsResponse actualResponse = client.batchCreateAccessBindings(request);
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
  public void batchCreateAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchCreateAccessBindingsRequest request =
          BatchCreateAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<CreateAccessBindingRequest>())
              .build();
      client.batchCreateAccessBindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetAccessBindingsTest() throws Exception {
    BatchGetAccessBindingsResponse expectedResponse =
        BatchGetAccessBindingsResponse.newBuilder()
            .addAllAccessBindings(new ArrayList<AccessBinding>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchGetAccessBindingsRequest request =
        BatchGetAccessBindingsRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetAccessBindingsResponse actualResponse = client.batchGetAccessBindings(request);
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
  public void batchGetAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchGetAccessBindingsRequest request =
          BatchGetAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetAccessBindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateAccessBindingsTest() throws Exception {
    BatchUpdateAccessBindingsResponse expectedResponse =
        BatchUpdateAccessBindingsResponse.newBuilder()
            .addAllAccessBindings(new ArrayList<AccessBinding>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchUpdateAccessBindingsRequest request =
        BatchUpdateAccessBindingsRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllRequests(new ArrayList<UpdateAccessBindingRequest>())
            .build();

    BatchUpdateAccessBindingsResponse actualResponse = client.batchUpdateAccessBindings(request);
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
  public void batchUpdateAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchUpdateAccessBindingsRequest request =
          BatchUpdateAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<UpdateAccessBindingRequest>())
              .build();
      client.batchUpdateAccessBindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteAccessBindingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BatchDeleteAccessBindingsRequest request =
        BatchDeleteAccessBindingsRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllRequests(new ArrayList<DeleteAccessBindingRequest>())
            .build();

    client.batchDeleteAccessBindings(request);

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
  public void batchDeleteAccessBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchDeleteAccessBindingsRequest request =
          BatchDeleteAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<DeleteAccessBindingRequest>())
              .build();
      client.batchDeleteAccessBindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExpandedDataSetTest() throws Exception {
    ExpandedDataSet expectedResponse =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");

    ExpandedDataSet actualResponse = client.getExpandedDataSet(name);
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
  public void getExpandedDataSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");
      client.getExpandedDataSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExpandedDataSetTest2() throws Exception {
    ExpandedDataSet expectedResponse =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-4725/expandedDataSets/expandedDataSet-4725";

    ExpandedDataSet actualResponse = client.getExpandedDataSet(name);
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
  public void getExpandedDataSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-4725/expandedDataSets/expandedDataSet-4725";
      client.getExpandedDataSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExpandedDataSetsTest() throws Exception {
    ExpandedDataSet responsesElement = ExpandedDataSet.newBuilder().build();
    ListExpandedDataSetsResponse expectedResponse =
        ListExpandedDataSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExpandedDataSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListExpandedDataSetsPagedResponse pagedListResponse = client.listExpandedDataSets(parent);

    List<ExpandedDataSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExpandedDataSetsList().get(0), resources.get(0));

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
  public void listExpandedDataSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listExpandedDataSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExpandedDataSetsTest2() throws Exception {
    ExpandedDataSet responsesElement = ExpandedDataSet.newBuilder().build();
    ListExpandedDataSetsResponse expectedResponse =
        ListExpandedDataSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExpandedDataSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListExpandedDataSetsPagedResponse pagedListResponse = client.listExpandedDataSets(parent);

    List<ExpandedDataSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExpandedDataSetsList().get(0), resources.get(0));

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
  public void listExpandedDataSetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listExpandedDataSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExpandedDataSetTest() throws Exception {
    ExpandedDataSet expectedResponse =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();

    ExpandedDataSet actualResponse = client.createExpandedDataSet(parent, expandedDataSet);
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
  public void createExpandedDataSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();
      client.createExpandedDataSet(parent, expandedDataSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExpandedDataSetTest2() throws Exception {
    ExpandedDataSet expectedResponse =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();

    ExpandedDataSet actualResponse = client.createExpandedDataSet(parent, expandedDataSet);
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
  public void createExpandedDataSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();
      client.createExpandedDataSet(parent, expandedDataSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExpandedDataSetTest() throws Exception {
    ExpandedDataSet expectedResponse =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ExpandedDataSet expandedDataSet =
        ExpandedDataSet.newBuilder()
            .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDimensionNames(new ArrayList<String>())
            .addAllMetricNames(new ArrayList<String>())
            .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
            .setDataCollectionStartTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExpandedDataSet actualResponse = client.updateExpandedDataSet(expandedDataSet, updateMask);
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
  public void updateExpandedDataSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExpandedDataSet expandedDataSet =
          ExpandedDataSet.newBuilder()
              .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllDimensionNames(new ArrayList<String>())
              .addAllMetricNames(new ArrayList<String>())
              .setDimensionFilterExpression(ExpandedDataSetFilterExpression.newBuilder().build())
              .setDataCollectionStartTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExpandedDataSet(expandedDataSet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExpandedDataSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");

    client.deleteExpandedDataSet(name);

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
  public void deleteExpandedDataSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");
      client.deleteExpandedDataSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExpandedDataSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-4725/expandedDataSets/expandedDataSet-4725";

    client.deleteExpandedDataSet(name);

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
  public void deleteExpandedDataSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-4725/expandedDataSets/expandedDataSet-4725";
      client.deleteExpandedDataSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelGroupTest() throws Exception {
    ChannelGroup expectedResponse =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    mockService.addResponse(expectedResponse);

    ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");

    ChannelGroup actualResponse = client.getChannelGroup(name);
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
  public void getChannelGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");
      client.getChannelGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelGroupTest2() throws Exception {
    ChannelGroup expectedResponse =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-836/channelGroups/channelGroup-836";

    ChannelGroup actualResponse = client.getChannelGroup(name);
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
  public void getChannelGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-836/channelGroups/channelGroup-836";
      client.getChannelGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelGroupsTest() throws Exception {
    ChannelGroup responsesElement = ChannelGroup.newBuilder().build();
    ListChannelGroupsResponse expectedResponse =
        ListChannelGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListChannelGroupsPagedResponse pagedListResponse = client.listChannelGroups(parent);

    List<ChannelGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelGroupsList().get(0), resources.get(0));

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
  public void listChannelGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listChannelGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelGroupsTest2() throws Exception {
    ChannelGroup responsesElement = ChannelGroup.newBuilder().build();
    ListChannelGroupsResponse expectedResponse =
        ListChannelGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListChannelGroupsPagedResponse pagedListResponse = client.listChannelGroups(parent);

    List<ChannelGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelGroupsList().get(0), resources.get(0));

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
  public void listChannelGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listChannelGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelGroupTest() throws Exception {
    ChannelGroup expectedResponse =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    ChannelGroup channelGroup = ChannelGroup.newBuilder().build();

    ChannelGroup actualResponse = client.createChannelGroup(parent, channelGroup);
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
  public void createChannelGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      ChannelGroup channelGroup = ChannelGroup.newBuilder().build();
      client.createChannelGroup(parent, channelGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelGroupTest2() throws Exception {
    ChannelGroup expectedResponse =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    ChannelGroup channelGroup = ChannelGroup.newBuilder().build();

    ChannelGroup actualResponse = client.createChannelGroup(parent, channelGroup);
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
  public void createChannelGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      ChannelGroup channelGroup = ChannelGroup.newBuilder().build();
      client.createChannelGroup(parent, channelGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateChannelGroupTest() throws Exception {
    ChannelGroup expectedResponse =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    mockService.addResponse(expectedResponse);

    ChannelGroup channelGroup =
        ChannelGroup.newBuilder()
            .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupingRule(new ArrayList<GroupingRule>())
            .setSystemDefined(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ChannelGroup actualResponse = client.updateChannelGroup(channelGroup, updateMask);
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
  public void updateChannelGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelGroup channelGroup =
          ChannelGroup.newBuilder()
              .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllGroupingRule(new ArrayList<GroupingRule>())
              .setSystemDefined(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateChannelGroup(channelGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteChannelGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");

    client.deleteChannelGroup(name);

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
  public void deleteChannelGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");
      client.deleteChannelGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteChannelGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-836/channelGroups/channelGroup-836";

    client.deleteChannelGroup(name);

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
  public void deleteChannelGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-836/channelGroups/channelGroup-836";
      client.deleteChannelGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setAutomatedGa4ConfigurationOptOutTest() throws Exception {
    SetAutomatedGa4ConfigurationOptOutResponse expectedResponse =
        SetAutomatedGa4ConfigurationOptOutResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SetAutomatedGa4ConfigurationOptOutRequest request =
        SetAutomatedGa4ConfigurationOptOutRequest.newBuilder()
            .setProperty("property-993141291")
            .setOptOut(true)
            .build();

    SetAutomatedGa4ConfigurationOptOutResponse actualResponse =
        client.setAutomatedGa4ConfigurationOptOut(request);
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
  public void setAutomatedGa4ConfigurationOptOutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetAutomatedGa4ConfigurationOptOutRequest request =
          SetAutomatedGa4ConfigurationOptOutRequest.newBuilder()
              .setProperty("property-993141291")
              .setOptOut(true)
              .build();
      client.setAutomatedGa4ConfigurationOptOut(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchAutomatedGa4ConfigurationOptOutTest() throws Exception {
    FetchAutomatedGa4ConfigurationOptOutResponse expectedResponse =
        FetchAutomatedGa4ConfigurationOptOutResponse.newBuilder().setOptOut(true).build();
    mockService.addResponse(expectedResponse);

    FetchAutomatedGa4ConfigurationOptOutRequest request =
        FetchAutomatedGa4ConfigurationOptOutRequest.newBuilder()
            .setProperty("property-993141291")
            .build();

    FetchAutomatedGa4ConfigurationOptOutResponse actualResponse =
        client.fetchAutomatedGa4ConfigurationOptOut(request);
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
  public void fetchAutomatedGa4ConfigurationOptOutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchAutomatedGa4ConfigurationOptOutRequest request =
          FetchAutomatedGa4ConfigurationOptOutRequest.newBuilder()
              .setProperty("property-993141291")
              .build();
      client.fetchAutomatedGa4ConfigurationOptOut(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBigQueryLinkTest() throws Exception {
    BigQueryLink expectedResponse =
        BigQueryLink.newBuilder()
            .setName(BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]").toString())
            .setProject("project-309310695")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDailyExportEnabled(true)
            .setStreamingExportEnabled(true)
            .setFreshDailyExportEnabled(true)
            .setIncludeAdvertisingId(true)
            .addAllExportStreams(new ArrayList<String>())
            .addAllExcludedEvents(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    BigQueryLinkName name = BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]");

    BigQueryLink actualResponse = client.getBigQueryLink(name);
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
  public void getBigQueryLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BigQueryLinkName name = BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]");
      client.getBigQueryLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBigQueryLinkTest2() throws Exception {
    BigQueryLink expectedResponse =
        BigQueryLink.newBuilder()
            .setName(BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]").toString())
            .setProject("project-309310695")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDailyExportEnabled(true)
            .setStreamingExportEnabled(true)
            .setFreshDailyExportEnabled(true)
            .setIncludeAdvertisingId(true)
            .addAllExportStreams(new ArrayList<String>())
            .addAllExcludedEvents(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-7430/bigQueryLinks/bigQueryLink-7430";

    BigQueryLink actualResponse = client.getBigQueryLink(name);
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
  public void getBigQueryLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-7430/bigQueryLinks/bigQueryLink-7430";
      client.getBigQueryLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryLinksTest() throws Exception {
    BigQueryLink responsesElement = BigQueryLink.newBuilder().build();
    ListBigQueryLinksResponse expectedResponse =
        ListBigQueryLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigqueryLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListBigQueryLinksPagedResponse pagedListResponse = client.listBigQueryLinks(parent);

    List<BigQueryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigqueryLinksList().get(0), resources.get(0));

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
  public void listBigQueryLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listBigQueryLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryLinksTest2() throws Exception {
    BigQueryLink responsesElement = BigQueryLink.newBuilder().build();
    ListBigQueryLinksResponse expectedResponse =
        ListBigQueryLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigqueryLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListBigQueryLinksPagedResponse pagedListResponse = client.listBigQueryLinks(parent);

    List<BigQueryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigqueryLinksList().get(0), resources.get(0));

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
  public void listBigQueryLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listBigQueryLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnhancedMeasurementSettingsTest() throws Exception {
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageChangesEnabled(true)
            .setFormInteractionsEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockService.addResponse(expectedResponse);

    EnhancedMeasurementSettingsName name =
        EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]");

    EnhancedMeasurementSettings actualResponse = client.getEnhancedMeasurementSettings(name);
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
  public void getEnhancedMeasurementSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnhancedMeasurementSettingsName name =
          EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]");
      client.getEnhancedMeasurementSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnhancedMeasurementSettingsTest2() throws Exception {
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageChangesEnabled(true)
            .setFormInteractionsEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-5816/dataStreams/dataStream-5816/enhancedMeasurementSettings";

    EnhancedMeasurementSettings actualResponse = client.getEnhancedMeasurementSettings(name);
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
  public void getEnhancedMeasurementSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-5816/dataStreams/dataStream-5816/enhancedMeasurementSettings";
      client.getEnhancedMeasurementSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEnhancedMeasurementSettingsTest() throws Exception {
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageChangesEnabled(true)
            .setFormInteractionsEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockService.addResponse(expectedResponse);

    EnhancedMeasurementSettings enhancedMeasurementSettings =
        EnhancedMeasurementSettings.newBuilder()
            .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageChangesEnabled(true)
            .setFormInteractionsEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EnhancedMeasurementSettings actualResponse =
        client.updateEnhancedMeasurementSettings(enhancedMeasurementSettings, updateMask);
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
  public void updateEnhancedMeasurementSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnhancedMeasurementSettings enhancedMeasurementSettings =
          EnhancedMeasurementSettings.newBuilder()
              .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
              .setStreamEnabled(true)
              .setScrollsEnabled(true)
              .setOutboundClicksEnabled(true)
              .setSiteSearchEnabled(true)
              .setVideoEngagementEnabled(true)
              .setFileDownloadsEnabled(true)
              .setPageChangesEnabled(true)
              .setFormInteractionsEnabled(true)
              .setSearchQueryParameter("searchQueryParameter-2012788855")
              .setUriQueryParameter("uriQueryParameter1580843085")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnhancedMeasurementSettings(enhancedMeasurementSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectedSiteTagTest() throws Exception {
    CreateConnectedSiteTagResponse expectedResponse =
        CreateConnectedSiteTagResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CreateConnectedSiteTagRequest request =
        CreateConnectedSiteTagRequest.newBuilder()
            .setProperty("property-993141291")
            .setConnectedSiteTag(ConnectedSiteTag.newBuilder().build())
            .build();

    CreateConnectedSiteTagResponse actualResponse = client.createConnectedSiteTag(request);
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
  public void createConnectedSiteTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateConnectedSiteTagRequest request =
          CreateConnectedSiteTagRequest.newBuilder()
              .setProperty("property-993141291")
              .setConnectedSiteTag(ConnectedSiteTag.newBuilder().build())
              .build();
      client.createConnectedSiteTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectedSiteTagTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteConnectedSiteTagRequest request =
        DeleteConnectedSiteTagRequest.newBuilder()
            .setProperty("property-993141291")
            .setTagId("tagId110119509")
            .build();

    client.deleteConnectedSiteTag(request);

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
  public void deleteConnectedSiteTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteConnectedSiteTagRequest request =
          DeleteConnectedSiteTagRequest.newBuilder()
              .setProperty("property-993141291")
              .setTagId("tagId110119509")
              .build();
      client.deleteConnectedSiteTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectedSiteTagsTest() throws Exception {
    ListConnectedSiteTagsResponse expectedResponse =
        ListConnectedSiteTagsResponse.newBuilder()
            .addAllConnectedSiteTags(new ArrayList<ConnectedSiteTag>())
            .build();
    mockService.addResponse(expectedResponse);

    ListConnectedSiteTagsRequest request =
        ListConnectedSiteTagsRequest.newBuilder().setProperty("property-993141291").build();

    ListConnectedSiteTagsResponse actualResponse = client.listConnectedSiteTags(request);
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
  public void listConnectedSiteTagsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListConnectedSiteTagsRequest request =
          ListConnectedSiteTagsRequest.newBuilder().setProperty("property-993141291").build();
      client.listConnectedSiteTags(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchConnectedGa4PropertyTest() throws Exception {
    FetchConnectedGa4PropertyResponse expectedResponse =
        FetchConnectedGa4PropertyResponse.newBuilder()
            .setProperty(PropertyName.of("[PROPERTY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    FetchConnectedGa4PropertyRequest request =
        FetchConnectedGa4PropertyRequest.newBuilder()
            .setProperty(PropertyName.of("[PROPERTY]").toString())
            .build();

    FetchConnectedGa4PropertyResponse actualResponse = client.fetchConnectedGa4Property(request);
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
  public void fetchConnectedGa4PropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchConnectedGa4PropertyRequest request =
          FetchConnectedGa4PropertyRequest.newBuilder()
              .setProperty(PropertyName.of("[PROPERTY]").toString())
              .build();
      client.fetchConnectedGa4Property(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdSenseLinkTest() throws Exception {
    AdSenseLink expectedResponse =
        AdSenseLink.newBuilder()
            .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
            .setAdClientCode("adClientCode-869953317")
            .build();
    mockService.addResponse(expectedResponse);

    AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");

    AdSenseLink actualResponse = client.getAdSenseLink(name);
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
  public void getAdSenseLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");
      client.getAdSenseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdSenseLinkTest2() throws Exception {
    AdSenseLink expectedResponse =
        AdSenseLink.newBuilder()
            .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
            .setAdClientCode("adClientCode-869953317")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-9633/adSenseLinks/adSenseLink-9633";

    AdSenseLink actualResponse = client.getAdSenseLink(name);
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
  public void getAdSenseLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-9633/adSenseLinks/adSenseLink-9633";
      client.getAdSenseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdSenseLinkTest() throws Exception {
    AdSenseLink expectedResponse =
        AdSenseLink.newBuilder()
            .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
            .setAdClientCode("adClientCode-869953317")
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();

    AdSenseLink actualResponse = client.createAdSenseLink(parent, adsenseLink);
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
  public void createAdSenseLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();
      client.createAdSenseLink(parent, adsenseLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdSenseLinkTest2() throws Exception {
    AdSenseLink expectedResponse =
        AdSenseLink.newBuilder()
            .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
            .setAdClientCode("adClientCode-869953317")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();

    AdSenseLink actualResponse = client.createAdSenseLink(parent, adsenseLink);
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
  public void createAdSenseLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();
      client.createAdSenseLink(parent, adsenseLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdSenseLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");

    client.deleteAdSenseLink(name);

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
  public void deleteAdSenseLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");
      client.deleteAdSenseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdSenseLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-9633/adSenseLinks/adSenseLink-9633";

    client.deleteAdSenseLink(name);

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
  public void deleteAdSenseLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-9633/adSenseLinks/adSenseLink-9633";
      client.deleteAdSenseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdSenseLinksTest() throws Exception {
    AdSenseLink responsesElement = AdSenseLink.newBuilder().build();
    ListAdSenseLinksResponse expectedResponse =
        ListAdSenseLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdsenseLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListAdSenseLinksPagedResponse pagedListResponse = client.listAdSenseLinks(parent);

    List<AdSenseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdsenseLinksList().get(0), resources.get(0));

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
  public void listAdSenseLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listAdSenseLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdSenseLinksTest2() throws Exception {
    AdSenseLink responsesElement = AdSenseLink.newBuilder().build();
    ListAdSenseLinksResponse expectedResponse =
        ListAdSenseLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdsenseLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListAdSenseLinksPagedResponse pagedListResponse = client.listAdSenseLinks(parent);

    List<AdSenseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdsenseLinksList().get(0), resources.get(0));

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
  public void listAdSenseLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listAdSenseLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventCreateRuleTest() throws Exception {
    EventCreateRule expectedResponse =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    mockService.addResponse(expectedResponse);

    EventCreateRuleName name =
        EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");

    EventCreateRule actualResponse = client.getEventCreateRule(name);
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
  public void getEventCreateRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventCreateRuleName name =
          EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");
      client.getEventCreateRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventCreateRuleTest2() throws Exception {
    EventCreateRule expectedResponse =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-8819/dataStreams/dataStream-8819/eventCreateRules/eventCreateRule-8819";

    EventCreateRule actualResponse = client.getEventCreateRule(name);
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
  public void getEventCreateRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-8819/dataStreams/dataStream-8819/eventCreateRules/eventCreateRule-8819";
      client.getEventCreateRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventCreateRulesTest() throws Exception {
    EventCreateRule responsesElement = EventCreateRule.newBuilder().build();
    ListEventCreateRulesResponse expectedResponse =
        ListEventCreateRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventCreateRules(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    ListEventCreateRulesPagedResponse pagedListResponse = client.listEventCreateRules(parent);

    List<EventCreateRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventCreateRulesList().get(0), resources.get(0));

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
  public void listEventCreateRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      client.listEventCreateRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventCreateRulesTest2() throws Exception {
    EventCreateRule responsesElement = EventCreateRule.newBuilder().build();
    ListEventCreateRulesResponse expectedResponse =
        ListEventCreateRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventCreateRules(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";

    ListEventCreateRulesPagedResponse pagedListResponse = client.listEventCreateRules(parent);

    List<EventCreateRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventCreateRulesList().get(0), resources.get(0));

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
  public void listEventCreateRulesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      client.listEventCreateRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventCreateRuleTest() throws Exception {
    EventCreateRule expectedResponse =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    mockService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
    EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();

    EventCreateRule actualResponse = client.createEventCreateRule(parent, eventCreateRule);
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
  public void createEventCreateRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
      EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();
      client.createEventCreateRule(parent, eventCreateRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventCreateRuleTest2() throws Exception {
    EventCreateRule expectedResponse =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
    EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();

    EventCreateRule actualResponse = client.createEventCreateRule(parent, eventCreateRule);
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
  public void createEventCreateRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-9651/dataStreams/dataStream-9651";
      EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();
      client.createEventCreateRule(parent, eventCreateRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEventCreateRuleTest() throws Exception {
    EventCreateRule expectedResponse =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    mockService.addResponse(expectedResponse);

    EventCreateRule eventCreateRule =
        EventCreateRule.newBuilder()
            .setName(
                EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                    .toString())
            .setDestinationEvent("destinationEvent1181456172")
            .addAllEventConditions(new ArrayList<MatchingCondition>())
            .setSourceCopyParameters(true)
            .addAllParameterMutations(new ArrayList<ParameterMutation>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EventCreateRule actualResponse = client.updateEventCreateRule(eventCreateRule, updateMask);
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
  public void updateEventCreateRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventCreateRule eventCreateRule =
          EventCreateRule.newBuilder()
              .setName(
                  EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
                      .toString())
              .setDestinationEvent("destinationEvent1181456172")
              .addAllEventConditions(new ArrayList<MatchingCondition>())
              .setSourceCopyParameters(true)
              .addAllParameterMutations(new ArrayList<ParameterMutation>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEventCreateRule(eventCreateRule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventCreateRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EventCreateRuleName name =
        EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");

    client.deleteEventCreateRule(name);

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
  public void deleteEventCreateRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventCreateRuleName name =
          EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");
      client.deleteEventCreateRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventCreateRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-8819/dataStreams/dataStream-8819/eventCreateRules/eventCreateRule-8819";

    client.deleteEventCreateRule(name);

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
  public void deleteEventCreateRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-8819/dataStreams/dataStream-8819/eventCreateRules/eventCreateRule-8819";
      client.deleteEventCreateRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataRedactionSettingsTest() throws Exception {
    DataRedactionSettings expectedResponse =
        DataRedactionSettings.newBuilder()
            .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setEmailRedactionEnabled(true)
            .setQueryParameterRedactionEnabled(true)
            .addAllQueryParameterKeys(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    DataRedactionSettings dataRedactionSettings =
        DataRedactionSettings.newBuilder()
            .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setEmailRedactionEnabled(true)
            .setQueryParameterRedactionEnabled(true)
            .addAllQueryParameterKeys(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataRedactionSettings actualResponse =
        client.updateDataRedactionSettings(dataRedactionSettings, updateMask);
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
  public void updateDataRedactionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataRedactionSettings dataRedactionSettings =
          DataRedactionSettings.newBuilder()
              .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
              .setEmailRedactionEnabled(true)
              .setQueryParameterRedactionEnabled(true)
              .addAllQueryParameterKeys(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataRedactionSettings(dataRedactionSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataRedactionSettingsTest() throws Exception {
    DataRedactionSettings expectedResponse =
        DataRedactionSettings.newBuilder()
            .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setEmailRedactionEnabled(true)
            .setQueryParameterRedactionEnabled(true)
            .addAllQueryParameterKeys(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    DataRedactionSettingsName name = DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]");

    DataRedactionSettings actualResponse = client.getDataRedactionSettings(name);
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
  public void getDataRedactionSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataRedactionSettingsName name = DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]");
      client.getDataRedactionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataRedactionSettingsTest2() throws Exception {
    DataRedactionSettings expectedResponse =
        DataRedactionSettings.newBuilder()
            .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
            .setEmailRedactionEnabled(true)
            .setQueryParameterRedactionEnabled(true)
            .addAllQueryParameterKeys(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-6817/dataStreams/dataStream-6817/dataRedactionSettings";

    DataRedactionSettings actualResponse = client.getDataRedactionSettings(name);
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
  public void getDataRedactionSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-6817/dataStreams/dataStream-6817/dataRedactionSettings";
      client.getDataRedactionSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCalculatedMetricTest() throws Exception {
    CalculatedMetric expectedResponse =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    mockService.addResponse(expectedResponse);

    CalculatedMetricName name = CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]");

    CalculatedMetric actualResponse = client.getCalculatedMetric(name);
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
  public void getCalculatedMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CalculatedMetricName name = CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]");
      client.getCalculatedMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCalculatedMetricTest2() throws Exception {
    CalculatedMetric expectedResponse =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-3802/calculatedMetrics/calculatedMetric-3802";

    CalculatedMetric actualResponse = client.getCalculatedMetric(name);
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
  public void getCalculatedMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-3802/calculatedMetrics/calculatedMetric-3802";
      client.getCalculatedMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCalculatedMetricTest() throws Exception {
    CalculatedMetric expectedResponse =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    CalculatedMetric calculatedMetric = CalculatedMetric.newBuilder().build();
    String calculatedMetricId = "calculatedMetricId-277970231";

    CalculatedMetric actualResponse =
        client.createCalculatedMetric(parent, calculatedMetric, calculatedMetricId);
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
  public void createCalculatedMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      CalculatedMetric calculatedMetric = CalculatedMetric.newBuilder().build();
      String calculatedMetricId = "calculatedMetricId-277970231";
      client.createCalculatedMetric(parent, calculatedMetric, calculatedMetricId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCalculatedMetricTest2() throws Exception {
    CalculatedMetric expectedResponse =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    CalculatedMetric calculatedMetric = CalculatedMetric.newBuilder().build();
    String calculatedMetricId = "calculatedMetricId-277970231";

    CalculatedMetric actualResponse =
        client.createCalculatedMetric(parent, calculatedMetric, calculatedMetricId);
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
  public void createCalculatedMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      CalculatedMetric calculatedMetric = CalculatedMetric.newBuilder().build();
      String calculatedMetricId = "calculatedMetricId-277970231";
      client.createCalculatedMetric(parent, calculatedMetric, calculatedMetricId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCalculatedMetricsTest() throws Exception {
    CalculatedMetric responsesElement = CalculatedMetric.newBuilder().build();
    ListCalculatedMetricsResponse expectedResponse =
        ListCalculatedMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCalculatedMetrics(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListCalculatedMetricsPagedResponse pagedListResponse = client.listCalculatedMetrics(parent);

    List<CalculatedMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCalculatedMetricsList().get(0), resources.get(0));

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
  public void listCalculatedMetricsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listCalculatedMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCalculatedMetricsTest2() throws Exception {
    CalculatedMetric responsesElement = CalculatedMetric.newBuilder().build();
    ListCalculatedMetricsResponse expectedResponse =
        ListCalculatedMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCalculatedMetrics(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListCalculatedMetricsPagedResponse pagedListResponse = client.listCalculatedMetrics(parent);

    List<CalculatedMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCalculatedMetricsList().get(0), resources.get(0));

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
  public void listCalculatedMetricsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listCalculatedMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCalculatedMetricTest() throws Exception {
    CalculatedMetric expectedResponse =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    mockService.addResponse(expectedResponse);

    CalculatedMetric calculatedMetric =
        CalculatedMetric.newBuilder()
            .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setCalculatedMetricId("calculatedMetricId-277970231")
            .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
            .setFormula("formula-677424794")
            .setInvalidMetricReference(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CalculatedMetric actualResponse = client.updateCalculatedMetric(calculatedMetric, updateMask);
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
  public void updateCalculatedMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CalculatedMetric calculatedMetric =
          CalculatedMetric.newBuilder()
              .setName(CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]").toString())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .setCalculatedMetricId("calculatedMetricId-277970231")
              .addAllRestrictedMetricType(new ArrayList<CalculatedMetric.RestrictedMetricType>())
              .setFormula("formula-677424794")
              .setInvalidMetricReference(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCalculatedMetric(calculatedMetric, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCalculatedMetricTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CalculatedMetricName name = CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]");

    client.deleteCalculatedMetric(name);

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
  public void deleteCalculatedMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CalculatedMetricName name = CalculatedMetricName.of("[PROPERTY]", "[CALCULATED_METRIC]");
      client.deleteCalculatedMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCalculatedMetricTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-3802/calculatedMetrics/calculatedMetric-3802";

    client.deleteCalculatedMetric(name);

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
  public void deleteCalculatedMetricExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-3802/calculatedMetrics/calculatedMetric-3802";
      client.deleteCalculatedMetric(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRollupPropertyTest() throws Exception {
    CreateRollupPropertyResponse expectedResponse =
        CreateRollupPropertyResponse.newBuilder()
            .setRollupProperty(Property.newBuilder().build())
            .addAllRollupPropertySourceLinks(new ArrayList<RollupPropertySourceLink>())
            .build();
    mockService.addResponse(expectedResponse);

    CreateRollupPropertyRequest request =
        CreateRollupPropertyRequest.newBuilder()
            .setRollupProperty(Property.newBuilder().build())
            .addAllSourceProperties(new ArrayList<String>())
            .build();

    CreateRollupPropertyResponse actualResponse = client.createRollupProperty(request);
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
  public void createRollupPropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateRollupPropertyRequest request =
          CreateRollupPropertyRequest.newBuilder()
              .setRollupProperty(Property.newBuilder().build())
              .addAllSourceProperties(new ArrayList<String>())
              .build();
      client.createRollupProperty(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRollupPropertySourceLinkTest() throws Exception {
    RollupPropertySourceLink expectedResponse =
        RollupPropertySourceLink.newBuilder()
            .setName(
                RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
                    .toString())
            .setSourceProperty("sourceProperty1938317072")
            .build();
    mockService.addResponse(expectedResponse);

    RollupPropertySourceLinkName name =
        RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");

    RollupPropertySourceLink actualResponse = client.getRollupPropertySourceLink(name);
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
  public void getRollupPropertySourceLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RollupPropertySourceLinkName name =
          RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");
      client.getRollupPropertySourceLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRollupPropertySourceLinkTest2() throws Exception {
    RollupPropertySourceLink expectedResponse =
        RollupPropertySourceLink.newBuilder()
            .setName(
                RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
                    .toString())
            .setSourceProperty("sourceProperty1938317072")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-3766/rollupPropertySourceLinks/rollupPropertySourceLink-3766";

    RollupPropertySourceLink actualResponse = client.getRollupPropertySourceLink(name);
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
  public void getRollupPropertySourceLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-3766/rollupPropertySourceLinks/rollupPropertySourceLink-3766";
      client.getRollupPropertySourceLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRollupPropertySourceLinksTest() throws Exception {
    RollupPropertySourceLink responsesElement = RollupPropertySourceLink.newBuilder().build();
    ListRollupPropertySourceLinksResponse expectedResponse =
        ListRollupPropertySourceLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollupPropertySourceLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListRollupPropertySourceLinksPagedResponse pagedListResponse =
        client.listRollupPropertySourceLinks(parent);

    List<RollupPropertySourceLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRollupPropertySourceLinksList().get(0), resources.get(0));

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
  public void listRollupPropertySourceLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listRollupPropertySourceLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRollupPropertySourceLinksTest2() throws Exception {
    RollupPropertySourceLink responsesElement = RollupPropertySourceLink.newBuilder().build();
    ListRollupPropertySourceLinksResponse expectedResponse =
        ListRollupPropertySourceLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollupPropertySourceLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListRollupPropertySourceLinksPagedResponse pagedListResponse =
        client.listRollupPropertySourceLinks(parent);

    List<RollupPropertySourceLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRollupPropertySourceLinksList().get(0), resources.get(0));

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
  public void listRollupPropertySourceLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listRollupPropertySourceLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRollupPropertySourceLinkTest() throws Exception {
    RollupPropertySourceLink expectedResponse =
        RollupPropertySourceLink.newBuilder()
            .setName(
                RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
                    .toString())
            .setSourceProperty("sourceProperty1938317072")
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    RollupPropertySourceLink rollupPropertySourceLink =
        RollupPropertySourceLink.newBuilder().build();

    RollupPropertySourceLink actualResponse =
        client.createRollupPropertySourceLink(parent, rollupPropertySourceLink);
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
  public void createRollupPropertySourceLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      RollupPropertySourceLink rollupPropertySourceLink =
          RollupPropertySourceLink.newBuilder().build();
      client.createRollupPropertySourceLink(parent, rollupPropertySourceLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRollupPropertySourceLinkTest2() throws Exception {
    RollupPropertySourceLink expectedResponse =
        RollupPropertySourceLink.newBuilder()
            .setName(
                RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
                    .toString())
            .setSourceProperty("sourceProperty1938317072")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    RollupPropertySourceLink rollupPropertySourceLink =
        RollupPropertySourceLink.newBuilder().build();

    RollupPropertySourceLink actualResponse =
        client.createRollupPropertySourceLink(parent, rollupPropertySourceLink);
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
  public void createRollupPropertySourceLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      RollupPropertySourceLink rollupPropertySourceLink =
          RollupPropertySourceLink.newBuilder().build();
      client.createRollupPropertySourceLink(parent, rollupPropertySourceLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRollupPropertySourceLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RollupPropertySourceLinkName name =
        RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");

    client.deleteRollupPropertySourceLink(name);

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
  public void deleteRollupPropertySourceLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RollupPropertySourceLinkName name =
          RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");
      client.deleteRollupPropertySourceLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRollupPropertySourceLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "properties/propertie-3766/rollupPropertySourceLinks/rollupPropertySourceLink-3766";

    client.deleteRollupPropertySourceLink(name);

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
  public void deleteRollupPropertySourceLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "properties/propertie-3766/rollupPropertySourceLinks/rollupPropertySourceLink-3766";
      client.deleteRollupPropertySourceLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubpropertyTest() throws Exception {
    CreateSubpropertyResponse expectedResponse =
        CreateSubpropertyResponse.newBuilder()
            .setSubproperty(Property.newBuilder().build())
            .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreateSubpropertyRequest request =
        CreateSubpropertyRequest.newBuilder()
            .setParent(PropertyName.of("[PROPERTY]").toString())
            .setSubproperty(Property.newBuilder().build())
            .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
            .build();

    CreateSubpropertyResponse actualResponse = client.createSubproperty(request);
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
  public void createSubpropertyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateSubpropertyRequest request =
          CreateSubpropertyRequest.newBuilder()
              .setParent(PropertyName.of("[PROPERTY]").toString())
              .setSubproperty(Property.newBuilder().build())
              .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
              .build();
      client.createSubproperty(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubpropertyEventFilterTest() throws Exception {
    SubpropertyEventFilter expectedResponse =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();

    SubpropertyEventFilter actualResponse =
        client.createSubpropertyEventFilter(parent, subpropertyEventFilter);
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
  public void createSubpropertyEventFilterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();
      client.createSubpropertyEventFilter(parent, subpropertyEventFilter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubpropertyEventFilterTest2() throws Exception {
    SubpropertyEventFilter expectedResponse =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";
    SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();

    SubpropertyEventFilter actualResponse =
        client.createSubpropertyEventFilter(parent, subpropertyEventFilter);
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
  public void createSubpropertyEventFilterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();
      client.createSubpropertyEventFilter(parent, subpropertyEventFilter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubpropertyEventFilterTest() throws Exception {
    SubpropertyEventFilter expectedResponse =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    SubpropertyEventFilterName name =
        SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");

    SubpropertyEventFilter actualResponse = client.getSubpropertyEventFilter(name);
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
  public void getSubpropertyEventFilterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubpropertyEventFilterName name =
          SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");
      client.getSubpropertyEventFilter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubpropertyEventFilterTest2() throws Exception {
    SubpropertyEventFilter expectedResponse =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-6725/subpropertyEventFilters/subpropertyEventFilter-6725";

    SubpropertyEventFilter actualResponse = client.getSubpropertyEventFilter(name);
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
  public void getSubpropertyEventFilterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-6725/subpropertyEventFilters/subpropertyEventFilter-6725";
      client.getSubpropertyEventFilter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubpropertyEventFiltersTest() throws Exception {
    SubpropertyEventFilter responsesElement = SubpropertyEventFilter.newBuilder().build();
    ListSubpropertyEventFiltersResponse expectedResponse =
        ListSubpropertyEventFiltersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubpropertyEventFilters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListSubpropertyEventFiltersPagedResponse pagedListResponse =
        client.listSubpropertyEventFilters(parent);

    List<SubpropertyEventFilter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubpropertyEventFiltersList().get(0), resources.get(0));

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
  public void listSubpropertyEventFiltersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listSubpropertyEventFilters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubpropertyEventFiltersTest2() throws Exception {
    SubpropertyEventFilter responsesElement = SubpropertyEventFilter.newBuilder().build();
    ListSubpropertyEventFiltersResponse expectedResponse =
        ListSubpropertyEventFiltersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubpropertyEventFilters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListSubpropertyEventFiltersPagedResponse pagedListResponse =
        client.listSubpropertyEventFilters(parent);

    List<SubpropertyEventFilter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubpropertyEventFiltersList().get(0), resources.get(0));

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
  public void listSubpropertyEventFiltersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listSubpropertyEventFilters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubpropertyEventFilterTest() throws Exception {
    SubpropertyEventFilter expectedResponse =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    mockService.addResponse(expectedResponse);

    SubpropertyEventFilter subpropertyEventFilter =
        SubpropertyEventFilter.newBuilder()
            .setName(
                SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                    .toString())
            .setApplyToProperty("applyToProperty267785086")
            .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SubpropertyEventFilter actualResponse =
        client.updateSubpropertyEventFilter(subpropertyEventFilter, updateMask);
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
  public void updateSubpropertyEventFilterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubpropertyEventFilter subpropertyEventFilter =
          SubpropertyEventFilter.newBuilder()
              .setName(
                  SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
                      .toString())
              .setApplyToProperty("applyToProperty267785086")
              .addAllFilterClauses(new ArrayList<SubpropertyEventFilterClause>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubpropertyEventFilter(subpropertyEventFilter, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubpropertyEventFilterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SubpropertyEventFilterName name =
        SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");

    client.deleteSubpropertyEventFilter(name);

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
  public void deleteSubpropertyEventFilterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubpropertyEventFilterName name =
          SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");
      client.deleteSubpropertyEventFilter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubpropertyEventFilterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-6725/subpropertyEventFilters/subpropertyEventFilter-6725";

    client.deleteSubpropertyEventFilter(name);

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
  public void deleteSubpropertyEventFilterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-6725/subpropertyEventFilters/subpropertyEventFilter-6725";
      client.deleteSubpropertyEventFilter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
