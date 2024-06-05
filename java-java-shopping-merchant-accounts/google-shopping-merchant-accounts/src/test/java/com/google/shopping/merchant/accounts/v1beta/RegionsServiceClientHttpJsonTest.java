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

import static com.google.shopping.merchant.accounts.v1beta.RegionsServiceClient.ListRegionsPagedResponse;

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
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonRegionsServiceStub;
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
public class RegionsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RegionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRegionsServiceStub.getMethodDescriptors(),
            RegionsServiceSettings.getDefaultEndpoint());
    RegionsServiceSettings settings =
        RegionsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RegionsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionsServiceClient.create(settings);
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
  public void getRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");

    Region actualResponse = client.getRegion(name);
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
  public void getRegionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
      client.getRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegionTest2() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8281/regions/region-8281";

    Region actualResponse = client.getRegion(name);
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
  public void getRegionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8281/regions/region-8281";
      client.getRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    Region region = Region.newBuilder().build();
    String regionId = "regionId-690339025";

    Region actualResponse = client.createRegion(parent, region, regionId);
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
  public void createRegionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      Region region = Region.newBuilder().build();
      String regionId = "regionId-690339025";
      client.createRegion(parent, region, regionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegionTest2() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    Region region = Region.newBuilder().build();
    String regionId = "regionId-690339025";

    Region actualResponse = client.createRegion(parent, region, regionId);
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
  public void createRegionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      Region region = Region.newBuilder().build();
      String regionId = "regionId-690339025";
      client.createRegion(parent, region, regionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Region region =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Region actualResponse = client.updateRegion(region, updateMask);
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
  public void updateRegionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Region region =
          Region.newBuilder()
              .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
              .setDisplayName("displayName1714148973")
              .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
              .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
              .setRegionalInventoryEligible(BoolValue.newBuilder().build())
              .setShippingEligible(BoolValue.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRegion(region, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");

    client.deleteRegion(name);

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
  public void deleteRegionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
      client.deleteRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8281/regions/region-8281";

    client.deleteRegion(name);

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
  public void deleteRegionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8281/regions/region-8281";
      client.deleteRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegionsTest() throws Exception {
    Region responsesElement = Region.newBuilder().build();
    ListRegionsResponse expectedResponse =
        ListRegionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListRegionsPagedResponse pagedListResponse = client.listRegions(parent);

    List<Region> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionsList().get(0), resources.get(0));

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
  public void listRegionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listRegions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegionsTest2() throws Exception {
    Region responsesElement = Region.newBuilder().build();
    ListRegionsResponse expectedResponse =
        ListRegionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListRegionsPagedResponse pagedListResponse = client.listRegions(parent);

    List<Region> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionsList().get(0), resources.get(0));

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
  public void listRegionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listRegions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
