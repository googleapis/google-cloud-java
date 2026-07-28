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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.AdSpotServiceClient.ListAdSpotsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonAdSpotServiceStub;
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
import com.google.protobuf.Duration;
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
public class AdSpotServiceClientTest {
  private static MockHttpService mockService;
  private static AdSpotServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAdSpotServiceStub.getMethodDescriptors(),
            AdSpotServiceSettings.getDefaultEndpoint());
    AdSpotServiceSettings settings =
        AdSpotServiceSettings.newBuilder()
            .setTransportChannelProvider(
                AdSpotServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdSpotServiceClient.create(settings);
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
  public void getAdSpotTest() throws Exception {
    AdSpot expectedResponse =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    mockService.addResponse(expectedResponse);

    AdSpotName name = AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]");

    AdSpot actualResponse = client.getAdSpot(name);
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
  public void getAdSpotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdSpotName name = AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]");
      client.getAdSpot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdSpotTest2() throws Exception {
    AdSpot expectedResponse =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-6619/adSpots/adSpot-6619";

    AdSpot actualResponse = client.getAdSpot(name);
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
  public void getAdSpotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6619/adSpots/adSpot-6619";
      client.getAdSpot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdSpotsTest() throws Exception {
    AdSpot responsesElement = AdSpot.newBuilder().build();
    ListAdSpotsResponse expectedResponse =
        ListAdSpotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdSpots(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListAdSpotsPagedResponse pagedListResponse = client.listAdSpots(parent);

    List<AdSpot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdSpotsList().get(0), resources.get(0));

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
  public void listAdSpotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listAdSpots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdSpotsTest2() throws Exception {
    AdSpot responsesElement = AdSpot.newBuilder().build();
    ListAdSpotsResponse expectedResponse =
        ListAdSpotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdSpots(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListAdSpotsPagedResponse pagedListResponse = client.listAdSpots(parent);

    List<AdSpot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdSpotsList().get(0), resources.get(0));

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
  public void listAdSpotsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listAdSpots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdSpotTest() throws Exception {
    AdSpot expectedResponse =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    AdSpot adSpot = AdSpot.newBuilder().build();

    AdSpot actualResponse = client.createAdSpot(parent, adSpot);
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
  public void createAdSpotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      AdSpot adSpot = AdSpot.newBuilder().build();
      client.createAdSpot(parent, adSpot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdSpotTest2() throws Exception {
    AdSpot expectedResponse =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    AdSpot adSpot = AdSpot.newBuilder().build();

    AdSpot actualResponse = client.createAdSpot(parent, adSpot);
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
  public void createAdSpotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      AdSpot adSpot = AdSpot.newBuilder().build();
      client.createAdSpot(parent, adSpot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateAdSpotsTest() throws Exception {
    BatchCreateAdSpotsResponse expectedResponse =
        BatchCreateAdSpotsResponse.newBuilder().addAllAdSpots(new ArrayList<AdSpot>()).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateAdSpotRequest> requests = new ArrayList<>();

    BatchCreateAdSpotsResponse actualResponse = client.batchCreateAdSpots(parent, requests);
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
  public void batchCreateAdSpotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateAdSpotRequest> requests = new ArrayList<>();
      client.batchCreateAdSpots(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateAdSpotsTest2() throws Exception {
    BatchCreateAdSpotsResponse expectedResponse =
        BatchCreateAdSpotsResponse.newBuilder().addAllAdSpots(new ArrayList<AdSpot>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateAdSpotRequest> requests = new ArrayList<>();

    BatchCreateAdSpotsResponse actualResponse = client.batchCreateAdSpots(parent, requests);
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
  public void batchCreateAdSpotsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateAdSpotRequest> requests = new ArrayList<>();
      client.batchCreateAdSpots(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAdSpotTest() throws Exception {
    AdSpot expectedResponse =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    mockService.addResponse(expectedResponse);

    AdSpot adSpot =
        AdSpot.newBuilder()
            .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
            .setCanonicalDisplayName("canonicalDisplayName2048456921")
            .setDisplayName("displayName1714148973")
            .setCustomSpot(true)
            .setFlexible(true)
            .setMaxDuration(Duration.newBuilder().build())
            .setMinAdDuration(Duration.newBuilder().build())
            .setMaxAdDuration(Duration.newBuilder().build())
            .setMaxAds(844430165)
            .setBackfillBlocked(true)
            .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
            .setInventorySharingBlocked(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AdSpot actualResponse = client.updateAdSpot(adSpot, updateMask);
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
  public void updateAdSpotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdSpot adSpot =
          AdSpot.newBuilder()
              .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
              .setCanonicalDisplayName("canonicalDisplayName2048456921")
              .setDisplayName("displayName1714148973")
              .setCustomSpot(true)
              .setFlexible(true)
              .setMaxDuration(Duration.newBuilder().build())
              .setMinAdDuration(Duration.newBuilder().build())
              .setMaxAdDuration(Duration.newBuilder().build())
              .setMaxAds(844430165)
              .setBackfillBlocked(true)
              .addAllAllowedLineItemTypes(new ArrayList<LineItemTypeEnum.LineItemType>())
              .setInventorySharingBlocked(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAdSpot(adSpot, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateAdSpotsTest() throws Exception {
    BatchUpdateAdSpotsResponse expectedResponse =
        BatchUpdateAdSpotsResponse.newBuilder().addAllAdSpots(new ArrayList<AdSpot>()).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateAdSpotRequest> requests = new ArrayList<>();

    BatchUpdateAdSpotsResponse actualResponse = client.batchUpdateAdSpots(parent, requests);
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
  public void batchUpdateAdSpotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateAdSpotRequest> requests = new ArrayList<>();
      client.batchUpdateAdSpots(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateAdSpotsTest2() throws Exception {
    BatchUpdateAdSpotsResponse expectedResponse =
        BatchUpdateAdSpotsResponse.newBuilder().addAllAdSpots(new ArrayList<AdSpot>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateAdSpotRequest> requests = new ArrayList<>();

    BatchUpdateAdSpotsResponse actualResponse = client.batchUpdateAdSpots(parent, requests);
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
  public void batchUpdateAdSpotsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateAdSpotRequest> requests = new ArrayList<>();
      client.batchUpdateAdSpots(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
