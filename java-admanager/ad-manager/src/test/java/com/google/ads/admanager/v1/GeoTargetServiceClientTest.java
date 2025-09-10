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

import static com.google.ads.admanager.v1.GeoTargetServiceClient.ListGeoTargetsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonGeoTargetServiceStub;
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
public class GeoTargetServiceClientTest {
  private static MockHttpService mockService;
  private static GeoTargetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGeoTargetServiceStub.getMethodDescriptors(),
            GeoTargetServiceSettings.getDefaultEndpoint());
    GeoTargetServiceSettings settings =
        GeoTargetServiceSettings.newBuilder()
            .setTransportChannelProvider(
                GeoTargetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeoTargetServiceClient.create(settings);
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
  public void getGeoTargetTest() throws Exception {
    GeoTarget expectedResponse =
        GeoTarget.newBuilder()
            .setName(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
            .setDisplayName("displayName1714148973")
            .setCanonicalParent(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
            .addAllParentNames(new ArrayList<String>())
            .setRegionCode("regionCode-1991004415")
            .setType("type3575610")
            .setTargetable(true)
            .build();
    mockService.addResponse(expectedResponse);

    GeoTargetName name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]");

    GeoTarget actualResponse = client.getGeoTarget(name);
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
  public void getGeoTargetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeoTargetName name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]");
      client.getGeoTarget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeoTargetTest2() throws Exception {
    GeoTarget expectedResponse =
        GeoTarget.newBuilder()
            .setName(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
            .setDisplayName("displayName1714148973")
            .setCanonicalParent(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
            .addAllParentNames(new ArrayList<String>())
            .setRegionCode("regionCode-1991004415")
            .setType("type3575610")
            .setTargetable(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-9312/geoTargets/geoTarget-9312";

    GeoTarget actualResponse = client.getGeoTarget(name);
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
  public void getGeoTargetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-9312/geoTargets/geoTarget-9312";
      client.getGeoTarget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeoTargetsTest() throws Exception {
    GeoTarget responsesElement = GeoTarget.newBuilder().build();
    ListGeoTargetsResponse expectedResponse =
        ListGeoTargetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeoTargets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListGeoTargetsPagedResponse pagedListResponse = client.listGeoTargets(parent);

    List<GeoTarget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeoTargetsList().get(0), resources.get(0));

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
  public void listGeoTargetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listGeoTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeoTargetsTest2() throws Exception {
    GeoTarget responsesElement = GeoTarget.newBuilder().build();
    ListGeoTargetsResponse expectedResponse =
        ListGeoTargetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeoTargets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListGeoTargetsPagedResponse pagedListResponse = client.listGeoTargets(parent);

    List<GeoTarget> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeoTargetsList().get(0), resources.get(0));

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
  public void listGeoTargetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listGeoTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
