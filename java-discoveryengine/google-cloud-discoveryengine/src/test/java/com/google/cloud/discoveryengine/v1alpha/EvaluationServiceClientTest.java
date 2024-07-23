/*
 * Copyright 2024 Google LLC
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
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

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
  public void listEvaluationsTest() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    ListEvaluationsResponse expectedResponse =
        ListEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
            .build();
    mockEvaluationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

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
    mockEvaluationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluationAsync(parent, evaluation).get();
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Evaluation evaluation = Evaluation.newBuilder().build();
      client.createEvaluationAsync(parent, evaluation).get();
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
    mockEvaluationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Evaluation evaluation = Evaluation.newBuilder().build();

    Evaluation actualResponse = client.createEvaluationAsync(parent, evaluation).get();
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
      client.createEvaluationAsync(parent, evaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockEvaluationService.addResponse(expectedResponse);

    EvaluationName evaluation = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(evaluation);

    List<ListEvaluationResultsResponse.EvaluationResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationResultsRequest actualRequest =
        ((ListEvaluationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(evaluation.toString(), actualRequest.getEvaluation());
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
    mockEvaluationService.addResponse(expectedResponse);

    String evaluation = "evaluation858523452";

    ListEvaluationResultsPagedResponse pagedListResponse = client.listEvaluationResults(evaluation);

    List<ListEvaluationResultsResponse.EvaluationResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEvaluationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationResultsRequest actualRequest =
        ((ListEvaluationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(evaluation, actualRequest.getEvaluation());
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
      String evaluation = "evaluation858523452";
      client.listEvaluationResults(evaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
