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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.PipelineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.PipelineServiceClient.ListPipelineJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.PipelineServiceClient.ListTrainingPipelinesPagedResponse;

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
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
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
public class PipelineServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockPipelineService mockPipelineService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PipelineServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPipelineService = new MockPipelineService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPipelineService, mockLocations, mockIAMPolicy));
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
    PipelineServiceSettings settings =
        PipelineServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PipelineServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTrainingPipelineTest() throws Exception {
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInputDataConfig(InputDataConfig.newBuilder().build())
            .setTrainingTaskDefinition("trainingTaskDefinition-1218104270")
            .setTrainingTaskInputs(Value.newBuilder().setBoolValue(true).build())
            .setTrainingTaskMetadata(Value.newBuilder().setBoolValue(true).build())
            .setModelToUpload(Model.newBuilder().build())
            .setModelId("modelId1226956324")
            .setParentModel("parentModel998431903")
            .setState(PipelineState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();

    TrainingPipeline actualResponse = client.createTrainingPipeline(parent, trainingPipeline);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTrainingPipelineRequest actualRequest =
        ((CreateTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(trainingPipeline, actualRequest.getTrainingPipeline());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
      client.createTrainingPipeline(parent, trainingPipeline);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTrainingPipelineTest2() throws Exception {
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInputDataConfig(InputDataConfig.newBuilder().build())
            .setTrainingTaskDefinition("trainingTaskDefinition-1218104270")
            .setTrainingTaskInputs(Value.newBuilder().setBoolValue(true).build())
            .setTrainingTaskMetadata(Value.newBuilder().setBoolValue(true).build())
            .setModelToUpload(Model.newBuilder().build())
            .setModelId("modelId1226956324")
            .setParentModel("parentModel998431903")
            .setState(PipelineState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();

    TrainingPipeline actualResponse = client.createTrainingPipeline(parent, trainingPipeline);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTrainingPipelineRequest actualRequest =
        ((CreateTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(trainingPipeline, actualRequest.getTrainingPipeline());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTrainingPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String parent = "parent-995424086";
      TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
      client.createTrainingPipeline(parent, trainingPipeline);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTrainingPipelineTest() throws Exception {
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInputDataConfig(InputDataConfig.newBuilder().build())
            .setTrainingTaskDefinition("trainingTaskDefinition-1218104270")
            .setTrainingTaskInputs(Value.newBuilder().setBoolValue(true).build())
            .setTrainingTaskMetadata(Value.newBuilder().setBoolValue(true).build())
            .setModelToUpload(Model.newBuilder().build())
            .setModelId("modelId1226956324")
            .setParentModel("parentModel998431903")
            .setState(PipelineState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

    TrainingPipeline actualResponse = client.getTrainingPipeline(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTrainingPipelineRequest actualRequest = ((GetTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
      client.getTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTrainingPipelineTest2() throws Exception {
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInputDataConfig(InputDataConfig.newBuilder().build())
            .setTrainingTaskDefinition("trainingTaskDefinition-1218104270")
            .setTrainingTaskInputs(Value.newBuilder().setBoolValue(true).build())
            .setTrainingTaskMetadata(Value.newBuilder().setBoolValue(true).build())
            .setModelToUpload(Model.newBuilder().build())
            .setModelId("modelId1226956324")
            .setParentModel("parentModel998431903")
            .setState(PipelineState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String name = "name3373707";

    TrainingPipeline actualResponse = client.getTrainingPipeline(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTrainingPipelineRequest actualRequest = ((GetTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTrainingPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.getTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrainingPipelinesTest() throws Exception {
    TrainingPipeline responsesElement = TrainingPipeline.newBuilder().build();
    ListTrainingPipelinesResponse expectedResponse =
        ListTrainingPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrainingPipelines(Arrays.asList(responsesElement))
            .build();
    mockPipelineService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTrainingPipelinesPagedResponse pagedListResponse = client.listTrainingPipelines(parent);

    List<TrainingPipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrainingPipelinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTrainingPipelinesRequest actualRequest =
        ((ListTrainingPipelinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTrainingPipelinesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTrainingPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrainingPipelinesTest2() throws Exception {
    TrainingPipeline responsesElement = TrainingPipeline.newBuilder().build();
    ListTrainingPipelinesResponse expectedResponse =
        ListTrainingPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrainingPipelines(Arrays.asList(responsesElement))
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTrainingPipelinesPagedResponse pagedListResponse = client.listTrainingPipelines(parent);

    List<TrainingPipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrainingPipelinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTrainingPipelinesRequest actualRequest =
        ((ListTrainingPipelinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTrainingPipelinesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTrainingPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTrainingPipelineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTrainingPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPipelineService.addResponse(resultOperation);

    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

    client.deleteTrainingPipelineAsync(name).get();

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTrainingPipelineRequest actualRequest =
        ((DeleteTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
      client.deleteTrainingPipelineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTrainingPipelineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTrainingPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPipelineService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTrainingPipelineAsync(name).get();

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTrainingPipelineRequest actualRequest =
        ((DeleteTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTrainingPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTrainingPipelineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelTrainingPipelineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPipelineService.addResponse(expectedResponse);

    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

    client.cancelTrainingPipeline(name);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelTrainingPipelineRequest actualRequest =
        ((CancelTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
      client.cancelTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelTrainingPipelineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPipelineService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelTrainingPipeline(name);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelTrainingPipelineRequest actualRequest =
        ((CancelTrainingPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelTrainingPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPipelineJobTest() throws Exception {
    PipelineJob expectedResponse =
        PipelineJob.newBuilder()
            .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPipelineSpec(Struct.newBuilder().build())
            .setState(PipelineState.forNumber(0))
            .setJobDetail(PipelineJobDetail.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(PipelineJob.RuntimeConfig.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setNetwork("network1843485230")
            .setTemplateUri("templateUri1769633426")
            .setTemplateMetadata(PipelineTemplateMetadata.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PipelineJob pipelineJob = PipelineJob.newBuilder().build();
    String pipelineJobId = "pipelineJobId-1711315914";

    PipelineJob actualResponse = client.createPipelineJob(parent, pipelineJob, pipelineJobId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePipelineJobRequest actualRequest = ((CreatePipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(pipelineJob, actualRequest.getPipelineJob());
    Assert.assertEquals(pipelineJobId, actualRequest.getPipelineJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPipelineJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PipelineJob pipelineJob = PipelineJob.newBuilder().build();
      String pipelineJobId = "pipelineJobId-1711315914";
      client.createPipelineJob(parent, pipelineJob, pipelineJobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPipelineJobTest2() throws Exception {
    PipelineJob expectedResponse =
        PipelineJob.newBuilder()
            .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPipelineSpec(Struct.newBuilder().build())
            .setState(PipelineState.forNumber(0))
            .setJobDetail(PipelineJobDetail.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(PipelineJob.RuntimeConfig.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setNetwork("network1843485230")
            .setTemplateUri("templateUri1769633426")
            .setTemplateMetadata(PipelineTemplateMetadata.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PipelineJob pipelineJob = PipelineJob.newBuilder().build();
    String pipelineJobId = "pipelineJobId-1711315914";

    PipelineJob actualResponse = client.createPipelineJob(parent, pipelineJob, pipelineJobId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePipelineJobRequest actualRequest = ((CreatePipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(pipelineJob, actualRequest.getPipelineJob());
    Assert.assertEquals(pipelineJobId, actualRequest.getPipelineJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPipelineJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String parent = "parent-995424086";
      PipelineJob pipelineJob = PipelineJob.newBuilder().build();
      String pipelineJobId = "pipelineJobId-1711315914";
      client.createPipelineJob(parent, pipelineJob, pipelineJobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPipelineJobTest() throws Exception {
    PipelineJob expectedResponse =
        PipelineJob.newBuilder()
            .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPipelineSpec(Struct.newBuilder().build())
            .setState(PipelineState.forNumber(0))
            .setJobDetail(PipelineJobDetail.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(PipelineJob.RuntimeConfig.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setNetwork("network1843485230")
            .setTemplateUri("templateUri1769633426")
            .setTemplateMetadata(PipelineTemplateMetadata.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");

    PipelineJob actualResponse = client.getPipelineJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPipelineJobRequest actualRequest = ((GetPipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPipelineJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
      client.getPipelineJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPipelineJobTest2() throws Exception {
    PipelineJob expectedResponse =
        PipelineJob.newBuilder()
            .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPipelineSpec(Struct.newBuilder().build())
            .setState(PipelineState.forNumber(0))
            .setJobDetail(PipelineJobDetail.newBuilder().build())
            .setError(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(PipelineJob.RuntimeConfig.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setNetwork("network1843485230")
            .setTemplateUri("templateUri1769633426")
            .setTemplateMetadata(PipelineTemplateMetadata.newBuilder().build())
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String name = "name3373707";

    PipelineJob actualResponse = client.getPipelineJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPipelineJobRequest actualRequest = ((GetPipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPipelineJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.getPipelineJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPipelineJobsTest() throws Exception {
    PipelineJob responsesElement = PipelineJob.newBuilder().build();
    ListPipelineJobsResponse expectedResponse =
        ListPipelineJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPipelineJobs(Arrays.asList(responsesElement))
            .build();
    mockPipelineService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPipelineJobsPagedResponse pagedListResponse = client.listPipelineJobs(parent);

    List<PipelineJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPipelineJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPipelineJobsRequest actualRequest = ((ListPipelineJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPipelineJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPipelineJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPipelineJobsTest2() throws Exception {
    PipelineJob responsesElement = PipelineJob.newBuilder().build();
    ListPipelineJobsResponse expectedResponse =
        ListPipelineJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPipelineJobs(Arrays.asList(responsesElement))
            .build();
    mockPipelineService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPipelineJobsPagedResponse pagedListResponse = client.listPipelineJobs(parent);

    List<PipelineJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPipelineJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPipelineJobsRequest actualRequest = ((ListPipelineJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPipelineJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPipelineJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePipelineJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePipelineJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPipelineService.addResponse(resultOperation);

    PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");

    client.deletePipelineJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePipelineJobRequest actualRequest = ((DeletePipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePipelineJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
      client.deletePipelineJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePipelineJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePipelineJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPipelineService.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePipelineJobAsync(name).get();

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePipelineJobRequest actualRequest = ((DeletePipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePipelineJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePipelineJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelPipelineJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPipelineService.addResponse(expectedResponse);

    PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");

    client.cancelPipelineJob(name);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelPipelineJobRequest actualRequest = ((CancelPipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelPipelineJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
      client.cancelPipelineJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPipelineJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPipelineService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelPipelineJob(name);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelPipelineJobRequest actualRequest = ((CancelPipelineJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelPipelineJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelPipelineJob(name);
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
