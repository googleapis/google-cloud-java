/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.errorreporting.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup;
import com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest;
import com.google.devtools.clouderrorreporting.v1beta1.GroupName;
import com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest;
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
public class ErrorGroupServiceClientTest {
  private static MockErrorGroupService mockErrorGroupService;
  private static MockErrorStatsService mockErrorStatsService;
  private static MockReportErrorsService mockReportErrorsService;
  private static MockServiceHelper serviceHelper;
  private ErrorGroupServiceClient client;
  private LocalChannelProvider channelProvider;

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
    channelProvider = serviceHelper.createChannelProvider();
    ErrorGroupServiceSettings settings =
        ErrorGroupServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ErrorGroupServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() {
    GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
    String groupId = "groupId506361563";
    ErrorGroup expectedResponse =
        ErrorGroup.newBuilder().setNameWithGroupName(name).setGroupId(groupId).build();
    mockErrorGroupService.addResponse(expectedResponse);

    GroupName groupName = GroupName.of("[PROJECT]", "[GROUP]");

    ErrorGroup actualResponse = client.getGroup(groupName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockErrorGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = (GetGroupRequest) actualRequests.get(0);

    Assert.assertEquals(groupName, actualRequest.getGroupNameAsGroupName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockErrorGroupService.addException(exception);

    try {
      GroupName groupName = GroupName.of("[PROJECT]", "[GROUP]");

      client.getGroup(groupName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() {
    GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
    String groupId = "groupId506361563";
    ErrorGroup expectedResponse =
        ErrorGroup.newBuilder().setNameWithGroupName(name).setGroupId(groupId).build();
    mockErrorGroupService.addResponse(expectedResponse);

    ErrorGroup group = ErrorGroup.newBuilder().build();

    ErrorGroup actualResponse = client.updateGroup(group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockErrorGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = (UpdateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockErrorGroupService.addException(exception);

    try {
      ErrorGroup group = ErrorGroup.newBuilder().build();

      client.updateGroup(group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
