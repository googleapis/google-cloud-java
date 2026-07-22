/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.LiveStreamServiceClient.ListLiveStreamsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonLiveStreamServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LiveStreamServiceClientTest {
  private static MockHttpService mockService;
  private static LiveStreamServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLiveStreamServiceStub.getMethodDescriptors(),
            LiveStreamServiceSettings.getDefaultEndpoint());
    LiveStreamServiceSettings settings =
        LiveStreamServiceSettings.newBuilder()
            .setTransportChannelProvider(
                LiveStreamServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LiveStreamServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void getLiveStreamTest() throws Exception {
    LiveStream expectedResponse =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LiveStreamName name = LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]");

    LiveStream actualResponse = client.getLiveStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLiveStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LiveStreamName name = LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]");
      client.getLiveStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLiveStreamTest2() throws Exception {
    LiveStream expectedResponse =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-5426/liveStreams/liveStream-5426";

    LiveStream actualResponse = client.getLiveStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLiveStreamExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-5426/liveStreams/liveStream-5426";
      client.getLiveStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLiveStreamsTest() throws Exception {
    LiveStream responsesElement = LiveStream.newBuilder().build();
    ListLiveStreamsResponse expectedResponse =
        ListLiveStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLiveStreams(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListLiveStreamsPagedResponse pagedListResponse = client.listLiveStreams(parent);

    List<LiveStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLiveStreamsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listLiveStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLiveStreamsTest2() throws Exception {
    LiveStream responsesElement = LiveStream.newBuilder().build();
    ListLiveStreamsResponse expectedResponse =
        ListLiveStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLiveStreams(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListLiveStreamsPagedResponse pagedListResponse = client.listLiveStreams(parent);

    List<LiveStream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLiveStreamsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listLiveStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLiveStreamTest() throws Exception {
    LiveStream expectedResponse =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    LiveStream liveStream = LiveStream.newBuilder().build();

    LiveStream actualResponse = client.createLiveStream(parent, liveStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createLiveStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      LiveStream liveStream = LiveStream.newBuilder().build();
      client.createLiveStream(parent, liveStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLiveStreamTest2() throws Exception {
    LiveStream expectedResponse =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    LiveStream liveStream = LiveStream.newBuilder().build();

    LiveStream actualResponse = client.createLiveStream(parent, liveStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createLiveStreamExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      LiveStream liveStream = LiveStream.newBuilder().build();
      client.createLiveStream(parent, liveStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateLiveStreamsTest() throws Exception {
    BatchCreateLiveStreamsResponse expectedResponse =
        BatchCreateLiveStreamsResponse.newBuilder()
            .addAllLiveStreams(new ArrayList<LiveStream>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateLiveStreamRequest> requests = new ArrayList<>();

    BatchCreateLiveStreamsResponse actualResponse = client.batchCreateLiveStreams(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateLiveStreamRequest> requests = new ArrayList<>();
      client.batchCreateLiveStreams(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateLiveStreamsTest2() throws Exception {
    BatchCreateLiveStreamsResponse expectedResponse =
        BatchCreateLiveStreamsResponse.newBuilder()
            .addAllLiveStreams(new ArrayList<LiveStream>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateLiveStreamRequest> requests = new ArrayList<>();

    BatchCreateLiveStreamsResponse actualResponse = client.batchCreateLiveStreams(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateLiveStreamRequest> requests = new ArrayList<>();
      client.batchCreateLiveStreams(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLiveStreamTest() throws Exception {
    LiveStream expectedResponse =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LiveStream liveStream =
        LiveStream.newBuilder()
            .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setEndTimeUnlimited(true)
            .addAllContentUrls(new ArrayList<String>())
            .addAllAdTags(new ArrayList<String>())
            .setAssetKey("assetKey-373222065")
            .setEnableDaiAuthenticationKeys(true)
            .setAdHolidayDuration(Duration.newBuilder().build())
            .setEnableMaxFillerDuration(true)
            .setMaxFillerDuration(Duration.newBuilder().build())
            .setPodServingSegmentDuration(Duration.newBuilder().build())
            .setEnableDurationlessAdBreaks(true)
            .setDefaultAdBreakDuration(Duration.newBuilder().build())
            .addAllSourceContentConfigurations(new ArrayList<String>())
            .setAdMediaDeliveryConfig(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
            .setPrerollSettings(PrerollSettings.newBuilder().build())
            .setHlsSettings(HlsSettings.newBuilder().build())
            .setAllowlistedIpsEnabled(true)
            .setRelativePlaylistDeliveryEnabled(true)
            .setPrefetchEnabled(true)
            .setPrefetchSettings(PrefetchSettings.newBuilder().build())
            .setForcedCueInEnabled(true)
            .setShortSegmentDroppingEnabled(true)
            .setCustomAssetKey("customAssetKey1101792224")
            .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
            .setAdBreakMarkupTypesEnabled(true)
            .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
            .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
            .setAdPodTrimTolerance(Duration.newBuilder().build())
            .setEffectiveAssetKey("effectiveAssetKey1853688854")
            .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LiveStream actualResponse = client.updateLiveStream(liveStream, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateLiveStreamExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LiveStream liveStream =
          LiveStream.newBuilder()
              .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setEndTimeUnlimited(true)
              .addAllContentUrls(new ArrayList<String>())
              .addAllAdTags(new ArrayList<String>())
              .setAssetKey("assetKey-373222065")
              .setEnableDaiAuthenticationKeys(true)
              .setAdHolidayDuration(Duration.newBuilder().build())
              .setEnableMaxFillerDuration(true)
              .setMaxFillerDuration(Duration.newBuilder().build())
              .setPodServingSegmentDuration(Duration.newBuilder().build())
              .setEnableDurationlessAdBreaks(true)
              .setDefaultAdBreakDuration(Duration.newBuilder().build())
              .addAllSourceContentConfigurations(new ArrayList<String>())
              .setAdMediaDeliveryConfig(
                  CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
              .setPrerollSettings(PrerollSettings.newBuilder().build())
              .setHlsSettings(HlsSettings.newBuilder().build())
              .setAllowlistedIpsEnabled(true)
              .setRelativePlaylistDeliveryEnabled(true)
              .setPrefetchEnabled(true)
              .setPrefetchSettings(PrefetchSettings.newBuilder().build())
              .setForcedCueInEnabled(true)
              .setShortSegmentDroppingEnabled(true)
              .setCustomAssetKey("customAssetKey1101792224")
              .addAllAdBreakMarkups(new ArrayList<AdBreakMarkupTypeEnum.AdBreakMarkupType>())
              .setAdBreakMarkupTypesEnabled(true)
              .setLiveStreamConditioning(LiveStreamConditioning.newBuilder().build())
              .setEarlyBreakNotificationMultiBreakSchedulingEnabled(true)
              .setAdPodTrimTolerance(Duration.newBuilder().build())
              .setEffectiveAssetKey("effectiveAssetKey1853688854")
              .setAuxiliaryAdSettings(AuxiliaryAdSettings.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLiveStream(liveStream, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateLiveStreamsTest() throws Exception {
    BatchUpdateLiveStreamsResponse expectedResponse =
        BatchUpdateLiveStreamsResponse.newBuilder()
            .addAllLiveStreams(new ArrayList<LiveStream>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateLiveStreamRequest> requests = new ArrayList<>();

    BatchUpdateLiveStreamsResponse actualResponse = client.batchUpdateLiveStreams(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchUpdateLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateLiveStreamRequest> requests = new ArrayList<>();
      client.batchUpdateLiveStreams(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateLiveStreamsTest2() throws Exception {
    BatchUpdateLiveStreamsResponse expectedResponse =
        BatchUpdateLiveStreamsResponse.newBuilder()
            .addAllLiveStreams(new ArrayList<LiveStream>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateLiveStreamRequest> requests = new ArrayList<>();

    BatchUpdateLiveStreamsResponse actualResponse = client.batchUpdateLiveStreams(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchUpdateLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateLiveStreamRequest> requests = new ArrayList<>();
      client.batchUpdateLiveStreams(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateLiveStreamsTest() throws Exception {
    BatchActivateLiveStreamsResponse expectedResponse =
        BatchActivateLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateLiveStreamsResponse actualResponse =
        client.batchActivateLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchActivateLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateLiveStreamsTest2() throws Exception {
    BatchActivateLiveStreamsResponse expectedResponse =
        BatchActivateLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateLiveStreamsResponse actualResponse =
        client.batchActivateLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchActivateLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseLiveStreamsTest() throws Exception {
    BatchPauseLiveStreamsResponse expectedResponse =
        BatchPauseLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchPauseLiveStreamsResponse actualResponse = client.batchPauseLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchPauseLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchPauseLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseLiveStreamsTest2() throws Exception {
    BatchPauseLiveStreamsResponse expectedResponse =
        BatchPauseLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchPauseLiveStreamsResponse actualResponse = client.batchPauseLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchPauseLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchPauseLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveLiveStreamsTest() throws Exception {
    BatchArchiveLiveStreamsResponse expectedResponse =
        BatchArchiveLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchArchiveLiveStreamsResponse actualResponse = client.batchArchiveLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchArchiveLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchArchiveLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveLiveStreamsTest2() throws Exception {
    BatchArchiveLiveStreamsResponse expectedResponse =
        BatchArchiveLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchArchiveLiveStreamsResponse actualResponse = client.batchArchiveLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchArchiveLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchArchiveLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseAdsLiveStreamsTest() throws Exception {
    BatchPauseAdsLiveStreamsResponse expectedResponse =
        BatchPauseAdsLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchPauseAdsLiveStreamsResponse actualResponse =
        client.batchPauseAdsLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchPauseAdsLiveStreamsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchPauseAdsLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseAdsLiveStreamsTest2() throws Exception {
    BatchPauseAdsLiveStreamsResponse expectedResponse =
        BatchPauseAdsLiveStreamsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchPauseAdsLiveStreamsResponse actualResponse =
        client.batchPauseAdsLiveStreams(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchPauseAdsLiveStreamsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchPauseAdsLiveStreams(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRefreshMasterPlaylistsTest() throws Exception {
    BatchRefreshMasterPlaylistsResponse expectedResponse =
        BatchRefreshMasterPlaylistsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRefreshMasterPlaylistsResponse actualResponse =
        client.batchRefreshMasterPlaylists(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRefreshMasterPlaylistsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRefreshMasterPlaylists(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRefreshMasterPlaylistsTest2() throws Exception {
    BatchRefreshMasterPlaylistsResponse expectedResponse =
        BatchRefreshMasterPlaylistsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRefreshMasterPlaylistsResponse actualResponse =
        client.batchRefreshMasterPlaylists(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRefreshMasterPlaylistsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRefreshMasterPlaylists(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
