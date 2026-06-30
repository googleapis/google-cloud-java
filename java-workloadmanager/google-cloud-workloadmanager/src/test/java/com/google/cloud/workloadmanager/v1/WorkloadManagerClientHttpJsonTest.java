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

package com.google.cloud.workloadmanager.v1;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.stub.HttpJsonWorkloadManagerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class WorkloadManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WorkloadManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWorkloadManagerStub.getMethodDescriptors(),
            WorkloadManagerSettings.getDefaultEndpoint());
    WorkloadManagerSettings settings =
        WorkloadManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WorkloadManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkloadManagerClient.create(settings);
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
  public void getEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
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
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
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
  public void createEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
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
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse =
        client.createEvaluationAsync(parent, evaluation, evaluationId).get();
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
      String evaluationId = "evaluationId407318903";
      client.createEvaluationAsync(parent, evaluation, evaluationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
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
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse =
        client.createEvaluationAsync(parent, evaluation, evaluationId).get();
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
      String evaluationId = "evaluationId407318903";
      client.createEvaluationAsync(parent, evaluation, evaluationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Evaluation evaluation =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
            .setDescription("description-1724546052")
            .setResourceFilter(ResourceFilter.newBuilder().build())
            .addAllRuleNames(new ArrayList<String>())
            .setResourceStatus(ResourceStatus.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchedule("schedule-697920873")
            .setCustomRulesBucket("customRulesBucket-888019568")
            .setBigQueryDestination(BigQueryDestination.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Evaluation actualResponse = client.updateEvaluationAsync(evaluation, updateMask).get();
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
              .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
              .setDescription("description-1724546052")
              .setResourceFilter(ResourceFilter.newBuilder().build())
              .addAllRuleNames(new ArrayList<String>())
              .setResourceStatus(ResourceStatus.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setSchedule("schedule-697920873")
              .setCustomRulesBucket("customRulesBucket-888019568")
              .setBigQueryDestination(BigQueryDestination.newBuilder().build())
              .setKmsKey("kmsKey-1127483058")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluationAsync(evaluation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEvaluationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    client.deleteEvaluationAsync(name).get();

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
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      client.deleteEvaluationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEvaluationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";

    client.deleteEvaluationAsync(name).get();

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
      String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";
      client.deleteEvaluationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listExecutionsTest() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

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
  public void listExecutionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExecutionsTest2() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7212/locations/location-7212/evaluations/evaluation-7212";

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

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
  public void listExecutionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7212/locations/location-7212/evaluations/evaluation-7212";
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setInventoryTime(Timestamp.newBuilder().build())
            .setEvaluationId("evaluationId407318903")
            .putAllLabels(new HashMap<String, String>())
            .addAllRuleResults(new ArrayList<RuleExecutionResult>())
            .addAllExternalDataSources(new ArrayList<Execution.ExternalDataSources>())
            .addAllNotices(new ArrayList<Execution.Notice>())
            .setResultSummary(Execution.Summary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
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
  public void getExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName name =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setInventoryTime(Timestamp.newBuilder().build())
            .setEvaluationId("evaluationId407318903")
            .putAllLabels(new HashMap<String, String>())
            .addAllRuleResults(new ArrayList<RuleExecutionResult>())
            .addAllExternalDataSources(new ArrayList<Execution.ExternalDataSources>())
            .addAllNotices(new ArrayList<Execution.Notice>())
            .setResultSummary(Execution.Summary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1480/locations/location-1480/evaluations/evaluation-1480/executions/execution-1480";

    Execution actualResponse = client.getExecution(name);
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
  public void getExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1480/locations/location-1480/evaluations/evaluation-1480/executions/execution-1480";
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runEvaluationTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setInventoryTime(Timestamp.newBuilder().build())
            .setEvaluationId("evaluationId407318903")
            .putAllLabels(new HashMap<String, String>())
            .addAllRuleResults(new ArrayList<RuleExecutionResult>())
            .addAllExternalDataSources(new ArrayList<Execution.ExternalDataSources>())
            .addAllNotices(new ArrayList<Execution.Notice>())
            .setResultSummary(Execution.Summary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.runEvaluationAsync(name, execution, executionId).get();
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
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.runEvaluationAsync(name, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void runEvaluationTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setInventoryTime(Timestamp.newBuilder().build())
            .setEvaluationId("evaluationId407318903")
            .putAllLabels(new HashMap<String, String>())
            .addAllRuleResults(new ArrayList<RuleExecutionResult>())
            .addAllExternalDataSources(new ArrayList<Execution.ExternalDataSources>())
            .addAllNotices(new ArrayList<Execution.Notice>())
            .setResultSummary(Execution.Summary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.runEvaluationAsync(name, execution, executionId).get();
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
      String name = "projects/project-9235/locations/location-9235/evaluations/evaluation-9235";
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.runEvaluationAsync(name, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteExecutionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");

    client.deleteExecutionAsync(name).get();

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
  public void deleteExecutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecutionName name =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteExecutionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1480/locations/location-1480/evaluations/evaluation-1480/executions/execution-1480";

    client.deleteExecutionAsync(name).get();

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
  public void deleteExecutionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1480/locations/location-1480/evaluations/evaluation-1480/executions/execution-1480";
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listExecutionResultsTest() throws Exception {
    ExecutionResult responsesElement = ExecutionResult.newBuilder().build();
    ListExecutionResultsResponse expectedResponse =
        ListExecutionResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutionResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2009/locations/location-2009/evaluations/evaluation-2009/executions/execution-2009";

    ListExecutionResultsPagedResponse pagedListResponse = client.listExecutionResults(parent);

    List<ExecutionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionResultsList().get(0), resources.get(0));

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
  public void listExecutionResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2009/locations/location-2009/evaluations/evaluation-2009/executions/execution-2009";
      client.listExecutionResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest() throws Exception {
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder().addAllRules(new ArrayList<Rule>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRulesResponse actualResponse = client.listRules(parent);
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
  public void listRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest2() throws Exception {
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder().addAllRules(new ArrayList<Rule>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRulesResponse actualResponse = client.listRules(parent);
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
  public void listRulesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScannedResourcesTest() throws Exception {
    ScannedResource responsesElement = ScannedResource.newBuilder().build();
    ListScannedResourcesResponse expectedResponse =
        ListScannedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScannedResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2009/locations/location-2009/evaluations/evaluation-2009/executions/execution-2009";

    ListScannedResourcesPagedResponse pagedListResponse = client.listScannedResources(parent);

    List<ScannedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScannedResourcesList().get(0), resources.get(0));

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
  public void listScannedResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2009/locations/location-2009/evaluations/evaluation-2009/executions/execution-2009";
      client.listScannedResources(parent);
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
