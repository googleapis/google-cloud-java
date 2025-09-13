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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiObservationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.apihub.v1.stub.HttpJsonApiHubDiscoveryStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ApiHubDiscoveryClientTest {
  private static MockHttpService mockService;
  private static ApiHubDiscoveryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonApiHubDiscoveryStub.getMethodDescriptors(),
            ApiHubDiscoverySettings.getDefaultEndpoint());
    ApiHubDiscoverySettings settings =
        ApiHubDiscoverySettings.newBuilder()
            .setTransportChannelProvider(
                ApiHubDiscoverySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiHubDiscoveryClient.create(settings);
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
  public void listDiscoveredApiObservationsTest() throws Exception {
    DiscoveredApiObservation responsesElement = DiscoveredApiObservation.newBuilder().build();
    ListDiscoveredApiObservationsResponse expectedResponse =
        ListDiscoveredApiObservationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredApiObservations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveredApiObservationsPagedResponse pagedListResponse =
        client.listDiscoveredApiObservations(parent);

    List<DiscoveredApiObservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDiscoveredApiObservationsList().get(0), resources.get(0));

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
  public void listDiscoveredApiObservationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveredApiObservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredApiObservationsTest2() throws Exception {
    DiscoveredApiObservation responsesElement = DiscoveredApiObservation.newBuilder().build();
    ListDiscoveredApiObservationsResponse expectedResponse =
        ListDiscoveredApiObservationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredApiObservations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDiscoveredApiObservationsPagedResponse pagedListResponse =
        client.listDiscoveredApiObservations(parent);

    List<DiscoveredApiObservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDiscoveredApiObservationsList().get(0), resources.get(0));

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
  public void listDiscoveredApiObservationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDiscoveredApiObservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredApiObservationTest() throws Exception {
    DiscoveredApiObservation expectedResponse =
        DiscoveredApiObservation.newBuilder()
            .setName(
                DiscoveredApiObservationName.of(
                        "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
                    .toString())
            .addAllServerIps(new ArrayList<String>())
            .setHostname("hostname-299803597")
            .setLastEventDetectedTime(Timestamp.newBuilder().build())
            .addAllSourceLocations(new ArrayList<String>())
            .setApiOperationCount(1601960978)
            .setOrigin("origin-1008619738")
            .addAllSourceTypes(new ArrayList<DiscoveredApiObservation.SourceType>())
            .setKnownOperationsCount(1870354552)
            .setUnknownOperationsCount(2105638481)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceMetadata(SourceMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredApiObservationName name =
        DiscoveredApiObservationName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");

    DiscoveredApiObservation actualResponse = client.getDiscoveredApiObservation(name);
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
  public void getDiscoveredApiObservationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredApiObservationName name =
          DiscoveredApiObservationName.of(
              "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
      client.getDiscoveredApiObservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredApiObservationTest2() throws Exception {
    DiscoveredApiObservation expectedResponse =
        DiscoveredApiObservation.newBuilder()
            .setName(
                DiscoveredApiObservationName.of(
                        "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
                    .toString())
            .addAllServerIps(new ArrayList<String>())
            .setHostname("hostname-299803597")
            .setLastEventDetectedTime(Timestamp.newBuilder().build())
            .addAllSourceLocations(new ArrayList<String>())
            .setApiOperationCount(1601960978)
            .setOrigin("origin-1008619738")
            .addAllSourceTypes(new ArrayList<DiscoveredApiObservation.SourceType>())
            .setKnownOperationsCount(1870354552)
            .setUnknownOperationsCount(2105638481)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceMetadata(SourceMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4863/locations/location-4863/discoveredApiObservations/discoveredApiObservation-4863";

    DiscoveredApiObservation actualResponse = client.getDiscoveredApiObservation(name);
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
  public void getDiscoveredApiObservationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4863/locations/location-4863/discoveredApiObservations/discoveredApiObservation-4863";
      client.getDiscoveredApiObservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredApiOperationsTest() throws Exception {
    DiscoveredApiOperation responsesElement = DiscoveredApiOperation.newBuilder().build();
    ListDiscoveredApiOperationsResponse expectedResponse =
        ListDiscoveredApiOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredApiOperations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredApiObservationName parent =
        DiscoveredApiObservationName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");

    ListDiscoveredApiOperationsPagedResponse pagedListResponse =
        client.listDiscoveredApiOperations(parent);

    List<DiscoveredApiOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredApiOperationsList().get(0), resources.get(0));

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
  public void listDiscoveredApiOperationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredApiObservationName parent =
          DiscoveredApiObservationName.of(
              "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
      client.listDiscoveredApiOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredApiOperationsTest2() throws Exception {
    DiscoveredApiOperation responsesElement = DiscoveredApiOperation.newBuilder().build();
    ListDiscoveredApiOperationsResponse expectedResponse =
        ListDiscoveredApiOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredApiOperations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-8302/locations/location-8302/discoveredApiObservations/discoveredApiObservation-8302";

    ListDiscoveredApiOperationsPagedResponse pagedListResponse =
        client.listDiscoveredApiOperations(parent);

    List<DiscoveredApiOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredApiOperationsList().get(0), resources.get(0));

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
  public void listDiscoveredApiOperationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8302/locations/location-8302/discoveredApiObservations/discoveredApiObservation-8302";
      client.listDiscoveredApiOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredApiOperationTest() throws Exception {
    DiscoveredApiOperation expectedResponse =
        DiscoveredApiOperation.newBuilder()
            .setName(
                DiscoveredApiOperationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[DISCOVERED_API_OBSERVATION]",
                        "[DISCOVERED_API_OPERATION]")
                    .toString())
            .setFirstSeenTime(Timestamp.newBuilder().build())
            .setLastSeenTime(Timestamp.newBuilder().build())
            .setCount(94851343)
            .addAllMatchResults(new ArrayList<DiscoveredApiOperation.MatchResult>())
            .setSourceMetadata(SourceMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredApiOperationName name =
        DiscoveredApiOperationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[DISCOVERED_API_OBSERVATION]",
            "[DISCOVERED_API_OPERATION]");

    DiscoveredApiOperation actualResponse = client.getDiscoveredApiOperation(name);
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
  public void getDiscoveredApiOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredApiOperationName name =
          DiscoveredApiOperationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[DISCOVERED_API_OBSERVATION]",
              "[DISCOVERED_API_OPERATION]");
      client.getDiscoveredApiOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredApiOperationTest2() throws Exception {
    DiscoveredApiOperation expectedResponse =
        DiscoveredApiOperation.newBuilder()
            .setName(
                DiscoveredApiOperationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[DISCOVERED_API_OBSERVATION]",
                        "[DISCOVERED_API_OPERATION]")
                    .toString())
            .setFirstSeenTime(Timestamp.newBuilder().build())
            .setLastSeenTime(Timestamp.newBuilder().build())
            .setCount(94851343)
            .addAllMatchResults(new ArrayList<DiscoveredApiOperation.MatchResult>())
            .setSourceMetadata(SourceMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2009/locations/location-2009/discoveredApiObservations/discoveredApiObservation-2009/discoveredApiOperations/discoveredApiOperation-2009";

    DiscoveredApiOperation actualResponse = client.getDiscoveredApiOperation(name);
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
  public void getDiscoveredApiOperationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2009/locations/location-2009/discoveredApiObservations/discoveredApiObservation-2009/discoveredApiOperations/discoveredApiOperation-2009";
      client.getDiscoveredApiOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
