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
package com.google.cloud.billing.budgets.v1beta1;

import static com.google.cloud.billing.budgets.v1beta1.BudgetServiceClient.ListBudgetsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class BudgetServiceClientTest {
  private static MockBudgetService mockBudgetService;
  private static MockServiceHelper serviceHelper;
  private BudgetServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBudgetService = new MockBudgetService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBudgetService));
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
  @SuppressWarnings("all")
  public void createBudgetTest() {
    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setEtag(etag)
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    Budget budget = Budget.newBuilder().build();
    CreateBudgetRequest request =
        CreateBudgetRequest.newBuilder().setParent(parent.toString()).setBudget(budget).build();

    Budget actualResponse = client.createBudget(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBudgetRequest actualRequest = (CreateBudgetRequest) actualRequests.get(0);

    Assert.assertEquals(parent, BillingAccountName.parse(actualRequest.getParent()));
    Assert.assertEquals(budget, actualRequest.getBudget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      Budget budget = Budget.newBuilder().build();
      CreateBudgetRequest request =
          CreateBudgetRequest.newBuilder().setParent(parent.toString()).setBudget(budget).build();

      client.createBudget(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBudgetTest() {
    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setEtag(etag)
            .build();
    mockBudgetService.addResponse(expectedResponse);

    Budget budget = Budget.newBuilder().build();
    UpdateBudgetRequest request = UpdateBudgetRequest.newBuilder().setBudget(budget).build();

    Budget actualResponse = client.updateBudget(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBudgetRequest actualRequest = (UpdateBudgetRequest) actualRequests.get(0);

    Assert.assertEquals(budget, actualRequest.getBudget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      Budget budget = Budget.newBuilder().build();
      UpdateBudgetRequest request = UpdateBudgetRequest.newBuilder().setBudget(budget).build();

      client.updateBudget(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBudgetTest() {
    BudgetName name2 = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Budget expectedResponse =
        Budget.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setEtag(etag)
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
    GetBudgetRequest request = GetBudgetRequest.newBuilder().setName(name.toString()).build();

    Budget actualResponse = client.getBudget(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBudgetRequest actualRequest = (GetBudgetRequest) actualRequests.get(0);

    Assert.assertEquals(name, BudgetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
      GetBudgetRequest request = GetBudgetRequest.newBuilder().setName(name.toString()).build();

      client.getBudget(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBudgetsTest() {
    String nextPageToken = "";
    Budget budgetsElement = Budget.newBuilder().build();
    List<Budget> budgets = Arrays.asList(budgetsElement);
    ListBudgetsResponse expectedResponse =
        ListBudgetsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllBudgets(budgets)
            .build();
    mockBudgetService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    ListBudgetsRequest request =
        ListBudgetsRequest.newBuilder().setParent(parent.toString()).build();

    ListBudgetsPagedResponse pagedListResponse = client.listBudgets(request);

    List<Budget> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBudgetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBudgetsRequest actualRequest = (ListBudgetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, BillingAccountName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBudgetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      ListBudgetsRequest request =
          ListBudgetsRequest.newBuilder().setParent(parent.toString()).build();

      client.listBudgets(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBudgetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBudgetService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
    DeleteBudgetRequest request = DeleteBudgetRequest.newBuilder().setName(name.toString()).build();

    client.deleteBudget(request);

    List<AbstractMessage> actualRequests = mockBudgetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBudgetRequest actualRequest = (DeleteBudgetRequest) actualRequests.get(0);

    Assert.assertEquals(name, BudgetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBudgetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBudgetService.addException(exception);

    try {
      BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
      DeleteBudgetRequest request =
          DeleteBudgetRequest.newBuilder().setName(name.toString()).build();

      client.deleteBudget(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
