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

package com.google.cloud.discoveryengine.v1alpha;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

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
      ProjectName name = ProjectName.of("[PROJECT]");
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
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
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
  public void provisionProjectTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("provisionProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProjectService.addResponse(resultOperation);

    ProjectName name = ProjectName.of("[PROJECT]");

    Project actualResponse = client.provisionProjectAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionProjectRequest actualRequest = ((ProvisionProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionProjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.provisionProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void provisionProjectTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("provisionProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProjectService.addResponse(resultOperation);

    String name = "name3373707";

    Project actualResponse = client.provisionProjectAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionProjectRequest actualRequest = ((ProvisionProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionProjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      String name = "name3373707";
      client.provisionProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportConsentChangeTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
        ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
    ProjectName project = ProjectName.of("[PROJECT]");
    String serviceTermId = "serviceTermId-2051343940";
    String serviceTermVersion = "serviceTermVersion-571872041";

    Project actualResponse =
        client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportConsentChangeRequest actualRequest = ((ReportConsentChangeRequest) actualRequests.get(0));

    Assert.assertEquals(consentChangeAction, actualRequest.getConsentChangeAction());
    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertEquals(serviceTermId, actualRequest.getServiceTermId());
    Assert.assertEquals(serviceTermVersion, actualRequest.getServiceTermVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportConsentChangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
          ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
      ProjectName project = ProjectName.of("[PROJECT]");
      String serviceTermId = "serviceTermId-2051343940";
      String serviceTermVersion = "serviceTermVersion-571872041";
      client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportConsentChangeTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockProjectService.addResponse(expectedResponse);

    ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
        ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
    String project = "project-309310695";
    String serviceTermId = "serviceTermId-2051343940";
    String serviceTermVersion = "serviceTermVersion-571872041";

    Project actualResponse =
        client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportConsentChangeRequest actualRequest = ((ReportConsentChangeRequest) actualRequests.get(0));

    Assert.assertEquals(consentChangeAction, actualRequest.getConsentChangeAction());
    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertEquals(serviceTermId, actualRequest.getServiceTermId());
    Assert.assertEquals(serviceTermVersion, actualRequest.getServiceTermVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportConsentChangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProjectService.addException(exception);

    try {
      ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
          ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
      String project = "project-309310695";
      String serviceTermId = "serviceTermId-2051343940";
      String serviceTermVersion = "serviceTermVersion-571872041";
      client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
