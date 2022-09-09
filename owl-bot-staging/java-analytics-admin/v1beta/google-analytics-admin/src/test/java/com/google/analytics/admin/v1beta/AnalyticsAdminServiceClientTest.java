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

package com.google.analytics.admin.v1beta;

import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.SearchChangeHistoryEventsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
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
public class AnalyticsAdminServiceClientTest {
  private static MockAnalyticsAdminService mockAnalyticsAdminService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AnalyticsAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAnalyticsAdminService = new MockAnalyticsAdminService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAnalyticsAdminService));
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
    AnalyticsAdminServiceSettings settings =
        AnalyticsAdminServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AnalyticsAdminServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.getAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountRequest actualRequest = ((GetAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    Account actualResponse = client.getAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountRequest actualRequest = ((GetAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountsRequest actualRequest = ((ListAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getShowDeleted(), actualRequest.getShowDeleted());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    client.deleteAccount(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccountRequest actualRequest = ((DeleteAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAccount(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccountRequest actualRequest = ((DeleteAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Account account = Account.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Account actualResponse = client.updateAccount(account, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountRequest actualRequest = ((UpdateAccountRequest) actualRequests.get(0));

    Assert.assertEquals(account, actualRequest.getAccount());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      Account account = Account.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ProvisionAccountTicketRequest request =
        ProvisionAccountTicketRequest.newBuilder()
            .setAccount(Account.newBuilder().build())
            .setRedirectUri("redirectUri1970337776")
            .build();

    ProvisionAccountTicketResponse actualResponse = client.provisionAccountTicket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionAccountTicketRequest actualRequest =
        ((ProvisionAccountTicketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getRedirectUri(), actualRequest.getRedirectUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionAccountTicketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ListAccountSummariesRequest request =
        ListAccountSummariesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAccountSummariesPagedResponse pagedListResponse = client.listAccountSummaries(request);

    List<AccountSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountSummariesRequest actualRequest =
        ((ListAccountSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountSummariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    Property actualResponse = client.getProperty(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPropertyRequest actualRequest = ((GetPropertyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    Property actualResponse = client.getProperty(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPropertyRequest actualRequest = ((GetPropertyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPropertyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPropertiesRequest actualRequest = ((ListPropertiesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getShowDeleted(), actualRequest.getShowDeleted());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPropertiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Property property = Property.newBuilder().build();

    Property actualResponse = client.createProperty(property);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePropertyRequest actualRequest = ((CreatePropertyRequest) actualRequests.get(0));

    Assert.assertEquals(property, actualRequest.getProperty());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    Property actualResponse = client.deleteProperty(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePropertyRequest actualRequest = ((DeletePropertyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    Property actualResponse = client.deleteProperty(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePropertyRequest actualRequest = ((DeletePropertyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePropertyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Property property = Property.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Property actualResponse = client.updateProperty(property, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePropertyRequest actualRequest = ((UpdatePropertyRequest) actualRequests.get(0));

    Assert.assertEquals(property, actualRequest.getProperty());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      Property property = Property.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

    FirebaseLink actualResponse = client.createFirebaseLink(parent, firebaseLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirebaseLinkRequest actualRequest = ((CreateFirebaseLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(firebaseLink, actualRequest.getFirebaseLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

    FirebaseLink actualResponse = client.createFirebaseLink(parent, firebaseLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirebaseLinkRequest actualRequest = ((CreateFirebaseLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(firebaseLink, actualRequest.getFirebaseLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirebaseLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");

    client.deleteFirebaseLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirebaseLinkRequest actualRequest = ((DeleteFirebaseLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFirebaseLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirebaseLinkRequest actualRequest = ((DeleteFirebaseLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirebaseLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListFirebaseLinksPagedResponse pagedListResponse = client.listFirebaseLinks(parent);

    List<FirebaseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirebaseLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirebaseLinksRequest actualRequest = ((ListFirebaseLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirebaseLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFirebaseLinksPagedResponse pagedListResponse = client.listFirebaseLinks(parent);

    List<FirebaseLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirebaseLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirebaseLinksRequest actualRequest = ((ListFirebaseLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirebaseLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFirebaseLinks(parent);
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

    GoogleAdsLink actualResponse = client.createGoogleAdsLink(parent, googleAdsLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGoogleAdsLinkRequest actualRequest = ((CreateGoogleAdsLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(googleAdsLink, actualRequest.getGoogleAdsLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

    GoogleAdsLink actualResponse = client.createGoogleAdsLink(parent, googleAdsLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGoogleAdsLinkRequest actualRequest = ((CreateGoogleAdsLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(googleAdsLink, actualRequest.getGoogleAdsLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGoogleAdsLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleAdsLink actualResponse = client.updateGoogleAdsLink(googleAdsLink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGoogleAdsLinkRequest actualRequest = ((UpdateGoogleAdsLinkRequest) actualRequests.get(0));

    Assert.assertEquals(googleAdsLink, actualRequest.getGoogleAdsLink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");

    client.deleteGoogleAdsLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGoogleAdsLinkRequest actualRequest = ((DeleteGoogleAdsLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGoogleAdsLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGoogleAdsLinkRequest actualRequest = ((DeleteGoogleAdsLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGoogleAdsLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListGoogleAdsLinksPagedResponse pagedListResponse = client.listGoogleAdsLinks(parent);

    List<GoogleAdsLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleAdsLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGoogleAdsLinksRequest actualRequest = ((ListGoogleAdsLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGoogleAdsLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGoogleAdsLinksPagedResponse pagedListResponse = client.listGoogleAdsLinks(parent);

    List<GoogleAdsLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleAdsLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGoogleAdsLinksRequest actualRequest = ((ListGoogleAdsLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGoogleAdsLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");

    DataSharingSettings actualResponse = client.getDataSharingSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSharingSettingsRequest actualRequest =
        ((GetDataSharingSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSharingSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    DataSharingSettings actualResponse = client.getDataSharingSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSharingSettingsRequest actualRequest =
        ((GetDataSharingSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSharingSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    MeasurementProtocolSecretName name =
        MeasurementProtocolSecretName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");

    MeasurementProtocolSecret actualResponse = client.getMeasurementProtocolSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMeasurementProtocolSecretRequest actualRequest =
        ((GetMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMeasurementProtocolSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    MeasurementProtocolSecret actualResponse = client.getMeasurementProtocolSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMeasurementProtocolSecretRequest actualRequest =
        ((GetMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMeasurementProtocolSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    ListMeasurementProtocolSecretsPagedResponse pagedListResponse =
        client.listMeasurementProtocolSecrets(parent);

    List<MeasurementProtocolSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMeasurementProtocolSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMeasurementProtocolSecretsRequest actualRequest =
        ((ListMeasurementProtocolSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMeasurementProtocolSecretsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMeasurementProtocolSecretsPagedResponse pagedListResponse =
        client.listMeasurementProtocolSecrets(parent);

    List<MeasurementProtocolSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMeasurementProtocolSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMeasurementProtocolSecretsRequest actualRequest =
        ((ListMeasurementProtocolSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMeasurementProtocolSecretsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMeasurementProtocolSecretRequest actualRequest =
        ((CreateMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(measurementProtocolSecret, actualRequest.getMeasurementProtocolSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMeasurementProtocolSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.createMeasurementProtocolSecret(parent, measurementProtocolSecret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMeasurementProtocolSecretRequest actualRequest =
        ((CreateMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(measurementProtocolSecret, actualRequest.getMeasurementProtocolSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMeasurementProtocolSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    MeasurementProtocolSecretName name =
        MeasurementProtocolSecretName.of(
            "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");

    client.deleteMeasurementProtocolSecret(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMeasurementProtocolSecretRequest actualRequest =
        ((DeleteMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMeasurementProtocolSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMeasurementProtocolSecret(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMeasurementProtocolSecretRequest actualRequest =
        ((DeleteMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMeasurementProtocolSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    MeasurementProtocolSecret measurementProtocolSecret =
        MeasurementProtocolSecret.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MeasurementProtocolSecret actualResponse =
        client.updateMeasurementProtocolSecret(measurementProtocolSecret, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMeasurementProtocolSecretRequest actualRequest =
        ((UpdateMeasurementProtocolSecretRequest) actualRequests.get(0));

    Assert.assertEquals(measurementProtocolSecret, actualRequest.getMeasurementProtocolSecret());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMeasurementProtocolSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      MeasurementProtocolSecret measurementProtocolSecret =
          MeasurementProtocolSecret.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AcknowledgeUserDataCollectionRequest request =
        AcknowledgeUserDataCollectionRequest.newBuilder()
            .setProperty(PropertyName.of("[PROPERTY]").toString())
            .setAcknowledgement("acknowledgement1769490938")
            .build();

    AcknowledgeUserDataCollectionResponse actualResponse =
        client.acknowledgeUserDataCollection(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcknowledgeUserDataCollectionRequest actualRequest =
        ((AcknowledgeUserDataCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProperty(), actualRequest.getProperty());
    Assert.assertEquals(request.getAcknowledgement(), actualRequest.getAcknowledgement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acknowledgeUserDataCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchChangeHistoryEventsRequest actualRequest =
        ((SearchChangeHistoryEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getProperty(), actualRequest.getProperty());
    Assert.assertEquals(request.getResourceTypeList(), actualRequest.getResourceTypeList());
    Assert.assertEquals(request.getActionList(), actualRequest.getActionList());
    Assert.assertEquals(request.getActorEmailList(), actualRequest.getActorEmailList());
    Assert.assertEquals(request.getEarliestChangeTime(), actualRequest.getEarliestChangeTime());
    Assert.assertEquals(request.getLatestChangeTime(), actualRequest.getLatestChangeTime());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchChangeHistoryEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
  public void createConversionEventTest() throws Exception {
    ConversionEvent expectedResponse =
        ConversionEvent.newBuilder()
            .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
            .setEventName("eventName31228997")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeletable(true)
            .setCustom(true)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();

    ConversionEvent actualResponse = client.createConversionEvent(parent, conversionEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionEventRequest actualRequest =
        ((CreateConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversionEvent, actualRequest.getConversionEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();

    ConversionEvent actualResponse = client.createConversionEvent(parent, conversionEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionEventRequest actualRequest =
        ((CreateConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversionEvent, actualRequest.getConversionEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");

    ConversionEvent actualResponse = client.getConversionEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionEventRequest actualRequest = ((GetConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    ConversionEvent actualResponse = client.getConversionEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionEventRequest actualRequest = ((GetConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getConversionEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");

    client.deleteConversionEvent(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionEventRequest actualRequest =
        ((DeleteConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversionEvent(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionEventRequest actualRequest =
        ((DeleteConversionEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListConversionEventsPagedResponse pagedListResponse = client.listConversionEvents(parent);

    List<ConversionEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionEventsRequest actualRequest =
        ((ListConversionEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversionEventsPagedResponse pagedListResponse = client.listConversionEvents(parent);

    List<ConversionEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionEventsRequest actualRequest =
        ((ListConversionEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversionEvents(parent);
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    CustomDimension customDimension = CustomDimension.newBuilder().build();

    CustomDimension actualResponse = client.createCustomDimension(parent, customDimension);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomDimensionRequest actualRequest =
        ((CreateCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customDimension, actualRequest.getCustomDimension());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomDimensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomDimension customDimension = CustomDimension.newBuilder().build();

    CustomDimension actualResponse = client.createCustomDimension(parent, customDimension);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomDimensionRequest actualRequest =
        ((CreateCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customDimension, actualRequest.getCustomDimension());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomDimensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomDimension customDimension = CustomDimension.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomDimension actualResponse = client.updateCustomDimension(customDimension, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomDimensionRequest actualRequest =
        ((UpdateCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(customDimension, actualRequest.getCustomDimension());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomDimensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      CustomDimension customDimension = CustomDimension.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListCustomDimensionsPagedResponse pagedListResponse = client.listCustomDimensions(parent);

    List<CustomDimension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomDimensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomDimensionsRequest actualRequest =
        ((ListCustomDimensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomDimensionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomDimensionsPagedResponse pagedListResponse = client.listCustomDimensions(parent);

    List<CustomDimension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomDimensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomDimensionsRequest actualRequest =
        ((ListCustomDimensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomDimensionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomDimensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomDimensionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");

    client.archiveCustomDimension(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ArchiveCustomDimensionRequest actualRequest =
        ((ArchiveCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void archiveCustomDimensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.archiveCustomDimension(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ArchiveCustomDimensionRequest actualRequest =
        ((ArchiveCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void archiveCustomDimensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");

    CustomDimension actualResponse = client.getCustomDimension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomDimensionRequest actualRequest = ((GetCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomDimensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    CustomDimension actualResponse = client.getCustomDimension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomDimensionRequest actualRequest = ((GetCustomDimensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomDimensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    CustomMetric customMetric = CustomMetric.newBuilder().build();

    CustomMetric actualResponse = client.createCustomMetric(parent, customMetric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomMetricRequest actualRequest = ((CreateCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customMetric, actualRequest.getCustomMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomMetric customMetric = CustomMetric.newBuilder().build();

    CustomMetric actualResponse = client.createCustomMetric(parent, customMetric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomMetricRequest actualRequest = ((CreateCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customMetric, actualRequest.getCustomMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomMetric customMetric = CustomMetric.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomMetric actualResponse = client.updateCustomMetric(customMetric, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomMetricRequest actualRequest = ((UpdateCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(customMetric, actualRequest.getCustomMetric());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      CustomMetric customMetric = CustomMetric.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListCustomMetricsPagedResponse pagedListResponse = client.listCustomMetrics(parent);

    List<CustomMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomMetricsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomMetricsRequest actualRequest = ((ListCustomMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomMetricsPagedResponse pagedListResponse = client.listCustomMetrics(parent);

    List<CustomMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomMetricsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomMetricsRequest actualRequest = ((ListCustomMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomMetricsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void archiveCustomMetricTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");

    client.archiveCustomMetric(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ArchiveCustomMetricRequest actualRequest = ((ArchiveCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void archiveCustomMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.archiveCustomMetric(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ArchiveCustomMetricRequest actualRequest = ((ArchiveCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void archiveCustomMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");

    CustomMetric actualResponse = client.getCustomMetric(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomMetricRequest actualRequest = ((GetCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    CustomMetric actualResponse = client.getCustomMetric(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomMetricRequest actualRequest = ((GetCustomMetricRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataRetentionSettingsName name = DataRetentionSettingsName.of("[PROPERTY]");

    DataRetentionSettings actualResponse = client.getDataRetentionSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataRetentionSettingsRequest actualRequest =
        ((GetDataRetentionSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataRetentionSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    DataRetentionSettings actualResponse = client.getDataRetentionSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataRetentionSettingsRequest actualRequest =
        ((GetDataRetentionSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataRetentionSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataRetentionSettings dataRetentionSettings = DataRetentionSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataRetentionSettings actualResponse =
        client.updateDataRetentionSettings(dataRetentionSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataRetentionSettingsRequest actualRequest =
        ((UpdateDataRetentionSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(dataRetentionSettings, actualRequest.getDataRetentionSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataRetentionSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      DataRetentionSettings dataRetentionSettings = DataRetentionSettings.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    DataStream dataStream = DataStream.newBuilder().build();

    DataStream actualResponse = client.createDataStream(parent, dataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataStreamRequest actualRequest = ((CreateDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataStream, actualRequest.getDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataStream dataStream = DataStream.newBuilder().build();

    DataStream actualResponse = client.createDataStream(parent, dataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataStreamRequest actualRequest = ((CreateDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataStream, actualRequest.getDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    client.deleteDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataStreamRequest actualRequest = ((DeleteDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataStreamRequest actualRequest = ((DeleteDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataStream dataStream = DataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataStream actualResponse = client.updateDataStream(dataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataStreamRequest actualRequest = ((UpdateDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(dataStream, actualRequest.getDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      DataStream dataStream = DataStream.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListDataStreamsPagedResponse pagedListResponse = client.listDataStreams(parent);

    List<DataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataStreamsRequest actualRequest = ((ListDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataStreamsPagedResponse pagedListResponse = client.listDataStreams(parent);

    List<DataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataStreamsRequest actualRequest = ((ListDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");

    DataStream actualResponse = client.getDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataStreamRequest actualRequest = ((GetDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    DataStream actualResponse = client.getDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataStreamRequest actualRequest = ((GetDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
