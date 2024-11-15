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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListSipTrunksPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class SipTrunksClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSipTrunks mockSipTrunks;
  private LocalChannelProvider channelProvider;
  private SipTrunksClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSipTrunks = new MockSipTrunks();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSipTrunks, mockLocations));
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
    SipTrunksSettings settings =
        SipTrunksSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SipTrunksClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSipTrunkTest() throws Exception {
    SipTrunk expectedResponse =
        SipTrunk.newBuilder()
            .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
            .addAllExpectedHostname(new ArrayList<String>())
            .addAllConnections(new ArrayList<Connection>())
            .setDisplayName("displayName1714148973")
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SipTrunk sipTrunk = SipTrunk.newBuilder().build();

    SipTrunk actualResponse = client.createSipTrunk(parent, sipTrunk);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSipTrunkRequest actualRequest = ((CreateSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sipTrunk, actualRequest.getSipTrunk());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSipTrunkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SipTrunk sipTrunk = SipTrunk.newBuilder().build();
      client.createSipTrunk(parent, sipTrunk);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSipTrunkTest2() throws Exception {
    SipTrunk expectedResponse =
        SipTrunk.newBuilder()
            .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
            .addAllExpectedHostname(new ArrayList<String>())
            .addAllConnections(new ArrayList<Connection>())
            .setDisplayName("displayName1714148973")
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SipTrunk sipTrunk = SipTrunk.newBuilder().build();

    SipTrunk actualResponse = client.createSipTrunk(parent, sipTrunk);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSipTrunkRequest actualRequest = ((CreateSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sipTrunk, actualRequest.getSipTrunk());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSipTrunkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      String parent = "parent-995424086";
      SipTrunk sipTrunk = SipTrunk.newBuilder().build();
      client.createSipTrunk(parent, sipTrunk);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSipTrunkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSipTrunks.addResponse(expectedResponse);

    SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");

    client.deleteSipTrunk(name);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSipTrunkRequest actualRequest = ((DeleteSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSipTrunkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");
      client.deleteSipTrunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSipTrunkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSipTrunks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSipTrunk(name);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSipTrunkRequest actualRequest = ((DeleteSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSipTrunkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSipTrunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSipTrunksTest() throws Exception {
    SipTrunk responsesElement = SipTrunk.newBuilder().build();
    ListSipTrunksResponse expectedResponse =
        ListSipTrunksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSipTrunks(Arrays.asList(responsesElement))
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSipTrunksPagedResponse pagedListResponse = client.listSipTrunks(parent);

    List<SipTrunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSipTrunksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSipTrunksRequest actualRequest = ((ListSipTrunksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSipTrunksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSipTrunks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSipTrunksTest2() throws Exception {
    SipTrunk responsesElement = SipTrunk.newBuilder().build();
    ListSipTrunksResponse expectedResponse =
        ListSipTrunksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSipTrunks(Arrays.asList(responsesElement))
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSipTrunksPagedResponse pagedListResponse = client.listSipTrunks(parent);

    List<SipTrunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSipTrunksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSipTrunksRequest actualRequest = ((ListSipTrunksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSipTrunksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSipTrunks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSipTrunkTest() throws Exception {
    SipTrunk expectedResponse =
        SipTrunk.newBuilder()
            .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
            .addAllExpectedHostname(new ArrayList<String>())
            .addAllConnections(new ArrayList<Connection>())
            .setDisplayName("displayName1714148973")
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");

    SipTrunk actualResponse = client.getSipTrunk(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSipTrunkRequest actualRequest = ((GetSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSipTrunkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");
      client.getSipTrunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSipTrunkTest2() throws Exception {
    SipTrunk expectedResponse =
        SipTrunk.newBuilder()
            .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
            .addAllExpectedHostname(new ArrayList<String>())
            .addAllConnections(new ArrayList<Connection>())
            .setDisplayName("displayName1714148973")
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    String name = "name3373707";

    SipTrunk actualResponse = client.getSipTrunk(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSipTrunkRequest actualRequest = ((GetSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSipTrunkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      String name = "name3373707";
      client.getSipTrunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSipTrunkTest() throws Exception {
    SipTrunk expectedResponse =
        SipTrunk.newBuilder()
            .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
            .addAllExpectedHostname(new ArrayList<String>())
            .addAllConnections(new ArrayList<Connection>())
            .setDisplayName("displayName1714148973")
            .build();
    mockSipTrunks.addResponse(expectedResponse);

    SipTrunk sipTrunk = SipTrunk.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SipTrunk actualResponse = client.updateSipTrunk(sipTrunk, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSipTrunks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSipTrunkRequest actualRequest = ((UpdateSipTrunkRequest) actualRequests.get(0));

    Assert.assertEquals(sipTrunk, actualRequest.getSipTrunk());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSipTrunkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSipTrunks.addException(exception);

    try {
      SipTrunk sipTrunk = SipTrunk.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSipTrunk(sipTrunk, updateMask);
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
