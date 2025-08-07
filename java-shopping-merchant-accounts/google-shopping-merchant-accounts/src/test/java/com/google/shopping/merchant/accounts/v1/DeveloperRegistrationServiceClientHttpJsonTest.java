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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonDeveloperRegistrationServiceStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeveloperRegistrationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DeveloperRegistrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDeveloperRegistrationServiceStub.getMethodDescriptors(),
            DeveloperRegistrationServiceSettings.getDefaultEndpoint());
    DeveloperRegistrationServiceSettings settings =
        DeveloperRegistrationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DeveloperRegistrationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeveloperRegistrationServiceClient.create(settings);
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
  public void registerGcpTest() throws Exception {
    DeveloperRegistration expectedResponse =
        DeveloperRegistration.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .addAllGcpIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    RegisterGcpRequest request =
        RegisterGcpRequest.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .setDeveloperEmail("developerEmail251249138")
            .build();

    DeveloperRegistration actualResponse = client.registerGcp(request);
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
  public void registerGcpExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegisterGcpRequest request =
          RegisterGcpRequest.newBuilder()
              .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
              .setDeveloperEmail("developerEmail251249138")
              .build();
      client.registerGcp(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeveloperRegistrationTest() throws Exception {
    DeveloperRegistration expectedResponse =
        DeveloperRegistration.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .addAllGcpIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    DeveloperRegistrationName name = DeveloperRegistrationName.of("[ACCOUNT]");

    DeveloperRegistration actualResponse = client.getDeveloperRegistration(name);
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
  public void getDeveloperRegistrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeveloperRegistrationName name = DeveloperRegistrationName.of("[ACCOUNT]");
      client.getDeveloperRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeveloperRegistrationTest2() throws Exception {
    DeveloperRegistration expectedResponse =
        DeveloperRegistration.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .addAllGcpIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2432/developerRegistration";

    DeveloperRegistration actualResponse = client.getDeveloperRegistration(name);
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
  public void getDeveloperRegistrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2432/developerRegistration";
      client.getDeveloperRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unregisterGcpTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    UnregisterGcpRequest request =
        UnregisterGcpRequest.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .build();

    client.unregisterGcp(request);

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
  public void unregisterGcpExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UnregisterGcpRequest request =
          UnregisterGcpRequest.newBuilder()
              .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
              .build();
      client.unregisterGcp(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
