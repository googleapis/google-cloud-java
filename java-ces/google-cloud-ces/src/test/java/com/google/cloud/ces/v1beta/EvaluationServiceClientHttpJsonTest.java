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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.ces.v1beta.stub.HttpJsonEvaluationServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EvaluationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EvaluationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEvaluationServiceStub.getMethodDescriptors(),
            EvaluationServiceSettings.getDefaultEndpoint());
    EvaluationServiceSettings settings =
        EvaluationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EvaluationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EvaluationServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(resultOperation);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    RunEvaluationResponse actualResponse = client.runEvaluationAsync(app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void runEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.runEvaluationAsync(app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String app = "projects/project-4468/locations/location-4468/apps/app-4468";

    RunEvaluationResponse actualResponse = client.runEvaluationAsync(app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void runEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String app = "projects/project-4468/locations/location-4468/apps/app-4468";
      client.runEvaluationAsync(app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ByteString audioContent = ByteString.EMPTY;

    UploadEvaluationAudioResponse actualResponse = client.uploadEvaluationAudio(app, audioContent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void uploadEvaluationAudioExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String app = "projects/project-4468/locations/location-4468/apps/app-4468";
    ByteString audioContent = ByteString.EMPTY;

    UploadEvaluationAudioResponse actualResponse = client.uploadEvaluationAudio(app, audioContent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void uploadEvaluationAudioExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String app = "projects/project-4468/locations/location-4468/apps/app-4468";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluation(parent, evaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluation(parent, evaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse = client.createEvaluation(parent, evaluation, evaluationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse = client.createEvaluation(parent, evaluation, evaluationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(resultOperation);

    ConversationName conversation =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    Evaluation actualResponse = client.generateEvaluationAsync(conversation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName conversation =
          ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
      client.generateEvaluationAsync(conversation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String conversation =
        "projects/project-154/locations/location-154/apps/app-154/conversations/conversation-154";

    Evaluation actualResponse = client.generateEvaluationAsync(conversation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversation =
          "projects/project-154/locations/location-154/apps/app-154/conversations/conversation-154";
      client.generateEvaluationAsync(conversation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ImportEvaluationsResponse actualResponse = client.importEvaluationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importEvaluationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.importEvaluationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ImportEvaluationsResponse actualResponse = client.importEvaluationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importEvaluationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
      client.importEvaluationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();

    EvaluationDataset actualResponse = client.createEvaluationDataset(parent, evaluationDataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();

    EvaluationDataset actualResponse = client.createEvaluationDataset(parent, evaluationDataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
    String evaluationDatasetId = "evaluationDatasetId1149172695";

    EvaluationDataset actualResponse =
        client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationDatasetExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
    String evaluationDatasetId = "evaluationDatasetId1149172695";

    EvaluationDataset actualResponse =
        client.createEvaluationDataset(parent, evaluationDataset, evaluationDatasetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationDatasetExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Evaluation evaluation =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Evaluation actualResponse = client.updateEvaluation(evaluation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Evaluation evaluation =
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
    mockService.addResponse(expectedResponse);

    EvaluationDataset evaluationDataset =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationDataset actualResponse =
        client.updateEvaluationDataset(evaluationDataset, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateEvaluationDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EvaluationDataset evaluationDataset =
          EvaluationDataset.newBuilder()
              .setName(
                  EvaluationDatasetName.of(
                          "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
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
    mockService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    client.deleteEvaluation(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7899/locations/location-7899/apps/app-7899/evaluations/evaluation-7899";

    client.deleteEvaluation(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7899/locations/location-7899/apps/app-7899/evaluations/evaluation-7899";
      client.deleteEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EvaluationResultName name =
        EvaluationResultName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");

    client.deleteEvaluationResult(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7815/locations/location-7815/apps/app-7815/evaluations/evaluation-7815/results/result-7815";

    client.deleteEvaluationResult(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7815/locations/location-7815/apps/app-7815/evaluations/evaluation-7815/results/result-7815";
      client.deleteEvaluationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EvaluationDatasetName name =
        EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");

    client.deleteEvaluationDataset(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7921/locations/location-7921/apps/app-7921/evaluationDatasets/evaluationDataset-7921";

    client.deleteEvaluationDataset(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7921/locations/location-7921/apps/app-7921/evaluationDatasets/evaluationDataset-7921";
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
    mockService.addResponse(resultOperation);

    EvaluationRunName name =
        EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");

    client.deleteEvaluationRunAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EvaluationRunName name =
          EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");
      client.deleteEvaluationRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1332/locations/location-1332/apps/app-1332/evaluationRuns/evaluationRun-1332";

    client.deleteEvaluationRunAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1332/locations/location-1332/apps/app-1332/evaluationRuns/evaluationRun-1332";
      client.deleteEvaluationRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7899/locations/location-7899/apps/app-7899/evaluations/evaluation-7899";

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7899/locations/location-7899/apps/app-7899/evaluations/evaluation-7899";
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
    mockService.addResponse(expectedResponse);

    EvaluationResultName name =
        EvaluationResultName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");

    EvaluationResult actualResponse = client.getEvaluationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7815/locations/location-7815/apps/app-7815/evaluations/evaluation-7815/results/result-7815";

    EvaluationResult actualResponse = client.getEvaluationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7815/locations/location-7815/apps/app-7815/evaluations/evaluation-7815/results/result-7815";
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
    mockService.addResponse(expectedResponse);

    EvaluationDatasetName name =
        EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");

    EvaluationDataset actualResponse = client.getEvaluationDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7921/locations/location-7921/apps/app-7921/evaluationDatasets/evaluationDataset-7921";

    EvaluationDataset actualResponse = client.getEvaluationDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7921/locations/location-7921/apps/app-7921/evaluationDatasets/evaluationDataset-7921";
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
    mockService.addResponse(expectedResponse);

    EvaluationRunName name =
        EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");

    EvaluationRun actualResponse = client.getEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1332/locations/location-1332/apps/app-1332/evaluationRuns/evaluationRun-1332";

    EvaluationRun actualResponse = client.getEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1332/locations/location-1332/apps/app-1332/evaluationRuns/evaluationRun-1332";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(parent);

    List<EvaluationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1142/locations/location-1142/apps/app-1142/evaluations/evaluation-1142";

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(parent);

    List<EvaluationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1142/locations/location-1142/apps/app-1142/evaluations/evaluation-1142";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationDatasetsPagedResponse pagedListResponse = client.listEvaluationDatasets(parent);

    List<EvaluationDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationDatasetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationDatasetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListEvaluationDatasetsPagedResponse pagedListResponse = client.listEvaluationDatasets(parent);

    List<EvaluationDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationDatasetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationDatasetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationRunsPagedResponse pagedListResponse = client.listEvaluationRuns(parent);

    List<EvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationRunsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListEvaluationRunsPagedResponse pagedListResponse = client.listEvaluationRuns(parent);

    List<EvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationRunsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListEvaluationExpectationsPagedResponse pagedListResponse =
        client.listEvaluationExpectations(parent);

    List<EvaluationExpectation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationExpectationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationExpectationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListEvaluationExpectationsPagedResponse pagedListResponse =
        client.listEvaluationExpectations(parent);

    List<EvaluationExpectation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationExpectationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEvaluationExpectationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    EvaluationExpectationName name =
        EvaluationExpectationName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");

    EvaluationExpectation actualResponse = client.getEvaluationExpectation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationExpectationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5483/locations/location-5483/apps/app-5483/evaluationExpectations/evaluationExpectation-5483";

    EvaluationExpectation actualResponse = client.getEvaluationExpectation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEvaluationExpectationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5483/locations/location-5483/apps/app-5483/evaluationExpectations/evaluationExpectation-5483";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExpectationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExpectationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
    String evaluationExpectationId = "evaluationExpectationId-31829349";

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExpectationExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
    String evaluationExpectationId = "evaluationExpectationId-31829349";

    EvaluationExpectation actualResponse =
        client.createEvaluationExpectation(parent, evaluationExpectation, evaluationExpectationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEvaluationExpectationExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    EvaluationExpectation evaluationExpectation =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationExpectation actualResponse =
        client.updateEvaluationExpectation(evaluationExpectation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateEvaluationExpectationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EvaluationExpectation evaluationExpectation =
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
    mockService.addResponse(expectedResponse);

    EvaluationExpectationName name =
        EvaluationExpectationName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");

    client.deleteEvaluationExpectation(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationExpectationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5483/locations/location-5483/apps/app-5483/evaluationExpectations/evaluationExpectation-5483";

    client.deleteEvaluationExpectation(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEvaluationExpectationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5483/locations/location-5483/apps/app-5483/evaluationExpectations/evaluationExpectation-5483";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
    String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(
            parent, scheduledEvaluationRun, scheduledEvaluationRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
    String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";

    ScheduledEvaluationRun actualResponse =
        client.createScheduledEvaluationRun(
            parent, scheduledEvaluationRun, scheduledEvaluationRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createScheduledEvaluationRunExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ScheduledEvaluationRunName name =
        ScheduledEvaluationRunName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");

    ScheduledEvaluationRun actualResponse = client.getScheduledEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getScheduledEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4271/locations/location-4271/apps/app-4271/scheduledEvaluationRuns/scheduledEvaluationRun-4271";

    ScheduledEvaluationRun actualResponse = client.getScheduledEvaluationRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getScheduledEvaluationRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4271/locations/location-4271/apps/app-4271/scheduledEvaluationRuns/scheduledEvaluationRun-4271";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListScheduledEvaluationRunsPagedResponse pagedListResponse =
        client.listScheduledEvaluationRuns(parent);

    List<ScheduledEvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScheduledEvaluationRunsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listScheduledEvaluationRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListScheduledEvaluationRunsPagedResponse pagedListResponse =
        client.listScheduledEvaluationRuns(parent);

    List<ScheduledEvaluationRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScheduledEvaluationRunsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listScheduledEvaluationRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ScheduledEvaluationRun scheduledEvaluationRun =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    ScheduledEvaluationRun actualResponse =
        client.updateScheduledEvaluationRun(scheduledEvaluationRun, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateScheduledEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScheduledEvaluationRun scheduledEvaluationRun =
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
    mockService.addResponse(expectedResponse);

    ScheduledEvaluationRunName name =
        ScheduledEvaluationRunName.of(
            "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");

    client.deleteScheduledEvaluationRun(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteScheduledEvaluationRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4271/locations/location-4271/apps/app-4271/scheduledEvaluationRuns/scheduledEvaluationRun-4271";

    client.deleteScheduledEvaluationRun(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteScheduledEvaluationRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4271/locations/location-4271/apps/app-4271/scheduledEvaluationRuns/scheduledEvaluationRun-4271";
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
    mockService.addResponse(expectedResponse);

    AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    TestPersonaVoiceResponse actualResponse = client.testPersonaVoice(app);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testPersonaVoiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String app = "projects/project-4468/locations/location-4468/apps/app-4468";

    TestPersonaVoiceResponse actualResponse = client.testPersonaVoice(app);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testPersonaVoiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String app = "projects/project-4468/locations/location-4468/apps/app-4468";
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
