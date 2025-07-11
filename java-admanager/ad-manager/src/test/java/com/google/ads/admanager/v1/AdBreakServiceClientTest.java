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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.AdBreakServiceClient.ListAdBreaksPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonAdBreakServiceStub;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class AdBreakServiceClientTest {
  private static MockHttpService mockService;
  private static AdBreakServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAdBreakServiceStub.getMethodDescriptors(),
            AdBreakServiceSettings.getDefaultEndpoint());
    AdBreakServiceSettings settings =
        AdBreakServiceSettings.newBuilder()
            .setTransportChannelProvider(
                AdBreakServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdBreakServiceClient.create(settings);
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
  public void getAdBreakTest() throws Exception {
    AdBreak expectedResponse =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    mockService.addResponse(expectedResponse);

    AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");

    AdBreak actualResponse = client.getAdBreak(name);
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
  public void getAdBreakExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
      client.getAdBreak(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdBreakTest2() throws Exception {
    AdBreak expectedResponse =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "networks/network-5271/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-5271/adBreaks/adBreak-5271";

    AdBreak actualResponse = client.getAdBreak(name);
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
  public void getAdBreakExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "networks/network-5271/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-5271/adBreaks/adBreak-5271";
      client.getAdBreak(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdBreaksTest() throws Exception {
    AdBreak responsesElement = AdBreak.newBuilder().build();
    ListAdBreaksResponse expectedResponse =
        ListAdBreaksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdBreaks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");

    ListAdBreaksPagedResponse pagedListResponse = client.listAdBreaks(parent);

    List<AdBreak> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdBreaksList().get(0), resources.get(0));

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
  public void listAdBreaksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");
      client.listAdBreaks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdBreaksTest2() throws Exception {
    AdBreak responsesElement = AdBreak.newBuilder().build();
    ListAdBreaksResponse expectedResponse =
        ListAdBreaksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdBreaks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "networks/network-1947/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-1947";

    ListAdBreaksPagedResponse pagedListResponse = client.listAdBreaks(parent);

    List<AdBreak> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdBreaksList().get(0), resources.get(0));

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
  public void listAdBreaksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "networks/network-1947/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-1947";
      client.listAdBreaks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdBreakTest() throws Exception {
    AdBreak expectedResponse =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    mockService.addResponse(expectedResponse);

    LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");
    AdBreak adBreak = AdBreak.newBuilder().build();

    AdBreak actualResponse = client.createAdBreak(parent, adBreak);
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
  public void createAdBreakExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");
      AdBreak adBreak = AdBreak.newBuilder().build();
      client.createAdBreak(parent, adBreak);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdBreakTest2() throws Exception {
    AdBreak expectedResponse =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "networks/network-1947/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-1947";
    AdBreak adBreak = AdBreak.newBuilder().build();

    AdBreak actualResponse = client.createAdBreak(parent, adBreak);
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
  public void createAdBreakExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "networks/network-1947/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-1947";
      AdBreak adBreak = AdBreak.newBuilder().build();
      client.createAdBreak(parent, adBreak);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAdBreakTest() throws Exception {
    AdBreak expectedResponse =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    mockService.addResponse(expectedResponse);

    AdBreak adBreak =
        AdBreak.newBuilder()
            .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
            .setAdBreakId("adBreakId763645143")
            .setAssetKey("assetKey-373222065")
            .setCustomAssetKey("customAssetKey1101792224")
            .setExpectedStartTime(Timestamp.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setBreakSequence(-1853489407)
            .setPodTemplateName("podTemplateName972272906")
            .setCustomParams("customParams284317783")
            .setScte35CueOut("scte35CueOut1476410590")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AdBreak actualResponse = client.updateAdBreak(adBreak, updateMask);
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
  public void updateAdBreakExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdBreak adBreak =
          AdBreak.newBuilder()
              .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
              .setAdBreakId("adBreakId763645143")
              .setAssetKey("assetKey-373222065")
              .setCustomAssetKey("customAssetKey1101792224")
              .setExpectedStartTime(Timestamp.newBuilder().build())
              .setDuration(Duration.newBuilder().build())
              .setBreakSequence(-1853489407)
              .setPodTemplateName("podTemplateName972272906")
              .setCustomParams("customParams284317783")
              .setScte35CueOut("scte35CueOut1476410590")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAdBreak(adBreak, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdBreakTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");

    client.deleteAdBreak(name);

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
  public void deleteAdBreakExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
      client.deleteAdBreak(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdBreakTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "networks/network-5271/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-5271/adBreaks/adBreak-5271";

    client.deleteAdBreak(name);

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
  public void deleteAdBreakExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "networks/network-5271/liveStreamEventsByAssetKey/liveStreamEventsByAssetKe-5271/adBreaks/adBreak-5271";
      client.deleteAdBreak(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
