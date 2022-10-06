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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.JobControllerClient.ListJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonJobControllerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class JobControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static JobControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonJobControllerStub.getMethodDescriptors(),
            JobControllerSettings.getDefaultEndpoint());
    JobControllerSettings settings =
        JobControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                JobControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobControllerClient.create(settings);
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
  public void submitJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setReference(JobReference.newBuilder().build())
            .setPlacement(JobPlacement.newBuilder().build())
            .setStatus(JobStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<JobStatus>())
            .addAllYarnApplications(new ArrayList<YarnApplication>())
            .setDriverOutputResourceUri("driverOutputResourceUri794556277")
            .setDriverControlFilesUri("driverControlFilesUri1491948202")
            .putAllLabels(new HashMap<String, String>())
            .setScheduling(JobScheduling.newBuilder().build())
            .setJobUuid("jobUuid-1437868776")
            .setDone(true)
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.submitJob(projectId, region, job);
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
  public void submitJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      Job job = Job.newBuilder().build();
      client.submitJob(projectId, region, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitJobAsOperationTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setReference(JobReference.newBuilder().build())
            .setPlacement(JobPlacement.newBuilder().build())
            .setStatus(JobStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<JobStatus>())
            .addAllYarnApplications(new ArrayList<YarnApplication>())
            .setDriverOutputResourceUri("driverOutputResourceUri794556277")
            .setDriverControlFilesUri("driverControlFilesUri1491948202")
            .putAllLabels(new HashMap<String, String>())
            .setScheduling(JobScheduling.newBuilder().build())
            .setJobUuid("jobUuid-1437868776")
            .setDone(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitJobAsOperationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String region = "region-9622";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.submitJobAsOperationAsync(projectId, region, job).get();
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
  public void submitJobAsOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      Job job = Job.newBuilder().build();
      client.submitJobAsOperationAsync(projectId, region, job).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setReference(JobReference.newBuilder().build())
            .setPlacement(JobPlacement.newBuilder().build())
            .setStatus(JobStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<JobStatus>())
            .addAllYarnApplications(new ArrayList<YarnApplication>())
            .setDriverOutputResourceUri("driverOutputResourceUri794556277")
            .setDriverControlFilesUri("driverControlFilesUri1491948202")
            .putAllLabels(new HashMap<String, String>())
            .setScheduling(JobScheduling.newBuilder().build())
            .setJobUuid("jobUuid-1437868776")
            .setDone(true)
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String jobId = "jobId-3646";

    Job actualResponse = client.getJob(projectId, region, jobId);
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
  public void getJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      String jobId = "jobId-3646";
      client.getJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";

    ListJobsPagedResponse pagedListResponse = client.listJobs(projectId, region);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void listJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      client.listJobs(projectId, region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest2() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(projectId, region, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void listJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      String filter = "filter-1274492040";
      client.listJobs(projectId, region, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setReference(JobReference.newBuilder().build())
            .setPlacement(JobPlacement.newBuilder().build())
            .setStatus(JobStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<JobStatus>())
            .addAllYarnApplications(new ArrayList<YarnApplication>())
            .setDriverOutputResourceUri("driverOutputResourceUri794556277")
            .setDriverControlFilesUri("driverControlFilesUri1491948202")
            .putAllLabels(new HashMap<String, String>())
            .setScheduling(JobScheduling.newBuilder().build())
            .setJobUuid("jobUuid-1437868776")
            .setDone(true)
            .build();
    mockService.addResponse(expectedResponse);

    UpdateJobRequest request =
        UpdateJobRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setRegion("region-9622")
            .setJobId("jobId-3646")
            .setJob(Job.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Job actualResponse = client.updateJob(request);
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
  public void updateJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateJobRequest request =
          UpdateJobRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setRegion("region-9622")
              .setJobId("jobId-3646")
              .setJob(Job.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setReference(JobReference.newBuilder().build())
            .setPlacement(JobPlacement.newBuilder().build())
            .setStatus(JobStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<JobStatus>())
            .addAllYarnApplications(new ArrayList<YarnApplication>())
            .setDriverOutputResourceUri("driverOutputResourceUri794556277")
            .setDriverControlFilesUri("driverControlFilesUri1491948202")
            .putAllLabels(new HashMap<String, String>())
            .setScheduling(JobScheduling.newBuilder().build())
            .setJobUuid("jobUuid-1437868776")
            .setDone(true)
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String jobId = "jobId-3646";

    Job actualResponse = client.cancelJob(projectId, region, jobId);
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
  public void cancelJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      String jobId = "jobId-3646";
      client.cancelJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String jobId = "jobId-3646";

    client.deleteJob(projectId, region, jobId);

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
  public void deleteJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      String jobId = "jobId-3646";
      client.deleteJob(projectId, region, jobId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
