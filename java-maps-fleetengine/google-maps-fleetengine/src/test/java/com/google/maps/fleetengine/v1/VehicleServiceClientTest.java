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

import static google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.geo.type.Viewport;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
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
public class VehicleServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockVehicleService mockVehicleService;
  private LocalChannelProvider channelProvider;
  private VehicleServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVehicleService = new MockVehicleService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockVehicleService));
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
    VehicleServiceSettings settings =
        VehicleServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VehicleServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createVehicleTest() throws Exception {
    Vehicle expectedResponse =
        Vehicle.newBuilder()
            .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setVehicleState(VehicleState.forNumber(0))
            .addAllSupportedTripTypes(new ArrayList<TripType>())
            .addAllCurrentTrips(new ArrayList<String>())
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setMaximumCapacity(582710265)
            .addAllAttributes(new ArrayList<VehicleAttribute>())
            .setVehicleType(Vehicle.VehicleType.newBuilder().build())
            .setLicensePlate(LicensePlate.newBuilder().build())
            .addAllRoute(new ArrayList<TerminalLocation>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentTraffic(TrafficPolylineData.newBuilder().build())
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeSeconds(Int32Value.newBuilder().build())
            .addAllWaypoints(new ArrayList<TripWaypoint>())
            .setWaypointsVersion(Timestamp.newBuilder().build())
            .setBackToBackEnabled(true)
            .setNavigationStatus(NavigationStatus.forNumber(0))
            .setDeviceSettings(DeviceSettings.newBuilder().build())
            .build();
    mockVehicleService.addResponse(expectedResponse);

    CreateVehicleRequest request =
        CreateVehicleRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent("parent-995424086")
            .setVehicleId("vehicleId-1984135833")
            .setVehicle(Vehicle.newBuilder().build())
            .build();

    Vehicle actualResponse = client.createVehicle(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVehicleRequest actualRequest = ((CreateVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getVehicleId(), actualRequest.getVehicleId());
    Assert.assertEquals(request.getVehicle(), actualRequest.getVehicle());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      CreateVehicleRequest request =
          CreateVehicleRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setVehicleId("vehicleId-1984135833")
              .setVehicle(Vehicle.newBuilder().build())
              .build();
      client.createVehicle(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVehicleTest() throws Exception {
    Vehicle expectedResponse =
        Vehicle.newBuilder()
            .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setVehicleState(VehicleState.forNumber(0))
            .addAllSupportedTripTypes(new ArrayList<TripType>())
            .addAllCurrentTrips(new ArrayList<String>())
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setMaximumCapacity(582710265)
            .addAllAttributes(new ArrayList<VehicleAttribute>())
            .setVehicleType(Vehicle.VehicleType.newBuilder().build())
            .setLicensePlate(LicensePlate.newBuilder().build())
            .addAllRoute(new ArrayList<TerminalLocation>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentTraffic(TrafficPolylineData.newBuilder().build())
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeSeconds(Int32Value.newBuilder().build())
            .addAllWaypoints(new ArrayList<TripWaypoint>())
            .setWaypointsVersion(Timestamp.newBuilder().build())
            .setBackToBackEnabled(true)
            .setNavigationStatus(NavigationStatus.forNumber(0))
            .setDeviceSettings(DeviceSettings.newBuilder().build())
            .build();
    mockVehicleService.addResponse(expectedResponse);

    GetVehicleRequest request =
        GetVehicleRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setWaypointsVersion(Timestamp.newBuilder().build())
            .build();

    Vehicle actualResponse = client.getVehicle(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVehicleRequest actualRequest = ((GetVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(
        request.getCurrentRouteSegmentVersion(), actualRequest.getCurrentRouteSegmentVersion());
    Assert.assertEquals(request.getWaypointsVersion(), actualRequest.getWaypointsVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      GetVehicleRequest request =
          GetVehicleRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
              .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
              .setWaypointsVersion(Timestamp.newBuilder().build())
              .build();
      client.getVehicle(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVehicleTest() throws Exception {
    Vehicle expectedResponse =
        Vehicle.newBuilder()
            .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setVehicleState(VehicleState.forNumber(0))
            .addAllSupportedTripTypes(new ArrayList<TripType>())
            .addAllCurrentTrips(new ArrayList<String>())
            .setLastLocation(VehicleLocation.newBuilder().build())
            .setMaximumCapacity(582710265)
            .addAllAttributes(new ArrayList<VehicleAttribute>())
            .setVehicleType(Vehicle.VehicleType.newBuilder().build())
            .setLicensePlate(LicensePlate.newBuilder().build())
            .addAllRoute(new ArrayList<TerminalLocation>())
            .setCurrentRouteSegment("currentRouteSegment29209795")
            .setCurrentRouteSegmentTraffic(TrafficPolylineData.newBuilder().build())
            .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
            .setCurrentRouteSegmentEndPoint(TripWaypoint.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setEtaToFirstWaypoint(Timestamp.newBuilder().build())
            .setRemainingTimeSeconds(Int32Value.newBuilder().build())
            .addAllWaypoints(new ArrayList<TripWaypoint>())
            .setWaypointsVersion(Timestamp.newBuilder().build())
            .setBackToBackEnabled(true)
            .setNavigationStatus(NavigationStatus.forNumber(0))
            .setDeviceSettings(DeviceSettings.newBuilder().build())
            .build();
    mockVehicleService.addResponse(expectedResponse);

    UpdateVehicleRequest request =
        UpdateVehicleRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName("name3373707")
            .setVehicle(Vehicle.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Vehicle actualResponse = client.updateVehicle(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVehicleRequest actualRequest = ((UpdateVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVehicle(), actualRequest.getVehicle());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      UpdateVehicleRequest request =
          UpdateVehicleRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName("name3373707")
              .setVehicle(Vehicle.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateVehicle(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVehicleLocationTest() throws Exception {
    VehicleLocation expectedResponse =
        VehicleLocation.newBuilder()
            .setLocation(LatLng.newBuilder().build())
            .setHorizontalAccuracy(DoubleValue.newBuilder().build())
            .setLatlngAccuracy(DoubleValue.newBuilder().build())
            .setHeading(Int32Value.newBuilder().build())
            .setBearingAccuracy(DoubleValue.newBuilder().build())
            .setHeadingAccuracy(DoubleValue.newBuilder().build())
            .setAltitude(DoubleValue.newBuilder().build())
            .setVerticalAccuracy(DoubleValue.newBuilder().build())
            .setAltitudeAccuracy(DoubleValue.newBuilder().build())
            .setSpeedKmph(Int32Value.newBuilder().build())
            .setSpeed(DoubleValue.newBuilder().build())
            .setSpeedAccuracy(DoubleValue.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setServerTime(Timestamp.newBuilder().build())
            .setLocationSensor(LocationSensor.forNumber(0))
            .setIsRoadSnapped(BoolValue.newBuilder().build())
            .setIsGpsSensorEnabled(BoolValue.newBuilder().build())
            .setTimeSinceUpdate(Int32Value.newBuilder().build())
            .setNumStaleUpdates(Int32Value.newBuilder().build())
            .setRawLocation(LatLng.newBuilder().build())
            .setRawLocationTime(Timestamp.newBuilder().build())
            .setRawLocationSensor(LocationSensor.forNumber(0))
            .setRawLocationAccuracy(DoubleValue.newBuilder().build())
            .setSupplementalLocation(LatLng.newBuilder().build())
            .setSupplementalLocationTime(Timestamp.newBuilder().build())
            .setSupplementalLocationSensor(LocationSensor.forNumber(0))
            .setSupplementalLocationAccuracy(DoubleValue.newBuilder().build())
            .setRoadSnapped(true)
            .build();
    mockVehicleService.addResponse(expectedResponse);

    UpdateVehicleLocationRequest request =
        UpdateVehicleLocationRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName("name3373707")
            .setCurrentLocation(VehicleLocation.newBuilder().build())
            .setCurrentState(VehicleState.forNumber(0))
            .build();

    VehicleLocation actualResponse = client.updateVehicleLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVehicleLocationRequest actualRequest =
        ((UpdateVehicleLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCurrentLocation(), actualRequest.getCurrentLocation());
    Assert.assertEquals(request.getCurrentState(), actualRequest.getCurrentState());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVehicleLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      UpdateVehicleLocationRequest request =
          UpdateVehicleLocationRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName("name3373707")
              .setCurrentLocation(VehicleLocation.newBuilder().build())
              .setCurrentState(VehicleState.forNumber(0))
              .build();
      client.updateVehicleLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVehicleAttributesTest() throws Exception {
    UpdateVehicleAttributesResponse expectedResponse =
        UpdateVehicleAttributesResponse.newBuilder()
            .addAllAttributes(new ArrayList<VehicleAttribute>())
            .build();
    mockVehicleService.addResponse(expectedResponse);

    UpdateVehicleAttributesRequest request =
        UpdateVehicleAttributesRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setName("name3373707")
            .addAllAttributes(new ArrayList<VehicleAttribute>())
            .build();

    UpdateVehicleAttributesResponse actualResponse = client.updateVehicleAttributes(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVehicleAttributesRequest actualRequest =
        ((UpdateVehicleAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAttributesList(), actualRequest.getAttributesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVehicleAttributesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      UpdateVehicleAttributesRequest request =
          UpdateVehicleAttributesRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName("name3373707")
              .addAllAttributes(new ArrayList<VehicleAttribute>())
              .build();
      client.updateVehicleAttributes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVehiclesTest() throws Exception {
    Vehicle responsesElement = Vehicle.newBuilder().build();
    ListVehiclesResponse expectedResponse =
        ListVehiclesResponse.newBuilder()
            .setNextPageToken("")
            .addAllVehicles(Arrays.asList(responsesElement))
            .build();
    mockVehicleService.addResponse(expectedResponse);

    ListVehiclesRequest request =
        ListVehiclesRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setMinimumCapacity(Int32Value.newBuilder().build())
            .addAllTripTypes(new ArrayList<TripType>())
            .setMaximumStaleness(Duration.newBuilder().build())
            .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
            .addAllRequiredAttributes(new ArrayList<String>())
            .addAllRequiredOneOfAttributes(new ArrayList<String>())
            .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
            .setVehicleState(VehicleState.forNumber(0))
            .setOnTripOnly(true)
            .setFilter("filter-1274492040")
            .setViewport(Viewport.newBuilder().build())
            .build();

    ListVehiclesPagedResponse pagedListResponse = client.listVehicles(request);

    List<Vehicle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVehiclesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVehiclesRequest actualRequest = ((ListVehiclesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getMinimumCapacity(), actualRequest.getMinimumCapacity());
    Assert.assertEquals(request.getTripTypesList(), actualRequest.getTripTypesList());
    Assert.assertEquals(request.getMaximumStaleness(), actualRequest.getMaximumStaleness());
    Assert.assertEquals(
        request.getVehicleTypeCategoriesList(), actualRequest.getVehicleTypeCategoriesList());
    Assert.assertEquals(
        request.getRequiredAttributesList(), actualRequest.getRequiredAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributesList(), actualRequest.getRequiredOneOfAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributeSetsList(),
        actualRequest.getRequiredOneOfAttributeSetsList());
    Assert.assertEquals(request.getVehicleState(), actualRequest.getVehicleState());
    Assert.assertEquals(request.getOnTripOnly(), actualRequest.getOnTripOnly());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getViewport(), actualRequest.getViewport());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVehiclesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      ListVehiclesRequest request =
          ListVehiclesRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMinimumCapacity(Int32Value.newBuilder().build())
              .addAllTripTypes(new ArrayList<TripType>())
              .setMaximumStaleness(Duration.newBuilder().build())
              .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
              .addAllRequiredAttributes(new ArrayList<String>())
              .addAllRequiredOneOfAttributes(new ArrayList<String>())
              .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
              .setVehicleState(VehicleState.forNumber(0))
              .setOnTripOnly(true)
              .setFilter("filter-1274492040")
              .setViewport(Viewport.newBuilder().build())
              .build();
      client.listVehicles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchVehiclesTest() throws Exception {
    SearchVehiclesResponse expectedResponse =
        SearchVehiclesResponse.newBuilder().addAllMatches(new ArrayList<VehicleMatch>()).build();
    mockVehicleService.addResponse(expectedResponse);

    SearchVehiclesRequest request =
        SearchVehiclesRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent("parent-995424086")
            .setPickupPoint(TerminalLocation.newBuilder().build())
            .setDropoffPoint(TerminalLocation.newBuilder().build())
            .setPickupRadiusMeters(-254656044)
            .setCount(94851343)
            .setMinimumCapacity(518841803)
            .addAllTripTypes(new ArrayList<TripType>())
            .setMaximumStaleness(Duration.newBuilder().build())
            .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
            .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
            .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
            .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
            .setIncludeBackToBack(true)
            .setTripId("tripId-865466336")
            .setFilter("filter-1274492040")
            .build();

    SearchVehiclesResponse actualResponse = client.searchVehicles(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchVehiclesRequest actualRequest = ((SearchVehiclesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPickupPoint(), actualRequest.getPickupPoint());
    Assert.assertEquals(request.getDropoffPoint(), actualRequest.getDropoffPoint());
    Assert.assertEquals(request.getPickupRadiusMeters(), actualRequest.getPickupRadiusMeters());
    Assert.assertEquals(request.getCount(), actualRequest.getCount());
    Assert.assertEquals(request.getMinimumCapacity(), actualRequest.getMinimumCapacity());
    Assert.assertEquals(request.getTripTypesList(), actualRequest.getTripTypesList());
    Assert.assertEquals(request.getMaximumStaleness(), actualRequest.getMaximumStaleness());
    Assert.assertEquals(request.getVehicleTypesList(), actualRequest.getVehicleTypesList());
    Assert.assertEquals(
        request.getRequiredAttributesList(), actualRequest.getRequiredAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributesList(), actualRequest.getRequiredOneOfAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributeSetsList(),
        actualRequest.getRequiredOneOfAttributeSetsList());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getIncludeBackToBack(), actualRequest.getIncludeBackToBack());
    Assert.assertEquals(request.getTripId(), actualRequest.getTripId());
    Assert.assertEquals(request.getCurrentTripsPresent(), actualRequest.getCurrentTripsPresent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchVehiclesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      SearchVehiclesRequest request =
          SearchVehiclesRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setPickupPoint(TerminalLocation.newBuilder().build())
              .setDropoffPoint(TerminalLocation.newBuilder().build())
              .setPickupRadiusMeters(-254656044)
              .setCount(94851343)
              .setMinimumCapacity(518841803)
              .addAllTripTypes(new ArrayList<TripType>())
              .setMaximumStaleness(Duration.newBuilder().build())
              .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
              .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
              .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
              .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
              .setIncludeBackToBack(true)
              .setTripId("tripId-865466336")
              .setFilter("filter-1274492040")
              .build();
      client.searchVehicles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchFuzzedVehiclesTest() throws Exception {
    SearchVehiclesResponse expectedResponse =
        SearchVehiclesResponse.newBuilder().addAllMatches(new ArrayList<VehicleMatch>()).build();
    mockVehicleService.addResponse(expectedResponse);

    SearchVehiclesRequest request =
        SearchVehiclesRequest.newBuilder()
            .setHeader(RequestHeader.newBuilder().build())
            .setParent("parent-995424086")
            .setPickupPoint(TerminalLocation.newBuilder().build())
            .setDropoffPoint(TerminalLocation.newBuilder().build())
            .setPickupRadiusMeters(-254656044)
            .setCount(94851343)
            .setMinimumCapacity(518841803)
            .addAllTripTypes(new ArrayList<TripType>())
            .setMaximumStaleness(Duration.newBuilder().build())
            .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
            .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
            .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
            .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
            .setIncludeBackToBack(true)
            .setTripId("tripId-865466336")
            .setFilter("filter-1274492040")
            .build();

    SearchVehiclesResponse actualResponse = client.searchFuzzedVehicles(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVehicleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchVehiclesRequest actualRequest = ((SearchVehiclesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPickupPoint(), actualRequest.getPickupPoint());
    Assert.assertEquals(request.getDropoffPoint(), actualRequest.getDropoffPoint());
    Assert.assertEquals(request.getPickupRadiusMeters(), actualRequest.getPickupRadiusMeters());
    Assert.assertEquals(request.getCount(), actualRequest.getCount());
    Assert.assertEquals(request.getMinimumCapacity(), actualRequest.getMinimumCapacity());
    Assert.assertEquals(request.getTripTypesList(), actualRequest.getTripTypesList());
    Assert.assertEquals(request.getMaximumStaleness(), actualRequest.getMaximumStaleness());
    Assert.assertEquals(request.getVehicleTypesList(), actualRequest.getVehicleTypesList());
    Assert.assertEquals(
        request.getRequiredAttributesList(), actualRequest.getRequiredAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributesList(), actualRequest.getRequiredOneOfAttributesList());
    Assert.assertEquals(
        request.getRequiredOneOfAttributeSetsList(),
        actualRequest.getRequiredOneOfAttributeSetsList());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getIncludeBackToBack(), actualRequest.getIncludeBackToBack());
    Assert.assertEquals(request.getTripId(), actualRequest.getTripId());
    Assert.assertEquals(request.getCurrentTripsPresent(), actualRequest.getCurrentTripsPresent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchFuzzedVehiclesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVehicleService.addException(exception);

    try {
      SearchVehiclesRequest request =
          SearchVehiclesRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setPickupPoint(TerminalLocation.newBuilder().build())
              .setDropoffPoint(TerminalLocation.newBuilder().build())
              .setPickupRadiusMeters(-254656044)
              .setCount(94851343)
              .setMinimumCapacity(518841803)
              .addAllTripTypes(new ArrayList<TripType>())
              .setMaximumStaleness(Duration.newBuilder().build())
              .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
              .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
              .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
              .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
              .setIncludeBackToBack(true)
              .setTripId("tripId-865466336")
              .setFilter("filter-1274492040")
              .build();
      client.searchFuzzedVehicles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
