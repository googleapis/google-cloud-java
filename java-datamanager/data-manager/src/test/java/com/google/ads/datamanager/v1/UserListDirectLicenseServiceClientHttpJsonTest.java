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

import com.google.ads.datamanager.v1.stub.HttpJsonUserListDirectLicenseServiceStub;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
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
public class UserListDirectLicenseServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserListDirectLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserListDirectLicenseServiceStub.getMethodDescriptors(),
            UserListDirectLicenseServiceSettings.getDefaultEndpoint());
    UserListDirectLicenseServiceSettings settings =
        UserListDirectLicenseServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserListDirectLicenseServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListDirectLicenseServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.createUserListDirectLicense(parent, userListDirectLicense);
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
  public void createUserListDirectLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";
    UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.createUserListDirectLicense(parent, userListDirectLicense);
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
  public void createUserListDirectLicenseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
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
    mockService.addResponse(expectedResponse);

    UserListDirectLicenseName name =
        UserListDirectLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]");

    UserListDirectLicense actualResponse = client.getUserListDirectLicense(name);
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
  public void getUserListDirectLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "accountTypes/accountType-1328/accounts/account-1328/userListDirectLicenses/userListDirectLicense-1328";

    UserListDirectLicense actualResponse = client.getUserListDirectLicense(name);
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
  public void getUserListDirectLicenseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accountTypes/accountType-1328/accounts/account-1328/userListDirectLicenses/userListDirectLicense-1328";
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
    mockService.addResponse(expectedResponse);

    UserListDirectLicense userListDirectLicense =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserListDirectLicense actualResponse =
        client.updateUserListDirectLicense(userListDirectLicense, updateMask);
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
  public void updateUserListDirectLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserListDirectLicense userListDirectLicense =
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListDirectLicensesPagedResponse pagedListResponse =
        client.listUserListDirectLicenses(parent);

    List<UserListDirectLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListDirectLicensesList().get(0), resources.get(0));

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
  public void listUserListDirectLicensesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";

    ListUserListDirectLicensesPagedResponse pagedListResponse =
        client.listUserListDirectLicenses(parent);

    List<UserListDirectLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListDirectLicensesList().get(0), resources.get(0));

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
  public void listUserListDirectLicensesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
      client.listUserListDirectLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
