/*
 * Copyright 2020 Google LLC
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
  private static MockServiceHelper mockServiceHelper;
  private JobServiceClient client;
  private static MockJobService mockJobService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockJobService = new MockJobService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockJobService));
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setInputs(Value.newBuilder().build())
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
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
            .setInputs(Value.newBuilder().build())
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
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
            .setInputs(Value.newBuilder().build())
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
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
            .setInputs(Value.newBuilder().build())
            .setLabelingProgress(-685978914)
            .setCurrentSpend(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSpecialistPools(new ArrayList<String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setModelParameters(Value.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setModelParameters(Value.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setModelParameters(Value.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
            .setModelParameters(Value.newBuilder().build())
            .setDedicatedResources(BatchDedicatedResources.newBuilder().build())
            .setManualBatchTuningParameters(ManualBatchTuningParameters.newBuilder().build())
            .setGenerateExplanation(true)
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setError(Status.newBuilder().build())
            .addAllPartialFailures(new ArrayList<Status>())
            .setResourcesConsumed(ResourcesConsumed.newBuilder().build())
            .setCompletionStats(CompletionStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
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
}
