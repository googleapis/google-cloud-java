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

package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.JobServiceClient.ListJobsPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsForAlertPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class JobServiceClientTest {
  private static MockJobService mockJobService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private JobServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockJobService = new MockJobService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockJobService));
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
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = JobServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Job job = Job.newBuilder().build();
      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Job job = Job.newBuilder().build();
      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTest3() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Job job = Job.newBuilder().build();

    Job actualResponse = client.createJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      Job job = Job.newBuilder().build();
      client.createJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateJobsTest() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateJobsRequest actualRequest = ((BatchCreateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      List<Job> jobs = new ArrayList<>();
      client.batchCreateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreateJobsTest2() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateJobsRequest actualRequest = ((BatchCreateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<Job> jobs = new ArrayList<>();
      client.batchCreateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreateJobsTest3() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateJobsRequest actualRequest = ((BatchCreateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateJobsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<Job> jobs = new ArrayList<>();
      client.batchCreateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .setApplicationInfo(Job.ApplicationInfo.newBuilder().build())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setJobLevel(JobLevel.forNumber(0))
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setPostingRegion(PostingRegion.forNumber(0))
            .setVisibility(Visibility.forNumber(0))
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .setDerivedInfo(Job.DerivedInfo.newBuilder().build())
            .setProcessingOptions(Job.ProcessingOptions.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    Job job = Job.newBuilder().build();

    Job actualResponse = client.updateJob(job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = ((UpdateJobRequest) actualRequests.get(0));

    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      Job job = Job.newBuilder().build();
      client.updateJob(job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateJobsTest() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateJobsRequest actualRequest = ((BatchUpdateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      List<Job> jobs = new ArrayList<>();
      client.batchUpdateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchUpdateJobsTest2() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateJobsRequest actualRequest = ((BatchUpdateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<Job> jobs = new ArrayList<>();
      client.batchUpdateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchUpdateJobsTest3() throws Exception {
    JobOperationResult expectedResponse =
        JobOperationResult.newBuilder()
            .addAllJobResults(new ArrayList<JobOperationResult.JobResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<Job> jobs = new ArrayList<>();

    JobOperationResult actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateJobsRequest actualRequest = ((BatchUpdateJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(jobs, actualRequest.getJobsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateJobsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<Job> jobs = new ArrayList<>();
      client.batchUpdateJobsAsync(parent, jobs).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = ((DeleteJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobRequest actualRequest = ((DeleteJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteJobsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    client.batchDeleteJobs(parent, filter);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = ((BatchDeleteJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.batchDeleteJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteJobsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    String filter = "filter-1274492040";

    client.batchDeleteJobs(parent, filter);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = ((BatchDeleteJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      String filter = "filter-1274492040";
      client.batchDeleteJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteJobsTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    client.batchDeleteJobs(parent, filter);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = ((BatchDeleteJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteJobsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.batchDeleteJobs(parent, filter);
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
    mockJobService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listJobs(parent, filter);
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
    mockJobService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      String filter = "filter-1274492040";
      client.listJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest3() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent, filter);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchJobsTest() throws Exception {
    SearchJobsResponse.MatchingJob responsesElement =
        SearchJobsResponse.MatchingJob.newBuilder().build();
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMatchingJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setRequestMetadata(RequestMetadata.newBuilder().build())
            .setJobQuery(JobQuery.newBuilder().build())
            .setEnableBroadening(true)
            .setRequirePreciseResultSize(true)
            .addAllHistogramQueries(new ArrayList<HistogramQuery>())
            .setJobView(JobView.forNumber(0))
            .setOffset(-1019779949)
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOrderBy("orderBy-1207110587")
            .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
            .setDisableKeywordMatch(true)
            .build();

    SearchJobsPagedResponse pagedListResponse = client.searchJobs(request);

    List<SearchJobsResponse.MatchingJob> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = ((SearchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(request.getRequestMetadata(), actualRequest.getRequestMetadata());
    Assert.assertEquals(request.getJobQuery(), actualRequest.getJobQuery());
    Assert.assertEquals(request.getEnableBroadening(), actualRequest.getEnableBroadening());
    Assert.assertEquals(
        request.getRequirePreciseResultSize(), actualRequest.getRequirePreciseResultSize());
    Assert.assertEquals(request.getHistogramQueriesList(), actualRequest.getHistogramQueriesList());
    Assert.assertEquals(request.getJobView(), actualRequest.getJobView());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getDiversificationLevel(), actualRequest.getDiversificationLevel());
    Assert.assertEquals(request.getCustomRankingInfo(), actualRequest.getCustomRankingInfo());
    Assert.assertEquals(request.getDisableKeywordMatch(), actualRequest.getDisableKeywordMatch());
    Assert.assertEquals(request.getKeywordMatchMode(), actualRequest.getKeywordMatchMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setJobQuery(JobQuery.newBuilder().build())
              .setEnableBroadening(true)
              .setRequirePreciseResultSize(true)
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setJobView(JobView.forNumber(0))
              .setOffset(-1019779949)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
              .setDisableKeywordMatch(true)
              .build();
      client.searchJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchJobsForAlertTest() throws Exception {
    SearchJobsResponse.MatchingJob responsesElement =
        SearchJobsResponse.MatchingJob.newBuilder().build();
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMatchingJobs(Arrays.asList(responsesElement))
            .build();
    mockJobService.addResponse(expectedResponse);

    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setRequestMetadata(RequestMetadata.newBuilder().build())
            .setJobQuery(JobQuery.newBuilder().build())
            .setEnableBroadening(true)
            .setRequirePreciseResultSize(true)
            .addAllHistogramQueries(new ArrayList<HistogramQuery>())
            .setJobView(JobView.forNumber(0))
            .setOffset(-1019779949)
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOrderBy("orderBy-1207110587")
            .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
            .setDisableKeywordMatch(true)
            .build();

    SearchJobsForAlertPagedResponse pagedListResponse = client.searchJobsForAlert(request);

    List<SearchJobsResponse.MatchingJob> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = ((SearchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(request.getRequestMetadata(), actualRequest.getRequestMetadata());
    Assert.assertEquals(request.getJobQuery(), actualRequest.getJobQuery());
    Assert.assertEquals(request.getEnableBroadening(), actualRequest.getEnableBroadening());
    Assert.assertEquals(
        request.getRequirePreciseResultSize(), actualRequest.getRequirePreciseResultSize());
    Assert.assertEquals(request.getHistogramQueriesList(), actualRequest.getHistogramQueriesList());
    Assert.assertEquals(request.getJobView(), actualRequest.getJobView());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getDiversificationLevel(), actualRequest.getDiversificationLevel());
    Assert.assertEquals(request.getCustomRankingInfo(), actualRequest.getCustomRankingInfo());
    Assert.assertEquals(request.getDisableKeywordMatch(), actualRequest.getDisableKeywordMatch());
    Assert.assertEquals(request.getKeywordMatchMode(), actualRequest.getKeywordMatchMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchJobsForAlertExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockJobService.addException(exception);

    try {
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setJobQuery(JobQuery.newBuilder().build())
              .setEnableBroadening(true)
              .setRequirePreciseResultSize(true)
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setJobView(JobView.forNumber(0))
              .setOffset(-1019779949)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
              .setDisableKeywordMatch(true)
              .build();
      client.searchJobsForAlert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
