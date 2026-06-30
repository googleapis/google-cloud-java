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

import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListLocationsPagedResponse;

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
public class InterceptClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockIntercept mockIntercept;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private InterceptClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIntercept = new MockIntercept();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIntercept, mockLocations, mockIAMPolicy));
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
    InterceptSettings settings =
        InterceptSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InterceptClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listInterceptEndpointGroupsTest() throws Exception {
    InterceptEndpointGroup responsesElement = InterceptEndpointGroup.newBuilder().build();
    ListInterceptEndpointGroupsResponse expectedResponse =
        ListInterceptEndpointGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptEndpointGroups(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInterceptEndpointGroupsPagedResponse pagedListResponse =
        client.listInterceptEndpointGroups(parent);

    List<InterceptEndpointGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterceptEndpointGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptEndpointGroupsRequest actualRequest =
        ((ListInterceptEndpointGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptEndpointGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInterceptEndpointGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterceptEndpointGroupsTest2() throws Exception {
    InterceptEndpointGroup responsesElement = InterceptEndpointGroup.newBuilder().build();
    ListInterceptEndpointGroupsResponse expectedResponse =
        ListInterceptEndpointGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptEndpointGroups(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterceptEndpointGroupsPagedResponse pagedListResponse =
        client.listInterceptEndpointGroups(parent);

    List<InterceptEndpointGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterceptEndpointGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptEndpointGroupsRequest actualRequest =
        ((ListInterceptEndpointGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptEndpointGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterceptEndpointGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptEndpointGroupTest() throws Exception {
    InterceptEndpointGroup expectedResponse =
        InterceptEndpointGroup.newBuilder()
            .setName(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setConnectedDeploymentGroup(
                InterceptEndpointGroup.ConnectedDeploymentGroup.newBuilder().build())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<InterceptEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    mockIntercept.addResponse(expectedResponse);

    InterceptEndpointGroupName name =
        InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");

    InterceptEndpointGroup actualResponse = client.getInterceptEndpointGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptEndpointGroupRequest actualRequest =
        ((GetInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroupName name =
          InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
      client.getInterceptEndpointGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptEndpointGroupTest2() throws Exception {
    InterceptEndpointGroup expectedResponse =
        InterceptEndpointGroup.newBuilder()
            .setName(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setConnectedDeploymentGroup(
                InterceptEndpointGroup.ConnectedDeploymentGroup.newBuilder().build())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<InterceptEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    mockIntercept.addResponse(expectedResponse);

    String name = "name3373707";

    InterceptEndpointGroup actualResponse = client.getInterceptEndpointGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptEndpointGroupRequest actualRequest =
        ((GetInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.getInterceptEndpointGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInterceptEndpointGroupTest() throws Exception {
    InterceptEndpointGroup expectedResponse =
        InterceptEndpointGroup.newBuilder()
            .setName(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setConnectedDeploymentGroup(
                InterceptEndpointGroup.ConnectedDeploymentGroup.newBuilder().build())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<InterceptEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
    String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";

    InterceptEndpointGroup actualResponse =
        client
            .createInterceptEndpointGroupAsync(
                parent, interceptEndpointGroup, interceptEndpointGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptEndpointGroupRequest actualRequest =
        ((CreateInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(interceptEndpointGroup, actualRequest.getInterceptEndpointGroup());
    Assert.assertEquals(interceptEndpointGroupId, actualRequest.getInterceptEndpointGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
      String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";
      client
          .createInterceptEndpointGroupAsync(
              parent, interceptEndpointGroup, interceptEndpointGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInterceptEndpointGroupTest2() throws Exception {
    InterceptEndpointGroup expectedResponse =
        InterceptEndpointGroup.newBuilder()
            .setName(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setConnectedDeploymentGroup(
                InterceptEndpointGroup.ConnectedDeploymentGroup.newBuilder().build())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<InterceptEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String parent = "parent-995424086";
    InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
    String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";

    InterceptEndpointGroup actualResponse =
        client
            .createInterceptEndpointGroupAsync(
                parent, interceptEndpointGroup, interceptEndpointGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptEndpointGroupRequest actualRequest =
        ((CreateInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(interceptEndpointGroup, actualRequest.getInterceptEndpointGroup());
    Assert.assertEquals(interceptEndpointGroupId, actualRequest.getInterceptEndpointGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
      String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";
      client
          .createInterceptEndpointGroupAsync(
              parent, interceptEndpointGroup, interceptEndpointGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInterceptEndpointGroupTest() throws Exception {
    InterceptEndpointGroup expectedResponse =
        InterceptEndpointGroup.newBuilder()
            .setName(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setConnectedDeploymentGroup(
                InterceptEndpointGroup.ConnectedDeploymentGroup.newBuilder().build())
            .setReconciling(true)
            .addAllAssociations(new ArrayList<InterceptEndpointGroup.AssociationDetails>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInterceptEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InterceptEndpointGroup actualResponse =
        client.updateInterceptEndpointGroupAsync(interceptEndpointGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInterceptEndpointGroupRequest actualRequest =
        ((UpdateInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(interceptEndpointGroup, actualRequest.getInterceptEndpointGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInterceptEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInterceptEndpointGroupAsync(interceptEndpointGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptEndpointGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptEndpointGroupName name =
        InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");

    client.deleteInterceptEndpointGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptEndpointGroupRequest actualRequest =
        ((DeleteInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptEndpointGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroupName name =
          InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
      client.deleteInterceptEndpointGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptEndpointGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptEndpointGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInterceptEndpointGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptEndpointGroupRequest actualRequest =
        ((DeleteInterceptEndpointGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptEndpointGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInterceptEndpointGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInterceptEndpointGroupAssociationsTest() throws Exception {
    InterceptEndpointGroupAssociation responsesElement =
        InterceptEndpointGroupAssociation.newBuilder().build();
    ListInterceptEndpointGroupAssociationsResponse expectedResponse =
        ListInterceptEndpointGroupAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptEndpointGroupAssociations(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInterceptEndpointGroupAssociationsPagedResponse pagedListResponse =
        client.listInterceptEndpointGroupAssociations(parent);

    List<InterceptEndpointGroupAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInterceptEndpointGroupAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptEndpointGroupAssociationsRequest actualRequest =
        ((ListInterceptEndpointGroupAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptEndpointGroupAssociationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInterceptEndpointGroupAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterceptEndpointGroupAssociationsTest2() throws Exception {
    InterceptEndpointGroupAssociation responsesElement =
        InterceptEndpointGroupAssociation.newBuilder().build();
    ListInterceptEndpointGroupAssociationsResponse expectedResponse =
        ListInterceptEndpointGroupAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptEndpointGroupAssociations(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterceptEndpointGroupAssociationsPagedResponse pagedListResponse =
        client.listInterceptEndpointGroupAssociations(parent);

    List<InterceptEndpointGroupAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInterceptEndpointGroupAssociationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptEndpointGroupAssociationsRequest actualRequest =
        ((ListInterceptEndpointGroupAssociationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptEndpointGroupAssociationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterceptEndpointGroupAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptEndpointGroupAssociationTest() throws Exception {
    InterceptEndpointGroupAssociation expectedResponse =
        InterceptEndpointGroupAssociation.newBuilder()
            .setName(
                InterceptEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptEndpointGroup(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<InterceptEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<InterceptLocation>())
            .setNetworkCookie(-2014610027)
            .build();
    mockIntercept.addResponse(expectedResponse);

    InterceptEndpointGroupAssociationName name =
        InterceptEndpointGroupAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");

    InterceptEndpointGroupAssociation actualResponse =
        client.getInterceptEndpointGroupAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptEndpointGroupAssociationRequest actualRequest =
        ((GetInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroupAssociationName name =
          InterceptEndpointGroupAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");
      client.getInterceptEndpointGroupAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptEndpointGroupAssociationTest2() throws Exception {
    InterceptEndpointGroupAssociation expectedResponse =
        InterceptEndpointGroupAssociation.newBuilder()
            .setName(
                InterceptEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptEndpointGroup(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<InterceptEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<InterceptLocation>())
            .setNetworkCookie(-2014610027)
            .build();
    mockIntercept.addResponse(expectedResponse);

    String name = "name3373707";

    InterceptEndpointGroupAssociation actualResponse =
        client.getInterceptEndpointGroupAssociation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptEndpointGroupAssociationRequest actualRequest =
        ((GetInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.getInterceptEndpointGroupAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInterceptEndpointGroupAssociationTest() throws Exception {
    InterceptEndpointGroupAssociation expectedResponse =
        InterceptEndpointGroupAssociation.newBuilder()
            .setName(
                InterceptEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptEndpointGroup(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<InterceptEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<InterceptLocation>())
            .setNetworkCookie(-2014610027)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
        InterceptEndpointGroupAssociation.newBuilder().build();
    String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";

    InterceptEndpointGroupAssociation actualResponse =
        client
            .createInterceptEndpointGroupAssociationAsync(
                parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptEndpointGroupAssociationRequest actualRequest =
        ((CreateInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        interceptEndpointGroupAssociation, actualRequest.getInterceptEndpointGroupAssociation());
    Assert.assertEquals(
        interceptEndpointGroupAssociationId,
        actualRequest.getInterceptEndpointGroupAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
          InterceptEndpointGroupAssociation.newBuilder().build();
      String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";
      client
          .createInterceptEndpointGroupAssociationAsync(
              parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInterceptEndpointGroupAssociationTest2() throws Exception {
    InterceptEndpointGroupAssociation expectedResponse =
        InterceptEndpointGroupAssociation.newBuilder()
            .setName(
                InterceptEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptEndpointGroup(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<InterceptEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<InterceptLocation>())
            .setNetworkCookie(-2014610027)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String parent = "parent-995424086";
    InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
        InterceptEndpointGroupAssociation.newBuilder().build();
    String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";

    InterceptEndpointGroupAssociation actualResponse =
        client
            .createInterceptEndpointGroupAssociationAsync(
                parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptEndpointGroupAssociationRequest actualRequest =
        ((CreateInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        interceptEndpointGroupAssociation, actualRequest.getInterceptEndpointGroupAssociation());
    Assert.assertEquals(
        interceptEndpointGroupAssociationId,
        actualRequest.getInterceptEndpointGroupAssociationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
          InterceptEndpointGroupAssociation.newBuilder().build();
      String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";
      client
          .createInterceptEndpointGroupAssociationAsync(
              parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInterceptEndpointGroupAssociationTest() throws Exception {
    InterceptEndpointGroupAssociation expectedResponse =
        InterceptEndpointGroupAssociation.newBuilder()
            .setName(
                InterceptEndpointGroupAssociationName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setInterceptEndpointGroup(
                InterceptEndpointGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
                    .toString())
            .setNetwork("network1843485230")
            .addAllLocationsDetails(
                new ArrayList<InterceptEndpointGroupAssociation.LocationDetails>())
            .setReconciling(true)
            .addAllLocations(new ArrayList<InterceptLocation>())
            .setNetworkCookie(-2014610027)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInterceptEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
        InterceptEndpointGroupAssociation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InterceptEndpointGroupAssociation actualResponse =
        client
            .updateInterceptEndpointGroupAssociationAsync(
                interceptEndpointGroupAssociation, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInterceptEndpointGroupAssociationRequest actualRequest =
        ((UpdateInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(
        interceptEndpointGroupAssociation, actualRequest.getInterceptEndpointGroupAssociation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInterceptEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
          InterceptEndpointGroupAssociation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updateInterceptEndpointGroupAssociationAsync(
              interceptEndpointGroupAssociation, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptEndpointGroupAssociationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptEndpointGroupAssociationName name =
        InterceptEndpointGroupAssociationName.of(
            "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");

    client.deleteInterceptEndpointGroupAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptEndpointGroupAssociationRequest actualRequest =
        ((DeleteInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptEndpointGroupAssociationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptEndpointGroupAssociationName name =
          InterceptEndpointGroupAssociationName.of(
              "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");
      client.deleteInterceptEndpointGroupAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptEndpointGroupAssociationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptEndpointGroupAssociationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInterceptEndpointGroupAssociationAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptEndpointGroupAssociationRequest actualRequest =
        ((DeleteInterceptEndpointGroupAssociationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptEndpointGroupAssociationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInterceptEndpointGroupAssociationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInterceptDeploymentGroupsTest() throws Exception {
    InterceptDeploymentGroup responsesElement = InterceptDeploymentGroup.newBuilder().build();
    ListInterceptDeploymentGroupsResponse expectedResponse =
        ListInterceptDeploymentGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptDeploymentGroups(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInterceptDeploymentGroupsPagedResponse pagedListResponse =
        client.listInterceptDeploymentGroups(parent);

    List<InterceptDeploymentGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInterceptDeploymentGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptDeploymentGroupsRequest actualRequest =
        ((ListInterceptDeploymentGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptDeploymentGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInterceptDeploymentGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterceptDeploymentGroupsTest2() throws Exception {
    InterceptDeploymentGroup responsesElement = InterceptDeploymentGroup.newBuilder().build();
    ListInterceptDeploymentGroupsResponse expectedResponse =
        ListInterceptDeploymentGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptDeploymentGroups(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterceptDeploymentGroupsPagedResponse pagedListResponse =
        client.listInterceptDeploymentGroups(parent);

    List<InterceptDeploymentGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInterceptDeploymentGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptDeploymentGroupsRequest actualRequest =
        ((ListInterceptDeploymentGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptDeploymentGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterceptDeploymentGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptDeploymentGroupTest() throws Exception {
    InterceptDeploymentGroup expectedResponse =
        InterceptDeploymentGroup.newBuilder()
            .setName(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<InterceptDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<InterceptDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<InterceptLocation>())
            .build();
    mockIntercept.addResponse(expectedResponse);

    InterceptDeploymentGroupName name =
        InterceptDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");

    InterceptDeploymentGroup actualResponse = client.getInterceptDeploymentGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptDeploymentGroupRequest actualRequest =
        ((GetInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeploymentGroupName name =
          InterceptDeploymentGroupName.of(
              "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");
      client.getInterceptDeploymentGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptDeploymentGroupTest2() throws Exception {
    InterceptDeploymentGroup expectedResponse =
        InterceptDeploymentGroup.newBuilder()
            .setName(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<InterceptDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<InterceptDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<InterceptLocation>())
            .build();
    mockIntercept.addResponse(expectedResponse);

    String name = "name3373707";

    InterceptDeploymentGroup actualResponse = client.getInterceptDeploymentGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptDeploymentGroupRequest actualRequest =
        ((GetInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.getInterceptDeploymentGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInterceptDeploymentGroupTest() throws Exception {
    InterceptDeploymentGroup expectedResponse =
        InterceptDeploymentGroup.newBuilder()
            .setName(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<InterceptDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<InterceptDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<InterceptLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InterceptDeploymentGroup interceptDeploymentGroup =
        InterceptDeploymentGroup.newBuilder().build();
    String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";

    InterceptDeploymentGroup actualResponse =
        client
            .createInterceptDeploymentGroupAsync(
                parent, interceptDeploymentGroup, interceptDeploymentGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptDeploymentGroupRequest actualRequest =
        ((CreateInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(interceptDeploymentGroup, actualRequest.getInterceptDeploymentGroup());
    Assert.assertEquals(interceptDeploymentGroupId, actualRequest.getInterceptDeploymentGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InterceptDeploymentGroup interceptDeploymentGroup =
          InterceptDeploymentGroup.newBuilder().build();
      String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";
      client
          .createInterceptDeploymentGroupAsync(
              parent, interceptDeploymentGroup, interceptDeploymentGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInterceptDeploymentGroupTest2() throws Exception {
    InterceptDeploymentGroup expectedResponse =
        InterceptDeploymentGroup.newBuilder()
            .setName(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<InterceptDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<InterceptDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<InterceptLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String parent = "parent-995424086";
    InterceptDeploymentGroup interceptDeploymentGroup =
        InterceptDeploymentGroup.newBuilder().build();
    String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";

    InterceptDeploymentGroup actualResponse =
        client
            .createInterceptDeploymentGroupAsync(
                parent, interceptDeploymentGroup, interceptDeploymentGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptDeploymentGroupRequest actualRequest =
        ((CreateInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(interceptDeploymentGroup, actualRequest.getInterceptDeploymentGroup());
    Assert.assertEquals(interceptDeploymentGroupId, actualRequest.getInterceptDeploymentGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      InterceptDeploymentGroup interceptDeploymentGroup =
          InterceptDeploymentGroup.newBuilder().build();
      String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";
      client
          .createInterceptDeploymentGroupAsync(
              parent, interceptDeploymentGroup, interceptDeploymentGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInterceptDeploymentGroupTest() throws Exception {
    InterceptDeploymentGroup expectedResponse =
        InterceptDeploymentGroup.newBuilder()
            .setName(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .addAllConnectedEndpointGroups(
                new ArrayList<InterceptDeploymentGroup.ConnectedEndpointGroup>())
            .addAllNestedDeployments(new ArrayList<InterceptDeploymentGroup.Deployment>())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .addAllLocations(new ArrayList<InterceptLocation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInterceptDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptDeploymentGroup interceptDeploymentGroup =
        InterceptDeploymentGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InterceptDeploymentGroup actualResponse =
        client.updateInterceptDeploymentGroupAsync(interceptDeploymentGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInterceptDeploymentGroupRequest actualRequest =
        ((UpdateInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(interceptDeploymentGroup, actualRequest.getInterceptDeploymentGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInterceptDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeploymentGroup interceptDeploymentGroup =
          InterceptDeploymentGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInterceptDeploymentGroupAsync(interceptDeploymentGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptDeploymentGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptDeploymentGroupName name =
        InterceptDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");

    client.deleteInterceptDeploymentGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptDeploymentGroupRequest actualRequest =
        ((DeleteInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptDeploymentGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeploymentGroupName name =
          InterceptDeploymentGroupName.of(
              "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");
      client.deleteInterceptDeploymentGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptDeploymentGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptDeploymentGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInterceptDeploymentGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptDeploymentGroupRequest actualRequest =
        ((DeleteInterceptDeploymentGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptDeploymentGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInterceptDeploymentGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInterceptDeploymentsTest() throws Exception {
    InterceptDeployment responsesElement = InterceptDeployment.newBuilder().build();
    ListInterceptDeploymentsResponse expectedResponse =
        ListInterceptDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptDeployments(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInterceptDeploymentsPagedResponse pagedListResponse =
        client.listInterceptDeployments(parent);

    List<InterceptDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterceptDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptDeploymentsRequest actualRequest =
        ((ListInterceptDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInterceptDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterceptDeploymentsTest2() throws Exception {
    InterceptDeployment responsesElement = InterceptDeployment.newBuilder().build();
    ListInterceptDeploymentsResponse expectedResponse =
        ListInterceptDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterceptDeployments(Arrays.asList(responsesElement))
            .build();
    mockIntercept.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterceptDeploymentsPagedResponse pagedListResponse =
        client.listInterceptDeployments(parent);

    List<InterceptDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterceptDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterceptDeploymentsRequest actualRequest =
        ((ListInterceptDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterceptDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterceptDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptDeploymentTest() throws Exception {
    InterceptDeployment expectedResponse =
        InterceptDeployment.newBuilder()
            .setName(
                InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    mockIntercept.addResponse(expectedResponse);

    InterceptDeploymentName name =
        InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");

    InterceptDeployment actualResponse = client.getInterceptDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptDeploymentRequest actualRequest =
        ((GetInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeploymentName name =
          InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");
      client.getInterceptDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterceptDeploymentTest2() throws Exception {
    InterceptDeployment expectedResponse =
        InterceptDeployment.newBuilder()
            .setName(
                InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    mockIntercept.addResponse(expectedResponse);

    String name = "name3373707";

    InterceptDeployment actualResponse = client.getInterceptDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterceptDeploymentRequest actualRequest =
        ((GetInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterceptDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.getInterceptDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInterceptDeploymentTest() throws Exception {
    InterceptDeployment expectedResponse =
        InterceptDeployment.newBuilder()
            .setName(
                InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
    String interceptDeploymentId = "interceptDeploymentId-240023390";

    InterceptDeployment actualResponse =
        client
            .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptDeploymentRequest actualRequest =
        ((CreateInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(interceptDeployment, actualRequest.getInterceptDeployment());
    Assert.assertEquals(interceptDeploymentId, actualRequest.getInterceptDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
      String interceptDeploymentId = "interceptDeploymentId-240023390";
      client
          .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInterceptDeploymentTest2() throws Exception {
    InterceptDeployment expectedResponse =
        InterceptDeployment.newBuilder()
            .setName(
                InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterceptDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String parent = "parent-995424086";
    InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
    String interceptDeploymentId = "interceptDeploymentId-240023390";

    InterceptDeployment actualResponse =
        client
            .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterceptDeploymentRequest actualRequest =
        ((CreateInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(interceptDeployment, actualRequest.getInterceptDeployment());
    Assert.assertEquals(interceptDeploymentId, actualRequest.getInterceptDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterceptDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String parent = "parent-995424086";
      InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
      String interceptDeploymentId = "interceptDeploymentId-240023390";
      client
          .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInterceptDeploymentTest() throws Exception {
    InterceptDeployment expectedResponse =
        InterceptDeployment.newBuilder()
            .setName(
                InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setForwardingRule("forwardingRule-1429104743")
            .setInterceptDeploymentGroup(
                InterceptDeploymentGroupName.of(
                        "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
                    .toString())
            .setReconciling(true)
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInterceptDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InterceptDeployment actualResponse =
        client.updateInterceptDeploymentAsync(interceptDeployment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInterceptDeploymentRequest actualRequest =
        ((UpdateInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(interceptDeployment, actualRequest.getInterceptDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInterceptDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInterceptDeploymentAsync(interceptDeployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    InterceptDeploymentName name =
        InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");

    client.deleteInterceptDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptDeploymentRequest actualRequest =
        ((DeleteInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      InterceptDeploymentName name =
          InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");
      client.deleteInterceptDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterceptDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterceptDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntercept.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInterceptDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockIntercept.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterceptDeploymentRequest actualRequest =
        ((DeleteInterceptDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterceptDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntercept.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInterceptDeploymentAsync(name).get();
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
