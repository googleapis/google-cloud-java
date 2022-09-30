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

package com.google.storagetransfer.v1.proto;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

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
import java.util.Arrays;
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
public class StorageTransferServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockStorageTransferService mockStorageTransferService;
  private LocalChannelProvider channelProvider;
  private StorageTransferServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStorageTransferService = new MockStorageTransferService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockStorageTransferService));
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
    StorageTransferServiceSettings settings =
        StorageTransferServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageTransferServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getGoogleServiceAccountTest() throws Exception {
    TransferTypes.GoogleServiceAccount expectedResponse =
        TransferTypes.GoogleServiceAccount.newBuilder()
            .setAccountEmail("accountEmail1067197807")
            .setSubjectId("subjectId258589543")
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.GetGoogleServiceAccountRequest request =
        TransferProto.GetGoogleServiceAccountRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .build();

    TransferTypes.GoogleServiceAccount actualResponse = client.getGoogleServiceAccount(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.GetGoogleServiceAccountRequest actualRequest =
        ((TransferProto.GetGoogleServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGoogleServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.GetGoogleServiceAccountRequest request =
          TransferProto.GetGoogleServiceAccountRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .build();
      client.getGoogleServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.CreateTransferJobRequest request =
        TransferProto.CreateTransferJobRequest.newBuilder()
            .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
            .build();

    TransferTypes.TransferJob actualResponse = client.createTransferJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.CreateTransferJobRequest actualRequest =
        ((TransferProto.CreateTransferJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTransferJob(), actualRequest.getTransferJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransferJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.CreateTransferJobRequest request =
          TransferProto.CreateTransferJobRequest.newBuilder()
              .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
              .build();
      client.createTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.UpdateTransferJobRequest request =
        TransferProto.UpdateTransferJobRequest.newBuilder()
            .setJobName("jobName-1438096408")
            .setProjectId("projectId-894832108")
            .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
            .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
            .build();

    TransferTypes.TransferJob actualResponse = client.updateTransferJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.UpdateTransferJobRequest actualRequest =
        ((TransferProto.UpdateTransferJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getJobName(), actualRequest.getJobName());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getTransferJob(), actualRequest.getTransferJob());
    Assert.assertEquals(
        request.getUpdateTransferJobFieldMask(), actualRequest.getUpdateTransferJobFieldMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTransferJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.UpdateTransferJobRequest request =
          TransferProto.UpdateTransferJobRequest.newBuilder()
              .setJobName("jobName-1438096408")
              .setProjectId("projectId-894832108")
              .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
              .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
              .build();
      client.updateTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.GetTransferJobRequest request =
        TransferProto.GetTransferJobRequest.newBuilder()
            .setJobName("jobName-1438096408")
            .setProjectId("projectId-894832108")
            .build();

    TransferTypes.TransferJob actualResponse = client.getTransferJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.GetTransferJobRequest actualRequest =
        ((TransferProto.GetTransferJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getJobName(), actualRequest.getJobName());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransferJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.GetTransferJobRequest request =
          TransferProto.GetTransferJobRequest.newBuilder()
              .setJobName("jobName-1438096408")
              .setProjectId("projectId-894832108")
              .build();
      client.getTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferJobsTest() throws Exception {
    TransferTypes.TransferJob responsesElement = TransferTypes.TransferJob.newBuilder().build();
    TransferProto.ListTransferJobsResponse expectedResponse =
        TransferProto.ListTransferJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferJobs(Arrays.asList(responsesElement))
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.ListTransferJobsRequest request =
        TransferProto.ListTransferJobsRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListTransferJobsPagedResponse pagedListResponse = client.listTransferJobs(request);

    List<TransferTypes.TransferJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.ListTransferJobsRequest actualRequest =
        ((TransferProto.ListTransferJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.ListTransferJobsRequest request =
          TransferProto.ListTransferJobsRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listTransferJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseTransferOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.PauseTransferOperationRequest request =
        TransferProto.PauseTransferOperationRequest.newBuilder().setName("name3373707").build();

    client.pauseTransferOperation(request);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.PauseTransferOperationRequest actualRequest =
        ((TransferProto.PauseTransferOperationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseTransferOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.PauseTransferOperationRequest request =
          TransferProto.PauseTransferOperationRequest.newBuilder().setName("name3373707").build();
      client.pauseTransferOperation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeTransferOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.ResumeTransferOperationRequest request =
        TransferProto.ResumeTransferOperationRequest.newBuilder().setName("name3373707").build();

    client.resumeTransferOperation(request);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.ResumeTransferOperationRequest actualRequest =
        ((TransferProto.ResumeTransferOperationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeTransferOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.ResumeTransferOperationRequest request =
          TransferProto.ResumeTransferOperationRequest.newBuilder().setName("name3373707").build();
      client.resumeTransferOperation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runTransferJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runTransferJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageTransferService.addResponse(resultOperation);

    TransferProto.RunTransferJobRequest request =
        TransferProto.RunTransferJobRequest.newBuilder()
            .setJobName("jobName-1438096408")
            .setProjectId("projectId-894832108")
            .build();

    client.runTransferJobAsync(request).get();

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.RunTransferJobRequest actualRequest =
        ((TransferProto.RunTransferJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getJobName(), actualRequest.getJobName());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runTransferJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.RunTransferJobRequest request =
          TransferProto.RunTransferJobRequest.newBuilder()
              .setJobName("jobName-1438096408")
              .setProjectId("projectId-894832108")
              .build();
      client.runTransferJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTransferJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferProto.DeleteTransferJobRequest request =
        TransferProto.DeleteTransferJobRequest.newBuilder()
            .setJobName("jobName-1438096408")
            .setProjectId("projectId-894832108")
            .build();

    client.deleteTransferJob(request);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.DeleteTransferJobRequest actualRequest =
        ((TransferProto.DeleteTransferJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getJobName(), actualRequest.getJobName());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransferJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferProto.DeleteTransferJobRequest request =
          TransferProto.DeleteTransferJobRequest.newBuilder()
              .setJobName("jobName-1438096408")
              .setProjectId("projectId-894832108")
              .build();
      client.deleteTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
    String agentPoolId = "agentPoolId1562124732";

    TransferTypes.AgentPool actualResponse =
        client.createAgentPool(projectId, agentPool, agentPoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.CreateAgentPoolRequest actualRequest =
        ((TransferProto.CreateAgentPoolRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(agentPool, actualRequest.getAgentPool());
    Assert.assertEquals(agentPoolId, actualRequest.getAgentPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      String projectId = "projectId-894832108";
      TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
      String agentPoolId = "agentPoolId1562124732";
      client.createAgentPool(projectId, agentPool, agentPoolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransferTypes.AgentPool actualResponse = client.updateAgentPool(agentPool, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.UpdateAgentPoolRequest actualRequest =
        ((TransferProto.UpdateAgentPoolRequest) actualRequests.get(0));

    Assert.assertEquals(agentPool, actualRequest.getAgentPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAgentPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAgentPool(agentPool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    TransferTypes.AgentPool actualResponse = client.getAgentPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.GetAgentPoolRequest actualRequest =
        ((TransferProto.GetAgentPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getAgentPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAgentPoolsTest() throws Exception {
    TransferTypes.AgentPool responsesElement = TransferTypes.AgentPool.newBuilder().build();
    TransferProto.ListAgentPoolsResponse expectedResponse =
        TransferProto.ListAgentPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentPools(Arrays.asList(responsesElement))
            .build();
    mockStorageTransferService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";

    ListAgentPoolsPagedResponse pagedListResponse = client.listAgentPools(projectId);

    List<TransferTypes.AgentPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.ListAgentPoolsRequest actualRequest =
        ((TransferProto.ListAgentPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      String projectId = "projectId-894832108";
      client.listAgentPools(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAgentPool(name);

    List<AbstractMessage> actualRequests = mockStorageTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferProto.DeleteAgentPoolRequest actualRequest =
        ((TransferProto.DeleteAgentPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAgentPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
