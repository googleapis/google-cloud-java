/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationDatasetsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationExpectationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationRunsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListScheduledEvaluationRunsPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class EvaluationServiceClientTest {
  private static MockEvaluationService mockEvaluationService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EvaluationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEvaluationService = new MockEvaluationService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEvaluationService, mockLocations));
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
    EvaluationServiceSettings settings =
        EvaluationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EvaluationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void runEvaluationTest() throws Exception {
    RunEvaluationResponse expectedResponse =
        RunEvaluationResponse.newBuilder()
            .setEvaluationRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    RunEvaluationResponse actualResponse = client.runEvaluationAsync(app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunEvaluationRequest actualRequest = ((RunEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(app.toString(), actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.runEvaluationAsync(app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void runEvaluationTest2() throws Exception {
    RunEvaluationResponse expectedResponse =
        RunEvaluationResponse.newBuilder()
            .setEvaluationRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    String app = "app96801";

    RunEvaluationResponse actualResponse = client.runEvaluationAsync(app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunEvaluationRequest actualRequest = ((RunEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String app = "app96801";
      client.runEvaluationAsync(app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void uploadEvaluationAudioTest() throws Exception {
    UploadEvaluationAudioResponse expectedResponse =
        UploadEvaluationAudioResponse.newBuilder()
            .setAudioGcsUri("audioGcsUri83075659")
            .setAudioTranscript("audioTranscript946674732")
            .setAudioDuration(Duration.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ByteString audioContent = ByteString.EMPTY;

    UploadEvaluationAudioResponse actualResponse = client.uploadEvaluationAudio(app, audioContent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadEvaluationAudioRequest actualRequest =
        ((UploadEvaluationAudioRequest) actualRequests.get(0));

    Assert.assertEquals(app.toString(), actualRequest.getApp());
    Assert.assertEquals(audioContent, actualRequest.getAudioContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadEvaluationAudioExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      ByteString audioContent = ByteString.EMPTY;
      client.uploadEvaluationAudio(app, audioContent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uploadEvaluationAudioTest2() throws Exception {
    UploadEvaluationAudioResponse expectedResponse =
        UploadEvaluationAudioResponse.newBuilder()
            .setAudioGcsUri("audioGcsUri83075659")
            .setAudioTranscript("audioTranscript946674732")
            .setAudioDuration(Duration.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String app = "app96801";
    ByteString audioContent = ByteString.EMPTY;

    UploadEvaluationAudioResponse actualResponse = client.uploadEvaluationAudio(app, audioContent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadEvaluationAudioRequest actualRequest =
        ((UploadEvaluationAudioRequest) actualRequests.get(0));

    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertEquals(audioContent, actualRequest.getAudioContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadEvaluationAudioExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String app = "app96801";
      ByteString audioContent = ByteString.EMPTY;
      client.uploadEvaluationAudio(app, audioContent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluation(parent, evaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationRequest actualRequest = ((CreateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Evaluation evaluation = Evaluation.newBuilder().build();
      client.createEvaluation(parent, evaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluation(parent, evaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationRequest actualRequest = ((CreateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Evaluation evaluation = Evaluation.newBuilder().build();
      client.createEvaluation(parent, evaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationTest3() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse = client.createEvaluation(parent, evaluation, evaluationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationRequest actualRequest = ((CreateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
    Assert.assertEquals(evaluationId, actualRequest.getEvaluationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Evaluation evaluation = Evaluation.newBuilder().build();
      String evaluationId = "evaluationId407318903";
      client.createEvaluation(parent, evaluation, evaluationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationTest4() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse = client.createEvaluation(parent, evaluation, evaluationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationRequest actualRequest = ((CreateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
    Assert.assertEquals(evaluationId, actualRequest.getEvaluationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Evaluation evaluation = Evaluation.newBuilder().build();
      String evaluationId = "evaluationId407318903";
      client.createEvaluation(parent, evaluation, evaluationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    ConversationName conversation =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    Evaluation actualResponse = client.generateEvaluationAsync(conversation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateEvaluationRequest actualRequest = ((GenerateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(conversation.toString(), actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      ConversationName conversation =
          ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
      client.generateEvaluationAsync(conversation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    String conversation = "conversation740154499";

    Evaluation actualResponse = client.generateEvaluationAsync(conversation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateEvaluationRequest actualRequest = ((GenerateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String conversation = "conversation740154499";
      client.generateEvaluationAsync(conversation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importEvaluationsTest() throws Exception {
    ImportEvaluationsResponse expectedResponse =
        ImportEvaluationsResponse.newBuilder()
            .addAllEvaluations(new ArrayList<Evaluation>())
            .addAllErrorMessages(new ArrayList<String>())
            .setImportFailureCount(663262976)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importEvaluationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ImportEvaluationsResponse actualResponse = client.importEvaluationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportEvaluationsRequest actualRequest = ((ImportEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.importEvaluationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importEvaluationsTest2() throws Exception {
    ImportEvaluationsResponse expectedResponse =
        ImportEvaluationsResponse.newBuilder()
            .addAllEvaluations(new ArrayList<Evaluation>())
            .addAllErrorMessages(new ArrayList<String>())
            .setImportFailureCount(663262976)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importEvaluationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    String parent = "parent-995424086";

    ImportEvaluationsResponse actualResponse = client.importEvaluationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportEvaluationsRequest actualRequest = ((ImportEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importEvaluationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.importEvaluationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEvaluationDatasetTest() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();

    EvaluationDataset actualResponse = client.createEvaluationDataset(parent, evaluationDataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationDatasetRequest actualRequest =
        ((CreateEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluationDataset, actualRequest.getEvaluationDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
      client.createEvaluationDataset(parent, evaluationDataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationDatasetTest2() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();

    EvaluationDataset actualResponse = client.createEvaluationDataset(parent, evaluationDataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationDatasetRequest actualRequest =
        ((CreateEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluationDataset, actualRequest.getEvaluationDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
      client.createEvaluationDataset(parent, evaluationDataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationDatasetTest3() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
    String evaluationDatasetId = "evaluationDatasetId1149172695";

    EvaluationDataset actualResponse =
        client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationDatasetRequest actualRequest =
        ((CreateEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluationDataset, actualRequest.getEvaluationDataset());
    Assert.assertEquals(evaluationDatasetId, actualRequest.getEvaluationDatasetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationDatasetExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
      String evaluationDatasetId = "evaluationDatasetId1149172695";
      client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationDatasetTest4() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
    String evaluationDatasetId = "evaluationDatasetId1149172695";

    EvaluationDataset actualResponse =
        client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationDatasetRequest actualRequest =
        ((CreateEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluationDataset, actualRequest.getEvaluationDataset());
    Assert.assertEquals(evaluationDatasetId, actualRequest.getEvaluationDatasetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationDatasetExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
      String evaluationDatasetId = "evaluationDatasetId1149172695";
      client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    Evaluation evaluation = Evaluation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Evaluation actualResponse = client.updateEvaluation(evaluation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEvaluationRequest actualRequest = ((UpdateEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      Evaluation evaluation = Evaluation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluation(evaluation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEvaluationDatasetTest() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationDataset actualResponse =
        client.updateEvaluationDataset(evaluationDataset, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEvaluationDatasetRequest actualRequest =
        ((UpdateEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(evaluationDataset, actualRequest.getEvaluationDataset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEvaluationDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluationDataset(evaluationDataset, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    client.deleteEvaluation(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationRequest actualRequest = ((DeleteEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
      client.deleteEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvaluation(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationRequest actualRequest = ((DeleteEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationResultName name =
        EvaluationResultName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");

    client.deleteEvaluationResult(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationResultRequest actualRequest =
        ((DeleteEvaluationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationResultName name =
          EvaluationResultName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");
      client.deleteEvaluationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationResultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvaluationResult(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationResultRequest actualRequest =
        ((DeleteEvaluationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationDatasetName name =
        EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");

    client.deleteEvaluationDataset(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationDatasetRequest actualRequest =
        ((DeleteEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationDatasetName name =
          EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");
      client.deleteEvaluationDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvaluationDataset(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationDatasetRequest actualRequest =
        ((DeleteEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEvaluationRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    EvaluationRunName name =
        EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");

    client.deleteEvaluationRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationRunRequest actualRequest = ((DeleteEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationRunName name =
          EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");
      client.deleteEvaluationRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEvaluationRunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEvaluationRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEvaluationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEvaluationRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationRunRequest actualRequest = ((DeleteEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = ((GetEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
      client.getEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(
                EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTags(new ArrayList<String>())
            .addAllEvaluationDatasets(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .addAllEvaluationRuns(new ArrayList<String>())
            .setEtag("etag3123477")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .setLastCompletedResult(EvaluationResult.newBuilder().build())
            .setInvalid(true)
            .addAllLastTenResults(new ArrayList<EvaluationResult>())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = ((GetEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationResultTest() throws Exception {
    EvaluationResult expectedResponse =
        EvaluationResult.newBuilder()
            .setName(
                EvaluationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEvaluationRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setPersona(EvaluationPersona.newBuilder().build())
            .setErrorInfo(EvaluationErrorInfo.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setInitiatedBy("initiatedBy1241266850")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setAppVersionDisplayName("appVersionDisplayName-359941514")
            .setChangelog(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setChangelogCreateTime(Timestamp.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationResultName name =
        EvaluationResultName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");

    EvaluationResult actualResponse = client.getEvaluationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationResultRequest actualRequest = ((GetEvaluationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationResultName name =
          EvaluationResultName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");
      client.getEvaluationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationResultTest2() throws Exception {
    EvaluationResult expectedResponse =
        EvaluationResult.newBuilder()
            .setName(
                EvaluationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEvaluationRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setPersona(EvaluationPersona.newBuilder().build())
            .setErrorInfo(EvaluationErrorInfo.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setInitiatedBy("initiatedBy1241266850")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setAppVersionDisplayName("appVersionDisplayName-359941514")
            .setChangelog(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setChangelogCreateTime(Timestamp.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    EvaluationResult actualResponse = client.getEvaluationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationResultRequest actualRequest = ((GetEvaluationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationDatasetTest() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationDatasetName name =
        EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");

    EvaluationDataset actualResponse = client.getEvaluationDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationDatasetRequest actualRequest =
        ((GetEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationDatasetName name =
          EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");
      client.getEvaluationDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationDatasetTest2() throws Exception {
    EvaluationDataset expectedResponse =
        EvaluationDataset.newBuilder()
            .setName(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluations(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setCreatedBy("createdBy598371679")
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setAggregatedMetrics(AggregatedMetrics.newBuilder().build())
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    EvaluationDataset actualResponse = client.getEvaluationDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationDatasetRequest actualRequest =
        ((GetEvaluationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluationDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationRunTest() throws Exception {
    EvaluationRun expectedResponse =
        EvaluationRun.newBuilder()
            .setName(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluationResults(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInitiatedBy("initiatedBy1241266850")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setAppVersionDisplayName("appVersionDisplayName-359941514")
            .setChangelog(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setChangelogCreateTime(Timestamp.newBuilder().build())
            .addAllEvaluations(new ArrayList<String>())
            .setEvaluationDataset(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setProgress(EvaluationRun.Progress.newBuilder().build())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setErrorInfo(EvaluationErrorInfo.newBuilder().build())
            .putAllEvaluationRunSummaries(new HashMap<String, EvaluationRun.EvaluationRunSummary>())
            .setLatencyReport(LatencyReport.newBuilder().build())
            .setRunCount(-485221797)
            .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
            .setOptimizationConfig(OptimizationConfig.newBuilder().build())
            .setScheduledEvaluationRun(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationRunName name =
        EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");

    EvaluationRun actualResponse = client.getEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRunRequest actualRequest = ((GetEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationRunName name =
          EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");
      client.getEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationRunTest2() throws Exception {
    EvaluationRun expectedResponse =
        EvaluationRun.newBuilder()
            .setName(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllEvaluationResults(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInitiatedBy("initiatedBy1241266850")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setAppVersionDisplayName("appVersionDisplayName-359941514")
            .setChangelog(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setChangelogCreateTime(Timestamp.newBuilder().build())
            .addAllEvaluations(new ArrayList<String>())
            .setEvaluationDataset(
                EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                    .toString())
            .setProgress(EvaluationRun.Progress.newBuilder().build())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setErrorInfo(EvaluationErrorInfo.newBuilder().build())
            .putAllEvaluationRunSummaries(new HashMap<String, EvaluationRun.EvaluationRunSummary>())
            .setLatencyReport(LatencyReport.newBuilder().build())
            .setRunCount(-485221797)
            .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
            .setOptimizationConfig(OptimizationConfig.newBuilder().build())
            .setScheduledEvaluationRun(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    EvaluationRun actualResponse = client.getEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRunRequest actualRequest = ((GetEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationsTest() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    ListEvaluationsResponse expectedResponse =
        ListEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationsRequest actualRequest = ((ListEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationsTest2() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    ListEvaluationsResponse expectedResponse =
        ListEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationsRequest actualRequest = ((ListEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationResultsTest() throws Exception {
    EvaluationResult responsesElement = EvaluationResult.newBuilder().build();
    ListEvaluationResultsResponse expectedResponse =
        ListEvaluationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationResults(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(parent);

    List<EvaluationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationResultsRequest actualRequest =
        ((ListEvaluationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
      client.listEvaluationResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationResultsTest2() throws Exception {
    EvaluationResult responsesElement = EvaluationResult.newBuilder().build();
    ListEvaluationResultsResponse expectedResponse =
        ListEvaluationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationResults(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(parent);

    List<EvaluationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationResultsRequest actualRequest =
        ((ListEvaluationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvaluationResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationDatasetsTest() throws Exception {
    EvaluationDataset responsesElement = EvaluationDataset.newBuilder().build();
    ListEvaluationDatasetsResponse expectedResponse =
        ListEvaluationDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationDatasets(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationDatasetsPagedResponse pagedListResponse = client.listEvaluationDatasets(parent);

    List<EvaluationDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationDatasetsRequest actualRequest =
        ((ListEvaluationDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listEvaluationDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationDatasetsTest2() throws Exception {
    EvaluationDataset responsesElement = EvaluationDataset.newBuilder().build();
    ListEvaluationDatasetsResponse expectedResponse =
        ListEvaluationDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationDatasets(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationDatasetsPagedResponse pagedListResponse = client.listEvaluationDatasets(parent);

    List<EvaluationDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationDatasetsRequest actualRequest =
        ((ListEvaluationDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvaluationDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationRunsTest() throws Exception {
    EvaluationRun responsesElement = EvaluationRun.newBuilder().build();
    ListEvaluationRunsResponse expectedResponse =
        ListEvaluationRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationRuns(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationRunsPagedResponse pagedListResponse = client.listEvaluationRuns(parent);

    List<EvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationRunsRequest actualRequest = ((ListEvaluationRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listEvaluationRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationRunsTest2() throws Exception {
    EvaluationRun responsesElement = EvaluationRun.newBuilder().build();
    ListEvaluationRunsResponse expectedResponse =
        ListEvaluationRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationRuns(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationRunsPagedResponse pagedListResponse = client.listEvaluationRuns(parent);

    List<EvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationRunsRequest actualRequest = ((ListEvaluationRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvaluationRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationExpectationsTest() throws Exception {
    EvaluationExpectation responsesElement = EvaluationExpectation.newBuilder().build();
    ListEvaluationExpectationsResponse expectedResponse =
        ListEvaluationExpectationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationExpectations(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationExpectationsPagedResponse pagedListResponse =
        client.listEvaluationExpectations(parent);

    List<EvaluationExpectation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationExpectationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationExpectationsRequest actualRequest =
        ((ListEvaluationExpectationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationExpectationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listEvaluationExpectations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationExpectationsTest2() throws Exception {
    EvaluationExpectation responsesElement = EvaluationExpectation.newBuilder().build();
    ListEvaluationExpectationsResponse expectedResponse =
        ListEvaluationExpectationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationExpectations(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationExpectationsPagedResponse pagedListResponse =
        client.listEvaluationExpectations(parent);

    List<EvaluationExpectation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationExpectationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationExpectationsRequest actualRequest =
        ((ListEvaluationExpectationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationExpectationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvaluationExpectations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationExpectationTest() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationExpectationName name =
        EvaluationExpectationName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");

    EvaluationExpectation actualResponse = client.getEvaluationExpectation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationExpectationRequest actualRequest =
        ((GetEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExpectationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationExpectationName name =
          EvaluationExpectationName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");
      client.getEvaluationExpectation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationExpectationTest2() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    EvaluationExpectation actualResponse = client.getEvaluationExpectation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationExpectationRequest actualRequest =
        ((GetEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExpectationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluationExpectation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationExpectationTest() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationExpectationRequest actualRequest =
        ((CreateEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluationExpectation, actualRequest.getEvaluationExpectation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExpectationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
      client.createEvaluationExpectation(parent, evaluationExpectation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationExpectationTest2() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationExpectationRequest actualRequest =
        ((CreateEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluationExpectation, actualRequest.getEvaluationExpectation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExpectationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
      client.createEvaluationExpectation(parent, evaluationExpectation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationExpectationTest3() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
    String evaluationExpectationId = "evaluationExpectationId-31829349";

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationExpectationRequest actualRequest =
        ((CreateEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(evaluationExpectation, actualRequest.getEvaluationExpectation());
    Assert.assertEquals(evaluationExpectationId, actualRequest.getEvaluationExpectationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExpectationExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
      String evaluationExpectationId = "evaluationExpectationId-31829349";
      client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationExpectationTest4() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
    String evaluationExpectationId = "evaluationExpectationId-31829349";

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationExpectationRequest actualRequest =
        ((CreateEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(evaluationExpectation, actualRequest.getEvaluationExpectation());
    Assert.assertEquals(evaluationExpectationId, actualRequest.getEvaluationExpectationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationExpectationExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
      String evaluationExpectationId = "evaluationExpectationId-31829349";
      client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEvaluationExpectationTest() throws Exception {
    EvaluationExpectation expectedResponse =
        EvaluationExpectation.newBuilder()
            .setName(
                EvaluationExpectationName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.updateEvaluationExpectation(evaluationExpectation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEvaluationExpectationRequest actualRequest =
        ((UpdateEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(evaluationExpectation, actualRequest.getEvaluationExpectation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEvaluationExpectationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluationExpectation(evaluationExpectation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationExpectationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationExpectationName name =
        EvaluationExpectationName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");

    client.deleteEvaluationExpectation(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationExpectationRequest actualRequest =
        ((DeleteEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationExpectationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      EvaluationExpectationName name =
          EvaluationExpectationName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");
      client.deleteEvaluationExpectation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationExpectationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvaluationExpectation(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationExpectationRequest actualRequest =
        ((DeleteEvaluationExpectationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationExpectationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationExpectation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScheduledEvaluationRunTest() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduledEvaluationRunRequest actualRequest =
        ((CreateScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(scheduledEvaluationRun, actualRequest.getScheduledEvaluationRun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
      client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScheduledEvaluationRunTest2() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduledEvaluationRunRequest actualRequest =
        ((CreateScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(scheduledEvaluationRun, actualRequest.getScheduledEvaluationRun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
      client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScheduledEvaluationRunTest3() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
    String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(
            parent, scheduledEvaluationRun, scheduledEvaluationRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduledEvaluationRunRequest actualRequest =
        ((CreateScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(scheduledEvaluationRun, actualRequest.getScheduledEvaluationRun());
    Assert.assertEquals(scheduledEvaluationRunId, actualRequest.getScheduledEvaluationRunId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
      String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";
      client.createScheduledEvaluationRun(parent, scheduledEvaluationRun, scheduledEvaluationRunId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScheduledEvaluationRunTest4() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
    String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(
            parent, scheduledEvaluationRun, scheduledEvaluationRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScheduledEvaluationRunRequest actualRequest =
        ((CreateScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(scheduledEvaluationRun, actualRequest.getScheduledEvaluationRun());
    Assert.assertEquals(scheduledEvaluationRunId, actualRequest.getScheduledEvaluationRunId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
      String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";
      client.createScheduledEvaluationRun(parent, scheduledEvaluationRun, scheduledEvaluationRunId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScheduledEvaluationRunTest() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    ScheduledEvaluationRunName name =
        ScheduledEvaluationRunName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");

    ScheduledEvaluationRun actualResponse = client.getScheduledEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScheduledEvaluationRunRequest actualRequest =
        ((GetScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScheduledEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      ScheduledEvaluationRunName name =
          ScheduledEvaluationRunName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");
      client.getScheduledEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScheduledEvaluationRunTest2() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    ScheduledEvaluationRun actualResponse = client.getScheduledEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScheduledEvaluationRunRequest actualRequest =
        ((GetScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScheduledEvaluationRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.getScheduledEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScheduledEvaluationRunsTest() throws Exception {
    ScheduledEvaluationRun responsesElement = ScheduledEvaluationRun.newBuilder().build();
    ListScheduledEvaluationRunsResponse expectedResponse =
        ListScheduledEvaluationRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScheduledEvaluationRuns(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListScheduledEvaluationRunsPagedResponse pagedListResponse =
        client.listScheduledEvaluationRuns(parent);

    List<ScheduledEvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScheduledEvaluationRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScheduledEvaluationRunsRequest actualRequest =
        ((ListScheduledEvaluationRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScheduledEvaluationRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listScheduledEvaluationRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScheduledEvaluationRunsTest2() throws Exception {
    ScheduledEvaluationRun responsesElement = ScheduledEvaluationRun.newBuilder().build();
    ListScheduledEvaluationRunsResponse expectedResponse =
        ListScheduledEvaluationRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScheduledEvaluationRuns(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListScheduledEvaluationRunsPagedResponse pagedListResponse =
        client.listScheduledEvaluationRuns(parent);

    List<ScheduledEvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScheduledEvaluationRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScheduledEvaluationRunsRequest actualRequest =
        ((ListScheduledEvaluationRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScheduledEvaluationRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listScheduledEvaluationRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateScheduledEvaluationRunTest() throws Exception {
    ScheduledEvaluationRun expectedResponse =
        ScheduledEvaluationRun.newBuilder()
            .setName(
                ScheduledEvaluationRunName.of(
                        "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRequest(RunEvaluationRequest.newBuilder().build())
            .setDescription("description-1724546052")
            .setSchedulingConfig(ScheduledEvaluationRun.SchedulingConfig.newBuilder().build())
            .setActive(true)
            .setLastCompletedRun(
                EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
                    .toString())
            .setTotalExecutions(-2074550218)
            .setNextScheduledExecutionTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdatedBy("lastUpdatedBy551402620")
            .setEtag("etag3123477")
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.updateScheduledEvaluationRun(scheduledEvaluationRun, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScheduledEvaluationRunRequest actualRequest =
        ((UpdateScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(scheduledEvaluationRun, actualRequest.getScheduledEvaluationRun());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateScheduledEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScheduledEvaluationRun(scheduledEvaluationRun, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScheduledEvaluationRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    ScheduledEvaluationRunName name =
        ScheduledEvaluationRunName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");

    client.deleteScheduledEvaluationRun(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScheduledEvaluationRunRequest actualRequest =
        ((DeleteScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScheduledEvaluationRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      ScheduledEvaluationRunName name =
          ScheduledEvaluationRunName.of(
              "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");
      client.deleteScheduledEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScheduledEvaluationRunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEvaluationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteScheduledEvaluationRun(name);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScheduledEvaluationRunRequest actualRequest =
        ((DeleteScheduledEvaluationRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScheduledEvaluationRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteScheduledEvaluationRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testPersonaVoiceTest() throws Exception {
    TestPersonaVoiceResponse expectedResponse =
        TestPersonaVoiceResponse.newBuilder().setAudio(ByteString.EMPTY).build();
    mockEvaluationService.addResponse(expectedResponse);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    TestPersonaVoiceResponse actualResponse = client.testPersonaVoice(app);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestPersonaVoiceRequest actualRequest = ((TestPersonaVoiceRequest) actualRequests.get(0));

    Assert.assertEquals(app.toString(), actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testPersonaVoiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.testPersonaVoice(app);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testPersonaVoiceTest2() throws Exception {
    TestPersonaVoiceResponse expectedResponse =
        TestPersonaVoiceResponse.newBuilder().setAudio(ByteString.EMPTY).build();
    mockEvaluationService.addResponse(expectedResponse);

    String app = "app96801";

    TestPersonaVoiceResponse actualResponse = client.testPersonaVoice(app);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestPersonaVoiceRequest actualRequest = ((TestPersonaVoiceRequest) actualRequests.get(0));

    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testPersonaVoiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEvaluationService.addException(exception);

    try {
      String app = "app96801";
      client.testPersonaVoice(app);
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
}
