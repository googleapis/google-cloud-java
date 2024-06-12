/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ProjectServiceClientTest {
  private static MockLocations mockLocations;
  private static MockProjectService mockProjectService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProjectServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProjectService = new MockProjectService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockProjectService, mockLocations));
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
    ProjectServiceSettings settings =
        ProjectServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProjectServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProjectTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    RetailProjectName name = RetailProjectName.of("[PROJECT]");

    Project actualResponse = client.getProject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectRequest actualRequest = ((GetProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      RetailProjectName name = RetailProjectName.of("[PROJECT]");
      client.getProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    String name = "name3373707";

    Project actualResponse = client.getProject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectRequest actualRequest = ((GetProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String name = "name3373707";
      client.getProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    RetailProjectName project = RetailProjectName.of("[PROJECT]");

    Project actualResponse = client.acceptTerms(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptTermsRequest actualRequest = ((AcceptTermsRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptTermsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      RetailProjectName project = RetailProjectName.of("[PROJECT]");
      client.acceptTerms(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    String project = "project-309310695";

    Project actualResponse = client.acceptTerms(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptTermsRequest actualRequest = ((AcceptTermsRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptTermsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String project = "project-309310695";
      client.acceptTerms(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enrollSolutionTest() throws Exception {
    EnrollSolutionResponse expectedResponse =
        EnrollSolutionResponse.newBuilder().setEnrolledSolution(SolutionType.forNumber(0)).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enrollSolutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProjectService.addResponse(resultOperation);

    EnrollSolutionRequest request =
        EnrollSolutionRequest.newBuilder()
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setSolution(SolutionType.forNumber(0))
            .build();

    EnrollSolutionResponse actualResponse = client.enrollSolutionAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnrollSolutionRequest actualRequest = ((EnrollSolutionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getSolution(), actualRequest.getSolution());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enrollSolutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      EnrollSolutionRequest request =
          EnrollSolutionRequest.newBuilder()
              .setProject(ProjectName.of("[PROJECT]").toString())
              .setSolution(SolutionType.forNumber(0))
              .build();
      client.enrollSolutionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEnrolledSolutionsTest() throws Exception {
    ListEnrolledSolutionsResponse expectedResponse =
        ListEnrolledSolutionsResponse.newBuilder()
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListEnrolledSolutionsResponse actualResponse = client.listEnrolledSolutions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnrolledSolutionsRequest actualRequest =
        ((ListEnrolledSolutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnrolledSolutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listEnrolledSolutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnrolledSolutionsTest2() throws Exception {
    ListEnrolledSolutionsResponse expectedResponse =
        ListEnrolledSolutionsResponse.newBuilder()
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnrolledSolutionsResponse actualResponse = client.listEnrolledSolutions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnrolledSolutionsRequest actualRequest =
        ((ListEnrolledSolutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnrolledSolutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEnrolledSolutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingConfigTest() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    LoggingConfigName name = LoggingConfigName.of("[PROJECT]");

    LoggingConfig actualResponse = client.getLoggingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoggingConfigRequest actualRequest = ((GetLoggingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoggingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      LoggingConfigName name = LoggingConfigName.of("[PROJECT]");
      client.getLoggingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingConfigTest2() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    String name = "name3373707";

    LoggingConfig actualResponse = client.getLoggingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoggingConfigRequest actualRequest = ((GetLoggingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoggingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String name = "name3373707";
      client.getLoggingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLoggingConfigTest() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    LoggingConfig loggingConfig = LoggingConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LoggingConfig actualResponse = client.updateLoggingConfig(loggingConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLoggingConfigRequest actualRequest = ((UpdateLoggingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(loggingConfig, actualRequest.getLoggingConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLoggingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      LoggingConfig loggingConfig = LoggingConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLoggingConfig(loggingConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertConfigTest() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    AlertConfigName name = AlertConfigName.of("[PROJECT]");

    AlertConfig actualResponse = client.getAlertConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlertConfigRequest actualRequest = ((GetAlertConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAlertConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      AlertConfigName name = AlertConfigName.of("[PROJECT]");
      client.getAlertConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertConfigTest2() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    String name = "name3373707";

    AlertConfig actualResponse = client.getAlertConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlertConfigRequest actualRequest = ((GetAlertConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAlertConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String name = "name3373707";
      client.getAlertConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAlertConfigTest() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    AlertConfig alertConfig = AlertConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AlertConfig actualResponse = client.updateAlertConfig(alertConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlertConfigRequest actualRequest = ((UpdateAlertConfigRequest) actualRequests.get(0));

    Assert.assertEquals(alertConfig, actualRequest.getAlertConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAlertConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      AlertConfig alertConfig = AlertConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAlertConfig(alertConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
