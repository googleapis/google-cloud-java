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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonUserStoreServiceStub;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class UserStoreServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserStoreServiceStub.getMethodDescriptors(),
            UserStoreServiceSettings.getDefaultEndpoint());
    UserStoreServiceSettings settings =
        UserStoreServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserStoreServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserStoreServiceClient.create(settings);
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
  public void getUserStoreTest() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockService.addResponse(expectedResponse);

    UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");

    UserStore actualResponse = client.getUserStore(name);
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
  public void getUserStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
      client.getUserStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserStoreTest2() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5651/locations/location-5651/userStores/userStore-5651";

    UserStore actualResponse = client.getUserStore(name);
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
  public void getUserStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5651/locations/location-5651/userStores/userStore-5651";
      client.getUserStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserStoreTest() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockService.addResponse(expectedResponse);

    UserStore userStore =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserStore actualResponse = client.updateUserStore(userStore, updateMask);
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
  public void updateUserStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserStore userStore =
          UserStore.newBuilder()
              .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
              .setDisplayName("displayName1714148973")
              .setDefaultLicenseConfig(
                  LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
              .setEnableLicenseAutoRegister(true)
              .setEnableExpiredLicenseAutoUpdate(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserStore(userStore, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
