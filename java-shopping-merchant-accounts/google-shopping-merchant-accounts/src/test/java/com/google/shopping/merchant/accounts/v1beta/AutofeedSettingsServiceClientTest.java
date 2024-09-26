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
public class AutofeedSettingsServiceClientTest {
  private static MockAutofeedSettingsService mockAutofeedSettingsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AutofeedSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAutofeedSettingsService = new MockAutofeedSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAutofeedSettingsService));
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
    AutofeedSettingsServiceSettings settings =
        AutofeedSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutofeedSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAutofeedSettingsTest() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockAutofeedSettingsService.addResponse(expectedResponse);

    AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");

    AutofeedSettings actualResponse = client.getAutofeedSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutofeedSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutofeedSettingsRequest actualRequest = ((GetAutofeedSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutofeedSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutofeedSettingsService.addException(exception);

    try {
      AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");
      client.getAutofeedSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutofeedSettingsTest2() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockAutofeedSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    AutofeedSettings actualResponse = client.getAutofeedSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutofeedSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutofeedSettingsRequest actualRequest = ((GetAutofeedSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutofeedSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutofeedSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAutofeedSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutofeedSettingsTest() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockAutofeedSettingsService.addResponse(expectedResponse);

    AutofeedSettings autofeedSettings = AutofeedSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AutofeedSettings actualResponse = client.updateAutofeedSettings(autofeedSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutofeedSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAutofeedSettingsRequest actualRequest =
        ((UpdateAutofeedSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(autofeedSettings, actualRequest.getAutofeedSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAutofeedSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutofeedSettingsService.addException(exception);

    try {
      AutofeedSettings autofeedSettings = AutofeedSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAutofeedSettings(autofeedSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
