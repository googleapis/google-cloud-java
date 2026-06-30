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

import com.google.ads.datamanager.v1.stub.HttpJsonUserListGlobalLicenseServiceStub;
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
public class UserListGlobalLicenseServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserListGlobalLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserListGlobalLicenseServiceStub.getMethodDescriptors(),
            UserListGlobalLicenseServiceSettings.getDefaultEndpoint());
    UserListGlobalLicenseServiceSettings settings =
        UserListGlobalLicenseServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserListGlobalLicenseServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserListGlobalLicenseServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.createUserListGlobalLicense(parent, userListGlobalLicense);
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
  public void createUserListGlobalLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";
    UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.createUserListGlobalLicense(parent, userListGlobalLicense);
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
  public void createUserListGlobalLicenseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
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
    mockService.addResponse(expectedResponse);

    UserListGlobalLicense userListGlobalLicense =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserListGlobalLicense actualResponse =
        client.updateUserListGlobalLicense(userListGlobalLicense, updateMask);
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
  public void updateUserListGlobalLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserListGlobalLicense userListGlobalLicense =
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
    mockService.addResponse(expectedResponse);

    UserListGlobalLicenseName name =
        UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");

    UserListGlobalLicense actualResponse = client.getUserListGlobalLicense(name);
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
  public void getUserListGlobalLicenseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "accountTypes/accountType-2714/accounts/account-2714/userListGlobalLicenses/userListGlobalLicense-2714";

    UserListGlobalLicense actualResponse = client.getUserListGlobalLicense(name);
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
  public void getUserListGlobalLicenseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accountTypes/accountType-2714/accounts/account-2714/userListGlobalLicenses/userListGlobalLicense-2714";
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    ListUserListGlobalLicensesPagedResponse pagedListResponse =
        client.listUserListGlobalLicenses(parent);

    List<UserListGlobalLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListGlobalLicensesList().get(0), resources.get(0));

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
  public void listUserListGlobalLicensesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accountTypes/accountType-129/accounts/account-129";

    ListUserListGlobalLicensesPagedResponse pagedListResponse =
        client.listUserListGlobalLicenses(parent);

    List<UserListGlobalLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserListGlobalLicensesList().get(0), resources.get(0));

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
  public void listUserListGlobalLicensesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accountTypes/accountType-129/accounts/account-129";
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
    mockService.addResponse(expectedResponse);

    UserListGlobalLicenseName parent =
        UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");

    ListUserListGlobalLicenseCustomerInfosPagedResponse pagedListResponse =
        client.listUserListGlobalLicenseCustomerInfos(parent);

    List<UserListGlobalLicenseCustomerInfo> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getUserListGlobalLicenseCustomerInfosList().get(0), resources.get(0));

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
  public void listUserListGlobalLicenseCustomerInfosExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "accountTypes/accountType-6153/accounts/account-6153/userListGlobalLicenses/userListGlobalLicense-6153";

    ListUserListGlobalLicenseCustomerInfosPagedResponse pagedListResponse =
        client.listUserListGlobalLicenseCustomerInfos(parent);

    List<UserListGlobalLicenseCustomerInfo> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getUserListGlobalLicenseCustomerInfosList().get(0), resources.get(0));

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
  public void listUserListGlobalLicenseCustomerInfosExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "accountTypes/accountType-6153/accounts/account-6153/userListGlobalLicenses/userListGlobalLicense-6153";
      client.listUserListGlobalLicenseCustomerInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
