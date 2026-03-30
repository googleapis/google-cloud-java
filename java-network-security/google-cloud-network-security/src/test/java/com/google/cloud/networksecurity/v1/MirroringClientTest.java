/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.MirroringClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupsPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class MirroringClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockMirroring mockMirroring;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MirroringClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMirroring = new MockMirroring();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMirroring, mockLocations, mockIAMPolicy));
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
    MirroringSettings settings =
        MirroringSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MirroringClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMirroringEndpointGroupsTest() throws Exception {
    MirroringEndpointGroup responsesElement = MirroringEndpointGroup.newBuilder().build();
    ListMirroringEndpointGroupsResponse expectedResponse =
        ListMirroringEndpointGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringEndpointGroups(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMirroringEndpointGroupsPagedResponse pagedListResponse =
        client.listMirroringEndpointGroups(parent);

    List<MirroringEndpointGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirroringEndpointGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringEndpointGroupsRequest actualRequest =
        ((ListMirroringEndpointGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringEndpointGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMirroringEndpointGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirroringEndpointGroupsTest2() throws Exception {
    MirroringEndpointGroup responsesElement = MirroringEndpointGroup.newBuilder().build();
    ListMirroringEndpointGroupsResponse expectedResponse =
        ListMirroringEndpointGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringEndpointGroups(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMirroringEndpointGroupsPagedResponse pagedListResponse =
        client.listMirroringEndpointGroups(parent);

    List<MirroringEndpointGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirroringEndpointGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringEndpointGroupsRequest actualRequest =
        ((ListMirroringEndpointGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringEndpointGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMirroringEndpointGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringEndpointGroupTest() throws Exception {
    MirroringEndpointGroup expectedResponse =
        MirroringEndpointGroup.newBuilder()
            .setName(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .addAllConnectedDeploymentGroups(
                new ArrayList<MirroringEndpointGroup.ConnectedDeploymentGroup>())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<MirroringEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    mockMirroring.addResponse(expectedResponse);

    MirroringEndpointGroupName name =
        MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");

    MirroringEndpointGroup actualResponse = client.getMirroringEndpointGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringEndpointGroupRequest actualRequest =
        ((GetMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroupName name =
          MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
      client.getMirroringEndpointGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringEndpointGroupTest2() throws Exception {
    MirroringEndpointGroup expectedResponse =
        MirroringEndpointGroup.newBuilder()
            .setName(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .addAllConnectedDeploymentGroups(
                new ArrayList<MirroringEndpointGroup.ConnectedDeploymentGroup>())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<MirroringEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    mockMirroring.addResponse(expectedResponse);

    String name = "name3373707";

    MirroringEndpointGroup actualResponse = client.getMirroringEndpointGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringEndpointGroupRequest actualRequest =
        ((GetMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.getMirroringEndpointGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMirroringEndpointGroupTest() throws Exception {
    MirroringEndpointGroup expectedResponse =
        MirroringEndpointGroup.newBuilder()
            .setName(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .addAllConnectedDeploymentGroups(
                new ArrayList<MirroringEndpointGroup.ConnectedDeploymentGroup>())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<MirroringEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
    String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";

    MirroringEndpointGroup actualResponse =
        client
            .createMirroringEndpointGroupAsync(
                parent, mirroringEndpointGroup, mirroringEndpointGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringEndpointGroupRequest actualRequest =
        ((CreateMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mirroringEndpointGroup, actualRequest.getMirroringEndpointGroup());
    Assert.assertEquals(mirroringEndpointGroupId, actualRequest.getMirroringEndpointGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
      String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";
      client
          .createMirroringEndpointGroupAsync(
              parent, mirroringEndpointGroup, mirroringEndpointGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirroringEndpointGroupTest2() throws Exception {
    MirroringEndpointGroup expectedResponse =
        MirroringEndpointGroup.newBuilder()
            .setName(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .addAllConnectedDeploymentGroups(
                new ArrayList<MirroringEndpointGroup.ConnectedDeploymentGroup>())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<MirroringEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String parent = "parent-995424086";
    MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
    String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";

    MirroringEndpointGroup actualResponse =
        client
            .createMirroringEndpointGroupAsync(
                parent, mirroringEndpointGroup, mirroringEndpointGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringEndpointGroupRequest actualRequest =
        ((CreateMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mirroringEndpointGroup, actualRequest.getMirroringEndpointGroup());
    Assert.assertEquals(mirroringEndpointGroupId, actualRequest.getMirroringEndpointGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
      String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";
      client
          .createMirroringEndpointGroupAsync(
              parent, mirroringEndpointGroup, mirroringEndpointGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMirroringEndpointGroupTest() throws Exception {
    MirroringEndpointGroup expectedResponse =
        MirroringEndpointGroup.newBuilder()
            .setName(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .addAllConnectedDeploymentGroups(
                new ArrayList<MirroringEndpointGroup.ConnectedDeploymentGroup>())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<MirroringEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMirroringEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MirroringEndpointGroup actualResponse =
        client.updateMirroringEndpointGroupAsync(mirroringEndpointGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMirroringEndpointGroupRequest actualRequest =
        ((UpdateMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(mirroringEndpointGroup, actualRequest.getMirroringEndpointGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMirroringEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMirroringEndpointGroupAsync(mirroringEndpointGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringEndpointGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringEndpointGroupName name =
        MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");

    client.deleteMirroringEndpointGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringEndpointGroupRequest actualRequest =
        ((DeleteMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroupName name =
          MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
      client.deleteMirroringEndpointGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringEndpointGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMirroringEndpointGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringEndpointGroupRequest actualRequest =
        ((DeleteMirroringEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMirroringEndpointGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMirroringEndpointGroupAssociationsTest() throws Exception {
    MirroringEndpointGroupAssociation responsesElement =
        MirroringEndpointGroupAssociation.newBuilder().build();
    ListMirroringEndpointGroupAssociationsResponse expectedResponse =
        ListMirroringEndpointGroupAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringEndpointGroupAssociations(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMirroringEndpointGroupAssociationsPagedResponse pagedListResponse =
        client.listMirroringEndpointGroupAssociations(parent);

    List<MirroringEndpointGroupAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMirroringEndpointGroupAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringEndpointGroupAssociationsRequest actualRequest =
        ((ListMirroringEndpointGroupAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringEndpointGroupAssociationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMirroringEndpointGroupAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirroringEndpointGroupAssociationsTest2() throws Exception {
    MirroringEndpointGroupAssociation responsesElement =
        MirroringEndpointGroupAssociation.newBuilder().build();
    ListMirroringEndpointGroupAssociationsResponse expectedResponse =
        ListMirroringEndpointGroupAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringEndpointGroupAssociations(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMirroringEndpointGroupAssociationsPagedResponse pagedListResponse =
        client.listMirroringEndpointGroupAssociations(parent);

    List<MirroringEndpointGroupAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMirroringEndpointGroupAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringEndpointGroupAssociationsRequest actualRequest =
        ((ListMirroringEndpointGroupAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringEndpointGroupAssociationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMirroringEndpointGroupAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringEndpointGroupAssociationTest() throws Exception {
    MirroringEndpointGroupAssociation expectedResponse =
        MirroringEndpointGroupAssociation.newBuilder()
            .setName(
                MirroringEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringEndpointGroup(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<MirroringEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    mockMirroring.addResponse(expectedResponse);

    MirroringEndpointGroupAssociationName name =
        MirroringEndpointGroupAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");

    MirroringEndpointGroupAssociation actualResponse =
        client.getMirroringEndpointGroupAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringEndpointGroupAssociationRequest actualRequest =
        ((GetMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroupAssociationName name =
          MirroringEndpointGroupAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");
      client.getMirroringEndpointGroupAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringEndpointGroupAssociationTest2() throws Exception {
    MirroringEndpointGroupAssociation expectedResponse =
        MirroringEndpointGroupAssociation.newBuilder()
            .setName(
                MirroringEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringEndpointGroup(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<MirroringEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    mockMirroring.addResponse(expectedResponse);

    String name = "name3373707";

    MirroringEndpointGroupAssociation actualResponse =
        client.getMirroringEndpointGroupAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringEndpointGroupAssociationRequest actualRequest =
        ((GetMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.getMirroringEndpointGroupAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMirroringEndpointGroupAssociationTest() throws Exception {
    MirroringEndpointGroupAssociation expectedResponse =
        MirroringEndpointGroupAssociation.newBuilder()
            .setName(
                MirroringEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringEndpointGroup(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<MirroringEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
        MirroringEndpointGroupAssociation.newBuilder().build();
    String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";

    MirroringEndpointGroupAssociation actualResponse =
        client
            .createMirroringEndpointGroupAssociationAsync(
                parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringEndpointGroupAssociationRequest actualRequest =
        ((CreateMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        mirroringEndpointGroupAssociation, actualRequest.getMirroringEndpointGroupAssociation());
    Assert.assertEquals(
        mirroringEndpointGroupAssociationId,
        actualRequest.getMirroringEndpointGroupAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
          MirroringEndpointGroupAssociation.newBuilder().build();
      String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";
      client
          .createMirroringEndpointGroupAssociationAsync(
              parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirroringEndpointGroupAssociationTest2() throws Exception {
    MirroringEndpointGroupAssociation expectedResponse =
        MirroringEndpointGroupAssociation.newBuilder()
            .setName(
                MirroringEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringEndpointGroup(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<MirroringEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String parent = "parent-995424086";
    MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
        MirroringEndpointGroupAssociation.newBuilder().build();
    String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";

    MirroringEndpointGroupAssociation actualResponse =
        client
            .createMirroringEndpointGroupAssociationAsync(
                parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringEndpointGroupAssociationRequest actualRequest =
        ((CreateMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        mirroringEndpointGroupAssociation, actualRequest.getMirroringEndpointGroupAssociation());
    Assert.assertEquals(
        mirroringEndpointGroupAssociationId,
        actualRequest.getMirroringEndpointGroupAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
          MirroringEndpointGroupAssociation.newBuilder().build();
      String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";
      client
          .createMirroringEndpointGroupAssociationAsync(
              parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMirroringEndpointGroupAssociationTest() throws Exception {
    MirroringEndpointGroupAssociation expectedResponse =
        MirroringEndpointGroupAssociation.newBuilder()
            .setName(
                MirroringEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setMirroringEndpointGroup(
                MirroringEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<MirroringEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMirroringEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
        MirroringEndpointGroupAssociation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MirroringEndpointGroupAssociation actualResponse =
        client
            .updateMirroringEndpointGroupAssociationAsync(
                mirroringEndpointGroupAssociation, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMirroringEndpointGroupAssociationRequest actualRequest =
        ((UpdateMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(
        mirroringEndpointGroupAssociation, actualRequest.getMirroringEndpointGroupAssociation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMirroringEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
          MirroringEndpointGroupAssociation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updateMirroringEndpointGroupAssociationAsync(
              mirroringEndpointGroupAssociation, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringEndpointGroupAssociationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringEndpointGroupAssociationName name =
        MirroringEndpointGroupAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");

    client.deleteMirroringEndpointGroupAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringEndpointGroupAssociationRequest actualRequest =
        ((DeleteMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringEndpointGroupAssociationName name =
          MirroringEndpointGroupAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");
      client.deleteMirroringEndpointGroupAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringEndpointGroupAssociationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMirroringEndpointGroupAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringEndpointGroupAssociationRequest actualRequest =
        ((DeleteMirroringEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMirroringEndpointGroupAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMirroringDeploymentGroupsTest() throws Exception {
    MirroringDeploymentGroup responsesElement = MirroringDeploymentGroup.newBuilder().build();
    ListMirroringDeploymentGroupsResponse expectedResponse =
        ListMirroringDeploymentGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringDeploymentGroups(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMirroringDeploymentGroupsPagedResponse pagedListResponse =
        client.listMirroringDeploymentGroups(parent);

    List<MirroringDeploymentGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMirroringDeploymentGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringDeploymentGroupsRequest actualRequest =
        ((ListMirroringDeploymentGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringDeploymentGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMirroringDeploymentGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirroringDeploymentGroupsTest2() throws Exception {
    MirroringDeploymentGroup responsesElement = MirroringDeploymentGroup.newBuilder().build();
    ListMirroringDeploymentGroupsResponse expectedResponse =
        ListMirroringDeploymentGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringDeploymentGroups(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMirroringDeploymentGroupsPagedResponse pagedListResponse =
        client.listMirroringDeploymentGroups(parent);

    List<MirroringDeploymentGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMirroringDeploymentGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringDeploymentGroupsRequest actualRequest =
        ((ListMirroringDeploymentGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringDeploymentGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMirroringDeploymentGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringDeploymentGroupTest() throws Exception {
    MirroringDeploymentGroup expectedResponse =
        MirroringDeploymentGroup.newBuilder()
            .setName(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<MirroringDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<MirroringDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    mockMirroring.addResponse(expectedResponse);

    MirroringDeploymentGroupName name =
        MirroringDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");

    MirroringDeploymentGroup actualResponse = client.getMirroringDeploymentGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringDeploymentGroupRequest actualRequest =
        ((GetMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeploymentGroupName name =
          MirroringDeploymentGroupName.of(
              "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");
      client.getMirroringDeploymentGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringDeploymentGroupTest2() throws Exception {
    MirroringDeploymentGroup expectedResponse =
        MirroringDeploymentGroup.newBuilder()
            .setName(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<MirroringDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<MirroringDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    mockMirroring.addResponse(expectedResponse);

    String name = "name3373707";

    MirroringDeploymentGroup actualResponse = client.getMirroringDeploymentGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringDeploymentGroupRequest actualRequest =
        ((GetMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.getMirroringDeploymentGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMirroringDeploymentGroupTest() throws Exception {
    MirroringDeploymentGroup expectedResponse =
        MirroringDeploymentGroup.newBuilder()
            .setName(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<MirroringDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<MirroringDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MirroringDeploymentGroup mirroringDeploymentGroup =
        MirroringDeploymentGroup.newBuilder().build();
    String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";

    MirroringDeploymentGroup actualResponse =
        client
            .createMirroringDeploymentGroupAsync(
                parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringDeploymentGroupRequest actualRequest =
        ((CreateMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mirroringDeploymentGroup, actualRequest.getMirroringDeploymentGroup());
    Assert.assertEquals(mirroringDeploymentGroupId, actualRequest.getMirroringDeploymentGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MirroringDeploymentGroup mirroringDeploymentGroup =
          MirroringDeploymentGroup.newBuilder().build();
      String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";
      client
          .createMirroringDeploymentGroupAsync(
              parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirroringDeploymentGroupTest2() throws Exception {
    MirroringDeploymentGroup expectedResponse =
        MirroringDeploymentGroup.newBuilder()
            .setName(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<MirroringDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<MirroringDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String parent = "parent-995424086";
    MirroringDeploymentGroup mirroringDeploymentGroup =
        MirroringDeploymentGroup.newBuilder().build();
    String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";

    MirroringDeploymentGroup actualResponse =
        client
            .createMirroringDeploymentGroupAsync(
                parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringDeploymentGroupRequest actualRequest =
        ((CreateMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mirroringDeploymentGroup, actualRequest.getMirroringDeploymentGroup());
    Assert.assertEquals(mirroringDeploymentGroupId, actualRequest.getMirroringDeploymentGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      MirroringDeploymentGroup mirroringDeploymentGroup =
          MirroringDeploymentGroup.newBuilder().build();
      String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";
      client
          .createMirroringDeploymentGroupAsync(
              parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMirroringDeploymentGroupTest() throws Exception {
    MirroringDeploymentGroup expectedResponse =
        MirroringDeploymentGroup.newBuilder()
            .setName(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<MirroringDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<MirroringDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<MirroringLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMirroringDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringDeploymentGroup mirroringDeploymentGroup =
        MirroringDeploymentGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MirroringDeploymentGroup actualResponse =
        client.updateMirroringDeploymentGroupAsync(mirroringDeploymentGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMirroringDeploymentGroupRequest actualRequest =
        ((UpdateMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(mirroringDeploymentGroup, actualRequest.getMirroringDeploymentGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMirroringDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeploymentGroup mirroringDeploymentGroup =
          MirroringDeploymentGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMirroringDeploymentGroupAsync(mirroringDeploymentGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringDeploymentGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringDeploymentGroupName name =
        MirroringDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");

    client.deleteMirroringDeploymentGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringDeploymentGroupRequest actualRequest =
        ((DeleteMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeploymentGroupName name =
          MirroringDeploymentGroupName.of(
              "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");
      client.deleteMirroringDeploymentGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringDeploymentGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMirroringDeploymentGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringDeploymentGroupRequest actualRequest =
        ((DeleteMirroringDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMirroringDeploymentGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMirroringDeploymentsTest() throws Exception {
    MirroringDeployment responsesElement = MirroringDeployment.newBuilder().build();
    ListMirroringDeploymentsResponse expectedResponse =
        ListMirroringDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringDeployments(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMirroringDeploymentsPagedResponse pagedListResponse =
        client.listMirroringDeployments(parent);

    List<MirroringDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirroringDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringDeploymentsRequest actualRequest =
        ((ListMirroringDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMirroringDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirroringDeploymentsTest2() throws Exception {
    MirroringDeployment responsesElement = MirroringDeployment.newBuilder().build();
    ListMirroringDeploymentsResponse expectedResponse =
        ListMirroringDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirroringDeployments(Arrays.asList(responsesElement))
            .build();
    mockMirroring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMirroringDeploymentsPagedResponse pagedListResponse =
        client.listMirroringDeployments(parent);

    List<MirroringDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirroringDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirroringDeploymentsRequest actualRequest =
        ((ListMirroringDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirroringDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMirroringDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringDeploymentTest() throws Exception {
    MirroringDeployment expectedResponse =
        MirroringDeployment.newBuilder()
            .setName(
                MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    mockMirroring.addResponse(expectedResponse);

    MirroringDeploymentName name =
        MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");

    MirroringDeployment actualResponse = client.getMirroringDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringDeploymentRequest actualRequest =
        ((GetMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeploymentName name =
          MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");
      client.getMirroringDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirroringDeploymentTest2() throws Exception {
    MirroringDeployment expectedResponse =
        MirroringDeployment.newBuilder()
            .setName(
                MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    mockMirroring.addResponse(expectedResponse);

    String name = "name3373707";

    MirroringDeployment actualResponse = client.getMirroringDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirroringDeploymentRequest actualRequest =
        ((GetMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirroringDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.getMirroringDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMirroringDeploymentTest() throws Exception {
    MirroringDeployment expectedResponse =
        MirroringDeployment.newBuilder()
            .setName(
                MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
    String mirroringDeploymentId = "mirroringDeploymentId-895939037";

    MirroringDeployment actualResponse =
        client
            .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringDeploymentRequest actualRequest =
        ((CreateMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mirroringDeployment, actualRequest.getMirroringDeployment());
    Assert.assertEquals(mirroringDeploymentId, actualRequest.getMirroringDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
      String mirroringDeploymentId = "mirroringDeploymentId-895939037";
      client
          .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirroringDeploymentTest2() throws Exception {
    MirroringDeployment expectedResponse =
        MirroringDeployment.newBuilder()
            .setName(
                MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirroringDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String parent = "parent-995424086";
    MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
    String mirroringDeploymentId = "mirroringDeploymentId-895939037";

    MirroringDeployment actualResponse =
        client
            .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirroringDeploymentRequest actualRequest =
        ((CreateMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mirroringDeployment, actualRequest.getMirroringDeployment());
    Assert.assertEquals(mirroringDeploymentId, actualRequest.getMirroringDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirroringDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String parent = "parent-995424086";
      MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
      String mirroringDeploymentId = "mirroringDeploymentId-895939037";
      client
          .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMirroringDeploymentTest() throws Exception {
    MirroringDeployment expectedResponse =
        MirroringDeployment.newBuilder()
            .setName(
                MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setMirroringDeploymentGroup(
                MirroringDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMirroringDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MirroringDeployment actualResponse =
        client.updateMirroringDeploymentAsync(mirroringDeployment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMirroringDeploymentRequest actualRequest =
        ((UpdateMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(mirroringDeployment, actualRequest.getMirroringDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMirroringDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMirroringDeploymentAsync(mirroringDeployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    MirroringDeploymentName name =
        MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");

    client.deleteMirroringDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringDeploymentRequest actualRequest =
        ((DeleteMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      MirroringDeploymentName name =
          MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");
      client.deleteMirroringDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirroringDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirroringDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMirroring.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMirroringDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockMirroring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirroringDeploymentRequest actualRequest =
        ((DeleteMirroringDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirroringDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMirroring.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMirroringDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
