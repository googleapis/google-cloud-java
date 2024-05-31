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

package com.google.cloud.iap.v1;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class IdentityAwareProxyAdminServiceClientTest {
  private static MockIdentityAwareProxyAdminService mockIdentityAwareProxyAdminService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IdentityAwareProxyAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIdentityAwareProxyAdminService = new MockIdentityAwareProxyAdminService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIdentityAwareProxyAdminService));
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
    IdentityAwareProxyAdminServiceSettings settings =
        IdentityAwareProxyAdminServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityAwareProxyAdminServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
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
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
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
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
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
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
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
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
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
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIapSettingsTest() throws Exception {
    IapSettings expectedResponse =
        IapSettings.newBuilder()
            .setName("name3373707")
            .setAccessSettings(AccessSettings.newBuilder().build())
            .setApplicationSettings(ApplicationSettings.newBuilder().build())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    GetIapSettingsRequest request =
        GetIapSettingsRequest.newBuilder().setName("name3373707").build();

    IapSettings actualResponse = client.getIapSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIapSettingsRequest actualRequest = ((GetIapSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIapSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      GetIapSettingsRequest request =
          GetIapSettingsRequest.newBuilder().setName("name3373707").build();
      client.getIapSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIapSettingsTest() throws Exception {
    IapSettings expectedResponse =
        IapSettings.newBuilder()
            .setName("name3373707")
            .setAccessSettings(AccessSettings.newBuilder().build())
            .setApplicationSettings(ApplicationSettings.newBuilder().build())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    UpdateIapSettingsRequest request =
        UpdateIapSettingsRequest.newBuilder()
            .setIapSettings(IapSettings.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    IapSettings actualResponse = client.updateIapSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIapSettingsRequest actualRequest = ((UpdateIapSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getIapSettings(), actualRequest.getIapSettings());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIapSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      UpdateIapSettingsRequest request =
          UpdateIapSettingsRequest.newBuilder()
              .setIapSettings(IapSettings.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateIapSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunnelDestGroupsTest() throws Exception {
    TunnelDestGroup responsesElement = TunnelDestGroup.newBuilder().build();
    ListTunnelDestGroupsResponse expectedResponse =
        ListTunnelDestGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunnelDestGroups(Arrays.asList(responsesElement))
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");

    ListTunnelDestGroupsPagedResponse pagedListResponse = client.listTunnelDestGroups(parent);

    List<TunnelDestGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunnelDestGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTunnelDestGroupsRequest actualRequest =
        ((ListTunnelDestGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTunnelDestGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
      client.listTunnelDestGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunnelDestGroupsTest2() throws Exception {
    TunnelDestGroup responsesElement = TunnelDestGroup.newBuilder().build();
    ListTunnelDestGroupsResponse expectedResponse =
        ListTunnelDestGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunnelDestGroups(Arrays.asList(responsesElement))
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTunnelDestGroupsPagedResponse pagedListResponse = client.listTunnelDestGroups(parent);

    List<TunnelDestGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunnelDestGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTunnelDestGroupsRequest actualRequest =
        ((ListTunnelDestGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTunnelDestGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTunnelDestGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
    TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
    String tunnelDestGroupId = "tunnelDestGroupId-1240473232";

    TunnelDestGroup actualResponse =
        client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTunnelDestGroupRequest actualRequest =
        ((CreateTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tunnelDestGroup, actualRequest.getTunnelDestGroup());
    Assert.assertEquals(tunnelDestGroupId, actualRequest.getTunnelDestGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTunnelDestGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
      TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
      String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
      client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunnelDestGroupTest2() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
    String tunnelDestGroupId = "tunnelDestGroupId-1240473232";

    TunnelDestGroup actualResponse =
        client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTunnelDestGroupRequest actualRequest =
        ((CreateTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tunnelDestGroup, actualRequest.getTunnelDestGroup());
    Assert.assertEquals(tunnelDestGroupId, actualRequest.getTunnelDestGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTunnelDestGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
      String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
      client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");

    TunnelDestGroup actualResponse = client.getTunnelDestGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTunnelDestGroupRequest actualRequest = ((GetTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTunnelDestGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
      client.getTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunnelDestGroupTest2() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    TunnelDestGroup actualResponse = client.getTunnelDestGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTunnelDestGroupRequest actualRequest = ((GetTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTunnelDestGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunnelDestGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");

    client.deleteTunnelDestGroup(name);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTunnelDestGroupRequest actualRequest =
        ((DeleteTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTunnelDestGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
      client.deleteTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunnelDestGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTunnelDestGroup(name);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTunnelDestGroupRequest actualRequest =
        ((DeleteTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTunnelDestGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockIdentityAwareProxyAdminService.addResponse(expectedResponse);

    TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TunnelDestGroup actualResponse = client.updateTunnelDestGroup(tunnelDestGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTunnelDestGroupRequest actualRequest =
        ((UpdateTunnelDestGroupRequest) actualRequests.get(0));

    Assert.assertEquals(tunnelDestGroup, actualRequest.getTunnelDestGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTunnelDestGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyAdminService.addException(exception);

    try {
      TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTunnelDestGroup(tunnelDestGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
