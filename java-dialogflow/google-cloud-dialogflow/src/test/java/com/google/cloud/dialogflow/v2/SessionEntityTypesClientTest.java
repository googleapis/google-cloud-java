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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.SessionEntityTypesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

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
public class SessionEntityTypesClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private LocalChannelProvider channelProvider;
  private SessionEntityTypesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSessionEntityTypes, mockLocations));
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
    SessionEntityTypesSettings settings =
        SessionEntityTypesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionEntityTypesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listSessionEntityTypesTest() throws Exception {
    SessionEntityType responsesElement = SessionEntityType.newBuilder().build();
    ListSessionEntityTypesResponse expectedResponse =
        ListSessionEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessionEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");

    ListSessionEntityTypesPagedResponse pagedListResponse = client.listSessionEntityTypes(parent);

    List<SessionEntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionEntityTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionEntityTypesRequest actualRequest =
        ((ListSessionEntityTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionEntityTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      client.listSessionEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionEntityTypesTest2() throws Exception {
    SessionEntityType responsesElement = SessionEntityType.newBuilder().build();
    ListSessionEntityTypesResponse expectedResponse =
        ListSessionEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessionEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSessionEntityTypesPagedResponse pagedListResponse = client.listSessionEntityTypes(parent);

    List<SessionEntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionEntityTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionEntityTypesRequest actualRequest =
        ((ListSessionEntityTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionEntityTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSessionEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionEntityTypeTest() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.ofProjectSessionEntityTypeName(
            "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    SessionEntityType actualResponse = client.getSessionEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionEntityTypeRequest actualRequest =
        ((GetSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityTypeName name =
          SessionEntityTypeName.ofProjectSessionEntityTypeName(
              "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
      client.getSessionEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionEntityTypeTest2() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    String name = "name3373707";

    SessionEntityType actualResponse = client.getSessionEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionEntityTypeRequest actualRequest =
        ((GetSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      String name = "name3373707";
      client.getSessionEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionEntityTypeTest() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.createSessionEntityType(parent, sessionEntityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionEntityTypeRequest actualRequest =
        ((CreateSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();
      client.createSessionEntityType(parent, sessionEntityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionEntityTypeTest2() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.createSessionEntityType(parent, sessionEntityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionEntityTypeRequest actualRequest =
        ((CreateSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      String parent = "parent-995424086";
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();
      client.createSessionEntityType(parent, sessionEntityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSessionEntityTypeTest() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.updateSessionEntityType(sessionEntityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSessionEntityTypeRequest actualRequest =
        ((UpdateSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();
      client.updateSessionEntityType(sessionEntityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSessionEntityTypeTest2() throws Exception {
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SessionEntityType actualResponse =
        client.updateSessionEntityType(sessionEntityType, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSessionEntityTypeRequest actualRequest =
        ((UpdateSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSessionEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSessionEntityType(sessionEntityType, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionEntityTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.ofProjectSessionEntityTypeName(
            "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    client.deleteSessionEntityType(name);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionEntityTypeRequest actualRequest =
        ((DeleteSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityTypeName name =
          SessionEntityTypeName.ofProjectSessionEntityTypeName(
              "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
      client.deleteSessionEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionEntityTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSessionEntityType(name);

    List<AbstractMessage> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionEntityTypeRequest actualRequest =
        ((DeleteSessionEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSessionEntityType(name);
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
