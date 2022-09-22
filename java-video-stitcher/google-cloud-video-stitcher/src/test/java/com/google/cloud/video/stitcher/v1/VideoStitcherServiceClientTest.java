/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.video.stitcher.v1;

import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListCdnKeysPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class VideoStitcherServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockVideoStitcherService mockVideoStitcherService;
  private LocalChannelProvider channelProvider;
  private VideoStitcherServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVideoStitcherService = new MockVideoStitcherService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockVideoStitcherService));
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
    VideoStitcherServiceSettings settings =
        VideoStitcherServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VideoStitcherServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createCdnKeyTest() throws Exception {
    CdnKey expectedResponse =
        CdnKey.newBuilder()
            .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
            .setHostname("hostname-299803597")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CdnKey cdnKey = CdnKey.newBuilder().build();
    String cdnKeyId = "cdnKeyId-1777782867";

    CdnKey actualResponse = client.createCdnKey(parent, cdnKey, cdnKeyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCdnKeyRequest actualRequest = ((CreateCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cdnKey, actualRequest.getCdnKey());
    Assert.assertEquals(cdnKeyId, actualRequest.getCdnKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCdnKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CdnKey cdnKey = CdnKey.newBuilder().build();
      String cdnKeyId = "cdnKeyId-1777782867";
      client.createCdnKey(parent, cdnKey, cdnKeyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCdnKeyTest2() throws Exception {
    CdnKey expectedResponse =
        CdnKey.newBuilder()
            .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
            .setHostname("hostname-299803597")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CdnKey cdnKey = CdnKey.newBuilder().build();
    String cdnKeyId = "cdnKeyId-1777782867";

    CdnKey actualResponse = client.createCdnKey(parent, cdnKey, cdnKeyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCdnKeyRequest actualRequest = ((CreateCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cdnKey, actualRequest.getCdnKey());
    Assert.assertEquals(cdnKeyId, actualRequest.getCdnKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCdnKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      CdnKey cdnKey = CdnKey.newBuilder().build();
      String cdnKeyId = "cdnKeyId-1777782867";
      client.createCdnKey(parent, cdnKey, cdnKeyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCdnKeysTest() throws Exception {
    CdnKey responsesElement = CdnKey.newBuilder().build();
    ListCdnKeysResponse expectedResponse =
        ListCdnKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCdnKeys(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCdnKeysPagedResponse pagedListResponse = client.listCdnKeys(parent);

    List<CdnKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCdnKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCdnKeysRequest actualRequest = ((ListCdnKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCdnKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCdnKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCdnKeysTest2() throws Exception {
    CdnKey responsesElement = CdnKey.newBuilder().build();
    ListCdnKeysResponse expectedResponse =
        ListCdnKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCdnKeys(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCdnKeysPagedResponse pagedListResponse = client.listCdnKeys(parent);

    List<CdnKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCdnKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCdnKeysRequest actualRequest = ((ListCdnKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCdnKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCdnKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCdnKeyTest() throws Exception {
    CdnKey expectedResponse =
        CdnKey.newBuilder()
            .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
            .setHostname("hostname-299803597")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");

    CdnKey actualResponse = client.getCdnKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCdnKeyRequest actualRequest = ((GetCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCdnKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
      client.getCdnKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCdnKeyTest2() throws Exception {
    CdnKey expectedResponse =
        CdnKey.newBuilder()
            .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
            .setHostname("hostname-299803597")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    CdnKey actualResponse = client.getCdnKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCdnKeyRequest actualRequest = ((GetCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCdnKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getCdnKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCdnKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVideoStitcherService.addResponse(expectedResponse);

    CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");

    client.deleteCdnKey(name);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCdnKeyRequest actualRequest = ((DeleteCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCdnKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
      client.deleteCdnKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCdnKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCdnKey(name);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCdnKeyRequest actualRequest = ((DeleteCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCdnKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCdnKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCdnKeyTest() throws Exception {
    CdnKey expectedResponse =
        CdnKey.newBuilder()
            .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
            .setHostname("hostname-299803597")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    CdnKey cdnKey = CdnKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CdnKey actualResponse = client.updateCdnKey(cdnKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCdnKeyRequest actualRequest = ((UpdateCdnKeyRequest) actualRequests.get(0));

    Assert.assertEquals(cdnKey, actualRequest.getCdnKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCdnKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      CdnKey cdnKey = CdnKey.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCdnKey(cdnKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVodSessionTest() throws Exception {
    VodSession expectedResponse =
        VodSession.newBuilder()
            .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
            .setInterstitials(Interstitials.newBuilder().build())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setAdTagUri("adTagUri-1692450443")
            .putAllAdTagMacroMap(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setAssetId("assetId-704776149")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VodSession vodSession = VodSession.newBuilder().build();

    VodSession actualResponse = client.createVodSession(parent, vodSession);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVodSessionRequest actualRequest = ((CreateVodSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vodSession, actualRequest.getVodSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVodSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VodSession vodSession = VodSession.newBuilder().build();
      client.createVodSession(parent, vodSession);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVodSessionTest2() throws Exception {
    VodSession expectedResponse =
        VodSession.newBuilder()
            .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
            .setInterstitials(Interstitials.newBuilder().build())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setAdTagUri("adTagUri-1692450443")
            .putAllAdTagMacroMap(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setAssetId("assetId-704776149")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    VodSession vodSession = VodSession.newBuilder().build();

    VodSession actualResponse = client.createVodSession(parent, vodSession);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVodSessionRequest actualRequest = ((CreateVodSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(vodSession, actualRequest.getVodSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVodSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      VodSession vodSession = VodSession.newBuilder().build();
      client.createVodSession(parent, vodSession);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodSessionTest() throws Exception {
    VodSession expectedResponse =
        VodSession.newBuilder()
            .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
            .setInterstitials(Interstitials.newBuilder().build())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setAdTagUri("adTagUri-1692450443")
            .putAllAdTagMacroMap(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setAssetId("assetId-704776149")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    VodSessionName name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");

    VodSession actualResponse = client.getVodSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodSessionRequest actualRequest = ((GetVodSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      VodSessionName name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
      client.getVodSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodSessionTest2() throws Exception {
    VodSession expectedResponse =
        VodSession.newBuilder()
            .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
            .setInterstitials(Interstitials.newBuilder().build())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setAdTagUri("adTagUri-1692450443")
            .putAllAdTagMacroMap(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setAssetId("assetId-704776149")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    VodSession actualResponse = client.getVodSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodSessionRequest actualRequest = ((GetVodSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getVodSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVodStitchDetailsTest() throws Exception {
    VodStitchDetail responsesElement = VodStitchDetail.newBuilder().build();
    ListVodStitchDetailsResponse expectedResponse =
        ListVodStitchDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVodStitchDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");

    ListVodStitchDetailsPagedResponse pagedListResponse = client.listVodStitchDetails(parent);

    List<VodStitchDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVodStitchDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVodStitchDetailsRequest actualRequest =
        ((ListVodStitchDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVodStitchDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
      client.listVodStitchDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVodStitchDetailsTest2() throws Exception {
    VodStitchDetail responsesElement = VodStitchDetail.newBuilder().build();
    ListVodStitchDetailsResponse expectedResponse =
        ListVodStitchDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVodStitchDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVodStitchDetailsPagedResponse pagedListResponse = client.listVodStitchDetails(parent);

    List<VodStitchDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVodStitchDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVodStitchDetailsRequest actualRequest =
        ((ListVodStitchDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVodStitchDetailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVodStitchDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodStitchDetailTest() throws Exception {
    VodStitchDetail expectedResponse =
        VodStitchDetail.newBuilder()
            .setName(
                VodStitchDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
                    .toString())
            .addAllAdStitchDetails(new ArrayList<AdStitchDetail>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    VodStitchDetailName name =
        VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]");

    VodStitchDetail actualResponse = client.getVodStitchDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodStitchDetailRequest actualRequest = ((GetVodStitchDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodStitchDetailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      VodStitchDetailName name =
          VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]");
      client.getVodStitchDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodStitchDetailTest2() throws Exception {
    VodStitchDetail expectedResponse =
        VodStitchDetail.newBuilder()
            .setName(
                VodStitchDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
                    .toString())
            .addAllAdStitchDetails(new ArrayList<AdStitchDetail>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    VodStitchDetail actualResponse = client.getVodStitchDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodStitchDetailRequest actualRequest = ((GetVodStitchDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodStitchDetailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getVodStitchDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVodAdTagDetailsTest() throws Exception {
    VodAdTagDetail responsesElement = VodAdTagDetail.newBuilder().build();
    ListVodAdTagDetailsResponse expectedResponse =
        ListVodAdTagDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVodAdTagDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");

    ListVodAdTagDetailsPagedResponse pagedListResponse = client.listVodAdTagDetails(parent);

    List<VodAdTagDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVodAdTagDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVodAdTagDetailsRequest actualRequest = ((ListVodAdTagDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVodAdTagDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
      client.listVodAdTagDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVodAdTagDetailsTest2() throws Exception {
    VodAdTagDetail responsesElement = VodAdTagDetail.newBuilder().build();
    ListVodAdTagDetailsResponse expectedResponse =
        ListVodAdTagDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVodAdTagDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVodAdTagDetailsPagedResponse pagedListResponse = client.listVodAdTagDetails(parent);

    List<VodAdTagDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVodAdTagDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVodAdTagDetailsRequest actualRequest = ((ListVodAdTagDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVodAdTagDetailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVodAdTagDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodAdTagDetailTest() throws Exception {
    VodAdTagDetail expectedResponse =
        VodAdTagDetail.newBuilder()
            .setName(
                VodAdTagDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
                    .toString())
            .addAllAdRequests(new ArrayList<AdRequest>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    VodAdTagDetailName name =
        VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]");

    VodAdTagDetail actualResponse = client.getVodAdTagDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodAdTagDetailRequest actualRequest = ((GetVodAdTagDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodAdTagDetailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      VodAdTagDetailName name =
          VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]");
      client.getVodAdTagDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVodAdTagDetailTest2() throws Exception {
    VodAdTagDetail expectedResponse =
        VodAdTagDetail.newBuilder()
            .setName(
                VodAdTagDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
                    .toString())
            .addAllAdRequests(new ArrayList<AdRequest>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    VodAdTagDetail actualResponse = client.getVodAdTagDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVodAdTagDetailRequest actualRequest = ((GetVodAdTagDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVodAdTagDetailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getVodAdTagDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLiveAdTagDetailsTest() throws Exception {
    LiveAdTagDetail responsesElement = LiveAdTagDetail.newBuilder().build();
    ListLiveAdTagDetailsResponse expectedResponse =
        ListLiveAdTagDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLiveAdTagDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");

    ListLiveAdTagDetailsPagedResponse pagedListResponse = client.listLiveAdTagDetails(parent);

    List<LiveAdTagDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLiveAdTagDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLiveAdTagDetailsRequest actualRequest =
        ((ListLiveAdTagDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLiveAdTagDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
      client.listLiveAdTagDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLiveAdTagDetailsTest2() throws Exception {
    LiveAdTagDetail responsesElement = LiveAdTagDetail.newBuilder().build();
    ListLiveAdTagDetailsResponse expectedResponse =
        ListLiveAdTagDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLiveAdTagDetails(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLiveAdTagDetailsPagedResponse pagedListResponse = client.listLiveAdTagDetails(parent);

    List<LiveAdTagDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLiveAdTagDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLiveAdTagDetailsRequest actualRequest =
        ((ListLiveAdTagDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLiveAdTagDetailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLiveAdTagDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLiveAdTagDetailTest() throws Exception {
    LiveAdTagDetail expectedResponse =
        LiveAdTagDetail.newBuilder()
            .setName(
                LiveAdTagDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
                    .toString())
            .addAllAdRequests(new ArrayList<AdRequest>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LiveAdTagDetailName name =
        LiveAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]");

    LiveAdTagDetail actualResponse = client.getLiveAdTagDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLiveAdTagDetailRequest actualRequest = ((GetLiveAdTagDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLiveAdTagDetailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LiveAdTagDetailName name =
          LiveAdTagDetailName.of(
              "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]");
      client.getLiveAdTagDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLiveAdTagDetailTest2() throws Exception {
    LiveAdTagDetail expectedResponse =
        LiveAdTagDetail.newBuilder()
            .setName(
                LiveAdTagDetailName.of(
                        "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
                    .toString())
            .addAllAdRequests(new ArrayList<AdRequest>())
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    LiveAdTagDetail actualResponse = client.getLiveAdTagDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLiveAdTagDetailRequest actualRequest = ((GetLiveAdTagDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLiveAdTagDetailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getLiveAdTagDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSlateTest() throws Exception {
    Slate expectedResponse =
        Slate.newBuilder()
            .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
            .setUri("uri116076")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Slate slate = Slate.newBuilder().build();
    String slateId = "slateId-2126174060";

    Slate actualResponse = client.createSlate(parent, slate, slateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSlateRequest actualRequest = ((CreateSlateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(slate, actualRequest.getSlate());
    Assert.assertEquals(slateId, actualRequest.getSlateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSlateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Slate slate = Slate.newBuilder().build();
      String slateId = "slateId-2126174060";
      client.createSlate(parent, slate, slateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSlateTest2() throws Exception {
    Slate expectedResponse =
        Slate.newBuilder()
            .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
            .setUri("uri116076")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Slate slate = Slate.newBuilder().build();
    String slateId = "slateId-2126174060";

    Slate actualResponse = client.createSlate(parent, slate, slateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSlateRequest actualRequest = ((CreateSlateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(slate, actualRequest.getSlate());
    Assert.assertEquals(slateId, actualRequest.getSlateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSlateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      Slate slate = Slate.newBuilder().build();
      String slateId = "slateId-2126174060";
      client.createSlate(parent, slate, slateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSlatesTest() throws Exception {
    Slate responsesElement = Slate.newBuilder().build();
    ListSlatesResponse expectedResponse =
        ListSlatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSlates(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSlatesPagedResponse pagedListResponse = client.listSlates(parent);

    List<Slate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSlatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSlatesRequest actualRequest = ((ListSlatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSlatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSlates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSlatesTest2() throws Exception {
    Slate responsesElement = Slate.newBuilder().build();
    ListSlatesResponse expectedResponse =
        ListSlatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSlates(Arrays.asList(responsesElement))
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSlatesPagedResponse pagedListResponse = client.listSlates(parent);

    List<Slate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSlatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSlatesRequest actualRequest = ((ListSlatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSlatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSlates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSlateTest() throws Exception {
    Slate expectedResponse =
        Slate.newBuilder()
            .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
            .setUri("uri116076")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");

    Slate actualResponse = client.getSlate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSlateRequest actualRequest = ((GetSlateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSlateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
      client.getSlate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSlateTest2() throws Exception {
    Slate expectedResponse =
        Slate.newBuilder()
            .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
            .setUri("uri116076")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    Slate actualResponse = client.getSlate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSlateRequest actualRequest = ((GetSlateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSlateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getSlate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSlateTest() throws Exception {
    Slate expectedResponse =
        Slate.newBuilder()
            .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
            .setUri("uri116076")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    Slate slate = Slate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Slate actualResponse = client.updateSlate(slate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSlateRequest actualRequest = ((UpdateSlateRequest) actualRequests.get(0));

    Assert.assertEquals(slate, actualRequest.getSlate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSlateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      Slate slate = Slate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSlate(slate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSlateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVideoStitcherService.addResponse(expectedResponse);

    SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");

    client.deleteSlate(name);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSlateRequest actualRequest = ((DeleteSlateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSlateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
      client.deleteSlate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSlateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSlate(name);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSlateRequest actualRequest = ((DeleteSlateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSlateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSlate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLiveSessionTest() throws Exception {
    LiveSession expectedResponse =
        LiveSession.newBuilder()
            .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setDefaultAdTagId("defaultAdTagId841142897")
            .putAllAdTagMap(new HashMap<String, AdTag>())
            .putAllAdTagMacros(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setDefaultSlateId("defaultSlateId-122056941")
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setStreamId("streamId1790933179")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
    LiveSession liveSession = LiveSession.newBuilder().build();

    LiveSession actualResponse = client.createLiveSession(parent, liveSession);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLiveSessionRequest actualRequest = ((CreateLiveSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(liveSession, actualRequest.getLiveSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLiveSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
      LiveSession liveSession = LiveSession.newBuilder().build();
      client.createLiveSession(parent, liveSession);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLiveSessionTest2() throws Exception {
    LiveSession expectedResponse =
        LiveSession.newBuilder()
            .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setDefaultAdTagId("defaultAdTagId841142897")
            .putAllAdTagMap(new HashMap<String, AdTag>())
            .putAllAdTagMacros(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setDefaultSlateId("defaultSlateId-122056941")
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setStreamId("streamId1790933179")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LiveSession liveSession = LiveSession.newBuilder().build();

    LiveSession actualResponse = client.createLiveSession(parent, liveSession);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLiveSessionRequest actualRequest = ((CreateLiveSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(liveSession, actualRequest.getLiveSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLiveSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String parent = "parent-995424086";
      LiveSession liveSession = LiveSession.newBuilder().build();
      client.createLiveSession(parent, liveSession);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLiveSessionTest() throws Exception {
    LiveSession expectedResponse =
        LiveSession.newBuilder()
            .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setDefaultAdTagId("defaultAdTagId841142897")
            .putAllAdTagMap(new HashMap<String, AdTag>())
            .putAllAdTagMacros(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setDefaultSlateId("defaultSlateId-122056941")
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setStreamId("streamId1790933179")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    LiveSessionName name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");

    LiveSession actualResponse = client.getLiveSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLiveSessionRequest actualRequest = ((GetLiveSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLiveSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      LiveSessionName name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
      client.getLiveSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLiveSessionTest2() throws Exception {
    LiveSession expectedResponse =
        LiveSession.newBuilder()
            .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
            .setPlayUri("playUri-493582952")
            .setSourceUri("sourceUri-1698419887")
            .setDefaultAdTagId("defaultAdTagId841142897")
            .putAllAdTagMap(new HashMap<String, AdTag>())
            .putAllAdTagMacros(new HashMap<String, String>())
            .setClientAdTracking(true)
            .setDefaultSlateId("defaultSlateId-122056941")
            .setManifestOptions(ManifestOptions.newBuilder().build())
            .setStreamId("streamId1790933179")
            .build();
    mockVideoStitcherService.addResponse(expectedResponse);

    String name = "name3373707";

    LiveSession actualResponse = client.getLiveSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoStitcherService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLiveSessionRequest actualRequest = ((GetLiveSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLiveSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoStitcherService.addException(exception);

    try {
      String name = "name3373707";
      client.getLiveSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
