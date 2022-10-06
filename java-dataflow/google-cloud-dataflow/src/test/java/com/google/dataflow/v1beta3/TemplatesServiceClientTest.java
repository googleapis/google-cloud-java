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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class TemplatesServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTemplatesService mockTemplatesService;
  private LocalChannelProvider channelProvider;
  private TemplatesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTemplatesService = new MockTemplatesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTemplatesService));
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
    TemplatesServiceSettings settings =
        TemplatesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TemplatesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createJobFromTemplateTest() throws Exception {
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
    mockTemplatesService.addResponse(expectedResponse);

    CreateJobFromTemplateRequest request =
        CreateJobFromTemplateRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobName("jobName-1438096408")
            .putAllParameters(new HashMap<String, String>())
            .setEnvironment(RuntimeEnvironment.newBuilder().build())
            .setLocation("location1901043637")
            .build();

    Job actualResponse = client.createJobFromTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTemplatesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobFromTemplateRequest actualRequest =
        ((CreateJobFromTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobName(), actualRequest.getJobName());
    Assert.assertEquals(request.getGcsPath(), actualRequest.getGcsPath());
    Assert.assertEquals(request.getParametersMap(), actualRequest.getParametersMap());
    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobFromTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTemplatesService.addException(exception);

    try {
      CreateJobFromTemplateRequest request =
          CreateJobFromTemplateRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobName("jobName-1438096408")
              .putAllParameters(new HashMap<String, String>())
              .setEnvironment(RuntimeEnvironment.newBuilder().build())
              .setLocation("location1901043637")
              .build();
      client.createJobFromTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void launchTemplateTest() throws Exception {
    LaunchTemplateResponse expectedResponse =
        LaunchTemplateResponse.newBuilder().setJob(Job.newBuilder().build()).build();
    mockTemplatesService.addResponse(expectedResponse);

    LaunchTemplateRequest request =
        LaunchTemplateRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setValidateOnly(true)
            .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
            .setLocation("location1901043637")
            .build();

    LaunchTemplateResponse actualResponse = client.launchTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTemplatesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LaunchTemplateRequest actualRequest = ((LaunchTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertEquals(request.getGcsPath(), actualRequest.getGcsPath());
    Assert.assertEquals(request.getDynamicTemplate(), actualRequest.getDynamicTemplate());
    Assert.assertEquals(request.getLaunchParameters(), actualRequest.getLaunchParameters());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void launchTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTemplatesService.addException(exception);

    try {
      LaunchTemplateRequest request =
          LaunchTemplateRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setValidateOnly(true)
              .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
              .setLocation("location1901043637")
              .build();
      client.launchTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateTest() throws Exception {
    GetTemplateResponse expectedResponse =
        GetTemplateResponse.newBuilder()
            .setStatus(Status.newBuilder().build())
            .setMetadata(TemplateMetadata.newBuilder().build())
            .setRuntimeMetadata(RuntimeMetadata.newBuilder().build())
            .build();
    mockTemplatesService.addResponse(expectedResponse);

    GetTemplateRequest request =
        GetTemplateRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setLocation("location1901043637")
            .build();

    GetTemplateResponse actualResponse = client.getTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTemplatesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateRequest actualRequest = ((GetTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getGcsPath(), actualRequest.getGcsPath());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTemplatesService.addException(exception);

    try {
      GetTemplateRequest request =
          GetTemplateRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setLocation("location1901043637")
              .build();
      client.getTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
