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
package com.google.cloud.scheduler.v1beta1;

import static com.google.cloud.scheduler.v1beta1.CloudSchedulerClient.ListJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class CloudSchedulerClientTest {
  private static MockCloudScheduler mockCloudScheduler;
  private static MockServiceHelper serviceHelper;
  private CloudSchedulerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudScheduler = new MockCloudScheduler();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockCloudScheduler));
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
    CloudSchedulerSettings settings =
        CloudSchedulerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudSchedulerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsTest() {
    String nextPageToken = "";
    Job jobsElement = Job.newBuilder().build();
    List<Job> jobs = Arrays.asList(jobsElement);
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockCloudScheduler.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = (ListJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTest() {
    JobName name2 = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = (GetJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTest() {
    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = (CreateJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Job job = Job.newBuilder().build();

      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobTest() {
    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    Job job = Job.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Job actualResponse = client.updateJob(job, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = (UpdateJobRequest) actualRequests.get(0);

    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      Job job = Job.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateJob(job, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = (DeleteJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void pauseJobTest() {
    JobName name2 = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.pauseJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseJobRequest actualRequest = (PauseJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void pauseJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

      client.pauseJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resumeJobTest() {
    JobName name2 = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.resumeJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeJobRequest actualRequest = (ResumeJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void resumeJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

      client.resumeJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void runJobTest() {
    JobName name2 = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String timeZone = "timeZone36848094";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.runJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunJobRequest actualRequest = (RunJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void runJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

      client.runJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
