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

package com.google.cloud.errorreporting.v1beta1;

import static com.google.cloud.errorreporting.v1beta1.ErrorStatsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.v1beta1.ErrorStatsServiceClient.ListGroupStatsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
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
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ErrorStatsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockErrorStatsService mockErrorStatsService;
  private ErrorStatsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockErrorStatsService = new MockErrorStatsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockErrorStatsService));
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
    ErrorStatsServiceSettings settings =
        ErrorStatsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ErrorStatsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listGroupStatsTest() throws Exception {
    ErrorGroupStats responsesElement = ErrorGroupStats.newBuilder().build();
    ListGroupStatsResponse expectedResponse =
        ListGroupStatsResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorGroupStats(Arrays.asList(responsesElement))
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.of("[PROJECT]");
    QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();

    ListGroupStatsPagedResponse pagedListResponse = client.listGroupStats(projectName, timeRange);

    List<ErrorGroupStats> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorGroupStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupStatsRequest actualRequest = ((ListGroupStatsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName.toString(), actualRequest.getProjectName());
    Assert.assertEquals(timeRange, actualRequest.getTimeRange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.of("[PROJECT]");
      QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
      client.listGroupStats(projectName, timeRange);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupStatsTest2() throws Exception {
    ErrorGroupStats responsesElement = ErrorGroupStats.newBuilder().build();
    ListGroupStatsResponse expectedResponse =
        ListGroupStatsResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorGroupStats(Arrays.asList(responsesElement))
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    String projectName = "project_name939388913";
    QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();

    ListGroupStatsPagedResponse pagedListResponse = client.listGroupStats(projectName, timeRange);

    List<ErrorGroupStats> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorGroupStatsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupStatsRequest actualRequest = ((ListGroupStatsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName, actualRequest.getProjectName());
    Assert.assertEquals(timeRange, actualRequest.getTimeRange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupStatsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      String projectName = "project_name939388913";
      QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
      client.listGroupStats(projectName, timeRange);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest() throws Exception {
    ErrorEvent responsesElement = ErrorEvent.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorEvents(Arrays.asList(responsesElement))
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.of("[PROJECT]");
    String groupId = "group_id506361563";

    ListEventsPagedResponse pagedListResponse = client.listEvents(projectName, groupId);

    List<ErrorEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName.toString(), actualRequest.getProjectName());
    Assert.assertEquals(groupId, actualRequest.getGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.of("[PROJECT]");
      String groupId = "group_id506361563";
      client.listEvents(projectName, groupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest2() throws Exception {
    ErrorEvent responsesElement = ErrorEvent.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorEvents(Arrays.asList(responsesElement))
            .build();
    mockErrorStatsService.addResponse(expectedResponse);

    String projectName = "project_name939388913";
    String groupId = "group_id506361563";

    ListEventsPagedResponse pagedListResponse = client.listEvents(projectName, groupId);

    List<ErrorEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName, actualRequest.getProjectName());
    Assert.assertEquals(groupId, actualRequest.getGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      String projectName = "project_name939388913";
      String groupId = "group_id506361563";
      client.listEvents(projectName, groupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventsTest() throws Exception {
    DeleteEventsResponse expectedResponse = DeleteEventsResponse.newBuilder().build();
    mockErrorStatsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.of("[PROJECT]");

    DeleteEventsResponse actualResponse = client.deleteEvents(projectName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventsRequest actualRequest = ((DeleteEventsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName.toString(), actualRequest.getProjectName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.of("[PROJECT]");
      client.deleteEvents(projectName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventsTest2() throws Exception {
    DeleteEventsResponse expectedResponse = DeleteEventsResponse.newBuilder().build();
    mockErrorStatsService.addResponse(expectedResponse);

    String projectName = "project_name939388913";

    DeleteEventsResponse actualResponse = client.deleteEvents(projectName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockErrorStatsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventsRequest actualRequest = ((DeleteEventsRequest) actualRequests.get(0));

    Assert.assertEquals(projectName, actualRequest.getProjectName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockErrorStatsService.addException(exception);

    try {
      String projectName = "project_name939388913";
      client.deleteEvents(projectName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
