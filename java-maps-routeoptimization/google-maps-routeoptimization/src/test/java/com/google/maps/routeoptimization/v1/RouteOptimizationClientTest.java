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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RouteOptimizationClientTest {
  private static MockRouteOptimization mockRouteOptimization;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RouteOptimizationClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRouteOptimization = new MockRouteOptimization();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRouteOptimization));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    RouteOptimizationSettings settings =
        RouteOptimizationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RouteOptimizationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockRouteOptimization.addResponse(expectedResponse);

    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent("parent-995424086")
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

    List<AbstractMessage> actualRequests = mockRouteOptimization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OptimizeToursRequest actualRequest = ((OptimizeToursRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getTimeout(), actualRequest.getTimeout());
    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getSolvingMode(), actualRequest.getSolvingMode());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(
        request.getInjectedFirstSolutionRoutesList(),
        actualRequest.getInjectedFirstSolutionRoutesList());
    Assert.assertEquals(
        request.getInjectedSolutionConstraint(), actualRequest.getInjectedSolutionConstraint());
    Assert.assertEquals(
        request.getRefreshDetailsRoutesList(), actualRequest.getRefreshDetailsRoutesList());
    Assert.assertEquals(
        request.getInterpretInjectedSolutionsUsingLabels(),
        actualRequest.getInterpretInjectedSolutionsUsingLabels());
    Assert.assertEquals(request.getConsiderRoadTraffic(), actualRequest.getConsiderRoadTraffic());
    Assert.assertEquals(request.getPopulatePolylines(), actualRequest.getPopulatePolylines());
    Assert.assertEquals(
        request.getPopulateTransitionPolylines(), actualRequest.getPopulateTransitionPolylines());
    Assert.assertEquals(
        request.getAllowLargeDeadlineDespiteInterruptionRisk(),
        actualRequest.getAllowLargeDeadlineDespiteInterruptionRisk());
    Assert.assertEquals(request.getUseGeodesicDistances(), actualRequest.getUseGeodesicDistances());
    Assert.assertEquals(
        request.getGeodesicMetersPerSecond(), actualRequest.getGeodesicMetersPerSecond(), 0.0001);
    Assert.assertEquals(request.getMaxValidationErrors(), actualRequest.getMaxValidationErrors());
    Assert.assertEquals(request.getLabel(), actualRequest.getLabel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void optimizeToursExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRouteOptimization.addException(exception);

    try {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockRouteOptimization.addResponse(resultOperation);

    BatchOptimizeToursRequest request =
        BatchOptimizeToursRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
            .build();

    BatchOptimizeToursResponse actualResponse = client.batchOptimizeToursAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRouteOptimization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchOptimizeToursRequest actualRequest = ((BatchOptimizeToursRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getModelConfigsList(), actualRequest.getModelConfigsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchOptimizeToursExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRouteOptimization.addException(exception);

    try {
      BatchOptimizeToursRequest request =
          BatchOptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
              .build();
      client.batchOptimizeToursAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockRouteOptimization.addResponse(resultOperation);

    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent("parent-995424086")
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

    List<AbstractMessage> actualRequests = mockRouteOptimization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OptimizeToursRequest actualRequest = ((OptimizeToursRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getTimeout(), actualRequest.getTimeout());
    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getSolvingMode(), actualRequest.getSolvingMode());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(
        request.getInjectedFirstSolutionRoutesList(),
        actualRequest.getInjectedFirstSolutionRoutesList());
    Assert.assertEquals(
        request.getInjectedSolutionConstraint(), actualRequest.getInjectedSolutionConstraint());
    Assert.assertEquals(
        request.getRefreshDetailsRoutesList(), actualRequest.getRefreshDetailsRoutesList());
    Assert.assertEquals(
        request.getInterpretInjectedSolutionsUsingLabels(),
        actualRequest.getInterpretInjectedSolutionsUsingLabels());
    Assert.assertEquals(request.getConsiderRoadTraffic(), actualRequest.getConsiderRoadTraffic());
    Assert.assertEquals(request.getPopulatePolylines(), actualRequest.getPopulatePolylines());
    Assert.assertEquals(
        request.getPopulateTransitionPolylines(), actualRequest.getPopulateTransitionPolylines());
    Assert.assertEquals(
        request.getAllowLargeDeadlineDespiteInterruptionRisk(),
        actualRequest.getAllowLargeDeadlineDespiteInterruptionRisk());
    Assert.assertEquals(request.getUseGeodesicDistances(), actualRequest.getUseGeodesicDistances());
    Assert.assertEquals(
        request.getGeodesicMetersPerSecond(), actualRequest.getGeodesicMetersPerSecond(), 0.0001);
    Assert.assertEquals(request.getMaxValidationErrors(), actualRequest.getMaxValidationErrors());
    Assert.assertEquals(request.getLabel(), actualRequest.getLabel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void optimizeToursLongRunningExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRouteOptimization.addException(exception);

    try {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockRouteOptimization.addResponse(resultOperation);

    OptimizeToursUriRequest request =
        OptimizeToursUriRequest.newBuilder()
            .setParent("parent-995424086")
            .setInput(Uri.newBuilder().build())
            .setOutput(Uri.newBuilder().build())
            .build();

    OptimizeToursUriResponse actualResponse = client.optimizeToursUriAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRouteOptimization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OptimizeToursUriRequest actualRequest = ((OptimizeToursUriRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInput(), actualRequest.getInput());
    Assert.assertEquals(request.getOutput(), actualRequest.getOutput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void optimizeToursUriExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRouteOptimization.addException(exception);

    try {
      OptimizeToursUriRequest request =
          OptimizeToursUriRequest.newBuilder()
              .setParent("parent-995424086")
              .setInput(Uri.newBuilder().build())
              .setOutput(Uri.newBuilder().build())
              .build();
      client.optimizeToursUriAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
