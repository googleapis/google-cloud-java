/*
 * Copyright 2020 Google LLC
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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class ApplicationServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockApplicationService mockApplicationService;
  private ApplicationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockApplicationService = new MockApplicationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockApplicationService));
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
  public void createApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]")
                    .toString())
            .setExternalId("externalId-1699764666")
            .setProfile("profile-309425751")
            .setJob(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setApplicationDate(Date.newBuilder().build())
            .addAllInterviews(new ArrayList<Interview>())
            .setReferral(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutcomeNotes("outcomeNotes-1412621681")
            .setOutcome(Outcome.forNumber(0))
            .setIsMatch(BoolValue.newBuilder().build())
            .setJobTitleSnippet("jobTitleSnippet748146690")
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
    Application application = Application.newBuilder().build();

    Application actualResponse = client.createApplication(parent, application);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
      Application application = Application.newBuilder().build();
      client.createApplication(parent, application);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]")
                    .toString())
            .setExternalId("externalId-1699764666")
            .setProfile("profile-309425751")
            .setJob(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setApplicationDate(Date.newBuilder().build())
            .addAllInterviews(new ArrayList<Interview>())
            .setReferral(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutcomeNotes("outcomeNotes-1412621681")
            .setOutcome(Outcome.forNumber(0))
            .setIsMatch(BoolValue.newBuilder().build())
            .setJobTitleSnippet("jobTitleSnippet748146690")
            .build();
    mockApplicationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Application application = Application.newBuilder().build();

    Application actualResponse = client.createApplication(parent, application);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Application application = Application.newBuilder().build();
      client.createApplication(parent, application);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]")
                    .toString())
            .setExternalId("externalId-1699764666")
            .setProfile("profile-309425751")
            .setJob(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setApplicationDate(Date.newBuilder().build())
            .addAllInterviews(new ArrayList<Interview>())
            .setReferral(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutcomeNotes("outcomeNotes-1412621681")
            .setOutcome(Outcome.forNumber(0))
            .setIsMatch(BoolValue.newBuilder().build())
            .setJobTitleSnippet("jobTitleSnippet748146690")
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]")
                    .toString())
            .setExternalId("externalId-1699764666")
            .setProfile("profile-309425751")
            .setJob(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setApplicationDate(Date.newBuilder().build())
            .addAllInterviews(new ArrayList<Interview>())
            .setReferral(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutcomeNotes("outcomeNotes-1412621681")
            .setOutcome(Outcome.forNumber(0))
            .setIsMatch(BoolValue.newBuilder().build())
            .setJobTitleSnippet("jobTitleSnippet748146690")
            .build();
    mockApplicationService.addResponse(expectedResponse);

    String name = "name3373707";

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      String name = "name3373707";
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]")
                    .toString())
            .setExternalId("externalId-1699764666")
            .setProfile("profile-309425751")
            .setJob(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setApplicationDate(Date.newBuilder().build())
            .addAllInterviews(new ArrayList<Interview>())
            .setReferral(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOutcomeNotes("outcomeNotes-1412621681")
            .setOutcome(Outcome.forNumber(0))
            .setIsMatch(BoolValue.newBuilder().build())
            .setJobTitleSnippet("jobTitleSnippet748146690")
            .build();
    mockApplicationService.addResponse(expectedResponse);

    Application application = Application.newBuilder().build();

    Application actualResponse = client.updateApplication(application);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationRequest actualRequest = ((UpdateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      Application application = Application.newBuilder().build();
      client.updateApplication(application);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApplicationService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");

    client.deleteApplication(name);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
      client.deleteApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApplicationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApplication(name);

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockApplicationService.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest2() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockApplicationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApplicationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplicationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
