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

package com.google.maps.routeoptimization.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.longrunning.Operation;
import com.google.maps.routeoptimization.v1.stub.HttpJsonRouteOptimizationStub;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RouteOptimizationClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RouteOptimizationClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRouteOptimizationStub.getMethodDescriptors(),
            RouteOptimizationSettings.getDefaultEndpoint());
    RouteOptimizationSettings settings =
        RouteOptimizationSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RouteOptimizationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RouteOptimizationClient.create(settings);
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
  public void optimizeToursTest() throws Exception {
    OptimizeToursResponse expectedResponse =
        OptimizeToursResponse.newBuilder()
            .addAllRoutes(new ArrayList<ShipmentRoute>())
            .setRequestLabel("requestLabel1285152165")
            .addAllSkippedShipments(new ArrayList<SkippedShipment>())
            .addAllValidationErrors(new ArrayList<OptimizeToursValidationError>())
            .setProcessedRequest(OptimizeToursRequest.newBuilder().build())
            .setMetrics(OptimizeToursResponse.Metrics.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setTimeout(Duration.newBuilder().build())
            .setModel(ShipmentModel.newBuilder().build())
            .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
            .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
            .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
            .setInterpretInjectedSolutionsUsingLabels(true)
            .setConsiderRoadTraffic(true)
            .setPopulatePolylines(true)
            .setPopulateTransitionPolylines(true)
            .setAllowLargeDeadlineDespiteInterruptionRisk(true)
            .setUseGeodesicDistances(true)
            .setGeodesicMetersPerSecond(-2129658905)
            .setMaxValidationErrors(-1367418922)
            .setLabel("label102727412")
            .build();

    OptimizeToursResponse actualResponse = client.optimizeTours(request);
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
  public void optimizeToursExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setTimeout(Duration.newBuilder().build())
              .setModel(ShipmentModel.newBuilder().build())
              .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
              .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
              .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
              .setInterpretInjectedSolutionsUsingLabels(true)
              .setConsiderRoadTraffic(true)
              .setPopulatePolylines(true)
              .setPopulateTransitionPolylines(true)
              .setAllowLargeDeadlineDespiteInterruptionRisk(true)
              .setUseGeodesicDistances(true)
              .setGeodesicMetersPerSecond(-2129658905)
              .setMaxValidationErrors(-1367418922)
              .setLabel("label102727412")
              .build();
      client.optimizeTours(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchOptimizeToursTest() throws Exception {
    BatchOptimizeToursResponse expectedResponse = BatchOptimizeToursResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchOptimizeToursTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BatchOptimizeToursRequest request =
        BatchOptimizeToursRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
            .build();

    BatchOptimizeToursResponse actualResponse = client.batchOptimizeToursAsync(request).get();
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
  public void batchOptimizeToursExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchOptimizeToursRequest request =
          BatchOptimizeToursRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
              .build();
      client.batchOptimizeToursAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void optimizeToursLongRunningTest() throws Exception {
    OptimizeToursResponse expectedResponse =
        OptimizeToursResponse.newBuilder()
            .addAllRoutes(new ArrayList<ShipmentRoute>())
            .setRequestLabel("requestLabel1285152165")
            .addAllSkippedShipments(new ArrayList<SkippedShipment>())
            .addAllValidationErrors(new ArrayList<OptimizeToursValidationError>())
            .setProcessedRequest(OptimizeToursRequest.newBuilder().build())
            .setMetrics(OptimizeToursResponse.Metrics.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("optimizeToursLongRunningTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setTimeout(Duration.newBuilder().build())
            .setModel(ShipmentModel.newBuilder().build())
            .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
            .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
            .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
            .setInterpretInjectedSolutionsUsingLabels(true)
            .setConsiderRoadTraffic(true)
            .setPopulatePolylines(true)
            .setPopulateTransitionPolylines(true)
            .setAllowLargeDeadlineDespiteInterruptionRisk(true)
            .setUseGeodesicDistances(true)
            .setGeodesicMetersPerSecond(-2129658905)
            .setMaxValidationErrors(-1367418922)
            .setLabel("label102727412")
            .build();

    OptimizeToursResponse actualResponse = client.optimizeToursLongRunningAsync(request).get();
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
  public void optimizeToursLongRunningExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setTimeout(Duration.newBuilder().build())
              .setModel(ShipmentModel.newBuilder().build())
              .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
              .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
              .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
              .setInterpretInjectedSolutionsUsingLabels(true)
              .setConsiderRoadTraffic(true)
              .setPopulatePolylines(true)
              .setPopulateTransitionPolylines(true)
              .setAllowLargeDeadlineDespiteInterruptionRisk(true)
              .setUseGeodesicDistances(true)
              .setGeodesicMetersPerSecond(-2129658905)
              .setMaxValidationErrors(-1367418922)
              .setLabel("label102727412")
              .build();
      client.optimizeToursLongRunningAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void optimizeToursUriTest() throws Exception {
    OptimizeToursUriResponse expectedResponse =
        OptimizeToursUriResponse.newBuilder().setOutput(Uri.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("optimizeToursUriTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OptimizeToursUriRequest request =
        OptimizeToursUriRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setInput(Uri.newBuilder().build())
            .setOutput(Uri.newBuilder().build())
            .build();

    OptimizeToursUriResponse actualResponse = client.optimizeToursUriAsync(request).get();
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
  public void optimizeToursUriExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OptimizeToursUriRequest request =
          OptimizeToursUriRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setInput(Uri.newBuilder().build())
              .setOutput(Uri.newBuilder().build())
              .build();
      client.optimizeToursUriAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
