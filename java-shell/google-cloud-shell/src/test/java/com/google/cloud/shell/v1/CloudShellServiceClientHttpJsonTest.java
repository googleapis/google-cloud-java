/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.shell.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.shell.v1.stub.HttpJsonCloudShellServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
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
public class CloudShellServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudShellServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudShellServiceStub.getMethodDescriptors(),
            CloudShellServiceSettings.getDefaultEndpoint());
    CloudShellServiceSettings settings =
        CloudShellServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudShellServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudShellServiceClient.create(settings);
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
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[USER]", "[ENVIRONMENT]").toString())
            .setId("id3355")
            .setDockerImage("dockerImage2086149915")
            .setWebHost("webHost1223060252")
            .setSshUsername("sshUsername-812965122")
            .setSshHost("sshHost-1920605232")
            .setSshPort(612046936)
            .addAllPublicKeys(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");

    Environment actualResponse = client.getEnvironment(name);
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
  public void getEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnvironmentTest2() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[USER]", "[ENVIRONMENT]").toString())
            .setId("id3355")
            .setDockerImage("dockerImage2086149915")
            .setWebHost("webHost1223060252")
            .setSshUsername("sshUsername-812965122")
            .setSshHost("sshHost-1920605232")
            .setSshPort(612046936)
            .addAllPublicKeys(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-9538/environments/environment-9538";

    Environment actualResponse = client.getEnvironment(name);
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
  public void getEnvironmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9538/environments/environment-9538";
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startEnvironmentTest() throws Exception {
    StartEnvironmentResponse expectedResponse =
        StartEnvironmentResponse.newBuilder()
            .setEnvironment(Environment.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    StartEnvironmentRequest request =
        StartEnvironmentRequest.newBuilder()
            .setName("users/user-9538/environments/environment-9538")
            .setAccessToken("accessToken-1042689291")
            .addAllPublicKeys(new ArrayList<String>())
            .build();

    StartEnvironmentResponse actualResponse = client.startEnvironmentAsync(request).get();
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
  public void startEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StartEnvironmentRequest request =
          StartEnvironmentRequest.newBuilder()
              .setName("users/user-9538/environments/environment-9538")
              .setAccessToken("accessToken-1042689291")
              .addAllPublicKeys(new ArrayList<String>())
              .build();
      client.startEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void authorizeEnvironmentTest() throws Exception {
    AuthorizeEnvironmentResponse expectedResponse =
        AuthorizeEnvironmentResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("authorizeEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AuthorizeEnvironmentRequest request =
        AuthorizeEnvironmentRequest.newBuilder()
            .setName("users/user-9538/environments/environment-9538")
            .setAccessToken("accessToken-1042689291")
            .setIdToken("idToken1642509726")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    AuthorizeEnvironmentResponse actualResponse = client.authorizeEnvironmentAsync(request).get();
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
  public void authorizeEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AuthorizeEnvironmentRequest request =
          AuthorizeEnvironmentRequest.newBuilder()
              .setName("users/user-9538/environments/environment-9538")
              .setAccessToken("accessToken-1042689291")
              .setIdToken("idToken1642509726")
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      client.authorizeEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addPublicKeyTest() throws Exception {
    AddPublicKeyResponse expectedResponse =
        AddPublicKeyResponse.newBuilder().setKey("key106079").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addPublicKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AddPublicKeyRequest request =
        AddPublicKeyRequest.newBuilder()
            .setEnvironment("users/user-9402/environments/environment-9402")
            .setKey("key106079")
            .build();

    AddPublicKeyResponse actualResponse = client.addPublicKeyAsync(request).get();
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
  public void addPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AddPublicKeyRequest request =
          AddPublicKeyRequest.newBuilder()
              .setEnvironment("users/user-9402/environments/environment-9402")
              .setKey("key106079")
              .build();
      client.addPublicKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removePublicKeyTest() throws Exception {
    RemovePublicKeyResponse expectedResponse = RemovePublicKeyResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removePublicKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RemovePublicKeyRequest request =
        RemovePublicKeyRequest.newBuilder()
            .setEnvironment("users/user-9402/environments/environment-9402")
            .setKey("key106079")
            .build();

    RemovePublicKeyResponse actualResponse = client.removePublicKeyAsync(request).get();
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
  public void removePublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RemovePublicKeyRequest request =
          RemovePublicKeyRequest.newBuilder()
              .setEnvironment("users/user-9402/environments/environment-9402")
              .setKey("key106079")
              .build();
      client.removePublicKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
