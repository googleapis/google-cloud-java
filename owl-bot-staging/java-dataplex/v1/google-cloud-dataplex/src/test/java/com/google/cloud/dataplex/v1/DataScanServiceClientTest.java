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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class DataScanServiceClientTest {
  private static MockDataScanService mockDataScanService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataScanServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataScanService = new MockDataScanService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataScanService, mockLocations, mockIAMPolicy));
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
    DataScanServiceSettings settings =
        DataScanServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataScanServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataScanService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataScan dataScan = DataScan.newBuilder().build();
    String dataScanId = "dataScanId1260787906";

    DataScan actualResponse = client.createDataScanAsync(parent, dataScan, dataScanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataScanRequest actualRequest = ((CreateDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataScan, actualRequest.getDataScan());
    Assert.assertEquals(dataScanId, actualRequest.getDataScanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataScanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataScan dataScan = DataScan.newBuilder().build();
      String dataScanId = "dataScanId1260787906";
      client.createDataScanAsync(parent, dataScan, dataScanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataScanTest2() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataScanService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataScan dataScan = DataScan.newBuilder().build();
    String dataScanId = "dataScanId1260787906";

    DataScan actualResponse = client.createDataScanAsync(parent, dataScan, dataScanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataScanRequest actualRequest = ((CreateDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataScan, actualRequest.getDataScan());
    Assert.assertEquals(dataScanId, actualRequest.getDataScanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataScanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataScan dataScan = DataScan.newBuilder().build();
      String dataScanId = "dataScanId1260787906";
      client.createDataScanAsync(parent, dataScan, dataScanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataScanService.addResponse(resultOperation);

    DataScan dataScan = DataScan.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataScan actualResponse = client.updateDataScanAsync(dataScan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataScanRequest actualRequest = ((UpdateDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(dataScan, actualRequest.getDataScan());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataScanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScan dataScan = DataScan.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataScanAsync(dataScan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataScanTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataScanService.addResponse(resultOperation);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    client.deleteDataScanAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataScanRequest actualRequest = ((DeleteDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataScanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.deleteDataScanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataScanTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataScanService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataScanAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataScanRequest actualRequest = ((DeleteDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataScanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataScanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    DataScan actualResponse = client.getDataScan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataScanRequest actualRequest = ((GetDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataScanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.getDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanTest2() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    String name = "name3373707";

    DataScan actualResponse = client.getDataScan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataScanRequest actualRequest = ((GetDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataScanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScansTest() throws Exception {
    DataScan responsesElement = DataScan.newBuilder().build();
    ListDataScansResponse expectedResponse =
        ListDataScansResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScans(Arrays.asList(responsesElement))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataScansPagedResponse pagedListResponse = client.listDataScans(parent);

    List<DataScan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataScansRequest actualRequest = ((ListDataScansRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataScansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataScans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScansTest2() throws Exception {
    DataScan responsesElement = DataScan.newBuilder().build();
    ListDataScansResponse expectedResponse =
        ListDataScansResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScans(Arrays.asList(responsesElement))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataScansPagedResponse pagedListResponse = client.listDataScans(parent);

    List<DataScan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataScansRequest actualRequest = ((ListDataScansRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataScansExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataScans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runDataScanTest() throws Exception {
    RunDataScanResponse expectedResponse =
        RunDataScanResponse.newBuilder().setJob(DataScanJob.newBuilder().build()).build();
    mockDataScanService.addResponse(expectedResponse);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    RunDataScanResponse actualResponse = client.runDataScan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunDataScanRequest actualRequest = ((RunDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runDataScanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.runDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runDataScanTest2() throws Exception {
    RunDataScanResponse expectedResponse =
        RunDataScanResponse.newBuilder().setJob(DataScanJob.newBuilder().build()).build();
    mockDataScanService.addResponse(expectedResponse);

    String name = "name3373707";

    RunDataScanResponse actualResponse = client.runDataScan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunDataScanRequest actualRequest = ((RunDataScanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runDataScanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String name = "name3373707";
      client.runDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanJobTest() throws Exception {
    DataScanJob expectedResponse =
        DataScanJob.newBuilder()
            .setName(
                DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setMessage("message954925063")
            .setType(DataScanType.forNumber(0))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    DataScanJobName name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]");

    DataScanJob actualResponse = client.getDataScanJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataScanJobRequest actualRequest = ((GetDataScanJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataScanJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScanJobName name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]");
      client.getDataScanJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanJobTest2() throws Exception {
    DataScanJob expectedResponse =
        DataScanJob.newBuilder()
            .setName(
                DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setMessage("message954925063")
            .setType(DataScanType.forNumber(0))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    String name = "name3373707";

    DataScanJob actualResponse = client.getDataScanJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataScanJobRequest actualRequest = ((GetDataScanJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataScanJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataScanJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScanJobsTest() throws Exception {
    DataScanJob responsesElement = DataScanJob.newBuilder().build();
    ListDataScanJobsResponse expectedResponse =
        ListDataScanJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScanJobs(Arrays.asList(responsesElement))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    DataScanName parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    ListDataScanJobsPagedResponse pagedListResponse = client.listDataScanJobs(parent);

    List<DataScanJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScanJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataScanJobsRequest actualRequest = ((ListDataScanJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataScanJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      DataScanName parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.listDataScanJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScanJobsTest2() throws Exception {
    DataScanJob responsesElement = DataScanJob.newBuilder().build();
    ListDataScanJobsResponse expectedResponse =
        ListDataScanJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScanJobs(Arrays.asList(responsesElement))
            .build();
    mockDataScanService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataScanJobsPagedResponse pagedListResponse = client.listDataScanJobs(parent);

    List<DataScanJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScanJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataScanService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataScanJobsRequest actualRequest = ((ListDataScanJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataScanJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataScanService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataScanJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
