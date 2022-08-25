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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.dataflow.v1beta3.stub.HttpJsonTemplatesServiceStub;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
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
public class TemplatesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TemplatesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTemplatesServiceStub.getMethodDescriptors(),
            TemplatesServiceSettings.getDefaultEndpoint());
    TemplatesServiceSettings settings =
        TemplatesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TemplatesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TemplatesServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    CreateJobFromTemplateRequest request =
        CreateJobFromTemplateRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobName("jobName-1438096408")
            .putAllParameters(new HashMap<String, String>())
            .setEnvironment(RuntimeEnvironment.newBuilder().build())
            .setLocation("location-9355")
            .build();

    Job actualResponse = client.createJobFromTemplate(request);
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
  public void createJobFromTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateJobFromTemplateRequest request =
          CreateJobFromTemplateRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobName("jobName-1438096408")
              .putAllParameters(new HashMap<String, String>())
              .setEnvironment(RuntimeEnvironment.newBuilder().build())
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    LaunchTemplateRequest request =
        LaunchTemplateRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setValidateOnly(true)
            .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
            .setLocation("location-9355")
            .build();

    LaunchTemplateResponse actualResponse = client.launchTemplate(request);
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
  public void launchTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LaunchTemplateRequest request =
          LaunchTemplateRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setValidateOnly(true)
              .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
              .setLocation("location-9355")
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
    mockService.addResponse(expectedResponse);

    GetTemplateRequest request =
        GetTemplateRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setLocation("location-9355")
            .build();

    GetTemplateResponse actualResponse = client.getTemplate(request);
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
  public void getTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetTemplateRequest request =
          GetTemplateRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setLocation("location-9355")
              .build();
      client.getTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
