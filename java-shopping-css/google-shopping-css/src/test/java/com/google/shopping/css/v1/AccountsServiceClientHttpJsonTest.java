/*
 * Copyright 2023 Google LLC
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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.shopping.css.v1.stub.HttpJsonAccountsServiceStub;
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
public class AccountsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccountsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccountsServiceStub.getMethodDescriptors(),
            AccountsServiceSettings.getDefaultEndpoint());
    AccountsServiceSettings settings =
        AccountsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccountsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountsServiceClient.create(settings);
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
  public void listChildAccountsTest() throws Exception {
    Account responsesElement = Account.newBuilder().build();
    ListChildAccountsResponse expectedResponse =
        ListChildAccountsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccounts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListChildAccountsPagedResponse pagedListResponse = client.listChildAccounts(parent);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

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
  public void listChildAccountsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListChildAccountsPagedResponse pagedListResponse = client.listChildAccounts(parent);

    List<Account> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountsList().get(0), resources.get(0));

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
  public void listChildAccountsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
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
    mockService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.getAccount(name);
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
  public void getAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3500";

    Account actualResponse = client.getAccount(name);
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
  public void getAccountExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3500";
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
    mockService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    Account actualResponse = client.updateLabels(name);
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
  public void updateLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3500";

    Account actualResponse = client.updateLabels(name);
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
  public void updateLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3500";
      client.updateLabels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
