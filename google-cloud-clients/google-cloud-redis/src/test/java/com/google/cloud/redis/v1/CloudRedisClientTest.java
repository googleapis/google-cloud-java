/*
 * Copyright 2019 Google LLC
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
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CloudRedisClientTest {
  private static MockCloudRedis mockCloudRedis;
  private static MockServiceHelper serviceHelper;
  private CloudRedisClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudRedis = new MockCloudRedis();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockCloudRedis));
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
    mockCloudRedis.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = (ListInstancesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb = 34199707;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    mockCloudRedis.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = (GetInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstanceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceTest() throws Exception {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb2 = 1493816946;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb2)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String instanceId = "test_instance";
    Instance.Tier tier = Instance.Tier.BASIC;
    int memorySizeGb = 1;
    Instance instance = Instance.newBuilder().setTier(tier).setMemorySizeGb(memorySizeGb).build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = (CreateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
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
    mockCloudRedis.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String instanceId = "test_instance";
      Instance.Tier tier = Instance.Tier.BASIC;
      int memorySizeGb = 1;
      Instance instance = Instance.newBuilder().setTier(tier).setMemorySizeGb(memorySizeGb).build();

      client.createInstanceAsync(parent, instanceId, instance).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateInstanceTest() throws Exception {
    String name = "name3373707";
    String displayName2 = "displayName21615000987";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb2 = 1493816946;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name)
            .setDisplayName(displayName2)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb2)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String pathsElement = "display_name";
    String pathsElement2 = "memory_size_gb";
    List<String> paths = Arrays.asList(pathsElement, pathsElement2);
    FieldMask updateMask = FieldMask.newBuilder().addAllPaths(paths).build();
    String displayName = "UpdatedDisplayName";
    int memorySizeGb = 4;
    Instance instance =
        Instance.newBuilder().setDisplayName(displayName).setMemorySizeGb(memorySizeGb).build();

    Instance actualResponse = client.updateInstanceAsync(updateMask, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = (UpdateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String pathsElement = "display_name";
      String pathsElement2 = "memory_size_gb";
      List<String> paths = Arrays.asList(pathsElement, pathsElement2);
      FieldMask updateMask = FieldMask.newBuilder().addAllPaths(paths).build();
      String displayName = "UpdatedDisplayName";
      int memorySizeGb = 4;
      Instance instance =
          Instance.newBuilder().setDisplayName(displayName).setMemorySizeGb(memorySizeGb).build();

      client.updateInstanceAsync(updateMask, instance).get();
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
    mockCloudRedis.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Empty actualResponse = client.deleteInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = (DeleteInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstanceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importInstanceTest() throws Exception {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb = 34199707;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    InputConfig inputConfig = InputConfig.newBuilder().build();

    Instance actualResponse = client.importInstanceAsync(formattedName, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportInstanceRequest actualRequest = (ImportInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      InputConfig inputConfig = InputConfig.newBuilder().build();

      client.importInstanceAsync(formattedName, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void exportInstanceTest() throws Exception {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb = 34199707;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    Instance actualResponse = client.exportInstanceAsync(formattedName, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportInstanceRequest actualRequest = (ExportInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void exportInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      OutputConfig outputConfig = OutputConfig.newBuilder().build();

      client.exportInstanceAsync(formattedName, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void failoverInstanceTest() throws Exception {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String locationId = "locationId552319461";
    String alternativeLocationId = "alternativeLocationId-718920621";
    String redisVersion = "redisVersion-685310444";
    String reservedIpRange = "reservedIpRange-1082940580";
    String host = "host3208616";
    int port = 3446913;
    String currentLocationId = "currentLocationId1312712735";
    String statusMessage = "statusMessage-239442758";
    int memorySizeGb = 34199707;
    String authorizedNetwork = "authorizedNetwork-1733809270";
    String persistenceIamIdentity = "persistenceIamIdentity1061944584";
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setLocationId(locationId)
            .setAlternativeLocationId(alternativeLocationId)
            .setRedisVersion(redisVersion)
            .setReservedIpRange(reservedIpRange)
            .setHost(host)
            .setPort(port)
            .setCurrentLocationId(currentLocationId)
            .setStatusMessage(statusMessage)
            .setMemorySizeGb(memorySizeGb)
            .setAuthorizedNetwork(authorizedNetwork)
            .setPersistenceIamIdentity(persistenceIamIdentity)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedis.addResponse(resultOperation);

    String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
        FailoverInstanceRequest.DataProtectionMode.DATA_PROTECTION_MODE_UNSPECIFIED;

    Instance actualResponse = client.failoverInstanceAsync(formattedName, dataProtectionMode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCloudRedis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverInstanceRequest actualRequest = (FailoverInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(dataProtectionMode, actualRequest.getDataProtectionMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void failoverInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudRedis.addException(exception);

    try {
      String formattedName = InstanceName.format("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
          FailoverInstanceRequest.DataProtectionMode.DATA_PROTECTION_MODE_UNSPECIFIED;

      client.failoverInstanceAsync(formattedName, dataProtectionMode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
