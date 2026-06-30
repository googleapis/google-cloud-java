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

import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicenseCustomerInfosPagedResponse;
import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicensesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class UserListGlobalLicenseServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUserListGlobalLicenseService mockUserListGlobalLicenseService;
  private LocalChannelProvider channelProvider;
  private UserListGlobalLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserListGlobalLicenseService = new MockUserListGlobalLicenseService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockUserListGlobalLicenseService));
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
    UserListGlobalLicenseServiceSettings settings =
        UserListGlobalLicenseServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListGlobalLicenseServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createUserListGlobalLicenseTest() throws Exception {
    UserListGlobalLicense expectedResponse =
        UserListGlobalLicense.newBuilder()
            .setName(
                UserListGlobalLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setLicenseType(UserListGlobalLicenseType.forNumber(0))
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.createUserListGlobalLicense(parent, userListGlobalLicense);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListGlobalLicenseRequest actualRequest =
        ((CreateUserListGlobalLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userListGlobalLicense, actualRequest.getUserListGlobalLicense());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListGlobalLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
      client.createUserListGlobalLicense(parent, userListGlobalLicense);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserListGlobalLicenseTest2() throws Exception {
    UserListGlobalLicense expectedResponse =
        UserListGlobalLicense.newBuilder()
            .setName(
                UserListGlobalLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setLicenseType(UserListGlobalLicenseType.forNumber(0))
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.createUserListGlobalLicense(parent, userListGlobalLicense);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListGlobalLicenseRequest actualRequest =
        ((CreateUserListGlobalLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userListGlobalLicense, actualRequest.getUserListGlobalLicense());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListGlobalLicenseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
      client.createUserListGlobalLicense(parent, userListGlobalLicense);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserListGlobalLicenseTest() throws Exception {
    UserListGlobalLicense expectedResponse =
        UserListGlobalLicense.newBuilder()
            .setName(
                UserListGlobalLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setLicenseType(UserListGlobalLicenseType.forNumber(0))
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.updateUserListGlobalLicense(userListGlobalLicense, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserListGlobalLicenseRequest actualRequest =
        ((UpdateUserListGlobalLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(userListGlobalLicense, actualRequest.getUserListGlobalLicense());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserListGlobalLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserListGlobalLicense(userListGlobalLicense, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserListGlobalLicenseTest() throws Exception {
    UserListGlobalLicense expectedResponse =
        UserListGlobalLicense.newBuilder()
            .setName(
                UserListGlobalLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setLicenseType(UserListGlobalLicenseType.forNumber(0))
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    UserListGlobalLicenseName name =
        UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");

    UserListGlobalLicense actualResponse = client.getUserListGlobalLicense(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListGlobalLicenseRequest actualRequest =
        ((GetUserListGlobalLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListGlobalLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      UserListGlobalLicenseName name =
          UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");
      client.getUserListGlobalLicense(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserListGlobalLicenseTest2() throws Exception {
    UserListGlobalLicense expectedResponse =
        UserListGlobalLicense.newBuilder()
            .setName(
                UserListGlobalLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setLicenseType(UserListGlobalLicenseType.forNumber(0))
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    String name = "name3373707";

    UserListGlobalLicense actualResponse = client.getUserListGlobalLicense(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListGlobalLicenseRequest actualRequest =
        ((GetUserListGlobalLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListGlobalLicenseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserListGlobalLicense(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListGlobalLicensesTest() throws Exception {
    UserListGlobalLicense responsesElement = UserListGlobalLicense.newBuilder().build();
    ListUserListGlobalLicensesResponse expectedResponse =
        ListUserListGlobalLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListGlobalLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListGlobalLicensesPagedResponse pagedListResponse =
        client.listUserListGlobalLicenses(parent);

    List<UserListGlobalLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListGlobalLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListGlobalLicensesRequest actualRequest =
        ((ListUserListGlobalLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListGlobalLicensesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      client.listUserListGlobalLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListGlobalLicensesTest2() throws Exception {
    UserListGlobalLicense responsesElement = UserListGlobalLicense.newBuilder().build();
    ListUserListGlobalLicensesResponse expectedResponse =
        ListUserListGlobalLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListGlobalLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserListGlobalLicensesPagedResponse pagedListResponse =
        client.listUserListGlobalLicenses(parent);

    List<UserListGlobalLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListGlobalLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListGlobalLicensesRequest actualRequest =
        ((ListUserListGlobalLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListGlobalLicensesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserListGlobalLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListGlobalLicenseCustomerInfosTest() throws Exception {
    UserListGlobalLicenseCustomerInfo responsesElement =
        UserListGlobalLicenseCustomerInfo.newBuilder().build();
    ListUserListGlobalLicenseCustomerInfosResponse expectedResponse =
        ListUserListGlobalLicenseCustomerInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListGlobalLicenseCustomerInfos(Arrays.asList(responsesElement))
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    UserListGlobalLicenseName parent =
        UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");

    ListUserListGlobalLicenseCustomerInfosPagedResponse pagedListResponse =
        client.listUserListGlobalLicenseCustomerInfos(parent);

    List<UserListGlobalLicenseCustomerInfo> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getUserListGlobalLicenseCustomerInfosList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListGlobalLicenseCustomerInfosRequest actualRequest =
        ((ListUserListGlobalLicenseCustomerInfosRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListGlobalLicenseCustomerInfosExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      UserListGlobalLicenseName parent =
          UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");
      client.listUserListGlobalLicenseCustomerInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListGlobalLicenseCustomerInfosTest2() throws Exception {
    UserListGlobalLicenseCustomerInfo responsesElement =
        UserListGlobalLicenseCustomerInfo.newBuilder().build();
    ListUserListGlobalLicenseCustomerInfosResponse expectedResponse =
        ListUserListGlobalLicenseCustomerInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListGlobalLicenseCustomerInfos(Arrays.asList(responsesElement))
            .build();
    mockUserListGlobalLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserListGlobalLicenseCustomerInfosPagedResponse pagedListResponse =
        client.listUserListGlobalLicenseCustomerInfos(parent);

    List<UserListGlobalLicenseCustomerInfo> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getUserListGlobalLicenseCustomerInfosList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListGlobalLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListGlobalLicenseCustomerInfosRequest actualRequest =
        ((ListUserListGlobalLicenseCustomerInfosRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListGlobalLicenseCustomerInfosExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListGlobalLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserListGlobalLicenseCustomerInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
