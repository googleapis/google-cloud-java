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

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonAccountServicesServiceStub;
import java.io.IOException;
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
public class AccountServicesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccountServicesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccountServicesServiceStub.getMethodDescriptors(),
            AccountServicesServiceSettings.getDefaultEndpoint());
    AccountServicesServiceSettings settings =
        AccountServicesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccountServicesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountServicesServiceClient.create(settings);
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
  public void getAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    AccountService actualResponse = client.getAccountService(name);
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
  public void getAccountServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.getAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-1564/services/service-1564";

    AccountService actualResponse = client.getAccountService(name);
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
  public void getAccountServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-1564/services/service-1564";
      client.getAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountServicesTest() throws Exception {
    AccountService responsesElement = AccountService.newBuilder().build();
    ListAccountServicesResponse expectedResponse =
        ListAccountServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountServices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountServicesPagedResponse pagedListResponse = client.listAccountServices(parent);

    List<AccountService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountServicesList().get(0), resources.get(0));

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
  public void listAccountServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountServicesTest2() throws Exception {
    AccountService responsesElement = AccountService.newBuilder().build();
    ListAccountServicesResponse expectedResponse =
        ListAccountServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountServices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListAccountServicesPagedResponse pagedListResponse = client.listAccountServices(parent);

    List<AccountService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountServicesList().get(0), resources.get(0));

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
  public void listAccountServicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listAccountServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    String provider = "provider-987494927";
    AccountService accountService = AccountService.newBuilder().build();

    AccountService actualResponse = client.proposeAccountService(parent, provider, accountService);
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
  public void proposeAccountServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      String provider = "provider-987494927";
      AccountService accountService = AccountService.newBuilder().build();
      client.proposeAccountService(parent, provider, accountService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    String provider = "provider-987494927";
    AccountService accountService = AccountService.newBuilder().build();

    AccountService actualResponse = client.proposeAccountService(parent, provider, accountService);
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
  public void proposeAccountServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      String provider = "provider-987494927";
      AccountService accountService = AccountService.newBuilder().build();
      client.proposeAccountService(parent, provider, accountService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    AccountService actualResponse = client.approveAccountService(name);
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
  public void approveAccountServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.approveAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-1564/services/service-1564";

    AccountService actualResponse = client.approveAccountService(name);
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
  public void approveAccountServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-1564/services/service-1564";
      client.approveAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectAccountServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    client.rejectAccountService(name);

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
  public void rejectAccountServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.rejectAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectAccountServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-1564/services/service-1564";

    client.rejectAccountService(name);

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
  public void rejectAccountServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-1564/services/service-1564";
      client.rejectAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
