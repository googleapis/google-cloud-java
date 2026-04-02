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

import com.google.ads.datamanager.v1.stub.HttpJsonUserListServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class UserListServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserListServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserListServiceStub.getMethodDescriptors(),
            UserListServiceSettings.getDefaultEndpoint());
    UserListServiceSettings settings =
        UserListServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserListServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");

    UserList actualResponse = client.getUserList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getUserListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accountTypes/accountType-8500/accounts/account-8500/userLists/userList-8500";

    UserList actualResponse = client.getUserList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getUserListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accountTypes/accountType-8500/accounts/account-8500/userLists/userList-8500";
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListsPagedResponse pagedListResponse = client.listUserLists(parent);

    List<UserList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUserListsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";

    ListUserListsPagedResponse pagedListResponse = client.listUserLists(parent);

    List<UserList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUserListsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserList userList = UserList.newBuilder().build();

    UserList actualResponse = client.createUserList(parent, userList);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createUserListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";
    UserList userList = UserList.newBuilder().build();

    UserList actualResponse = client.createUserList(parent, userList);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createUserListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
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
    mockService.addResponse(expectedResponse);

    UserList userList =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserList actualResponse = client.updateUserList(userList, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateUserListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserList userList =
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
    mockService.addResponse(expectedResponse);

    UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");

    client.deleteUserList(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accountTypes/accountType-8500/accounts/account-8500/userLists/userList-8500";

    client.deleteUserList(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accountTypes/accountType-8500/accounts/account-8500/userLists/userList-8500";
      client.deleteUserList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
