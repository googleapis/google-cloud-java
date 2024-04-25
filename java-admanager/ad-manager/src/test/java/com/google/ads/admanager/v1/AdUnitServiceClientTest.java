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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonAdUnitServiceStub;
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
import com.google.protobuf.Timestamp;
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
public class AdUnitServiceClientTest {
  private static MockHttpService mockService;
  private static AdUnitServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAdUnitServiceStub.getMethodDescriptors(),
            AdUnitServiceSettings.getDefaultEndpoint());
    AdUnitServiceSettings settings =
        AdUnitServiceSettings.newBuilder()
            .setTransportChannelProvider(
                AdUnitServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdUnitServiceClient.create(settings);
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
  public void getAdUnitTest() throws Exception {
    AdUnit expectedResponse =
        AdUnit.newBuilder()
            .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setAdUnitId(-167061094)
            .setParentAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .addAllParentPath(new ArrayList<AdUnitParent>())
            .setDisplayName("displayName1714148973")
            .setAdUnitCode("adUnitCode1827682004")
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllTeams(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setExplicitlyTargeted(true)
            .setHasChildren(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllAdUnitSizes(new ArrayList<AdUnitSize>())
            .setExternalSetTopBoxChannelId("externalSetTopBoxChannelId1711101009")
            .setRefreshDelay(Duration.newBuilder().build())
            .setCtvApplicationId(-1772918844)
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllAppliedLabelFrequencyCaps(new ArrayList<LabelFrequencyCap>())
            .addAllEffectiveLabelFrequencyCaps(new ArrayList<LabelFrequencyCap>())
            .setEffectiveAdsenseEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");

    AdUnit actualResponse = client.getAdUnit(name);
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
  public void getAdUnitExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
      client.getAdUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdUnitTest2() throws Exception {
    AdUnit expectedResponse =
        AdUnit.newBuilder()
            .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setAdUnitId(-167061094)
            .setParentAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .addAllParentPath(new ArrayList<AdUnitParent>())
            .setDisplayName("displayName1714148973")
            .setAdUnitCode("adUnitCode1827682004")
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllTeams(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setExplicitlyTargeted(true)
            .setHasChildren(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllAdUnitSizes(new ArrayList<AdUnitSize>())
            .setExternalSetTopBoxChannelId("externalSetTopBoxChannelId1711101009")
            .setRefreshDelay(Duration.newBuilder().build())
            .setCtvApplicationId(-1772918844)
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllAppliedLabelFrequencyCaps(new ArrayList<LabelFrequencyCap>())
            .addAllEffectiveLabelFrequencyCaps(new ArrayList<LabelFrequencyCap>())
            .setEffectiveAdsenseEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-1315/adUnits/adUnit-1315";

    AdUnit actualResponse = client.getAdUnit(name);
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
  public void getAdUnitExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-1315/adUnits/adUnit-1315";
      client.getAdUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdUnitsTest() throws Exception {
    AdUnit responsesElement = AdUnit.newBuilder().build();
    ListAdUnitsResponse expectedResponse =
        ListAdUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdUnits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListAdUnitsPagedResponse pagedListResponse = client.listAdUnits(parent);

    List<AdUnit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdUnitsList().get(0), resources.get(0));

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
  public void listAdUnitsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listAdUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdUnitsTest2() throws Exception {
    AdUnit responsesElement = AdUnit.newBuilder().build();
    ListAdUnitsResponse expectedResponse =
        ListAdUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdUnits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListAdUnitsPagedResponse pagedListResponse = client.listAdUnits(parent);

    List<AdUnit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdUnitsList().get(0), resources.get(0));

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
  public void listAdUnitsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listAdUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
