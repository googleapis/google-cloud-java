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

package com.google.cloud.video.transcoder.v1;

import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobsPagedResponse;

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
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class TranscoderServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTranscoderService mockTranscoderService;
  private LocalChannelProvider channelProvider;
  private TranscoderServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTranscoderService = new MockTranscoderService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTranscoderService));
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
    TranscoderServiceSettings settings =
        TranscoderServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TranscoderServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setInputUri("inputUri470706498")
            .setOutputUri("outputUri-2119300949")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTtlAfterCompletionDays(107576420)
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
            .setInputUri("inputUri470706498")
            .setOutputUri("outputUri-2119300949")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTtlAfterCompletionDays(107576420)
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
    mockTranscoderService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
            .setInputUri("inputUri470706498")
            .setOutputUri("outputUri-2119300949")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTtlAfterCompletionDays(107576420)
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
            .setInputUri("inputUri470706498")
            .setOutputUri("outputUri-2119300949")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTtlAfterCompletionDays(107576420)
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

    try {
      String name = "name3373707";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTranscoderService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
    mockTranscoderService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTemplateTest() throws Exception {
    JobTemplate expectedResponse =
        JobTemplate.newBuilder()
            .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
            .setConfig(JobConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    JobTemplate jobTemplate = JobTemplate.newBuilder().build();
    String jobTemplateId = "jobTemplateId-597733678";

    JobTemplate actualResponse = client.createJobTemplate(parent, jobTemplate, jobTemplateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTemplateRequest actualRequest = ((CreateJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(jobTemplate, actualRequest.getJobTemplate());
    Assert.assertEquals(jobTemplateId, actualRequest.getJobTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      JobTemplate jobTemplate = JobTemplate.newBuilder().build();
      String jobTemplateId = "jobTemplateId-597733678";
      client.createJobTemplate(parent, jobTemplate, jobTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTemplateTest2() throws Exception {
    JobTemplate expectedResponse =
        JobTemplate.newBuilder()
            .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
            .setConfig(JobConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    JobTemplate jobTemplate = JobTemplate.newBuilder().build();
    String jobTemplateId = "jobTemplateId-597733678";

    JobTemplate actualResponse = client.createJobTemplate(parent, jobTemplate, jobTemplateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTemplateRequest actualRequest = ((CreateJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(jobTemplate, actualRequest.getJobTemplate());
    Assert.assertEquals(jobTemplateId, actualRequest.getJobTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      String parent = "parent-995424086";
      JobTemplate jobTemplate = JobTemplate.newBuilder().build();
      String jobTemplateId = "jobTemplateId-597733678";
      client.createJobTemplate(parent, jobTemplate, jobTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobTemplatesTest() throws Exception {
    JobTemplate responsesElement = JobTemplate.newBuilder().build();
    ListJobTemplatesResponse expectedResponse =
        ListJobTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobTemplates(Arrays.asList(responsesElement))
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobTemplatesPagedResponse pagedListResponse = client.listJobTemplates(parent);

    List<JobTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobTemplatesRequest actualRequest = ((ListJobTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listJobTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobTemplatesTest2() throws Exception {
    JobTemplate responsesElement = JobTemplate.newBuilder().build();
    ListJobTemplatesResponse expectedResponse =
        ListJobTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobTemplates(Arrays.asList(responsesElement))
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListJobTemplatesPagedResponse pagedListResponse = client.listJobTemplates(parent);

    List<JobTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobTemplatesRequest actualRequest = ((ListJobTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listJobTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTemplateTest() throws Exception {
    JobTemplate expectedResponse =
        JobTemplate.newBuilder()
            .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
            .setConfig(JobConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

    JobTemplate actualResponse = client.getJobTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobTemplateRequest actualRequest = ((GetJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
      client.getJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTemplateTest2() throws Exception {
    JobTemplate expectedResponse =
        JobTemplate.newBuilder()
            .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
            .setConfig(JobConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    String name = "name3373707";

    JobTemplate actualResponse = client.getJobTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobTemplateRequest actualRequest = ((GetJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      String name = "name3373707";
      client.getJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTranscoderService.addResponse(expectedResponse);

    JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

    client.deleteJobTemplate(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobTemplateRequest actualRequest = ((DeleteJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
      client.deleteJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTranscoderService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteJobTemplate(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobTemplateRequest actualRequest = ((DeleteJobTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
