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

package com.google.cloud.osconfig.v1beta;

import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListGuestPoliciesPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobsPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class OsConfigServiceClientTest {
  private static MockOsConfigService mockOsConfigService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OsConfigServiceClient client;

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
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setInstanceDetailsSummary(
                PatchJobs.PatchJob.InstanceDetailsSummary.newBuilder().build())
            .setDryRun(true)
            .setErrorMessage("errorMessage1203236063")
            .setPercentComplete(-1960969229)
            .setPatchDeployment("patchDeployment1500445997")
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobs.ExecutePatchJobRequest request =
        PatchJobs.ExecutePatchJobRequest.newBuilder()
            .setParent("parent-995424086")
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setDryRun(true)
            .setDisplayName("displayName1714148973")
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
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
              .setParent("parent-995424086")
              .setDescription("description-1724546052")
              .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
              .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
              .setDuration(Duration.newBuilder().build())
              .setDryRun(true)
              .setDisplayName("displayName1714148973")
              .setRollout(PatchJobs.PatchRollout.newBuilder().build())
              .build();
      client.executePatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setInstanceDetailsSummary(
                PatchJobs.PatchJob.InstanceDetailsSummary.newBuilder().build())
            .setDryRun(true)
            .setErrorMessage("errorMessage1203236063")
            .setPercentComplete(-1960969229)
            .setPatchDeployment("patchDeployment1500445997")
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobs.GetPatchJobRequest request =
        PatchJobs.GetPatchJobRequest.newBuilder().setName("name3373707").build();

    PatchJobs.PatchJob actualResponse = client.getPatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.GetPatchJobRequest actualRequest =
        ((PatchJobs.GetPatchJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      PatchJobs.GetPatchJobRequest request =
          PatchJobs.GetPatchJobRequest.newBuilder().setName("name3373707").build();
      client.getPatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setInstanceDetailsSummary(
                PatchJobs.PatchJob.InstanceDetailsSummary.newBuilder().build())
            .setDryRun(true)
            .setErrorMessage("errorMessage1203236063")
            .setPercentComplete(-1960969229)
            .setPatchDeployment("patchDeployment1500445997")
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchJobs.CancelPatchJobRequest request =
        PatchJobs.CancelPatchJobRequest.newBuilder().setName("name3373707").build();

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
          PatchJobs.CancelPatchJobRequest.newBuilder().setName("name3373707").build();
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

    PatchJobs.ListPatchJobsRequest request =
        PatchJobs.ListPatchJobsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(request);

    List<PatchJobs.PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchJobs.ListPatchJobsRequest actualRequest =
        ((PatchJobs.ListPatchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
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
      PatchJobs.ListPatchJobsRequest request =
          PatchJobs.ListPatchJobsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listPatchJobs(request);
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
  public void listPatchJobInstanceDetailsExceptionTest() throws Exception {
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
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeployments.CreatePatchDeploymentRequest request =
        PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
            .setParent("parent-995424086")
            .setPatchDeploymentId("patchDeploymentId-1180405976")
            .setPatchDeployment(PatchDeployments.PatchDeployment.newBuilder().build())
            .build();

    PatchDeployments.PatchDeployment actualResponse = client.createPatchDeployment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.CreatePatchDeploymentRequest actualRequest =
        ((PatchDeployments.CreatePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPatchDeploymentId(), actualRequest.getPatchDeploymentId());
    Assert.assertEquals(request.getPatchDeployment(), actualRequest.getPatchDeployment());
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
      PatchDeployments.CreatePatchDeploymentRequest request =
          PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
              .setParent("parent-995424086")
              .setPatchDeploymentId("patchDeploymentId-1180405976")
              .setPatchDeployment(PatchDeployments.PatchDeployment.newBuilder().build())
              .build();
      client.createPatchDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeployments.GetPatchDeploymentRequest request =
        PatchDeployments.GetPatchDeploymentRequest.newBuilder().setName("name3373707").build();

    PatchDeployments.PatchDeployment actualResponse = client.getPatchDeployment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.GetPatchDeploymentRequest actualRequest =
        ((PatchDeployments.GetPatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      PatchDeployments.GetPatchDeploymentRequest request =
          PatchDeployments.GetPatchDeploymentRequest.newBuilder().setName("name3373707").build();
      client.getPatchDeployment(request);
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

    PatchDeployments.ListPatchDeploymentsRequest request =
        PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(request);

    List<PatchDeployments.PatchDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.ListPatchDeploymentsRequest actualRequest =
        ((PatchDeployments.ListPatchDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
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
      PatchDeployments.ListPatchDeploymentsRequest request =
          PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listPatchDeployments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePatchDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeployments.DeletePatchDeploymentRequest request =
        PatchDeployments.DeletePatchDeploymentRequest.newBuilder().setName("name3373707").build();

    client.deletePatchDeployment(request);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.DeletePatchDeploymentRequest actualRequest =
        ((PatchDeployments.DeletePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      PatchDeployments.DeletePatchDeploymentRequest request =
          PatchDeployments.DeletePatchDeploymentRequest.newBuilder().setName("name3373707").build();
      client.deletePatchDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PatchDeployments.PatchDeployment actualResponse =
        client.updatePatchDeployment(patchDeployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.UpdatePatchDeploymentRequest actualRequest =
        ((PatchDeployments.UpdatePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(patchDeployment, actualRequest.getPatchDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeployments.PatchDeployment patchDeployment =
          PatchDeployments.PatchDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePatchDeployment(patchDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pausePatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.pausePatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.PausePatchDeploymentRequest actualRequest =
        ((PatchDeployments.PausePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pausePatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
      client.pausePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pausePatchDeploymentTest2() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    PatchDeployments.PatchDeployment actualResponse = client.pausePatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.PausePatchDeploymentRequest actualRequest =
        ((PatchDeployments.PausePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pausePatchDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.pausePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumePatchDeploymentTest() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.resumePatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.ResumePatchDeploymentRequest actualRequest =
        ((PatchDeployments.ResumePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumePatchDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
      client.resumePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumePatchDeploymentTest2() throws Exception {
    PatchDeployments.PatchDeployment expectedResponse =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setDescription("description-1724546052")
            .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
            .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastExecuteTime(Timestamp.newBuilder().build())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    PatchDeployments.PatchDeployment actualResponse = client.resumePatchDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PatchDeployments.ResumePatchDeploymentRequest actualRequest =
        ((PatchDeployments.ResumePatchDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumePatchDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.resumePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuestPolicyTest() throws Exception {
    GuestPolicies.GuestPolicy expectedResponse =
        GuestPolicies.GuestPolicy.newBuilder()
            .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAssignment(GuestPolicies.Assignment.newBuilder().build())
            .addAllPackages(new ArrayList<GuestPolicies.Package>())
            .addAllPackageRepositories(new ArrayList<GuestPolicies.PackageRepository>())
            .addAllRecipes(new ArrayList<GuestPolicies.SoftwareRecipe>())
            .setEtag("etag3123477")
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();

    GuestPolicies.GuestPolicy actualResponse = client.createGuestPolicy(parent, guestPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.CreateGuestPolicyRequest actualRequest =
        ((GuestPolicies.CreateGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(guestPolicy, actualRequest.getGuestPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuestPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();
      client.createGuestPolicy(parent, guestPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuestPolicyTest2() throws Exception {
    GuestPolicies.GuestPolicy expectedResponse =
        GuestPolicies.GuestPolicy.newBuilder()
            .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAssignment(GuestPolicies.Assignment.newBuilder().build())
            .addAllPackages(new ArrayList<GuestPolicies.Package>())
            .addAllPackageRepositories(new ArrayList<GuestPolicies.PackageRepository>())
            .addAllRecipes(new ArrayList<GuestPolicies.SoftwareRecipe>())
            .setEtag("etag3123477")
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();

    GuestPolicies.GuestPolicy actualResponse = client.createGuestPolicy(parent, guestPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.CreateGuestPolicyRequest actualRequest =
        ((GuestPolicies.CreateGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(guestPolicy, actualRequest.getGuestPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuestPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();
      client.createGuestPolicy(parent, guestPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGuestPolicyTest() throws Exception {
    GuestPolicies.GuestPolicy expectedResponse =
        GuestPolicies.GuestPolicy.newBuilder()
            .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAssignment(GuestPolicies.Assignment.newBuilder().build())
            .addAllPackages(new ArrayList<GuestPolicies.Package>())
            .addAllPackageRepositories(new ArrayList<GuestPolicies.PackageRepository>())
            .addAllRecipes(new ArrayList<GuestPolicies.SoftwareRecipe>())
            .setEtag("etag3123477")
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    GuestPolicyName name = GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]");

    GuestPolicies.GuestPolicy actualResponse = client.getGuestPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.GetGuestPolicyRequest actualRequest =
        ((GuestPolicies.GetGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGuestPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      GuestPolicyName name = GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]");
      client.getGuestPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGuestPolicyTest2() throws Exception {
    GuestPolicies.GuestPolicy expectedResponse =
        GuestPolicies.GuestPolicy.newBuilder()
            .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAssignment(GuestPolicies.Assignment.newBuilder().build())
            .addAllPackages(new ArrayList<GuestPolicies.Package>())
            .addAllPackageRepositories(new ArrayList<GuestPolicies.PackageRepository>())
            .addAllRecipes(new ArrayList<GuestPolicies.SoftwareRecipe>())
            .setEtag("etag3123477")
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    GuestPolicies.GuestPolicy actualResponse = client.getGuestPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.GetGuestPolicyRequest actualRequest =
        ((GuestPolicies.GetGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGuestPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getGuestPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGuestPoliciesTest() throws Exception {
    GuestPolicies.GuestPolicy responsesElement = GuestPolicies.GuestPolicy.newBuilder().build();
    GuestPolicies.ListGuestPoliciesResponse expectedResponse =
        GuestPolicies.ListGuestPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGuestPolicies(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListGuestPoliciesPagedResponse pagedListResponse = client.listGuestPolicies(parent);

    List<GuestPolicies.GuestPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuestPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.ListGuestPoliciesRequest actualRequest =
        ((GuestPolicies.ListGuestPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGuestPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listGuestPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGuestPoliciesTest2() throws Exception {
    GuestPolicies.GuestPolicy responsesElement = GuestPolicies.GuestPolicy.newBuilder().build();
    GuestPolicies.ListGuestPoliciesResponse expectedResponse =
        GuestPolicies.ListGuestPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGuestPolicies(Arrays.asList(responsesElement))
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGuestPoliciesPagedResponse pagedListResponse = client.listGuestPolicies(parent);

    List<GuestPolicies.GuestPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuestPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.ListGuestPoliciesRequest actualRequest =
        ((GuestPolicies.ListGuestPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGuestPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGuestPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGuestPolicyTest() throws Exception {
    GuestPolicies.GuestPolicy expectedResponse =
        GuestPolicies.GuestPolicy.newBuilder()
            .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAssignment(GuestPolicies.Assignment.newBuilder().build())
            .addAllPackages(new ArrayList<GuestPolicies.Package>())
            .addAllPackageRepositories(new ArrayList<GuestPolicies.PackageRepository>())
            .addAllRecipes(new ArrayList<GuestPolicies.SoftwareRecipe>())
            .setEtag("etag3123477")
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GuestPolicies.GuestPolicy actualResponse = client.updateGuestPolicy(guestPolicy, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.UpdateGuestPolicyRequest actualRequest =
        ((GuestPolicies.UpdateGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(guestPolicy, actualRequest.getGuestPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGuestPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      GuestPolicies.GuestPolicy guestPolicy = GuestPolicies.GuestPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGuestPolicy(guestPolicy, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGuestPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    GuestPolicyName name = GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]");

    client.deleteGuestPolicy(name);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.DeleteGuestPolicyRequest actualRequest =
        ((GuestPolicies.DeleteGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGuestPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      GuestPolicyName name = GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]");
      client.deleteGuestPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGuestPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGuestPolicy(name);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.DeleteGuestPolicyRequest actualRequest =
        ((GuestPolicies.DeleteGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGuestPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGuestPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEffectiveGuestPolicyTest() throws Exception {
    GuestPolicies.EffectiveGuestPolicy expectedResponse =
        GuestPolicies.EffectiveGuestPolicy.newBuilder()
            .addAllPackages(new ArrayList<GuestPolicies.EffectiveGuestPolicy.SourcedPackage>())
            .addAllPackageRepositories(
                new ArrayList<GuestPolicies.EffectiveGuestPolicy.SourcedPackageRepository>())
            .addAllSoftwareRecipes(
                new ArrayList<GuestPolicies.EffectiveGuestPolicy.SourcedSoftwareRecipe>())
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    GuestPolicies.LookupEffectiveGuestPolicyRequest request =
        GuestPolicies.LookupEffectiveGuestPolicyRequest.newBuilder()
            .setInstance("instance555127957")
            .setOsShortName("osShortName1253394339")
            .setOsVersion("osVersion1812004436")
            .setOsArchitecture("osArchitecture1339954519")
            .build();

    GuestPolicies.EffectiveGuestPolicy actualResponse = client.lookupEffectiveGuestPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GuestPolicies.LookupEffectiveGuestPolicyRequest actualRequest =
        ((GuestPolicies.LookupEffectiveGuestPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getOsShortName(), actualRequest.getOsShortName());
    Assert.assertEquals(request.getOsVersion(), actualRequest.getOsVersion());
    Assert.assertEquals(request.getOsArchitecture(), actualRequest.getOsArchitecture());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupEffectiveGuestPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigService.addException(exception);

    try {
      GuestPolicies.LookupEffectiveGuestPolicyRequest request =
          GuestPolicies.LookupEffectiveGuestPolicyRequest.newBuilder()
              .setInstance("instance555127957")
              .setOsShortName("osShortName1253394339")
              .setOsVersion("osVersion1812004436")
              .setOsArchitecture("osArchitecture1339954519")
              .build();
      client.lookupEffectiveGuestPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
