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

package com.google.cloud.redis.v1;

import static com.google.cloud.redis.v1.CloudRedisClient.ListInstancesPagedResponse;

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
public class CloudRedisClientTest {
  private static MockCloudRedis mockCloudRedis;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudRedisClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudRedis = new MockCloudRedis();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudRedis));
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
    CloudRedisSettings settings =
        CloudRedisSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudRedisClient.create(settings);
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
    mockCloudRedis.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

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
    mockCloudRedis.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

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
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    mockCloudRedis.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

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
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    mockCloudRedis.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceAuthStringTest() throws Exception {
    InstanceAuthString expectedResponse =
        InstanceAuthString.newBuilder().setAuthString("authString1994738649").build();
    mockCloudRedis.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    InstanceAuthString actualResponse = client.getInstanceAuthString(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceAuthStringRequest actualRequest =
        ((GetInstanceAuthStringRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceAuthStringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstanceAuthString(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceAuthStringTest2() throws Exception {
    InstanceAuthString expectedResponse =
        InstanceAuthString.newBuilder().setAuthString("authString1994738649").build();
    mockCloudRedis.addResponse(expectedResponse);

    String name = "name3373707";

    InstanceAuthString actualResponse = client.getInstanceAuthString(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceAuthStringRequest actualRequest =
        ((GetInstanceAuthStringRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceAuthStringExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      client.getInstanceAuthString(name);
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
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, instance).get();
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
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, instance).get();
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
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    FieldMask updateMask = FieldMask.newBuilder().build();
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(updateMask, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      Instance instance = Instance.newBuilder().build();
      client.updateInstanceAsync(updateMask, instance).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String redisVersion = "redisVersion-1972584739";

    Instance actualResponse = client.upgradeInstanceAsync(name, redisVersion).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceRequest actualRequest = ((UpgradeInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(redisVersion, actualRequest.getRedisVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String redisVersion = "redisVersion-1972584739";
      client.upgradeInstanceAsync(name, redisVersion).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";
    String redisVersion = "redisVersion-1972584739";

    Instance actualResponse = client.upgradeInstanceAsync(name, redisVersion).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeInstanceRequest actualRequest = ((UpgradeInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(redisVersion, actualRequest.getRedisVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      String redisVersion = "redisVersion-1972584739";
      client.upgradeInstanceAsync(name, redisVersion).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";
    InputConfig inputConfig = InputConfig.newBuilder().build();

    Instance actualResponse = client.importInstanceAsync(name, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportInstanceRequest actualRequest = ((ImportInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      client.importInstanceAsync(name, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    Instance actualResponse = client.exportInstanceAsync(name, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportInstanceRequest actualRequest = ((ExportInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      client.exportInstanceAsync(name, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
        FailoverInstanceRequest.DataProtectionMode.forNumber(0);

    Instance actualResponse = client.failoverInstanceAsync(name, dataProtectionMode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverInstanceRequest actualRequest = ((FailoverInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(dataProtectionMode, actualRequest.getDataProtectionMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
          FailoverInstanceRequest.DataProtectionMode.forNumber(0);
      client.failoverInstanceAsync(name, dataProtectionMode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";
    FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
        FailoverInstanceRequest.DataProtectionMode.forNumber(0);

    Instance actualResponse = client.failoverInstanceAsync(name, dataProtectionMode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverInstanceRequest actualRequest = ((FailoverInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(dataProtectionMode, actualRequest.getDataProtectionMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
          FailoverInstanceRequest.DataProtectionMode.forNumber(0);
      client.failoverInstanceAsync(name, dataProtectionMode).get();
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
    mockCloudRedis.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

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
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
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
    mockCloudRedis.addException(exception);

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
  public void rescheduleMaintenanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(rescheduleType, actualRequest.getRescheduleType());
    Assert.assertEquals(scheduleTime, actualRequest.getScheduleTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rescheduleMaintenanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setLocationId("locationId1541836720")
            .setAlternativeLocationId("alternativeLocationId1787141949")
            .setRedisVersion("redisVersion-1972584739")
            .setReservedIpRange("reservedIpRange575015950")
            .setSecondaryIpRange("secondaryIpRange-1937131454")
            .setHost("host3208616")
            .setPort(3446913)
            .setCurrentLocationId("currentLocationId-1808505335")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .putAllRedisConfigs(new HashMap<String, String>())
            .setMemorySizeGb(34199707)
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .setPersistenceIamIdentity("persistenceIamIdentity1464017428")
            .setAuthEnabled(true)
            .addAllServerCaCerts(new ArrayList<TlsCertificate>())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setReplicaCount(564075208)
            .addAllNodes(new ArrayList<NodeInfo>())
            .setReadEndpoint("readEndpoint294053195")
            .setReadEndpointPort(-1676143102)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String name = "name3373707";
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(rescheduleType, actualRequest.getRescheduleType());
    Assert.assertEquals(scheduleTime, actualRequest.getScheduleTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String name = "name3373707";
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
