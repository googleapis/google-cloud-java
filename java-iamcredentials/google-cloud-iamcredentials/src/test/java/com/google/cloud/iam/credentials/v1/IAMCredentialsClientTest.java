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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
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
public class IAMCredentialsClientTest {
  private static MockIAMCredentials mockIAMCredentials;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IamCredentialsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIAMCredentials = new MockIAMCredentials();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIAMCredentials));
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
    IamCredentialsSettings settings =
        IamCredentialsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IamCredentialsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateAccessTokenTest() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    List<String> scope = new ArrayList<>();
    Duration lifetime = Duration.newBuilder().build();

    GenerateAccessTokenResponse actualResponse =
        client.generateAccessToken(name, delegates, scope, lifetime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(scope, actualRequest.getScopeList());
    Assert.assertEquals(lifetime, actualRequest.getLifetime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

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
    mockIAMCredentials.addResponse(expectedResponse);

    String name = "name3373707";
    List<String> delegates = new ArrayList<>();
    List<String> scope = new ArrayList<>();
    Duration lifetime = Duration.newBuilder().build();

    GenerateAccessTokenResponse actualResponse =
        client.generateAccessToken(name, delegates, scope, lifetime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(scope, actualRequest.getScopeList());
    Assert.assertEquals(lifetime, actualRequest.getLifetime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      String name = "name3373707";
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
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String audience = "audience975628804";
    boolean includeEmail = true;

    GenerateIdTokenResponse actualResponse =
        client.generateIdToken(name, delegates, audience, includeEmail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateIdTokenRequest actualRequest = ((GenerateIdTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(audience, actualRequest.getAudience());
    Assert.assertEquals(includeEmail, actualRequest.getIncludeEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateIdTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

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
    mockIAMCredentials.addResponse(expectedResponse);

    String name = "name3373707";
    List<String> delegates = new ArrayList<>();
    String audience = "audience975628804";
    boolean includeEmail = true;

    GenerateIdTokenResponse actualResponse =
        client.generateIdToken(name, delegates, audience, includeEmail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateIdTokenRequest actualRequest = ((GenerateIdTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(audience, actualRequest.getAudience());
    Assert.assertEquals(includeEmail, actualRequest.getIncludeEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateIdTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      String name = "name3373707";
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
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    ByteString payload = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignBlobRequest actualRequest = ((SignBlobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signBlobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

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
    mockIAMCredentials.addResponse(expectedResponse);

    String name = "name3373707";
    List<String> delegates = new ArrayList<>();
    ByteString payload = ByteString.EMPTY;

    SignBlobResponse actualResponse = client.signBlob(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignBlobRequest actualRequest = ((SignBlobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signBlobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      String name = "name3373707";
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
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignJwtRequest actualRequest = ((SignJwtRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signJwtExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

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
    mockIAMCredentials.addResponse(expectedResponse);

    String name = "name3373707";
    List<String> delegates = new ArrayList<>();
    String payload = "payload-786701938";

    SignJwtResponse actualResponse = client.signJwt(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignJwtRequest actualRequest = ((SignJwtRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signJwtExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      String name = "name3373707";
      List<String> delegates = new ArrayList<>();
      String payload = "payload-786701938";
      client.signJwt(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
