/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class FulfillmentsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockFulfillments mockFulfillments;
  private FulfillmentsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockFulfillments = new MockFulfillments();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFulfillments));
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
    FulfillmentsSettings settings =
        FulfillmentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FulfillmentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getFulfillmentTest() throws Exception {
    Fulfillment expectedResponse =
        Fulfillment.newBuilder()
            .setName(FulfillmentName.ofProjectName("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setEnabled(true)
            .addAllFeatures(new ArrayList<Fulfillment.Feature>())
            .build();
    mockFulfillments.addResponse(expectedResponse);

    FulfillmentName name = FulfillmentName.ofProjectName("[PROJECT]");

    Fulfillment actualResponse = client.getFulfillment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFulfillments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFulfillmentRequest actualRequest = ((GetFulfillmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFulfillmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFulfillments.addException(exception);

    try {
      FulfillmentName name = FulfillmentName.ofProjectName("[PROJECT]");
      client.getFulfillment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFulfillmentTest2() throws Exception {
    Fulfillment expectedResponse =
        Fulfillment.newBuilder()
            .setName(FulfillmentName.ofProjectName("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setEnabled(true)
            .addAllFeatures(new ArrayList<Fulfillment.Feature>())
            .build();
    mockFulfillments.addResponse(expectedResponse);

    String name = "name3373707";

    Fulfillment actualResponse = client.getFulfillment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFulfillments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFulfillmentRequest actualRequest = ((GetFulfillmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFulfillmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFulfillments.addException(exception);

    try {
      String name = "name3373707";
      client.getFulfillment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFulfillmentTest() throws Exception {
    Fulfillment expectedResponse =
        Fulfillment.newBuilder()
            .setName(FulfillmentName.ofProjectName("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setEnabled(true)
            .addAllFeatures(new ArrayList<Fulfillment.Feature>())
            .build();
    mockFulfillments.addResponse(expectedResponse);

    Fulfillment fulfillment = Fulfillment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Fulfillment actualResponse = client.updateFulfillment(fulfillment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFulfillments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFulfillmentRequest actualRequest = ((UpdateFulfillmentRequest) actualRequests.get(0));

    Assert.assertEquals(fulfillment, actualRequest.getFulfillment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFulfillmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFulfillments.addException(exception);

    try {
      Fulfillment fulfillment = Fulfillment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFulfillment(fulfillment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
