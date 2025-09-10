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

package com.google.api.cloudquotas.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class QuotaAdjusterSettingsManagerClientTest {
  private static MockQuotaAdjusterSettingsManager mockQuotaAdjusterSettingsManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private QuotaAdjusterSettingsManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockQuotaAdjusterSettingsManager = new MockQuotaAdjusterSettingsManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockQuotaAdjusterSettingsManager));
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
    QuotaAdjusterSettingsManagerSettings settings =
        QuotaAdjusterSettingsManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = QuotaAdjusterSettingsManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateQuotaAdjusterSettingsTest() throws Exception {
    QuotaAdjusterSettings expectedResponse =
        QuotaAdjusterSettings.newBuilder()
            .setName(
                QuotaAdjusterSettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
                    .toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setInherited(true)
            .setInheritedFrom("inheritedFrom1276696996")
            .build();
    mockQuotaAdjusterSettingsManager.addResponse(expectedResponse);

    QuotaAdjusterSettings quotaAdjusterSettings = QuotaAdjusterSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QuotaAdjusterSettings actualResponse =
        client.updateQuotaAdjusterSettings(quotaAdjusterSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockQuotaAdjusterSettingsManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQuotaAdjusterSettingsRequest actualRequest =
        ((UpdateQuotaAdjusterSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(quotaAdjusterSettings, actualRequest.getQuotaAdjusterSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQuotaAdjusterSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaAdjusterSettingsManager.addException(exception);

    try {
      QuotaAdjusterSettings quotaAdjusterSettings = QuotaAdjusterSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQuotaAdjusterSettings(quotaAdjusterSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaAdjusterSettingsTest() throws Exception {
    QuotaAdjusterSettings expectedResponse =
        QuotaAdjusterSettings.newBuilder()
            .setName(
                QuotaAdjusterSettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
                    .toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setInherited(true)
            .setInheritedFrom("inheritedFrom1276696996")
            .build();
    mockQuotaAdjusterSettingsManager.addResponse(expectedResponse);

    QuotaAdjusterSettingsName name =
        QuotaAdjusterSettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    QuotaAdjusterSettings actualResponse = client.getQuotaAdjusterSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockQuotaAdjusterSettingsManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaAdjusterSettingsRequest actualRequest =
        ((GetQuotaAdjusterSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaAdjusterSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaAdjusterSettingsManager.addException(exception);

    try {
      QuotaAdjusterSettingsName name =
          QuotaAdjusterSettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.getQuotaAdjusterSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaAdjusterSettingsTest2() throws Exception {
    QuotaAdjusterSettings expectedResponse =
        QuotaAdjusterSettings.newBuilder()
            .setName(
                QuotaAdjusterSettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
                    .toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setInherited(true)
            .setInheritedFrom("inheritedFrom1276696996")
            .build();
    mockQuotaAdjusterSettingsManager.addResponse(expectedResponse);

    String name = "name3373707";

    QuotaAdjusterSettings actualResponse = client.getQuotaAdjusterSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockQuotaAdjusterSettingsManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaAdjusterSettingsRequest actualRequest =
        ((GetQuotaAdjusterSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaAdjusterSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaAdjusterSettingsManager.addException(exception);

    try {
      String name = "name3373707";
      client.getQuotaAdjusterSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
