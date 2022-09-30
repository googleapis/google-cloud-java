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

package com.google.cloud.memcache.v1beta2;

import static com.google.cloud.memcache.v1beta2.CloudMemcacheClient.ListInstancesPagedResponse;

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
public class CloudMemcacheClientTest {
  private static MockCloudMemcache mockCloudMemcache;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudMemcacheClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudMemcache = new MockCloudMemcache();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudMemcache));
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
    CloudMemcacheSettings settings =
        CloudMemcacheSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudMemcacheClient.create(settings);
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
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockCloudMemcache.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
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
    mockCloudMemcache.addException(exception);

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
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockCloudMemcache.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
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
    mockCloudMemcache.addException(exception);

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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    mockCloudMemcache.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
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
    mockCloudMemcache.addException(exception);

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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    mockCloudMemcache.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
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
    mockCloudMemcache.addException(exception);

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
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String instanceId = "instanceId902024336";
    Instance resource = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, resource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String instanceId = "instanceId902024336";
      Instance resource = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId902024336";
    Instance resource = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, resource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId902024336";
      Instance resource = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    FieldMask updateMask = FieldMask.newBuilder().build();
    Instance resource = Instance.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(updateMask, resource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      Instance resource = Instance.newBuilder().build();
      client.updateInstanceAsync(updateMask, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateParametersTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FieldMask updateMask = FieldMask.newBuilder().build();
    MemcacheParameters parameters = MemcacheParameters.newBuilder().build();

    Instance actualResponse = client.updateParametersAsync(name, updateMask, parameters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateParametersRequest actualRequest = ((UpdateParametersRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FieldMask updateMask = FieldMask.newBuilder().build();
      MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
      client.updateParametersAsync(name, updateMask, parameters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateParametersTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    String name = "name3373707";
    FieldMask updateMask = FieldMask.newBuilder().build();
    MemcacheParameters parameters = MemcacheParameters.newBuilder().build();

    Instance actualResponse = client.updateParametersAsync(name, updateMask, parameters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateParametersRequest actualRequest = ((UpdateParametersRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateParametersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      String name = "name3373707";
      FieldMask updateMask = FieldMask.newBuilder().build();
      MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
      client.updateParametersAsync(name, updateMask, parameters).get();
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
    mockCloudMemcache.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

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
  public void applyParametersTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applyParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applyParametersAsync(name, nodeIds, applyAll).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApplyParametersRequest actualRequest = ((ApplyParametersRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(nodeIds, actualRequest.getNodeIdsList());
    Assert.assertEquals(applyAll, actualRequest.getApplyAll());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void applyParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applyParametersAsync(name, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void applyParametersTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applyParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    String name = "name3373707";
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applyParametersAsync(name, nodeIds, applyAll).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApplyParametersRequest actualRequest = ((ApplyParametersRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(nodeIds, actualRequest.getNodeIdsList());
    Assert.assertEquals(applyAll, actualRequest.getApplyAll());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void applyParametersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      String name = "name3373707";
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applyParametersAsync(name, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void applySoftwareUpdateTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applySoftwareUpdateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applySoftwareUpdateAsync(instance, nodeIds, applyAll).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApplySoftwareUpdateRequest actualRequest = ((ApplySoftwareUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertEquals(nodeIds, actualRequest.getNodeIdsList());
    Assert.assertEquals(applyAll, actualRequest.getApplyAll());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void applySoftwareUpdateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applySoftwareUpdateAsync(instance, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void applySoftwareUpdateTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setUpdateAvailable(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applySoftwareUpdateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudMemcache.addResponse(resultOperation);

    String instance = "instance555127957";
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applySoftwareUpdateAsync(instance, nodeIds, applyAll).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudMemcache.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApplySoftwareUpdateRequest actualRequest = ((ApplySoftwareUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(nodeIds, actualRequest.getNodeIdsList());
    Assert.assertEquals(applyAll, actualRequest.getApplyAll());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void applySoftwareUpdateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudMemcache.addException(exception);

    try {
      String instance = "instance555127957";
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applySoftwareUpdateAsync(instance, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
