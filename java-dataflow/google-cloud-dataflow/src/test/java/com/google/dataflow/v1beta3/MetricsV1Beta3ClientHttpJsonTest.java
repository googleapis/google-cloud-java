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

package com.google.dataflow.v1beta3;

import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetJobExecutionDetailsPagedResponse;
import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetStageExecutionDetailsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.dataflow.v1beta3.stub.HttpJsonMetricsV1Beta3Stub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MetricsV1Beta3ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MetricsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMetricsV1Beta3Stub.getMethodDescriptors(),
            MetricsV1Beta3Settings.getDefaultEndpoint());
    MetricsV1Beta3Settings settings =
        MetricsV1Beta3Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MetricsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetricsV1Beta3Client.create(settings);
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
  public void getJobMetricsTest() throws Exception {
    JobMetrics expectedResponse =
        JobMetrics.newBuilder()
            .setMetricTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<MetricUpdate>())
            .build();
    mockService.addResponse(expectedResponse);

    GetJobMetricsRequest request =
        GetJobMetricsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setStartTime(Timestamp.newBuilder().build())
            .setLocation("location-9355")
            .build();

    JobMetrics actualResponse = client.getJobMetrics(request);
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
  public void getJobMetricsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetJobMetricsRequest request =
          GetJobMetricsRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setStartTime(Timestamp.newBuilder().build())
              .setLocation("location-9355")
              .build();
      client.getJobMetrics(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobExecutionDetailsTest() throws Exception {
    StageSummary responsesElement = StageSummary.newBuilder().build();
    JobExecutionDetails expectedResponse =
        JobExecutionDetails.newBuilder()
            .setNextPageToken("")
            .addAllStages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    GetJobExecutionDetailsRequest request =
        GetJobExecutionDetailsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setLocation("location-9355")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    GetJobExecutionDetailsPagedResponse pagedListResponse = client.getJobExecutionDetails(request);

    List<StageSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStagesList().get(0), resources.get(0));

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
  public void getJobExecutionDetailsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetJobExecutionDetailsRequest request =
          GetJobExecutionDetailsRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setLocation("location-9355")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.getJobExecutionDetails(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStageExecutionDetailsTest() throws Exception {
    WorkerDetails responsesElement = WorkerDetails.newBuilder().build();
    StageExecutionDetails expectedResponse =
        StageExecutionDetails.newBuilder()
            .setNextPageToken("")
            .addAllWorkers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    GetStageExecutionDetailsRequest request =
        GetStageExecutionDetailsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setLocation("location-9355")
            .setStageId("stageId-1")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();

    GetStageExecutionDetailsPagedResponse pagedListResponse =
        client.getStageExecutionDetails(request);

    List<WorkerDetails> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkersList().get(0), resources.get(0));

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
  public void getStageExecutionDetailsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetStageExecutionDetailsRequest request =
          GetStageExecutionDetailsRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setLocation("location-9355")
              .setStageId("stageId-1")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .build();
      client.getStageExecutionDetails(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
