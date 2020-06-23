/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigqueryconnection.v1;

import static com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient.ListConnectionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.ConnectionName;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1.GetConnectionRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsResponse;
import com.google.cloud.bigquery.connection.v1.LocationName;
import com.google.cloud.bigquery.connection.v1.UpdateConnectionRequest;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ConnectionServiceClientTest {
  private static MockConnectionService mockConnectionService;
  private static MockServiceHelper serviceHelper;
  private ConnectionServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockConnectionService = new MockConnectionService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockConnectionService));
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
    ConnectionServiceSettings settings =
        ConnectionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConnectionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createConnectionTest() {
    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    String friendlyName = "friendlyName1451097503";
    String description = "description-1724546052";
    long creationTime = 1932333101L;
    long lastModifiedTime = 671513446L;
    boolean hasCredential = true;
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(name.toString())
            .setFriendlyName(friendlyName)
            .setDescription(description)
            .setCreationTime(creationTime)
            .setLastModifiedTime(lastModifiedTime)
            .setHasCredential(hasCredential)
            .build();
    mockConnectionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId-513204708";

    Connection actualResponse = client.createConnection(parent, connection, connectionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionRequest actualRequest = (CreateConnectionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertEquals(connectionId, actualRequest.getConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId-513204708";

      client.createConnection(parent, connection, connectionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getConnectionTest() {
    ConnectionName name2 = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    String friendlyName = "friendlyName1451097503";
    String description = "description-1724546052";
    long creationTime = 1932333101L;
    long lastModifiedTime = 671513446L;
    boolean hasCredential = true;
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(name2.toString())
            .setFriendlyName(friendlyName)
            .setDescription(description)
            .setCreationTime(creationTime)
            .setLastModifiedTime(lastModifiedTime)
            .setHasCredential(hasCredential)
            .build();
    mockConnectionService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    Connection actualResponse = client.getConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionRequest actualRequest = (GetConnectionRequest) actualRequests.get(0);

    Assert.assertEquals(name, ConnectionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

      client.getConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listConnectionsTest() {
    String nextPageToken = "";
    Connection connectionsElement = Connection.newBuilder().build();
    List<Connection> connections = Arrays.asList(connectionsElement);
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllConnections(connections)
            .build();
    mockConnectionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionsRequest actualRequest = (ListConnectionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateConnectionTest() {
    ConnectionName name2 = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    String friendlyName = "friendlyName1451097503";
    String description = "description-1724546052";
    long creationTime = 1932333101L;
    long lastModifiedTime = 671513446L;
    boolean hasCredential = true;
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(name2.toString())
            .setFriendlyName(friendlyName)
            .setDescription(description)
            .setCreationTime(creationTime)
            .setLastModifiedTime(lastModifiedTime)
            .setHasCredential(hasCredential)
            .build();
    mockConnectionService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    Connection connection = Connection.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connection actualResponse = client.updateConnection(name, connection, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectionRequest actualRequest = (UpdateConnectionRequest) actualRequests.get(0);

    Assert.assertEquals(name, ConnectionName.parse(actualRequest.getName()));
    Assert.assertEquals(connection, actualRequest.getConnection());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      Connection connection = Connection.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateConnection(name, connection, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteConnectionTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConnectionService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    client.deleteConnection(name);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionRequest actualRequest = (DeleteConnectionRequest) actualRequests.get(0);

    Assert.assertEquals(name, ConnectionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

      client.deleteConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockConnectionService.addResponse(expectedResponse);

    ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    GetPolicyOptions options = GetPolicyOptions.newBuilder().build();

    Policy actualResponse = client.getIamPolicy(resource, options);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(options, actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      GetPolicyOptions options = GetPolicyOptions.newBuilder().build();

      client.getIamPolicy(resource, options);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockConnectionService.addResponse(expectedResponse);

    ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockConnectionService.addResponse(expectedResponse);

    ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      ResourceName resource = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
