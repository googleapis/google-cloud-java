/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.UserLicenseServiceClient.ListUserLicensesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonUserLicenseServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class UserLicenseServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserLicenseServiceStub.getMethodDescriptors(),
            UserLicenseServiceSettings.getDefaultEndpoint());
    UserLicenseServiceSettings settings =
        UserLicenseServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserLicenseServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserLicenseServiceClient.create(settings);
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
  public void listUserLicensesTest() throws Exception {
    UserLicense responsesElement = UserLicense.newBuilder().build();
    ListUserLicensesResponse expectedResponse =
        ListUserLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLicenses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");

    ListUserLicensesPagedResponse pagedListResponse = client.listUserLicenses(parent);

    List<UserLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLicensesList().get(0), resources.get(0));

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
  public void listUserLicensesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
      client.listUserLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserLicensesTest2() throws Exception {
    UserLicense responsesElement = UserLicense.newBuilder().build();
    ListUserLicensesResponse expectedResponse =
        ListUserLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLicenses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3682/locations/location-3682/userStores/userStore-3682";

    ListUserLicensesPagedResponse pagedListResponse = client.listUserLicenses(parent);

    List<UserLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLicensesList().get(0), resources.get(0));

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
  public void listUserLicensesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3682/locations/location-3682/userStores/userStore-3682";
      client.listUserLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateUserLicensesTest() throws Exception {
    BatchUpdateUserLicensesResponse expectedResponse =
        BatchUpdateUserLicensesResponse.newBuilder()
            .addAllUserLicenses(new ArrayList<UserLicense>())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateUserLicensesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BatchUpdateUserLicensesRequest request =
        BatchUpdateUserLicensesRequest.newBuilder()
            .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDeleteUnassignedUserLicenses(true)
            .build();

    BatchUpdateUserLicensesResponse actualResponse =
        client.batchUpdateUserLicensesAsync(request).get();
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
  public void batchUpdateUserLicensesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchUpdateUserLicensesRequest request =
          BatchUpdateUserLicensesRequest.newBuilder()
              .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
              .setDeleteUnassignedUserLicenses(true)
              .build();
      client.batchUpdateUserLicensesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
