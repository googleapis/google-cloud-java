/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.logging.spi.v2;

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogsPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogName;
import com.google.logging.v2.LogNameOneof;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class LoggingServiceV2ClientTest {
  private static MockLoggingServiceV2 mockLoggingServiceV2;
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper serviceHelper;
  private LoggingServiceV2Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockLoggingServiceV2 = new MockLoggingServiceV2();
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockMetricsServiceV2 = new MockMetricsServiceV2();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockLoggingServiceV2, mockConfigServiceV2, mockMetricsServiceV2));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    LoggingServiceV2Settings settings =
        LoggingServiceV2Settings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .build();
    client = LoggingServiceV2Client.create(settings);
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

    LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));

    client.deleteLog(logName);

    List<GeneratedMessageV3> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogRequest actualRequest = (DeleteLogRequest) actualRequests.get(0);

    Assert.assertEquals(logName, actualRequest.getLogNameAsLogNameOneof());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteLogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLoggingServiceV2.addException(exception);

    try {
      LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));

      client.deleteLog(logName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void writeLogEntriesTest() {
    WriteLogEntriesResponse expectedResponse = WriteLogEntriesResponse.newBuilder().build();
    mockLoggingServiceV2.addResponse(expectedResponse);

    LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    Map<String, String> labels = new HashMap<>();
    List<LogEntry> entries = new ArrayList<>();

    WriteLogEntriesResponse actualResponse =
        client.writeLogEntries(logName, resource, labels, entries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteLogEntriesRequest actualRequest = (WriteLogEntriesRequest) actualRequests.get(0);

    Assert.assertEquals(logName, actualRequest.getLogNameAsLogNameOneof());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(labels, actualRequest.getLabels());
    Assert.assertEquals(entries, actualRequest.getEntriesList());
  }

  @Test
  @SuppressWarnings("all")
  public void writeLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLoggingServiceV2.addException(exception);

    try {
      LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
      MonitoredResource resource = MonitoredResource.newBuilder().build();
      Map<String, String> labels = new HashMap<>();
      List<LogEntry> entries = new ArrayList<>();

      client.writeLogEntries(logName, resource, labels, entries);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
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

    List<String> resourceNames = new ArrayList<>();
    String filter = "filter-1274492040";
    String orderBy = "orderBy1234304744";

    ListLogEntriesPagedResponse pagedListResponse =
        client.listLogEntries(resourceNames, filter, orderBy);

    List<LogEntry> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogEntriesRequest actualRequest = (ListLogEntriesRequest) actualRequests.get(0);

    Assert.assertEquals(resourceNames, actualRequest.getResourceNamesList());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(orderBy, actualRequest.getOrderBy());
  }

  @Test
  @SuppressWarnings("all")
  public void listLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLoggingServiceV2.addException(exception);

    try {
      List<String> resourceNames = new ArrayList<>();
      String filter = "filter-1274492040";
      String orderBy = "orderBy1234304744";

      client.listLogEntries(resourceNames, filter, orderBy);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
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

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));

    ListLogsPagedResponse pagedListResponse = client.listLogs(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogNamesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockLoggingServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogsRequest actualRequest = (ListLogsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
  }

  @Test
  @SuppressWarnings("all")
  public void listLogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLoggingServiceV2.addException(exception);

    try {
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));

      client.listLogs(parent);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
