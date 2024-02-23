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

package com.google.shopping.css.v1;

import static com.google.shopping.css.v1.AccountsServiceClient.ListChildAccountsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
  public void listChildAccountsTest() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListChildAccountsResponse expectedResponse =
        ListChildAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockAccountsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListChildAccountsPagedResponse pagedListResponse = client.listChildAccounts(parent);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChildAccountsRequest actualRequest = ((ListChildAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChildAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listChildAccounts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChildAccountsTest2() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListChildAccountsResponse expectedResponse =
        ListChildAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockAccountsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChildAccountsPagedResponse pagedListResponse = client.listChildAccounts(parent);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChildAccountsRequest actualRequest = ((ListChildAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChildAccountsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChildAccounts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountTest() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setFullName("fullName1330852282")
            .setDisplayName("displayName1714148973")
            .setHomepageUri("homepageUri1440042654")
            .setParent("parent-995424086")
            .addAllLabelIds(new ArrayList<Long>())
            .addAllAutomaticLabelIds(new ArrayList<Long>())
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
            .setFullName("fullName1330852282")
            .setDisplayName("displayName1714148973")
            .setHomepageUri("homepageUri1440042654")
            .setParent("parent-995424086")
            .addAllLabelIds(new ArrayList<Long>())
            .addAllAutomaticLabelIds(new ArrayList<Long>())
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
  public void updateLabelsTest() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setFullName("fullName1330852282")
            .setDisplayName("displayName1714148973")
            .setHomepageUri("homepageUri1440042654")
            .setParent("parent-995424086")
            .addAllLabelIds(new ArrayList<Long>())
            .addAllAutomaticLabelIds(new ArrayList<Long>())
            .build();
    mockAccountsService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.updateLabels(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountLabelsRequest actualRequest = ((UpdateAccountLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");
      client.updateLabels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLabelsTest2() throws Exception {
    Account expectedResponse =
        Account.newBuilder()
            .setName(AccountName.of("[ACCOUNT]").toString())
            .setFullName("fullName1330852282")
            .setDisplayName("displayName1714148973")
            .setHomepageUri("homepageUri1440042654")
            .setParent("parent-995424086")
            .addAllLabelIds(new ArrayList<Long>())
            .addAllAutomaticLabelIds(new ArrayList<Long>())
            .build();
    mockAccountsService.addResponse(expectedResponse);

    String name = "name3373707";

    Account actualResponse = client.updateLabels(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountLabelsRequest actualRequest = ((UpdateAccountLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountsService.addException(exception);

    try {
      String name = "name3373707";
      client.updateLabels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
