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

package com.google.cloud.commerce.consumer.procurement.v1;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.commerce.consumer.procurement.v1.stub.HttpJsonLicenseManagementServiceStub;
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
public class LicenseManagementServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LicenseManagementServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLicenseManagementServiceStub.getMethodDescriptors(),
            LicenseManagementServiceSettings.getDefaultEndpoint());
    LicenseManagementServiceSettings settings =
        LicenseManagementServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LicenseManagementServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LicenseManagementServiceClient.create(settings);
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
  public void getLicensePoolTest() throws Exception {
    LicensePool expectedResponse =
        LicensePool.newBuilder()
            .setName("name3373707")
            .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
            .setAvailableLicenseCount(387091611)
            .setTotalLicenseCount(-834147882)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "billingAccounts/billingAccount-2660/orders/order-2660/licensePool";

    LicensePool actualResponse = client.getLicensePool(name);
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
  public void getLicensePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "billingAccounts/billingAccount-2660/orders/order-2660/licensePool";
      client.getLicensePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLicensePoolTest() throws Exception {
    LicensePool expectedResponse =
        LicensePool.newBuilder()
            .setName("name3373707")
            .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
            .setAvailableLicenseCount(387091611)
            .setTotalLicenseCount(-834147882)
            .build();
    mockService.addResponse(expectedResponse);

    LicensePool licensePool =
        LicensePool.newBuilder()
            .setName("billingAccounts/billingAccount-9/orders/order-9/licensePool/licensePoo-9")
            .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
            .setAvailableLicenseCount(387091611)
            .setTotalLicenseCount(-834147882)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LicensePool actualResponse = client.updateLicensePool(licensePool, updateMask);
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
  public void updateLicensePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LicensePool licensePool =
          LicensePool.newBuilder()
              .setName("billingAccounts/billingAccount-9/orders/order-9/licensePool/licensePoo-9")
              .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
              .setAvailableLicenseCount(387091611)
              .setTotalLicenseCount(-834147882)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLicensePool(licensePool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void assignTest() throws Exception {
    AssignResponse expectedResponse = AssignResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";
    List<String> usernames = new ArrayList<>();

    AssignResponse actualResponse = client.assign(parent, usernames);
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
  public void assignExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";
      List<String> usernames = new ArrayList<>();
      client.assign(parent, usernames);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unassignTest() throws Exception {
    UnassignResponse expectedResponse = UnassignResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";
    List<String> usernames = new ArrayList<>();

    UnassignResponse actualResponse = client.unassign(parent, usernames);
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
  public void unassignExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";
      List<String> usernames = new ArrayList<>();
      client.unassign(parent, usernames);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enumerateLicensedUsersTest() throws Exception {
    LicensedUser responsesElement = LicensedUser.newBuilder().build();
    EnumerateLicensedUsersResponse expectedResponse =
        EnumerateLicensedUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLicensedUsers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";

    EnumerateLicensedUsersPagedResponse pagedListResponse = client.enumerateLicensedUsers(parent);

    List<LicensedUser> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicensedUsersList().get(0), resources.get(0));

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
  public void enumerateLicensedUsersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "billingAccounts/billingAccount-8731/orders/order-8731/licensePool";
      client.enumerateLicensedUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
