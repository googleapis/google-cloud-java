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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListLocationsPagedResponse;

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
public class EntityTypesClientTest {
  private static MockEntityTypes mockEntityTypes;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EntityTypesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEntityTypes = new MockEntityTypes();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEntityTypes, mockLocations));
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
    EntityTypesSettings settings =
        EntityTypesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EntityTypesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEntityTypesTest() throws Exception {
    EntityType responsesElement = EntityType.newBuilder().build();
    ListEntityTypesResponse expectedResponse =
        ListEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityTypesRequest actualRequest = ((ListEntityTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntityTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntityTypesTest2() throws Exception {
    EntityType responsesElement = EntityType.newBuilder().build();
    ListEntityTypesResponse expectedResponse =
        ListEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityTypesRequest actualRequest = ((ListEntityTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntityTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityTypeTest() throws Exception {
    EntityType expectedResponse =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");

    EntityType actualResponse = client.getEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityTypeRequest actualRequest = ((GetEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName name =
          EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");
      client.getEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityTypeTest2() throws Exception {
    EntityType expectedResponse =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    String name = "name3373707";

    EntityType actualResponse = client.getEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityTypeRequest actualRequest = ((GetEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      String name = "name3373707";
      client.getEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntityTypeTest() throws Exception {
    EntityType expectedResponse =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.createEntityType(parent, entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityTypeRequest actualRequest = ((CreateEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      EntityType entityType = EntityType.newBuilder().build();
      client.createEntityType(parent, entityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntityTypeTest2() throws Exception {
    EntityType expectedResponse =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.createEntityType(parent, entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityTypeRequest actualRequest = ((CreateEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      String parent = "parent-995424086";
      EntityType entityType = EntityType.newBuilder().build();
      client.createEntityType(parent, entityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntityTypeTest() throws Exception {
    EntityType expectedResponse =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityType entityType = EntityType.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntityType actualResponse = client.updateEntityType(entityType, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntityTypeRequest actualRequest = ((UpdateEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityType entityType = EntityType.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntityType(entityType, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");

    client.deleteEntityType(name);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntityTypeRequest actualRequest = ((DeleteEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName name =
          EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");
      client.deleteEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEntityTypes.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEntityType(name);

    List<AbstractMessage> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntityTypeRequest actualRequest = ((DeleteEntityTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntityType(name);
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
