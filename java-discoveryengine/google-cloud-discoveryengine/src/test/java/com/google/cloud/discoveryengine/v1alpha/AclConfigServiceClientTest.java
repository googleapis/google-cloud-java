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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class AclConfigServiceClientTest {
  private static MockAclConfigService mockAclConfigService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AclConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAclConfigService = new MockAclConfigService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAclConfigService, mockLocations));
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
    AclConfigServiceSettings settings =
        AclConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AclConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateAclConfigTest() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockAclConfigService.addResponse(expectedResponse);

    UpdateAclConfigRequest request =
        UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();

    AclConfig actualResponse = client.updateAclConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAclConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAclConfigRequest actualRequest = ((UpdateAclConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAclConfig(), actualRequest.getAclConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAclConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAclConfigService.addException(exception);

    try {
      UpdateAclConfigRequest request =
          UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();
      client.updateAclConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAclConfigTest() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockAclConfigService.addResponse(expectedResponse);

    AclConfigName name = AclConfigName.of("[PROJECT]", "[LOCATION]");

    AclConfig actualResponse = client.getAclConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAclConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAclConfigRequest actualRequest = ((GetAclConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAclConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAclConfigService.addException(exception);

    try {
      AclConfigName name = AclConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAclConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAclConfigTest2() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockAclConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    AclConfig actualResponse = client.getAclConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAclConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAclConfigRequest actualRequest = ((GetAclConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAclConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAclConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getAclConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
