/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storagebatchoperations.v1;

import static com.google.cloud.storagebatchoperations.v1.StorageBatchOperationsClient.ListJobsPagedResponse;
import static com.google.cloud.storagebatchoperations.v1.StorageBatchOperationsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class StorageBatchOperationsClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockStorageBatchOperations mockStorageBatchOperations;
  private LocalChannelProvider channelProvider;
  private StorageBatchOperationsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStorageBatchOperations = new MockStorageBatchOperations();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockStorageBatchOperations, mockLocations));
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
    StorageBatchOperationsSettings settings =
        StorageBatchOperationsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageBatchOperationsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listJobs(parent);
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
    mockStorageBatchOperations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setCounters(Counters.newBuilder().build())
            .addAllErrorSummaries(new ArrayList<ErrorSummary>())
            .build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
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
    mockStorageBatchOperations.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
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
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setCounters(Counters.newBuilder().build())
            .addAllErrorSummaries(new ArrayList<ErrorSummary>())
            .build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
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
    mockStorageBatchOperations.addException(exception);

    try {
      String name = "name3373707";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setCounters(Counters.newBuilder().build())
            .addAllErrorSummaries(new ArrayList<ErrorSummary>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageBatchOperations.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Job job = Job.newBuilder().build();
    String jobId = "jobId101296568";

    Job actualResponse = client.createJobAsync(parent, job, jobId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(jobId, actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Job job = Job.newBuilder().build();
      String jobId = "jobId101296568";
      client.createJobAsync(parent, job, jobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
            .setDescription("description-1724546052")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setCounters(Counters.newBuilder().build())
            .addAllErrorSummaries(new ArrayList<ErrorSummary>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageBatchOperations.addResponse(resultOperation);

    String parent = "parent-995424086";
    Job job = Job.newBuilder().build();
    String jobId = "jobId101296568";

    Job actualResponse = client.createJobAsync(parent, job, jobId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobRequest actualRequest = ((CreateJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertEquals(jobId, actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      String parent = "parent-995424086";
      Job job = Job.newBuilder().build();
      String jobId = "jobId101296568";
      client.createJobAsync(parent, job, jobId).get();
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
    mockStorageBatchOperations.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
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
    mockStorageBatchOperations.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteJob(name);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
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
    mockStorageBatchOperations.addException(exception);

    try {
      String name = "name3373707";
      client.deleteJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest() throws Exception {
    CancelJobResponse expectedResponse = CancelJobResponse.newBuilder().build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");

    CancelJobResponse actualResponse = client.cancelJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelJobRequest actualRequest = ((CancelJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
      client.cancelJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest2() throws Exception {
    CancelJobResponse expectedResponse = CancelJobResponse.newBuilder().build();
    mockStorageBatchOperations.addResponse(expectedResponse);

    String name = "name3373707";

    CancelJobResponse actualResponse = client.cancelJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageBatchOperations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelJobRequest actualRequest = ((CancelJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageBatchOperations.addException(exception);

    try {
      String name = "name3373707";
      client.cancelJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
