/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.baremetalsolution.v2;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSnapshotSchedulePoliciesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
public class BareMetalSolutionClientTest {
  private static MockBareMetalSolution mockBareMetalSolution;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BareMetalSolutionClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBareMetalSolution = new MockBareMetalSolution();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBareMetalSolution));
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
    BareMetalSolutionSettings settings =
        BareMetalSolutionSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BareMetalSolutionClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetInstanceTest() throws Exception {
    ResetInstanceResponse expectedResponse = ResetInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ResetInstanceResponse actualResponse = client.resetInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetInstanceRequest actualRequest = ((ResetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.resetInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetInstanceTest2() throws Exception {
    ResetInstanceResponse expectedResponse = ResetInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String name = "name3373707";

    ResetInstanceResponse actualResponse = client.resetInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetInstanceRequest actualRequest = ((ResetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.resetInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listVolumesTest() throws Exception {
    Volume responsesElement = Volume.newBuilder().build();
    ListVolumesResponse expectedResponse =
        ListVolumesResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumes(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVolumesPagedResponse pagedListResponse = client.listVolumes(parent);

    List<Volume> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumesRequest actualRequest = ((ListVolumesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVolumes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumesTest2() throws Exception {
    Volume responsesElement = Volume.newBuilder().build();
    ListVolumesResponse expectedResponse =
        ListVolumesResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumes(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVolumesPagedResponse pagedListResponse = client.listVolumes(parent);

    List<Volume> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumesRequest actualRequest = ((ListVolumesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVolumes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .setSnapshotSchedulePolicy(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    Volume actualResponse = client.getVolume(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeRequest actualRequest = ((GetVolumeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.getVolume(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeTest2() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .setSnapshotSchedulePolicy(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    Volume actualResponse = client.getVolume(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeRequest actualRequest = ((GetVolumeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getVolume(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .setSnapshotSchedulePolicy(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    Volume volume = Volume.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Volume actualResponse = client.updateVolumeAsync(volume, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVolumeRequest actualRequest = ((UpdateVolumeRequest) actualRequests.get(0));

    Assert.assertEquals(volume, actualRequest.getVolume());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVolumeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      Volume volume = Volume.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVolumeAsync(volume, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listNetworksTest() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworksRequest actualRequest = ((ListNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworksTest2() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworksRequest actualRequest = ((ListNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setNetwork("network1843485230")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");

    Network actualResponse = client.getNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkRequest actualRequest = ((GetNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setNetwork("network1843485230")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    Network actualResponse = client.getNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkRequest actualRequest = ((GetNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnapshotSchedulePoliciesTest() throws Exception {
    SnapshotSchedulePolicy responsesElement = SnapshotSchedulePolicy.newBuilder().build();
    ListSnapshotSchedulePoliciesResponse expectedResponse =
        ListSnapshotSchedulePoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshotSchedulePolicies(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSnapshotSchedulePoliciesPagedResponse pagedListResponse =
        client.listSnapshotSchedulePolicies(parent);

    List<SnapshotSchedulePolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSnapshotSchedulePoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnapshotSchedulePoliciesRequest actualRequest =
        ((ListSnapshotSchedulePoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnapshotSchedulePoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSnapshotSchedulePolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnapshotSchedulePoliciesTest2() throws Exception {
    SnapshotSchedulePolicy responsesElement = SnapshotSchedulePolicy.newBuilder().build();
    ListSnapshotSchedulePoliciesResponse expectedResponse =
        ListSnapshotSchedulePoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshotSchedulePolicies(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSnapshotSchedulePoliciesPagedResponse pagedListResponse =
        client.listSnapshotSchedulePolicies(parent);

    List<SnapshotSchedulePolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSnapshotSchedulePoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnapshotSchedulePoliciesRequest actualRequest =
        ((ListSnapshotSchedulePoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnapshotSchedulePoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSnapshotSchedulePolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnapshotSchedulePolicyTest() throws Exception {
    SnapshotSchedulePolicy expectedResponse =
        SnapshotSchedulePolicy.newBuilder()
            .setName(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllSchedules(new ArrayList<SnapshotSchedulePolicy.Schedule>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    SnapshotSchedulePolicyName name =
        SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");

    SnapshotSchedulePolicy actualResponse = client.getSnapshotSchedulePolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnapshotSchedulePolicyRequest actualRequest =
        ((GetSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnapshotSchedulePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      SnapshotSchedulePolicyName name =
          SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");
      client.getSnapshotSchedulePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnapshotSchedulePolicyTest2() throws Exception {
    SnapshotSchedulePolicy expectedResponse =
        SnapshotSchedulePolicy.newBuilder()
            .setName(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllSchedules(new ArrayList<SnapshotSchedulePolicy.Schedule>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    SnapshotSchedulePolicy actualResponse = client.getSnapshotSchedulePolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnapshotSchedulePolicyRequest actualRequest =
        ((GetSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnapshotSchedulePolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getSnapshotSchedulePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotSchedulePolicyTest() throws Exception {
    SnapshotSchedulePolicy expectedResponse =
        SnapshotSchedulePolicy.newBuilder()
            .setName(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllSchedules(new ArrayList<SnapshotSchedulePolicy.Schedule>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
    String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";

    SnapshotSchedulePolicy actualResponse =
        client.createSnapshotSchedulePolicy(
            parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotSchedulePolicyRequest actualRequest =
        ((CreateSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(snapshotSchedulePolicy, actualRequest.getSnapshotSchedulePolicy());
    Assert.assertEquals(snapshotSchedulePolicyId, actualRequest.getSnapshotSchedulePolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotSchedulePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
      String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";
      client.createSnapshotSchedulePolicy(parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotSchedulePolicyTest2() throws Exception {
    SnapshotSchedulePolicy expectedResponse =
        SnapshotSchedulePolicy.newBuilder()
            .setName(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllSchedules(new ArrayList<SnapshotSchedulePolicy.Schedule>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
    String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";

    SnapshotSchedulePolicy actualResponse =
        client.createSnapshotSchedulePolicy(
            parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotSchedulePolicyRequest actualRequest =
        ((CreateSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(snapshotSchedulePolicy, actualRequest.getSnapshotSchedulePolicy());
    Assert.assertEquals(snapshotSchedulePolicyId, actualRequest.getSnapshotSchedulePolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotSchedulePolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
      String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";
      client.createSnapshotSchedulePolicy(parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSnapshotSchedulePolicyTest() throws Exception {
    SnapshotSchedulePolicy expectedResponse =
        SnapshotSchedulePolicy.newBuilder()
            .setName(
                SnapshotSchedulePolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllSchedules(new ArrayList<SnapshotSchedulePolicy.Schedule>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SnapshotSchedulePolicy actualResponse =
        client.updateSnapshotSchedulePolicy(snapshotSchedulePolicy, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSnapshotSchedulePolicyRequest actualRequest =
        ((UpdateSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(snapshotSchedulePolicy, actualRequest.getSnapshotSchedulePolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSnapshotSchedulePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSnapshotSchedulePolicy(snapshotSchedulePolicy, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSnapshotSchedulePolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBareMetalSolution.addResponse(expectedResponse);

    SnapshotSchedulePolicyName name =
        SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");

    client.deleteSnapshotSchedulePolicy(name);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSnapshotSchedulePolicyRequest actualRequest =
        ((DeleteSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSnapshotSchedulePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      SnapshotSchedulePolicyName name =
          SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");
      client.deleteSnapshotSchedulePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSnapshotSchedulePolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSnapshotSchedulePolicy(name);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSnapshotSchedulePolicyRequest actualRequest =
        ((DeleteSnapshotSchedulePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSnapshotSchedulePolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSnapshotSchedulePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
    VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();

    VolumeSnapshot actualResponse = client.createVolumeSnapshot(parent, volumeSnapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVolumeSnapshotRequest actualRequest =
        ((CreateVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(volumeSnapshot, actualRequest.getVolumeSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVolumeSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
      client.createVolumeSnapshot(parent, volumeSnapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";
    VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();

    VolumeSnapshot actualResponse = client.createVolumeSnapshot(parent, volumeSnapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVolumeSnapshotRequest actualRequest =
        ((CreateVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(volumeSnapshot, actualRequest.getVolumeSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVolumeSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
      client.createVolumeSnapshot(parent, volumeSnapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreVolumeSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    VolumeSnapshotName volumeSnapshot =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    VolumeSnapshot actualResponse = client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreVolumeSnapshotRequest actualRequest =
        ((RestoreVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(volumeSnapshot.toString(), actualRequest.getVolumeSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreVolumeSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeSnapshotName volumeSnapshot =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreVolumeSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String volumeSnapshot = "volumeSnapshot1771857662";

    VolumeSnapshot actualResponse = client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreVolumeSnapshotRequest actualRequest =
        ((RestoreVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(volumeSnapshot, actualRequest.getVolumeSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreVolumeSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String volumeSnapshot = "volumeSnapshot1771857662";
      client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVolumeSnapshotTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeSnapshotName name =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    client.deleteVolumeSnapshot(name);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVolumeSnapshotRequest actualRequest =
        ((DeleteVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVolumeSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeSnapshotName name =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.deleteVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteVolumeSnapshotTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteVolumeSnapshot(name);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVolumeSnapshotRequest actualRequest =
        ((DeleteVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVolumeSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeSnapshotName name =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    VolumeSnapshot actualResponse = client.getVolumeSnapshot(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeSnapshotRequest actualRequest = ((GetVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeSnapshotName name =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.getVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    VolumeSnapshot actualResponse = client.getVolumeSnapshot(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeSnapshotRequest actualRequest = ((GetVolumeSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeSnapshotsTest() throws Exception {
    VolumeSnapshot responsesElement = VolumeSnapshot.newBuilder().build();
    ListVolumeSnapshotsResponse expectedResponse =
        ListVolumeSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeSnapshots(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    ListVolumeSnapshotsPagedResponse pagedListResponse = client.listVolumeSnapshots(parent);

    List<VolumeSnapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeSnapshotsRequest actualRequest = ((ListVolumeSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeSnapshotsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.listVolumeSnapshots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeSnapshotsTest2() throws Exception {
    VolumeSnapshot responsesElement = VolumeSnapshot.newBuilder().build();
    ListVolumeSnapshotsResponse expectedResponse =
        ListVolumeSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeSnapshots(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVolumeSnapshotsPagedResponse pagedListResponse = client.listVolumeSnapshots(parent);

    List<VolumeSnapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeSnapshotsRequest actualRequest = ((ListVolumeSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeSnapshotsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVolumeSnapshots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLunTest() throws Exception {
    Lun expectedResponse =
        Lun.newBuilder()
            .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
            .setSizeGb(2105542105)
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setShareable(true)
            .setBootLun(true)
            .setWwid("wwid3662843")
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Lun actualResponse = client.getLun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLunRequest actualRequest = ((GetLunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.getLun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLunTest2() throws Exception {
    Lun expectedResponse =
        Lun.newBuilder()
            .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
            .setSizeGb(2105542105)
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setShareable(true)
            .setBootLun(true)
            .setWwid("wwid3662843")
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    Lun actualResponse = client.getLun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLunRequest actualRequest = ((GetLunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getLun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLunsTest() throws Exception {
    Lun responsesElement = Lun.newBuilder().build();
    ListLunsResponse expectedResponse =
        ListLunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLuns(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    ListLunsPagedResponse pagedListResponse = client.listLuns(parent);

    List<Lun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLunsRequest actualRequest = ((ListLunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.listLuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLunsTest2() throws Exception {
    Lun responsesElement = Lun.newBuilder().build();
    ListLunsResponse expectedResponse =
        ListLunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLuns(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLunsPagedResponse pagedListResponse = client.listLuns(parent);

    List<Lun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLunsRequest actualRequest = ((ListLunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
