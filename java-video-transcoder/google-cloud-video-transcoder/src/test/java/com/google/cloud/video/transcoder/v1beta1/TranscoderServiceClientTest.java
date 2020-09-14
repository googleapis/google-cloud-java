/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.video.transcoder.v1beta1;

import static com.google.cloud.video.transcoder.v1beta1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1beta1.TranscoderServiceClient.ListJobsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TranscoderServiceClientTest {
  private static MockTranscoderService mockTranscoderService;
  private static MockServiceHelper serviceHelper;
  private TranscoderServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTranscoderService = new MockTranscoderService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTranscoderService));
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
  @SuppressWarnings("all")
  public void createJobTest() {
    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
    String inputUri = "inputUri1707300727";
    String outputUri = "outputUri-1273518802";
    String templateId = "templateId1769642752";
    int priority = 1165461084;
    String failureReason = "failureReason1743941273";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name.toString())
            .setInputUri(inputUri)
            .setOutputUri(outputUri)
            .setTemplateId(templateId)
            .setPriority(priority)
            .setFailureReason(failureReason)
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
  public void listJobsTest() {
    String nextPageToken = "";
    Job jobsElement = Job.newBuilder().build();
    List<Job> jobs = Arrays.asList(jobsElement);
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
    String inputUri = "inputUri1707300727";
    String outputUri = "outputUri-1273518802";
    String templateId = "templateId1769642752";
    int priority = 1165461084;
    String failureReason = "failureReason1743941273";
    Job expectedResponse =
        Job.newBuilder()
            .setName(name2.toString())
            .setInputUri(inputUri)
            .setOutputUri(outputUri)
            .setTemplateId(templateId)
            .setPriority(priority)
            .setFailureReason(failureReason)
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
  public void deleteJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTranscoderService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
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
    mockTranscoderService.addException(exception);

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
  public void createJobTemplateTest() {
    JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
    JobTemplate expectedResponse = JobTemplate.newBuilder().setName(name.toString()).build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    JobTemplate jobTemplate = JobTemplate.newBuilder().build();
    String jobTemplateId = "jobTemplateId-1231822466";

    JobTemplate actualResponse = client.createJobTemplate(parent, jobTemplate, jobTemplateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTemplateRequest actualRequest = (CreateJobTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(jobTemplate, actualRequest.getJobTemplate());
    Assert.assertEquals(jobTemplateId, actualRequest.getJobTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      JobTemplate jobTemplate = JobTemplate.newBuilder().build();
      String jobTemplateId = "jobTemplateId-1231822466";

      client.createJobTemplate(parent, jobTemplate, jobTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listJobTemplatesTest() {
    String nextPageToken = "";
    JobTemplate jobTemplatesElement = JobTemplate.newBuilder().build();
    List<JobTemplate> jobTemplates = Arrays.asList(jobTemplatesElement);
    ListJobTemplatesResponse expectedResponse =
        ListJobTemplatesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllJobTemplates(jobTemplates)
            .build();
    mockTranscoderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobTemplatesPagedResponse pagedListResponse = client.listJobTemplates(parent);

    List<JobTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobTemplatesRequest actualRequest = (ListJobTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listJobTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTemplateTest() {
    JobTemplateName name2 = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
    JobTemplate expectedResponse = JobTemplate.newBuilder().setName(name2.toString()).build();
    mockTranscoderService.addResponse(expectedResponse);

    JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

    JobTemplate actualResponse = client.getJobTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobTemplateRequest actualRequest = (GetJobTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

      client.getJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTemplateTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTranscoderService.addResponse(expectedResponse);

    JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

    client.deleteJobTemplate(name);

    List<AbstractMessage> actualRequests = mockTranscoderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobTemplateRequest actualRequest = (DeleteJobTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranscoderService.addException(exception);

    try {
      JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");

      client.deleteJobTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
