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

import static com.google.ads.admanager.v1.TrafficForecastSegmentServiceClient.ListTrafficForecastSegmentsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonTrafficForecastSegmentServiceStub;
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
public class TrafficForecastSegmentServiceClientTest {
  private static MockHttpService mockService;
  private static TrafficForecastSegmentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTrafficForecastSegmentServiceStub.getMethodDescriptors(),
            TrafficForecastSegmentServiceSettings.getDefaultEndpoint());
    TrafficForecastSegmentServiceSettings settings =
        TrafficForecastSegmentServiceSettings.newBuilder()
            .setTransportChannelProvider(
                TrafficForecastSegmentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TrafficForecastSegmentServiceClient.create(settings);
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
  public void getTrafficForecastSegmentTest() throws Exception {
    TrafficForecastSegment expectedResponse =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TrafficForecastSegmentName name =
        TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]");

    TrafficForecastSegment actualResponse = client.getTrafficForecastSegment(name);
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
  public void getTrafficForecastSegmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TrafficForecastSegmentName name =
          TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]");
      client.getTrafficForecastSegment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTrafficForecastSegmentTest2() throws Exception {
    TrafficForecastSegment expectedResponse =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-431/trafficForecastSegments/trafficForecastSegment-431";

    TrafficForecastSegment actualResponse = client.getTrafficForecastSegment(name);
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
  public void getTrafficForecastSegmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-431/trafficForecastSegments/trafficForecastSegment-431";
      client.getTrafficForecastSegment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrafficForecastSegmentsTest() throws Exception {
    TrafficForecastSegment responsesElement = TrafficForecastSegment.newBuilder().build();
    ListTrafficForecastSegmentsResponse expectedResponse =
        ListTrafficForecastSegmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrafficForecastSegments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListTrafficForecastSegmentsPagedResponse pagedListResponse =
        client.listTrafficForecastSegments(parent);

    List<TrafficForecastSegment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrafficForecastSegmentsList().get(0), resources.get(0));

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
  public void listTrafficForecastSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listTrafficForecastSegments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrafficForecastSegmentsTest2() throws Exception {
    TrafficForecastSegment responsesElement = TrafficForecastSegment.newBuilder().build();
    ListTrafficForecastSegmentsResponse expectedResponse =
        ListTrafficForecastSegmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrafficForecastSegments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListTrafficForecastSegmentsPagedResponse pagedListResponse =
        client.listTrafficForecastSegments(parent);

    List<TrafficForecastSegment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrafficForecastSegmentsList().get(0), resources.get(0));

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
  public void listTrafficForecastSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listTrafficForecastSegments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTrafficForecastSegmentTest() throws Exception {
    TrafficForecastSegment expectedResponse =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();

    TrafficForecastSegment actualResponse =
        client.createTrafficForecastSegment(parent, trafficForecastSegment);
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
  public void createTrafficForecastSegmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();
      client.createTrafficForecastSegment(parent, trafficForecastSegment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTrafficForecastSegmentTest2() throws Exception {
    TrafficForecastSegment expectedResponse =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();

    TrafficForecastSegment actualResponse =
        client.createTrafficForecastSegment(parent, trafficForecastSegment);
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
  public void createTrafficForecastSegmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();
      client.createTrafficForecastSegment(parent, trafficForecastSegment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTrafficForecastSegmentsTest() throws Exception {
    BatchCreateTrafficForecastSegmentsResponse expectedResponse =
        BatchCreateTrafficForecastSegmentsResponse.newBuilder()
            .addAllTrafficForecastSegments(new ArrayList<TrafficForecastSegment>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();

    BatchCreateTrafficForecastSegmentsResponse actualResponse =
        client.batchCreateTrafficForecastSegments(parent, requests);
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
  public void batchCreateTrafficForecastSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();
      client.batchCreateTrafficForecastSegments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTrafficForecastSegmentsTest2() throws Exception {
    BatchCreateTrafficForecastSegmentsResponse expectedResponse =
        BatchCreateTrafficForecastSegmentsResponse.newBuilder()
            .addAllTrafficForecastSegments(new ArrayList<TrafficForecastSegment>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();

    BatchCreateTrafficForecastSegmentsResponse actualResponse =
        client.batchCreateTrafficForecastSegments(parent, requests);
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
  public void batchCreateTrafficForecastSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();
      client.batchCreateTrafficForecastSegments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTrafficForecastSegmentTest() throws Exception {
    TrafficForecastSegment expectedResponse =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TrafficForecastSegment trafficForecastSegment =
        TrafficForecastSegment.newBuilder()
            .setName(
                TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .setForecastAdjustmentCount(-534214271)
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllTargetedAdUnits(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TrafficForecastSegment actualResponse =
        client.updateTrafficForecastSegment(trafficForecastSegment, updateMask);
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
  public void updateTrafficForecastSegmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TrafficForecastSegment trafficForecastSegment =
          TrafficForecastSegment.newBuilder()
              .setName(
                  TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setTargeting(Targeting.newBuilder().build())
              .setForecastAdjustmentCount(-534214271)
              .setCreateTime(Timestamp.newBuilder().build())
              .addAllTargetedAdUnits(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTrafficForecastSegment(trafficForecastSegment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateTrafficForecastSegmentsTest() throws Exception {
    BatchUpdateTrafficForecastSegmentsResponse expectedResponse =
        BatchUpdateTrafficForecastSegmentsResponse.newBuilder()
            .addAllTrafficForecastSegments(new ArrayList<TrafficForecastSegment>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();

    BatchUpdateTrafficForecastSegmentsResponse actualResponse =
        client.batchUpdateTrafficForecastSegments(parent, requests);
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
  public void batchUpdateTrafficForecastSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();
      client.batchUpdateTrafficForecastSegments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateTrafficForecastSegmentsTest2() throws Exception {
    BatchUpdateTrafficForecastSegmentsResponse expectedResponse =
        BatchUpdateTrafficForecastSegmentsResponse.newBuilder()
            .addAllTrafficForecastSegments(new ArrayList<TrafficForecastSegment>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();

    BatchUpdateTrafficForecastSegmentsResponse actualResponse =
        client.batchUpdateTrafficForecastSegments(parent, requests);
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
  public void batchUpdateTrafficForecastSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();
      client.batchUpdateTrafficForecastSegments(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
