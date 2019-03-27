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
package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.ApplicationServiceClient.ListApplicationsPagedResponse;

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
public class ApplicationServiceClientTest {
  private static MockApplicationService mockApplicationService;
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockProfileService mockProfileService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private ApplicationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockApplicationService = new MockApplicationService();
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockProfileService = new MockProfileService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockApplicationService,
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockProfileService,
                mockTenantService));
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
    ApplicationServiceSettings settings =
        ApplicationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApplicationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createApplicationTest() {
    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
    String externalId = "externalId-1153075697";
    String profile = "profile-309425751";
    String job = "job105405";
    String company = "company950484093";
    String outcomeNotes = "outcomeNotes-355961964";
    String jobTitleSnippet = "jobTitleSnippet-1100512972";
    Application expectedResponse =
        Application.newBuilder()
            .setName(name.toString())
            .setExternalId(externalId)
            .setProfile(profile)
            .setJob(job)
            .setCompany(company)
            .setOutcomeNotes(outcomeNotes)
            .setJobTitleSnippet(jobTitleSnippet)
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
    Application application = Application.newBuilder().build();

    Application actualResponse = client.createApplication(parent, application);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = (CreateApplicationRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProfileName.parse(actualRequest.getParent()));
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
      Application application = Application.newBuilder().build();

      client.createApplication(parent, application);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getApplicationTest() {
    ApplicationName name2 =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
    String externalId = "externalId-1153075697";
    String profile = "profile-309425751";
    String job = "job105405";
    String company = "company950484093";
    String outcomeNotes = "outcomeNotes-355961964";
    String jobTitleSnippet = "jobTitleSnippet-1100512972";
    Application expectedResponse =
        Application.newBuilder()
            .setName(name2.toString())
            .setExternalId(externalId)
            .setProfile(profile)
            .setJob(job)
            .setCompany(company)
            .setOutcomeNotes(outcomeNotes)
            .setJobTitleSnippet(jobTitleSnippet)
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = (GetApplicationRequest) actualRequests.get(0);

    Assert.assertEquals(name, ApplicationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateApplicationTest() {
    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
    String externalId = "externalId-1153075697";
    String profile = "profile-309425751";
    String job = "job105405";
    String company = "company950484093";
    String outcomeNotes = "outcomeNotes-355961964";
    String jobTitleSnippet = "jobTitleSnippet-1100512972";
    Application expectedResponse =
        Application.newBuilder()
            .setName(name.toString())
            .setExternalId(externalId)
            .setProfile(profile)
            .setJob(job)
            .setCompany(company)
            .setOutcomeNotes(outcomeNotes)
            .setJobTitleSnippet(jobTitleSnippet)
            .build();
    mockApplicationService.addResponse(expectedResponse);

    Application application = Application.newBuilder().build();

    Application actualResponse = client.updateApplication(application);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationRequest actualRequest = (UpdateApplicationRequest) actualRequests.get(0);

    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      Application application = Application.newBuilder().build();

      client.updateApplication(application);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteApplicationTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApplicationService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

    client.deleteApplication(name);

    List<GeneratedMessageV3> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = (DeleteApplicationRequest) actualRequests.get(0);

    Assert.assertEquals(name, ApplicationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

      client.deleteApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listApplicationsTest() {
    String nextPageToken = "";
    Application applicationsElement = Application.newBuilder().build();
    List<Application> applications = Arrays.asList(applicationsElement);
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllApplications(applications)
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = (ListApplicationsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProfileName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listApplicationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
