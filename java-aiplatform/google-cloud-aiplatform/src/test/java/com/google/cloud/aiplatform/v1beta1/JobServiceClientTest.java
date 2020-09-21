/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class JobServiceClientTest {
  private static MockDatasetService mockDatasetService;
  private static MockEndpointService mockEndpointService;
  private static MockJobService mockJobService;
  private static MockModelService mockModelService;
  private static MockPipelineService mockPipelineService;
  private static MockPredictionService mockPredictionService;
  private static MockSpecialistPoolService mockSpecialistPoolService;
  private static MockServiceHelper serviceHelper;
  private JobServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDatasetService = new MockDatasetService();
    mockEndpointService = new MockEndpointService();
    mockJobService = new MockJobService();
    mockModelService = new MockModelService();
    mockPipelineService = new MockPipelineService();
    mockPredictionService = new MockPredictionService();
    mockSpecialistPoolService = new MockSpecialistPoolService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockDatasetService,
                mockEndpointService,
                mockJobService,
                mockModelService,
                mockPipelineService,
                mockPredictionService,
                mockSpecialistPoolService));
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
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createCustomJobTest() {
    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");
    String displayName = "displayName1615086568";
    CustomJob expectedResponse =
        CustomJob.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomJob customJob = CustomJob.newBuilder().build();

    CustomJob actualResponse = client.createCustomJob(parent, customJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomJobRequest actualRequest = (CreateCustomJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(customJob, actualRequest.getCustomJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomJob customJob = CustomJob.newBuilder().build();

      client.createCustomJob(parent, customJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCustomJobTest() {
    CustomJobName name2 = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");
    String displayName = "displayName1615086568";
    CustomJob expectedResponse =
        CustomJob.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockJobService.addResponse(expectedResponse);

    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

    CustomJob actualResponse = client.getCustomJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomJobRequest actualRequest = (GetCustomJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, CustomJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

      client.getCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCustomJobsTest() {
    String nextPageToken = "";
    CustomJob customJobsElement = CustomJob.newBuilder().build();
    List<CustomJob> customJobs = Arrays.asList(customJobsElement);
    ListCustomJobsResponse expectedResponse =
        ListCustomJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCustomJobs(customJobs)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomJobsPagedResponse pagedListResponse = client.listCustomJobs(parent);

    List<CustomJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomJobsRequest actualRequest = (ListCustomJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCustomJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listCustomJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCustomJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

    Empty actualResponse = client.deleteCustomJobAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomJobRequest actualRequest = (DeleteCustomJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, CustomJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

      client.deleteCustomJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelCustomJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

    client.cancelCustomJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelCustomJobRequest actualRequest = (CancelCustomJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, CustomJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

      client.cancelCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDataLabelingJobTest() {
    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");
    String displayName = "displayName1615086568";
    int labelerCount = 1457777167;
    String instructionUri = "instructionUri1537272379";
    String inputsSchemaUri = "inputsSchemaUri990382564";
    int labelingProgress = 685978914;
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setLabelerCount(labelerCount)
            .setInstructionUri(instructionUri)
            .setInputsSchemaUri(inputsSchemaUri)
            .setLabelingProgress(labelingProgress)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();

    DataLabelingJob actualResponse = client.createDataLabelingJob(parent, dataLabelingJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataLabelingJobRequest actualRequest =
        (CreateDataLabelingJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(dataLabelingJob, actualRequest.getDataLabelingJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();

      client.createDataLabelingJob(parent, dataLabelingJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDataLabelingJobTest() {
    DataLabelingJobName name2 =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");
    String displayName = "displayName1615086568";
    int labelerCount = 1457777167;
    String instructionUri = "instructionUri1537272379";
    String inputsSchemaUri = "inputsSchemaUri990382564";
    int labelingProgress = 685978914;
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setLabelerCount(labelerCount)
            .setInstructionUri(instructionUri)
            .setInputsSchemaUri(inputsSchemaUri)
            .setLabelingProgress(labelingProgress)
            .build();
    mockJobService.addResponse(expectedResponse);

    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

    DataLabelingJob actualResponse = client.getDataLabelingJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataLabelingJobRequest actualRequest = (GetDataLabelingJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataLabelingJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

      client.getDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDataLabelingJobsTest() {
    String nextPageToken = "";
    DataLabelingJob dataLabelingJobsElement = DataLabelingJob.newBuilder().build();
    List<DataLabelingJob> dataLabelingJobs = Arrays.asList(dataLabelingJobsElement);
    ListDataLabelingJobsResponse expectedResponse =
        ListDataLabelingJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDataLabelingJobs(dataLabelingJobs)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataLabelingJobsPagedResponse pagedListResponse = client.listDataLabelingJobs(parent);

    List<DataLabelingJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataLabelingJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataLabelingJobsRequest actualRequest = (ListDataLabelingJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDataLabelingJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listDataLabelingJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDataLabelingJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataLabelingJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

    Empty actualResponse = client.deleteDataLabelingJobAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataLabelingJobRequest actualRequest =
        (DeleteDataLabelingJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataLabelingJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

      client.deleteDataLabelingJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelDataLabelingJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

    client.cancelDataLabelingJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelDataLabelingJobRequest actualRequest =
        (CancelDataLabelingJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataLabelingJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

      client.cancelDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createHyperparameterTuningJobTest() {
    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");
    String displayName = "displayName1615086568";
    int maxTrialCount = 445994933;
    int parallelTrialCount = 1813795950;
    int maxFailedTrialCount = 887662497;
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setMaxTrialCount(maxTrialCount)
            .setParallelTrialCount(parallelTrialCount)
            .setMaxFailedTrialCount(maxFailedTrialCount)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    HyperparameterTuningJob hyperparameterTuningJob = HyperparameterTuningJob.newBuilder().build();

    HyperparameterTuningJob actualResponse =
        client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHyperparameterTuningJobRequest actualRequest =
        (CreateHyperparameterTuningJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(hyperparameterTuningJob, actualRequest.getHyperparameterTuningJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      HyperparameterTuningJob hyperparameterTuningJob =
          HyperparameterTuningJob.newBuilder().build();

      client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getHyperparameterTuningJobTest() {
    HyperparameterTuningJobName name2 =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");
    String displayName = "displayName1615086568";
    int maxTrialCount = 445994933;
    int parallelTrialCount = 1813795950;
    int maxFailedTrialCount = 887662497;
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setMaxTrialCount(maxTrialCount)
            .setParallelTrialCount(parallelTrialCount)
            .setMaxFailedTrialCount(maxFailedTrialCount)
            .build();
    mockJobService.addResponse(expectedResponse);

    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

    HyperparameterTuningJob actualResponse = client.getHyperparameterTuningJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHyperparameterTuningJobRequest actualRequest =
        (GetHyperparameterTuningJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, HyperparameterTuningJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

      client.getHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listHyperparameterTuningJobsTest() {
    String nextPageToken = "";
    HyperparameterTuningJob hyperparameterTuningJobsElement =
        HyperparameterTuningJob.newBuilder().build();
    List<HyperparameterTuningJob> hyperparameterTuningJobs =
        Arrays.asList(hyperparameterTuningJobsElement);
    ListHyperparameterTuningJobsResponse expectedResponse =
        ListHyperparameterTuningJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllHyperparameterTuningJobs(hyperparameterTuningJobs)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHyperparameterTuningJobsPagedResponse pagedListResponse =
        client.listHyperparameterTuningJobs(parent);

    List<HyperparameterTuningJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getHyperparameterTuningJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHyperparameterTuningJobsRequest actualRequest =
        (ListHyperparameterTuningJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listHyperparameterTuningJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listHyperparameterTuningJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteHyperparameterTuningJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHyperparameterTuningJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

    Empty actualResponse = client.deleteHyperparameterTuningJobAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHyperparameterTuningJobRequest actualRequest =
        (DeleteHyperparameterTuningJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, HyperparameterTuningJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

      client.deleteHyperparameterTuningJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelHyperparameterTuningJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

    client.cancelHyperparameterTuningJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelHyperparameterTuningJobRequest actualRequest =
        (CancelHyperparameterTuningJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, HyperparameterTuningJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

      client.cancelHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createBatchPredictionJobTest() {
    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");
    String displayName = "displayName1615086568";
    ModelName model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    boolean generateExplanation = false;
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setModel(model.toString())
            .setGenerateExplanation(generateExplanation)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();

    BatchPredictionJob actualResponse = client.createBatchPredictionJob(parent, batchPredictionJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBatchPredictionJobRequest actualRequest =
        (CreateBatchPredictionJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(batchPredictionJob, actualRequest.getBatchPredictionJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();

      client.createBatchPredictionJob(parent, batchPredictionJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBatchPredictionJobTest() {
    BatchPredictionJobName name2 =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");
    String displayName = "displayName1615086568";
    ModelName model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    boolean generateExplanation = false;
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setModel(model.toString())
            .setGenerateExplanation(generateExplanation)
            .build();
    mockJobService.addResponse(expectedResponse);

    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

    BatchPredictionJob actualResponse = client.getBatchPredictionJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBatchPredictionJobRequest actualRequest =
        (GetBatchPredictionJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, BatchPredictionJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

      client.getBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBatchPredictionJobsTest() {
    String nextPageToken = "";
    BatchPredictionJob batchPredictionJobsElement = BatchPredictionJob.newBuilder().build();
    List<BatchPredictionJob> batchPredictionJobs = Arrays.asList(batchPredictionJobsElement);
    ListBatchPredictionJobsResponse expectedResponse =
        ListBatchPredictionJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllBatchPredictionJobs(batchPredictionJobs)
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBatchPredictionJobsPagedResponse pagedListResponse = client.listBatchPredictionJobs(parent);

    List<BatchPredictionJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBatchPredictionJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBatchPredictionJobsRequest actualRequest =
        (ListBatchPredictionJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBatchPredictionJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listBatchPredictionJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBatchPredictionJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBatchPredictionJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

    Empty actualResponse = client.deleteBatchPredictionJobAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBatchPredictionJobRequest actualRequest =
        (DeleteBatchPredictionJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, BatchPredictionJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

      client.deleteBatchPredictionJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelBatchPredictionJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

    client.cancelBatchPredictionJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelBatchPredictionJobRequest actualRequest =
        (CancelBatchPredictionJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, BatchPredictionJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

      client.cancelBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
