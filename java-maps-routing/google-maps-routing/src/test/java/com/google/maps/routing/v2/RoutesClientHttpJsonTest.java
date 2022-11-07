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

package com.google.maps.routing.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.maps.routing.v2.stub.HttpJsonRoutesStub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RoutesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RoutesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRoutesStub.getMethodDescriptors(), RoutesSettings.getDefaultEndpoint());
    RoutesSettings settings =
        RoutesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RoutesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RoutesClient.create(settings);
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
  public void computeRoutesTest() throws Exception {
    ComputeRoutesResponse expectedResponse =
        ComputeRoutesResponse.newBuilder()
            .addAllRoutes(new ArrayList<Route>())
            .setFallbackInfo(FallbackInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ComputeRoutesRequest request =
        ComputeRoutesRequest.newBuilder()
            .setOrigin(Waypoint.newBuilder().build())
            .setDestination(Waypoint.newBuilder().build())
            .addAllIntermediates(new ArrayList<Waypoint>())
            .setTravelMode(RouteTravelMode.forNumber(0))
            .setRoutingPreference(RoutingPreference.forNumber(0))
            .setPolylineQuality(PolylineQuality.forNumber(0))
            .setPolylineEncoding(PolylineEncoding.forNumber(0))
            .setDepartureTime(Timestamp.newBuilder().build())
            .setComputeAlternativeRoutes(true)
            .setRouteModifiers(RouteModifiers.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setUnits(Units.forNumber(0))
            .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
            .build();

    ComputeRoutesResponse actualResponse = client.computeRoutes(request);
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
  public void computeRoutesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComputeRoutesRequest request =
          ComputeRoutesRequest.newBuilder()
              .setOrigin(Waypoint.newBuilder().build())
              .setDestination(Waypoint.newBuilder().build())
              .addAllIntermediates(new ArrayList<Waypoint>())
              .setTravelMode(RouteTravelMode.forNumber(0))
              .setRoutingPreference(RoutingPreference.forNumber(0))
              .setPolylineQuality(PolylineQuality.forNumber(0))
              .setPolylineEncoding(PolylineEncoding.forNumber(0))
              .setDepartureTime(Timestamp.newBuilder().build())
              .setComputeAlternativeRoutes(true)
              .setRouteModifiers(RouteModifiers.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setUnits(Units.forNumber(0))
              .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
              .build();
      client.computeRoutes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeRouteMatrixTest() throws Exception {}

  @Test
  public void computeRouteMatrixExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }
}
