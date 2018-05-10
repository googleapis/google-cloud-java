/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.EntityTypesClient.ListEntityTypesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.dialogflow.v2beta1.EntityType.Entity;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class EntityTypesClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private EntityTypesClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockContexts = new MockContexts();
    mockEntityTypes = new MockEntityTypes();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAgents,
                mockContexts,
                mockEntityTypes,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void listEntityTypesTest() {
    String nextPageToken = "";
    EntityType entityTypesElement = EntityType.newBuilder().build();
    List<EntityType> entityTypes = Arrays.asList(entityTypesElement);
    ListEntityTypesResponse expectedResponse =
        ListEntityTypesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEntityTypes(entityTypes)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityTypesRequest actualRequest = (ListEntityTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEntityTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");

      client.listEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listEntityTypesTest2() {
    String nextPageToken = "";
    EntityType entityTypesElement = EntityType.newBuilder().build();
    List<EntityType> entityTypes = Arrays.asList(entityTypesElement);
    ListEntityTypesResponse expectedResponse =
        ListEntityTypesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEntityTypes(entityTypes)
            .build();
    mockEntityTypes.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    String languageCode = "languageCode-412800396";

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent, languageCode);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityTypesRequest actualRequest = (ListEntityTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEntityTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      String languageCode = "languageCode-412800396";

      client.listEntityTypes(parent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEntityTypeTest() {
    EntityTypeName name2 = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");

    EntityType actualResponse = client.getEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityTypeRequest actualRequest = (GetEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, EntityTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");

      client.getEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEntityTypeTest2() {
    EntityTypeName name2 = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String languageCode = "languageCode-412800396";

    EntityType actualResponse = client.getEntityType(name, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityTypeRequest actualRequest = (GetEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, EntityTypeName.parse(actualRequest.getName()));
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      String languageCode = "languageCode-412800396";

      client.getEntityType(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEntityTypeTest() {
    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.createEntityType(parent, entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityTypeRequest actualRequest = (CreateEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      EntityType entityType = EntityType.newBuilder().build();

      client.createEntityType(parent, entityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEntityTypeTest2() {
    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    EntityType entityType = EntityType.newBuilder().build();
    String languageCode = "languageCode-412800396";

    EntityType actualResponse = client.createEntityType(parent, entityType, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityTypeRequest actualRequest = (CreateEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      EntityType entityType = EntityType.newBuilder().build();
      String languageCode = "languageCode-412800396";

      client.createEntityType(parent, entityType, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntityTypeTest() {
    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.updateEntityType(entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntityTypeRequest actualRequest = (UpdateEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityType entityType = EntityType.newBuilder().build();

      client.updateEntityType(entityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntityTypeTest2() {
    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    String displayName = "displayName1615086568";
    EntityType expectedResponse =
        EntityType.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityType entityType = EntityType.newBuilder().build();
    String languageCode = "languageCode-412800396";

    EntityType actualResponse = client.updateEntityType(entityType, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntityTypeRequest actualRequest = (UpdateEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(entityType, actualRequest.getEntityType());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntityTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityType entityType = EntityType.newBuilder().build();
      String languageCode = "languageCode-412800396";

      client.updateEntityType(entityType, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEntityTypeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEntityTypes.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");

    client.deleteEntityType(name);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntityTypeRequest actualRequest = (DeleteEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, EntityTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");

      client.deleteEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntityTypesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteEntityTypesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    List<String> entityTypeNames = new ArrayList<>();

    Empty actualResponse = client.batchDeleteEntityTypesAsync(parent, entityTypeNames).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteEntityTypesRequest actualRequest =
        (BatchDeleteEntityTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(entityTypeNames, actualRequest.getEntityTypeNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntityTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      List<String> entityTypeNames = new ArrayList<>();

      client.batchDeleteEntityTypesAsync(parent, entityTypeNames).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateEntitiesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<EntityType.Entity> entities = new ArrayList<>();

    Empty actualResponse = client.batchCreateEntitiesAsync(parent, entities).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateEntitiesRequest actualRequest = (BatchCreateEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entities, actualRequest.getEntitiesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<EntityType.Entity> entities = new ArrayList<>();

      client.batchCreateEntitiesAsync(parent, entities).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateEntitiesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateEntitiesTest2")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<EntityType.Entity> entities = new ArrayList<>();
    String languageCode = "languageCode-412800396";

    Empty actualResponse = client.batchCreateEntitiesAsync(parent, entities, languageCode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateEntitiesRequest actualRequest = (BatchCreateEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entities, actualRequest.getEntitiesList());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateEntitiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<EntityType.Entity> entities = new ArrayList<>();
      String languageCode = "languageCode-412800396";

      client.batchCreateEntitiesAsync(parent, entities, languageCode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateEntitiesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<EntityType.Entity> entities = new ArrayList<>();

    Empty actualResponse = client.batchUpdateEntitiesAsync(parent, entities).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateEntitiesRequest actualRequest = (BatchUpdateEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entities, actualRequest.getEntitiesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<EntityType.Entity> entities = new ArrayList<>();

      client.batchUpdateEntitiesAsync(parent, entities).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateEntitiesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateEntitiesTest2")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<EntityType.Entity> entities = new ArrayList<>();
    String languageCode = "languageCode-412800396";

    Empty actualResponse = client.batchUpdateEntitiesAsync(parent, entities, languageCode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateEntitiesRequest actualRequest = (BatchUpdateEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entities, actualRequest.getEntitiesList());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateEntitiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<EntityType.Entity> entities = new ArrayList<>();
      String languageCode = "languageCode-412800396";

      client.batchUpdateEntitiesAsync(parent, entities, languageCode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntitiesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<String> entityValues = new ArrayList<>();

    Empty actualResponse = client.batchDeleteEntitiesAsync(parent, entityValues).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteEntitiesRequest actualRequest = (BatchDeleteEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entityValues, actualRequest.getEntityValuesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<String> entityValues = new ArrayList<>();

      client.batchDeleteEntitiesAsync(parent, entityValues).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntitiesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteEntitiesTest2")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEntityTypes.addResponse(resultOperation);

    EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
    List<String> entityValues = new ArrayList<>();
    String languageCode = "languageCode-412800396";

    Empty actualResponse =
        client.batchDeleteEntitiesAsync(parent, entityValues, languageCode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteEntitiesRequest actualRequest = (BatchDeleteEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EntityTypeName.parse(actualRequest.getParent()));
    Assert.assertEquals(entityValues, actualRequest.getEntityValuesList());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteEntitiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEntityTypes.addException(exception);

    try {
      EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
      List<String> entityValues = new ArrayList<>();
      String languageCode = "languageCode-412800396";

      client.batchDeleteEntitiesAsync(parent, entityValues, languageCode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
