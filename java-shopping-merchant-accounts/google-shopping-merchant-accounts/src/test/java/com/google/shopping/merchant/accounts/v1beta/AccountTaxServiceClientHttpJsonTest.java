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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonAccountTaxServiceStub;
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
public class AccountTaxServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccountTaxServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccountTaxServiceStub.getMethodDescriptors(),
            AccountTaxServiceSettings.getDefaultEndpoint());
    AccountTaxServiceSettings settings =
        AccountTaxServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccountTaxServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountTaxServiceClient.create(settings);
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
  public void getAccountTaxTest() throws Exception {
    AccountTax expectedResponse =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    mockService.addResponse(expectedResponse);

    AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");

    AccountTax actualResponse = client.getAccountTax(name);
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
  public void getAccountTaxExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8428/accounttax/accountta-8428";

    AccountTax actualResponse = client.getAccountTax(name);
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
  public void getAccountTaxExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8428/accounttax/accountta-8428";
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountTaxPagedResponse pagedListResponse = client.listAccountTax(parent);

    List<AccountTax> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountTaxesList().get(0), resources.get(0));

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
  public void listAccountTaxExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListAccountTaxPagedResponse pagedListResponse = client.listAccountTax(parent);

    List<AccountTax> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountTaxesList().get(0), resources.get(0));

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
  public void listAccountTaxExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
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
    mockService.addResponse(expectedResponse);

    AccountTax accountTax =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();

    AccountTax actualResponse = client.updateAccountTax(accountTax);
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
  public void updateAccountTaxExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountTax accountTax =
          AccountTax.newBuilder()
              .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
              .setAccount(-1177318867)
              .addAllTaxRules(new ArrayList<TaxRule>())
              .build();
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
    mockService.addResponse(expectedResponse);

    AccountTax accountTax =
        AccountTax.newBuilder()
            .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
            .setAccount(-1177318867)
            .addAllTaxRules(new ArrayList<TaxRule>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccountTax actualResponse = client.updateAccountTax(accountTax, updateMask);
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
  public void updateAccountTaxExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountTax accountTax =
          AccountTax.newBuilder()
              .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
              .setAccount(-1177318867)
              .addAllTaxRules(new ArrayList<TaxRule>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccountTax(accountTax, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
