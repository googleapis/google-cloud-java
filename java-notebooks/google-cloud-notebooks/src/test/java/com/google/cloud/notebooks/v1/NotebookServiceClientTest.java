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

package com.google.cloud.notebooks.v1;

import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListSchedulesPagedResponse;

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
public class NotebookServiceClientTest {
  private static MockNotebookService mockNotebookService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NotebookServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNotebookService = new MockNotebookService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockNotebookService));
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
    NotebookServiceSettings settings =
        NotebookServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NotebookServiceClient.create(settings);
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
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

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
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void registerInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    RegisterInstanceRequest request =
        RegisterInstanceRequest.newBuilder()
            .setParent("parent-995424086")
            .setInstanceId("instanceId902024336")
            .build();

    Instance actualResponse = client.registerInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterInstanceRequest actualRequest = ((RegisterInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInstanceId(), actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      RegisterInstanceRequest request =
          RegisterInstanceRequest.newBuilder()
              .setParent("parent-995424086")
              .setInstanceId("instanceId902024336")
              .build();
      client.registerInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setInstanceAcceleratorTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceAcceleratorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    SetInstanceAcceleratorRequest request =
        SetInstanceAcceleratorRequest.newBuilder()
            .setName("name3373707")
            .setCoreCount(-1963855761)
            .build();

    Instance actualResponse = client.setInstanceAcceleratorAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceAcceleratorRequest actualRequest =
        ((SetInstanceAcceleratorRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertEquals(request.getCoreCount(), actualRequest.getCoreCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setInstanceAcceleratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      SetInstanceAcceleratorRequest request =
          SetInstanceAcceleratorRequest.newBuilder()
              .setName("name3373707")
              .setCoreCount(-1963855761)
              .build();
      client.setInstanceAcceleratorAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setInstanceMachineTypeTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceMachineTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    SetInstanceMachineTypeRequest request =
        SetInstanceMachineTypeRequest.newBuilder()
            .setName("name3373707")
            .setMachineType("machineType-218117087")
            .build();

    Instance actualResponse = client.setInstanceMachineTypeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceMachineTypeRequest actualRequest =
        ((SetInstanceMachineTypeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getMachineType(), actualRequest.getMachineType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setInstanceMachineTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      SetInstanceMachineTypeRequest request =
          SetInstanceMachineTypeRequest.newBuilder()
              .setName("name3373707")
              .setMachineType("machineType-218117087")
              .build();
      client.setInstanceMachineTypeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceConfigTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    UpdateInstanceConfigRequest request =
        UpdateInstanceConfigRequest.newBuilder()
            .setName("name3373707")
            .setConfig(InstanceConfig.newBuilder().build())
            .build();

    Instance actualResponse = client.updateInstanceConfigAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceConfigRequest actualRequest =
        ((UpdateInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getConfig(), actualRequest.getConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      UpdateInstanceConfigRequest request =
          UpdateInstanceConfigRequest.newBuilder()
              .setName("name3373707")
              .setConfig(InstanceConfig.newBuilder().build())
              .build();
      client.updateInstanceConfigAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateShieldedInstanceConfigTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateShieldedInstanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    UpdateShieldedInstanceConfigRequest request =
        UpdateShieldedInstanceConfigRequest.newBuilder()
            .setName("name3373707")
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .build();

    Instance actualResponse = client.updateShieldedInstanceConfigAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateShieldedInstanceConfigRequest actualRequest =
        ((UpdateShieldedInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(
        request.getShieldedInstanceConfig(), actualRequest.getShieldedInstanceConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateShieldedInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      UpdateShieldedInstanceConfigRequest request =
          UpdateShieldedInstanceConfigRequest.newBuilder()
              .setName("name3373707")
              .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
              .build();
      client.updateShieldedInstanceConfigAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setInstanceLabelsTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    SetInstanceLabelsRequest request =
        SetInstanceLabelsRequest.newBuilder()
            .setName("name3373707")
            .putAllLabels(new HashMap<String, String>())
            .build();

    Instance actualResponse = client.setInstanceLabelsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceLabelsRequest actualRequest = ((SetInstanceLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setInstanceLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      SetInstanceLabelsRequest request =
          SetInstanceLabelsRequest.newBuilder()
              .setName("name3373707")
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.setInstanceLabelsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceMetadataItemsTest() throws Exception {
    UpdateInstanceMetadataItemsResponse expectedResponse =
        UpdateInstanceMetadataItemsResponse.newBuilder()
            .putAllItems(new HashMap<String, String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    UpdateInstanceMetadataItemsRequest request =
        UpdateInstanceMetadataItemsRequest.newBuilder()
            .setName("name3373707")
            .putAllItems(new HashMap<String, String>())
            .build();

    UpdateInstanceMetadataItemsResponse actualResponse =
        client.updateInstanceMetadataItems(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceMetadataItemsRequest actualRequest =
        ((UpdateInstanceMetadataItemsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getItemsMap(), actualRequest.getItemsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceMetadataItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      UpdateInstanceMetadataItemsRequest request =
          UpdateInstanceMetadataItemsRequest.newBuilder()
              .setName("name3373707")
              .putAllItems(new HashMap<String, String>())
              .build();
      client.updateInstanceMetadataItems(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    StartInstanceRequest request = StartInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.startInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartInstanceRequest actualRequest = ((StartInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      StartInstanceRequest request =
          StartInstanceRequest.newBuilder().setName("name3373707").build();
      client.startInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    StopInstanceRequest request = StopInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.stopInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopInstanceRequest actualRequest = ((StopInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      StopInstanceRequest request = StopInstanceRequest.newBuilder().setName("name3373707").build();
      client.stopInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.resetInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetInstanceRequest actualRequest = ((ResetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ResetInstanceRequest request =
          ResetInstanceRequest.newBuilder().setName("name3373707").build();
      client.resetInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportInstanceInfoTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportInstanceInfoTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ReportInstanceInfoRequest request =
        ReportInstanceInfoRequest.newBuilder()
            .setName("name3373707")
            .setVmId("vmId3622450")
            .putAllMetadata(new HashMap<String, String>())
            .build();

    Instance actualResponse = client.reportInstanceInfoAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportInstanceInfoRequest actualRequest = ((ReportInstanceInfoRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVmId(), actualRequest.getVmId());
    Assert.assertEquals(request.getMetadataMap(), actualRequest.getMetadataMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportInstanceInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ReportInstanceInfoRequest request =
          ReportInstanceInfoRequest.newBuilder()
              .setName("name3373707")
              .setVmId("vmId3622450")
              .putAllMetadata(new HashMap<String, String>())
              .build();
      client.reportInstanceInfoAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void isInstanceUpgradeableTest() throws Exception {
    IsInstanceUpgradeableResponse expectedResponse =
        IsInstanceUpgradeableResponse.newBuilder()
            .setUpgradeable(true)
            .setUpgradeVersion("upgradeVersion-392903908")
            .setUpgradeInfo("upgradeInfo-1844902678")
            .setUpgradeImage("upgradeImage-1357442913")
            .build();
    mockNotebookService.addResponse(expectedResponse);

    IsInstanceUpgradeableRequest request =
        IsInstanceUpgradeableRequest.newBuilder()
            .setNotebookInstance("notebookInstance-544239728")
            .setType(UpgradeType.forNumber(0))
            .build();

    IsInstanceUpgradeableResponse actualResponse = client.isInstanceUpgradeable(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IsInstanceUpgradeableRequest actualRequest =
        ((IsInstanceUpgradeableRequest) actualRequests.get(0));

    Assert.assertEquals(request.getNotebookInstance(), actualRequest.getNotebookInstance());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void isInstanceUpgradeableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      IsInstanceUpgradeableRequest request =
          IsInstanceUpgradeableRequest.newBuilder()
              .setNotebookInstance("notebookInstance-544239728")
              .setType(UpgradeType.forNumber(0))
              .build();
      client.isInstanceUpgradeable(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceHealthTest() throws Exception {
    GetInstanceHealthResponse expectedResponse =
        GetInstanceHealthResponse.newBuilder()
            .putAllHealthInfo(new HashMap<String, String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    GetInstanceHealthResponse actualResponse = client.getInstanceHealth(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceHealthRequest actualRequest = ((GetInstanceHealthRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceHealthExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.getInstanceHealth(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceHealthTest2() throws Exception {
    GetInstanceHealthResponse expectedResponse =
        GetInstanceHealthResponse.newBuilder()
            .putAllHealthInfo(new HashMap<String, String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    GetInstanceHealthResponse actualResponse = client.getInstanceHealth(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceHealthRequest actualRequest = ((GetInstanceHealthRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceHealthExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getInstanceHealth(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void upgradeInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    UpgradeInstanceRequest request =
        UpgradeInstanceRequest.newBuilder()
            .setName("name3373707")
            .setType(UpgradeType.forNumber(0))
            .build();

    Instance actualResponse = client.upgradeInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceRequest actualRequest = ((UpgradeInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      UpgradeInstanceRequest request =
          UpgradeInstanceRequest.newBuilder()
              .setName("name3373707")
              .setType(UpgradeType.forNumber(0))
              .build();
      client.upgradeInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rollbackInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rollbackInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    RollbackInstanceRequest request =
        RollbackInstanceRequest.newBuilder()
            .setName("name3373707")
            .setTargetSnapshot("targetSnapshot-1307211147")
            .build();

    Instance actualResponse = client.rollbackInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackInstanceRequest actualRequest = ((RollbackInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTargetSnapshot(), actualRequest.getTargetSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      RollbackInstanceRequest request =
          RollbackInstanceRequest.newBuilder()
              .setName("name3373707")
              .setTargetSnapshot("targetSnapshot-1307211147")
              .build();
      client.rollbackInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeInstanceInternalTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .addAllServiceAccountScopes(new ArrayList<String>())
            .setMachineType("machineType-218117087")
            .setAcceleratorConfig(Instance.AcceleratorConfig.newBuilder().build())
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .addAllDisks(new ArrayList<Instance.Disk>())
            .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllUpgradeHistory(new ArrayList<Instance.UpgradeHistoryEntry>())
            .setReservationAffinity(ReservationAffinity.newBuilder().build())
            .setCreator("creator1028554796")
            .setCanIpForward(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceInternalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    UpgradeInstanceInternalRequest request =
        UpgradeInstanceInternalRequest.newBuilder()
            .setName("name3373707")
            .setVmId("vmId3622450")
            .setType(UpgradeType.forNumber(0))
            .build();

    Instance actualResponse = client.upgradeInstanceInternalAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceInternalRequest actualRequest =
        ((UpgradeInstanceInternalRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVmId(), actualRequest.getVmId());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeInstanceInternalExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      UpgradeInstanceInternalRequest request =
          UpgradeInstanceInternalRequest.newBuilder()
              .setName("name3373707")
              .setVmId("vmId3622450")
              .setType(UpgradeType.forNumber(0))
              .build();
      client.upgradeInstanceInternalAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEnvironmentsTest() throws Exception {
    Environment responsesElement = Environment.newBuilder().build();
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnvironments(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = ((ListEnvironmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnvironmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEnvironments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPostStartupScript("postStartupScript870779112")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPostStartupScript("postStartupScript870779112")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Environment environment = Environment.newBuilder().build();
    String environmentId = "environmentId-950205810";

    Environment actualResponse =
        client.createEnvironmentAsync(parent, environment, environmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = ((CreateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertEquals(environmentId, actualRequest.getEnvironmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      Environment environment = Environment.newBuilder().build();
      String environmentId = "environmentId-950205810";
      client.createEnvironmentAsync(parent, environment, environmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnvironmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEnvironmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = ((DeleteEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSchedulesTest() throws Exception {
    Schedule responsesElement = Schedule.newBuilder().build();
    ListSchedulesResponse expectedResponse =
        ListSchedulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchedules(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");

    ListSchedulesPagedResponse pagedListResponse = client.listSchedules(parent);

    List<Schedule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchedulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSchedulesRequest actualRequest = ((ListSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSchedulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
      client.listSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSchedulesTest2() throws Exception {
    Schedule responsesElement = Schedule.newBuilder().build();
    ListSchedulesResponse expectedResponse =
        ListSchedulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchedules(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSchedulesPagedResponse pagedListResponse = client.listSchedules(parent);

    List<Schedule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchedulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSchedulesRequest actualRequest = ((ListSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSchedulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScheduleTest() throws Exception {
    Schedule expectedResponse =
        Schedule.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .addAllRecentExecutions(new ArrayList<Execution>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");

    Schedule actualResponse = client.getSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScheduleRequest actualRequest = ((GetScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
      client.getSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScheduleTest2() throws Exception {
    Schedule expectedResponse =
        Schedule.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .addAllRecentExecutions(new ArrayList<Execution>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    Schedule actualResponse = client.getSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScheduleRequest actualRequest = ((GetScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScheduleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScheduleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");

    client.deleteScheduleAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScheduleRequest actualRequest = ((DeleteScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
      client.deleteScheduleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteScheduleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScheduleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteScheduleAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScheduleRequest actualRequest = ((DeleteScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteScheduleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createScheduleTest() throws Exception {
    Schedule expectedResponse =
        Schedule.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .addAllRecentExecutions(new ArrayList<Execution>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScheduleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
    Schedule schedule = Schedule.newBuilder().build();
    String scheduleId = "scheduleId-687058414";

    Schedule actualResponse = client.createScheduleAsync(parent, schedule, scheduleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduleRequest actualRequest = ((CreateScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(schedule, actualRequest.getSchedule());
    Assert.assertEquals(scheduleId, actualRequest.getScheduleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
      Schedule schedule = Schedule.newBuilder().build();
      String scheduleId = "scheduleId-687058414";
      client.createScheduleAsync(parent, schedule, scheduleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createScheduleTest2() throws Exception {
    Schedule expectedResponse =
        Schedule.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .addAllRecentExecutions(new ArrayList<Execution>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScheduleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Schedule schedule = Schedule.newBuilder().build();
    String scheduleId = "scheduleId-687058414";

    Schedule actualResponse = client.createScheduleAsync(parent, schedule, scheduleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduleRequest actualRequest = ((CreateScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(schedule, actualRequest.getSchedule());
    Assert.assertEquals(scheduleId, actualRequest.getScheduleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      Schedule schedule = Schedule.newBuilder().build();
      String scheduleId = "scheduleId-687058414";
      client.createScheduleAsync(parent, schedule, scheduleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void triggerScheduleTest() throws Exception {
    Schedule expectedResponse =
        Schedule.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .addAllRecentExecutions(new ArrayList<Execution>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("triggerScheduleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    TriggerScheduleRequest request =
        TriggerScheduleRequest.newBuilder()
            .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .build();

    Schedule actualResponse = client.triggerScheduleAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TriggerScheduleRequest actualRequest = ((TriggerScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void triggerScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      TriggerScheduleRequest request =
          TriggerScheduleRequest.newBuilder()
              .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
              .build();
      client.triggerScheduleAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listExecutionsTest() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExecutionsTest2() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutputNotebookFile("outputNotebookFile2076023192")
            .setJobUri("jobUri-1154761617")
            .build();
    mockNotebookService.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutputNotebookFile("outputNotebookFile2076023192")
            .setJobUri("jobUri-1154761617")
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExecutionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExecutionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutputNotebookFile("outputNotebookFile2076023192")
            .setJobUri("jobUri-1154761617")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.createExecutionAsync(parent, execution, executionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExecutionRequest actualRequest = ((CreateExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.createExecutionAsync(parent, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setExecutionTemplate(ExecutionTemplate.newBuilder().build())
            .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutputNotebookFile("outputNotebookFile2076023192")
            .setJobUri("jobUri-1154761617")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.createExecutionAsync(parent, execution, executionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExecutionRequest actualRequest = ((CreateExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.createExecutionAsync(parent, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
