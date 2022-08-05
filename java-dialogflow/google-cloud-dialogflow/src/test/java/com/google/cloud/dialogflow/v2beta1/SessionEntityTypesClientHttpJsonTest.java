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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.SessionEntityTypesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2beta1.stub.HttpJsonSessionEntityTypesStub;
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
public class SessionEntityTypesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SessionEntityTypesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSessionEntityTypesStub.getMethodDescriptors(),
            SessionEntityTypesSettings.getDefaultEndpoint());
    SessionEntityTypesSettings settings =
        SessionEntityTypesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SessionEntityTypesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionEntityTypesClient.create(settings);
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
  public void listSessionEntityTypesTest() throws Exception {
    SessionEntityType responsesElement = SessionEntityType.newBuilder().build();
    ListSessionEntityTypesResponse expectedResponse =
        ListSessionEntityTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessionEntityTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");

    ListSessionEntityTypesPagedResponse pagedListResponse = client.listSessionEntityTypes(parent);

    List<SessionEntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionEntityTypesList().get(0), resources.get(0));

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
  public void listSessionEntityTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6494/agent/sessions/session-6494";

    ListSessionEntityTypesPagedResponse pagedListResponse = client.listSessionEntityTypes(parent);

    List<SessionEntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionEntityTypesList().get(0), resources.get(0));

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
  public void listSessionEntityTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6494/agent/sessions/session-6494";
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
    mockService.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.ofProjectSessionEntityTypeName(
            "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    SessionEntityType actualResponse = client.getSessionEntityType(name);
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
  public void getSessionEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-957/agent/sessions/session-957/entityTypes/entityType-957";

    SessionEntityType actualResponse = client.getSessionEntityType(name);
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
  public void getSessionEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-957/agent/sessions/session-957/entityTypes/entityType-957";
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
    mockService.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.createSessionEntityType(parent, sessionEntityType);
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
  public void createSessionEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6494/agent/sessions/session-6494";
    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.createSessionEntityType(parent, sessionEntityType);
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
  public void createSessionEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6494/agent/sessions/session-6494";
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
    mockService.addResponse(expectedResponse);

    SessionEntityType sessionEntityType =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();

    SessionEntityType actualResponse = client.updateSessionEntityType(sessionEntityType);
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
  public void updateSessionEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionEntityType sessionEntityType =
          SessionEntityType.newBuilder()
              .setName(
                  SessionEntityTypeName.ofProjectSessionEntityTypeName(
                          "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                      .toString())
              .addAllEntities(new ArrayList<EntityType.Entity>())
              .build();
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
    mockService.addResponse(expectedResponse);

    SessionEntityType sessionEntityType =
        SessionEntityType.newBuilder()
            .setName(
                SessionEntityTypeName.ofProjectSessionEntityTypeName(
                        "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                    .toString())
            .addAllEntities(new ArrayList<EntityType.Entity>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SessionEntityType actualResponse =
        client.updateSessionEntityType(sessionEntityType, updateMask);
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
  public void updateSessionEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionEntityType sessionEntityType =
          SessionEntityType.newBuilder()
              .setName(
                  SessionEntityTypeName.ofProjectSessionEntityTypeName(
                          "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]")
                      .toString())
              .addAllEntities(new ArrayList<EntityType.Entity>())
              .build();
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
    mockService.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.ofProjectSessionEntityTypeName(
            "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    client.deleteSessionEntityType(name);

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
  public void deleteSessionEntityTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-957/agent/sessions/session-957/entityTypes/entityType-957";

    client.deleteSessionEntityType(name);

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
  public void deleteSessionEntityTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-957/agent/sessions/session-957/entityTypes/entityType-957";
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
