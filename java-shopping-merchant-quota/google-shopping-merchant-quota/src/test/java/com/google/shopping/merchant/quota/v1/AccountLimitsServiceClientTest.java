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

package com.google.shopping.merchant.quota.v1;

import static com.google.shopping.merchant.quota.v1.AccountLimitsServiceClient.ListAccountLimitsPagedResponse;

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
public class AccountLimitsServiceClientTest {
  private static MockAccountLimitsService mockAccountLimitsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountLimitsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountLimitsService = new MockAccountLimitsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccountLimitsService));
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
    AccountLimitsServiceSettings settings =
        AccountLimitsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountLimitsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAccountLimitTest() throws Exception {
    AccountLimit expectedResponse =
        AccountLimit.newBuilder()
            .setName(AccountLimitName.of("[ACCOUNT]", "[LIMIT]").toString())
            .build();
    mockAccountLimitsService.addResponse(expectedResponse);

    AccountLimitName name = AccountLimitName.of("[ACCOUNT]", "[LIMIT]");

    AccountLimit actualResponse = client.getAccountLimit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountLimitsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountLimitRequest actualRequest = ((GetAccountLimitRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountLimitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLimitsService.addException(exception);

    try {
      AccountLimitName name = AccountLimitName.of("[ACCOUNT]", "[LIMIT]");
      client.getAccountLimit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountLimitTest2() throws Exception {
    AccountLimit expectedResponse =
        AccountLimit.newBuilder()
            .setName(AccountLimitName.of("[ACCOUNT]", "[LIMIT]").toString())
            .build();
    mockAccountLimitsService.addResponse(expectedResponse);

    String name = "name3373707";

    AccountLimit actualResponse = client.getAccountLimit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountLimitsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountLimitRequest actualRequest = ((GetAccountLimitRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountLimitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLimitsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccountLimit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountLimitsTest() throws Exception {
    AccountLimit responsesElement = AccountLimit.newBuilder().build();
    ListAccountLimitsResponse expectedResponse =
        ListAccountLimitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountLimits(Arrays.asList(responsesElement))
            .build();
    mockAccountLimitsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountLimitsPagedResponse pagedListResponse = client.listAccountLimits(parent);

    List<AccountLimit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountLimitsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountLimitsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountLimitsRequest actualRequest = ((ListAccountLimitsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountLimitsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLimitsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountLimits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountLimitsTest2() throws Exception {
    AccountLimit responsesElement = AccountLimit.newBuilder().build();
    ListAccountLimitsResponse expectedResponse =
        ListAccountLimitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountLimits(Arrays.asList(responsesElement))
            .build();
    mockAccountLimitsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountLimitsPagedResponse pagedListResponse = client.listAccountLimits(parent);

    List<AccountLimit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountLimitsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountLimitsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountLimitsRequest actualRequest = ((ListAccountLimitsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountLimitsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLimitsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountLimits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
