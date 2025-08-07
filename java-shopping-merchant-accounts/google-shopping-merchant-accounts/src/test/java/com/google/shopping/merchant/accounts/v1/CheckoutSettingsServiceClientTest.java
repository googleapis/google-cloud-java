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
import com.google.protobuf.FieldMask;
import com.google.shopping.type.Destination;
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
public class CheckoutSettingsServiceClientTest {
  private static MockCheckoutSettingsService mockCheckoutSettingsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CheckoutSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCheckoutSettingsService = new MockCheckoutSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCheckoutSettingsService));
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
    CheckoutSettingsServiceSettings settings =
        CheckoutSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CheckoutSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");

    CheckoutSettings actualResponse = client.getCheckoutSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCheckoutSettingsRequest actualRequest = ((GetCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCheckoutSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
      client.getCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCheckoutSettingsTest2() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    CheckoutSettings actualResponse = client.getCheckoutSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCheckoutSettingsRequest actualRequest = ((GetCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCheckoutSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    ProgramName parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
    CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();

    CheckoutSettings actualResponse = client.createCheckoutSettings(parent, checkoutSettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCheckoutSettingsRequest actualRequest =
        ((CreateCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(checkoutSettings, actualRequest.getCheckoutSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCheckoutSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      ProgramName parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
      client.createCheckoutSettings(parent, checkoutSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCheckoutSettingsTest2() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();

    CheckoutSettings actualResponse = client.createCheckoutSettings(parent, checkoutSettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCheckoutSettingsRequest actualRequest =
        ((CreateCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(checkoutSettings, actualRequest.getCheckoutSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCheckoutSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
      client.createCheckoutSettings(parent, checkoutSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CheckoutSettings actualResponse = client.updateCheckoutSettings(checkoutSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCheckoutSettingsRequest actualRequest =
        ((UpdateCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(checkoutSettings, actualRequest.getCheckoutSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCheckoutSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCheckoutSettings(checkoutSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCheckoutSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");

    client.deleteCheckoutSettings(name);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCheckoutSettingsRequest actualRequest =
        ((DeleteCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCheckoutSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
      client.deleteCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCheckoutSettingsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCheckoutSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCheckoutSettings(name);

    List<AbstractMessage> actualRequests = mockCheckoutSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCheckoutSettingsRequest actualRequest =
        ((DeleteCheckoutSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCheckoutSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCheckoutSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
