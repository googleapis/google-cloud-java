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

package com.google.cloud.maintenance.api.v1beta;

import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListLocationsPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListResourceMaintenancesPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.SummarizeMaintenancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class MaintenanceClientTest {
  private static MockLocations mockLocations;
  private static MockMaintenance mockMaintenance;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MaintenanceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMaintenance = new MockMaintenance();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMaintenance, mockLocations));
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
    MaintenanceSettings settings =
        MaintenanceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MaintenanceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void summarizeMaintenancesTest() throws Exception {
    MaintenanceSummary responsesElement = MaintenanceSummary.newBuilder().build();
    SummarizeMaintenancesResponse expectedResponse =
        SummarizeMaintenancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMaintenances(Arrays.asList(responsesElement))
            .build();
    mockMaintenance.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SummarizeMaintenancesPagedResponse pagedListResponse = client.summarizeMaintenances(parent);

    List<MaintenanceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMaintenancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SummarizeMaintenancesRequest actualRequest =
        ((SummarizeMaintenancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void summarizeMaintenancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.summarizeMaintenances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void summarizeMaintenancesTest2() throws Exception {
    MaintenanceSummary responsesElement = MaintenanceSummary.newBuilder().build();
    SummarizeMaintenancesResponse expectedResponse =
        SummarizeMaintenancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMaintenances(Arrays.asList(responsesElement))
            .build();
    mockMaintenance.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SummarizeMaintenancesPagedResponse pagedListResponse = client.summarizeMaintenances(parent);

    List<MaintenanceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMaintenancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SummarizeMaintenancesRequest actualRequest =
        ((SummarizeMaintenancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void summarizeMaintenancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      String parent = "parent-995424086";
      client.summarizeMaintenances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceMaintenancesTest() throws Exception {
    ResourceMaintenance responsesElement = ResourceMaintenance.newBuilder().build();
    ListResourceMaintenancesResponse expectedResponse =
        ListResourceMaintenancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceMaintenances(Arrays.asList(responsesElement))
            .build();
    mockMaintenance.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListResourceMaintenancesPagedResponse pagedListResponse =
        client.listResourceMaintenances(parent);

    List<ResourceMaintenance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceMaintenancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceMaintenancesRequest actualRequest =
        ((ListResourceMaintenancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceMaintenancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listResourceMaintenances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceMaintenancesTest2() throws Exception {
    ResourceMaintenance responsesElement = ResourceMaintenance.newBuilder().build();
    ListResourceMaintenancesResponse expectedResponse =
        ListResourceMaintenancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceMaintenances(Arrays.asList(responsesElement))
            .build();
    mockMaintenance.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListResourceMaintenancesPagedResponse pagedListResponse =
        client.listResourceMaintenances(parent);

    List<ResourceMaintenance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceMaintenancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceMaintenancesRequest actualRequest =
        ((ListResourceMaintenancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceMaintenancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listResourceMaintenances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceMaintenanceTest() throws Exception {
    ResourceMaintenance expectedResponse =
        ResourceMaintenance.newBuilder()
            .setName(
                ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]")
                    .toString())
            .setResource(ResourceMaintenance.Resource.newBuilder().build())
            .setMaintenance(ResourceMaintenance.Maintenance.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMaintenanceStartTime(Timestamp.newBuilder().build())
            .setMaintenanceEndTime(Timestamp.newBuilder().build())
            .setMaintenanceCancelTime(Timestamp.newBuilder().build())
            .setMaintenanceScheduledStartTime(Timestamp.newBuilder().build())
            .setMaintenanceScheduledEndTime(Timestamp.newBuilder().build())
            .setUserControllable(true)
            .addAllControls(new ArrayList<MaintenanceControl>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockMaintenance.addResponse(expectedResponse);

    ResourceMaintenanceName name =
        ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]");

    ResourceMaintenance actualResponse = client.getResourceMaintenance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceMaintenanceRequest actualRequest =
        ((GetResourceMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceMaintenanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      ResourceMaintenanceName name =
          ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]");
      client.getResourceMaintenance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceMaintenanceTest2() throws Exception {
    ResourceMaintenance expectedResponse =
        ResourceMaintenance.newBuilder()
            .setName(
                ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]")
                    .toString())
            .setResource(ResourceMaintenance.Resource.newBuilder().build())
            .setMaintenance(ResourceMaintenance.Maintenance.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMaintenanceStartTime(Timestamp.newBuilder().build())
            .setMaintenanceEndTime(Timestamp.newBuilder().build())
            .setMaintenanceCancelTime(Timestamp.newBuilder().build())
            .setMaintenanceScheduledStartTime(Timestamp.newBuilder().build())
            .setMaintenanceScheduledEndTime(Timestamp.newBuilder().build())
            .setUserControllable(true)
            .addAllControls(new ArrayList<MaintenanceControl>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockMaintenance.addResponse(expectedResponse);

    String name = "name3373707";

    ResourceMaintenance actualResponse = client.getResourceMaintenance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMaintenance.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceMaintenanceRequest actualRequest =
        ((GetResourceMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceMaintenanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMaintenance.addException(exception);

    try {
      String name = "name3373707";
      client.getResourceMaintenance(name);
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
