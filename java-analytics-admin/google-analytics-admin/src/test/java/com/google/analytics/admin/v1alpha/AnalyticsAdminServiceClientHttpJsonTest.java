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

package com.google.analytics.admin.v1alpha;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.AuditUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAudiencesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinkProposalsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListUserLinksPagedResponse;
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
  public void getUserLinkTest() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    UserLink actualResponse = client.getUserLink(name);
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
  public void getUserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
      client.getUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserLinkTest2() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2326/userLinks/userLink-2326";

    UserLink actualResponse = client.getUserLink(name);
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
  public void getUserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2326/userLinks/userLink-2326";
      client.getUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetUserLinksTest() throws Exception {
    BatchGetUserLinksResponse expectedResponse =
        BatchGetUserLinksResponse.newBuilder().addAllUserLinks(new ArrayList<UserLink>()).build();
    mockService.addResponse(expectedResponse);

    BatchGetUserLinksRequest request =
        BatchGetUserLinksRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetUserLinksResponse actualResponse = client.batchGetUserLinks(request);
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
  public void batchGetUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchGetUserLinksRequest request =
          BatchGetUserLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserLinksTest() throws Exception {
    UserLink responsesElement = UserLink.newBuilder().build();
    ListUserLinksResponse expectedResponse =
        ListUserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listUserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserLinksTest2() throws Exception {
    UserLink responsesElement = UserLink.newBuilder().build();
    ListUserLinksResponse expectedResponse =
        ListUserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUserLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listUserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserLinksTest3() throws Exception {
    UserLink responsesElement = UserLink.newBuilder().build();
    ListUserLinksResponse expectedResponse =
        ListUserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUserLinksExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listUserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void auditUserLinksTest() throws Exception {
    AuditUserLink responsesElement = AuditUserLink.newBuilder().build();
    AuditUserLinksResponse expectedResponse =
        AuditUserLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AuditUserLinksRequest request =
        AuditUserLinksRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    AuditUserLinksPagedResponse pagedListResponse = client.auditUserLinks(request);

    List<AuditUserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void auditUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AuditUserLinksRequest request =
          AuditUserLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.auditUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserLinkTest() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
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
  public void createUserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      UserLink userLink = UserLink.newBuilder().build();
      client.createUserLink(parent, userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserLinkTest2() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
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
  public void createUserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      UserLink userLink = UserLink.newBuilder().build();
      client.createUserLink(parent, userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserLinkTest3() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
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
  public void createUserLinkExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      UserLink userLink = UserLink.newBuilder().build();
      client.createUserLink(parent, userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateUserLinksTest() throws Exception {
    BatchCreateUserLinksResponse expectedResponse =
        BatchCreateUserLinksResponse.newBuilder()
            .addAllUserLinks(new ArrayList<UserLink>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchCreateUserLinksRequest request =
        BatchCreateUserLinksRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setNotifyNewUsers(true)
            .addAllRequests(new ArrayList<CreateUserLinkRequest>())
            .build();

    BatchCreateUserLinksResponse actualResponse = client.batchCreateUserLinks(request);
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
  public void batchCreateUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchCreateUserLinksRequest request =
          BatchCreateUserLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setNotifyNewUsers(true)
              .addAllRequests(new ArrayList<CreateUserLinkRequest>())
              .build();
      client.batchCreateUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserLinkTest() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserLink userLink =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();

    UserLink actualResponse = client.updateUserLink(userLink);
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
  public void updateUserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserLink userLink =
          UserLink.newBuilder()
              .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
              .setEmailAddress("emailAddress-1070931784")
              .addAllDirectRoles(new ArrayList<String>())
              .build();
      client.updateUserLink(userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateUserLinksTest() throws Exception {
    BatchUpdateUserLinksResponse expectedResponse =
        BatchUpdateUserLinksResponse.newBuilder()
            .addAllUserLinks(new ArrayList<UserLink>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchUpdateUserLinksRequest request =
        BatchUpdateUserLinksRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllRequests(new ArrayList<UpdateUserLinkRequest>())
            .build();

    BatchUpdateUserLinksResponse actualResponse = client.batchUpdateUserLinks(request);
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
  public void batchUpdateUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchUpdateUserLinksRequest request =
          BatchUpdateUserLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<UpdateUserLinkRequest>())
              .build();
      client.batchUpdateUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    client.deleteUserLink(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
      client.deleteUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2326/userLinks/userLink-2326";

    client.deleteUserLink(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2326/userLinks/userLink-2326";
      client.deleteUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteUserLinksTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BatchDeleteUserLinksRequest request =
        BatchDeleteUserLinksRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
            .build();

    client.batchDeleteUserLinks(request);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchDeleteUserLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchDeleteUserLinksRequest request =
          BatchDeleteUserLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
              .build();
      client.batchDeleteUserLinks(request);
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
  public void getConversionEventTest() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
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
            .setName(PropertyName.of("[PROPERTY]").toString())
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
              .setName(PropertyName.of("[PROPERTY]").toString())
              .build();
      client.archiveAudience(request);
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
              .build();
      client.runAccessReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
