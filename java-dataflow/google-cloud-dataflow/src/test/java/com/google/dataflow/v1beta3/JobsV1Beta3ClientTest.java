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

import static com.google.dataflow.v1beta3.JobsV1Beta3Client.AggregatedListJobsPagedResponse;
import static com.google.dataflow.v1beta3.JobsV1Beta3Client.ListJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class JobsV1Beta3ClientTest {
  private static MockJobsV1Beta3 mockJobsV1Beta3;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private JobsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockJobsV1Beta3 = new MockJobsV1Beta3();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockJobsV1Beta3));
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
    JobsV1Beta3Settings settings =
        JobsV1Beta3Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobsV1Beta3Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setName("name3373707")
            .setType(JobType.forNumber(0))
            .setEnvironment(Environment.newBuilder().build())
            .addAllSteps(new ArrayList<Step>())
            .setStepsLocation("stepsLocation1335803900")
            .setCurrentState(JobState.forNumber(0))
            .setCurrentStateTime(Timestamp.newBuilder().build())
            .setRequestedState(JobState.forNumber(0))
            .setExecutionInfo(JobExecutionInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setReplaceJobId("replaceJobId441554788")
            .putAllTransformNameMapping(new HashMap<String, String>())
            .setClientRequestId("clientRequestId848942207")
            .setReplacedByJobId("replacedByJobId614115665")
            .addAllTempFiles(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .setLocation("location1901043637")
            .setPipelineDescription(PipelineDescription.newBuilder().build())
            .addAllStageStates(new ArrayList<ExecutionStageState>())
            .setJobMetadata(JobMetadata.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setCreatedFromSnapshotId("createdFromSnapshotId851802705")
            .setSatisfiesPzs(true)
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJob(Job.newBuilder().build())
            .setView(JobView.forNumber(0))
            .setReplaceJobId("replaceJobId441554788")
            .setLocation("location1901043637")
            .build();

    Job actualResponse = client.createJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJob(), actualRequest.getJob());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getReplaceJobId(), actualRequest.getReplaceJobId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      CreateJobRequest request =
          CreateJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJob(Job.newBuilder().build())
              .setView(JobView.forNumber(0))
              .setReplaceJobId("replaceJobId441554788")
              .setLocation("location1901043637")
              .build();
      client.createJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setName("name3373707")
            .setType(JobType.forNumber(0))
            .setEnvironment(Environment.newBuilder().build())
            .addAllSteps(new ArrayList<Step>())
            .setStepsLocation("stepsLocation1335803900")
            .setCurrentState(JobState.forNumber(0))
            .setCurrentStateTime(Timestamp.newBuilder().build())
            .setRequestedState(JobState.forNumber(0))
            .setExecutionInfo(JobExecutionInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setReplaceJobId("replaceJobId441554788")
            .putAllTransformNameMapping(new HashMap<String, String>())
            .setClientRequestId("clientRequestId848942207")
            .setReplacedByJobId("replacedByJobId614115665")
            .addAllTempFiles(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .setLocation("location1901043637")
            .setPipelineDescription(PipelineDescription.newBuilder().build())
            .addAllStageStates(new ArrayList<ExecutionStageState>())
            .setJobMetadata(JobMetadata.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setCreatedFromSnapshotId("createdFromSnapshotId851802705")
            .setSatisfiesPzs(true)
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    GetJobRequest request =
        GetJobRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setView(JobView.forNumber(0))
            .setLocation("location1901043637")
            .build();

    Job actualResponse = client.getJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      GetJobRequest request =
          GetJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setView(JobView.forNumber(0))
              .setLocation("location1901043637")
              .build();
      client.getJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setName("name3373707")
            .setType(JobType.forNumber(0))
            .setEnvironment(Environment.newBuilder().build())
            .addAllSteps(new ArrayList<Step>())
            .setStepsLocation("stepsLocation1335803900")
            .setCurrentState(JobState.forNumber(0))
            .setCurrentStateTime(Timestamp.newBuilder().build())
            .setRequestedState(JobState.forNumber(0))
            .setExecutionInfo(JobExecutionInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setReplaceJobId("replaceJobId441554788")
            .putAllTransformNameMapping(new HashMap<String, String>())
            .setClientRequestId("clientRequestId848942207")
            .setReplacedByJobId("replacedByJobId614115665")
            .addAllTempFiles(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .setLocation("location1901043637")
            .setPipelineDescription(PipelineDescription.newBuilder().build())
            .addAllStageStates(new ArrayList<ExecutionStageState>())
            .setJobMetadata(JobMetadata.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setCreatedFromSnapshotId("createdFromSnapshotId851802705")
            .setSatisfiesPzs(true)
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    UpdateJobRequest request =
        UpdateJobRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setJob(Job.newBuilder().build())
            .setLocation("location1901043637")
            .build();

    Job actualResponse = client.updateJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = ((UpdateJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getJob(), actualRequest.getJob());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      UpdateJobRequest request =
          UpdateJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setJob(Job.newBuilder().build())
              .setLocation("location1901043637")
              .build();
      client.updateJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setView(JobView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLocation("location1901043637")
            .build();

    ListJobsPagedResponse pagedListResponse = client.listJobs(request);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setView(JobView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLocation("location1901043637")
              .build();
      client.listJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregatedListJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setView(JobView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLocation("location1901043637")
            .build();

    AggregatedListJobsPagedResponse pagedListResponse = client.aggregatedListJobs(request);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregatedListJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setView(JobView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLocation("location1901043637")
              .build();
      client.aggregatedListJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkActiveJobsTest() throws Exception {
    CheckActiveJobsResponse expectedResponse =
        CheckActiveJobsResponse.newBuilder().setActiveJobsExist(true).build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    CheckActiveJobsRequest request =
        CheckActiveJobsRequest.newBuilder().setProjectId("projectId-894832108").build();

    CheckActiveJobsResponse actualResponse = client.checkActiveJobs(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckActiveJobsRequest actualRequest = ((CheckActiveJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkActiveJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      CheckActiveJobsRequest request =
          CheckActiveJobsRequest.newBuilder().setProjectId("projectId-894832108").build();
      client.checkActiveJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void snapshotJobTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setSourceJobId("sourceJobId-104191395")
            .setCreationTime(Timestamp.newBuilder().build())
            .setTtl(Duration.newBuilder().build())
            .setState(SnapshotState.forNumber(0))
            .addAllPubsubMetadata(new ArrayList<PubsubSnapshotMetadata>())
            .setDescription("description-1724546052")
            .setDiskSizeBytes(-275393905)
            .setRegion("region-934795532")
            .build();
    mockJobsV1Beta3.addResponse(expectedResponse);

    SnapshotJobRequest request =
        SnapshotJobRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setTtl(Duration.newBuilder().build())
            .setLocation("location1901043637")
            .setSnapshotSources(true)
            .setDescription("description-1724546052")
            .build();

    Snapshot actualResponse = client.snapshotJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SnapshotJobRequest actualRequest = ((SnapshotJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getTtl(), actualRequest.getTtl());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getSnapshotSources(), actualRequest.getSnapshotSources());
    Assert.assertEquals(request.getDescription(), actualRequest.getDescription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void snapshotJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobsV1Beta3.addException(exception);

    try {
      SnapshotJobRequest request =
          SnapshotJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setTtl(Duration.newBuilder().build())
              .setLocation("location1901043637")
              .setSnapshotSources(true)
              .setDescription("description-1724546052")
              .build();
      client.snapshotJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
