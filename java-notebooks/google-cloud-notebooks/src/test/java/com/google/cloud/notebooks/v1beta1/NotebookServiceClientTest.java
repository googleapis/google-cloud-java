/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.notebooks.v1beta1;

import static com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListInstancesPagedResponse;

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
  private static MockServiceHelper mockServiceHelper;
  private static MockNotebookService mockNotebookService;
  private NotebookServiceClient client;
  private LocalChannelProvider channelProvider;

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

    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListInstancesPagedResponse pagedListResponse = client.listInstances(request);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
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
      ListInstancesRequest request =
          ListInstancesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listInstances(request);
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.getInstance(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
      client.getInstance(request);
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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

    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent("parent-995424086")
            .setInstanceId("instanceId902024336")
            .setInstance(Instance.newBuilder().build())
            .build();

    Instance actualResponse = client.createInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInstanceId(), actualRequest.getInstanceId());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
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
      CreateInstanceRequest request =
          CreateInstanceRequest.newBuilder()
              .setParent("parent-995424086")
              .setInstanceId("instanceId902024336")
              .setInstance(Instance.newBuilder().build())
              .build();
      client.createInstanceAsync(request).get();
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
  public void setInstanceLabelsTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setPostStartupScript("postStartupScript870779112")
            .setProxyUri("proxyUri-985185250")
            .addAllInstanceOwners(new ArrayList<String>())
            .setServiceAccount("serviceAccount1079137720")
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName("name3373707").build();

    client.deleteInstanceAsync(request).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      DeleteInstanceRequest request =
          DeleteInstanceRequest.newBuilder().setName("name3373707").build();
      client.deleteInstanceAsync(request).get();
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .build();
    mockNotebookService.addResponse(expectedResponse);

    IsInstanceUpgradeableRequest request =
        IsInstanceUpgradeableRequest.newBuilder()
            .setNotebookInstance("notebookInstance-544239728")
            .build();

    IsInstanceUpgradeableResponse actualResponse = client.isInstanceUpgradeable(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IsInstanceUpgradeableRequest actualRequest =
        ((IsInstanceUpgradeableRequest) actualRequests.get(0));

    Assert.assertEquals(request.getNotebookInstance(), actualRequest.getNotebookInstance());
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
              .build();
      client.isInstanceUpgradeable(request);
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
        UpgradeInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.upgradeInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceRequest actualRequest = ((UpgradeInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
          UpgradeInstanceRequest.newBuilder().setName("name3373707").build();
      client.upgradeInstanceAsync(request).get();
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
            .setMachineType("machineType-218117087")
            .setInstallGpuDriver(true)
            .setCustomGpuDriverPath("customGpuDriverPath509224520")
            .setBootDiskSizeGb(1398920548)
            .setDataDiskSizeGb(-1668379732)
            .setNoRemoveDataDisk(true)
            .setKmsKey("kmsKey-1127483058")
            .setNoPublicIp(true)
            .setNoProxyAccess(true)
            .setNetwork("network1843485230")
            .setSubnet("subnet-891534499")
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
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
            .build();

    Instance actualResponse = client.upgradeInstanceInternalAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceInternalRequest actualRequest =
        ((UpgradeInstanceInternalRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVmId(), actualRequest.getVmId());
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

    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(request);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = ((ListEnvironmentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
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
      ListEnvironmentsRequest request =
          ListEnvironmentsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listEnvironments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPostStartupScript("postStartupScript870779112")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    GetEnvironmentRequest request =
        GetEnvironmentRequest.newBuilder().setName("name3373707").build();

    Environment actualResponse = client.getEnvironment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      GetEnvironmentRequest request =
          GetEnvironmentRequest.newBuilder().setName("name3373707").build();
      client.getEnvironment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[ENVIRONMENT]").toString())
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

    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent("parent-995424086")
            .setEnvironmentId("environmentId-950205810")
            .setEnvironment(Environment.newBuilder().build())
            .build();

    Environment actualResponse = client.createEnvironmentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = ((CreateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEnvironmentId(), actualRequest.getEnvironmentId());
    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
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
      CreateEnvironmentRequest request =
          CreateEnvironmentRequest.newBuilder()
              .setParent("parent-995424086")
              .setEnvironmentId("environmentId-950205810")
              .setEnvironment(Environment.newBuilder().build())
              .build();
      client.createEnvironmentAsync(request).get();
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

    DeleteEnvironmentRequest request =
        DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();

    client.deleteEnvironmentAsync(request).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = ((DeleteEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      DeleteEnvironmentRequest request =
          DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
      client.deleteEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
