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

import static com.google.shopping.merchant.accounts.v1beta.AccountTaxServiceClient.ListAccountTaxPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class AccountTaxServiceClientTest {
  private static MockAccountTaxService mockAccountTaxService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountTaxServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountTaxService = new MockAccountTaxService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccountTaxService));
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
    AccountTaxServiceSettings settings =
        AccountTaxServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountTaxServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAccountTaxTest() throws Exception {
    AccountTax expectedResponse =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");

    AccountTax actualResponse = client.getAccountTax(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountTaxRequest actualRequest = ((GetAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountTaxExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");
      client.getAccountTax(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountTaxTest2() throws Exception {
    AccountTax expectedResponse =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    String name = "name3373707";

    AccountTax actualResponse = client.getAccountTax(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountTaxRequest actualRequest = ((GetAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountTaxExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccountTax(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountTaxTest() throws Exception {
    AccountTax responsesElement = AccountTax.newBuilder().build();
    ListAccountTaxResponse expectedResponse =
        ListAccountTaxResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountTaxes(Arrays.asList(responsesElement))
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountTaxPagedResponse pagedListResponse = client.listAccountTax(parent);

    List<AccountTax> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountTaxesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountTaxRequest actualRequest = ((ListAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountTaxExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountTax(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountTaxTest2() throws Exception {
    AccountTax responsesElement = AccountTax.newBuilder().build();
    ListAccountTaxResponse expectedResponse =
        ListAccountTaxResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountTaxes(Arrays.asList(responsesElement))
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountTaxPagedResponse pagedListResponse = client.listAccountTax(parent);

    List<AccountTax> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountTaxesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountTaxRequest actualRequest = ((ListAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountTaxExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountTax(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountTaxTest() throws Exception {
    AccountTax expectedResponse =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    AccountTax accountTax = AccountTax.newBuilder().build();

    AccountTax actualResponse = client.updateAccountTax(accountTax);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountTaxRequest actualRequest = ((UpdateAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(accountTax, actualRequest.getAccountTax());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccountTaxExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      AccountTax accountTax = AccountTax.newBuilder().build();
      client.updateAccountTax(accountTax);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountTaxTest2() throws Exception {
    AccountTax expectedResponse =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    mockAccountTaxService.addResponse(expectedResponse);

    AccountTax accountTax = AccountTax.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccountTax actualResponse = client.updateAccountTax(accountTax, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountTaxService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountTaxRequest actualRequest = ((UpdateAccountTaxRequest) actualRequests.get(0));

    Assert.assertEquals(accountTax, actualRequest.getAccountTax());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccountTaxExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountTaxService.addException(exception);

    try {
      AccountTax accountTax = AccountTax.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccountTax(accountTax, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
