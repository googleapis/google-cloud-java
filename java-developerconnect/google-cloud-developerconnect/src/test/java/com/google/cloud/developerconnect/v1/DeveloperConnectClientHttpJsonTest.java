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

package com.google.cloud.developerconnect.v1;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListAccountConnectorsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListUsersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.developerconnect.v1.stub.HttpJsonDeveloperConnectStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeveloperConnectClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DeveloperConnectClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDeveloperConnectStub.getMethodDescriptors(),
            DeveloperConnectSettings.getDefaultEndpoint());
    DeveloperConnectSettings settings =
        DeveloperConnectSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DeveloperConnectSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeveloperConnectClient.create(settings);
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
  public void listConnectionsTest() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

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
  public void listConnectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionsTest2() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

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
  public void listConnectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    Connection actualResponse = client.getConnection(name);
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
  public void getConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.getConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7851/locations/location-7851/connections/connection-7851";

    Connection actualResponse = client.getConnection(name);
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
  public void getConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7851/locations/location-7851/connections/connection-7851";
      client.getConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse =
        client.createConnectionAsync(parent, connection, connectionId).get();
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
  public void createConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnectionAsync(parent, connection, connectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse =
        client.createConnectionAsync(parent, connection, connectionId).get();
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
  public void createConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnectionAsync(parent, connection, connectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Connection connection =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInstallationState(InstallationState.newBuilder().build())
            .setDisabled(true)
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setUid("uid115792")
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .setGitProxyConfig(GitProxyConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connection actualResponse = client.updateConnectionAsync(connection, updateMask).get();
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
  public void updateConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Connection connection =
          Connection.newBuilder()
              .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setInstallationState(InstallationState.newBuilder().build())
              .setDisabled(true)
              .setReconciling(true)
              .putAllAnnotations(new HashMap<String, String>())
              .setEtag("etag3123477")
              .setUid("uid115792")
              .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
              .setGitProxyConfig(GitProxyConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectionAsync(connection, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    client.deleteConnectionAsync(name).get();

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
  public void deleteConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.deleteConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7851/locations/location-7851/connections/connection-7851";

    client.deleteConnectionAsync(name).get();

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
  public void deleteConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7851/locations/location-7851/connections/connection-7851";
      client.deleteConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGitRepositoryLinkTest() throws Exception {
    GitRepositoryLink expectedResponse =
        GitRepositoryLink.newBuilder()
            .setName(
                GitRepositoryLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                    .toString())
            .setCloneUri("cloneUri1088198351")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setWebhookId("webhookId-544129550")
            .setGitProxyUri("gitProxyUri306660880")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
    String gitRepositoryLinkId = "gitRepositoryLinkId684669585";

    GitRepositoryLink actualResponse =
        client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
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
  public void createGitRepositoryLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
      String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
      client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGitRepositoryLinkTest2() throws Exception {
    GitRepositoryLink expectedResponse =
        GitRepositoryLink.newBuilder()
            .setName(
                GitRepositoryLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                    .toString())
            .setCloneUri("cloneUri1088198351")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setWebhookId("webhookId-544129550")
            .setGitProxyUri("gitProxyUri306660880")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-7002/locations/location-7002/connections/connection-7002";
    GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
    String gitRepositoryLinkId = "gitRepositoryLinkId684669585";

    GitRepositoryLink actualResponse =
        client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
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
  public void createGitRepositoryLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7002/locations/location-7002/connections/connection-7002";
      GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
      String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
      client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGitRepositoryLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GitRepositoryLinkName name =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    client.deleteGitRepositoryLinkAsync(name).get();

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
  public void deleteGitRepositoryLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GitRepositoryLinkName name =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      client.deleteGitRepositoryLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGitRepositoryLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-756/locations/location-756/connections/connection-756/gitRepositoryLinks/gitRepositoryLink-756";

    client.deleteGitRepositoryLinkAsync(name).get();

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
  public void deleteGitRepositoryLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-756/locations/location-756/connections/connection-756/gitRepositoryLinks/gitRepositoryLink-756";
      client.deleteGitRepositoryLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listGitRepositoryLinksTest() throws Exception {
    GitRepositoryLink responsesElement = GitRepositoryLink.newBuilder().build();
    ListGitRepositoryLinksResponse expectedResponse =
        ListGitRepositoryLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllGitRepositoryLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    ListGitRepositoryLinksPagedResponse pagedListResponse = client.listGitRepositoryLinks(parent);

    List<GitRepositoryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGitRepositoryLinksList().get(0), resources.get(0));

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
  public void listGitRepositoryLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.listGitRepositoryLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGitRepositoryLinksTest2() throws Exception {
    GitRepositoryLink responsesElement = GitRepositoryLink.newBuilder().build();
    ListGitRepositoryLinksResponse expectedResponse =
        ListGitRepositoryLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllGitRepositoryLinks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7002/locations/location-7002/connections/connection-7002";

    ListGitRepositoryLinksPagedResponse pagedListResponse = client.listGitRepositoryLinks(parent);

    List<GitRepositoryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGitRepositoryLinksList().get(0), resources.get(0));

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
  public void listGitRepositoryLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7002/locations/location-7002/connections/connection-7002";
      client.listGitRepositoryLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGitRepositoryLinkTest() throws Exception {
    GitRepositoryLink expectedResponse =
        GitRepositoryLink.newBuilder()
            .setName(
                GitRepositoryLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                    .toString())
            .setCloneUri("cloneUri1088198351")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setWebhookId("webhookId-544129550")
            .setGitProxyUri("gitProxyUri306660880")
            .build();
    mockService.addResponse(expectedResponse);

    GitRepositoryLinkName name =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    GitRepositoryLink actualResponse = client.getGitRepositoryLink(name);
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
  public void getGitRepositoryLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GitRepositoryLinkName name =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      client.getGitRepositoryLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGitRepositoryLinkTest2() throws Exception {
    GitRepositoryLink expectedResponse =
        GitRepositoryLink.newBuilder()
            .setName(
                GitRepositoryLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                    .toString())
            .setCloneUri("cloneUri1088198351")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setWebhookId("webhookId-544129550")
            .setGitProxyUri("gitProxyUri306660880")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-756/locations/location-756/connections/connection-756/gitRepositoryLinks/gitRepositoryLink-756";

    GitRepositoryLink actualResponse = client.getGitRepositoryLink(name);
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
  public void getGitRepositoryLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-756/locations/location-756/connections/connection-756/gitRepositoryLinks/gitRepositoryLink-756";
      client.getGitRepositoryLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchReadWriteTokenTest() throws Exception {
    FetchReadWriteTokenResponse expectedResponse =
        FetchReadWriteTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setGitUsername("gitUsername1026132680")
            .build();
    mockService.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    FetchReadWriteTokenResponse actualResponse = client.fetchReadWriteToken(gitRepositoryLink);
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
  public void fetchReadWriteTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GitRepositoryLinkName gitRepositoryLink =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      client.fetchReadWriteToken(gitRepositoryLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchReadWriteTokenTest2() throws Exception {
    FetchReadWriteTokenResponse expectedResponse =
        FetchReadWriteTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setGitUsername("gitUsername1026132680")
            .build();
    mockService.addResponse(expectedResponse);

    String gitRepositoryLink =
        "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";

    FetchReadWriteTokenResponse actualResponse = client.fetchReadWriteToken(gitRepositoryLink);
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
  public void fetchReadWriteTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String gitRepositoryLink =
          "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";
      client.fetchReadWriteToken(gitRepositoryLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchReadTokenTest() throws Exception {
    FetchReadTokenResponse expectedResponse =
        FetchReadTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setGitUsername("gitUsername1026132680")
            .build();
    mockService.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    FetchReadTokenResponse actualResponse = client.fetchReadToken(gitRepositoryLink);
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
  public void fetchReadTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GitRepositoryLinkName gitRepositoryLink =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      client.fetchReadToken(gitRepositoryLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchReadTokenTest2() throws Exception {
    FetchReadTokenResponse expectedResponse =
        FetchReadTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setGitUsername("gitUsername1026132680")
            .build();
    mockService.addResponse(expectedResponse);

    String gitRepositoryLink =
        "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";

    FetchReadTokenResponse actualResponse = client.fetchReadToken(gitRepositoryLink);
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
  public void fetchReadTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String gitRepositoryLink =
          "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";
      client.fetchReadToken(gitRepositoryLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchLinkableGitRepositoriesTest() throws Exception {
    LinkableGitRepository responsesElement = LinkableGitRepository.newBuilder().build();
    FetchLinkableGitRepositoriesResponse expectedResponse =
        FetchLinkableGitRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLinkableGitRepositories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    FetchLinkableGitRepositoriesPagedResponse pagedListResponse =
        client.fetchLinkableGitRepositories(connection);

    List<LinkableGitRepository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinkableGitRepositoriesList().get(0), resources.get(0));

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
  public void fetchLinkableGitRepositoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.fetchLinkableGitRepositories(connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchLinkableGitRepositoriesTest2() throws Exception {
    LinkableGitRepository responsesElement = LinkableGitRepository.newBuilder().build();
    FetchLinkableGitRepositoriesResponse expectedResponse =
        FetchLinkableGitRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLinkableGitRepositories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String connection = "projects/project-8802/locations/location-8802/connections/connection-8802";

    FetchLinkableGitRepositoriesPagedResponse pagedListResponse =
        client.fetchLinkableGitRepositories(connection);

    List<LinkableGitRepository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinkableGitRepositoriesList().get(0), resources.get(0));

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
  public void fetchLinkableGitRepositoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String connection =
          "projects/project-8802/locations/location-8802/connections/connection-8802";
      client.fetchLinkableGitRepositories(connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchGitHubInstallationsTest() throws Exception {
    FetchGitHubInstallationsResponse expectedResponse =
        FetchGitHubInstallationsResponse.newBuilder()
            .addAllInstallations(new ArrayList<FetchGitHubInstallationsResponse.Installation>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    FetchGitHubInstallationsResponse actualResponse = client.fetchGitHubInstallations(connection);
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
  public void fetchGitHubInstallationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.fetchGitHubInstallations(connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchGitHubInstallationsTest2() throws Exception {
    FetchGitHubInstallationsResponse expectedResponse =
        FetchGitHubInstallationsResponse.newBuilder()
            .addAllInstallations(new ArrayList<FetchGitHubInstallationsResponse.Installation>())
            .build();
    mockService.addResponse(expectedResponse);

    String connection = "projects/project-8802/locations/location-8802/connections/connection-8802";

    FetchGitHubInstallationsResponse actualResponse = client.fetchGitHubInstallations(connection);
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
  public void fetchGitHubInstallationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String connection =
          "projects/project-8802/locations/location-8802/connections/connection-8802";
      client.fetchGitHubInstallations(connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchGitRefsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchGitRefsResponse expectedResponse =
        FetchGitRefsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRefNames(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
    FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);

    FetchGitRefsPagedResponse pagedListResponse = client.fetchGitRefs(gitRepositoryLink, refType);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRefNamesList().get(0), resources.get(0));

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
  public void fetchGitRefsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GitRepositoryLinkName gitRepositoryLink =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);
      client.fetchGitRefs(gitRepositoryLink, refType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchGitRefsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchGitRefsResponse expectedResponse =
        FetchGitRefsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRefNames(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String gitRepositoryLink =
        "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";
    FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);

    FetchGitRefsPagedResponse pagedListResponse = client.fetchGitRefs(gitRepositoryLink, refType);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRefNamesList().get(0), resources.get(0));

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
  public void fetchGitRefsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String gitRepositoryLink =
          "projects/project-3697/locations/location-3697/connections/connection-3697/gitRepositoryLinks/gitRepositoryLink-3697";
      FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);
      client.fetchGitRefs(gitRepositoryLink, refType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountConnectorsTest() throws Exception {
    AccountConnector responsesElement = AccountConnector.newBuilder().build();
    ListAccountConnectorsResponse expectedResponse =
        ListAccountConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccountConnectorsPagedResponse pagedListResponse = client.listAccountConnectors(parent);

    List<AccountConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountConnectorsList().get(0), resources.get(0));

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
  public void listAccountConnectorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAccountConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountConnectorsTest2() throws Exception {
    AccountConnector responsesElement = AccountConnector.newBuilder().build();
    ListAccountConnectorsResponse expectedResponse =
        ListAccountConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAccountConnectorsPagedResponse pagedListResponse = client.listAccountConnectors(parent);

    List<AccountConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountConnectorsList().get(0), resources.get(0));

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
  public void listAccountConnectorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAccountConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountConnectorTest() throws Exception {
    AccountConnector expectedResponse =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    mockService.addResponse(expectedResponse);

    AccountConnectorName name =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    AccountConnector actualResponse = client.getAccountConnector(name);
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
  public void getAccountConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName name =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.getAccountConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountConnectorTest2() throws Exception {
    AccountConnector expectedResponse =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";

    AccountConnector actualResponse = client.getAccountConnector(name);
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
  public void getAccountConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";
      client.getAccountConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccountConnectorTest() throws Exception {
    AccountConnector expectedResponse =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccountConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AccountConnector accountConnector = AccountConnector.newBuilder().build();
    String accountConnectorId = "accountConnectorId-605811237";

    AccountConnector actualResponse =
        client.createAccountConnectorAsync(parent, accountConnector, accountConnectorId).get();
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
  public void createAccountConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AccountConnector accountConnector = AccountConnector.newBuilder().build();
      String accountConnectorId = "accountConnectorId-605811237";
      client.createAccountConnectorAsync(parent, accountConnector, accountConnectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAccountConnectorTest2() throws Exception {
    AccountConnector expectedResponse =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccountConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AccountConnector accountConnector = AccountConnector.newBuilder().build();
    String accountConnectorId = "accountConnectorId-605811237";

    AccountConnector actualResponse =
        client.createAccountConnectorAsync(parent, accountConnector, accountConnectorId).get();
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
  public void createAccountConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AccountConnector accountConnector = AccountConnector.newBuilder().build();
      String accountConnectorId = "accountConnectorId-605811237";
      client.createAccountConnectorAsync(parent, accountConnector, accountConnectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAccountConnectorTest() throws Exception {
    AccountConnector expectedResponse =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAccountConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AccountConnector accountConnector =
        AccountConnector.newBuilder()
            .setName(
                AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setOauthStartUri("oauthStartUri-1592753823")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccountConnector actualResponse =
        client.updateAccountConnectorAsync(accountConnector, updateMask).get();
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
  public void updateAccountConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnector accountConnector =
          AccountConnector.newBuilder()
              .setName(
                  AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllAnnotations(new HashMap<String, String>())
              .setEtag("etag3123477")
              .putAllLabels(new HashMap<String, String>())
              .setOauthStartUri("oauthStartUri-1592753823")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccountConnectorAsync(accountConnector, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAccountConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccountConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AccountConnectorName name =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    client.deleteAccountConnectorAsync(name).get();

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
  public void deleteAccountConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName name =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.deleteAccountConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAccountConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccountConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";

    client.deleteAccountConnectorAsync(name).get();

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
  public void deleteAccountConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";
      client.deleteAccountConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchAccessTokenTest() throws Exception {
    FetchAccessTokenResponse expectedResponse =
        FetchAccessTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .addAllScopes(new ArrayList<String>())
            .setExchangeError(ExchangeError.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountConnectorName accountConnector =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    FetchAccessTokenResponse actualResponse = client.fetchAccessToken(accountConnector);
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
  public void fetchAccessTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName accountConnector =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.fetchAccessToken(accountConnector);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchAccessTokenTest2() throws Exception {
    FetchAccessTokenResponse expectedResponse =
        FetchAccessTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .addAllScopes(new ArrayList<String>())
            .setExchangeError(ExchangeError.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String accountConnector =
        "projects/project-5342/locations/location-5342/accountConnectors/accountConnector-5342";

    FetchAccessTokenResponse actualResponse = client.fetchAccessToken(accountConnector);
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
  public void fetchAccessTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String accountConnector =
          "projects/project-5342/locations/location-5342/accountConnectors/accountConnector-5342";
      client.fetchAccessToken(accountConnector);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsersTest() throws Exception {
    User responsesElement = User.newBuilder().build();
    ListUsersResponse expectedResponse =
        ListUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountConnectorName parent =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    ListUsersPagedResponse pagedListResponse = client.listUsers(parent);

    List<User> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsersList().get(0), resources.get(0));

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
  public void listUsersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName parent =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.listUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsersTest2() throws Exception {
    User responsesElement = User.newBuilder().build();
    ListUsersResponse expectedResponse =
        ListUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2472/locations/location-2472/accountConnectors/accountConnector-2472";

    ListUsersPagedResponse pagedListResponse = client.listUsers(parent);

    List<User> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsersList().get(0), resources.get(0));

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
  public void listUsersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2472/locations/location-2472/accountConnectors/accountConnector-2472";
      client.listUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UserName name = UserName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]", "[USER]");

    client.deleteUserAsync(name).get();

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
  public void deleteUserExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserName name = UserName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]", "[USER]");
      client.deleteUserAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteUserTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8611/locations/location-8611/accountConnectors/accountConnector-8611/users/user-8611";

    client.deleteUserAsync(name).get();

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
  public void deleteUserExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8611/locations/location-8611/accountConnectors/accountConnector-8611/users/user-8611";
      client.deleteUserAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchSelfTest() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(
                UserName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]", "[USER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastTokenRequestTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountConnectorName name =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    User actualResponse = client.fetchSelf(name);
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
  public void fetchSelfExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName name =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.fetchSelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchSelfTest2() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(
                UserName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]", "[USER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastTokenRequestTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";

    User actualResponse = client.fetchSelf(name);
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
  public void fetchSelfExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";
      client.fetchSelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSelfTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSelfTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AccountConnectorName name =
        AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");

    client.deleteSelfAsync(name).get();

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
  public void deleteSelfExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountConnectorName name =
          AccountConnectorName.of("[PROJECT]", "[LOCATION]", "[ACCOUNT_CONNECTOR]");
      client.deleteSelfAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSelfTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSelfTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";

    client.deleteSelfAsync(name).get();

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
  public void deleteSelfExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1769/locations/location-1769/accountConnectors/accountConnector-1769";
      client.deleteSelfAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
