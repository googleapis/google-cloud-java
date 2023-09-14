/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dataproc.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
import com.google.protobuf.FieldMask;
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
public class NodeGroupControllerClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockNodeGroupController mockNodeGroupController;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NodeGroupControllerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNodeGroupController = new MockNodeGroupController();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNodeGroupController, mockIAMPolicy));
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
    NodeGroupControllerSettings settings =
        NodeGroupControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NodeGroupControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createNodeGroupTest() throws Exception {
    NodeGroup expectedResponse =
        NodeGroup.newBuilder()
            .setName(
                NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
            .addAllRoles(new ArrayList<NodeGroup.Role>())
            .setNodeGroupConfig(InstanceGroupConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNodeGroupController.addResponse(resultOperation);

    ClusterRegionName parent = ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]");
    NodeGroup nodeGroup = NodeGroup.newBuilder().build();
    String nodeGroupId = "nodeGroupId1097129880";

    NodeGroup actualResponse = client.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNodeGroupController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodeGroupRequest actualRequest = ((CreateNodeGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(nodeGroup, actualRequest.getNodeGroup());
    Assert.assertEquals(nodeGroupId, actualRequest.getNodeGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodeGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNodeGroupController.addException(exception);

    try {
      ClusterRegionName parent = ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]");
      NodeGroup nodeGroup = NodeGroup.newBuilder().build();
      String nodeGroupId = "nodeGroupId1097129880";
      client.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNodeGroupTest2() throws Exception {
    NodeGroup expectedResponse =
        NodeGroup.newBuilder()
            .setName(
                NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
            .addAllRoles(new ArrayList<NodeGroup.Role>())
            .setNodeGroupConfig(InstanceGroupConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNodeGroupController.addResponse(resultOperation);

    String parent = "parent-995424086";
    NodeGroup nodeGroup = NodeGroup.newBuilder().build();
    String nodeGroupId = "nodeGroupId1097129880";

    NodeGroup actualResponse = client.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNodeGroupController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodeGroupRequest actualRequest = ((CreateNodeGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(nodeGroup, actualRequest.getNodeGroup());
    Assert.assertEquals(nodeGroupId, actualRequest.getNodeGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodeGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNodeGroupController.addException(exception);

    try {
      String parent = "parent-995424086";
      NodeGroup nodeGroup = NodeGroup.newBuilder().build();
      String nodeGroupId = "nodeGroupId1097129880";
      client.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resizeNodeGroupTest() throws Exception {
    NodeGroup expectedResponse =
        NodeGroup.newBuilder()
            .setName(
                NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
            .addAllRoles(new ArrayList<NodeGroup.Role>())
            .setNodeGroupConfig(InstanceGroupConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resizeNodeGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNodeGroupController.addResponse(resultOperation);

    String name = "name3373707";
    int size = 3530753;

    NodeGroup actualResponse = client.resizeNodeGroupAsync(name, size).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNodeGroupController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResizeNodeGroupRequest actualRequest = ((ResizeNodeGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(size, actualRequest.getSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resizeNodeGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNodeGroupController.addException(exception);

    try {
      String name = "name3373707";
      int size = 3530753;
      client.resizeNodeGroupAsync(name, size).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getNodeGroupTest() throws Exception {
    NodeGroup expectedResponse =
        NodeGroup.newBuilder()
            .setName(
                NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
            .addAllRoles(new ArrayList<NodeGroup.Role>())
            .setNodeGroupConfig(InstanceGroupConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNodeGroupController.addResponse(expectedResponse);

    NodeGroupName name = NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]");

    NodeGroup actualResponse = client.getNodeGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNodeGroupController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeGroupRequest actualRequest = ((GetNodeGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNodeGroupController.addException(exception);

    try {
      NodeGroupName name = NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]");
      client.getNodeGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeGroupTest2() throws Exception {
    NodeGroup expectedResponse =
        NodeGroup.newBuilder()
            .setName(
                NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
            .addAllRoles(new ArrayList<NodeGroup.Role>())
            .setNodeGroupConfig(InstanceGroupConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockNodeGroupController.addResponse(expectedResponse);

    String name = "name3373707";

    NodeGroup actualResponse = client.getNodeGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNodeGroupController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeGroupRequest actualRequest = ((GetNodeGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNodeGroupController.addException(exception);

    try {
      String name = "name3373707";
      client.getNodeGroup(name);
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
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
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
