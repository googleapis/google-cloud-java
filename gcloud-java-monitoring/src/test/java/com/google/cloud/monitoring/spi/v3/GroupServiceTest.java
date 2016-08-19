/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.monitoring.spi.v3;

import com.google.api.MonitoredResource;
import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class GroupServiceTest {
  private static MockServiceHelper serviceHelper;
  private GroupServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    MockGroupService mockService = new MockGroupService();
    serviceHelper = new MockServiceHelper("in-process-1", mockService);
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
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = GroupServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupsTest() {
    ListGroupsResponse expectedResponse = ListGroupsResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
    String childrenOfGroup = "";
    String ancestorsOfGroup = "";
    String descendantsOfGroup = "";
    PageAccessor<Group> pageAccessor =
        api.listGroups(formattedName, childrenOfGroup, ancestorsOfGroup, descendantsOfGroup);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<Group> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(0, resources.size());

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = (ListGroupsRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getChildrenOfGroup(), childrenOfGroup);
    Assert.assertEquals(actualRequest.getAncestorsOfGroup(), ancestorsOfGroup);
    Assert.assertEquals(actualRequest.getDescendantsOfGroup(), descendantsOfGroup);
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() {
    Group expectedResponse = Group.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
    Group actualResponse = api.getGroup(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = (GetGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() {
    Group expectedResponse = Group.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
    Group group = Group.newBuilder().build();
    boolean validateOnly = false;
    Group actualResponse = api.createGroup(formattedName, group, validateOnly);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = (CreateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getGroup(), group);
    Assert.assertEquals(actualRequest.getValidateOnly(), validateOnly);
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() {
    Group expectedResponse = Group.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    Group group = Group.newBuilder().build();
    boolean validateOnly = false;
    Group actualResponse = api.updateGroup(group, validateOnly);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = (UpdateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getGroup(), group);
    Assert.assertEquals(actualRequest.getValidateOnly(), validateOnly);
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
    api.deleteGroup(formattedName);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGroupRequest actualRequest = (DeleteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersTest() {
    ListGroupMembersResponse expectedResponse = ListGroupMembersResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
    String filter = "";
    TimeInterval interval = TimeInterval.newBuilder().build();
    PageAccessor<MonitoredResource> pageAccessor =
        api.listGroupMembers(formattedName, filter, interval);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<MonitoredResource> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(0, resources.size());

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupMembersRequest actualRequest = (ListGroupMembersRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getFilter(), filter);
    Assert.assertEquals(actualRequest.getInterval(), interval);
  }
}
