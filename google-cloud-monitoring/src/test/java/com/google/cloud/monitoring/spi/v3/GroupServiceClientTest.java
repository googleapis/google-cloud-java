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
package com.google.cloud.monitoring.spi.v3;

import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListGroupMembersPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupName;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
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
public class GroupServiceClientTest {
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockServiceHelper serviceHelper;
  private GroupServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockGroupService, mockMetricService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    GroupServiceSettings settings =
        GroupServiceSettings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .build();
    client = GroupServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() {
    GroupName name2 = GroupName.create("[PROJECT]", "[GROUP]");
    String displayName = "displayName1615086568";
    GroupName parentName = GroupName.create("[PROJECT]", "[GROUP]");
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setNameWithGroupName(name2)
            .setDisplayName(displayName)
            .setParentNameWithGroupName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

    Group actualResponse = client.getGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = (GetGroupRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsGroupName());
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() {
    GroupName name2 = GroupName.create("[PROJECT]", "[GROUP]");
    String displayName = "displayName1615086568";
    GroupName parentName = GroupName.create("[PROJECT]", "[GROUP]");
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setNameWithGroupName(name2)
            .setDisplayName(displayName)
            .setParentNameWithGroupName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    mockGroupService.addResponse(expectedResponse);

    ProjectName name = ProjectName.create("[PROJECT]");
    Group group = Group.newBuilder().build();

    Group actualResponse = client.createGroup(name, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = (CreateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsProjectName());
    Assert.assertEquals(group, actualRequest.getGroup());
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockGroupService.addException(exception);

    try {
      ProjectName name = ProjectName.create("[PROJECT]");
      Group group = Group.newBuilder().build();

      client.createGroup(name, group);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() {
    GroupName name = GroupName.create("[PROJECT]", "[GROUP]");
    String displayName = "displayName1615086568";
    GroupName parentName = GroupName.create("[PROJECT]", "[GROUP]");
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setNameWithGroupName(name)
            .setDisplayName(displayName)
            .setParentNameWithGroupName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    mockGroupService.addResponse(expectedResponse);

    Group group = Group.newBuilder().build();

    Group actualResponse = client.updateGroup(group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = (UpdateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(group, actualRequest.getGroup());
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockGroupService.addException(exception);

    try {
      Group group = Group.newBuilder().build();

      client.updateGroup(group);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

    client.deleteGroup(name);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGroupRequest actualRequest = (DeleteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsGroupName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

      client.deleteGroup(name);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersTest() {
    String nextPageToken = "";
    int totalSize = -705419236;
    MonitoredResource membersElement = MonitoredResource.newBuilder().build();
    List<MonitoredResource> members = Arrays.asList(membersElement);
    ListGroupMembersResponse expectedResponse =
        ListGroupMembersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllMembers(members)
            .build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

    ListGroupMembersPagedResponse pagedListResponse = client.listGroupMembers(name);

    List<MonitoredResource> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupMembersRequest actualRequest = (ListGroupMembersRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsGroupName());
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.create("[PROJECT]", "[GROUP]");

      client.listGroupMembers(name);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
