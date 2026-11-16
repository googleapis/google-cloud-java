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

import static com.google.ads.admanager.v1.ForecastAdjustmentServiceClient.ListForecastAdjustmentsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonForecastAdjustmentServiceStub;
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
public class ForecastAdjustmentServiceClientTest {
  private static MockHttpService mockService;
  private static ForecastAdjustmentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonForecastAdjustmentServiceStub.getMethodDescriptors(),
            ForecastAdjustmentServiceSettings.getDefaultEndpoint());
    ForecastAdjustmentServiceSettings settings =
        ForecastAdjustmentServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ForecastAdjustmentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ForecastAdjustmentServiceClient.create(settings);
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
  public void getForecastAdjustmentTest() throws Exception {
    ForecastAdjustment expectedResponse =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    ForecastAdjustmentName name =
        ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]");

    ForecastAdjustment actualResponse = client.getForecastAdjustment(name);
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
  public void getForecastAdjustmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ForecastAdjustmentName name =
          ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]");
      client.getForecastAdjustment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getForecastAdjustmentTest2() throws Exception {
    ForecastAdjustment expectedResponse =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-8110/forecastAdjustments/forecastAdjustment-8110";

    ForecastAdjustment actualResponse = client.getForecastAdjustment(name);
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
  public void getForecastAdjustmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-8110/forecastAdjustments/forecastAdjustment-8110";
      client.getForecastAdjustment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listForecastAdjustmentsTest() throws Exception {
    ForecastAdjustment responsesElement = ForecastAdjustment.newBuilder().build();
    ListForecastAdjustmentsResponse expectedResponse =
        ListForecastAdjustmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllForecastAdjustments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListForecastAdjustmentsPagedResponse pagedListResponse = client.listForecastAdjustments(parent);

    List<ForecastAdjustment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getForecastAdjustmentsList().get(0), resources.get(0));

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
  public void listForecastAdjustmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listForecastAdjustments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listForecastAdjustmentsTest2() throws Exception {
    ForecastAdjustment responsesElement = ForecastAdjustment.newBuilder().build();
    ListForecastAdjustmentsResponse expectedResponse =
        ListForecastAdjustmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllForecastAdjustments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListForecastAdjustmentsPagedResponse pagedListResponse = client.listForecastAdjustments(parent);

    List<ForecastAdjustment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getForecastAdjustmentsList().get(0), resources.get(0));

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
  public void listForecastAdjustmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listForecastAdjustments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createForecastAdjustmentTest() throws Exception {
    ForecastAdjustment expectedResponse =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();

    ForecastAdjustment actualResponse = client.createForecastAdjustment(parent, forecastAdjustment);
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
  public void createForecastAdjustmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
      client.createForecastAdjustment(parent, forecastAdjustment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createForecastAdjustmentTest2() throws Exception {
    ForecastAdjustment expectedResponse =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();

    ForecastAdjustment actualResponse = client.createForecastAdjustment(parent, forecastAdjustment);
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
  public void createForecastAdjustmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
      client.createForecastAdjustment(parent, forecastAdjustment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateForecastAdjustmentsTest() throws Exception {
    BatchCreateForecastAdjustmentsResponse expectedResponse =
        BatchCreateForecastAdjustmentsResponse.newBuilder()
            .addAllForecastAdjustments(new ArrayList<ForecastAdjustment>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();

    BatchCreateForecastAdjustmentsResponse actualResponse =
        client.batchCreateForecastAdjustments(parent, requests);
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
  public void batchCreateForecastAdjustmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();
      client.batchCreateForecastAdjustments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateForecastAdjustmentsTest2() throws Exception {
    BatchCreateForecastAdjustmentsResponse expectedResponse =
        BatchCreateForecastAdjustmentsResponse.newBuilder()
            .addAllForecastAdjustments(new ArrayList<ForecastAdjustment>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();

    BatchCreateForecastAdjustmentsResponse actualResponse =
        client.batchCreateForecastAdjustments(parent, requests);
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
  public void batchCreateForecastAdjustmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();
      client.batchCreateForecastAdjustments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateForecastAdjustmentsTest() throws Exception {
    BatchActivateForecastAdjustmentsResponse expectedResponse =
        BatchActivateForecastAdjustmentsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateForecastAdjustmentsResponse actualResponse =
        client.batchActivateForecastAdjustments(parent, names);
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
  public void batchActivateForecastAdjustmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateForecastAdjustments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateForecastAdjustmentsTest2() throws Exception {
    BatchActivateForecastAdjustmentsResponse expectedResponse =
        BatchActivateForecastAdjustmentsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateForecastAdjustmentsResponse actualResponse =
        client.batchActivateForecastAdjustments(parent, names);
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
  public void batchActivateForecastAdjustmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateForecastAdjustments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateForecastAdjustmentsTest() throws Exception {
    BatchDeactivateForecastAdjustmentsResponse expectedResponse =
        BatchDeactivateForecastAdjustmentsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDeactivateForecastAdjustmentsResponse actualResponse =
        client.batchDeactivateForecastAdjustments(parent, names);
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
  public void batchDeactivateForecastAdjustmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeactivateForecastAdjustments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateForecastAdjustmentsTest2() throws Exception {
    BatchDeactivateForecastAdjustmentsResponse expectedResponse =
        BatchDeactivateForecastAdjustmentsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDeactivateForecastAdjustmentsResponse actualResponse =
        client.batchDeactivateForecastAdjustments(parent, names);
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
  public void batchDeactivateForecastAdjustmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeactivateForecastAdjustments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateForecastAdjustmentTest() throws Exception {
    ForecastAdjustment expectedResponse =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    ForecastAdjustment forecastAdjustment =
        ForecastAdjustment.newBuilder()
            .setName(
                ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
            .setTrafficForecastSegment(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDateRange(DateRange.newBuilder().build())
            .setAllowAdjustingForecastAboveRecommendedLimit(true)
            .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ForecastAdjustment actualResponse =
        client.updateForecastAdjustment(forecastAdjustment, updateMask);
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
  public void updateForecastAdjustmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ForecastAdjustment forecastAdjustment =
          ForecastAdjustment.newBuilder()
              .setName(
                  ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
              .setTrafficForecastSegment(
                  TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDateRange(DateRange.newBuilder().build())
              .setAllowAdjustingForecastAboveRecommendedLimit(true)
              .addAllCalculatedDailyAdOpportunityCounts(new ArrayList<Long>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateForecastAdjustment(forecastAdjustment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateForecastAdjustmentsTest() throws Exception {
    BatchUpdateForecastAdjustmentsResponse expectedResponse =
        BatchUpdateForecastAdjustmentsResponse.newBuilder()
            .addAllForecastAdjustments(new ArrayList<ForecastAdjustment>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();

    BatchUpdateForecastAdjustmentsResponse actualResponse =
        client.batchUpdateForecastAdjustments(parent, requests);
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
  public void batchUpdateForecastAdjustmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();
      client.batchUpdateForecastAdjustments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateForecastAdjustmentsTest2() throws Exception {
    BatchUpdateForecastAdjustmentsResponse expectedResponse =
        BatchUpdateForecastAdjustmentsResponse.newBuilder()
            .addAllForecastAdjustments(new ArrayList<ForecastAdjustment>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();

    BatchUpdateForecastAdjustmentsResponse actualResponse =
        client.batchUpdateForecastAdjustments(parent, requests);
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
  public void batchUpdateForecastAdjustmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();
      client.batchUpdateForecastAdjustments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateDailyAdOpportunityCountsTest() throws Exception {
    CalculateDailyAdOpportunityCountsResponse expectedResponse =
        CalculateDailyAdOpportunityCountsResponse.newBuilder()
            .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();

    CalculateDailyAdOpportunityCountsResponse actualResponse =
        client.calculateDailyAdOpportunityCounts(parent, forecastAdjustment);
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
  public void calculateDailyAdOpportunityCountsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
      client.calculateDailyAdOpportunityCounts(parent, forecastAdjustment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateDailyAdOpportunityCountsTest2() throws Exception {
    CalculateDailyAdOpportunityCountsResponse expectedResponse =
        CalculateDailyAdOpportunityCountsResponse.newBuilder()
            .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();

    CalculateDailyAdOpportunityCountsResponse actualResponse =
        client.calculateDailyAdOpportunityCounts(parent, forecastAdjustment);
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
  public void calculateDailyAdOpportunityCountsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
      client.calculateDailyAdOpportunityCounts(parent, forecastAdjustment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
