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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.dataflow.v1beta3.stub.HttpJsonJobsV1Beta3Stub;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class JobsV1Beta3ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static JobsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonJobsV1Beta3Stub.getMethodDescriptors(),
            JobsV1Beta3Settings.getDefaultEndpoint());
    JobsV1Beta3Settings settings =
        JobsV1Beta3Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                JobsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobsV1Beta3Client.create(settings);
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
    mockService.addResponse(expectedResponse);

    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJob(Job.newBuilder().build())
            .setView(JobView.forNumber(0))
            .setReplaceJobId("replaceJobId441554788")
            .setLocation("location-9355")
            .build();

    Job actualResponse = client.createJob(request);
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
  public void createJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateJobRequest request =
          CreateJobRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJob(Job.newBuilder().build())
              .setView(JobView.forNumber(0))
              .setReplaceJobId("replaceJobId441554788")
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    GetJobRequest request =
        GetJobRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setView(JobView.forNumber(0))
            .setLocation("location-9355")
            .build();

    Job actualResponse = client.getJob(request);
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
  public void getJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetJobRequest request =
          GetJobRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setView(JobView.forNumber(0))
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    UpdateJobRequest request =
        UpdateJobRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setJob(Job.newBuilder().build())
            .setLocation("location-9355")
            .build();

    Job actualResponse = client.updateJob(request);
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
  public void updateJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateJobRequest request =
          UpdateJobRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setJob(Job.newBuilder().build())
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setView(JobView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLocation("location-9355")
            .build();

    ListJobsPagedResponse pagedListResponse = client.listJobs(request);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void listJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setView(JobView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setView(JobView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLocation("location1901043637")
            .build();

    AggregatedListJobsPagedResponse pagedListResponse = client.aggregatedListJobs(request);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void aggregatedListJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setProjectId("projectId-1530")
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
  public void checkActiveJobsUnsupportedMethodTest() throws Exception {
    // The checkActiveJobs() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
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
    mockService.addResponse(expectedResponse);

    SnapshotJobRequest request =
        SnapshotJobRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setTtl(Duration.newBuilder().build())
            .setLocation("location-9355")
            .setSnapshotSources(true)
            .setDescription("description-1724546052")
            .build();

    Snapshot actualResponse = client.snapshotJob(request);
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
  public void snapshotJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SnapshotJobRequest request =
          SnapshotJobRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setTtl(Duration.newBuilder().build())
              .setLocation("location-9355")
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
