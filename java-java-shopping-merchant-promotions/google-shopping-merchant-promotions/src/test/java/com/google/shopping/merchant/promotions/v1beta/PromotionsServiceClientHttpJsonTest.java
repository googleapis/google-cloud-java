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

package com.google.shopping.merchant.promotions.v1beta;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

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
import com.google.shopping.merchant.promotions.v1beta.stub.HttpJsonPromotionsServiceStub;
import com.google.shopping.type.CustomAttribute;
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
public class PromotionsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PromotionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPromotionsServiceStub.getMethodDescriptors(),
            PromotionsServiceSettings.getDefaultEndpoint());
    PromotionsServiceSettings settings =
        PromotionsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PromotionsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PromotionsServiceClient.create(settings);
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
  public void insertPromotionTest() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockService.addResponse(expectedResponse);

    InsertPromotionRequest request =
        InsertPromotionRequest.newBuilder()
            .setParent("accounts/account-4811")
            .setPromotion(Promotion.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    Promotion actualResponse = client.insertPromotion(request);
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
  public void insertPromotionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertPromotionRequest request =
          InsertPromotionRequest.newBuilder()
              .setParent("accounts/account-4811")
              .setPromotion(Promotion.newBuilder().build())
              .setDataSource("dataSource1272470629")
              .build();
      client.insertPromotion(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPromotionTest() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockService.addResponse(expectedResponse);

    PromotionName name = PromotionName.of("[ACCOUNT]", "[PROMOTION]");

    Promotion actualResponse = client.getPromotion(name);
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
  public void getPromotionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PromotionName name = PromotionName.of("[ACCOUNT]", "[PROMOTION]");
      client.getPromotion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPromotionTest2() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-6242/promotions/promotion-6242";

    Promotion actualResponse = client.getPromotion(name);
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
  public void getPromotionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-6242/promotions/promotion-6242";
      client.getPromotion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPromotionsTest() throws Exception {
    Promotion responsesElement = Promotion.newBuilder().build();
    ListPromotionsResponse expectedResponse =
        ListPromotionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPromotions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListPromotionsPagedResponse pagedListResponse = client.listPromotions(parent);

    List<Promotion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPromotionsList().get(0), resources.get(0));

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
  public void listPromotionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listPromotions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
