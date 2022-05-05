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

package com.google.cloud.billing.budgets.v1;

import static com.google.cloud.billing.budgets.v1.BudgetServiceClient.ListBudgetsPagedResponse;

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
public class BudgetServiceClientTest {
  private static MockBudgetService mockBudgetService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BudgetServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBudgetService = new MockBudgetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBudgetService));
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
    BudgetServiceSettings settings =
        BudgetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BudgetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createBudgetTest() throws Exception {
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    Budget budget = Budget.newBuilder().build();

    Budget actualResponse = client.createBudget(parent, budget);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBudgetRequest actualRequest = ((CreateBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(budget, actualRequest.getBudget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      Budget budget = Budget.newBuilder().build();
      client.createBudget(parent, budget);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBudgetTest2() throws Exception {
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockBudgetService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Budget budget = Budget.newBuilder().build();

    Budget actualResponse = client.createBudget(parent, budget);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBudgetRequest actualRequest = ((CreateBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(budget, actualRequest.getBudget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBudgetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      String parent = "parent-995424086";
      Budget budget = Budget.newBuilder().build();
      client.createBudget(parent, budget);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBudgetTest() throws Exception {
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockBudgetService.addResponse(expectedResponse);

    Budget budget = Budget.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Budget actualResponse = client.updateBudget(budget, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBudgetRequest actualRequest = ((UpdateBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(budget, actualRequest.getBudget());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      Budget budget = Budget.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBudget(budget, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBudgetTest() throws Exception {
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");

    Budget actualResponse = client.getBudget(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBudgetRequest actualRequest = ((GetBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
      client.getBudget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBudgetTest2() throws Exception {
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockBudgetService.addResponse(expectedResponse);

    String name = "name3373707";

    Budget actualResponse = client.getBudget(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBudgetRequest actualRequest = ((GetBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBudgetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      String name = "name3373707";
      client.getBudget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBudgetsTest() throws Exception {
    Budget responsesElement = Budget.newBuilder().build();
    ListBudgetsResponse expectedResponse =
        ListBudgetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBudgets(Arrays.asList(responsesElement))
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListBudgetsPagedResponse pagedListResponse = client.listBudgets(parent);

    List<Budget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBudgetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBudgetsRequest actualRequest = ((ListBudgetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBudgetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listBudgets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBudgetsTest2() throws Exception {
    Budget responsesElement = Budget.newBuilder().build();
    ListBudgetsResponse expectedResponse =
        ListBudgetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBudgets(Arrays.asList(responsesElement))
            .build();
    mockBudgetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBudgetsPagedResponse pagedListResponse = client.listBudgets(parent);

    List<Budget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBudgetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBudgetsRequest actualRequest = ((ListBudgetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBudgetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBudgets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBudgetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBudgetService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");

    client.deleteBudget(name);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBudgetRequest actualRequest = ((DeleteBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
      client.deleteBudget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBudgetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBudgetService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBudget(name);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBudgetRequest actualRequest = ((DeleteBudgetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBudgetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBudget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
