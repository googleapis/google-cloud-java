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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EntityTypesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.cx.v3beta1.stub.HttpJsonEntityTypesStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EntityTypesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EntityTypesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEntityTypesStub.getMethodDescriptors(),
            EntityTypesSettings.getDefaultEndpoint());
    EntityTypesSettings settings =
        EntityTypesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EntityTypesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EntityTypesClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listEntityTypesTest() throws Exception {
    EntityType responsesElement = EntityType.newBuilder().build();
    ListEntityTypesResponse expectedResponse =
        ListEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntityTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1167/locations/location-1167/agents/agent-1167";

    ListEntityTypesPagedResponse pagedListResponse = client.listEntityTypes(parent);

    List<EntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntityTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntityTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1167/locations/location-1167/agents/agent-1167";
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
    mockService.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");

    EntityType actualResponse = client.getEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4320/locations/location-4320/agents/agent-4320/entityTypes/entityType-4320";

    EntityType actualResponse = client.getEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4320/locations/location-4320/agents/agent-4320/entityTypes/entityType-4320";
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
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.createEntityType(parent, entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1167/locations/location-1167/agents/agent-1167";
    EntityType entityType = EntityType.newBuilder().build();

    EntityType actualResponse = client.createEntityType(parent, entityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1167/locations/location-1167/agents/agent-1167";
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
    mockService.addResponse(expectedResponse);

    EntityType entityType =
        EntityType.newBuilder()
            .setName(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
            .setEnableFuzzyExtraction(true)
            .setRedact(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntityType actualResponse = client.updateEntityType(entityType, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntityType entityType =
          EntityType.newBuilder()
              .setName(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .addAllEntities(new ArrayList<EntityType.Entity>())
              .addAllExcludedPhrases(new ArrayList<EntityType.ExcludedPhrase>())
              .setEnableFuzzyExtraction(true)
              .setRedact(true)
              .build();
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
    mockService.addResponse(expectedResponse);

    EntityTypeName name = EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");

    client.deleteEntityType(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4320/locations/location-4320/agents/agent-4320/entityTypes/entityType-4320";

    client.deleteEntityType(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4320/locations/location-4320/agents/agent-4320/entityTypes/entityType-4320";
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
