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
import com.google.protobuf.FieldMask;
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
public class AutomaticImprovementsServiceClientTest {
  private static MockAutomaticImprovementsService mockAutomaticImprovementsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AutomaticImprovementsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAutomaticImprovementsService = new MockAutomaticImprovementsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAutomaticImprovementsService));
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
    AutomaticImprovementsServiceSettings settings =
        AutomaticImprovementsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutomaticImprovementsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAutomaticImprovementsTest() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockAutomaticImprovementsService.addResponse(expectedResponse);

    AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");

    AutomaticImprovements actualResponse = client.getAutomaticImprovements(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutomaticImprovementsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutomaticImprovementsRequest actualRequest =
        ((GetAutomaticImprovementsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutomaticImprovementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutomaticImprovementsService.addException(exception);

    try {
      AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");
      client.getAutomaticImprovements(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutomaticImprovementsTest2() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockAutomaticImprovementsService.addResponse(expectedResponse);

    String name = "name3373707";

    AutomaticImprovements actualResponse = client.getAutomaticImprovements(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutomaticImprovementsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutomaticImprovementsRequest actualRequest =
        ((GetAutomaticImprovementsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutomaticImprovementsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutomaticImprovementsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAutomaticImprovements(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutomaticImprovementsTest() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockAutomaticImprovementsService.addResponse(expectedResponse);

    AutomaticImprovements automaticImprovements = AutomaticImprovements.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AutomaticImprovements actualResponse =
        client.updateAutomaticImprovements(automaticImprovements, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutomaticImprovementsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAutomaticImprovementsRequest actualRequest =
        ((UpdateAutomaticImprovementsRequest) actualRequests.get(0));

    Assert.assertEquals(automaticImprovements, actualRequest.getAutomaticImprovements());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAutomaticImprovementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutomaticImprovementsService.addException(exception);

    try {
      AutomaticImprovements automaticImprovements = AutomaticImprovements.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAutomaticImprovements(automaticImprovements, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
