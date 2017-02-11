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
package com.google.cloud.errorreporting.spi.v1beta1;

import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListGroupStatsPagedResponse;

import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ErrorStatsServiceClientTest {
  private static MockErrorGroupService mockErrorGroupService;
  private static MockErrorStatsService mockErrorStatsService;
  private static MockReportErrorsService mockReportErrorsService;
  private static MockServiceHelper serviceHelper;
  private ErrorStatsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockErrorGroupService = new MockErrorGroupService();
    mockErrorStatsService = new MockErrorStatsService();
    mockReportErrorsService = new MockReportErrorsService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockErrorGroupService, mockErrorStatsService, mockReportErrorsService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    ErrorStatsServiceSettings settings =
        ErrorStatsServiceSettings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .build();
    client = ErrorStatsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupStatsTest() {
    String nextPageToken = "";
    ErrorGroupStats errorGroupStatsElement = ErrorGroupStats.newBuilder().build();
    List<ErrorGroupStats> errorGroupStats = Arrays.asList(errorGroupStatsElement);
    ListGroupStatsResponse expectedResponse =
        ListGroupStatsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllErrorGroupStats(errorGroupStats)
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.create("[PROJECT]");
    QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();

    ListGroupStatsPagedResponse pagedListResponse = client.listGroupStats(projectName, timeRange);

    List<ErrorGroupStats> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorGroupStatsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupStatsRequest actualRequest = (ListGroupStatsRequest) actualRequests.get(0);

    Assert.assertEquals(projectName, actualRequest.getProjectNameAsProjectName());
    Assert.assertEquals(timeRange, actualRequest.getTimeRange());
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.create("[PROJECT]");
      QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();

      client.listGroupStats(projectName, timeRange);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listEventsTest() {
    String nextPageToken = "";
    ErrorEvent errorEventsElement = ErrorEvent.newBuilder().build();
    List<ErrorEvent> errorEvents = Arrays.asList(errorEventsElement);
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllErrorEvents(errorEvents)
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.create("[PROJECT]");
    String groupId = "groupId506361563";

    ListEventsPagedResponse pagedListResponse = client.listEvents(projectName, groupId);

    List<ErrorEvent> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorEventsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = (ListEventsRequest) actualRequests.get(0);

    Assert.assertEquals(projectName, actualRequest.getProjectNameAsProjectName());
    Assert.assertEquals(groupId, actualRequest.getGroupId());
  }

  @Test
  @SuppressWarnings("all")
  public void listEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.create("[PROJECT]");
      String groupId = "groupId506361563";

      client.listEvents(projectName, groupId);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEventsTest() {
    DeleteEventsResponse expectedResponse = DeleteEventsResponse.newBuilder().build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.create("[PROJECT]");

    DeleteEventsResponse actualResponse = client.deleteEvents(projectName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventsRequest actualRequest = (DeleteEventsRequest) actualRequests.get(0);

    Assert.assertEquals(projectName, actualRequest.getProjectNameAsProjectName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.create("[PROJECT]");

      client.deleteEvents(projectName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
