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

package com.google.shopping.merchant.accounts.v1beta;

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
public class ShippingSettingsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockShippingSettingsService mockShippingSettingsService;
  private LocalChannelProvider channelProvider;
  private ShippingSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockShippingSettingsService = new MockShippingSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockShippingSettingsService));
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
    ShippingSettingsServiceSettings settings =
        ShippingSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ShippingSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getShippingSettingsTest() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockShippingSettingsService.addResponse(expectedResponse);

    ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");

    ShippingSettings actualResponse = client.getShippingSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockShippingSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetShippingSettingsRequest actualRequest = ((GetShippingSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getShippingSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockShippingSettingsService.addException(exception);

    try {
      ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");
      client.getShippingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShippingSettingsTest2() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockShippingSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    ShippingSettings actualResponse = client.getShippingSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockShippingSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetShippingSettingsRequest actualRequest = ((GetShippingSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getShippingSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockShippingSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getShippingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertShippingSettingsTest() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockShippingSettingsService.addResponse(expectedResponse);

    InsertShippingSettingsRequest request =
        InsertShippingSettingsRequest.newBuilder()
            .setParent("parent-995424086")
            .setShippingSetting(ShippingSettings.newBuilder().build())
            .build();

    ShippingSettings actualResponse = client.insertShippingSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockShippingSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertShippingSettingsRequest actualRequest =
        ((InsertShippingSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getShippingSetting(), actualRequest.getShippingSetting());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertShippingSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockShippingSettingsService.addException(exception);

    try {
      InsertShippingSettingsRequest request =
          InsertShippingSettingsRequest.newBuilder()
              .setParent("parent-995424086")
              .setShippingSetting(ShippingSettings.newBuilder().build())
              .build();
      client.insertShippingSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
