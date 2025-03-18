/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.financialservices.v1;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Interval;
import com.google.type.TimeZone;
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
public class AMLClientTest {
  private static MockAML mockAML;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AMLClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAML = new MockAML();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAML, mockLocations));
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
    AMLSettings settings =
        AMLSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AMLClient.create(settings);
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
    mockAML.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
            .putAllLabels(new HashMap<String, String>())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
            .putAllLabels(new HashMap<String, String>())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setKmsKey("kmsKey-1127483058")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
    mockAML.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
  public void createInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setKmsKey("kmsKey-1127483058")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

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
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setKmsKey("kmsKey-1127483058")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
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
    mockAML.addException(exception);

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
  public void importRegisteredPartiesTest() throws Exception {
    ImportRegisteredPartiesResponse expectedResponse =
        ImportRegisteredPartiesResponse.newBuilder()
            .setPartiesAdded(2042133253)
            .setPartiesRemoved(1929921829)
            .setPartiesTotal(2060023113)
            .setPartiesFailedToRemove(151928353)
            .setPartiesUptiered(1998473271)
            .setPartiesDowntiered(-1262161346)
            .setPartiesFailedToDowntier(1915135969)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ImportRegisteredPartiesRequest.UpdateMode mode =
        ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
    List<String> partyTables = new ArrayList<>();

    ImportRegisteredPartiesResponse actualResponse =
        client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportRegisteredPartiesRequest actualRequest =
        ((ImportRegisteredPartiesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(lineOfBusiness, actualRequest.getLineOfBusiness());
    Assert.assertEquals(partyTables, actualRequest.getPartyTablesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importRegisteredPartiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      ImportRegisteredPartiesRequest.UpdateMode mode =
          ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      List<String> partyTables = new ArrayList<>();
      client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importRegisteredPartiesTest2() throws Exception {
    ImportRegisteredPartiesResponse expectedResponse =
        ImportRegisteredPartiesResponse.newBuilder()
            .setPartiesAdded(2042133253)
            .setPartiesRemoved(1929921829)
            .setPartiesTotal(2060023113)
            .setPartiesFailedToRemove(151928353)
            .setPartiesUptiered(1998473271)
            .setPartiesDowntiered(-1262161346)
            .setPartiesFailedToDowntier(1915135969)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";
    ImportRegisteredPartiesRequest.UpdateMode mode =
        ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
    List<String> partyTables = new ArrayList<>();

    ImportRegisteredPartiesResponse actualResponse =
        client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportRegisteredPartiesRequest actualRequest =
        ((ImportRegisteredPartiesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(lineOfBusiness, actualRequest.getLineOfBusiness());
    Assert.assertEquals(partyTables, actualRequest.getPartyTablesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importRegisteredPartiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      ImportRegisteredPartiesRequest.UpdateMode mode =
          ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      List<String> partyTables = new ArrayList<>();
      client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportRegisteredPartiesTest() throws Exception {
    ExportRegisteredPartiesResponse expectedResponse =
        ExportRegisteredPartiesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);

    ExportRegisteredPartiesResponse actualResponse =
        client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportRegisteredPartiesRequest actualRequest =
        ((ExportRegisteredPartiesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(lineOfBusiness, actualRequest.getLineOfBusiness());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportRegisteredPartiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportRegisteredPartiesTest2() throws Exception {
    ExportRegisteredPartiesResponse expectedResponse =
        ExportRegisteredPartiesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";
    BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);

    ExportRegisteredPartiesResponse actualResponse =
        client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportRegisteredPartiesRequest actualRequest =
        ((ExportRegisteredPartiesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(lineOfBusiness, actualRequest.getLineOfBusiness());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportRegisteredPartiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDatasetsTest() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest2() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    mockAML.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Dataset dataset = Dataset.newBuilder().build();
    String datasetId = "datasetId-345342029";

    Dataset actualResponse = client.createDatasetAsync(parent, dataset, datasetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = ((CreateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(datasetId, actualRequest.getDatasetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Dataset dataset = Dataset.newBuilder().build();
      String datasetId = "datasetId-345342029";
      client.createDatasetAsync(parent, dataset, datasetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    Dataset dataset = Dataset.newBuilder().build();
    String datasetId = "datasetId-345342029";

    Dataset actualResponse = client.createDatasetAsync(parent, dataset, datasetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = ((CreateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(datasetId, actualRequest.getDatasetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      Dataset dataset = Dataset.newBuilder().build();
      String datasetId = "datasetId-345342029";
      client.createDatasetAsync(parent, dataset, datasetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    Dataset dataset = Dataset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Dataset actualResponse = client.updateDatasetAsync(dataset, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatasetRequest actualRequest = ((UpdateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      Dataset dataset = Dataset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetAsync(dataset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");

    client.deleteDatasetAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = ((DeleteDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDatasetAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = ((DeleteDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelsRequest actualRequest = ((ListModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelsRequest actualRequest = ((ListModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Model model = Model.newBuilder().build();
    String modelId = "modelId1226956324";

    Model actualResponse = client.createModelAsync(parent, model, modelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelRequest actualRequest = ((CreateModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(modelId, actualRequest.getModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Model model = Model.newBuilder().build();
      String modelId = "modelId1226956324";
      client.createModelAsync(parent, model, modelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    Model model = Model.newBuilder().build();
    String modelId = "modelId1226956324";

    Model actualResponse = client.createModelAsync(parent, model, modelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelRequest actualRequest = ((CreateModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(modelId, actualRequest.getModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      Model model = Model.newBuilder().build();
      String modelId = "modelId1226956324";
      client.createModelAsync(parent, model, modelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    Model model = Model.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Model actualResponse = client.updateModelAsync(model, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateModelRequest actualRequest = ((UpdateModelRequest) actualRequests.get(0));

    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      Model model = Model.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateModelAsync(model, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportModelMetadataTest() throws Exception {
    ExportModelMetadataResponse expectedResponse = ExportModelMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    ModelName model = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportModelMetadataResponse actualResponse =
        client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportModelMetadataRequest actualRequest = ((ExportModelMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(model.toString(), actualRequest.getModel());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportModelMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      ModelName model = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportModelMetadataTest2() throws Exception {
    ExportModelMetadataResponse expectedResponse = ExportModelMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String model = "model104069929";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportModelMetadataResponse actualResponse =
        client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportModelMetadataRequest actualRequest = ((ExportModelMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportModelMetadataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String model = "model104069929";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");

    client.deleteModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelRequest actualRequest = ((DeleteModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelRequest actualRequest = ((DeleteModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEngineConfigsTest() throws Exception {
    EngineConfig responsesElement = EngineConfig.newBuilder().build();
    ListEngineConfigsResponse expectedResponse =
        ListEngineConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineConfigs(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListEngineConfigsPagedResponse pagedListResponse = client.listEngineConfigs(parent);

    List<EngineConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEngineConfigsRequest actualRequest = ((ListEngineConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEngineConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listEngineConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineConfigsTest2() throws Exception {
    EngineConfig responsesElement = EngineConfig.newBuilder().build();
    ListEngineConfigsResponse expectedResponse =
        ListEngineConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineConfigs(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEngineConfigsPagedResponse pagedListResponse = client.listEngineConfigs(parent);

    List<EngineConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEngineConfigsRequest actualRequest = ((ListEngineConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEngineConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEngineConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    mockAML.addResponse(expectedResponse);

    EngineConfigName name =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");

    EngineConfig actualResponse = client.getEngineConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineConfigRequest actualRequest = ((GetEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      EngineConfigName name =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      client.getEngineConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineConfigTest2() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    EngineConfig actualResponse = client.getEngineConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineConfigRequest actualRequest = ((GetEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getEngineConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    EngineConfig engineConfig = EngineConfig.newBuilder().build();
    String engineConfigId = "engineConfigId451461215";

    EngineConfig actualResponse =
        client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEngineConfigRequest actualRequest = ((CreateEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(engineConfig, actualRequest.getEngineConfig());
    Assert.assertEquals(engineConfigId, actualRequest.getEngineConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEngineConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      EngineConfig engineConfig = EngineConfig.newBuilder().build();
      String engineConfigId = "engineConfigId451461215";
      client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEngineConfigTest2() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    EngineConfig engineConfig = EngineConfig.newBuilder().build();
    String engineConfigId = "engineConfigId451461215";

    EngineConfig actualResponse =
        client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEngineConfigRequest actualRequest = ((CreateEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(engineConfig, actualRequest.getEngineConfig());
    Assert.assertEquals(engineConfigId, actualRequest.getEngineConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEngineConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      EngineConfig engineConfig = EngineConfig.newBuilder().build();
      String engineConfigId = "engineConfigId451461215";
      client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    EngineConfig engineConfig = EngineConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EngineConfig actualResponse = client.updateEngineConfigAsync(engineConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEngineConfigRequest actualRequest = ((UpdateEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(engineConfig, actualRequest.getEngineConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEngineConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      EngineConfig engineConfig = EngineConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEngineConfigAsync(engineConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportEngineConfigMetadataTest() throws Exception {
    ExportEngineConfigMetadataResponse expectedResponse =
        ExportEngineConfigMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEngineConfigMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    EngineConfigName engineConfig =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportEngineConfigMetadataResponse actualResponse =
        client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportEngineConfigMetadataRequest actualRequest =
        ((ExportEngineConfigMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(engineConfig.toString(), actualRequest.getEngineConfig());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportEngineConfigMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      EngineConfigName engineConfig =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportEngineConfigMetadataTest2() throws Exception {
    ExportEngineConfigMetadataResponse expectedResponse =
        ExportEngineConfigMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEngineConfigMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String engineConfig = "engineConfig389296164";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportEngineConfigMetadataResponse actualResponse =
        client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportEngineConfigMetadataRequest actualRequest =
        ((ExportEngineConfigMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(engineConfig, actualRequest.getEngineConfig());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportEngineConfigMetadataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String engineConfig = "engineConfig389296164";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEngineConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    EngineConfigName name =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");

    client.deleteEngineConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEngineConfigRequest actualRequest = ((DeleteEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEngineConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      EngineConfigName name =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      client.deleteEngineConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEngineConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEngineConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEngineConfigRequest actualRequest = ((DeleteEngineConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEngineConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEngineConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getEngineVersionTest() throws Exception {
    EngineVersion expectedResponse =
        EngineVersion.newBuilder()
            .setName(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setExpectedLimitationStartTime(Timestamp.newBuilder().build())
            .setExpectedDecommissionTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    EngineVersionName name =
        EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]");

    EngineVersion actualResponse = client.getEngineVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineVersionRequest actualRequest = ((GetEngineVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      EngineVersionName name =
          EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]");
      client.getEngineVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineVersionTest2() throws Exception {
    EngineVersion expectedResponse =
        EngineVersion.newBuilder()
            .setName(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setExpectedLimitationStartTime(Timestamp.newBuilder().build())
            .setExpectedDecommissionTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    EngineVersion actualResponse = client.getEngineVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineVersionRequest actualRequest = ((GetEngineVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getEngineVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineVersionsTest() throws Exception {
    EngineVersion responsesElement = EngineVersion.newBuilder().build();
    ListEngineVersionsResponse expectedResponse =
        ListEngineVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineVersions(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListEngineVersionsPagedResponse pagedListResponse = client.listEngineVersions(parent);

    List<EngineVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEngineVersionsRequest actualRequest = ((ListEngineVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEngineVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listEngineVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineVersionsTest2() throws Exception {
    EngineVersion responsesElement = EngineVersion.newBuilder().build();
    ListEngineVersionsResponse expectedResponse =
        ListEngineVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineVersions(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEngineVersionsPagedResponse pagedListResponse = client.listEngineVersions(parent);

    List<EngineVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEngineVersionsRequest actualRequest = ((ListEngineVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEngineVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEngineVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionResultsTest() throws Exception {
    PredictionResult responsesElement = PredictionResult.newBuilder().build();
    ListPredictionResultsResponse expectedResponse =
        ListPredictionResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionResults(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListPredictionResultsPagedResponse pagedListResponse = client.listPredictionResults(parent);

    List<PredictionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPredictionResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPredictionResultsRequest actualRequest =
        ((ListPredictionResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPredictionResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listPredictionResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionResultsTest2() throws Exception {
    PredictionResult responsesElement = PredictionResult.newBuilder().build();
    ListPredictionResultsResponse expectedResponse =
        ListPredictionResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionResults(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPredictionResultsPagedResponse pagedListResponse = client.listPredictionResults(parent);

    List<PredictionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPredictionResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPredictionResultsRequest actualRequest =
        ((ListPredictionResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPredictionResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPredictionResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    PredictionResultName name =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");

    PredictionResult actualResponse = client.getPredictionResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPredictionResultRequest actualRequest = ((GetPredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPredictionResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      PredictionResultName name =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      client.getPredictionResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPredictionResultTest2() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    PredictionResult actualResponse = client.getPredictionResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPredictionResultRequest actualRequest = ((GetPredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPredictionResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getPredictionResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    PredictionResult predictionResult = PredictionResult.newBuilder().build();
    String predictionResultId = "predictionResultId62892999";

    PredictionResult actualResponse =
        client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePredictionResultRequest actualRequest =
        ((CreatePredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(predictionResult, actualRequest.getPredictionResult());
    Assert.assertEquals(predictionResultId, actualRequest.getPredictionResultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPredictionResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      PredictionResult predictionResult = PredictionResult.newBuilder().build();
      String predictionResultId = "predictionResultId62892999";
      client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPredictionResultTest2() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    PredictionResult predictionResult = PredictionResult.newBuilder().build();
    String predictionResultId = "predictionResultId62892999";

    PredictionResult actualResponse =
        client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePredictionResultRequest actualRequest =
        ((CreatePredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(predictionResult, actualRequest.getPredictionResult());
    Assert.assertEquals(predictionResultId, actualRequest.getPredictionResultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPredictionResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      PredictionResult predictionResult = PredictionResult.newBuilder().build();
      String predictionResultId = "predictionResultId62892999";
      client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updatePredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    PredictionResult predictionResult = PredictionResult.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PredictionResult actualResponse =
        client.updatePredictionResultAsync(predictionResult, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePredictionResultRequest actualRequest =
        ((UpdatePredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(predictionResult, actualRequest.getPredictionResult());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePredictionResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      PredictionResult predictionResult = PredictionResult.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePredictionResultAsync(predictionResult, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportPredictionResultMetadataTest() throws Exception {
    ExportPredictionResultMetadataResponse expectedResponse =
        ExportPredictionResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportPredictionResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    PredictionResultName predictionResult =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportPredictionResultMetadataResponse actualResponse =
        client
            .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportPredictionResultMetadataRequest actualRequest =
        ((ExportPredictionResultMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(predictionResult.toString(), actualRequest.getPredictionResult());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportPredictionResultMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      PredictionResultName predictionResult =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client
          .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportPredictionResultMetadataTest2() throws Exception {
    ExportPredictionResultMetadataResponse expectedResponse =
        ExportPredictionResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportPredictionResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String predictionResult = "predictionResult-1877027444";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportPredictionResultMetadataResponse actualResponse =
        client
            .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportPredictionResultMetadataRequest actualRequest =
        ((ExportPredictionResultMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(predictionResult, actualRequest.getPredictionResult());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportPredictionResultMetadataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String predictionResult = "predictionResult-1877027444";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client
          .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePredictionResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    PredictionResultName name =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");

    client.deletePredictionResultAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePredictionResultRequest actualRequest =
        ((DeletePredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePredictionResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      PredictionResultName name =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      client.deletePredictionResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePredictionResultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePredictionResultAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePredictionResultRequest actualRequest =
        ((DeletePredictionResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePredictionResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.deletePredictionResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBacktestResultsTest() throws Exception {
    BacktestResult responsesElement = BacktestResult.newBuilder().build();
    ListBacktestResultsResponse expectedResponse =
        ListBacktestResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBacktestResults(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListBacktestResultsPagedResponse pagedListResponse = client.listBacktestResults(parent);

    List<BacktestResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBacktestResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBacktestResultsRequest actualRequest = ((ListBacktestResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBacktestResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listBacktestResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBacktestResultsTest2() throws Exception {
    BacktestResult responsesElement = BacktestResult.newBuilder().build();
    ListBacktestResultsResponse expectedResponse =
        ListBacktestResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBacktestResults(Arrays.asList(responsesElement))
            .build();
    mockAML.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBacktestResultsPagedResponse pagedListResponse = client.listBacktestResults(parent);

    List<BacktestResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBacktestResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBacktestResultsRequest actualRequest = ((ListBacktestResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBacktestResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBacktestResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    BacktestResultName name =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");

    BacktestResult actualResponse = client.getBacktestResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBacktestResultRequest actualRequest = ((GetBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBacktestResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      BacktestResultName name =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      client.getBacktestResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBacktestResultTest2() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockAML.addResponse(expectedResponse);

    String name = "name3373707";

    BacktestResult actualResponse = client.getBacktestResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBacktestResultRequest actualRequest = ((GetBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBacktestResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.getBacktestResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    BacktestResult backtestResult = BacktestResult.newBuilder().build();
    String backtestResultId = "backtestResultId-2045569231";

    BacktestResult actualResponse =
        client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBacktestResultRequest actualRequest =
        ((CreateBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backtestResult, actualRequest.getBacktestResult());
    Assert.assertEquals(backtestResultId, actualRequest.getBacktestResultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBacktestResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      BacktestResult backtestResult = BacktestResult.newBuilder().build();
      String backtestResultId = "backtestResultId-2045569231";
      client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBacktestResultTest2() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String parent = "parent-995424086";
    BacktestResult backtestResult = BacktestResult.newBuilder().build();
    String backtestResultId = "backtestResultId-2045569231";

    BacktestResult actualResponse =
        client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBacktestResultRequest actualRequest =
        ((CreateBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backtestResult, actualRequest.getBacktestResult());
    Assert.assertEquals(backtestResultId, actualRequest.getBacktestResultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBacktestResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String parent = "parent-995424086";
      BacktestResult backtestResult = BacktestResult.newBuilder().build();
      String backtestResultId = "backtestResultId-2045569231";
      client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    BacktestResult backtestResult = BacktestResult.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BacktestResult actualResponse =
        client.updateBacktestResultAsync(backtestResult, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBacktestResultRequest actualRequest =
        ((UpdateBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(backtestResult, actualRequest.getBacktestResult());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBacktestResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      BacktestResult backtestResult = BacktestResult.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBacktestResultAsync(backtestResult, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportBacktestResultMetadataTest() throws Exception {
    ExportBacktestResultMetadataResponse expectedResponse =
        ExportBacktestResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBacktestResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    BacktestResultName backtestResult =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportBacktestResultMetadataResponse actualResponse =
        client
            .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportBacktestResultMetadataRequest actualRequest =
        ((ExportBacktestResultMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(backtestResult.toString(), actualRequest.getBacktestResult());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportBacktestResultMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      BacktestResultName backtestResult =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportBacktestResultMetadataTest2() throws Exception {
    ExportBacktestResultMetadataResponse expectedResponse =
        ExportBacktestResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBacktestResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String backtestResult = "backtestResult1883902838";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportBacktestResultMetadataResponse actualResponse =
        client
            .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportBacktestResultMetadataRequest actualRequest =
        ((ExportBacktestResultMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(backtestResult, actualRequest.getBacktestResult());
    Assert.assertEquals(
        structuredMetadataDestination, actualRequest.getStructuredMetadataDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportBacktestResultMetadataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String backtestResult = "backtestResult1883902838";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBacktestResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    BacktestResultName name =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");

    client.deleteBacktestResultAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBacktestResultRequest actualRequest =
        ((DeleteBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBacktestResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      BacktestResultName name =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      client.deleteBacktestResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBacktestResultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAML.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBacktestResultAsync(name).get();

    List<AbstractMessage> actualRequests = mockAML.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBacktestResultRequest actualRequest =
        ((DeleteBacktestResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBacktestResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAML.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBacktestResultAsync(name).get();
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
}
