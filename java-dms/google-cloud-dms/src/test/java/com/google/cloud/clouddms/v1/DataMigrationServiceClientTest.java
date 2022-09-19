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

package com.google.cloud.clouddms.v1;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;

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
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class DataMigrationServiceClientTest {
  private static MockDataMigrationService mockDataMigrationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataMigrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataMigrationService = new MockDataMigrationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataMigrationService));
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
    DataMigrationServiceSettings settings =
        DataMigrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataMigrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMigrationJobsTest() throws Exception {
    MigrationJob responsesElement = MigrationJob.newBuilder().build();
    ListMigrationJobsResponse expectedResponse =
        ListMigrationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationJobs(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMigrationJobsPagedResponse pagedListResponse = client.listMigrationJobs(parent);

    List<MigrationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationJobsRequest actualRequest = ((ListMigrationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMigrationJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationJobsTest2() throws Exception {
    MigrationJob responsesElement = MigrationJob.newBuilder().build();
    ListMigrationJobsResponse expectedResponse =
        ListMigrationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationJobs(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMigrationJobsPagedResponse pagedListResponse = client.listMigrationJobs(parent);

    List<MigrationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationJobsRequest actualRequest = ((ListMigrationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMigrationJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");

    MigrationJob actualResponse = client.getMigrationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationJobRequest actualRequest = ((GetMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");
      client.getMigrationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationJobTest2() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    MigrationJob actualResponse = client.getMigrationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationJobRequest actualRequest = ((GetMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getMigrationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MigrationJob migrationJob = MigrationJob.newBuilder().build();
    String migrationJobId = "migrationJobId1870575242";

    MigrationJob actualResponse =
        client.createMigrationJobAsync(parent, migrationJob, migrationJobId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMigrationJobRequest actualRequest = ((CreateMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(migrationJob, actualRequest.getMigrationJob());
    Assert.assertEquals(migrationJobId, actualRequest.getMigrationJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MigrationJob migrationJob = MigrationJob.newBuilder().build();
      String migrationJobId = "migrationJobId1870575242";
      client.createMigrationJobAsync(parent, migrationJob, migrationJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMigrationJobTest2() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    MigrationJob migrationJob = MigrationJob.newBuilder().build();
    String migrationJobId = "migrationJobId1870575242";

    MigrationJob actualResponse =
        client.createMigrationJobAsync(parent, migrationJob, migrationJobId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMigrationJobRequest actualRequest = ((CreateMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(migrationJob, actualRequest.getMigrationJob());
    Assert.assertEquals(migrationJobId, actualRequest.getMigrationJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMigrationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      MigrationJob migrationJob = MigrationJob.newBuilder().build();
      String migrationJobId = "migrationJobId1870575242";
      client.createMigrationJobAsync(parent, migrationJob, migrationJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    MigrationJob migrationJob = MigrationJob.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MigrationJob actualResponse = client.updateMigrationJobAsync(migrationJob, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMigrationJobRequest actualRequest = ((UpdateMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(migrationJob, actualRequest.getMigrationJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      MigrationJob migrationJob = MigrationJob.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMigrationJobAsync(migrationJob, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMigrationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");

    client.deleteMigrationJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMigrationJobRequest actualRequest = ((DeleteMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");
      client.deleteMigrationJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMigrationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMigrationJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMigrationJobRequest actualRequest = ((DeleteMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMigrationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMigrationJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    StartMigrationJobRequest request =
        StartMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.startMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartMigrationJobRequest actualRequest = ((StartMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      StartMigrationJobRequest request =
          StartMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.startMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    StopMigrationJobRequest request =
        StopMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.stopMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopMigrationJobRequest actualRequest = ((StopMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      StopMigrationJobRequest request =
          StopMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.stopMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resumeMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ResumeMigrationJobRequest request =
        ResumeMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.resumeMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeMigrationJobRequest actualRequest = ((ResumeMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ResumeMigrationJobRequest request =
          ResumeMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.resumeMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void promoteMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("promoteMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    PromoteMigrationJobRequest request =
        PromoteMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.promoteMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PromoteMigrationJobRequest actualRequest = ((PromoteMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void promoteMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      PromoteMigrationJobRequest request =
          PromoteMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.promoteMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void verifyMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("verifyMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    VerifyMigrationJobRequest request =
        VerifyMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.verifyMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyMigrationJobRequest actualRequest = ((VerifyMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void verifyMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      VerifyMigrationJobRequest request =
          VerifyMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.verifyMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restartMigrationJobTest() throws Exception {
    MigrationJob expectedResponse =
        MigrationJob.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDumpPath("dumpPath-2122385351")
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restartMigrationJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    RestartMigrationJobRequest request =
        RestartMigrationJobRequest.newBuilder()
            .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .build();

    MigrationJob actualResponse = client.restartMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartMigrationJobRequest actualRequest = ((RestartMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartMigrationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      RestartMigrationJobRequest request =
          RestartMigrationJobRequest.newBuilder()
              .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .build();
      client.restartMigrationJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateSshScriptTest() throws Exception {
    SshScript expectedResponse = SshScript.newBuilder().setScript("script-907685685").build();
    mockDataMigrationService.addResponse(expectedResponse);

    GenerateSshScriptRequest request =
        GenerateSshScriptRequest.newBuilder()
            .setMigrationJob(
                MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setVm("vm3767")
            .setVmPort(563010825)
            .build();

    SshScript actualResponse = client.generateSshScript(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateSshScriptRequest actualRequest = ((GenerateSshScriptRequest) actualRequests.get(0));

    Assert.assertEquals(request.getMigrationJob(), actualRequest.getMigrationJob());
    Assert.assertEquals(request.getVm(), actualRequest.getVm());
    Assert.assertEquals(request.getVmCreationConfig(), actualRequest.getVmCreationConfig());
    Assert.assertEquals(request.getVmSelectionConfig(), actualRequest.getVmSelectionConfig());
    Assert.assertEquals(request.getVmPort(), actualRequest.getVmPort());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateSshScriptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      GenerateSshScriptRequest request =
          GenerateSshScriptRequest.newBuilder()
              .setMigrationJob(
                  MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .setVm("vm3767")
              .setVmPort(563010825)
              .build();
      client.generateSshScript(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionProfilesTest() throws Exception {
    ConnectionProfile responsesElement = ConnectionProfile.newBuilder().build();
    ListConnectionProfilesResponse expectedResponse =
        ListConnectionProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectionProfiles(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectionProfilesPagedResponse pagedListResponse = client.listConnectionProfiles(parent);

    List<ConnectionProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionProfilesRequest actualRequest =
        ((ListConnectionProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnectionProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionProfilesTest2() throws Exception {
    ConnectionProfile responsesElement = ConnectionProfile.newBuilder().build();
    ListConnectionProfilesResponse expectedResponse =
        ListConnectionProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectionProfiles(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectionProfilesPagedResponse pagedListResponse = client.listConnectionProfiles(parent);

    List<ConnectionProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionProfilesRequest actualRequest =
        ((ListConnectionProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectionProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .setProvider(DatabaseProvider.forNumber(0))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    ConnectionProfileName name =
        ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");

    ConnectionProfile actualResponse = client.getConnectionProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionProfileRequest actualRequest =
        ((GetConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConnectionProfileName name =
          ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
      client.getConnectionProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionProfileTest2() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .setProvider(DatabaseProvider.forNumber(0))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    ConnectionProfile actualResponse = client.getConnectionProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionProfileRequest actualRequest =
        ((GetConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getConnectionProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .setProvider(DatabaseProvider.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConnectionProfileName parent =
        ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    String connectionProfileId = "connectionProfileId597575526";

    ConnectionProfile actualResponse =
        client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionProfileRequest actualRequest =
        ((CreateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(connectionProfileId, actualRequest.getConnectionProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConnectionProfileName parent =
          ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      String connectionProfileId = "connectionProfileId597575526";
      client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConnectionProfileTest2() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .setProvider(DatabaseProvider.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    String connectionProfileId = "connectionProfileId597575526";

    ConnectionProfile actualResponse =
        client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionProfileRequest actualRequest =
        ((CreateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(connectionProfileId, actualRequest.getConnectionProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      String connectionProfileId = "connectionProfileId597575526";
      client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .setProvider(DatabaseProvider.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConnectionProfile actualResponse =
        client.updateConnectionProfileAsync(connectionProfile, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectionProfileRequest actualRequest =
        ((UpdateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectionProfileAsync(connectionProfile, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectionProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConnectionProfileName name =
        ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");

    client.deleteConnectionProfileAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionProfileRequest actualRequest =
        ((DeleteConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConnectionProfileName name =
          ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
      client.deleteConnectionProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectionProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectionProfileAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionProfileRequest actualRequest =
        ((DeleteConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectionProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
