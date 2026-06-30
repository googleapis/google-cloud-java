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

import static com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient.ListUserListDirectLicensesPagedResponse;

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
public class UserListDirectLicenseServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUserListDirectLicenseService mockUserListDirectLicenseService;
  private LocalChannelProvider channelProvider;
  private UserListDirectLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserListDirectLicenseService = new MockUserListDirectLicenseService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockUserListDirectLicenseService));
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
    UserListDirectLicenseServiceSettings settings =
        UserListDirectLicenseServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListDirectLicenseServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createUserListDirectLicenseTest() throws Exception {
    UserListDirectLicense expectedResponse =
        UserListDirectLicense.newBuilder()
            .setName(
                UserListDirectLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setClientAccountType(UserListLicenseClientAccountType.forNumber(0))
            .setClientAccountId(1552007521)
            .setClientAccountDisplayName("clientAccountDisplayName-394446549")
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.createUserListDirectLicense(parent, userListDirectLicense);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListDirectLicenseRequest actualRequest =
        ((CreateUserListDirectLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userListDirectLicense, actualRequest.getUserListDirectLicense());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListDirectLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
      client.createUserListDirectLicense(parent, userListDirectLicense);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserListDirectLicenseTest2() throws Exception {
    UserListDirectLicense expectedResponse =
        UserListDirectLicense.newBuilder()
            .setName(
                UserListDirectLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setClientAccountType(UserListLicenseClientAccountType.forNumber(0))
            .setClientAccountId(1552007521)
            .setClientAccountDisplayName("clientAccountDisplayName-394446549")
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.createUserListDirectLicense(parent, userListDirectLicense);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserListDirectLicenseRequest actualRequest =
        ((CreateUserListDirectLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userListDirectLicense, actualRequest.getUserListDirectLicense());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserListDirectLicenseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
      client.createUserListDirectLicense(parent, userListDirectLicense);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserListDirectLicenseTest() throws Exception {
    UserListDirectLicense expectedResponse =
        UserListDirectLicense.newBuilder()
            .setName(
                UserListDirectLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setClientAccountType(UserListLicenseClientAccountType.forNumber(0))
            .setClientAccountId(1552007521)
            .setClientAccountDisplayName("clientAccountDisplayName-394446549")
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    UserListDirectLicenseName name =
        UserListDirectLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]");

    UserListDirectLicense actualResponse = client.getUserListDirectLicense(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListDirectLicenseRequest actualRequest =
        ((GetUserListDirectLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListDirectLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      UserListDirectLicenseName name =
          UserListDirectLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]");
      client.getUserListDirectLicense(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserListDirectLicenseTest2() throws Exception {
    UserListDirectLicense expectedResponse =
        UserListDirectLicense.newBuilder()
            .setName(
                UserListDirectLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setClientAccountType(UserListLicenseClientAccountType.forNumber(0))
            .setClientAccountId(1552007521)
            .setClientAccountDisplayName("clientAccountDisplayName-394446549")
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    String name = "name3373707";

    UserListDirectLicense actualResponse = client.getUserListDirectLicense(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserListDirectLicenseRequest actualRequest =
        ((GetUserListDirectLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserListDirectLicenseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserListDirectLicense(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserListDirectLicenseTest() throws Exception {
    UserListDirectLicense expectedResponse =
        UserListDirectLicense.newBuilder()
            .setName(
                UserListDirectLicenseName.of(
                        "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
                    .toString())
            .setUserListId(1707617256)
            .setUserListDisplayName("userListDisplayName1315716004")
            .setClientAccountType(UserListLicenseClientAccountType.forNumber(0))
            .setClientAccountId(1552007521)
            .setClientAccountDisplayName("clientAccountDisplayName-394446549")
            .setStatus(UserListLicenseStatus.forNumber(0))
            .setPricing(UserListLicensePricing.newBuilder().build())
            .addAllHistoricalPricings(new ArrayList<UserListLicensePricing>())
            .setMetrics(UserListLicenseMetrics.newBuilder().build())
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.updateUserListDirectLicense(userListDirectLicense, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserListDirectLicenseRequest actualRequest =
        ((UpdateUserListDirectLicenseRequest) actualRequests.get(0));

    Assert.assertEquals(userListDirectLicense, actualRequest.getUserListDirectLicense());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserListDirectLicenseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserListDirectLicense(userListDirectLicense, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListDirectLicensesTest() throws Exception {
    UserListDirectLicense responsesElement = UserListDirectLicense.newBuilder().build();
    ListUserListDirectLicensesResponse expectedResponse =
        ListUserListDirectLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListDirectLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListDirectLicensesPagedResponse pagedListResponse =
        client.listUserListDirectLicenses(parent);

    List<UserListDirectLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListDirectLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListDirectLicensesRequest actualRequest =
        ((ListUserListDirectLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListDirectLicensesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      client.listUserListDirectLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserListDirectLicensesTest2() throws Exception {
    UserListDirectLicense responsesElement = UserListDirectLicense.newBuilder().build();
    ListUserListDirectLicensesResponse expectedResponse =
        ListUserListDirectLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserListDirectLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserListDirectLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserListDirectLicensesPagedResponse pagedListResponse =
        client.listUserListDirectLicenses(parent);

    List<UserListDirectLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListDirectLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserListDirectLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserListDirectLicensesRequest actualRequest =
        ((ListUserListDirectLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserListDirectLicensesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserListDirectLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserListDirectLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
