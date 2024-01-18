/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.DescribeDatabaseEntitiesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConversionWorkspacesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMappingRulesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListPrivateConnectionsPagedResponse;

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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setSkipValidation(true)
            .build();

    MigrationJob actualResponse = client.startMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartMigrationJobRequest actualRequest = ((StartMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getSkipValidation(), actualRequest.getSkipValidation());
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
              .setSkipValidation(true)
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setUpdateMask(FieldMask.newBuilder().build())
            .setMigrationJob(MigrationJob.newBuilder().build())
            .build();

    MigrationJob actualResponse = client.verifyMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyMigrationJobRequest actualRequest = ((VerifyMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getMigrationJob(), actualRequest.getMigrationJob());
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
              .setUpdateMask(FieldMask.newBuilder().build())
              .setMigrationJob(MigrationJob.newBuilder().build())
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
            .setDumpFlags(MigrationJob.DumpFlags.newBuilder().build())
            .setSource("source-896505829")
            .setDestination("destination-1429847026")
            .setDuration(Duration.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setSourceDatabase(DatabaseType.newBuilder().build())
            .setDestinationDatabase(DatabaseType.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setConversionWorkspace(ConversionWorkspaceInfo.newBuilder().build())
            .setFilter("filter-1274492040")
            .setCmekKeyName("cmekKeyName-1267813158")
            .setPerformanceConfig(MigrationJob.PerformanceConfig.newBuilder().build())
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
            .setSkipValidation(true)
            .build();

    MigrationJob actualResponse = client.restartMigrationJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartMigrationJobRequest actualRequest = ((RestartMigrationJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getSkipValidation(), actualRequest.getSkipValidation());
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
              .setSkipValidation(true)
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
  public void generateTcpProxyScriptTest() throws Exception {
    TcpProxyScript expectedResponse =
        TcpProxyScript.newBuilder().setScript("script-907685685").build();
    mockDataMigrationService.addResponse(expectedResponse);

    GenerateTcpProxyScriptRequest request =
        GenerateTcpProxyScriptRequest.newBuilder()
            .setMigrationJob(
                MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
            .setVmName("vmName-813643294")
            .setVmMachineType("vmMachineType-1921917718")
            .setVmZone("vmZone-813272317")
            .setVmSubnet("vmSubnet-65857292")
            .build();

    TcpProxyScript actualResponse = client.generateTcpProxyScript(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateTcpProxyScriptRequest actualRequest =
        ((GenerateTcpProxyScriptRequest) actualRequests.get(0));

    Assert.assertEquals(request.getMigrationJob(), actualRequest.getMigrationJob());
    Assert.assertEquals(request.getVmName(), actualRequest.getVmName());
    Assert.assertEquals(request.getVmMachineType(), actualRequest.getVmMachineType());
    Assert.assertEquals(request.getVmZone(), actualRequest.getVmZone());
    Assert.assertEquals(request.getVmSubnet(), actualRequest.getVmSubnet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateTcpProxyScriptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      GenerateTcpProxyScriptRequest request =
          GenerateTcpProxyScriptRequest.newBuilder()
              .setMigrationJob(
                  MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .setVmName("vmName-813643294")
              .setVmMachineType("vmMachineType-1921917718")
              .setVmZone("vmZone-813272317")
              .setVmSubnet("vmSubnet-65857292")
              .build();
      client.generateTcpProxyScript(request);
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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

  @Test
  public void createPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Status.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest2() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    ConversionWorkspaceName name =
        ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");

    ConversionWorkspace actualResponse = client.getConversionWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionWorkspaceRequest actualRequest =
        ((GetConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspaceName name =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
      client.getConversionWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionWorkspaceTest2() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    ConversionWorkspace actualResponse = client.getConversionWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionWorkspaceRequest actualRequest =
        ((GetConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getConversionWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionWorkspacesTest() throws Exception {
    ConversionWorkspace responsesElement = ConversionWorkspace.newBuilder().build();
    ListConversionWorkspacesResponse expectedResponse =
        ListConversionWorkspacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionWorkspaces(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversionWorkspacesPagedResponse pagedListResponse =
        client.listConversionWorkspaces(parent);

    List<ConversionWorkspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionWorkspacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionWorkspacesRequest actualRequest =
        ((ListConversionWorkspacesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionWorkspacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConversionWorkspaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionWorkspacesTest2() throws Exception {
    ConversionWorkspace responsesElement = ConversionWorkspace.newBuilder().build();
    ListConversionWorkspacesResponse expectedResponse =
        ListConversionWorkspacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionWorkspaces(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversionWorkspacesPagedResponse pagedListResponse =
        client.listConversionWorkspaces(parent);

    List<ConversionWorkspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionWorkspacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionWorkspacesRequest actualRequest =
        ((ListConversionWorkspacesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionWorkspacesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversionWorkspaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
    String conversionWorkspaceId = "conversionWorkspaceId-928604774";

    ConversionWorkspace actualResponse =
        client
            .createConversionWorkspaceAsync(parent, conversionWorkspace, conversionWorkspaceId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionWorkspaceRequest actualRequest =
        ((CreateConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversionWorkspace, actualRequest.getConversionWorkspace());
    Assert.assertEquals(conversionWorkspaceId, actualRequest.getConversionWorkspaceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
      String conversionWorkspaceId = "conversionWorkspaceId-928604774";
      client
          .createConversionWorkspaceAsync(parent, conversionWorkspace, conversionWorkspaceId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConversionWorkspaceTest2() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
    String conversionWorkspaceId = "conversionWorkspaceId-928604774";

    ConversionWorkspace actualResponse =
        client
            .createConversionWorkspaceAsync(parent, conversionWorkspace, conversionWorkspaceId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionWorkspaceRequest actualRequest =
        ((CreateConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversionWorkspace, actualRequest.getConversionWorkspace());
    Assert.assertEquals(conversionWorkspaceId, actualRequest.getConversionWorkspaceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
      String conversionWorkspaceId = "conversionWorkspaceId-928604774";
      client
          .createConversionWorkspaceAsync(parent, conversionWorkspace, conversionWorkspaceId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversionWorkspace actualResponse =
        client.updateConversionWorkspaceAsync(conversionWorkspace, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConversionWorkspaceRequest actualRequest =
        ((UpdateConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(conversionWorkspace, actualRequest.getConversionWorkspace());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspace conversionWorkspace = ConversionWorkspace.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversionWorkspaceAsync(conversionWorkspace, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConversionWorkspaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConversionWorkspaceName name =
        ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");

    client.deleteConversionWorkspaceAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionWorkspaceRequest actualRequest =
        ((DeleteConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspaceName name =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
      client.deleteConversionWorkspaceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConversionWorkspaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConversionWorkspaceAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionWorkspaceRequest actualRequest =
        ((DeleteConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConversionWorkspaceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMappingRuleTest() throws Exception {
    MappingRule expectedResponse =
        MappingRule.newBuilder()
            .setName(
                MappingRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRuleScope(DatabaseEntityType.forNumber(0))
            .setFilter(MappingRuleFilter.newBuilder().build())
            .setRuleOrder(-432188341)
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    ConversionWorkspaceName parent =
        ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
    MappingRule mappingRule = MappingRule.newBuilder().build();
    String mappingRuleId = "mappingRuleId-900824155";

    MappingRule actualResponse = client.createMappingRule(parent, mappingRule, mappingRuleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMappingRuleRequest actualRequest = ((CreateMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mappingRule, actualRequest.getMappingRule());
    Assert.assertEquals(mappingRuleId, actualRequest.getMappingRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMappingRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspaceName parent =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
      MappingRule mappingRule = MappingRule.newBuilder().build();
      String mappingRuleId = "mappingRuleId-900824155";
      client.createMappingRule(parent, mappingRule, mappingRuleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMappingRuleTest2() throws Exception {
    MappingRule expectedResponse =
        MappingRule.newBuilder()
            .setName(
                MappingRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRuleScope(DatabaseEntityType.forNumber(0))
            .setFilter(MappingRuleFilter.newBuilder().build())
            .setRuleOrder(-432188341)
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MappingRule mappingRule = MappingRule.newBuilder().build();
    String mappingRuleId = "mappingRuleId-900824155";

    MappingRule actualResponse = client.createMappingRule(parent, mappingRule, mappingRuleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMappingRuleRequest actualRequest = ((CreateMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mappingRule, actualRequest.getMappingRule());
    Assert.assertEquals(mappingRuleId, actualRequest.getMappingRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMappingRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      MappingRule mappingRule = MappingRule.newBuilder().build();
      String mappingRuleId = "mappingRuleId-900824155";
      client.createMappingRule(parent, mappingRule, mappingRuleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMappingRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataMigrationService.addResponse(expectedResponse);

    ConversionWorkspaceName name =
        ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");

    client.deleteMappingRule(name);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMappingRuleRequest actualRequest = ((DeleteMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMappingRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspaceName name =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
      client.deleteMappingRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMappingRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMappingRule(name);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMappingRuleRequest actualRequest = ((DeleteMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMappingRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMappingRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMappingRulesTest() throws Exception {
    MappingRule responsesElement = MappingRule.newBuilder().build();
    ListMappingRulesResponse expectedResponse =
        ListMappingRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMappingRules(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    ConversionWorkspaceName parent =
        ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");

    ListMappingRulesPagedResponse pagedListResponse = client.listMappingRules(parent);

    List<MappingRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMappingRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMappingRulesRequest actualRequest = ((ListMappingRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMappingRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConversionWorkspaceName parent =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]");
      client.listMappingRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMappingRulesTest2() throws Exception {
    MappingRule responsesElement = MappingRule.newBuilder().build();
    ListMappingRulesResponse expectedResponse =
        ListMappingRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMappingRules(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMappingRulesPagedResponse pagedListResponse = client.listMappingRules(parent);

    List<MappingRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMappingRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMappingRulesRequest actualRequest = ((ListMappingRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMappingRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMappingRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMappingRuleTest() throws Exception {
    MappingRule expectedResponse =
        MappingRule.newBuilder()
            .setName(
                MappingRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRuleScope(DatabaseEntityType.forNumber(0))
            .setFilter(MappingRuleFilter.newBuilder().build())
            .setRuleOrder(-432188341)
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    MappingRuleName name =
        MappingRuleName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]");

    MappingRule actualResponse = client.getMappingRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMappingRuleRequest actualRequest = ((GetMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMappingRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      MappingRuleName name =
          MappingRuleName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]");
      client.getMappingRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMappingRuleTest2() throws Exception {
    MappingRule expectedResponse =
        MappingRule.newBuilder()
            .setName(
                MappingRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]", "[MAPPING_RULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRuleScope(DatabaseEntityType.forNumber(0))
            .setFilter(MappingRuleFilter.newBuilder().build())
            .setRuleOrder(-432188341)
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    MappingRule actualResponse = client.getMappingRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMappingRuleRequest actualRequest = ((GetMappingRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMappingRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getMappingRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void seedConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("seedConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    SeedConversionWorkspaceRequest request =
        SeedConversionWorkspaceRequest.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setAutoCommit(true)
            .build();

    ConversionWorkspace actualResponse = client.seedConversionWorkspaceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SeedConversionWorkspaceRequest actualRequest =
        ((SeedConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAutoCommit(), actualRequest.getAutoCommit());
    Assert.assertEquals(
        request.getSourceConnectionProfile(), actualRequest.getSourceConnectionProfile());
    Assert.assertEquals(
        request.getDestinationConnectionProfile(), actualRequest.getDestinationConnectionProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void seedConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      SeedConversionWorkspaceRequest request =
          SeedConversionWorkspaceRequest.newBuilder()
              .setName(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setAutoCommit(true)
              .build();
      client.seedConversionWorkspaceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importMappingRulesTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importMappingRulesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ImportMappingRulesRequest request =
        ImportMappingRulesRequest.newBuilder()
            .setParent(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setRulesFormat(ImportRulesFileFormat.forNumber(0))
            .addAllRulesFiles(new ArrayList<ImportMappingRulesRequest.RulesFile>())
            .setAutoCommit(true)
            .build();

    ConversionWorkspace actualResponse = client.importMappingRulesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportMappingRulesRequest actualRequest = ((ImportMappingRulesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRulesFormat(), actualRequest.getRulesFormat());
    Assert.assertEquals(request.getRulesFilesList(), actualRequest.getRulesFilesList());
    Assert.assertEquals(request.getAutoCommit(), actualRequest.getAutoCommit());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importMappingRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ImportMappingRulesRequest request =
          ImportMappingRulesRequest.newBuilder()
              .setParent(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setRulesFormat(ImportRulesFileFormat.forNumber(0))
              .addAllRulesFiles(new ArrayList<ImportMappingRulesRequest.RulesFile>())
              .setAutoCommit(true)
              .build();
      client.importMappingRulesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void convertConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("convertConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ConvertConversionWorkspaceRequest request =
        ConvertConversionWorkspaceRequest.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setAutoCommit(true)
            .setFilter("filter-1274492040")
            .setConvertFullPath(true)
            .build();

    ConversionWorkspace actualResponse = client.convertConversionWorkspaceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConvertConversionWorkspaceRequest actualRequest =
        ((ConvertConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAutoCommit(), actualRequest.getAutoCommit());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getConvertFullPath(), actualRequest.getConvertFullPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void convertConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ConvertConversionWorkspaceRequest request =
          ConvertConversionWorkspaceRequest.newBuilder()
              .setName(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setAutoCommit(true)
              .setFilter("filter-1274492040")
              .setConvertFullPath(true)
              .build();
      client.convertConversionWorkspaceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void commitConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("commitConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    CommitConversionWorkspaceRequest request =
        CommitConversionWorkspaceRequest.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setCommitName("commitName1018078306")
            .build();

    ConversionWorkspace actualResponse = client.commitConversionWorkspaceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitConversionWorkspaceRequest actualRequest =
        ((CommitConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCommitName(), actualRequest.getCommitName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      CommitConversionWorkspaceRequest request =
          CommitConversionWorkspaceRequest.newBuilder()
              .setName(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setCommitName("commitName1018078306")
              .build();
      client.commitConversionWorkspaceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rollbackConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rollbackConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    RollbackConversionWorkspaceRequest request =
        RollbackConversionWorkspaceRequest.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .build();

    ConversionWorkspace actualResponse = client.rollbackConversionWorkspaceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackConversionWorkspaceRequest actualRequest =
        ((RollbackConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      RollbackConversionWorkspaceRequest request =
          RollbackConversionWorkspaceRequest.newBuilder()
              .setName(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .build();
      client.rollbackConversionWorkspaceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void applyConversionWorkspaceTest() throws Exception {
    ConversionWorkspace expectedResponse =
        ConversionWorkspace.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setSource(DatabaseEngineInfo.newBuilder().build())
            .setDestination(DatabaseEngineInfo.newBuilder().build())
            .putAllGlobalSettings(new HashMap<String, String>())
            .setHasUncommittedChanges(true)
            .setLatestCommitId("latestCommitId-1343996583")
            .setLatestCommitTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applyConversionWorkspaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataMigrationService.addResponse(resultOperation);

    ApplyConversionWorkspaceRequest request =
        ApplyConversionWorkspaceRequest.newBuilder()
            .setName(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setFilter("filter-1274492040")
            .setDryRun(true)
            .setAutoCommit(true)
            .build();

    ConversionWorkspace actualResponse = client.applyConversionWorkspaceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApplyConversionWorkspaceRequest actualRequest =
        ((ApplyConversionWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getDryRun(), actualRequest.getDryRun());
    Assert.assertEquals(request.getAutoCommit(), actualRequest.getAutoCommit());
    Assert.assertEquals(request.getConnectionProfile(), actualRequest.getConnectionProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void applyConversionWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      ApplyConversionWorkspaceRequest request =
          ApplyConversionWorkspaceRequest.newBuilder()
              .setName(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setDryRun(true)
              .setAutoCommit(true)
              .build();
      client.applyConversionWorkspaceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void describeDatabaseEntitiesTest() throws Exception {
    DatabaseEntity responsesElement = DatabaseEntity.newBuilder().build();
    DescribeDatabaseEntitiesResponse expectedResponse =
        DescribeDatabaseEntitiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabaseEntities(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    DescribeDatabaseEntitiesRequest request =
        DescribeDatabaseEntitiesRequest.newBuilder()
            .setConversionWorkspace(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setUncommitted(true)
            .setCommitId("commitId-602292046")
            .setFilter("filter-1274492040")
            .setView(DatabaseEntityView.forNumber(0))
            .build();

    DescribeDatabaseEntitiesPagedResponse pagedListResponse =
        client.describeDatabaseEntities(request);

    List<DatabaseEntity> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabaseEntitiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DescribeDatabaseEntitiesRequest actualRequest =
        ((DescribeDatabaseEntitiesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getConversionWorkspace(), actualRequest.getConversionWorkspace());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getTree(), actualRequest.getTree());
    Assert.assertEquals(request.getUncommitted(), actualRequest.getUncommitted());
    Assert.assertEquals(request.getCommitId(), actualRequest.getCommitId());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void describeDatabaseEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      DescribeDatabaseEntitiesRequest request =
          DescribeDatabaseEntitiesRequest.newBuilder()
              .setConversionWorkspace(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setUncommitted(true)
              .setCommitId("commitId-602292046")
              .setFilter("filter-1274492040")
              .setView(DatabaseEntityView.forNumber(0))
              .build();
      client.describeDatabaseEntities(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchBackgroundJobsTest() throws Exception {
    SearchBackgroundJobsResponse expectedResponse =
        SearchBackgroundJobsResponse.newBuilder()
            .addAllJobs(new ArrayList<BackgroundJobLogEntry>())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    SearchBackgroundJobsRequest request =
        SearchBackgroundJobsRequest.newBuilder()
            .setConversionWorkspace(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setReturnMostRecentPerJobType(true)
            .setMaxSize(408072700)
            .setCompletedUntilTime(Timestamp.newBuilder().build())
            .build();

    SearchBackgroundJobsResponse actualResponse = client.searchBackgroundJobs(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchBackgroundJobsRequest actualRequest =
        ((SearchBackgroundJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getConversionWorkspace(), actualRequest.getConversionWorkspace());
    Assert.assertEquals(
        request.getReturnMostRecentPerJobType(), actualRequest.getReturnMostRecentPerJobType());
    Assert.assertEquals(request.getMaxSize(), actualRequest.getMaxSize());
    Assert.assertEquals(request.getCompletedUntilTime(), actualRequest.getCompletedUntilTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchBackgroundJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      SearchBackgroundJobsRequest request =
          SearchBackgroundJobsRequest.newBuilder()
              .setConversionWorkspace(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setReturnMostRecentPerJobType(true)
              .setMaxSize(408072700)
              .setCompletedUntilTime(Timestamp.newBuilder().build())
              .build();
      client.searchBackgroundJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void describeConversionWorkspaceRevisionsTest() throws Exception {
    DescribeConversionWorkspaceRevisionsResponse expectedResponse =
        DescribeConversionWorkspaceRevisionsResponse.newBuilder()
            .addAllRevisions(new ArrayList<ConversionWorkspace>())
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    DescribeConversionWorkspaceRevisionsRequest request =
        DescribeConversionWorkspaceRevisionsRequest.newBuilder()
            .setConversionWorkspace(
                ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                    .toString())
            .setCommitId("commitId-602292046")
            .build();

    DescribeConversionWorkspaceRevisionsResponse actualResponse =
        client.describeConversionWorkspaceRevisions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DescribeConversionWorkspaceRevisionsRequest actualRequest =
        ((DescribeConversionWorkspaceRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getConversionWorkspace(), actualRequest.getConversionWorkspace());
    Assert.assertEquals(request.getCommitId(), actualRequest.getCommitId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void describeConversionWorkspaceRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      DescribeConversionWorkspaceRevisionsRequest request =
          DescribeConversionWorkspaceRevisionsRequest.newBuilder()
              .setConversionWorkspace(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setCommitId("commitId-602292046")
              .build();
      client.describeConversionWorkspaceRevisions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchStaticIpsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchStaticIpsResponse expectedResponse =
        FetchStaticIpsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStaticIps(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchStaticIpsPagedResponse pagedListResponse = client.fetchStaticIps(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStaticIpsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchStaticIpsRequest actualRequest = ((FetchStaticIpsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchStaticIpsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
      client.fetchStaticIps(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchStaticIpsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchStaticIpsResponse expectedResponse =
        FetchStaticIpsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStaticIps(Arrays.asList(responsesElement))
            .build();
    mockDataMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    FetchStaticIpsPagedResponse pagedListResponse = client.fetchStaticIps(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStaticIpsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchStaticIpsRequest actualRequest = ((FetchStaticIpsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchStaticIpsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.fetchStaticIps(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
