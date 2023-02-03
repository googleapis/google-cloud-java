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

package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.osconfig.v1.stub.HttpJsonOsConfigServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class OsConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OsConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOsConfigServiceStub.getMethodDescriptors(),
            OsConfigServiceSettings.getDefaultEndpoint());
    OsConfigServiceSettings settings =
        OsConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OsConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsConfigServiceClient.create(settings);
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
  public void executePatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
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
            .setPatchDeployment(
                PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PatchJobs.ExecutePatchJobRequest request =
        PatchJobs.ExecutePatchJobRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
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
  public void executePatchJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PatchJobs.ExecutePatchJobRequest request =
          PatchJobs.ExecutePatchJobRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
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
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
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
            .setPatchDeployment(
                PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    PatchJobs.PatchJob actualResponse = client.getPatchJob(name);
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
  public void getPatchJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
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
            .setPatchDeployment(
                PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3014/patchJobs/patchJob-3014";

    PatchJobs.PatchJob actualResponse = client.getPatchJob(name);
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
  public void getPatchJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3014/patchJobs/patchJob-3014";
      client.getPatchJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPatchJobTest() throws Exception {
    PatchJobs.PatchJob expectedResponse =
        PatchJobs.PatchJob.newBuilder()
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
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
            .setPatchDeployment(
                PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
            .setRollout(PatchJobs.PatchRollout.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PatchJobs.CancelPatchJobRequest request =
        PatchJobs.CancelPatchJobRequest.newBuilder()
            .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
            .build();

    PatchJobs.PatchJob actualResponse = client.cancelPatchJob(request);
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
  public void cancelPatchJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(parent);

    List<PatchJobs.PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

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
  public void listPatchJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListPatchJobsPagedResponse pagedListResponse = client.listPatchJobs(parent);

    List<PatchJobs.PatchJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobsList().get(0), resources.get(0));

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
  public void listPatchJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");

    ListPatchJobInstanceDetailsPagedResponse pagedListResponse =
        client.listPatchJobInstanceDetails(parent);

    List<PatchJobs.PatchJobInstanceDetails> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobInstanceDetailsList().get(0), resources.get(0));

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
  public void listPatchJobInstanceDetailsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1881/patchJobs/patchJob-1881";

    ListPatchJobInstanceDetailsPagedResponse pagedListResponse =
        client.listPatchJobInstanceDetails(parent);

    List<PatchJobs.PatchJobInstanceDetails> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchJobInstanceDetailsList().get(0), resources.get(0));

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
  public void listPatchJobInstanceDetailsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1881/patchJobs/patchJob-1881";
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder().build();
    String patchDeploymentId = "patchDeploymentId-1180405976";

    PatchDeployments.PatchDeployment actualResponse =
        client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
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
  public void createPatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder().build();
    String patchDeploymentId = "patchDeploymentId-1180405976";

    PatchDeployments.PatchDeployment actualResponse =
        client.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
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
  public void createPatchDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.getPatchDeployment(name);
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
  public void getPatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2608/patchDeployments/patchDeployment-2608";

    PatchDeployments.PatchDeployment actualResponse = client.getPatchDeployment(name);
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
  public void getPatchDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2608/patchDeployments/patchDeployment-2608";
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(parent);

    List<PatchDeployments.PatchDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

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
  public void listPatchDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListPatchDeploymentsPagedResponse pagedListResponse = client.listPatchDeployments(parent);

    List<PatchDeployments.PatchDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPatchDeploymentsList().get(0), resources.get(0));

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
  public void listPatchDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listPatchDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePatchDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    client.deletePatchDeployment(name);

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
  public void deletePatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2608/patchDeployments/patchDeployment-2608";

    client.deletePatchDeployment(name);

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
  public void deletePatchDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2608/patchDeployments/patchDeployment-2608";
      client.deletePatchDeployment(name);
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
    mockService.addResponse(expectedResponse);

    PatchDeployments.PatchDeployment patchDeployment =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    PatchDeployments.PatchDeployment actualResponse =
        client.updatePatchDeployment(patchDeployment, updateMask);
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
  public void updatePatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PatchDeployments.PatchDeployment patchDeployment =
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
    mockService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.pausePatchDeployment(name);
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
  public void pausePatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2608/patchDeployments/patchDeployment-2608";

    PatchDeployments.PatchDeployment actualResponse = client.pausePatchDeployment(name);
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
  public void pausePatchDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2608/patchDeployments/patchDeployment-2608";
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
    mockService.addResponse(expectedResponse);

    PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");

    PatchDeployments.PatchDeployment actualResponse = client.resumePatchDeployment(name);
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
  public void resumePatchDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2608/patchDeployments/patchDeployment-2608";

    PatchDeployments.PatchDeployment actualResponse = client.resumePatchDeployment(name);
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
  public void resumePatchDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2608/patchDeployments/patchDeployment-2608";
      client.resumePatchDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
