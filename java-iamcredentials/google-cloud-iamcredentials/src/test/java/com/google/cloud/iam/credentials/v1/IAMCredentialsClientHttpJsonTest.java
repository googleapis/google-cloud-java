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

package com.google.cloud.iam.credentials.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.iam.credentials.v1.stub.HttpJsonIamCredentialsStub;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
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
public class IAMCredentialsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IamCredentialsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIamCredentialsStub.getMethodDescriptors(),
            IamCredentialsSettings.getDefaultEndpoint());
    IamCredentialsSettings settings =
        IamCredentialsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IamCredentialsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IamCredentialsClient.create(settings);
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
  public void generateAccessTokenTest() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    List<String> scope = new ArrayList<>();
    Duration lifetime = Duration.newBuilder().build();

    GenerateAccessTokenResponse actualResponse =
        client.generateAccessToken(name, delegates, scope, lifetime);
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
  public void generateAccessTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      List<String> scope = new ArrayList<>();
      Duration lifetime = Duration.newBuilder().build();
      client.generateAccessToken(name, delegates, scope, lifetime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAccessTokenTest2() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-217/serviceAccounts/serviceAccount-217";
    List<String> delegates = new ArrayList<>();
    List<String> scope = new ArrayList<>();
    Duration lifetime = Duration.newBuilder().build();

    GenerateAccessTokenResponse actualResponse =
        client.generateAccessToken(name, delegates, scope, lifetime);
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
  public void generateAccessTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-217/serviceAccounts/serviceAccount-217";
      List<String> delegates = new ArrayList<>();
      List<String> scope = new ArrayList<>();
      Duration lifetime = Duration.newBuilder().build();
      client.generateAccessToken(name, delegates, scope, lifetime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateIdTokenTest() throws Exception {
    GenerateIdTokenResponse expectedResponse =
        GenerateIdTokenResponse.newBuilder().setToken("token110541305").build();
    mockService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String audience = "audience975628804";
    boolean includeEmail = true;

    GenerateIdTokenResponse actualResponse =
        client.generateIdToken(name, delegates, audience, includeEmail);
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
  public void generateIdTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      String audience = "audience975628804";
      boolean includeEmail = true;
      client.generateIdToken(name, delegates, audience, includeEmail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateIdTokenTest2() throws Exception {
    GenerateIdTokenResponse expectedResponse =
        GenerateIdTokenResponse.newBuilder().setToken("token110541305").build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-217/serviceAccounts/serviceAccount-217";
    List<String> delegates = new ArrayList<>();
    String audience = "audience975628804";
    boolean includeEmail = true;

    GenerateIdTokenResponse actualResponse =
        client.generateIdToken(name, delegates, audience, includeEmail);
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
  public void generateIdTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-217/serviceAccounts/serviceAccount-217";
      List<String> delegates = new ArrayList<>();
      String audience = "audience975628804";
      boolean includeEmail = true;
      client.generateIdToken(name, delegates, audience, includeEmail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signBlobTest() throws Exception {
    SignBlobResponse expectedResponse =
        SignBlobResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedBlob(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    ByteString payload = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, delegates, payload);
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
  public void signBlobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      ByteString payload = ByteString.EMPTY;
      client.signBlob(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signBlobTest2() throws Exception {
    SignBlobResponse expectedResponse =
        SignBlobResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedBlob(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-217/serviceAccounts/serviceAccount-217";
    List<String> delegates = new ArrayList<>();
    ByteString payload = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, delegates, payload);
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
  public void signBlobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-217/serviceAccounts/serviceAccount-217";
      List<String> delegates = new ArrayList<>();
      ByteString payload = ByteString.EMPTY;
      client.signBlob(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signJwtTest() throws Exception {
    SignJwtResponse expectedResponse =
        SignJwtResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedJwt("signedJwt1076760587")
            .build();
    mockService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, delegates, payload);
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
  public void signJwtExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      String payload = "payload-786701938";
      client.signJwt(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void signJwtTest2() throws Exception {
    SignJwtResponse expectedResponse =
        SignJwtResponse.newBuilder()
            .setKeyId("keyId101944282")
            .setSignedJwt("signedJwt1076760587")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-217/serviceAccounts/serviceAccount-217";
    List<String> delegates = new ArrayList<>();
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, delegates, payload);
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
  public void signJwtExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-217/serviceAccounts/serviceAccount-217";
      List<String> delegates = new ArrayList<>();
      String payload = "payload-786701938";
      client.signJwt(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
