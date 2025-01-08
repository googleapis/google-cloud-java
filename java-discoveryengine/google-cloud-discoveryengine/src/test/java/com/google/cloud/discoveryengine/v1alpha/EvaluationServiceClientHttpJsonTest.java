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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonEvaluationServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
  public void getEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setEvaluationSpec(Evaluation.EvaluationSpec.newBuilder().build())
            .setQualityMetrics(QualityMetrics.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

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
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
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
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setEvaluationSpec(Evaluation.EvaluationSpec.newBuilder().build())
            .setQualityMetrics(QualityMetrics.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";

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
      String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";
      client.getEvaluation(name);
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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

    String parent = "projects/project-5833/locations/location-5833";

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
      String parent = "projects/project-5833/locations/location-5833";
      client.listEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setEvaluationSpec(Evaluation.EvaluationSpec.newBuilder().build())
            .setQualityMetrics(QualityMetrics.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluationAsync(parent, evaluation).get();
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Evaluation evaluation = Evaluation.newBuilder().build();
      client.createEvaluationAsync(parent, evaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setEvaluationSpec(Evaluation.EvaluationSpec.newBuilder().build())
            .setQualityMetrics(QualityMetrics.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluationAsync(parent, evaluation).get();
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
      String parent = "projects/project-5833/locations/location-5833";
      Evaluation evaluation = Evaluation.newBuilder().build();
      client.createEvaluationAsync(parent, evaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEvaluationResultsTest() throws Exception {
    ListEvaluationResultsResponse.EvaluationResult responsesElement =
        ListEvaluationResultsResponse.EvaluationResult.newBuilder().build();
    ListEvaluationResultsResponse expectedResponse =
        ListEvaluationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EvaluationName evaluation = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(evaluation);

    List<ListEvaluationResultsResponse.EvaluationResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

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
      EvaluationName evaluation = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      client.listEvaluationResults(evaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationResultsTest2() throws Exception {
    ListEvaluationResultsResponse.EvaluationResult responsesElement =
        ListEvaluationResultsResponse.EvaluationResult.newBuilder().build();
    ListEvaluationResultsResponse expectedResponse =
        ListEvaluationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String evaluation = "projects/project-7058/locations/location-7058/evaluations/evaluation-7058";

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(evaluation);

    List<ListEvaluationResultsResponse.EvaluationResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

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
      String evaluation =
          "projects/project-7058/locations/location-7058/evaluations/evaluation-7058";
      client.listEvaluationResults(evaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
