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

package com.google.cloud.vmwareengine.v1;

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.FetchNetworkPolicyExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAccessRulesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLoggingServersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListManagementDnsZoneBindingsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPeeringsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

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
public class VmwareEngineClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVmwareEngine mockVmwareEngine;
  private LocalChannelProvider channelProvider;
  private VmwareEngineClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVmwareEngine = new MockVmwareEngine();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVmwareEngine, mockLocations, mockIAMPolicy));
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
    VmwareEngineSettings settings =
        VmwareEngineSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VmwareEngineClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listPrivateCloudsTest() throws Exception {
    PrivateCloud responsesElement = PrivateCloud.newBuilder().build();
    ListPrivateCloudsResponse expectedResponse =
        ListPrivateCloudsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateClouds(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateCloudsPagedResponse pagedListResponse = client.listPrivateClouds(parent);

    List<PrivateCloud> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateCloudsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateCloudsRequest actualRequest = ((ListPrivateCloudsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateCloudsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateClouds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateCloudsTest2() throws Exception {
    PrivateCloud responsesElement = PrivateCloud.newBuilder().build();
    ListPrivateCloudsResponse expectedResponse =
        ListPrivateCloudsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateClouds(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrivateCloudsPagedResponse pagedListResponse = client.listPrivateClouds(parent);

    List<PrivateCloud> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateCloudsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateCloudsRequest actualRequest = ((ListPrivateCloudsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateCloudsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrivateClouds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.getPrivateCloud(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateCloudRequest actualRequest = ((GetPrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateCloudExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.getPrivateCloud(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    PrivateCloud actualResponse = client.getPrivateCloud(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateCloudRequest actualRequest = ((GetPrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateCloudExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getPrivateCloud(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
    String privateCloudId = "privateCloudId573896493";

    PrivateCloud actualResponse =
        client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateCloudRequest actualRequest = ((CreatePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertEquals(privateCloudId, actualRequest.getPrivateCloudId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateCloudExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
      String privateCloudId = "privateCloudId573896493";
      client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
    String privateCloudId = "privateCloudId573896493";

    PrivateCloud actualResponse =
        client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateCloudRequest actualRequest = ((CreatePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertEquals(privateCloudId, actualRequest.getPrivateCloudId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateCloudExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
      String privateCloudId = "privateCloudId573896493";
      client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updatePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateCloud actualResponse = client.updatePrivateCloudAsync(privateCloud, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePrivateCloudRequest actualRequest = ((UpdatePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePrivateCloudExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateCloudAsync(privateCloud, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.deletePrivateCloudAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateCloudRequest actualRequest = ((DeletePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateCloudExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.deletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    PrivateCloud actualResponse = client.deletePrivateCloudAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateCloudRequest actualRequest = ((DeletePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateCloudExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeletePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.undeletePrivateCloudAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePrivateCloudRequest actualRequest =
        ((UndeletePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePrivateCloudExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.undeletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeletePrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    PrivateCloud actualResponse = client.undeletePrivateCloudAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePrivateCloudRequest actualRequest =
        ((UndeletePrivateCloudRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePrivateCloudExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.undeletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listClustersTest() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest2() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .setStretchedClusterConfig(StretchedClusterConfig.newBuilder().build())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .setStretchedClusterConfig(StretchedClusterConfig.newBuilder().build())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .setStretchedClusterConfig(StretchedClusterConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .setStretchedClusterConfig(StretchedClusterConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .setStretchedClusterConfig(StretchedClusterConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClusterRequest actualRequest = ((UpdateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listNodesTest() throws Exception {
    Node responsesElement = Node.newBuilder().build();
    ListNodesResponse expectedResponse =
        ListNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodesRequest actualRequest = ((ListNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ClusterName parent =
          ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
      client.listNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodesTest2() throws Exception {
    Node responsesElement = Node.newBuilder().build();
    ListNodesResponse expectedResponse =
        ListNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodesRequest actualRequest = ((ListNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(
                NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]")
                    .toString())
            .setFqdn("fqdn3150485")
            .setInternalIp("internalIp-1591143228")
            .setNodeTypeId("nodeTypeId1245332119")
            .setVersion("version351608024")
            .setCustomCoreCount(2091833853)
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NodeName name =
        NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]");

    Node actualResponse = client.getNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeRequest actualRequest = ((GetNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NodeName name =
          NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]");
      client.getNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTest2() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(
                NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]")
                    .toString())
            .setFqdn("fqdn3150485")
            .setInternalIp("internalIp-1591143228")
            .setNodeTypeId("nodeTypeId1245332119")
            .setVersion("version351608024")
            .setCustomCoreCount(2091833853)
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    Node actualResponse = client.getNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeRequest actualRequest = ((GetNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExternalAddressesTest() throws Exception {
    ExternalAddress responsesElement = ExternalAddress.newBuilder().build();
    ListExternalAddressesResponse expectedResponse =
        ListExternalAddressesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAddresses(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListExternalAddressesPagedResponse pagedListResponse = client.listExternalAddresses(parent);

    List<ExternalAddress> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAddressesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalAddressesRequest actualRequest =
        ((ListExternalAddressesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalAddressesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listExternalAddresses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExternalAddressesTest2() throws Exception {
    ExternalAddress responsesElement = ExternalAddress.newBuilder().build();
    ListExternalAddressesResponse expectedResponse =
        ListExternalAddressesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAddresses(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExternalAddressesPagedResponse pagedListResponse = client.listExternalAddresses(parent);

    List<ExternalAddress> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAddressesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalAddressesRequest actualRequest =
        ((ListExternalAddressesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalAddressesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExternalAddresses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchNetworkPolicyExternalAddressesTest() throws Exception {
    ExternalAddress responsesElement = ExternalAddress.newBuilder().build();
    FetchNetworkPolicyExternalAddressesResponse expectedResponse =
        FetchNetworkPolicyExternalAddressesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAddresses(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NetworkPolicyName networkPolicy =
        NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    FetchNetworkPolicyExternalAddressesPagedResponse pagedListResponse =
        client.fetchNetworkPolicyExternalAddresses(networkPolicy);

    List<ExternalAddress> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAddressesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchNetworkPolicyExternalAddressesRequest actualRequest =
        ((FetchNetworkPolicyExternalAddressesRequest) actualRequests.get(0));

    Assert.assertEquals(networkPolicy.toString(), actualRequest.getNetworkPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchNetworkPolicyExternalAddressesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicyName networkPolicy =
          NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.fetchNetworkPolicyExternalAddresses(networkPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchNetworkPolicyExternalAddressesTest2() throws Exception {
    ExternalAddress responsesElement = ExternalAddress.newBuilder().build();
    FetchNetworkPolicyExternalAddressesResponse expectedResponse =
        FetchNetworkPolicyExternalAddressesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAddresses(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String networkPolicy = "networkPolicy-1037627136";

    FetchNetworkPolicyExternalAddressesPagedResponse pagedListResponse =
        client.fetchNetworkPolicyExternalAddresses(networkPolicy);

    List<ExternalAddress> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAddressesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchNetworkPolicyExternalAddressesRequest actualRequest =
        ((FetchNetworkPolicyExternalAddressesRequest) actualRequests.get(0));

    Assert.assertEquals(networkPolicy, actualRequest.getNetworkPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchNetworkPolicyExternalAddressesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String networkPolicy = "networkPolicy-1037627136";
      client.fetchNetworkPolicyExternalAddresses(networkPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalAddressTest() throws Exception {
    ExternalAddress expectedResponse =
        ExternalAddress.newBuilder()
            .setName(
                ExternalAddressName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalIp("internalIp-1591143228")
            .setExternalIp("externalIp-1699764654")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    ExternalAddressName name =
        ExternalAddressName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");

    ExternalAddress actualResponse = client.getExternalAddress(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalAddressRequest actualRequest = ((GetExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAddressName name =
          ExternalAddressName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");
      client.getExternalAddress(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalAddressTest2() throws Exception {
    ExternalAddress expectedResponse =
        ExternalAddress.newBuilder()
            .setName(
                ExternalAddressName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalIp("internalIp-1591143228")
            .setExternalIp("externalIp-1699764654")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    ExternalAddress actualResponse = client.getExternalAddress(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalAddressRequest actualRequest = ((GetExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalAddressExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getExternalAddress(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalAddressTest() throws Exception {
    ExternalAddress expectedResponse =
        ExternalAddress.newBuilder()
            .setName(
                ExternalAddressName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalIp("internalIp-1591143228")
            .setExternalIp("externalIp-1699764654")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExternalAddressTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
    String externalAddressId = "externalAddressId221595812";

    ExternalAddress actualResponse =
        client.createExternalAddressAsync(parent, externalAddress, externalAddressId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAddressRequest actualRequest =
        ((CreateExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(externalAddress, actualRequest.getExternalAddress());
    Assert.assertEquals(externalAddressId, actualRequest.getExternalAddressId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
      String externalAddressId = "externalAddressId221595812";
      client.createExternalAddressAsync(parent, externalAddress, externalAddressId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExternalAddressTest2() throws Exception {
    ExternalAddress expectedResponse =
        ExternalAddress.newBuilder()
            .setName(
                ExternalAddressName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalIp("internalIp-1591143228")
            .setExternalIp("externalIp-1699764654")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExternalAddressTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
    String externalAddressId = "externalAddressId221595812";

    ExternalAddress actualResponse =
        client.createExternalAddressAsync(parent, externalAddress, externalAddressId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAddressRequest actualRequest =
        ((CreateExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(externalAddress, actualRequest.getExternalAddress());
    Assert.assertEquals(externalAddressId, actualRequest.getExternalAddressId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAddressExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
      String externalAddressId = "externalAddressId221595812";
      client.createExternalAddressAsync(parent, externalAddress, externalAddressId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateExternalAddressTest() throws Exception {
    ExternalAddress expectedResponse =
        ExternalAddress.newBuilder()
            .setName(
                ExternalAddressName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalIp("internalIp-1591143228")
            .setExternalIp("externalIp-1699764654")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExternalAddressTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExternalAddress actualResponse =
        client.updateExternalAddressAsync(externalAddress, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExternalAddressRequest actualRequest =
        ((UpdateExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(externalAddress, actualRequest.getExternalAddress());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExternalAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExternalAddressAsync(externalAddress, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExternalAddressTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExternalAddressTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ExternalAddressName name =
        ExternalAddressName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");

    client.deleteExternalAddressAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalAddressRequest actualRequest =
        ((DeleteExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAddressName name =
          ExternalAddressName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");
      client.deleteExternalAddressAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExternalAddressTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExternalAddressTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExternalAddressAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalAddressRequest actualRequest =
        ((DeleteExternalAddressRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalAddressExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExternalAddressAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSubnetsTest() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubnetsRequest actualRequest = ((ListSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubnetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubnetsTest2() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubnetsRequest actualRequest = ((ListSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubnetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubnetTest() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(
                SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]").toString())
            .setIpCidrRange("ipCidrRange-866375486")
            .setGatewayIp("gatewayIp-1354641781")
            .setType("type3575610")
            .setVlanId(536153463)
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]");

    Subnet actualResponse = client.getSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubnetRequest actualRequest = ((GetSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]");
      client.getSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubnetTest2() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(
                SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]").toString())
            .setIpCidrRange("ipCidrRange-866375486")
            .setGatewayIp("gatewayIp-1354641781")
            .setType("type3575610")
            .setVlanId(536153463)
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    Subnet actualResponse = client.getSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubnetRequest actualRequest = ((GetSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubnetTest() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(
                SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]").toString())
            .setIpCidrRange("ipCidrRange-866375486")
            .setGatewayIp("gatewayIp-1354641781")
            .setType("type3575610")
            .setVlanId(536153463)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    Subnet subnet = Subnet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subnet actualResponse = client.updateSubnetAsync(subnet, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSubnetRequest actualRequest = ((UpdateSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(subnet, actualRequest.getSubnet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      Subnet subnet = Subnet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubnetAsync(subnet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listExternalAccessRulesTest() throws Exception {
    ExternalAccessRule responsesElement = ExternalAccessRule.newBuilder().build();
    ListExternalAccessRulesResponse expectedResponse =
        ListExternalAccessRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAccessRules(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NetworkPolicyName parent = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    ListExternalAccessRulesPagedResponse pagedListResponse = client.listExternalAccessRules(parent);

    List<ExternalAccessRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAccessRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalAccessRulesRequest actualRequest =
        ((ListExternalAccessRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalAccessRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicyName parent =
          NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.listExternalAccessRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExternalAccessRulesTest2() throws Exception {
    ExternalAccessRule responsesElement = ExternalAccessRule.newBuilder().build();
    ListExternalAccessRulesResponse expectedResponse =
        ListExternalAccessRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalAccessRules(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExternalAccessRulesPagedResponse pagedListResponse = client.listExternalAccessRules(parent);

    List<ExternalAccessRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalAccessRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalAccessRulesRequest actualRequest =
        ((ListExternalAccessRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalAccessRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExternalAccessRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalAccessRuleTest() throws Exception {
    ExternalAccessRule expectedResponse =
        ExternalAccessRule.newBuilder()
            .setName(
                ExternalAccessRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setIpProtocol("ipProtocol-655038241")
            .addAllSourceIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllSourcePorts(new ArrayList<String>())
            .addAllDestinationIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllDestinationPorts(new ArrayList<String>())
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    ExternalAccessRuleName name =
        ExternalAccessRuleName.of(
            "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");

    ExternalAccessRule actualResponse = client.getExternalAccessRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalAccessRuleRequest actualRequest =
        ((GetExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalAccessRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAccessRuleName name =
          ExternalAccessRuleName.of(
              "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");
      client.getExternalAccessRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalAccessRuleTest2() throws Exception {
    ExternalAccessRule expectedResponse =
        ExternalAccessRule.newBuilder()
            .setName(
                ExternalAccessRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setIpProtocol("ipProtocol-655038241")
            .addAllSourceIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllSourcePorts(new ArrayList<String>())
            .addAllDestinationIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllDestinationPorts(new ArrayList<String>())
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    ExternalAccessRule actualResponse = client.getExternalAccessRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalAccessRuleRequest actualRequest =
        ((GetExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalAccessRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getExternalAccessRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalAccessRuleTest() throws Exception {
    ExternalAccessRule expectedResponse =
        ExternalAccessRule.newBuilder()
            .setName(
                ExternalAccessRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setIpProtocol("ipProtocol-655038241")
            .addAllSourceIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllSourcePorts(new ArrayList<String>())
            .addAllDestinationIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllDestinationPorts(new ArrayList<String>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExternalAccessRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    NetworkPolicyName parent = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
    ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
    String externalAccessRuleId = "externalAccessRuleId1937389350";

    ExternalAccessRule actualResponse =
        client
            .createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAccessRuleRequest actualRequest =
        ((CreateExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(externalAccessRule, actualRequest.getExternalAccessRule());
    Assert.assertEquals(externalAccessRuleId, actualRequest.getExternalAccessRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAccessRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicyName parent =
          NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
      String externalAccessRuleId = "externalAccessRuleId1937389350";
      client.createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExternalAccessRuleTest2() throws Exception {
    ExternalAccessRule expectedResponse =
        ExternalAccessRule.newBuilder()
            .setName(
                ExternalAccessRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setIpProtocol("ipProtocol-655038241")
            .addAllSourceIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllSourcePorts(new ArrayList<String>())
            .addAllDestinationIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllDestinationPorts(new ArrayList<String>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExternalAccessRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
    String externalAccessRuleId = "externalAccessRuleId1937389350";

    ExternalAccessRule actualResponse =
        client
            .createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAccessRuleRequest actualRequest =
        ((CreateExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(externalAccessRule, actualRequest.getExternalAccessRule());
    Assert.assertEquals(externalAccessRuleId, actualRequest.getExternalAccessRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAccessRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
      String externalAccessRuleId = "externalAccessRuleId1937389350";
      client.createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateExternalAccessRuleTest() throws Exception {
    ExternalAccessRule expectedResponse =
        ExternalAccessRule.newBuilder()
            .setName(
                ExternalAccessRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setIpProtocol("ipProtocol-655038241")
            .addAllSourceIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllSourcePorts(new ArrayList<String>())
            .addAllDestinationIpRanges(new ArrayList<ExternalAccessRule.IpRange>())
            .addAllDestinationPorts(new ArrayList<String>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExternalAccessRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExternalAccessRule actualResponse =
        client.updateExternalAccessRuleAsync(externalAccessRule, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExternalAccessRuleRequest actualRequest =
        ((UpdateExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(externalAccessRule, actualRequest.getExternalAccessRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExternalAccessRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExternalAccessRuleAsync(externalAccessRule, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExternalAccessRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExternalAccessRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ExternalAccessRuleName name =
        ExternalAccessRuleName.of(
            "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");

    client.deleteExternalAccessRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalAccessRuleRequest actualRequest =
        ((DeleteExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalAccessRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ExternalAccessRuleName name =
          ExternalAccessRuleName.of(
              "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");
      client.deleteExternalAccessRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExternalAccessRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExternalAccessRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExternalAccessRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalAccessRuleRequest actualRequest =
        ((DeleteExternalAccessRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalAccessRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExternalAccessRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLoggingServersTest() throws Exception {
    LoggingServer responsesElement = LoggingServer.newBuilder().build();
    ListLoggingServersResponse expectedResponse =
        ListLoggingServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLoggingServers(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListLoggingServersPagedResponse pagedListResponse = client.listLoggingServers(parent);

    List<LoggingServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLoggingServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLoggingServersRequest actualRequest = ((ListLoggingServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLoggingServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listLoggingServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLoggingServersTest2() throws Exception {
    LoggingServer responsesElement = LoggingServer.newBuilder().build();
    ListLoggingServersResponse expectedResponse =
        ListLoggingServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLoggingServers(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLoggingServersPagedResponse pagedListResponse = client.listLoggingServers(parent);

    List<LoggingServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLoggingServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLoggingServersRequest actualRequest = ((ListLoggingServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLoggingServersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLoggingServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingServerTest() throws Exception {
    LoggingServer expectedResponse =
        LoggingServer.newBuilder()
            .setName(
                LoggingServerName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setHostname("hostname-299803597")
            .setPort(3446913)
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LoggingServerName name =
        LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");

    LoggingServer actualResponse = client.getLoggingServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoggingServerRequest actualRequest = ((GetLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoggingServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LoggingServerName name =
          LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");
      client.getLoggingServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingServerTest2() throws Exception {
    LoggingServer expectedResponse =
        LoggingServer.newBuilder()
            .setName(
                LoggingServerName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setHostname("hostname-299803597")
            .setPort(3446913)
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    LoggingServer actualResponse = client.getLoggingServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoggingServerRequest actualRequest = ((GetLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoggingServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getLoggingServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLoggingServerTest() throws Exception {
    LoggingServer expectedResponse =
        LoggingServer.newBuilder()
            .setName(
                LoggingServerName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setHostname("hostname-299803597")
            .setPort(3446913)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLoggingServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    LoggingServer loggingServer = LoggingServer.newBuilder().build();
    String loggingServerId = "loggingServerId-304163779";

    LoggingServer actualResponse =
        client.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLoggingServerRequest actualRequest = ((CreateLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(loggingServer, actualRequest.getLoggingServer());
    Assert.assertEquals(loggingServerId, actualRequest.getLoggingServerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLoggingServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      LoggingServer loggingServer = LoggingServer.newBuilder().build();
      String loggingServerId = "loggingServerId-304163779";
      client.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLoggingServerTest2() throws Exception {
    LoggingServer expectedResponse =
        LoggingServer.newBuilder()
            .setName(
                LoggingServerName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setHostname("hostname-299803597")
            .setPort(3446913)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLoggingServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    LoggingServer loggingServer = LoggingServer.newBuilder().build();
    String loggingServerId = "loggingServerId-304163779";

    LoggingServer actualResponse =
        client.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLoggingServerRequest actualRequest = ((CreateLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(loggingServer, actualRequest.getLoggingServer());
    Assert.assertEquals(loggingServerId, actualRequest.getLoggingServerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLoggingServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      LoggingServer loggingServer = LoggingServer.newBuilder().build();
      String loggingServerId = "loggingServerId-304163779";
      client.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateLoggingServerTest() throws Exception {
    LoggingServer expectedResponse =
        LoggingServer.newBuilder()
            .setName(
                LoggingServerName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setHostname("hostname-299803597")
            .setPort(3446913)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLoggingServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LoggingServer loggingServer = LoggingServer.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LoggingServer actualResponse = client.updateLoggingServerAsync(loggingServer, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLoggingServerRequest actualRequest = ((UpdateLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(loggingServer, actualRequest.getLoggingServer());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLoggingServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LoggingServer loggingServer = LoggingServer.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLoggingServerAsync(loggingServer, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLoggingServerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLoggingServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LoggingServerName name =
        LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");

    client.deleteLoggingServerAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLoggingServerRequest actualRequest = ((DeleteLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLoggingServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LoggingServerName name =
          LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");
      client.deleteLoggingServerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLoggingServerTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLoggingServerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLoggingServerAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLoggingServerRequest actualRequest = ((DeleteLoggingServerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLoggingServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLoggingServerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listNodeTypesTest() throws Exception {
    NodeType responsesElement = NodeType.newBuilder().build();
    ListNodeTypesResponse expectedResponse =
        ListNodeTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodeTypes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNodeTypesPagedResponse pagedListResponse = client.listNodeTypes(parent);

    List<NodeType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodeTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodeTypesRequest actualRequest = ((ListNodeTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodeTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNodeTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodeTypesTest2() throws Exception {
    NodeType responsesElement = NodeType.newBuilder().build();
    ListNodeTypesResponse expectedResponse =
        ListNodeTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodeTypes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNodeTypesPagedResponse pagedListResponse = client.listNodeTypes(parent);

    List<NodeType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodeTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodeTypesRequest actualRequest = ((ListNodeTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodeTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNodeTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTypeTest() throws Exception {
    NodeType expectedResponse =
        NodeType.newBuilder()
            .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
            .setNodeTypeId("nodeTypeId1245332119")
            .setDisplayName("displayName1714148973")
            .setVirtualCpuCount(289038212)
            .setTotalCoreCount(-282953654)
            .setMemoryGb(1726613721)
            .setDiskSizeGb(-757478089)
            .addAllAvailableCustomCoreCounts(new ArrayList<Integer>())
            .addAllFamilies(new ArrayList<String>())
            .addAllCapabilities(new ArrayList<NodeType.Capability>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");

    NodeType actualResponse = client.getNodeType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeTypeRequest actualRequest = ((GetNodeTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");
      client.getNodeType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTypeTest2() throws Exception {
    NodeType expectedResponse =
        NodeType.newBuilder()
            .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
            .setNodeTypeId("nodeTypeId1245332119")
            .setDisplayName("displayName1714148973")
            .setVirtualCpuCount(289038212)
            .setTotalCoreCount(-282953654)
            .setMemoryGb(1726613721)
            .setDiskSizeGb(-757478089)
            .addAllAvailableCustomCoreCounts(new ArrayList<Integer>())
            .addAllFamilies(new ArrayList<String>())
            .addAllCapabilities(new ArrayList<NodeType.Capability>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    NodeType actualResponse = client.getNodeType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeTypeRequest actualRequest = ((GetNodeTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getNodeType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showNsxCredentialsTest() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    Credentials actualResponse = client.showNsxCredentials(privateCloud);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowNsxCredentialsRequest actualRequest = ((ShowNsxCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud.toString(), actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showNsxCredentialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.showNsxCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showNsxCredentialsTest2() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String privateCloud = "privateCloud974897778";

    Credentials actualResponse = client.showNsxCredentials(privateCloud);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowNsxCredentialsRequest actualRequest = ((ShowNsxCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showNsxCredentialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String privateCloud = "privateCloud974897778";
      client.showNsxCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showVcenterCredentialsTest() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    Credentials actualResponse = client.showVcenterCredentials(privateCloud);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowVcenterCredentialsRequest actualRequest =
        ((ShowVcenterCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud.toString(), actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showVcenterCredentialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.showVcenterCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showVcenterCredentialsTest2() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String privateCloud = "privateCloud974897778";

    Credentials actualResponse = client.showVcenterCredentials(privateCloud);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowVcenterCredentialsRequest actualRequest =
        ((ShowVcenterCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showVcenterCredentialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String privateCloud = "privateCloud974897778";
      client.showVcenterCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetNsxCredentialsTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetNsxCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.resetNsxCredentialsAsync(privateCloud).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetNsxCredentialsRequest actualRequest = ((ResetNsxCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud.toString(), actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetNsxCredentialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.resetNsxCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetNsxCredentialsTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetNsxCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String privateCloud = "privateCloud974897778";

    PrivateCloud actualResponse = client.resetNsxCredentialsAsync(privateCloud).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetNsxCredentialsRequest actualRequest = ((ResetNsxCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetNsxCredentialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String privateCloud = "privateCloud974897778";
      client.resetNsxCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetVcenterCredentialsTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetVcenterCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.resetVcenterCredentialsAsync(privateCloud).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetVcenterCredentialsRequest actualRequest =
        ((ResetVcenterCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud.toString(), actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetVcenterCredentialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.resetVcenterCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetVcenterCredentialsTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetVcenterCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String privateCloud = "privateCloud974897778";

    PrivateCloud actualResponse = client.resetVcenterCredentialsAsync(privateCloud).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetVcenterCredentialsRequest actualRequest =
        ((ResetVcenterCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(privateCloud, actualRequest.getPrivateCloud());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetVcenterCredentialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String privateCloud = "privateCloud974897778";
      client.resetVcenterCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDnsForwardingTest() throws Exception {
    DnsForwarding expectedResponse =
        DnsForwarding.newBuilder()
            .setName(DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllForwardingRules(new ArrayList<DnsForwarding.ForwardingRule>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    DnsForwardingName name = DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    DnsForwarding actualResponse = client.getDnsForwarding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsForwardingRequest actualRequest = ((GetDnsForwardingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsForwardingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      DnsForwardingName name = DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.getDnsForwarding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDnsForwardingTest2() throws Exception {
    DnsForwarding expectedResponse =
        DnsForwarding.newBuilder()
            .setName(DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllForwardingRules(new ArrayList<DnsForwarding.ForwardingRule>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    DnsForwarding actualResponse = client.getDnsForwarding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsForwardingRequest actualRequest = ((GetDnsForwardingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsForwardingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getDnsForwarding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDnsForwardingTest() throws Exception {
    DnsForwarding expectedResponse =
        DnsForwarding.newBuilder()
            .setName(DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllForwardingRules(new ArrayList<DnsForwarding.ForwardingRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDnsForwardingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    DnsForwarding dnsForwarding = DnsForwarding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DnsForwarding actualResponse = client.updateDnsForwardingAsync(dnsForwarding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDnsForwardingRequest actualRequest = ((UpdateDnsForwardingRequest) actualRequests.get(0));

    Assert.assertEquals(dnsForwarding, actualRequest.getDnsForwarding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDnsForwardingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      DnsForwarding dnsForwarding = DnsForwarding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDnsForwardingAsync(dnsForwarding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getNetworkPeeringTest() throws Exception {
    NetworkPeering expectedResponse =
        NetworkPeering.newBuilder()
            .setName(
                NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPeerNetwork("peerNetwork392662636")
            .setExportCustomRoutes(true)
            .setImportCustomRoutes(true)
            .setExchangeSubnetRoutes(true)
            .setExportCustomRoutesWithPublicIp(true)
            .setImportCustomRoutesWithPublicIp(true)
            .setStateDetails("stateDetails1730982001")
            .setPeerMtu(69584721)
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NetworkPeeringName name = NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");

    NetworkPeering actualResponse = client.getNetworkPeering(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkPeeringRequest actualRequest = ((GetNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkPeeringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPeeringName name =
          NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
      client.getNetworkPeering(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkPeeringTest2() throws Exception {
    NetworkPeering expectedResponse =
        NetworkPeering.newBuilder()
            .setName(
                NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPeerNetwork("peerNetwork392662636")
            .setExportCustomRoutes(true)
            .setImportCustomRoutes(true)
            .setExchangeSubnetRoutes(true)
            .setExportCustomRoutesWithPublicIp(true)
            .setImportCustomRoutesWithPublicIp(true)
            .setStateDetails("stateDetails1730982001")
            .setPeerMtu(69584721)
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    NetworkPeering actualResponse = client.getNetworkPeering(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkPeeringRequest actualRequest = ((GetNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkPeeringExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getNetworkPeering(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPeeringsTest() throws Exception {
    NetworkPeering responsesElement = NetworkPeering.newBuilder().build();
    ListNetworkPeeringsResponse expectedResponse =
        ListNetworkPeeringsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPeerings(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworkPeeringsPagedResponse pagedListResponse = client.listNetworkPeerings(parent);

    List<NetworkPeering> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPeeringsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkPeeringsRequest actualRequest = ((ListNetworkPeeringsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkPeeringsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworkPeerings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPeeringsTest2() throws Exception {
    NetworkPeering responsesElement = NetworkPeering.newBuilder().build();
    ListNetworkPeeringsResponse expectedResponse =
        ListNetworkPeeringsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPeerings(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNetworkPeeringsPagedResponse pagedListResponse = client.listNetworkPeerings(parent);

    List<NetworkPeering> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPeeringsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkPeeringsRequest actualRequest = ((ListNetworkPeeringsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkPeeringsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNetworkPeerings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNetworkPeeringTest() throws Exception {
    NetworkPeering expectedResponse =
        NetworkPeering.newBuilder()
            .setName(
                NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPeerNetwork("peerNetwork392662636")
            .setExportCustomRoutes(true)
            .setImportCustomRoutes(true)
            .setExchangeSubnetRoutes(true)
            .setExportCustomRoutesWithPublicIp(true)
            .setImportCustomRoutesWithPublicIp(true)
            .setStateDetails("stateDetails1730982001")
            .setPeerMtu(69584721)
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPeeringTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
    String networkPeeringId = "networkPeeringId1321772525";

    NetworkPeering actualResponse =
        client.createNetworkPeeringAsync(parent, networkPeering, networkPeeringId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkPeeringRequest actualRequest =
        ((CreateNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(networkPeering, actualRequest.getNetworkPeering());
    Assert.assertEquals(networkPeeringId, actualRequest.getNetworkPeeringId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkPeeringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
      String networkPeeringId = "networkPeeringId1321772525";
      client.createNetworkPeeringAsync(parent, networkPeering, networkPeeringId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNetworkPeeringTest2() throws Exception {
    NetworkPeering expectedResponse =
        NetworkPeering.newBuilder()
            .setName(
                NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPeerNetwork("peerNetwork392662636")
            .setExportCustomRoutes(true)
            .setImportCustomRoutes(true)
            .setExchangeSubnetRoutes(true)
            .setExportCustomRoutesWithPublicIp(true)
            .setImportCustomRoutesWithPublicIp(true)
            .setStateDetails("stateDetails1730982001")
            .setPeerMtu(69584721)
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPeeringTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
    String networkPeeringId = "networkPeeringId1321772525";

    NetworkPeering actualResponse =
        client.createNetworkPeeringAsync(parent, networkPeering, networkPeeringId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkPeeringRequest actualRequest =
        ((CreateNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(networkPeering, actualRequest.getNetworkPeering());
    Assert.assertEquals(networkPeeringId, actualRequest.getNetworkPeeringId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkPeeringExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
      String networkPeeringId = "networkPeeringId1321772525";
      client.createNetworkPeeringAsync(parent, networkPeering, networkPeeringId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkPeeringTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPeeringTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    NetworkPeeringName name = NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");

    client.deleteNetworkPeeringAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkPeeringRequest actualRequest =
        ((DeleteNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkPeeringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPeeringName name =
          NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
      client.deleteNetworkPeeringAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkPeeringTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPeeringTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNetworkPeeringAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkPeeringRequest actualRequest =
        ((DeleteNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkPeeringExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNetworkPeeringAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateNetworkPeeringTest() throws Exception {
    NetworkPeering expectedResponse =
        NetworkPeering.newBuilder()
            .setName(
                NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPeerNetwork("peerNetwork392662636")
            .setExportCustomRoutes(true)
            .setImportCustomRoutes(true)
            .setExchangeSubnetRoutes(true)
            .setExportCustomRoutesWithPublicIp(true)
            .setImportCustomRoutesWithPublicIp(true)
            .setStateDetails("stateDetails1730982001")
            .setPeerMtu(69584721)
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNetworkPeeringTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NetworkPeering actualResponse =
        client.updateNetworkPeeringAsync(networkPeering, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNetworkPeeringRequest actualRequest =
        ((UpdateNetworkPeeringRequest) actualRequests.get(0));

    Assert.assertEquals(networkPeering, actualRequest.getNetworkPeering());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNetworkPeeringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetworkPeeringAsync(networkPeering, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPeeringRoutesTest() throws Exception {
    PeeringRoute responsesElement = PeeringRoute.newBuilder().build();
    ListPeeringRoutesResponse expectedResponse =
        ListPeeringRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPeeringRoutes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NetworkPeeringName parent =
        NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");

    ListPeeringRoutesPagedResponse pagedListResponse = client.listPeeringRoutes(parent);

    List<PeeringRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPeeringRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPeeringRoutesRequest actualRequest = ((ListPeeringRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPeeringRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPeeringName parent =
          NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
      client.listPeeringRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPeeringRoutesTest2() throws Exception {
    PeeringRoute responsesElement = PeeringRoute.newBuilder().build();
    ListPeeringRoutesResponse expectedResponse =
        ListPeeringRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPeeringRoutes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPeeringRoutesPagedResponse pagedListResponse = client.listPeeringRoutes(parent);

    List<PeeringRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPeeringRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPeeringRoutesRequest actualRequest = ((ListPeeringRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPeeringRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPeeringRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHcxActivationKeyTest() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHcxActivationKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
    String hcxActivationKeyId = "hcxActivationKeyId-645871673";

    HcxActivationKey actualResponse =
        client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHcxActivationKeyRequest actualRequest =
        ((CreateHcxActivationKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hcxActivationKey, actualRequest.getHcxActivationKey());
    Assert.assertEquals(hcxActivationKeyId, actualRequest.getHcxActivationKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHcxActivationKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
      String hcxActivationKeyId = "hcxActivationKeyId-645871673";
      client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHcxActivationKeyTest2() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHcxActivationKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
    String hcxActivationKeyId = "hcxActivationKeyId-645871673";

    HcxActivationKey actualResponse =
        client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHcxActivationKeyRequest actualRequest =
        ((CreateHcxActivationKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hcxActivationKey, actualRequest.getHcxActivationKey());
    Assert.assertEquals(hcxActivationKeyId, actualRequest.getHcxActivationKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHcxActivationKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
      String hcxActivationKeyId = "hcxActivationKeyId-645871673";
      client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHcxActivationKeysTest() throws Exception {
    HcxActivationKey responsesElement = HcxActivationKey.newBuilder().build();
    ListHcxActivationKeysResponse expectedResponse =
        ListHcxActivationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHcxActivationKeys(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListHcxActivationKeysPagedResponse pagedListResponse = client.listHcxActivationKeys(parent);

    List<HcxActivationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHcxActivationKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHcxActivationKeysRequest actualRequest =
        ((ListHcxActivationKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHcxActivationKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listHcxActivationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHcxActivationKeysTest2() throws Exception {
    HcxActivationKey responsesElement = HcxActivationKey.newBuilder().build();
    ListHcxActivationKeysResponse expectedResponse =
        ListHcxActivationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHcxActivationKeys(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHcxActivationKeysPagedResponse pagedListResponse = client.listHcxActivationKeys(parent);

    List<HcxActivationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHcxActivationKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHcxActivationKeysRequest actualRequest =
        ((ListHcxActivationKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHcxActivationKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHcxActivationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHcxActivationKeyTest() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    HcxActivationKeyName name =
        HcxActivationKeyName.of(
            "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");

    HcxActivationKey actualResponse = client.getHcxActivationKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHcxActivationKeyRequest actualRequest = ((GetHcxActivationKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHcxActivationKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      HcxActivationKeyName name =
          HcxActivationKeyName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");
      client.getHcxActivationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHcxActivationKeyTest2() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    HcxActivationKey actualResponse = client.getHcxActivationKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHcxActivationKeyRequest actualRequest = ((GetHcxActivationKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHcxActivationKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getHcxActivationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    NetworkPolicy actualResponse = client.getNetworkPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkPolicyRequest actualRequest = ((GetNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.getNetworkPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkPolicyTest2() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    NetworkPolicy actualResponse = client.getNetworkPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkPolicyRequest actualRequest = ((GetNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getNetworkPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPoliciesTest() throws Exception {
    NetworkPolicy responsesElement = NetworkPolicy.newBuilder().build();
    ListNetworkPoliciesResponse expectedResponse =
        ListNetworkPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPolicies(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworkPoliciesPagedResponse pagedListResponse = client.listNetworkPolicies(parent);

    List<NetworkPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkPoliciesRequest actualRequest = ((ListNetworkPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworkPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPoliciesTest2() throws Exception {
    NetworkPolicy responsesElement = NetworkPolicy.newBuilder().build();
    ListNetworkPoliciesResponse expectedResponse =
        ListNetworkPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPolicies(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNetworkPoliciesPagedResponse pagedListResponse = client.listNetworkPolicies(parent);

    List<NetworkPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkPoliciesRequest actualRequest = ((ListNetworkPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNetworkPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
    String networkPolicyId = "networkPolicyId-727262661";

    NetworkPolicy actualResponse =
        client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkPolicyRequest actualRequest = ((CreateNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(networkPolicy, actualRequest.getNetworkPolicy());
    Assert.assertEquals(networkPolicyId, actualRequest.getNetworkPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      String networkPolicyId = "networkPolicyId-727262661";
      client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNetworkPolicyTest2() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
    String networkPolicyId = "networkPolicyId-727262661";

    NetworkPolicy actualResponse =
        client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkPolicyRequest actualRequest = ((CreateNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(networkPolicy, actualRequest.getNetworkPolicy());
    Assert.assertEquals(networkPolicyId, actualRequest.getNetworkPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      String networkPolicyId = "networkPolicyId-727262661";
      client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NetworkPolicy actualResponse = client.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNetworkPolicyRequest actualRequest = ((UpdateNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(networkPolicy, actualRequest.getNetworkPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNetworkPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    client.deleteNetworkPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkPolicyRequest actualRequest = ((DeleteNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.deleteNetworkPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNetworkPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkPolicyRequest actualRequest = ((DeleteNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNetworkPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listManagementDnsZoneBindingsTest() throws Exception {
    ManagementDnsZoneBinding responsesElement = ManagementDnsZoneBinding.newBuilder().build();
    ListManagementDnsZoneBindingsResponse expectedResponse =
        ListManagementDnsZoneBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllManagementDnsZoneBindings(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListManagementDnsZoneBindingsPagedResponse pagedListResponse =
        client.listManagementDnsZoneBindings(parent);

    List<ManagementDnsZoneBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getManagementDnsZoneBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListManagementDnsZoneBindingsRequest actualRequest =
        ((ListManagementDnsZoneBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listManagementDnsZoneBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listManagementDnsZoneBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listManagementDnsZoneBindingsTest2() throws Exception {
    ManagementDnsZoneBinding responsesElement = ManagementDnsZoneBinding.newBuilder().build();
    ListManagementDnsZoneBindingsResponse expectedResponse =
        ListManagementDnsZoneBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllManagementDnsZoneBindings(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListManagementDnsZoneBindingsPagedResponse pagedListResponse =
        client.listManagementDnsZoneBindings(parent);

    List<ManagementDnsZoneBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getManagementDnsZoneBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListManagementDnsZoneBindingsRequest actualRequest =
        ((ListManagementDnsZoneBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listManagementDnsZoneBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listManagementDnsZoneBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getManagementDnsZoneBindingTest() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    ManagementDnsZoneBindingName name =
        ManagementDnsZoneBindingName.of(
            "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");

    ManagementDnsZoneBinding actualResponse = client.getManagementDnsZoneBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetManagementDnsZoneBindingRequest actualRequest =
        ((GetManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getManagementDnsZoneBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ManagementDnsZoneBindingName name =
          ManagementDnsZoneBindingName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
      client.getManagementDnsZoneBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getManagementDnsZoneBindingTest2() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    ManagementDnsZoneBinding actualResponse = client.getManagementDnsZoneBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetManagementDnsZoneBindingRequest actualRequest =
        ((GetManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getManagementDnsZoneBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getManagementDnsZoneBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createManagementDnsZoneBindingTest() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    ManagementDnsZoneBinding managementDnsZoneBinding =
        ManagementDnsZoneBinding.newBuilder().build();
    String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";

    ManagementDnsZoneBinding actualResponse =
        client
            .createManagementDnsZoneBindingAsync(
                parent, managementDnsZoneBinding, managementDnsZoneBindingId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateManagementDnsZoneBindingRequest actualRequest =
        ((CreateManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(managementDnsZoneBinding, actualRequest.getManagementDnsZoneBinding());
    Assert.assertEquals(managementDnsZoneBindingId, actualRequest.getManagementDnsZoneBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createManagementDnsZoneBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      ManagementDnsZoneBinding managementDnsZoneBinding =
          ManagementDnsZoneBinding.newBuilder().build();
      String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";
      client
          .createManagementDnsZoneBindingAsync(
              parent, managementDnsZoneBinding, managementDnsZoneBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createManagementDnsZoneBindingTest2() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    ManagementDnsZoneBinding managementDnsZoneBinding =
        ManagementDnsZoneBinding.newBuilder().build();
    String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";

    ManagementDnsZoneBinding actualResponse =
        client
            .createManagementDnsZoneBindingAsync(
                parent, managementDnsZoneBinding, managementDnsZoneBindingId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateManagementDnsZoneBindingRequest actualRequest =
        ((CreateManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(managementDnsZoneBinding, actualRequest.getManagementDnsZoneBinding());
    Assert.assertEquals(managementDnsZoneBindingId, actualRequest.getManagementDnsZoneBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createManagementDnsZoneBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      ManagementDnsZoneBinding managementDnsZoneBinding =
          ManagementDnsZoneBinding.newBuilder().build();
      String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";
      client
          .createManagementDnsZoneBindingAsync(
              parent, managementDnsZoneBinding, managementDnsZoneBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateManagementDnsZoneBindingTest() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ManagementDnsZoneBinding managementDnsZoneBinding =
        ManagementDnsZoneBinding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ManagementDnsZoneBinding actualResponse =
        client.updateManagementDnsZoneBindingAsync(managementDnsZoneBinding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateManagementDnsZoneBindingRequest actualRequest =
        ((UpdateManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(managementDnsZoneBinding, actualRequest.getManagementDnsZoneBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateManagementDnsZoneBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ManagementDnsZoneBinding managementDnsZoneBinding =
          ManagementDnsZoneBinding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateManagementDnsZoneBindingAsync(managementDnsZoneBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteManagementDnsZoneBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ManagementDnsZoneBindingName name =
        ManagementDnsZoneBindingName.of(
            "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");

    client.deleteManagementDnsZoneBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteManagementDnsZoneBindingRequest actualRequest =
        ((DeleteManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteManagementDnsZoneBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ManagementDnsZoneBindingName name =
          ManagementDnsZoneBindingName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
      client.deleteManagementDnsZoneBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteManagementDnsZoneBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteManagementDnsZoneBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteManagementDnsZoneBindingRequest actualRequest =
        ((DeleteManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteManagementDnsZoneBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteManagementDnsZoneBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void repairManagementDnsZoneBindingTest() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("repairManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    ManagementDnsZoneBindingName name =
        ManagementDnsZoneBindingName.of(
            "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");

    ManagementDnsZoneBinding actualResponse =
        client.repairManagementDnsZoneBindingAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RepairManagementDnsZoneBindingRequest actualRequest =
        ((RepairManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void repairManagementDnsZoneBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      ManagementDnsZoneBindingName name =
          ManagementDnsZoneBindingName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
      client.repairManagementDnsZoneBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void repairManagementDnsZoneBindingTest2() throws Exception {
    ManagementDnsZoneBinding expectedResponse =
        ManagementDnsZoneBinding.newBuilder()
            .setName(
                ManagementDnsZoneBindingName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[PRIVATE_CLOUD]",
                        "[MANAGEMENT_DNS_ZONE_BINDING]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("repairManagementDnsZoneBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    ManagementDnsZoneBinding actualResponse =
        client.repairManagementDnsZoneBindingAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RepairManagementDnsZoneBindingRequest actualRequest =
        ((RepairManagementDnsZoneBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void repairManagementDnsZoneBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.repairManagementDnsZoneBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
    String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";

    VmwareEngineNetwork actualResponse =
        client
            .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVmwareEngineNetworkRequest actualRequest =
        ((CreateVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vmwareEngineNetwork, actualRequest.getVmwareEngineNetwork());
    Assert.assertEquals(vmwareEngineNetworkId, actualRequest.getVmwareEngineNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVmwareEngineNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
      String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
      client
          .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVmwareEngineNetworkTest2() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
    String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";

    VmwareEngineNetwork actualResponse =
        client
            .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVmwareEngineNetworkRequest actualRequest =
        ((CreateVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(vmwareEngineNetwork, actualRequest.getVmwareEngineNetwork());
    Assert.assertEquals(vmwareEngineNetworkId, actualRequest.getVmwareEngineNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVmwareEngineNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
      String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
      client
          .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    VmwareEngineNetwork actualResponse =
        client.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVmwareEngineNetworkRequest actualRequest =
        ((UpdateVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(vmwareEngineNetwork, actualRequest.getVmwareEngineNetwork());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVmwareEngineNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVmwareEngineNetworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    VmwareEngineNetworkName name =
        VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");

    client.deleteVmwareEngineNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVmwareEngineNetworkRequest actualRequest =
        ((DeleteVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVmwareEngineNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      VmwareEngineNetworkName name =
          VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
      client.deleteVmwareEngineNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVmwareEngineNetworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteVmwareEngineNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVmwareEngineNetworkRequest actualRequest =
        ((DeleteVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVmwareEngineNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVmwareEngineNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    VmwareEngineNetworkName name =
        VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");

    VmwareEngineNetwork actualResponse = client.getVmwareEngineNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVmwareEngineNetworkRequest actualRequest =
        ((GetVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVmwareEngineNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      VmwareEngineNetworkName name =
          VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
      client.getVmwareEngineNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVmwareEngineNetworkTest2() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    VmwareEngineNetwork actualResponse = client.getVmwareEngineNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVmwareEngineNetworkRequest actualRequest =
        ((GetVmwareEngineNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVmwareEngineNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getVmwareEngineNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVmwareEngineNetworksTest() throws Exception {
    VmwareEngineNetwork responsesElement = VmwareEngineNetwork.newBuilder().build();
    ListVmwareEngineNetworksResponse expectedResponse =
        ListVmwareEngineNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllVmwareEngineNetworks(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVmwareEngineNetworksPagedResponse pagedListResponse =
        client.listVmwareEngineNetworks(parent);

    List<VmwareEngineNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVmwareEngineNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVmwareEngineNetworksRequest actualRequest =
        ((ListVmwareEngineNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVmwareEngineNetworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVmwareEngineNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVmwareEngineNetworksTest2() throws Exception {
    VmwareEngineNetwork responsesElement = VmwareEngineNetwork.newBuilder().build();
    ListVmwareEngineNetworksResponse expectedResponse =
        ListVmwareEngineNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllVmwareEngineNetworks(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVmwareEngineNetworksPagedResponse pagedListResponse =
        client.listVmwareEngineNetworks(parent);

    List<VmwareEngineNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVmwareEngineNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVmwareEngineNetworksRequest actualRequest =
        ((ListVmwareEngineNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVmwareEngineNetworksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVmwareEngineNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setPeeringId("peeringId-2128589701")
            .setUid("uid115792")
            .setServiceNetwork("serviceNetwork-195025479")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setPeeringId("peeringId-2128589701")
            .setUid("uid115792")
            .setServiceNetwork("serviceNetwork-195025479")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setPeeringId("peeringId-2128589701")
            .setUid("uid115792")
            .setServiceNetwork("serviceNetwork-195025479")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setPeeringId("peeringId-2128589701")
            .setUid("uid115792")
            .setServiceNetwork("serviceNetwork-195025479")
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest2() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setPeeringId("peeringId-2128589701")
            .setUid("uid115792")
            .setServiceNetwork("serviceNetwork-195025479")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateConnection actualResponse =
        client.updatePrivateConnectionAsync(privateConnection, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePrivateConnectionRequest actualRequest =
        ((UpdatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateConnectionAsync(privateConnection, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPrivateConnectionPeeringRoutesTest() throws Exception {
    PeeringRoute responsesElement = PeeringRoute.newBuilder().build();
    ListPrivateConnectionPeeringRoutesResponse expectedResponse =
        ListPrivateConnectionPeeringRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPeeringRoutes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    PrivateConnectionName parent =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    ListPrivateConnectionPeeringRoutesPagedResponse pagedListResponse =
        client.listPrivateConnectionPeeringRoutes(parent);

    List<PeeringRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPeeringRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionPeeringRoutesRequest actualRequest =
        ((ListPrivateConnectionPeeringRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionPeeringRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      PrivateConnectionName parent =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.listPrivateConnectionPeeringRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionPeeringRoutesTest2() throws Exception {
    PeeringRoute responsesElement = PeeringRoute.newBuilder().build();
    ListPrivateConnectionPeeringRoutesResponse expectedResponse =
        ListPrivateConnectionPeeringRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPeeringRoutes(Arrays.asList(responsesElement))
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrivateConnectionPeeringRoutesPagedResponse pagedListResponse =
        client.listPrivateConnectionPeeringRoutes(parent);

    List<PeeringRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPeeringRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionPeeringRoutesRequest actualRequest =
        ((ListPrivateConnectionPeeringRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionPeeringRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrivateConnectionPeeringRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void grantDnsBindPermissionTest() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("grantDnsBindPermissionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
    Principal principal = Principal.newBuilder().build();

    DnsBindPermission actualResponse = client.grantDnsBindPermissionAsync(name, principal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GrantDnsBindPermissionRequest actualRequest =
        ((GrantDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(principal, actualRequest.getPrincipal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void grantDnsBindPermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
      Principal principal = Principal.newBuilder().build();
      client.grantDnsBindPermissionAsync(name, principal).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void grantDnsBindPermissionTest2() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("grantDnsBindPermissionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";
    Principal principal = Principal.newBuilder().build();

    DnsBindPermission actualResponse = client.grantDnsBindPermissionAsync(name, principal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GrantDnsBindPermissionRequest actualRequest =
        ((GrantDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(principal, actualRequest.getPrincipal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void grantDnsBindPermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      Principal principal = Principal.newBuilder().build();
      client.grantDnsBindPermissionAsync(name, principal).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDnsBindPermissionTest() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");

    DnsBindPermission actualResponse = client.getDnsBindPermission(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsBindPermissionRequest actualRequest =
        ((GetDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsBindPermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
      client.getDnsBindPermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDnsBindPermissionTest2() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    mockVmwareEngine.addResponse(expectedResponse);

    String name = "name3373707";

    DnsBindPermission actualResponse = client.getDnsBindPermission(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsBindPermissionRequest actualRequest =
        ((GetDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsBindPermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getDnsBindPermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeDnsBindPermissionTest() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("revokeDnsBindPermissionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
    Principal principal = Principal.newBuilder().build();

    DnsBindPermission actualResponse = client.revokeDnsBindPermissionAsync(name, principal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeDnsBindPermissionRequest actualRequest =
        ((RevokeDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(principal, actualRequest.getPrincipal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeDnsBindPermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
      Principal principal = Principal.newBuilder().build();
      client.revokeDnsBindPermissionAsync(name, principal).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void revokeDnsBindPermissionTest2() throws Exception {
    DnsBindPermission expectedResponse =
        DnsBindPermission.newBuilder()
            .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllPrincipals(new ArrayList<Principal>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("revokeDnsBindPermissionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVmwareEngine.addResponse(resultOperation);

    String name = "name3373707";
    Principal principal = Principal.newBuilder().build();

    DnsBindPermission actualResponse = client.revokeDnsBindPermissionAsync(name, principal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVmwareEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeDnsBindPermissionRequest actualRequest =
        ((RevokeDnsBindPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(principal, actualRequest.getPrincipal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeDnsBindPermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVmwareEngine.addException(exception);

    try {
      String name = "name3373707";
      Principal principal = Principal.newBuilder().build();
      client.revokeDnsBindPermissionAsync(name, principal).get();
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
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
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
