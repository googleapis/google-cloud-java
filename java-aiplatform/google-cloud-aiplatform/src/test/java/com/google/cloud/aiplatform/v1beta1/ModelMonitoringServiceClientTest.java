/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringAlertsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringStatsPagedResponse;

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
public class ModelMonitoringServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockModelMonitoringService mockModelMonitoringService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ModelMonitoringServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockModelMonitoringService = new MockModelMonitoringService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockModelMonitoringService, mockLocations, mockIAMPolicy));
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
    ModelMonitoringServiceSettings settings =
        ModelMonitoringServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelMonitoringServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createModelMonitorTest() throws Exception {
    ModelMonitor expectedResponse =
        ModelMonitor.newBuilder()
            .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringTarget(ModelMonitor.ModelMonitoringTarget.newBuilder().build())
            .setTrainingDataset(ModelMonitoringInput.newBuilder().build())
            .setNotificationSpec(ModelMonitoringNotificationSpec.newBuilder().build())
            .setOutputSpec(ModelMonitoringOutputSpec.newBuilder().build())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setModelMonitoringSchema(ModelMonitoringSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelMonitorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();

    ModelMonitor actualResponse = client.createModelMonitorAsync(parent, modelMonitor).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelMonitorRequest actualRequest = ((CreateModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(modelMonitor, actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelMonitorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
      client.createModelMonitorAsync(parent, modelMonitor).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createModelMonitorTest2() throws Exception {
    ModelMonitor expectedResponse =
        ModelMonitor.newBuilder()
            .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringTarget(ModelMonitor.ModelMonitoringTarget.newBuilder().build())
            .setTrainingDataset(ModelMonitoringInput.newBuilder().build())
            .setNotificationSpec(ModelMonitoringNotificationSpec.newBuilder().build())
            .setOutputSpec(ModelMonitoringOutputSpec.newBuilder().build())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setModelMonitoringSchema(ModelMonitoringSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelMonitorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();

    ModelMonitor actualResponse = client.createModelMonitorAsync(parent, modelMonitor).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelMonitorRequest actualRequest = ((CreateModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(modelMonitor, actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelMonitorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
      client.createModelMonitorAsync(parent, modelMonitor).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateModelMonitorTest() throws Exception {
    ModelMonitor expectedResponse =
        ModelMonitor.newBuilder()
            .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringTarget(ModelMonitor.ModelMonitoringTarget.newBuilder().build())
            .setTrainingDataset(ModelMonitoringInput.newBuilder().build())
            .setNotificationSpec(ModelMonitoringNotificationSpec.newBuilder().build())
            .setOutputSpec(ModelMonitoringOutputSpec.newBuilder().build())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setModelMonitoringSchema(ModelMonitoringSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateModelMonitorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ModelMonitor actualResponse = client.updateModelMonitorAsync(modelMonitor, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateModelMonitorRequest actualRequest = ((UpdateModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(modelMonitor, actualRequest.getModelMonitor());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateModelMonitorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateModelMonitorAsync(modelMonitor, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getModelMonitorTest() throws Exception {
    ModelMonitor expectedResponse =
        ModelMonitor.newBuilder()
            .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringTarget(ModelMonitor.ModelMonitoringTarget.newBuilder().build())
            .setTrainingDataset(ModelMonitoringInput.newBuilder().build())
            .setNotificationSpec(ModelMonitoringNotificationSpec.newBuilder().build())
            .setOutputSpec(ModelMonitoringOutputSpec.newBuilder().build())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setModelMonitoringSchema(ModelMonitoringSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");

    ModelMonitor actualResponse = client.getModelMonitor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelMonitorRequest actualRequest = ((GetModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelMonitorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      client.getModelMonitor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelMonitorTest2() throws Exception {
    ModelMonitor expectedResponse =
        ModelMonitor.newBuilder()
            .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringTarget(ModelMonitor.ModelMonitoringTarget.newBuilder().build())
            .setTrainingDataset(ModelMonitoringInput.newBuilder().build())
            .setNotificationSpec(ModelMonitoringNotificationSpec.newBuilder().build())
            .setOutputSpec(ModelMonitoringOutputSpec.newBuilder().build())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setModelMonitoringSchema(ModelMonitoringSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    ModelMonitor actualResponse = client.getModelMonitor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelMonitorRequest actualRequest = ((GetModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelMonitorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.getModelMonitor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelMonitorsTest() throws Exception {
    ModelMonitor responsesElement = ModelMonitor.newBuilder().build();
    ListModelMonitorsResponse expectedResponse =
        ListModelMonitorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitors(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListModelMonitorsPagedResponse pagedListResponse = client.listModelMonitors(parent);

    List<ModelMonitor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelMonitorsRequest actualRequest = ((ListModelMonitorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelMonitorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listModelMonitors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelMonitorsTest2() throws Exception {
    ModelMonitor responsesElement = ModelMonitor.newBuilder().build();
    ListModelMonitorsResponse expectedResponse =
        ListModelMonitorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitors(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelMonitorsPagedResponse pagedListResponse = client.listModelMonitors(parent);

    List<ModelMonitor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelMonitorsRequest actualRequest = ((ListModelMonitorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelMonitorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModelMonitors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteModelMonitorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelMonitorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");

    client.deleteModelMonitorAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelMonitorRequest actualRequest = ((DeleteModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelMonitorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      client.deleteModelMonitorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelMonitorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelMonitorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelMonitorAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelMonitorRequest actualRequest = ((DeleteModelMonitorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelMonitorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelMonitorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createModelMonitoringJobTest() throws Exception {
    ModelMonitoringJob expectedResponse =
        ModelMonitoringJob.newBuilder()
            .setName(
                ModelMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringSpec(ModelMonitoringSpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setSchedule(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setJobExecutionDetail(ModelMonitoringJobExecutionDetail.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
    ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();

    ModelMonitoringJob actualResponse = client.createModelMonitoringJob(parent, modelMonitoringJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelMonitoringJobRequest actualRequest =
        ((CreateModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(modelMonitoringJob, actualRequest.getModelMonitoringJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();
      client.createModelMonitoringJob(parent, modelMonitoringJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelMonitoringJobTest2() throws Exception {
    ModelMonitoringJob expectedResponse =
        ModelMonitoringJob.newBuilder()
            .setName(
                ModelMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringSpec(ModelMonitoringSpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setSchedule(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setJobExecutionDetail(ModelMonitoringJobExecutionDetail.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();

    ModelMonitoringJob actualResponse = client.createModelMonitoringJob(parent, modelMonitoringJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelMonitoringJobRequest actualRequest =
        ((CreateModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(modelMonitoringJob, actualRequest.getModelMonitoringJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();
      client.createModelMonitoringJob(parent, modelMonitoringJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelMonitoringJobTest() throws Exception {
    ModelMonitoringJob expectedResponse =
        ModelMonitoringJob.newBuilder()
            .setName(
                ModelMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringSpec(ModelMonitoringSpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setSchedule(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setJobExecutionDetail(ModelMonitoringJobExecutionDetail.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitoringJobName name =
        ModelMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");

    ModelMonitoringJob actualResponse = client.getModelMonitoringJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelMonitoringJobRequest actualRequest =
        ((GetModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitoringJobName name =
          ModelMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");
      client.getModelMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelMonitoringJobTest2() throws Exception {
    ModelMonitoringJob expectedResponse =
        ModelMonitoringJob.newBuilder()
            .setName(
                ModelMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelMonitoringSpec(ModelMonitoringSpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setSchedule(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
            .setJobExecutionDetail(ModelMonitoringJobExecutionDetail.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    ModelMonitoringJob actualResponse = client.getModelMonitoringJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelMonitoringJobRequest actualRequest =
        ((GetModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.getModelMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelMonitoringJobsTest() throws Exception {
    ModelMonitoringJob responsesElement = ModelMonitoringJob.newBuilder().build();
    ListModelMonitoringJobsResponse expectedResponse =
        ListModelMonitoringJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitoringJobs(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");

    ListModelMonitoringJobsPagedResponse pagedListResponse = client.listModelMonitoringJobs(parent);

    List<ModelMonitoringJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitoringJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelMonitoringJobsRequest actualRequest =
        ((ListModelMonitoringJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelMonitoringJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      client.listModelMonitoringJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelMonitoringJobsTest2() throws Exception {
    ModelMonitoringJob responsesElement = ModelMonitoringJob.newBuilder().build();
    ListModelMonitoringJobsResponse expectedResponse =
        ListModelMonitoringJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitoringJobs(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelMonitoringJobsPagedResponse pagedListResponse = client.listModelMonitoringJobs(parent);

    List<ModelMonitoringJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitoringJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelMonitoringJobsRequest actualRequest =
        ((ListModelMonitoringJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelMonitoringJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModelMonitoringJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteModelMonitoringJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelMonitoringJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    ModelMonitoringJobName name =
        ModelMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");

    client.deleteModelMonitoringJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelMonitoringJobRequest actualRequest =
        ((DeleteModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitoringJobName name =
          ModelMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");
      client.deleteModelMonitoringJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelMonitoringJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelMonitoringJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelMonitoringService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelMonitoringJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelMonitoringJobRequest actualRequest =
        ((DeleteModelMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelMonitoringJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void searchModelMonitoringStatsTest() throws Exception {
    ModelMonitoringStats responsesElement = ModelMonitoringStats.newBuilder().build();
    SearchModelMonitoringStatsResponse expectedResponse =
        SearchModelMonitoringStatsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoringStats(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitorName modelMonitor =
        ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");

    SearchModelMonitoringStatsPagedResponse pagedListResponse =
        client.searchModelMonitoringStats(modelMonitor);

    List<ModelMonitoringStats> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoringStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelMonitoringStatsRequest actualRequest =
        ((SearchModelMonitoringStatsRequest) actualRequests.get(0));

    Assert.assertEquals(modelMonitor.toString(), actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelMonitoringStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName modelMonitor =
          ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      client.searchModelMonitoringStats(modelMonitor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchModelMonitoringStatsTest2() throws Exception {
    ModelMonitoringStats responsesElement = ModelMonitoringStats.newBuilder().build();
    SearchModelMonitoringStatsResponse expectedResponse =
        SearchModelMonitoringStatsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoringStats(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String modelMonitor = "modelMonitor1097148913";

    SearchModelMonitoringStatsPagedResponse pagedListResponse =
        client.searchModelMonitoringStats(modelMonitor);

    List<ModelMonitoringStats> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoringStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelMonitoringStatsRequest actualRequest =
        ((SearchModelMonitoringStatsRequest) actualRequests.get(0));

    Assert.assertEquals(modelMonitor, actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelMonitoringStatsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String modelMonitor = "modelMonitor1097148913";
      client.searchModelMonitoringStats(modelMonitor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchModelMonitoringAlertsTest() throws Exception {
    ModelMonitoringAlert responsesElement = ModelMonitoringAlert.newBuilder().build();
    SearchModelMonitoringAlertsResponse expectedResponse =
        SearchModelMonitoringAlertsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitoringAlerts(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    ModelMonitorName modelMonitor =
        ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");

    SearchModelMonitoringAlertsPagedResponse pagedListResponse =
        client.searchModelMonitoringAlerts(modelMonitor);

    List<ModelMonitoringAlert> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitoringAlertsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelMonitoringAlertsRequest actualRequest =
        ((SearchModelMonitoringAlertsRequest) actualRequests.get(0));

    Assert.assertEquals(modelMonitor.toString(), actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelMonitoringAlertsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      ModelMonitorName modelMonitor =
          ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
      client.searchModelMonitoringAlerts(modelMonitor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchModelMonitoringAlertsTest2() throws Exception {
    ModelMonitoringAlert responsesElement = ModelMonitoringAlert.newBuilder().build();
    SearchModelMonitoringAlertsResponse expectedResponse =
        SearchModelMonitoringAlertsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelMonitoringAlerts(Arrays.asList(responsesElement))
            .build();
    mockModelMonitoringService.addResponse(expectedResponse);

    String modelMonitor = "modelMonitor1097148913";

    SearchModelMonitoringAlertsPagedResponse pagedListResponse =
        client.searchModelMonitoringAlerts(modelMonitor);

    List<ModelMonitoringAlert> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelMonitoringAlertsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelMonitoringAlertsRequest actualRequest =
        ((SearchModelMonitoringAlertsRequest) actualRequests.get(0));

    Assert.assertEquals(modelMonitor, actualRequest.getModelMonitor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelMonitoringAlertsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelMonitoringService.addException(exception);

    try {
      String modelMonitor = "modelMonitor1097148913";
      client.searchModelMonitoringAlerts(modelMonitor);
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
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
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
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
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
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
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
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
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
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
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
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
