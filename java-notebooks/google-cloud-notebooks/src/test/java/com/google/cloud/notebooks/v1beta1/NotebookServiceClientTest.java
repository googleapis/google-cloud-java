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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class NotebookServiceClientTest {
  private static MockNotebookService mockNotebookService;
  private static MockServiceHelper serviceHelper;
  private NotebookServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockNotebookService = new MockNotebookService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockNotebookService));
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
  @SuppressWarnings("all")
  public void listInstancesTest() {
    String nextPageToken = "";
    Instance instancesElement = Instance.newBuilder().build();
    List<Instance> instances = Arrays.asList(instancesElement);
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllInstances(instances)
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();

    ListInstancesPagedResponse pagedListResponse = client.listInstances(request);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = (ListInstancesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();

      client.listInstances(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceTest() {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.getInstance(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = (GetInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();

      client.getInstance(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceTest() throws Exception {
    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId-2101995259";
    Instance instance = Instance.newBuilder().build();
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();

    Instance actualResponse = client.createInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = (CreateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId-2101995259";
      Instance instance = Instance.newBuilder().build();
      CreateInstanceRequest request =
          CreateInstanceRequest.newBuilder()
              .setParent(parent)
              .setInstanceId(instanceId)
              .setInstance(instance)
              .build();

      client.createInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void registerInstanceTest() throws Exception {
    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId-2101995259";
    RegisterInstanceRequest request =
        RegisterInstanceRequest.newBuilder().setParent(parent).setInstanceId(instanceId).build();

    Instance actualResponse = client.registerInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterInstanceRequest actualRequest = (RegisterInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void registerInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId-2101995259";
      RegisterInstanceRequest request =
          RegisterInstanceRequest.newBuilder().setParent(parent).setInstanceId(instanceId).build();

      client.registerInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceAcceleratorTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceAcceleratorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    Instance.AcceleratorType type = Instance.AcceleratorType.ACCELERATOR_TYPE_UNSPECIFIED;
    long coreCount = 1963855761L;
    SetInstanceAcceleratorRequest request =
        SetInstanceAcceleratorRequest.newBuilder()
            .setName(name)
            .setType(type)
            .setCoreCount(coreCount)
            .build();

    Instance actualResponse = client.setInstanceAcceleratorAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceAcceleratorRequest actualRequest =
        (SetInstanceAcceleratorRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(type, actualRequest.getType());
    Assert.assertEquals(coreCount, actualRequest.getCoreCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceAcceleratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      Instance.AcceleratorType type = Instance.AcceleratorType.ACCELERATOR_TYPE_UNSPECIFIED;
      long coreCount = 1963855761L;
      SetInstanceAcceleratorRequest request =
          SetInstanceAcceleratorRequest.newBuilder()
              .setName(name)
              .setType(type)
              .setCoreCount(coreCount)
              .build();

      client.setInstanceAcceleratorAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceMachineTypeTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType2 = "machineType21397579621";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType2)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceMachineTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    String machineType = "machineType1838323762";
    SetInstanceMachineTypeRequest request =
        SetInstanceMachineTypeRequest.newBuilder()
            .setName(name)
            .setMachineType(machineType)
            .build();

    Instance actualResponse = client.setInstanceMachineTypeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceMachineTypeRequest actualRequest =
        (SetInstanceMachineTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(machineType, actualRequest.getMachineType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceMachineTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      String machineType = "machineType1838323762";
      SetInstanceMachineTypeRequest request =
          SetInstanceMachineTypeRequest.newBuilder()
              .setName(name)
              .setMachineType(machineType)
              .build();

      client.setInstanceMachineTypeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceLabelsTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInstanceLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    SetInstanceLabelsRequest request = SetInstanceLabelsRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.setInstanceLabelsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetInstanceLabelsRequest actualRequest = (SetInstanceLabelsRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setInstanceLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      SetInstanceLabelsRequest request =
          SetInstanceLabelsRequest.newBuilder().setName(name).build();

      client.setInstanceLabelsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
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
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();

    Empty actualResponse = client.deleteInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = (DeleteInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();

      client.deleteInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void startInstanceTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    StartInstanceRequest request = StartInstanceRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.startInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartInstanceRequest actualRequest = (StartInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void startInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      StartInstanceRequest request = StartInstanceRequest.newBuilder().setName(name).build();

      client.startInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void stopInstanceTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    StopInstanceRequest request = StopInstanceRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.stopInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopInstanceRequest actualRequest = (StopInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void stopInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      StopInstanceRequest request = StopInstanceRequest.newBuilder().setName(name).build();

      client.stopInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resetInstanceTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.resetInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetInstanceRequest actualRequest = (ResetInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void resetInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName(name).build();

      client.resetInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void reportInstanceInfoTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportInstanceInfoTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    String vmId = "vmId112317347";
    ReportInstanceInfoRequest request =
        ReportInstanceInfoRequest.newBuilder().setName(name).setVmId(vmId).build();

    Instance actualResponse = client.reportInstanceInfoAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportInstanceInfoRequest actualRequest = (ReportInstanceInfoRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(vmId, actualRequest.getVmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void reportInstanceInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      String vmId = "vmId112317347";
      ReportInstanceInfoRequest request =
          ReportInstanceInfoRequest.newBuilder().setName(name).setVmId(vmId).build();

      client.reportInstanceInfoAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void isInstanceUpgradeableTest() {
    boolean upgradeable = true;
    String upgradeVersion = "upgradeVersion1040155061";
    IsInstanceUpgradeableResponse expectedResponse =
        IsInstanceUpgradeableResponse.newBuilder()
            .setUpgradeable(upgradeable)
            .setUpgradeVersion(upgradeVersion)
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String notebookInstance = "notebookInstance-1078982023";
    IsInstanceUpgradeableRequest request =
        IsInstanceUpgradeableRequest.newBuilder().setNotebookInstance(notebookInstance).build();

    IsInstanceUpgradeableResponse actualResponse = client.isInstanceUpgradeable(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IsInstanceUpgradeableRequest actualRequest =
        (IsInstanceUpgradeableRequest) actualRequests.get(0);

    Assert.assertEquals(notebookInstance, actualRequest.getNotebookInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void isInstanceUpgradeableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String notebookInstance = "notebookInstance-1078982023";
      IsInstanceUpgradeableRequest request =
          IsInstanceUpgradeableRequest.newBuilder().setNotebookInstance(notebookInstance).build();

      client.isInstanceUpgradeable(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void upgradeInstanceTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    UpgradeInstanceRequest request = UpgradeInstanceRequest.newBuilder().setName(name).build();

    Instance actualResponse = client.upgradeInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceRequest actualRequest = (UpgradeInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void upgradeInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      UpgradeInstanceRequest request = UpgradeInstanceRequest.newBuilder().setName(name).build();

      client.upgradeInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void upgradeInstanceInternalTest() throws Exception {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String postStartupScript = "postStartupScript355382860";
    String proxyUri = "proxyUri-475670501";
    String serviceAccount = "serviceAccount-1948028253";
    String machineType = "machineType1838323762";
    boolean installGpuDriver = false;
    String customGpuDriverPath = "customGpuDriverPath1863223803";
    long bootDiskSizeGb = 1398920548L;
    long dataDiskSizeGb = 1668379732L;
    boolean noRemoveDataDisk = false;
    String kmsKey = "kmsKey-591635343";
    boolean noPublicIp = false;
    boolean noProxyAccess = false;
    String network = "network1843485230";
    String subnet = "subnet-891534499";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setPostStartupScript(postStartupScript)
            .setProxyUri(proxyUri)
            .setServiceAccount(serviceAccount)
            .setMachineType(machineType)
            .setInstallGpuDriver(installGpuDriver)
            .setCustomGpuDriverPath(customGpuDriverPath)
            .setBootDiskSizeGb(bootDiskSizeGb)
            .setDataDiskSizeGb(dataDiskSizeGb)
            .setNoRemoveDataDisk(noRemoveDataDisk)
            .setKmsKey(kmsKey)
            .setNoPublicIp(noPublicIp)
            .setNoProxyAccess(noProxyAccess)
            .setNetwork(network)
            .setSubnet(subnet)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceInternalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    String vmId = "vmId112317347";
    UpgradeInstanceInternalRequest request =
        UpgradeInstanceInternalRequest.newBuilder().setName(name).setVmId(vmId).build();

    Instance actualResponse = client.upgradeInstanceInternalAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceInternalRequest actualRequest =
        (UpgradeInstanceInternalRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(vmId, actualRequest.getVmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void upgradeInstanceInternalExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      String vmId = "vmId112317347";
      UpgradeInstanceInternalRequest request =
          UpgradeInstanceInternalRequest.newBuilder().setName(name).setVmId(vmId).build();

      client.upgradeInstanceInternalAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listEnvironmentsTest() {
    String nextPageToken = "";
    Environment environmentsElement = Environment.newBuilder().build();
    List<Environment> environments = Arrays.asList(environmentsElement);
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEnvironments(environments)
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(request);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = (ListEnvironmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEnvironmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      ListEnvironmentsRequest request =
          ListEnvironmentsRequest.newBuilder().setParent(parent).build();

      client.listEnvironments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEnvironmentTest() {
    EnvironmentName name2 = EnvironmentName.of("[PROJECT]", "[ENVIRONMENT]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String postStartupScript = "postStartupScript355382860";
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setPostStartupScript(postStartupScript)
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();

    Environment actualResponse = client.getEnvironment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = (GetEnvironmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();

      client.getEnvironment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEnvironmentTest() throws Exception {
    EnvironmentName name = EnvironmentName.of("[PROJECT]", "[ENVIRONMENT]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String postStartupScript = "postStartupScript355382860";
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setPostStartupScript(postStartupScript)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String environmentId = "environmentId608412359";
    Environment environment = Environment.newBuilder().build();
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent)
            .setEnvironmentId(environmentId)
            .setEnvironment(environment)
            .build();

    Environment actualResponse = client.createEnvironmentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = (CreateEnvironmentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(environmentId, actualRequest.getEnvironmentId());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      String environmentId = "environmentId608412359";
      Environment environment = Environment.newBuilder().build();
      CreateEnvironmentRequest request =
          CreateEnvironmentRequest.newBuilder()
              .setParent(parent)
              .setEnvironmentId(environmentId)
              .setEnvironment(environment)
              .build();

      client.createEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
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
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();

    Empty actualResponse = client.deleteEnvironmentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = (DeleteEnvironmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      DeleteEnvironmentRequest request =
          DeleteEnvironmentRequest.newBuilder().setName(name).build();

      client.deleteEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
