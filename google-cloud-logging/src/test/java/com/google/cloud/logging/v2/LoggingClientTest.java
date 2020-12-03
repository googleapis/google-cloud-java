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
package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.LoggingClient.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListLogsPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class LoggingClientTest {
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockLoggingServiceV2 mockLoggingServiceV2;
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper serviceHelper;
  private LoggingClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockLoggingServiceV2 = new MockLoggingServiceV2();
    mockMetricsServiceV2 = new MockMetricsServiceV2();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockConfigServiceV2, mockLoggingServiceV2, mockMetricsServiceV2));
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
    LoggingSettings settings =
        LoggingSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LoggingClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteLogTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");

    client.deleteLog(logName);

    List<AbstractMessage> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogRequest actualRequest = (DeleteLogRequest) actualRequests.get(0);

    Assert.assertEquals(logName, LogName.parse(actualRequest.getLogName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteLogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);

    try {
      LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");

      client.deleteLog(logName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listLogEntriesTest() {
    String nextPageToken = "";
    LogEntry entriesElement = LogEntry.newBuilder().build();
    List<LogEntry> entries = Arrays.asList(entriesElement);
    ListLogEntriesResponse expectedResponse =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEntries(entries)
            .build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    List<String> formattedResourceNames = new ArrayList<>();
    String filter = "filter-1274492040";
    String orderBy = "orderBy1234304744";

    ListLogEntriesPagedResponse pagedListResponse =
        client.listLogEntries(formattedResourceNames, filter, orderBy);

    List<LogEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogEntriesRequest actualRequest = (ListLogEntriesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResourceNames, actualRequest.getResourceNamesList());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(orderBy, actualRequest.getOrderBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);

    try {
      List<String> formattedResourceNames = new ArrayList<>();
      String filter = "filter-1274492040";
      String orderBy = "orderBy1234304744";

      client.listLogEntries(formattedResourceNames, filter, orderBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void writeLogEntriesTest() {
    WriteLogEntriesResponse expectedResponse = WriteLogEntriesResponse.newBuilder().build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    Map<String, String> labels = new HashMap<>();
    List<LogEntry> entries = new ArrayList<>();

    WriteLogEntriesResponse actualResponse =
        client.writeLogEntries(logName, resource, labels, entries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteLogEntriesRequest actualRequest = (WriteLogEntriesRequest) actualRequests.get(0);

    Assert.assertEquals(logName, LogName.parse(actualRequest.getLogName()));
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(labels, actualRequest.getLabelsMap());
    Assert.assertEquals(entries, actualRequest.getEntriesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void writeLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);

    try {
      LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");
      MonitoredResource resource = MonitoredResource.newBuilder().build();
      Map<String, String> labels = new HashMap<>();
      List<LogEntry> entries = new ArrayList<>();

      client.writeLogEntries(logName, resource, labels, entries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsTest() {
    String nextPageToken = "";
    MonitoredResourceDescriptor resourceDescriptorsElement =
        MonitoredResourceDescriptor.newBuilder().build();
    List<MonitoredResourceDescriptor> resourceDescriptors =
        Arrays.asList(resourceDescriptorsElement);
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllResourceDescriptors(resourceDescriptors)
            .build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();

    ListMonitoredResourceDescriptorsPagedResponse pagedListResponse =
        client.listMonitoredResourceDescriptors(request);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        (ListMonitoredResourceDescriptorsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);

    try {
      ListMonitoredResourceDescriptorsRequest request =
          ListMonitoredResourceDescriptorsRequest.newBuilder().build();

      client.listMonitoredResourceDescriptors(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listLogsTest() {
    String nextPageToken = "";
    String logNamesElement = "logNamesElement-1079688374";
    List<String> logNames = Arrays.asList(logNamesElement);
    ListLogsResponse expectedResponse =
        ListLogsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllLogNames(logNames)
            .build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListLogsPagedResponse pagedListResponse = client.listLogs(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogNamesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogsRequest actualRequest = (ListLogsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listLogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void tailLogEntriesTest() throws Exception {
    TailLogEntriesResponse expectedResponse = TailLogEntriesResponse.newBuilder().build();
    mockLoggingServiceV2.addResponse(expectedResponse);
    List<String> resourceNames = new ArrayList<>();
    TailLogEntriesRequest request =
        TailLogEntriesRequest.newBuilder().addAllResourceNames(resourceNames).build();

    MockStreamObserver<TailLogEntriesResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse> callable =
        client.tailLogEntriesCallable();
    ApiStreamObserver<TailLogEntriesRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<TailLogEntriesResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void tailLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockLoggingServiceV2.addException(exception);
    List<String> resourceNames = new ArrayList<>();
    TailLogEntriesRequest request =
        TailLogEntriesRequest.newBuilder().addAllResourceNames(resourceNames).build();

    MockStreamObserver<TailLogEntriesResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse> callable =
        client.tailLogEntriesCallable();
    ApiStreamObserver<TailLogEntriesRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<TailLogEntriesResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
