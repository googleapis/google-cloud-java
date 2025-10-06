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

package com.google.cloud.locationfinder.v1;

import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.ListCloudLocationsPagedResponse;
import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.SearchCloudLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.locationfinder.v1.stub.HttpJsonCloudLocationFinderStub;
import com.google.common.collect.Lists;
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
public class CloudLocationFinderClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudLocationFinderClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudLocationFinderStub.getMethodDescriptors(),
            CloudLocationFinderSettings.getDefaultEndpoint());
    CloudLocationFinderSettings settings =
        CloudLocationFinderSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudLocationFinderSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudLocationFinderClient.create(settings);
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
  public void listCloudLocationsTest() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    ListCloudLocationsResponse expectedResponse =
        ListCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudLocationsPagedResponse pagedListResponse = client.listCloudLocations(parent);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void listCloudLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCloudLocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudLocationsTest2() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    ListCloudLocationsResponse expectedResponse =
        ListCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCloudLocationsPagedResponse pagedListResponse = client.listCloudLocations(parent);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void listCloudLocationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCloudLocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudLocationTest() throws Exception {
    CloudLocation expectedResponse =
        CloudLocation.newBuilder()
            .setName(CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
            .setContainingCloudLocation(
                CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
            .setDisplayName("displayName1714148973")
            .setTerritoryCode("territoryCode-834638553")
            .setCarbonFreeEnergyPercentage(-1331329872)
            .build();
    mockService.addResponse(expectedResponse);

    CloudLocationName name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");

    CloudLocation actualResponse = client.getCloudLocation(name);
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
  public void getCloudLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudLocationName name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
      client.getCloudLocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudLocationTest2() throws Exception {
    CloudLocation expectedResponse =
        CloudLocation.newBuilder()
            .setName(CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
            .setContainingCloudLocation(
                CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
            .setDisplayName("displayName1714148973")
            .setTerritoryCode("territoryCode-834638553")
            .setCarbonFreeEnergyPercentage(-1331329872)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1991/locations/location-1991/cloudLocations/cloudLocation-1991";

    CloudLocation actualResponse = client.getCloudLocation(name);
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
  public void getCloudLocationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1991/locations/location-1991/cloudLocations/cloudLocation-1991";
      client.getCloudLocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCloudLocationsTest() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    SearchCloudLocationsResponse expectedResponse =
        SearchCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudLocationName sourceCloudLocation =
        CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void searchCloudLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudLocationName sourceCloudLocation =
          CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
      String query = "query107944136";
      client.searchCloudLocations(parent, sourceCloudLocation, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCloudLocationsTest2() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    SearchCloudLocationsResponse expectedResponse =
        SearchCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String sourceCloudLocation = "sourceCloudLocation194570415";
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void searchCloudLocationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String sourceCloudLocation = "sourceCloudLocation194570415";
      String query = "query107944136";
      client.searchCloudLocations(parent, sourceCloudLocation, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCloudLocationsTest3() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    SearchCloudLocationsResponse expectedResponse =
        SearchCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    CloudLocationName sourceCloudLocation =
        CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void searchCloudLocationsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CloudLocationName sourceCloudLocation =
          CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
      String query = "query107944136";
      client.searchCloudLocations(parent, sourceCloudLocation, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCloudLocationsTest4() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    SearchCloudLocationsResponse expectedResponse =
        SearchCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String sourceCloudLocation = "sourceCloudLocation194570415";
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

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
  public void searchCloudLocationsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String sourceCloudLocation = "sourceCloudLocation194570415";
      String query = "query107944136";
      client.searchCloudLocations(parent, sourceCloudLocation, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
