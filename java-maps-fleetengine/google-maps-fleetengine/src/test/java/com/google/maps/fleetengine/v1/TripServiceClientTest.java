/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1;

import static google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class TripServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTripService mockTripService;
  private LocalChannelProvider channelProvider;
  private TripServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTripService = new MockTripService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTripService));
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
    TripServiceSettings settings =
        TripServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TripServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTripTest() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
            .setVehicleId("vehicleId-1984135833")
            .setTripStatus(TripStatus.forNumber(0))
            .setTripType(TripType.forNumber(0))
            .setPickupPoint(TerminalLocation.newBuilder().build())
            .setActualPickupPoint(StopLocation.newBuilder().build())
            .setActualPickupArrivalPoint(StopLocation.newBuilder().build())
            .setPickupTime(Timestamp.newBuilder().build())
            .addAllIntermediateDestinations(new ArrayList<TerminalLocation>())
            .setIntermediateDestinationsVersion(Timestamp.newBuilder().build())
            .setIntermediateDestinationIndex(-144716901)
            .addAllActualIntermediateDestinationArrivalPoints(new ArrayList<StopLocation>())
            .addAllActualIntermediateDestinations(new ArrayList<StopLocation>())
            .setDropoffPoint(TerminalLocation.newBuilder().build())
            .setActualDropoffPoint(StopLocation.newBuilder().build())
            .setDropoffTime(Timestamp.newBuilder().build())
            .addAllRemainingWaypoints(new ArrayList<TripWaypoint>())
            .addAllVehicleWaypoints(new ArrayList<TripWaypoint>())
            .addAllRoute(new ArrayList<LatLng>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentTraffic(ConsumableTrafficPolyline.newBuilder().build())
            .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeToFirstWaypoint(Duration.newBuilder().build())
            .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
            .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
            .setNumberOfPassengers(-674364405)
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setLastLocationSnappable(true)
            .setView(TripView.forNumber(0))
            .build();
    mockTripService.addResponse(expectedResponse);

    CreateTripRequest request =
        CreateTripRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
            .setTripId("tripId-865466336")
            .setTrip(Trip.newBuilder().build())
            .build();

    Trip actualResponse = client.createTrip(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTripService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTripRequest actualRequest = ((CreateTripRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getTripId(), actualRequest.getTripId());
    Assert.assertEquals(request.getTrip(), actualRequest.getTrip());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTripService.addException(exception);

    try {
      CreateTripRequest request =
          CreateTripRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
              .setTripId("tripId-865466336")
              .setTrip(Trip.newBuilder().build())
              .build();
      client.createTrip(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTripTest() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
            .setVehicleId("vehicleId-1984135833")
            .setTripStatus(TripStatus.forNumber(0))
            .setTripType(TripType.forNumber(0))
            .setPickupPoint(TerminalLocation.newBuilder().build())
            .setActualPickupPoint(StopLocation.newBuilder().build())
            .setActualPickupArrivalPoint(StopLocation.newBuilder().build())
            .setPickupTime(Timestamp.newBuilder().build())
            .addAllIntermediateDestinations(new ArrayList<TerminalLocation>())
            .setIntermediateDestinationsVersion(Timestamp.newBuilder().build())
            .setIntermediateDestinationIndex(-144716901)
            .addAllActualIntermediateDestinationArrivalPoints(new ArrayList<StopLocation>())
            .addAllActualIntermediateDestinations(new ArrayList<StopLocation>())
            .setDropoffPoint(TerminalLocation.newBuilder().build())
            .setActualDropoffPoint(StopLocation.newBuilder().build())
            .setDropoffTime(Timestamp.newBuilder().build())
            .addAllRemainingWaypoints(new ArrayList<TripWaypoint>())
            .addAllVehicleWaypoints(new ArrayList<TripWaypoint>())
            .addAllRoute(new ArrayList<LatLng>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentTraffic(ConsumableTrafficPolyline.newBuilder().build())
            .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeToFirstWaypoint(Duration.newBuilder().build())
            .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
            .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
            .setNumberOfPassengers(-674364405)
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setLastLocationSnappable(true)
            .setView(TripView.forNumber(0))
            .build();
    mockTripService.addResponse(expectedResponse);

    GetTripRequest request =
        GetTripRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
            .setView(TripView.forNumber(0))
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
            .setRouteFormatType(PolylineFormatType.forNumber(0))
            .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
            .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
            .build();

    Trip actualResponse = client.getTrip(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTripService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTripRequest actualRequest = ((GetTripRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(
        request.getCurrentRouteSegmentVersion(), actualRequest.getCurrentRouteSegmentVersion());
    Assert.assertEquals(
        request.getRemainingWaypointsVersion(), actualRequest.getRemainingWaypointsVersion());
    Assert.assertEquals(request.getRouteFormatType(), actualRequest.getRouteFormatType());
    Assert.assertEquals(
        request.getCurrentRouteSegmentTrafficVersion(),
        actualRequest.getCurrentRouteSegmentTrafficVersion());
    Assert.assertEquals(
        request.getRemainingWaypointsRouteVersion(),
        actualRequest.getRemainingWaypointsRouteVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTripService.addException(exception);

    try {
      GetTripRequest request =
          GetTripRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
              .setView(TripView.forNumber(0))
              .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
              .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
              .setRouteFormatType(PolylineFormatType.forNumber(0))
              .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
              .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
              .build();
      client.getTrip(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportBillableTripTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTripService.addResponse(expectedResponse);

    ReportBillableTripRequest request =
        ReportBillableTripRequest.newBuilder()
            .setName("name3373707")
            .setCountryCode("countryCode-1477067101")
            .setPlatform(BillingPlatformIdentifier.forNumber(0))
            .addAllRelatedIds(new ArrayList<String>())
            .build();

    client.reportBillableTrip(request);

    List<AbstractMessage> actualRequests = mockTripService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportBillableTripRequest actualRequest = ((ReportBillableTripRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCountryCode(), actualRequest.getCountryCode());
    Assert.assertEquals(request.getPlatform(), actualRequest.getPlatform());
    Assert.assertEquals(request.getRelatedIdsList(), actualRequest.getRelatedIdsList());
    Assert.assertEquals(request.getSolutionType(), actualRequest.getSolutionType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportBillableTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTripService.addException(exception);

    try {
      ReportBillableTripRequest request =
          ReportBillableTripRequest.newBuilder()
              .setName("name3373707")
              .setCountryCode("countryCode-1477067101")
              .setPlatform(BillingPlatformIdentifier.forNumber(0))
              .addAllRelatedIds(new ArrayList<String>())
              .build();
      client.reportBillableTrip(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTripsTest() throws Exception {
    Trip responsesElement = Trip.newBuilder().build();
    SearchTripsResponse expectedResponse =
        SearchTripsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrips(Arrays.asList(responsesElement))
            .build();
    mockTripService.addResponse(expectedResponse);

    SearchTripsRequest request =
        SearchTripsRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent("parent-995424086")
            .setVehicleId("vehicleId-1984135833")
            .setActiveTripsOnly(true)
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setMinimumStaleness(Duration.newBuilder().build())
            .build();

    SearchTripsPagedResponse pagedListResponse = client.searchTrips(request);

    List<Trip> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTripsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTripService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTripsRequest actualRequest = ((SearchTripsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getVehicleId(), actualRequest.getVehicleId());
    Assert.assertEquals(request.getActiveTripsOnly(), actualRequest.getActiveTripsOnly());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getMinimumStaleness(), actualRequest.getMinimumStaleness());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTripsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTripService.addException(exception);

    try {
      SearchTripsRequest request =
          SearchTripsRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setVehicleId("vehicleId-1984135833")
              .setActiveTripsOnly(true)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMinimumStaleness(Duration.newBuilder().build())
              .build();
      client.searchTrips(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTripTest() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
            .setVehicleId("vehicleId-1984135833")
            .setTripStatus(TripStatus.forNumber(0))
            .setTripType(TripType.forNumber(0))
            .setPickupPoint(TerminalLocation.newBuilder().build())
            .setActualPickupPoint(StopLocation.newBuilder().build())
            .setActualPickupArrivalPoint(StopLocation.newBuilder().build())
            .setPickupTime(Timestamp.newBuilder().build())
            .addAllIntermediateDestinations(new ArrayList<TerminalLocation>())
            .setIntermediateDestinationsVersion(Timestamp.newBuilder().build())
            .setIntermediateDestinationIndex(-144716901)
            .addAllActualIntermediateDestinationArrivalPoints(new ArrayList<StopLocation>())
            .addAllActualIntermediateDestinations(new ArrayList<StopLocation>())
            .setDropoffPoint(TerminalLocation.newBuilder().build())
            .setActualDropoffPoint(StopLocation.newBuilder().build())
            .setDropoffTime(Timestamp.newBuilder().build())
            .addAllRemainingWaypoints(new ArrayList<TripWaypoint>())
            .addAllVehicleWaypoints(new ArrayList<TripWaypoint>())
            .addAllRoute(new ArrayList<LatLng>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentTraffic(ConsumableTrafficPolyline.newBuilder().build())
            .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeToFirstWaypoint(Duration.newBuilder().build())
            .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
            .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
            .setNumberOfPassengers(-674364405)
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setLastLocationSnappable(true)
            .setView(TripView.forNumber(0))
            .build();
    mockTripService.addResponse(expectedResponse);

    UpdateTripRequest request =
        UpdateTripRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName("name3373707")
            .setTrip(Trip.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Trip actualResponse = client.updateTrip(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTripService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTripRequest actualRequest = ((UpdateTripRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTrip(), actualRequest.getTrip());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTripService.addException(exception);

    try {
      UpdateTripRequest request =
          UpdateTripRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName("name3373707")
              .setTrip(Trip.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateTrip(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
