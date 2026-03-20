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

package com.google.ads.datamanager.v1;

import static com.google.ads.datamanager.v1.UserListServiceClient.ListUserListsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class UserListServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUserListService mockUserListService;
  private LocalChannelProvider channelProvider;
  private UserListServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserListService = new MockUserListService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockUserListService));
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
    UserListServiceSettings settings =
        UserListServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getUserListTest() throws Exception {
    UserList expectedResponse =
        UserList.newBuilder()
            .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
            .setId(3355)
            .setReadOnly(true)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIntegrationCode("integrationCode1802866145")
            .setMembershipDuration(Duration.newBuilder().build())
            .setSizeInfo(SizeInfo.newBuilder().build())
            .setTargetNetworkInfo(TargetNetworkInfo.newBuilder().build())
            .build();
    mockUserListService.addResponse(expectedResponse);

    UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");

    UserList actualResponse = client.getUserList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListRequest actualRequest = ((GetUserListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
      client.getUserList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserListTest2() throws Exception {
    UserList expectedResponse =
        UserList.newBuilder()
            .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
            .setId(3355)
            .setReadOnly(true)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIntegrationCode("integrationCode1802866145")
            .setMembershipDuration(Duration.newBuilder().build())
            .setSizeInfo(SizeInfo.newBuilder().build())
            .setTargetNetworkInfo(TargetNetworkInfo.newBuilder().build())
            .build();
    mockUserListService.addResponse(expectedResponse);

    String name = "name3373707";

    UserList actualResponse = client.getUserList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListRequest actualRequest = ((GetUserListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListsTest() throws Exception {
    UserList responsesElement = UserList.newBuilder().build();
    ListUserListsResponse expectedResponse =
        ListUserListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLists(Arrays.asList(responsesElement))
            .build();
    mockUserListService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListsPagedResponse pagedListResponse = client.listUserLists(parent);

    List<UserList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListsRequest actualRequest = ((ListUserListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      client.listUserLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListsTest2() throws Exception {
    UserList responsesElement = UserList.newBuilder().build();
    ListUserListsResponse expectedResponse =
        ListUserListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLists(Arrays.asList(responsesElement))
            .build();
    mockUserListService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserListsPagedResponse pagedListResponse = client.listUserLists(parent);

    List<UserList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListsRequest actualRequest = ((ListUserListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserListTest() throws Exception {
    UserList expectedResponse =
        UserList.newBuilder()
            .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
            .setId(3355)
            .setReadOnly(true)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIntegrationCode("integrationCode1802866145")
            .setMembershipDuration(Duration.newBuilder().build())
            .setSizeInfo(SizeInfo.newBuilder().build())
            .setTargetNetworkInfo(TargetNetworkInfo.newBuilder().build())
            .build();
    mockUserListService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserList userList = UserList.newBuilder().build();

    UserList actualResponse = client.createUserList(parent, userList);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListRequest actualRequest = ((CreateUserListRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userList, actualRequest.getUserList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      UserList userList = UserList.newBuilder().build();
      client.createUserList(parent, userList);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserListTest2() throws Exception {
    UserList expectedResponse =
        UserList.newBuilder()
            .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
            .setId(3355)
            .setReadOnly(true)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIntegrationCode("integrationCode1802866145")
            .setMembershipDuration(Duration.newBuilder().build())
            .setSizeInfo(SizeInfo.newBuilder().build())
            .setTargetNetworkInfo(TargetNetworkInfo.newBuilder().build())
            .build();
    mockUserListService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserList userList = UserList.newBuilder().build();

    UserList actualResponse = client.createUserList(parent, userList);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListRequest actualRequest = ((CreateUserListRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userList, actualRequest.getUserList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      String parent = "parent-995424086";
      UserList userList = UserList.newBuilder().build();
      client.createUserList(parent, userList);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserListTest() throws Exception {
    UserList expectedResponse =
        UserList.newBuilder()
            .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
            .setId(3355)
            .setReadOnly(true)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIntegrationCode("integrationCode1802866145")
            .setMembershipDuration(Duration.newBuilder().build())
            .setSizeInfo(SizeInfo.newBuilder().build())
            .setTargetNetworkInfo(TargetNetworkInfo.newBuilder().build())
            .build();
    mockUserListService.addResponse(expectedResponse);

    UserList userList = UserList.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserList actualResponse = client.updateUserList(userList, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserListRequest actualRequest = ((UpdateUserListRequest) actualRequests.get(0));

    Assert.assertEquals(userList, actualRequest.getUserList());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      UserList userList = UserList.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserList(userList, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserListTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUserListService.addResponse(expectedResponse);

    UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");

    client.deleteUserList(name);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserListRequest actualRequest = ((DeleteUserListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
      client.deleteUserList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserListTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUserListService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserList(name);

    List<AbstractMessage> actualRequests = mockUserListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserListRequest actualRequest = ((DeleteUserListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
