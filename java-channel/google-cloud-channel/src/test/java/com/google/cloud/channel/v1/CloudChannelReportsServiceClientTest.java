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

package com.google.cloud.channel.v1;

import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.FetchReportResultsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.ListReportsPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
public class CloudChannelReportsServiceClientTest {
  private static MockCloudChannelReportsService mockCloudChannelReportsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudChannelReportsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudChannelReportsService = new MockCloudChannelReportsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudChannelReportsService));
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
    CloudChannelReportsServiceSettings settings =
        CloudChannelReportsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudChannelReportsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void runReportJobTest() throws Exception {
    RunReportJobResponse expectedResponse =
        RunReportJobResponse.newBuilder()
            .setReportJob(ReportJob.newBuilder().build())
            .setReportMetadata(ReportResultsMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runReportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelReportsService.addResponse(resultOperation);

    RunReportJobRequest request =
        RunReportJobRequest.newBuilder()
            .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
            .setDateRange(DateRange.newBuilder().build())
            .setFilter("filter-1274492040")
            .setLanguageCode("languageCode-2092349083")
            .build();

    RunReportJobResponse actualResponse = client.runReportJobAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelReportsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunReportJobRequest actualRequest = ((RunReportJobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getDateRange(), actualRequest.getDateRange());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runReportJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelReportsService.addException(exception);

    try {
      RunReportJobRequest request =
          RunReportJobRequest.newBuilder()
              .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
              .setDateRange(DateRange.newBuilder().build())
              .setFilter("filter-1274492040")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.runReportJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchReportResultsTest() throws Exception {
    Row responsesElement = Row.newBuilder().build();
    FetchReportResultsResponse expectedResponse =
        FetchReportResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelReportsService.addResponse(expectedResponse);

    ReportJobName reportJob = ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]");

    FetchReportResultsPagedResponse pagedListResponse = client.fetchReportResults(reportJob);

    List<Row> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelReportsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReportResultsRequest actualRequest = ((FetchReportResultsRequest) actualRequests.get(0));

    Assert.assertEquals(reportJob.toString(), actualRequest.getReportJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReportResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelReportsService.addException(exception);

    try {
      ReportJobName reportJob = ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]");
      client.fetchReportResults(reportJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchReportResultsTest2() throws Exception {
    Row responsesElement = Row.newBuilder().build();
    FetchReportResultsResponse expectedResponse =
        FetchReportResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelReportsService.addResponse(expectedResponse);

    String reportJob = "reportJob-353349143";

    FetchReportResultsPagedResponse pagedListResponse = client.fetchReportResults(reportJob);

    List<Row> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelReportsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchReportResultsRequest actualRequest = ((FetchReportResultsRequest) actualRequests.get(0));

    Assert.assertEquals(reportJob, actualRequest.getReportJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchReportResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelReportsService.addException(exception);

    try {
      String reportJob = "reportJob-353349143";
      client.fetchReportResults(reportJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelReportsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelReportsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportsRequest actualRequest = ((ListReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelReportsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
