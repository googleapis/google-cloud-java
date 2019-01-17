/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.JobControllerClient.ListJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class JobControllerClientTest {
  private static MockClusterController mockClusterController;
  private static MockJobController mockJobController;
  private static MockWorkflowTemplateService mockWorkflowTemplateService;
  private static MockServiceHelper serviceHelper;
  private JobControllerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterController = new MockClusterController();
    mockJobController = new MockJobController();
    mockWorkflowTemplateService = new MockWorkflowTemplateService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockClusterController, mockJobController, mockWorkflowTemplateService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    JobControllerSettings settings =
        JobControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void submitJobTest() {
    String driverOutputResourceUri = "driverOutputResourceUri-542229086";
    String driverControlFilesUri = "driverControlFilesUri207057643";
    String jobUuid = "jobUuid-1615012099";
    Job expectedResponse =
        Job.newBuilder()
            .setDriverOutputResourceUri(driverOutputResourceUri)
            .setDriverControlFilesUri(driverControlFilesUri)
            .setJobUuid(jobUuid)
            .build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.submitJob(projectId, region, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitJobRequest actualRequest = (SubmitJobRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void submitJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      Job job = Job.newBuilder().build();

      client.submitJob(projectId, region, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTest() {
    String driverOutputResourceUri = "driverOutputResourceUri-542229086";
    String driverControlFilesUri = "driverControlFilesUri207057643";
    String jobUuid = "jobUuid-1615012099";
    Job expectedResponse =
        Job.newBuilder()
            .setDriverOutputResourceUri(driverOutputResourceUri)
            .setDriverControlFilesUri(driverControlFilesUri)
            .setJobUuid(jobUuid)
            .build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String jobId = "jobId-1154752291";

    Job actualResponse = client.getJob(projectId, region, jobId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = (GetJobRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(jobId, actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String jobId = "jobId-1154752291";

      client.getJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsTest() {
    String nextPageToken = "";
    Job jobsElement = Job.newBuilder().build();
    List<Job> jobs = Arrays.asList(jobsElement);
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";

    ListJobsPagedResponse pagedListResponse = client.listJobs(projectId, region);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = (ListJobsRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";

      client.listJobs(projectId, region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsTest2() {
    String nextPageToken = "";
    Job jobsElement = Job.newBuilder().build();
    List<Job> jobs = Arrays.asList(jobsElement);
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(projectId, region, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = (ListJobsRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String filter = "filter-1274492040";

      client.listJobs(projectId, region, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelJobTest() {
    String driverOutputResourceUri = "driverOutputResourceUri-542229086";
    String driverControlFilesUri = "driverControlFilesUri207057643";
    String jobUuid = "jobUuid-1615012099";
    Job expectedResponse =
        Job.newBuilder()
            .setDriverOutputResourceUri(driverOutputResourceUri)
            .setDriverControlFilesUri(driverControlFilesUri)
            .setJobUuid(jobUuid)
            .build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String jobId = "jobId-1154752291";

    Job actualResponse = client.cancelJob(projectId, region, jobId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelJobRequest actualRequest = (CancelJobRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(jobId, actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String jobId = "jobId-1154752291";

      client.cancelJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String jobId = "jobId-1154752291";

    client.deleteJob(projectId, region, jobId);

    List<GeneratedMessageV3> actualRequests = mockJobController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = (DeleteJobRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(jobId, actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockJobController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String jobId = "jobId-1154752291";

      client.deleteJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
