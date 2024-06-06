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

import static com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyServiceClient.ListOnlineReturnPoliciesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonOnlineReturnPolicyServiceStub;
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
public class OnlineReturnPolicyServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OnlineReturnPolicyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOnlineReturnPolicyServiceStub.getMethodDescriptors(),
            OnlineReturnPolicyServiceSettings.getDefaultEndpoint());
    OnlineReturnPolicyServiceSettings settings =
        OnlineReturnPolicyServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OnlineReturnPolicyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OnlineReturnPolicyServiceClient.create(settings);
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
  public void getOnlineReturnPolicyTest() throws Exception {
    OnlineReturnPolicy expectedResponse =
        OnlineReturnPolicy.newBuilder()
            .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
            .setReturnPolicyId("returnPolicyId-636904643")
            .setLabel("label102727412")
            .addAllCountries(new ArrayList<String>())
            .setPolicy(OnlineReturnPolicy.Policy.newBuilder().build())
            .setRestockingFee(OnlineReturnPolicy.RestockingFee.newBuilder().build())
            .addAllReturnMethods(new ArrayList<OnlineReturnPolicy.ReturnMethod>())
            .addAllItemConditions(new ArrayList<OnlineReturnPolicy.ItemCondition>())
            .setReturnShippingFee(OnlineReturnPolicy.ReturnShippingFee.newBuilder().build())
            .setReturnPolicyUri("returnPolicyUri1730804618")
            .setAcceptDefectiveOnly(true)
            .setProcessRefundDays(1233584878)
            .setAcceptExchange(true)
            .build();
    mockService.addResponse(expectedResponse);

    OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");

    OnlineReturnPolicy actualResponse = client.getOnlineReturnPolicy(name);
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
  public void getOnlineReturnPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");
      client.getOnlineReturnPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOnlineReturnPolicyTest2() throws Exception {
    OnlineReturnPolicy expectedResponse =
        OnlineReturnPolicy.newBuilder()
            .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
            .setReturnPolicyId("returnPolicyId-636904643")
            .setLabel("label102727412")
            .addAllCountries(new ArrayList<String>())
            .setPolicy(OnlineReturnPolicy.Policy.newBuilder().build())
            .setRestockingFee(OnlineReturnPolicy.RestockingFee.newBuilder().build())
            .addAllReturnMethods(new ArrayList<OnlineReturnPolicy.ReturnMethod>())
            .addAllItemConditions(new ArrayList<OnlineReturnPolicy.ItemCondition>())
            .setReturnShippingFee(OnlineReturnPolicy.ReturnShippingFee.newBuilder().build())
            .setReturnPolicyUri("returnPolicyUri1730804618")
            .setAcceptDefectiveOnly(true)
            .setProcessRefundDays(1233584878)
            .setAcceptExchange(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4527/onlineReturnPolicies/onlineReturnPolicie-4527";

    OnlineReturnPolicy actualResponse = client.getOnlineReturnPolicy(name);
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
  public void getOnlineReturnPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4527/onlineReturnPolicies/onlineReturnPolicie-4527";
      client.getOnlineReturnPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOnlineReturnPoliciesTest() throws Exception {
    OnlineReturnPolicy responsesElement = OnlineReturnPolicy.newBuilder().build();
    ListOnlineReturnPoliciesResponse expectedResponse =
        ListOnlineReturnPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOnlineReturnPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListOnlineReturnPoliciesPagedResponse pagedListResponse =
        client.listOnlineReturnPolicies(parent);

    List<OnlineReturnPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOnlineReturnPoliciesList().get(0), resources.get(0));

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
  public void listOnlineReturnPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listOnlineReturnPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOnlineReturnPoliciesTest2() throws Exception {
    OnlineReturnPolicy responsesElement = OnlineReturnPolicy.newBuilder().build();
    ListOnlineReturnPoliciesResponse expectedResponse =
        ListOnlineReturnPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOnlineReturnPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListOnlineReturnPoliciesPagedResponse pagedListResponse =
        client.listOnlineReturnPolicies(parent);

    List<OnlineReturnPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOnlineReturnPoliciesList().get(0), resources.get(0));

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
  public void listOnlineReturnPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listOnlineReturnPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
