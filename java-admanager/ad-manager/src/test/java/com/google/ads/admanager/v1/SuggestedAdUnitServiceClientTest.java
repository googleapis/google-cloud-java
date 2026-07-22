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

import static com.google.ads.admanager.v1.SuggestedAdUnitServiceClient.ListSuggestedAdUnitsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonSuggestedAdUnitServiceStub;
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
public class SuggestedAdUnitServiceClientTest {
  private static MockHttpService mockService;
  private static SuggestedAdUnitServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSuggestedAdUnitServiceStub.getMethodDescriptors(),
            SuggestedAdUnitServiceSettings.getDefaultEndpoint());
    SuggestedAdUnitServiceSettings settings =
        SuggestedAdUnitServiceSettings.newBuilder()
            .setTransportChannelProvider(
                SuggestedAdUnitServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SuggestedAdUnitServiceClient.create(settings);
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
  public void getSuggestedAdUnitTest() throws Exception {
    SuggestedAdUnit expectedResponse =
        SuggestedAdUnit.newBuilder()
            .setName(SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]").toString())
            .setWeeklyRequestCount(-272753631)
            .addAllNewCodePath(new ArrayList<String>())
            .addAllExistingCodePath(new ArrayList<AdUnitParent>())
            .addAllAdUnitSizes(new ArrayList<AdUnitSize>())
            .build();
    mockService.addResponse(expectedResponse);

    SuggestedAdUnitName name = SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]");

    SuggestedAdUnit actualResponse = client.getSuggestedAdUnit(name);
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
  public void getSuggestedAdUnitExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SuggestedAdUnitName name = SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]");
      client.getSuggestedAdUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSuggestedAdUnitTest2() throws Exception {
    SuggestedAdUnit expectedResponse =
        SuggestedAdUnit.newBuilder()
            .setName(SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]").toString())
            .setWeeklyRequestCount(-272753631)
            .addAllNewCodePath(new ArrayList<String>())
            .addAllExistingCodePath(new ArrayList<AdUnitParent>())
            .addAllAdUnitSizes(new ArrayList<AdUnitSize>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-2760/suggestedAdUnits/suggestedAdUnit-2760";

    SuggestedAdUnit actualResponse = client.getSuggestedAdUnit(name);
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
  public void getSuggestedAdUnitExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-2760/suggestedAdUnits/suggestedAdUnit-2760";
      client.getSuggestedAdUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSuggestedAdUnitsTest() throws Exception {
    SuggestedAdUnit responsesElement = SuggestedAdUnit.newBuilder().build();
    ListSuggestedAdUnitsResponse expectedResponse =
        ListSuggestedAdUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSuggestedAdUnits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListSuggestedAdUnitsPagedResponse pagedListResponse = client.listSuggestedAdUnits(parent);

    List<SuggestedAdUnit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSuggestedAdUnitsList().get(0), resources.get(0));

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
  public void listSuggestedAdUnitsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listSuggestedAdUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSuggestedAdUnitsTest2() throws Exception {
    SuggestedAdUnit responsesElement = SuggestedAdUnit.newBuilder().build();
    ListSuggestedAdUnitsResponse expectedResponse =
        ListSuggestedAdUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSuggestedAdUnits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListSuggestedAdUnitsPagedResponse pagedListResponse = client.listSuggestedAdUnits(parent);

    List<SuggestedAdUnit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSuggestedAdUnitsList().get(0), resources.get(0));

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
  public void listSuggestedAdUnitsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listSuggestedAdUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchApproveSuggestedAdUnitsTest() throws Exception {
    BatchApproveSuggestedAdUnitsResponse expectedResponse =
        BatchApproveSuggestedAdUnitsResponse.newBuilder()
            .addAllCreatedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchApproveSuggestedAdUnitsResponse actualResponse =
        client.batchApproveSuggestedAdUnits(parent, names);
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
  public void batchApproveSuggestedAdUnitsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchApproveSuggestedAdUnits(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchApproveSuggestedAdUnitsTest2() throws Exception {
    BatchApproveSuggestedAdUnitsResponse expectedResponse =
        BatchApproveSuggestedAdUnitsResponse.newBuilder()
            .addAllCreatedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchApproveSuggestedAdUnitsResponse actualResponse =
        client.batchApproveSuggestedAdUnits(parent, names);
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
  public void batchApproveSuggestedAdUnitsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchApproveSuggestedAdUnits(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
