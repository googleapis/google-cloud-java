/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListHostProjectRegistrationsPagedResponse;
import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListLocationsPagedResponse;

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
public class HostProjectRegistrationServiceClientTest {
  private static MockHostProjectRegistrationService mockHostProjectRegistrationService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HostProjectRegistrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHostProjectRegistrationService = new MockHostProjectRegistrationService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockHostProjectRegistrationService, mockLocations));
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
    HostProjectRegistrationServiceSettings settings =
        HostProjectRegistrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HostProjectRegistrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createHostProjectRegistrationTest() throws Exception {
    HostProjectRegistration expectedResponse =
        HostProjectRegistration.newBuilder()
            .setName(
                HostProjectRegistrationName.of(
                        "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
                    .toString())
            .setGcpProject("gcpProject1666184549")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    HostProjectRegistration hostProjectRegistration = HostProjectRegistration.newBuilder().build();
    String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";

    HostProjectRegistration actualResponse =
        client.createHostProjectRegistration(
            parent, hostProjectRegistration, hostProjectRegistrationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHostProjectRegistrationRequest actualRequest =
        ((CreateHostProjectRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hostProjectRegistration, actualRequest.getHostProjectRegistration());
    Assert.assertEquals(hostProjectRegistrationId, actualRequest.getHostProjectRegistrationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHostProjectRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      HostProjectRegistration hostProjectRegistration =
          HostProjectRegistration.newBuilder().build();
      String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
      client.createHostProjectRegistration(
          parent, hostProjectRegistration, hostProjectRegistrationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHostProjectRegistrationTest2() throws Exception {
    HostProjectRegistration expectedResponse =
        HostProjectRegistration.newBuilder()
            .setName(
                HostProjectRegistrationName.of(
                        "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
                    .toString())
            .setGcpProject("gcpProject1666184549")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    HostProjectRegistration hostProjectRegistration = HostProjectRegistration.newBuilder().build();
    String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";

    HostProjectRegistration actualResponse =
        client.createHostProjectRegistration(
            parent, hostProjectRegistration, hostProjectRegistrationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHostProjectRegistrationRequest actualRequest =
        ((CreateHostProjectRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hostProjectRegistration, actualRequest.getHostProjectRegistration());
    Assert.assertEquals(hostProjectRegistrationId, actualRequest.getHostProjectRegistrationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHostProjectRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      HostProjectRegistration hostProjectRegistration =
          HostProjectRegistration.newBuilder().build();
      String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
      client.createHostProjectRegistration(
          parent, hostProjectRegistration, hostProjectRegistrationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHostProjectRegistrationTest() throws Exception {
    HostProjectRegistration expectedResponse =
        HostProjectRegistration.newBuilder()
            .setName(
                HostProjectRegistrationName.of(
                        "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
                    .toString())
            .setGcpProject("gcpProject1666184549")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    HostProjectRegistrationName name =
        HostProjectRegistrationName.of("[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]");

    HostProjectRegistration actualResponse = client.getHostProjectRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHostProjectRegistrationRequest actualRequest =
        ((GetHostProjectRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHostProjectRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      HostProjectRegistrationName name =
          HostProjectRegistrationName.of("[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]");
      client.getHostProjectRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHostProjectRegistrationTest2() throws Exception {
    HostProjectRegistration expectedResponse =
        HostProjectRegistration.newBuilder()
            .setName(
                HostProjectRegistrationName.of(
                        "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
                    .toString())
            .setGcpProject("gcpProject1666184549")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    String name = "name3373707";

    HostProjectRegistration actualResponse = client.getHostProjectRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHostProjectRegistrationRequest actualRequest =
        ((GetHostProjectRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHostProjectRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getHostProjectRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHostProjectRegistrationsTest() throws Exception {
    HostProjectRegistration responsesElement = HostProjectRegistration.newBuilder().build();
    ListHostProjectRegistrationsResponse expectedResponse =
        ListHostProjectRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHostProjectRegistrations(Arrays.asList(responsesElement))
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHostProjectRegistrationsPagedResponse pagedListResponse =
        client.listHostProjectRegistrations(parent);

    List<HostProjectRegistration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getHostProjectRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHostProjectRegistrationsRequest actualRequest =
        ((ListHostProjectRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHostProjectRegistrationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHostProjectRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHostProjectRegistrationsTest2() throws Exception {
    HostProjectRegistration responsesElement = HostProjectRegistration.newBuilder().build();
    ListHostProjectRegistrationsResponse expectedResponse =
        ListHostProjectRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHostProjectRegistrations(Arrays.asList(responsesElement))
            .build();
    mockHostProjectRegistrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHostProjectRegistrationsPagedResponse pagedListResponse =
        client.listHostProjectRegistrations(parent);

    List<HostProjectRegistration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getHostProjectRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHostProjectRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHostProjectRegistrationsRequest actualRequest =
        ((ListHostProjectRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHostProjectRegistrationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHostProjectRegistrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHostProjectRegistrations(parent);
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
