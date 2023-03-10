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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.billing.budgets.v1.stub.HttpJsonBudgetServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BudgetServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BudgetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBudgetServiceStub.getMethodDescriptors(),
            BudgetServiceSettings.getDefaultEndpoint());
    BudgetServiceSettings settings =
        BudgetServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BudgetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BudgetServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    Budget budget = Budget.newBuilder().build();

    Budget actualResponse = client.createBudget(parent, budget);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBudgetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "billingAccounts/billingAccount-7950";
    Budget budget = Budget.newBuilder().build();

    Budget actualResponse = client.createBudget(parent, budget);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBudgetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "billingAccounts/billingAccount-7950";
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
    mockService.addResponse(expectedResponse);

    Budget budget =
        Budget.newBuilder()
            .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
            .setDisplayName("displayName1714148973")
            .setBudgetFilter(Filter.newBuilder().build())
            .setAmount(BudgetAmount.newBuilder().build())
            .addAllThresholdRules(new ArrayList<ThresholdRule>())
            .setNotificationsRule(NotificationsRule.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Budget actualResponse = client.updateBudget(budget, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBudgetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Budget budget =
          Budget.newBuilder()
              .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
              .setDisplayName("displayName1714148973")
              .setBudgetFilter(Filter.newBuilder().build())
              .setAmount(BudgetAmount.newBuilder().build())
              .addAllThresholdRules(new ArrayList<ThresholdRule>())
              .setNotificationsRule(NotificationsRule.newBuilder().build())
              .setEtag("etag3123477")
              .build();
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
    mockService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");

    Budget actualResponse = client.getBudget(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBudgetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "billingAccounts/billingAccount-7221/budgets/budget-7221";

    Budget actualResponse = client.getBudget(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBudgetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "billingAccounts/billingAccount-7221/budgets/budget-7221";
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
    mockService.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListBudgetsPagedResponse pagedListResponse = client.listBudgets(parent);

    List<Budget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBudgetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBudgetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "billingAccounts/billingAccount-7950";

    ListBudgetsPagedResponse pagedListResponse = client.listBudgets(parent);

    List<Budget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBudgetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBudgetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "billingAccounts/billingAccount-7950";
      client.listBudgets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBudgetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");

    client.deleteBudget(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBudgetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "billingAccounts/billingAccount-7221/budgets/budget-7221";

    client.deleteBudget(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBudgetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "billingAccounts/billingAccount-7221/budgets/budget-7221";
      client.deleteBudget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
