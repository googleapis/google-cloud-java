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
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
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
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    String patchDeployment = "patchDeployment633565980";
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder().build();

    PatchJob actualResponse = client.executePatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecutePatchJobRequest actualRequest = (ExecutePatchJobRequest) actualRequests.get(0);

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
      ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder().build();

      client.executePatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchJobTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    String patchDeployment = "patchDeployment633565980";
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    GetPatchJobRequest request = GetPatchJobRequest.newBuilder().build();

    PatchJob actualResponse = client.getPatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPatchJobRequest actualRequest = (GetPatchJobRequest) actualRequests.get(0);

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
      GetPatchJobRequest request = GetPatchJobRequest.newBuilder().build();

      client.getPatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelPatchJobTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    boolean dryRun = false;
    String errorMessage = "errorMessage-1938755376";
    double percentComplete = -1.96096922E8;
    String patchDeployment = "patchDeployment633565980";
    PatchJob expectedResponse =
        PatchJob.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setDryRun(dryRun)
            .setErrorMessage(errorMessage)
            .setPercentComplete(percentComplete)
            .setPatchDeployment(patchDeployment)
            .build();
    mockOsConfigService.addResponse(expectedResponse);

    CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder().build();

    PatchJob actualResponse = client.cancelPatchJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelPatchJobRequest actualRequest = (CancelPatchJobRequest) actualRequests.get(0);

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
      CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder().build();

      client.cancelPatchJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListPatchJobsResponse expectedResponse =
        ListPatchJobsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockOsConfigService.addResponse(expectedResponse);

    ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder().build();

    ListPatchJobsResponse actualResponse = client.listPatchJobs(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchJobsRequest actualRequest = (ListPatchJobsRequest) actualRequests.get(0);

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
      ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder().build();

      client.listPatchJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchJobInstanceDetailsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListPatchJobInstanceDetailsResponse expectedResponse =
        ListPatchJobInstanceDetailsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockOsConfigService.addResponse(expectedResponse);

    ListPatchJobInstanceDetailsRequest request =
        ListPatchJobInstanceDetailsRequest.newBuilder().build();

    ListPatchJobInstanceDetailsResponse actualResponse =
        client.listPatchJobInstanceDetails(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchJobInstanceDetailsRequest actualRequest =
        (ListPatchJobInstanceDetailsRequest) actualRequests.get(0);

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
      ListPatchJobInstanceDetailsRequest request =
          ListPatchJobInstanceDetailsRequest.newBuilder().build();

      client.listPatchJobInstanceDetails(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createPatchDeploymentTest() {
    String name = "name3373707";
    String description = "description-1724546052";
    PatchDeployment expectedResponse =
        PatchDeployment.newBuilder().setName(name).setDescription(description).build();
    mockOsConfigService.addResponse(expectedResponse);

    CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder().build();

    PatchDeployment actualResponse = client.createPatchDeployment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePatchDeploymentRequest actualRequest =
        (CreatePatchDeploymentRequest) actualRequests.get(0);

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
      CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder().build();

      client.createPatchDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPatchDeploymentTest() {
    String name = "name3373707";
    String description = "description-1724546052";
    PatchDeployment expectedResponse =
        PatchDeployment.newBuilder().setName(name).setDescription(description).build();
    mockOsConfigService.addResponse(expectedResponse);

    GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder().build();

    PatchDeployment actualResponse = client.getPatchDeployment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPatchDeploymentRequest actualRequest = (GetPatchDeploymentRequest) actualRequests.get(0);

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
      GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder().build();

      client.getPatchDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPatchDeploymentsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListPatchDeploymentsResponse expectedResponse =
        ListPatchDeploymentsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockOsConfigService.addResponse(expectedResponse);

    ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder().build();

    ListPatchDeploymentsResponse actualResponse = client.listPatchDeployments(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPatchDeploymentsRequest actualRequest = (ListPatchDeploymentsRequest) actualRequests.get(0);

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
      ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder().build();

      client.listPatchDeployments(request);
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

    DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder().build();

    client.deletePatchDeployment(request);

    List<AbstractMessage> actualRequests = mockOsConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePatchDeploymentRequest actualRequest =
        (DeletePatchDeploymentRequest) actualRequests.get(0);

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
      DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder().build();

      client.deletePatchDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
