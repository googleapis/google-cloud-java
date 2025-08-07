/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.GbpAccountsServiceClient.ListGbpAccountsPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class GbpAccountsServiceClientTest {
  private static MockGbpAccountsService mockGbpAccountsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GbpAccountsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGbpAccountsService = new MockGbpAccountsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGbpAccountsService));
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
    GbpAccountsServiceSettings settings =
        GbpAccountsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GbpAccountsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listGbpAccountsTest() throws Exception {
    GbpAccount responsesElement = GbpAccount.newBuilder().build();
    ListGbpAccountsResponse expectedResponse =
        ListGbpAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGbpAccounts(Arrays.asList(responsesElement))
            .build();
    mockGbpAccountsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListGbpAccountsPagedResponse pagedListResponse = client.listGbpAccounts(parent);

    List<GbpAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGbpAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGbpAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGbpAccountsRequest actualRequest = ((ListGbpAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGbpAccountsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGbpAccountsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listGbpAccounts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGbpAccountsTest2() throws Exception {
    GbpAccount responsesElement = GbpAccount.newBuilder().build();
    ListGbpAccountsResponse expectedResponse =
        ListGbpAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGbpAccounts(Arrays.asList(responsesElement))
            .build();
    mockGbpAccountsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGbpAccountsPagedResponse pagedListResponse = client.listGbpAccounts(parent);

    List<GbpAccount> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGbpAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGbpAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGbpAccountsRequest actualRequest = ((ListGbpAccountsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGbpAccountsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGbpAccountsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGbpAccounts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkGbpAccountTest() throws Exception {
    LinkGbpAccountResponse expectedResponse =
        LinkGbpAccountResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockGbpAccountsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    LinkGbpAccountResponse actualResponse = client.linkGbpAccount(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGbpAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkGbpAccountRequest actualRequest = ((LinkGbpAccountRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkGbpAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGbpAccountsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.linkGbpAccount(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkGbpAccountTest2() throws Exception {
    LinkGbpAccountResponse expectedResponse =
        LinkGbpAccountResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockGbpAccountsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    LinkGbpAccountResponse actualResponse = client.linkGbpAccount(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGbpAccountsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkGbpAccountRequest actualRequest = ((LinkGbpAccountRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkGbpAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGbpAccountsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.linkGbpAccount(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
