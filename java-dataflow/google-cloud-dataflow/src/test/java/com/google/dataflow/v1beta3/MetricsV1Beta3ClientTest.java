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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MetricsV1Beta3ClientTest {
  private static MockMetricsV1Beta3 mockMetricsV1Beta3;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetricsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetricsV1Beta3 = new MockMetricsV1Beta3();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetricsV1Beta3));
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
    MetricsV1Beta3Settings settings =
        MetricsV1Beta3Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetricsV1Beta3Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getJobMetricsTest() throws Exception {
    JobMetrics expectedResponse =
        JobMetrics.newBuilder()
            .setMetricTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<MetricUpdate>())
            .build();
    mockMetricsV1Beta3.addResponse(expectedResponse);

    GetJobMetricsRequest request =
        GetJobMetricsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setStartTime(Timestamp.newBuilder().build())
            .setLocation("location1901043637")
            .build();

    JobMetrics actualResponse = client.getJobMetrics(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobMetricsRequest actualRequest = ((GetJobMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getStartTime(), actualRequest.getStartTime());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsV1Beta3.addException(exception);

    try {
      GetJobMetricsRequest request =
          GetJobMetricsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setStartTime(Timestamp.newBuilder().build())
              .setLocation("location1901043637")
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
    mockMetricsV1Beta3.addResponse(expectedResponse);

    GetJobExecutionDetailsRequest request =
        GetJobExecutionDetailsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setLocation("location1901043637")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    GetJobExecutionDetailsPagedResponse pagedListResponse = client.getJobExecutionDetails(request);

    List<StageSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobExecutionDetailsRequest actualRequest =
        ((GetJobExecutionDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExecutionDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsV1Beta3.addException(exception);

    try {
      GetJobExecutionDetailsRequest request =
          GetJobExecutionDetailsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setLocation("location1901043637")
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
    mockMetricsV1Beta3.addResponse(expectedResponse);

    GetStageExecutionDetailsRequest request =
        GetStageExecutionDetailsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setLocation("location1901043637")
            .setStageId("stageId-1897528135")
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

    List<AbstractMessage> actualRequests = mockMetricsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStageExecutionDetailsRequest actualRequest =
        ((GetStageExecutionDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getStageId(), actualRequest.getStageId());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getStartTime(), actualRequest.getStartTime());
    Assert.assertEquals(request.getEndTime(), actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStageExecutionDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsV1Beta3.addException(exception);

    try {
      GetStageExecutionDetailsRequest request =
          GetStageExecutionDetailsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setLocation("location1901043637")
              .setStageId("stageId-1897528135")
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
