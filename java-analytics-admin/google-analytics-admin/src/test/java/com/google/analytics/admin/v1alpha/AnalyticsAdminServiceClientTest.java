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

package com.google.analytics.admin.v1alpha;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.AuditUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAndroidAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListIosAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListWebDataStreamsPagedResponse;

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
  private AnalyticsAdminServiceClient client;
  private LocalChannelProvider channelProvider;

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setDeleted(true)
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setDeleted(true)
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setDeleted(true)
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
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    client.deleteProperty(name);

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
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProperty(name);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParent("parent-995424086")
            .setDisplayName("displayName1714148973")
            .setIndustryCategory(IndustryCategory.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .setDeleted(true)
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
  public void getUserLinkTest() throws Exception {
    UserLink expectedResponse =
        UserLink.newBuilder()
            .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .addAllDirectRoles(new ArrayList<String>())
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    UserLink actualResponse = client.getUserLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserLinkRequest actualRequest = ((GetUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    UserLink actualResponse = client.getUserLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserLinkRequest actualRequest = ((GetUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    BatchGetUserLinksRequest request =
        BatchGetUserLinksRequest.newBuilder()
            .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetUserLinksResponse actualResponse = client.batchGetUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetUserLinksRequest actualRequest = ((BatchGetUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      BatchGetUserLinksRequest request =
          BatchGetUserLinksRequest.newBuilder()
              .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLinksRequest actualRequest = ((ListUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLinksRequest actualRequest = ((ListUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLinksRequest actualRequest = ((ListUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserLinksExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AuditUserLinksRequest request =
        AuditUserLinksRequest.newBuilder()
            .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    AuditUserLinksPagedResponse pagedListResponse = client.auditUserLinks(request);

    List<AuditUserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AuditUserLinksRequest actualRequest = ((AuditUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void auditUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AuditUserLinksRequest request =
          AuditUserLinksRequest.newBuilder()
              .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserLinkRequest actualRequest = ((CreateUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserLinkRequest actualRequest = ((CreateUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserLinkRequest actualRequest = ((CreateUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserLinkExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    BatchCreateUserLinksRequest request =
        BatchCreateUserLinksRequest.newBuilder()
            .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .setNotifyNewUsers(true)
            .addAllRequests(new ArrayList<CreateUserLinkRequest>())
            .build();

    BatchCreateUserLinksResponse actualResponse = client.batchCreateUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateUserLinksRequest actualRequest =
        ((BatchCreateUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNotifyNewUsers(), actualRequest.getNotifyNewUsers());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      BatchCreateUserLinksRequest request =
          BatchCreateUserLinksRequest.newBuilder()
              .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.updateUserLink(userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserLinkRequest actualRequest = ((UpdateUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      UserLink userLink = UserLink.newBuilder().build();
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    BatchUpdateUserLinksRequest request =
        BatchUpdateUserLinksRequest.newBuilder()
            .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .addAllRequests(new ArrayList<UpdateUserLinkRequest>())
            .build();

    BatchUpdateUserLinksResponse actualResponse = client.batchUpdateUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateUserLinksRequest actualRequest =
        ((BatchUpdateUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      BatchUpdateUserLinksRequest request =
          BatchUpdateUserLinksRequest.newBuilder()
              .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    client.deleteUserLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserLinkRequest actualRequest = ((DeleteUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

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
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserLinkRequest actualRequest = ((DeleteUserLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteUserLinksTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    BatchDeleteUserLinksRequest request =
        BatchDeleteUserLinksRequest.newBuilder()
            .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
            .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
            .build();

    client.batchDeleteUserLinks(request);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteUserLinksRequest actualRequest =
        ((BatchDeleteUserLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      BatchDeleteUserLinksRequest request =
          BatchDeleteUserLinksRequest.newBuilder()
              .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
              .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
              .build();
      client.batchDeleteUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWebDataStreamTest() throws Exception {
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setMeasurementId("measurementId1655367159")
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultUri("defaultUri678642539")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    WebDataStream actualResponse = client.getWebDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWebDataStreamRequest actualRequest = ((GetWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
      client.getWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWebDataStreamTest2() throws Exception {
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setMeasurementId("measurementId1655367159")
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultUri("defaultUri678642539")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    WebDataStream actualResponse = client.getWebDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWebDataStreamRequest actualRequest = ((GetWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWebDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWebDataStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    client.deleteWebDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWebDataStreamRequest actualRequest = ((DeleteWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
      client.deleteWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWebDataStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteWebDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWebDataStreamRequest actualRequest = ((DeleteWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWebDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWebDataStreamTest() throws Exception {
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setMeasurementId("measurementId1655367159")
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultUri("defaultUri678642539")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStream webDataStream = WebDataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WebDataStream actualResponse = client.updateWebDataStream(webDataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWebDataStreamRequest actualRequest = ((UpdateWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(webDataStream, actualRequest.getWebDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStream webDataStream = WebDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWebDataStream(webDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWebDataStreamTest() throws Exception {
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setMeasurementId("measurementId1655367159")
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultUri("defaultUri678642539")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    WebDataStream webDataStream = WebDataStream.newBuilder().build();

    WebDataStream actualResponse = client.createWebDataStream(parent, webDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWebDataStreamRequest actualRequest = ((CreateWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(webDataStream, actualRequest.getWebDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      WebDataStream webDataStream = WebDataStream.newBuilder().build();
      client.createWebDataStream(parent, webDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWebDataStreamTest2() throws Exception {
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setMeasurementId("measurementId1655367159")
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultUri("defaultUri678642539")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    WebDataStream webDataStream = WebDataStream.newBuilder().build();

    WebDataStream actualResponse = client.createWebDataStream(parent, webDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWebDataStreamRequest actualRequest = ((CreateWebDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(webDataStream, actualRequest.getWebDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWebDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      WebDataStream webDataStream = WebDataStream.newBuilder().build();
      client.createWebDataStream(parent, webDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWebDataStreamsTest() throws Exception {
    WebDataStream responsesElement = WebDataStream.newBuilder().build();
    ListWebDataStreamsResponse expectedResponse =
        ListWebDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWebDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListWebDataStreamsPagedResponse pagedListResponse = client.listWebDataStreams(parent);

    List<WebDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWebDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWebDataStreamsRequest actualRequest = ((ListWebDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWebDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listWebDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWebDataStreamsTest2() throws Exception {
    WebDataStream responsesElement = WebDataStream.newBuilder().build();
    ListWebDataStreamsResponse expectedResponse =
        ListWebDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWebDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWebDataStreamsPagedResponse pagedListResponse = client.listWebDataStreams(parent);

    List<WebDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWebDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWebDataStreamsRequest actualRequest = ((ListWebDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWebDataStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWebDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIosAppDataStreamTest() throws Exception {
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBundleId("bundleId-1294655171")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

    IosAppDataStream actualResponse = client.getIosAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIosAppDataStreamRequest actualRequest = ((GetIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
      client.getIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIosAppDataStreamTest2() throws Exception {
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBundleId("bundleId-1294655171")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    IosAppDataStream actualResponse = client.getIosAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIosAppDataStreamRequest actualRequest = ((GetIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIosAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIosAppDataStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

    client.deleteIosAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIosAppDataStreamRequest actualRequest =
        ((DeleteIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
      client.deleteIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIosAppDataStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteIosAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIosAppDataStreamRequest actualRequest =
        ((DeleteIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIosAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIosAppDataStreamTest() throws Exception {
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBundleId("bundleId-1294655171")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IosAppDataStream actualResponse = client.updateIosAppDataStream(iosAppDataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIosAppDataStreamRequest actualRequest =
        ((UpdateIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(iosAppDataStream, actualRequest.getIosAppDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIosAppDataStream(iosAppDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIosAppDataStreamTest() throws Exception {
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBundleId("bundleId-1294655171")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();

    IosAppDataStream actualResponse = client.createIosAppDataStream(parent, iosAppDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIosAppDataStreamRequest actualRequest =
        ((CreateIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(iosAppDataStream, actualRequest.getIosAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
      client.createIosAppDataStream(parent, iosAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIosAppDataStreamTest2() throws Exception {
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setBundleId("bundleId-1294655171")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();

    IosAppDataStream actualResponse = client.createIosAppDataStream(parent, iosAppDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIosAppDataStreamRequest actualRequest =
        ((CreateIosAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(iosAppDataStream, actualRequest.getIosAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIosAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
      client.createIosAppDataStream(parent, iosAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIosAppDataStreamsTest() throws Exception {
    IosAppDataStream responsesElement = IosAppDataStream.newBuilder().build();
    ListIosAppDataStreamsResponse expectedResponse =
        ListIosAppDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIosAppDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListIosAppDataStreamsPagedResponse pagedListResponse = client.listIosAppDataStreams(parent);

    List<IosAppDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIosAppDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIosAppDataStreamsRequest actualRequest =
        ((ListIosAppDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIosAppDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listIosAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIosAppDataStreamsTest2() throws Exception {
    IosAppDataStream responsesElement = IosAppDataStream.newBuilder().build();
    ListIosAppDataStreamsResponse expectedResponse =
        ListIosAppDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIosAppDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIosAppDataStreamsPagedResponse pagedListResponse = client.listIosAppDataStreams(parent);

    List<IosAppDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIosAppDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIosAppDataStreamsRequest actualRequest =
        ((ListIosAppDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIosAppDataStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIosAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAndroidAppDataStreamTest() throws Exception {
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(
                AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPackageName("packageName908759025")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

    AndroidAppDataStream actualResponse = client.getAndroidAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAndroidAppDataStreamRequest actualRequest =
        ((GetAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStreamName name =
          AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
      client.getAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAndroidAppDataStreamTest2() throws Exception {
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(
                AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPackageName("packageName908759025")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    AndroidAppDataStream actualResponse = client.getAndroidAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAndroidAppDataStreamRequest actualRequest =
        ((GetAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAndroidAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAndroidAppDataStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

    client.deleteAndroidAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAndroidAppDataStreamRequest actualRequest =
        ((DeleteAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStreamName name =
          AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
      client.deleteAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAndroidAppDataStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAndroidAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAndroidAppDataStreamRequest actualRequest =
        ((DeleteAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAndroidAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAndroidAppDataStreamTest() throws Exception {
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(
                AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPackageName("packageName908759025")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AndroidAppDataStream actualResponse =
        client.updateAndroidAppDataStream(androidAppDataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAndroidAppDataStreamRequest actualRequest =
        ((UpdateAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(androidAppDataStream, actualRequest.getAndroidAppDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAndroidAppDataStream(androidAppDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAndroidAppDataStreamTest() throws Exception {
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(
                AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPackageName("packageName908759025")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();

    AndroidAppDataStream actualResponse =
        client.createAndroidAppDataStream(parent, androidAppDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAndroidAppDataStreamRequest actualRequest =
        ((CreateAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(androidAppDataStream, actualRequest.getAndroidAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
      client.createAndroidAppDataStream(parent, androidAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAndroidAppDataStreamTest2() throws Exception {
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(
                AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
            .setFirebaseAppId("firebaseAppId1895156053")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPackageName("packageName908759025")
            .setDisplayName("displayName1714148973")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();

    AndroidAppDataStream actualResponse =
        client.createAndroidAppDataStream(parent, androidAppDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAndroidAppDataStreamRequest actualRequest =
        ((CreateAndroidAppDataStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(androidAppDataStream, actualRequest.getAndroidAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAndroidAppDataStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
      client.createAndroidAppDataStream(parent, androidAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAndroidAppDataStreamsTest() throws Exception {
    AndroidAppDataStream responsesElement = AndroidAppDataStream.newBuilder().build();
    ListAndroidAppDataStreamsResponse expectedResponse =
        ListAndroidAppDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAndroidAppDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListAndroidAppDataStreamsPagedResponse pagedListResponse =
        client.listAndroidAppDataStreams(parent);

    List<AndroidAppDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAndroidAppDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAndroidAppDataStreamsRequest actualRequest =
        ((ListAndroidAppDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAndroidAppDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      client.listAndroidAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAndroidAppDataStreamsTest2() throws Exception {
    AndroidAppDataStream responsesElement = AndroidAppDataStream.newBuilder().build();
    ListAndroidAppDataStreamsResponse expectedResponse =
        ListAndroidAppDataStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAndroidAppDataStreams(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAndroidAppDataStreamsPagedResponse pagedListResponse =
        client.listAndroidAppDataStreams(parent);

    List<AndroidAppDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAndroidAppDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAndroidAppDataStreamsRequest actualRequest =
        ((ListAndroidAppDataStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAndroidAppDataStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAndroidAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnhancedMeasurementSettingsTest() throws Exception {
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(
                EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setPageViewsEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageLoadsEnabled(true)
            .setPageChangesEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    EnhancedMeasurementSettingsName name =
        EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    EnhancedMeasurementSettings actualResponse = client.getEnhancedMeasurementSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnhancedMeasurementSettingsRequest actualRequest =
        ((GetEnhancedMeasurementSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnhancedMeasurementSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      EnhancedMeasurementSettingsName name =
          EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
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
            .setName(
                EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setPageViewsEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageLoadsEnabled(true)
            .setPageChangesEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    EnhancedMeasurementSettings actualResponse = client.getEnhancedMeasurementSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnhancedMeasurementSettingsRequest actualRequest =
        ((GetEnhancedMeasurementSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnhancedMeasurementSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
            .setName(
                EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
            .setStreamEnabled(true)
            .setPageViewsEnabled(true)
            .setScrollsEnabled(true)
            .setOutboundClicksEnabled(true)
            .setSiteSearchEnabled(true)
            .setVideoEngagementEnabled(true)
            .setFileDownloadsEnabled(true)
            .setPageLoadsEnabled(true)
            .setPageChangesEnabled(true)
            .setSearchQueryParameter("searchQueryParameter-2012788855")
            .setUriQueryParameter("uriQueryParameter1580843085")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    EnhancedMeasurementSettings enhancedMeasurementSettings =
        EnhancedMeasurementSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EnhancedMeasurementSettings actualResponse =
        client.updateEnhancedMeasurementSettings(enhancedMeasurementSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEnhancedMeasurementSettingsRequest actualRequest =
        ((UpdateEnhancedMeasurementSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(
        enhancedMeasurementSettings, actualRequest.getEnhancedMeasurementSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEnhancedMeasurementSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      EnhancedMeasurementSettings enhancedMeasurementSettings =
          EnhancedMeasurementSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnhancedMeasurementSettings(enhancedMeasurementSettings, updateMask);
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
            .setMaximumUserAccess(MaximumUserAccess.forNumber(0))
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
            .setMaximumUserAccess(MaximumUserAccess.forNumber(0))
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
  public void updateFirebaseLinkTest() throws Exception {
    FirebaseLink expectedResponse =
        FirebaseLink.newBuilder()
            .setName(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
            .setProject("project-309310695")
            .setCreateTime(Timestamp.newBuilder().build())
            .setMaximumUserAccess(MaximumUserAccess.forNumber(0))
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FirebaseLink actualResponse = client.updateFirebaseLink(firebaseLink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFirebaseLinkRequest actualRequest = ((UpdateFirebaseLinkRequest) actualRequests.get(0));

    Assert.assertEquals(firebaseLink, actualRequest.getFirebaseLink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFirebaseLink(firebaseLink, updateMask);
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
  public void getGlobalSiteTagTest() throws Exception {
    GlobalSiteTag expectedResponse =
        GlobalSiteTag.newBuilder()
            .setName(GlobalSiteTagName.of("[PROPERTY]").toString())
            .setSnippet("snippet-2061635299")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]");

    GlobalSiteTag actualResponse = client.getGlobalSiteTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlobalSiteTagRequest actualRequest = ((GetGlobalSiteTagRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlobalSiteTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]");
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
            .setName(GlobalSiteTagName.of("[PROPERTY]").toString())
            .setSnippet("snippet-2061635299")
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    GlobalSiteTag actualResponse = client.getGlobalSiteTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlobalSiteTagRequest actualRequest = ((GetGlobalSiteTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlobalSiteTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String name = "name3373707";
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
            .setEmailAddress("emailAddress-1070931784")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
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
            .setEmailAddress("emailAddress-1070931784")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
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
            .setEmailAddress("emailAddress-1070931784")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
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
}
