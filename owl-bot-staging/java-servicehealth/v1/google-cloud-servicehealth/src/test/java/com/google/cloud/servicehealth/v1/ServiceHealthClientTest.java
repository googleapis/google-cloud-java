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

package com.google.cloud.servicehealth.v1;

import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListLocationsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationImpactsPagedResponse;

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
public class ServiceHealthClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHealth mockServiceHealth;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ServiceHealthClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServiceHealth = new MockServiceHealth();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockServiceHealth, mockLocations));
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
    ServiceHealthSettings settings =
        ServiceHealthSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceHealthClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEventsTest() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest2() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllEventImpacts(new ArrayList<EventImpact>())
            .addAllUpdates(new ArrayList<EventUpdate>())
            .setParentEvent("parentEvent991253520")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setNextUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]");

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]");
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest2() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllEventImpacts(new ArrayList<EventImpact>())
            .addAllUpdates(new ArrayList<EventUpdate>())
            .setParentEvent("parentEvent991253520")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setNextUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String name = "name3373707";

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String name = "name3373707";
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrganizationEventsTest() throws Exception {
    OrganizationEvent responsesElement = OrganizationEvent.newBuilder().build();
    ListOrganizationEventsResponse expectedResponse =
        ListOrganizationEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrganizationEvents(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListOrganizationEventsPagedResponse pagedListResponse = client.listOrganizationEvents(parent);

    List<OrganizationEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrganizationEventsRequest actualRequest =
        ((ListOrganizationEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrganizationEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listOrganizationEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrganizationEventsTest2() throws Exception {
    OrganizationEvent responsesElement = OrganizationEvent.newBuilder().build();
    ListOrganizationEventsResponse expectedResponse =
        ListOrganizationEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrganizationEvents(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOrganizationEventsPagedResponse pagedListResponse = client.listOrganizationEvents(parent);

    List<OrganizationEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrganizationEventsRequest actualRequest =
        ((ListOrganizationEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrganizationEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOrganizationEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationEventTest() throws Exception {
    OrganizationEvent expectedResponse =
        OrganizationEvent.newBuilder()
            .setName(OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllEventImpacts(new ArrayList<EventImpact>())
            .addAllUpdates(new ArrayList<EventUpdate>())
            .setParentEvent("parentEvent991253520")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setNextUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    OrganizationEventName name =
        OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]");

    OrganizationEvent actualResponse = client.getOrganizationEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationEventRequest actualRequest =
        ((GetOrganizationEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      OrganizationEventName name =
          OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]");
      client.getOrganizationEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationEventTest2() throws Exception {
    OrganizationEvent expectedResponse =
        OrganizationEvent.newBuilder()
            .setName(OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllEventImpacts(new ArrayList<EventImpact>())
            .addAllUpdates(new ArrayList<EventUpdate>())
            .setParentEvent("parentEvent991253520")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setNextUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String name = "name3373707";

    OrganizationEvent actualResponse = client.getOrganizationEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationEventRequest actualRequest =
        ((GetOrganizationEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String name = "name3373707";
      client.getOrganizationEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrganizationImpactsTest() throws Exception {
    OrganizationImpact responsesElement = OrganizationImpact.newBuilder().build();
    ListOrganizationImpactsResponse expectedResponse =
        ListOrganizationImpactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrganizationImpacts(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListOrganizationImpactsPagedResponse pagedListResponse = client.listOrganizationImpacts(parent);

    List<OrganizationImpact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationImpactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrganizationImpactsRequest actualRequest =
        ((ListOrganizationImpactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrganizationImpactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listOrganizationImpacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrganizationImpactsTest2() throws Exception {
    OrganizationImpact responsesElement = OrganizationImpact.newBuilder().build();
    ListOrganizationImpactsResponse expectedResponse =
        ListOrganizationImpactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrganizationImpacts(Arrays.asList(responsesElement))
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOrganizationImpactsPagedResponse pagedListResponse = client.listOrganizationImpacts(parent);

    List<OrganizationImpact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrganizationImpactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrganizationImpactsRequest actualRequest =
        ((ListOrganizationImpactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrganizationImpactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOrganizationImpacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationImpactTest() throws Exception {
    OrganizationImpact expectedResponse =
        OrganizationImpact.newBuilder()
            .setName(
                OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]")
                    .toString())
            .addAllEvents(new ArrayList<String>())
            .setAsset(Asset.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    OrganizationImpactName name =
        OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]");

    OrganizationImpact actualResponse = client.getOrganizationImpact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationImpactRequest actualRequest =
        ((GetOrganizationImpactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationImpactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      OrganizationImpactName name =
          OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]");
      client.getOrganizationImpact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationImpactTest2() throws Exception {
    OrganizationImpact expectedResponse =
        OrganizationImpact.newBuilder()
            .setName(
                OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]")
                    .toString())
            .addAllEvents(new ArrayList<String>())
            .setAsset(Asset.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockServiceHealth.addResponse(expectedResponse);

    String name = "name3373707";

    OrganizationImpact actualResponse = client.getOrganizationImpact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceHealth.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationImpactRequest actualRequest =
        ((GetOrganizationImpactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationImpactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceHealth.addException(exception);

    try {
      String name = "name3373707";
      client.getOrganizationImpact(name);
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
