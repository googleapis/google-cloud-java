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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListAccountsPagedResponse;
import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListSubAccountsPagedResponse;

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
import com.google.type.TimeZone;
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
public class AccountsServiceClientTest {
  private static MockAccountsService mockAccountsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountsService = new MockAccountsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccountsService));
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
    AccountsServiceSettings settings =
        AccountsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountsServiceClient.create(settings);
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
            .setAccountId(-803333011)
            .setAccountName("accountName865966680")
            .setAdultContent(true)
            .setTestAccount(true)
            .setTimeZone(TimeZone.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockAccountsService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.getAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
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
    mockAccountsService.addException(exception);

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
            .setAccountId(-803333011)
            .setAccountName("accountName865966680")
            .setAdultContent(true)
            .setTestAccount(true)
            .setTimeZone(TimeZone.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockAccountsService.addResponse(expectedResponse);

    String name = "name3373707";

    Account actualResponse = client.getAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
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
    mockAccountsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAndConfigureAccountTest() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setAccountId(-803333011)
            .setAccountName("accountName865966680")
            .setAdultContent(true)
            .setTestAccount(true)
            .setTimeZone(TimeZone.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockAccountsService.addResponse(expectedResponse);

    CreateAndConfigureAccountRequest request =
        CreateAndConfigureAccountRequest.newBuilder()
            .setAccount(Account.newBuilder().build())
            .addAllUsers(new ArrayList<CreateUserRequest>())
            .setAcceptTermsOfService(
                CreateAndConfigureAccountRequest.AcceptTermsOfService.newBuilder().build())
            .addAllService(new ArrayList<CreateAndConfigureAccountRequest.AddAccountService>())
            .build();

    Account actualResponse = client.createAndConfigureAccount(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAndConfigureAccountRequest actualRequest =
        ((CreateAndConfigureAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getUsersList(), actualRequest.getUsersList());
    Assert.assertEquals(request.getAcceptTermsOfService(), actualRequest.getAcceptTermsOfService());
    Assert.assertEquals(request.getServiceList(), actualRequest.getServiceList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAndConfigureAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      CreateAndConfigureAccountRequest request =
          CreateAndConfigureAccountRequest.newBuilder()
              .setAccount(Account.newBuilder().build())
              .addAllUsers(new ArrayList<CreateUserRequest>())
              .setAcceptTermsOfService(
                  CreateAndConfigureAccountRequest.AcceptTermsOfService.newBuilder().build())
              .addAllService(new ArrayList<CreateAndConfigureAccountRequest.AddAccountService>())
              .build();
      client.createAndConfigureAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccountsService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    client.deleteAccount(name);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
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
    mockAccountsService.addException(exception);

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
    mockAccountsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAccount(name);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
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
    mockAccountsService.addException(exception);

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
            .setAccountId(-803333011)
            .setAccountName("accountName865966680")
            .setAdultContent(true)
            .setTestAccount(true)
            .setTimeZone(TimeZone.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockAccountsService.addResponse(expectedResponse);

    Account account = Account.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Account actualResponse = client.updateAccount(account, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
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
    mockAccountsService.addException(exception);

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
  public void listAccountsTest() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListAccountsResponse expectedResponse =
        ListAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockAccountsService.addResponse(expectedResponse);

    ListAccountsRequest request =
        ListAccountsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListAccountsPagedResponse pagedListResponse = client.listAccounts(request);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountsRequest actualRequest = ((ListAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      ListAccountsRequest request =
          ListAccountsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listAccounts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubAccountsTest() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListSubAccountsResponse expectedResponse =
        ListSubAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockAccountsService.addResponse(expectedResponse);

    AccountName provider = AccountName.of("[ACCOUNT]");

    ListSubAccountsPagedResponse pagedListResponse = client.listSubAccounts(provider);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubAccountsRequest actualRequest = ((ListSubAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(provider.toString(), actualRequest.getProvider());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      AccountName provider = AccountName.of("[ACCOUNT]");
      client.listSubAccounts(provider);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubAccountsTest2() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListSubAccountsResponse expectedResponse =
        ListSubAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockAccountsService.addResponse(expectedResponse);

    String provider = "provider-987494927";

    ListSubAccountsPagedResponse pagedListResponse = client.listSubAccounts(provider);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubAccountsRequest actualRequest = ((ListSubAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(provider, actualRequest.getProvider());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubAccountsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      String provider = "provider-987494927";
      client.listSubAccounts(provider);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
