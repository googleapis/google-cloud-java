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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class DeveloperRegistrationServiceClientTest {
  private static MockDeveloperRegistrationService mockDeveloperRegistrationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeveloperRegistrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeveloperRegistrationService = new MockDeveloperRegistrationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDeveloperRegistrationService));
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
    DeveloperRegistrationServiceSettings settings =
        DeveloperRegistrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeveloperRegistrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void registerGcpTest() throws Exception {
    DeveloperRegistration expectedResponse =
        DeveloperRegistration.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .addAllGcpIds(new ArrayList<String>())
            .build();
    mockDeveloperRegistrationService.addResponse(expectedResponse);

    RegisterGcpRequest request =
        RegisterGcpRequest.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .setDeveloperEmail("developerEmail251249138")
            .build();

    DeveloperRegistration actualResponse = client.registerGcp(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterGcpRequest actualRequest = ((RegisterGcpRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getDeveloperEmail(), actualRequest.getDeveloperEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerGcpExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperRegistrationService.addException(exception);

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
    mockDeveloperRegistrationService.addResponse(expectedResponse);

    DeveloperRegistrationName name = DeveloperRegistrationName.of("[ACCOUNT]");

    DeveloperRegistration actualResponse = client.getDeveloperRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeveloperRegistrationRequest actualRequest =
        ((GetDeveloperRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeveloperRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperRegistrationService.addException(exception);

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
    mockDeveloperRegistrationService.addResponse(expectedResponse);

    String name = "name3373707";

    DeveloperRegistration actualResponse = client.getDeveloperRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeveloperRegistrationRequest actualRequest =
        ((GetDeveloperRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeveloperRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperRegistrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getDeveloperRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unregisterGcpTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDeveloperRegistrationService.addResponse(expectedResponse);

    UnregisterGcpRequest request =
        UnregisterGcpRequest.newBuilder()
            .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
            .build();

    client.unregisterGcp(request);

    List<AbstractMessage> actualRequests = mockDeveloperRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnregisterGcpRequest actualRequest = ((UnregisterGcpRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unregisterGcpExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperRegistrationService.addException(exception);

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
