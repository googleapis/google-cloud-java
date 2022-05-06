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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CloudShellServiceClientTest {
  private static MockCloudShellService mockCloudShellService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudShellServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudShellService = new MockCloudShellService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudShellService));
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
    CloudShellServiceSettings settings =
        CloudShellServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudShellServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockCloudShellService.addResponse(expectedResponse);

    EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

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
    mockCloudShellService.addResponse(expectedResponse);

    String name = "name3373707";

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCloudShellService.addResponse(resultOperation);

    StartEnvironmentRequest request =
        StartEnvironmentRequest.newBuilder()
            .setName("name3373707")
            .setAccessToken("accessToken-1042689291")
            .addAllPublicKeys(new ArrayList<String>())
            .build();

    StartEnvironmentResponse actualResponse = client.startEnvironmentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartEnvironmentRequest actualRequest = ((StartEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAccessToken(), actualRequest.getAccessToken());
    Assert.assertEquals(request.getPublicKeysList(), actualRequest.getPublicKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

    try {
      StartEnvironmentRequest request =
          StartEnvironmentRequest.newBuilder()
              .setName("name3373707")
              .setAccessToken("accessToken-1042689291")
              .addAllPublicKeys(new ArrayList<String>())
              .build();
      client.startEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudShellService.addResponse(resultOperation);

    AuthorizeEnvironmentRequest request =
        AuthorizeEnvironmentRequest.newBuilder()
            .setName("name3373707")
            .setAccessToken("accessToken-1042689291")
            .setIdToken("idToken1642509726")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    AuthorizeEnvironmentResponse actualResponse = client.authorizeEnvironmentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AuthorizeEnvironmentRequest actualRequest =
        ((AuthorizeEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAccessToken(), actualRequest.getAccessToken());
    Assert.assertEquals(request.getIdToken(), actualRequest.getIdToken());
    Assert.assertEquals(request.getExpireTime(), actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void authorizeEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

    try {
      AuthorizeEnvironmentRequest request =
          AuthorizeEnvironmentRequest.newBuilder()
              .setName("name3373707")
              .setAccessToken("accessToken-1042689291")
              .setIdToken("idToken1642509726")
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      client.authorizeEnvironmentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudShellService.addResponse(resultOperation);

    AddPublicKeyRequest request =
        AddPublicKeyRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setKey("key106079")
            .build();

    AddPublicKeyResponse actualResponse = client.addPublicKeyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddPublicKeyRequest actualRequest = ((AddPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getKey(), actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addPublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

    try {
      AddPublicKeyRequest request =
          AddPublicKeyRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setKey("key106079")
              .build();
      client.addPublicKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudShellService.addResponse(resultOperation);

    RemovePublicKeyRequest request =
        RemovePublicKeyRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setKey("key106079")
            .build();

    RemovePublicKeyResponse actualResponse = client.removePublicKeyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudShellService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemovePublicKeyRequest actualRequest = ((RemovePublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getKey(), actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removePublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudShellService.addException(exception);

    try {
      RemovePublicKeyRequest request =
          RemovePublicKeyRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setKey("key106079")
              .build();
      client.removePublicKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
