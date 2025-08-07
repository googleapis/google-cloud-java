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

import static com.google.shopping.merchant.accounts.v1.AccountRelationshipsServiceClient.ListAccountRelationshipsPagedResponse;

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
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonAccountRelationshipsServiceStub;
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
public class AccountRelationshipsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccountRelationshipsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccountRelationshipsServiceStub.getMethodDescriptors(),
            AccountRelationshipsServiceSettings.getDefaultEndpoint());
    AccountRelationshipsServiceSettings settings =
        AccountRelationshipsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccountRelationshipsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountRelationshipsServiceClient.create(settings);
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
  public void getAccountRelationshipTest() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockService.addResponse(expectedResponse);

    AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");

    AccountRelationship actualResponse = client.getAccountRelationship(name);
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
  public void getAccountRelationshipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");
      client.getAccountRelationship(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountRelationshipTest2() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-5363/relationships/relationship-5363";

    AccountRelationship actualResponse = client.getAccountRelationship(name);
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
  public void getAccountRelationshipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-5363/relationships/relationship-5363";
      client.getAccountRelationship(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountRelationshipTest() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockService.addResponse(expectedResponse);

    AccountRelationship accountRelationship =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccountRelationship actualResponse =
        client.updateAccountRelationship(accountRelationship, updateMask);
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
  public void updateAccountRelationshipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountRelationship accountRelationship =
          AccountRelationship.newBuilder()
              .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
              .setProvider("provider-987494927")
              .setProviderDisplayName("providerDisplayName-597096516")
              .setAccountIdAlias("accountIdAlias-1952169208")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccountRelationship(accountRelationship, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountRelationshipsTest() throws Exception {
    AccountRelationship responsesElement = AccountRelationship.newBuilder().build();
    ListAccountRelationshipsResponse expectedResponse =
        ListAccountRelationshipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountRelationships(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountRelationshipsPagedResponse pagedListResponse =
        client.listAccountRelationships(parent);

    List<AccountRelationship> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountRelationshipsList().get(0), resources.get(0));

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
  public void listAccountRelationshipsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountRelationships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountRelationshipsTest2() throws Exception {
    AccountRelationship responsesElement = AccountRelationship.newBuilder().build();
    ListAccountRelationshipsResponse expectedResponse =
        ListAccountRelationshipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountRelationships(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListAccountRelationshipsPagedResponse pagedListResponse =
        client.listAccountRelationships(parent);

    List<AccountRelationship> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountRelationshipsList().get(0), resources.get(0));

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
  public void listAccountRelationshipsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listAccountRelationships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
