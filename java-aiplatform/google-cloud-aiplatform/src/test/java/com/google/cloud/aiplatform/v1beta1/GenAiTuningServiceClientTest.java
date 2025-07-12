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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.GenAiTuningServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.GenAiTuningServiceClient.ListTuningJobsPagedResponse;

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
public class GenAiTuningServiceClientTest {
  private static MockGenAiTuningService mockGenAiTuningService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GenAiTuningServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGenAiTuningService = new MockGenAiTuningService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGenAiTuningService, mockLocations, mockIAMPolicy));
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
    GenAiTuningServiceSettings settings =
        GenAiTuningServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GenAiTuningServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTuningJobTest() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TuningJob tuningJob = TuningJob.newBuilder().build();

    TuningJob actualResponse = client.createTuningJob(parent, tuningJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTuningJobRequest actualRequest = ((CreateTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tuningJob, actualRequest.getTuningJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TuningJob tuningJob = TuningJob.newBuilder().build();
      client.createTuningJob(parent, tuningJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTuningJobTest2() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TuningJob tuningJob = TuningJob.newBuilder().build();

    TuningJob actualResponse = client.createTuningJob(parent, tuningJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTuningJobRequest actualRequest = ((CreateTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tuningJob, actualRequest.getTuningJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      String parent = "parent-995424086";
      TuningJob tuningJob = TuningJob.newBuilder().build();
      client.createTuningJob(parent, tuningJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTuningJobTest() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");

    TuningJob actualResponse = client.getTuningJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTuningJobRequest actualRequest = ((GetTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");
      client.getTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTuningJobTest2() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    String name = "name3373707";

    TuningJob actualResponse = client.getTuningJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTuningJobRequest actualRequest = ((GetTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      String name = "name3373707";
      client.getTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTuningJobsTest() throws Exception {
    TuningJob responsesElement = TuningJob.newBuilder().build();
    ListTuningJobsResponse expectedResponse =
        ListTuningJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTuningJobs(Arrays.asList(responsesElement))
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTuningJobsPagedResponse pagedListResponse = client.listTuningJobs(parent);

    List<TuningJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTuningJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTuningJobsRequest actualRequest = ((ListTuningJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTuningJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTuningJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTuningJobsTest2() throws Exception {
    TuningJob responsesElement = TuningJob.newBuilder().build();
    ListTuningJobsResponse expectedResponse =
        ListTuningJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTuningJobs(Arrays.asList(responsesElement))
            .build();
    mockGenAiTuningService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTuningJobsPagedResponse pagedListResponse = client.listTuningJobs(parent);

    List<TuningJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTuningJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTuningJobsRequest actualRequest = ((ListTuningJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTuningJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTuningJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelTuningJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGenAiTuningService.addResponse(expectedResponse);

    TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");

    client.cancelTuningJob(name);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelTuningJobRequest actualRequest = ((CancelTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelTuningJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");
      client.cancelTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelTuningJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGenAiTuningService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelTuningJob(name);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelTuningJobRequest actualRequest = ((CancelTuningJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelTuningJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelTuningJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rebaseTunedModelTest() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rebaseTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGenAiTuningService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TunedModelRef tunedModelRef = TunedModelRef.newBuilder().build();

    TuningJob actualResponse = client.rebaseTunedModelAsync(parent, tunedModelRef).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RebaseTunedModelRequest actualRequest = ((RebaseTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tunedModelRef, actualRequest.getTunedModelRef());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rebaseTunedModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TunedModelRef tunedModelRef = TunedModelRef.newBuilder().build();
      client.rebaseTunedModelAsync(parent, tunedModelRef).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rebaseTunedModelTest2() throws Exception {
    TuningJob expectedResponse =
        TuningJob.newBuilder()
            .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
            .setTunedModelDisplayName("tunedModelDisplayName759401232")
            .setDescription("description-1724546052")
            .setCustomBaseModel("customBaseModel942572135")
            .setState(JobState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExperiment(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setTunedModel(TunedModel.newBuilder().build())
            .setTuningDataStats(TuningDataStats.newBuilder().build())
            .setPipelineJob(
                PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setOutputUri("outputUri-2119300949")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rebaseTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGenAiTuningService.addResponse(resultOperation);

    String parent = "parent-995424086";
    TunedModelRef tunedModelRef = TunedModelRef.newBuilder().build();

    TuningJob actualResponse = client.rebaseTunedModelAsync(parent, tunedModelRef).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenAiTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RebaseTunedModelRequest actualRequest = ((RebaseTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tunedModelRef, actualRequest.getTunedModelRef());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rebaseTunedModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenAiTuningService.addException(exception);

    try {
      String parent = "parent-995424086";
      TunedModelRef tunedModelRef = TunedModelRef.newBuilder().build();
      client.rebaseTunedModelAsync(parent, tunedModelRef).get();
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
