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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupsPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.FolderName;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupName;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class GroupServiceClientTest {
  private static MockGroupService mockGroupService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GroupServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGroupService = new MockGroupService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGroupService));
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
    GroupServiceSettings settings =
        GroupServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GroupServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listGroupsTest() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroup(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(name);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listGroups(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest2() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroup(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(name);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listGroups(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest3() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroup(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(name);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listGroups(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest4() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroup(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    ListGroupsPagedResponse pagedListResponse = client.listGroups(name);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.listGroups(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");

    Group actualResponse = client.getGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = ((GetGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    Group actualResponse = client.getGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = ((GetGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    Group group = Group.newBuilder().build();

    Group actualResponse = client.createGroup(name, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = ((CreateGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      Group group = Group.newBuilder().build();
      client.createGroup(name, group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");
    Group group = Group.newBuilder().build();

    Group actualResponse = client.createGroup(name, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = ((CreateGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      Group group = Group.newBuilder().build();
      client.createGroup(name, group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest3() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    Group group = Group.newBuilder().build();

    Group actualResponse = client.createGroup(name, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = ((CreateGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGroupExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      Group group = Group.newBuilder().build();
      client.createGroup(name, group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest4() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    String name = "name3373707";
    Group group = Group.newBuilder().build();

    Group actualResponse = client.createGroup(name, group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGroupRequest actualRequest = ((CreateGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGroupExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      String name = "name3373707";
      Group group = Group.newBuilder().build();
      client.createGroup(name, group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setParentName("parentName-244870571")
            .setFilter("filter-1274492040")
            .setIsCluster(true)
            .build();
    mockGroupService.addResponse(expectedResponse);

    Group group = Group.newBuilder().build();

    Group actualResponse = client.updateGroup(group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = ((UpdateGroupRequest) actualRequests.get(0));

    Assert.assertEquals(group, actualRequest.getGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      Group group = Group.newBuilder().build();
      client.updateGroup(group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");

    client.deleteGroup(name);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGroupRequest actualRequest = ((DeleteGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");
      client.deleteGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGroup(name);

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGroupRequest actualRequest = ((DeleteGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupMembersTest() throws Exception {
    MonitoredResource responsesElement = MonitoredResource.newBuilder().build();
    ListGroupMembersResponse expectedResponse =
        ListGroupMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembers(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");

    ListGroupMembersPagedResponse pagedListResponse = client.listGroupMembers(name);

    List<MonitoredResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupMembersRequest actualRequest = ((ListGroupMembersRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");
      client.listGroupMembers(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupMembersTest2() throws Exception {
    MonitoredResource responsesElement = MonitoredResource.newBuilder().build();
    ListGroupMembersResponse expectedResponse =
        ListGroupMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembers(Arrays.asList(responsesElement))
            .build();
    mockGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    ListGroupMembersPagedResponse pagedListResponse = client.listGroupMembers(name);

    List<MonitoredResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupMembersRequest actualRequest = ((ListGroupMembersRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupMembersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.listGroupMembers(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
