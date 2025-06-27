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

package com.google.shopping.merchant.productstudio.v1alpha;

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
public class ImageServiceClientTest {
  private static MockImageService mockImageService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ImageServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockImageService = new MockImageService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockImageService));
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
    ImageServiceSettings settings =
        ImageServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ImageServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateProductImageBackgroundTest() throws Exception {
    GenerateProductImageBackgroundResponse expectedResponse =
        GenerateProductImageBackgroundResponse.newBuilder()
            .setGeneratedImage(GeneratedImage.newBuilder().build())
            .build();
    mockImageService.addResponse(expectedResponse);

    String name = "name3373707";

    GenerateProductImageBackgroundResponse actualResponse =
        client.generateProductImageBackground(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateProductImageBackgroundRequest actualRequest =
        ((GenerateProductImageBackgroundRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateProductImageBackgroundExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageService.addException(exception);

    try {
      String name = "name3373707";
      client.generateProductImageBackground(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeProductImageBackgroundTest() throws Exception {
    RemoveProductImageBackgroundResponse expectedResponse =
        RemoveProductImageBackgroundResponse.newBuilder()
            .setGeneratedImage(GeneratedImage.newBuilder().build())
            .build();
    mockImageService.addResponse(expectedResponse);

    String name = "name3373707";

    RemoveProductImageBackgroundResponse actualResponse = client.removeProductImageBackground(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductImageBackgroundRequest actualRequest =
        ((RemoveProductImageBackgroundRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeProductImageBackgroundExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageService.addException(exception);

    try {
      String name = "name3373707";
      client.removeProductImageBackground(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void upscaleProductImageTest() throws Exception {
    UpscaleProductImageResponse expectedResponse =
        UpscaleProductImageResponse.newBuilder()
            .setGeneratedImage(GeneratedImage.newBuilder().build())
            .build();
    mockImageService.addResponse(expectedResponse);

    String name = "name3373707";

    UpscaleProductImageResponse actualResponse = client.upscaleProductImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpscaleProductImageRequest actualRequest = ((UpscaleProductImageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upscaleProductImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageService.addException(exception);

    try {
      String name = "name3373707";
      client.upscaleProductImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
