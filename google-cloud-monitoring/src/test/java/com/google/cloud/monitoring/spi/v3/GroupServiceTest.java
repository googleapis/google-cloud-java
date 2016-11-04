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
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class GroupServiceTest {
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockServiceHelper serviceHelper;
  private GroupServiceApi api;

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
    api = GroupServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() {
    String formattedName2 = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
    String displayName = "displayName1615086568";
    String parentName = "parentName1015022848";
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setName(formattedName2)
            .setDisplayName(displayName)
            .setParentName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockGroupService.setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");

    Group actualResponse = api.getGroup(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = (GetGroupRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() {
    String formattedName2 = GroupServiceApi.formatProjectName("[PROJECT]");
    String displayName = "displayName1615086568";
    String parentName = "parentName1015022848";
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setName(formattedName2)
            .setDisplayName(displayName)
            .setParentName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockGroupService.setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
    Group group = Group.newBuilder().build();

    Group actualResponse = api.createGroup(formattedName, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = (CreateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(group, actualRequest.getGroup());
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String parentName = "parentName1015022848";
    String filter = "filter-1274492040";
    boolean isCluster = false;
    Group expectedResponse =
        Group.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setParentName(parentName)
            .setFilter(filter)
            .setIsCluster(isCluster)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockGroupService.setResponses(expectedResponses);

    Group group = Group.newBuilder().build();

    Group actualResponse = api.updateGroup(group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = (UpdateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(group, actualRequest.getGroup());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockGroupService.setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");

    api.deleteGroup(formattedName);

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGroupRequest actualRequest = (DeleteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockGroupService.setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");

    ListGroupMembersPagedResponse pagedListResponse = api.listGroupMembers(formattedName);

    List<MonitoredResource> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupMembersRequest actualRequest = (ListGroupMembersRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }
}
