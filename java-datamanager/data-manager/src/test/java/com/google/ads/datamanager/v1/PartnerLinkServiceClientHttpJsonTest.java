/*
 * Copyright 2026 Google LLC
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

package com.google.ads.datamanager.v1;

import static com.google.ads.datamanager.v1.PartnerLinkServiceClient.SearchPartnerLinksPagedResponse;

import com.google.ads.datamanager.v1.stub.HttpJsonPartnerLinkServiceStub;
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
public class PartnerLinkServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PartnerLinkServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPartnerLinkServiceStub.getMethodDescriptors(),
            PartnerLinkServiceSettings.getDefaultEndpoint());
    PartnerLinkServiceSettings settings =
        PartnerLinkServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PartnerLinkServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PartnerLinkServiceClient.create(settings);
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
  public void createPartnerLinkTest() throws Exception {
    PartnerLink expectedResponse =
        PartnerLink.newBuilder()
            .setName(PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
            .setPartnerLinkId("partnerLinkId171029917")
            .setOwningAccount(ProductAccount.newBuilder().build())
            .setPartnerAccount(ProductAccount.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    PartnerLink partnerLink = PartnerLink.newBuilder().build();

    PartnerLink actualResponse = client.createPartnerLink(parent, partnerLink);
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
  public void createPartnerLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      PartnerLink partnerLink = PartnerLink.newBuilder().build();
      client.createPartnerLink(parent, partnerLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPartnerLinkTest2() throws Exception {
    PartnerLink expectedResponse =
        PartnerLink.newBuilder()
            .setName(PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
            .setPartnerLinkId("partnerLinkId171029917")
            .setOwningAccount(ProductAccount.newBuilder().build())
            .setPartnerAccount(ProductAccount.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";
    PartnerLink partnerLink = PartnerLink.newBuilder().build();

    PartnerLink actualResponse = client.createPartnerLink(parent, partnerLink);
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
  public void createPartnerLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
      PartnerLink partnerLink = PartnerLink.newBuilder().build();
      client.createPartnerLink(parent, partnerLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartnerLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PartnerLinkName name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]");

    client.deletePartnerLink(name);

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
  public void deletePartnerLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PartnerLinkName name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]");
      client.deletePartnerLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartnerLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "accountTypes/accountType-9923/accounts/account-9923/partnerLinks/partnerLink-9923";

    client.deletePartnerLink(name);

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
  public void deletePartnerLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accountTypes/accountType-9923/accounts/account-9923/partnerLinks/partnerLink-9923";
      client.deletePartnerLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPartnerLinksTest() throws Exception {
    PartnerLink responsesElement = PartnerLink.newBuilder().build();
    SearchPartnerLinksResponse expectedResponse =
        SearchPartnerLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartnerLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    SearchPartnerLinksPagedResponse pagedListResponse = client.searchPartnerLinks(parent);

    List<PartnerLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnerLinksList().get(0), resources.get(0));

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
  public void searchPartnerLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      client.searchPartnerLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPartnerLinksTest2() throws Exception {
    PartnerLink responsesElement = PartnerLink.newBuilder().build();
    SearchPartnerLinksResponse expectedResponse =
        SearchPartnerLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartnerLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";

    SearchPartnerLinksPagedResponse pagedListResponse = client.searchPartnerLinks(parent);

    List<PartnerLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnerLinksList().get(0), resources.get(0));

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
  public void searchPartnerLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
      client.searchPartnerLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
