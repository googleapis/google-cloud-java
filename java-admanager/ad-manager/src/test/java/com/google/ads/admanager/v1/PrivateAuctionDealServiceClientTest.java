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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.PrivateAuctionDealServiceClient.ListPrivateAuctionDealsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonPrivateAuctionDealServiceStub;
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
import com.google.protobuf.Timestamp;
import com.google.type.Money;
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
public class PrivateAuctionDealServiceClientTest {
  private static MockHttpService mockService;
  private static PrivateAuctionDealServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPrivateAuctionDealServiceStub.getMethodDescriptors(),
            PrivateAuctionDealServiceSettings.getDefaultEndpoint());
    PrivateAuctionDealServiceSettings settings =
        PrivateAuctionDealServiceSettings.newBuilder()
            .setTransportChannelProvider(
                PrivateAuctionDealServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrivateAuctionDealServiceClient.create(settings);
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
  public void getPrivateAuctionDealTest() throws Exception {
    PrivateAuctionDeal expectedResponse =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateAuctionDealName name =
        PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]");

    PrivateAuctionDeal actualResponse = client.getPrivateAuctionDeal(name);
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
  public void getPrivateAuctionDealExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateAuctionDealName name =
          PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]");
      client.getPrivateAuctionDeal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateAuctionDealTest2() throws Exception {
    PrivateAuctionDeal expectedResponse =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-2898/privateAuctionDeals/privateAuctionDeal-2898";

    PrivateAuctionDeal actualResponse = client.getPrivateAuctionDeal(name);
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
  public void getPrivateAuctionDealExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-2898/privateAuctionDeals/privateAuctionDeal-2898";
      client.getPrivateAuctionDeal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateAuctionDealsTest() throws Exception {
    PrivateAuctionDeal responsesElement = PrivateAuctionDeal.newBuilder().build();
    ListPrivateAuctionDealsResponse expectedResponse =
        ListPrivateAuctionDealsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateAuctionDeals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListPrivateAuctionDealsPagedResponse pagedListResponse = client.listPrivateAuctionDeals(parent);

    List<PrivateAuctionDeal> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateAuctionDealsList().get(0), resources.get(0));

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
  public void listPrivateAuctionDealsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listPrivateAuctionDeals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateAuctionDealsTest2() throws Exception {
    PrivateAuctionDeal responsesElement = PrivateAuctionDeal.newBuilder().build();
    ListPrivateAuctionDealsResponse expectedResponse =
        ListPrivateAuctionDealsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateAuctionDeals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListPrivateAuctionDealsPagedResponse pagedListResponse = client.listPrivateAuctionDeals(parent);

    List<PrivateAuctionDeal> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateAuctionDealsList().get(0), resources.get(0));

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
  public void listPrivateAuctionDealsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listPrivateAuctionDeals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateAuctionDealTest() throws Exception {
    PrivateAuctionDeal expectedResponse =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();

    PrivateAuctionDeal actualResponse = client.createPrivateAuctionDeal(parent, privateAuctionDeal);
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
  public void createPrivateAuctionDealExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();
      client.createPrivateAuctionDeal(parent, privateAuctionDeal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateAuctionDealTest2() throws Exception {
    PrivateAuctionDeal expectedResponse =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();

    PrivateAuctionDeal actualResponse = client.createPrivateAuctionDeal(parent, privateAuctionDeal);
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
  public void createPrivateAuctionDealExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();
      client.createPrivateAuctionDeal(parent, privateAuctionDeal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrivateAuctionDealTest() throws Exception {
    PrivateAuctionDeal expectedResponse =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateAuctionDeal privateAuctionDeal =
        PrivateAuctionDeal.newBuilder()
            .setName(
                PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
            .setPrivateAuctionDealId(1870574870)
            .setPrivateAuctionId(-20317997)
            .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
            .setBuyerAccountId(-994282887)
            .setExternalDealId(-66314918)
            .setTargeting(Targeting.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setFloorPrice(Money.newBuilder().build())
            .addAllCreativeSizes(new ArrayList<Size>())
            .setAuctionPriorityEnabled(true)
            .setBlockOverrideEnabled(true)
            .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateAuctionDeal actualResponse =
        client.updatePrivateAuctionDeal(privateAuctionDeal, updateMask);
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
  public void updatePrivateAuctionDealExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateAuctionDeal privateAuctionDeal =
          PrivateAuctionDeal.newBuilder()
              .setName(
                  PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
              .setPrivateAuctionDealId(1870574870)
              .setPrivateAuctionId(-20317997)
              .setPrivateAuctionDisplayName("privateAuctionDisplayName1032179469")
              .setBuyerAccountId(-994282887)
              .setExternalDealId(-66314918)
              .setTargeting(Targeting.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setFloorPrice(Money.newBuilder().build())
              .addAllCreativeSizes(new ArrayList<Size>())
              .setAuctionPriorityEnabled(true)
              .setBlockOverrideEnabled(true)
              .setBuyerData(PrivateAuctionDeal.BuyerData.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateAuctionDeal(privateAuctionDeal, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
