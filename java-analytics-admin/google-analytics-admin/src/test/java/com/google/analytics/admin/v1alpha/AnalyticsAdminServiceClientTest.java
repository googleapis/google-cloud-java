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
package com.google.analytics.admin.v1alpha;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.AuditUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAndroidAppDataStreamsPagedResponse;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AnalyticsAdminServiceClientTest {
  private static MockAnalyticsAdminService mockAnalyticsAdminService;
  private static MockServiceHelper serviceHelper;
  private AnalyticsAdminServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAnalyticsAdminService = new MockAnalyticsAdminService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAnalyticsAdminService));
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
  @SuppressWarnings("all")
  public void getAccountTest() {
    AccountName name2 = AccountName.of("[ACCOUNT]");
    String displayName = "displayName1615086568";
    String countryCode = "countryCode1481071862";
    boolean deleted = false;
    Account expectedResponse =
        Account.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setCountryCode(countryCode)
            .setDeleted(deleted)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.getAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountRequest actualRequest = (GetAccountRequest) actualRequests.get(0);

    Assert.assertEquals(name, AccountName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");

      client.getAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAccountsTest() {
    String nextPageToken = "";
    Account accountsElement = Account.newBuilder().build();
    List<Account> accounts = Arrays.asList(accountsElement);
    ListAccountsResponse expectedResponse =
        ListAccountsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAccounts(accounts)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ListAccountsRequest request = ListAccountsRequest.newBuilder().build();

    ListAccountsPagedResponse pagedListResponse = client.listAccounts(request);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountsRequest actualRequest = (ListAccountsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      ListAccountsRequest request = ListAccountsRequest.newBuilder().build();

      client.listAccounts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAccountTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    client.deleteAccount(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccountRequest actualRequest = (DeleteAccountRequest) actualRequests.get(0);

    Assert.assertEquals(name, AccountName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");

      client.deleteAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAccountTest() {
    AccountName name = AccountName.of("[ACCOUNT]");
    String displayName = "displayName1615086568";
    String countryCode = "countryCode1481071862";
    boolean deleted = false;
    Account expectedResponse =
        Account.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setCountryCode(countryCode)
            .setDeleted(deleted)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Account account = Account.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Account actualResponse = client.updateAccount(account, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountRequest actualRequest = (UpdateAccountRequest) actualRequests.get(0);

    Assert.assertEquals(account, actualRequest.getAccount());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      Account account = Account.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateAccount(account, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void provisionAccountTicketTest() {
    String accountTicketId = "accountTicketId-442102884";
    ProvisionAccountTicketResponse expectedResponse =
        ProvisionAccountTicketResponse.newBuilder().setAccountTicketId(accountTicketId).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    ProvisionAccountTicketRequest request = ProvisionAccountTicketRequest.newBuilder().build();

    ProvisionAccountTicketResponse actualResponse = client.provisionAccountTicket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionAccountTicketRequest actualRequest =
        (ProvisionAccountTicketRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void provisionAccountTicketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      ProvisionAccountTicketRequest request = ProvisionAccountTicketRequest.newBuilder().build();

      client.provisionAccountTicket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPropertyTest() {
    PropertyName name2 = PropertyName.of("[PROPERTY]");
    String parent = "parent-995424086";
    String displayName = "displayName1615086568";
    String timeZone = "timeZone36848094";
    String currencyCode = "currencyCode1108728155";
    boolean deleted = false;
    Property expectedResponse =
        Property.newBuilder()
            .setName(name2.toString())
            .setParent(parent)
            .setDisplayName(displayName)
            .setTimeZone(timeZone)
            .setCurrencyCode(currencyCode)
            .setDeleted(deleted)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    Property actualResponse = client.getProperty(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPropertyRequest actualRequest = (GetPropertyRequest) actualRequests.get(0);

    Assert.assertEquals(name, PropertyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getPropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName name = PropertyName.of("[PROPERTY]");

      client.getProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPropertiesTest() {
    String nextPageToken = "";
    Property propertiesElement = Property.newBuilder().build();
    List<Property> properties = Arrays.asList(propertiesElement);
    ListPropertiesResponse expectedResponse =
        ListPropertiesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProperties(properties)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String filter = "filter-1274492040";
    ListPropertiesRequest request = ListPropertiesRequest.newBuilder().setFilter(filter).build();

    ListPropertiesPagedResponse pagedListResponse = client.listProperties(request);

    List<Property> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPropertiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPropertiesRequest actualRequest = (ListPropertiesRequest) actualRequests.get(0);

    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPropertiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String filter = "filter-1274492040";
      ListPropertiesRequest request = ListPropertiesRequest.newBuilder().setFilter(filter).build();

      client.listProperties(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createPropertyTest() {
    PropertyName name = PropertyName.of("[PROPERTY]");
    String parent = "parent-995424086";
    String displayName = "displayName1615086568";
    String timeZone = "timeZone36848094";
    String currencyCode = "currencyCode1108728155";
    boolean deleted = false;
    Property expectedResponse =
        Property.newBuilder()
            .setName(name.toString())
            .setParent(parent)
            .setDisplayName(displayName)
            .setTimeZone(timeZone)
            .setCurrencyCode(currencyCode)
            .setDeleted(deleted)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Property property = Property.newBuilder().build();

    Property actualResponse = client.createProperty(property);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePropertyRequest actualRequest = (CreatePropertyRequest) actualRequests.get(0);

    Assert.assertEquals(property, actualRequest.getProperty());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createPropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      Property property = Property.newBuilder().build();

      client.createProperty(property);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deletePropertyTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName name = PropertyName.of("[PROPERTY]");

    client.deleteProperty(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePropertyRequest actualRequest = (DeletePropertyRequest) actualRequests.get(0);

    Assert.assertEquals(name, PropertyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deletePropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName name = PropertyName.of("[PROPERTY]");

      client.deleteProperty(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updatePropertyTest() {
    PropertyName name = PropertyName.of("[PROPERTY]");
    String parent = "parent-995424086";
    String displayName = "displayName1615086568";
    String timeZone = "timeZone36848094";
    String currencyCode = "currencyCode1108728155";
    boolean deleted = false;
    Property expectedResponse =
        Property.newBuilder()
            .setName(name.toString())
            .setParent(parent)
            .setDisplayName(displayName)
            .setTimeZone(timeZone)
            .setCurrencyCode(currencyCode)
            .setDeleted(deleted)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    Property property = Property.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Property actualResponse = client.updateProperty(property, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePropertyRequest actualRequest = (UpdatePropertyRequest) actualRequests.get(0);

    Assert.assertEquals(property, actualRequest.getProperty());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updatePropertyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      Property property = Property.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateProperty(property, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getUserLinkTest() {
    UserLinkName name2 = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
    String emailAddress = "emailAddress-769510831";
    UserLink expectedResponse =
        UserLink.newBuilder().setName(name2.toString()).setEmailAddress(emailAddress).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    UserLink actualResponse = client.getUserLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserLinkRequest actualRequest = (GetUserLinkRequest) actualRequests.get(0);

    Assert.assertEquals(name, UserLinkName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

      client.getUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetUserLinksTest() {
    BatchGetUserLinksResponse expectedResponse = BatchGetUserLinksResponse.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    List<UserLinkName> names = new ArrayList<>();
    BatchGetUserLinksRequest request =
        BatchGetUserLinksRequest.newBuilder()
            .setParent(parent.toString())
            .addAllNames(UserLinkName.toStringList(names))
            .build();

    BatchGetUserLinksResponse actualResponse = client.batchGetUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetUserLinksRequest actualRequest = (BatchGetUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AccountName.parse(actualRequest.getParent()));
    Assert.assertEquals(names, UserLinkName.parseList(actualRequest.getNamesList()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      List<UserLinkName> names = new ArrayList<>();
      BatchGetUserLinksRequest request =
          BatchGetUserLinksRequest.newBuilder()
              .setParent(parent.toString())
              .addAllNames(UserLinkName.toStringList(names))
              .build();

      client.batchGetUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listUserLinksTest() {
    String nextPageToken = "";
    UserLink userLinksElement = UserLink.newBuilder().build();
    List<UserLink> userLinks = Arrays.asList(userLinksElement);
    ListUserLinksResponse expectedResponse =
        ListUserLinksResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllUserLinks(userLinks)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListUserLinksPagedResponse pagedListResponse = client.listUserLinks(parent);

    List<UserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLinksRequest actualRequest = (ListUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AccountName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");

      client.listUserLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void auditUserLinksTest() {
    String nextPageToken = "";
    AuditUserLink userLinksElement = AuditUserLink.newBuilder().build();
    List<AuditUserLink> userLinks = Arrays.asList(userLinksElement);
    AuditUserLinksResponse expectedResponse =
        AuditUserLinksResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllUserLinks(userLinks)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    AuditUserLinksRequest request =
        AuditUserLinksRequest.newBuilder().setParent(parent.toString()).build();

    AuditUserLinksPagedResponse pagedListResponse = client.auditUserLinks(request);

    List<AuditUserLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AuditUserLinksRequest actualRequest = (AuditUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AccountName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void auditUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      AuditUserLinksRequest request =
          AuditUserLinksRequest.newBuilder().setParent(parent.toString()).build();

      client.auditUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createUserLinkTest() {
    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
    String emailAddress = "emailAddress-769510831";
    UserLink expectedResponse =
        UserLink.newBuilder().setName(name.toString()).setEmailAddress(emailAddress).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.createUserLink(parent, userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserLinkRequest actualRequest = (CreateUserLinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AccountName.parse(actualRequest.getParent()));
    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      UserLink userLink = UserLink.newBuilder().build();

      client.createUserLink(parent, userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateUserLinksTest() {
    BatchCreateUserLinksResponse expectedResponse =
        BatchCreateUserLinksResponse.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BatchCreateUserLinksRequest request =
        BatchCreateUserLinksRequest.newBuilder().setParent(parent).build();

    BatchCreateUserLinksResponse actualResponse = client.batchCreateUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateUserLinksRequest actualRequest = (BatchCreateUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      BatchCreateUserLinksRequest request =
          BatchCreateUserLinksRequest.newBuilder().setParent(parent).build();

      client.batchCreateUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateUserLinkTest() {
    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
    String emailAddress = "emailAddress-769510831";
    UserLink expectedResponse =
        UserLink.newBuilder().setName(name.toString()).setEmailAddress(emailAddress).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLink userLink = UserLink.newBuilder().build();

    UserLink actualResponse = client.updateUserLink(userLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserLinkRequest actualRequest = (UpdateUserLinkRequest) actualRequests.get(0);

    Assert.assertEquals(userLink, actualRequest.getUserLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      UserLink userLink = UserLink.newBuilder().build();

      client.updateUserLink(userLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateUserLinksTest() {
    BatchUpdateUserLinksResponse expectedResponse =
        BatchUpdateUserLinksResponse.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BatchUpdateUserLinksRequest request =
        BatchUpdateUserLinksRequest.newBuilder().setParent(parent).build();

    BatchUpdateUserLinksResponse actualResponse = client.batchUpdateUserLinks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateUserLinksRequest actualRequest = (BatchUpdateUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      BatchUpdateUserLinksRequest request =
          BatchUpdateUserLinksRequest.newBuilder().setParent(parent).build();

      client.batchUpdateUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUserLinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

    client.deleteUserLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserLinkRequest actualRequest = (DeleteUserLinkRequest) actualRequests.get(0);

    Assert.assertEquals(name, UserLinkName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUserLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");

      client.deleteUserLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteUserLinksTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BatchDeleteUserLinksRequest request =
        BatchDeleteUserLinksRequest.newBuilder().setParent(parent).build();

    client.batchDeleteUserLinks(request);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteUserLinksRequest actualRequest = (BatchDeleteUserLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteUserLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      BatchDeleteUserLinksRequest request =
          BatchDeleteUserLinksRequest.newBuilder().setParent(parent).build();

      client.batchDeleteUserLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWebDataStreamTest() {
    WebDataStreamName name2 = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
    String measurementId = "measurementId-223204226";
    String firebaseAppId = "firebaseAppId605863217";
    String defaultUri = "defaultUri-436616594";
    String displayName = "displayName1615086568";
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(name2.toString())
            .setMeasurementId(measurementId)
            .setFirebaseAppId(firebaseAppId)
            .setDefaultUri(defaultUri)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    WebDataStream actualResponse = client.getWebDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWebDataStreamRequest actualRequest = (GetWebDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, WebDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

      client.getWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWebDataStreamTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    client.deleteWebDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWebDataStreamRequest actualRequest = (DeleteWebDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, WebDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

      client.deleteWebDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateWebDataStreamTest() {
    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
    String measurementId = "measurementId-223204226";
    String firebaseAppId = "firebaseAppId605863217";
    String defaultUri = "defaultUri-436616594";
    String displayName = "displayName1615086568";
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(name.toString())
            .setMeasurementId(measurementId)
            .setFirebaseAppId(firebaseAppId)
            .setDefaultUri(defaultUri)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    WebDataStream webDataStream = WebDataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WebDataStream actualResponse = client.updateWebDataStream(webDataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWebDataStreamRequest actualRequest = (UpdateWebDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(webDataStream, actualRequest.getWebDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      WebDataStream webDataStream = WebDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateWebDataStream(webDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createWebDataStreamTest() {
    WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
    String measurementId = "measurementId-223204226";
    String firebaseAppId = "firebaseAppId605863217";
    String defaultUri = "defaultUri-436616594";
    String displayName = "displayName1615086568";
    WebDataStream expectedResponse =
        WebDataStream.newBuilder()
            .setName(name.toString())
            .setMeasurementId(measurementId)
            .setFirebaseAppId(firebaseAppId)
            .setDefaultUri(defaultUri)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    WebDataStream webDataStream = WebDataStream.newBuilder().build();

    WebDataStream actualResponse = client.createWebDataStream(parent, webDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWebDataStreamRequest actualRequest = (CreateWebDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertEquals(webDataStream, actualRequest.getWebDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWebDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      WebDataStream webDataStream = WebDataStream.newBuilder().build();

      client.createWebDataStream(parent, webDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listWebDataStreamsTest() {
    String nextPageToken = "";
    WebDataStream webDataStreamsElement = WebDataStream.newBuilder().build();
    List<WebDataStream> webDataStreams = Arrays.asList(webDataStreamsElement);
    ListWebDataStreamsResponse expectedResponse =
        ListWebDataStreamsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllWebDataStreams(webDataStreams)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListWebDataStreamsPagedResponse pagedListResponse = client.listWebDataStreams(parent);

    List<WebDataStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWebDataStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWebDataStreamsRequest actualRequest = (ListWebDataStreamsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listWebDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");

      client.listWebDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIosAppDataStreamTest() {
    IosAppDataStreamName name2 = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String bundleId = "bundleId-1479583240";
    String displayName = "displayName1615086568";
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(name2.toString())
            .setFirebaseAppId(firebaseAppId)
            .setBundleId(bundleId)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

    IosAppDataStream actualResponse = client.getIosAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIosAppDataStreamRequest actualRequest = (GetIosAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, IosAppDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

      client.getIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIosAppDataStreamTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

    client.deleteIosAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIosAppDataStreamRequest actualRequest =
        (DeleteIosAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, IosAppDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");

      client.deleteIosAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateIosAppDataStreamTest() {
    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String bundleId = "bundleId-1479583240";
    String displayName = "displayName1615086568";
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(name.toString())
            .setFirebaseAppId(firebaseAppId)
            .setBundleId(bundleId)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IosAppDataStream actualResponse = client.updateIosAppDataStream(iosAppDataStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIosAppDataStreamRequest actualRequest =
        (UpdateIosAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(iosAppDataStream, actualRequest.getIosAppDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateIosAppDataStream(iosAppDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createIosAppDataStreamTest() {
    IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String bundleId = "bundleId-1479583240";
    String displayName = "displayName1615086568";
    IosAppDataStream expectedResponse =
        IosAppDataStream.newBuilder()
            .setName(name.toString())
            .setFirebaseAppId(firebaseAppId)
            .setBundleId(bundleId)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();

    IosAppDataStream actualResponse = client.createIosAppDataStream(parent, iosAppDataStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIosAppDataStreamRequest actualRequest =
        (CreateIosAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertEquals(iosAppDataStream, actualRequest.getIosAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createIosAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();

      client.createIosAppDataStream(parent, iosAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listIosAppDataStreamsTest() {
    String nextPageToken = "";
    IosAppDataStream iosAppDataStreamsElement = IosAppDataStream.newBuilder().build();
    List<IosAppDataStream> iosAppDataStreams = Arrays.asList(iosAppDataStreamsElement);
    ListIosAppDataStreamsResponse expectedResponse =
        ListIosAppDataStreamsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllIosAppDataStreams(iosAppDataStreams)
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
        (ListIosAppDataStreamsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listIosAppDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");

      client.listIosAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAndroidAppDataStreamTest() {
    AndroidAppDataStreamName name2 =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String packageName = "packageName-1877165340";
    String displayName = "displayName1615086568";
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(name2.toString())
            .setFirebaseAppId(firebaseAppId)
            .setPackageName(packageName)
            .setDisplayName(displayName)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

    AndroidAppDataStream actualResponse = client.getAndroidAppDataStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAndroidAppDataStreamRequest actualRequest =
        (GetAndroidAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, AndroidAppDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStreamName name =
          AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

      client.getAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAndroidAppDataStreamTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

    client.deleteAndroidAppDataStream(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAndroidAppDataStreamRequest actualRequest =
        (DeleteAndroidAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, AndroidAppDataStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStreamName name =
          AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");

      client.deleteAndroidAppDataStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAndroidAppDataStreamTest() {
    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String packageName = "packageName-1877165340";
    String displayName = "displayName1615086568";
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(name.toString())
            .setFirebaseAppId(firebaseAppId)
            .setPackageName(packageName)
            .setDisplayName(displayName)
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
        (UpdateAndroidAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(androidAppDataStream, actualRequest.getAndroidAppDataStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateAndroidAppDataStream(androidAppDataStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAndroidAppDataStreamTest() {
    AndroidAppDataStreamName name =
        AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
    String firebaseAppId = "firebaseAppId605863217";
    String packageName = "packageName-1877165340";
    String displayName = "displayName1615086568";
    AndroidAppDataStream expectedResponse =
        AndroidAppDataStream.newBuilder()
            .setName(name.toString())
            .setFirebaseAppId(firebaseAppId)
            .setPackageName(packageName)
            .setDisplayName(displayName)
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
        (CreateAndroidAppDataStreamRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertEquals(androidAppDataStream, actualRequest.getAndroidAppDataStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAndroidAppDataStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();

      client.createAndroidAppDataStream(parent, androidAppDataStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAndroidAppDataStreamsTest() {
    String nextPageToken = "";
    AndroidAppDataStream androidAppDataStreamsElement = AndroidAppDataStream.newBuilder().build();
    List<AndroidAppDataStream> androidAppDataStreams = Arrays.asList(androidAppDataStreamsElement);
    ListAndroidAppDataStreamsResponse expectedResponse =
        ListAndroidAppDataStreamsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAndroidAppDataStreams(androidAppDataStreams)
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
        (ListAndroidAppDataStreamsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAndroidAppDataStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");

      client.listAndroidAppDataStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEnhancedMeasurementSettingsTest() {
    EnhancedMeasurementSettingsName name2 =
        EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
    boolean streamEnabled = true;
    boolean pageViewsEnabled = true;
    boolean scrollsEnabled = true;
    boolean outboundClicksEnabled = true;
    boolean contentViewsEnabled = true;
    boolean siteSearchEnabled = true;
    boolean formInteractionsEnabled = true;
    boolean videoEngagementEnabled = false;
    boolean fileDownloadsEnabled = true;
    boolean dataTaggedElementClicksEnabled = true;
    boolean pageLoadsEnabled = false;
    boolean pageChangesEnabled = false;
    boolean articlesAndBlogsEnabled = false;
    boolean productsAndEcommerceEnabled = false;
    String searchQueryParameter = "searchQueryParameter638048347";
    String urlQueryParameter = "urlQueryParameter729598498";
    String excludedDomains = "excludedDomains147054266";
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(name2.toString())
            .setStreamEnabled(streamEnabled)
            .setPageViewsEnabled(pageViewsEnabled)
            .setScrollsEnabled(scrollsEnabled)
            .setOutboundClicksEnabled(outboundClicksEnabled)
            .setContentViewsEnabled(contentViewsEnabled)
            .setSiteSearchEnabled(siteSearchEnabled)
            .setFormInteractionsEnabled(formInteractionsEnabled)
            .setVideoEngagementEnabled(videoEngagementEnabled)
            .setFileDownloadsEnabled(fileDownloadsEnabled)
            .setDataTaggedElementClicksEnabled(dataTaggedElementClicksEnabled)
            .setPageLoadsEnabled(pageLoadsEnabled)
            .setPageChangesEnabled(pageChangesEnabled)
            .setArticlesAndBlogsEnabled(articlesAndBlogsEnabled)
            .setProductsAndEcommerceEnabled(productsAndEcommerceEnabled)
            .setSearchQueryParameter(searchQueryParameter)
            .setUrlQueryParameter(urlQueryParameter)
            .setExcludedDomains(excludedDomains)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    EnhancedMeasurementSettingsName name =
        EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

    EnhancedMeasurementSettings actualResponse = client.getEnhancedMeasurementSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnhancedMeasurementSettingsRequest actualRequest =
        (GetEnhancedMeasurementSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, EnhancedMeasurementSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEnhancedMeasurementSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      EnhancedMeasurementSettingsName name =
          EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");

      client.getEnhancedMeasurementSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEnhancedMeasurementSettingsTest() {
    EnhancedMeasurementSettingsName name =
        EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
    boolean streamEnabled = true;
    boolean pageViewsEnabled = true;
    boolean scrollsEnabled = true;
    boolean outboundClicksEnabled = true;
    boolean contentViewsEnabled = true;
    boolean siteSearchEnabled = true;
    boolean formInteractionsEnabled = true;
    boolean videoEngagementEnabled = false;
    boolean fileDownloadsEnabled = true;
    boolean dataTaggedElementClicksEnabled = true;
    boolean pageLoadsEnabled = false;
    boolean pageChangesEnabled = false;
    boolean articlesAndBlogsEnabled = false;
    boolean productsAndEcommerceEnabled = false;
    String searchQueryParameter = "searchQueryParameter638048347";
    String urlQueryParameter = "urlQueryParameter729598498";
    String excludedDomains = "excludedDomains147054266";
    EnhancedMeasurementSettings expectedResponse =
        EnhancedMeasurementSettings.newBuilder()
            .setName(name.toString())
            .setStreamEnabled(streamEnabled)
            .setPageViewsEnabled(pageViewsEnabled)
            .setScrollsEnabled(scrollsEnabled)
            .setOutboundClicksEnabled(outboundClicksEnabled)
            .setContentViewsEnabled(contentViewsEnabled)
            .setSiteSearchEnabled(siteSearchEnabled)
            .setFormInteractionsEnabled(formInteractionsEnabled)
            .setVideoEngagementEnabled(videoEngagementEnabled)
            .setFileDownloadsEnabled(fileDownloadsEnabled)
            .setDataTaggedElementClicksEnabled(dataTaggedElementClicksEnabled)
            .setPageLoadsEnabled(pageLoadsEnabled)
            .setPageChangesEnabled(pageChangesEnabled)
            .setArticlesAndBlogsEnabled(articlesAndBlogsEnabled)
            .setProductsAndEcommerceEnabled(productsAndEcommerceEnabled)
            .setSearchQueryParameter(searchQueryParameter)
            .setUrlQueryParameter(urlQueryParameter)
            .setExcludedDomains(excludedDomains)
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
        (UpdateEnhancedMeasurementSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(
        enhancedMeasurementSettings, actualRequest.getEnhancedMeasurementSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEnhancedMeasurementSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      EnhancedMeasurementSettings enhancedMeasurementSettings =
          EnhancedMeasurementSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateEnhancedMeasurementSettings(enhancedMeasurementSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createFirebaseLinkTest() {
    FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");
    String project = "project-309310695";
    FirebaseLink expectedResponse =
        FirebaseLink.newBuilder().setName(name.toString()).setProject(project).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

    FirebaseLink actualResponse = client.createFirebaseLink(parent, firebaseLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirebaseLinkRequest actualRequest = (CreateFirebaseLinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertEquals(firebaseLink, actualRequest.getFirebaseLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();

      client.createFirebaseLink(parent, firebaseLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateFirebaseLinkTest() {
    FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");
    String project = "project-309310695";
    FirebaseLink expectedResponse =
        FirebaseLink.newBuilder().setName(name.toString()).setProject(project).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FirebaseLink actualResponse = client.updateFirebaseLink(firebaseLink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFirebaseLinkRequest actualRequest = (UpdateFirebaseLinkRequest) actualRequests.get(0);

    Assert.assertEquals(firebaseLink, actualRequest.getFirebaseLink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateFirebaseLink(firebaseLink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFirebaseLinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");

    client.deleteFirebaseLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirebaseLinkRequest actualRequest = (DeleteFirebaseLinkRequest) actualRequests.get(0);

    Assert.assertEquals(name, FirebaseLinkName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFirebaseLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");

      client.deleteFirebaseLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listFirebaseLinksTest() {
    ListFirebaseLinksResponse expectedResponse = ListFirebaseLinksResponse.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListFirebaseLinksResponse actualResponse = client.listFirebaseLinks(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirebaseLinksRequest actualRequest = (ListFirebaseLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFirebaseLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");

      client.listFirebaseLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGlobalSiteTagTest() {
    String snippet = "snippet-2061635299";
    GlobalSiteTag expectedResponse = GlobalSiteTag.newBuilder().setSnippet(snippet).build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]");

    GlobalSiteTag actualResponse = client.getGlobalSiteTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlobalSiteTagRequest actualRequest = (GetGlobalSiteTagRequest) actualRequests.get(0);

    Assert.assertEquals(name, GlobalSiteTagName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGlobalSiteTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]");

      client.getGlobalSiteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGoogleAdsLinkTest() {
    GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");
    String parent2 = "parent21175163357";
    String customerId = "customerId-1772061412";
    boolean canManageClients = false;
    String emailAddress = "emailAddress-769510831";
    GoogleAdsLink expectedResponse =
        GoogleAdsLink.newBuilder()
            .setName(name.toString())
            .setParent(parent2)
            .setCustomerId(customerId)
            .setCanManageClients(canManageClients)
            .setEmailAddress(emailAddress)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");
    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

    GoogleAdsLink actualResponse = client.createGoogleAdsLink(parent, googleAdsLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGoogleAdsLinkRequest actualRequest = (CreateGoogleAdsLinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertEquals(googleAdsLink, actualRequest.getGoogleAdsLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");
      GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();

      client.createGoogleAdsLink(parent, googleAdsLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGoogleAdsLinkTest() {
    GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");
    String parent = "parent-995424086";
    String customerId = "customerId-1772061412";
    boolean canManageClients = false;
    String emailAddress = "emailAddress-769510831";
    GoogleAdsLink expectedResponse =
        GoogleAdsLink.newBuilder()
            .setName(name.toString())
            .setParent(parent)
            .setCustomerId(customerId)
            .setCanManageClients(canManageClients)
            .setEmailAddress(emailAddress)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleAdsLink actualResponse = client.updateGoogleAdsLink(googleAdsLink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGoogleAdsLinkRequest actualRequest = (UpdateGoogleAdsLinkRequest) actualRequests.get(0);

    Assert.assertEquals(googleAdsLink, actualRequest.getGoogleAdsLink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateGoogleAdsLink(googleAdsLink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGoogleAdsLinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");

    client.deleteGoogleAdsLink(name);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGoogleAdsLinkRequest actualRequest = (DeleteGoogleAdsLinkRequest) actualRequests.get(0);

    Assert.assertEquals(name, GoogleAdsLinkName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGoogleAdsLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");

      client.deleteGoogleAdsLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGoogleAdsLinksTest() {
    String nextPageToken = "";
    GoogleAdsLink googleAdsLinksElement = GoogleAdsLink.newBuilder().build();
    List<GoogleAdsLink> googleAdsLinks = Arrays.asList(googleAdsLinksElement);
    ListGoogleAdsLinksResponse expectedResponse =
        ListGoogleAdsLinksResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllGoogleAdsLinks(googleAdsLinks)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTY]");

    ListGoogleAdsLinksPagedResponse pagedListResponse = client.listGoogleAdsLinks(parent);

    List<GoogleAdsLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleAdsLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGoogleAdsLinksRequest actualRequest = (ListGoogleAdsLinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PropertyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listGoogleAdsLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTY]");

      client.listGoogleAdsLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDataSharingSettingsTest() {
    DataSharingSettingsName name2 = DataSharingSettingsName.of("[ACCOUNT]");
    boolean sharingWithGoogleSupportEnabled = false;
    boolean sharingWithGoogleAssignedSalesEnabled = false;
    boolean sharingWithGoogleAnySalesEnabled = false;
    boolean sharingWithGoogleProductsEnabled = true;
    boolean sharingWithOthersEnabled = false;
    DataSharingSettings expectedResponse =
        DataSharingSettings.newBuilder()
            .setName(name2.toString())
            .setSharingWithGoogleSupportEnabled(sharingWithGoogleSupportEnabled)
            .setSharingWithGoogleAssignedSalesEnabled(sharingWithGoogleAssignedSalesEnabled)
            .setSharingWithGoogleAnySalesEnabled(sharingWithGoogleAnySalesEnabled)
            .setSharingWithGoogleProductsEnabled(sharingWithGoogleProductsEnabled)
            .setSharingWithOthersEnabled(sharingWithOthersEnabled)
            .build();
    mockAnalyticsAdminService.addResponse(expectedResponse);

    DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");

    DataSharingSettings actualResponse = client.getDataSharingSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSharingSettingsRequest actualRequest =
        (GetDataSharingSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataSharingSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDataSharingSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAnalyticsAdminService.addException(exception);

    try {
      DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");

      client.getDataSharingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
