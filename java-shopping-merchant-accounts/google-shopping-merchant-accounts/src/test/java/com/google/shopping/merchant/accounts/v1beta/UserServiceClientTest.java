/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.UserServiceClient.ListUsersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class UserServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUserService mockUserService;
  private LocalChannelProvider channelProvider;
  private UserServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserService = new MockUserService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockUserService));
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
    UserServiceSettings settings =
        UserServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getUserTest() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
            .addAllAccessRights(new ArrayList<AccessRight>())
            .build();
    mockUserService.addResponse(expectedResponse);

    UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");

    User actualResponse = client.getUser(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserRequest actualRequest = ((GetUserRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
      client.getUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserTest2() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
            .addAllAccessRights(new ArrayList<AccessRight>())
            .build();
    mockUserService.addResponse(expectedResponse);

    String name = "name3373707";

    User actualResponse = client.getUser(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserRequest actualRequest = ((GetUserRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      String name = "name3373707";
      client.getUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserTest() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
            .addAllAccessRights(new ArrayList<AccessRight>())
            .build();
    mockUserService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    User user = User.newBuilder().build();

    User actualResponse = client.createUser(parent, user);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserRequest actualRequest = ((CreateUserRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getUser());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      User user = User.newBuilder().build();
      client.createUser(parent, user);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserTest2() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
            .addAllAccessRights(new ArrayList<AccessRight>())
            .build();
    mockUserService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    User user = User.newBuilder().build();

    User actualResponse = client.createUser(parent, user);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserRequest actualRequest = ((CreateUserRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getUser());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      String parent = "parent-995424086";
      User user = User.newBuilder().build();
      client.createUser(parent, user);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUserService.addResponse(expectedResponse);

    UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");

    client.deleteUser(name);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserRequest actualRequest = ((DeleteUserRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
      client.deleteUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUserService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUser(name);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserRequest actualRequest = ((DeleteUserRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserTest() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
            .addAllAccessRights(new ArrayList<AccessRight>())
            .build();
    mockUserService.addResponse(expectedResponse);

    User user = User.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    User actualResponse = client.updateUser(user, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserRequest actualRequest = ((UpdateUserRequest) actualRequests.get(0));

    Assert.assertEquals(user, actualRequest.getUser());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      User user = User.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUser(user, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsersTest() throws Exception {
    User responsesElement = User.newBuilder().build();
    ListUsersResponse expectedResponse =
        ListUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsers(Arrays.asList(responsesElement))
            .build();
    mockUserService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListUsersPagedResponse pagedListResponse = client.listUsers(parent);

    List<User> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsersRequest actualRequest = ((ListUsersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsersTest2() throws Exception {
    User responsesElement = User.newBuilder().build();
    ListUsersResponse expectedResponse =
        ListUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsers(Arrays.asList(responsesElement))
            .build();
    mockUserService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUsersPagedResponse pagedListResponse = client.listUsers(parent);

    List<User> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsersRequest actualRequest = ((ListUsersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
