/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListFilesPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListSessionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonSessionServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SessionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SessionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSessionServiceStub.getMethodDescriptors(),
            SessionServiceSettings.getDefaultEndpoint());
    SessionServiceSettings settings =
        SessionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SessionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionServiceClient.create(settings);
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
  public void createSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
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
  public void createSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
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
  public void createSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SessionName name =
        SessionName.ofProjectLocationDataStoreSessionName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");

    client.deleteSession(name);

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
  public void deleteSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name =
          SessionName.ofProjectLocationDataStoreSessionName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";

    client.deleteSession(name);

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
  public void deleteSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    mockService.addResponse(expectedResponse);

    Session session =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Session actualResponse = client.updateSession(session, updateMask);
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
  public void updateSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Session session =
          Session.newBuilder()
              .setName(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setUserPseudoId("userPseudoId-1155274652")
              .addAllTurns(new ArrayList<Session.Turn>())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setIsPinned(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSession(session, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    mockService.addResponse(expectedResponse);

    SessionName name =
        SessionName.ofProjectLocationDataStoreSessionName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name =
          SessionName.ofProjectLocationDataStoreSessionName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setIsPinned(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest2() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFilesTest() throws Exception {
    FileMetadata responsesElement = FileMetadata.newBuilder().build();
    ListFilesResponse expectedResponse =
        ListFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SessionName parent =
        SessionName.ofProjectLocationCollectionEngineSessionName(
            "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]");

    ListFilesPagedResponse pagedListResponse = client.listFiles(parent);

    List<FileMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFilesList().get(0), resources.get(0));

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
  public void listFilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName parent =
          SessionName.ofProjectLocationCollectionEngineSessionName(
              "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]");
      client.listFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFilesTest2() throws Exception {
    FileMetadata responsesElement = FileMetadata.newBuilder().build();
    ListFilesResponse expectedResponse =
        ListFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-672/locations/location-672/collections/collection-672/engines/engine-672/sessions/session-672";

    ListFilesPagedResponse pagedListResponse = client.listFiles(parent);

    List<FileMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFilesList().get(0), resources.get(0));

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
  public void listFilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-672/locations/location-672/collections/collection-672/engines/engine-672/sessions/session-672";
      client.listFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
