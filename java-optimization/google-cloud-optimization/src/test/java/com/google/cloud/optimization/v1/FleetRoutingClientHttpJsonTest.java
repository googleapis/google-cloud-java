/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.optimization.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.optimization.v1.stub.HttpJsonFleetRoutingStub;
import com.google.longrunning.Operation;
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
public class FleetRoutingClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FleetRoutingClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFleetRoutingStub.getMethodDescriptors(),
            FleetRoutingSettings.getDefaultEndpoint());
    FleetRoutingSettings settings =
        FleetRoutingSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FleetRoutingSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FleetRoutingClient.create(settings);
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
            .setMetrics(OptimizeToursResponse.Metrics.newBuilder().build())
            .setTotalCost(-705890328)
            .build();
    mockService.addResponse(expectedResponse);

    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setTimeout(Duration.newBuilder().build())
            .setModel(ShipmentModel.newBuilder().build())
            .setMaxValidationErrors(-1367418922)
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
            .setLabel("label102727412")
            .setPopulateTravelStepPolylines(true)
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
              .setMaxValidationErrors(-1367418922)
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
              .setLabel("label102727412")
              .setPopulateTravelStepPolylines(true)
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
}
