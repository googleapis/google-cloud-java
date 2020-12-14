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
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
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
public class OsConfigServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockOsConfigService mockOsConfigService;
  private OsConfigServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockOsConfigService = new MockOsConfigService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOsConfigService));
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
  public void executePatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse = PatchJobs.PatchJob.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobs.ExecutePatchJobRequest request =
        PatchJobs.ExecutePatchJobRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .setDuration(Duration.newBuilder().build())
            .setDryRun(true)
            .setDisplayName("displayName1714148973")
            .build();

    PatchJobs.PatchJob actualResponse = client.executePatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ExecutePatchJobRequest actualRequest =
        ((PatchJobs.ExecutePatchJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDescription(), actualRequest.getDescription());
    Assert.assertEquals(request.getInstanceFilter(), actualRequest.getInstanceFilter());
    Assert.assertEquals(request.getPatchConfig(), actualRequest.getPatchConfig());
    Assert.assertEquals(request.getDuration(), actualRequest.getDuration());
    Assert.assertEquals(request.getDryRun(), actualRequest.getDryRun());
    Assert.assertEquals(request.getDisplayName(), actualRequest.getDisplayName());
    Assert.assertEquals(request.getRollout(), actualRequest.getRollout());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executePatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobs.ExecutePatchJobRequest request =
          PatchJobs.ExecutePatchJobRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDescription("description-1724546052")
              .setDuration(Duration.newBuilder().build())
              .setDryRun(true)
              .setDisplayName("displayName1714148973")
              .build();
      client.executePatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse = PatchJobs.PatchJob.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    PatchJobs.PatchJob actualResponse = client.getPatchJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.GetPatchJobRequest actualRequest =
        ((PatchJobs.GetPatchJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
      client.getPatchJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchJobTest2() throws Exception {
    PatchJobs.PatchJob expectedResponse = PatchJobs.PatchJob.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    PatchJobs.PatchJob actualResponse = client.getPatchJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.GetPatchJobRequest actualRequest =
        ((PatchJobs.GetPatchJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPatchJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getPatchJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse = PatchJobs.PatchJob.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobs.CancelPatchJobRequest request =
        PatchJobs.CancelPatchJobRequest.newBuilder()
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
            .build();

    PatchJobs.PatchJob actualResponse = client.cancelPatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.CancelPatchJobRequest actualRequest =
        ((PatchJobs.CancelPatchJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelPatchJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobs.CancelPatchJobRequest request =
          PatchJobs.CancelPatchJobRequest.newBuilder()
              .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
              .build();
      client.cancelPatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchJobsTest() throws Exception {
    PatchJobs.PatchJob responsesElement = PatchJobs.PatchJob.newBuilder().build();
    PatchJobs.ListPatchJobsResponse expectedResponse =
        PatchJobs.ListPatchJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchJobs(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(parent);

    List<PatchJobs.PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ListPatchJobsRequest actualRequest =
        ((PatchJobs.ListPatchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listPatchJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchJobsTest2() throws Exception {
    PatchJobs.PatchJob responsesElement = PatchJobs.PatchJob.newBuilder().build();
    PatchJobs.ListPatchJobsResponse expectedResponse =
        PatchJobs.ListPatchJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchJobs(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(parent);

    List<PatchJobs.PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ListPatchJobsRequest actualRequest =
        ((PatchJobs.ListPatchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPatchJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchJobInstanceDetailsTest() throws Exception {
    PatchJobs.PatchJobInstanceDetails responsesElement =
        PatchJobs.PatchJobInstanceDetails.newBuilder().build();
    PatchJobs.ListPatchJobInstanceDetailsResponse expectedResponse =
        PatchJobs.ListPatchJobInstanceDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchJobInstanceDetails(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    ListPatchJobInstanceDetailsPagedResponse pagedListResponse =
        client.listPatchJobInstanceDetails(parent);

    List<PatchJobs.PatchJobInstanceDetails> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobInstanceDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ListPatchJobInstanceDetailsRequest actualRequest =
        ((PatchJobs.ListPatchJobInstanceDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchJobInstanceDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
      client.listPatchJobInstanceDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchJobInstanceDetailsTest2() throws Exception {
    PatchJobs.PatchJobInstanceDetails responsesElement =
        PatchJobs.PatchJobInstanceDetails.newBuilder().build();
    PatchJobs.ListPatchJobInstanceDetailsResponse expectedResponse =
        PatchJobs.ListPatchJobInstanceDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchJobInstanceDetails(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPatchJobInstanceDetailsPagedResponse pagedListResponse =
        client.listPatchJobInstanceDetails(parent);

    List<PatchJobs.PatchJobInstanceDetails> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobInstanceDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ListPatchJobInstanceDetailsRequest actualRequest =
        ((PatchJobs.ListPatchJobInstanceDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchJobInstanceDetailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPatchJobInstanceDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder().build();
    String patchDeploymentId = "patchDeploymentId-1180405976";

    PatchDeployments.PatchDeployment actualResponse =
        client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.CreatePatchDeploymentRequest actualRequest =
        ((PatchDeployments.CreatePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(patchDeployment, actualRequest.getPatchDeployment());
    Assert.assertEquals(patchDeploymentId, actualRequest.getPatchDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      PatchDeployments.PatchDeployment patchDeployment =
          PatchDeployments.PatchDeployment.newBuilder().build();
      String patchDeploymentId = "patchDeploymentId-1180405976";
      client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPatchDeploymentTest2() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder().build();
    String patchDeploymentId = "patchDeploymentId-1180405976";

    PatchDeployments.PatchDeployment actualResponse =
        client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.CreatePatchDeploymentRequest actualRequest =
        ((PatchDeployments.CreatePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(patchDeployment, actualRequest.getPatchDeployment());
    Assert.assertEquals(patchDeploymentId, actualRequest.getPatchDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPatchDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      PatchDeployments.PatchDeployment patchDeployment =
          PatchDeployments.PatchDeployment.newBuilder().build();
      String patchDeploymentId = "patchDeploymentId-1180405976";
      client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.getPatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.GetPatchDeploymentRequest actualRequest =
        ((PatchDeployments.GetPatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
      client.getPatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchDeploymentTest2() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    PatchDeployments.PatchDeployment actualResponse = client.getPatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.GetPatchDeploymentRequest actualRequest =
        ((PatchDeployments.GetPatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPatchDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getPatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchDeploymentsTest() throws Exception {
    PatchDeployments.PatchDeployment responsesElement =
        PatchDeployments.PatchDeployment.newBuilder().build();
    PatchDeployments.ListPatchDeploymentsResponse expectedResponse =
        PatchDeployments.ListPatchDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchDeployments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(parent);

    List<PatchDeployments.PatchDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.ListPatchDeploymentsRequest actualRequest =
        ((PatchDeployments.ListPatchDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listPatchDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPatchDeploymentsTest2() throws Exception {
    PatchDeployments.PatchDeployment responsesElement =
        PatchDeployments.PatchDeployment.newBuilder().build();
    PatchDeployments.ListPatchDeploymentsResponse expectedResponse =
        PatchDeployments.ListPatchDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPatchDeployments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(parent);

    List<PatchDeployments.PatchDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.ListPatchDeploymentsRequest actualRequest =
        ((PatchDeployments.ListPatchDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPatchDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPatchDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePatchDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    client.deletePatchDeployment(name);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.DeletePatchDeploymentRequest actualRequest =
        ((PatchDeployments.DeletePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
      client.deletePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePatchDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePatchDeployment(name);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.DeletePatchDeploymentRequest actualRequest =
        ((PatchDeployments.DeletePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePatchDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
