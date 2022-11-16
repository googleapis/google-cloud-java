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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListModelDeploymentMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse;

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
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.google.rpc.Status;
import com.google.type.Money;
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
public class JobServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockJobService mockJobService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private JobServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockJobService = new MockJobService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockJobService, mockLocations, mockIAMPolicy));
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
  public void createCustomJobTest() throws Exception {
    CustomJob expectedResponse =
        CustomJob.newBuilder()
            .setName(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setJobSpec(CustomJobSpec.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomJob customJob = CustomJob.newBuilder().build();

    CustomJob actualResponse = client.createCustomJob(parent, customJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomJobRequest actualRequest = ((CreateCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customJob, actualRequest.getCustomJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomJob customJob = CustomJob.newBuilder().build();
      client.createCustomJob(parent, customJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomJobTest2() throws Exception {
    CustomJob expectedResponse =
        CustomJob.newBuilder()
            .setName(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setJobSpec(CustomJobSpec.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomJob customJob = CustomJob.newBuilder().build();

    CustomJob actualResponse = client.createCustomJob(parent, customJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomJobRequest actualRequest = ((CreateCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customJob, actualRequest.getCustomJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomJob customJob = CustomJob.newBuilder().build();
      client.createCustomJob(parent, customJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomJobTest() throws Exception {
    CustomJob expectedResponse =
        CustomJob.newBuilder()
            .setName(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setJobSpec(CustomJobSpec.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockJobService.addResponse(expectedResponse);

    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

    CustomJob actualResponse = client.getCustomJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomJobRequest actualRequest = ((GetCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");
      client.getCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomJobTest2() throws Exception {
    CustomJob expectedResponse =
        CustomJob.newBuilder()
            .setName(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setJobSpec(CustomJobSpec.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    CustomJob actualResponse = client.getCustomJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomJobRequest actualRequest = ((GetCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomJobsTest() throws Exception {
    CustomJob responsesElement = CustomJob.newBuilder().build();
    ListCustomJobsResponse expectedResponse =
        ListCustomJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomJobsPagedResponse pagedListResponse = client.listCustomJobs(parent);

    List<CustomJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomJobsRequest actualRequest = ((ListCustomJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCustomJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomJobsTest2() throws Exception {
    CustomJob responsesElement = CustomJob.newBuilder().build();
    ListCustomJobsResponse expectedResponse =
        ListCustomJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomJobsPagedResponse pagedListResponse = client.listCustomJobs(parent);

    List<CustomJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomJobsRequest actualRequest = ((ListCustomJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
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

    client.deleteCustomJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomJobRequest actualRequest = ((DeleteCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");
      client.deleteCustomJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCustomJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCustomJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomJobRequest actualRequest = ((DeleteCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelCustomJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");

    client.cancelCustomJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelCustomJobRequest actualRequest = ((CancelCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelCustomJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      CustomJobName name = CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]");
      client.cancelCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelCustomJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelCustomJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelCustomJobRequest actualRequest = ((CancelCustomJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelCustomJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelCustomJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataLabelingJobTest() throws Exception {
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(
                DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .addAllDatasets(new ArrayList<String>())
            .putAllAnnotationLabels(new HashMap<String, String>())
            .setLabelerCount(-1457777167)
            .setInstructionUri("instructionUri1989242366")
            .setInputsSchemaUri("inputsSchemaUri1757461538")
            .setInputs(Value.newBuilder().setBoolValue(true).build())
            .setState(JobState.forNumber(0))
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setActiveLearningConfig(ActiveLearningConfig.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();

    DataLabelingJob actualResponse = client.createDataLabelingJob(parent, dataLabelingJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataLabelingJobRequest actualRequest =
        ((CreateDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataLabelingJob, actualRequest.getDataLabelingJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();
      client.createDataLabelingJob(parent, dataLabelingJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataLabelingJobTest2() throws Exception {
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(
                DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .addAllDatasets(new ArrayList<String>())
            .putAllAnnotationLabels(new HashMap<String, String>())
            .setLabelerCount(-1457777167)
            .setInstructionUri("instructionUri1989242366")
            .setInputsSchemaUri("inputsSchemaUri1757461538")
            .setInputs(Value.newBuilder().setBoolValue(true).build())
            .setState(JobState.forNumber(0))
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setActiveLearningConfig(ActiveLearningConfig.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();

    DataLabelingJob actualResponse = client.createDataLabelingJob(parent, dataLabelingJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataLabelingJobRequest actualRequest =
        ((CreateDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataLabelingJob, actualRequest.getDataLabelingJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataLabelingJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataLabelingJob dataLabelingJob = DataLabelingJob.newBuilder().build();
      client.createDataLabelingJob(parent, dataLabelingJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataLabelingJobTest() throws Exception {
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(
                DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .addAllDatasets(new ArrayList<String>())
            .putAllAnnotationLabels(new HashMap<String, String>())
            .setLabelerCount(-1457777167)
            .setInstructionUri("instructionUri1989242366")
            .setInputsSchemaUri("inputsSchemaUri1757461538")
            .setInputs(Value.newBuilder().setBoolValue(true).build())
            .setState(JobState.forNumber(0))
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setActiveLearningConfig(ActiveLearningConfig.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

    DataLabelingJob actualResponse = client.getDataLabelingJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataLabelingJobRequest actualRequest = ((GetDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");
      client.getDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataLabelingJobTest2() throws Exception {
    DataLabelingJob expectedResponse =
        DataLabelingJob.newBuilder()
            .setName(
                DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .addAllDatasets(new ArrayList<String>())
            .putAllAnnotationLabels(new HashMap<String, String>())
            .setLabelerCount(-1457777167)
            .setInstructionUri("instructionUri1989242366")
            .setInputsSchemaUri("inputsSchemaUri1757461538")
            .setInputs(Value.newBuilder().setBoolValue(true).build())
            .setState(JobState.forNumber(0))
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setActiveLearningConfig(ActiveLearningConfig.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    DataLabelingJob actualResponse = client.getDataLabelingJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataLabelingJobRequest actualRequest = ((GetDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataLabelingJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataLabelingJobsTest() throws Exception {
    DataLabelingJob responsesElement = DataLabelingJob.newBuilder().build();
    ListDataLabelingJobsResponse expectedResponse =
        ListDataLabelingJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataLabelingJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataLabelingJobsPagedResponse pagedListResponse = client.listDataLabelingJobs(parent);

    List<DataLabelingJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataLabelingJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataLabelingJobsRequest actualRequest =
        ((ListDataLabelingJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataLabelingJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataLabelingJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataLabelingJobsTest2() throws Exception {
    DataLabelingJob responsesElement = DataLabelingJob.newBuilder().build();
    ListDataLabelingJobsResponse expectedResponse =
        ListDataLabelingJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataLabelingJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataLabelingJobsPagedResponse pagedListResponse = client.listDataLabelingJobs(parent);

    List<DataLabelingJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataLabelingJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataLabelingJobsRequest actualRequest =
        ((ListDataLabelingJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataLabelingJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataLabelingJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
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

    client.deleteDataLabelingJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataLabelingJobRequest actualRequest =
        ((DeleteDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");
      client.deleteDataLabelingJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataLabelingJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataLabelingJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataLabelingJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataLabelingJobRequest actualRequest =
        ((DeleteDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataLabelingJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataLabelingJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelDataLabelingJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    DataLabelingJobName name =
        DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");

    client.cancelDataLabelingJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelDataLabelingJobRequest actualRequest =
        ((CancelDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelDataLabelingJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      DataLabelingJobName name =
          DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]");
      client.cancelDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelDataLabelingJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelDataLabelingJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelDataLabelingJobRequest actualRequest =
        ((CancelDataLabelingJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelDataLabelingJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelDataLabelingJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHyperparameterTuningJobTest() throws Exception {
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(
                HyperparameterTuningJobName.of(
                        "[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setMaxTrialCount(-445994933)
            .setParallelTrialCount(1813795950)
            .setMaxFailedTrialCount(-887662497)
            .setTrialJobSpec(CustomJobSpec.newBuilder().build())
            .addAllTrials(new ArrayList<Trial>())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
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
        ((CreateHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hyperparameterTuningJob, actualRequest.getHyperparameterTuningJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      HyperparameterTuningJob hyperparameterTuningJob =
          HyperparameterTuningJob.newBuilder().build();
      client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHyperparameterTuningJobTest2() throws Exception {
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(
                HyperparameterTuningJobName.of(
                        "[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setMaxTrialCount(-445994933)
            .setParallelTrialCount(1813795950)
            .setMaxFailedTrialCount(-887662497)
            .setTrialJobSpec(CustomJobSpec.newBuilder().build())
            .addAllTrials(new ArrayList<Trial>())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    HyperparameterTuningJob hyperparameterTuningJob = HyperparameterTuningJob.newBuilder().build();

    HyperparameterTuningJob actualResponse =
        client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHyperparameterTuningJobRequest actualRequest =
        ((CreateHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hyperparameterTuningJob, actualRequest.getHyperparameterTuningJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHyperparameterTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      HyperparameterTuningJob hyperparameterTuningJob =
          HyperparameterTuningJob.newBuilder().build();
      client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHyperparameterTuningJobTest() throws Exception {
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(
                HyperparameterTuningJobName.of(
                        "[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setMaxTrialCount(-445994933)
            .setParallelTrialCount(1813795950)
            .setMaxFailedTrialCount(-887662497)
            .setTrialJobSpec(CustomJobSpec.newBuilder().build())
            .addAllTrials(new ArrayList<Trial>())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

    HyperparameterTuningJob actualResponse = client.getHyperparameterTuningJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHyperparameterTuningJobRequest actualRequest =
        ((GetHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");
      client.getHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHyperparameterTuningJobTest2() throws Exception {
    HyperparameterTuningJob expectedResponse =
        HyperparameterTuningJob.newBuilder()
            .setName(
                HyperparameterTuningJobName.of(
                        "[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setMaxTrialCount(-445994933)
            .setParallelTrialCount(1813795950)
            .setMaxFailedTrialCount(-887662497)
            .setTrialJobSpec(CustomJobSpec.newBuilder().build())
            .addAllTrials(new ArrayList<Trial>())
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    HyperparameterTuningJob actualResponse = client.getHyperparameterTuningJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHyperparameterTuningJobRequest actualRequest =
        ((GetHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHyperparameterTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHyperparameterTuningJobsTest() throws Exception {
    HyperparameterTuningJob responsesElement = HyperparameterTuningJob.newBuilder().build();
    ListHyperparameterTuningJobsResponse expectedResponse =
        ListHyperparameterTuningJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHyperparameterTuningJobs(Arrays.asList(responsesElement))
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
        ((ListHyperparameterTuningJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHyperparameterTuningJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHyperparameterTuningJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHyperparameterTuningJobsTest2() throws Exception {
    HyperparameterTuningJob responsesElement = HyperparameterTuningJob.newBuilder().build();
    ListHyperparameterTuningJobsResponse expectedResponse =
        ListHyperparameterTuningJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHyperparameterTuningJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHyperparameterTuningJobsPagedResponse pagedListResponse =
        client.listHyperparameterTuningJobs(parent);

    List<HyperparameterTuningJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getHyperparameterTuningJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHyperparameterTuningJobsRequest actualRequest =
        ((ListHyperparameterTuningJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHyperparameterTuningJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHyperparameterTuningJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
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

    client.deleteHyperparameterTuningJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHyperparameterTuningJobRequest actualRequest =
        ((DeleteHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");
      client.deleteHyperparameterTuningJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHyperparameterTuningJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHyperparameterTuningJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHyperparameterTuningJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHyperparameterTuningJobRequest actualRequest =
        ((DeleteHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHyperparameterTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHyperparameterTuningJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelHyperparameterTuningJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    HyperparameterTuningJobName name =
        HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");

    client.cancelHyperparameterTuningJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelHyperparameterTuningJobRequest actualRequest =
        ((CancelHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelHyperparameterTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      HyperparameterTuningJobName name =
          HyperparameterTuningJobName.of("[PROJECT]", "[LOCATION]", "[HYPERPARAMETER_TUNING_JOB]");
      client.cancelHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelHyperparameterTuningJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelHyperparameterTuningJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelHyperparameterTuningJobRequest actualRequest =
        ((CancelHyperparameterTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelHyperparameterTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelHyperparameterTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBatchPredictionJobTest() throws Exception {
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(
                BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .setUnmanagedContainerModel(UnmanagedContainerModel.newBuilder().build())
            .setInputConfig(BatchPredictionJob.InputConfig.newBuilder().build())
            .setModelParameters(Value.newBuilder().setBoolValue(true).build())
            .setOutputConfig(BatchPredictionJob.OutputConfig.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setOutputInfo(BatchPredictionJob.OutputInfo.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();

    BatchPredictionJob actualResponse = client.createBatchPredictionJob(parent, batchPredictionJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBatchPredictionJobRequest actualRequest =
        ((CreateBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(batchPredictionJob, actualRequest.getBatchPredictionJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();
      client.createBatchPredictionJob(parent, batchPredictionJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBatchPredictionJobTest2() throws Exception {
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(
                BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .setUnmanagedContainerModel(UnmanagedContainerModel.newBuilder().build())
            .setInputConfig(BatchPredictionJob.InputConfig.newBuilder().build())
            .setModelParameters(Value.newBuilder().setBoolValue(true).build())
            .setOutputConfig(BatchPredictionJob.OutputConfig.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setOutputInfo(BatchPredictionJob.OutputInfo.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();

    BatchPredictionJob actualResponse = client.createBatchPredictionJob(parent, batchPredictionJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBatchPredictionJobRequest actualRequest =
        ((CreateBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(batchPredictionJob, actualRequest.getBatchPredictionJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBatchPredictionJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      BatchPredictionJob batchPredictionJob = BatchPredictionJob.newBuilder().build();
      client.createBatchPredictionJob(parent, batchPredictionJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBatchPredictionJobTest() throws Exception {
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(
                BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .setUnmanagedContainerModel(UnmanagedContainerModel.newBuilder().build())
            .setInputConfig(BatchPredictionJob.InputConfig.newBuilder().build())
            .setModelParameters(Value.newBuilder().setBoolValue(true).build())
            .setOutputConfig(BatchPredictionJob.OutputConfig.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setOutputInfo(BatchPredictionJob.OutputInfo.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

    BatchPredictionJob actualResponse = client.getBatchPredictionJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBatchPredictionJobRequest actualRequest =
        ((GetBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");
      client.getBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBatchPredictionJobTest2() throws Exception {
    BatchPredictionJob expectedResponse =
        BatchPredictionJob.newBuilder()
            .setName(
                BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .setUnmanagedContainerModel(UnmanagedContainerModel.newBuilder().build())
            .setInputConfig(BatchPredictionJob.InputConfig.newBuilder().build())
            .setModelParameters(Value.newBuilder().setBoolValue(true).build())
            .setOutputConfig(BatchPredictionJob.OutputConfig.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setOutputInfo(BatchPredictionJob.OutputInfo.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    BatchPredictionJob actualResponse = client.getBatchPredictionJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBatchPredictionJobRequest actualRequest =
        ((GetBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBatchPredictionJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBatchPredictionJobsTest() throws Exception {
    BatchPredictionJob responsesElement = BatchPredictionJob.newBuilder().build();
    ListBatchPredictionJobsResponse expectedResponse =
        ListBatchPredictionJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBatchPredictionJobs(Arrays.asList(responsesElement))
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
        ((ListBatchPredictionJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBatchPredictionJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBatchPredictionJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBatchPredictionJobsTest2() throws Exception {
    BatchPredictionJob responsesElement = BatchPredictionJob.newBuilder().build();
    ListBatchPredictionJobsResponse expectedResponse =
        ListBatchPredictionJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBatchPredictionJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBatchPredictionJobsPagedResponse pagedListResponse = client.listBatchPredictionJobs(parent);

    List<BatchPredictionJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBatchPredictionJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBatchPredictionJobsRequest actualRequest =
        ((ListBatchPredictionJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBatchPredictionJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBatchPredictionJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
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

    client.deleteBatchPredictionJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBatchPredictionJobRequest actualRequest =
        ((DeleteBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");
      client.deleteBatchPredictionJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBatchPredictionJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBatchPredictionJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBatchPredictionJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBatchPredictionJobRequest actualRequest =
        ((DeleteBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBatchPredictionJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBatchPredictionJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelBatchPredictionJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    BatchPredictionJobName name =
        BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");

    client.cancelBatchPredictionJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelBatchPredictionJobRequest actualRequest =
        ((CancelBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelBatchPredictionJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      BatchPredictionJobName name =
          BatchPredictionJobName.of("[PROJECT]", "[LOCATION]", "[BATCH_PREDICTION_JOB]");
      client.cancelBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelBatchPredictionJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelBatchPredictionJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelBatchPredictionJobRequest actualRequest =
        ((CancelBatchPredictionJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelBatchPredictionJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelBatchPredictionJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelDeploymentMonitoringJobTest() throws Exception {
    ModelDeploymentMonitoringJob expectedResponse =
        ModelDeploymentMonitoringJob.newBuilder()
            .setName(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setState(JobState.forNumber(0))
            .setLatestMonitoringPipelineMetadata(
                ModelDeploymentMonitoringJob.LatestMonitoringPipelineMetadata.newBuilder().build())
            .addAllModelDeploymentMonitoringObjectiveConfigs(
                new ArrayList<ModelDeploymentMonitoringObjectiveConfig>())
            .setModelDeploymentMonitoringScheduleConfig(
                ModelDeploymentMonitoringScheduleConfig.newBuilder().build())
            .setLoggingSamplingStrategy(SamplingStrategy.newBuilder().build())
            .setModelMonitoringAlertConfig(ModelMonitoringAlertConfig.newBuilder().build())
            .setPredictInstanceSchemaUri("predictInstanceSchemaUri-1702051043")
            .setSamplePredictInstance(Value.newBuilder().setBoolValue(true).build())
            .setAnalysisInstanceSchemaUri("analysisInstanceSchemaUri-1686197382")
            .addAllBigqueryTables(new ArrayList<ModelDeploymentMonitoringBigQueryTable>())
            .setLogTtl(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextScheduleTime(Timestamp.newBuilder().build())
            .setStatsAnomaliesBaseDirectory(GcsDestination.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setEnableMonitoringPipelineLogs(true)
            .setError(Status.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
        ModelDeploymentMonitoringJob.newBuilder().build();

    ModelDeploymentMonitoringJob actualResponse =
        client.createModelDeploymentMonitoringJob(parent, modelDeploymentMonitoringJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelDeploymentMonitoringJobRequest actualRequest =
        ((CreateModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        modelDeploymentMonitoringJob, actualRequest.getModelDeploymentMonitoringJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
          ModelDeploymentMonitoringJob.newBuilder().build();
      client.createModelDeploymentMonitoringJob(parent, modelDeploymentMonitoringJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelDeploymentMonitoringJobTest2() throws Exception {
    ModelDeploymentMonitoringJob expectedResponse =
        ModelDeploymentMonitoringJob.newBuilder()
            .setName(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setState(JobState.forNumber(0))
            .setLatestMonitoringPipelineMetadata(
                ModelDeploymentMonitoringJob.LatestMonitoringPipelineMetadata.newBuilder().build())
            .addAllModelDeploymentMonitoringObjectiveConfigs(
                new ArrayList<ModelDeploymentMonitoringObjectiveConfig>())
            .setModelDeploymentMonitoringScheduleConfig(
                ModelDeploymentMonitoringScheduleConfig.newBuilder().build())
            .setLoggingSamplingStrategy(SamplingStrategy.newBuilder().build())
            .setModelMonitoringAlertConfig(ModelMonitoringAlertConfig.newBuilder().build())
            .setPredictInstanceSchemaUri("predictInstanceSchemaUri-1702051043")
            .setSamplePredictInstance(Value.newBuilder().setBoolValue(true).build())
            .setAnalysisInstanceSchemaUri("analysisInstanceSchemaUri-1686197382")
            .addAllBigqueryTables(new ArrayList<ModelDeploymentMonitoringBigQueryTable>())
            .setLogTtl(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextScheduleTime(Timestamp.newBuilder().build())
            .setStatsAnomaliesBaseDirectory(GcsDestination.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setEnableMonitoringPipelineLogs(true)
            .setError(Status.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
        ModelDeploymentMonitoringJob.newBuilder().build();

    ModelDeploymentMonitoringJob actualResponse =
        client.createModelDeploymentMonitoringJob(parent, modelDeploymentMonitoringJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateModelDeploymentMonitoringJobRequest actualRequest =
        ((CreateModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        modelDeploymentMonitoringJob, actualRequest.getModelDeploymentMonitoringJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createModelDeploymentMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
          ModelDeploymentMonitoringJob.newBuilder().build();
      client.createModelDeploymentMonitoringJob(parent, modelDeploymentMonitoringJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchModelDeploymentMonitoringStatsAnomaliesTest() throws Exception {
    ModelMonitoringStatsAnomalies responsesElement =
        ModelMonitoringStatsAnomalies.newBuilder().build();
    SearchModelDeploymentMonitoringStatsAnomaliesResponse expectedResponse =
        SearchModelDeploymentMonitoringStatsAnomaliesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoringStats(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    ModelDeploymentMonitoringJobName modelDeploymentMonitoringJob =
        ModelDeploymentMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
    String deployedModelId = "deployedModelId-1817547906";

    SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse pagedListResponse =
        client.searchModelDeploymentMonitoringStatsAnomalies(
            modelDeploymentMonitoringJob, deployedModelId);

    List<ModelMonitoringStatsAnomalies> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoringStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelDeploymentMonitoringStatsAnomaliesRequest actualRequest =
        ((SearchModelDeploymentMonitoringStatsAnomaliesRequest) actualRequests.get(0));

    Assert.assertEquals(
        modelDeploymentMonitoringJob.toString(), actualRequest.getModelDeploymentMonitoringJob());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelDeploymentMonitoringStatsAnomaliesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJobName modelDeploymentMonitoringJob =
          ModelDeploymentMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
      String deployedModelId = "deployedModelId-1817547906";
      client.searchModelDeploymentMonitoringStatsAnomalies(
          modelDeploymentMonitoringJob, deployedModelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchModelDeploymentMonitoringStatsAnomaliesTest2() throws Exception {
    ModelMonitoringStatsAnomalies responsesElement =
        ModelMonitoringStatsAnomalies.newBuilder().build();
    SearchModelDeploymentMonitoringStatsAnomaliesResponse expectedResponse =
        SearchModelDeploymentMonitoringStatsAnomaliesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoringStats(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String modelDeploymentMonitoringJob = "modelDeploymentMonitoringJob-1178077657";
    String deployedModelId = "deployedModelId-1817547906";

    SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse pagedListResponse =
        client.searchModelDeploymentMonitoringStatsAnomalies(
            modelDeploymentMonitoringJob, deployedModelId);

    List<ModelMonitoringStatsAnomalies> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoringStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchModelDeploymentMonitoringStatsAnomaliesRequest actualRequest =
        ((SearchModelDeploymentMonitoringStatsAnomaliesRequest) actualRequests.get(0));

    Assert.assertEquals(
        modelDeploymentMonitoringJob, actualRequest.getModelDeploymentMonitoringJob());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchModelDeploymentMonitoringStatsAnomaliesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String modelDeploymentMonitoringJob = "modelDeploymentMonitoringJob-1178077657";
      String deployedModelId = "deployedModelId-1817547906";
      client.searchModelDeploymentMonitoringStatsAnomalies(
          modelDeploymentMonitoringJob, deployedModelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelDeploymentMonitoringJobTest() throws Exception {
    ModelDeploymentMonitoringJob expectedResponse =
        ModelDeploymentMonitoringJob.newBuilder()
            .setName(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setState(JobState.forNumber(0))
            .setLatestMonitoringPipelineMetadata(
                ModelDeploymentMonitoringJob.LatestMonitoringPipelineMetadata.newBuilder().build())
            .addAllModelDeploymentMonitoringObjectiveConfigs(
                new ArrayList<ModelDeploymentMonitoringObjectiveConfig>())
            .setModelDeploymentMonitoringScheduleConfig(
                ModelDeploymentMonitoringScheduleConfig.newBuilder().build())
            .setLoggingSamplingStrategy(SamplingStrategy.newBuilder().build())
            .setModelMonitoringAlertConfig(ModelMonitoringAlertConfig.newBuilder().build())
            .setPredictInstanceSchemaUri("predictInstanceSchemaUri-1702051043")
            .setSamplePredictInstance(Value.newBuilder().setBoolValue(true).build())
            .setAnalysisInstanceSchemaUri("analysisInstanceSchemaUri-1686197382")
            .addAllBigqueryTables(new ArrayList<ModelDeploymentMonitoringBigQueryTable>())
            .setLogTtl(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextScheduleTime(Timestamp.newBuilder().build())
            .setStatsAnomaliesBaseDirectory(GcsDestination.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setEnableMonitoringPipelineLogs(true)
            .setError(Status.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    ModelDeploymentMonitoringJobName name =
        ModelDeploymentMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");

    ModelDeploymentMonitoringJob actualResponse = client.getModelDeploymentMonitoringJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelDeploymentMonitoringJobRequest actualRequest =
        ((GetModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJobName name =
          ModelDeploymentMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
      client.getModelDeploymentMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelDeploymentMonitoringJobTest2() throws Exception {
    ModelDeploymentMonitoringJob expectedResponse =
        ModelDeploymentMonitoringJob.newBuilder()
            .setName(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setState(JobState.forNumber(0))
            .setLatestMonitoringPipelineMetadata(
                ModelDeploymentMonitoringJob.LatestMonitoringPipelineMetadata.newBuilder().build())
            .addAllModelDeploymentMonitoringObjectiveConfigs(
                new ArrayList<ModelDeploymentMonitoringObjectiveConfig>())
            .setModelDeploymentMonitoringScheduleConfig(
                ModelDeploymentMonitoringScheduleConfig.newBuilder().build())
            .setLoggingSamplingStrategy(SamplingStrategy.newBuilder().build())
            .setModelMonitoringAlertConfig(ModelMonitoringAlertConfig.newBuilder().build())
            .setPredictInstanceSchemaUri("predictInstanceSchemaUri-1702051043")
            .setSamplePredictInstance(Value.newBuilder().setBoolValue(true).build())
            .setAnalysisInstanceSchemaUri("analysisInstanceSchemaUri-1686197382")
            .addAllBigqueryTables(new ArrayList<ModelDeploymentMonitoringBigQueryTable>())
            .setLogTtl(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextScheduleTime(Timestamp.newBuilder().build())
            .setStatsAnomaliesBaseDirectory(GcsDestination.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setEnableMonitoringPipelineLogs(true)
            .setError(Status.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    ModelDeploymentMonitoringJob actualResponse = client.getModelDeploymentMonitoringJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelDeploymentMonitoringJobRequest actualRequest =
        ((GetModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelDeploymentMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getModelDeploymentMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelDeploymentMonitoringJobsTest() throws Exception {
    ModelDeploymentMonitoringJob responsesElement =
        ModelDeploymentMonitoringJob.newBuilder().build();
    ListModelDeploymentMonitoringJobsResponse expectedResponse =
        ListModelDeploymentMonitoringJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelDeploymentMonitoringJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListModelDeploymentMonitoringJobsPagedResponse pagedListResponse =
        client.listModelDeploymentMonitoringJobs(parent);

    List<ModelDeploymentMonitoringJob> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getModelDeploymentMonitoringJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelDeploymentMonitoringJobsRequest actualRequest =
        ((ListModelDeploymentMonitoringJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelDeploymentMonitoringJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listModelDeploymentMonitoringJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelDeploymentMonitoringJobsTest2() throws Exception {
    ModelDeploymentMonitoringJob responsesElement =
        ModelDeploymentMonitoringJob.newBuilder().build();
    ListModelDeploymentMonitoringJobsResponse expectedResponse =
        ListModelDeploymentMonitoringJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelDeploymentMonitoringJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelDeploymentMonitoringJobsPagedResponse pagedListResponse =
        client.listModelDeploymentMonitoringJobs(parent);

    List<ModelDeploymentMonitoringJob> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getModelDeploymentMonitoringJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelDeploymentMonitoringJobsRequest actualRequest =
        ((ListModelDeploymentMonitoringJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelDeploymentMonitoringJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModelDeploymentMonitoringJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateModelDeploymentMonitoringJobTest() throws Exception {
    ModelDeploymentMonitoringJob expectedResponse =
        ModelDeploymentMonitoringJob.newBuilder()
            .setName(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setState(JobState.forNumber(0))
            .setLatestMonitoringPipelineMetadata(
                ModelDeploymentMonitoringJob.LatestMonitoringPipelineMetadata.newBuilder().build())
            .addAllModelDeploymentMonitoringObjectiveConfigs(
                new ArrayList<ModelDeploymentMonitoringObjectiveConfig>())
            .setModelDeploymentMonitoringScheduleConfig(
                ModelDeploymentMonitoringScheduleConfig.newBuilder().build())
            .setLoggingSamplingStrategy(SamplingStrategy.newBuilder().build())
            .setModelMonitoringAlertConfig(ModelMonitoringAlertConfig.newBuilder().build())
            .setPredictInstanceSchemaUri("predictInstanceSchemaUri-1702051043")
            .setSamplePredictInstance(Value.newBuilder().setBoolValue(true).build())
            .setAnalysisInstanceSchemaUri("analysisInstanceSchemaUri-1686197382")
            .addAllBigqueryTables(new ArrayList<ModelDeploymentMonitoringBigQueryTable>())
            .setLogTtl(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextScheduleTime(Timestamp.newBuilder().build())
            .setStatsAnomaliesBaseDirectory(GcsDestination.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setEnableMonitoringPipelineLogs(true)
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateModelDeploymentMonitoringJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
        ModelDeploymentMonitoringJob.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ModelDeploymentMonitoringJob actualResponse =
        client
            .updateModelDeploymentMonitoringJobAsync(modelDeploymentMonitoringJob, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateModelDeploymentMonitoringJobRequest actualRequest =
        ((UpdateModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(
        modelDeploymentMonitoringJob, actualRequest.getModelDeploymentMonitoringJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJob modelDeploymentMonitoringJob =
          ModelDeploymentMonitoringJob.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updateModelDeploymentMonitoringJobAsync(modelDeploymentMonitoringJob, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelDeploymentMonitoringJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelDeploymentMonitoringJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    ModelDeploymentMonitoringJobName name =
        ModelDeploymentMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");

    client.deleteModelDeploymentMonitoringJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelDeploymentMonitoringJobRequest actualRequest =
        ((DeleteModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJobName name =
          ModelDeploymentMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
      client.deleteModelDeploymentMonitoringJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelDeploymentMonitoringJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelDeploymentMonitoringJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelDeploymentMonitoringJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelDeploymentMonitoringJobRequest actualRequest =
        ((DeleteModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelDeploymentMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelDeploymentMonitoringJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void pauseModelDeploymentMonitoringJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    ModelDeploymentMonitoringJobName name =
        ModelDeploymentMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");

    client.pauseModelDeploymentMonitoringJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseModelDeploymentMonitoringJobRequest actualRequest =
        ((PauseModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJobName name =
          ModelDeploymentMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
      client.pauseModelDeploymentMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseModelDeploymentMonitoringJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.pauseModelDeploymentMonitoringJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseModelDeploymentMonitoringJobRequest actualRequest =
        ((PauseModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseModelDeploymentMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.pauseModelDeploymentMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeModelDeploymentMonitoringJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    ModelDeploymentMonitoringJobName name =
        ModelDeploymentMonitoringJobName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");

    client.resumeModelDeploymentMonitoringJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeModelDeploymentMonitoringJobRequest actualRequest =
        ((ResumeModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeModelDeploymentMonitoringJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ModelDeploymentMonitoringJobName name =
          ModelDeploymentMonitoringJobName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]");
      client.resumeModelDeploymentMonitoringJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeModelDeploymentMonitoringJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.resumeModelDeploymentMonitoringJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeModelDeploymentMonitoringJobRequest actualRequest =
        ((ResumeModelDeploymentMonitoringJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeModelDeploymentMonitoringJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.resumeModelDeploymentMonitoringJob(name);
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
