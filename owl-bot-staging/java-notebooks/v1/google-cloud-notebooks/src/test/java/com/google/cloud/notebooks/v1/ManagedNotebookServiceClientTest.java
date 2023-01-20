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

import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListRuntimesPagedResponse;

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
public class ManagedNotebookServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockManagedNotebookService mockManagedNotebookService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ManagedNotebookServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockManagedNotebookService = new MockManagedNotebookService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockManagedNotebookService, mockLocations, mockIAMPolicy));
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
    ManagedNotebookServiceSettings settings =
        ManagedNotebookServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ManagedNotebookServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRuntimesTest() throws Exception {
    Runtime responsesElement = Runtime.newBuilder().build();
    ListRuntimesResponse expectedResponse =
        ListRuntimesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimes(Arrays.asList(responsesElement))
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRuntimesPagedResponse pagedListResponse = client.listRuntimes(parent);

    List<Runtime> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimesRequest actualRequest = ((ListRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRuntimes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimesTest2() throws Exception {
    Runtime responsesElement = Runtime.newBuilder().build();
    ListRuntimesResponse expectedResponse =
        ListRuntimesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimes(Arrays.asList(responsesElement))
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuntimesPagedResponse pagedListResponse = client.listRuntimes(parent);

    List<Runtime> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimesRequest actualRequest = ((ListRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuntimes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");

    Runtime actualResponse = client.getRuntime(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeRequest actualRequest = ((GetRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      client.getRuntime(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeTest2() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    Runtime actualResponse = client.getRuntime(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeRequest actualRequest = ((GetRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getRuntime(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    RuntimeName parent = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
    String runtimeId = "runtimeId121455379";
    Runtime runtime = Runtime.newBuilder().build();

    Runtime actualResponse = client.createRuntimeAsync(parent, runtimeId, runtime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuntimeRequest actualRequest = ((CreateRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(runtimeId, actualRequest.getRuntimeId());
    Assert.assertEquals(runtime, actualRequest.getRuntime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName parent = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      String runtimeId = "runtimeId121455379";
      Runtime runtime = Runtime.newBuilder().build();
      client.createRuntimeAsync(parent, runtimeId, runtime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRuntimeTest2() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String runtimeId = "runtimeId121455379";
    Runtime runtime = Runtime.newBuilder().build();

    Runtime actualResponse = client.createRuntimeAsync(parent, runtimeId, runtime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuntimeRequest actualRequest = ((CreateRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(runtimeId, actualRequest.getRuntimeId());
    Assert.assertEquals(runtime, actualRequest.getRuntime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      String runtimeId = "runtimeId121455379";
      Runtime runtime = Runtime.newBuilder().build();
      client.createRuntimeAsync(parent, runtimeId, runtime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    Runtime runtime = Runtime.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Runtime actualResponse = client.updateRuntimeAsync(runtime, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuntimeRequest actualRequest = ((UpdateRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(runtime, actualRequest.getRuntime());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      Runtime runtime = Runtime.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRuntimeAsync(runtime, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRuntimeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");

    client.deleteRuntimeAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuntimeRequest actualRequest = ((DeleteRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      client.deleteRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRuntimeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRuntimeAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuntimeRequest actualRequest = ((DeleteRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.startRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartRuntimeRequest actualRequest = ((StartRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.startRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.stopRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopRuntimeRequest actualRequest = ((StopRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.stopRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void switchRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("switchRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.switchRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SwitchRuntimeRequest actualRequest = ((SwitchRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.switchRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.resetRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetRuntimeRequest actualRequest = ((ResetRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.resetRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.upgradeRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeRuntimeRequest actualRequest = ((UpgradeRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.upgradeRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportRuntimeEventTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportRuntimeEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");

    Runtime actualResponse = client.reportRuntimeEventAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportRuntimeEventRequest actualRequest = ((ReportRuntimeEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportRuntimeEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      client.reportRuntimeEventAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportRuntimeEventTest2() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportRuntimeEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    Runtime actualResponse = client.reportRuntimeEventAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportRuntimeEventRequest actualRequest = ((ReportRuntimeEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportRuntimeEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.reportRuntimeEventAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void refreshRuntimeTokenInternalTest() throws Exception {
    RefreshRuntimeTokenInternalResponse expectedResponse =
        RefreshRuntimeTokenInternalResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
    String vmId = "vmId3622450";

    RefreshRuntimeTokenInternalResponse actualResponse =
        client.refreshRuntimeTokenInternal(name, vmId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RefreshRuntimeTokenInternalRequest actualRequest =
        ((RefreshRuntimeTokenInternalRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(vmId, actualRequest.getVmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void refreshRuntimeTokenInternalExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      String vmId = "vmId3622450";
      client.refreshRuntimeTokenInternal(name, vmId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void refreshRuntimeTokenInternalTest2() throws Exception {
    RefreshRuntimeTokenInternalResponse expectedResponse =
        RefreshRuntimeTokenInternalResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockManagedNotebookService.addResponse(expectedResponse);

    String name = "name3373707";
    String vmId = "vmId3622450";

    RefreshRuntimeTokenInternalResponse actualResponse =
        client.refreshRuntimeTokenInternal(name, vmId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RefreshRuntimeTokenInternalRequest actualRequest =
        ((RefreshRuntimeTokenInternalRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(vmId, actualRequest.getVmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void refreshRuntimeTokenInternalExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      String vmId = "vmId3622450";
      client.refreshRuntimeTokenInternal(name, vmId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseRuntimeTest() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("diagnoseRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
    DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();

    Runtime actualResponse = client.diagnoseRuntimeAsync(name, diagnosticConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseRuntimeRequest actualRequest = ((DiagnoseRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(diagnosticConfig, actualRequest.getDiagnosticConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
      DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();
      client.diagnoseRuntimeAsync(name, diagnosticConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void diagnoseRuntimeTest2() throws Exception {
    Runtime expectedResponse =
        Runtime.newBuilder()
            .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
            .setAccessConfig(RuntimeAccessConfig.newBuilder().build())
            .setSoftwareConfig(RuntimeSoftwareConfig.newBuilder().build())
            .setMetrics(RuntimeMetrics.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("diagnoseRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedNotebookService.addResponse(resultOperation);

    String name = "name3373707";
    DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();

    Runtime actualResponse = client.diagnoseRuntimeAsync(name, diagnosticConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseRuntimeRequest actualRequest = ((DiagnoseRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(diagnosticConfig, actualRequest.getDiagnosticConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedNotebookService.addException(exception);

    try {
      String name = "name3373707";
      DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();
      client.diagnoseRuntimeAsync(name, diagnosticConfig).get();
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
            .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
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
              .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
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
            .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
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
              .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
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
            .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
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
              .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
