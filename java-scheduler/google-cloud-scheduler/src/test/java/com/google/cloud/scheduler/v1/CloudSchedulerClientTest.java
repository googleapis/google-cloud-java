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

package com.google.cloud.scheduler.v1;

import static com.google.cloud.scheduler.v1.CloudSchedulerClient.ListJobsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class CloudSchedulerClientTest {
  private static MockCloudScheduler mockCloudScheduler;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudSchedulerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudScheduler = new MockCloudScheduler();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudScheduler));
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
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest2() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String name = "name3373707";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Job job = Job.newBuilder().build();
      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String parent = "parent-995424086";
      Job job = Job.newBuilder().build();
      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    Job job = Job.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Job actualResponse = client.updateJob(job, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = ((UpdateJobRequest) actualRequests.get(0));

    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      Job job = Job.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateJob(job, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = ((DeleteJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudScheduler.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = ((DeleteJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String name = "name3373707";
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.pauseJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseJobRequest actualRequest = ((PauseJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.pauseJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.pauseJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseJobRequest actualRequest = ((PauseJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String name = "name3373707";
      client.pauseJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.resumeJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeJobRequest actualRequest = ((ResumeJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.resumeJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.resumeJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeJobRequest actualRequest = ((ResumeJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String name = "name3373707";
      client.resumeJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.runJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunJobRequest actualRequest = ((RunJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.runJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setTimeZone("timeZone-2077180903")
            .setUserUpdateTime(Timestamp.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setLastAttemptTime(Timestamp.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setAttemptDeadline(Duration.newBuilder().build())
            .build();
    mockCloudScheduler.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.runJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudScheduler.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunJobRequest actualRequest = ((RunJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudScheduler.addException(exception);

    try {
      String name = "name3373707";
      client.runJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
