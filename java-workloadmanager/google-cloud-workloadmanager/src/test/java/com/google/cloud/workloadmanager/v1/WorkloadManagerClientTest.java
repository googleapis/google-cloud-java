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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class WorkloadManagerClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockWorkloadManager mockWorkloadManager;
  private LocalChannelProvider channelProvider;
  private WorkloadManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkloadManager = new MockWorkloadManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWorkloadManager, mockLocations));
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
    WorkloadManagerSettings settings =
        WorkloadManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkloadManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEvaluationsTest() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    ListEvaluationsResponse expectedResponse =
        ListEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
            .build();
    mockWorkloadManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

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
    mockWorkloadManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEvaluationsPagedResponse pagedListResponse = client.listEvaluations(parent);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkloadManager.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

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
    mockWorkloadManager.addResponse(expectedResponse);

    String name = "name3373707";

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkloadManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse =
        client.createEvaluationAsync(parent, evaluation, evaluationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
  public void createEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Evaluation evaluation = Evaluation.newBuilder().build();
      String evaluationId = "evaluationId407318903";
      client.createEvaluationAsync(parent, evaluation, evaluationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Evaluation evaluation = Evaluation.newBuilder().build();
    String evaluationId = "evaluationId407318903";

    Evaluation actualResponse =
        client.createEvaluationAsync(parent, evaluation, evaluationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
  public void createEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Evaluation evaluation = Evaluation.newBuilder().build();
      String evaluationId = "evaluationId407318903";
      client.createEvaluationAsync(parent, evaluation, evaluationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    Evaluation evaluation = Evaluation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Evaluation actualResponse = client.updateEvaluationAsync(evaluation, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

    try {
      Evaluation evaluation = Evaluation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluationAsync(evaluation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    client.deleteEvaluationAsync(name).get();

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      client.deleteEvaluationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEvaluationAsync(name).get();

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
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
    mockWorkloadManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

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
    mockWorkloadManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkloadManager.addResponse(expectedResponse);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

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
    mockWorkloadManager.addResponse(expectedResponse);

    String name = "name3373707";

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkloadManager.addResponse(resultOperation);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.runEvaluationAsync(name, execution, executionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunEvaluationRequest actualRequest = ((RunEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.runEvaluationAsync(name, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    String name = "name3373707";
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.runEvaluationAsync(name, execution, executionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunEvaluationRequest actualRequest = ((RunEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String name = "name3373707";
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.runEvaluationAsync(name, execution, executionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      ExecutionName name =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkloadManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExecutionResultsPagedResponse pagedListResponse = client.listExecutionResults(parent);

    List<ExecutionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionResultsRequest actualRequest =
        ((ListExecutionResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkloadManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRulesResponse actualResponse = client.listRules(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

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
    mockWorkloadManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRulesResponse actualResponse = client.listRules(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkloadManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListScannedResourcesPagedResponse pagedListResponse = client.listScannedResources(parent);

    List<ScannedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScannedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkloadManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScannedResourcesRequest actualRequest =
        ((ListScannedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScannedResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkloadManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
