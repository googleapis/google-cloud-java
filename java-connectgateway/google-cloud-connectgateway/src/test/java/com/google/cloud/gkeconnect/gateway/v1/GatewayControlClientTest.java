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

package com.google.cloud.gkeconnect.gateway.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class GatewayControlClientTest {
  private static MockGatewayControl mockGatewayControl;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GatewayControlClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGatewayControl = new MockGatewayControl();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGatewayControl));
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
    GatewayControlSettings settings =
        GatewayControlSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GatewayControlClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateCredentialsTest() throws Exception {
    GenerateCredentialsResponse expectedResponse =
        GenerateCredentialsResponse.newBuilder()
            .setKubeconfig(ByteString.EMPTY)
            .setEndpoint("endpoint1741102485")
            .build();
    mockGatewayControl.addResponse(expectedResponse);

    GenerateCredentialsRequest request =
        GenerateCredentialsRequest.newBuilder()
            .setName("name3373707")
            .setForceUseAgent(true)
            .setVersion("version351608024")
            .setKubernetesNamespace("kubernetesNamespace-1862862667")
            .build();

    GenerateCredentialsResponse actualResponse = client.generateCredentials(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGatewayControl.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateCredentialsRequest actualRequest = ((GenerateCredentialsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getForceUseAgent(), actualRequest.getForceUseAgent());
    Assert.assertEquals(request.getVersion(), actualRequest.getVersion());
    Assert.assertEquals(request.getKubernetesNamespace(), actualRequest.getKubernetesNamespace());
    Assert.assertEquals(request.getOperatingSystem(), actualRequest.getOperatingSystem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateCredentialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGatewayControl.addException(exception);

    try {
      GenerateCredentialsRequest request =
          GenerateCredentialsRequest.newBuilder()
              .setName("name3373707")
              .setForceUseAgent(true)
              .setVersion("version351608024")
              .setKubernetesNamespace("kubernetesNamespace-1862862667")
              .build();
      client.generateCredentials(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
