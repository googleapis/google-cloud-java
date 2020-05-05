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
package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchInstanceFilter;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJobInstanceDetails;
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
public class OsConfigServiceClientTest {
  private static MockOsConfigService mockOsConfigService;
  private static MockServiceHelper serviceHelper;
  private OsConfigServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockOsConfigService = new MockOsConfigService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOsConfigService));
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
    OsConfigServiceSettings settings =
        OsConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void executePatchJobTest() {
    PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    PatchDeploymentName patchDeployment = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment.toString())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    PatchInstanceFilter instanceFilter = PatchInstanceFilter.newBuilder().build();
    ExecutePatchJobRequest request =
        ExecutePatchJobRequest.newBuilder()
            .setParent(parent.toString())
            .setInstanceFilter(instanceFilter)
            .build();

    PatchJob actualResponse = client.executePatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecutePatchJobRequest actualRequest = (ExecutePatchJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(instanceFilter, actualRequest.getInstanceFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void executePatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      PatchInstanceFilter instanceFilter = PatchInstanceFilter.newBuilder().build();
      ExecutePatchJobRequest request =
          ExecutePatchJobRequest.newBuilder()
              .setParent(parent.toString())
              .setInstanceFilter(instanceFilter)
              .build();

      client.executePatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchJobTest() {
    PatchJobName name2 = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    PatchDeploymentName patchDeployment = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment.toString())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    PatchJob actualResponse = client.getPatchJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPatchJobRequest actualRequest = (GetPatchJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, PatchJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

      client.getPatchJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelPatchJobTest() {
    PatchJobName name2 = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    PatchDeploymentName patchDeployment = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment.toString())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
    CancelPatchJobRequest request =
        CancelPatchJobRequest.newBuilder().setName(name.toString()).build();

    PatchJob actualResponse = client.cancelPatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelPatchJobRequest actualRequest = (CancelPatchJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, PatchJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelPatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
      CancelPatchJobRequest request =
          CancelPatchJobRequest.newBuilder().setName(name.toString()).build();

      client.cancelPatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobsTest() {
    String nextPageToken = "";
    PatchJob patchJobsElement = PatchJob.newBuilder().build();
    List<PatchJob> patchJobs = Arrays.asList(patchJobsElement);
    ListPatchJobsResponse expectedResponse =
        ListPatchJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPatchJobs(patchJobs)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(parent);

    List<PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchJobsRequest actualRequest = (ListPatchJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listPatchJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobInstanceDetailsTest() {
    String nextPageToken = "";
    PatchJobInstanceDetails patchJobInstanceDetailsElement =
        PatchJobInstanceDetails.newBuilder().build();
    List<PatchJobInstanceDetails> patchJobInstanceDetails =
        Arrays.asList(patchJobInstanceDetailsElement);
    ListPatchJobInstanceDetailsResponse expectedResponse =
        ListPatchJobInstanceDetailsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPatchJobInstanceDetails(patchJobInstanceDetails)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    ListPatchJobInstanceDetailsPagedResponse pagedListResponse =
        client.listPatchJobInstanceDetails(parent);

    List<PatchJobInstanceDetails> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobInstanceDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchJobInstanceDetailsRequest actualRequest =
        (ListPatchJobInstanceDetailsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, PatchJobName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobInstanceDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

      client.listPatchJobInstanceDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createPatchDeploymentTest() {
    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
    String description = "description-1724546052";
    PatchDeployment expectedResponse =
        PatchDeployment.newBuilder().setName(name.toString()).setDescription(description).build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
    String patchDeploymentId = "patchDeploymentId-1817061090";

    PatchDeployment actualResponse =
        client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePatchDeploymentRequest actualRequest =
        (CreatePatchDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(patchDeployment, actualRequest.getPatchDeployment());
    Assert.assertEquals(patchDeploymentId, actualRequest.getPatchDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createPatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
      String patchDeploymentId = "patchDeploymentId-1817061090";

      client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchDeploymentTest() {
    PatchDeploymentName name2 = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
    String description = "description-1724546052";
    PatchDeployment expectedResponse =
        PatchDeployment.newBuilder().setName(name2.toString()).setDescription(description).build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployment actualResponse = client.getPatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPatchDeploymentRequest actualRequest = (GetPatchDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(name, PatchDeploymentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

      client.getPatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchDeploymentsTest() {
    String nextPageToken = "";
    PatchDeployment patchDeploymentsElement = PatchDeployment.newBuilder().build();
    List<PatchDeployment> patchDeployments = Arrays.asList(patchDeploymentsElement);
    ListPatchDeploymentsResponse expectedResponse =
        ListPatchDeploymentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPatchDeployments(patchDeployments)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(parent);

    List<PatchDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchDeploymentsRequest actualRequest = (ListPatchDeploymentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listPatchDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deletePatchDeploymentTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    client.deletePatchDeployment(name);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePatchDeploymentRequest actualRequest =
        (DeletePatchDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(name, PatchDeploymentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deletePatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

      client.deletePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
