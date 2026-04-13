/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.appoptimize.v1beta;

import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListLocationsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListReportsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ReadReportPagedResponse;

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
import com.google.protobuf.ListValue;
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
public class AppOptimizeClientTest {
  private static MockAppOptimize mockAppOptimize;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AppOptimizeClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAppOptimize = new MockAppOptimize();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAppOptimize, mockLocations));
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
    AppOptimizeSettings settings =
        AppOptimizeSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AppOptimizeClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
            .addAllDimensions(new ArrayList<String>())
            .addAllMetrics(new ArrayList<String>())
            .addAllScopes(new ArrayList<Scope>())
            .setFilter("filter-1274492040")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppOptimize.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Report report = Report.newBuilder().build();
    String reportId = "reportId-427040401";

    Report actualResponse = client.createReportAsync(parent, report, reportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReportRequest actualRequest = ((CreateReportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(report, actualRequest.getReport());
    Assert.assertEquals(reportId, actualRequest.getReportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Report report = Report.newBuilder().build();
      String reportId = "reportId-427040401";
      client.createReportAsync(parent, report, reportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
            .addAllDimensions(new ArrayList<String>())
            .addAllMetrics(new ArrayList<String>())
            .addAllScopes(new ArrayList<Scope>())
            .setFilter("filter-1274492040")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppOptimize.addResponse(resultOperation);

    String parent = "parent-995424086";
    Report report = Report.newBuilder().build();
    String reportId = "reportId-427040401";

    Report actualResponse = client.createReportAsync(parent, report, reportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReportRequest actualRequest = ((CreateReportRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(report, actualRequest.getReport());
    Assert.assertEquals(reportId, actualRequest.getReportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      String parent = "parent-995424086";
      Report report = Report.newBuilder().build();
      String reportId = "reportId-427040401";
      client.createReportAsync(parent, report, reportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
            .addAllDimensions(new ArrayList<String>())
            .addAllMetrics(new ArrayList<String>())
            .addAllScopes(new ArrayList<Scope>())
            .setFilter("filter-1274492040")
            .build();
    mockAppOptimize.addResponse(expectedResponse);

    ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");

    Report actualResponse = client.getReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportRequest actualRequest = ((GetReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
      client.getReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
            .addAllDimensions(new ArrayList<String>())
            .addAllMetrics(new ArrayList<String>())
            .addAllScopes(new ArrayList<Scope>())
            .setFilter("filter-1274492040")
            .build();
    mockAppOptimize.addResponse(expectedResponse);

    String name = "name3373707";

    Report actualResponse = client.getReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportRequest actualRequest = ((GetReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      String name = "name3373707";
      client.getReport(name);
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
    mockAppOptimize.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportsRequest actualRequest = ((ListReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest2() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockAppOptimize.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportsRequest actualRequest = ((ListReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAppOptimize.addResponse(expectedResponse);

    ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");

    client.deleteReport(name);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReportRequest actualRequest = ((DeleteReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
      client.deleteReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAppOptimize.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteReport(name);

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReportRequest actualRequest = ((DeleteReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readReportTest() throws Exception {
    ListValue responsesElement = ListValue.newBuilder().build();
    ReadReportResponse expectedResponse =
        ReadReportResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockAppOptimize.addResponse(expectedResponse);

    ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");

    ReadReportPagedResponse pagedListResponse = client.readReport(name);

    List<ListValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadReportRequest actualRequest = ((ReadReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
      client.readReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readReportTest2() throws Exception {
    ListValue responsesElement = ListValue.newBuilder().build();
    ReadReportResponse expectedResponse =
        ReadReportResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockAppOptimize.addResponse(expectedResponse);

    String name = "name3373707";

    ReadReportPagedResponse pagedListResponse = client.readReport(name);

    List<ListValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppOptimize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadReportRequest actualRequest = ((ReadReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppOptimize.addException(exception);

    try {
      String name = "name3373707";
      client.readReport(name);
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
