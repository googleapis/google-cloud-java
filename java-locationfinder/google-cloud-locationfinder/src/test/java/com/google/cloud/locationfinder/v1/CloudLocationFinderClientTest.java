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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CloudLocationFinderClientTest {
  private static MockCloudLocationFinder mockCloudLocationFinder;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudLocationFinderClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudLocationFinder = new MockCloudLocationFinder();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudLocationFinder));
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
    CloudLocationFinderSettings settings =
        CloudLocationFinderSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudLocationFinderClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCloudLocationsTest() throws Exception {
    CloudLocation responsesElement = CloudLocation.newBuilder().build();
    ListCloudLocationsResponse expectedResponse =
        ListCloudLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudLocations(Arrays.asList(responsesElement))
            .build();
    mockCloudLocationFinder.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudLocationsPagedResponse pagedListResponse = client.listCloudLocations(parent);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudLocationsRequest actualRequest = ((ListCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

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
    mockCloudLocationFinder.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCloudLocationsPagedResponse pagedListResponse = client.listCloudLocations(parent);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudLocationsRequest actualRequest = ((ListCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudLocationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCloudLocationFinder.addResponse(expectedResponse);

    CloudLocationName name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");

    CloudLocation actualResponse = client.getCloudLocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudLocationRequest actualRequest = ((GetCloudLocationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

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
    mockCloudLocationFinder.addResponse(expectedResponse);

    String name = "name3373707";

    CloudLocation actualResponse = client.getCloudLocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudLocationRequest actualRequest = ((GetCloudLocationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudLocationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

    try {
      String name = "name3373707";
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
    mockCloudLocationFinder.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudLocationName sourceCloudLocation =
        CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCloudLocationsRequest actualRequest =
        ((SearchCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sourceCloudLocation.toString(), actualRequest.getSourceCloudLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCloudLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

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
    mockCloudLocationFinder.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String sourceCloudLocation = "sourceCloudLocation194570415";
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCloudLocationsRequest actualRequest =
        ((SearchCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sourceCloudLocation, actualRequest.getSourceCloudLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCloudLocationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

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
    mockCloudLocationFinder.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CloudLocationName sourceCloudLocation =
        CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCloudLocationsRequest actualRequest =
        ((SearchCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sourceCloudLocation.toString(), actualRequest.getSourceCloudLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCloudLocationsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCloudLocationFinder.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String sourceCloudLocation = "sourceCloudLocation194570415";
    String query = "query107944136";

    SearchCloudLocationsPagedResponse pagedListResponse =
        client.searchCloudLocations(parent, sourceCloudLocation, query);

    List<CloudLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudLocationFinder.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCloudLocationsRequest actualRequest =
        ((SearchCloudLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sourceCloudLocation, actualRequest.getSourceCloudLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCloudLocationsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudLocationFinder.addException(exception);

    try {
      String parent = "parent-995424086";
      String sourceCloudLocation = "sourceCloudLocation194570415";
      String query = "query107944136";
      client.searchCloudLocations(parent, sourceCloudLocation, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
