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

import static com.google.cloud.aiplatform.v1beta1.PipelineServiceClient.ListTrainingPipelinesPagedResponse;

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
public class PipelineServiceClientTest {
  private static MockDatasetService mockDatasetService;
  private static MockEndpointService mockEndpointService;
  private static MockJobService mockJobService;
  private static MockModelService mockModelService;
  private static MockPipelineService mockPipelineService;
  private static MockPredictionService mockPredictionService;
  private static MockSpecialistPoolService mockSpecialistPoolService;
  private static MockServiceHelper serviceHelper;
  private PipelineServiceClient client;
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
  @SuppressWarnings("all")
  public void createTrainingPipelineTest() {
    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
    String displayName = "displayName1615086568";
    String trainingTaskDefinition = "trainingTaskDefinition-1916695832";
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setTrainingTaskDefinition(trainingTaskDefinition)
            .build();
    mockPipelineService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();

    TrainingPipeline actualResponse = client.createTrainingPipeline(parent, trainingPipeline);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTrainingPipelineRequest actualRequest =
        (CreateTrainingPipelineRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(trainingPipeline, actualRequest.getTrainingPipeline());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();

      client.createTrainingPipeline(parent, trainingPipeline);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTrainingPipelineTest() {
    TrainingPipelineName name2 =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
    String displayName = "displayName1615086568";
    String trainingTaskDefinition = "trainingTaskDefinition-1916695832";
    TrainingPipeline expectedResponse =
        TrainingPipeline.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setTrainingTaskDefinition(trainingTaskDefinition)
            .build();
    mockPipelineService.addResponse(expectedResponse);

    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

    TrainingPipeline actualResponse = client.getTrainingPipeline(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTrainingPipelineRequest actualRequest = (GetTrainingPipelineRequest) actualRequests.get(0);

    Assert.assertEquals(name, TrainingPipelineName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

      client.getTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTrainingPipelinesTest() {
    String nextPageToken = "";
    TrainingPipeline trainingPipelinesElement = TrainingPipeline.newBuilder().build();
    List<TrainingPipeline> trainingPipelines = Arrays.asList(trainingPipelinesElement);
    ListTrainingPipelinesResponse expectedResponse =
        ListTrainingPipelinesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTrainingPipelines(trainingPipelines)
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
        (ListTrainingPipelinesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTrainingPipelinesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listTrainingPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
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

    Empty actualResponse = client.deleteTrainingPipelineAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTrainingPipelineRequest actualRequest =
        (DeleteTrainingPipelineRequest) actualRequests.get(0);

    Assert.assertEquals(name, TrainingPipelineName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

      client.deleteTrainingPipelineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelTrainingPipelineTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPipelineService.addResponse(expectedResponse);

    TrainingPipelineName name =
        TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

    client.cancelTrainingPipeline(name);

    List<AbstractMessage> actualRequests = mockPipelineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelTrainingPipelineRequest actualRequest =
        (CancelTrainingPipelineRequest) actualRequests.get(0);

    Assert.assertEquals(name, TrainingPipelineName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelTrainingPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPipelineService.addException(exception);

    try {
      TrainingPipelineName name =
          TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");

      client.cancelTrainingPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
