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

package com.google.cloud.developerconnect.v1;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeveloperConnectClientTest {
  private static MockDeveloperConnect mockDeveloperConnect;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeveloperConnectClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeveloperConnect = new MockDeveloperConnect();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDeveloperConnect, mockLocations));
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
    DeveloperConnectSettings settings =
        DeveloperConnectSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeveloperConnectClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConnectionsTest() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockDeveloperConnect.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionsRequest actualRequest = ((ListConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionsRequest actualRequest = ((ListConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    mockDeveloperConnect.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    Connection actualResponse = client.getConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionRequest actualRequest = ((GetConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
            .build();
    mockDeveloperConnect.addResponse(expectedResponse);

    String name = "name3373707";

    Connection actualResponse = client.getConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionRequest actualRequest = ((GetConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String name = "name3373707";
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeveloperConnect.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse =
        client.createConnectionAsync(parent, connection, connectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionRequest actualRequest = ((CreateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertEquals(connectionId, actualRequest.getConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnectionAsync(parent, connection, connectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeveloperConnect.addResponse(resultOperation);

    String parent = "parent-995424086";
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse =
        client.createConnectionAsync(parent, connection, connectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionRequest actualRequest = ((CreateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertEquals(connectionId, actualRequest.getConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnectionAsync(parent, connection, connectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeveloperConnect.addResponse(resultOperation);

    Connection connection = Connection.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connection actualResponse = client.updateConnectionAsync(connection, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectionRequest actualRequest = ((UpdateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      Connection connection = Connection.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectionAsync(connection, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDeveloperConnect.addResponse(resultOperation);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    client.deleteConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionRequest actualRequest = ((DeleteConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.deleteConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDeveloperConnect.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionRequest actualRequest = ((DeleteConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeveloperConnect.addResponse(resultOperation);

    ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
    String gitRepositoryLinkId = "gitRepositoryLinkId684669585";

    GitRepositoryLink actualResponse =
        client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGitRepositoryLinkRequest actualRequest =
        ((CreateGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gitRepositoryLink, actualRequest.getGitRepositoryLink());
    Assert.assertEquals(gitRepositoryLinkId, actualRequest.getGitRepositoryLinkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGitRepositoryLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
      String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
      client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGitRepositoryLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeveloperConnect.addResponse(resultOperation);

    String parent = "parent-995424086";
    GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
    String gitRepositoryLinkId = "gitRepositoryLinkId684669585";

    GitRepositoryLink actualResponse =
        client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGitRepositoryLinkRequest actualRequest =
        ((CreateGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gitRepositoryLink, actualRequest.getGitRepositoryLink());
    Assert.assertEquals(gitRepositoryLinkId, actualRequest.getGitRepositoryLinkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGitRepositoryLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
      String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
      client.createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDeveloperConnect.addResponse(resultOperation);

    GitRepositoryLinkName name =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    client.deleteGitRepositoryLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGitRepositoryLinkRequest actualRequest =
        ((DeleteGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGitRepositoryLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      GitRepositoryLinkName name =
          GitRepositoryLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
      client.deleteGitRepositoryLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDeveloperConnect.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGitRepositoryLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGitRepositoryLinkRequest actualRequest =
        ((DeleteGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGitRepositoryLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGitRepositoryLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDeveloperConnect.addResponse(expectedResponse);

    ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    ListGitRepositoryLinksPagedResponse pagedListResponse = client.listGitRepositoryLinks(parent);

    List<GitRepositoryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGitRepositoryLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGitRepositoryLinksRequest actualRequest =
        ((ListGitRepositoryLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGitRepositoryLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGitRepositoryLinksPagedResponse pagedListResponse = client.listGitRepositoryLinks(parent);

    List<GitRepositoryLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGitRepositoryLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGitRepositoryLinksRequest actualRequest =
        ((ListGitRepositoryLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGitRepositoryLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    mockDeveloperConnect.addResponse(expectedResponse);

    GitRepositoryLinkName name =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    GitRepositoryLink actualResponse = client.getGitRepositoryLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGitRepositoryLinkRequest actualRequest =
        ((GetGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGitRepositoryLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
            .build();
    mockDeveloperConnect.addResponse(expectedResponse);

    String name = "name3373707";

    GitRepositoryLink actualResponse = client.getGitRepositoryLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGitRepositoryLinkRequest actualRequest =
        ((GetGitRepositoryLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGitRepositoryLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeveloperConnect.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    FetchReadWriteTokenResponse actualResponse = client.fetchReadWriteToken(gitRepositoryLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReadWriteTokenRequest actualRequest = ((FetchReadWriteTokenRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink.toString(), actualRequest.getGitRepositoryLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReadWriteTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String gitRepositoryLink = "gitRepositoryLink1752665814";

    FetchReadWriteTokenResponse actualResponse = client.fetchReadWriteToken(gitRepositoryLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReadWriteTokenRequest actualRequest = ((FetchReadWriteTokenRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink, actualRequest.getGitRepositoryLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReadWriteTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String gitRepositoryLink = "gitRepositoryLink1752665814";
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
    mockDeveloperConnect.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");

    FetchReadTokenResponse actualResponse = client.fetchReadToken(gitRepositoryLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReadTokenRequest actualRequest = ((FetchReadTokenRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink.toString(), actualRequest.getGitRepositoryLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReadTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String gitRepositoryLink = "gitRepositoryLink1752665814";

    FetchReadTokenResponse actualResponse = client.fetchReadToken(gitRepositoryLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReadTokenRequest actualRequest = ((FetchReadTokenRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink, actualRequest.getGitRepositoryLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReadTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String gitRepositoryLink = "gitRepositoryLink1752665814";
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
    mockDeveloperConnect.addResponse(expectedResponse);

    ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    FetchLinkableGitRepositoriesPagedResponse pagedListResponse =
        client.fetchLinkableGitRepositories(connection);

    List<LinkableGitRepository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinkableGitRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchLinkableGitRepositoriesRequest actualRequest =
        ((FetchLinkableGitRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(connection.toString(), actualRequest.getConnection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchLinkableGitRepositoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String connection = "connection-775651618";

    FetchLinkableGitRepositoriesPagedResponse pagedListResponse =
        client.fetchLinkableGitRepositories(connection);

    List<LinkableGitRepository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinkableGitRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchLinkableGitRepositoriesRequest actualRequest =
        ((FetchLinkableGitRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchLinkableGitRepositoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String connection = "connection-775651618";
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
    mockDeveloperConnect.addResponse(expectedResponse);

    ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    FetchGitHubInstallationsResponse actualResponse = client.fetchGitHubInstallations(connection);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchGitHubInstallationsRequest actualRequest =
        ((FetchGitHubInstallationsRequest) actualRequests.get(0));

    Assert.assertEquals(connection.toString(), actualRequest.getConnection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchGitHubInstallationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String connection = "connection-775651618";

    FetchGitHubInstallationsResponse actualResponse = client.fetchGitHubInstallations(connection);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchGitHubInstallationsRequest actualRequest =
        ((FetchGitHubInstallationsRequest) actualRequests.get(0));

    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchGitHubInstallationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String connection = "connection-775651618";
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
    mockDeveloperConnect.addResponse(expectedResponse);

    GitRepositoryLinkName gitRepositoryLink =
        GitRepositoryLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
    FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);

    FetchGitRefsPagedResponse pagedListResponse = client.fetchGitRefs(gitRepositoryLink, refType);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRefNamesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchGitRefsRequest actualRequest = ((FetchGitRefsRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink.toString(), actualRequest.getGitRepositoryLink());
    Assert.assertEquals(refType, actualRequest.getRefType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchGitRefsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

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
    mockDeveloperConnect.addResponse(expectedResponse);

    String gitRepositoryLink = "gitRepositoryLink1752665814";
    FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);

    FetchGitRefsPagedResponse pagedListResponse = client.fetchGitRefs(gitRepositoryLink, refType);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRefNamesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchGitRefsRequest actualRequest = ((FetchGitRefsRequest) actualRequests.get(0));

    Assert.assertEquals(gitRepositoryLink, actualRequest.getGitRepositoryLink());
    Assert.assertEquals(refType, actualRequest.getRefType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchGitRefsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperConnect.addException(exception);

    try {
      String gitRepositoryLink = "gitRepositoryLink1752665814";
      FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);
      client.fetchGitRefs(gitRepositoryLink, refType);
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
