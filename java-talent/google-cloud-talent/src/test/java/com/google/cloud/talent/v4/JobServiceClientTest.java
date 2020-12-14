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

package com.google.cloud.talent.v4;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

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
import com.google.protobuf.FieldMask;
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
  private static MockServiceHelper mockServiceHelper;
  private JobServiceClient client;
  private static MockJobService mockJobService;
  private LocalChannelProvider channelProvider;

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
            .setName(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
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
  public void createJobExceptionTest() throws Exception {
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
  public void createJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
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
  public void createJobExceptionTest2() throws Exception {
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
    BatchCreateJobsResponse expectedResponse =
        BatchCreateJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    BatchCreateJobsResponse actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
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
  public void batchCreateJobsTest2() throws Exception {
    BatchCreateJobsResponse expectedResponse =
        BatchCreateJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<Job> jobs = new ArrayList<>();

    BatchCreateJobsResponse actualResponse = client.batchCreateJobsAsync(parent, jobs).get();
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
  public void batchCreateJobsExceptionTest2() throws Exception {
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
            .setName(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .build();
    mockJobService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

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
      JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");
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
            .setName(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
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
            .setName(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setRequisitionId("requisitionId-1769495849")
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .addAllAddresses(new ArrayList<String>())
            .addAllJobBenefits(new ArrayList<JobBenefit>())
            .setCompensationInfo(CompensationInfo.newBuilder().build())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .addAllDegreeTypes(new ArrayList<DegreeType>())
            .setDepartment("department848184146")
            .addAllEmploymentTypes(new ArrayList<EmploymentType>())
            .setIncentives("incentives-1262874520")
            .setLanguageCode("languageCode-2092349083")
            .setPromotionValue(353413845)
            .setQualifications("qualifications1903501412")
            .setResponsibilities("responsibilities-926952660")
            .setJobStartTime(Timestamp.newBuilder().build())
            .setJobEndTime(Timestamp.newBuilder().build())
            .setPostingPublishTime(Timestamp.newBuilder().build())
            .setPostingExpireTime(Timestamp.newBuilder().build())
            .setPostingCreateTime(Timestamp.newBuilder().build())
            .setPostingUpdateTime(Timestamp.newBuilder().build())
            .setCompanyDisplayName("companyDisplayName-686915152")
            .build();
    mockJobService.addResponse(expectedResponse);

    Job job = Job.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Job actualResponse = client.updateJob(job, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobRequest actualRequest = ((UpdateJobRequest) actualRequests.get(0));

    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateJob(job, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateJobsTest() throws Exception {
    BatchUpdateJobsResponse expectedResponse =
        BatchUpdateJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<Job> jobs = new ArrayList<>();

    BatchUpdateJobsResponse actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
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
  public void batchUpdateJobsTest2() throws Exception {
    BatchUpdateJobsResponse expectedResponse =
        BatchUpdateJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<Job> jobs = new ArrayList<>();

    BatchUpdateJobsResponse actualResponse = client.batchUpdateJobsAsync(parent, jobs).get();
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
  public void batchUpdateJobsExceptionTest2() throws Exception {
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

    JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");

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
      JobName name = JobName.of("[PROJECT]", "[TENANT]", "[JOB]");
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
    BatchDeleteJobsResponse expectedResponse =
        BatchDeleteJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    List<String> names = new ArrayList<>();

    BatchDeleteJobsResponse actualResponse = client.batchDeleteJobsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = ((BatchDeleteJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
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
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      List<String> names = new ArrayList<>();
      client.batchDeleteJobsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchDeleteJobsTest2() throws Exception {
    BatchDeleteJobsResponse expectedResponse =
        BatchDeleteJobsResponse.newBuilder().addAllJobResults(new ArrayList<JobResult>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteJobsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockJobService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    BatchDeleteJobsResponse actualResponse = client.batchDeleteJobsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteJobsRequest actualRequest = ((BatchDeleteJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
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
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.batchDeleteJobsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
  public void listJobsExceptionTest() throws Exception {
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
  public void listJobsTest2() throws Exception {
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
  public void listJobsExceptionTest2() throws Exception {
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
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .addAllMatchingJobs(new ArrayList<SearchJobsResponse.MatchingJob>())
            .addAllHistogramQueryResults(new ArrayList<HistogramQueryResult>())
            .setNextPageToken("nextPageToken-1386094857")
            .addAllLocationFilters(new ArrayList<Location>())
            .setTotalSize(-705419236)
            .setMetadata(ResponseMetadata.newBuilder().build())
            .setBroadenedQueryJobsCount(1432104658)
            .setSpellCorrection(SpellingCorrection.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setRequestMetadata(RequestMetadata.newBuilder().build())
            .setJobQuery(JobQuery.newBuilder().build())
            .setEnableBroadening(true)
            .addAllHistogramQueries(new ArrayList<HistogramQuery>())
            .setOffset(-1019779949)
            .setMaxPageSize(524069526)
            .setPageToken("pageToken873572522")
            .setOrderBy("orderBy-1207110587")
            .setDisableKeywordMatch(true)
            .build();

    SearchJobsResponse actualResponse = client.searchJobs(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = ((SearchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(request.getRequestMetadata(), actualRequest.getRequestMetadata());
    Assert.assertEquals(request.getJobQuery(), actualRequest.getJobQuery());
    Assert.assertEquals(request.getEnableBroadening(), actualRequest.getEnableBroadening());
    Assert.assertEquals(request.getHistogramQueriesList(), actualRequest.getHistogramQueriesList());
    Assert.assertEquals(request.getJobView(), actualRequest.getJobView());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getMaxPageSize(), actualRequest.getMaxPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getDiversificationLevel(), actualRequest.getDiversificationLevel());
    Assert.assertEquals(request.getCustomRankingInfo(), actualRequest.getCustomRankingInfo());
    Assert.assertEquals(request.getDisableKeywordMatch(), actualRequest.getDisableKeywordMatch());
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
              .setParent(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setJobQuery(JobQuery.newBuilder().build())
              .setEnableBroadening(true)
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setOffset(-1019779949)
              .setMaxPageSize(524069526)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
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
    SearchJobsResponse expectedResponse =
        SearchJobsResponse.newBuilder()
            .addAllMatchingJobs(new ArrayList<SearchJobsResponse.MatchingJob>())
            .addAllHistogramQueryResults(new ArrayList<HistogramQueryResult>())
            .setNextPageToken("nextPageToken-1386094857")
            .addAllLocationFilters(new ArrayList<Location>())
            .setTotalSize(-705419236)
            .setMetadata(ResponseMetadata.newBuilder().build())
            .setBroadenedQueryJobsCount(1432104658)
            .setSpellCorrection(SpellingCorrection.newBuilder().build())
            .build();
    mockJobService.addResponse(expectedResponse);

    SearchJobsRequest request =
        SearchJobsRequest.newBuilder()
            .setParent(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
            .setRequestMetadata(RequestMetadata.newBuilder().build())
            .setJobQuery(JobQuery.newBuilder().build())
            .setEnableBroadening(true)
            .addAllHistogramQueries(new ArrayList<HistogramQuery>())
            .setOffset(-1019779949)
            .setMaxPageSize(524069526)
            .setPageToken("pageToken873572522")
            .setOrderBy("orderBy-1207110587")
            .setDisableKeywordMatch(true)
            .build();

    SearchJobsResponse actualResponse = client.searchJobsForAlert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockJobService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchJobsRequest actualRequest = ((SearchJobsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(request.getRequestMetadata(), actualRequest.getRequestMetadata());
    Assert.assertEquals(request.getJobQuery(), actualRequest.getJobQuery());
    Assert.assertEquals(request.getEnableBroadening(), actualRequest.getEnableBroadening());
    Assert.assertEquals(request.getHistogramQueriesList(), actualRequest.getHistogramQueriesList());
    Assert.assertEquals(request.getJobView(), actualRequest.getJobView());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getMaxPageSize(), actualRequest.getMaxPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getDiversificationLevel(), actualRequest.getDiversificationLevel());
    Assert.assertEquals(request.getCustomRankingInfo(), actualRequest.getCustomRankingInfo());
    Assert.assertEquals(request.getDisableKeywordMatch(), actualRequest.getDisableKeywordMatch());
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
              .setParent(JobName.of("[PROJECT]", "[TENANT]", "[JOB]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setJobQuery(JobQuery.newBuilder().build())
              .setEnableBroadening(true)
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setOffset(-1019779949)
              .setMaxPageSize(524069526)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .setDisableKeywordMatch(true)
              .build();
      client.searchJobsForAlert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
