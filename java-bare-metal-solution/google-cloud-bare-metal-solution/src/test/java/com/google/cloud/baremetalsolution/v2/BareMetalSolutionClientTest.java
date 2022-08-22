/*
 * Copyright 2022 Google LLC
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
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
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
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
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
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
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
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
  public void startInstanceTest() throws Exception {
    StartInstanceResponse expectedResponse = StartInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    StartInstanceResponse actualResponse = client.startInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartInstanceRequest actualRequest = ((StartInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startInstanceTest2() throws Exception {
    StartInstanceResponse expectedResponse = StartInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String name = "name3373707";

    StartInstanceResponse actualResponse = client.startInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartInstanceRequest actualRequest = ((StartInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopInstanceTest() throws Exception {
    StopInstanceResponse expectedResponse = StopInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    StopInstanceResponse actualResponse = client.stopInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopInstanceRequest actualRequest = ((StopInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopInstanceTest2() throws Exception {
    StopInstanceResponse expectedResponse = StopInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String name = "name3373707";

    StopInstanceResponse actualResponse = client.stopInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopInstanceRequest actualRequest = ((StopInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachLunTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachLunRequest actualRequest = ((DetachLunRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertEquals(lun.toString(), actualRequest.getLun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachLunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachLunTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String lun = "lun107525";

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachLunRequest actualRequest = ((DetachLunRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertEquals(lun, actualRequest.getLun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachLunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String lun = "lun107525";
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachLunTest3() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String instance = "instance555127957";
    LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachLunRequest actualRequest = ((DetachLunRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(lun.toString(), actualRequest.getLun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachLunExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String instance = "instance555127957";
      LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachLunTest4() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String instance = "instance555127957";
    String lun = "lun107525";

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachLunRequest actualRequest = ((DetachLunRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(lun, actualRequest.getLun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachLunExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String instance = "instance555127957";
      String lun = "lun107525";
      client.detachLunAsync(instance, lun).get();
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
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
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
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
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
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
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
  public void resizeVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resizeVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
    long sizeGib = 847296130;

    Volume actualResponse = client.resizeVolumeAsync(volume, sizeGib).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResizeVolumeRequest actualRequest = ((ResizeVolumeRequest) actualRequests.get(0));

    Assert.assertEquals(volume.toString(), actualRequest.getVolume());
    Assert.assertEquals(sizeGib, actualRequest.getSizeGib());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resizeVolumeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      long sizeGib = 847296130;
      client.resizeVolumeAsync(volume, sizeGib).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resizeVolumeTest2() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resizeVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    String volume = "volume-810883302";
    long sizeGib = 847296130;

    Volume actualResponse = client.resizeVolumeAsync(volume, sizeGib).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResizeVolumeRequest actualRequest = ((ResizeVolumeRequest) actualRequests.get(0));

    Assert.assertEquals(volume, actualRequest.getVolume());
    Assert.assertEquals(sizeGib, actualRequest.getSizeGib());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resizeVolumeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String volume = "volume-810883302";
      long sizeGib = 847296130;
      client.resizeVolumeAsync(volume, sizeGib).get();
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
  public void listNetworkUsageTest() throws Exception {
    ListNetworkUsageResponse expectedResponse =
        ListNetworkUsageResponse.newBuilder().addAllNetworks(new ArrayList<NetworkUsage>()).build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworkUsageResponse actualResponse = client.listNetworkUsage(location);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkUsageRequest actualRequest = ((ListNetworkUsageRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkUsageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworkUsage(location);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkUsageTest2() throws Exception {
    ListNetworkUsageResponse expectedResponse =
        ListNetworkUsageResponse.newBuilder().addAllNetworks(new ArrayList<NetworkUsage>()).build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String location = "location1901043637";

    ListNetworkUsageResponse actualResponse = client.listNetworkUsage(location);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworkUsageRequest actualRequest = ((ListNetworkUsageRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworkUsageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String location = "location1901043637";
      client.listNetworkUsage(location);
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
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
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
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
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
  public void updateNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    Network network = Network.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Network actualResponse = client.updateNetworkAsync(network, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNetworkRequest actualRequest = ((UpdateNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(network, actualRequest.getNetwork());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      Network network = Network.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetworkAsync(network, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getLunTest() throws Exception {
    Lun expectedResponse =
        Lun.newBuilder()
            .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
            .setId("id3355")
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
            .setId("id3355")
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

  @Test
  public void getNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");

    NfsShare actualResponse = client.getNfsShare(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNfsShareRequest actualRequest = ((GetNfsShareRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNfsShareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
      client.getNfsShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNfsShareTest2() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String name = "name3373707";

    NfsShare actualResponse = client.getNfsShare(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNfsShareRequest actualRequest = ((GetNfsShareRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNfsShareExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String name = "name3373707";
      client.getNfsShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNfsSharesTest() throws Exception {
    NfsShare responsesElement = NfsShare.newBuilder().build();
    ListNfsSharesResponse expectedResponse =
        ListNfsSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNfsShares(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNfsSharesPagedResponse pagedListResponse = client.listNfsShares(parent);

    List<NfsShare> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNfsSharesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNfsSharesRequest actualRequest = ((ListNfsSharesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNfsSharesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNfsShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNfsSharesTest2() throws Exception {
    NfsShare responsesElement = NfsShare.newBuilder().build();
    ListNfsSharesResponse expectedResponse =
        ListNfsSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNfsShares(Arrays.asList(responsesElement))
            .build();
    mockBareMetalSolution.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNfsSharesPagedResponse pagedListResponse = client.listNfsShares(parent);

    List<NfsShare> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNfsSharesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNfsSharesRequest actualRequest = ((ListNfsSharesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNfsSharesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNfsShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBareMetalSolution.addResponse(resultOperation);

    NfsShare nfsShare = NfsShare.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NfsShare actualResponse = client.updateNfsShareAsync(nfsShare, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBareMetalSolution.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNfsShareRequest actualRequest = ((UpdateNfsShareRequest) actualRequests.get(0));

    Assert.assertEquals(nfsShare, actualRequest.getNfsShare());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNfsShareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBareMetalSolution.addException(exception);

    try {
      NfsShare nfsShare = NfsShare.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNfsShareAsync(nfsShare, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
